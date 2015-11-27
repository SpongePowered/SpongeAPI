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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.mutable.common.AbstractSingleData;
import org.spongepowered.api.data.value.mutable.ListValue;

import java.util.List;

/**
 * An abstract {@link DataManipulator} focusing on a single value that is
 * represented as a {@link List}.
 *
 * @param <E> The type of element
 * @param <M> The manipulator class
 * @param <I> The immutable manipulator class
 */
public abstract class AbstractSingleListData<E, M extends DataManipulator<M, I>, I extends ImmutableDataManipulator<I, M>>
    extends AbstractSingleData<List<E>, M, I> {

    protected AbstractSingleListData(List<E> value, Key<ListValue<E>> usedKey) {
        super(Lists.newArrayList(value), usedKey);
    }

    @Override
    protected List<E> getValue() {
        return Lists.newArrayList(super.getValue());
    }

    @Override
    public M setValue(List<E> value) {
        checkNotNull(value).forEach(Preconditions::checkNotNull);
        return super.setValue(Lists.newArrayList(value));
    }

    @SuppressWarnings("unchecked")
    @Override
    protected ListValue<E> getValueGetter() {
        return Sponge.getRegistry().getValueFactory().createListValue((Key<ListValue<E>>) this.usedKey, getValue());
    }

    @Override
    public int compareTo(M o) {
        final List<E> list = o.get(this.usedKey).get();
        return Boolean.compare(list.containsAll(this.getValue()), this.getValue().containsAll(list));
    }
}
