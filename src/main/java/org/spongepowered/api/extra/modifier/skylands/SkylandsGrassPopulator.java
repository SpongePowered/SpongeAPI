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
import com.flowpowered.noise.module.Module;
import com.flowpowered.noise.module.source.Voronoi;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.type.PlantType;
import org.spongepowered.api.data.type.PlantTypes;
import org.spongepowered.api.data.type.ShrubTypes;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.extent.ImmutableBiomeVolume;
import org.spongepowered.api.world.extent.MutableBlockVolume;
import org.spongepowered.api.world.gen.GenerationPopulator;

/**
 * Places tall grass with groups of flowers.
 */
public class SkylandsGrassPopulator implements GenerationPopulator {

    private static final double GRASS_ODDS = 0.3;
    private static final double DOUBLE_GRASS_ODDS = 0.9;
    private static final double COVERED_GRASS_ODDS = 0.8;
    private static final BlockState TALL_GRASS;
    // the type of flower cells, null means just grass, so it's not all flowers
    @SuppressWarnings("ConstantConditions")
    private static final Flower[] FLOWERS = {
        new Flower(BlockTypes.YELLOW_FLOWER),
        new Flower(PlantTypes.WHITE_TULIP),
        new Flower(PlantTypes.ORANGE_TULIP),
        new Flower(PlantTypes.BLUE_ORCHID),
        new Flower(PlantTypes.HOUSTONIA),
        new Flower(PlantTypes.POPPY),
        null,
        null,
        null,
        null,
        null,
        null
    };
    private final Voronoi flowerCells = new Voronoi();
    private final Voronoi flowerDensities = new Voronoi();
    private final RarityCurve flowerOdds = new RarityCurve();

    static {
        //noinspection ConstantConditions
        final BlockState defaultGrass = BlockTypes.TALLGRASS.getDefaultState();
        //noinspection ConstantConditions
        TALL_GRASS = defaultGrass.with(Keys.SHRUB_TYPE, ShrubTypes.TALL_GRASS).get();
    }

    /**
     * Constructs a new grass populator for the Skylands.
     */
    public SkylandsGrassPopulator() {
        this.flowerCells.setFrequency(0.1);
        this.flowerCells.setDisplacement(FLOWERS.length - 1);
        this.flowerCells.setEnableDistance(false);
        this.flowerDensities.setFrequency(0.1);
        this.flowerDensities.setDisplacement(0);
        this.flowerDensities.setEnableDistance(true);
        this.flowerOdds.setSourceModule(0, this.flowerDensities);
        this.flowerOdds.setDegree(5);
    }

    @Override
    @SuppressWarnings("ConstantConditions")
    public void populate(World world, MutableBlockVolume buffer, ImmutableBiomeVolume biomes) {
        final Vector3i max = buffer.getBlockMax();
        final Vector3i min = buffer.getBlockMin();
        final int yMax = max.getY() - 2;
        final int yMin = min.getY();
        if (yMax < SkylandsTerrainGenerator.MIN_HEIGHT || yMin > SkylandsTerrainGenerator.MAX_HEIGHT) {
            return;
        }
        final long seed = world.getProperties().getSeed();
        final int intSeed = (int) (seed >> 32 ^ seed);
        final int intSeed2 = intSeed * 28703;
        final int yStart = Math.min(yMax, SkylandsTerrainGenerator.MAX_HEIGHT);
        final int yEnd = Math.max(yMin, SkylandsTerrainGenerator.MIN_HEIGHT);
        final int xMin = min.getX();
        final int zMin = min.getZ();
        final int xMax = max.getX();
        final int zMax = max.getZ();
        for (int zz = zMin; zz <= zMax; zz++) {
            for (int xx = xMin; xx <= xMax; xx++) {
                // get the y value of the topmost block
                int yy = SkylandsUtil.getNextSolid(buffer, xx, yStart, zz, yEnd);
                if (yy < yEnd) {
                    continue;
                }
                // only place tall grass and flowers on grass blocks
                if (buffer.getBlockType(xx, yy, zz) == BlockTypes.GRASS) {
                    // some random value to compare to odds
                    final float value = SkylandsUtil.hashToFloat(xx, zz, seed);
                    // get the flower for the current cell, may be null
                    this.flowerCells.setSeed(intSeed);
                    this.flowerDensities.setSeed(intSeed);
                    Flower flower = FLOWERS[(int) this.flowerCells.getValue(xx, 0, zz)];
                    // check if we have a flower based on odds for the cell
                    if (flower == null || value < this.flowerOdds.getValue(xx, 0, zz)) {
                        // try with a different seed to create a second layer of flower cells, giving us some overlap
                        this.flowerCells.setSeed(intSeed2);
                        this.flowerDensities.setSeed(intSeed2);
                        flower = FLOWERS[(int) this.flowerCells.getValue(xx, 0, zz)];
                        // try the check again if we have a flower
                        if (flower != null && value < this.flowerOdds.getValue(xx, 0, zz)) {
                            // check failed, no flowers
                            flower = null;
                        }
                    }
                    if (flower != null) {
                        buffer.setBlock(xx, yy + 1, zz, flower.getBlock());
                        if (flower.isDoubleHeight()) {
                            buffer.setBlock(xx, yy + 2, zz, flower.getUpperBlock());
                        }
                    } else if (value >= GRASS_ODDS) {
                        // if no flower, check if the value is greater than the grass odds
                        if (value >= DOUBLE_GRASS_ODDS && yy + 1 < yMax) {
                            // tall grass is a bit more rare
                            //buffer.setBlockType(xx, yy + 1, zz, BlockTypes.MELON_BLOCK);
                            //buffer.setBlockType(xx, yy + 2, zz, BlockTypes.MELON_BLOCK);
                            // TODO: fix double plants
                            buffer.setBlock(xx, yy + 1, zz, TALL_GRASS);
                        } else {
                            buffer.setBlock(xx, yy + 1, zz, TALL_GRASS);
                        }
                    }
                }
                // locations underneath this one will only get grass and less of it as they are covered
                yy = SkylandsUtil.getNextAir(buffer, xx, yy, zz, yEnd);
                yy = SkylandsUtil.getNextSolid(buffer, xx, yy, zz, yEnd);
                int layerNumber = 0;
                while (yy >= yEnd) {
                    // only place on grass blockss
                    if (buffer.getBlockType(xx, yy, zz) == BlockTypes.GRASS) {
                        // generate a new random value for the layer
                        final float value = SkylandsUtil.hashToFloat(xx, layerNumber, zz, seed);
                        if (value >= COVERED_GRASS_ODDS) {
                            buffer.setBlock(xx, yy + 1, zz, TALL_GRASS);
                        }
                    }
                    layerNumber++;
                    yy = SkylandsUtil.getNextAir(buffer, xx, yy, zz, yEnd);
                    yy = SkylandsUtil.getNextSolid(buffer, xx, yy, zz, yEnd);
                }
            }
        }
    }

    @SuppressWarnings("ConstantConditions")
    private static class Flower {

        private static final BlockState DEFAULT_FLOWER = BlockTypes.RED_FLOWER.getDefaultState();
        private final BlockState block;
        private final boolean doubleHeight;
        private final BlockState upperBlock;

        Flower(PlantType type) {
            this(DEFAULT_FLOWER.with(Keys.PLANT_TYPE, type).get(), false);
        }

        Flower(BlockType block) {
            this(block.getDefaultState(), false);
        }

        Flower(BlockState block, boolean doubleHeight) {
            this.block = block;
            this.doubleHeight = doubleHeight;
            this.upperBlock = this.block;
        }

        BlockState getBlock() {
            return this.block;
        }

        boolean isDoubleHeight() {
            return this.doubleHeight;
        }

        BlockState getUpperBlock() {
            return this.upperBlock;
        }
    }

    private static class RarityCurve extends Module {

        private double degree;

        RarityCurve() {
            super(1);
        }

        void setDegree(double degree) {
            this.degree = degree;
        }

        @Override
        public int getSourceModuleCount() {
            return 1;
        }

        @Override
        public double getValue(double x, double y, double z) {
            final double value = this.sourceModule[0].getValue(x, y, z);
            return 1 - Math.pow(1 - value, this.degree);
        }
    }
}
