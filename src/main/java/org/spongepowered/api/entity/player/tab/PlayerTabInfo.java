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
package org.spongepowered.api.entity.player.tab;

import org.spongepowered.api.GameProfile;
import org.spongepowered.api.entity.player.gamemode.GameMode;
import org.spongepowered.api.text.message.Message;

public interface PlayerTabInfo {

    /**
     * <p>Sets the connection time for this player. The client displays
     * connection bars based on this number.</p> <table summary=""> <col
     * width="25%"/> <col width="75%"/> <thead>
     * <tr><th>Bars</th><th>Time</th></tr> </thead> <tbody> <tr><td>0</td><td>
     * Less than 0 </td></tr> <tr><td>1</td><td> 1000+ </td></tr>
     * <tr><td>2</td><td> 600 - 999</td></tr> <tr><td>3</td><td> 300 -
     * 599</td></tr> <tr><td>4</td><td> 150 - 299 </td></tr> <tr><td>5</td><td>
     * 0 - 149 </td></tr> </tbody> </table>
     * 
     * @param milliseconds The new connection time, in milliseconds
     */
    public void setConnectionTime(int milliseconds);

    /**
     * Gets the connection time for this player.
     * 
     * @return The connection time for this player
     */
    public int getConnectionTime();

    /**
     * Sets this player's gamemode. Note that setting this to spectator is what
     * enables spectator (noclip, invisibility).
     * 
     * @param gamemode The new gamemode
     */
    public void setGameMode(GameMode gamemode);

    /**
     * Gets the {@link GameMode} this player is in.
     * 
     * @return The Gamemode this player is in
     */
    public GameMode getGameMode();

    /**
     * Sets this player's display name.
     * 
     * @param displayName The new display name
     */
    public void setDisplayName(Message displayName);

    /**
     * Gets this player's display name.
     * 
     * @return This player's display nam
     */
    public Message getDisplayName();

    /**
     * Sets this player's username.
     * 
     * @param name A new username
     */
    public void setName(String name);

    /**
     * Gets this player's username.
     * 
     * @return This player's username
     */
    public String getName();

    /**
     * Sets the {@link GameProfile} associated with this player.
     * 
     * @param profile The new GameProfile for this player
     */
    public void setProfile(GameProfile profile);

    /**
     * Gets the {@link GameProfile} associated with this player.
     * 
     * @return The GameProfile associated with this player
     */
    public GameProfile getProfile();
}
