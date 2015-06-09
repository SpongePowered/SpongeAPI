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

import org.spongepowered.api.data.value.immutable.ImmutableWeightedCollectionValue;
import org.spongepowered.api.util.weighted.WeightedCollection;
import org.spongepowered.api.util.weighted.WeightedObject;

import java.util.Random;

import javax.annotation.Nullable;

/**
 * Represents a particular type of {@link CollectionValue} that is backed by
 * a {@link WeightedCollection}.
 *
 * @param <E> The type of weighted object
 * @param <W> The type of extended weighted collection value
 * @param <I> The type of immutable weighted collection value
 */
public interface WeightedCollectionValue<E extends WeightedObject<?>, W extends WeightedCollectionValue<E, W, I>,
    I extends ImmutableWeightedCollectionValue<E, I, W>> extends CollectionValue<E, WeightedCollection<E>, W, I> {

    /**
     * Selects a random value from this list based on their weight.
     *
     * <p>If the list is empty then null will be returned.</p>
     *
     * @param random The random object to use for selection
     * @return The selected value
     */
    @Nullable
    E get(Random random);

}
