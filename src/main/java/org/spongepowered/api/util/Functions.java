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

import com.google.common.base.Preconditions;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import javax.annotation.Nullable;

/**
 * Helper class with some utility methods pertaining {@link Function}s.
 */
public final class Functions {

    /**
     * Creates a {@link Function} that will always return the given constant.
     *
     * @param value The value to return always
     * @return The newly created function
     */
    public static <T, R> Function<T, R> constant(R value) {
        checkNotNull(value, "value");
        return constantNullable(value);
    }

    /**
     * Creates a {@link Function} that will always return null.
     *
     * @return The newly created function
     */
    public static <T, R> Function<T, R> constantNull() {
        return constantNullable(null);
    }

    /**
     * Creates a {@link Function} that will always return the given nullable
     * constant.
     *
     * @param value The nullable value to return always
     * @return The newly created function
     */
    public static <T, R> Function<T, R> constantNullable(final @Nullable R value) {
        return input -> value;
    }

    /**
     * Creates a {@link Function} that will always return the result of the
     * given {@link Supplier}.
     *
     * @param supplier The supplier to get the result from
     * @return The newly created function
     */
    public static <T, R> Function<T, R> supplied(final Supplier<? extends R> supplier) {
        checkNotNull(supplier, "supplier");
        return input -> supplier.get();
    }

    /**
     * Creates a {@link Function} that will always throw an exception from the
     * given {@link Supplier}.
     *
     * @param exceptionSupplier The supplier for the exception to throw
     * @return The newly created function
     */
    public static <T, R> Function<T, R> exceptionSupplier(Supplier<? extends RuntimeException> exceptionSupplier) {
        checkNotNull(exceptionSupplier, "exceptionSupplier");
        return input -> {
            throw checkNotNull(exceptionSupplier.get(), "exception from " + exceptionSupplier);
        };
    }

    /**
     * Creates a {@link Function} that will always throw an exception calculated
     * by the given {@link Function}.
     *
     * @param exceptionFunction The function to calculate the exception to throw
     * @param messageFunction The function to calculate the exception message
     * @return The newly created function
     */
    public static <T, R> Function<T, R> exceptionFunction(Function<String, ? extends RuntimeException> exceptionFunction,
            Function<T, String> messageFunction) {
        checkNotNull(exceptionFunction, "exceptionFunction");
        checkNotNull(messageFunction, "messageFunction");
        return exceptionFunction(exceptionFunction.compose(messageFunction));
    }

    /**
     * Creates a {@link Function} that will always throw an exception calculated
     * by the given {@link Function}.
     *
     * @param exceptionFunction The function to calculate the exception to throw
     * @return The newly created function
     */
    public static <T, R> Function<T, R> exceptionFunction(Function<T, ? extends RuntimeException> exceptionFunction) {
        checkNotNull(exceptionFunction, "exceptionFunction");
        return input -> {
            throw checkNotNull(exceptionFunction.apply(input), "exception from " + exceptionFunction);
        };
    }

    /**
     * Creates a {@link Function} that will wrap the results of the given
     * function in an {@link Optional}.
     *
     * @param function The function to wrap
     * @return The newly created function
     */
    public static <T, R> Function<T, Optional<R>> optional(Function<T, R> function) {
        checkNotNull(function, "function");
        return function.andThen(Optional::ofNullable);
    }

    /**
     * Creates a {@link Function} that will unwrap the {@link Optional} results
     * of the given function.
     *
     * @param function The function to unwrap
     * @return The newly created function
     * @see Optional#get()
     */
    public static <T, R> Function<T, R> present(Function<T, Optional<? extends R>> function) {
        checkNotNull(function, "function");
        return function.andThen(Optional::get);
    }

    /**
     * Creates a {@link Function} that will wrap the results of the given
     * function in an {@link Optional} unless it is already an {@link Optional}.
     *
     * @param function The function to wrap
     * @return The newly created function
     */
    public static <T> Function<T, Optional<?>> optionalWrapper(Function<T, ?> function) {
        checkNotNull(function, "function");
        return input -> {
            final Object result = function.apply(input);
            if (result instanceof Optional) {
                return (Optional<?>) result;
            } else {
                return Optional.ofNullable(result);
            }
        };
    }

    /**
     * Creates a {@link Function} that will check the input for being non-Null.
     *
     * @param message The message to show in case the input is null
     * @return The newly created function
     * @see Preconditions#checkNotNull(Object, Object)
     */
    public static <T> Function<T, T> nonNullIdentity(String message) {
        checkNotNull(message, "message");
        return input -> checkNotNull(input, message);
    }

    /**
     * Creates a {@link Function} that will check the results of the given
     * function for being non-Null.
     *
     * @param function The function to check for null results
     * @param message The message to show in case the input is null
     * @return The newly created function
     * @see Preconditions#checkNotNull(Object, Object)
     */
    public static <T, U> Function<T, U> nonNullResult(Function<T, U> function, String message) {
        checkNotNull(function, "function");
        return function.andThen(nonNullIdentity(message));
    }

    /**
     * Creates a {@link Function} that first try to test the given input using
     * the given filter and then will either execute the match or dismatch
     * {@link Function} based on the results of the test.
     *
     * @param filter The filter to test the input with
     * @param match The function that should be executed in case the input does
     *        match the filter requirements
     * @param dismatch The function that should be executed in case the input
     *        does not match the filter requirements
     * @return The newly created function
     */
    public static <T, R> Function<T, R> conditional(Predicate<? super T> filter,
            Function<? super T, ? extends R> match, Function<? super T, ? extends R> dismatch) {
        checkNotNull(filter, "filter");
        checkNotNull(match, "match");
        checkNotNull(dismatch, "dismatch");
        return input -> filter.test(input) ? match.apply(input) : dismatch.apply(input);
    }

    /**
     * Creates a {@link Function} that first execute the main {@link Function}
     * and will then test its result using the given filter. If the result of
     * the function matches the filter then the result will be returned. If the
     * filter does not match then the alternative function will be used to get a
     * different result.
     *
     * @param main The function that should be used for the conversion
     * @param filter The filter to test the main function's result with
     * @param alternative The function that should be executed in case the
     *        result does not match the filter requirements
     * @return The newly created function
     */
    public static <T, R> Function<T, R> resultConditional(Function<? super T, ? extends R> main,
            Predicate<? super R> filter, Function<? super T, ? extends R> alternative) {
        return input -> {
            final R result = main.apply(input);
            if (filter.test(result)) {
                return result;
            } else {
                return alternative.apply(input);
            }
        };
    }

    /**
     * Creates a {@link Function} that first execute the main {@link Function}
     * and will then test its result for being non null. If the result of the
     * function is not null then it will be returned. If the result is null then
     * the alternative {@link Function} will be used to calculate the result.
     *
     * @param main The function that should be used for the conversion
     * @param alternative The function that should be executed in case the
     *        result of the main function was null
     * @return The newly created function
     */
    public static <T, R> Function<T, R> nonNullResultOrElse(Function<? super T, ? extends R> main, Function<? super T, ? extends R> alternative) {
        return resultConditional(main, Functional.notNull(), alternative);
    }

    /**
     * Creates a {@link Function} that first execute the main {@link Function}
     * and will then test its result for being {@link Optional#isPresent()
     * present}. If the result of the function is present then it will be
     * returned. If the result is absent/empty then the alternative
     * {@link Function} will be used to calculate the result.
     *
     * @param main The function that should be used for the conversion
     * @param alternative The function that should be executed in case the
     *        result of the main function was absent/empty
     * @return The newly created function
     */
    public static <T, R> Function<T, Optional<? extends R>> presentResultOrElse(Function<? super T, Optional<? extends R>> main,
            Function<? super T, Optional<? extends R>> alternative) {
        return resultConditional(main, Optional::isPresent, alternative);
    }

    private Functions() {
    }

}
