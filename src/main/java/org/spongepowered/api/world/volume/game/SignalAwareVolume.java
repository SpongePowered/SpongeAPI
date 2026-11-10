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

import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.SignalType;
import org.spongepowered.math.vector.Vector3i;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * A volume aware of the signal that can "power" blocks. <br>
 * This signal is often referred to as "redstone signal".
 */
public interface SignalAwareVolume extends PrimitiveGameVolume {

    /**
     * Returns whether the given position can conduct the signal.
     *
     * @param x The x position
     * @param y The y position
     * @param z The z position
     * @return True if the given position can conduct the signal
     */
    boolean canConductSignal(int x, int y, int z);

    /**
     * Returns whether the given position can conduct the signal.
     *
     * @param position The position
     * @return True if the given position can conduct the signal
     */
    default boolean canConductSignal(final Vector3i position) {
        Objects.requireNonNull(position, "position");
        return this.canConductSignal(position.x(), position.y(), position.z());
    }

    /**
     * Returns whether the given position can emit the signal of the given type.
     *
     * @param type The signal type
     * @param x The x position
     * @param y The y position
     * @param z The z position
     * @return True if the given position can emit the signal of the given type
     */
    boolean canEmitSignal(SignalType type, int x, int y, int z);

    /**
     * Returns whether the given position can emit the signal of the given type.
     *
     * @param type The signal type
     * @param x The x position
     * @param y The y position
     * @param z The z position
     * @return True if the given position can emit the signal of the given type
     */
    default boolean canEmitSignal(final Supplier<? extends SignalType> type, final int x, final int y, final int z) {
        Objects.requireNonNull(type, "type");
        return this.canEmitSignal(type.get(), x, y, z);
    }

    /**
     * Returns whether the given position can emit the signal of the given type.
     *
     * @param type The signal type
     * @param position The position
     * @return True if the given position can emit the signal of the given type
     */
    default boolean canEmitSignal(final SignalType type, final Vector3i position) {
        Objects.requireNonNull(position, "position");
        return this.canEmitSignal(type, position.x(), position.y(), position.z());
    }

    /**
     * Returns whether the given position can emit the signal of the given type.
     *
     * @param type The signal type
     * @param position The position
     * @return True if the given position can emit the signal of the given type
     */
    default boolean canEmitSignal(final Supplier<? extends SignalType> type, final Vector3i position) {
        Objects.requireNonNull(type, "type");
        Objects.requireNonNull(position, "position");
        return this.canEmitSignal(type.get(), position.x(), position.y(), position.z());
    }

    /**
     * Returns the signal of the given type emitted from the given position in the given direction.
     *
     * @param type The signal type
     * @param x The x position
     * @param y The y position
     * @param z The z position
     * @param direction The direction
     * @return The signal of the given type emitted from the given position in the given direction
     */
    int signalFrom(SignalType type, int x, int y, int z, Direction direction);

    /**
     * Returns the signal of the given type emitted from the given position in the given direction.
     *
     * @param type The signal type
     * @param x The x position
     * @param y The y position
     * @param z The z position
     * @param direction The direction
     * @return The signal of the given type emitted from the given position in the given direction
     */
    default int signalFrom(final Supplier<? extends SignalType> type, final int x, final int y, final int z, final Direction direction) {
        Objects.requireNonNull(type, "type");
        return this.signalFrom(type.get(), x, y, z, direction);
    }

    /**
     * Returns the signal of the given type emitted from the given position in the given direction.
     *
     * @param type The signal type
     * @param position The position
     * @param direction The direction
     * @return The signal of the given type emitted from the given position in the given direction
     */
    default int signalFrom(final SignalType type, final Vector3i position, final Direction direction) {
        Objects.requireNonNull(position, "position");
        return this.signalFrom(type, position.x(), position.y(), position.z(), direction);
    }

    /**
     * Returns the signal of the given type emitted from the given position in the given direction.
     *
     * @param type The signal type
     * @param position The position
     * @param direction The direction
     * @return The signal of the given type emitted from the given position in the given direction
     */
    default int signalFrom(final Supplier<? extends SignalType> type, final Vector3i position, final Direction direction) {
        Objects.requireNonNull(type, "type");
        Objects.requireNonNull(position, "position");
        return this.signalFrom(type.get(), position.x(), position.y(), position.z(), direction);
    }

    /**
     * Returns whether there is signal of the given type emitted from the given position in the given direction.
     *
     * @param type The signal type
     * @param x The x position
     * @param y The y position
     * @param z The z position
     * @param direction The direction
     * @return True if there is signal of the given type emitted from the given position in the given direction
     */
    default boolean hasSignalFrom(final SignalType type, final int x, final int y, final int z, final Direction direction) {
        return this.signalFrom(type, x, y, z, direction) > 0;
    }

    /**
     * Returns whether there is signal of the given type emitted from the given position in the given direction.
     *
     * @param type The signal type
     * @param x The x position
     * @param y The y position
     * @param z The z position
     * @param direction The direction
     * @return True if there is signal of the given type emitted from the given position in the given direction
     */
    default boolean hasSignalFrom(final Supplier<? extends SignalType> type, final int x, final int y, final int z, final Direction direction) {
        Objects.requireNonNull(type, "type");
        return this.hasSignalFrom(type.get(), x, y, z, direction);
    }

    /**
     * Returns whether there is signal of the given type emitted from the given position in the given direction.
     *
     * @param type The signal type
     * @param position The position
     * @param direction The direction
     * @return True if there is signal of the given type emitted from the given position in the given direction
     */
    default boolean hasSignalFrom(final SignalType type, final Vector3i position, final Direction direction) {
        Objects.requireNonNull(position, "position");
        return this.hasSignalFrom(type, position.x(), position.y(), position.z(), direction);
    }

    /**
     * Returns whether there is signal of the given type emitted from the given position in the given direction.
     *
     * @param type The signal type
     * @param position The position
     * @param direction The direction
     * @return True if there is signal of the given type emitted from the given position in the given direction
     */
    default boolean hasSignalFrom(final Supplier<? extends SignalType> type, final Vector3i position, final Direction direction) {
        Objects.requireNonNull(type, "type");
        Objects.requireNonNull(position, "position");
        return this.hasSignalFrom(type.get(), position.x(), position.y(), position.z(), direction);
    }

    /**
     * Returns the highest signal of the given type emitted towards the given position from its neighbours.
     *
     * @param type The signal type
     * @param x The x position
     * @param y The y position
     * @param z The z position
     * @return The highest signal of the given type emitted towards the given position from its neighbours
     */
    int highestSignalAt(SignalType type, int x, int y, int z);

    /**
     * Returns the highest signal of the given type emitted towards the given position from its neighbours.
     *
     * @param type The signal type
     * @param x The x position
     * @param y The y position
     * @param z The z position
     * @return The highest signal of the given type emitted towards the given position from its neighbours
     */
    default int highestSignalAt(final Supplier<? extends SignalType> type, final int x, final int y, final int z) {
        Objects.requireNonNull(type, "type");
        return this.highestSignalAt(type.get(), x, y, z);
    }

    /**
     * Returns the highest signal of the given type emitted towards the given position from its neighbours.
     *
     * @param type The signal type
     * @param position The position
     * @return The highest signal of the given type emitted towards the given position from its neighbours
     */
    default int highestSignalAt(final SignalType type, final Vector3i position) {
        Objects.requireNonNull(position, "position");
        return this.highestSignalAt(type, position.x(), position.y(), position.z());
    }

    /**
     * Returns the highest signal of the given type emitted towards the given position from its neighbours.
     *
     * @param type The signal type
     * @param position The position
     * @return The highest signal of the given type emitted towards the given position from its neighbours
     */
    default int highestSignalAt(final Supplier<? extends SignalType> type, final Vector3i position) {
        Objects.requireNonNull(type, "type");
        Objects.requireNonNull(position, "position");
        return this.highestSignalAt(type.get(), position.x(), position.y(), position.z());
    }

    /**
     * Returns whether there is any signal of the given type emitted towards the given position from its neighbours.
     *
     * @param type The signal type
     * @param x The x position
     * @param y The y position
     * @param z The z position
     * @return True if there is any signal of the given type emitted towards the given position from its neighbours
     */
    default boolean hasSignalAt(final SignalType type, final int x, final int y, final int z) {
        return this.highestSignalAt(type, x, y, z) > 0;
    }

    /**
     * Returns whether there is any signal of the given type emitted towards the given position from its neighbours.
     *
     * @param type The signal type
     * @param x The x position
     * @param y The y position
     * @param z The z position
     * @return True if there is any signal of the given type emitted towards the given position from its neighbours
     */
    default boolean hasSignalAt(final Supplier<? extends SignalType> type, final int x, final int y, final int z) {
        Objects.requireNonNull(type, "type");
        return this.hasSignalAt(type.get(), x, y, z);
    }

    /**
     * Returns whether there is any signal of the given type emitted towards the given position from its neighbours.
     *
     * @param type The signal type
     * @param position The position
     * @return True if there is any signal of the given type emitted towards the given position from its neighbours
     */
    default boolean hasSignalAt(final SignalType type, final Vector3i position) {
        Objects.requireNonNull(position, "position");
        return this.hasSignalAt(type, position.x(), position.y(), position.z());
    }

    /**
     * Returns whether there is any signal of the given type emitted towards the given position from its neighbours.
     *
     * @param type The signal type
     * @param position The position
     * @return True if there is any signal of the given type emitted towards the given position from its neighbours
     */
    default boolean hasSignalAt(final Supplier<? extends SignalType> type, final Vector3i position) {
        Objects.requireNonNull(type, "type");
        Objects.requireNonNull(position, "position");
        return this.hasSignalAt(type.get(), position.x(), position.y(), position.z());
    }
}
