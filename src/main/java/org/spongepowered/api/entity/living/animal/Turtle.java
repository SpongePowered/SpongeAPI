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
package org.spongepowered.api.entity.living.animal;

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.math.vector.Vector3i;

/**
 * Represents a Turtle
 */
public interface Turtle extends Animal {

    /**
     * {@link Keys#HOME_POSITION}
     * @return The position that is considered "home"
     */
    default Value.Mutable<Vector3i> homePosition() {
        return this.requireValue(Keys.HOME_POSITION).asMutable();
    }

    /**
     * {@link Keys#HAS_EGG}
     * @return Whether this turtle has an egg laid
     */
    default Value.Mutable<Boolean> hasEgg() {
        return this.requireValue(Keys.HAS_EGG).asMutable();
    }

    /**
     * {@link Keys#IS_LAYING_EGG}
     * @return Whether this turtle is laying an egg
     */
    default Value.Mutable<Boolean> layingEgg() {
        return this.requireValue(Keys.IS_LAYING_EGG).asMutable();
    }

    /**
     * {@link Keys#TARGET_POSITION}
     * @return The position that this turtle is traveling to
     */
    default Value.Mutable<Vector3i> travelingPosition() {
        return this.requireValue(Keys.TARGET_POSITION).asMutable();
    }

    /**
     * {@link Keys#IS_GOING_HOME}
     * @return Whether this turtle is heading home
     */
    default Value.Mutable<Boolean> goingHome() {
        return this.requireValue(Keys.IS_GOING_HOME).asMutable();
    }

    /**
     * {@link Keys#IS_TRAVELING}
     * @return Whether this turtle is traveling
     */
    default Value.Mutable<Boolean> traveling() {
        return this.requireValue(Keys.IS_TRAVELING).asMutable();
    }
}
