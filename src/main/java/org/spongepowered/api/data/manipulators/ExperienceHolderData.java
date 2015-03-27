/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.data.manipulators;

import org.spongepowered.api.data.DataManipulator;

public interface ExperienceHolderData extends DataManipulator<ExperienceHolderData> {

    /**
     * Gets the current experience accumulated since the last level-up.
     *
     * <p>This is not the total experience this human has.</p>
     *
     * @return The current experience accumulated since the last level-up.
     */
    int getExperienceSinceLevel();

    /**
     * Sets the experience accumulated since the last level-up.
     *
     * <p>This is not the total experience this human has.</p>
     *
     * @param experience The experience accumulated since the last level-up.
     */
    void setExperienceSinceLevel(int experience);

    /**
     * Gets the experience required since the last level to level up.
     *
     * <p>For example, if level 14 reqiures 280 experience points, level 15
     * requires 315, and the player is at level 14, this method will return
     * 35.</p>
     *
     * @return the experience required since the last level to level up
     */
    int getExperienceBetweenLevels();

    /**
     * Gets the current experience level of this human.
     *
     * @return The current level
     */
    int getLevel();

    /**
     * Sets the level of experience.
     *
     * @param level The level of experience
     */
    void setLevel(int level);

    /**
     * Gets the total accumulated experience this human has, including
     * the experience to achieve the current experience level and the
     * experienced gained towards the next level.
     *
     * @return The current total accumulated experience
     */
    int getTotalExperience();

    /**
     * Sets the total accumulated experience starting from zero.
     *
     * @param totalExperience The total experience
     */
    void setTotalExperience(int totalExperience);

}
