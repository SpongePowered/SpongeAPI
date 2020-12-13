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

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.entity.BlockEntity;
import org.spongepowered.api.block.entity.BlockEntityArchetype;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityArchetype;
import org.spongepowered.api.world.BlockChangeFlag;
import org.spongepowered.api.world.LocationCreator;
import org.spongepowered.api.world.biome.BiomeType;
import org.spongepowered.api.world.volume.biome.MutableBiomeVolume;
import org.spongepowered.api.world.volume.block.MutableBlockVolume;
import org.spongepowered.api.world.volume.block.PhysicsAwareMutableBlockVolume;
import org.spongepowered.api.world.volume.block.entity.MutableBlockEntityVolume;
import org.spongepowered.api.world.volume.entity.MutableEntityVolume;

import java.util.Objects;
import java.util.Optional;

public final class VolumeApplicators {

    public static <M extends MutableBlockVolume<M>> VolumeApplicator<M, BlockState, Boolean> applyBlocks() {
        return ((volume, element) -> volume.setBlock(element.getPosition(), element.getType()));
    }

    public static <M extends PhysicsAwareMutableBlockVolume<M>> VolumeApplicator<M, BlockState, Boolean> applyBlocks(final BlockChangeFlag flag) {
        Objects.requireNonNull(flag, "BlockChangeFlag cannot be null!");
        return ((volume, element) -> volume.setBlock(element.getPosition(), element.getType(), flag));
    }

    public static <M extends MutableBlockEntityVolume<M>> VolumeApplicator<M, BlockEntity, Boolean> applyBlockEntities() {
        return (volume, element) -> {
            if (volume.setBlock(element.getPosition(), element.getType().getBlock())) {
                volume.addBlockEntity(element.getPosition(), element.getType());
                return true;
            }
            return false;
        };
    }

    public static <M extends MutableBlockEntityVolume<M>> VolumeApplicator<M, Optional<? extends BlockEntity>, Boolean> applyOrRemoveBlockEntities() {
        return (volume, element) -> {
            final Optional<? extends BlockEntity> blockEntityOpt = element.getType();
            if (blockEntityOpt.isPresent()) {
                final BlockEntity blockEntity = blockEntityOpt.get();
                if (volume.setBlock(element.getPosition(), blockEntity.getBlock())) {
                    volume.addBlockEntity(element.getPosition(), blockEntity);
                    return true;
                }
                return false;
            } else {
                return volume.removeBlock(element.getPosition());
            }
        };
    }

    public static <M extends MutableBlockVolume<M>> VolumeApplicator<M, Optional<BlockState>, Boolean> applyOrRemoveBlockState() {
        return (volume, element) -> element.getType()
            .map(blockState -> volume.setBlock(element.getPosition(), blockState))
            .orElseGet(() -> volume.removeBlock(element.getPosition()));
    }

    public static <M extends PhysicsAwareMutableBlockVolume<M>> VolumeApplicator<M, Optional<BlockState>, Boolean> applyOrRemoveBlockState(final BlockChangeFlag flag) {
        return (volume, element) -> element.getType()
            .map(blockState -> volume.setBlock(element.getPosition(), blockState, flag))
            .orElseGet(() -> volume.removeBlock(element.getPosition()));
    }

    public static <M extends LocationCreator & MutableBlockEntityVolume<M>> VolumeApplicator<M, BlockEntityArchetype, Optional<? extends BlockEntity>> applyBlockEntityArchetype() {
        return (volume, element) -> element.getType().apply(volume.getLocation(element.getPosition()));
    }

    public static <M extends MutableEntityVolume<M>> VolumeApplicator<M, Entity, Boolean> applyEntities() {
        return (volume, element) -> volume.spawnEntity(element.getType());
    }

    public static <M extends MutableBiomeVolume<M>> VolumeApplicator<M, BiomeType, Boolean> applyBiomes() {
        return (volume, element) -> volume.setBiome(element.getPosition(), element.getType());
    }

    public static <M extends LocationCreator & MutableEntityVolume<M>> VolumeApplicator<M, EntityArchetype, Optional<? extends Entity>> applyEntityArchetype() {
        return (volume, element) -> element.getType().apply(volume.getLocation(element.getPosition()));
    }

    private VolumeApplicators() {}

}
