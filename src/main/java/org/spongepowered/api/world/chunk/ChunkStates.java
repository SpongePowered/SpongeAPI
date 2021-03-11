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
package org.spongepowered.api.world.chunk;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.entity.BlockEntity;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.world.ProtoWorld;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.biome.Biome;

@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class ChunkStates {

    // @formatter:off

    // SORTFIELDS:ON

    /**
     * A {@link ProtoChunk} that is at this state means that it is being generated
     * with a "base" layer of terrain.
     * The chunk should not have any {@link Entity} instances or {@link BlockEntity}
     * instances and may have a valid {@link ProtoWorld} used for world generation.
     */
    public static final DefaultedRegistryReference<ChunkState> BASE = ChunkStates.key(ResourceKey.minecraft("base"));

    /**
     * A {@link ProtoChunk} that is being "carved out" for general terrain features
     * that require things like "caves" or "canyons".
     */
    public static final DefaultedRegistryReference<ChunkState> CARVED = ChunkStates.key(ResourceKey.minecraft("carved"));

    /**
     * A {@link ProtoChunk} state that is being populated by world generation,
     * usually provided by {@link Biome}s.
     */
    public static final DefaultedRegistryReference<ChunkState> DECORATED = ChunkStates.key(ResourceKey.minecraft("decorated"));

    /**
     * Identifies a {@link ProtoChunk} that is considered empty. The method
     * {@link ProtoChunk#isEmpty()} would return {@code true}. Identifies the
     * chunk has nothing contained within it, but can be used as a dummy chunk
     * in some regards for world generation.
     */
    public static final DefaultedRegistryReference<ChunkState> EMPTY = ChunkStates.key(ResourceKey.minecraft("empty"));

    /**
     * A {@link ProtoChunk} state that is being used for entity spawning.
     * Generally requires that the neighboring chunks are adequately populated,
     * and requires that this chunk has proper lighting, for mob placement logic.
     */
    public static final DefaultedRegistryReference<ChunkState> ENTITIES_SPAWNED = ChunkStates.key(ResourceKey.minecraft("entities_spawned"));

    /**
     * A {@link ProtoChunk} state that is "cleaning" up remnant objects of a
     * chunk in process of world generation. Generally, height maps are being
     * calculated at this point as entity spawning can affect block placement.
     */
    public static final DefaultedRegistryReference<ChunkState> FINALIZED = ChunkStates.key(ResourceKey.minecraft("finalized"));

    /**
     * A {@link ProtoChunk} that has completed world generation tasks and can be
     * added to a level ready {@link World}. Likewise can be utilized during
     * chunk deserialization prior to a {@link Chunk} being fully added to a
     * {@link World} instance.
     */
    public static final DefaultedRegistryReference<ChunkState> GENERATED = ChunkStates.key(ResourceKey.minecraft("generated"));

    /**
     * A {@link ProtoChunk} state that is being "carved" with liquid cave
     * features, such as underwater ravines, underwater caves, etc.
     */
    public static final DefaultedRegistryReference<ChunkState> LIQUID_CARVED = ChunkStates.key(ResourceKey.minecraft("liquid_carved"));

    /**
     * A {@link ProtoChunk} state that has yet been processed with lighting in
     * respects to the {@link ProtoWorld} that contains it. This is the second
     * to last step in the world generation pipeline for a chunk to be marked
     * as ready for being added to a {@link World}.
     */
    public static final DefaultedRegistryReference<ChunkState> LIT = ChunkStates.key(ResourceKey.minecraft("lit"));

    /**
     * State for a {@link ProtoChunk} marking it being used by a world, and not
     * in the process of either world generation, or deserialization from storage.
     * Should have an instance of {@link Chunk} providing this state only, as
     * other {@link ProtoChunk}s would assuredly be invalid with this state.
     */
    public static final DefaultedRegistryReference<ChunkState> WORLD_READY = ChunkStates.key(ResourceKey.minecraft("world_ready"));

    // SORTFIELDS:OFF

    // @formatter:on

    private ChunkStates() {
    }

    private static DefaultedRegistryReference<ChunkState> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.CHUNK_STATE, location).asDefaultedReference(() -> Sponge.game().registries());
    }
}
