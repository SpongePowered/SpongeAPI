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
import com.flowpowered.noise.NoiseQuality;
import com.flowpowered.noise.module.Module;
import com.flowpowered.noise.module.modifier.Exponent;
import com.flowpowered.noise.module.modifier.ScaleBias;
import com.flowpowered.noise.module.modifier.ScalePoint;
import com.flowpowered.noise.module.source.Perlin;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.util.gen.BiomeBuffer;
import org.spongepowered.api.util.gen.MutableBlockBuffer;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.gen.GeneratorPopulator;

/**
 * A terrain generator modifier for a Skylands look-alike.
 */
public class SkylandsTerrainGenerator implements GeneratorPopulator {

    private static final int MID_POINT = 64;
    private static final int UPPER_SIZE = 24;
    private static final int LOWER_SIZE = 24;
    public static final int MAX_HEIGHT = MID_POINT + UPPER_SIZE - 1;
    public static final int MIN_HEIGHT = MID_POINT - LOWER_SIZE + 1;
    private static final double THRESHOLD = 0.25;
    private final Perlin inputNoise = new Perlin();
    private final VerticalScaling outputNoise = new VerticalScaling();

    public SkylandsTerrainGenerator() {
        inputNoise.setFrequency(0.04);
        inputNoise.setLacunarity(2);
        inputNoise.setNoiseQuality(NoiseQuality.STANDARD);
        inputNoise.setPersistence(0.5);
        inputNoise.setOctaveCount(4);

        final ScaleBias scaleBias = new ScaleBias();
        scaleBias.setSourceModule(0, inputNoise);
        scaleBias.setScale(1 / getOutputMax(inputNoise));
        scaleBias.setBias(0);

        final ScalePoint scalePoint = new ScalePoint();
        scalePoint.setSourceModule(0, scaleBias);
        scalePoint.setXScale(0.5);
        scalePoint.setYScale(1);
        scalePoint.setZScale(0.5);

        final Exponent exponent = new Exponent();
        exponent.setSourceModule(0, scalePoint);
        exponent.setExponent(2);

        outputNoise.setSourceModule(0, exponent);
        outputNoise.setMidPoint(MID_POINT);
        outputNoise.setUpperSize(UPPER_SIZE);
        outputNoise.setLowerSize(LOWER_SIZE);
        outputNoise.setDegree(2);
    }

    @Override
    @SuppressWarnings("ConstantConditions")
    public void populate(World world, MutableBlockBuffer buffer, BiomeBuffer biomes) {
        final Vector3i min = buffer.getBlockMin();
        final Vector3i max = buffer.getBlockMax();
        if (max.getY() < SkylandsTerrainGenerator.MIN_HEIGHT || min.getY() > SkylandsTerrainGenerator.MAX_HEIGHT) {
            return;
        }
        final long seed = world.getProperties().getSeed();
        inputNoise.setSeed((int) (seed >> 32 ^ seed));
        final double[][][] noise = fastNoise(outputNoise, buffer.getBlockSize(), 4, min);
        final int x = min.getX();
        final int y = min.getY();
        final int z = min.getZ();
        for (int zz = min.getZ(); zz <= max.getZ(); zz++) {
            for (int yy = min.getY(); yy <= max.getY(); yy++) {
                for (int xx = min.getX(); xx <= max.getX(); xx++) {
                    final double density = noise[zz - z][yy - y][xx - x];
                    buffer.setBlockType(xx, yy, zz, density >= THRESHOLD ? BlockTypes.STONE : BlockTypes.AIR);
                }
            }
        }
    }

    /**
     * Generates a 3D noise map using reduced sampling and trilinear interpolation.
     * TODO: move this to a util class?
     *
     * @param noiseGenerator The noise generator module
     * @param size The size of the 3D map
     * @param samplingPeriod The sampling period to use. xSize % samplingPeriod, ySize % samplingPeriod and zSize % samplingPeriod must return 0.
     * @param position The position of (0, 0, 0) index of the map in the noise space
     * @throws IllegalArgumentException if the noise generator is null, the sampling rate is zero, or xSize % samplingPeriod, ySize %
     * samplingPeriod or
     * zSize % samplingPeriod doesn't return 0
     */
    public static double[][][] fastNoise(Module noiseGenerator, Vector3i size, int samplingPeriod, Vector3i position) {
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

    private static double getOutputMax(Perlin perlin) {
        final int octaves = perlin.getOctaveCount();
        final double persistence = perlin.getPersistence();
        double max = 0;
        for (int i = 0; i < octaves; i++) {
            max += Math.pow(persistence, i);
        }
        return max;
    }

    private static class VerticalScaling extends Module {

        private double midPoint;
        private double upperScale;
        private double lowerScale;
        private double degree;

        public VerticalScaling() {
            super(1);
        }

        @Override
        public int getSourceModuleCount() {
            return 1;
        }

        public void setMidPoint(double midPoint) {
            this.midPoint = midPoint;
        }

        public void setUpperSize(double upperScale) {
            this.upperScale = upperScale;
        }

        public void setLowerSize(double lowerScale) {
            this.lowerScale = lowerScale;
        }

        public void setDegree(double degree) {
            this.degree = degree;
        }

        @Override
        public double getValue(double x, double y, double z) {
            final double value = sourceModule[0].getValue(x, y, z);
            y -= midPoint;
            double scale;
            if (y >= 0) {
                scale = Math.pow(y / upperScale, degree);
            } else {
                scale = Math.pow(-y / lowerScale, degree);
            }
            scale = Math.max(0, 1 - scale);
            return value * scale;
        }
    }
}
