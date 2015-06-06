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
package org.spongepowered.api.data.manipulator.entity;

import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.data.value.OptionalValue;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Living;

/**
 * Represents the various information for a damageable {@link Entity} such that
 * it is aware of the previous attacker, the last amount of damage it took, etc.
 * Usually applicable to {@link Living} entities.
 */
public interface DamageableData extends DataManipulator<DamageableData> {

    /**
     * Gets the living entity that last attacked this one.
     * <p>The last attacker may expire over time or when the attacker died.</p>
     *
     * @return The last attacker of this entity
     */
    OptionalValue<Living, DamageableData> lastAttacker();

    /**
     * Gets the last amount of damage dealt to this entity.
     *
     * @return The damage amount last dealt
     */
    OptionalValue<Double, DamageableData> lastDamage();

    /**
     * Gets the amount of ticks this entity is immune from damage.
     *
     * @return The ticks of immunity towards damage
     */
    OptionalValue<Integer, DamageableData> invulnerabilityTicks();

    /**
     * Gets the maximum ticks of invulnerability for this entity.
     *
     * @return The maximum ticks of invulnerability
     */
    OptionalValue<Integer, DamageableData> maxInvulnerabilityTicks();

}
