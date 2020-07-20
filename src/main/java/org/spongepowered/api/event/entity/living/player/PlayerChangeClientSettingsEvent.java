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
package org.spongepowered.api.event.entity.living.player;

import org.spongepowered.api.data.type.SkinPart;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.entity.living.player.chat.ChatVisibility;

import java.util.Locale;
import java.util.Set;

/**
 * Fired when a {@link ServerPlayer player} changes one or more of the following settings.
 *
 * <ul>
 *   <li>Locale</li>
 *   <li>View distance</li>
 *   <li>Chat visibility</li>
 *   <li>Chat colors</li>
 *   <li>Displayed skin parts</li>
 * </ul>
 *
 * <p>The event is fired before the player object is updated so it is possible
 * to inspect the old settings.</p>
 */
public interface PlayerChangeClientSettingsEvent extends Event {

    /**
     * Gets the {@link ServerPlayer player}.
     *
     * @return The player
     */
    ServerPlayer getPlayer();

    /**
     * Gets the new locale of the player.
     *
     * @return The locale
     */
    Locale getLocale();

    /**
     * Gets the new view distance of the player. This value represents the
     * radius in unit chunks.
     *
     * @return The view distance
     */
    int getViewDistance();

    /**
     * Gets the new chat visibility setting of the player.
     *
     * @return The chat visibility setting
     */
    ChatVisibility getChatVisibility();

    /**
     * Gets the new value for whether the player has colors enabled in chat.
     *
     * @return True if colors are enabled in chat
     */
    boolean isChatColorsEnabled();

    /**
     * Gets the new skin part's displayed.
     *
     * @return The displayed skin parts
     */
    Set<SkinPart> getDisplayedSkinParts();

}
