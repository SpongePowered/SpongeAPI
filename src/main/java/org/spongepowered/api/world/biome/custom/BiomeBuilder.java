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
package org.spongepowered.api.world.biome.custom;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.data.types.ResourceType;
import org.spongepowered.api.world.biome.BiomeType;

import java.util.HashMap;
import java.util.List;

/**
 * Builder used to create TerrainControl-style customized biomes.
 */
public interface BiomeBuilder {

    BiomeBuilder parent(BiomeType parent);

    /**
     * Set the id of this biome. Cannot be greater than 255.
     *
     * @param id The id
     * @return This builder, for chaining
     */
    BiomeBuilder id(int id);

    /**
     * Set the name of this biome.
     *
     * @param name The name
     * @return This builder, for chaining
     */
    BiomeBuilder name(String name);

    BiomeBuilder size(int size);

    BiomeBuilder rarity(int rarity);

    BiomeBuilder color(String hex);

    /**
     * The height of the biome. 0.0 is half of map height.
     *
     * @param height The height of the biome
     * @return This builder, for chaining
     */
    BiomeBuilder height(float height);

    BiomeBuilder maxAverageHeight(float height);

    BiomeBuilder maxAverageDepth(float depth);

    BiomeBuilder smoothRadius(int radius);

    /**
     * Adjusts the weight of the corresponding volatility settings. This
     * allows you to change how prevalent you want either of the volatility settings to be in the terrain.
     *
     * @param weight1 The first weight
     * @param weight2 The second weight
     * @return This builder, for chaining
     */
    BiomeBuilder volatility(float weight1, float weight2);

    BiomeBuilder volatilityWeight(float weight1, float weight2);

    BiomeBuilder biomeVolatility(float volatility);

    BiomeBuilder customHeightControl(List<Float> list);

    BiomeBuilder surfaceBlock(BlockState block);

    BiomeBuilder groundBlock(BlockState block);

    BiomeBuilder setWater(int min, int max);


    /**
     * Set the block in place of water. Defaults to
     * {@link org.spongepowered.api.block.BlockTypes#WATER}.
     *
     * @param block The block used in place of water
     * @return This builder, for chaining
     */
    BiomeBuilder waterBlock(BlockState block);

    /**
     * Set values for the resource generators.
     *
     * @param type The type of resource set
     * @param properties The properties of the resource, <em>(Ex. How often it occurs etc.)</em>
     * @return This builder, for chaining
     * @throws BiomeSettingsException When the properties do not reflect the
     * properties of the resource.
     */
    BiomeBuilder resource(ResourceType type, HashMap<String, Object> properties) throws BiomeSettingsException;

    /**
     * Set this custom biome as a normal biome.
     *
     * @return The normal biome builder, for chaining
     * @throws IllegalStateException
     */
    NormalBiomeBuilder setNormalBiome() throws IllegalStateException;

    /**
     * Set this custom biome as biome that borders other biomes.
     *
     * @return The border biome builder, for chaining
     * @throws IllegalStateException
     */
    BorderBiomeBuilder setBorderBiome() throws IllegalStateException;

    /**
     * Set this custom biome as a <strong>island</strong> biome.
     *
     * @return The island biome builder, for chaining
     * @throws IllegalStateException
     */
    IsleBiomeBuilder setIsleBiome() throws IllegalStateException;
}
