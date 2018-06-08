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

import org.spongepowered.api.data.value.immutable.ImmutableWeightedCollectionValue;
import org.spongepowered.api.data.value.mutable.MutableWeightedCollectionValue;
import org.spongepowered.api.util.weighted.TableEntry;
import org.spongepowered.api.util.weighted.WeightedTable;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

public interface WeightedCollectionValue<E> extends CollectionValue<TableEntry<E>, WeightedTable<E>>  {

    /**
     * Selects a random value from this list based on their weight.
     *
     * <p>If the list is empty then null will be returned.</p>
     *
     * @param random The random object to use for selection
     * @return The selected value
     */
    @Nullable
    List<E> get(Random random);

    @Override
    MutableWeightedCollectionValue<E> asMutable();

    @Override
    ImmutableWeightedCollectionValue<E> asImmutable();
}
