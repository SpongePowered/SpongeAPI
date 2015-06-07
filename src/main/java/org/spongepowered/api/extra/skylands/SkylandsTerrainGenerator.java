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
import com.flowpowered.noise.Noise;
import com.flowpowered.noise.NoiseQuality;
import com.flowpowered.noise.module.Module;
import com.flowpowered.noise.module.modifier.Exponent;
import com.flowpowered.noise.module.modifier.ScaleBias;
import com.flowpowered.noise.module.modifier.ScalePoint;
import com.flowpowered.noise.module.source.Perlin;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.util.gen.BiomeBuffer;
import org.spongepowered.api.util.gen.MutableBlockBuffer;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.gen.GeneratorPopulator;

/**
 * A terrain generator for a Skylands look-alike.
 */
public class SkylandsTerrainGenerator implements GeneratorPopulator {

    private static final int MID_POINT = 64;
    private static final int UPPER_SIZE = 48;
    private static final int LOWER_SIZE = 36;
    /**
     * Maximum height of the basic terrain.
     */
    public static final int MAX_HEIGHT = MID_POINT + UPPER_SIZE - 1;
    /**
     * Minimum height of the basic terrain.
     */
    public static final int MIN_HEIGHT = MID_POINT - LOWER_SIZE + 1;
    private static final double THRESHOLD = 0.215;
    private final Perlin inputNoise = new Perlin();
    private final VerticalScaling outputNoise = new VerticalScaling();
    private final OreNoise[] oreNoises;

    /**
     * Constructs a new Skylands terrain generator.
     */
    @SuppressWarnings("ConstantConditions")
    public SkylandsTerrainGenerator() {
        this.inputNoise.setFrequency(0.04);
        this.inputNoise.setLacunarity(2);
        this.inputNoise.setNoiseQuality(NoiseQuality.STANDARD);
        this.inputNoise.setPersistence(0.5);
        this.inputNoise.setOctaveCount(4);

        final ScaleBias scaleBias = new ScaleBias();
        scaleBias.setSourceModule(0, this.inputNoise);
        scaleBias.setScale(1 / getOutputMax(this.inputNoise));
        scaleBias.setBias(0);

        final ScalePoint scalePoint = new ScalePoint();
        scalePoint.setSourceModule(0, scaleBias);
        scalePoint.setXScale(0.5);
        scalePoint.setYScale(1);
        scalePoint.setZScale(0.5);

        final Exponent exponent = new Exponent();
        exponent.setSourceModule(0, scalePoint);
        exponent.setExponent(2.2);

        this.outputNoise.setSourceModule(0, exponent);
        this.outputNoise.setMidPoint(MID_POINT);
        this.outputNoise.setUpperSize(UPPER_SIZE);
        this.outputNoise.setLowerSize(LOWER_SIZE);
        this.outputNoise.setDegree(2);

        this.oreNoises = new OreNoise[]{
            new OreNoise(GenericMath.lerp(THRESHOLD, 1, 0.07), 0.3, 0.64, BlockTypes.DIAMOND_ORE),
            new OreNoise(GenericMath.lerp(THRESHOLD, 1, 0.06), 0.27, 0.64, BlockTypes.GOLD_ORE),
            new OreNoise(GenericMath.lerp(THRESHOLD, 1, 0.05), 0.26, 0.64, BlockTypes.REDSTONE_ORE),
            new OreNoise(GenericMath.lerp(THRESHOLD, 1, 0), 0.25, 0.64, BlockTypes.IRON_ORE),
            new OreNoise(GenericMath.lerp(THRESHOLD, 1, 0), 0.22, 0.63, BlockTypes.COAL_ORE)
        };
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
        final int intSeed = (int) (seed >> 32 ^ seed);
        this.inputNoise.setSeed(intSeed);
        final double[][][] noise = SkylandsUtil.fastNoise(this.outputNoise, buffer.getBlockSize(), 4, min);
        final int x = min.getX();
        final int y = min.getY();
        final int z = min.getZ();
        for (int zz = min.getZ(); zz <= max.getZ(); zz++) {
            for (int yy = min.getY(); yy <= max.getY(); yy++) {
                xIteration:
                for (int xx = min.getX(); xx <= max.getX(); xx++) {
                    final double density = noise[zz - z][yy - y][xx - x];
                    for (OreNoise oreNoise : this.oreNoises) {
                        if (oreNoise.hasBlock(density, xx, yy, zz, intSeed)) {
                            buffer.setBlockType(xx, yy, zz, oreNoise.getBlock());
                            continue xIteration;
                        }
                    }
                    buffer.setBlockType(xx, yy, zz, density >= THRESHOLD ? BlockTypes.STONE : BlockTypes.AIR);
                }
            }
        }
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

        private VerticalScaling() {
            super(1);
        }

        @Override
        public int getSourceModuleCount() {
            return 1;
        }

        private void setMidPoint(double midPoint) {
            this.midPoint = midPoint;
        }

        private void setUpperSize(double upperScale) {
            this.upperScale = upperScale;
        }

        private void setLowerSize(double lowerScale) {
            this.lowerScale = lowerScale;
        }

        private void setDegree(double degree) {
            this.degree = degree;
        }

        @Override
        public double getValue(double x, double y, double z) {
            final double value = sourceModule[0].getValue(x, y, z);
            y -= this.midPoint;
            double scale;
            if (y >= 0) {
                scale = Math.pow(y / this.upperScale, this.degree);
            } else {
                scale = Math.pow(-y / this.lowerScale, this.degree);
            }
            scale = Math.max(0, 1 - scale);
            return value * scale;
        }
    }

    private static class OreNoise {

        private final double densityThreshold;
        private final double frequency;
        private final double noiseThreshold;
        private final BlockType block;
        private final int seedTransform;

        private OreNoise(double densityThreshold, double frequency, double noiseThreshold, BlockType block) {
            this.densityThreshold = densityThreshold;
            this.frequency = frequency;
            this.noiseThreshold = noiseThreshold;
            this.block = block;
            this.seedTransform = block.getName().hashCode();
        }

        private boolean hasBlock(double density, double x, double y, double z, int seed) {
            return density >= this.densityThreshold && Noise.gradientCoherentNoise3D(x * this.frequency, y * this.frequency, z * this.frequency,
                seed ^ this.seedTransform, NoiseQuality.FAST) >= this.noiseThreshold;
        }

        private BlockType getBlock() {
            return this.block;
        }
    }
}
