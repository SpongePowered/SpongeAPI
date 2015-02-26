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
package org.spongepowered.api.event.entity;

import org.spongepowered.api.entity.explosive.Explosive;
import org.spongepowered.api.util.event.Cancellable;

/**
 * Represents an event when an {@link Explosive} is about to explode.
 *
 * <p>Explosions usually affect a radius and ignite, depending on the explosion.</p>
 */
public interface ExplosionPrimeEvent extends EntityEvent, Cancellable {

    /**
     * Gets the explosive radius that the {@link Explosive} will affect.
     *
     * @return The radius of effect
     */
    double getRadius();

    /**
     * Sets the explosion radius.
     *
     * @param radius The explosion radius
     */
    void setRadius(double radius);

    /**
     * Gets whether the explosion will ignite ignitable blocks.
     *
     * <p>Blocks that may be ignited include logs, leaves, wool, etc.</p>
     *
     * @return Whether this explosion is flammable
     */
    boolean isFlammable();

    /**
     * Sets whether this explosion will be flammable or not.
     *
     * <p>Blocks that may be ignited include logs, leaves, wool, etc.</p>
     *
     * @param flammable Whether this explosion is flammable
     */
    void setFlammable(boolean flammable);

}
