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

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.util.gen.BiomeBuffer;
import org.spongepowered.api.util.gen.MutableBlockBuffer;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.gen.GeneratorPopulator;

/**
 * Places grass and dirt on the blocks just bellow air.
 */
public class SkylandsGroundCoverPopulator implements GeneratorPopulator {

    @SuppressWarnings("ConstantConditions")
    private static final GroundCoverLayer[] LAYERS = {
        new UniformGroundCoverLayer(BlockTypes.GRASS, 1),
        new VariableGroundCoverLayer(BlockTypes.DIRT, 1, 4)
    };

    @Override
    public void populate(World world, MutableBlockBuffer buffer, BiomeBuffer biomes) {
        final Vector3i max = buffer.getBlockMax();
        final Vector3i min = buffer.getBlockMin();
        final int yMax = max.getY();
        final int yMin = min.getY();
        if (yMax < SkylandsTerrainGenerator.MIN_HEIGHT || yMin > SkylandsTerrainGenerator.MAX_HEIGHT) {
            return;
        }
        final long seed = world.getProperties().getSeed();
        final int yStart = Math.min(yMax, SkylandsTerrainGenerator.MAX_HEIGHT);
        final int yEnd = Math.max(yMin, SkylandsTerrainGenerator.MIN_HEIGHT);
        final int xMin = min.getX();
        final int zMin = min.getZ();
        final int xMax = max.getX();
        final int zMax = max.getZ();
        for (int zz = zMin; zz <= zMax; zz++) {
            for (int xx = xMin; xx <= xMax; xx++) {
                int yy = yStart;
                yIteration:
                while (yy >= yEnd) {
                    yy = SkylandsUtil.getNextSolid(buffer, xx, yy, zz, yEnd);
                    if (yy < yEnd) {
                        break;
                    }
                    layerIteration:
                    for (GroundCoverLayer layer : LAYERS) {
                        final int yBottom = yy - layer.getDepth(xx, yy, zz, seed);
                        final BlockType cover = layer.getBlock(xx, yy, zz, seed);
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
                    yy = SkylandsUtil.getNextAir(buffer, xx, yy, zz, yEnd);
                }
            }
        }
    }

    private abstract static class GroundCoverLayer {

        private GroundCoverLayer() {
        }

        protected abstract BlockType getBlock(int x, int y, int z, long seed);

        protected abstract int getDepth(int x, int y, int z, long seed);
    }

    private static class VariableGroundCoverLayer extends GroundCoverLayer {

        private final BlockType block;
        private final int min;
        private final int max;

        private VariableGroundCoverLayer(BlockType block, int minDepth, int maxDepth) {
            this.block = block;
            this.min = minDepth;
            this.max = maxDepth;
        }

        @Override
        protected BlockType getBlock(int x, int y, int z, long seed) {
            return this.block;
        }

        @Override
        protected int getDepth(int x, int y, int z, long seed) {
            return (int) (SkylandsUtil.hashToFloat(x, z, seed) * (this.max - this.min + 1) + this.min);
        }
    }

    private static class UniformGroundCoverLayer extends GroundCoverLayer {

        private final BlockType block;
        private final int depth;

        private UniformGroundCoverLayer(BlockType block, int depth) {
            this.block = block;
            this.depth = depth;
        }

        @Override
        protected BlockType getBlock(int x, int y, int z, long seed) {
            return this.block;
        }

        @Override
        protected int getDepth(int x, int y, int z, long seed) {
            return this.depth;
        }
    }
}
