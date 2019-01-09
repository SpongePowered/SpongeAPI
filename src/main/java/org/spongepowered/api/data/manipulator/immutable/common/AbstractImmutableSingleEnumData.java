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
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.mutable.Value;

/**
 * An abstract implementation of an {@link ImmutableDataManipulator} dealing
 * specifically with an {@link Enum} value. Note that due to the limitations
 * of adding new values to an {@code Enum}, these may be cached.
 *
 * @param <E> The enum type
 * @param <I> The immutable manipulator type
 * @param <M> The mutable manipulator type
 */
public abstract class AbstractImmutableSingleEnumData<E extends Enum<E>, I extends ImmutableDataManipulator<I, M>, M extends DataManipulator<M, I>>
        extends AbstractImmutableSingleData<E, I, M> {

    private final ImmutableValue<E> cachedValue;

    /**
     * @deprecated Use {@link #AbstractImmutableSingleEnumData(Key, Enum, Enum)} instead.
     */
    @Deprecated
    protected AbstractImmutableSingleEnumData(E value, E defaultValue, Key<Value<E>> usedKey) {
        this(usedKey, value, defaultValue);
    }

    protected AbstractImmutableSingleEnumData(Key<Value<E>> usedKey, E value) {
        this(usedKey, value, value);
    }

    protected AbstractImmutableSingleEnumData(Key<Value<E>> usedKey, E value, E defaultValue) {
        super(usedKey, value, defaultValue);
        this.cachedValue = Sponge.getRegistry().getValueFactory().createValue(usedKey, value, defaultValue).asImmutable();
    }

    /**
     * @deprecated Use {@link #getValueGetter()} instead.
     */
    @Deprecated
    protected final ImmutableValue<E> enumType() {
        return this.cachedValue;
    }

    @Override
    protected final ImmutableValue<E> getValueGetter() {
        return this.cachedValue;
    }

    @Override
    public DataContainer toContainer() {
        return super.toContainer();
    }

    @Override
    protected DataContainer fillContainer(DataContainer dataContainer) {
        return dataContainer.set(this.usedKey.getQuery(), getValue().name());
    }
}
