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

import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.util.weighted.VariableAmount;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.gen.GenerationPopulator;
import org.spongepowered.api.world.gen.WorldGenerator;
import org.spongepowered.api.world.gen.WorldGeneratorModifier;
import org.spongepowered.api.world.gen.populator.Forest;
import org.spongepowered.api.world.gen.populator.Lake;
import org.spongepowered.api.world.gen.type.BiomeTreeTypes;
import org.spongepowered.api.world.storage.WorldProperties;

import java.util.List;

/**
 * Modifies a {@link World}'s generation to look like the world type "Skylands"
 * that used to exist in vanilla Minecraft.
 *
 * @deprecated Will be removed from the api
 */
@Deprecated
public class SkylandsWorldGeneratorModifier implements WorldGeneratorModifier {

    @Override
    public void modifyWorldGenerator(WorldProperties properties, DataContainer settings, WorldGenerator worldGenerator) {
        worldGenerator.setBaseGenerationPopulator(new SkylandsTerrainGenerator());
        worldGenerator.setBiomeGenerator(new SkylandsBiomeGenerator());
        final List<GenerationPopulator> generationPopulators = worldGenerator.getGenerationPopulators();
        generationPopulators.clear();
        generationPopulators.add(new SkylandsGroundCoverPopulator());
        generationPopulators.add(new SkylandsGrassPopulator());
        worldGenerator.getPopulators().clear();

        // TODO: temporary, need to decide what to use
        final Forest forest = Forest.builder()
                .perChunk(VariableAmount.baseWithOptionalAddition(6, 1, 0.1))
                .type(BiomeTreeTypes.OAK.getPopulatorObject(), 4)
                .type(BiomeTreeTypes.BIRCH.getPopulatorObject(), 1)
                .build();

        worldGenerator.getPopulators().add(0, forest);

        final Lake lake = Lake.builder()
                .chance(0.25)
                .liquidType(BlockTypes.WATER.getDefaultState())
                .height(VariableAmount.baseWithRandomAddition(0, 256))
                .build();

        worldGenerator.getPopulators().add(1, lake);
    }

    @Override
    public String getId() {
        return "sponge:skylands";
    }

    @Override
    public String getName() {
        return "Skylands Modifier";
    }
}
