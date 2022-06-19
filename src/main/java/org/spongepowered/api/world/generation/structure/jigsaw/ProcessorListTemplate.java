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

import org.spongepowered.api.ResourceKeyed;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.datapack.DataPack;
import org.spongepowered.api.datapack.DataPackEntry;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.util.ResourceKeyedBuilder;

import java.util.List;

/**
 * A template for {@link ProcessorList}.
 */
public interface ProcessorListTemplate extends DataPackEntry<ProcessorListTemplate> {

    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class).reset();
    }

    ProcessorList processorList();

    interface Builder extends ResourceKeyedBuilder<ProcessorListTemplate, Builder>, CopyableBuilder<ProcessorListTemplate, Builder> {

        Builder from(List<Processor> processorList);

        Builder pack(DataPack<ProcessorListTemplate> pack);

        Builder from(ProcessorList processorList);
    }
}
