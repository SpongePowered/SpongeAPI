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
public interface Panda extends Animal {

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
     * {@link Keys#IS_SITTING}
     * @return Whether this panda is sitting
     */
    default Value.Mutable<Boolean> sitting() {
        return this.getValue(Keys.IS_SITTING).get().asMutable();
    }

    /**
     * {@link Keys#IS_SNEEZING}
     * @return Whether this panda is sneezing
     */
    default Value.Mutable<Boolean> sneezing() {
        return this.getValue(Keys.IS_SNEEZING).get().asMutable();
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
     * {@link Keys#EATING_TIME}
     * @return The eating time
     */
    default Value.Mutable<Integer> eatingTime() {
        return this.getValue(Keys.EATING_TIME).get().asMutable();
    }

    /**
     * {@link Keys#SNEEZING_TIME}
     * @return The sneezing time
     */
    default Value.Mutable<Integer> sneezingTime() {
        return this.getValue(Keys.SNEEZING_TIME).get().asMutable();
    }

    /**
     * Determines if the panda is currently eating. In vanilla, this is {@link Panda#unhappyTime()} &gt; 0. Affects their ability to produce
     * offspring or sit down.
     *
     * {@link Panda#unhappyTime()}
     *
     * @return True if unhappy, false if not
     */
    boolean isUnhappy();

    /**
     * Instructs the panda to be unhappy or not. In vanilla, if false, this will set the {@link Panda#unhappyTime()} to 0. Otherwise 32.
     * @param unhappy Whether this is an unhappy panda
     */
    void setUnhappy(boolean unhappy);

    /**
     * Determines if the panda is currently eating. In vanilla, this is {@link Panda#eatingTime()} &gt; 0.
     *
     * {@link Panda#eatingTime()}
     *
     * @return True if eating, false if not
     */
    boolean isEating();

    /**
     * Instructs the panda to eat or not. In vanilla, if true, this will set the {@link Panda#eatingTime()} to 1. Otherwise 0.
     *
     * {@link Panda#eatingTime()}
     * @param eating Whether to be eating or not
     */
    void setEating(boolean eating);

    /**
     * Determines if the panda is currently sneezing. In vanilla, this is {@link Panda#sneezingTime()} &gt;= 0.
     *
     * @return True if sneezing, false if not
     */
    boolean isSneezing();

    /**
     * Instructs the panda to sneeze or not. In vanilla, if true, this will set {@link Panda#sneezing()} to true and {@link Panda#sneezingTime()}
     * to 0. Otherwise if the panda was sneezing, the sneezingTime will be set to 20 and if not will be set to 0.
     * @param sneeze Whether this panda is sneezing
     */
    void setSneezing(boolean sneeze);

    /**
     * Gets if the panda is currently frightened. In vanilla, pandas that have a {@link Panda#knownGene()}
     * of {@link PandaGenes#WORRIED} and are in a {@link World} whose {@link Weather} is currently a
     * {@link Weathers#THUNDER_STORM} are considered "frightened".
     *
     * @return True if frightened, false if not
     */
    boolean isFrightened();
}
