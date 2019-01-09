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

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.immutable.ImmutableVariantData;
import org.spongepowered.api.data.manipulator.mutable.VariantData;
import org.spongepowered.api.data.value.mutable.Value;

/**
 * An abstract {@link VariantData} implementation providing all implementation
 * requirements, except {@link #asImmutable()}.
 *
 * @param <T> The type of catalog type
 * @param <M> The manipulator type
 * @param <I> The immutable manipulator type
 */
public abstract class AbstractSingleCatalogData<T extends CatalogType, M extends VariantData<T, M, I>, I extends ImmutableVariantData<T, I, M>>
        extends AbstractSingleData<T, M, I> implements VariantData<T, M, I> {

    /**
     * @deprecated Use {@link #AbstractSingleCatalogData(Key, CatalogType)} instead.
     */
    @Deprecated
    protected AbstractSingleCatalogData(T value, Key<Value<T>> usedKey) {
        super(value, usedKey);
    }

    protected AbstractSingleCatalogData(Key<Value<T>> usedKey, T value) {
        this(usedKey, value, value);
    }

    protected AbstractSingleCatalogData(Key<Value<T>> usedKey, T value, T defaultValue) {
        super(usedKey, value, defaultValue);
    }

    @Override
    protected Value<?> getValueGetter() {
        return type();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Value<T> type() {
        return Sponge.getRegistry().getValueFactory().createValue((Key<Value<T>>) this.usedKey, this.value, this.defaultValue);
    }

    @Override
    public DataContainer toContainer() {
        return super.toContainer();
    }
}
