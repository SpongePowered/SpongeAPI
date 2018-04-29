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
package org.spongepowered.api.event.entity;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.immutable.entity.ImmutableExperienceHolderData;
import org.spongepowered.api.data.manipulator.mutable.entity.ExperienceHolderData;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.util.annotation.eventgen.AbsoluteSortPosition;
import org.spongepowered.api.util.annotation.eventgen.PropertySettings;

/**
 * An event that is related to experience.
 */
public interface ChangeEntityExperienceEvent extends TargetEntityEvent, Cancellable {

    @Override
    Player getTargetEntity();

    /**
     * Gets the original experience unmodified by event changes.
     *
     * @return The experience
     */
    @PropertySettings(generateMethods = false, requiredParameter = false)
    @Deprecated
    default int getOriginalExperience() {
        return getOriginalData().totalExperience().get();
    }

    /**
     * Gets the original values for the experience unmodified by event changes.
     *
     * @return The experience data
     */
    @AbsoluteSortPosition(1)
    ImmutableExperienceHolderData getOriginalData();

    /**
     * Gets the original experience unmodified by event changes.
     *
     * @return The experience
     */
    @PropertySettings(generateMethods = false, requiredParameter = false)
    @Deprecated
    default int getExperience() {
        return getFinalData().totalExperience().get();
    }

    /**
     * Gets the original experience unmodified by event changes.
     *
     * @return The experience
     */
    @PropertySettings(generateMethods = false, requiredParameter = false)
    @Deprecated
    default void setExperience(int experience) {
        getFinalData().set(Keys.TOTAL_EXPERIENCE, experience);
    }

    /**
     * Gets the experience after an event has been processed. Modify this
     * data manipulator to change the final experience.
     *
     * @return The experience to receive
     */
    @AbsoluteSortPosition(2)
    ExperienceHolderData getFinalData();

}
