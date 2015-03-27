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
package org.spongepowered.api.data.manipulators;

import com.google.common.base.Optional;
import org.spongepowered.api.data.DataManipulator;

import java.util.Collection;
import java.util.List;

/**
 * Represents an item that can have a {@link Collection} of types of elements.
 * Since {@link DataManipulator} is meant to be mutable, the {@link ListData}
 * too is mutable.
 *
 * <p>The various implementations of {@link ListData} include:
 * {@link PagedData}, {@link LoreData}, and {@link PlaceableData}.</p>
 *
 * @param <T> The type of element involved in the collection
 * @param <E> The implementing item data that should be comparable to itself
 */
public interface ListData<E, T extends ListData<E, T>> extends DataManipulator<T> {

    /**
     * Gets all the elements stored by this {@link ListData}.
     *
     * <p>This will return an unmodifiable list of elements. To modify the
     * list of elements, use the provided methods in {@link ListData}.
     * The returned list will have non-null values.</p>
     *
     * @return An unmodifiable list of all elements
     */
    List<E> getAll();

    /**
     * Gets the element at the desired index.
     *
     * <p>A {@link ListData} may not have an element at the
     * desired index.</p>
     *
     * @param index The element index, starting at 0
     * @return The element, if available
     */
    Optional<E> get(int index);

    /**
     * Checks whether the given element exists within this {@link ListData}.
     *
     * @param element The elemnt to check
     * @return Whether the element exists in this data
     */
    boolean contains(E element);

    /**
     * Resets this {@link ListData} to only the given elements.
     *
     * <p>This removes any extra elements outside the range of the given
     * elements.</p>
     *
     * @param elements The elements
     */
    void set(E... elements);

    /**
     * Resets this {@link ListData} to only the given elements.
     *
     * <p>This removes any extra elements outside the range of the given
     * elements.</p>
     *
     * @param elements The elements
     */
    void set(Iterable<E> elements);

    /**
     * Sets the given element at the desired index.
     *
     * <p>If there are no element preceding the desired element, the element
     * is added after the last non-null element.</p>
     *
     * @param index The index of the element
     * @param element The element to set
     */
    void set(int index, E element);

    /**
     * Adds the given element at the end of this {@link ListData}.
     *
     * @param element The element to add
     */
    void add(E element);

    /**
     * Adds the given element at the end of this {@link ListData}.
     *
     * <p>If there are elements at the given index, the given element
     * is inserted and pushes the rest of the elements back. If there
     * are no elements preceeding the desired index, the element is added
     * after the last non-null element.</p>
     *
     * @param index The index to insert
     * @param element The element to add
     */
    void add(int index, E element);

    /**
     * Removes the element at the desired index.
     *
     * @param index The index to remove the element at
     */
    void remove(int index);
}
