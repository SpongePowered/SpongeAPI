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

import java.util.Map;
import java.util.function.Supplier;

/**
 * Represents something that can hold {@link GameRule}s.
 */
public interface GameRuleHolder {

    /**
     * Gets the value for the specified {@link GameRule}.
     *
     * @param gameRule The game rule
     * @param <V> The value type
     * @return The value
     */
    default <V> V getGameRule(Supplier<? extends GameRule<V>> gameRule) {
        return this.getGameRule(gameRule.get());
    }

    /**
     * Gets the value for the specified {@link GameRule}.
     *
     * @param gameRule The game rule
     * @param <V> The value type
     * @return The value
     */
    <V> V getGameRule(GameRule<V> gameRule);

    /**
     * Sets the value for the specified {@link GameRule}.
     *
     * @param gameRule The game rule
     * @param value The value
     * @param <V> The value type
     */
    default <V> void setGameRule(Supplier<? extends GameRule<V>> gameRule, V value) {
        this.setGameRule(gameRule.get(), value);
    }

    /**
     * Sets the value for the specified {@link GameRule}.
     *
     * @param gameRule The game rule
     * @param value The value
     * @param <V> The value type
     */
    <V> void setGameRule(GameRule<V> gameRule, V value);

    /**
     * Gets a map with all the {@link GameRule}s and their values.
     *
     * @return The game rules
     */
    Map<GameRule<?>, ?> getGameRules();
}
