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
package org.spongepowered.api.block;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.entity.BlockEntity;
import org.spongepowered.api.block.entity.BlockEntityArchetype;
import org.spongepowered.api.data.SerializableDataHolderBuilder;
import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;
import org.spongepowered.api.world.BlockChangeFlag;
import org.spongepowered.api.world.LocatableSnapshot;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.schematic.Schematic;
import org.spongepowered.api.world.storage.WorldProperties;
import org.spongepowered.math.vector.Vector3i;

import java.util.Optional;
import java.util.UUID;

/**
 * An immutable representation of a {@link BlockState} and any extra data that
 * may be associated with it, including {@link BlockEntity} related data.
 */
public interface BlockSnapshot extends LocatableSnapshot<BlockSnapshot> {

    /**
     * Represents a {@link BlockSnapshot} with the default state of
     * {@link BlockTypes#AIR} and a {@link Location} that cannot be determined.
     */
    BlockSnapshot NONE = DummyObjectProvider.createFor(BlockSnapshot.class, "NONE");

    /**
     * Creates a {@link Builder} to get {@link BlockSnapshot}s.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the {@link BlockState}.
     *
     * @return The BlockState
     */
    BlockState getState();

    /**
     * Creates a copy of the {@link BlockSnapshot} with the provided
     * {@link BlockState}. Any additional data associated with a
     * {@link BlockEntity} or custom data may be lost.
     *
     * <p>Note: all custom data, including implementation detailed
     * data relating to any and all {@link BlockEntity} instances that
     * was included in this snapshot will NOT copy over to the new
     * snapshot.</p>
     *
     * @param blockState The block state
     * @return The new snapshot
     */
    BlockSnapshot withState(BlockState blockState);

    /**
     * Creates a copy of the {@link BlockSnapshot} with the provided
     * {@link DataContainer}. Note that this is equal to calling
     * {@link Builder#build(DataView)}. All data is
     * validated and
     *
     * @param container The data container
     * @return The new snapshot
     */
    BlockSnapshot withContainer(DataContainer container);

    /**
     * Restores the {@link BlockSnapshot} to the {@link Location} stored within
     * the snapshot. If the {@link Location} is not available, the snapshot will
     * not be restored.
     *
     * <p>If forced, the state of the block will change its {@link BlockType}
     * to match that of the snapshot then set the state. However, if force is
     * set to false and the {@link BlockType}s does not match, false will be
     * returned.
     * If notifyNeighbors is true, neighboring blocks will be notified of
     * changes at the restored block location triggering physic updates.</p>
     *
     * @param force If true, forces block state to be set even if the
     *     {@link BlockType} does not match the snapshot one.
     * @param flag The block change flags to determine whether neighbors are
     *     notified, block physics performed, etc.
     * @return True if the restore was successful, false otherwise
     */
    boolean restore(boolean force, BlockChangeFlag flag);

    /**
     * Gets the {@link UUID}, if available, of the user who created this
     * {@link BlockSnapshot}.
     *
     * @return The {@link UUID} if available
     */
    Optional<UUID> getCreator();

    /**
     * Gets the {@link UUID}, if available, of the user who last notified this
     * {@link BlockSnapshot}.
     *
     * @return The {@link UUID} if available
     */
    Optional<UUID> getNotifier();

    /**
     * Creates a new {@link BlockEntityArchetype} for use with {@link Schematic}s
     * and placing the archetype in multiple locations.
     *
     * <p>If this blocksnapshot does not contain a block entity then this will
     * return {@link Optional#empty()}.</p>
     *
     * @return The created archetype for re-creating this block entity
     */
    Optional<BlockEntityArchetype> createArchetype();

    interface Builder extends SerializableDataHolderBuilder.Immutable<BlockSnapshot, Builder> {

        /**
         * Sets the {@link WorldProperties} for this {@link BlockSnapshot}.
         *
         * <p>
         *     This is used to grab the {@link UUID} of the World for this snapshot.
         * </p>
         *
         * @param worldProperties The WorldProperties
         * @return This builder, for chaining
         */
        Builder world(WorldProperties worldProperties);

        /**
         * Sets the {@link BlockState} for this {@link BlockSnapshot}.
         *
         * @param blockState The BlockState
         * @return This builder, for chaining
         */
        Builder blockState(BlockState blockState);

        /**
         * Sets the coordinates of this {@link BlockSnapshot} from a {@link Vector3i}.
         *
         * @param position The Vector3i representing the coordinates
         * @return This builder, for chaining
         */
        Builder position(Vector3i position);

        /**
         * Copies over block data from a {@link Location}.
         *
         * @param location The Location to copy from
         * @return This builder, for chaining
         */
        Builder from(Location location);

        /**
         * Sets the {@link UUID} of the user who created this
         * {@link BlockSnapshot}.
         *
         * @param uuid The {@link UUID} of the creator
         * @return This builder, for chaining
         */
        Builder creator(UUID uuid);

        /**
         * Sets the {@link UUID} of the user who last notified this
         * {@link BlockSnapshot}.
         *
         * @param uuid The {@link UUID} of the notifier
         * @return This builder, for chaining
         */
        Builder notifier(UUID uuid);
    }
}
