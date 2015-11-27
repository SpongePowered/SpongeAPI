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
package org.spongepowered.api.data.manipulator.mutable.common.collection;

import com.google.common.collect.Maps;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.mutable.common.AbstractSingleData;
import org.spongepowered.api.data.value.mutable.MapValue;
import org.spongepowered.api.data.value.mutable.Value;

import java.util.Map;

/**
 * An abstract implementation of a {@link DataManipulator} that deals with a
 * {@link Map} value.
 *
 * @param <K> The key type of the map
 * @param <V> The value type of the map
 * @param <M> The manipulator type
 * @param <I> The immutable manipulator type
 */
public abstract class AbstractSingleMapData<K, V, M extends DataManipulator<M, I>, I extends ImmutableDataManipulator<I, M>>
    extends AbstractSingleData<Map<K, V>, M, I> {

    protected AbstractSingleMapData(Map<K, V> value, Key<MapValue<K, V>> usedKey) {
        super(Maps.newHashMap(value), usedKey);
    }

    @Override
    protected Map<K, V> getValue() {
        return Maps.newHashMap(super.getValue());
    }

    @Override
    protected M setValue(Map<K, V> value) {
        return super.setValue(Maps.newHashMap(value));
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Value<?> getValueGetter() {
        return Sponge.getRegistry().getValueFactory().createMapValue((Key<MapValue<K, V>>) this.usedKey, this.getValue());
    }

}
