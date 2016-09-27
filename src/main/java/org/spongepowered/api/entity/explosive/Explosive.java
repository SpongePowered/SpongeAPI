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
package org.spongepowered.api.entity.explosive;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.mutable.entity.ExplosionRadiusData;
import org.spongepowered.api.data.value.mutable.OptionalValue;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.cause.Cause;

/**
 * Represents an explosive entity that explodes.
 */
public interface Explosive extends Entity {

    /**
     * Returns the {@link ExplosionRadiusData} for this explosive.
     *
     * @return Explosion radius data
     */
    default ExplosionRadiusData getExplosionRadiusData() {
        return get(ExplosionRadiusData.class).get();
    }

    /**
     * The radius in blocks that the explosion will affect. This value may be
     * missing if the explosion radius is unknown such as when it is generated
     * randomly on detonation. Setting this value on such explosives will
     * override that behavior.
     *
     * @return Explosion radius
     */
    default OptionalValue<Integer> explosionRadius() {
        return getValue(Keys.EXPLOSION_RADIUS).get();
    }

    /**
     * Detonates this explosive as soon as possible.
     */
    void detonate();

}
