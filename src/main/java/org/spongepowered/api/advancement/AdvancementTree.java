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

import com.flowpowered.math.vector.Vector2d;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;

/**
 * An advancement tree.
 */
public interface AdvancementTree extends AdvancementStyle {

    /**
     * Creates a new {@link Builder} to create {@link AdvancementTree}s.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets all the {@link Player}s with access
     * to this {@link AdvancementTree}.
     *
     * @return The players
     */
    List<Player> getPlayers();

    /**
     * Adds a new {@link Player} to track this
     * {@link AdvancementTree}.
     *
     * @param player The player
     */
    void addPlayer(Player player);

    /**
     * Removes the {@link Player}.
     *
     * @param player The player
     */
    void removePlayer(Player player);

    /**
     * Gets the root {@link Advancement} if present.
     *
     * @return The root advancement, if present
     */
    Optional<Advancement> getRootAdvancement();

    /**
     * Gets the background texture of this tree.
     *
     * @return The background texture
     */
    String getBackground();

    /**
     * Adds the {@link Advancement} to this tree at the specified x
     * and y coordinates.
     * <p>
     * Positive and negative values can be used as coordinates. The
     * x and y coordinates origin in in the top left corner.
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param advancement The advancement
     */
    void addAdvancement(double x, double y, Advancement advancement);

    /**
     * Removes the specified {@link Advancement}.
     *
     * @param advancement The advancement
     */
    void removeAdvancement(Advancement advancement);

    /**
     * A builder to create {@link AdvancementTree}s.
     */
    interface Builder extends AdvancementStyle.Builder<AdvancementTree, Builder> {

        /**
         * Sets the root {@link Advancement}.
         * <p>
         * If this isn't specified ({@code null}), then it is required to provide at least a title,
         * with optionally a icon and description.
         *
         * @param rootAdvancement The root advancement
         * @return This builder, for chaining
         */
        Builder rootAdvancement(@Nullable Advancement rootAdvancement);

        /**
         * Sets the position of the root advancement or icon.
         * <p>
         * Defaults to {@link Vector2d#ZERO}.
         *
         * @param position The position
         * @return This builder, for chaining
         */
        Builder rootPosition(Vector2d position);

        /**
         * Sets the background of {@link AdvancementTree}.
         * <p>
         * Defaults to the stone background:
         * {@code minecraft:textures/gui/advancements/backgrounds/stone.png}
         *
         * @param background The background
         * @return This builder, for chaining
         */
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
