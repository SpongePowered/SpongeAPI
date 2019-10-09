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
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.projectile.source.EntityProjectileSource;
import org.spongepowered.api.scoreboard.TeamMember;
import org.spongepowered.math.vector.Vector3d;

import java.util.OptionalDouble;

/**
 * Represents an entity that is living, and therefor can be damaged.
 *
 * <p>Living entities can have {@link PotionEffect}s, breathing air
 * under water, custom names, be meaningfully added to teams, and become
 * invisible.</p>
 */
public interface Living extends Entity, EntityProjectileSource, TeamMember {

    /**
     * {@link Keys#HEALTH}
     */
    default BoundedValue.Mutable<Double> health() {
        return this.getValue(Keys.HEALTH).get().asMutable();
    }

    /**
     * {@link Keys#MAX_HEALTH}
     */
    default BoundedValue.Mutable<Double> maxHealth() {
        return this.getValue(Keys.MAX_HEALTH).get().asMutable();
    }

    /**
     * {@link Keys#LAST_ATTACKER}
     */
    default Value.Mutable<Entity> lastAttacker() {
        return this.getValue(Keys.LAST_ATTACKER).get().asMutable();
    }

    /**
     * {@link Keys#HEAD_ROTATION}
     */
    default Value.Mutable<Vector3d> headRotation() {
        return this.getValue(Keys.HEAD_ROTATION).get().asMutable();
    }

    /**
     * Gets the last amount of damage that was dealt to this entity.
     *
     * @return The last damage, if present
     */
    OptionalDouble getLastDamage();

    /**
     * Makes the entity look at the specified target position.
     *
     * @param targetPos Position to target
     */
    void lookAt(Vector3d targetPos);
}
