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
package org.spongepowered.api.data.manipulator.immutable.common.collection;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableSet;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableSingleData;
import org.spongepowered.api.data.value.immutable.ImmutableSetValue;
import org.spongepowered.api.data.value.mutable.SetValue;

import java.util.Set;

public abstract class AbstractImmutableSingleSetData<E, I extends ImmutableDataManipulator<I, M>, M extends DataManipulator<M, I>>
    extends AbstractImmutableSingleData<Set<E>, I, M> {

    private final ImmutableSetValue<E> setValue;

    public AbstractImmutableSingleSetData(Set<E> value, Key<SetValue<E>> usedKey) {
        super(ImmutableSet.copyOf(value), usedKey);
        this.setValue = Sponge.getRegistry().getValueFactory().createSetValue(usedKey, this.value).asImmutable();
    }

    @Override
    protected ImmutableSetValue<E> getValueGetter() {
        return this.setValue;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public int compareTo(I o) {
        return ComparisonChain.start()
            .compare(o.getValue((Key<SetValue<E>>) (Key) this.usedKey).get().get().containsAll(this.getValue()),
                     this.getValue().containsAll(o.getValue((Key<SetValue<E>>) (Key) this.usedKey).get().get()))
            .result();
    }
}
