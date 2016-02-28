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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableMap;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.immutable.ImmutableMappedData;
import org.spongepowered.api.data.manipulator.mutable.MappedData;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.immutable.ImmutableMapValue;
import org.spongepowered.api.data.value.mutable.MapValue;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public abstract class AbstractImmutableMappedData<K, V, I extends ImmutableMappedData<K, V, I, M>, M extends MappedData<K, V, M, I>>
    extends AbstractImmutableSingleData<Map<K, V>, I, M> implements ImmutableMappedData<K, V, I, M> {

    private final ImmutableMapValue<K, V> mapValue;

    @SuppressWarnings("unchecked")
    protected AbstractImmutableMappedData(Map<K, V> value, Key<? extends BaseValue<Map<K, V>>> usedKey) {
        super(ImmutableMap.copyOf(value), usedKey);
        this.mapValue = Sponge.getRegistry().getValueFactory().createMapValue((Key<MapValue<K, V>>) this.usedKey, this.value).asImmutable();
    }

    @Override
    protected final ImmutableMapValue<K, V> getValueGetter() {
        return this.mapValue;
    }

    @Override
    public int compareTo(I o) {
        final Map<K, V> thisMap = getValue();
        final Map<K, V> otherMap = o.asMap();
        final Set<K> thisKeySet = thisMap.keySet();
        final Set<K> otherKeySet = otherMap.keySet();
        final Collection<V> thisValueSet = thisMap.values();
        final Collection<V> otherValueSet = otherMap.values();
        return ComparisonChain.start()
            .compare(thisKeySet.containsAll(otherKeySet), otherKeySet.containsAll(thisKeySet))
            .compare(thisValueSet.containsAll(otherValueSet), otherValueSet.containsAll(thisValueSet))
            .result();
    }

    @Override
    public Optional<V> get(K key) {
        return Optional.ofNullable(super.getValue().get(checkNotNull(key, "Key cannot be null!")));
    }

    @Override
    public Set<K> getMapKeys() {
        return super.getValue().keySet();
    }

    @Override
    public ImmutableMapValue<K, V> getMapValue() {
        return this.mapValue;
    }
}
