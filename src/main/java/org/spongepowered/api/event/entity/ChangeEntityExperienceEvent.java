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
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.SpongeEventFactory;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.util.annotation.eventgen.AbsoluteSortPosition;
import org.spongepowered.api.util.annotation.eventgen.FactoryMethod;
import org.spongepowered.api.util.annotation.eventgen.PropertySettings;

/**
 * An event that is related to experience.
 */
public interface ChangeEntityExperienceEvent extends TargetEntityEvent, Cancellable {

    /**
     * Gets the original total experience unmodified by event changes.
     *
     * @return The experience
     * @deprecated Use {@link #getOriginalData()} instead, which provides more
     * information about the experience.
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
     * Gets the total experience after event changes.
     *
     * @return The experience
     * @deprecated Use {@link #getFinalData()} instead, which provides more
     * information about the experience.
     */
    @PropertySettings(generateMethods = false, requiredParameter = false)
    @Deprecated
    default int getExperience() {
        return getFinalData().totalExperience().get();
    }

    /**
     * Sets the final total experience after event changes.
     *
     * @param experience The experience
     * @deprecated Modify the value returned by {@link #getFinalData()}
     * instead, which provides more information about the experience.
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

    /**
     * This method exists solely to provide backwards-compatibility with existing plugins
     * using the old ChangeExperienceEvent. It should not be called directly - instead,
     * plugins should use {@link SpongeEventFactory#createChangeEntityExperienceEvent(Cause, ImmutableExperienceHolderData, ExperienceHolderData, Entity)}
     *
     * @param cause The cause to use
     * @param originalExperience The original experience amount
     * @param experience New experience amount
     * @param targetEntity The target entity
     * @return The event
     */
    @FactoryMethod
    @Deprecated
    static ChangeEntityExperienceEvent createChangeEntityExperienceEvent(Cause cause, int originalExperience, int experience, Entity targetEntity) {
        ExperienceHolderData finalData = targetEntity.getOrCreate(ExperienceHolderData.class)
                .orElseThrow(() -> new RuntimeException("Failed to get ExperienceHolderData from " + targetEntity));
        ImmutableExperienceHolderData originalData = finalData.asImmutable();
        originalData = originalData.with(Keys.TOTAL_EXPERIENCE, originalExperience).get();
        finalData.set(Keys.TOTAL_EXPERIENCE, experience);
        return SpongeEventFactory.createChangeEntityExperienceEvent(cause, originalData, finalData, targetEntity);
    }

}
