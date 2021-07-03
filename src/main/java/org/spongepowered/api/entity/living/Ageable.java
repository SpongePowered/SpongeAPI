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
package org.spongepowered.api.entity.living;

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.util.Ticks;

import java.util.Optional;

/**
 * Represents an {@link Agent} that produces offspring and grows into an adult
 */
public interface Ageable extends Agent {

    /**
     * {@link Keys#IS_ADULT}
     *
     * @return Whether this entity is an adult or not
     */
    default Value.Mutable<Boolean> adult() {
        return this.requireValue(Keys.IS_ADULT).asMutable();
    }

    /**
     * {@link Keys#BABY_TICKS}
     *
     * @return The ticks until this entity turns into an adult
     */
    default Optional<Value.Mutable<Ticks>> babyTicks() {
        return this.getValue(Keys.BABY_TICKS).map(Value::asMutable);
    }

    /**
     * {@link Keys#CAN_BREED}
     *
     * @return Whether the entity can breed
     */
    default Value.Mutable<Boolean> canBreed() {
        return this.requireValue(Keys.CAN_BREED).asMutable();
    }

    /**
     * {@link Keys#BREEDING_COOLDOWN}
     *
     * @return The ticks until the entity can breed again
     */
    default Optional<Value.Mutable<Ticks>> breedingCooldown() {
        return this.getValue(Keys.BREEDING_COOLDOWN).map(Value::asMutable);
    }

}
