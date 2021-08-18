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

/**
 * The known {@link CommandTreeNodeType types} available on the vanilla client.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class CommandTreeNodeTypes {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> ANGLE = CommandTreeNodeTypes.key(ResourceKey.minecraft("angle"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> BLOCK_POS = CommandTreeNodeTypes.key(ResourceKey.minecraft("block_pos"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> BLOCK_PREDICATE = CommandTreeNodeTypes.key(ResourceKey.minecraft("block_predicate"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> BLOCK_STATE = CommandTreeNodeTypes.key(ResourceKey.minecraft("block_state"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> BOOL = CommandTreeNodeTypes.key(ResourceKey.brigadier("bool"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> COLOR = CommandTreeNodeTypes.key(ResourceKey.minecraft("color"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> COLUMN_POS = CommandTreeNodeTypes.key(ResourceKey.minecraft("column_pos"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> COMPONENT = CommandTreeNodeTypes.key(ResourceKey.minecraft("component"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> DIMENSION = CommandTreeNodeTypes.key(ResourceKey.minecraft("dimension"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Range<Double>>> DOUBLE = CommandTreeNodeTypes.key(ResourceKey.brigadier("double"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.EntitySelection>> ENTITY = CommandTreeNodeTypes.key(ResourceKey.minecraft("entity"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> ENTITY_ANCHOR = CommandTreeNodeTypes.key(ResourceKey.minecraft("entity_anchor"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> ENTITY_SUMMON = CommandTreeNodeTypes.key(ResourceKey.minecraft("entity_summon"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Range<Float>>> FLOAT = CommandTreeNodeTypes.key(ResourceKey.brigadier("float"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> FLOAT_RANGE = CommandTreeNodeTypes.key(ResourceKey.minecraft("float_range"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> FUNCTION = CommandTreeNodeTypes.key(ResourceKey.minecraft("function"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> GAME_PROFILE = CommandTreeNodeTypes.key(ResourceKey.minecraft("game_profile"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Range<Integer>>> INTEGER = CommandTreeNodeTypes.key(ResourceKey.brigadier("integer"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> INT_RANGE = CommandTreeNodeTypes.key(ResourceKey.minecraft("int_range"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> ITEM_ENCHANTMENT = CommandTreeNodeTypes.key(ResourceKey.minecraft("item_enchantment"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> ITEM_PREDICATE = CommandTreeNodeTypes.key(ResourceKey.minecraft("item_predicate"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> ITEM_SLOT = CommandTreeNodeTypes.key(ResourceKey.minecraft("item_slot"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> ITEM_STACK = CommandTreeNodeTypes.key(ResourceKey.minecraft("item_stack"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Range<Long>>> LONG = CommandTreeNodeTypes.key(ResourceKey.brigadier("long"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> MESSAGE = CommandTreeNodeTypes.key(ResourceKey.minecraft("message"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> MOB_EFFECT = CommandTreeNodeTypes.key(ResourceKey.minecraft("mob_effect"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> NBT_COMPOUND_TAG = CommandTreeNodeTypes.key(ResourceKey.minecraft("nbt_compound_tag"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> NBT_PATH = CommandTreeNodeTypes.key(ResourceKey.minecraft("nbt_path"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> NBT_TAG = CommandTreeNodeTypes.key(ResourceKey.minecraft("nbt_tag"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> OBJECTIVE = CommandTreeNodeTypes.key(ResourceKey.minecraft("objective"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> OBJECTIVE_CRITERIA = CommandTreeNodeTypes.key(ResourceKey.minecraft("objective_criteria"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> OPERATION = CommandTreeNodeTypes.key(ResourceKey.minecraft("operation"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> PARTICLE = CommandTreeNodeTypes.key(ResourceKey.minecraft("particle"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> RESOURCE_LOCATION = CommandTreeNodeTypes.key(ResourceKey.minecraft("resource_location"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> ROTATION = CommandTreeNodeTypes.key(ResourceKey.minecraft("rotation"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Amount>> SCORE_HOLDER = CommandTreeNodeTypes.key(ResourceKey.minecraft("score_holder"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> SCOREBOARD_SLOT = CommandTreeNodeTypes.key(ResourceKey.minecraft("scoreboard_slot"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.StringParser>> STRING = CommandTreeNodeTypes.key(ResourceKey.brigadier("string"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> SWIZZLE = CommandTreeNodeTypes.key(ResourceKey.minecraft("swizzle"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> TEAM = CommandTreeNodeTypes.key(ResourceKey.minecraft("team"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> TIME = CommandTreeNodeTypes.key(ResourceKey.minecraft("time"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> UUID = CommandTreeNodeTypes.key(ResourceKey.minecraft("uuid"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> VEC2 = CommandTreeNodeTypes.key(ResourceKey.minecraft("vec2"));

    public static final DefaultedRegistryReference<CommandTreeNodeType<CommandTreeNode.Basic>> VEC3 = CommandTreeNodeTypes.key(ResourceKey.minecraft("vec3"));

    // SORTFIELDS:OFF

    // @formatter:on

    private CommandTreeNodeTypes() {
    }

    private static <T extends CommandTreeNode<T>> DefaultedRegistryReference<CommandTreeNodeType<T>> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.COMMAND_TREE_NODE_TYPE, location).asDefaultedReference(Sponge::game);
    }
}
