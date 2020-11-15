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

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public interface MutableDataProviderBuilder<H extends DataHolder.Mutable, V extends Value<E>, E> extends ResettableBuilder<DataProvider<Value<E>, E>, MutableDataProviderBuilder<H, V, E>> {

    <NV extends Value<NE>, NE> MutableDataProviderBuilder<H, NV, NE> key(Key<NV> key);
    <NH extends H> MutableDataProviderBuilder<NH, V, E> dataHolder(TypeToken<NH> holder);
    <NH extends H> MutableDataProviderBuilder<NH, V, E> dataHolder(Class<NH> holder);

    MutableDataProviderBuilder<H, V, E> get(Function<H, E> get);
    MutableDataProviderBuilder<H, V, E> set(BiConsumer<H, E> set);
    MutableDataProviderBuilder<H, V, E> setAnd(BiFunction<H, E, Boolean> setAnd);
    MutableDataProviderBuilder<H, V, E> delete(Consumer<H> delete);
    MutableDataProviderBuilder<H, V, E> deleteAnd(Function<H, Boolean> delete);
    MutableDataProviderBuilder<H, V, E> deleteAndGet(Function<H, DataTransactionResult> delete);
    MutableDataProviderBuilder<H, V, E> resetOnDelete(Supplier<E> resetOnDeleteTo);
    MutableDataProviderBuilder<H, V, E> resetOnDelete(Function<H, E> resetOnDeleteTo);
    MutableDataProviderBuilder<H, V, E> setAndGet(BiFunction<H, E, DataTransactionResult> setAndGet);

    MutableDataProviderBuilder<H, V, E> supports(final Function<H, Boolean> supports);

    DataProvider<V, E> build();
}
