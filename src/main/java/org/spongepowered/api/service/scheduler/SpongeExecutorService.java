package org.spongepowered.api.service.scheduler;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Supplier;

import javax.annotation.Nullable;

/**
 * A delegating ExecutionService that schedules all its tasks on
 * Sponge's {@link SchedulerService}.
 * <p>
 *     This class can be used to allow any libraries that support the
 *     standard concurrency interface to schedule their asynchronous
 *     tasks through Sponge.
 * </p>
 * <p>
 *     This implementation cannot be shut down and does not distinguish
 *     between fixed-rate / fixed-delay repeating tasks.
 * </p>
 */
public class SpongeExecutorService extends AbstractExecutorService implements ScheduledExecutorService {

    private final Supplier<TaskBuilder> taskBuilderProvider;
    private final Object plugin;

    protected SpongeExecutorService(final Supplier<TaskBuilder> taskBuilderProvider, final Object plugin) {
        this.taskBuilderProvider = taskBuilderProvider;
        this.plugin = checkNotNull(plugin, "plugin");
    }

    @Override
    public void shutdown() {
        //NOOP
    }

    @Override
    public List<Runnable> shutdownNow() {
        return ImmutableList.of();
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void execute(Runnable command) {
        this.createTask(command).submit(this.plugin);
    }

    @Override
    public SpongeFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
        final FutureTask<?> runnable = new FutureTask<>(command, null);

        final Task task = this.createTask(runnable)
                .delay(delay, unit)
                .submit(this.plugin);

        return new SpongeFuture<>(runnable, task);
    }

    @Override
    public <V> SpongeFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
        final FutureTask<V> runnable = new FutureTask<>(callable);

        final Task task = this.createTask(runnable)
                .delay(delay, unit)
                .submit(this.plugin);

        return new SpongeFuture<>(runnable, task);
    }

    @Override
    public SpongeFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
        final RepeatableFutureTask<?> runnable = new RepeatableFutureTask<>(command);

        final Task task = this.createTask(runnable)
                .delay(initialDelay, unit)
                .interval(period, unit)
                .submit(this.plugin);

        // A repeatable task needs to be able to cancel itself
        runnable.setTask(task);

        return new SpongeFuture<>(runnable, task);
    }

    @Override
    public SpongeFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
        //Since we don't have full control over the execution, the contract needs to be a little broken
        return this.scheduleAtFixedRate(command, initialDelay, delay, unit);
    }

    private TaskBuilder createTask(final Runnable runnable) {
        return this.taskBuilderProvider.get().execute(runnable);
    }

    public static class SpongeFuture<V> implements RunnableScheduledFuture<V> {

        private final long scheduledAt = System.currentTimeMillis();
        private final FutureTask<V> runnable;
        private final Task task;

        protected SpongeFuture(FutureTask<V> runnable, Task task) {
            this.runnable = runnable;
            this.task = task;
        }

        /**
         * @return The {@link SchedulerService} task that is responsible for
         *         the execution of this future
         */
        public Task getTask() {
            return this.task;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(getCurrentDelay(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed other) {
            // Since getDelay may return different values for each call,
            // this check is required to correctly implement Comparable
            if (other == this) {
                return 0;
            }
            return Long.compare(this.getDelay(TimeUnit.MILLISECONDS), other.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public boolean cancel(boolean mayInterruptIfRunning) {
            this.task.cancel(); //Ensure Sponge is not going to try to run a cancelled task.
            return this.runnable.cancel(mayInterruptIfRunning);
        }

        @Override
        public boolean isCancelled() {
            return this.runnable.isCancelled();
        }

        @Override
        public boolean isDone() {
            return this.runnable.isDone();
        }

        @Override
        public V get() throws InterruptedException, ExecutionException {
            return this.runnable.get();
        }

        @Override
        public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            return this.runnable.get(timeout, unit);
        }

        @Override
        public boolean isPeriodic() {
            return this.task.getInterval() > 0;
        }

        @Override
        public void run() {
            this.runnable.run();
        }

        private long getCurrentDelay() {
            //TODO: this is a hack, probably needs to be partially moved to SpongeCommon if this needs to be accurate
            long originalDelay = (this.scheduledAt + this.task.getDelay()) - System.currentTimeMillis();
            if (this.isPeriodic() && originalDelay <= 0) {
                //Since its periodic, find the first positive delay and report
                long interval = this.task.getInterval();
                return originalDelay % interval + interval;
            } else {
                return originalDelay;
            }
        }
    }

    /**
     * An extension of the JREs FutureTask that can be repeatedly executed,
     * required for scheduling on an interval.
     */
    private static class RepeatableFutureTask<V> extends FutureTask<V> {

        @Nullable private Task owningTask = null;

        protected RepeatableFutureTask(Runnable runnable) {
            super(runnable, null);
        }

        protected void setTask(Task task) {
            this.owningTask = task;
        }

        @Override
        public void run() {
            super.runAndReset();

            // A repeating task that is done but hasn't been cancelled has
            // failed exceptionally. Following the contract of
            // ScheduledExecutorService, this means the task has to be stopped.
            if (super.isDone() && !super.isCancelled() && this.owningTask != null) {
                //TODO: should this be logged?
                this.owningTask.cancel();
            }
        }
    }
}
