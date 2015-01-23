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
 * Arguments is a utility class to work with and create Arguments.
 */
public final class Arguments {

    private static final ArgumentFactory factory = null;

    private Arguments() {}

    /**
     * Creates an {@link Argument}.
     * 
     * @param type The type for the Argument
     * @param value The value for the Argument
     *
     * @return A new argument with {@code type.getKey()} mapped to {@code value}
     */
    public static <T, A extends Argument<T>> A create(ArgumentType<T, A> type, T value) {
        return factory.createArgument(type, value);
    }

    /**
     * Creates a custom {@link Argument}. Using a key defined by an ArgumentType
     * will not offer the features of the ArgumentType, such as inversion.
     * 
     * @param key The key for the Argument
     * @param value The value for the Argument
     *
     * @return A new argument with {@code key} mapped to {@code value}
     */
    public static <T> Argument<T> createCustom(String key, T value) {
        return factory.createCustomArgument(key, value);
    }

    /**
     * Creates a custom {@link Argument}. Using a key defined by an ArgumentType
     * will not offer the features of the ArgumentType, such as inversion.
     * 
     * @param key The key for the Argument
     * @param value The value for the Argument
     *
     * @return A new argument with {@code key} mapped to {@code value}
     */
    public static Argument<Integer> createCustom(String key, int value) {
        return factory.createCustomArgument(key, Integer.valueOf(value));
    }

    /**
     * Parses an {@link Argument} from the given argument string. Any
     * ArgumentTypes defined in ArgumentTypes are used to generate the returned
     * Argument.
     *
     * @param argument The raw argument string
     * @return A new Argument containing the given argument data
     * @throws IllegalArgumentException If the argument could not be parsed
     */
    public static Argument<?> parseRaw(String argument) throws IllegalArgumentException {
        return factory.parseRawArgument(argument);
    }

    /**
     * Parses an {@link Argument} from the given argument string, and attempts
     * to cover it to the requested type. Any ArgumentTypes defined in
     * ArgumentTypes are used to generate the returned Argument.
     *
     * @param argument The raw argument string
     * @param type The type to convert to
     * @return A new Argument containing the given argument data
     * @throws IllegalArgumentException If the argument could not be parsed and
     *         conveyed
     */
    public static <T> Argument<T> parseRaw(String argument, Class<? extends T> type) throws IllegalArgumentException {
        return factory.parseRawArgument(argument, type);
    }

}
