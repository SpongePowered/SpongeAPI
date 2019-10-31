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
package org.spongepowered.api.world.volume.game;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableSet;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.data.value.MergeFunction;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.world.Location;
import org.spongepowered.math.vector.Vector3i;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Set;
import java.util.function.Function;

/**
 * A type of {@link Location} based value store that can handle proxied data api
 * related queries for specific positions.
 */
public interface LocationBaseDataHolder {

    /**
     * Gets the value of data that is keyed to the provided {@link Key} at the
     * give block location.
     *
     * @param position The position of the block
     * @param key The key to the data
     * @param <E> The type of element of data
     * @return The data, if available
     */
    default <E> Optional<E> get(Vector3i position, Key<? extends Value<E>> key) {
        return this.get(position.getX(), position.getY(), position.getZ(), key);
    }

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
    <E> Optional<E> get(int x, int y, int z, Key<? extends Value<E>> key);

    /**
     * Gets the int value of data that is keyed to the provided {@link Key} at the
     * give block location.
     *
     * @param position The position of the block
     * @param key The key to the data
     * @return The data, if available
     */
    default OptionalInt getInt(Vector3i position, Key<? extends Value<Integer>> key) {
        return this.getInt(position.getX(), position.getY(), position.getZ(), key);
    }

    /**
     * Gets the int value of data that is keyed to the provided {@link Key} at the
     * give block location.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param key The key to the data
     * @return The data, if available
     */
    default OptionalInt getInt(int x, int y, int z, Key<? extends Value<Integer>> key) {
        return this.get(x, y, z, key).map(OptionalInt::of).orElse(OptionalInt.empty());
    }

    /**
     * Gets the double value of data that is keyed to the provided {@link Key} at the
     * give block location.
     *
     * @param position The position of the block
     * @param key The key to the data
     * @return The data, if available
     */
    default OptionalDouble getDouble(Vector3i position, Key<? extends Value<Double>> key) {
        return this.getDouble(position.getX(), position.getY(), position.getZ(), key);
    }

    /**
     * Gets the double value of data that is keyed to the provided {@link Key} at the
     * give block location.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param key The key to the data
     * @return The data, if available
     */
    default OptionalDouble getDouble(int x, int y, int z, Key<? extends Value<Double>> key) {
        return this.get(x, y, z, key).map(OptionalDouble::of).orElse(OptionalDouble.empty());
    }

    /**
     * Gets the long value of data that is keyed to the provided {@link Key} at the
     * give block location.
     *
     * @param position The position of the block
     * @param key The key to the data
     * @return The data, if available
     */
    default OptionalLong getLong(Vector3i position, Key<? extends Value<Long>> key) {
        return this.getLong(position.getX(), position.getY(), position.getZ(), key);
    }

    /**
     * Gets the long value of data that is keyed to the provided {@link Key} at the
     * give block location.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param key The key to the data
     * @return The data, if available
     */
    default OptionalLong getLong(int x, int y, int z, Key<? extends Value<Long>> key) {
        return this.get(x, y, z, key).map(OptionalLong::of).orElse(OptionalLong.empty());
    }

    /**
     * Attempts to get the underlying value backed by a {@link Value}
     * linked to the provided {@link Key}.
     *
     * <p>If the {@link Key} is not supported or
     * available, {@link NoSuchElementException} will be thrown.</p>
     *
     * @param position The position of the block
     * @param key The key
     * @param <E> The type of value
     * @return The value
     * @throws NoSuchElementException If the value is not supported or present
     */
    default <E> E require(Vector3i position, Key<? extends Value<E>> key) {
        return this.require(position.getX(), position.getY(), position.getZ(), key);
    }

    /**
     * Attempts to get the underlying value backed by a {@link Value}
     * linked to the provided {@link Key}.
     *
     * <p>If the {@link Key} is not supported or
     * available, {@link NoSuchElementException} will be thrown.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param key The key
     * @param <E> The type of value
     * @return The value
     * @throws NoSuchElementException If the value is not supported or present
     */
    default <E> E require(int x, int y, int z, Key<? extends Value<E>> key) {
        final Optional<E> optional = this.get(x, y, z, key);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new NoSuchElementException(String.format("Could not retrieve value for key '%s'", key.toString()));
    }

    /**
     * Gets the value of data that is keyed to the provided {@link Key} at the
     * give block location. The data may not exist, or may not be compatible in
     * which case <code>null</code> may be returned.
     *
     * @param position The position of the block
     * @param key The key to the data
     * @param <E> The type of element of data
     * @return The data or null
     */
    default <E> @Nullable E getOrNull(Vector3i position, Key<? extends Value<E>> key) {
        return this.get(position.getX(), position.getY(), position.getZ(), key).orElse(null);
    }

    /**
     * Gets the value of data that is keyed to the provided {@link Key} at the
     * give block location. The data may not exist, or may not be compatible in
     * which case <code>null</code> may be returned.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param key The key to the data
     * @param <E> The type of element of data
     * @return The data or null
     */
    default <E> @Nullable E getOrNull(int x, int y, int z, Key<? extends Value<E>> key) {
        return this.get(x, y, z, key).orElse(null);
    }

    /**
     * Gets the value of data that is keyed to the provided {@link Key} at the
     * give block location. The data may not exist, or may not be compatible in
     * which case the default value may be returned.
     *
     * @param position The position of the block
     * @param key The key to the data
     * @param defaultValue The default value to be provided
     * @param <E> The type of element of data
     * @return The data or null
     */
    default <E> E getOrElse(Vector3i position, Key<? extends Value<E>> key, E defaultValue) {
        return this.get(position.getX(), position.getY(), position.getZ(), key).orElse(checkNotNull(defaultValue));
    }

    /**
     * Gets the value of data that is keyed to the provided {@link Key} at the
     * give block location. The data may not exist, or may not be compatible in
     * which case the default value may be returned.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param key The key to the data
     * @param defaultValue The default value to return
     * @param <E> The type of element of data
     * @return The data or null
     */
    default <E> E getOrElse(int x, int y, int z, Key<? extends Value<E>> key, E defaultValue) {
        return this.get(x, y, z, key).orElse(checkNotNull(defaultValue));
    }

    /**
     * Gets the value of data that is keyed to the provided {@link Key} at the
     * give block location. The data may not exist, or may not be compatible in
     * which case <code>null</code> may be returned.
     *
     * @param position The position of the block
     * @param key The key to the data
     * @param <E> The type of element of data
     * @param <V> The type of value
     * @return The base value, if available
     */
    default <E, V extends Value<E>> Optional<V> getValue(Vector3i position, Key<V> key) {
        return this.getValue(position.getX(), position.getY(), position.getZ(), key);
    }

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
    <E, V extends Value<E>> Optional<V> getValue(int x, int y, int z, Key<V> key);

    /**
     * Checks if the provided {@link Key} to the data is supported by the block
     * at the provided location.
     *
     * @param position The position of the block
     * @param key The Key to the value of data
     * @return True if the block supports the data
     */
    default boolean supports(Vector3i position, Key<?> key) {
        return this.supports(position.getX(), position.getY(), position.getZ(), key);
    }

    /**
     * Checks if the provided {@link Key} to the data is supported by the block
     * at the provided location.
     *
     * @param x The X coordinate
     * @param y The Y coordinate
     * @param z The Z coordinate
     * @param key The Key to the value of data
     * @return True if the block supports the data
     */
    boolean supports(int x, int y, int z, Key<?> key);

    /**
     * Checks if the provided {@link Value} is supported by the block at the
     * provided location.
     *
     * @param position The position of the block
     * @param value The value of data
     * @return True if the block supports the data
     */
    default boolean supports(Vector3i position, Value<?> value) {
        return this.supports(position.getX(), position.getY(), position.getZ(), value.getKey());
    }

    /**
     * Checks if the provided {@link Value} is supported by the block at the
     * provided location.
     *
     * @param x The X coordinate
     * @param y The Y coordinate
     * @param z The Z coordinate
     * @param value The value of data
     * @return True if the block supports the data
     */
    default boolean supports(int x, int y, int z, Value<?> value) {
        return this.supports(x, y, z, value.getKey());
    }

    /**
     * Gets an {@link ImmutableSet} of {@link Key}s for the block at the given
     * location.
     *
     * @param position The position of the block
     * @return The immutable set of values for the block
     */
    default Set<Key<?>> getKeys(Vector3i position) {
        return this.getKeys(position.getX(), position.getY(), position.getZ());
    }

    /**
     * Gets an {@link ImmutableSet} of {@link Key}s for the block at the given
     * location.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return The immutable set of values for the block
     */
    Set<Key<?>> getKeys(int x, int y, int z);

    /**
     * Gets an {@link ImmutableSet} of {@link org.spongepowered.api.data.value.Value.Immutable}s for the block at
     * the given location.
     *
     * @param position The position of the block
     * @return The immutable set of values for the block
     */
    default Set<Value.Immutable<?>> getValues(Vector3i position) {
        return this.getValues(position.getX(), position.getY(), position.getZ());
    }

    /**
     * Gets an {@link ImmutableSet} of {@link org.spongepowered.api.data.value.Value.Immutable}s for the block at
     * the given location.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return The immutable set of values for the block
     */
    Set<Value.Immutable<?>> getValues(int x, int y, int z);

    interface Mutable extends LocationBaseDataHolder {

        /**
         * Applies a transformation on the pre-existing value of the data keyed by
         * the provided {@link Key} and returns a {@link DataTransactionResult} of
         * said transformation.
         *
         * @param position The position of the block
         * @param key The key to the data
         * @param function The function applying the transformation
         * @param <E> The type of data
         * @return The transaction result
         */
        default <E> DataTransactionResult transform(Vector3i position, Key<? extends Value<E>> key, Function<E, E> function) {
            return this.transform(position.getX(), position.getY(), position.getZ(), key, function);
        }

        /**
         * Applies a transformation on the pre-existing value of the data keyed by
         * the provided {@link Key} and returns a {@link DataTransactionResult} of
         * said transformation.
         *
         * @param x The X position
         * @param y The Y position
         * @param z The Z position
         * @param key The key to the data
         * @param function The function applying the transformation
         * @param <E> The type of data
         * @return The transaction result
         */
        default <E> DataTransactionResult transform(int x, int y, int z, Key<? extends Value<E>> key, Function<E, E> function) {
            if (this.supports(x, y, z, key)) {
                final Optional<E> optional = this.get(x, y, z, key);
                if (optional.isPresent()) {
                    return this.offer(x, y, z, key, function.apply(optional.get()));
                }
            }
            return DataTransactionResult.failNoData();
        }

        /**
         * Offers the given <code>E</code> value that is keyed by the provided
         * {@link Key} to the block at the provided location.
         *
         * <p>If any data is rejected or existing data is replaced, the
         * {@link DataTransactionResult} will retain the rejected and replaced
         * data.</p>
         *
         * @param position The position of the block
         * @param key The key for the data
         * @param value The value to offer
         * @param <E> The type of data being offered
         * @return The transaction result
         */
        default <E> DataTransactionResult offer(Vector3i position, Key<? extends Value<E>> key, E value) {
            return this.offer(position.getX(), position.getY(), position.getZ(), key, value);
        }

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
        <E> DataTransactionResult offer(int x, int y, int z, Key<? extends Value<E>> key, E value);

        /**
         * Offers the given {@link Value} to the block at the given position.
         *
         * <p>If any data is rejected or existing data is replaced, the
         * {@link DataTransactionResult} will retain the rejected and replaced
         * data.</p>
         *
         * @param position The position of the block
         * @param value The value to offer
         * @param <E> The type of the element wrapped by the value
         * @return The transaction result
         */
        default <E> DataTransactionResult offer(Vector3i position, Value<E> value) {
            return this.offer(position.getX(), position.getY(), position.getZ(), value.getKey(), value.get());
        }

        /**
         * Offers the given {@link Value} to the block at the given position.
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
        default <E> DataTransactionResult offer(int x, int y, int z, Value<E> value) {
            return this.offer(x, y, z, value.getKey(), value.get());
        }

        /**
         * Attempts to remove the data associated with the provided {@link Key} from
         * the block at the provided location.
         *
         * @param position The position of the block
         * @param key The key to the data to remove
         * @return The transaction result
         */
        default DataTransactionResult remove(Vector3i position, Key<?> key) {
            return this.remove(position.getX(), position.getY(), position.getZ(), key);
        }

        /**
         * Attempts to remove the data associated with the provided {@link Key} from
         * the block at the provided location.
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
         * {@link org.spongepowered.api.data.value.Value.Immutable}s that were successfully added are removed, and all
         * replaced {@link org.spongepowered.api.data.value.Value.Immutable}s are offered.
         *
         * @param position The position of the block
         * @param result The transaction result to undo
         * @return The transaction result
         */
        default DataTransactionResult undo(Vector3i position, DataTransactionResult result) {
            return this.undo(position.getX(), position.getY(), position.getZ(), result);
        }

        /**
         * Attempts to undo a {@link DataTransactionResult}. Specifically, all
         * {@link org.spongepowered.api.data.value.Value.Immutable}s that were successfully added are removed, and all
         * replaced {@link org.spongepowered.api.data.value.Value.Immutable}s are offered.
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
         * {@link DataHolder} to the block at the provided position.
         *
         * @param to The position of the block
         * @param from The data holder to copy data from
         * @return The transaction result
         */
        default DataTransactionResult copyFrom(Vector3i to, DataHolder from) {
            return this.copyFrom(to.getX(), to.getY(), to.getZ(), from);
        }

        /**
         * Attempts to copy all the relevant data from the provided
         * {@link DataHolder} to the block at the provided position.
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
         * {@link DataHolder} to the block at the provided position.
         *
         * @param positionTo The position of the block
         * @param positionFrom The position of the block to copy data from
         * @return The transaction result
         */
        default DataTransactionResult copyFrom(Vector3i positionTo, Vector3i positionFrom) {
            return this.copyFrom(positionTo.getX(), positionTo.getY(), positionTo.getZ(),
                    positionFrom.getX(), positionFrom.getY(), positionFrom.getZ(),
                    MergeFunction.REPLACEMENT_PREFERRED);
        }

        /**
         * Attempts to copy all {@link org.spongepowered.api.data.value.Value.Immutable}s from the provided block to
         * provided block to the provided block position.
         *
         * @param xTo The X position of the block to copy data to
         * @param yTo The Y position of the block to copy data to
         * @param zTo The Z position of the block to copy data to
         * @param xFrom The X position of the block to copy data from
         * @param yFrom The Y position of the block to copy data from
         * @param zFrom The Z position of the block to copy data from
         * @return The transaction result
         */
        default DataTransactionResult copyFrom(int xTo, int yTo, int zTo, int xFrom, int yFrom, int zFrom) {
            return this.copyFrom(xTo, yTo, zTo, xFrom, yFrom, zFrom, MergeFunction.REPLACEMENT_PREFERRED);
        }

        /**
         * Attempts to copy all {@link org.spongepowered.api.data.value.Value.Immutable}s from the provided block to
         * provided block to the provided block position. Any conflicting data is
         * handled through the provided {@link MergeFunction}.
         *
         * @param to The block position to copy to
         * @param from the data holder to copy data from
         * @param function The merge function to resolve conflicts
         * @return The transaction result
         */
        default DataTransactionResult copyFrom(Vector3i to, DataHolder from, MergeFunction function) {
            return this.copyFrom(to.getX(), to.getY(), to.getZ(), from, function);
        }

        /**
         * Attempts to copy all {@link org.spongepowered.api.data.value.Value.Immutable}s from the provided block to
         * provided block to the provided block position. Any conflicting data is
         * handled through the provided {@link MergeFunction}.
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
         * Attempts to copy all {@link org.spongepowered.api.data.value.Value.Immutable}s from the provided block to
         * provided block to the provided block position. Any conflicting data is
         * handled through the provided {@link MergeFunction}.
         *
         * @param positionTo The position of the block copying data to
         * @param positionFrom The position of the block to copy data from
         * @param function The merge function to resolve conflicts
         * @return The transaction result
         */
        default DataTransactionResult copyFrom(Vector3i positionTo, Vector3i positionFrom, MergeFunction function) {
            return this.copyFrom(positionTo.getX(), positionTo.getY(), positionTo.getZ(),
                    positionFrom.getX(), positionFrom.getY(), positionFrom.getZ(), function);
        }

        /**
         * Attempts to copy all {@link org.spongepowered.api.data.value.Value.Immutable}s from the provided block to
         * provided block to the provided block position. Any conflicting data is
         * handled through the provided {@link MergeFunction}.
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
        default boolean validateRawData(Vector3i position, DataView container) {
            return this.validateRawData(position.getX(), position.getY(), position.getZ(), container);
        }

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
         * represented by the Data API, including forge mods and other unknown data.
         * Attempts at validating known {@link DataManipulator}s contained in the
         * data container are made with the assumption that all necessary data
         * exists.</p>
         *
         * @param position The position of the block
         * @param container A container containing all raw data to set on the block
         *        at the given position
         * @throws InvalidDataException If the container is missing or has invalid
         *         data that this holder will refuse
         */
        default void setRawData(Vector3i position, DataView container) throws InvalidDataException {
            this.setRawData(position.getX(), position.getY(), position.getZ(), container);
        }

        /**
         * Attempts to set all data of the block at the given position according to
         * the {@link DataContainer}'s held information. Using this to modify known
         * {@link DataManipulator}s is unsupported and if the data is invalid, an
         * {@link InvalidDataException} is thrown.
         *
         * <p>This setter is used to provide setting custom data that is not
         * represented by the Data API, including forge mods and other unknown data.
         * Attempts at validating known {@link DataManipulator}s contained in the
         * data container are made with the assumption that all necessary data
         * exists.</p>
         *
         * @param x The X position
         * @param y The Y position
         * @param z The Z position
         * @param container A container containing all raw data to set on the block
         *        at the given position
         * @throws InvalidDataException If the container is missing or has invalid
         *         data that this holder will refuse
         */
        void setRawData(int x, int y, int z, DataView container) throws InvalidDataException;

    }
}
