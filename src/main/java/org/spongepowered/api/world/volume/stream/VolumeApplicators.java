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
package org.spongepowered.api.world.volume.stream;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.entity.BlockEntity;
import org.spongepowered.api.block.entity.BlockEntityArchetype;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityArchetype;
import org.spongepowered.api.world.BlockChangeFlag;
import org.spongepowered.api.world.LocationCreator;
import org.spongepowered.api.world.biome.Biome;
import org.spongepowered.api.world.server.ServerLocation;
import org.spongepowered.api.world.volume.archetype.block.entity.BlockEntityArchetypeVolume;
import org.spongepowered.api.world.volume.archetype.entity.EntityArchetypeVolume;
import org.spongepowered.api.world.volume.biome.BiomeVolume;
import org.spongepowered.api.world.volume.block.BlockVolume;
import org.spongepowered.api.world.volume.block.PhysicsAwareMutableBlockVolume;
import org.spongepowered.api.world.volume.block.entity.BlockEntityVolume;
import org.spongepowered.api.world.volume.entity.EntityVolume;

import java.util.Objects;
import java.util.Optional;

/**
 * A collection of default implemented {@link VolumeApplicator}s for various
 * "traditional" use cases.
 */
public final class VolumeApplicators {

    /**
     * A standard {@link VolumeApplicator} that applies a {@link BlockState} to
     * any {@link BlockVolume.Modifiable}.
     *
     * <p>Note that this has a different side
     * effect compared to {@link #applyBlocks(BlockChangeFlag)} if the target
     * {@link BlockVolume volume} is a {@link PhysicsAwareMutableBlockVolume}
     * due to the nature of applying blocks with a {@link BlockChangeFlag}. It
     * can be expected that applying blocks directly with this applicator will
     * likely result in side effects playing out to their full extent per block
     * changed.</p>
     *
     * @param <M> The type of modifiable block volume
     * @return A blockstate based VolumeApplicator
     */
    public static <M extends BlockVolume.Modifiable<M>> VolumeApplicator<M, BlockState, Boolean> applyBlocks() {
        return (volume, element) -> volume.setBlock(element.position().round().toInt(), element.type());
    }

    /**
     * Creates a "physics aware" variation of a {@link VolumeApplicator} that
     * applies {@link BlockState BlockStates} with side effects in accordance
     * with the passed in {@link BlockChangeFlag}.
     *
     * @param flag The respective change flag to signal what side effects to
     *      play out on application
     * @param <M> The target volume type that accepts a BlockChangeFlag
     * @return A blockstate based VolumeApplicator
     */
    public static <M extends PhysicsAwareMutableBlockVolume<M>> VolumeApplicator<M, BlockState, Boolean> applyBlocks(final BlockChangeFlag flag) {
        Objects.requireNonNull(flag, "BlockChangeFlag cannot be null!");
        return (volume, element) -> volume.setBlock(element.position().round().toInt(), element.type(), flag);
    }

    /**
     * A generic applicator to add a {@link BlockEntity} to a target {@link BlockEntityVolume volume}.
     * This does have the best intention of attempting to set the target's
     * container {@link BlockState} prior to adding the {@link BlockEntity}.
     *
     * @param <M> The type of modifiable volume
     * @return An applicator to add block entities
     */
    public static <M extends BlockEntityVolume.Modifiable<M>> VolumeApplicator<M, BlockEntity, Boolean> applyBlockEntities() {
        return (volume, element) -> {
            if (volume.setBlock(element.position().round().toInt(), element.type().block())) {
                volume.addBlockEntity(element.position().round().toInt(), element.type());
                return true;
            }
            return false;
        };
    }

    /**
     * A potentially useful {@link VolumeApplicator} that conditionally adds or
     * removes a {@link BlockEntity}/{@link BlockState} based on the element's
     * {@link Optional} state of being {@link Optional#empty()} or
     * {@link Optional#isPresent()}.
     *
     * @param <M> The type of modifiable block entity volume
     * @return An applicator that conditionally adds block entities or removes
     *   blocks
     */
    public static <M extends BlockEntityVolume.Modifiable<M>> VolumeApplicator<M, Optional<? extends BlockEntity>, Boolean> applyOrRemoveBlockEntities() {
        return (volume, element) -> {
            final Optional<? extends BlockEntity> blockEntityOpt = element.type();
            if (blockEntityOpt.isPresent()) {
                final BlockEntity blockEntity = blockEntityOpt.get();
                if (volume.setBlock(element.position().round().toInt(), blockEntity.block())) {
                    volume.addBlockEntity(element.position().round().toInt(), blockEntity);
                    return true;
                }
                return false;
            } else {
                return volume.removeBlock(element.position().round().toInt());
            }
        };
    }

    /**
     * A potentially useful {@link VolumeApplicator} that conditionally adds or
     * removes a {@link BlockState} based on the element's
     * {@link Optional} state of being {@link Optional#empty()} or
     * {@link Optional#isPresent()}.
     *
     * @param <M> The type of modifiable block volume
     * @return An applicator that conditionally sets a block or removes a block
     */
    public static <M extends BlockVolume.Modifiable<M>> VolumeApplicator<M, Optional<BlockState>, Boolean> applyOrRemoveBlockState() {
        return (volume, element) -> element.type()
            .map(blockState -> volume.setBlock(element.position().round().toInt(), blockState))
            .orElseGet(() -> volume.removeBlock(element.position().round().toInt()));
    }

    /**
     * A potentially useful {@link VolumeApplicator} that conditionally adds or
     * removes a {@link BlockState} based on the element's
     * {@link Optional} state of being {@link Optional#empty()} or
     * {@link Optional#isPresent()}. The added change being the flag
     *
     * @param <M> The type of modifiable block volume
     * @return An applicator that conditionally sets a block or removes a block
     */
    public static <M extends PhysicsAwareMutableBlockVolume<M>> VolumeApplicator<M, Optional<BlockState>, Boolean> applyOrRemoveBlockState(final BlockChangeFlag flag) {
        return (volume, element) -> element.type()
            .map(blockState -> volume.setBlock(element.position().round().toInt(), blockState, flag))
            .orElseGet(() -> volume.removeBlock(element.position().round().toInt()));
    }

    /**
     * A potentially useful {@link VolumeApplicator} that attempts to apply a
     * {@link BlockEntityArchetype} onto a target {@link BlockEntityVolume},
     * optionally returning a newly placed {@link BlockEntity}.
     *
     * @param <M> The type of block entity
     * @return A volume applicator that applies block entity archetypes
     */
    @SuppressWarnings({"unchecked"})
    public static <M extends BlockEntityVolume.Modifiable<M> & LocationCreator<@NonNull ?, ? extends ServerLocation>> VolumeApplicator<M, BlockEntityArchetype, Optional<? extends BlockEntity>> applyBlockEntityArchetype() {
        return (volume, element) -> element.type().apply(volume.location(element.position()));
    }

    /**
     * A potentially useful {@link VolumeApplicator} that attempts to apply a
     * {@link BlockEntityArchetype} onto a target {@link BlockEntityVolume},
     * optionally returning a newly placed {@link BlockEntity}.
     *
     * @param <M> The type of block entity
     * @return A volume applicator that applies block entity archetypes
     */
    public static <M extends BlockEntityArchetypeVolume.Modifiable<M>> VolumeApplicator<M, BlockEntityArchetype, Boolean> applyBlockEntityArchetypes() {
        return (volume, element) -> {
            volume.addBlockEntity(element.position().round().toInt(), element.type());
            return true;
        };
    }

    /**
     * A potentially useful {@link VolumeApplicator} that attempts to apply a
     * {@link Entity} onto a target {@link EntityVolume},
     * returning {@code boolean} whether the entity was successfully spawned.
     *
     * @param <M> The type of entity volume
     * @return A volume applicator that applies entities to volumes
     */
    public static <M extends EntityVolume.Modifiable<M>> VolumeApplicator<M, Entity, Boolean> applyEntities() {
        return (volume, element) -> volume.spawnEntity(element.type());
    }

    /**
     * A potentially useful {@link VolumeApplicator} that attempts to apply a
     * {@link Biome} onto a target {@link BiomeVolume},
     * returning {@code boolean} whether the biome was successfully set.
     *
     * @param <M> The type of biome volume
     * @return A volume applicator that applies biomes to volumes
     */
    public static <M extends BiomeVolume.Modifiable<M>> VolumeApplicator<M, Biome, Boolean> applyBiomes() {
        return (volume, element) -> volume.setBiome(element.position().round().toInt(), element.type());
    }

    @SuppressWarnings("unchecked")
    public static <M extends EntityVolume.Modifiable<M> & LocationCreator<@NonNull ?, ? extends ServerLocation>> VolumeApplicator<M, EntityArchetype, Optional<? extends Entity>> applyEntityArchetype() {
        return (volume, element) -> element.type().apply(volume.location(element.position()));
    }

    public static <M extends EntityArchetypeVolume.Modifiable<M>> VolumeApplicator<M, EntityArchetype, Boolean> applyEntityArchetypes() {
        return (volume, element) -> {
            volume.addEntity(element.type(), element.position().toDouble());
            return true;
        };
    }

    private VolumeApplicators() {}

}
