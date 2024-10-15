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
package org.spongepowered.api.world.volume.archetype;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.CauseStackManager;
import org.spongepowered.api.event.EventContextKeys;
import org.spongepowered.api.event.cause.entity.SpawnType;
import org.spongepowered.api.util.transformation.Transformation;
import org.spongepowered.api.world.BlockChangeFlag;
import org.spongepowered.api.world.BlockChangeFlags;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.api.world.volume.archetype.block.entity.BlockEntityArchetypeVolume;
import org.spongepowered.api.world.volume.archetype.entity.EntityArchetypeVolume;
import org.spongepowered.api.world.volume.biome.BiomeVolume;
import org.spongepowered.api.world.volume.block.BlockVolume;
import org.spongepowered.api.world.volume.stream.StreamOptions;
import org.spongepowered.api.world.volume.stream.VolumeApplicators;
import org.spongepowered.api.world.volume.stream.VolumeCollectors;
import org.spongepowered.api.world.volume.stream.VolumePositionTranslators;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

import java.util.Objects;
import java.util.function.Supplier;

public interface ArchetypeVolume extends BlockVolume.Modifiable<ArchetypeVolume>,
    BlockEntityArchetypeVolume.Modifiable<ArchetypeVolume>,
    EntityArchetypeVolume.Modifiable<ArchetypeVolume>,
    BiomeVolume.Modifiable<ArchetypeVolume> {

    ArchetypeVolume transform(Transformation transformation);

    /**
     * Gets the logical center of a volume, considering the decimal coordinates,
     * the block's center location would have an offset of {@code 0.5}
     *
     * @return The logical center of the volume
     */
    default Vector3d logicalCenter() {
        return this.min().toDouble().add(this.size().toDouble().div(2));
    }

    /**
     * Attempts to apply all of the contents of this
     * {@link ArchetypeVolume volume} onto the target {@link ServerWorld world}
     * with a relative {@code placement}. This default implementation can be
     * used as a guide for utilizing
     * {@link org.spongepowered.api.world.volume.stream.VolumeStream VolumeStreams}
     * and their companion types.
     *
     * @param target The target world
     * @param placement The target origin, where the diff of relative position
     *      compared to this volume's min position as the offset
     * @param spawnContext The context value used for processing spawn entities.
     */
    default void applyToWorld(final ServerWorld target, final Vector3i placement, final Supplier<SpawnType> spawnContext) {
        this.applyToWorld(target, placement, spawnContext, BlockChangeFlags.DEFAULT_PLACEMENT);
    }

    /**
     * Attempts to apply all of the contents of this
     * {@link ArchetypeVolume volume} onto the target {@link ServerWorld world}
     * with a relative {@code placement}. This default implementation can be
     * used as a guide for utilizing
     * {@link org.spongepowered.api.world.volume.stream.VolumeStream VolumeStreams}
     * and their companion types.
     *
     * @param target The target world
     * @param placement The target origin, where the diff of relative position
     *      compared to this volume's min position as the offset
     * @param spawnContext The context value used for processing spawn entities.
     * @param flag The various change flags controlling some interactions
     */
    default void applyToWorld(final ServerWorld target, final Vector3i placement, final Supplier<SpawnType> spawnContext, final BlockChangeFlag flag) {
        Objects.requireNonNull(target, "Target world cannot be null");
        Objects.requireNonNull(placement, "Target position cannot be null");
        try (final CauseStackManager.StackFrame frame = Sponge.server().causeStackManager().pushCauseFrame()) {
            this.blockStateStream(this.min(), this.max(), StreamOptions.lazily())
                .apply(VolumeCollectors.of(
                    target,
                    VolumePositionTranslators.relativeTo(placement),
                    VolumeApplicators.applyBlocks(flag)
                ));

            this.biomeStream(this.min(), this.max(), StreamOptions.lazily())
                .apply(VolumeCollectors.of(
                    target,
                    VolumePositionTranslators.relativeTo(placement),
                    VolumeApplicators.applyBiomes()
                ));
            this.blockEntityArchetypeStream(this.min(), this.max(), StreamOptions.lazily())
                .apply(VolumeCollectors.of(
                    target,
                    VolumePositionTranslators.relativeTo(placement),
                    VolumeApplicators.applyBlockEntityArchetype()
                ));
            frame.addContext(EventContextKeys.SPAWN_TYPE, spawnContext);
            this.entityArchetypeStream(this.min(), this.max(), StreamOptions.lazily())
                .apply(VolumeCollectors.of(
                    target,
                    VolumePositionTranslators.relativeTo(placement),
                    VolumeApplicators.applyEntityArchetype()
                ));
        }
    }
}
