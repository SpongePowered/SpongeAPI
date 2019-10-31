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

import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.util.Direction;

import java.util.Optional;

public interface DirectionRelativeDataProvider<V extends Value<E>, E> extends DataProvider<V, E> {

    @Override
    default Optional<E> get(DataHolder dataHolder) {
        return this.get(dataHolder, Direction.NONE);
    }

    @Override
    default Optional<V> getValue(DataHolder dataHolder) {
        return this.getValue(dataHolder, Direction.NONE);
    }

    @Override
    default boolean isSupported(DataHolder dataHolder) {
        return this.isSupported(dataHolder, Direction.NONE);
    }

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
    Optional<E> get(DataHolder dataHolder, Direction direction);

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
    default Optional<V> getValue(DataHolder dataHolder, Direction direction) {
        return this.get(dataHolder, direction).map(element -> Value.genericMutableOf(this.getKey(), element));
    }

    /**
     * Gets whether this value provider is supported by the given {@link ValueContainer}.
     *
     * @param dataHolder The data holder
     * @return Whether it's supported
     */
    boolean isSupported(DataHolder dataHolder, Direction direction);
}
