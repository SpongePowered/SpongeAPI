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
package org.spongepowered.api.data.manipulator.mutable.tileentity;

import org.spongepowered.api.block.tileentity.carrier.Beacon;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.immutable.tileentity.ImmutableBeaconData;
import org.spongepowered.api.data.value.mutable.OptionalValue;
import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.entity.Entity;

import java.util.Optional;

/**
 * An {@link DataManipulator} handling the data for a {@link Beacon},
 * usually applicable to the {@link PotionEffectType}s being applied to
 * {@link Entity} instances in the region around the {@link Beacon}.
 */
public interface BeaconData extends DataManipulator<BeaconData, ImmutableBeaconData> {

    /**
     * Gets the {@link OptionalValue} for the primary
     * {@link PotionEffectType}.
     *
     * @return The optional value for the primary potion effect
     * @see Keys#BEACON_PRIMARY_EFFECT
     */
    OptionalValue<PotionEffectType> primaryEffect();

    /**
     * Gets the {@link OptionalValue} for the secondary
     * {@link PotionEffectType}.
     *
     * @return The optional value for the secondary potion effect
     * @see Keys#BEACON_SECONDARY_EFFECT
     */
    OptionalValue<PotionEffectType> secondaryEffect();

    /**
     * Fills the primary and secondary {@link PotionEffectType}s
     * with {@link Optional#empty()} values as a semi "reset" state.
     *
     * @return This instance, for chaining
     */
    BeaconData clearEffects();

}
