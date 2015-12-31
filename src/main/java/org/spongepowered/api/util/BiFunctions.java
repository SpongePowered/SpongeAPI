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

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import javax.annotation.Nullable;

/**
 * Helper class with some utility methods pertaining {@link BiFunction}s.
 */
public final class BiFunctions {

    /**
     * Creates a {@link BiFunction} that will always return its first input.
     *
     * @return The newly created function
     */
    public static <T> BiFunction<T, ?, T> first() {
        return (first, second) -> first;
    }

    /**
     * Creates a {@link BiFunction} that will always return its second.
     *
     * @return The newly created function
     */
    public static <T> BiFunction<?, T, T> second() {
        return (first, second) -> second;
    }

    /**
     * Creates a {@link BiFunction} that will always return the given constant.
     *
     * @param value The value to return always
     * @return The newly created function
     */
    public static <T, U, R> BiFunction<T, U, R> constant(R value) {
        checkNotNull(value, "value");
        return constantNullable(value);
    }

    /**
     * Creates a {@link BiFunction} that will always return null.
     *
     * @return The newly created function
     */
    public static <T, U, R> BiFunction<T, U, R> constantNull() {
        return constantNullable(null);
    }

    /**
     * Creates a {@link BiFunction} that will always return the given nullable
     * constant.
     *
     * @param value The nullable value to return always
     * @return The newly created function
     */
    public static <T, U, R> BiFunction<T, U, R> constantNullable(final @Nullable R value) {
        return (first, second) -> value;
    }

    /**
     * Creates a {@link BiFunction} that will always return the result of the
     * given {@link Supplier}.
     *
     * @param supplier The supplier to get the result from
     * @return The newly created function
     */
    public static <T, U, R> BiFunction<T, U, R> supplied(final Supplier<? extends R> supplier) {
        checkNotNull(supplier, "supplier");
        return (first, second) -> supplier.get();
    }

    /**
     * Creates a {@link BiFunction} that will always throw an exception from the
     * given {@link Supplier}.
     *
     * @param exceptionSupplier The supplier for the exception to throw
     * @return The newly created function
     */
    public static <T, U, R> BiFunction<T, U, R> exceptionSupplier(Supplier<? extends RuntimeException> exceptionSupplier) {
        checkNotNull(exceptionSupplier, "exceptionSupplier");
        return (first, second) -> {
            throw checkNotNull(exceptionSupplier.get(), "exception from " + exceptionSupplier);
        };
    }

    /**
     * Creates a {@link BiFunction} that will always throw an exception
     * calculated by the given {@link BiFunction}.
     *
     * @param exceptionFunction The function to calculate the exception to throw
     * @param messageBiFunction The function to calculate the exception message
     * @return The newly created function
     */
    public static <T, U, R> BiFunction<T, U, R> exceptionBiFunction(Function<String, ? extends RuntimeException> exceptionFunction,
            BiFunction<T, U, String> messageBiFunction) {
        checkNotNull(exceptionFunction, "exceptionBiFunction");
        checkNotNull(messageBiFunction, "messageBiFunction");
        return exceptionBiFunction(messageBiFunction.andThen(exceptionFunction));
    }

    /**
     * Creates a {@link BiFunction} that will always throw an exception
     * calculated by the given {@link BiFunction}.
     *
     * @param exceptionBiFunction The function to calculate the exception to
     *        throw
     * @return The newly created function
     */
    public static <T, U, R> BiFunction<T, U, R> exceptionBiFunction(BiFunction<T, U, ? extends RuntimeException> exceptionBiFunction) {
        checkNotNull(exceptionBiFunction, "exceptionBiFunction");
        return (first, second) -> {
            throw checkNotNull(exceptionBiFunction.apply(first, second), "exception from " + exceptionBiFunction);
        };
    }

    /**
     * Creates a {@link BiFunction} that will wrap the results of the given
     * function in an {@link Optional}.
     *
     * @param function The function to wrap
     * @return The newly created function
     */
    public static <T, U, R> BiFunction<T, U, Optional<R>> optional(BiFunction<T, U, R> function) {
        checkNotNull(function, "function");
        return function.andThen(Optional::ofNullable);
    }

    /**
     * Creates a {@link BiFunction} that will unwrap the {@link Optional}
     * results of the given function.
     *
     * @param function The function to unwrap
     * @return The newly created function
     * @see Optional#get()
     */
    public static <T, U, R> BiFunction<T, U, R> present(BiFunction<T, U, Optional<? extends R>> function) {
        checkNotNull(function, "function");
        return function.andThen(Optional::get);
    }

    /**
     * Creates a {@link BiFunction} that will wrap the results of the given
     * function in an {@link Optional} unless it is already an {@link Optional}.
     *
     * @param function The function to wrap
     * @return The newly created function
     */
    public static <T, U> BiFunction<T, U, Optional<?>> optionalWrapper(BiFunction<T, U, ?> function) {
        checkNotNull(function, "function");
        return (first, second) -> {
            final Object result = function.apply(first, second);
            if (result instanceof Optional) {
                return (Optional<?>) result;
            } else {
                return Optional.ofNullable(result);
            }
        };
    }

    /**
     * Creates a {@link BiFunction} that first try to test the given input using
     * the given filter and then will either execute the match or dismatch
     * {@link BiFunction} based on the results of the test.
     *
     * @param filter The filter to test the input with
     * @param match The function that should be executed in case the input does
     *        match the filter requirements
     * @param dismatch The function that should be executed in case the input
     *        does not match the filter requirements
     * @return The newly created function
     */
    public static <T, U, R> BiFunction<T, U, R> conditional(BiPredicate<? super T, ? super U> filter,
            BiFunction<? super T, ? super U, ? extends R> match, BiFunction<? super T, ? super U, ? extends R> dismatch) {
        checkNotNull(filter, "filter");
        checkNotNull(match, "match");
        checkNotNull(dismatch, "dismatch");
        return (first, second) -> filter.test(first, second) ? match.apply(first, second) : dismatch.apply(first, second);
    }

    /**
     * Creates a {@link BiFunction} that first execute the main
     * {@link BiFunction} and will then test its result using the given filter.
     * If the result of the function matches the filter then the result will be
     * returned. If the filter does not match then the alternative function will
     * be used to get a different result.
     *
     * @param main The function that should be used for the conversion
     * @param filter The filter to test the main function's result with
     * @param alternative The function that should be executed in case the
     *        result does not match the filter requirements
     * @return The newly created function
     */
    public static <T, U, R> BiFunction<T, U, R> resultConditional(BiFunction<? super T, ? super U, ? extends R> main,
            Predicate<? super R> filter, BiFunction<? super T, ? super U, ? extends R> alternative) {
        return (first, second) -> {
            final R result = main.apply(first, second);
            if (filter.test(result)) {
                return result;
            } else {
                return alternative.apply(first, second);
            }
        };
    }

    /**
     * Creates a {@link BiFunction} that first execute the main
     * {@link BiFunction} and will then test its result for being non null. If
     * the result of the function is not null then it will be returned. If the
     * result is null then the alternative {@link BiFunction} will be used to
     * calculate the result.
     *
     * @param main The function that should be used for the conversion
     * @param alternative The function that should be executed in case the
     *        result of the main function was null
     * @return The newly created function
     */
    public static <T, U, R> BiFunction<T, U, R> nonNullResultOrElse(BiFunction<? super T, ? super U, ? extends R> main,
            BiFunction<? super T, ? super U, ? extends R> alternative) {
        return resultConditional(main, Functional.notNull(), alternative);
    }

    /**
     * Creates a {@link BiFunction} that first execute the main
     * {@link BiFunction} and will then test its result for being
     * {@link Optional#isPresent() present}. If the result of the function is
     * present then it will be returned. If the result is absent/empty then the
     * alternative {@link BiFunction} will be used to calculate the result.
     *
     * @param main The function that should be used for the conversion
     * @param alternative The function that should be executed in case the
     *        result of the main function was absent/empty
     * @return The newly created function
     */
    public static <T, U, R> BiFunction<T, U, Optional<? extends R>> presentResultOrElse(BiFunction<? super T, ? super U, Optional<? extends R>> main,
            BiFunction<? super T, ? super U, Optional<? extends R>> alternative) {
        return resultConditional(main, Optional::isPresent, alternative);
    }

    private BiFunctions() {
    }

}
