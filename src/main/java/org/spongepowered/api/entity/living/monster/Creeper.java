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

package org.spongepowered.api.entity.living.monster;

import org.spongepowered.api.entity.living.Monster;

/**
 * Represents a Creeepr.
 */
public interface Creeper extends Monster {

    /**
     * Gets whether or not the creeper has been struck by lightning.
     *
     * @return If the creeper is powered
     */
    boolean isPowered();

    /**
     * Sets whether or not the creeper has been struck by lightning.
     *
     * @param powered If the creeper should be powered
     */
    void setPowered(boolean powered);

    /**
     * Gets the explosion radius of this creeper.
     *
     * @return The explosion radius of this creeper
     */
    int getExplosionRadius();

    /**
     * Sets the explosion radius of this creeper.
     *
     * @param radius The explosion radius of this creeper
     */
    void setExplosionRadius(int radius);
}
