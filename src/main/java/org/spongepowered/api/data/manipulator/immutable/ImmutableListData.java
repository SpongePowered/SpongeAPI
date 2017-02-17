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
package org.spongepowered.api.data.manipulator.immutable;

import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.mutable.ListData;
import org.spongepowered.api.data.value.immutable.ImmutableListValue;

import java.util.List;
import java.util.Optional;

/**
 * An immutable variant of {@link ListData} that can be queried, but not
 * changed or mutated.
 *
 * @param <E> The type of elements contained in the underlying list
 * @param <I> The immutable data variant
 * @param <M> The mutable data variant
 */
public interface ImmutableListData<E, I extends ImmutableListData<E, I, M>, M extends ListData<E, M, I>> extends ImmutableDataManipulator<I, M> {

    /**
     * Gets the {@link ImmutableListValue} of this {@link ImmutableListData}.
     *
     * @return The underlying list value
     */
    ImmutableListValue<E> getListValue();

    /**
     * Gets the {@link List} value itself from this manipulator.
     *
     * @return The underlying list value as a list
     * @see ImmutableListValue
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

}
