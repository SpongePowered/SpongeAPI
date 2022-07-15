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

import net.kyori.adventure.text.Component;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Cause;
import org.spongepowered.api.util.annotation.eventgen.NoFactoryMethod;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * Fired when sending a chat message.
 * To modify the message use {@link Decorate}.
 */
@NoFactoryMethod
public interface PlayerChatEvent extends MessageEvent {

    /**
     * Returns the player sending the message.
     *
     * @return The player sending the message
     */
    ServerPlayer player();

    /**
     * Fired when a message is sent by a player.
     * <p>Note that a signed message cannot be modified.</p>
     */
    interface Submit extends PlayerChatEvent, Cancellable {

        /**
         * Returns the predicate for filtering the players receiving the message if set.
         *
         * @return the predicate
         */
        Optional<Predicate<ServerPlayer>> filter();

        /**
         * Sets the predicate for filtering the players receiving the message.
         *
         * @param filter the predicate
         */
        void setFilter(Predicate<ServerPlayer> filter);

        /**
         * Returns the component to use as the sender.
         * In Vanilla this defaults to the players display name
         *
         * @return The sender component
         */
        Component sender();

        /**
         * Sets the component to use as the sender.
         *
         * @param sender The sender component
         */
        void setSender(Component sender);

        /**
         * Returns true when using the sponge chat type.
         *
         * @return True when using the sponge chat type.
         */
        boolean isCustom();

        /**
         * Sets whether to use the sponge chat type.
         * The Sponge Chat Type uses {@code %s%s} as a Formatting Mask for chat messages.
         * This allows plugins to essentially modify the chat format by {@link #setSender setting} a custom sender component.
         * To modify the chat message itself it is recommended to use {@link PlayerChatEvent.Decorate}.
         *
         * @param isCustomized True to use the sponge chat type.
         */
        void setCustom(boolean isCustomized);

        /**
         * Returns true when {@link #originalMessage()} is signed and cannot be modified.
         *
         * @return True when signed
         */
        boolean isSigned();

    }

    /**
     * Fired when previewing a message by a player or {@link ServerPlayer#simulateChat(Component, Cause) simulating chat}
     */
    interface Decorate extends PlayerChatEvent {

        /**
         * Gets the original chat message.
         *
         * <p>In Vanilla, this is equivalent to what a player typed into the
         * chat box (no name prefix or other elements).</p>
         *
         * @return The original chat message
         */
        @Override
        Component originalMessage();

    }

}
