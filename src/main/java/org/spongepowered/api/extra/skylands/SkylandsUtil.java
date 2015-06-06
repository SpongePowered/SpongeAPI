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
package org.spongepowered.api.extra.skylands;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.vector.Vector3i;
import com.flowpowered.noise.module.Module;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.util.gen.MutableBlockBuffer;

/**
 * Private utility methods for the Skylands generator too specific to be made
 * public.
 */
class SkylandsUtil {

    /**
     * Generates a 3D noise map using reduced sampling and trilinear
     * interpolation.
     * TODO: make me public?
     *
     * @param noiseGenerator The noise generator module
     * @param size The size of the 3D map
     * @param samplingPeriod The sampling period to use.
     *     xSize % samplingPeriod, ySize % samplingPeriod
     *     and zSize % samplingPeriod must return 0.
     * @param position The position of (0, 0, 0) index of the map in the
     *     noise space
     * @return An array containing the noise values, in order [z][y][x]
     * @throws IllegalArgumentException if the noise generator is null,
     *     the sampling rate is zero, or xSize % samplingPeriod,
     *     ySize % samplingPeriod or zSize % samplingPeriod doesn't return 0
     */
    static double[][][] fastNoise(Module noiseGenerator, Vector3i size, int samplingPeriod, Vector3i position) {
        if (samplingPeriod <= 0) {
            throw new IllegalArgumentException("samplingPeriod cannot smaller or equal to 0");
        }
        final int xSize = size.getX();
        final int ySize = size.getY();
        final int zSize = size.getZ();
        if (xSize % samplingPeriod != 0) {
            throw new IllegalArgumentException("x size % samplingPeriod must return 0");
        }
        if (ySize % samplingPeriod != 0) {
            throw new IllegalArgumentException("y size % samplingPeriod must return 0");
        }
        if (zSize % samplingPeriod != 0) {
            throw new IllegalArgumentException("z size % samplingPeriod must return 0");
        }
        final double[][][] noiseArray = new double[zSize + 1][ySize + 1][xSize + 1];
        final int x = position.getX();
        final int y = position.getY();
        final int z = position.getZ();
        for (int zz = 0; zz <= zSize; zz += samplingPeriod) {
            for (int yy = 0; yy <= ySize; yy += samplingPeriod) {
                for (int xx = 0; xx <= xSize; xx += samplingPeriod) {
                    noiseArray[zz][yy][xx] = noiseGenerator.getValue(x + xx, y + yy, z + zz);
                }
            }
        }
        for (int zz = 0; zz < zSize; zz++) {
            for (int yy = 0; yy < ySize; yy++) {
                for (int xx = 0; xx < xSize; xx++) {
                    final int xFract = xx % samplingPeriod;
                    final int yFract = yy % samplingPeriod;
                    final int zFract = zz % samplingPeriod;
                    if (xFract != 0 || yFract != 0 || zFract != 0) {
                        int nx = xx - xFract;
                        int ny = yy - yFract;
                        int nz = zz - zFract;
                        noiseArray[zz][yy][xx] = GenericMath.triLerp(xx, yy, zz,
                            noiseArray[nz][ny][nx],
                            noiseArray[nz][ny + samplingPeriod][nx],
                            noiseArray[nz + samplingPeriod][ny][nx],
                            noiseArray[nz + samplingPeriod][ny + samplingPeriod][nx],
                            noiseArray[nz][ny][nx + samplingPeriod],
                            noiseArray[nz][ny + samplingPeriod][nx + samplingPeriod],
                            noiseArray[nz + samplingPeriod][ny][nx + samplingPeriod],
                            noiseArray[nz + samplingPeriod][ny + samplingPeriod][nx + samplingPeriod],
                            nx, nx + samplingPeriod, ny, ny + samplingPeriod, nz, nz + samplingPeriod);
                    }
                }
            }

        }
        return noiseArray;
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
    @SuppressWarnings("StatementWithEmptyBody")
    static int getNextSolid(MutableBlockBuffer buffer, int x, int y, int z, int yEnd) {
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
    @SuppressWarnings("StatementWithEmptyBody")
    static int getNextAir(MutableBlockBuffer buffer, int x, int y, int z, int yEnd) {
        for (; y >= yEnd && !buffer.getBlockType(x, y, z).equals(BlockTypes.AIR); y--) {
            // iterate until we exit the solid column
        }
        return y;
    }
}
