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

import org.spongepowered.api.world.World;
import org.spongepowered.api.world.storage.WorldProperties;

import java.util.Optional;

/**
 * Someone who holds various {@link GameRule}s and the values they point to.
 *
 * In vanilla this is generally only the {@link World} which can be accessed
 * through its {@link WorldProperties}.
 */
public interface GameRuleHolder {

    /**
     * Gets the value of the specified game rule for this game rule holder
     * if it is present.
     *
     * @param gameRule The game rule to get the value for
     * @param <T> The value type of the game rule
     * @return The value of the game rule, if present
     */
    <T> Optional<T> getGameRule(GameRule<T> gameRule);

    /**
     * Gets the value of the specified game rule of this game rule holder
     * or creates it using the game rule's default value and adds it to the
     * holder.
     *
     * @param gameRule The game rule to get the value for
     * @param <T> The value type of the game rule
     * @return The value of the game rule
     */
    <T> T getOrCreateGameRule(GameRule<T> gameRule);

    /**
     * Sets the value of the specified game rule. If this game rule holder
     * lacks this game rule, then it will be created automatically.
     *
     * @param gameRule The game rule to set the value for
     * @param value The value to set the game rule to
     * @param <T> The value type of the game rule
     */
    <T> void setGameRule(GameRule<T> gameRule, T value);

    /**
     * Removes the specified game rule from this game rule holder. If the rule
     * was present, then the previous value will be returned.
     *
     * @param gameRule The game rule to remove
     * @param <T> The value type of the game rule
     * @return The removed value, if it was present on this game rule holder
     */
    <T> Optional<T> removeGameRule(GameRule<T> gameRule);

    /**
     * Gets whether or not this game rule holder has the specified
     * game rule present.
     *
     * @param gameRule The game rule to check for
     * @param <T> The value type of the game rule
     * @return If this game rule holder has the game rule
     */
    default <T> boolean hasGameRule(GameRule<T> gameRule) {
        return this.getGameRule(gameRule).isPresent();
    }

}
