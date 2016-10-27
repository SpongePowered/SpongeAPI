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

import java.util.Optional;
import java.util.Set;

/**
 * An abstract implementation of an {@link ImmutableDataManipulator} that
 * specificaly deals with a single value.
 *
 * @param <T> The type of value
 * @param <I> The type of immutable manipulator
 * @param <M> The type of mutable manipulator
 * @deprecated These classes are only to be used for easing the compatibility requirements
 * for plugin developers moving to the new system introduced by
 * {@link org.spongepowered.api.data.manipulator.generator.CustomDataProvider}. It is highly
 * recommended to move towards the data provider system as all implementation classes provided
 * by the API will be removed in the next major version (API 7.0.0).
 */
@Deprecated
public abstract class AbstractImmutableSingleData<T, I extends ImmutableDataManipulator<I, M>, M extends DataManipulator<M, I>>
        extends AbstractImmutableData<I, M> {

    protected final Key<? extends BaseValue<T>> usedKey;
    protected final T value;

    protected AbstractImmutableSingleData(T value, Key<? extends BaseValue<T>> usedKey) {
        super();
        this.value = checkNotNull(value);
        this.usedKey = checkNotNull(usedKey, "Hey, the key provided is null! Please make sure it is registered!");
        registerGetters();
    }

    @Deprecated
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
        return checkNotNull(key).equals(this.usedKey) ? Optional.of((E) this.value) : Optional.<E>empty();
    }

    @Override
    public boolean supports(Key<?> key) {
        return checkNotNull(key) == this.usedKey;
    }

    @Override
    public Set<Key<?>> getKeys() {
        return ImmutableSet.<Key<?>>of(this.usedKey);
    }

}
