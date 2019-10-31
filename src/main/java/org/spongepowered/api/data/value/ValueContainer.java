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
package org.spongepowered.api.data.value;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableSet;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.data.Key;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Set;

/**
 * A value holder is a holder of a particular set of {@link Value}s. While
 * there exists a {@link DataHolder} and {@link DataManipulator},
 * the emphasis of {@link ValueContainer} is that it only contains "data". It
 * is not known whether a {@code ValueHolder} is mutable or immutable.
 *
 * <p>Being that a {@code ValueHolder} is literally a container of
 * {@link Value}s, it itself does not contain the underlying values of
 * data. A {@link ValueContainer} may not always be parented by another
 * {@link ValueContainer}, such as the case for {@link DataManipulator}s and
 * {@link org.spongepowered.api.data.DataHolder.Mutable}s, it is recommended to knowingly understand the
 * fundamental differences between them.</p>
 */
public interface ValueContainer {

    /**
     * Attempts to get the underlying value backed by a {@link Value}
     * linked to the provided {@link Key}. If the {@link Key} is not
     * supported, {@link Optional#empty()} is returned. It is important
     * to check for support of a {@link Key} by either calling
     * {@link #supports(Value)} or {@link #supports(Key)}.
     *
     * @param key The key to retrieve the value for
     * @param <E> The type of value
     * @return The value, if available
     */
    <E> Optional<E> get(Key<? extends Value<E>> key);

    /**
     * Attempts to get the underlying int value backed by a {@link Value}
     * linked to the provided {@link Key}. If the {@link Key} is not
     * supported, {@link Optional#empty()} is returned. It is important
     * to check for support of a {@link Key} by either calling
     * {@link #supports(Value)} or {@link #supports(Key)}.
     *
     * @param key The key to retrieve the value for
     * @return The value, if available
     */
    default OptionalInt getInt(Key<? extends Value<Integer>> key) {
        return this.get(key).map(OptionalInt::of).orElse(OptionalInt.empty());
    }

    /**
     * Attempts to get the underlying double value backed by a {@link Value}
     * linked to the provided {@link Key}. If the {@link Key} is not
     * supported, {@link Optional#empty()} is returned. It is important
     * to check for support of a {@link Key} by either calling
     * {@link #supports(Value)} or {@link #supports(Key)}.
     *
     * @param key The key to retrieve the value for
     * @return The value, if available
     */
    default OptionalDouble getDouble(Key<? extends Value<Double>> key) {
        return this.get(key).map(OptionalDouble::of).orElse(OptionalDouble.empty());
    }

    /**
     * Attempts to get the underlying long value backed by a {@link Value}
     * linked to the provided {@link Key}. If the {@link Key} is not
     * supported, {@link Optional#empty()} is returned. It is important
     * to check for support of a {@link Key} by either calling
     * {@link #supports(Value)} or {@link #supports(Key)}.
     *
     * @param key The key to retrieve the value for
     * @return The value, if available
     */
    default OptionalLong getLong(Key<? extends Value<Long>> key) {
        return this.get(key).map(OptionalLong::of).orElse(OptionalLong.empty());
    }

    /**
     * Attempts to get the underlying value backed by a {@link Value}
     * linked to the provided {@link Key}.
     *
     * <p>If the {@link Key} is not supported or
     * available, {@link NoSuchElementException} will be thrown.</p>
     *
     * @param key The key
     * @param <E> The type of value
     * @return The value
     * @throws NoSuchElementException If the value is not supported or present
     */
    default <E> E require(Key<? extends Value<E>> key) {
        return this.get(key).orElseThrow(() -> new NoSuchElementException(String.format(
                "Could not retrieve value for key '%s'", key.toString())));
    }

    /**
     * Attempts to get the underlying value if available and supported. If the
     * {@link Value} is not supported whatsoever by this
     * {@link ValueContainer}, an exception is thrown.
     *
     * @param key The {@link Key} backing the {@link Value}
     * @param <E> The type of value
     * @return The value, or null if not set
     */
    default <E> @Nullable E getOrNull(Key<? extends Value<E>> key) {
        final Optional<E> value = this.get(key);
        if (value.isPresent()) {
            return value.get();
        }
        if (!this.supports(key)) {
            throw new UnsupportedOperationException("Key not supported. Key: " + key);
        }
        return null;
    }

    /**
     * Attempts to get the underlying value if available. If the value is not
     * set, the given {@code defaultValue} is returned, if the
     * {@link Value} is even supported.
     *
     * @param key The key backing the {@link Value}
     * @param defaultValue The value to default to if not set
     * @param <E> The type of value
     * @return The value, or default if not set
     */
    default <E> E getOrElse(Key<? extends Value<E>> key, E defaultValue) {
        return this.get(key).orElse(checkNotNull(defaultValue, "defaultValue"));
    }

    /**
     * Gets the {@link Value} for the given {@link Key}.
     *
     * @param key The key linked to the {@link Value}
     * @param <E> The type of the return type
     * @param <V> The type of value
     * @return The value, if available
     */
    <E, V extends Value<E>> Optional<V> getValue(Key<V> key);

    /**
     * Checks if the given {@link Key} is supported by this
     * {@link ValueContainer}.
     *
     * @param key The key to check
     * @return True if the key and value backed by the key is supported
     */
    boolean supports(Key<?> key);

    /**
     * Checks if the provided {@link Value} is supported.
     *
     * @param value The base value to check
     * @return True if the base value is supported
     */
    default boolean supports(Value<?> value) {
        return this.supports(value.getKey());
    }

    /**
     * Gets all applicable {@link Key}s for this {@link ValueContainer}.
     * Changes can not be made to the set to alter the {@link ValueContainer},
     * nor can the {@link Value}s be changed with the provided
     * {@link ImmutableSet}.
     *
     * @return An immutable set of known {@link Key}s
     */
    Set<Key<?>> getKeys();

    /**
     * Gets all applicable {@link Value}s associated with this
     * {@link ValueContainer}. As the data backed by the values are copied,
     * any modifications to the {@link Value}s will not be reflected onto
     * this {@link ValueContainer}.
     *
     * @return An immutable set of copied values
     */
    Set<Value.Immutable<?>> getValues();
}
