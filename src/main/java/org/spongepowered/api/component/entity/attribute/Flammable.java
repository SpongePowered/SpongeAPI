/**
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
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
package org.spongepowered.api.component.entity.attribute;

import org.spongepowered.api.component.entity.EntityComponent;

/**
 * Gives the attribute "flammable" to an {@link org.spongepowered.api.entity.Entity Entity}.
 */
public interface Flammable extends EntityComponent {
    /**
     * Gets the remaining time for an {@link org.spongepowered.api.entity.Entity Entity} to be on
     * fire.
     * @return The duration in ticks
     */
    int getDuration();

    /**
     * Checks to see if {@link org.spongepowered.api.entity.Entity Entity} is on fire.
     * @return true If {@link #getDuration()} is greater than 0
     */
    boolean isBurning();

    /**
     * Sets the remaining time for an {@link org.spongepowered.api.entity.Entity Entity} to be on
     * fire. If {@link #isBurning()} is true
     * @param ticks The amount to set
     */
    void setDuration(int ticks);
}
