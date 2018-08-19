package org.spongepowered.api.scheduler;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.fluid.FluidType;

import java.util.Collection;

/**
 * A tick based priority scheduled list targeting speicifc types of
 * objects that need to be ticked. In common cases, there's either
 * a {@link BlockType} or {@link FluidType} being ticked.
 * @param <T>
 */
public interface ScheduledTaskList<T> {

    default ScheduledTaskEntry<T> scheduleUpdate(Vector3i pos, T itemIn, int scheduledTime) {
        return scheduleUpdate(pos.getX(), pos.getY(), pos.getZ(), itemIn, scheduledTime, TaskPriorities.NORMAL);
    }

    default ScheduledTaskEntry<T> scheduleUpdate(int x, int y, int z, T itemIn, int scheduledTime) {
        return scheduleUpdate(x, y, z, itemIn, scheduledTime, TaskPriorities.NORMAL);
    }

    default ScheduledTaskEntry<T> scheduleUpdate(Vector3i pos, T itemIn, int scheduledTime, TaskPriority priority) {
        return scheduleUpdate(pos.getX(), pos.getY(), pos.getZ(), itemIn, scheduledTime, priority);
    }

    ScheduledTaskEntry<T> scheduleUpdate(int x, int y, int z, T itemIn, int scheduledTime, TaskPriority priority);

    default boolean isUpdateScheduled(Vector3i pos, T itemIn) {
        return isUpdateScheduled(pos.getX(), pos.getY(), pos.getZ(), itemIn);
    }

    boolean isUpdateScheduled(int x, int y, int z, T itemIn);

    Collection<ScheduledTaskEntry<T>> getScheduledUpdates(int x, int y, int z);
    void removeUpdate(Vector3i blockPosition, ScheduledTaskEntry<T> update);

    default Collection<ScheduledTaskEntry<T>> getScheduledUpdates(Vector3i pos) {
        return getScheduledUpdates(pos.getX(), pos.getY(), pos.getZ());
    }
}
