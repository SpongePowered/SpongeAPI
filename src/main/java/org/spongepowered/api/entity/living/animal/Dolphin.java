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
import org.spongepowered.api.entity.living.Aquatic;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSources;

public interface Dolphin extends Aquatic {

    /**
     * Gets a {@link Value} representing the skin moisture of a {@link Dolphin}.
     *
     * <p>
     *     Vanilla sets the dolphin's skin moisture to 2400 so long as the entity
     *     is in water, being rained on, or in a bubble column. If not, the dolphin
     *     will loose 1 moisture per tick. Once this value is 0 or below, the dolphin
     *     will be damaged via {@link DamageSources#DRYOUT} with a value of 1 per tick
     *     until death.
     * </p>
     * @return The skin moisture value
     */
    default Value.Mutable<Integer> skinMoisture() {
        return this.getValue(Keys.SKIN_MOISTURE).get().asMutable();
    }

    /**
     * Gets a {@link Value} representing if a {@link Dolphin} has a fish.
     *
     * <p>
     *     Dolphins will navigate to a treasure (if a structure that provides one is nearby)
     *     if they have been given a fish.
     * </p>
     * @return The got fish value
     */
    default Value.Mutable<Boolean> gotFish() {
        return this.getValue(Keys.GOT_FISH).get().asMutable();
    }
}
