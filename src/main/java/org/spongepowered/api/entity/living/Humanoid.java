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
package org.spongepowered.api.entity.living;

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.Tamer;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.item.inventory.ArmorEquipable;

/**
 * Represents a human-like entity in game, such as {@link Player} or {@link Human}s.
 */
public interface Humanoid extends Living, ArmorEquipable, Tamer {
    /**
     * {@link Keys#FOOD_LEVEL}
     * @return The human's food level
     */
    default Value.Mutable<Integer> foodLevel() {
        return this.requireValue(Keys.FOOD_LEVEL).asMutable();
    }

    /**
     * {@link Keys#EXHAUSTION}
     * @return The human's exhaustion
     */
    default Value.Mutable<Double> exhaustion() {
        return this.requireValue(Keys.EXHAUSTION).asMutable();
    }

    /**
     * {@link Keys#SATURATION}
     * @return The human's saturation
     */
    default Value.Mutable<Double> saturation() {
        return this.requireValue(Keys.SATURATION).asMutable();
    }

    /**
     * {@link Keys#GAME_MODE}
     * @return The gamemode
     */
    default Value.Mutable<GameMode> gameMode() {
        return this.requireValue(Keys.GAME_MODE).asMutable();
    }
}
