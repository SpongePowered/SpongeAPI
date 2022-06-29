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
package org.spongepowered.api.world.generation.structure;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.tag.Tag;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.world.biome.Biome;
import org.spongepowered.math.vector.Vector3i;

/**
 * Used to modify the placement of {@link StructureSet structure sets}.
 */
public interface StructurePlacement {

    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class).reset();
    }

    /**
     * Returns the locate offset. Used for the {@code /locate} command.
     *
     * @return The locate offset.
     */
    Vector3i offset();

    interface Builder extends ResettableBuilder<StructurePlacement, Builder> {

        /**
         * Starts building a random spread structure placement.
         * <p>This type of placement is used for most vanilla {@link StructureSets}</p>
         *
         * @param locateOffset The locate offset
         * @param salt The salt to assist randomization
         * @return This builder, for chaining
         */
        RandomSpread randomSpread(Vector3i locateOffset, final int salt);

        /**
         * Starts building a random spread structure placement.
         * <p>This type of placement is used for most vanilla {@link StructureSets}</p>
         *
         * @param salt The salt to assist randomization
         * @return This builder, for chaining
         */
        RandomSpread randomSpread(final int salt);

        /**
         * Starts building a concentric rings structure placement.
         * <p>This type of placement is used for placing vanilla {@link StructureSets#STRONGHOLDS}</p>
         *
         * @param locateOffset The locate offset
         * @param salt The salt to assist randomization
         * @return This builder, for chaining
         */
        ConcentricRings concentricRings(Vector3i locateOffset, final int salt);

        /**
         * Starts building a concentric rings structure placement.
         *
         * @return This builder, for chaining
         */
        ConcentricRings concentricRings();

        /**
         * Returns the built structure placement.
         *
         * @return The built structure placement
         */
        StructurePlacement build();

        interface RandomSpread extends Builder {

            /**
             * Sets the type of random spread.
             *
             * @return This builder, for chaining
             */
            RandomSpread linear();

            /**
             * Sets the type of random spread.
             *
             * @return This builder, for chaining
             */
            RandomSpread triangular();

            /**
             * Sets the spacing.
             *
             * @param spacing The spacing in chunks
             * @return This builder, for chaining
             */
            RandomSpread spacing(int spacing);

            /**
             * The minimum separation distance.
             * <p>Must be less than spacing</p>
             * @param separation The minimum separation distance in chunks
             * @return This builder, for chaining
             */
            RandomSpread separation(int separation);

        }

        interface ConcentricRings extends Builder {

            /**
             * Sets the distance between structures
             *
             * @param distance The distance
             * @return This builder, for chaining
             */
            ConcentricRings distance(int distance);

            /**
             * Sets the structure count in the first ring
             *
             * @param spread The spread
             * @return This builder, for chaining
             */
            ConcentricRings spread(int spread);

            /**
             * Sets the amount of structures to generate

             * @param count The count
             * @return This builder, for chaining
             */
            ConcentricRings count(int count);

            /**
             * Sets the preferred biomes.
             *
             * @param preferredBiomes the preferred biomes tag.
             * @return This builder, for chaining
             */
            ConcentricRings preferredBiomes(Tag<Biome> preferredBiomes);

        }

    }
}
