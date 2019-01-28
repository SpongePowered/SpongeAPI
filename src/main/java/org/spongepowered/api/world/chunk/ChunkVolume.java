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

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.world.volume.block.ReadableBlockVolume;

public interface ChunkVolume extends ReadableBlockVolume {

    ProtoChunk<?> getChunk(int x, int y, int z);

    default ProtoChunk<?> getChunk(Vector3i pos) {
        return getChunk(pos.getX(), pos.getY(), pos.getZ());
    }

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
}
