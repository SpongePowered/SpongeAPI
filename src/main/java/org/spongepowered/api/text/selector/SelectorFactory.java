/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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
package org.spongepowered.api.text.selector;

/**
 * Represents the required implementation for the static methods in
 * {@link Selectors}, {@link Arguments} and {@link ArgumentTypes}.
 */
interface SelectorFactory {

    /**
     * Creates a {@link SelectorBuilder} with no type set and no arguments.
     *
     * @return A new selector builder with no data
     */
    SelectorBuilder createEmptyBuilder();

    /**
     * Parses a {@link Selector} from the given selector string.
     *
     * @param selector The raw selector string
     * @return A new selector containing the given selector data
     */
    Selector parseRawSelector(String selector);

    /**
     * Creates a score maximum {@linkplain ArgumentType} for the given objective
     * name.
     * 
     * @param name The objective name to use
     *
     * @return An ArgumentType for the objective name
     */
    ArgumentType<Integer, Argument<Integer>> createScoreMaxArgument(String name);

    /**
     * Creates a score minimum {@linkplain ArgumentType} for the given objective
     * name.
     * 
     * @param name The objective name to use
     *
     * @return An ArgumentType for the objective name
     */
    ArgumentType<Integer, Argument<Integer>> createScoreMinArgument(String name);

    /**
     * Creates an {@link Argument}.
     * 
     * @param type The type for the Argument
     * @param value The value for the Argument
     *
     * @return A new argument with {@code type.getKey()} mapped to {@code value}
     */
    <T, A extends Argument<T>> A createArgument(ArgumentType<T, A> type, T value);

    /**
     * Creates a custom {@link Argument}. Using a key defined by an ArgumentType
     * will not offer the features of the ArgumentType, such as inversion.
     * 
     * @param key The key for the Argument
     * @param value The value for the Argument
     *
     * @return A new argument with {@code key} mapped to {@code value}
     */
    <T> Argument<T> createCustomArgument(String key, T value);

    /**
     * Parses an {@link Argument} from the given argument string. Any
     * ArgumentTypes defined in ArgumentTypes are used to generate the returned
     * Argument.
     *
     * @param argument The raw argument string
     * @return A new Argument containing the given argument data
     * @throws IllegalArgumentException If the argument could not be parsed
     */
    Argument<?> parseRawArgument(String argument) throws IllegalArgumentException;

    /**
     * Parses an {@link Argument} from the given argument string, and attempts
     * to convert it to the requested type. Any ArgumentTypes defined in
     * ArgumentTypes are used to generate the returned Argument.
     *
     * @param argument The raw argument string
     * @param type The type to convert to
     * @return A new Argument containing the given argument data
     * @throws IllegalArgumentException If the argument could not be parsed and
     *         converted
     */
    <T> Argument<T> parseRawArgument(String argument, Class<? extends T> type) throws IllegalArgumentException;

}
