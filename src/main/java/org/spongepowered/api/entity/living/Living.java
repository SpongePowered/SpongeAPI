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

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.mutable.entity.DamageableData;
import org.spongepowered.api.data.manipulator.mutable.entity.HealthData;
import org.spongepowered.api.data.value.mutable.MutableBoundedValue;
import org.spongepowered.api.data.value.mutable.OptionalValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.scoreboard.TeamMember;

/**
 * Represents an entity that is living, and therefor can be damaged.
 *
 * <p>Living entities can have {@link PotionEffect}s, breathing air
 * under water, custom names, be meaningfully added to teams, and become invisible.</p>
 */
public interface Living extends Entity, TeamMember {

    /**
     * Gets a copy of the current {@link HealthData}.
     *
     * @return A copy of the current health data
     */
    default HealthData getHealthData() {
        return get(HealthData.class).get();
    }

    /**
     * Returns the health amount.
     *
     * <p>The range of the health depends on the object on which this
     * method is defined. For players in Minecraft, the nominal range is
     * between 0 and 20, inclusive, but the range can be adjusted.</p>
     *
     * <p>Convention dictates that health does not follow below 0 but this
     * convention may be broken.</p>
     *
     * @return Health value
     */
    default MutableBoundedValue<Double> health() {
        return getValue(Keys.HEALTH).get();
    }

    /**
     * Gets the current maximum health.
     *
     * <p>The maximum health set here may affect the attribute increasing
     * health points. The base health should be minded that it may be lower
     * than the total maximum health of this entity.</p>
     *
     * @return This entities maximum health
     */
    default MutableBoundedValue<Double> maxHealth() {
        return getValue(Keys.MAX_HEALTH).get();
    }

    /**
     * Gets a copy of the current {@link DamageableData}.
     *
     * @return A copy of the current damageable data
     */
    default DamageableData getMortalData() {
        return get(DamageableData.class).get();
    }

    /**
     * Gets the {@link OptionalValue} for the last attacker.
     *
     * @return The last attacker as an optional value
     */
    default OptionalValue<Living> lastAttacker() {
        return getValue(Keys.LAST_ATTACKER).get();
    }

    /**
     * Gets the last amount of damage dealt as an optional value.
     *
     * @return The last damage dealt as an optional value
     */
    default OptionalValue<Double> lastDamage() {
        return getValue(Keys.LAST_DAMAGE).get();
    }

}
