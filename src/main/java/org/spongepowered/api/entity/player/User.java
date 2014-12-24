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

package org.spongepowered.api.entity.player;

import com.google.common.base.Optional;
import org.spongepowered.api.entity.ArmorEquipable;
import org.spongepowered.api.util.Identifiable;

import java.util.Date;

/**
 * A User is the data usually associated with a Player that is persisted across server restarts.
 * This is in contrast to Player which represents the ingame entity associated with an online User.
 */
public interface User extends Identifiable, ArmorEquipable {

    /**
     * Gets the player's last known username.
     * 
     * @return The player's last known username
     */
    String getName();

    /**
     * Checks if this player has joined the server before.
     * 
     * @return True If player has joined before
     */
    boolean hasJoinedBefore();

    /**
     * Gets the first time a player joined the server.
     *
     * <p>
     *     This time is based off epoch timestamps.
     * </p>
     *
     * @return The players first join time.
     */
    Date getFirstPlayed();

    /**
     * Gets the last time a player was on the server.
     *
     * <p>
     *     This time is based off epoch timestamps.
     * </p>
     *
     * @return The last time a player was online.
     */
    Date getLastPlayed();

    /**
     * Checks if this player is banned.
     * 
     * @return True If banned
     */
    boolean isBanned();
	
	/**
     * Checks if this subject is server operator (of any level) or not.
     * 
     * @return True if corresponding subject is server operator
     */
    boolean isOp();
    
	/**
	 * Sets this User's OP permission level to OP permission level specified in server properties file (default is 4).
	 * 
	 * @param value Whether this User should be OP
	 */
	void setOp(boolean value);
	
    /**
     * <p>
     * Returns OP permission level of this subject.
     * </p>
     * 
     * <p>
     * According to minecraft wiki, these permission levels are available:
     * <ul>
     * <li>1 - Ops can bypass spawn protection.</li>
     * <li>2 - Ops can use /clear, /difficulty, /effect, /gamemode, /gamerule, /give, and /tp, and can edit command 
     * blocks.</li>
     * <li>3 - Ops can use /ban, /deop, /kick, and /op.</li>
     * <li>4 - Ops can use /stop.</li>
     * </ul>
     * </p>
     * 
     * @return Permission level (1-4) if this player is OP, 0 is returned when player is not OP
     */
    int getOpPermissionLevel();
    
    /**
     * <p>
     * Sets new OP permission level. Use level of zero, if you want to remove OP from player.
     * </p>
     * 
     * <p>
     * These permission levels are available:
     * <ul>
     * <li>1 - Ops can bypass spawn protection.</li>
     * <li>2 - Ops can use /clear, /difficulty, /effect, /gamemode, /gamerule, /give, and /tp, and can edit command 
     * blocks.</li>
     * <li>3 - Ops can use /ban, /deop, /kick, and /op.</li>
     * <li>4 - Ops can use /stop.</li>
     * </ul>
     * </p>
     * 
     * @param level Permission level (1-4), zero if subject should be de-opped.
     */
    void setOpPermissionLevel(int level);

    /**
     * Checks if this player is whitelisted.
     * 
     * @return True If whitelisted
     */
    boolean isWhitelisted();

    /**
     * Checks if this player is online or not.
     *
     * @return True if the corresponding player is online
     */
    boolean isOnline();

    /**
     * Gets the related online {@link Player} if the player is
     * in fact online.
     *
     * @return The associated online Player, if available
     */
    Optional<Player> getPlayer();
}
