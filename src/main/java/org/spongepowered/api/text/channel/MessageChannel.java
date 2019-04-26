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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableSet;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.chat.ChatType;
import org.spongepowered.api.text.chat.ChatTypes;
import org.spongepowered.api.world.World;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Nullable;

/**
 * Represents a channel that takes a message and transforms it for distribution
 * to the members.
 */
@FunctionalInterface
public interface MessageChannel {

    /**
     * A channel with no members.
     */
    MessageChannel TO_NONE = ImmutableSet::of;

    /**
     * @see MessageChannelFactory#permission(String)
     */
    static MessageChannel permission(String permission) {
        return Sponge.getRegistry().getMessageChannelFactory().permission(permission);
    }

    /**
     * @see MessageChannelFactory#combined(MessageChannel...)
     */
    static MessageChannel combined(MessageChannel... channels) {
        return Sponge.getRegistry().getMessageChannelFactory().combined(channels);
    }

    /**
     * @see MessageChannelFactory#combined(Collection)
     */
    static MessageChannel combined(Collection<MessageChannel> channels) {
        return Sponge.getRegistry().getMessageChannelFactory().combined(channels);
    }

    /**
     * @see MessageChannelFactory#fixed(MessageReceiver...)
     */
    static MessageChannel fixed(MessageReceiver... recipients) {
        return Sponge.getRegistry().getMessageChannelFactory().fixed(recipients);
    }

    /**
     * @see MessageChannelFactory#fixed(Collection)
     */
    static MessageChannel fixed(Collection<? extends MessageReceiver> recipients) {
        return Sponge.getRegistry().getMessageChannelFactory().fixed(recipients);
    }

    /**
     * @see MessageChannelFactory#world(World)
     */
    static MessageChannel world(World world) {
        return Sponge.getRegistry().getMessageChannelFactory().world(world);
    }

    /**
     * Broadcast a message to this channel, transforming and sending it to
     * the members.
     *
     * @param original The original text to send
     */
    default void send(Text original) {
        this.send(null, original);
    }

    /**
     * Sends a message to this channel, transforming and sending it to
     * the members.
     *
     * <p>By default, the {@link ChatTypes#SYSTEM} type is used when sending
     * messages to applicable recipients of this channel.</p>
     *
     * @param original The original text to send
     * @param type The type of message
     */
    default void send(Text original, ChatType type) {
        this.send(null, original, type);
    }

    /**
     * Send a message to this channel, transforming and sending it to the
     * members.
     *
     * @param sender The sender of the message
     * @param original The original message to send
     */
    default void send(@Nullable Object sender, Text original) {
        this.send(sender, original, ChatTypes.SYSTEM);
    }

    /**
     * Send a message to this channel, transforming and sending it to the
     * members.
     *
     * @param sender The sender of the message
     * @param original The original message to send
     * @param type The type of message
     */
    default void send(@Nullable Object sender, Text original, ChatType type) {
        checkNotNull(original, "original text");
        checkNotNull(type, "type");
        for (MessageReceiver member : this.getMembers()) {
            if (member instanceof ChatTypeMessageReceiver) {
                this.transformMessage(sender, member, original, type).ifPresent(text -> ((ChatTypeMessageReceiver) member).sendMessage(type, text));
            } else {
                this.transformMessage(sender, member, original, type).ifPresent(member::sendMessage);
            }
        }
    }

    /**
     * Handle transforming the input message appropriately.
     *
     * @param sender The sender of the message
     * @param recipient The recipient of the message
     * @param original The original message, to optionally transform
     * @param type The type of message
     * @return The message to send, if present, otherwise {@link Optional#empty()}
     */
    default Optional<Text> transformMessage(@Nullable Object sender, MessageReceiver recipient, Text original, ChatType type) {
        return Optional.of(original);
    }

    /**
     * Gets a collection of all members in this channel.
     *
     * @return A collection of all members of this channel
     */
    Collection<MessageReceiver> getMembers();

    /**
     * @see MessageChannelFactory#asMutable(MessageChannel)
     */
    default MutableMessageChannel asMutable() {
        return Sponge.getRegistry().getMessageChannelFactory().asMutable(this);
    }
}
