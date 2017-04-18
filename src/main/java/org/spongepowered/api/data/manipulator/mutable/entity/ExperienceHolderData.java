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
package org.spongepowered.api.data.manipulator.mutable.entity;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.immutable.entity.ImmutableExperienceHolderData;
import org.spongepowered.api.data.value.immutable.ImmutableBoundedValue;
import org.spongepowered.api.data.value.mutable.MutableBoundedValue;
import org.spongepowered.api.entity.living.Humanoid;

/**
 * Represents the "gained" experience information. Usually experience can be
 * used to enchant weapons and items. Usually applicable to {@link Humanoid}s.
 */
public interface ExperienceHolderData extends DataManipulator<ExperienceHolderData, ImmutableExperienceHolderData> {

    /**
     * Gets the {@link MutableBoundedValue}  for the amount of experience
     * gained since the beginning of the current {@link #level()}. Normally,
     * the higher the level, the more "experience" required to gain another
     * level.
     *
     * @return The bounded value of experience since the beginning of the
     *     current level
     * @see Keys#EXPERIENCE_SINCE_LEVEL
     */
    MutableBoundedValue<Integer> experienceSinceLevel();

    /**
     * Gets the {@link ImmutableBoundedValue} for the amount of experience
     * required between the current {@link #level()} and the next level.
     * This can be presumed to be the supposed "maximum" for the
     * {@link #experienceSinceLevel()} amount.
     *
     * @return The immutable bounded required experience between levels
     * @see Keys#EXPERIENCE_FROM_START_OF_LEVEL
     */
    ImmutableBoundedValue<Integer> getExperienceBetweenLevels();

    /**
     * Gets the {@link MutableBoundedValue} for the current "level" of
     * experience deserved according to the {@link #totalExperience()} and
     * a function from implementation defining how much experience required
     * per level.
     *
     * @return The current level according to the amount of total experience
     * @see Keys#EXPERIENCE_LEVEL
     */
    MutableBoundedValue<Integer> level();

    /**
     * Gets the total amount of experience stored.
     *
     * @return The value of total amount of experience
     * @see Keys#TOTAL_EXPERIENCE
     */
    MutableBoundedValue<Integer> totalExperience();

}
