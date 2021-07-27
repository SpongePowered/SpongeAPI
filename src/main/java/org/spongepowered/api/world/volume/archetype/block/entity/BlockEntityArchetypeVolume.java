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
package org.spongepowered.api.world.volume.archetype.block.entity;

import org.spongepowered.api.block.entity.BlockEntity;
import org.spongepowered.api.block.entity.BlockEntityArchetype;
import org.spongepowered.api.world.volume.ImmutableVolume;
import org.spongepowered.api.world.volume.MutableVolume;
import org.spongepowered.api.world.volume.UnmodifiableVolume;
import org.spongepowered.api.world.volume.block.BlockVolume;
import org.spongepowered.api.world.volume.stream.StreamOptions;
import org.spongepowered.api.world.volume.stream.VolumeStream;
import org.spongepowered.math.vector.Vector3i;

import java.util.Map;
import java.util.Optional;

public interface BlockEntityArchetypeVolume extends BlockVolume {

    /**
     * Gets the {@link BlockEntityArchetype} for the block entity carrying block
     * at the given coordinates.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return The block entity, if found
     */
    Optional<BlockEntityArchetype> blockEntityArchetype(int x, int y, int z);

    /**
     * Gets the {@link BlockEntityArchetype} for the block entity carrying block
     * at the given coordinates.
     *
     * @param position The position
     * @return The block entity, if found
     */
    default Optional<BlockEntityArchetype> blockEntityArchetype(final Vector3i position) {
        return this.blockEntityArchetype(position.x(), position.y(), position.z());
    }

    /**
     * Gets a map containing all block entity archetypes within this volume,
     * keyed by their positions within the volume.
     *
     * @return The block entity map
     */
    Map<Vector3i, BlockEntityArchetype> blockEntityArchetypes();

    interface Streamable<B extends Streamable<B>> extends BlockEntityArchetypeVolume {

        /**
         * Gets a {@link VolumeStream}&lt;{@code B, }{@link BlockEntityArchetype}&gt;
         * from this volume such that the {@code min} and {@code max} are contained
         * within this volume.
         *
         * @param min The minimum coordinate set
         * @param max The maximum coordinate set
         * @param options The options to construct the stream
         * @return The volume stream
         */
        VolumeStream<B, BlockEntityArchetype> blockEntityArchetypeStream(Vector3i min, Vector3i max, StreamOptions options);

    }

    interface Unmodifiable<U extends Unmodifiable<U>> extends BlockEntityArchetypeVolume,
        Streamable<U>,
        UnmodifiableVolume, BlockVolume.Unmodifiable<U> {

    }

    interface Modifiable<M extends Modifiable<M>> extends Streamable<M>, BlockVolume.Modifiable<M>, MutableVolume {

        default void addBlockEntity(final Vector3i pos, final BlockEntity blockEntity) {
            this.addBlockEntity(pos.x(), pos.y(), pos.z(), blockEntity);
        }

        default void addBlockEntity(final int x, final int y, final int z, final BlockEntity blockEntity) {
            this.addBlockEntity(x, y, z, blockEntity.createArchetype());
        }

        default void addBlockEntity(final Vector3i pos, final BlockEntityArchetype archetype) {
            this.addBlockEntity(pos.x(), pos.y(), pos.z(), archetype);
        }

        void addBlockEntity(int x, int y, int z, BlockEntityArchetype archetype);

        default void removeBlockEntity(final Vector3i pos) {
            this.removeBlockEntity(pos.x(), pos.y(), pos.z());
        }

        void removeBlockEntity(int x, int y, int z);
    }

    interface Mutable extends Modifiable<Mutable> {


    }

    interface Immutable extends Unmodifiable<Immutable>, ImmutableVolume {

    }
}
