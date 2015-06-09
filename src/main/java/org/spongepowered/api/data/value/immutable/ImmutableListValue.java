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
package org.spongepowered.api.data.value.immutable;

import org.spongepowered.api.data.value.mutable.ListValue;

import java.util.List;

/**
 * A type of {@link ImmutableCollectionValue} that is backed by a {@link List}.
 * All "with" and "Without" methods are returning new instances as every
 * instance is immutable.
 *
 * @param <E> The type of element of this list value
 */
public interface ImmutableListValue<E> extends ImmutableCollectionValue<E, List<E>, ImmutableListValue<E>, ListValue<E>> {

    /**
     * Gets the desired element at the desired index.
     *
     * @param index The index of the element to return
     * @return The element at the desired index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    E get(int index);

    /**
     * Creates a new {@link ImmutableListValue} with the specified element
     * at the specified position in the list. As well, the element at the
     * provided index is shifted to the right,  increasing its and the elements
     * thereafter their indices by one.
     *
     * @param index The index to add the provided element at
     * @param value The element to add
     * @return The new value, for chaining
     */
    ImmutableListValue<E> with(int index, E value);

    /**
     * Creates a new {@link ImmutableListValue} with the specified elements
     * in the order that they are iterated to the list at the specified index.
     * The element at the provided index and elements thereafter are shifted to
     * the right, increasing their indices by one.
     *
     * @param index The index to add the elements at
     * @param values The elements to add
     * @return The new value, for chaining
     */
    ImmutableListValue<E> with(int index, Iterable<E> values);

    /**
     * Creates a new {@link ImmutableListValue} without the element at the
     * specified index. Shifts any subsequent elements to the left, subtracts
     * one from their indices.
     *
     * @param index The index of the element to exclude
     * @return The new value, for chaining
     */
    ImmutableListValue<E> without(int index);

    /**
     * Creates a new {@link ImmutableListValue} with the desired element at
     * the desired index.
     *
     * @param index The index to replace the element
     * @param element The element to include at the index
     * @return The new value, for chaining
     */
    ImmutableListValue<E> set(int index, E element);

    /**
     * Queries for the index of the provided element. If the element is
     * not contained in this list, -1 is returned.
     *
     * @param element The element to get the index from
     * @return The index of the element, -1 if not available
     */
    int indexOf(E element);

}
