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
package org.spongepowered.api.world.generation.structure.jigsaw;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.datapack.DataPackEntry;
import org.spongepowered.api.registry.RegistryReference;
import org.spongepowered.api.util.DataPackEntryBuilder;

/**
 * A template for {@link JigsawPool jigsaw pools}
 */
public interface JigsawPoolTemplate extends DataPackEntry<JigsawPoolTemplate> {

    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class).reset();
    }

    /**
     * Returns the jigsaw pool.
     *
     * @return The jigsaw pool
     */
    JigsawPool jigsawPool();

    interface Builder extends DataPackEntryBuilder<JigsawPool, JigsawPoolTemplate, Builder> {

        /**
         * Adds a jigsaw element with given weight.
         *
         * @param element The element
         * @param weight The weight
         * @return This builder, for chaining
         */
        Builder add(JigsawPoolElement element, int weight);

        /**
         * Sets the name of the jigsaw pool.
         *
         * @param name The name
         * @return This builder, for chaining
         */
        Builder name(ResourceKey name);

        /**
         * Sets the fallback for the jigsaw pool.
         *
         * @param fallback The fallback jigsaw pool
         * @return This builder, for chaining
         */
        Builder fallback(RegistryReference<JigsawPool> fallback);

        /**
         * Sets the fallback for the jigsaw pool.
         *
         * @param fallback the fallback jigsaw pool
         * @return This builder, for chaining
         */
        Builder fallback(JigsawPoolTemplate fallback);
    }
}
