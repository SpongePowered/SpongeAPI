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

import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.ExperienceOrb;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;

/**
 * Handles when one or more {@link ExperienceOrb} are about to be
 * "dropped" onto the ground. This will happen before they are physically
 * dropped, let alone spawned.
 */
public interface DropExperienceEvent extends Event, Cancellable {

    /**
     * Gets the original experience unmodified by event changes.
     *
     * @return The experience
     */
    int getOriginalExperience();

    /**
     * Gets the new amount of experience.
     *
     * @return The new amount of experience
     */
    int getExperience();

    /**
     * Sets the new amount of experience.
     *
     * @param experience The new amount of experience to change to
     */
    void setExperience(int experience);

    /**
     * An event that is fired when a block drop experience on when broken
     */
    interface TargetBlock extends DropExperienceEvent {

        /**
         * Gets the {@link BlockSnapshot}.
         *
         * @return The block snapshot
         */
        BlockSnapshot getBlockSnapshot();

    }

    /**
     * An event that is fired when an entity drop experience on its death
     */
    interface TargetEntity extends DropExperienceEvent {

        /**
         * Gets the {@link Entity}.
         *
         * @return The entity
         */
        Entity getEntity();

    }

}
