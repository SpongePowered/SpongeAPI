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

import com.google.common.collect.ImmutableSet;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.mutable.Value;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * An abstract implementation of an {@link ImmutableDataManipulator} that
 * specifically deals with a single value.
 *
 * @param <T> The type of value
 * @param <I> The type of immutable manipulator
 * @param <M> The type of mutable manipulator
 */
public abstract class AbstractImmutableSingleData<T, I extends ImmutableDataManipulator<I, M>, M extends DataManipulator<M, I>>
        extends AbstractImmutableData<I, M> {

    protected final Key<? extends BaseValue<T>> usedKey;
    protected final T value;
    protected final T defaultValue;

    /**
     * @deprecated Use {@link #AbstractImmutableSingleData(Key, Object)} instead.
     */
    @Deprecated
    @SuppressWarnings("unchecked")
    protected AbstractImmutableSingleData(T value, Key<? extends BaseValue<T>> usedKey) {
        this((Key<? extends Value<T>>) usedKey, value, value);
    }

    protected AbstractImmutableSingleData(Key<? extends Value<T>> usedKey, T value) {
        this(usedKey, value, value);
    }

    protected AbstractImmutableSingleData(Key<? extends Value<T>> usedKey, T value, T defaultValue) {
        this.value = checkNotNull(value, "value");
        this.defaultValue = checkNotNull(defaultValue, "defaultValue");
        this.usedKey = checkNotNull(usedKey, "usedKey");
        registerGetters();
    }

    protected abstract ImmutableValue<?> getValueGetter();

    protected final T getValue() {
        return this.value;
    }

    @Override
    public abstract M asMutable();

    @Override
    protected final void registerGetters() {
        registerFieldGetter(this.usedKey, AbstractImmutableSingleData.this::getValue);
        registerKeyValue(this.usedKey, AbstractImmutableSingleData.this::getValueGetter);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <E> Optional<E> get(Key<? extends BaseValue<E>> key) {
        return checkNotNull(key).equals(this.usedKey) ? Optional.of((E) this.value) : Optional.empty();
    }

    @Override
    public boolean supports(Key<?> key) {
        return checkNotNull(key) == this.usedKey;
    }

    @Override
    public Set<Key<?>> getKeys() {
        return ImmutableSet.of(this.usedKey);
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + Objects.hashCode(this.value);
        hash = 31 * hash + Objects.hashCode(this.defaultValue);
        return hash;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        final AbstractImmutableSingleData other = (AbstractImmutableSingleData) obj;
        return Objects.equals(this.value, other.value) &&
                Objects.equals(this.defaultValue, other.defaultValue);
    }
}
