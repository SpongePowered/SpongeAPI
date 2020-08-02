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
package org.spongepowered.api.block.entity.carrier;

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.effect.potion.PotionEffectType;

import java.util.Optional;

/**
 * Represents a Beacon.
 *
 * <p>Beacons apply prescribed effects according to the {@link Keys#PRIMARY_POTION_EFFECT_TYPE}.
 * Depending on the completed levels of the beacon, the effects may be applied
 * at a further range or shorter range.</p>
 */
public interface Beacon extends NameableCarrierBlockEntity {

    /**
     * Gets the number of completed levels of valid beacon structure blocks
     * beneath this beacon.
     *
     * @return The number of levels
     */
    int getCompletedLevels();

    /**
     * Gets the {@link org.spongepowered.api.data.value.Value.Mutable} for the primary
     * {@link PotionEffectType}.
     *
     * @return The optional value for the primary potion effect
     */
    default Optional<Value.Mutable<PotionEffectType>> primaryEffect() {
        return this.getValue(Keys.PRIMARY_POTION_EFFECT_TYPE).map(Value::asMutable);
    }

    /**
     * Gets the {@link org.spongepowered.api.data.value.Value.Mutable} for the secondary
     * {@link PotionEffectType}.
     *
     * @return The optional value for the secondary potion effect
     */
    default Optional<Value.Mutable<PotionEffectType>> secondaryEffect() {
        return this.getValue(Keys.SECONDARY_POTION_EFFECT_TYPE).map(Value::asMutable);
    }

}
