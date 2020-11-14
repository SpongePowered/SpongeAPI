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
import org.spongepowered.api.Server;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.event.data.ChangeDataHolderEvent;

import java.lang.reflect.Type;
import java.util.Optional;

@SuppressWarnings("unchecked")
public interface DataProvider<V extends Value<E>, E> {

    /**
     * Constructs a new {@link MutableDataProviderBuilder}.
     *
     * @return The builder
     */
    static <H extends DataHolder.Mutable, V extends Value<E>, E> MutableDataProviderBuilder<H, V, E> mutableBuilder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(MutableDataProviderBuilder.class);
    }

    /**
     * Constructs a new {@link ImmutableDataProviderBuilder}.
     *
     * @return The builder
     */
    static <H extends DataHolder, V extends Value<E>, E> ImmutableDataProviderBuilder<H, V, E> immutableBuilder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(ImmutableDataProviderBuilder.class);
    }

    /**
     * Gets the {@link Key} this provider supports.
     *
     * @return The key
     */
    Key<V> getKey();

    /**
     * Gets whether this provider will allow asynchronous access for retrieving
     * and storing value changes through the API and implementation. This is
     * usually sanity checked by the implementation through a simplified
     * {@link Server#onMainThread()} as a majority of datas are required to be
     * synchronous if the changes can end up throwing {@link ChangeDataHolderEvent}s.
     *
     * <p>A list of methods that are constrained by this check are:
     * <ul>
     *     <li>- {@link #get(DataHolder)}</li>
     *     <li>- {@link #offer(DataHolder.Mutable, Object)}</li>
     *     <li>- {@link #remove(DataHolder.Mutable)}</li>
     * </ul>
     * Conceptually, an immutable {@link DataHolder} will be ignorant of
     * asynchronous access, however, some cases may exist where attempting to
     * create new immutable  variants with different values can be still limited
     * by synchronous access.
     *
     * @param dataHolder The data holder
     * @return True if this provider allows asynchronous access
     */
    boolean allowsAsynchronousAccess(DataHolder dataHolder);

    /**
     * Gets the elemental value from the provided {@link DataHolder}. This is
     * generally considered the underlying implementation access for any
     * {@link DataHolder#get(Key)} where the {@link Key} is registered with
     * this {@link DataProvider}. Nominally, this means the data is provided
     * outside traditional serialized data that is stored with the
     * {@link DataHolder}. It's possible that there may be changing return values
     * for even immutable types, since the provider is providing the data.
     *
     * @param dataHolder The data holder
     * @return The value, if it's supported and exists
     */
    Optional<E> get(DataHolder dataHolder);

    /**
     * Gets a constructed {@link Value} for the provided {@link DataHolder}.
     * Much like {@link #get(DataHolder)}, this is generally considered the
     * underlying implementation access for any {@link DataHolder#get(Key)}
     * where the {@link Key} is registered with this {@link DataProvider}.
     * Nominally, this means the data is provided outside traditional serialized
     * data that is stored with the {@link DataHolder}. It's possible that there
     * may be changing return values for even immutable types, since the
     * provider is providing the data.
     *
     * @param dataHolder The data holder to get the constructed value from
     * @return The value
     */
    default Optional<V> getValue(DataHolder dataHolder) {
        return this.get(dataHolder).map(element -> Value.genericMutableOf(this.getKey(), element));
    }

    /**
     * Gets whether this value provider is supported by the given {@link ValueContainer}.
     *
     * @param dataHolder The data holder
     * @return Whether it's supported
     */
    boolean isSupported(DataHolder dataHolder);

    default boolean isSupported(final TypeToken<? extends DataHolder> dataHolder) {
        return isSupported(dataHolder.getType());
    }

    boolean isSupported(Type dataHolder);

    DataTransactionResult offer(DataHolder.Mutable dataHolder, E element);

    default DataTransactionResult offerValue(DataHolder.Mutable dataHolder, V value) {
        return this.offer(dataHolder, value.get());
    }

    DataTransactionResult remove(DataHolder.Mutable dataHolder);

    <I extends DataHolder.Immutable<I>> Optional<I> with(I immutable, E element);

    default <I extends DataHolder.Immutable<I>> Optional<I> withValue(I immutable, V value) {
        return this.with(immutable, value.get());
    }

    /**
     * Gets a {@link DataHolder.Immutable} without
     * a {@link Value} with the target {@link Key}, if successful.
     *
     * @param immutable The immutable value store
     * @param <I> The type of the immutable value store
     * @return The new value store, if successful
     */
    <I extends DataHolder.Immutable<I>> Optional<I> without(I immutable);

}
