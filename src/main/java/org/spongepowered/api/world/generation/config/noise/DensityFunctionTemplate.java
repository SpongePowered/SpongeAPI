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
package org.spongepowered.api.world.generation.config.noise;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.datapack.DataPack;
import org.spongepowered.api.datapack.DataPackEntry;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.util.ResourceKeyedBuilder;

import java.io.IOException;

/**
 * A template for {@link DensityFunction density functions}
 */
public interface DensityFunctionTemplate extends DataPackEntry<DensityFunctionTemplate> {

    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class).reset();
    }

    DensityFunction densityFunction();

    interface Builder extends ResourceKeyedBuilder<DensityFunctionTemplate, Builder>, CopyableBuilder<DensityFunctionTemplate, Builder> {

        // TODO advanced

        /**
         * Sets the density function.
         * @param densityFunction The density function
         * @return This builder, for chaining
         */
        Builder from(DensityFunction densityFunction);

        /**
         * Initializes the builder with the data from given {@link DataView}.
         * {@link DensityFunctionTemplate#toContainer()}
         *
         * @param datapack The data pack data
         * @return This builder, for chaining
         */
        Builder fromDataPack(DataView datapack) throws IOException;

        /**
         * Sets the data pack
         * @param pack The data pack
         * @return This builder, for chaining
         */
        Builder pack(DataPack<DensityFunctionTemplate> pack);
    }

}
