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
package org.spongepowered.api.world.gen;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.GameRegistry;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.util.annotation.CatalogedBy;
import org.spongepowered.api.world.storage.WorldProperties;

/**
 * Custom world generation is done using this interface. Any plugin that wishes
 * to modify the world generator should implement this interface. When the
 * server admin/player has chosen to use this modifier for a world, the method
 * {@link #modifyWorldGenerator(WorldProperties, DataContainer, WorldGenerator)}
 * will be called.
 *
 * <p>The modifier can change every aspect of terrain generation using the
 * {@link WorldGenerator} provided as a parameter to
 * {@code modifyWorldGenerator}. This is no requirement, you can for example
 * replace only the biome generator. Multiple world generator modifiers can be
 * applied on a single world.</p>
 *
 * <p>Implementations of this interface must be registered using the
 * {@link GameRegistry}.</p>
 */
@CatalogedBy(WorldGeneratorModifiers.class)
public interface WorldGeneratorModifier extends CatalogType {

    /**
     * Modifies the given world generator. This method is called by the
     * implementation when the server is set to use this plugin for world
     * generation.
     *
     * <p>To replace the base chunk generator, replace the main generator
     * populator using
     * {@link WorldGenerator#setBaseGenerationPopulator(GenerationPopulator)}.
     * To replace the biome generator, use
     * {@link WorldGenerator#setBiomeGenerator(BiomeGenerator)}. To change
     * terrain population, modify the populator list returned by
     * {@link WorldGenerator#getPopulators()} or
     * {@link WorldGenerator#getGenerationPopulators()}.</p>
     *
     * @param world The properties of the world.
     * @param settings A data container with (usually) user-provided settings,
     *        can be used by the plugin to modify the world generator.
     * @param worldGenerator The world generator, should be modified.
     * @see WorldGenerator Additional information on the generation process
     */
    void modifyWorldGenerator(WorldProperties world, DataContainer settings, WorldGenerator worldGenerator);

}
