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
package org.spongepowered.api.world.volume;

import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.util.AABB;
import org.spongepowered.api.util.RandomProvider;
import org.spongepowered.api.world.Dimension;
import org.spongepowered.api.world.WorldBorder;
import org.spongepowered.api.world.volume.biome.StreamableBiomeVolume;
import org.spongepowered.api.world.volume.block.StreamableBlockVolume;
import org.spongepowered.api.world.volume.composite.ReadableCompositeVolume;
import org.spongepowered.api.world.volume.entity.CollisionAwareEntityVolume;
import org.spongepowered.api.world.volume.entity.StreamableEntityVolume;
import org.spongepowered.api.world.volume.block.entity.StreamableBlockEntityVolume;

import javax.annotation.Nullable;

public interface ReadableRegion<R extends ReadableRegion<R>> extends
    ReadableCompositeVolume,
    StreamableBiomeVolume<R>,
    StreamableBlockVolume<R>,
    StreamableEntityVolume<R>,
    StreamableBlockEntityVolume<R>,
    CollisionAwareEntityVolume,
    LightCalculatingVolume,
    HeightAwareVolume,
    RandomProvider {


    WorldBorder getBorder();

    boolean isInBorder(Entity entity);

    default boolean canSeeSky(Vector3i pos) {
        return canSeeSky(pos.getX(), pos.getY(), pos.getZ());
    }

    boolean canSeeSky(int x, int y, int z);

    default boolean hasWater(Vector3i pos) {
        return hasWater(pos.getX(), pos.getY(), pos.getZ());
    }

    boolean hasWater(int x, int y, int z);

    default boolean containsAnyLiquids(AABB aabb) {
        final Vector3d min = aabb.getMin();
        final Vector3d max = aabb.getMax();
        return getView(min.floor().toInt(), max.ceil().toInt())
            .toBlockStream()
            .anyMatch((volume, element, x, y, z) -> !element.getFluidState().isEmpty());
    }

    int getSkylightSubtracted();

    /**
     * Gets the sea level of the world.
     *
     * @return The sea level
     */
    int getSeaLevel();

    boolean isCollisionBoxesEmpty(@Nullable Entity entity, AABB aabb);

    boolean isChunkLoaded(int x, int y, int z, boolean allowEmpty);

    default boolean isBlockLoaded(int x, int y, int z) {
        return isBlockLoaded(x, y, z, true);
    }

    default boolean isBlockLoaded(int x, int y, int z, boolean allowEmpty) {
        final Vector3i chunkPos = Sponge.getServer().getChunkLayout().forceToChunk(x, y, z);
        return isChunkLoaded(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ(), allowEmpty);
    }

    default boolean isBlockLoaded(Vector3i pos) {
        return this.isBlockLoaded(pos.getX(), pos.getY(), pos.getZ(), true);
    }

    default boolean isBlockLoaded(Vector3i pos, boolean allowEmpty) {
        return this.isBlockLoaded(pos.getX(), pos.getY(), pos.getZ(), allowEmpty);
    }

    default boolean isAreaLoaded(Vector3i pos, int radius) {
        return this.isAreaLoaded(pos, radius, true);
    }

    default boolean isAreaLoaded(Vector3i center, int radius, boolean allowEmpty) {
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

    Dimension getDimension();
}
