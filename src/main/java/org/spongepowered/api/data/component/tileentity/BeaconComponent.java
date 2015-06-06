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
package org.spongepowered.api.data.component.tileentity;

import com.google.common.base.Optional;
import org.spongepowered.api.block.tileentity.carrier.Beacon;
import org.spongepowered.api.data.Component;
import org.spongepowered.api.potion.PotionEffectType;

/**
 * Represents the information for a {@link Beacon}.
 */
public interface BeaconComponent extends Component<BeaconComponent> {

    /**
     * Gets the primary effect provided by this beacon.
     *
     * @return The primary effect
     */
    Optional<PotionEffectType> getPrimaryEffect();

    /**
     * Sets the primary effect for this beacon.
     *
     * @param effect The new primary effect
     * @return This instance, for chaining
     */
    BeaconComponent setPrimaryEffect(PotionEffectType effect);

    /**
     * Gets the secondary effect provided by this beacon.
     *
     * @return The secondary effect
     */
    Optional<PotionEffectType> getSecondaryEffect();

    /**
     * Sets the secondary effect for this beacon.
     *
     * @param effect The new secondary effect
     * @return This instance, for chaining
     */
    BeaconComponent setSecondaryEffect(PotionEffectType effect);

    /**
     * Clears all selected potion effects for this beacon.
     *
     * @return This instance, for chaining
     */
    BeaconComponent clearEffects();

}
