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
import org.spongepowered.api.datapack.DataPackEntry;
import org.spongepowered.api.util.DataPackEntryBuilder;

/**
 * A template for {@link StructureSet structure sets}
 */
public interface StructureSetTemplate extends DataPackEntry<StructureSetTemplate> {

    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class).reset();
    }

    /**
     * Returns the structure set.
     *
     * @return The structure set
     */
    StructureSet structureSet();

    interface Builder extends DataPackEntryBuilder<StructureSet, StructureSetTemplate, Builder> {

        /**
         * Sets the structure placement.
         *
         * @param placement The placement
         * @return This builder, for chaining
         */
        Builder placement(StructurePlacement placement);

        /**
         * Adds a structure with given weight.
         *
         * @param structure The structure
         * @param weight The weight
         * @return This builder, for chaining
         */
        Builder add(Structure structure, int weight);
    }
}
