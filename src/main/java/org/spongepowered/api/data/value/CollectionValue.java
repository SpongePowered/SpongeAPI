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

import org.spongepowered.api.data.value.immutable.ImmutableCollectionValue;
import org.spongepowered.api.data.value.mutable.MutableCollectionValue;

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
     * collection are not reflected to this {@link MutableCollectionValue}. Likewise,
     * no modifications to this {@link MutableCollectionValue} are reflected to the
     * returned {@link Collection}.
     *
     * @return A new collection with all elements copied
     */
    C getAll();

    @Override
    MutableCollectionValue<E, C, ?, ?> asMutable();

    @Override
    ImmutableCollectionValue<E, C, ?, ?> asImmutable();
}
