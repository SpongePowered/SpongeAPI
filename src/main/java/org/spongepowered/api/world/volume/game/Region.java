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
import org.spongepowered.api.world.WorldType;
import org.spongepowered.api.world.border.WorldBorder;
import org.spongepowered.api.world.volume.biome.BiomeVolume;
import org.spongepowered.api.world.volume.block.BlockVolume;
import org.spongepowered.api.world.volume.block.entity.BlockEntityVolume;
import org.spongepowered.math.vector.Vector3i;

import java.util.Objects;

public interface Region<R extends Region<R>> extends
    EnvironmentalVolume,
    BiomeVolume.Streamable<R>,
    BlockVolume.Streamable<R>,
    BlockEntityVolume.Streamable<R>,
    ChunkVolume,
    HeightAwareVolume,
    RandomProvider {

    WorldType worldType();

    /**
     * Gets the {@link WorldBorder} for this {@link Region}.
     *
     * @return The border.
     */
    WorldBorder border();

    /**
     * Sets ths {@link WorldBorder} for this {@link Region}.
     *
     * <p>As events may alter the final border set to the </p>
     *
     * @param worldBorder The border to set.
     * @return The {@link WorldBorder} that was set, which may not be the border
     *         that was provided.
     */
    WorldBorder setBorder(WorldBorder worldBorder);

    boolean isInBorder(Entity entity);

    default boolean canSeeSky(final Vector3i position) {
        return this.canSeeSky(position.x(), position.y(), position.z());
    }

    boolean canSeeSky(int x, int y, int z);

    default boolean hasLiquid(final Vector3i position) {
        return this.hasLiquid(position.x(), position.y(), position.z());
    }

    boolean hasLiquid(int x, int y, int z);

    boolean containsAnyLiquids(AABB aabb);

    int skylightSubtracted();

    /**
     * Gets the sea level of the world.
     *
     * @return The sea level
     */
    int seaLevel();

    boolean isCollisionBoxesEmpty(@Nullable Entity entity, AABB aabb);

    // TODO - Collision Boxes and VoxelShapes

    default boolean isBlockLoaded(final int x, final int y, final int z) {
        return this.isBlockLoaded(x, y, z, true);
    }

    default boolean isBlockLoaded(final int x, final int y, final int z, final boolean allowEmpty) {
        final Vector3i chunkPos = Sponge.server().chunkLayout().forceToChunk(x, y, z);
        return this.isChunkLoaded(chunkPos.x(), chunkPos.y(), chunkPos.z(), allowEmpty);
    }

    default boolean isBlockLoaded(final Vector3i position) {
        Objects.requireNonNull(position);

        return this.isBlockLoaded(position.x(), position.y(), position.z(), true);
    }

    default boolean isBlockLoaded(final Vector3i position, final boolean allowEmpty) {
        Objects.requireNonNull(position);

        return this.isBlockLoaded(position.x(), position.y(), position.z(), allowEmpty);
    }

    default boolean isAreaLoaded(final Vector3i position, final int radius) {
        Objects.requireNonNull(position);

        return this.isAreaLoaded(position, radius, true);
    }

    default boolean isAreaLoaded(final Vector3i center, final int radius, final boolean allowEmpty) {
        Objects.requireNonNull(center);

        return this.isAreaLoaded(
            center.x() - radius,
            center.y() - radius,
            center.z() - radius,
            center.x() + radius,
            center.y() + radius,
            center.z() + radius,
            allowEmpty
        );
    }

    default boolean isAreaLoaded(final Vector3i from, final Vector3i to) {
        return this.isAreaLoaded(from, to, true);
    }

    default boolean isAreaLoaded(final Vector3i from, final Vector3i to, final boolean allowEmpty) {
        return this.isAreaLoaded(from.x(), from.y(), from.z(), to.x(), to.y(), to.z(), allowEmpty);
    }

    boolean isAreaLoaded(int xStart, int yStart, int zStart, int xEnd, int yEnd, int zEnd, boolean allowEmpty);

}
