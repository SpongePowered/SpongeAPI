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

package org.spongepowered.api.entity.projectile;

import org.spongepowered.api.entity.EntityType;

/**
 * Represents entities that act as projectiles and can fly in the air.
 * For example, Arrows.
 */
public interface DamagingProjectile extends Projectile {

    /**
     * Gets the damage this projectile will deal to a {@link org.spongepowered.api.entity.living.Living}
     * if hit.
     *
     * @return The damage to deal
     */
    double getDamage();

    /**
     * Sets the damage this projectile will deal to a LivingEntity if hit.
     *
     * @param damage The damage to deal
     */
    void setDamage(double damage);

    /**
     * Gets the damage this projectile will deal to the specified {@link
     * EntityType} if hit.
     *
     * <p>Note that in events, the damage defined for the provided {@link
     * EntityType} will take priority over the "default" damage as defined
     * from {@link #getDamage()}.</p>
     *
     * @param entityType The {@link EntityType} to set the damage amount for
     * @return The damage to deal to the specified {@link EntityType}
     */
    double getDamageForEntity(EntityType entityType);

    /**
     * Sets the damage this projectile will deal to the specified {@link
     * EntityType} if hit.
     *
     * <p>Note that in events, the damage defined for the provided {@link
     * EntityType} will take priority over the "default" damage as defined
     * from {@link #getDamage()}.</p>
     *
     * @param entityType The {@link EntityType} to set the damage amount for
     * @param damage The damage to deal to the specified {@link EntityType}
     */
    void setDamageForEntity(EntityType entityType, double damage);

}
