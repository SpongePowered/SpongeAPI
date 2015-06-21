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
     * @param samplingRate The sampling rate to use for each axis
     *     xSize % samplingRate.getX(), ySize % samplingRate.getY()
     *     and zSize % samplingRate.getZ() must return 0.
     * @param position The position of (0, 0, 0) index of the map in the
     *     noise space
     * @return An array containing the noise values, in order [z][y][x]
     */
    static double[][][] fastNoise(Module noiseGenerator, Vector3i size, Vector3i samplingRate, Vector3i position) {
        final int xSize = size.getX();
        final int ySize = size.getY();
        final int zSize = size.getZ();
        final int samplingRateX = samplingRate.getX();
        final int samplingRateY = samplingRate.getY();
        final int samplingRateZ = samplingRate.getZ();
        final double[][][] noiseArray = new double[zSize + 1][ySize + 1][xSize + 1];
        final int x = position.getX();
        final int y = position.getY();
        final int z = position.getZ();
        for (int zz = 0; zz <= zSize; zz += samplingRateZ) {
            final double[][] zNoiseArray = noiseArray[zz];
            for (int yy = 0; yy <= ySize; yy += samplingRateY) {
                final double[] yNoiseArray = zNoiseArray[yy];
                for (int xx = 0; xx <= xSize; xx += samplingRateX) {
                    yNoiseArray[xx] = noiseGenerator.getValue(x + xx, y + yy, z + zz);
                }
            }
        }
        for (int zz = 0; zz < zSize; zz++) {
            final double[][] zNoiseArray = noiseArray[zz];
            final int zFract = zz % samplingRateZ;
            final int zPrevious = zz - zFract;
            final int zNext = zPrevious + samplingRateZ;
            final double[][] zPreviousSample = noiseArray[zPrevious];
            final double[][] zNextSample = noiseArray[(zNext)];
            for (int yy = 0; yy < ySize; yy++) {
                final double[] yNoiseArray = zNoiseArray[yy];
                final int yFract = yy % samplingRateY;
                final int yPrevious = yy - yFract;
                final int yNext = yPrevious + samplingRateY;
                final double[] yPreviousPreviousSample = zPreviousSample[yPrevious];
                final double[] yPreviousNextSample = zPreviousSample[(yNext)];
                final double[] yNextPreviousSample = zNextSample[yPrevious];
                final double[] yNextNextSample = zNextSample[(yNext)];
                for (int xx = 0; xx < xSize; xx++) {
                    final int xFract = xx % samplingRateX;
                    if (xFract == 0 && yFract == 0 && zFract == 0) {
                        continue;
                    }
                    final int xPrevious = xx - xFract;
                    final int xNext = xPrevious + samplingRateX;
                    yNoiseArray[xx] = GenericMath.triLerp(xx, yy, zz,
                        yPreviousPreviousSample[xPrevious],
                        yPreviousNextSample[xPrevious],
                        yNextPreviousSample[xPrevious],
                        yNextNextSample[xPrevious],
                        yPreviousPreviousSample[xNext],
                        yPreviousNextSample[xNext],
                        yNextPreviousSample[xNext],
                        yNextNextSample[xNext],
                        xPrevious, xNext, yPrevious, yNext, zPrevious, zNext);
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
