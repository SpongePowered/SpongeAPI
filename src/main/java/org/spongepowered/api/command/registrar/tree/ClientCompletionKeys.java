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

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> BLOCK_STATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "BLOCK_STATE");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> BLOCK_PREDICATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "BLOCK_PREDICATE");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> BOOL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "BOOL");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> COLOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "COLOR");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> COMPONENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "COMPONENT");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> DIMENSION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "DIMENSION");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> DOUBLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "DOUBLE");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.EntitySelection>> ENTITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "ENTITY");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> ENTITY_ANCHOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "ENTITY_ANCHOR");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> ENTITY_SUMMON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "ENTITY_SUMMON");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> FLOAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "FLOAT");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> FUNCTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "FUNCTION");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> GAME_PROFILE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "GAME_PROFILE");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> INTEGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "INTEGER");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> ITEM_ENCHANTMENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "ITEM_ENCHANTMENT");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> ITEM_SLOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "ITEM_SLOT");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> LONG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "LONG");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> MESSAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "MESSAGE");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> MOB_EFFECT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "MOB_EFFECT");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> NBT_COMPOUND_TAG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "NBT_COMPOUND_TAG");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> NBT_PATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "NBT_PATH");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> NBT_TAG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "NBT_TAG");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> OBJECTIVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "OBJECTIVE");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> OBJECTIVE_CRITERIA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "OBJECTIVE_CRITERIA");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> OPERATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "OPERATION");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> PARTICLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "PARTICLE");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> RESOURCE_LOCATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "RESOURCE_LOCATION");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "ROTATION");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Amount>> SCORE_HOLDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "SCORE_HOLDER");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> SCOREBOARD_SLOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "SCOREBOARD_SLOT");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.StringParser>> STRING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "STRING");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> SWIZZLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "SWIZZLE");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> TEAM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "TEAM");

    public static final Supplier<ClientCompletionKey<CommandTreeNode.Basic>> TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "TIME");

    public static Supplier<ClientCompletionKey<CommandTreeNode.Basic>> VEC2 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "VEC2");

    public static Supplier<ClientCompletionKey<CommandTreeNode.Basic>> VEC3 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "VEC3");

    // SORTFIELDS: OFF

    private ClientCompletionKeys() {
        throw new AssertionError("This cannot be instantiated.");
    }

}
