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

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.GameRegistry;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.ResettableBuilder;
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
     * use {@link GameRegistry#getType(Class, String)}.
     *
     * @param id ID of the sound
     * @return A new SoundType object
     */
    static SoundType of(String id) {
        return builder().build(id);
    }

    /**
     * Builds a SoundType, primarily for sending custom sounds to the client.
     */
    interface Builder extends ResettableBuilder<SoundType, Builder> {

        /**
         * Builds a new instance of a {@link SoundType}.
         *
         * <p>Note: If no domain (indicated by the string before ':') is present
         * in the id, the default "minecraft" domain will be used.</p>
         *
         * @param id ID of the sound
         * @return A new instance of the sound type
         */
        SoundType build(String id);

    }
}
