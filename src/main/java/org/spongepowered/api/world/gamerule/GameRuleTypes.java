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
 * An enumeration of all possible {@link GameRuleType}s in vanilla minecraft.
 */
public class GameRuleTypes {

    public static final GameRuleType COMMAND_BLOCK_OUTPUT = null;
    public static final GameRuleType DO_DAYLIGHT_CYCLE = null;
    public static final GameRuleType DO_ENTITY_DROPS = null;
    public static final GameRuleType DO_FIRE_TICK = null;
    public static final GameRuleType DO_MOB_LOOT = null;
    public static final GameRuleType DO_MOB_SPAWNING = null;
    public static final GameRuleType DO_TILE_DROPS = null;
    public static final GameRuleType KEEP_INVENTORY = null;
    public static final GameRuleType LOG_ADMIN_COMMANDS = null;
    public static final GameRuleType MOB_GRIEFING = null;
    public static final GameRuleType NATURAL_REGENERATION = null;
    public static final GameRuleType RANDOM_TICK_SPEED = null;
    public static final GameRuleType REDUCED_DEBUG_INFO = null;
    public static final GameRuleType SEND_COMMAND_FEEDBACK = null;
    public static final GameRuleType SHOW_DEATH_MESSAGES = null;

    /**
     * Gets a {@link GameRuleType} by name.
     *
     * @param name The name of the {@link GameRuleType}.
     *
     * @return The {@link GameRuleType}, if available.
     */
    public static Optional<GameRuleType> getByName(String name) {
        return null;
    }

    public static List<GameRuleType> getValues() {
        return null;
    }

}
