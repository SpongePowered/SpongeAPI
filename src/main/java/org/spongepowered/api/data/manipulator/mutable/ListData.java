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
package org.spongepowered.api.data.manipulator.mutable;

import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.immutable.ImmutableListData;
import org.spongepowered.api.data.value.mutable.ListValue;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface ListData<E, M extends ListData<E, M, I>, I extends ImmutableListData<E, I, M>> extends DataManipulator<M, I> {

    /**
     * Gets the {@link ListValue} of this {@link ListData}.
     *
     * @return The underlying list value
     */
    ListValue<E> getListValue();

    /**
     * Gets the {@link List} value itself from this manipulator.
     *
     * @return The underlying list value as a list
     * @see ListValue
     */
    List<E> asList();

    /**
     * Gets an element of type {@code E} by the provided {@code index}.
     *
     * @param index The index to get the value at
     * @return The object at the provided index, if available
     * @see List#get(int)
     */
    default Optional<E> get(int index) {
        final List<E> list = asList();
        if (list.size() < index) {
            return Optional.empty();
        }
        return Optional.of(list.get(index));
    }

    /**
     * Returns whether the underlying {@link List} contains the provided
     * {@code element}.
     *
     * @param element The element to check
     * @return True if the element is contained in the underlying list
     * @see List#contains(Object)
     */
    default boolean contains(E element) {
        return getListValue().contains(element);
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element (optional operation).
     *
     * @param index The index to set the element to
     * @param element The element to set at the index
     * @return This manipulator, for chaining
     * @see List#set(int, Object)
     */
    default M setElement(int index, E element) {
        return set(getListValue().set(index, element));
    }

    /**
     * Replaces the underlying list of elements with the provided {@link List}
     * of elements.
     *
     * @param elements The element to set at the index
     * @return This manipulator, for chaining
     * @see List#set(int, Object)
     */
    default M setElements(List<E> elements) {
        return set(getListValue().set(elements));
    }

    /**
     * Appends the provided element at the end of the underlying {@link List}.
     *
     * @param element The element to append
     * @return This manipulator, for chaining
     * @see List#add(Object)
     */
    default M addElement(E element) {
        return set(getListValue().add(element));
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     *
     * @param index The index of the element
     * @param element The element to add
     * @return This manipulator, for chaining
     * @see List#add(int, Object)
     */
    default M addElement(int index, E element) {
        return set(getListValue().add(index, element));
    }

    /**
     * Appends the provided {@code E} elements to the end of the internal list
     * of elements.
     *
     * @param elements The elements to add
     * @return This manipulator, for chaining
     * @see List#addAll(Collection)
     */
    default M addElements(Iterable<E> elements) {
        return set(getListValue().addAll(elements));
    }

    /**
     * Removes the desired {@code element} from the desired {@code index}.
     *
     * @param index The index to remove an element from
     * @return This manipulator, for chaining
     * @see List#remove(int)
     */
    default M remove(int index) {
        return set(getListValue().remove(index));
    }

    /**
     * Removes the desired {@code element} from the underlying {@link List}.
     *
     * @param element The element to remove
     * @return This manipulator, for chaining
     * @see List#remove(Object)
     */
    default M remove(E element) {
        return set(getListValue().remove(element));
    }

    /**
     * Removes all of the provided {@code elements} from the underlying
     * {@link List}.
     *
     * @param elements The elements to remove
     * @return This manipulator, for chaining
     * @see List#removeAll(Collection)
     */
    default M removeAll(Iterable<E> elements) {
        return set(getListValue().removeAll(elements));
    }

    /**
     * Removes any and all {@code elements} that match {@code true} to
     * the provided {@link Predicate} from the underlying {@link List}.
     *
     * @param predicate The predicate to filter elements from
     * @return This manipulator, for chaining
     * @see List#removeIf(Predicate)
     */
    default M removeAll(Predicate<E> predicate) {
        return set(getListValue().removeAll(predicate));
    }

}
