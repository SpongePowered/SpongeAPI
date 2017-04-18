package org.spongepowered.api.entity.living.player.tab;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

import java.util.Optional;
import java.util.UUID;

import javax.annotation.Nullable;

/**
 * A mutable version of {@link TabList}. It also contains a reference to the
 * {@link Player} entity.
 */
public interface PlayerTabList extends TabList {

    /**
     * Gets the associated {@link Player} with this {@link TabList}.
     *
     * @return The associated player
     */
    Player getPlayer();

    /**
     * Sets this list's header.
     *
     * <p>When {@code null} is passed, an empty {@link Text} will
     * be sent.</p>
     *
     * @param header The new header
     * @return This tab list, for chaining
     */
    TabList setHeader(@Nullable Text header);

    /**
     * Sets this list's footer.
     *
     * <p>When {@code null} is passed, an empty {@link Text} will
     * be sent.</p>
     *
     * @param footer The new footer
     * @return This tab list, for chaining
     */
    TabList setFooter(@Nullable Text footer);

    /**
     * Sets this list's header and footer.
     *
     * <p>When {@code null} is passed, an empty {@link Text} will
     * be sent.</p>
     *
     * @param header The new header
     * @param footer The new footer
     * @return This tab list, for chaining
     */
    default TabList setHeaderAndFooter(@Nullable Text header, @Nullable Text footer) {
        this.setHeader(header);
        this.setFooter(footer);
        return this;
    }

    /**
     * Adds an entry to the list.
     *
     * @param entry The entry to add
     * @return This tab list, for chaining
     * @throws IllegalArgumentException if an entry already with the same unique
     * id exists on the list
     * @throws IllegalStateException if the provided entry was not
     */
    TabList addEntry(TabListEntry entry) throws IllegalArgumentException;

    /**
     * Removes an entry from the list.
     *
     * <p>Note that if this is used on a player, but they remain visible
     * in-game, their skin will not work.</p>
     *
     * @param uniqueId The unique id of the entry to remove
     * @return The entry that was associated with the unique id
     */
    Optional<TabListEntry> removeEntry(UUID uniqueId);
}
