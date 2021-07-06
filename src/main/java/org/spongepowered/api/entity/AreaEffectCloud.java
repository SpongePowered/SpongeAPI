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
package org.spongepowered.api.entity;

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.value.ListValue;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.effect.particle.ParticleEffect;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.util.Ticks;

/**
 * Represents an AreaEffectCloud. The cloud will apply {@link PotionEffect}s to
 * {@link Entity} instances within it's bounding box.
 */
public interface AreaEffectCloud extends Entity {

    /**
     * {@link Keys#COLOR}
     *
     * @return The color of this cloud
     */
    default Value.Mutable<Color> color() {
        return this.requireValue(Keys.COLOR).asMutable();
    }

    /**
     * {@link Keys#RADIUS}
     *
     * @return The initial radius of this cloud
     */
    default Value.Mutable<Double> radius() {
        return this.requireValue(Keys.RADIUS).asMutable();
    }

    /**
     * {@link Keys#PARTICLE_EFFECT}
     *
     * @return The particle type
     * @see org.spongepowered.api.effect.particle.ParticleTypes
     */
    default Value.Mutable<ParticleEffect> particleEffect() {
        return this.requireValue(Keys.PARTICLE_EFFECT).asMutable();
    }

    /**
     * {@link Keys#DURATION}
     *
     * @return The duration of which this cloud will linger
     */
    default Value.Mutable<Ticks> duration() {
        return this.requireValue(Keys.DURATION).asMutable();
    }

    /**
     * {@link Keys#WAIT_TIME}
     *
     * @return The wait time before applying to an entity
     */
    default Value.Mutable<Ticks> waitTime() {
        return this.requireValue(Keys.WAIT_TIME).asMutable();
    }

    /**
     * {@link Keys#RADIUS_ON_USE}
     *
     * @return The radius decrease per use
     */
    default Value.Mutable<Double> radiusOnUse() {
        return this.requireValue(Keys.RADIUS_ON_USE).asMutable();
    }

    /**
     * {@link Keys#RADIUS_PER_TICK}
     *
     * @return The radius decrease per tick
     */
    default Value.Mutable<Double> radiusPerTick() {
        return this.requireValue(Keys.RADIUS_PER_TICK).asMutable();
    }

    /**
     * {@link Keys#DURATION_ON_USE}
     *
     * @return The duration of the potion effects when an entity gets a potion applied
     */
    default Value.Mutable<Ticks> durationOnUse() {
        return this.requireValue(Keys.DURATION_ON_USE).asMutable();
    }

    /**
     * {@link Keys#REAPPLICATION_DELAY}
     *
     * @return The delay for an entity to have a potion effect applied while standing in this cloud
     */
    default Value.Mutable<Ticks> applicationDelay() {
        return this.requireValue(Keys.REAPPLICATION_DELAY).asMutable();
    }

    /**
     * {@link Keys#POTION_EFFECTS}
     *
     * @return The list of potion effects being applied
     */
    default ListValue.Mutable<PotionEffect> effects() {
        return this.requireValue(Keys.POTION_EFFECTS).asMutable();
    }
}
