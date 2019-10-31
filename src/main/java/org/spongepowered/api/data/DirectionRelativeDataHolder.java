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
import org.spongepowered.api.util.Direction;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public interface DirectionRelativeDataHolder extends DataHolder {

    /**
     * Attempts to get the underlying value backed by a {@link Value}
     * linked to the provided {@link Key} and {@link Direction}. If the
     * {@link Key} is not supported, {@link Optional#empty()} is returned.
     * It is important to check for support of a {@link Key} by either
     * calling {@link #supports(Value)} or {@link #supports(Key)}.
     *
     * @param direction The direction
     * @param key The key to retrieve the value for
     * @param <E> The type of value
     * @return The value, if available
     */
    <E> Optional<E> get(Direction direction, Key<? extends Value<E>> key);

    /**
     * Attempts to get the underlying int value backed by a {@link Value}
     * linked to the provided {@link Key} and {@link Direction}. If the
     * {@link Key} is not supported, {@link Optional#empty()} is returned.
     * It is important to check for support of a {@link Key} by either
     * calling {@link #supports(Value)} or {@link #supports(Key)}.
     *
     * @param direction The direction
     * @param key The key to retrieve the value for
     * @return The value, if available
     */
    default OptionalInt getInt(Direction direction, Key<? extends Value<Integer>> key) {
        return this.get(direction, key).map(OptionalInt::of).orElse(OptionalInt.empty());
    }

    /**
     * Attempts to get the underlying double value backed by a {@link Value}
     * linked to the provided {@link Key} and {@link Direction}. If the
     * {@link Key} is not supported, {@link Optional#empty()} is returned.
     * It is important to check for support of a {@link Key} by either
     * calling {@link #supports(Value)} or {@link #supports(Key)}.
     *
     * @param direction The direction
     * @param key The key to retrieve the value for
     * @return The value, if available
     */
    default OptionalDouble getDouble(Direction direction, Key<? extends Value<Double>> key) {
        return this.get(direction, key).map(OptionalDouble::of).orElse(OptionalDouble.empty());
    }

    /**
     * Attempts to get the underlying long value backed by a {@link Value}
     * linked to the provided {@link Key} and {@link Direction}. If the
     * {@link Key} is not supported, {@link Optional#empty()} is returned.
     * It is important to check for support of a {@link Key} by either
     * calling {@link #supports(Value)} or {@link #supports(Key)}.
     *
     * @param direction The direction
     * @param key The key to retrieve the value for
     * @return The value, if available
     */
    default OptionalLong getLong(Direction direction, Key<? extends Value<Long>> key) {
        return this.get(direction, key).map(OptionalLong::of).orElse(OptionalLong.empty());
    }

    interface Mutable extends DataHolder.Mutable, DirectionRelativeDataHolder {

    }

    interface Immutable<I extends Immutable<I>> extends DataHolder.Immutable<I>, DirectionRelativeDataHolder {

    }
}
