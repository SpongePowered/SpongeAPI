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

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.projectile.source.ProjectileSource;

/**
 * Represents entities that act as projectiles and can fly in the air.
 * For example, Arrows.
 */
public interface Projectile extends Entity {

    /**
     * Gets the shooter of this projectile.
     * <p>All projectiles have a {@link ProjectileSource} regardless
     * whether the projectile was launched via plugin or mod.</p>
     *
     * @return The projectile source that shot this projectile
     */
    ProjectileSource getShooter();

    /**
     * Sets the shooter of this projectile.
     * <p>All projectiles have a {@link ProjectileSource} regardless
     * whether the projectile was launched via plugin or mod.</p>
     *
     * @param shooter The projectile source that shot this projectile
     */
    void setShooter(ProjectileSource shooter);

}
