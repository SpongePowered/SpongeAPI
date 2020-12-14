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
package org.spongepowered.api.world;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registries;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

/**
 * An enumeration of the possible {@link ChunkRegenerateFlag}s.
 *
 * <p>{@link ChunkRegenerateFlag}s can be combined using the
 * {@link ChunkRegenerateFlag#andFlag(ChunkRegenerateFlag)} and
 * {@link ChunkRegenerateFlag#andNotFlag(ChunkRegenerateFlag)} operators.</p>
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class ChunkRegenerateFlags {

    // @formatter:off

    // SORTFIELDS:ON

    /**
     * All the available flags are applied through the AND operator.
     */
    public static final DefaultedRegistryReference<ChunkRegenerateFlag> ALL = ChunkRegenerateFlags.key(ResourceKey.sponge("all"));

    /**
     * A flag that defines whether a chunk should be created.
     */
    public static final DefaultedRegistryReference<ChunkRegenerateFlag> CREATE = ChunkRegenerateFlags.key(ResourceKey.sponge("create"));

    /**
     * A flag that defines whether a chunk should preserve entities.
     * 
     * Note: It is up to the implementation to decide whether this will
     * include moving entities to safe locations.
     */
    public static final DefaultedRegistryReference<ChunkRegenerateFlag> ENTITIES = ChunkRegenerateFlags.key(ResourceKey.sponge("entities"));

    /**
     * No flags are set, triggers nothing.
     */
    public static final DefaultedRegistryReference<ChunkRegenerateFlag> NONE = ChunkRegenerateFlags.key(ResourceKey.sponge("none"));

    // SORTFIELDS:OFF

    // @formatter:on

    private ChunkRegenerateFlags() {
    }

    private static DefaultedRegistryReference<ChunkRegenerateFlag> key(final ResourceKey location) {
        return RegistryKey.of(Registries.CHUNK_REGENERATE_FLAG, location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
