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
package org.spongepowered.api.data.value.mutable;

import org.spongepowered.api.data.value.CollectionValue;
import org.spongepowered.api.data.value.immutable.ImmutableCollectionValue;

import java.util.Collection;
import java.util.function.Predicate;

/**
 * Represents a {@link MutableValue} that is backed by a {@link Collection} of
 * elements.
 *
 * @param <E> The type of element
 * @param <C> The type of collection, for chaining
 * @param <V> The type of {@linkplain MutableCollectionValue}
 * @param <I> The type of {@link ImmutableCollectionValue}
 */
public interface MutableCollectionValue<E,
    C extends Collection<E>,
    V extends MutableCollectionValue<E, C, V, I>,
    I extends ImmutableCollectionValue<E, C, I, V>>
    extends MutableValue<C, V, I>, CollectionValue<E, C, V>, Iterable<E> {


    /**
     * Adds the given {@code element} to this {@link MutableCollectionValue}.
     *
     * @param element The element to add
     * @return This value, for chaining
     */
    V add(E element);

    /**
     * Adds all the given {@link Iterable} {@code elements} to the underlying
     * {@link Collection}.
     *
     * @see Collection#addAll(Collection)
     *
     * @param elements The elements to add
     * @return This value, for chaining
     */
    V addAll(Iterable<E> elements);

    /**
     * Removes the given {@code element} from the backed {@link Collection}.
     *
     * @param element The element to remove
     * @return This value, for chaining
     */
    V remove(E element);

    /**
     * Removes all elements from the {@link Iterable} from the backed
     * {@link Collection}.
     *
     * @param elements The elements to remove
     * @return This value, for chaining
     */
    V removeAll(Iterable<E> elements);

    /**
     * Iterates over all existing elements and removes any elements that
     * {@link Predicate#test(Object)} returns {@code true}.
     *
     * @param predicate The predicate to remove elements
     * @return This value, for chaining
     */
    V removeAll(Predicate<E> predicate);

    @Override
    V copy();

    @SuppressWarnings("unchecked")
    @Override
    default V asMutable() {
        return (V) this;
    }
}
