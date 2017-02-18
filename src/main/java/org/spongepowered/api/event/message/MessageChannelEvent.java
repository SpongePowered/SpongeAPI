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
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.util.annotation.eventgen.GenerateFactoryMethod;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * Describes events when a involving a {@link Text} message and {@link MessageChannel}s.
 */
@GenerateFactoryMethod
public interface MessageChannelEvent extends MessageEvent {

    /**
     * Gets the original channel that this message will be sent to.
     *
     * @return The original message channel to send to
     */
    MessageChannel getOriginalChannel();

    /**
     * Gets the current channel that this message will be sent to.
     *
     * <p>Note that an {@link Optional#empty()} channel is different from a
     * {@link MessageChannel#TO_NONE} channel.</p>
     *
     * @return The message channel the message in this event will be sent to
     */
    Optional<MessageChannel> getChannel();

    /**
     * Set the channel for this message to go to.
     *
     * <p>Note that an {@link Optional#empty()} channel is different from a
     * {@link MessageChannel#TO_NONE} channel.</p>
     *
     * @param channel The channel to set
     */
    void setChannel(@Nullable MessageChannel channel);

    /**
     * Fired when the {@link Text} being sent to a {@link MessageChannel} was
     * due to chatting.
     */
    interface Chat extends MessageChannelEvent, Cancellable {

        /**
         * Gets the 'raw' chat message.
         *
         * <p>This message is the original chat message, without any formatting
         * whatsoever.</p>
         *
         * <p>In Vanilla, this is equivalent to what a player typed into the
         * chat box (no name prefix or other elements).</p>
         *
         * @return The raw message
         */
        Text getRawMessage();

    }
}
