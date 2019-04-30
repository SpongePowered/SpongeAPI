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
package org.spongepowered.api.world.gamerule;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of all the possible game rules in vanilla minecraft.
 */
@SuppressWarnings("unchecked")
public final class GameRules {

    // SORTFIELDS:ON

    public static final GameRule<Boolean> ANNOUNCE_ADVANCEMENTS = DummyObjectProvider.createFor(GameRule.class, "ANNOUNCE_ADVANCEMENTS");

    public static final GameRule<Boolean> COMMAND_BLOCK_OUTPUT = DummyObjectProvider.createFor(GameRule.class, "COMMAND_BLOCK_OUTPUT");

    public static final GameRule<Boolean> DISABLE_ELYTRA_MOVEMENT_CHECK = DummyObjectProvider.createFor(GameRule.class, "DISABLE_ELYTRA_MOVEMENT_CHECK");

    public static final GameRule<Boolean> DO_DAYLIGHT_CYCLE = DummyObjectProvider.createFor(GameRule.class, "DO_DAYLIGHT_CYCLE");

    public static final GameRule<Boolean> DO_ENTITY_DROPS = DummyObjectProvider.createFor(GameRule.class, "DO_ENTITY_DROPS");

    public static final GameRule<Boolean> DO_FIRE_TICK = DummyObjectProvider.createFor(GameRule.class, "DO_FIRE_TICK");

    public static final GameRule<Boolean> DO_LIMITED_CRAFTING = DummyObjectProvider.createFor(GameRule.class, "DO_LIMITED_CRAFTING");

    public static final GameRule<Boolean> DO_MOB_LOOT = DummyObjectProvider.createFor(GameRule.class, "DO_MOB_LOOT");

    public static final GameRule<Boolean> DO_MOB_SPAWNING = DummyObjectProvider.createFor(GameRule.class, "DO_MOB_SPAWNING");

    public static final GameRule<Boolean> DO_TILE_DROPS = DummyObjectProvider.createFor(GameRule.class, "DO_TILE_DROPS");

    public static final GameRule<Boolean> DO_WEATHER_CYCLE = DummyObjectProvider.createFor(GameRule.class, "DO_WEATHER_CYCLE");

    public static final GameRule<Boolean> KEEP_INVENTORY = DummyObjectProvider.createFor(GameRule.class, "KEEP_INVENTORY");

    public static final GameRule<Boolean> LOG_ADMIN_COMMANDS = DummyObjectProvider.createFor(GameRule.class, "LOG_ADMIN_COMMANDS");

    public static final GameRule<Integer> MAX_COMMAND_CHAIN_LENGTH = DummyObjectProvider.createFor(GameRule.class, "MAX_COMMAND_CHAIN_LENGTH");

    public static final GameRule<Integer> MAX_ENTITY_CRAMMING = DummyObjectProvider.createFor(GameRule.class, "MAX_ENTITY_CRAMMING");

    public static final GameRule<Boolean> MOB_GRIEFING = DummyObjectProvider.createFor(GameRule.class, "MOB_GRIEFING");

    public static final GameRule<Boolean> NATURAL_REGENERATION = DummyObjectProvider.createFor(GameRule.class, "NATURAL_REGENERATION");

    public static final GameRule<Integer> RANDOM_TICK_SPEED = DummyObjectProvider.createFor(GameRule.class, "RANDOM_TICK_SPEED");

    public static final GameRule<Boolean> REDUCED_DEBUG_INFO = DummyObjectProvider.createFor(GameRule.class, "REDUCED_DEBUG_INFO");

    public static final GameRule<Boolean> SEND_COMMAND_FEEDBACK = DummyObjectProvider.createFor(GameRule.class, "SEND_COMMAND_FEEDBACK");

    public static final GameRule<Boolean> SHOW_DEATH_MESSAGES = DummyObjectProvider.createFor(GameRule.class, "SHOW_DEATH_MESSAGES");

    public static final GameRule<Integer> SPAWN_RADIUS = DummyObjectProvider.createFor(GameRule.class, "SPAWN_RADIUS");

    public static final GameRule<Boolean> SPECTATORS_GENERATE_CHUNKS = DummyObjectProvider.createFor(GameRule.class, "SPECTATORS_GENERATE_CHUNKS");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private GameRules() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
