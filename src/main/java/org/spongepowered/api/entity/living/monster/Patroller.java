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
package org.spongepowered.api.entity.living.monster;

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.living.Monster;
import org.spongepowered.math.vector.Vector3i;

import java.util.Optional;

public interface Patroller extends Monster {

    /**
     * {@link Keys#TARGET_POSITION}
     * @return The target position for a patrol
     */
    default Optional<Value.Mutable<Vector3i>> targetPosition() {
        return this.getValue(Keys.TARGET_POSITION).map(Value::asMutable);
    }

    /**
     * {@link Keys#IS_LEADER}
     * @return Whether this is the leader of a patrol
     */
    default Value.Mutable<Boolean> leader() {
        return this.requireValue(Keys.IS_LEADER).asMutable();
    }

    /**
     * {@link Keys#IS_PATROLLING}
     * @return Whether this patroller is patrolling
     */
    default Value.Mutable<Boolean> patrolling() {
        return this.requireValue(Keys.IS_PATROLLING).asMutable();
    }

    /**
     * Instructs the patroller to find a new patrol target.
     *
     * {@link Keys#TARGET_POSITION}
     */
    void findPatrolTarget();
}
