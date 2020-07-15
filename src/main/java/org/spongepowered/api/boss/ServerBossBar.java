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
package org.spongepowered.api.boss;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableSet;
import org.spongepowered.api.Server;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.CopyableBuilder;

import java.util.Collection;
import java.util.function.Supplier;

/**
 * Represents a boss bar controlled by a {@link Server}.
 */
public interface ServerBossBar extends BossBar {

    /**
     * Creates a new {@link Builder} to create {@link ServerBossBar boss bars}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    @Override
    ServerBossBar setName(Text name);

    @Override
    ServerBossBar setPercent(float percent);

    @Override
    default ServerBossBar setColor(Supplier<? extends BossBarColor> color) {
        return this.setColor(color.get());
    }

    @Override
    ServerBossBar setColor(BossBarColor color);

    @Override
    default ServerBossBar setOverlay(Supplier<? extends BossBarOverlay> overlay) {
        return this.setOverlay(overlay.get());
    }

    @Override
    ServerBossBar setOverlay(BossBarOverlay overlay);

    @Override
    ServerBossBar setDarkenSky(boolean darkenSky);

    @Override
    ServerBossBar setPlayEndBossMusic(boolean playEndBossMusic);

    @Override
    ServerBossBar setCreateFog(boolean createFog);

    /**
     * If this boss bar is visible.
     *
     * @return If this boss bar is visible
     */
    boolean isVisible();

    /**
     * Sets if this boss bar is visible.
     *
     * @param visible If this boss bar is visible
     * @return This boss bar
     */
    ServerBossBar setVisible(boolean visible);

    /**
     * Gets a collection of all {@link ServerPlayer players} on this boss bar.
     *
     * @return A collection of all players on this boss bar
     */
    Collection<ServerPlayer> getPlayers();

    /**
     * Adds a {@link ServerPlayer player} to this boss bar.
     *
     * @param player The player to add
     * @return This boss bar
     */
    ServerBossBar addPlayer(ServerPlayer player);

    /**
     * Adds a collection of players to this boss bar.
     *
     * @param players The players to add
     * @return This boss bar
     */
    default ServerBossBar addPlayers(Collection<ServerPlayer> players) {
        checkNotNull(players, "players");
        ImmutableSet.copyOf(players).forEach(this::addPlayer);
        return this;
    }

    /**
     * Removes a {@link ServerPlayer player} from this boss bar.
     *
     * @param player The player to remove
     * @return This boss bar
     */
    ServerBossBar removePlayer(ServerPlayer player);

    /**
     * Removes a collection of {@link ServerPlayer players} from this boss bar.
     *
     * @param players The players to remove
     * @return This boss bar
     */
    default ServerBossBar removePlayers(Collection<ServerPlayer> players) {
        checkNotNull(players, "players");
        ImmutableSet.copyOf(players).forEach(this::removePlayer);
        return this;
    }

    /**
     * Represents a builder class to create mutable {@link ServerBossBar}s.
     *
     * @see BossBar
     * @see ServerBossBar
     */
    interface Builder extends CopyableBuilder<ServerBossBar, Builder> {

        /**
         * Sets the name of the boss bar.
         *
         * @param name The boss bar name
         * @return This builder
         */
        Builder name(Text name);

        /**
         * Sets the percent.
         *
         * <p>The percent must be between {@code 0.0} and {@code 1.0}.</p>
         *
         * @param percent The percent
         * @return This builder
         */
        Builder percent(float percent);

        /**
         * Sets the color.
         *
         * @param color The color
         * @return This builder
         */
        default Builder color(Supplier<? extends BossBarColor> color) {
            return this.color(color.get());
        }

        /**
         * Sets the color.
         *
         * @param color The color
         * @return This builder
         */
        Builder color(BossBarColor color);

        /**
         * Sets the overlay.
         *
         * @param overlay The overlay
         * @return This builder
         */
        default Builder overlay(Supplier<? extends BossBarOverlay> overlay) {
            return this.overlay(overlay.get());
        }

        /**
         * Sets the overlay.
         *
         * @param overlay The overlay
         * @return This builder
         */
        Builder overlay(BossBarOverlay overlay);

        /**
         * Sets if the sky should darken.
         *
         * @param darkenSky If the sky should darken
         * @return This builder
         */
        Builder darkenSky(boolean darkenSky);

        /**
         * Sets if the end boss music should be played.
         *
         * @param playEndBossMusic If the end boss music should be played
         * @return This builder
         */
        Builder playEndBossMusic(boolean playEndBossMusic);

        /**
         * Sets if fog should be created.
         *
         * @param createFog If fog should be created
         * @return This builder
         */
        Builder createFog(boolean createFog);

        /**
         * Sets if the boss bar is visible.
         *
         * @param visible If this boss bar is visible
         * @return This builder
         */
        Builder visible(boolean visible);

        /**
         * Build the boss bar from the values in this builder.
         *
         * @return The boss bar
         */
        ServerBossBar build();

    }

}
