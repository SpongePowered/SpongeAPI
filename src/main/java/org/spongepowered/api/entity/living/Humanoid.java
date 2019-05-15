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
import org.spongepowered.api.data.value.BoundedValue;
import org.spongepowered.api.entity.ArmorEquipable;
import org.spongepowered.api.entity.Tamer;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.projectile.ProjectileLauncher;

/**
 * Represents a human-like entity in game, such as {@link Player} or {@link Human}s.
 */
public interface Humanoid extends Living, ProjectileLauncher, ArmorEquipable, Tamer {

    /**
     * Gets the current food level as an {@link org.spongepowered.api.data.value.BoundedValue.Mutable}.
     *
     * <p>Food level has health effects, depending on game difficulty and
     * hunger levels. If the food level is high enough, the human entity
     * may heal. If the food level is at 0, the human entity may starve.</p>
     *
     * @return The current food level
     */
    default BoundedValue.Mutable<Integer> foodLevel() {
        return getValue(Keys.FOOD_LEVEL).get().asMutable();
    }

    /**
     * Gets the {@link org.spongepowered.api.data.value.BoundedValue.Mutable} for the "exhaustion" level.
     *
     * <p>When the exhaustion level reaches 0, saturation is usually diminished
     * such that saturation is decreased and then exhaustion is reset to the
     * maximum. This type of effect occurs over time and can be modified by
     * movements and actions performed by the {@link Humanoid} entity.</p>
     *
     * @return The immutable bounded value of exhaustion
     */
    default BoundedValue.Mutable<Double> exhaustion() {
        return getValue(Keys.EXHAUSTION).get().asMutable();
    }

    /**
     * Gets the {@link org.spongepowered.api.data.value.BoundedValue.Mutable} for the "saturation" level.
     *
     * <p>When the saturation level reaches 0, the food level is usually
     * diminished such that the food level is decreased by 1, then
     * saturation is reset to the maximum value. This type of effect occurs
     * over time and can be modified by movements and actions performed by the
     * {@link Humanoid} entity.</p>
     *
     * @return The immutable bounded value of saturation
     */
    default BoundedValue.Mutable<Double> saturation() {
        return getValue(Keys.SATURATION).get().asMutable();
    }
}
