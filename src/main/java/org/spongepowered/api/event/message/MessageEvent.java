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

import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.GameEvent;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.sink.MessageSink;
import org.spongepowered.api.util.command.CommandSource;

/**
 * Describes events when a {@link CommandSource} sends a {@link Text} message.
 */
public interface MessageEvent extends GameEvent, Cancellable {

    /**
     * Gets the {@link CommandSource} of the event which may
     * or may not be a target of the {@link Text}.
     *
     * @return The source
     */
    CommandSource getSource();

    /**
     * Gets the {@link Text} message created by the {@link CommandSource} before
     * the calling of this event.
     *
     * @return The message
     */
    Text getMessage();

    /**
     * Gets the currently set {@link Text} message.
     *
     * @return The message
     */
    Text getNewMessage();

    /**
     * Sets the {@link Text} message.
     *
     * @param message The new message
     */
    void setNewMessage(Text message);

    /**
     * Gets the current sink that this message will be sent to.
     *
     * @return The message sink the message in this event will be sent to
     */
    MessageSink getSink();

    /**
     * Set the target for this message to go to.
     *
     * @param sink The sink to set
     */
    void setSink(MessageSink sink);

}
