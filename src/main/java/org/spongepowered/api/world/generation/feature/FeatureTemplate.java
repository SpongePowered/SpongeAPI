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
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.datapack.DataPack;
import org.spongepowered.api.datapack.DataPackEntry;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.util.ResourceKeyedBuilder;

import java.io.IOException;

/**
 * A template for {@link Feature features}
 */
public interface FeatureTemplate extends DataPackEntry<FeatureTemplate> {

    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class).reset();
    }

    /**
     * Returns the feature.
     *
     * @return The feature
     */
    Feature feature();

    interface Builder extends ResourceKeyedBuilder<FeatureTemplate, Builder>, CopyableBuilder<FeatureTemplate, Builder> {

        /**
         * Initializes the builder with all data from given {@link Feature}.
         *
         * @param feature The feature
         * @return The builder, for chaining
         */
        Builder from(Feature feature);

        /**
         * Sets the given {@link FeatureType}.
         *
         * @param type The feature type
         * @return The builder, for chaining
         */
        Builder type(FeatureType type);

        /**
         * Initializes the builder with all data from given {@link DataView}.
         * <p>{@link FeatureTemplate#toContainer()}</p>
         *
         * @param pack The data pack data
         * @return The builder, for chaining
         */
        Builder fromDataPack(DataView pack) throws IOException;

        /**
         * Sets the data pack.
         *
         * @param pack The data pack
         * @return This builder, for chaining
         */
        Builder pack(DataPack<FeatureTemplate> pack);
    }

}
