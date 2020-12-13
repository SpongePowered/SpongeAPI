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
package org.spongepowered.api.data;

import io.leangen.geantyref.TypeToken;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.function.BiFunction;
import java.util.function.Function;

public interface ImmutableDataProviderBuilder<H extends DataHolder, V extends Value<E>, E> extends ResettableBuilder<DataProvider<Value<E>, E>, ImmutableDataProviderBuilder<H, V, E>> {

    <NV extends Value<NE>, NE> ImmutableDataProviderBuilder<H, NV, NE> key(Key<NV> key);
    <NH extends H> ImmutableDataProviderBuilder<NH, V, E> dataHolder(TypeToken<NH> holder);
    <NH extends H> ImmutableDataProviderBuilder<NH, V, E> dataHolder(Class<NH> holder);

    ImmutableDataProviderBuilder<H, V, E> get(Function<H, E> get);
    ImmutableDataProviderBuilder<H, V, E> set(BiFunction<H, E, H> set);

    ImmutableDataProviderBuilder<H, V, E> supports(final Function<H, Boolean> supports);

    DataProvider<? extends Value<E>, E> build();


}
