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
package org.spongepowered.api.projectile.source;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.projectile.Projectile;
import org.spongepowered.math.vector.Vector3d;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Represents a valid source of a projectile.
 */
public interface ProjectileSource {

    /**
     * Launches a {@link Projectile} from this projectile source.
     *
     * @param projectileType The type of the projectile
     * @param <T> The Type of Projectile
     * @return The projectile instance if it was launched, or absent
     */
    <T extends Projectile> Optional<T> launchProjectile(EntityType<T> projectileType);

    /**
     * Launches a {@link Projectile} from this projectile source.
     *
     * @param projectileType The type of the projectile
     * @param <T> The Type of Projectile
     * @return The projectile instance if it was launched, or absent
     */
    default <T extends Projectile> Optional<T> launchProjectile(final Supplier<EntityType<T>> projectileType) {
        return this.launchProjectile(projectileType.get());
    }

    /**
     * Launches a {@link Projectile} from this projectile source.
     *
     * @param projectileType The type of the projectile
     * @param velocity The velocity to launch the projectile
     * @param <T> The Type of Projectile
     * @return The projectile instance if it was launched, or absent
     */
    <T extends Projectile> Optional<T> launchProjectile(EntityType<T> projectileType, Vector3d velocity);

    /**
     * Launches a {@link Projectile} from this projectile source.
     *
     * @param projectileType The type of the projectile
     * @param velocity The velocity to launch the projectile
     * @param <T> The Type of Projectile
     * @return The projectile instance if it was launched, or absent
     */
    default <T extends Projectile> Optional<T> launchProjectile(final Supplier<EntityType<T>> projectileType, final Vector3d velocity) {
        return this.launchProjectile(projectileType.get(), velocity);
    }

    /**
     * Launches a new {@link Projectile} from this projectile source.
     *
     * @param projectileType The type of the projectile
     * @param target the target to launch the projectile at
     * @param <T> The Type of Projectile
     * @return the projectile if successfully launched, {@link Optional#empty()} otherwise
     */
    <T extends Projectile> Optional<T> launchProjectileTo(EntityType<T> projectileType, Entity target);

    /**
     * Launches a new {@link Projectile} from this projectile source.
     *
     * @param projectileType The type of the projectile
     * @param target the target to launch the projectile at
     * @param <T> The Type of Projectile
     * @return the projectile if successfully launched, {@link Optional#empty()} otherwise
     */
    default <T extends Projectile> Optional<T> launchProjectileTo(final Supplier<EntityType<T>> projectileType, final Entity target) {
        return this.launchProjectileTo(projectileType.get(), target);
    }
}
