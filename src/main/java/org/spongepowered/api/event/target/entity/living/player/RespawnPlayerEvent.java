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
package org.spongepowered.api.event.target.entity.living.player;

import org.spongepowered.api.entity.Transform;
import org.spongepowered.api.world.World;

/**
 * Called when a player respawns.
 */
public interface RespawnPlayerEvent extends TargetPlayerEvent {

    /**
     * Gets a copy of the new respawn transform of the player.
     *
     * @return The new respawn location of the player
     */
    Transform<World> getOriginTransform();

    Transform<World> getTransform();

    /**
     * Gets whether the original respawn transform was set by a bed or not.
     *
     * @return Whether the original respawn transform was set by a bed
     */
    boolean isBedSpawn();

    /**
     * Sets the new player respawn transform permanently.
     *
     * @param respawnTransform The new respawn transform
     */
    void setNewRespawnTransform(Transform<World> respawnTransform);

}
