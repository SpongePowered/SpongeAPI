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
 * Represents a {@linkplain Selector selector} argument. An Argument is a
 * key-to-value mapping ({@code key=value}) used only for building a selector,
 * as Map provides a better way of getting this information than iterating over
 * a list of Arguments.
 */
public interface Argument {

    /**
     * Returns the key for this {@linkplain Argument}.
     * 
     * @return The key for this Argument
     */
    String getKey();

    /**
     * Returns the value for this {@linkplain Argument}.
     * 
     * @return The value for this Argument
     */
    String getValue();

    /**
     * Returns the result of inverting this {@linkplain Argument}'s value. For
     * example, {@code type=Player} is inverted to {@code type=!Player}.
     * 
     * <p>
     * It may not be possible to invert this Argument's value, in which case a
     * {@link IllegalStateException} is thrown.
     * </p>
     * 
     * @return An inverted argument, if possible
     * @throws IllegalStateException If it is not possible to invert this
     *         Argument's value
     */
    Argument invert() throws IllegalStateException;

    /**
     * Converts this {@linkplain Argument} to a valid argument string.
     *
     * @return A valid Argument string that can be parsed with
     *         {@link Arguments#parseRaw(String)}
     */
    String asString();

}
