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

import org.spongepowered.api.world.World;

/**
 * Represents the state of a GameRule.
 */
public interface GameRule {

    /**
     * Sets the value of this GameRule.
     *
     * @param value The new value to set it to.
     */
    void set(String value);

    /**
     * Gets the value of this GameRule.
     *
     * @return The GameRule value.
     */
    String get();

    /**
     * Sets the value of this GameRule to a boolean.
     *
     * <p>
     *     This is equivalent to calling set(String.valueOf(value));
     * </p>
     *
     * @param value The boolean value to set it to.
     */
    void setBoolean(boolean value);

    /**
     * Gets the value of this GameRule as a boolean.
     *
     * <p>
     *     This is equivalent to calling Boolean.parseBoolean(get());
     * </p>
     *
     * @return The boolean value of the GameRule.
     */
    boolean getBoolean();

    /**
     * Sets the value of this GameRule to a double.
     *
     * <p>
     *     This is equivalent to calling set(String.valueOf(value));
     * </p>
     *
     * @param value The double value to set it to.
     */
    void setDouble(double value);

    /**
     * Gets the value of this GameRule as a double.
     *
     * <p>
     *     This is equivalent to calling Double.parseDouble(get());
     * </p>
     *
     * @return The double value of the GameRule.
     */
    double getDouble();

    /**
     * Sets the value of this GameRule to an int.
     *
     * <p>
     *     This is equivalent to calling set(String.valueOf(value));
     * </p>
     *
     * @param value The int value to set it to.
     */
    void setInteger(int value);

    /**
     * Gets the value of this GameRule as an int.
     *
     * <p>
     *     This is equivalent to calling Integer.parseInt(get());
     * </p>
     *
     * @return The int value of the GameRule.
     */
    int getInteger();

    /**
     * Gets the {@link GameRuleType} of this GameRule.
     *
     * @return The type of the GameRule.
     */
    GameRuleType getType();

    /**
     * Gets the {@link World} this GameRule is on.
     *
     * @return The world.
     */
    World getWorld();

}
