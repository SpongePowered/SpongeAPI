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
package org.spongepowered.api.world.volume.biome;

import org.spongepowered.api.util.PositionOutOfBoundsException;
import org.spongepowered.api.world.biome.Biome;
import org.spongepowered.api.world.volume.ImmutableVolume;
import org.spongepowered.api.world.volume.MutableVolume;
import org.spongepowered.api.world.volume.UnmodifiableVolume;
import org.spongepowered.api.world.volume.Volume;
import org.spongepowered.api.world.volume.block.BlockVolume;
import org.spongepowered.api.world.volume.stream.StreamOptions;
import org.spongepowered.api.world.volume.stream.VolumeStream;
import org.spongepowered.math.vector.Vector3i;

import java.util.Objects;

public interface BiomeVolume extends Volume {

    /**
     * Gets an object representing the biome at the given position.
     *
     * @param position The position
     * @return The biome
     * @throws PositionOutOfBoundsException If the position is outside of the
     *         bounds of the volume
     */
    default Biome getBiome(final Vector3i position) {
        Objects.requireNonNull(position, "position");
        return this.getBiome(position.getX(), position.getY(), position.getZ());
    }

    /**
     * Gets the {@link Biome} at the given location.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return The biome
     * @throws PositionOutOfBoundsException If the position is outside of the
     *         bounds of the volume
     */
    Biome getBiome(int x, int y, int z);

    interface Streamable<B extends Streamable<B>> extends BiomeVolume {

        /**
         * Gets a {@link VolumeStream}&lt;{@code B, }{@link Biome}&gt;
         * from this volume such that the {@code min} and {@code max} are contained
         * within this volume.
         *
         * @param min The minimum coordinate set
         * @param max The maximum coordinate set
         * @param options The options to construct the stream
         * @return The volume stream
         */
        VolumeStream<B, Biome> getBiomeStream(Vector3i min, Vector3i max, StreamOptions options);
    }

    /**
     * Like a {@link BlockVolume} except in the case that
     * while the parent volume can potentially be a {@link MutableVolume},
     * this volume returned will not be. This is useful if needing to simply
     * scan blocks or use {@link java.util.stream.Stream}s to perform various operations.
     */
    interface Unmodifiable<U extends Unmodifiable<U>> extends BiomeVolume, Streamable<U>, UnmodifiableVolume {

    }

    interface Mutable<M extends Mutable<M>> extends Streamable<M>, MutableVolume {

        /**
         * Sets the {@link Biome} at the given position in this volume.
         *
         * @param position The position
         * @param biome The biome type
         * @return Whether the biome change was successful
         * @throws PositionOutOfBoundsException If the position is outside of the
         *                                      bounds of the volume
         */
        default boolean setBiome(Vector3i position, Biome biome) {
            return this.setBiome(position.getX(), position.getY(), position.getZ(), biome);
        }

        /**
         * Sets the {@link Biome} at the given position in this volume.
         *
         * @param x The X position
         * @param y The Y position
         * @param z The Z position
         * @param biome The biome type
         * @return Whether the biome change was successful
         * @throws PositionOutOfBoundsException If the position is outside of the
         *                                      bounds of the volume
         */
        boolean setBiome(int x, int y, int z, Biome biome);

    }

    interface Immutable extends Unmodifiable<Immutable>, ImmutableVolume {

    }
}
