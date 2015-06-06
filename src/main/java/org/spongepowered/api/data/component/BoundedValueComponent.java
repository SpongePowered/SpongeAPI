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
package org.spongepowered.api.data.component;

import org.spongepowered.api.data.Component;

/**
 * Represents a {@link Component} that has upper and lower bounds of the value
 * that it can contain.
 *
 * @param <V> The type of comparable value
 * @param <T> The type of bounded value component
 */
public interface BoundedValueComponent<V extends Comparable<V>, T extends BoundedValueComponent<V, T>> extends SingleValueComponent<V, T> {

    /**
     * Gets the minimum value supported by this {@link BoundedValueComponent}.
     *
     * @return The minimum supported value
     */
    V getMinimum();

    /**
     * Gets the maximum value supported by this {@link BoundedValueComponent}.
     *
     * @return The maximum supported value
     */
    V getMaximum();

}
