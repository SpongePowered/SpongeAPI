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

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

public class ClientCompletionKeys {

    // SORTFIELDS: ON

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> BLOCK_STATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "block_state");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> BLOCK_PREDICATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "block_predicate");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> BOOL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "bool");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> COLOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "color");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> COMPONENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "component");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> DIMENSION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "dimension");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> DOUBLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "double");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.EntitySelection>> ENTITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "entity");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> ENTITY_ANCHOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "entity_anchor");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> ENTITY_SUMMON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "entity_summon");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> FLOAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "float");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> FUNCTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "function");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> GAME_PROFILE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "game_profile");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> INTEGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "integer");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> ITEM_ENCHANTMENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "item_enchantment");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> ITEM_SLOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "item_slot");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> LONG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "long");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> MESSAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "message");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> MOB_EFFECT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "mob_effect");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> NBT_COMPOUND_TAG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "nbt_compound_tag");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> NBT_PATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "nbt_path");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> NBT_TAG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "nbt_tag");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> OBJECTIVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "objective");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> OBJECTIVE_CRITERIA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "objective_criteria");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> OPERATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "operation");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> PARTICLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "particle");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> RESOURCE_LOCATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "resource_location");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "rotation");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Amount>> SCORE_HOLDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "score_holder");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> SCOREBOARD_SLOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "scoreboard_slot");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.StringParser>> STRING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "string");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> SWIZZLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "swizzle");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> TEAM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "team");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "time");

    public static Supplier<ClientCompletionKey<CommandTreeNode.Basic>> VEC2 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "VEC2");

    public static Supplier<ClientCompletionKey<CommandTreeNode.Basic>> VEC3 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "VEC3");

    // SORTFIELDS: OFF

    private ClientCompletionKeys() {
        throw new AssertionError("This cannot be instantiated.");
    }

}
