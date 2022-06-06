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
package org.spongepowered.api.world.generation.biome;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.datapack.DataPackEntry;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.util.ResourceKeyedBuilder;
import org.spongepowered.api.world.biome.Biome;

import java.io.IOException;

/**
 * A template for {@link org.spongepowered.api.world.biome.Biome}s
 * <p>Serialized into a data pack at {@code data/<namespace>/worldgen/biome/<value>.json}</p>
 */
public interface BiomeTemplate extends DataPackEntry {

    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class).reset();
    }

    // TODO usage? probably needs to be turned into a data-pack then - reloaded into registry
    Biome biome();

    // see Vanilla Biome.BiomeBuilder
    interface Builder extends ResourceKeyedBuilder<BiomeTemplate, Builder>, CopyableBuilder<BiomeTemplate, Builder> {

        // TODO
        <V> Builder add(Key<? extends Value<V>> key, V value);

        // TODO
        Builder from(Biome biome);

        // TODO Biome.CODEC
        Builder fromDataPack(DataView pack) throws IOException;
    }

}
