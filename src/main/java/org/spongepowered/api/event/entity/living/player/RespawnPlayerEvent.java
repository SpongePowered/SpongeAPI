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
package org.spongepowered.api.event.entity.living.player;

import org.spongepowered.api.block.entity.Bed;
import org.spongepowered.api.block.entity.EndPortal;
import org.spongepowered.api.util.Transform;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.world.dimension.DimensionTypes;
import org.spongepowered.api.world.World;

/**
 * Called when a {@link Player} is undergoing a respawn.
 *
 * <p>Examples of respawn triggers include:</p>
 *
 * <ul>
 *     <li>Death</li>
 *     <li>Returning from {@link DimensionTypes#THE_END} via an {@link EndPortal} (Vanilla Minecraft)</li>
 * </ul>
 */
public interface RespawnPlayerEvent extends Event {

    /**
     * The original {@link Player} that this new player is a clone of.
     *
     * <p>When a player dies, or leaves The End, their {@link Player} is re-created.</p>
     *
     * @return The original player
     */
    Player getOriginalPlayer();

    /**
     * Gets the {@link Player}.
     *
     * @return The player
     */
    Player getPlayer();

    /**
     * Gets the previous {@link World} the {@link Player} will respawn at.
     *
     * @return The world
     */
    World getFromWorld();

    /**
     * Gets the previous {@link Transform} the {@link Player} will have at respawn.
     *
     * @return The transform
     */
    Transform getFromTransform();

    /**
     * Gets the {@link World} the {@link Player} will respawn at.
     *
     * @return The world
     */
    World getToWorld();

    /**
     * Gets the {@link Transform} the {@link Player} will have at respawn.
     *
     * @return The transform
     */
    Transform getToTransform();

    /**
     * Sets the {@link World} and {@link Transform} the {@link Player} will have
     * at respawn.
     *
     * @param world The world
     * @param transform The transform
     */
    void setSpawnPosition(World world, Transform transform);

    /**
     * Gets whether the position of spawn was set by a {@link Bed}.
     *
     * @return True if the position of spawn was due to a bed, false otherwise
     */
    boolean isBedSpawn();

    /**
     * Gets if this respawn is due to a {@link Player}'s death.
     *
     * @return {@code true} if player died, {@code false} otherwise
     */
    boolean isDeath();
}
