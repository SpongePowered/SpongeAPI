/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

import com.google.common.base.Optional;

import java.util.List;

/**
 * An enumeration of all possible {@link GameRule}s in vanilla minecraft.
 */
public class GameRules {

    public static final GameRule<Boolean> COMMAND_BLOCK_OUTPUT = null;
    public static final GameRule<Boolean> DO_DAYLIGHT_CYCLE = null;
    public static final GameRule<Boolean> DO_ENTITY_DROPS = null;
    public static final GameRule<Boolean> DO_FIRE_TICK = null;
    public static final GameRule<Boolean> DO_MOB_LOOT = null;
    public static final GameRule<Boolean> DO_MOB_SPAWNING = null;
    public static final GameRule<Boolean> DO_TILE_DROPS = null;
    public static final GameRule<Boolean> KEEP_INVENTORY = null;
    public static final GameRule<Boolean> LOG_ADMIN_COMMANDS = null;
    public static final GameRule<Boolean> MOB_GRIEFING = null;
    public static final GameRule<Boolean> NATURAL_REGENERATION = null;
    public static final GameRule<Integer> RANDOM_TICK_SPEED = null;
    public static final GameRule<Boolean> REDUCED_DEBUG_INFO = null;
    public static final GameRule<Boolean> SEND_COMMAND_FEEDBACK = null;
    public static final GameRule<Boolean> SHOW_DEATH_MESSAGES = null;

    /**
     * Gets a {@link GameRule} by name.
     *
     * @param name The name of the {@link GameRule}.
     * @param <T> The value type of the {@link GameRule}.
     *
     * @return The {@link GameRule}, if available.
     */
    public static <T> Optional<GameRule<T>> getByName(String name) {
        return null;
    }

    public static List<GameRule> getValues() {
        return null;
    }

}
