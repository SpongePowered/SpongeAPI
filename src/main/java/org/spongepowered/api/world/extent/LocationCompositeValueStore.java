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
package org.spongepowered.api.world.extent;

import com.flowpowered.math.vector.Vector3i;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.merge.MergeFunction;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.service.persistence.InvalidDataException;
import org.spongepowered.api.world.Location;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Nullable;

/**
 * A type of {@link Location} based value store that can handle proxied
 * data api related queries for specific positions.
 */
public interface LocationCompositeValueStore {

    /**
     * Gets the value of data that is keyed to the provided {@link Key} at the
     * give block location.
     *
     * @param coordinates The position of the block
     * @param key The key to the data
     * @param <E> The type of element of data
     * @return The data, if available
     */
    <E> Optional<E> get(Vector3i coordinates, Key<? extends BaseValue<E>> key);

    /**
     * Gets the value of data that is keyed to the provided {@link Key} at the
     * give block location.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param key The key to the data
     * @param <E> The type of element of data
     * @return The data, if available
     */
    <E> Optional<E> get(int x, int y, int z, Key<? extends BaseValue<E>> key);

    /**
     * Gets an instance of the given data class for given block at the location.
     *
     * <p>If there is no pre-existing data that can be represented by the given
     * {@link DataManipulator} class, {@link Optional#absent()} is returned.
     * </p>
     *
     * @param coordinates The position of the block
     * @param manipulatorClass The data class
     * @param <T> The type of data
     * @return An instance of the class, if not available
     */
    <T extends DataManipulator<?, ?>> Optional<T> get(Vector3i coordinates, Class<T> manipulatorClass);

    /**
     * Gets an instance of the given data class for given block at the location.
     *
     * <p>If there is no pre-existing data that can be represented by the given
     * {@link DataManipulator} class, {@link Optional#absent()} is returned.
     * </p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param manipulatorClass The data class
     * @param <T> The type of data
     * @return An instance of the class, if not available
     */
    <T extends DataManipulator<?, ?>> Optional<T> get(int x, int y, int z, Class<T> manipulatorClass);

    /**
     * Gets or creates a new {@link DataManipulator} that can be accepted by
     * the block at the location. In the event that there is no data that can
     * be represented by the given {@link DataManipulator}, a new
     * {@link  DataManipulator} object is created with default values.
     *
     * <p>In the event the {@link DataManipulator} can not represent any data
     * pertaining to the block at the location, {@link Optional#absent()} is
     * returned.</p>
     *
     * @param coordinates The position of the block
     * @param manipulatorClass The data class
     * @param <T> The type of data
     * @return An instance of the class, if not available
     */
    <T extends DataManipulator<?, ?>> Optional<T> getOrCreate(Vector3i coordinates, Class<T> manipulatorClass);

    /**
     * Gets or creates a new {@link DataManipulator} that can be accepted by
     * the block at the location. In the event that there is no data that can
     * be represented by the given {@link DataManipulator}, a new
     * {@link  DataManipulator} object is created with default values.
     *
     * <p>In the event the {@link DataManipulator} can not represent any data
     * pertaining to the block at the location, {@link Optional#absent()} is
     * returned.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param manipulatorClass The data class
     * @param <T> The type of data
     * @return An instance of the class, if not available
     */
    <T extends DataManipulator<?, ?>> Optional<T> getOrCreate(int x, int y, int z, Class<T> manipulatorClass);

    /**
     * Gets the value of data that is keyed to the provided {@link Key} at the
     * give block location. The data may not exist, or may not be compatible
     * in which case <code>null</code> may be returned.
     *
     * @param coordinates The position of the block
     * @param key The key to the data
     * @param <E> The type of element of data
     * @return The data or null
     */
    <E> E getOrNull(Vector3i coordinates, Key<? extends BaseValue<E>> key);

    /**
     * Gets the value of data that is keyed to the provided {@link Key} at the
     * give block location. The data may not exist, or may not be compatible
     * in which case <code>null</code> may be returned.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param key The key to the data
     * @param <E> The type of element of data
     * @return The data or null
     */
    @Nullable
    <E> E getOrNull(int x, int y, int z, Key<? extends BaseValue<E>> key);

    /**
     * Gets the value of data that is keyed to the provided {@link Key} at the
     * give block location. The data may not exist, or may not be compatible
     * in which case the default value may be returned.
     *
     * @param coordinates The position of the block
     * @param key The key to the data
     * @param defaultValue The default value to be provided
     * @param <E> The type of element of data
     * @return The data or null
     */
    <E> E getOrElse(Vector3i coordinates, Key<? extends BaseValue<E>> key, E defaultValue);

    /**
     * Gets the value of data that is keyed to the provided {@link Key} at the
     * give block location. The data may not exist, or may not be compatible
     * in which case the default value may be returned.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param key The key to the data
     * @param defaultValue The default value to return
     * @param <E> The type of element of data
     * @return The data or null
     */
    <E> E getOrElse(int x, int y, int z, Key<? extends BaseValue<E>> key, E defaultValue);

    /**
     * Gets the value of data that is keyed to the provided {@link Key} at the
     * give block location. The data may not exist, or may not be compatible
     * in which case <code>null</code> may be returned.
     *
     * @param coordinates The position of the block
     * @param key The key to the data
     * @param <E> The type of element of data
     * @param <V> The type of value
     * @return The base value, if available
     */
    <E, V extends BaseValue<E>> Optional<V> getValue(Vector3i coordinates, Key<V> key);

    /**
     * Gets the value of data that is keyed to the provided {@link Key} at the
     * give block location.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param key The key to the data
     * @param <E> The type of element of data
     * @param <V> The type of value
     * @return The base value, if available
     */
    <E, V extends BaseValue<E>> Optional<V> getValue(int x, int y, int z, Key<V> key);

    /**
     * Checks if the provided {@link Key} to the data is supported by the block at
     * the provided location.
     *
     * @param coordinates The position of the block
     * @param key The Key to the value of data
     * @return True if the block supports the data
     */
    boolean supports(Vector3i coordinates, Key<?> key);

    /**
     * Checks if the provided {@link Key} to the data is supported by the block at
     * the provided location.
     *
     * @param x The X coordinate
     * @param y The Y coordinate
     * @param z The Z coordinate
     * @param key The Key to the value of data
     * @return True if the block supports the data
     */
    boolean supports(int x, int y, int z, Key<?> key);

    /**
     * Checks if the provided {@link BaseValue} is supported by the block at
     * the provided location.
     *
     * @param coordinates The position of the block
     * @param value The value of data
     * @return True if the block supports the data
     */
    boolean supports(Vector3i coordinates, BaseValue<?> value);

    /**
     * Checks if the provided {@link BaseValue} is supported by the block at
     * the provided location.
     *
     * @param x The X coordinate
     * @param y The Y coordinate
     * @param z The Z coordinate
     * @param value The value of data
     * @return True if the block supports the data
     */
    boolean supports(int x, int y, int z, BaseValue<?> value);

    /**
     * Checks if the given {@link DataManipulator} class is able to represent
     * data within the block at the given position.
     *
     * @param coordinates The position of the block
     * @param manipulatorClass The data class
     * @return True if the block at the given position can accept the
     *     {@link DataManipulator} object
     */
    boolean supports(Vector3i coordinates, Class<? extends DataManipulator<?, ?>> manipulatorClass);

    /**
     * Checks if the given {@link DataManipulator} class is able to represent
     * data within the block at the given position.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param manipulatorClass The data class
     * @return True if the block at the given position can accept the
     *     {@link DataManipulator} object
     */
    boolean supports(int x, int y, int z, Class<? extends DataManipulator<?, ?>> manipulatorClass);

    /**
     * Checks if the given {@link DataManipulator} class is able to represent
     * data within the block at the given position.
     *
     * @param coordinates The position of the block
     * @param manipulator The manipulator
     * @return True if the block at the given position can accept the
     *     {@link DataManipulator} object
     */
    boolean supports(Vector3i coordinates, DataManipulator<?, ?> manipulator);

    /**
     * Checks if the given {@link DataManipulator} class is able to represent
     * data within the block at the given position.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param manipulator The manipulator
     * @return True if the block at the given position can accept the
     *     {@link DataManipulator} object
     */
    boolean supports(int x, int y, int z, DataManipulator<?, ?> manipulator);

    /**
     * Gets an {@link ImmutableSet} of {@link Key}s for the block at
     * the given location.
     *
     * @param coordinates The position of the block
     * @return The immutable set of values for the block
     */
    Set<Key<?>> getKeys(Vector3i coordinates);

    /**
     * Gets an {@link ImmutableSet} of {@link Key}s for the block at
     * the given location.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return The immutable set of values for the block
     */
    Set<Key<?>> getKeys(int x, int y, int z);

    /**
     * Gets an {@link ImmutableSet} of {@link ImmutableValue}s for the block at
     * the given location.
     *
     * @param coordinates The position of the block
     * @return The immutable set of values for the block
     */
    Set<ImmutableValue<?>> getValues(Vector3i coordinates);

    /**
     * Gets an {@link ImmutableSet} of {@link ImmutableValue}s for the block at
     * the given location.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return The immutable set of values for the block
     */
    Set<ImmutableValue<?>> getValues(int x, int y, int z);

    /**
     * Applies a transformation on the pre-existing value of the data keyed
     * by the provided {@link Key} and returns a {@link DataTransactionResult}
     * of said transformation.
     *
     * @param coordinates The position of the block
     * @param key The key to the data
     * @param function The function applying the transformation
     * @param <E> The type of data
     * @return The transaction result
     */
    <E> DataTransactionResult transform(Vector3i coordinates, Key<? extends BaseValue<E>> key, Function<E, E> function);

    /**
     * Applies a transformation on the pre-existing value of the data keyed
     * by the provided {@link Key} and returns a {@link DataTransactionResult}
     * of said transformation.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param key The key to the data
     * @param function The function applying the transformation
     * @param <E> The type of data
     * @return The transaction result
     */
    <E> DataTransactionResult transform(int x, int y, int z, Key<? extends BaseValue<E>> key, Function<E, E> function);

    /**
     * Offers the given <code>E</code> value that is keyed by the provided
     * {@link Key} to the block at the provided location.
     *
     * <p>If any data is rejected or existing data is replaced, the
     * {@link DataTransactionResult} will retain the rejected and replaced
     * data.</p>
     *
     * @param coordinates The position of the block
     * @param key The key for the data
     * @param value The value to offer
     * @param <E> The type of data being offered
     * @return The transaction result
     */
    <E> DataTransactionResult offer(Vector3i coordinates, Key<? extends BaseValue<E>> key, E value);

    /**
     * Offers the given <code>E</code> value that is keyed by the provided
     * {@link Key} to the block at the provided location.
     *
     * <p>If any data is rejected or existing data is replaced, the
     * {@link DataTransactionResult} will retain the rejected and replaced
     * data.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param key The key for the data
     * @param value The value to offer
     * @param <E> The type of data being offered
     * @return The transaction result
     */
    <E> DataTransactionResult offer(int x, int y, int z, Key<? extends BaseValue<E>> key, E value);

    /**
     * Offers the given {@link BaseValue} to the block at the given
     * position.
     *
     * <p>If any data is rejected or existing data is replaced, the
     * {@link DataTransactionResult} will retain the rejected and replaced
     * data.</p>
     *
     * @param coordinates The position of the block
     * @param value The value to offer
     * @param <E> The type of the element wrapped by the value
     * @return The transaction result
     */
    <E> DataTransactionResult offer(Vector3i coordinates, BaseValue<E> value);

    /**
     * Offers the given {@link BaseValue} to the block at the given
     * position.
     *
     * <p>If any data is rejected or existing data is replaced, the
     * {@link DataTransactionResult} will retain the rejected and replaced
     * data.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param value The value to offer
     * @param <E> The type of the element wrapped by the value
     * @return The transaction result
     */
    <E> DataTransactionResult offer(int x, int y, int z, BaseValue<E> value);

    /**
     * Offers the given {@link DataManipulator} to the block at the given
     * position.
     *
     * <p>If any data is rejected or existing data is replaced, the
     * {@link DataTransactionResult} will retain the rejected and replaced
     * data.</p>
     *
     * @param coordinates The position of the block
     * @param manipulator The manipulator data to offer
     * @return The transaction result
     */
    DataTransactionResult offer(Vector3i coordinates, DataManipulator<?, ?> manipulator);

    /**
     * Offers the given {@link DataManipulator} to the block at the given
     * position.
     *
     * <p>If any data is rejected or existing data is replaced, the
     * {@link DataTransactionResult} will retain the rejected and replaced
     * data.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param manipulator The manipulator data to offer
     * @return The transaction result
     */
    DataTransactionResult offer(int x, int y, int z, DataManipulator<?, ?> manipulator);

    /**
     * Offers the given {@link DataManipulator} to the block at the given
     * position.
     *
     * <p>If any data is rejected or existing data is replaced, the
     * {@link DataTransactionResult} will retain the rejected and replaced
     * data.</p>
     *
     * @param coordinates The position of the block
     * @param manipulator The manipulator data to offer
     * @param function The merge function to resolve conflicts
     * @return The transaction result
     */
    DataTransactionResult offer(Vector3i coordinates, DataManipulator<?, ?> manipulator, MergeFunction function);

    /**
     * Offers the given {@link DataManipulator} to the block at the given
     * position.
     *
     * <p>If any data is rejected or existing data is replaced, the
     * {@link DataTransactionResult} will retain the rejected and replaced
     * data.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param manipulator The manipulator data to offer
     * @param function The merge function to resolve conflicts
     * @return The transaction result
     */
    DataTransactionResult offer(int x, int y, int z, DataManipulator<?, ?> manipulator, MergeFunction function);

    /**
     * Offers the provided {@link DataManipulator}s to the block at the given
     * position.
     *
     * <p>If any data is rejected or existing data is replaced, the
     * {@link DataTransactionResult} will retain the rejected, replaced, and
     * successfully offered data.</p>
     *
     * @param coordinates The position of the block
     * @param manipulators The values to offer
     * @return The transaction result
     */
    DataTransactionResult offer(Vector3i coordinates, Iterable<DataManipulator<?, ?>> manipulators);

    /**
     * Offers the provided {@link DataManipulator}s to the block at the given
     * position.
     *
     * <p>If any data is rejected or existing data is replaced, the
     * {@link DataTransactionResult} will retain the rejected, replaced, and
     * successfully offered data.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param manipulators The values to offer
     * @return The transaction result
     */
    DataTransactionResult offer(int x, int y, int z, Iterable<DataManipulator<?, ?>> manipulators);

    /**
     * Offers the provided {@link DataManipulator}s to the block at the given
     * position. If there's any overlaps of data, the provided
     * {@link MergeFunction} is used to delegate the merges. It is possible to
     * recycle {@link MergeFunction}s provided that the {@link MergeFunction}
     * is aware of being usable in multiple environments.
     *
     * <p>If any data is rejected or existing data is replaced, the
     * {@link DataTransactionResult} will retain the rejected, replaced, and
     * successfully offered data.</p>
     *
     * @param blockPosition The block position
     * @param values The values to offer
     * @param function The merge function to resolve conflicts
     * @return The transaction result
     */
    DataTransactionResult offer(Vector3i blockPosition, Iterable<DataManipulator<?,?>> values, MergeFunction function);

    /**
     * Attempts to remove the given {@link DataManipulator} represented by
     * the block at the given location if possible.
     *
     * <p>Certain {@link DataManipulator}s can not be removed due to certain
     * dependencies relying on the particular data to function.</p>
     *
     * @param coordinates The position of the block
     * @param manipulatorClass The data class
     * @return If the manipulator was removed
     */
    DataTransactionResult remove(Vector3i coordinates, Class<? extends DataManipulator<?, ?>> manipulatorClass);

    /**
     * Attempts to remove the given {@link DataManipulator} represented by
     * the block at the given location if possible.
     *
     * <p>Certain {@link DataManipulator}s can not be removed due to certain
     * dependencies relying on the particular data to function.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param manipulatorClass The data class
     * @return If the manipulator was removed
     */
    DataTransactionResult remove(int x, int y, int z, Class<? extends DataManipulator<?, ?>> manipulatorClass);

    /**
     * Attempts to remove the data associated with the provided {@link Key}
     * from the block at the provided location.
     *
     * @param coordinates The position of the block
     * @param key The key to the data to remove
     * @return The transaction result
     */
    DataTransactionResult remove(Vector3i coordinates, Key<?> key);

    /**
     * Attempts to remove the data associated with the provided {@link Key}
     * from the block at the provided location.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param key The key of the data to remove
     * @return The transaction result
     */
    DataTransactionResult remove(int x, int y, int z, Key<?> key);

    /**
     * Attempts to undo a {@link DataTransactionResult}. Specifically, all
     * {@link ImmutableValue}s that were successfully added are removed, and
     * all replaced {@link ImmutableValue}s are offered.
     *
     * @param coordinates The position of the block
     * @param result The transaction result to undo
     * @return The transaction result
     */
    DataTransactionResult undo(Vector3i coordinates, DataTransactionResult result);

    /**
     * Attempts to undo a {@link DataTransactionResult}. Specifically, all
     * {@link ImmutableValue}s that were successfully added are removed, and
     * all replaced {@link ImmutableValue}s are offered.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param result The transaction result to undo
     * @return The transaction result
     */
    DataTransactionResult undo(int x, int y, int z, DataTransactionResult result);

    /**
     * Attempts to copy all the relevant data from the provided
     * {@link DataHolder} to the block at the provided coordinates.
     *
     * @param to The coordinates of the block
     * @param from The data holder to copy data from
     * @return The transaction result
     */
    DataTransactionResult copyFrom(Vector3i to, DataHolder from);

    /**
     * Attempts to copy all the relevant data from the provided
     * {@link DataHolder} to the block at the provided coordinates.
     *
     * @param xTo The X pos
     * @param yTo The Y pos
     * @param zTo The Z pos
     * @param from The data holder to copy data from
     * @return The transaction result
     */
    DataTransactionResult copyFrom(int xTo, int yTo, int zTo, DataHolder from);

    /**
     * Attempts to copy all the relevant data from the provided
     * {@link DataHolder} to the block at the provided coordinates.
     *
     * @param coordinatesTo The coordinates of the block
     * @param coordinatesFrom The coordinates of the block to copy data from
     * @return The transaction result
     */
    DataTransactionResult copyFrom(Vector3i coordinatesTo, Vector3i coordinatesFrom);

    /**
     * Attempts to copy all {@link ImmutableValue}s from the provided block to
     * provided block to the provided block coordinates.
     *
     * @param xTo The X position of the block to copy data to
     * @param yTo The Y position of the block to copy data to
     * @param zTo The Z position of the block to copy data to
     * @param xFrom The X position of the block to copy data from
     * @param yFrom The Y position of the block to copy data from
     * @param zFrom The Z position of the block to copy data from
     * @return The transaction result
     */
    DataTransactionResult copyFrom(int xTo, int yTo, int zTo, int xFrom, int yFrom, int zFrom);

    /**
     * Attempts to copy all {@link ImmutableValue}s from the provided block to
     * provided block to the provided block coordinates. Any conflicting data
     * is handled through the provided {@link MergeFunction}.
     *
     * @param to The block coordinates to copy to
     * @param from the data holder to copy data from
     * @param function The merge function to resolve conflicts
     * @return The transaction result
     */
    DataTransactionResult copyFrom(Vector3i to, DataHolder from, MergeFunction function);

    /**
     * Attempts to copy all {@link ImmutableValue}s from the provided block to
     * provided block to the provided block coordinates. Any conflicting data
     * is handled through the provided {@link MergeFunction}.
     *
     * @param xTo The X pos of the block to copy data to
     * @param yTo The Y pos of the block to copy data to
     * @param zTo The Z pos of the block to copy data to
     * @param from The data holder to copy data from
     * @param function The merge function to resolve conflicts
     * @return The transaction result
     */
    DataTransactionResult copyFrom(int xTo, int yTo, int zTo, DataHolder from, MergeFunction function);

    /**
     * Attempts to copy all {@link ImmutableValue}s from the provided block to
     * provided block to the provided block coordinates. Any conflicting data
     * is handled through the provided {@link MergeFunction}.
     *
     * @param coordinatesTo The coordinates of the block copying data to
     * @param coordinatesFrom The coordinates of the block to copy data from
     * @param function The merge function to resolve conflicts
     * @return The transaction result
     */
    DataTransactionResult copyFrom(Vector3i coordinatesTo, Vector3i coordinatesFrom, MergeFunction function);

    /**
     * Attempts to copy all {@link ImmutableValue}s from the provided block to
     * provided block to the provided block coordinates. Any conflicting data
     * is handled through the provided {@link MergeFunction}.
     *
     * @param xTo The X position
     * @param yTo The Y position
     * @param zTo The Z position
     * @param xFrom The X position
     * @param yFrom The Y position
     * @param zFrom The Z position
     * @param function The merge resolving function
     * @return The transaction result
     */
    DataTransactionResult copyFrom(int xTo, int yTo, int zTo, int xFrom, int yFrom, int zFrom, MergeFunction function);

    /**
     * Gets an copied collection of all known {@link DataManipulator}s
     * belonging to the block at the given position. An individual
     * {@link DataManipulator} can be used for creating new data to replace
     * on the block at the given position.
     *
     * @param coordinates The position of the block
     * @return A collection of copied data manipulators belonging to the block
     *     at the given position
     */
    Collection<DataManipulator<?, ?>> getManipulators(Vector3i coordinates);

    /**
     * Gets an copied collection of all known {@link DataManipulator}s
     * belonging to the block at the given position. An individual
     * {@link DataManipulator} can be used for creating new data to replace
     * on the block at the given position.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return A collection of copied data manipulators belonging to the block
     *     at the given position
     */
    Collection<DataManipulator<?, ?>> getManipulators(int x, int y, int z);

    /**
     * Validates the container with known data required to set the raw data to
     * the block at the given position. If the container is incomplete or
     * contains invalid data, <code>false</code> is returned.
     *
     * <p>This validation should be checked prior to calling
     * {@link #setRawData(Vector3i, DataView)} to avoid exceptions.</p>
     *
     * @param position The position of the block
     * @param container The raw data to validate
     * @return True if the data is valid
     */
    boolean validateRawData(Vector3i position, DataView container);

    /**
     * Validates the container with known data required to set the raw data to
     * the block at the given position. If the container is incomplete or
     * contains invalid data, <code>false</code> is returned.
     *
     * <p>This validation should be checked prior to calling
     * {@link #setRawData(Vector3i, DataView)} to avoid exceptions.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param container The raw data to validate
     * @return True if the data is valid
     */
    boolean validateRawData(int x, int y, int z, DataView container);

    /**
     * Attempts to set all data of the block at the given position according to
     * the {@link DataContainer}'s held information. Using this to modify known
     * {@link DataManipulator}s is unsupported and if the data is invalid, an
     * {@link InvalidDataException} is thrown.
     *
     * <p>This setter is used to provide setting custom data that is not
     * represented by the Data API, including forge mods and other
     * unknown data. Attempts at validating known {@link DataManipulator}s
     * contained in the data container are made with the assumption that all
     * necessary data exists.</p>
     *
     * @param position The position of the block
     * @param container A container containing all raw data to set on the block
     *     at the given position
     * @throws InvalidDataException If the container is missing or has invalid
     *     data that this holder will refuse
     */
    void setRawData(Vector3i position, DataView container) throws InvalidDataException;

    /**
     * Attempts to set all data of the block at the given position according to
     * the {@link DataContainer}'s held information. Using this to modify known
     * {@link DataManipulator}s is unsupported and if the data is invalid, an
     * {@link InvalidDataException} is thrown.
     *
     * <p>This setter is used to provide setting custom data that is not
     * represented by the Data API, including forge mods and other
     * unknown data. Attempts at validating known {@link DataManipulator}s
     * contained in the data container are made with the assumption that all
     * necessary data exists.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param container A container containing all raw data to set on the block
     *     at the given position
     * @throws InvalidDataException If the container is missing or has invalid
     *     data that this holder will refuse
     */
    void setRawData(int x, int y, int z, DataView container) throws InvalidDataException;

}
