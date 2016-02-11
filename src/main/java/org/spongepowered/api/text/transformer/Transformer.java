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

package org.spongepowered.api.text.transformer;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.text.PlaceholderText;
import org.spongepowered.api.text.Text;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * The context aware transformer interface represents a function that tries to
 * convert the passed context data or select from them to dynamically calculate
 * or generate content suiting the given context best. {@link PlaceholderText}s
 * use this interface to resolve their replacements for
 * {@link Text#format(Text, Function)}.
 *
 * @param <T> The type returned by this transformer
 *
 * @see Text#format(Text, Function)
 * @see PlaceholderText
 * @see PlaceholderText#calculateReplacement(Function)
 */
public interface Transformer<T> {

    /**
     * Tries to transform the input context into appropriate content. Other
     * transformations may take place after this. Implementations should be
     * aware that sometimes their context data may not be available, in that
     * case this method should return {@link Optional#empty()}.
     *
     * @param context The context function that contains the context data
     * @return The non-null content for the given context or
     *         {@link Optional#empty()}
     *
     * @see PlaceholderText#calculateReplacement(Function)
     */
    Optional<T> transform(Function<String, ?> context);

    /**
     * Wraps this transformer in another one that will return a fallback value
     * in case this transformer returns {@link Optional#empty()}.
     *
     * @param fallback The fallback to use
     * @return A newly created transformer with the given fallback
     */
    default Transformer<T> orDefault(final T fallback) {
        checkNotNull(fallback, "fallback");
        final Optional<T> optFallback = Optional.of(fallback);
        return context -> {
            final Optional<T> result = transform(context);
            if (result.isPresent()) {
                return result;
            } else {
                return optFallback;
            }
        };
    }

    /**
     * Wraps this transformer in another one that will return a value from the
     * given {@link Supplier} in case this transformer returns
     * {@link Optional#empty()}.
     *
     * @param fallback The fallback supplier to use. The supplier is allowed to
     *        return null
     * @return A newly created transformer with the given fallback supplier
     */
    default Transformer<T> orSupplied(final Supplier<? extends T> fallback) {
        checkNotNull(fallback, "fallback");
        return context -> {
            final Optional<T> result = transform(context);
            if (result.isPresent()) {
                return result;
            } else {
                return Optional.ofNullable(fallback.get());
            }
        };
    }

    /**
     * Wraps this transformer in another one that will use the given
     * {@link Transformer} in case this transformer returns
     * {@link Optional#empty()}.
     *
     * @param transformer The fallback transformer to use. The transformer is
     *        allowed to return empty
     * @return A newly created transformer with the given fallback transformer
     */
    default Transformer<T> orElse(final Transformer<T> transformer) {
        checkNotNull(transformer, "transformer");
        return context -> {
            final Optional<T> result = transform(context);
            if (result.isPresent()) {
                return result;
            } else {
                return transformer.transform(context);
            }
        };
    }

    /**
     * Wraps this transformer in another one that will return the
     * {@link Text#of() empty text} in case this transformer returns
     * {@link Optional#empty()}. This will effectively remove the param from the
     * template in case there is no value for it.
     *
     * @return A newly created transformer with the empty text fallback
     */
    default Transformer<Text> orEmptyText() {
        return orText(Text.of());
    }

    /**
     * Wraps this transformer in another one that will return the given fallback
     * {@link Text} in case this transformer returns {@link Optional#empty()}.
     *
     * @param fallback The fallback text to use
     * @return A newly created transformer with the given fallback text
     */
    default Transformer<Text> orText(final Text fallback) {
        checkNotNull(fallback, "fallback");
        return context -> Optional.of(transform(context).map(Text::of).orElse(fallback));
    }

    /**
     * Wraps this transformer in another one that will transform the result
     * using the given function in case the value is present.
     *
     * @param function The transform function used to transform the present data
     * @param <R> The expected result type for the function
     * @return A newly created transformer with the given transformation
     *         function
     * @see Optional#map(Function)
     */
    default <R> Transformer<R> map(final Function<? super T, R> function) {
        checkNotNull(function, "function");
        return context -> transform(context).map(function);
    }

    /**
     * Wraps this transformer in another one that will transform the result
     * using the given function in case the value is present.
     *
     * @param function The transform function used to transform the present data
     * @param <R> The expected result type for the function
     * @return A newly created transformer with the given transformation
     *         function
     * @see Optional#flatMap(Function)
     */
    default <R> Transformer<R> flatMap(final Function<? super T, Optional<R>> function) {
        checkNotNull(function, "function");
        return context -> transform(context).flatMap(function);
    }

    /**
     * Wraps this transformer in another one that will join a new value to the
     * result of this one using the given function in case this one's is
     * present. The created transformer will return {@link Optional#empty()} in
     * case one of the two values are {@link Optional#empty()}.
     *
     * <p>This method is intended to be used to calculate a value based on two
     * or more context parameters. This could be the distance between two
     * players or a hostility check.</p>
     *
     * @param key The context parameter name to join
     * @param joinFunction The function used to join both results. The function
     *        is allowed to return null
     * @return A newly created transformer with the given join function
     * @see Transformers#key(String)
     * @see BiFunction
     * @see #join(Transformer, BiFunction)
     */
    default <U, R> Transformer<R> join(final String key, final BiFunction<T, U, R> joinFunction) {
        return join(Transformers.key(key), joinFunction);
    }

    /**
     * Wraps this transformer in another one that will join a new value to the
     * result of this one using the given function in case this one's is
     * present. The created transformer will return {@link Optional#empty()} in
     * case one of the two values are {@link Optional#empty()}.
     *
     * <p>This method is intended to be used to calculate a value based on two
     * or more context parameters. This could be the distance between two
     * players or a hostility check.</p>
     *
     * @param joined The transformer which results should be used for the join
     * @param joinFunction The function used to join both results. The function
     *        is allowed to return null
     * @return A newly created transformer with the given join function
     * @see BiFunction
     */
    default <U, R> Transformer<R> join(final Transformer<U> joined, final BiFunction<T, U, R> joinFunction) {
        checkNotNull(joined, "joined");
        checkNotNull(joinFunction, "function");
        return context -> {
            final Optional<T> value = transform(context);
            if (value.isPresent()) {
                final Optional<U> value2 = joined.transform(context);
                if (value2.isPresent()) {
                    return Optional.ofNullable(joinFunction.apply(value.get(), value2.get()));
                } else {
                    return Optional.empty();
                }
            } else {
                return Optional.empty();
            }
        };
    }

    /**
     * Wraps this transformer in another one that will join a new value to the
     * result of this one using the given function.
     *
     * <p>This method is intended to be used to calculate a value based on two
     * or more context parameters. This could be the distance between two
     * players or a hostility check.</p>
     *
     * @param key The context parameter name to join
     * @param joinFunction The function used to join both results. The given
     *        function must be prepared to deal with null arguments. The
     *        function is allowed to return null
     * @return A newly created transformer with the given join function
     * @see Transformers#key(String)
     * @see BiFunction
     * @see #joinNullable(Transformer, BiFunction)
     * @see #join(String, BiFunction)
     */
    default <U, R> Transformer<R> joinNullable(final String key, final BiFunction<T, U, R> joinFunction) {
        return joinNullable(Transformers.key(key), joinFunction);
    }

    /**
     * Wraps this transformer in another one that will join a new value to the
     * result of this one using the given function.
     *
     * <p>This method is intended to be used to calculate a value based on two
     * or more context parameters. This could be the distance between two
     * players or a hostility check.</p>
     *
     * @param joined The transformer which results should be used for the join
     * @param joinFunction The function used to join both results. The given
     *        function must be prepared to deal with null arguments. The
     *        function is allowed to return null
     * @return A newly created transformer with the given join function
     * @see BiFunction
     * @see #join(Transformer, BiFunction)
     */
    default <U, R> Transformer<R> joinNullable(final Transformer<U> joined, final BiFunction<T, U, R> joinFunction) {
        checkNotNull(joined, "joined");
        checkNotNull(joinFunction, "function");
        return context -> {
            final Optional<T> value = transform(context);
            final Optional<U> value2 = joined.transform(context);
            return Optional.ofNullable(joinFunction.apply(value.orElse(null), value2.orElse(null)));
        };
    }

    /**
     * Wraps this transformer in a placeholder to store it in a field or in a
     * {@link Text} instance. This method is a shortcut for
     * {@link Text#placeholder(Transformer)}.
     *
     * @return A newly created placeholder containing this transformer
     * @see Text#placeholder(Transformer)
     */
    default PlaceholderText asPlaceholder() {
        return Text.placeholder(this);
    }

}
