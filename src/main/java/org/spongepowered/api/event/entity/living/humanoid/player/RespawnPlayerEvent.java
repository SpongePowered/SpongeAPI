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
package org.spongepowered.api.event.entity.living.humanoid.player;

import org.spongepowered.api.entity.Transform;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.world.World;

/**
 * Called when a {@link Player} is cloned during a respawn.
 *
 * <p>Either caused by death, or by traveling from the End.</p>
 */
public interface RespawnPlayerEvent extends TargetPlayerEvent {

    /**
     * The original {@link Player} that this new player is a clone of.
     *
     * <p>When a player dies, or leaves The End, their {@link Player} is re-created.</p>
     *
     * @return The original player
     */
    Player getOriginalPlayer();

    /**
     * Gets a copy of the transform that the entity came from.
     *
     * @return the previous transform
     */
    Transform<World> getFromTransform();

    /**
     * Gets the new transform that the {@link Player} will change to.
     *
     * @return the new transform
     */
    Transform<World> getToTransform();

    /**
     * Sets the new transform that the entity will change to.
     *
     * @param respawnTransform The new transform
     */
    void setToTransform(Transform<World> respawnTransform);

    /**
     * Gets whether the transform was set by a bed or not.
     *
     * @return Whether the transform was set by a bed
     */
    boolean isBedSpawn();

    /**
     * Gets whether this event was fired because the {@link Player} died.
     *
     * @return {@code true} if player died, {@code false} if the player switched
     *      dimensions
     */
    boolean isDeath();
}
