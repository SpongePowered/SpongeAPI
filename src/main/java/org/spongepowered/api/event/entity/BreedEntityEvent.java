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

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Ageable;
import org.spongepowered.api.event.TristateResult;

/**
 * Represents an event when two {@link Ageable} entities come together
 * to attempt to produce offspring.
 */
public interface BreedEntityEvent extends InteractEntityEvent {

    /**
     * Called when an {@link Entity} finds an {@link Entity} to mate with.
     * 
     * If {@link org.spongepowered.api.event.TristateResult.Result#ALLOW},
     * bypasses normal handling to force mate with {@link Entity}.
     */
    interface FindMate extends BreedEntityEvent, InteractEntityEvent, TristateResult {}

    /**
     * Called when an {@link Entity} begins to breed with an {@link Entity}.
     */
    interface Breed extends BreedEntityEvent, InteractEntityEvent {

        /**
         * Gets the offspring {@link Entity}.
         * 
         * @return the offspring entity
         */
        Ageable getOffspringEntity();
    }

}
