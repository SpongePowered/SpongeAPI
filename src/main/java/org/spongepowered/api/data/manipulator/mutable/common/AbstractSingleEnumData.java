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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.mutable.Value;

/**
 * Another abstract helper class further simplifying implementing various
 * single value enum based {@link DataManipulator}s.
 *
 * @param <E> The type of enum value
 * @param <M> The manipulator type
 * @param <I> The immutable manipulator type
 */
public abstract class AbstractSingleEnumData<E extends Enum<E>, M extends DataManipulator<M, I>, I extends ImmutableDataManipulator<I, M>>
        extends AbstractSingleData<E, M, I> {

    /**
     * @deprecated Use {@link #AbstractSingleEnumData(Key, Enum, Enum)} instead.
     */
    @SuppressWarnings("unchecked")
    @Deprecated
    protected AbstractSingleEnumData(E value, Key<? extends BaseValue<E>> usedKey, E defaultValue) {
        this((Key<Value<E>>) usedKey, value, defaultValue);
    }

    protected AbstractSingleEnumData(Key<Value<E>> usedKey, E value) {
        this(usedKey, value, value);
    }

    protected AbstractSingleEnumData(Key<Value<E>> usedKey, E value, E defaultValue) {
        super(usedKey, value, defaultValue);
    }

    @Override
    public DataContainer toContainer() {
        return super.toContainer();
    }

    @Override
    protected DataContainer fillContainer(DataContainer dataContainer) {
        return dataContainer.set(this.usedKey.getQuery(), this.value.name());
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Value<E> getValueGetter() {
        return Sponge.getRegistry().getValueFactory().createValue((Key<Value<E>>) this.usedKey, this.value, this.defaultValue);
    }
}
