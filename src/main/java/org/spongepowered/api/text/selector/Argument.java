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
 * Represents a {@link Selector selector} argument. An Argument is one or
 * more key-to-value mappings ({@code key=value}) used only for building a
 * selector, as Map provides a better way of getting this information than
 * iterating over a list of Arguments.
 * 
 * @param <T> The type of the value
 */
public interface Argument<T> {

    /**
     * Returns the key for this {@link Argument}.
     * 
     * @return The key for this Argument
     */
    String getKey();

    /**
     * Returns the value for this {@link Argument}.
     * 
     * @return The value for this Argument
     */
    T getValue();

    /**
     * Converts this {@link Argument} to a valid argument string.
     *
     * @return A valid Argument string that can be parsed with
     *         {@link Arguments#parseRaw(String)}
     */
    String asString();

}
