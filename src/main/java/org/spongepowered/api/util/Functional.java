/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.util;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableSet;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Utility methods to help with function work.
 */
public class Functional {

    private Functional() {
    }

    /**
     * Perform an AND using an array of predicates.
     *
     * @param predicates The predicates to AND
     * @param <E> The type to accept
     * @return The combined predicate
     */
    @SafeVarargs
    @SuppressWarnings("varargs")
    public static <E> Predicate<E> predicateAnd(Predicate<E>... predicates) {
        return predicateAnd(Arrays.asList(predicates));
    }

    /**
     * Perform an AND using an iterable of predicates.
     *
     * @param predicates The predicates to and
     * @param <E> The type to accept
     * @return The combined predicate
     */
    public static <E> Predicate<E> predicateAnd(Iterable<Predicate<E>> predicates) {
        return e -> {
            for (Predicate<E> pred : predicates) {
                if (!pred.test(e)) {
                    return false;
                }
            }
            return true;
        };
    }

    public static <E> Predicate<E> predicateIn(Collection<E> collection) {
        return collection::contains;
    }

    /**
     * Creates a new predicate that will match if its input is not null.
     *
     * @return The newly created predicate
     */
    public static <E> Predicate<E> notNull() {
        return input -> input != null;
    }

    /**
     * Creates a {@link Consumer} that can be used to join elements of a stream
     * and insert the given separator between each element.
     *
     * @param main The consumer used to process each element
     * @param separator The separator used with the main consumer
     * @return The newly created consumer ready to join a stream once
     */
    public static <T> Consumer<T> joiner(final Consumer<T> main, final T separator) {
        final Runnable runnable = () -> main.accept(separator);
        return joiner(main, runnable);
    }

    /**
     * Creates a {@link Consumer} that can be used to join elements of a stream
     * and insert the given separator between each element.
     *
     * @param main The consumer used to process each element
     * @param separatorAdder The runnable to execute to add the separator
     * @return The newly created consumer ready to join a stream once
     */
    public static <T> Consumer<T> joiner(Consumer<T> main, Runnable separatorAdder) {
        return consumeOnceAndElse(main, Functional.<T>asConsumer(separatorAdder).andThen(main));
    }

    /**
     * Wraps this {@link Runnable} in a {@link Consumer}.
     *
     * @param runnable The runnable to wrap
     * @return The newly created consumer containing the given runnable
     */
    public static <T> Consumer<T> asConsumer(Runnable runnable) {
        return input -> runnable.run();
    }

    public static <E> com.google.common.base.Predicate<E> java8ToGuava(Predicate<E> predicate) {
        return predicate::test;
    }

    /**
     * Get the value of an {@link Optional} as either a zero- or one-element
     * immutable set.
     *
     * @param value The value to get as a set
     * @param <T> The type
     * @return The immutable set containing any value the optional has
     */
    public static <T> Set<T> optionalAsSet(Optional<T> value) {
        return value.isPresent() ? ImmutableSet.of(value.get()) : ImmutableSet.of();
    }

    /**
     * Execute a callable on <strong>the current thread</strong>, capturing the
     * result or any exceptions that may be thrown into a
     * {@link CompletableFuture}.
     *
     * @param call The callable to execute
     * @param <T> The type of value returned
     * @return The future holding the result
     */
    public static <T> CompletableFuture<T> failableFuture(Callable<T> call) {
        CompletableFuture<T> ret = new CompletableFuture<>();
        try {
            ret.complete(call.call());
        } catch (Exception e) {
            ret.completeExceptionally(e);
        }
        return ret;
    }

    /**
     * Execute a callable on the provided executor, capturing the result or any
     * exceptions that may be thrown into a {@link CompletableFuture}.
     *
     * @param call The callable to execute
     * @param exec The executor to execute this task on
     * @param <T> The type of value returned
     * @return The future holding the result
     */
    public static <T> CompletableFuture<T> asyncFailableFuture(Callable<T> call, Executor exec) {
        CompletableFuture<T> ret = new CompletableFuture<>();
        exec.execute(() -> {
            try {
                ret.complete(call.call());
            } catch (Exception e) {
                ret.completeExceptionally(e);
            }
        });
        return ret;
    }

    /**
     * Creates a new {@link Consumer} that will execute the first
     * {@link Consumer} once and after that it will use a different
     * {@link Consumer}.
     *
     * @param first The consumer to use once
     * @param later The consumer to use after the first time
     * @return The newly created consumer
     * @see #supplyOnceAndElse(Object, Object)
     */
    public static <T> Consumer<T> consumeOnceAndElse(Consumer<T> first, Consumer<T> later) {
        final Supplier<Consumer<T>> once = supplyOnceAndElse(checkNotNull(first, "first"), checkNotNull(later, "later"));
        return input -> once.get().accept(input);
    }

    /**
     * Creates a new {@link Supplier} that will return a given result only once
     * and after that it will return a different value all the time.
     *
     * @param first The value to return once
     * @param later The value to return after the first time
     * @return The newly created supplier
     */
    public static <T> Supplier<T> supplyOnceAndElse(T first, T later) {
        return new Once<>(first, later);
    }

    /**
     * {@link Supplier} that will return a given input once and after that
     * returns a different result.
     *
     * @param <T> The type of results supplied by this supplier
     */
    public static class Once<T> implements Supplier<T> {

        private final T first;
        private final T later;
        private boolean running = false;

        Once(final T first, final T later) {
            this.first = first;
            this.later = later;
        }

        @Override
        public T get() {
            if (this.running) {
                return this.later;
            } else {
                this.running = true;
                return this.first;
            }
        }

    }

}
