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
package org.spongepowered.api.data.value;

import org.spongepowered.api.data.value.immutable.ImmutableListValue;
import org.spongepowered.api.data.value.mutable.MutableListValue;

import java.util.List;

public interface ListValue<E, V extends ListValue<E, V>> extends CollectionValue<E, List<E>, V> {

    /**
     * Gets the desired element at the desired index.
     *
     * @param index The index of the element to return
     * @return The element at the desired index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    E get(int index);

    /**
     * Queries for the index of the provided element. If the element is
     * not contained in this list, -1 is returned.
     *
     * @param element The element to get the index from
     * @return The index of the element, -1 if not available
     */
    int indexOf(E element);

    @Override
    MutableListValue<E> asMutable();

    @Override
    ImmutableListValue<E> asImmutable();

}
