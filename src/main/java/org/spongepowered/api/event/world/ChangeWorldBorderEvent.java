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
package org.spongepowered.api.event.world;

import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.eventgen.annotations.NoFactoryMethod;
import org.spongepowered.api.world.border.WorldBorder;
import org.spongepowered.api.world.server.ServerWorld;

import java.util.Optional;

/**
 * Fired when the world border changes for a {@code Player} or a {@code World}.
 */
@NoFactoryMethod
public interface ChangeWorldBorderEvent extends Event, Cancellable {

    /**
     * Gets the border that was previously used as an {@link Optional}. There
     * may be no border set for the target (especially if it is a player), in
     * which case, {@link Optional#empty()} is returned.
     *
     * @return The border that was previously in use, if there was one.
     */
    Optional<WorldBorder> previousBorder();

    /**
     * Gets the border that was originally meant to be used as an {@link Optional}.
     * For some targets, the border may be unset and therefore they may not always
     * have a border. It is in these instances that {@link Optional#empty()} is
     * returned.
     *
     * @return The border that will be in use, if there is one.
     */
    Optional<WorldBorder> originalNewBorder();

    /**
     * Gets the border that will be used as an {@link Optional}. For some
     * targets, the border may be unset and therefore they may not always have a
     * border. It is in these instances that {@link Optional#empty()} is
     * returned.
     *
     * @return The border that will be in use, if there is one.
     */
    Optional<WorldBorder> newBorder();

    /**
     * Sets the border that will be used.
     *
     * @param worldBorder The border that will be used.
     */
    void setNewBorder(WorldBorder worldBorder);

    /**
     * Fired when a value on a world's {@link WorldBorder} is changed.
     */
    interface World extends ChangeWorldBorderEvent {

        /**
         * The {@link ServerWorld} that this is associated with.
         *
         * @return The world.
         */
        ServerWorld world();

    }

    /**
     * An event that is fired when a player's world border is changed. This may
     * also be fired when a player's border is set or unset.
     */
    interface Player extends ChangeWorldBorderEvent {

        /**
         * Gets the {@link ServerPlayer player}.
         *
         * @return The player
         */
        ServerPlayer player();

    }

}
