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
package org.spongepowered.api.world.server;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.world.generation.config.WorldGenerationConfig;

import java.util.Optional;

public interface WorldArchetype {

    static WorldArchetype.Builder builder() {
        return Sponge.game().builderProvider().provide(WorldArchetype.Builder.class);
    }

    static WorldArchetype of(WorldArchetypeType type) {
        return WorldArchetype.builder().type(type).build();
    }

    static WorldArchetype of(WorldArchetypeType type, WorldGenerationConfig generationConfig) {
        return WorldArchetype.builder().type(type).generationConfig(generationConfig).build();
    }

    WorldArchetypeType type();

    Optional<WorldGenerationConfig> generationConfig();

    interface Builder extends org.spongepowered.api.util.Builder<WorldArchetype, Builder>, CopyableBuilder<WorldArchetype, Builder> {

        Builder type(WorldArchetypeType type);

        Builder generationConfig(WorldGenerationConfig generationConfig);
    }
}
