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

import java.util.Collection;
import java.util.function.Predicate;

public interface CollectionValue<E, C extends Collection<E>> extends Value<C>, Iterable<E> {

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

    /**
     * Checks if the given <code>E</code> element is contained within the backed
     * {@link Collection}.
     *
     * @param element The element to check
     * @return True if the element is contained in this collection
     */
    boolean contains(E element);

    /**
     * Checks if all of the given {@link Iterable} elements are contained
     * within the backed {@link Collection}.
     *
     * @param iterable The iterable elements
     * @return True if all elements are contained in this value
     */
    boolean containsAll(Collection<E> iterable);

    /**
     * Creates a new {@link Collection} of the proper type <code>C</code> with
     * all elements copied to the new collection. Any modifications to the new
     * collection are not reflected to this {@link Mutable}. Likewise,
     * no modifications to this {@link Mutable} are reflected to the
     * returned {@link Collection}.
     *
     * @return A new collection with all elements copied
     */
    C getAll();

    /**
     * A {@link Value.Immutable} type that handles a {@link Collection} of elements
     * type <code>E</code>. All of the methods provided for modification return new
     * instances of the same type. Likewise, the underlying {@link ValueContainer}
     * is not modified.
     *
     * @param <E> The type of element
     * @param <C> The type of {@link Collection}
     * @param <I> The extended {@link CollectionValue.Immutable} for self referencing
     * @param <M> The mutable {@link CollectionValue.Mutable} counterpart for {@link #asMutable()}
     */
    interface Immutable<
        E,
        C extends Collection<E>,
        I extends Immutable<E, C, I, M>,
        M extends Mutable<E, C, M, I>>
        extends Value.Immutable<C, I, M>, CollectionValue<E, C> {


        /**
         * Creates a new {@link CollectionValue.Immutable} with the given values
         * along with any pre-existing values within this value.
         *
         * @param elements The values to add
         * @return The new value
         */
        I withElement(E elements);

        /**
         * Creates a new {@link CollectionValue.Immutable} with the given elements
         * along with any pre-existing values within this value.
         *
         * @see Collection#addAll(Collection)
         *
         * @param elements The elements to add
         * @return The new value
         */
        I withAll(Iterable<E> elements);

        /**
         * Creates a new {@link CollectionValue.Immutable} without the given
         * <code>E</code> element.
         *
         * @param element The element to exclude
         * @return The new value
         */
        I without(E element);

        /**
         * Creates a new {@link CollectionValue.Immutable} without the given
         * elements of the provided {@link Iterable}.
         *
         * @param elements The elements to exclude
         * @return The new value
         */
        I withoutAll(Iterable<E> elements);

        /**
         * Creates a new {@link CollectionValue.Immutable} with elements that
         * when the given {@link Predicate} is {@link Predicate#test(Object)} on
         * the element and {@code true} is returned, the element will remain in the
         * new {@link CollectionValue.Immutable}.
         *
         * @param predicate The predicte to apply
         * @return The new value
         */
        I withoutAll(Predicate<E> predicate);

        /**
         * Checks if all of the given elements in the provided {@link Iterable} are
         * contained within the backed {@link Collection}.
         *
         * @param iterable The iterable elements
         * @return True if all elements are contained within the backed collection
         */
        boolean containsAll(Iterable<E> iterable);

    }

    /**
     * Represents a {@link Value.Mutable} that is backed by a {@link Collection} of
     * elements.
     *
     * @param <E> The type of element
     * @param <C> The type of collection, for chaining
     * @param <V> The type of {@linkplain CollectionValue.Mutable}
     * @param <I> The type of {@link CollectionValue.Immutable}
     */
    interface Mutable<E,
        C extends Collection<E>,
        V extends Mutable<E, C, V, I>,
        I extends Immutable<E, C, I, V>>
        extends Value.Mutable<C, V, I>, CollectionValue<E, C>, Iterable<E> {


        /**
         * Adds the given {@code element} to this {@link CollectionValue.Mutable}.
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

        V filter(Predicate<? super E> predicate);

    }
}
