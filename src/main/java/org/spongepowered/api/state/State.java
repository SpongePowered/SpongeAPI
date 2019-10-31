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
package org.spongepowered.api.state;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.SerializableDataHolder;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.util.Cycleable;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public interface State<S extends State<S>> extends SerializableDataHolder.Immutable<S>, CatalogType {

    /**
     * Gets the {@link Comparable} value for the specific {@link StateProperty}
     * such that if the {@link State} does not support the
     * {@link StateProperty}, {@link Optional#empty()} is returned.
     *
     * @param stateProperty The state property
     * @param <T> The generic type of state property
     * @return The comparable value, if available and compatible
     */
    <T extends Comparable<T>> Optional<T> getStateProperty(StateProperty<T> stateProperty);

    /**
     * Attempts to retrieve the {@link StateProperty} instance associated with
     * this {@link State}s {@link StateContainer} by name. If there is no
     * {@link StateProperty} available, {@link Optional#empty()} is returned.
     *
     * @param name The state property name
     * @return The state property, if available
     */
    Optional<StateProperty<?>> getStatePropertyByName(String name);

    /**
     * Gets the {@link State} with the appropriate value for the given
     * {@link StateProperty}. If the {@link StateProperty} is not supported,
     * {@link Optional#empty()} is returned. If the object is not either
     * an instance contained in {@link StateProperty#getPossibleValues()} or
     * an instance {@link Object#toString()}, {@link Optional#empty()} may be
     * returned.
     *
     * @param <T> The type of cycleable value
     * @param stateProperty The state property
     * @param value The value
     * @param <V> The type of extended value
     * @return The state, if the state property and value are supported
     */
    <T extends Comparable<T>, V extends T> Optional<S> withStateProperty(StateProperty<T> stateProperty, V value);

    /**
     * Cycles to the next possible value of the {@link StateProperty} and returns
     * the new {@link State}. Returns {@link Optional#empty()} if the state property or
     * the value isn't supported.
     *
     * @param <T> The type of cycleable value
     * @param stateProperty The state property
     * @return The cycled state if successful
     */
    <T extends Comparable<T>> Optional<S> cycleStateProperty(StateProperty<T> stateProperty);

    /**
     * Cycles to the next possible value of the {@link Key} and returns
     * the new {@link State}. Returns {@link Optional#empty()} if the key or
     * the value isn't supported.
     *
     * @param <T> The type of cycleable value
     * @param key The key
     * @return The cycled state if successful
     */
    <T extends Cycleable<T>> Optional<S> cycleValue(Key<? extends Value<T>> key);

    /**
     * Gets an immutable {@link Collection} of all applicable
     * {@link StateProperty}s for this {@link State}.
     *
     * @return An immutable collection of all applicable state properties
     */
    Collection<StateProperty<?>> getStateProperties();

    /**
     * Gets an immutable {@link Collection} of all the values for all
     * {@link StateProperty}s for this {@link State}.
     *
     * @return An immutable collection of all the values for all applicable properties
     */
    Collection<?> getStatePropertyValues();

    /**
     * Gets an immutable or unmodifiable {@link Map} of the known {@link StateProperty}s
     * to their current values for this {@link State}.
     *
     * @return The immutable map of state properties to their values representing this state
     */
    Map<StateProperty<?>, ?> getStatePropertyMap();
}
