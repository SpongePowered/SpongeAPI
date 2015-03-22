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
package org.spongepowered.api.item.data;

import com.google.common.base.Optional;

import java.util.Collection;
import java.util.List;

/**
 * Represents an item that can have a {@link Collection} of types of elements.
 * Since {@link ItemData} is meant to be mutable, the {@link ListItemData}
 * too is mutable.
 *
 * <p>The various implementations of {@link ListItemData} include:
 * {@link PagedItemData}, {@link LoreItemData}, and {@link PlaceableItemData}.</p>
 *
 * @param <T> The type of element involved in the collection
 * @param <E> The implementing item data that should be comparable to itself
 */
public interface ListItemData<E, T extends ListItemData<E, T>> extends ItemData<T> {

    /**
     * Gets all the elements stored by this {@link ListItemData}.
     *
     * <p>This will return an unmodifiable list of elements. To modify the
     * list of elements, use the provided methods in {@link ListItemData}.
     * The returned list will have non-null values.</p>
     *
     * @return An unmodifiable list of all elements
     */
    List<E> getAll();

    /**
     * Gets the element at the desired index.
     *
     * <p>A {@link ListItemData} may not have an element at the
     * desired index.</p>
     *
     * @param index The element index, starting at 0
     * @return The element, if available
     */
    Optional<E> get(int index);

    /**
     * Resets this {@link ListItemData} to only the given elements.
     *
     * <p>This removes any extra elements outside the range of the given
     * elements.</p>
     *
     * @param elements The elements
     */
    void set(E... elements);

    /**
     * Resets this {@link ListItemData} to only the given elements.
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
     * Adds the given element at the end of this {@link ListItemData}.
     *
     * @param element The element to add
     */
    void add(E element);

    /**
     * Adds the given element at the end of this {@link ListItemData}.
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
