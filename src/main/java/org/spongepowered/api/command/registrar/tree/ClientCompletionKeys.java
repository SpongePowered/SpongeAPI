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
package org.spongepowered.api.command.registrar.tree;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registries;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class ClientCompletionKeys {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> BLOCK_STATE = ClientCompletionKeys.key(ResourceKey.sponge("block_state"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> BLOCK_PREDICATE = ClientCompletionKeys.key(ResourceKey.sponge("block_predicate"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> BOOL = ClientCompletionKeys.key(ResourceKey.sponge("bool"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> COLOR = ClientCompletionKeys.key(ResourceKey.sponge("color"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> COMPONENT = ClientCompletionKeys.key(ResourceKey.sponge("component"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> DIMENSION = ClientCompletionKeys.key(ResourceKey.sponge("dimension"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> DOUBLE = ClientCompletionKeys.key(ResourceKey.sponge("double"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.EntitySelection>> ENTITY = ClientCompletionKeys.key(ResourceKey.sponge("entity"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> ENTITY_ANCHOR = ClientCompletionKeys.key(ResourceKey.sponge("entity_anchor"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> ENTITY_SUMMON = ClientCompletionKeys.key(ResourceKey.sponge("entity_summon"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> FLOAT = ClientCompletionKeys.key(ResourceKey.sponge("float"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> FUNCTION = ClientCompletionKeys.key(ResourceKey.sponge("function"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> GAME_PROFILE = ClientCompletionKeys.key(ResourceKey.sponge("game_profile"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> INTEGER = ClientCompletionKeys.key(ResourceKey.sponge("integer"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> ITEM_ENCHANTMENT = ClientCompletionKeys.key(ResourceKey.sponge("item_enchantment"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> ITEM_SLOT = ClientCompletionKeys.key(ResourceKey.sponge("item_slot"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> LONG = ClientCompletionKeys.key(ResourceKey.sponge("long"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> MESSAGE = ClientCompletionKeys.key(ResourceKey.sponge("message"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> MOB_EFFECT = ClientCompletionKeys.key(ResourceKey.sponge("mob_effect"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> NBT_COMPOUND_TAG = ClientCompletionKeys.key(ResourceKey.sponge("nbt_compound_tag"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> NBT_PATH = ClientCompletionKeys.key(ResourceKey.sponge("nbt_path"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> NBT_TAG = ClientCompletionKeys.key(ResourceKey.sponge("nbt_tag"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> OBJECTIVE = ClientCompletionKeys.key(ResourceKey.sponge("objective"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> OBJECTIVE_CRITERIA = ClientCompletionKeys.key(ResourceKey.sponge("objective_criteria"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> OPERATION = ClientCompletionKeys.key(ResourceKey.sponge("operation"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> PARTICLE = ClientCompletionKeys.key(ResourceKey.sponge("particle"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> RESOURCE_LOCATION = ClientCompletionKeys.key(ResourceKey.sponge("resource_location"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> ROTATION = ClientCompletionKeys.key(ResourceKey.sponge("rotation"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Amount>> SCORE_HOLDER = ClientCompletionKeys.key(ResourceKey.sponge("score_holder"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> SCOREBOARD_SLOT = ClientCompletionKeys.key(ResourceKey.sponge("scoreboard_slot"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.StringParser>> STRING = ClientCompletionKeys.key(ResourceKey.sponge("string"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> SWIZZLE = ClientCompletionKeys.key(ResourceKey.sponge("swizzle"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> TEAM = ClientCompletionKeys.key(ResourceKey.sponge("team"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> TIME = ClientCompletionKeys.key(ResourceKey.sponge("time"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> VEC2 = ClientCompletionKeys.key(ResourceKey.sponge("VEC2"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> VEC3 = ClientCompletionKeys.key(ResourceKey.sponge("VEC3"));

    // SORTFIELDS:OFF

    // @formatter:on

    private ClientCompletionKeys() {
    }

    private static <T extends CommandTreeNode<T>> DefaultedRegistryReference<ClientCompletionKey<T>> key(final ResourceKey location) {
        return RegistryKey.<ClientCompletionKey<T>>of(Registries.CLIENT_COMPLETION_KEY.registry(), location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
