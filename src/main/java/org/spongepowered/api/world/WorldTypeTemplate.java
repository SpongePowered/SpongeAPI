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
package org.spongepowered.api.world;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.datapack.DataPackEntry;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.util.ResourceKeyedBuilder;

import java.io.IOException;

/**
 * A template for a {@link WorldType}.
 * <p>Serialized into a data pack at {@code data/<namespace>/dimension_type/<value>.json}</p>
 */
public interface WorldTypeTemplate extends DataPackEntry<WorldTypeTemplate> {

    static WorldTypeTemplate overworld() {
        return Sponge.game().factoryProvider().provide(Factory.class).overworld();
    }

    static WorldTypeTemplate overworldCaves() {
        return Sponge.game().factoryProvider().provide(Factory.class).overworldCaves();
    }

    static WorldTypeTemplate theNether() {
        return Sponge.game().factoryProvider().provide(Factory.class).theNether();
    }

    static WorldTypeTemplate theEnd() {
        return Sponge.game().factoryProvider().provide(Factory.class).theEnd();
    }

    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class).reset();
    }

    /**
     * Returns the world type.
     * TODO usage? probably needs to be turned into a data-pack then - reloaded into registry
     *
     * @return The world type
     */
    WorldType worldType();

    interface Builder extends ResourceKeyedBuilder<WorldTypeTemplate, Builder>, CopyableBuilder<WorldTypeTemplate, Builder> {

        // TODO
        <V> Builder add(Key<? extends Value<V>> key, V value);

        /**
         * Fills the builder with settings from given world type
         * @param type The world type
         *
         * @return This builder, for chaining
         */
        Builder from(WorldType type);

        /**
         * Fills the builder with given data view.
         * <p>The data must be equivalent to a data-pack</p>
         *
         * @param pack The data
         * @return This builder, for chaining
         */
        Builder fromDataPack(DataView pack) throws IOException;
    }

    interface Factory {

        WorldTypeTemplate overworld();

        WorldTypeTemplate overworldCaves();

        WorldTypeTemplate theNether();

        WorldTypeTemplate theEnd();
    }
}
