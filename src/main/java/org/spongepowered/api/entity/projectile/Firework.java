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
package org.spongepowered.api.entity.projectile;

/**
 * Represents a firework.
 */
public interface Firework extends Projectile {

    /**
     * Detonates this firework.
     */
    void detonate();

    /**
     * Gets the current fuse time for this firework.
     * <p>Usually, after the fuse time passes the detonation time, the
     * firework will explode.</p>
     *
     * @return The current fuse time
     */
    int getFuseTime();

    /**
     * Sets the fuse time.
     * <p>Usually, after the fuse time passes the detonation time, the
     * firework will explode.</p>
     *
     * @param fusetime The new fuse time
     */
    void setFusetime(int fusetime);

    /**
     * Gets the detonation time limit.
     * <p>Usually, after the fuse time passes the detonation time, the
     * firework will explode.</p>
     *
     * @return The current max fuse time
     */
    int getDetonationTime();

    /**
     * Sets the detonation time limit.
     * <p>Usually, after the fuse time passes the detonation time, the
     * firework will explode.</p>
     *
     * @param detonationTime The new detonation time
     */
    void setDetonationTime(int detonationTime);

}
