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
import org.spongepowered.api.util.weighted.TableEntry;
import org.spongepowered.api.util.weighted.WeightedTable;

import java.util.List;
import java.util.Random;

public interface WeightedCollectionValue<E> extends CollectionValue<TableEntry<E>, WeightedTable<E>>  {

    /**
     * Constructs a mutable {@link WeightedCollectionValue} of the appropriate type based
     * on the given {@link Key} and the element.
     *
     * @param key The key
     * @param element The element
     * @param <E> The element type
     * @return The constructed mutable value
     */
    static <E> WeightedCollectionValue.Mutable<E> mutableOf(Key<? extends WeightedCollectionValue<E>> key, WeightedTable<E> element) {
        return Value.mutableOf(key, element);
    }

    /**
     * Constructs an immutable {@link WeightedCollectionValue} of the appropriate type based
     * on the given {@link Key} and the element.
     *
     * @param key The key
     * @param element The element
     * @param <E> The element type
     * @return The constructed immutable value
     */
    static <E> WeightedCollectionValue.Immutable<E> immutableOf(Key<? extends WeightedCollectionValue<E>> key, WeightedTable<E> element) {
        return Value.immutableOf(key, element);
    }

    @Override
    Key<? extends WeightedCollectionValue<E>> getKey();

    /**
     * Selects random valued from this list based on their weight.
     *
     * <p>An empty list will be returned if there are no
     * entries in the weighted table.</p>
     *
     * @param random The random object to use for selection
     * @return The selected values
     */
    List<E> get(Random random);

    @Override
    WeightedCollectionValue.Mutable<E> asMutable();

    @Override
    WeightedCollectionValue.Mutable<E> asMutableCopy();

    @Override
    WeightedCollectionValue.Immutable<E> asImmutable();

    /**
     * Represents a particular type of {@link org.spongepowered.api.data.value.CollectionValue.Immutable} that is
     * backed by a {@link WeightedTable}.
     *
     * @param <E> The type of weighted object
     */
    interface Immutable<E> extends WeightedCollectionValue<E>,
            CollectionValue.Immutable<TableEntry<E>, WeightedTable<E>, Immutable<E>, Mutable<E>> {

        @Override
        WeightedCollectionValue.Mutable<E> asMutable();

        @Override
        default WeightedCollectionValue.Mutable<E> asMutableCopy() {
            return asMutable();
        }

        @Override
        default WeightedCollectionValue.Immutable<E> asImmutable() {
            return this;
        }
    }

    /**
     * Represents a particular type of {@link org.spongepowered.api.data.value.CollectionValue.Mutable} that is backed by
     * a {@link WeightedTable}.
     *
     * @param <E> The type of weighted object
     */
    interface Mutable<E> extends WeightedCollectionValue<E>,
            CollectionValue.Mutable<TableEntry<E>, WeightedTable<E>, Mutable<E>, Immutable<E>> {

        @Override
        default WeightedCollectionValue.Mutable<E> asMutable() {
            return this;
        }

        @Override
        default WeightedCollectionValue.Mutable<E> asMutableCopy() {
            return copy();
        }

        @Override
        WeightedCollectionValue.Immutable<E> asImmutable();
    }
}
