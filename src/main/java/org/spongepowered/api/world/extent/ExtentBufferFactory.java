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
package org.spongepowered.api.world.extent;

import com.flowpowered.math.vector.Vector3i;

/**
 * A factory for creating buffers to store extent data.
 */
public interface ExtentBufferFactory {

    /**
     * Returns a new biome buffer of the desired size.
     *
     * @param size The size of the buffer on x, y, and z.
     * @return A new biome buffer
     */
    default MutableBiomeVolume createBiomeBuffer(Vector3i size) {
        return createBiomeBuffer(Vector3i.ZERO, size);
    }

    /**
     * Returns a new biome buffer of the desired size and minimum position.
     *
     * @param min The minimum point of the buffer.
     * @param size The size of the buffer on x, y, and z.
     * @return A new biome buffer
     */
    MutableBiomeVolume createBiomeBuffer(Vector3i min, Vector3i size);

    /**
     * Returns a new biome buffer of the desired size.
     *
     * @param xSize The size of the buffer on x
     * @param ySize The size of the buffer on y
     * @param zSize The size of the buffer on z
     * @return A new biome buffer
     */
    default MutableBiomeVolume createBiomeBuffer(int xSize, int ySize, int zSize) {
        return createBiomeBuffer(new Vector3i(xSize, ySize, zSize));
    }

    /**
     * Returns a new biome buffer of the desired size and minimum position.
     *
     * @param xMin The minimum point of the buffer on x
     * @param yMin The minimum point of the buffer on y
     * @param zMin The minimum point of the buffer on z
     * @param xSize The size of the buffer on x
     * @param ySize The size of the buffer on y
     * @param zSize The size of the buffer on z
     * @return A new biome buffer
     */
    default MutableBiomeVolume createBiomeBuffer(int xMin, int yMin, int zMin, int xSize, int ySize, int zSize) {
        return createBiomeBuffer(new Vector3i(xMin, yMin, zMin), new Vector3i(xSize, ySize, zSize));
    }

    /**
     * Returns a new biome buffer of the desired size. This buffer is thread
     * safe.
     *
     * @param size The size of the buffer on x, y, and z.
     * @return A new biome buffer
     */
    default MutableBiomeVolume createThreadSafeBiomeBuffer(Vector3i size) {
        return createThreadSafeBiomeBuffer(Vector3i.ZERO, size);
    }

    /**
     * Returns a new biome buffer of the desired size an minimum position. This
     * buffer is thread safe.
     *
     * @param min The minimum point of the buffer.
     * @param size The size of the buffer on x, y, and z.
     * @return A new biome buffer
     */
    MutableBiomeVolume createThreadSafeBiomeBuffer(Vector3i min, Vector3i size);

    /**
     * Returns a new biome buffer of the desired size. This buffer is thread
     * safe.
     *
     * @param xSize The size of the buffer on x
     * @param ySize The size of the buffer on y
     * @param zSize The size of the buffer on z
     * @return A new biome buffer
     */
    default MutableBiomeVolume createThreadSafeBiomeBuffer(int xSize, int ySize, int zSize) {
        return createThreadSafeBiomeBuffer(new Vector3i(xSize, ySize, zSize));
    }

    /**
     * Returns a new biome buffer of the desired size. This buffer is thread
     * safe.
     *
     * @param xMin The minimum point of the buffer on x
     * @param yMin The minimum point of the buffer on y
     * @param zMin The minimum point of the buffer on z
     * @param xSize The size of the buffer on x
     * @param ySize The size of the buffer on y
     * @param zSize The size of the buffer on z
     * @return A new biome buffer
     */
    default MutableBiomeVolume createThreadSafeBiomeBuffer(int xMin, int yMin, int zMin, int xSize, int ySize, int zSize) {
        return createThreadSafeBiomeBuffer(new Vector3i(xMin, yMin, zMin), new Vector3i(xSize, ySize, zSize));
    }

    /**
     * Returns a new block buffer of the desired size.
     *
     * @param size The size of the buffer on x, y, and z
     * @return A new block buffer
     */
    default MutableBlockVolume createBlockBuffer(Vector3i size) {
        return createBlockBuffer(Vector3i.ZERO, size);
    }

    /**
     * Returns a new block buffer of the desired size and minimum position.
     *
     * @param min The minimum point of the buffer.
     * @param size The size of the buffer on x, y, and z
     * @return A new block buffer
     */
    MutableBlockVolume createBlockBuffer(Vector3i min, Vector3i size);

    /**
     * Returns a new block buffer of the desired size.
     *
     * @param xSize The size of the buffer on x
     * @param ySize The size of the buffer on y
     * @param zSize The size of the buffer on z
     * @return A new block buffer
     */
    default MutableBlockVolume createBlockBuffer(int xSize, int ySize, int zSize) {
        return createBlockBuffer(new Vector3i(xSize, ySize, zSize));
    }

    /**
     * Returns a new block buffer of the desired size and minimum position.
     *
     * @param xMin The minimum point of the buffer on x
     * @param yMin The minimum point of the buffer on y
     * @param zMin The minimum point of the buffer on z
     * @param xSize The size of the buffer on x
     * @param ySize The size of the buffer on y
     * @param zSize The size of the buffer on z
     * @return A new block buffer
     */
    default MutableBlockVolume createBlockBuffer(int xMin, int yMin, int zMin, int xSize, int ySize, int zSize) {
        return createBlockBuffer(new Vector3i(xMin, yMin, zMin), new Vector3i(xSize, ySize, zSize));
    }

    /**
     * Returns a new block buffer of the desired size. This buffer is thread
     * safe.
     *
     * @param size The size of the buffer on x, y, and z
     * @return A new block buffer
     */
    default MutableBlockVolume createThreadSafeBlockBuffer(Vector3i size) {
        return createThreadSafeBlockBuffer(Vector3i.ZERO, size);
    }

    /**
     * Returns a new block buffer of the desired size and minimum position. This
     * buffer is thread safe.
     *
     * @param min The minimum point of the buffer.
     * @param size The size of the buffer on x, y, and z
     * @return A new block buffer
     */
    MutableBlockVolume createThreadSafeBlockBuffer(Vector3i min, Vector3i size);

    /**
     * Returns a new block buffer of the desired size. This buffer is thread
     * safe.
     *
     * @param xSize The size of the buffer on x
     * @param ySize The size of the buffer on y
     * @param zSize The size of the buffer on z
     * @return A new block buffer
     */
    default MutableBlockVolume createThreadSafeBlockBuffer(int xSize, int ySize, int zSize) {
        return createThreadSafeBlockBuffer(new Vector3i(xSize, ySize, zSize));
    }

    /**
     * Returns a new block buffer of the desired size and minimum position. This
     * buffer is thread safe.
     *
     * @param xMin The minimum point of the buffer on x
     * @param yMin The minimum point of the buffer on y
     * @param zMin The minimum point of the buffer on z
     * @param xSize The size of the buffer on x
     * @param ySize The size of the buffer on y
     * @param zSize The size of the buffer on z
     * @return A new block buffer
     */
    default MutableBlockVolume createThreadSafeBlockBuffer(int xMin, int yMin, int zMin, int xSize, int ySize, int zSize) {
        return createThreadSafeBlockBuffer(new Vector3i(xMin, yMin, zMin), new Vector3i(xSize, ySize, zSize));
    }

    /**
     * Returns a new archetype volume of the desired size.
     *
     * @param size The size of the volume
     * @param origin The origin of the buffer
     * @return A new archetype volume
     */
    ArchetypeVolume createArchetypeVolume(Vector3i size, Vector3i origin);

    /**
     * Returns a new archetype volume of the desired size.
     *
     * @param size The size of the volume
     * @return A new archetype volume
     */
    default ArchetypeVolume createArchetypeVolume(Vector3i size) {
        return createArchetypeVolume(size, Vector3i.ZERO);
    }

}
