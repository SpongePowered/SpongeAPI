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
package org.spongepowered.api.text.selector;

import java.util.Set;

/**
 * Represents the type of an {@link Argument}. This represents a single argument
 * key in a {@link Selector}.
 *
 * @param <T> The type for the value of this argument type
 * @see Selector
 * @see Argument
 * @see ArgumentTypes
 */
public interface ArgumentType<T> extends ArgumentHolder<ArgumentType<T>> {

    /**
     * Returns the key associated with this {@link ArgumentType}.
     *
     * @return The key of this argument type
     */
    String getKey();

    /**
     * Returns 1.
     *
     * @return 1
     */
    @Override
    int getCount();

    /**
     * Returns a set containing this {@link ArgumentType}.
     *
     * @return A set containing this {@link ArgumentType}
     */
    @Override
    Set<ArgumentType<T>> getTypes();

    /**
     * Represents an {@link ArgumentType} that can be inverted.
     *
     * @param <T> The type for the value of this argument type
     * @see ArgumentType
     * @see Argument.Invertible
     */
    interface Invertible<T> extends ArgumentType<T> {

    }

}
