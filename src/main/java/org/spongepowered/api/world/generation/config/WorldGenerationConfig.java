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
package org.spongepowered.api.world.generation.config;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.world.server.ServerWorld;

/**
 * Represents settings that apply to the generation of a {@link ServerWorld world}.
 */
public interface WorldGenerationConfig {

    /**
     * Gets the seed
     *
     * @return The seed
     */
    long seed();

    /**
     * Gets if features will generate
     *
     * @return Whether features will generate
     */
    boolean generateFeatures();

    /**
     * Gets if the bonus chest will generate
     *
     * @return Whether bonus chest will generate
     */
    boolean generateBonusChest();

    interface Mutable extends WorldGenerationConfig {

        static Builder builder() {
            return Sponge.getGame().getBuilderProvider().provide(Builder.class).reset();
        }

        /**
         * Sets the seed
         *
         * @param seed The seed
         */
        void setSeed(long seed);

        /**
         * Sets whether features will generate
         *
         * @param generateFeatures Whether features will generate
         */
        void setGenerateFeatures(boolean generateFeatures);

        /**
         * Sets if the bonus chest will generate.
         *
         * <p>It is up to the implementation on how this setting is handled. For Vanilla Minecraft, this setting has no effect
         * if first-time generation has already occurred.</p>
         *
         * @param generateBonusChest Whether bonus chest will generate
         */
        void setGenerateBonusChest(boolean generateBonusChest);

        interface Builder extends org.spongepowered.api.util.Builder<WorldGenerationConfig.Mutable, Builder>, CopyableBuilder<WorldGenerationConfig, Builder> {

            Builder seed(long seed);

            Builder generateFeatures(boolean generateFeatures);

            Builder generateBonusChest(boolean generateBonusChest);

            WorldGenerationConfig.Mutable build();
        }
    }
}
