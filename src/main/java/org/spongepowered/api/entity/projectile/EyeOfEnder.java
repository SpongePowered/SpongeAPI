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
package org.spongepowered.api.entity.projectile;

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.util.Ticks;
import org.spongepowered.math.vector.Vector3d;

/**
 * Represents an Eye of Ender.
 */
public interface EyeOfEnder extends Projectile {

    /**
     * {@link Keys#DESPAWN_DELAY}
     *
     * @return The despawn delay (in ticks) of the eye of ender
     */
    default Value.Mutable<Ticks> despawnDelay() {
        return this.requireValue(Keys.DESPAWN_DELAY).asMutable();
    }

    /**
     * {@link Keys#TARGET_LOCATION}
     *
     * @return The targeted location, if available
     */
    default Value.Mutable<Vector3d> targetLocation() {
        return this.requireValue(Keys.TARGET_LOCATION).asMutable();
    }

    /**
     * {@link Keys#WILL_SHATTER}
     *
     * @return Whether the thrown eye of ender will shatter
     */
    default Value.Mutable<Boolean> willShatter() {
        return this.requireValue(Keys.WILL_SHATTER).asMutable();
    }

}
