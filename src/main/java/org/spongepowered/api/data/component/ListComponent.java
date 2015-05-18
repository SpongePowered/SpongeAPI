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

import com.google.common.base.Optional;
import org.spongepowered.api.data.Component;
import org.spongepowered.api.data.component.item.LoreComponent;
import org.spongepowered.api.data.component.item.PagedComponent;
import org.spongepowered.api.data.component.item.PlaceableComponent;

import java.util.Collection;
import java.util.List;

/**
 * Represents an item that can have a {@link Collection} of types of elements.
 * Since {@link Component} is meant to be mutable, the {@link ListComponent}
 * too is mutable.
 *
 * <p>The various implementations of {@link ListComponent} include:
 * {@link PagedComponent}, {@link LoreComponent}, and {@link PlaceableComponent}.</p>
 *
 * @param <T> The type of element involved in the collection
 * @param <E> The implementing item data that should be comparable to itself
 */
public interface ListComponent<E, T extends ListComponent<E, T>> extends Component<T> {

    /**
     * Gets all the elements stored by this {@link ListComponent}.
     *
     * <p>This will return an unmodifiable list of elements. To modify the
     * list of elements, use the provided methods in {@link ListComponent}.
     * The returned list will have non-null values.</p>
     *
     * @return An unmodifiable list of all elements
     */
    List<E> getAll();

    /**
     * Gets the element at the desired index.
     *
     * <p>A {@link ListComponent} may not have an element at the
     * desired index.</p>
     *
     * @param index The element index, starting at 0
     * @return The element, if available
     */
    Optional<E> get(int index);

    /**
     * Checks whether the given element exists within this {@link ListComponent}.
     *
     * @param element The elemnt to check
     * @return Whether the element exists in this data
     */
    boolean contains(E element);

    /**
     * Resets this {@link ListComponent} to only the given elements.
     *
     * <p>This removes any extra elements outside the range of the given
     * elements.</p>
     *
     * @param elements The elements
     * @return This instance, for chaining
     */
    T set(E... elements);

    /**
     * Resets this {@link ListComponent} to only the given elements.
     *
     * <p>This removes any extra elements outside the range of the given
     * elements.</p>
     *
     * @param elements The elements
     * @return This instance, for chaining
     */
    T set(Iterable<E> elements);

    /**
     * Sets the given element at the desired index.
     *
     * <p>If there are no element preceding the desired element, the element
     * is added after the last non-null element.</p>
     *
     * @param index The index of the element
     * @param element The element to set
     * @return This instance, for chaining
     */
    T set(int index, E element);

    /**
     * Adds the given element at the end of this {@link ListComponent}.
     *
     * @param element The element to add
     * @return This instance, for chaining
     */
    T add(E element);

    /**
     * Adds the given element at the end of this {@link ListComponent}.
     *
     * <p>If there are elements at the given index, the given element
     * is inserted and pushes the rest of the elements back. If there
     * are no elements preceeding the desired index, the element is added
     * after the last non-null element.</p>
     *
     * @param index The index to insert
     * @param element The element to add
     * @return This instance, for chaining
     */
    T add(int index, E element);

    /**
     * Removes the element at the desired index.
     *
     * @param index The index to remove the element at
     * @return This instance, for chaining
     */
    T remove(int index);
}
