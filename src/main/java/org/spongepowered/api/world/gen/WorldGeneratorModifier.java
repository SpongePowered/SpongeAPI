/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

import org.spongepowered.api.plugin.PluginContainer;

import org.spongepowered.api.GameRegistry;
import org.spongepowered.api.service.persistence.data.DataContainer;

/**
 * If a plugin wishes to modify a world generator, the plugin must register a
 * custom implementation of this interface.
 *
 * @see GameRegistry#registerWorldGeneratorModifier(PluginContainer, String,
 *      WorldGeneratorModifier)
 */
public interface WorldGeneratorModifier {

    /**
     * Modifies the given world generator. This method is called by the
     * implementation when the server is set to use this plugin for world
     * generation.
     *
     * <p>To replace the base chunk generator, replace the main generator
     * populator using
     * {@link WorldGenerator#setBaseGeneratorPopulator(GeneratorPopulator)}. To
     * replace the biome generator, use
     * {@link WorldGenerator#setBiomeGenerator(BiomeGenerator)}. To change
     * terrain population, modify the populator list returned by
     * {@link WorldGenerator#getPopulators()}.</p>
     *
     * @param worldName The name of the world.
     * @param settings A data container with settings, can be used by the plugin
     *        to modify the world generator.
     * @param worldGenerator The world generator, should be modified.
     */
    void modifyWorldGenerator(String worldName, DataContainer settings, WorldGenerator worldGenerator);

}
