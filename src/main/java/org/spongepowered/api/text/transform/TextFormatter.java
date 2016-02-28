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
package org.spongepowered.api.text.transform;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextRepresentable;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * A TextFormatter is a mutable collection of {@link TextRepresentable}s which
 * are all concatenated to an empty {@link Text} object on {@link #format()}.
 */
public interface TextFormatter<E extends TextRepresentable> extends TextRepresentable, Iterable<E> {

    /**
     * Returns an {@link ImmutableList} of this formatter's elements.
     *
     * @return All elements
     */
    ImmutableList<E> getAll();

    /**
     * Returns the element at the specified index.
     *
     * @param i Index to retrieve from
     * @return Element at index
     */
    E get(int i);

    /**
     * Returns the first element of the specified type after the specified
     * index.
     *
     * @param index To start at
     * @param clazz Class of type
     * @param <T> Type of TextRepresentable
     * @return Element if found
     */
    @SuppressWarnings("unchecked")
    default <T extends TextRepresentable> Optional<T> firstAfter(int index, Class<T> clazz) {
        checkNotNull(clazz, "class");
        for (int i = index; i < size(); i++) {
            E e = get(i);
            if (clazz.isAssignableFrom(e.getClass())) {
                return Optional.of((T) e);
            }
        }
        return Optional.empty();
    }

    /**
     * Returns the first element of the specified type.
     *
     * @param clazz Type to get
     * @param <T> Type of {@link TextRepresentable}
     * @return TextRepresentable of type if found, empty otherwise
     */
    default <T extends TextRepresentable> Optional<T> first(Class<T> clazz) {
        return firstAfter(0, clazz);
    }

    /**
     * Applies the specified consumer to each element of the specified type
     * after the specified index.
     *
     * @param index Index to start at
     * @param clazz Class of type
     * @param consumer Consumer
     * @param <T> Type
     */
    @SuppressWarnings("unchecked")
    default <T extends TextRepresentable> void forEachAfter(int index, Class<T> clazz, Consumer<T> consumer) {
        checkNotNull(clazz, "class");
        for (int i = index; i < size(); i++) {
            E e = get(i);
            if (clazz.isAssignableFrom(e.getClass())) {
                consumer.accept((T) e);
            }
        }
    }

    /**
     * Applies the specified consumer to each element of the specified type
     * after the specified index.
     *
     * @param clazz Class of type
     * @param consumer Consumer
     * @param <T> Type
     */
    default <T extends TextRepresentable> void forEach(Class<T> clazz, Consumer<T> consumer) {
        forEachAfter(0, clazz, consumer);
    }

    /**
     * Replaces the element previously at the specified index with the
     * specified element.
     *
     * @param i Index to replace
     * @param e Element to replace with
     * @return Element previously at index
     */
    E set(int i, E e);

    /**
     * Returns the amount of elements in this formatter.
     *
     * @return Amount of elements
     */
    int size();

    /**
     * Returns true if the formatter contains no elements.
     *
     * @return True if contains no elements
     */
    boolean isEmpty();

    /**
     * Returns true if the specified element is in the formatter.
     *
     * @param e Element to check
     * @return True if in formatter
     */
    boolean contains(E e);

    /**
     * Clears all elements from this formatter.
     */
    void clear();

    /**
     * Adds the specified element to the end of this formatter.
     *
     * @param element Element to add
     * @return True if the formatter changed as a result of the call
     */
    boolean add(E element);

    /**
     * Adds the specified elements to the end of this formatter.
     *
     * @param elements Elements to add
     * @return True if the formatter changed as a result of the call
     */
    boolean add(Collection<E> elements);

    /**
     * Adds the specified elements to the end of this formatter.
     *
     * @param elements Elements to add
     * @return True if the formatter changed as a result of the call
     */
    default boolean add(Iterable<E> elements) {
        return add(Lists.newArrayList(elements));
    }

    /**
     * Adds the specified elements to the end of this formatter.
     *
     * @param elements Elements to add
     * @return True if the formatter changed as a result of the call
     */
    default boolean add(Iterator<E> elements) {
        return add(Lists.newArrayList(elements));
    }

    /**
     * Inserts the specified element at the specified index within the
     * formatter.
     *
     * @param i Index to insert at
     * @param element Element to insert
     */
    void insert(int i, E element);

    /**
     * Inserts the specified elements at the specified index within the
     * formatter.
     *
     * @param i Index to insert at
     * @param elements Elements to insert
     */
    void insert(int i, Collection<E> elements);

    /**
     * Inserts the specified elements at the specified index within the
     * formatter.
     *
     * @param i Index to insert at
     * @param elements Elements to insert
     */
    default void insert(int i, Iterable<E> elements) {
        insert(i, Lists.newArrayList(elements));
    }

    /**
     * Inserts the specified elements at the specified index within the
     * formatter.
     *
     * @param i Index to insert at
     * @param elements Elements to insert
     */
    default void insert(int i, Iterator<E> elements) {
        insert(i, Lists.newArrayList(elements));
    }

    /**
     * Removes the specified element from the formatter.
     *
     * @param element Element to remove
     * @return True if this formatter contained the Element
     */
    boolean remove(E element);

    /**
     * Removes the specified elements from the formatter.
     *
     * @param elements Elements to remove
     * @return True if the formatter changed as a result of this call
     */
    boolean remove(Collection<E> elements);

    /**
     * Removes the specified elements from the formatter.
     *
     * @param elements Elements to remove
     * @return True if the formatter changed as a result of this call
     */
    default boolean remove(Iterable<E> elements) {
        return remove(Lists.newArrayList(elements));
    }

    /**
     * Removes the specified elements from the formatter.
     *
     * @param elements Elements to remove
     * @return True if the formatter changed as a result of this call
     */
    default boolean remove(Iterator<E> elements) {
        return remove(Lists.newArrayList(elements));
    }

    /**
     * Removes all elements from the formatter except for these specified
     * elements.
     *
     * @param elements Elements to retain
     * @return True if the formatter changed as a result of this call
     */
    boolean retain(Collection<E> elements);

    /**
     * Removes all elements from the formatter except for these specified
     * elements.
     *
     * @param elements Elements to retain
     * @return True if the formatter changed as a result of this call
     */
    default boolean retain(Iterable<E> elements) {
        return retain(Lists.newArrayList(elements));
    }

    /**
     * Removes all elements from the formatter except for these specified
     * elements.
     *
     * @param elements Elements to retain
     * @return True if the formatter changed as a result of this call
     */
    default boolean retain(Iterator<E> elements) {
        return retain(Lists.newArrayList(elements));
    }

    /**
     * Builds the result {@link Text} for this formatter using the current
     * configuration of each element. The result of each element is
     * concatenated to an empty {@link Text} to yield the result.
     *
     * @return Text result of formatter
     */
    default Text format() {
        Text text = Text.EMPTY;
        for (E e : this) {
            text = text.concat(e.toText());
        }
        return text.trim();
    }

    @Override
    default Iterator<E> iterator() {
        return getAll().iterator();
    }

    @Override
    default Text toText() {
        return format();
    }

}
