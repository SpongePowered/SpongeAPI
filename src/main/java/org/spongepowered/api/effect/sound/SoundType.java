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
package org.spongepowered.api.effect.sound;

import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.GameRegistry;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.CauseStackManager;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.util.CatalogBuilder;
import org.spongepowered.api.util.annotation.CatalogedBy;

/**
 * Represents a sound that can be heard on clients.
 */
@CatalogedBy(SoundTypes.class)
public interface SoundType extends CatalogType {

    /**
     * Creates a new {@link Builder} for building SoundTypes.
     *
     * @return A new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Creates a <i>new</i>SoundType from the given ID. To fetch existing types,
     * use {@link GameRegistry#getType(Class, CatalogKey)}.
     *
     * <p>A {@link CatalogKey} is used where the provided id is the value and the namespace
     * is the id of the {@link PluginContainer} that is currently in the {@link CauseStackManager}.</p>
     *
     * @param id The id of the sound
     * @return A new sound type
     */
    static SoundType of(String id) {
        return builder().id(id).build();
    }

    /**
     * Creates a <i>new</i>SoundType from the given {@link CatalogKey}. To fetch existing types,
     * use {@link GameRegistry#getType(Class, CatalogKey)}.
     *
     * @param key The key of the sound
     * @return A new sound type
     */
    static SoundType of(CatalogKey key) {
        return builder().key(key).build();
    }

    /**
     * Builds a SoundType, primarily for sending custom sounds to the client.
     */
    interface Builder extends CatalogBuilder<SoundType, Builder> {
    }
}
