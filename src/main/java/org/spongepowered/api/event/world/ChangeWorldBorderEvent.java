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
import org.spongepowered.api.util.annotation.eventgen.GenerateFactoryMethod;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.WorldBorder;
import org.spongepowered.api.world.server.ServerWorld;

import java.util.Optional;

/**
 * Fired when the world border changes for a {@code Player} or a {@code World}.
 */
@GenerateFactoryMethod
public interface ChangeWorldBorderEvent extends Event, Cancellable {
    /**
     * Gets the border that was previously used as an {@link Optional}. There 
     * may be no border set for the target (especially, if it is a player), in 
     * which case, an empty {@code Optional} is returned.
     *
     * @return The border that was previously in use, if there was one.
     */
    Optional<WorldBorder> getPreviousBorder();

    /**
     * Gets the border that will be used as an {@link Optional}. For some
     * targets, the border may be unset and therefore they may not always have a
     * border. It is in these instances that an empty {@code Optional} is
     * returned.
     *
     * @return The border that will be in use, if there is one.
     */
    Optional<WorldBorder> getNewBorder();

    /**
     * An event that is fired when a world's border is changed.
     */
    interface TargetWorld extends ChangeWorldBorderEvent {

        /**
         * Gets the {@link World}.
         *
         * @return The world
         */
        ServerWorld getWorld();

    }

    /**
     * An event that is fired when a player's world border is changed. This may
     * also be fired when a player's border is set or unset.
     */
    interface TargetPlayer extends ChangeWorldBorderEvent {

        /**
         * Gets the {@link ServerPlayer player}.
         *
         * @return The player
         */
        ServerPlayer getPlayer();
    }

}
