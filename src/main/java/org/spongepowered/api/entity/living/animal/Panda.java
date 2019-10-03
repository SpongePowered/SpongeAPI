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
     */
    default Value.Mutable<PandaGene> knownGene() {
        return this.getValue(Keys.KNOWN_GENE).get().asMutable();
    }

    /**
     * {@link Keys#HIDDEN_GENE}
     */
    default Value.Mutable<PandaGene> hiddenGene() {
        return this.getValue(Keys.HIDDEN_GENE).get().asMutable();
    }

    /**
     * {@link Keys#IS_SITTING}
     */
    default Value.Mutable<Boolean> sitting() {
        return this.getValue(Keys.IS_SITTING).get().asMutable();
    }

    /**
     * {@link Keys#IS_SNEEZING}
     */
    default Value.Mutable<Boolean> sneezing() {
        return this.getValue(Keys.IS_SNEEZING).get().asMutable();
    }

    /**
     * {@link Keys#IS_LYING_ON_BACK}
     */
    default Value.Mutable<Boolean> lyingOnBack() {
        return this.getValue(Keys.IS_LYING_ON_BACK).get().asMutable();
    }

    /**
     * {@link Keys#IS_ROLLING_AROUND}
     */
    default Value.Mutable<Boolean> rollingAround() {
        return this.getValue(Keys.IS_ROLLING_AROUND).get().asMutable();
    }

    /**
     * {@link Keys#UNHAPPY_TIME}
     */
    default Value.Mutable<Integer> unhappyTime() {
        return this.getValue(Keys.UNHAPPY_TIME).get().asMutable();
    }

    /**
     * {@link Keys#EATING_TIME}
     */
    default Value.Mutable<Integer> eatingTime() {
        return this.getValue(Keys.EATING_TIME).get().asMutable();
    }

    /**
     * {@link Keys#SNEEZING_TIME}
     */
    default Value.Mutable<Integer> sneezingTime() {
        return this.getValue(Keys.SNEEZING_TIME).get().asMutable();
    }

    /**
     * Determines if the panda is currently eating. In vanilla, this is {@link Panda#unhappyTime()} > 0. Affects their ability to produce
     * offspring or sit down.
     *
     * {@link Panda#unhappyTime()}
     *
     * @return True if unhappy, false if not
     */
    boolean isUnhappy();

    /**
     * Instructs the panda to now be happy. In vanilla, this will set the {@link Panda#unhappyTime()} to 0.
     */
    void makeHappy();

    /**
     * Instructs the panda to now be un-happy. In vanilla, this will set the {@link Panda#unhappyTime()} to 32.
     */
    void makeUnhappy();

    /**
     * Determines if the panda is currently eating. In vanilla, this is {@link Panda#eatingTime()} > 0.
     *
     * {@link Panda#eatingTime()}
     *
     * @return True if eating, false if not
     */
    boolean isEating();

    /**
     * Instructs the panda to eat. In vanilla, this will set the {@link Panda#eatingTime()} to 1.
     *
     * {@link Panda#eatingTime()}
     */
    void eat();

    /**
     * Instructs the panda to stop eating. In vanilla, this will set the {@link Panda#eatingTime()} to 0.
     *
     * {@link Panda#eatingTime()}
     */
    void stopEating();

    /**
     * Determines if the panda is currently sneezing. In vanilla, this is {@link Panda#sneezingTime()} >= 0.
     *
     * @return True if sneezing, false if not
     */
    boolean isSneezing();

    /**
     * Instructs the panda to sneeze. In vanilla, this will set {@link Panda#sneezing()} to true and {@link Panda#sneezingTime()} to 0.
     */
    void sneeze();

    /**
     * Instructs the panda to stop sneezing. In vanilla, this will set {@link Panda#sneezing()} to false. If the panda was sneezing, this
     * will also set {@link Panda#sneezingTime()} to 20. Otherwise it will be set to 0.
     */
    void stopSneezing();

    /**
     * Gets if the panda is currently frightened. In vanilla, pandas that have a {@link Panda#knownGene()}
     * of {@link PandaGenes#WORRIED} and are in a {@link World} whose {@link Weather} is currently a
     * {@link Weathers#THUNDER_STORM} are considered "frightened".
     *
     * @return True if frightened, false if not
     */
    boolean isFrightened();
}
