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

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.mutable.Value;

/**
 * An abstract {@link DataManipulator} dealing specifically with a
 * {@code boolean} value type.
 *
 * @param <M> The manipulator type
 * @param <I> The immutable manipulator type
 * @deprecated These classes are only to be used for easing the compatibility requirements
 * for plugin developers moving to the new system introduced by
 * {@link org.spongepowered.api.data.manipulator.generator.CustomDataProvider}. It is highly
 * recommended to move towards the data provider system as all implementation classes provided
 * by the API will be removed in the next major version (API 7.0.0).
 */
@Deprecated
public abstract class AbstractBooleanData<M extends DataManipulator<M, I>, I extends ImmutableDataManipulator<I, M>> extends
        AbstractSingleData<Boolean, M, I> {

    private final boolean defaultValue;

    protected AbstractBooleanData(boolean value, Key<? extends BaseValue<Boolean>> usedKey, boolean defaultValue) {
        super(value, usedKey);
        this.defaultValue = checkNotNull(defaultValue);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Value<Boolean> getValueGetter() {
        return Sponge.getRegistry().getValueFactory().createValue((Key<Value<Boolean>>) this.usedKey, this.getValue(), this.defaultValue);
    }

    @Override
    public DataContainer toContainer() {
        return super.toContainer()
                .set(this.usedKey.getQuery(), getValue());
    }
}
