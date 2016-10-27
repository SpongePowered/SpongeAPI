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
package org.spongepowered.api.data.manipulator.immutable.common;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.value.immutable.ImmutableBoundedValue;
import org.spongepowered.api.data.value.mutable.MutableBoundedValue;
import org.spongepowered.api.data.value.mutable.Value;

import java.util.Comparator;

/**
 * An abstracted {@link ImmutableDataManipulator} that focuses solely on an
 * {@link ImmutableBoundedValue} as it's {@link Value} return type.
 *
 * @param <T> The type of comparable element
 * @param <I> The immutable data manipulator type
 * @param <M> The mutable data manipulator type
 * @deprecated These classes are only to be used for easing the compatibility requirements
 * for plugin developers moving to the new system introduced by
 * {@link org.spongepowered.api.data.manipulator.generator.CustomDataProvider}. It is highly
 * recommended to move towards the data provider system as all implementation classes provided
 * by the API will be removed in the next major version (API 7.0.0).
 */
@Deprecated
public abstract class AbstractImmutableBoundedComparableData<T extends Comparable<T>, I extends ImmutableDataManipulator<I, M>,
    M extends DataManipulator<M, I>> extends AbstractImmutableSingleData<T, I, M> {

    protected final Comparator<T> comparator;
    protected final T lowerBound;
    protected final T upperBound;
    protected final T defaultValue;
    private final ImmutableBoundedValue<T> immutableBoundedValue;

    @SuppressWarnings("unchecked")
    protected AbstractImmutableBoundedComparableData(T value, Key<MutableBoundedValue<T>> usedKey,
                                                     Comparator<T> comparator, T lowerBound,
                                                     T upperBound, T defaultValue) {
        super(value, usedKey);
        this.comparator = comparator;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.defaultValue = defaultValue;
        this.immutableBoundedValue = Sponge.getRegistry().getValueFactory()
            .createBoundedValueBuilder((Key<MutableBoundedValue<T>>) this.usedKey)
            .defaultValue(this.defaultValue)
            .actualValue(this.value)
            .minimum(this.lowerBound)
            .maximum(this.upperBound)
            .comparator(this.comparator)
            .build()
            .asImmutable();
    }

    @Override
    protected final ImmutableBoundedValue<T> getValueGetter() {
        return this.immutableBoundedValue;
    }

}
