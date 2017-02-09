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
import org.spongepowered.api.text.channel.impl.DelegateMutableMessageChannel;
import org.spongepowered.api.text.channel.type.CombinedMessageChannel;
import org.spongepowered.api.text.channel.type.FixedMessageChannel;
import org.spongepowered.api.text.channel.type.PermissionMessageChannel;
import org.spongepowered.api.text.channel.type.WorldMessageChannel;
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
     * A channel with all online players as members.
     */
    MessageChannel TO_PLAYERS = () -> ImmutableSet.copyOf(Sponge.getGame().getServer().getOnlinePlayers());

    /**
     * A channel with the server console as a member.
     */
    MessageChannel TO_CONSOLE = () -> ImmutableSet.of(Sponge.getGame().getServer().getConsole());

    /**
     * A channel with all online players, as well as the server console, as
     * members.
     */
    MessageChannel TO_ALL = () -> ImmutableSet.<MessageReceiver>builder()
            .addAll(Sponge.getGame().getServer().getOnlinePlayers())
            .add(Sponge.getGame().getServer().getConsole())
            .build();

    /**
     * Creates a message channel that targets all subjects with the given
     * permission.
     *
     * @param permission The permission to target
     * @return The channel
     * @see PermissionMessageChannel
     */
    static MessageChannel permission(String permission) {
        return new PermissionMessageChannel(permission);
    }

    /**
     * Creates a message channel that targets all subjects contained within the
     * given channels and applies the message transformations of each channel in
     * order.
     *
     * @param channels The channels to combine
     * @return The channel
     * @see CombinedMessageChannel
     */
    static MessageChannel combined(MessageChannel... channels) {
        return new CombinedMessageChannel(channels);
    }

    /**
     * Gets a message channel that targets all subjects contained within the
     * given channels and applies the message transformations of each channel in
     * order.
     *
     * @param channels The channels to combine
     * @return The channel
     * @see CombinedMessageChannel
     */
    static MessageChannel combined(Collection<MessageChannel> channels) {
        return new CombinedMessageChannel(channels);
    }

    /**
     * Creates a message channel that targets the given sources.
     *
     * @param recipients The recipients
     * @return The channel
     * @see FixedMessageChannel
     */
    static MessageChannel fixed(MessageReceiver... recipients) {
        return new FixedMessageChannel(recipients);
    }

    /**
     * Creates a message channel that targets the given recipients.
     *
     * @param recipients The recipients
     * @return The channel
     * @see FixedMessageChannel
     */
    static MessageChannel fixed(Collection<? extends MessageReceiver> recipients) {
        return new FixedMessageChannel(recipients);
    }

    /**
     * Creates a message channel that targets the given world.
     *
     * @param world The world
     * @return The channel
     * @see WorldMessageChannel
     */
    static MessageChannel world(World world) {
        return new WorldMessageChannel(world);
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
     * Gets or creates a mutable version of this channel.
     *
     * <p>The default behaviour of this method is to copy the current member
     * list into a {@link DelegateMutableMessageChannel}, which calls the
     * {@link #transformMessage(Object, MessageReceiver, Text, ChatType)} method
     * on this channel.</p>
     *
     * @return A mutable channel
     */
    default MutableMessageChannel asMutable() {
        return new DelegateMutableMessageChannel(this);
    }

}
