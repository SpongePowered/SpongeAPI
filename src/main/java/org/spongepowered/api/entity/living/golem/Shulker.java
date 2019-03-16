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
package org.spongepowered.api.entity.living.golem;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.mutable.DyeableData;
import org.spongepowered.api.data.manipulator.mutable.block.DirectionalData;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.projectile.EntityTargetingProjectile;
import org.spongepowered.api.entity.projectile.source.ProjectileSource;
import org.spongepowered.api.util.Direction;

import java.util.Optional;

public interface Shulker extends Golem, ProjectileSource {

    /**
     * Gets a copy of the {@link DyeableData} representing the color of this
     * {@link Shulker} entity.
     *
     * @return A copy of the dye data
     */
    default DyeableData getDyeData() {
        return get(DyeableData.class).get();
    }

    /**
     * Gets the current {@link Value} of {@link DyeColor} for this
     * {@link Shulker}.
     *
     * @return The current value of dye color for this shulker
     */
    default Value<DyeColor> color() {
        return getValue(Keys.DYE_COLOR).get();
    }

    /**
     * Gets a copy of the {@link DirectionalData} representing the direction this
     * {@link Shulker} is oriented towards.
     *
     * @return A copy of the directional data
     */
    default DirectionalData getDirectionalData() {
        return get(DirectionalData.class).get();
    }

    /**
     * Gets the current {@link Value} of {@link Direction} for this {@link Shulker}.
     *
     * @return The current value of direction for this shulker
     */
    default Value<Direction> direction() {
        return getValue(Keys.DIRECTION).get();
    }

    /**
     * Launches a new {@link EntityTargetingProjectile} from this {@link Shulker}.
     *
     * @param projectileClass The class of the projectile to launch
     * @param target the target to assign to the launched projectile
     * @param <P> The type of {@link EntityTargetingProjectile}
     *
     * @return the projectile if successfully launched, {@link Optional#empty()} otherwise
     */
    <P extends EntityTargetingProjectile> Optional<P> launchWithTarget(Class<P> projectileClass, Entity target);
}
