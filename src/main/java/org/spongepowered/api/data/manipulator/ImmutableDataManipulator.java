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
package org.spongepowered.api.data.manipulator;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.merge.MergeFunction;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.mutable.Value;

/**
 * An {@code ImmutableDataManipulator} is an immutable {@link ValueContainer}
 * such that once it is created, any {@link BaseValue}s exist as
 * {@link ImmutableValue}s. Any modification methods result in new instances of
 * the same typed {@link ImmutableDataManipulator}.
 *
 * <p>As with {@link DataManipulator}, it is always possible to translate back
 * and forth between mutable and immutable with {@link #asMutable()} and
 * {@link DataManipulator#asImmutable()}.</p>
 *
 * @param <I> The type of immutable data manipulator
 * @param <M> The type of mutable data manipulator
 */
public interface ImmutableDataManipulator<I extends ImmutableDataManipulator<I, M>, M extends DataManipulator<M, I>> extends Comparable<I>,
                                                                                                                             DataSerializable,
                                                                                                                             ValueContainer<I> {
    /**
     * Attempts to read data from the given {@link DataHolder} and constructs
     * a new copy of this {@link DataManipulator} as an instance of
     * <code>T</code>.
     *
     * <p>Any data that overlaps existing data from the {@link DataHolder} will
     * take priority and be overwriten from the pre-existing data from the
     * {@link DataHolder}. It is recommended that a call from
     * {@link DataHolder#supports(Class)} is checked prior to using this
     * method on any {@link DataHolder}.</p>
     *
     * @param dataHolder The {@link DataHolder} to extract data
     * @return A new {@link ImmutableDataManipulator} with all the merged data
     */
    Optional<I> fill(DataHolder dataHolder);

    /**
     * Attempts to read data from the given {@link DataHolder} and constructs
     * a new copy of this {@link DataManipulator} as an instance of
     * <code>T</code>. Any data that overlaps between this and the given
     * {@link DataHolder} will be resolved using the given
     * {@link MergeFunction}.
     *
     * <p>Any data that overlaps existing data from the {@link DataHolder} will
     * take priority and be overwriten from the pre-existing data from the
     * {@link DataHolder}. It is recommended that a call from
     * {@link DataHolder#supports(Class)} is checked prior to using this
     * method on any {@link DataHolder}.</p>
     *
     * @param dataHolder The {@link DataHolder} to extract data
     * @param overlap The overlap resolver to decide which data to retain
     * @return A new {@link ImmutableDataManipulator} with all the merged data
     */
    Optional<I> fill(DataHolder dataHolder, MergeFunction overlap);

    /**
     * Attempts to read the raw data from the provided {@link DataContainer}.
     * This manipulator should be "reset" to a default state and apply all data
     * from the given {@link DataContainer}. If data is missing from the
     * {@link DataContainer}, {@link Optional#absent()} can be returned.
     *
     * @param container The container of raw data
     * @return A new {@link ImmutableDataManipulator} with all the merged data
     */
    Optional<I> from(DataContainer container);

    /**
     * Creates a new {@link ImmutableDataManipulator} with the provided value
     * if the {@link Key} is supported by this {@link ImmutableDataManipulator}
     * without exception.
     *
     * @param key The key to use
     * @param value The value to set
     * @param <E> The type of value
     * @return The new immutable data manipulator, if compatible
     */
    <E> Optional<I> with(Key<? extends BaseValue<E>> key, E value);

    /**
     * Creates a new {@link ImmutableDataManipulator} with the provided
     * {@link BaseValue} provided that the {@link BaseValue} is supported by
     * this {@link ImmutableDataManipulator}. A simple check can be called for
     * {@link #supports(BaseValue)} prior to ensure
     * {@link Optional#isPresent()} returns {@code true}.
     *
     * @param value The value to set
     * @return The new immutable data manipulator, if compatible
     */
    Optional<I> with(BaseValue<?> value);

    @Override
    I copy();

    /**
     * Gets a {@link DataManipulator} copy of this
     * {@link ImmutableDataManipulator} such that all backed
     * {@link ImmutableValue}s are copied into their {@link Value}
     * counterparts. Any changes to this {@link ImmutableDataManipulator} will
     * NOT be reflected on the returned {@link DataManipulator} and vice versa.
     *
     * @return This {@link ImmutableDataManipulator}'s data copied into a
     *     {@link DataManipulator}
     */
    M asMutable();

}
