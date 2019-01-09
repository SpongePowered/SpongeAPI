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
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.mutable.Value;

/**
 * An abstract implementation of an {@link ImmutableDataManipulator} handling
 * specifically a {@code boolean} value. Technically these can be cached since
 * their values are immutable.
 *
 * @param <I> The immutable manipulator type
 * @param <M> The mutable manipulator type
 */
public abstract class AbstractImmutableBooleanData<I extends ImmutableDataManipulator<I, M>, M extends DataManipulator<M, I>> extends
        AbstractImmutableSingleData<Boolean, I, M> {

    private final ImmutableValue<Boolean> immutableValue;

    /**
     * @deprecated Use {@link #AbstractImmutableBooleanData(Key, boolean, boolean)} instead.
     */
    @Deprecated
    protected AbstractImmutableBooleanData(boolean value, Key<Value<Boolean>> usedKey, boolean defaultValue) {
        this(usedKey, value, defaultValue);
    }

    protected AbstractImmutableBooleanData(Key<Value<Boolean>> usedKey, boolean value) {
        this(usedKey, value, value);
    }

    protected AbstractImmutableBooleanData(Key<Value<Boolean>> usedKey, boolean value, boolean defaultValue) {
        super(usedKey, value, defaultValue);
        this.immutableValue = Sponge.getRegistry().getValueFactory().createValue(usedKey, value, defaultValue).asImmutable();
    }

    @Override
    protected final ImmutableValue<Boolean> getValueGetter() {
        return this.immutableValue;
    }
}
