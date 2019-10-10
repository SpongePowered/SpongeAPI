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
     * {@link Keys#TURTLE_HOME_POSITION}
     */
    default Value.Mutable<Vector3i> homePosition() {
        return this.getValue(Keys.TURTLE_HOME_POSITION).get().asMutable();
    }

    /**
     * {@link Keys#TURTLE_DOES_HAVE_EGG}
     */
    default Value.Mutable<Boolean> hasEgg() {
        return this.getValue(Keys.TURTLE_DOES_HAVE_EGG).get().asMutable();
    }

    /**
     * {@link Keys#TURTLE_IS_LAYING_EGG}
     */
    default Value.Mutable<Boolean> layingEgg() {
        return this.getValue(Keys.TURTLE_IS_LAYING_EGG).get().asMutable();
    }

    /**
     * {@link Keys#TURTLE_TRAVELING_POSITION}
     */
    default Value.Mutable<Vector3i> travelingPosition() {
        return this.getValue(Keys.TURTLE_TRAVELING_POSITION).get().asMutable();
    }

    /**
     * {@link Keys#TURTLE_IS_GOING_HOME}
     */
    default Value.Mutable<Boolean> goingHome() {
        return this.getValue(Keys.TURTLE_IS_GOING_HOME).get().asMutable();
    }

    /**
     * {@link Keys#TURTLE_IS_TRAVELING}
     */
    default Value.Mutable<Boolean> traveling() {
        return this.getValue(Keys.TURTLE_IS_TRAVELING).get().asMutable();
    }
}
