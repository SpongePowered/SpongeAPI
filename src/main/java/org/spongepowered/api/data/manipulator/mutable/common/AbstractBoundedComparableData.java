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
package org.spongepowered.api.data.manipulator.mutable.common;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.value.mutable.MutableBoundedValue;

import java.util.Comparator;

/**
 * An abstract implementation of a {@link DataManipulator} that deals
 * specifically with a {@link MutableBoundedValue}. Similar to
 * {@link AbstractSingleData} in that it focuses on a single value,
 * it adds the certainty that the value can only accept values of which
 * the bounds are met.
 *
 * @param <T> The type of comparable
 * @param <M> The API datamanipulator
 * @param <I> The API immutable data manipulator
 */
public abstract class AbstractBoundedComparableData<T extends Comparable<T>, M extends DataManipulator<M, I>, I
        extends ImmutableDataManipulator<I, M>> extends AbstractSingleData<T, M, I> {

    protected final Comparator<T> comparator;
    protected final T lowerBound;
    protected final T upperBound;
    protected final T defaultValue;

    protected AbstractBoundedComparableData(T value, Key<MutableBoundedValue<T>> usedKey, Comparator<T> comparator, T lowerBound, T upperBound,
                                            T defaultValue) {
        super(value, usedKey);
        this.comparator = checkNotNull(comparator);
        this.lowerBound = checkNotNull(lowerBound);
        this.upperBound = checkNotNull(upperBound);
        this.defaultValue = checkNotNull(defaultValue);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected MutableBoundedValue<T> getValueGetter() {
        return Sponge.getRegistry().getValueFactory()
            .createBoundedValueBuilder((Key<MutableBoundedValue<T>>) this.usedKey)
            .defaultValue(this.defaultValue)
            .comparator(this.comparator)
            .minimum(this.lowerBound)
            .maximum(this.upperBound)
            .actualValue(this.getValue())
            .build();
    }

    @Override
    public int compareTo(M o) {
        return this.comparator.compare(o.get(this.usedKey).get(), this.getValue());
    }

    @Override
    public M setValue(T value) {
        checkArgument(this.comparator.compare(this.lowerBound, value) >= 0);
        checkArgument(this.comparator.compare(this.upperBound, value) <= 0);
        return super.setValue(value);
    }

    @Override
    public DataContainer toContainer() {
        return super.toContainer()
                .set(this.usedKey.getQuery(), this.getValue());
    }
}
