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
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.immutable.ImmutableMappedData;
import org.spongepowered.api.data.manipulator.mutable.ListData;
import org.spongepowered.api.data.manipulator.mutable.MappedData;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.mutable.MapValue;
import org.spongepowered.api.util.CollectionUtils;

import java.util.Map;

/**
 * A common implementation for {@link ListData}s provided by the API.
 *
 * @param <K> The type of key in the map
 * @param <V> The type of value in the map
 * @param <M> The type of {@link DataManipulator}
 * @param <I> The type of {@link ImmutableDataManipulator}
 */
@SuppressWarnings("unchecked")
public abstract class AbstractMappedData<K, V, M extends MappedData<K, V, M, I>, I extends ImmutableMappedData<K, V, I, M>>
        extends AbstractSingleData<Map<K, V>, M, I> implements MappedData<K, V, M, I> {

    /**
     * @deprecated Use {@link #AbstractMappedData(Key, Map)} instead.
     */
    @Deprecated
    protected AbstractMappedData(Map<K, V> value, Key<? extends BaseValue<Map<K, V>>> usedKey) {
        this((Key<MapValue<K, V>>) usedKey, value);
    }

    protected AbstractMappedData(Key<MapValue<K, V>> usedKey, Map<K, V> value) {
        super(usedKey, CollectionUtils.copyMap(value));
    }

    protected AbstractMappedData(Key<MapValue<K, V>> usedKey, Map<K, V> value, Map<K, V> defaultValue) {
        super(usedKey, CollectionUtils.copyMap(value), CollectionUtils.copyMap(defaultValue));
    }

    @Override
    protected MapValue<K, V> getValueGetter() {
        return Sponge.getRegistry().getValueFactory().createMapValue(
                (Key<MapValue<K, V>>) this.usedKey, getValue(), CollectionUtils.copyMap(this.defaultValue));
    }

    @Override
    protected Map<K, V> getValue() {
        return CollectionUtils.copyMap(super.getValue());
    }

    @Override
    protected M setValue(Map<K, V> value) {
        return super.setValue(CollectionUtils.copyMap(value));
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public MapValue<K, V> getMapValue() {
        return getValueGetter();
    }

    @Override
    public Map<K, V> asMap() {
        return getValue();
    }
}
