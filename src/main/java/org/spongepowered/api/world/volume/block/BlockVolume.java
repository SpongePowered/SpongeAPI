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
package org.spongepowered.api.world.volume.block;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.fluid.FluidState;
import org.spongepowered.api.registry.RegistryReference;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.util.PositionOutOfBoundsException;
import org.spongepowered.api.world.server.ServerLocation;
import org.spongepowered.api.world.schematic.Palette;
import org.spongepowered.api.world.schematic.PaletteTypes;
import org.spongepowered.api.world.volume.ImmutableVolume;
import org.spongepowered.api.world.volume.MutableVolume;
import org.spongepowered.api.world.volume.UnmodifiableVolume;
import org.spongepowered.api.world.volume.Volume;
import org.spongepowered.api.world.volume.stream.StreamOptions;
import org.spongepowered.api.world.volume.stream.VolumeStream;
import org.spongepowered.math.vector.Vector2i;
import org.spongepowered.math.vector.Vector3i;

public interface BlockVolume extends Volume {

    static BlockVolume.Mutable<@NonNull ?> empty(final Vector3i min, final Vector3i max) {
        return BlockVolume.empty(PaletteTypes.BLOCK_STATE_PALETTE.get().create(Sponge.game().registries(), RegistryTypes.BLOCK_TYPE), BlockTypes.AIR, min, max);
    }

    static BlockVolume.Mutable<@NonNull ?> empty(final Palette<BlockState, BlockType> palette, final RegistryReference<BlockType> defaultState, final Vector3i min, final Vector3i max) {
        return Sponge.game().factoryProvider().provide(BlockVolumeFactory.class).empty(palette, defaultState, min, max);
    }

    BlockState block(int x, int y, int z);

    default BlockState block(final Vector3i vector3i) {
        return this.block(vector3i.getX(), vector3i.getY(), vector3i.getZ());
    }

    FluidState fluid(int x, int y, int z);

    default FluidState fluid(final Vector3i vector3i) {
        return this.fluid(vector3i.getX(), vector3i.getY(), vector3i.getZ());
    }

    /**
     * Get the y value of the highest block that sunlight can reach in the given
     * column.
     *
     * <p>This method ignores all transparent blocks, providing the highest
     * opaque block.</p>
     *
     * @param x The x column value
     * @param z The z column value
     * @return The y value of the highest opaque block
     */
    int highestYAt(int x, int z);

    /**
     * Get the y value of the highest block that sunlight can reach in the given
     * column.
     *
     * <p>This method ignores all transparent blocks, providing the highest
     * opaque block.</p>
     *
     * @param column The column value
     * @return The y value of the highest opaque block
     */
    default int highestYAt(final Vector2i column) {
        return this.highestYAt(column.getX(), column.getY());
    }

    /**
     * Get the {@link ServerLocation} of the highest block that sunlight can reach in
     * the given column.
     *
     * <p>This method ignores all transparent blocks, providing the highest
     * opaque block.</p>
     *
     * @param position The column position
     * @return The highest opaque position
     */
    default Vector3i highestPositionAt(final Vector3i position) {
        return new Vector3i(position.getX(), this.highestYAt(position.getX(), position.getZ()), position.getZ());
    }

    interface Streamable<B extends Streamable<B>> extends BlockVolume {

        /**
         * Gets a {@link VolumeStream}&lt;{@code B, }{@link BlockState}&gt;
         * from this volume such that the {@code min} and {@code max} are contained
         * within this volume.
         *
         * @param min The minimum coordinate set
         * @param max The maximum coordinate set
         * @param options The options to construct the stream
         * @return The volume stream
         */
        VolumeStream<B, BlockState> blockStateStream(Vector3i min, Vector3i max, StreamOptions options);

    }

    /**
     * Like a {@link BlockVolume} except in the case that
     * while the parent volume can potentially be a {@link MutableVolume},
     * this volume returned will not be. This is useful if needing to simply
     * scan blocks or use {@link java.util.stream.Stream}s to perform various operations.
     */
    interface Unmodifiable<U extends Unmodifiable<U>> extends BlockVolume, Streamable<U>, UnmodifiableVolume {

    }

    interface Immutable extends Unmodifiable<Immutable>, ImmutableVolume {

    }

    interface Mutable<M extends Mutable<M>> extends Streamable<M>, MutableVolume {

        /**
         * Sets the block at the given position in the world.
         *
         * @param position The position
         * @param block The block
         * @return Whether the block change was successful
         * @throws PositionOutOfBoundsException If the position is outside of the
         *         bounds of the volume
         */
        default boolean setBlock(final Vector3i position, final BlockState block) {
            return this.setBlock(position.getX(), position.getY(), position.getZ(), block);
        }

        /**
         * Sets the block at the given position in the world.
         *
         * @param x The X position
         * @param y The Y position
         * @param z The Z position
         * @param block The block
         * @return Whether the block change was successful
         * @throws PositionOutOfBoundsException If the position is outside of the
         *         bounds of the volume
         */
        boolean setBlock(int x, int y, int z, BlockState block);

        default boolean removeBlock(final Vector3i position) {
            return this.removeBlock(position.getX(), position.getY(), position.getZ());
        }

        boolean removeBlock(int x, int y, int z);

    }
}
