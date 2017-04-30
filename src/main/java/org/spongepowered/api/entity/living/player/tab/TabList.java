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

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents a {@link Player}'s tab list. For mutability, use the
 * {@link ServerTabList}.
 *
 * @see ServerTabList
 */
public interface TabList {

    /**
     * Gets this list's header.
     *
     * @return The current header
     */
    Optional<Text> getHeader();

    /**
     * Gets this list's footer.
     *
     * @return The current footer
     */
    Optional<Text> getFooter();

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


}
