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
package org.spongepowered.api.world.generation.feature;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.datapack.DataPackEntry;
import org.spongepowered.api.util.DataPackEntryBuilder;

/**
 * A template for {@link PlacedFeature placed features}
 */
public interface PlacedFeatureTemplate extends DataPackEntry<PlacedFeatureTemplate> {

    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class).reset();
    }

    /**
     * Returns the placed feature.
     *
     * @return The placed feature
     */
    PlacedFeature feature();

    interface Builder extends DataPackEntryBuilder<PlacedFeature, PlacedFeatureTemplate, Builder> {

        /**
         * Sets the {@link Feature}.
         *
         * @param feature The feature
         * @return The builder, for chaining
         */
        Builder feature(Feature feature);

        /**
         * Initializes the builder with all data from given {@link FeatureTemplate}.
         *
         * @param feature The feature template
         * @return The builder, for chaining
         */
        Builder feature(FeatureTemplate feature);

        /**
         * Adds a {@link PlacementModifier placement modifier}.
         *
         * @param modifier The placement modifier
         * @return The builder, for chaining
         */
        Builder addModifier(PlacementModifier modifier);

    }

}
