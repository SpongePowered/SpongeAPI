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
import org.spongepowered.api.data.value.BoundedValue;
import org.spongepowered.api.data.value.ListValue;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.effect.particle.ParticleEffect;
import org.spongepowered.api.effect.particle.ParticleType;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.util.Color;

/**
 * Represents an AreaEffectCloud. The cloud will apply {@link PotionEffect}s to
 * {@link Entity} instances within it's bounding box.
 */
public interface AreaEffectCloud extends Entity {

    /**
     * {@link Keys#AREA_EFFECT_CLOUD_COLOR}
     * @return The color of this cloud
     */
    default Value.Mutable<Color> color() {
        return this.getValue(Keys.AREA_EFFECT_CLOUD_COLOR.get()).get().asMutable();
    }

    /**
     * {@link Keys#AREA_EFFECT_CLOUD_RADIUS}
     * @return The initial radius of this cloud
     */
    default BoundedValue.Mutable<Double> radius() {
        return this.getValue(Keys.AREA_EFFECT_CLOUD_RADIUS.get()).get().asMutable();
    }

    /**
     * {@link Keys#AREA_EFFECT_CLOUD_PARTICLE_EFFECT}
     * @return The particle type
     * @see org.spongepowered.api.effect.particle.ParticleTypes
     */
    default Value.Mutable<ParticleEffect> particleEffect() {
        return this.getValue(Keys.AREA_EFFECT_CLOUD_PARTICLE_EFFECT.get()).get().asMutable();
    }

    /**
     * {@link Keys#AREA_EFFECT_CLOUD_DURATION}
     * @return The duration of which this cloud will linger
     */
    default BoundedValue.Mutable<Integer> duration() {
        return this.getValue(Keys.AREA_EFFECT_CLOUD_DURATION.get()).get().asMutable();
    }

    /**
     * {@link Keys#AREA_EFFECT_CLOUD_WAIT_TIME}
     * @return The wait time before applying to an entity
     */
    default BoundedValue.Mutable<Integer> waitTime() {
        return this.getValue(Keys.AREA_EFFECT_CLOUD_WAIT_TIME.get()).get().asMutable();
    }

    /**
     * {@link Keys#AREA_EFFECT_CLOUD_RADIUS_ON_USE}
     * @return The radius decrease per use
     */
    default BoundedValue.Mutable<Double> radiusOnUse() {
        return this.getValue(Keys.AREA_EFFECT_CLOUD_RADIUS_ON_USE.get()).get().asMutable();
    }

    /**
     * {@link Keys#AREA_EFFECT_CLOUD_RADIUS_PER_TICK}
     * @return The radius decrease per tick
     */
    default BoundedValue.Mutable<Double> radiusPerTick() {
        return this.getValue(Keys.AREA_EFFECT_CLOUD_RADIUS_PER_TICK.get()).get().asMutable();
    }

    /**
     * {@link Keys#AREA_EFFECT_CLOUD_DURATION_ON_USE}
     * @return The duration of the potion effects when an entity gets a potion applied
     */
    default BoundedValue.Mutable<Integer> durationOnUse() {
        return this.getValue(Keys.AREA_EFFECT_CLOUD_DURATION_ON_USE.get()).get().asMutable();
    }

    /**
     * {@link Keys#AREA_EFFECT_CLOUD_REAPPLICATION_DELAY}
     * @return The delay for an entity to have a potion effect applied while standing in this cloud
     */
    default BoundedValue.Mutable<Integer> applicationDelay() {
        return this.getValue(Keys.AREA_EFFECT_CLOUD_REAPPLICATION_DELAY.get()).get().asMutable();
    }

    /**
     * {@link Keys#POTION_EFFECTS}
     * @return The list of potion effects being applied
     */
    default ListValue.Mutable<PotionEffect> effects() {
        return this.getValue(Keys.POTION_EFFECTS.get()).get().asMutable();
    }

    /**
     * {@link Keys#AREA_EFFECT_CLOUD_AGE}
     * @return The age of this cloud
     */
    default BoundedValue.Mutable<Integer> age() {
        return this.getValue(Keys.AREA_EFFECT_CLOUD_AGE.get()).get().asMutable();
    }

}
