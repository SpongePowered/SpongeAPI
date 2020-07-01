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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Server;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.chat.ChatType;
import org.spongepowered.api.text.chat.ChatTypes;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Represents a channel that takes a message and transforms it for distribution
 * to the members.
 */
@FunctionalInterface
public interface MessageChannel {

    /**
     * Creates a message channel that targets nothing.
     *
     * @return The channel
     */
    static MessageChannel toNone() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).toNone();
    }

    /**
     * Creates a message channel that targets the {@link Server}.
     *
     * @return The channel
     */
    static MessageChannel toServer() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).toServer();
    }

    /**
     * Creates a message channel that targets all the online
     * {@link Player}s.
     *
     * @return The channel
     */
    static MessageChannel toPlayers() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).toPlayers();
    }

    /**
     * Creates a message channel that targets all {@link Player}s with the given
     * permission.
     *
     * @param permission The permission to target
     * @return The channel
     */
    static MessageChannel toPlayersWithPermission(String permission) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).toPlayersWithPermission(permission);
    }

    /**
     * Creates a message channel that targets all the online
     * {@link Player}s and the {@link Server}.
     *
     * @return The channel
     */
    static MessageChannel toPlayersAndServer() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).toPlayersAndServer();
    }

    /**
     * Creates a message channel that targets all {@link Subject}s with the given
     * permission.
     *
     * @param permission The permission to target
     * @return The channel
     */
    static MessageChannel toSubjectsWithPermission(String permission) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).toSubjectsWithPermission(permission);
    }

    /**
     * Creates a message channel that targets all subjects contained within the
     * given channels and applies the message transformations of each channel in
     * order.
     *
     * @param channels The channels to combine
     * @return The channel
     */
    static MessageChannel combined(MessageChannel... channels) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).combined(channels);
    }

    /**
     * Gets a message channel that targets all subjects contained within the
     * given channels and applies the message transformations of each channel in
     * order.
     *
     * @param channels The channels to combine
     * @return The channel
     */
    static MessageChannel combined(Iterable<? extends MessageChannel> channels) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).combined(channels);
    }

    /**
     * Creates a message channel that targets the given sources.
     *
     * @param recipients The recipients
     * @return The channel
     */
    static MessageChannel to(MessageReceiver... recipients) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).to(recipients);
    }

    /**
     * Creates a message channel that targets the given recipients.
     *
     * @param recipients The recipients
     * @return The channel
     */
    static MessageChannel to(Iterable<? extends MessageReceiver> recipients) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).to(recipients);
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
     * Send a message to this channel, transforming and sending it to the
     * members.
     *
     * @param sender The sender of the message
     * @param original The original message to send
     * @param type The type of message
     */
    default void send(@Nullable Object sender, Text original, Supplier<? extends ChatType> type) {
        checkNotNull(original, "original text");
        checkNotNull(type, "type");
        for (MessageReceiver member : this.getMembers()) {
            if (member instanceof ChatTypeMessageReceiver) {
                this.transformMessage(sender, member, original, type.get()).ifPresent(text -> ((ChatTypeMessageReceiver) member).sendMessage(type, text));
            } else {
                this.transformMessage(sender, member, original, type.get()).ifPresent(member::sendMessage);
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
     * Handle transforming the input message appropriately.
     *
     * @param sender The sender of the message
     * @param recipient The recipient of the message
     * @param original The original message, to optionally transform
     * @param type The type of message
     * @return The message to send, if present, otherwise {@link Optional#empty()}
     */
    default Optional<Text> transformMessage(@Nullable Object sender, MessageReceiver recipient, Text original, Supplier<? extends ChatType> type) {
        return Optional.of(original);
    }

    /**
     * Gets a collection of all members in this channel.
     *
     * @return A collection of all members of this channel
     */
    Collection<? extends MessageReceiver> getMembers();

    /**
     * Creates a copy of this channel as a {@link MutableMessageChannel}.
     *
     * @return The mutable channel
     */
    default MutableMessageChannel asMutable() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).asMutable(this);
    }

    interface Factory {

        MessageChannel toSubjectsWithPermission(String permission);

        MessageChannel combined(MessageChannel... channels);

        MessageChannel combined(Iterable<? extends MessageChannel> channels);

        MessageChannel to(MessageReceiver... recipients);

        MessageChannel to(Iterable<? extends MessageReceiver> recipients);

        MessageChannel toNone();

        MessageChannel toPlayers();

        MessageChannel toPlayersWithPermission(String permission);

        MessageChannel toPlayersAndServer();

        MessageChannel toServer();

        MutableMessageChannel asMutable(MessageChannel channel);
    }
}
