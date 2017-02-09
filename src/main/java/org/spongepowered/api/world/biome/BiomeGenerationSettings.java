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
package org.spongepowered.api.world.biome;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.world.gen.GenerationPopulator;
import org.spongepowered.api.world.gen.Populator;

import java.util.List;

/**
 * A representation of the biome-specific generation settings.
 */
public interface BiomeGenerationSettings {

    /**
     * Gets a new builder for creating new BiomeGenerationSettings.
     * 
     * @return The builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the minimum terrain height of this biome.
     * 
     * @return The min height
     */
    float getMinHeight();

    /**
     * Sets the minimum terrain height of this biome.
     * 
     * @param height The new min height
     */
    void setMinHeight(float height);

    /**
     * Gets the maximum terrain height of this biome.
     * 
     * @return The max height
     */
    float getMaxHeight();

    /**
     * Sets the maximum terrain height of this biome.
     * 
     * @param height The new max height
     */
    void setMaxHeight(float height);

    /**
     * Gets a mutable ordered list of {@link GroundCoverLayer}s. These layers
     * will be applied to the base terrain during the generation phase starting
     * at the topmost stone block in each column.
     * 
     * @return The ground cover layers
     */
    List<GroundCoverLayer> getGroundCoverLayers();

    /**
     * Gets a mutable list of {@link GenerationPopulator}s. These populators
     * work strictly on a single chunk. They will be executed directly after the
     * {@link #getGroundCoverLayers() ground cover layers} are applied. These
     * generation populators are typically used to generate large terrain
     * features, like caves and ravines.
     * 
     * @return The generation populators
     */
    List<GenerationPopulator> getGenerationPopulators();

    /**
     * Gets an immutable list of {@link GenerationPopulator}s matching the given
     * class type.
     * 
     * @param type the generation populator type to return
     * @return The generation populators
     */
    List<GenerationPopulator> getGenerationPopulators(Class<? extends GenerationPopulator> type);

    /**
     * Returns a mutable list of {@link Populator}s specific to this biome.
     * Changing this list will affect population of all new chunks.
     * 
     * @return The populators
     */
    List<Populator> getPopulators();

    /**
     * Returns an immutable list of {@link Populator}s specific to this biome
     * which match the given class type.
     * 
     * @param type the populator type to return
     * @param <T> The populator type
     * @return The populators
     */
    <T extends Populator> List<T> getPopulators(Class<T> type);

    /**
     * Returns a new biome generation settings which is a copy of this set of
     * generation settings at this point in time.
     * 
     * @return The copy of these settings
     */
    BiomeGenerationSettings copy();

    /**
     * A builder for {@link BiomeGenerationSettings}s.
     */
    interface Builder extends ResettableBuilder<BiomeGenerationSettings, Builder> {

        /**
         * Sets the min height for the biome.
         * 
         * @param height The min height
         * @return This builder, for chaining
         */
        Builder minHeight(float height);

        /**
         * Sets the max height for the biome.
         * 
         * @param height The max height
         * @return This builder, for chaining
         */
        Builder maxHeight(float height);

        /**
         * Sets the ground cover layers.
         * 
         * @param coverLayers The ground cover layers
         * @return This builder, for chaining
         */
        Builder groundCover(GroundCoverLayer... coverLayers);

        /**
         * Sets the ground cover layers.
         * 
         * @param coverLayers The ground cover layers
         * @return This builder, for chaining
         */
        Builder groundCover(Iterable<GroundCoverLayer> coverLayers);

        /**
         * Sets the generation populators.
         * 
         * @param genpop The generation populators
         * @return This builder, for chaining
         */
        Builder generationPopulators(GenerationPopulator... genpop);

        /**
         * Sets the generation populators.
         * 
         * @param genpop The generation populators
         * @return This builder, for chaining
         */
        Builder generationPopulators(Iterable<GenerationPopulator> genpop);

        /**
         * Sets the populators.
         * 
         * @param populators The populators
         * @return This builder, for chaining
         */
        Builder populators(Populator... populators);

        /**
         * Sets the populators.
         * 
         * @param populators The populators
         * @return This builder, for chaining
         */
        Builder populators(Iterable<Populator> populators);

        /**
         * Creates a new set of {@link BiomeGenerationSettings}s.
         * 
         * @return The settings
         * @throws IllegalStateException If any required values were left unset
         */
        BiomeGenerationSettings build() throws IllegalStateException;

    }

}
