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
package org.spongepowered.api.extra.modifier.skylands;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.vector.Vector3i;
import com.flowpowered.noise.module.Module;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.world.extent.MutableBlockVolume;

/**
 * Private utility methods for the Skylands generator too specific to be made
 * public.
 *
 * @deprecated Will be removed from the api
 */
@Deprecated
class SkylandsUtil {

    /**
     * Generates a 3D noise map using reduced sampling and trilinear
     * interpolation. The returned array is one larger in all dimensions.
     * TODO: make me public?
     *
     * @param noiseGenerator The noise generator module
     * @param samplingRate The sampling rate to use for each axis
     * @param x The x position of the origin of the map in the noise space
     * @param y The y position of the origin of the map in the noise space
     * @param z The z position of the origin of the map in the noise space
     * @param xSize The size on x
     * @param ySize The size on y
     * @param zSize the size on z
     *     xSize % samplingRate.getX(), ySize % samplingRate.getY()
     *     and zSize % samplingRate.getZ() must return 0.
     * @return A flat array containing the noise values,
     *     use {@link #index3D(int, int, int, int, int)} with size + 1
     *     to index it
     */
    static double[] fastNoise(Module noiseGenerator, Vector3i samplingRate, int x, int y, int z, int xSize, int ySize, int zSize) {
        xSize += 1;
        ySize += 1;
        zSize += 1;
        final int samplingRateX = samplingRate.getX();
        final int samplingRateY = samplingRate.getY();
        final int samplingRateZ = samplingRate.getZ();
        final double[] noiseArray = new double[xSize * ySize * zSize];
        for (int zz = 0; zz < zSize; zz += samplingRateZ) {
            for (int yy = 0; yy < ySize; yy += samplingRateY) {
                for (int xx = 0; xx < xSize; xx += samplingRateX) {
                    noiseArray[index3D(xx, yy, zz, xSize, ySize)] = noiseGenerator.getValue(x + xx, y + yy, z + zz);
                }
            }
        }
        for (int zz = 0; zz < zSize - 1; zz++) {
            final int zFract = zz % samplingRateZ;
            final int zPrevious = zz - zFract;
            final int zNext = zPrevious + samplingRateZ;
            for (int yy = 0; yy < ySize - 1; yy++) {
                final int yFract = yy % samplingRateY;
                final int yPrevious = yy - yFract;
                final int yNext = yPrevious + samplingRateY;
                for (int xx = 0; xx < xSize - 1; xx++) {
                    final int xFract = xx % samplingRateX;
                    if (xFract == 0 && yFract == 0 && zFract == 0) {
                        continue;
                    }
                    final int xPrevious = xx - xFract;
                    final int xNext = xPrevious + samplingRateX;
                    noiseArray[index3D(xx, yy, zz, xSize, ySize)] = GenericMath.triLerp(xx, yy, zz,
                        noiseArray[index3D(xPrevious, yPrevious, zPrevious, xSize, ySize)],
                        noiseArray[index3D(xPrevious, yNext, zPrevious, xSize, ySize)],
                        noiseArray[index3D(xPrevious, yPrevious, zNext, xSize, ySize)],
                        noiseArray[index3D(xPrevious, yNext, zNext, xSize, ySize)],
                        noiseArray[index3D(xNext, yPrevious, zPrevious, xSize, ySize)],
                        noiseArray[index3D(xNext, yNext, zPrevious, xSize, ySize)],
                        noiseArray[index3D(xNext, yPrevious, zNext, xSize, ySize)],
                        noiseArray[index3D(xNext, yNext, zNext, xSize, ySize)],
                        xPrevious, xNext, yPrevious, yNext, zPrevious, zNext);
                }
            }

        }
        return noiseArray;
    }

    /**
     * Returns the index in the flat array corresponding to the 3D coordinates.
     * TODO: make me public?
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param z The z coordinate
     * @param xSize The size on x
     * @param ySize The size on y
     * @return The index in the array
     */
    static int index3D(int x, int y, int z, int xSize, int ySize) {
        return z * xSize * ySize + y * xSize + x;
    }

    /**
     * Hashes a 2D location and seed to return a normalized float.
     * TODO: make me public?
     *
     * @param x The x coordinate to hash
     * @param y The y coordinate to hash
     * @param seed The seed for the hash
     * @return A float in the range [0, 1[ constant for a constant seed
     *     and constant position
     */
    static float hashToFloat(int x, int y, long seed) {
        final long hash = x * 73428767 ^ y * 9122569 ^ seed * 457;
        return (hash * (hash + 456149) & 0x00ffffff) / (float) 0x01000000;
    }

    /**
     * Hashes a 3D location and seed to return a normalized float.
     * TODO: make me public?
     *
     * @param x The x coordinate to hash
     * @param y The y coordinate to hash
     * @param z The z coordinate to hash
     * @param seed The seed
     * @return A float in the range [0, 1[ constant for a constant seed
     *     and constant position
     */
    static float hashToFloat(int x, int y, int z, long seed) {
        final long hash = x * 73428767 ^ y * 9122569 ^ z * 4382893 ^ seed * 457;
        return (hash * (hash + 456149) & 0x00ffffff) / (float) 0x01000000;
    }

    /**
     * Gets the next non-air block in the buffer, starting from the given y
     * coordinate and going down until yEnd. Returns yEnd if none is found.
     *
     * @param buffer The buffer to iterate
     * @param x The x coordinate of the starting point
     * @param y The y coordinate of the starting point
     * @param z The z coordinate of the starting point
     * @param yEnd The lowest y coordinate to check
     * @return The y coordinate of the next non-air block or yEnd if none
     *     found.
     */
    static int getNextSolid(MutableBlockVolume buffer, int x, int y, int z, int yEnd) {
        for (; y >= yEnd && buffer.getBlockType(x, y, z).equals(BlockTypes.AIR); y--) {
            // iterate until we reach solid
        }
        return y;
    }

    /**
     * Gets the next air block in the buffer, starting from the given y
     * coordinate and going down until yEnd. Returns yEnd if none is found.
     *
     * @param buffer The buffer to iterate
     * @param x The x coordinate of the starting point
     * @param y The y coordinate of the starting point
     * @param z The z coordinate of the starting point
     * @param yEnd The lowest y coordinate to check
     * @return The y coordinate of the next air block or yEnd if none found.
     */
    static int getNextAir(MutableBlockVolume buffer, int x, int y, int z, int yEnd) {
        for (; y >= yEnd && !buffer.getBlockType(x, y, z).equals(BlockTypes.AIR); y--) {
            // iterate until we exit the solid column
        }
        return y;
    }
}
