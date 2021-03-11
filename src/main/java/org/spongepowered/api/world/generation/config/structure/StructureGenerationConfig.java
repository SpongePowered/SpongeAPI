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
package org.spongepowered.api.world.generation.config.structure;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.world.generation.structure.Structure;

import java.util.Map;
import java.util.Optional;

public interface StructureGenerationConfig {

    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class).reset();
    }

    Optional<SpacedStructureConfig> stronghold();

    Optional<SeparatedStructureConfig> structure(Structure structure);

    Map<Structure, SeparatedStructureConfig> structures();

    interface Builder extends org.spongepowered.api.util.Builder<StructureGenerationConfig, Builder>, CopyableBuilder<StructureGenerationConfig, Builder> {

        Builder stronghold(@Nullable SpacedStructureConfig config);

        Builder addStructure(Structure structure, SeparatedStructureConfig config);

        Builder addStructures(Map<Structure, SeparatedStructureConfig> structures);

        Builder removeStructure(Structure structure);
    }
}
