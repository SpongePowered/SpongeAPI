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
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class ClientCompletionKeys {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> BLOCK_STATE = ClientCompletionKeys.key(ResourceKey.minecraft("block_state"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> BLOCK_PREDICATE = ClientCompletionKeys.key(ResourceKey.minecraft("block_predicate"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> BOOL = ClientCompletionKeys.key(ResourceKey.brigadier("bool"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> COLOR = ClientCompletionKeys.key(ResourceKey.minecraft("color"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> COMPONENT = ClientCompletionKeys.key(ResourceKey.minecraft("component"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> DIMENSION = ClientCompletionKeys.key(ResourceKey.minecraft("dimension"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> DOUBLE = ClientCompletionKeys.key(ResourceKey.brigadier("double"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.EntitySelection>> ENTITY = ClientCompletionKeys.key(ResourceKey.minecraft("entity"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> ENTITY_ANCHOR = ClientCompletionKeys.key(ResourceKey.minecraft("entity_anchor"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> ENTITY_SUMMON = ClientCompletionKeys.key(ResourceKey.minecraft("entity_summon"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> FLOAT = ClientCompletionKeys.key(ResourceKey.brigadier("float"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> FUNCTION = ClientCompletionKeys.key(ResourceKey.minecraft("function"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> GAME_PROFILE = ClientCompletionKeys.key(ResourceKey.minecraft("game_profile"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> INTEGER = ClientCompletionKeys.key(ResourceKey.brigadier("integer"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> ITEM_ENCHANTMENT = ClientCompletionKeys.key(ResourceKey.minecraft("item_enchantment"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> ITEM_SLOT = ClientCompletionKeys.key(ResourceKey.minecraft("item_slot"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> LONG = ClientCompletionKeys.key(ResourceKey.brigadier("long"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> MESSAGE = ClientCompletionKeys.key(ResourceKey.minecraft("message"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> MOB_EFFECT = ClientCompletionKeys.key(ResourceKey.minecraft("mob_effect"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> NBT_COMPOUND_TAG = ClientCompletionKeys.key(ResourceKey.minecraft("nbt_compound_tag"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> NBT_PATH = ClientCompletionKeys.key(ResourceKey.minecraft("nbt_path"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> NBT_TAG = ClientCompletionKeys.key(ResourceKey.minecraft("nbt_tag"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> OBJECTIVE = ClientCompletionKeys.key(ResourceKey.minecraft("objective"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> OBJECTIVE_CRITERIA = ClientCompletionKeys.key(ResourceKey.minecraft("objective_criteria"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> OPERATION = ClientCompletionKeys.key(ResourceKey.minecraft("operation"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> PARTICLE = ClientCompletionKeys.key(ResourceKey.minecraft("particle"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> RESOURCE_LOCATION = ClientCompletionKeys.key(ResourceKey.minecraft("resource_location"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> ROTATION = ClientCompletionKeys.key(ResourceKey.minecraft("rotation"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Amount>> SCORE_HOLDER = ClientCompletionKeys.key(ResourceKey.minecraft("score_holder"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> SCOREBOARD_SLOT = ClientCompletionKeys.key(ResourceKey.minecraft("scoreboard_slot"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.StringParser>> STRING = ClientCompletionKeys.key(ResourceKey.brigadier("string"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> SWIZZLE = ClientCompletionKeys.key(ResourceKey.minecraft("swizzle"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> TEAM = ClientCompletionKeys.key(ResourceKey.minecraft("team"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> TIME = ClientCompletionKeys.key(ResourceKey.minecraft("time"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> VEC2 = ClientCompletionKeys.key(ResourceKey.minecraft("vec2"));

    public static final DefaultedRegistryReference<ClientCompletionKey<CommandTreeNode.Basic>> VEC3 = ClientCompletionKeys.key(ResourceKey.minecraft("vec3"));

    // SORTFIELDS:OFF

    // @formatter:on

    private ClientCompletionKeys() {
    }

    private static <T extends CommandTreeNode<T>> DefaultedRegistryReference<ClientCompletionKey<T>> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.CLIENT_COMPLETION_KEY, location).asDefaultedReference(() -> Sponge.game().registries());
    }
}
