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
package org.spongepowered.api.entity.living.player.tab;

import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents a {@link Player}'s tab list.
 */
public interface TabList {

    /**
     * Gets the associated {@link ServerPlayer player} with this {@link TabList}.
     *
     * @return The associated player
     */
    ServerPlayer getPlayer();

    /**
     * Gets this list's header.
     *
     * @return The current header
     */
    Optional<Component> getHeader();

    /**
     * Sets this list's header.
     *
     * <p>When {@code null} is passed, an empty {@link Component} will
     * be sent.</p>
     *
     * @param header The new header
     * @return This tab list, for chaining
     */
    TabList setHeader(@Nullable Component header);

    /**
     * Gets this list's footer.
     *
     * @return The current footer
     */
    Optional<Component> getFooter();

    /**
     * Sets this list's footer.
     *
     * <p>When {@code null} is passed, an empty {@link Component} will
     * be sent.</p>
     *
     * @param footer The new footer
     * @return This tab list, for chaining
     */
    TabList setFooter(@Nullable Component footer);

    /**
     * Sets this list's header and footer.
     *
     * <p>When {@code null} is passed, an empty {@link Component} will
     * be sent.</p>
     *
     * @param header The new header
     * @param footer The new footer
     * @return This tab list, for chaining
     */
    default TabList setHeaderAndFooter(@Nullable Component header, @Nullable Component footer) {
        this.setHeader(header);
        this.setFooter(footer);
        return this;
    }

    /**
     * Gets the entries on the list.
     *
     * <p>The returned collection should be immutable.</p>
     *
     * @return The entries on the list
     */
    Collection<TabListEntry> getEntries();

    /**
     * Gets a {@link TabListEntry} matching the specified unique id.
     *
     * @param uniqueId The unique id to search for
     * @return The entry if present, otherwise {@link Optional#empty()}
     */
    Optional<TabListEntry> getEntry(UUID uniqueId);

    /**
     * Adds an entry to the list.
     *
     * @param entry The entry to add
     * @return This tab list, for chaining
     * @throws IllegalArgumentException if an entry already with the same unique
     *     id exists on the list
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
