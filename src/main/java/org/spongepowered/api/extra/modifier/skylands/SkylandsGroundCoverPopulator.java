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

import com.flowpowered.math.vector.Vector3i;
import com.flowpowered.noise.Noise;
import com.flowpowered.noise.NoiseQuality;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.extent.ImmutableBiomeVolume;
import org.spongepowered.api.world.extent.MutableBlockVolume;
import org.spongepowered.api.world.gen.GenerationPopulator;

/**
 * Places grass and dirt on the blocks just bellow air.
 */
public class SkylandsGroundCoverPopulator implements GenerationPopulator {

    @SuppressWarnings("ConstantConditions")
    private static final GroundCoverLayer[] LAYERS = {
        new UniformGroundCoverLayer(BlockTypes.GRASS, 1),
        new VariableGroundCoverLayer(BlockTypes.DIRT, 1, 4)
    };
    private static final double HOLE_THRESHOLD = 0.6;

    @Override
    public void populate(World world, MutableBlockVolume buffer, ImmutableBiomeVolume biomes) {
        final Vector3i max = buffer.getBlockMax();
        final Vector3i min = buffer.getBlockMin();
        final int yMax = max.getY();
        final int yMin = min.getY();
        if (yMax < SkylandsTerrainGenerator.MIN_HEIGHT || yMin > SkylandsTerrainGenerator.MAX_HEIGHT) {
            return;
        }
        final long seed = world.getProperties().getSeed();
        final int intSeed = (int) (seed >> 32 ^ seed);
        final int yStart = Math.min(yMax, SkylandsTerrainGenerator.MAX_HEIGHT);
        final int yEnd = Math.max(yMin, SkylandsTerrainGenerator.MIN_HEIGHT);
        final int xMin = min.getX();
        final int zMin = min.getZ();
        final int xMax = max.getX();
        final int zMax = max.getZ();
        for (int zz = zMin; zz <= zMax; zz++) {
            for (int xx = xMin; xx <= xMax; xx++) {
                int yy = yStart;
                int layerNumber = 0;
                yIteration:
                while (yy >= yEnd) {
                    yy = SkylandsUtil.getNextSolid(buffer, xx, yy, zz, yEnd);
                    if (yy < yEnd) {
                        break;
                    }
                    if (Noise.gradientCoherentNoise3D(xx * 0.01, 0, zz * 0.01, intSeed ^ layerNumber, NoiseQuality.FAST) < HOLE_THRESHOLD) {
                        layerIteration:
                        for (GroundCoverLayer layer : LAYERS) {
                            final int yBottom = yy - layer.getDepth(xx, yy, zz, layerNumber, seed);
                            final BlockType cover = layer.getBlock(xx, yy, zz, layerNumber, seed);
                            for (; yy > yBottom; yy--) {
                                if (yy < yEnd) {
                                    break yIteration;
                                }
                                if (!buffer.getBlockType(xx, yy, zz).equals(BlockTypes.AIR)) {
                                    buffer.setBlockType(xx, yy, zz, cover);
                                } else {
                                    break layerIteration;
                                }
                            }
                        }
                    }
                    layerNumber++;
                    yy = SkylandsUtil.getNextAir(buffer, xx, yy, zz, yEnd);
                }
            }
        }
    }

    private abstract static class GroundCoverLayer {

        private GroundCoverLayer() {
        }

        protected abstract BlockType getBlock(int x, int y, int z, int layer, long seed);

        protected abstract int getDepth(int x, int y, int z, int layer, long seed);
    }

    private static class VariableGroundCoverLayer extends GroundCoverLayer {

        private final BlockType block;
        private final int min;
        private final int max;

        VariableGroundCoverLayer(BlockType block, int minDepth, int maxDepth) {
            this.block = block;
            this.min = minDepth;
            this.max = maxDepth;
        }

        @Override
        protected BlockType getBlock(int x, int y, int z, int layer, long seed) {
            return this.block;
        }

        @Override
        protected int getDepth(int x, int y, int z, int layer, long seed) {
            return (int) (SkylandsUtil.hashToFloat(x, layer, z, seed) * (this.max - this.min + 1) + this.min);
        }
    }

    private static class UniformGroundCoverLayer extends GroundCoverLayer {

        private final BlockType block;
        private final int depth;

        UniformGroundCoverLayer(BlockType block, int depth) {
            this.block = block;
            this.depth = depth;
        }

        @Override
        protected BlockType getBlock(int x, int y, int z, int layer, long seed) {
            return this.block;
        }

        @Override
        protected int getDepth(int x, int y, int z, int layer, long seed) {
            return this.depth;
        }
    }
}
