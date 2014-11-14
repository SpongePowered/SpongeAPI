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

public interface TeleportEvent {
	
	/**
	 * Gets the reason for teleportation.
	 * 
	 * @return The reason for teleportation
	 */
	TeleportReason getReason();
	
	/**
	 * The possible reasons for a player being teleported.
	 */
	public enum TeleportReason {
		
		/**
		 * The player was teleported by an execute of a command.
		 */
		COMMAND,
		
		/**
		 * The player was teleported by entering an end portal.
		 */
		END_PORTAL,
		
		/**
		 * The player was teleported by the launching of an ender pearl.
		 */
		ENDER_PEARL,
		
		/**
		 * The player was teleported by entering a nether portal.
		 */
		NETHER_PORTAL,
		
		/**
		 * The player was teleported by an external plugin.
		 */
		PLUGIN
	}
}
