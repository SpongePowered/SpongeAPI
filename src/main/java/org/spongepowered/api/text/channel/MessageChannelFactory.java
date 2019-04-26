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
package org.spongepowered.api.text.channel;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.chat.ChatType;
import org.spongepowered.api.world.World;

import java.util.Collection;

public interface MessageChannelFactory {

    /**
     * Creates a message channel that targets all subjects with the given
     * permission.
     *
     * @param permission The permission to target
     * @return The channel
     */
    MessageChannel permission(String permission);

    /**
     * Creates a message channel that targets all subjects contained within the
     * given channels and applies the message transformations of each channel in
     * order.
     *
     * @param channels The channels to combine
     * @return The channel
     */
    MessageChannel combined(MessageChannel... channels);

    /**
     * Gets a message channel that targets all subjects contained within the
     * given channels and applies the message transformations of each channel in
     * order.
     *
     * @param channels The channels to combine
     * @return The channel
     */
    MessageChannel combined(Collection<MessageChannel> channels);

    /**
     * Creates a message channel that targets the given sources.
     *
     * @param recipients The recipients
     * @return The channel
     */
    MessageChannel fixed(MessageReceiver... recipients);

    /**
     * Creates a message channel that targets the given recipients.
     *
     * @param recipients The recipients
     * @return The channel
     */
    MessageChannel fixed(Collection<? extends MessageReceiver> recipients);

    /**
     * Creates a message channel that targets the given world.
     *
     * @param world The world
     * @return The channel
     */
    MessageChannel world(World world);

    /**
     * Gets or creates a mutable version of the provided channel.
     *
     * @return A mutable channel
     */
    MutableMessageChannel asMutable(MessageChannel channel);
}
