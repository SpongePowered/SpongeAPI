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
import org.spongepowered.api.data.type.PandaGene;
import org.spongepowered.api.data.type.PandaGenes;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.weather.Weather;
import org.spongepowered.api.world.weather.Weathers;

/**
 * Represents a Panda.
 */
public interface Panda extends Animal, Sittable {

    /**
     * {@link Keys#KNOWN_GENE}
     * @return Whether this panda has a known gene
     */
    default Value.Mutable<PandaGene> knownGene() {
        return this.getValue(Keys.KNOWN_GENE).get().asMutable();
    }

    /**
     * {@link Keys#HIDDEN_GENE}
     * @return Whether this panda has a hidden gene
     */
    default Value.Mutable<PandaGene> hiddenGene() {
        return this.getValue(Keys.HIDDEN_GENE).get().asMutable();
    }

    /**
     * {@link Keys#IS_LYING_ON_BACK}
     * @return The time remaining to lie on it's back
     */
    default Value.Mutable<Boolean> lyingOnBack() {
        return this.getValue(Keys.IS_LYING_ON_BACK).get().asMutable();
    }

    /**
     * {@link Keys#IS_ROLLING_AROUND}
     * @return The time remaining to roll around
     */
    default Value.Mutable<Boolean> rollingAround() {
        return this.getValue(Keys.IS_ROLLING_AROUND).get().asMutable();
    }

    /**
     * {@link Keys#UNHAPPY_TIME}
     * @return The time remaining to be unhappy
     */
    default Value.Mutable<Integer> unhappyTime() {
        return this.getValue(Keys.UNHAPPY_TIME).get().asMutable();
    }

    /**
     * {@link Keys#IS_UNHAPPY}
     *
     * <p>Being happy or unhappy affects the panda's ability to
     * produce offspring or sit down.</p>
     *
     * <p>When offering the unhappy state in vanilla. If the value is false,
     * the unhappy time will be set to 0. Otherwise 32.</p>
     *
     * @return Whether the panda is unhappy
     */
    default Value.Mutable<Boolean> unhappy() {
        return this.getValue(Keys.IS_UNHAPPY).get().asMutable();
    }

    /**
     * {@link Keys#EATING_TIME}
     * @return The eating time
     */
    default Value.Mutable<Integer> eatingTime() {
        return this.getValue(Keys.EATING_TIME).get().asMutable();
    }

    /**
     * {@link Keys#IS_EATING}
     *
     * @return Whether the panda is eating
     */
    default Value.Mutable<Boolean> eating() {
        return this.getValue(Keys.IS_EATING).get().asMutable();
    }

    /**
     * {@link Keys#IS_SNEEZING}
     * @return Whether this panda is sneezing
     */
    default Value.Mutable<Boolean> sneezing() {
        return this.getValue(Keys.IS_SNEEZING).get().asMutable();
    }

    /**
     * {@link Keys#SNEEZING_TIME}
     * @return The sneezing time
     */
    default Value.Mutable<Integer> sneezingTime() {
        return this.getValue(Keys.SNEEZING_TIME).get().asMutable();
    }

    /**
     * {@link Keys#IS_FRIGHTENED}
     *
     * @return Whether this panda is frightened
     */
    default Value.Mutable<Boolean> frightened() {
        return this.getValue(Keys.IS_FRIGHTENED).get().asMutable();
    }
}
