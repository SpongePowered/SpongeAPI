package org.spongepowered.api.entity.player.tab;

import org.spongepowered.api.text.message.Message;

import com.google.common.base.Optional;

import java.util.List;
import java.util.UUID;

public interface TabList {

    /**
     * Sets this list's header.
     * 
     * @param header The new header
     */
    public void setHeader(Message header);

    /**
     * Gets this list's header.
     * 
     * @return The current header
     */
    public Message getHeader();

    /**
     * Sets this list's footer.
     * 
     * @param footer The new footer
     */
    public void setFooter(Message footer);

    /**
     * Gets this list's footer.
     * 
     * @return The current footer
     */
    public Message getFooter();

    /**
     * Gets the players on the list.
     * 
     * @return The players on the list
     */
    public List<PlayerTabInfo> getPlayers();

    /**
     * Adds a player to the list.
     * 
     * @throws IllegalArgumentException when it attempts to add a player already
     *         on the list. This is to prevent modification of a
     *         {@link PlayerTabInfo} by overwriting it
     * 
     * @param player The player to add
     */
    public void addPlayer(PlayerTabInfo player) throws IllegalArgumentException;

    /**
     * <p>Removes a player from the list. This should only be used to completely
     * remove a player, not add it back later. Note that if this is used on a
     * player, but they remain visible in-game, their skin will not work.</p>
     * 
     * @param playerId the UUID of the player to remove
     * @return The {@link PlayerTabInfo} that was associated with the UUID
     */
    public PlayerTabInfo removePlayer(UUID playerId);

    /**
     * <p>Finds a {@link PlayerTabInfo} matching the specified UUID. If none
     * were found, it returns Optional.absent().</p>
     * 
     * @param uuid The UUID to search for
     * @return An Optional containing a PlayerTabInfo if one was found
     */
    public Optional<PlayerTabInfo> getPlayer(UUID uuid);

}