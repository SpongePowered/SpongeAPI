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

import com.google.common.reflect.TypeToken;
import org.spongepowered.api.server.Server;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.event.data.ChangeDataHolderEvent;

import java.util.Optional;

public interface DataProvider<V extends Value<E>, E> {

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
     * </p>
     *
     * @param token The token of the {@link DataHolder} that is being requested
     * @return True if this provider allows asynchronous access
     */
    boolean allowsAsynchronousAccess(TypeToken<? extends DataHolder> token);

    /**
     * Gets the {@link Key} this provider supports.
     *
     * @return The key
     */
    Key<V> getKey();

    /**
     * Gets the elemental value from the provided {@link DataHolder}. This is
     * generally considered the underlying implementation access for any
     * {@link DataHolder#get(Key)} where the {@link Key} is registered with
     * this {@link DataProvider}. Nominally, this means the data is provided
     * outside traditional serialized data that is stored with the
     * {@link DataHolder}. It's possible that there may be changing return values
     * for even immutable types, since the provider is providing the data.
     *
     * @param container The dataholder
     * @return The value, if it's supported and exists
     */
    Optional<E> get(DataHolder container);

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
     * @param container The holder to get the constructed value from
     * @return The value
     */
    default Optional<V> getValue(DataHolder container) {
        return get(container).map(element -> Value.mutableOf(getKey(), element));
    }


    DataTransactionResult offer(DataHolder.Mutable container, E element);

    default DataTransactionResult offerValue(DataHolder.Mutable container, V value) {
        return offer(container, value.get());
    }

    DataTransactionResult remove(DataHolder.Mutable container);

    <I extends DataHolder.Immutable<I>> Optional<I> with(I immutable, E element);

    default <I extends DataHolder.Immutable<I>> Optional<I> withValue(I immutable, V value) {
        return with(immutable, value.get());
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

    boolean isSupported(DataHolder container);

}
