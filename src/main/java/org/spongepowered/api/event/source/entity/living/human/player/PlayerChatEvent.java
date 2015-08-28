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
package org.spongepowered.api.event.source.entity.living.human.player;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.text.Text;

/**
 * Called when a {@link Player} sends a chat message.
 */
public interface PlayerChatEvent extends PlayerMessageEvent, Cancellable {

    /**
     * The placeholder key that will be replaced with the player's name
     */
    String PLACEHOLDER_NAME = "name";

    /**
     * The placeholder key that will be replaced with the output of {@link #getUnformattedMessage()}
     */
    String PLACEHOLDER_MESSAGE = "message";

    /**
     * Returns the message as the player provided it, without being formatted with the player's name or any other decorations.
     *
     * @return The unformatted message
     */
    Text getUnformattedMessage();

    /**
     * Set the unformatted message that will be provided for this event
     *
     * @param message The message to set
     */
    void setUnformattedMessage(Text message);

    /**
     * Set the new message to be used in this event. The placeholders {@code name} and {@code message} will be replaced with the sender's display
     * name and {@link #getUnformattedMessage()} in the provided text.
     *
     * @param message The new message
     */
    @Override
    void setNewMessage(Text message);
}
