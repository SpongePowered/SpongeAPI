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
package org.spongepowered.api.advancement;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.util.ResettableBuilder;

/**
 * Represents a {@link Advancement} tree or tab menu. The tree will become visible to
 * a {@link Player} once the root {@link Advancement} gets achieved.
 */
public interface AdvancementTree extends CatalogType {

    /**
     * Creates a new {@link Builder} to create {@link AdvancementTree}s.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the root {@link Advancement}.
     *
     * @return The root advancement
     */
    Advancement getRootAdvancement();

    /**
     * Gets the background texture of this tree.
     *
     * @return The background texture
     */
    // TODO: Use ResourcePath, or something similar?
    String getBackground();

    /**
     * A builder to create {@link AdvancementTree}s.
     */
    interface Builder extends ResettableBuilder<AdvancementTree, Builder> {

        /**
         * Sets the root {@link Advancement}. The root advancement MUST have
         * {@link DisplayInfo} present.
         *
         * @param rootAdvancement The root advancement
         * @return This builder, for chaining
         * @throws IllegalArgumentException If the display info is missing
         */
        Builder rootAdvancement(Advancement rootAdvancement);

        /**
         * Sets the background of {@link AdvancementTree}.
         * <p>
         * Defaults to the stone background:
         * {@code minecraft:textures/gui/advancements/backgrounds/stone.png}
         *
         * @param background The background
         * @return This builder, for chaining
         */
        // TODO: Use ResourcePath, or something similar?
        Builder background(String background);

        /**
         * Builds the {@link AdvancementTree} with the specified
         * plugin id and id.
         *
         * @param pluginId The plugin id
         * @param id The id
         * @return The advancement tree
         */
        AdvancementTree build(String pluginId, String id);
    }
}
