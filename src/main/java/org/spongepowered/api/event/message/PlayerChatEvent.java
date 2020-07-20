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
package org.spongepowered.api.event.message;

import java.util.Optional;
import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.entity.living.player.PlayerChatRouter;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;

/**
 * Fired when the {@link Component} being sent to a {@link PlayerChatRouter} was
 * due to chatting.
 */
public interface PlayerChatEvent extends Event, Cancellable {

    /**
     * Gets the original router that this message will be sent to.
     *
     * @return The original router to send to
     */
    PlayerChatRouter getOriginalChatRouter();

    /**
     * Gets the current router that this message will be sent to.
     *
     * @return The router the message in this event will be sent to
     */
    Optional<PlayerChatRouter> getChatRouter();

    /**
     * Sets the router for this message to go to.
     *
     * @param router The router to set
     */
    void setChatRouter(@Nullable PlayerChatRouter router);

    /**
     * Gets the original chat message.
     *
     * <p>This message is the original chat message, without any formatting
     * whatsoever.</p>
     *
     * <p>In Vanilla, this is equivalent to what a player typed into the
     * chat box (no name prefix or other elements).</p>
     *
     * @return The original chat message
     */
    Component getOriginalMessage();

    /**
     * Gets the chat message.
     *
     * @return The chat message
     */
    Component getMessage();

    /**
     * Sets the chat message.
     *
     * @param message The chat message
     */
    void setMessage(final Component message);

}
