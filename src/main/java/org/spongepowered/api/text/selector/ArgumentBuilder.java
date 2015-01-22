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
 * Represents a builder interface to create immutable {@link Argument}
 * instances.
 */
public interface ArgumentBuilder {

    /**
     * Sets the key.
     * 
     * @param key
     *            The key
     * @return This argument builder
     */
    ArgumentBuilder key(String key);

    /**
     * Sets the value.
     * 
     * @param value
     *            The value
     * @return This argument builder
     */
    ArgumentBuilder value(String value);

    /**
     * Sets the value, converting it to a String first.
     * 
     * @param value
     *            The value
     * @return This argument builder
     */
    ArgumentBuilder value(int value);

    /**
     * Inverts this builder's value.
     * 
     * <p>
     * It may not be possible to invert the value, in which case a
     * {@link IllegalStateException} is thrown.
     * </p>
     * 
     * @return This argument builder
     * @throws IllegalStateException
     *             If it is not possible to invert the value
     */
    ArgumentBuilder invert() throws IllegalStateException;

    /**
     * Builds an immutable instance of the current state of this argument
     * builder.
     *
     * @return An immutable {@link Argument} with the current properties of this
     *         builder
     */
    Argument build();

}
