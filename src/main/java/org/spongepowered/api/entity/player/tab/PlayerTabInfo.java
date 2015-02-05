package org.spongepowered.api.entity.player.tab;

import org.spongepowered.api.GameProfile;
import org.spongepowered.api.entity.player.gamemode.GameMode;
import org.spongepowered.api.text.message.Message;

public interface PlayerTabInfo {

    /**
     * Sets the connection time for this player.
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