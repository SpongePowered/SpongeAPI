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

import org.spongepowered.api.data.Key;

import java.util.List;

public interface ListValue<E> extends CollectionValue<E, List<E>> {

    /**
     * Constructs a mutable {@link ListValue} of the appropriate type based
     * on the given {@link Key} and the element.
     *
     * @param key The key
     * @param element The element
     * @param <E> The element type
     * @return The constructed mutable value
     */
    static <E> ListValue.Mutable<E> mutableOf(Key<? extends ListValue<E>> key, List<E> element) {
        return Value.mutableOf(key, element);
    }

    /**
     * Constructs an immutable {@link ListValue} of the appropriate type based
     * on the given {@link Key} and the element.
     *
     * @param key The key
     * @param element The element
     * @param <E> The element type
     * @return The constructed immutable value
     */
    static <E> ListValue.Immutable<E> immutableOf(Key<? extends ListValue<E>> key, List<E> element) {
        return Value.immutableOf(key, element);
    }

    @Override
    Key<? extends ListValue<E>> getKey();

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
    ListValue.Mutable<E> asMutable();

    @Override
    ListValue.Immutable<E> asImmutable();

    /**
     * A type of {@link org.spongepowered.api.data.value.CollectionValue.Mutable} that is backed by a {@link List}. All
     * mutator methods provided are similar to those existing in {@link List} with
     * the difference of returning itself, for fluency.
     *
     * @param <E> The type of element of this list value
     */
    interface Mutable<E> extends ListValue<E>, CollectionValue.Mutable<E, List<E>, Mutable<E>, Immutable<E>> {

        /**
         * Adds the specified element at the specified position in the list.
         * As well, the element at the provided index is shifted to the right,
         * increasing its and the elements thereafter their indices by one.
         *
         * @param index The index to add the provided element at
         * @param value The element to add
         * @return This value, for chaining
         */
        ListValue.Mutable<E> add(int index, E value);

        /**
         * Adds the specified elements in the order that they are iterated
         * to the list at the specified index. The element at the provided
         * index and elements thereafter are shifted to the right, increasing
         * their indices by one.
         *
         * @param index The index to add the elements at
         * @param values The elements to add
         * @return This value, for chaining
         */
        ListValue.Mutable<E> add(int index, Iterable<E> values);

        /**
         * Removes the element at the specified position in this list (optional
         * operation). Shifts any subsequent elements to the left, subtracts
         * one from their indices.
         *
         * @param index The index of the element to remove
         * @return This value, for chaining
         */
        ListValue.Mutable<E> remove(int index);

        /**
         * Replaces the element at the specified index in this list with the
         * specified element.
         *
         * @param index The index to replace the element with
         * @param element The element to set
         * @return This value, for chaining
         */
        ListValue.Mutable<E> set(int index, E element);

        @Override
        default ListValue.Mutable<E> asMutable() {
            return this;
        }

        @Override
        ListValue.Immutable<E> asImmutable();
    }

    /**
     * A type of {@link org.spongepowered.api.data.value.CollectionValue.Immutable} that is backed by a {@link List}.
     * All "with" and "Without" methods are returning new instances as every
     * instance is immutable.
     *
     * @param <E> The type of element of this list value
     */
    interface Immutable<E> extends ListValue<E>, CollectionValue.Immutable<E, List<E>, Immutable<E>, Mutable<E>> {


        /**
         * Creates a new {@link org.spongepowered.api.data.value.ListValue.Immutable} with the specified element
         * at the specified position in the list. As well, the element at the
         * provided index is shifted to the right,  increasing its and the elements
         * thereafter their indices by one.
         *
         * @param index The index to add the provided element at
         * @param value The element to add
         * @return The new value, for chaining
         */
        ListValue.Immutable<E> with(int index, E value);

        /**
         * Creates a new {@link org.spongepowered.api.data.value.ListValue.Immutable} with the specified elements
         * in the order that they are iterated to the list at the specified index.
         * The element at the provided index and elements thereafter are shifted to
         * the right, increasing their indices by one.
         *
         * @param index The index to add the elements at
         * @param values The elements to add
         * @return The new value, for chaining
         */
        ListValue.Immutable<E> with(int index, Iterable<E> values);

        /**
         * Creates a new {@link org.spongepowered.api.data.value.ListValue.Immutable} without the element at the
         * specified index. Shifts any subsequent elements to the left, subtracts
         * one from their indices.
         *
         * @param index The index of the element to exclude
         * @return The new value, for chaining
         */
        ListValue.Immutable<E> without(int index);

        /**
         * Creates a new {@link org.spongepowered.api.data.value.ListValue.Immutable} with the desired element at
         * the desired index.
         *
         * @param index The index to replace the element
         * @param element The element to include at the index
         * @return The new value, for chaining
         */
        ListValue.Immutable<E> set(int index, E element);

        @Override
        ListValue.Mutable<E> asMutable();

        @Override
        default ListValue.Immutable<E> asImmutable() {
            return this;
        }
    }
}
