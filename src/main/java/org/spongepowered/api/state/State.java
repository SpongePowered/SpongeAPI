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
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.data.ImmutableDataHolder;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public interface State<S extends State<S>> extends ImmutableDataHolder<S>, CatalogType {

    /**
     * Gets the {@link StateContainer} this
     * {@link State} is part of.
     *
     * @return The state container
     */
    StateContainer<S> getStateContainer();

    /**
     * Gets the {@link Comparable} value for the specific {@link StateProperty}
     * such that if the {@link BlockState} does not support the
     * {@link StateProperty}, {@link Optional#empty()} is returned.
     *
     * @param blockTrait The block trait instance
     * @param <T> The generic type of block trait
     * @return The comparable value, if available and compatible
     */
    <T extends Comparable<T>> Optional<T> getPropertyValue(StateProperty<T> blockTrait);

    /**
     * Attempts to retrieve the {@link StateProperty} instance associated with
     * this {@link BlockState}s {@link BlockType} by string id. If there is no
     * {@link StateProperty} available, {@link Optional#empty()} is returned.
     *
     * @param blockTrait The block trait id
     * @return The block trait, if available
     */
    Optional<StateProperty<?>> getProperty(String blockTrait);

    /**
     * Gets the {@link State} with the appropriate value for the given
     * {@link StateProperty}. If the {@link StateProperty} is not supported,
     * {@link Optional#empty()} is returned. If the object is not either
     * an instance contained in {@link StateProperty#getPossibleValues()} or
     * an instance {@link Object#toString()}, {@link Optional#empty()} may be
     * returned.
     *
     * @param trait The trait
     * @param value The value
     * @return The state container, if the trait and value are supported
     */
    <T extends Comparable<T>, V extends T> Optional<S> withProperty(StateProperty<?> trait, V value);

    <T extends Comparable<T>> Optional<S> cycleProperty(StateProperty<T> property);

    /**
     * Gets an immutable {@link Collection} of all applicable
     * {@link StateProperty}s for this {@link BlockState}.
     *
     * @return An immutable collection of all applicable block traits
     */
    Collection<StateProperty<?>> getProperties();

    /**
     * Gets an immutable {@link Collection} of all the values for all
     * {@link StateProperty}s for this {@link BlockState}.
     *
     * @return An immutable collection of all the values for all applicable
     *     traits
     */
    Collection<?> getPropertyValues();

    /**
     * Gets an immutable or unmodifiable {@link Map} of the known {@link StateProperty}s
     * to their current values for this {@link BlockState}.
     *
     * @return The immutable map of block traits to their values representing
     *     this block state
     */
    Map<StateProperty<?>, ?> getPropertyMap();
}
