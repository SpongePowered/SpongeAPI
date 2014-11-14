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

public class TeleportEvent {
	
	/**
	 * When a player teleports, this should be called.
	 */
	public TeleportEvent() {
		
	}
	
	/**
	 * The player was teleported by an execute of a command.
	 */
	public static final TeleportEvent COMMAND = new TeleportEvent();
	
	/**
	 * The player was teleported by entering an end portal.
	 */
	public static final TeleportEvent END_PORTAL = new TeleportEvent();
	
	/**
	 * The player was teleported by the launching of an ender pearl.
	 */
	public static final TeleportEvent ENDER_PEARL = new TeleportEvent();
	
	/**
	 * The player was teleported by entering a nether portal.
	 */
	public static final TeleportEvent NETHER_PORTAL = new TeleportEvent();
	
	/**
	 * The player was teleported by an external plugin.
	 */
	public static final TeleportEvent PLUGIN = new TeleportEvent();
	
}
