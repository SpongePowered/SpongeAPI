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

public final class VolumeApplicators {

    public static <M extends BlockVolume.Mutable<M>> VolumeApplicator<M, BlockState, Boolean> applyBlocks() {
        return ((volume, element) -> volume.setBlock(element.position(), element.type()));
    }

    public static <M extends PhysicsAwareMutableBlockVolume<M>> VolumeApplicator<M, BlockState, Boolean> applyBlocks(final BlockChangeFlag flag) {
        Objects.requireNonNull(flag, "BlockChangeFlag cannot be null!");
        return ((volume, element) -> volume.setBlock(element.position(), element.type(), flag));
    }

    public static <M extends BlockEntityVolume.Mutable<M>> VolumeApplicator<M, BlockEntity, Boolean> applyBlockEntities() {
        return (volume, element) -> {
            if (volume.setBlock(element.position(), element.type().block())) {
                volume.addBlockEntity(element.position(), element.type());
                return true;
            }
            return false;
        };
    }

    public static <M extends BlockEntityVolume.Mutable<M>> VolumeApplicator<M, Optional<? extends BlockEntity>, Boolean> applyOrRemoveBlockEntities() {
        return (volume, element) -> {
            final Optional<? extends BlockEntity> blockEntityOpt = element.type();
            if (blockEntityOpt.isPresent()) {
                final BlockEntity blockEntity = blockEntityOpt.get();
                if (volume.setBlock(element.position(), blockEntity.block())) {
                    volume.addBlockEntity(element.position(), blockEntity);
                    return true;
                }
                return false;
            } else {
                return volume.removeBlock(element.position());
            }
        };
    }

    public static <M extends BlockVolume.Mutable<M>> VolumeApplicator<M, Optional<BlockState>, Boolean> applyOrRemoveBlockState() {
        return (volume, element) -> element.type()
            .map(blockState -> volume.setBlock(element.position(), blockState))
            .orElseGet(() -> volume.removeBlock(element.position()));
    }

    public static <M extends PhysicsAwareMutableBlockVolume<M>> VolumeApplicator<M, Optional<BlockState>, Boolean> applyOrRemoveBlockState(final BlockChangeFlag flag) {
        return (volume, element) -> element.type()
            .map(blockState -> volume.setBlock(element.position(), blockState, flag))
            .orElseGet(() -> volume.removeBlock(element.position()));
    }

    public static <M extends LocationCreator<?, ? extends ServerLocation> & BlockEntityVolume.Mutable<M>> VolumeApplicator<M, BlockEntityArchetype,
            Optional<?
            extends BlockEntity>> applyBlockEntityArchetype() {
        return (volume, element) -> element.type().apply((ServerLocation) volume.location(element.position()));
    }

    public static <M extends BlockEntityArchetypeVolume.Mutable<M>> VolumeApplicator<M, BlockEntityArchetype, Boolean> applyBlockEntityArchetypes() {
        return (volume, element) -> {
            volume.addBlockEntity(element.position(), element.type());
            return true;
        };
    }

    public static <M extends EntityVolume.Mutable<M>> VolumeApplicator<M, Entity, Boolean> applyEntities() {
        return (volume, element) -> volume.spawnEntity(element.type());
    }

    public static <M extends BiomeVolume.Mutable<M>> VolumeApplicator<M, Biome, Boolean> applyBiomes() {
        return (volume, element) -> volume.setBiome(element.position(), element.type());
    }

    @SuppressWarnings("RedundantCast")
    public static <M extends LocationCreator<@NonNull ?, ? extends ServerLocation> & EntityVolume.Mutable<M>> VolumeApplicator<M, EntityArchetype, Optional<?
            extends Entity>> applyEntityArchetype() {
        return (volume, element) -> element.type().apply((ServerLocation) volume.location(element.position()));
    }

    public static <M extends EntityArchetypeVolume.Mutable<M>> VolumeApplicator<M, EntityArchetype, Boolean> applyEntityArchetypes() {
        return (volume, element) -> {
            volume.addEntity(element.type(), element.position().toDouble());
            return true;
        };
    }

    private VolumeApplicators() {}

}
