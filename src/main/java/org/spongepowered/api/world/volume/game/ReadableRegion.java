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
package org.spongepowered.api.world.volume.game;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.util.AABB;
import org.spongepowered.api.util.RandomProvider;
import org.spongepowered.api.world.WorldBorder;
import org.spongepowered.api.world.dimension.DimensionType;
import org.spongepowered.api.world.volume.biome.StreamableBiomeVolume;
import org.spongepowered.api.world.volume.block.StreamableBlockVolume;
import org.spongepowered.api.world.volume.block.entity.StreamableBlockEntityVolume;
import org.spongepowered.api.world.volume.entity.StreamableEntityVolume;
import org.spongepowered.math.vector.Vector3i;

import java.util.Objects;

public interface ReadableRegion<R extends ReadableRegion<R>> extends
    EnvironmentalVolume,
    StreamableBiomeVolume<R>,
    StreamableBlockVolume<R>,
    StreamableEntityVolume<R>,
    StreamableBlockEntityVolume<R>,
    ChunkVolume,
    HeightAwareVolume,
    RandomProvider {

    DimensionType getDimensionType();

    WorldBorder getBorder();

    boolean isInBorder(Entity entity);

    default boolean canSeeSky(Vector3i position) {
        return this.canSeeSky(position.getX(), position.getY(), position.getZ());
    }

    boolean canSeeSky(int x, int y, int z);

    default boolean hasLiquid(Vector3i position) {
        return this.hasLiquid(position.getX(), position.getY(), position.getZ());
    }

    boolean hasLiquid(int x, int y, int z);

    boolean containsAnyLiquids(AABB aabb);

    int getSkylightSubtracted();

    /**
     * Gets the sea level of the world.
     *
     * @return The sea level
     */
    int getSeaLevel();

    boolean isCollisionBoxesEmpty(@Nullable Entity entity, AABB aabb);

    // TODO - Collision Boxes and VoxelShapes

    default boolean isBlockLoaded(int x, int y, int z) {
        return this.isBlockLoaded(x, y, z, true);
    }

    default boolean isBlockLoaded(int x, int y, int z, boolean allowEmpty) {
        final Vector3i chunkPos = Sponge.getServer().getChunkLayout().forceToChunk(x, y, z);
        return this.isChunkLoaded(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ(), allowEmpty);
    }

    default boolean isBlockLoaded(Vector3i position) {
        Objects.requireNonNull(position);

        return this.isBlockLoaded(position.getX(), position.getY(), position.getZ(), true);
    }

    default boolean isBlockLoaded(Vector3i position, boolean allowEmpty) {
        Objects.requireNonNull(position);

        return this.isBlockLoaded(position.getX(), position.getY(), position.getZ(), allowEmpty);
    }

    default boolean isAreaLoaded(Vector3i position, int radius) {
        Objects.requireNonNull(position);

        return this.isAreaLoaded(position, radius, true);
    }

    default boolean isAreaLoaded(Vector3i center, int radius, boolean allowEmpty) {
        Objects.requireNonNull(center);

        return this.isAreaLoaded(
            center.getX() - radius,
            center.getY() - radius,
            center.getZ() - radius,
            center.getX() + radius,
            center.getY() + radius,
            center.getZ() + radius,
            allowEmpty
        );
    }

    default boolean isAreaLoaded(Vector3i from, Vector3i to) {
        return this.isAreaLoaded(from, to, true);
    }

    default boolean isAreaLoaded(Vector3i from, Vector3i to, boolean allowEmpty) {
        return this.isAreaLoaded(from.getX(), from.getY(), from.getZ(), to.getX(), to.getY(), to.getZ(), allowEmpty);
    }

    boolean isAreaLoaded(int xStart, int yStart, int zStart, int xEnd, int yEnd, int zEnd, boolean allowEmpty);

}
