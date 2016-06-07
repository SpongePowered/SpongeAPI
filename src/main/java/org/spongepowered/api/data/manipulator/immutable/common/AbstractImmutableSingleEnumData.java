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

    private final E defaultValue;
    private final ImmutableValue<E> cachedValue;

    protected AbstractImmutableSingleEnumData(E value, E defaultValue, Key<Value<E>> usedKey) {
        super(value, usedKey);
        this.defaultValue = defaultValue;
        this.cachedValue = Sponge.getRegistry().getValueFactory().createValue(usedKey, this.defaultValue, this.value).asImmutable();
    }

    protected final ImmutableValue<E> enumType() {
        return this.cachedValue;
    }

    @Override
    protected final ImmutableValue<E> getValueGetter() {
        return this.cachedValue;
    }

    @Override
    public int compareTo(I o) {
        return o.get(this.usedKey).get().ordinal() - this.value.ordinal();
    }

    @Override
    public DataContainer toContainer() {
        return super.toContainer()
                .set(this.usedKey.getQuery(), this.value.name());
    }
}
