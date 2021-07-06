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

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.math.vector.Vector3i;

import java.util.Optional;

/**
 * Represents an end crystal.
 */
public interface EndCrystal extends Explosive {

    /**
     * {@link Keys#TARGET_POSITION}
     *
     * @return The target position of the beam
     */
    default Optional<Value.Mutable<Vector3i>> beamTarget() {
        return this.getValue(Keys.TARGET_POSITION).map(Value::asMutable);
    }

    /**
     * {@link Keys#SHOW_BOTTOM}
     *
     * @return The value whether this crystal is showing a bottom "pedestal"
     */
    default Value.Mutable<Boolean> showBottom() {
        return this.requireValue(Keys.SHOW_BOTTOM).asMutable();
    }

    /**
     * {@link Keys#HEALTH}
     *
     * @return The health of the end crystal
     */
    default Value.Mutable<Double> health() {
        return this.requireValue(Keys.HEALTH).asMutable();
    }
}
