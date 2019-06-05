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

import org.spongepowered.api.block.entity.BlockEntityArchetype;
import org.spongepowered.api.world.volume.block.ReadableBlockVolume;
import org.spongepowered.math.vector.Vector3i;

import java.util.Map;
import java.util.Optional;

public interface ReadableBlockEntityArchetypeVolume extends ReadableBlockVolume {

    /**
     * Gets the {@link BlockEntityArchetype} for the block entity carrying block
     * at the given coordinates.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return The block entity, if found
     */
    Optional<BlockEntityArchetype> getBlockEntityArchetype(int x, int y, int z);

    /**
     * Gets the {@link BlockEntityArchetype} for the block entity carrying block
     * at the given coordinates.
     *
     * @param position The position
     * @return The block entity, if found
     */
    default Optional<BlockEntityArchetype> getBlockEntityArchetype(Vector3i position) {
        return getBlockEntityArchetype(position.getX(), position.getY(), position.getZ());
    }

    /**
     * Gets a map containing all block entity archetypes within this volume,
     * keyed by their positions within the volume.
     *
     * @return The block entity map
     */
    Map<Vector3i, BlockEntityArchetype> getBlockEntityArchetypes();

    UnmodifiableBlockEntityArchetypeVolume<?> asUnmodifiableBlockEntityArchetypeVolume();

    ImmutableBlockEntityArchetypeVolume asImmutableBlockEntityArchetypeVolume();
}
