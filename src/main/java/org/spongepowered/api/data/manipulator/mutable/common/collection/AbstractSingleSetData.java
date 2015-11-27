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

import com.google.common.collect.Sets;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.mutable.common.AbstractSingleData;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.mutable.SetValue;
import org.spongepowered.api.data.value.mutable.Value;

import java.util.Set;

/**
 * An abstract {@link DataManipulator} specifically dealing with a {@link Set}
 * type value.
 *
 * @param <E> The type of element within the set
 * @param <M> The manipulator type
 * @param <I> The immutable manipulator type
 */
public abstract class AbstractSingleSetData<E, M extends DataManipulator<M, I>, I extends ImmutableDataManipulator<I, M>>
    extends AbstractSingleData<Set<E>, M, I> {


    public AbstractSingleSetData(Set<E> value, Key<? extends BaseValue<Set<E>>> usedKey) {
        super(Sets.newHashSet(value), usedKey);
    }

    @Override
    protected Set<E> getValue() {
        return Sets.newHashSet(super.getValue());
    }

    @Override
    protected M setValue(Set<E> value) {
        return super.setValue(Sets.newHashSet(value));
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Value<?> getValueGetter() {
        return Sponge.getRegistry().getValueFactory().createSetValue((Key<SetValue<E>>) this.usedKey, this.getValue());
    }

}
