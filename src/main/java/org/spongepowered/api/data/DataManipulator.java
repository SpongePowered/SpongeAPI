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
package org.spongepowered.api.data;

import com.google.common.base.Optional;
import org.spongepowered.api.util.annotation.TransformWith;

/**
 * Represents a changelist of data that can be applied to a {@link DataHolder}.
 * With a {@link DataManipulator}, specific sets of mutable data can be
 * represented and changed outside the live state of the {@link DataHolder}.
 *
 * <p>{@link DataManipulator}s are serializable such that they can be serialized
 * and deserialized from persistence, and applied to {@link DataHolder}s with
 * respects to their {@link DataPriority}.</p>
 *
 * @param <T> The type of {@link DataManipulator} for comparisons
 */
public interface DataManipulator<T extends DataManipulator<T>> extends Comparable<T>, DataSerializable {

    /**
     * Attempts to read data from the given {@link DataHolder} and constructs
     * a new copy of this {@link DataManipulator} as an instance of
     * <code>T</code>. Any data that overlaps between this and the given
     * {@link DataHolder} will be resolved by a default
     * {@link DataPriority#PRE_MERGE} such that the current data from this
     * {@link DataManipulator} will be applied before the existing data from
     * the {@link DataHolder}.
     *
     * <p>Any data that overlaps existing data from the {@link DataHolder} will
     * take priority and be overwriten from the pre-existing data from the
     * {@link DataHolder}. It is recommended that a call from
     * {@link DataHolder#isCompatible(Class)} is checked prior to using this
     * method on any {@link DataHolder}.</p>
     *
     * @param dataHolder The {@link DataHolder} to extract data
     * @return This {@link DataManipulator} with relevant data filled from the
     *     given {@link DataHolder}, if compatible
     */
    Optional<T> fill(DataHolder dataHolder);

    /**
     * Attempts to read data from the given {@link DataHolder} and constructs
     * a new copy of this {@link DataManipulator} as an instance of
     * <code>T</code>. Any data that overlaps between this and the given
     * {@link DataHolder} will be resolved using the given
     * {@link DataPriority}.
     *
     * <p>Any data that overlaps existing data from the {@link DataHolder} will
     * take priority and be overwriten from the pre-existing data from the
     * {@link DataHolder}. It is recommended that a call from
     * {@link DataHolder#isCompatible(Class)} is checked prior to using this
     * method on any {@link DataHolder}.</p>
     *
     * @param dataHolder The {@link DataHolder} to extract data
     * @param overlap The overlap resolver to decide which data to retain
     * @return This {@link DataManipulator} with relevant data filled from the
     *     given {@link DataHolder}, if compatible
     */
    Optional<T> fill(DataHolder dataHolder, DataPriority overlap);

    /**
     * Attempts to read the raw data from the provided {@link DataContainer}.
     * This manipulator should be "reset" to a default state and apply all data
     * from the given {@link DataContainer}. If data is missing from the
     * {@link DataContainer}, {@link Optional#absent()} can be returned.
     *
     * @param container The container of raw data
     * @return This {@link DataManipulator} with relevant data filled from the
     *     given {@link DataContainer}, if compatible
     */
    Optional<T> from(DataContainer container);

    /**
     * Creates a copy of this {@link DataManipulator} and copies all data of
     * this manipulator into the new {@link DataManipulator}. This manipulator
     * is left unaffected.
     *
     * @return The new copy of this manipulator with all data copied
     */
    @TransformWith
    T copy();

}
