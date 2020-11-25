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
import org.spongepowered.api.world.BlockChangeFlags;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.volume.MutableVolume;

import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

public final class VolumeCollectors {

    public static <W extends World<W>> VolumeCollector<W, BlockState, Boolean> applyBlocksToWorld(final W world, final BlockChangeFlag flag) {
        Objects.requireNonNull(flag, "BlockChangeFlag cannot be null!");
        return VolumeCollectors.of(world, VolumePositionTranslators.identity(), VolumeApplicators.applyBlocks(flag));
    }

    public static <W extends World<W>> VolumeCollector<W, BlockState, Boolean> applyBlocksToWorld(final W world) {
        return VolumeCollectors.applyBlocksToWorld(world, BlockChangeFlags.ALL);
    }

    public static <W extends World<W>> VolumeCollector<W, BlockEntity, Boolean> applyBlockEntityToWorld(final W world) {
        return VolumeCollectors.of(world, VolumePositionTranslators.identity(), VolumeApplicators.applyBlockEntities());
    }

    public static <W extends World<W>> VolumeCollector<W, Optional<? extends BlockEntity>, Boolean> applyBlockEntitiesOrRemove(final W world) {
        return VolumeCollectors.of(world, VolumePositionTranslators.identity(), VolumeApplicators.applyOrRemoveBlockEntities());
    }

    public static <W extends World<W>> VolumeCollector<W, Entity, Boolean> applyEntitiesToWorld(final W world) {
        return VolumeCollectors.of(world, VolumePositionTranslators.identity(), VolumeApplicators.applyEntities());
    }

    public static <W extends World<W>> VolumeCollector<W, EntityArchetype, Optional<? extends Entity>> applyEntityArchetypesToWorld(final W world) {
        return VolumeCollectors.of(world, VolumePositionTranslators.identity(), VolumeApplicators.applyEntityArchetype());
    }

    public static <W extends World<W>> VolumeCollector<W, BlockEntityArchetype, Optional<? extends BlockEntity>> applyBlockEntityArchetypesToWorld(final W world) {
        return VolumeCollectors.of(world, VolumePositionTranslators.identity(), VolumeApplicators.applyBlockEntityArchetype());
    }

    public static <M extends MutableVolume, T, R> VolumeCollector<M, T, R> of(final M volume, final VolumePositionTranslator<M, T> transformer, final VolumeApplicator<M, T, R> applicator) {
        final WeakReference<M> volumeRef = new WeakReference<>(Objects.requireNonNull(volume, "Volume cannot be null!"));
        final Supplier<M> volumeSupplier = () -> Objects.requireNonNull(volumeRef.get(), "Target volume de-referenced");
        Objects.requireNonNull(applicator, "VolumeApplicator cannot be null");
        return new VolumeCollector<M, T, R>() {
            @Override
            public Supplier<M> target() {
                return volumeSupplier;
            }

            @Override
            public VolumePositionTranslator<M, T> positionTransform() {
                return transformer;
            }

            @Override
            public VolumeApplicator<M, T, R> applicator() {
                return applicator;
            }
        };
    }

    private VolumeCollectors() {}
}
