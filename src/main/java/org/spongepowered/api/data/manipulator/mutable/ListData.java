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

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface ListData<E, M extends ListData<E, M, I>, I extends ImmutableListData<E, I, M>> extends DataManipulator<M, I> {

    ListValue<E> getListValue();

    List<E> asList();

    default Optional<E> get(int index) {
        final List<E> list = asList();
        if (list.size() < index) {
            return Optional.empty();
        }
        return Optional.of(list.get(index));
    }

    default boolean contains(E element) {
        return getListValue().contains(element);
    }

    default M setElement(int index, E element) {
        return set(getListValue().set(index, element));
    }

    default M setElements(List<E> elements) {
        return set(getListValue().set(elements));
    }

    default M addElement(E element) {
        return set(getListValue().add(element));
    }

    default M addElement(int index, E element) {
        return set(getListValue().add(index, element));
    }

    default M addElements(Iterable<E> elements) {
        return set(getListValue().addAll(elements));
    }

    default M remove(int index) {
        return set(getListValue().remove(index));
    }

    default M remove(E element) {
        return set(getListValue().remove(element));
    }

    default M removeAll(Iterable<E> elements) {
        return set(getListValue().removeAll(elements));
    }

    default M removeAll(Predicate<E> predicate) {
        return set(getListValue().removeAll(predicate));
    }

}
