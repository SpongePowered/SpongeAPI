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

import org.spongepowered.api.world.biome.BiomeType;

import java.util.List;

/**
 * Represents the world generator of a world. This interface contains all
 * settings for the world generator, like which populators are in use, but also
 * the world seed.
 * 
 * <p>The generation process for chunks is divided into two phases, generation
 * and population. The generation phase is in charge of creating the base
 * terrain shape and generating large terrain features. All operations during
 * the generation phase act upon a BlockBuffer rather than a live chunk
 * object.</p>
 * 
 * <p>Conversely the population phase operates against a live chunk object and
 * has the guarantee that all immediately surrounding chunks have at least
 * passed the generation phase. The population phase is typically used for the
 * placement of small features and objects placed may cross chunk
 * boundaries.</p>
 * 
 * <ol><strong>The generation phase:</strong> <li>Create a BlockBuffer
 * representing the chunk's area</li> <li>Call the
 * {@link #getBaseGeneratorPopulator() base GeneratorPopulator} from the
 * WorldGenerator to create the base terrain shape.</li> <li>Call each of the
 * {@link BiomeType#getGeneratorPopulators() GeneratorPopulators} registered to
 * the BiomeType.</li> <li>Call each of the {@link #getGeneratorPopulators()
 * GeneratorPopulators} registered to the WorldGenerator.</li> <li>Build the
 * final Chunk object from the contents of the BlockBuffer.</li> </ol>
 * 
 * <ol><strong>The population phase:</strong> <li>Validate surrounding
 * chunks.</li> <li>Using the biome at an arbitrary point within the chunk ({16,
 * 0, 16} in the vanilla game), pass the chunk to each of the
 * {@link BiomeType#getPopulators() Populators} registered to the chosen
 * biome.</li> <li>Pass the chunk to each of the {@link #getPopulators()
 * Populators} registered to the WorldGenerator.</li> </ol>
 */
public interface WorldGenerator {

    /**
     * Gets the main {@link GeneratorPopulator}. This generator populator is
     * responsible for generating the base terrain of the chunk.
     *
     * @return The {@link GeneratorPopulator}.
     * @see #setBaseGeneratorPopulator(GeneratorPopulator)
     */
    GeneratorPopulator getBaseGeneratorPopulator();

    /**
     * Sets the {@link GeneratorPopulator}. This generator populator is
     * responsible for generating the base terrain of the chunk.
     *
     * @param generator The generator.
     */
    void setBaseGeneratorPopulator(GeneratorPopulator generator);

    /**
     * Gets a mutable list of {@link GeneratorPopulator}s. These populators work
     * strictly on a single chunk. They will be executed directly after the
     * {@link BiomeType#getGroundCover() biome ground cover layers} and the
     * {@link BiomeType#getGeneratorPopulators() biome generator populators}
     * have been called. These generator populators are typically used to
     * generate large terrain features, like caves and ravines.
     *
     * <p>This list does not include {@link #getBaseGeneratorPopulator() the
     * base generator}.</p>
     *
     * @return The generator populators
     */
    List<GeneratorPopulator> getGeneratorPopulators();

    /**
     * Gets a mutable list of {@link Populator}s which are applied globally (in
     * the whole world).
     *
     * @see BiomeType#getPopulators()
     * @return The populators
     */
    List<Populator> getPopulators();

    /**
     * Gets the {@link BiomeGenerator} for this world generator.
     *
     * @return The biome generator
     */
    BiomeGenerator getBiomeGenerator();

    /**
     * Sets the {@link BiomeGenerator} for this world generator.
     *
     * @param biomeGenerator The new biome generator
     */
    void setBiomeGenerator(BiomeGenerator biomeGenerator);

}
