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

import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.data.value.mutable.CollectionValue;

import java.util.Collection;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * A {@link ImmutableValue} type that handles a {@link Collection} of elements
 * type <code>E</code>. All of the methods provided for modification return new
 * instances of the same type. Likewise, the underlying {@link ValueContainer}
 * is not modified.
 *
 * @param <E> The type of element
 * @param <C> The type of {@link Collection}
 * @param <I> The extended {@link ImmutableCollectionValue} for self referencing
 * @param <M> The mutable {@link CollectionValue} counterpart for {@link #asMutable()}
 */
public interface ImmutableCollectionValue<E, C extends Collection<E>, I extends ImmutableCollectionValue<E, C, I, M>,
    M extends CollectionValue<E, C, M, I>> extends ImmutableValue<C> {

    /**
     * Gets the size of the underlying collection of elements.
     *
     * @return The size
     */
    int size();

    /**
     * Checks if the backed {@link Collection} is empty.
     *
     * @see Collection#isEmpty()
     * @return True if the collection is empty
     */
    boolean isEmpty();

    @Override
    I with(C collection);

    /**
     * Creates a new {@link ImmutableCollectionValue} with the given values
     * along with any pre-existing values within this value.
     *
     * @param elements The values to add
     * @return The new value
     */
    I withElement(E elements);

    @Override
    I transform(Function<C, C> function);

    /**
     * Creates a new {@link ImmutableCollectionValue} with the given elements
     * along with any pre-existing values within this value.
     *
     * @see Collection#addAll(Collection)
     *
     * @param elements The elements to add
     * @return The new value
     */
    I withAll(Iterable<E> elements);

    /**
     * Creates a new {@link ImmutableCollectionValue} without the given
     * <code>E</code> element.
     *
     * @param element The element to exclude
     * @return The new value
     */
    I without(E element);

    /**
     * Creates a new {@link ImmutableCollectionValue} without the given
     * elements of the provided {@link Iterable}.
     *
     * @param elements The elements to exclude
     * @return The new value
     */
    I withoutAll(Iterable<E> elements);

    /**
     * Creates a new {@link ImmutableCollectionValue} with elements that
     * when the given {@link Predicate} is {@link Predicate#test(Object)} on
     * the element and {@code true} is returned, the element will remain in the
     * new {@link ImmutableCollectionValue}.
     *
     * @param predicate The predicte to apply
     * @return The new value
     */
    I withoutAll(Predicate<E> predicate);

    /**
     * Checks if the given <code>E</code> element is contained within the
     * backed {@link Collection}.
     *
     * @param element The element to check
     * @return True if the element is contained, false if not
     */
    boolean contains(E element);

    /**
     * Checks if all of the given elements in the provided {@link Iterable} are
     * contained within the backed {@link Collection}.
     *
     * @param iterable The iterable elements
     * @return True if all elements are contained within the backed collection
     */
    boolean containsAll(Iterable<E> iterable);

    /**
     * Creates a new {@link Collection} of the proper type <code>C</code> with
     * all elements copied to the new collection. Any modifications to the new
     * collection are not reflected to this {@link ImmutableCollectionValue}.
     * Likewise, no modifications to this {@link ImmutableCollectionValue} are
     * reflected to the returned {@link Collection}.
     *
     * @return A new collection with all elements copied
     */
    C getAll();

    @Override
    M asMutable();
}
