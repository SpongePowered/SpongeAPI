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
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

import java.util.function.Supplier;

public class ClientCompletionKeys {

    // SORTFIELDS: ON

    /**
     * Indicates that tab completing this element should query the server for
     * potential completions.
     *
     * <p><strong>Important note:</strong> if you wish to have any control
     * over the completion process, you should use this key.</p>
     */
    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.StringParser>> ASK_SERVER =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "ASK_SERVER");

    /**
     * Completions will attempt to return arguments that represent
     * {@link BlockState}s
     */
    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> BLOCK_STATE =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "BLOCK_STATE");

    /**
     * Completions will attempt to return arguments that represent
     * {@link BlockState}s - // TODO: Predicate
     */
    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> BLOCK_PREDICATE =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "BLOCK_PREDICATE");

    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> BOOLEAN =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "BOOLEAN");

    /**
     * Completions will attempt to return arguments that represent
     * {@link Color}s
     */
    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> COLOR =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "COLOR");

    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> DIMENSION =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "DIMENSION");

    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> DOUBLE =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "DOUBLE");

    /**
     * Completions will attempt to return arguments that represent
     * {@link Entity}s
     */
    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.EntitySelection>> ENTITY =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "ENTITY");

    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> ENTITY_ANCHOR =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "ENTITY_ANCHOR");

    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> ENTITY_SUMMON =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "ENTITY_SUMMON");

    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> FLOAT =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "FLOAT");

    public static Supplier<ClientCompletionKey<CommandTreeBuilder.Range<Float>>> FLOAT_RANGE =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "FLOAT_RANGE");

    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> FUNCTION =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "FUNCTION");

    /**
     * Completions will attempt to return arguments that represent
     * {@link GameProfile}s
     */
    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> GAME_PROFILE =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "GAME_PROFILE");

    public static Supplier<ClientCompletionKey<CommandTreeBuilder.Range<Integer>>> INT_RANGE =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "INT_RANGE");

    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> INTEGER =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "INTEGER");

    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> ITEM_ENCHANTMENT =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "ITEM_ENCHANTMENT");

    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> ITEM_SLOT =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "ITEM_SLOT");

    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> LONG =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "LONG");

    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> MESSAGE =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "MESSAGE");

    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> MOB_EFFECT =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "MOB_EFFECT");

    // TODO -> dataview?
    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> NBT_COMPOUND =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "NBT_COMPOUND");

    // TODO -> datapath?
    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> NBT_PATH =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "NBT_PATH");

    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> NBT_TAG =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "NBT_TAG");

    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> OBJECTIVE =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "OBJECTIVE");

    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> OBJECTIVE_CRITERIA =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "OBJECTIVE_CRITERIA");

    // TODO -> check
    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> OPERATION =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "OPERATION");

    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> PARTICLE =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "PARTICLE");

    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> RESOURCE_LOCATION =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "RESOURCE_LOCATION");

    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> ROTATION =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "ROTATION");

    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Amount>> SCORE_HOLDER =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "SCORE_HOLDER");

    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> SCOREBOARD_SLOT =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "SCOREBOARD_SLOT");

    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.StringParser>> STRING =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "STRING");

    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> SWIZZLE =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "SWIZZLE");

    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> TEAM =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "TEAM");

    /**
     * Completions will attempt to return arguments that represent
     * {@link Text}s
     */
    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> TEXT =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "TEXT");

    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> TIME =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "TIME");

    /**
     * Completions will attempt to return arguments that represent a
     * real-space position (that is, two-dimensional decimal co-ordinates).
     */
    public static final Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> VECTOR_2D =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "VECTOR_2D");

    /**
     * Completions will attempt to return arguments that represent a
     * block position (that is, two-dimensional integer co-ordinates).
     */
    public static Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> VECTOR_2I =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "VECTOR_2I");

    /**
     * Completions will attempt to return arguments that represent a
     * real-space position (that is, three-dimensional decimal co-ordinates).
     */
    public static Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> VECTOR_3D =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "VECTOR_3D");

    /**
     * Completions will attempt to return arguments that represent a
     * block position (that is, three-dimensional integer co-ordinates).
     */
    public static Supplier<ClientCompletionKey<CommandTreeBuilder.Basic>> VECTOR_3I =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClientCompletionKey.class, "VECTOR_3I");

    // SORTFIELDS: OFF

    private ClientCompletionKeys() {
        throw new AssertionError("This cannot be instantiated.");
    }

}
