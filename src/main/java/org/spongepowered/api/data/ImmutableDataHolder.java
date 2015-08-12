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

import com.google.common.collect.ImmutableCollection;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.immutable.ImmutableValueStore;

/**
 * A type of {@link DataHolder} variant that is completely immutable once
 * constructed. The advantage of an {@link ImmutableDataHolder} is that it can
 * be processed without worry of mutating any existing {@link BaseValue}s
 * belonging to this {@link ImmutableDataHolder}. It should be considered that
 * an {@link ImmutableDataHolder} is considered "safe" to process
 * asynchronously as all {@link BaseValue}s are copied into
 * {@link ImmutableValue} counterparts.
 *
 * @see DataHolder
 * @param <T> The sub type of immutable data holder
 */
public interface ImmutableDataHolder<T extends ImmutableDataHolder<T>> extends DataSerializable,
                                                                               ImmutableValueStore<T, ImmutableDataManipulator<?, ?>> {

    /**
     * Get a copy of all properties defined on this
     * {@link ImmutableDataHolder}, with their current values.
     *
     * @return A collection of all known manipulators
     */
    ImmutableCollection<ImmutableDataManipulator<?, ?>> getManipulators();

}
