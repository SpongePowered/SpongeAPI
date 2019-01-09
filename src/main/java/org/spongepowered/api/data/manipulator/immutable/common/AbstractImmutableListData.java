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

import com.google.common.collect.ImmutableList;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.immutable.ImmutableListData;
import org.spongepowered.api.data.manipulator.mutable.ListData;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.immutable.ImmutableListValue;
import org.spongepowered.api.data.value.mutable.ListValue;

import java.util.List;

import javax.annotation.Nullable;

public abstract class AbstractImmutableListData<E, I extends ImmutableListData<E, I, M>, M extends ListData<E, M, I>>
        extends AbstractImmutableSingleData<List<E>, I, M> implements ImmutableListData<E, I, M> {

    private final ImmutableListValue<E> listValue;

    /**
     * @deprecated Use {@link #AbstractImmutableListData(Key, List)} instead.
     */
    @Deprecated
    @SuppressWarnings("unchecked")
    protected AbstractImmutableListData(List<E> value, Key<? extends BaseValue<List<E>>> usedKey) {
        this((Key<ListValue<E>>) usedKey, value);
    }

    protected AbstractImmutableListData(Key<ListValue<E>> usedKey, List<E> value) {
        this(usedKey, value, value);
    }

    protected AbstractImmutableListData(Key<ListValue<E>> usedKey, List<E> value, List<E> defaultValue) {
        this(ImmutableList.copyOf(value), value == defaultValue ? null : ImmutableList.copyOf(defaultValue), usedKey);
    }

    private AbstractImmutableListData(List<E> value, @Nullable List<E> defaultValue, Key<ListValue<E>> usedKey) {
        super(usedKey, value, defaultValue == null ? value : defaultValue);
        this.listValue = Sponge.getRegistry().getValueFactory().createListValue(usedKey, value, this.defaultValue).asImmutable();
    }

    @Override
    protected final ImmutableListValue<E> getValueGetter() {
        return this.listValue;
    }

    @Override
    public ImmutableListValue<E> getListValue() {
        return getValueGetter();
    }

    @Override
    public List<E> asList() {
        return getValue();
    }
}
