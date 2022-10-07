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
package org.spongepowered.api.adventure;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registry;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

@RegistryScopes(scopes = RegistryScope.ENGINE)
public final class ChatTypes {

    // @formatter:off

    // SORTFIELDS:ON

    /**
     * The default vanilla chat type
     */
    public static final DefaultedRegistryReference<ChatType> CHAT = ChatTypes.key(ResourceKey.minecraft("chat"));

    /**
     * The default vanilla chat type for say command messages
     */
    public static final DefaultedRegistryReference<ChatType> SAY_COMMAND = ChatTypes.key(ResourceKey.minecraft("say_command"));

    /**
     * The default vanilla chat type for incoming command messages
     */
    public static final DefaultedRegistryReference<ChatType> MSG_COMMAND_INCOMING = ChatTypes.key(ResourceKey.minecraft("msg_command_incoming"));

    /**
     * The default vanilla chat type for outgoing command messages
     */
    public static final DefaultedRegistryReference<ChatType> MSG_COMMAND_OUTGOING = ChatTypes.key(ResourceKey.minecraft("msg_command_outgoing"));

    /**
     * The default vanilla chat type for incoming team command messages
     */
    public static final DefaultedRegistryReference<ChatType> TEAM_MSG_COMMAND_INCOMING = ChatTypes.key(ResourceKey.minecraft("team_msg_command_incoming"));

    /**
     * The default vanilla chat type for outgoing team command messages
     */
    public static final DefaultedRegistryReference<ChatType> TEAM_MSG_COMMAND_OUTGOING = ChatTypes.key(ResourceKey.minecraft("team_msg_command_outgoing"));

    /**
     * The default vanilla chat type for the emote command
     */
    public static final DefaultedRegistryReference<ChatType> EMOTE_COMMAND = ChatTypes.key(ResourceKey.minecraft("emote_command"));

    /**
     * Sponge provided custom chat type using {@code %s%s} ({@code sender}, {@code content}) for formatting.
     */
    public static final DefaultedRegistryReference<ChatType> CUSTOM_CHAT = ChatTypes.key(ResourceKey.sponge("chat"));

    /**
     * Sponge provided custom chat type using {@code %s%s%s} ({@code target}, {@code sender}, {@code content}) for formatting.
     */
    public static final DefaultedRegistryReference<ChatType> CUSTOM_MESSAGE = ChatTypes.key(ResourceKey.sponge("message"));


    // SORTFIELDS:OFF

    // @formatter:on

    private ChatTypes() {
    }

    public static Registry<ChatType> registry() {
        return Sponge.server().registry(RegistryTypes.CHAT_TYPE);
    }

    public static DefaultedRegistryReference<ChatType> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.CHAT_TYPE, location).asDefaultedReference(Sponge::server);
    }
}
