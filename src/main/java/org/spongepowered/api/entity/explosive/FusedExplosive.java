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
package org.spongepowered.api.entity.explosive;

/**
 * Represents an explosive that detonates after its fuse has expired.
 */
public interface FusedExplosive extends Explosive {

    /**
     * Ignites this explosive to detonate after some fuse duration in ticks.
     */
    void ignite();

    /**
     * Ignites this explosive to detonate after the given fuse ticks.
     *
     * @param fuseTicks The ticks to set the fuse
     */
    void ignite(int fuseTicks);

    /**
     * Gets the current fuse duration in ticks on this explosive.
     * <p>After the fuse duration diminishes to zero, explosive entities
     * may explode.</p><p>If the fuse duration is set to negative,
     * the explosive may become idle.</p>
     *
     * @return The current fuse duration in ticks
     */
    int getFuseDuration();

    /**
     * Sets the remainig fuse duration in ticks on this explosive.
     * <p>After the fuse duration diminishes to zero, explosive entities
     * may explode.</p><p>If the fuse duration is set to negative,
     * the explosive may become idle.</p>
     *
     * @param fuseTicks The ticks for the fuse
     */
    void setFuseDuration(int fuseTicks);

}
