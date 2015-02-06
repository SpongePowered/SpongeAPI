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
 * Utility class to create {@link Argument}s.
 */
public final class Arguments {

    private Arguments() {
    }

    /**
     * Creates a new {@link Argument} using the specified type and value.
     *
     * @param type The type of the argument
     * @param value The value of the argument
     * @param <T> The type of the argument value
     * @return The created argument
     */
    public static <T> Argument<T> create(ArgumentType<T> type, T value) {
        return Selectors.factory.createArgument(type, value);
    }

    /**
     * Creates a new {@link Argument.Invertible} using the specified type and
     * value. The created {@link Argument} will not be inverted.
     *
     * @param type The type of the invertible argument
     * @param value The value of the invertible argument
     * @param <T> The type of the argument value
     * @return The created invertible argument
     */
    public static <T> Argument.Invertible<T> create(ArgumentType.Invertible<T> type, T value) {
        return create(type, value, false);
    }

    /**
     * Creates a new {@link Argument.Invertible} using the specified type and
     * value. The created {@link Argument} will be inverted based on the given
     * parameter.
     *
     * @param type The type of the invertible argument
     * @param value The value of the invertible argument
     * @param inverted {@code true} if the argument should be inverted
     * @param <T> The type of the argument value
     * @return The created invertible argument
     */
    public static <T> Argument.Invertible<T> create(ArgumentType.Invertible<T> type, T value, boolean inverted) {
        return Selectors.factory.createArgument(type, value, inverted);
    }

    /**
     * Parses an {@link Argument} from the given argument string.
     *
     * <p>In Vanilla, it should be formatted like {@code key=value}.</p>
     *
     * @param argument The argument string
     * @return The parsed argument
     * @throws IllegalArgumentException If the argument couldn't be parsed (e.g.
     *         due to invalid format)
     */
    public static Argument<?> parse(String argument) throws IllegalArgumentException {
        return Selectors.factory.parseArgument(argument);
    }

}
