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
package org.spongepowered.api.data.property;

import org.spongepowered.api.util.Direction;
import org.spongepowered.math.vector.Vector3i;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface LocationBasePropertyHolder {

    /**
     * Attempts to retrieve a value for the specified {@link Property} from
     * the block at the specified location. If the property is not applicable,
     * {@link Optional#empty()} is returned.
     *
     * <p>Sometimes can a property not be retrieved because it's missing
     * directional information. In that case you should use
     * {@link #getProperty(Vector3i, Direction, Property)} instead.</p>
     *
     * <p>{@link Property}s can define various immutable information about a
     * {@link PropertyHolder} that is dependent on the instance of the holder.
     * As {@link Property}s cannot be changed, the {@link PropertyHolder} can
     * not change the information about it's own properties either.</p>
     *
     * <p>The catalog {@link Properties} lists most of the available properties.</p>
     *
     * @param coords The coordinates of the block
     * @param property The property to retrieve the value for
     * @param <V> The property value type
     * @return The property value, if available
     */
    default <V> Optional<V> getProperty(Vector3i coords, Property<V> property) {
        return getProperty(coords.getX(), coords.getY(), coords.getZ(), property);
    }

    /**
     * Attempts to retrieve a value for the specified {@link Property} from
     * the block at the specified location. If the property is not applicable,
     * {@link Optional#empty()} is returned.
     *
     * <p>Sometimes can a property not be retrieved because it's missing
     * directional information. In that case you should use
     * {@link #getProperty(Vector3i, Direction, Property)} instead.</p>
     *
     * <p>{@link Property}s can define various immutable information about a
     * {@link PropertyHolder} that is dependent on the instance of the holder.
     * As {@link Property}s cannot be changed, the {@link PropertyHolder} can
     * not change the information about it's own properties either.</p>
     *
     * <p>The catalog {@link Properties} lists most of the available properties.</p>
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param z The z coordinate
     * @param property The property to retrieve the value for
     * @param <V> The property value type
     * @return The property value, if available
     */
    <V> Optional<V> getProperty(int x, int y, int z, Property<V> property);

    /**
     * Attempts to retrieve a integer value for the specified {@link Property} from
     * the block at the specified location. If the property is not applicable,
     * {@link OptionalInt#empty()} is returned.
     *
     * @param coords The coordinates of the block
     * @param property The property to retrieve the value for
     * @return The integer property value, if available
     * @see #getProperty(Vector3i, Property)
     */
    default OptionalInt getIntProperty(Vector3i coords, Property<Integer> property) {
        return getIntProperty(coords.getX(), coords.getY(), coords.getZ(), property);
    }

    /**
     * Attempts to retrieve a integer value for the specified {@link Property} from
     * the block at the specified location. If the property is not applicable,
     * {@link OptionalInt#empty()} is returned.
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param z The z coordinate
     * @param property The property to retrieve the value for
     * @return The integer property value, if available
     * @see #getProperty(int, int, int, Property)
     */
    OptionalInt getIntProperty(int x, int y, int z, Property<Integer> property);

    /**
     * Attempts to retrieve a double value for the specified {@link Property} from
     * the block at the specified location. If the property is not applicable,
     * {@link OptionalDouble#empty()} is returned.
     *
     * @param coords The coordinates of the block
     * @param property The property to retrieve the value for
     * @return The double property value, if available
     * @see #getProperty(Vector3i, Property)
     */
    default OptionalDouble getDoubleProperty(Vector3i coords, Property<Double> property) {
        return getDoubleProperty(coords.getX(), coords.getY(), coords.getZ(), property);
    }

    /**
     * Attempts to retrieve a double value for the specified {@link Property} from
     * the block at the specified location. If the property is not applicable,
     * {@link OptionalDouble#empty()} is returned.
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param z The z coordinate
     * @param property The property to retrieve the value for
     * @return The double property value, if available
     * @see #getProperty(int, int, int, Property)
     */
    OptionalDouble getDoubleProperty(int x, int y, int z, Property<Double> property);

    /**
     * Attempts to retrieve a value for the specified {@link Property} from
     * the block at the specified location on the given block face. If the
     * property is not applicable, {@link Optional#empty()} is returned.
     *
     * <p>{@link Property}s can define various immutable information about a
     * {@link PropertyHolder} that is dependent on the instance of the holder.
     * As {@link Property}s cannot be changed, the {@link PropertyHolder} can
     * not change the information about it's own properties either.</p>
     *
     * <p>The catalog {@link Properties} lists most of the available properties.</p>
     *
     * @param coords The coordinates
     * @param direction The face of the block
     * @param property The property to retrieve the value for
     * @param <V> The property value type
     * @return The property value, if available
     */
    default <V> Optional<V> getProperty(Vector3i coords, Direction direction, Property<V> property) {
        return getProperty(coords.getX(), coords.getY(), coords.getZ(), direction, property);
    }

    /**
     * Attempts to retrieve a value for the specified {@link Property} from
     * the block at the specified location on the given block face. If the
     * property is not applicable, {@link Optional#empty()} is returned.
     *
     * <p>{@link Property}s can define various immutable information about a
     * {@link PropertyHolder} that is dependent on the instance of the holder.
     * As {@link Property}s cannot be changed, the {@link PropertyHolder} can
     * not change the information about it's own properties either.</p>
     *
     * <p>The catalog {@link Properties} lists most of the available properties.</p>
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param z The z coordinate
     * @param direction The face of the block
     * @param property The property to retrieve the value for
     * @param <V> The property value type
     * @return The property value, if available
     */
    <V> Optional<V> getProperty(int x, int y, int z, Direction direction, Property<V> property);

    /**
     * Attempts to retrieve a integer value for the specified {@link Property} from
     * the block at the specified location on the given block face. If the
     * property is not applicable, {@link OptionalInt#empty()} is returned.
     *
     * @param coords The coordinates
     * @param direction The face of the block
     * @param property The property to retrieve the value for
     * @return The integer property value, if available
     * @see #getProperty(Vector3i, Direction, Property)
     */
    default OptionalInt getIntProperty(Vector3i coords, Direction direction, Property<Integer> property) {
        return getIntProperty(coords.getX(), coords.getY(), coords.getZ(), direction, property);
    }

    /**
     * Attempts to retrieve a integer value for the specified {@link Property} from
     * the block at the specified location on the given block face. If the
     * property is not applicable, {@link OptionalInt#empty()} is returned.
     *
     * <p>{@link Property}s can define various immutable information about a
     * {@link PropertyHolder} that is dependent on the instance of the holder.
     * As {@link Property}s cannot be changed, the {@link PropertyHolder} can
     * not change the information about it's own properties either.</p>
     *
     * <p>The catalog {@link Properties} lists most of the available properties.</p>
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param z The z coordinate
     * @param direction The face of the block
     * @param property The property to retrieve the value for
     * @return The integer property value, if available
     * @see #getProperty(int, int, int, Direction, Property)
     */
    OptionalInt getIntProperty(int x, int y, int z, Direction direction, Property<Integer> property);

    /**
     * Attempts to retrieve a double value for the specified {@link Property} from
     * the block at the specified location on the given block face. If the
     * property is not applicable, {@link OptionalDouble#empty()} is returned.
     *
     * @param coords The coordinates
     * @param direction The face of the block
     * @param property The property to retrieve the value for
     * @return The double property value, if available
     * @see #getProperty(Vector3i, Direction, Property)
     */
    default OptionalDouble getDoubleProperty(Vector3i coords, Direction direction, Property<Double> property) {
        return getDoubleProperty(coords.getX(), coords.getY(), coords.getZ(), direction, property);
    }

    /**
     * Attempts to retrieve a double value for the specified {@link Property} from
     * the block at the specified location on the given block face. If the
     * property is not applicable, {@link OptionalDouble#empty()} is returned.
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param z The z coordinate
     * @param direction The face of the block
     * @param property The property to retrieve the value for
     * @return The double property value, if available
     * @see #getProperty(int, int, int, Direction, Property)
     */
    OptionalDouble getDoubleProperty(int x, int y, int z, Direction direction, Property<Double> property);

    /**
     * Gets an immutable map of all known {@link Property}s that
     * are supported by this {@link PropertyHolder} mapped to their value.
     *
     * <p>{@link Property}s can not be changed such that the property is
     * attached to the instance of the residing {@link PropertyHolder}.</p>
     *
     * @param coords The coordinates
     * @return An immutable map of all known {@link Property}s
     */
    default Map<Property<?>, ?> getProperties(Vector3i coords) {
        return getProperties(coords.getX(), coords.getY(), coords.getZ());
    }

    /**
     * Gets an immutable map of all known {@link Property}s that
     * are supported by this {@link PropertyHolder} mapped to their value.
     *
     * <p>{@link Property}s can not be changed such that the property is
     * attached to the instance of the residing {@link PropertyHolder}.</p>
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param z The z coordinate
     * @return An immutable map of all known {@link Property}s
     */
    Map<Property<?>, ?> getProperties(int x, int y, int z);

    /**
     * Gets all the faces of this block that have the given property.
     *
     * @param coords The coordinates
     * @param property The property
     * @return All faces with the property
     */
    default Collection<Direction> getFacesWithProperty(Vector3i coords, Property<?> property) {
        return getFacesWithProperty(coords.getX(), coords.getY(), coords.getZ(), property);
    }

    /**
     * Gets all the faces of this block that have the given property.
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param z The z coordinate
     * @param property The property
     * @return All faces with the property
     */
    Collection<Direction> getFacesWithProperty(int x, int y, int z, Property<?> property);

}
