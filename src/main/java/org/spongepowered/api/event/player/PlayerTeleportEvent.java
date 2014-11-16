/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.event.player;

import org.spongepowered.api.entity.Player;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.entity.EntityTeleportEvent;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

/**
 * Called when a {@link Player} is teleported.
 */
public interface PlayerTeleportEvent extends PlayerEvent, EntityTeleportEvent, Cancellable {
	
	/**
	 * Gets the cause of a {@link Player} teleportation.
	 * 
	 * @return The cause for teleportation
	 */
	PlayerTeleportCause getCause();
	
	/**
	 * Teleports the player to the designated location in a designated world.
	 * 
	 * @param player The {@link Player} being teleporting
	 * @param currentWorld The current {@link World}
	 * @param targetWorld The target {@link World}
	 * @param current The current {@link Location}
	 * @param target The target {@link Location}
	 */
	void teleportPlayer(Player player, World currentWorld, World targetWorld, Location current, Location target);

}
