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
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.immutable.ImmutableValueStore;
import org.spongepowered.api.data.value.mutable.CompositeValueStore;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import javax.annotation.Nullable;

/**
 * A ValueContainer is a holder of a particular set of {@link BaseValue}s. While
 * there exists a {@link CompositeValueStore} and {@link ImmutableValueStore},
 * the emphasis of {@link ValueContainer} is that it only contains "data". It
 * is not known whether a {@code ValueContainer} is mutable or immutable.
 *
 * <p>Being that a {@code ValueContainer} is literally a container of
 * {@link BaseValue}s, it itself does not contain the underlying values of
 * data. A {@link ValueContainer} may not always be parented by another
 * {@link ValueContainer}, such as the case for {@link DataManipulator}s and
 * {@link DataHolder}s, it is recommended to knowingly understand the
 * fundamental differences between them.</p>
 *
 * @param <C> The type of container for fluency
 */
public interface ValueContainer<C extends ValueContainer<C>> {

    /**
     * Attempts to get the underlying value backed by a {@link BaseValue}
     * linked to the provided {@link Key}. If the {@link Key} is not
     * supported, {@link Optional#empty()} is returned. It is important
     * to check for support of a {@link Key} by either calling
     * {@link #supports(BaseValue)} or {@link #supports(Key)}.
     *
     * @param key The key linking the
     * @param <E> The type of value
     * @return The value, if available
     */
    <E> Optional<E> get(Key<? extends BaseValue<E>> key);

    /**
     * Attempts to get the underlying value backed by a {@link BaseValue}
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
    default <E> E require(Key<? extends BaseValue<E>> key) {
        final Optional<E> optional = this.get(key);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new NoSuchElementException(String.format("Could not retrieve value for key '%s'", key.getId()));
    }

    /**
     * Attempts to get the underlying value if available and supported. If the
     * {@link BaseValue} is not supported whatsoever by this
     * {@link ValueContainer}, an exception is thrown.
     *
     * @param key The {@link Key} backing the {@link BaseValue}
     * @param <E> The type of value
     * @return The value, or null if not set
     */
    @Nullable
    default <E> E getOrNull(Key<? extends BaseValue<E>> key) {
        Optional<E> value = get(key);
        if (value.isPresent()) {
            return value.get();
        }
        if (!supports(key)) {
            throw new UnsupportedOperationException("Key not supported. Key: " + key);
        }
        return null;
    }

    /**
     * Attempts to get the underlying value if available. If the value is not
     * set, the given {@code defaultValue} is returned, if the
     * {@link BaseValue} is even supported.
     *
     * @param key The key backing the {@link BaseValue}
     * @param defaultValue The value to default to if not set
     * @param <E> The type of value
     * @return The value, or default if not set
     */
    default <E> E getOrElse(Key<? extends BaseValue<E>> key, E defaultValue) {
        return get(key).orElse(checkNotNull(defaultValue, "Provided a null default value for 'getOrElse(Key, null)'!"));
    }

    /**
     * Gets the {@link BaseValue} for the given {@link Key}.
     *
     * @param key The key linked to the {@link BaseValue}
     * @param <E> The type of the return type
     * @param <V> The type of value
     * @return The value, if available
     */
    <E, V extends BaseValue<E>> Optional<V> getValue(Key<V> key);

    /**
     * Checks if the given {@link Key} is supported by this
     * {@link ValueContainer}.
     *
     * @param key The key to check
     * @return True if the key and value backed by the key is supported
     */
    boolean supports(Key<?> key);

    /**
     * Checks if the provided {@link BaseValue} is supported.
     *
     * @param baseValue The base value to check
     * @return True if the base value is supported
     */
    default boolean supports(BaseValue<?> baseValue) {
        return supports(baseValue.getKey());
    }

    /**
     * Creates a clone copy of this {@link ValueContainer} as a new
     * {@link ValueContainer} such that all the {@link BaseValue}s are
     * safely duplicated to the new instance.
     *
     * @return The new copy
     */
    C copy();

    /**
     * Gets all applicable {@link Key}s for this {@link ValueContainer}.
     * Changes can not be made to the set to alter the {@link ValueContainer},
     * nor can the {@link BaseValue}s be changed with the provided
     * {@link ImmutableSet}.
     *
     * @return An immutable set of known {@link Key}s
     */
    Set<Key<?>> getKeys();

    /**
     * Gets all applicable {@link BaseValue}s associated with this
     * {@link ValueContainer}. As the data backed by the values are copied,
     * any modifications to the {@link BaseValue}s will not be reflected onto
     * this {@link ValueContainer}.
     *
     * @return An immutable set of copied values
     */
    Set<ImmutableValue<?>> getValues();

}
