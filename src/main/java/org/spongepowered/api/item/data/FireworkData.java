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
package org.spongepowered.api.item.data;

import org.spongepowered.api.item.FireworkEffect;

/**
 * Represents data specific to fireworks.
 */
public interface FireworkData extends ListItemData<FireworkEffect, FireworkData> {

    /**
     * Gets the flight modifier for this firework.
     *
     * <p>Flight modifiers are tiered ranks of flight duration. Generally,
     * the modifier is used to calculate the fuse time of a firework when
     * launched. This can be approximated by multiplying 10 and the modifier,
     * and adding a random number between 0 and 13. Again, this is a general
     * approximation of what vanilla Minecraft performs.</p>
     *
     * @return The flight modifier
     */
    int getFlightModifier();

    /**
     * Sets the flight modifier for this firework.
     *
     * <p>Flight modifiers are tiered ranks of flight duration. Generally,
     * the modifier is used to calculate the fuse time of a firework when
     * launched. This can be approximated by multiplying 10 and the modifier,
     * and adding a random number between 0 and 13. Again, this is a general
     * approximation of what vanilla Minecraft performs.</p>
     *
     * @param flightModifier The flight modifier
     */
    void setFlightModifier(int flightModifier);
}
