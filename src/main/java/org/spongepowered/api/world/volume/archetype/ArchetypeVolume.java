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
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.event.CauseStackManager;
import org.spongepowered.api.event.EventContextKeys;
import org.spongepowered.api.event.cause.entity.SpawnType;
import org.spongepowered.api.registry.Registry;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.world.BlockChangeFlags;
import org.spongepowered.api.world.biome.Biome;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.api.world.volume.archetype.block.entity.BlockEntityArchetypeVolume;
import org.spongepowered.api.world.volume.archetype.entity.EntityArchetypeVolume;
import org.spongepowered.api.world.volume.biome.BiomeVolume;
import org.spongepowered.api.world.volume.block.BlockVolume;
import org.spongepowered.api.world.volume.stream.StreamOptions;
import org.spongepowered.api.world.volume.stream.VolumeApplicators;
import org.spongepowered.api.world.volume.stream.VolumeCollectors;
import org.spongepowered.api.world.volume.stream.VolumePositionTranslators;
import org.spongepowered.math.vector.Vector3i;

import java.util.Objects;
import java.util.function.Supplier;

public interface ArchetypeVolume extends BlockVolume.Mutable<ArchetypeVolume>,
    BlockEntityArchetypeVolume.Mutable<ArchetypeVolume>,
    EntityArchetypeVolume.Mutable<ArchetypeVolume>,
    BiomeVolume.Mutable<ArchetypeVolume> {

    Registry<BlockType> blockStateRegistry();

    Registry<Biome> biomeRegistry();

    default void applyToWorld(final ServerWorld target, final Vector3i placement, final Supplier<SpawnType> spawnContext) {
        Objects.requireNonNull(target, "Target world cannot be null");
        Objects.requireNonNull(placement, "Target position cannot be null");
        try (final CauseStackManager.StackFrame frame = Sponge.server().causeStackManager().pushCauseFrame()) {
            this.blockStateStream(this.blockMin(), this.blockMax(), StreamOptions.lazily())
                .apply(VolumeCollectors.of(
                    target,
                    VolumePositionTranslators.relativeTo(placement),
                    VolumeApplicators.applyBlocks(BlockChangeFlags.ALL)
                ));

            this.biomeStream(this.blockMin(), this.blockMax(), StreamOptions.lazily())
                // It's common that we'll have to be translating back and forth between ResourceKeys because a Biome
                // is reloadable between worlds (one biome instance can be limited to that world)
                .map((v, b, x, y, z) -> this.biomeRegistry().valueKey(b.get()))
                .map((v, key, x, y, z) -> target.registries().registry(RegistryTypes.BIOME).<Biome>value(key.get()))
                .apply(VolumeCollectors.of(
                    target,
                    VolumePositionTranslators.relativeTo(placement),
                    VolumeApplicators.applyBiomes()
                ));
            this.blockEntityArchetypeStream(this.blockMin(), this.blockMax(), StreamOptions.lazily())
                .apply(VolumeCollectors.of(
                    target,
                    VolumePositionTranslators.relativeTo(placement),
                    VolumeApplicators.applyBlockEntityArchetype()
                ));
            frame.addContext(EventContextKeys.SPAWN_TYPE, spawnContext);
            this.entityArchetypeStream(this.blockMin(), this.blockMax(), StreamOptions.lazily())
                .apply(VolumeCollectors.of(
                    target,
                    VolumePositionTranslators.relativeTo(placement),
                    VolumeApplicators.applyEntityArchetype()
                ));
        }
    }

}
