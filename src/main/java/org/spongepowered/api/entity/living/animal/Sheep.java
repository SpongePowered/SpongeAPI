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

package org.spongepowered.api.entity.living.animal;

import org.spongepowered.api.entity.living.Dyeable;

/**
 * Represents a Sheep.
 */
public interface Sheep extends Animal, Dyeable {

    /**
     * Returns whether this sheep is sheared or not.
     * <p>A sheared sheep may not return a wool block from shearing.
     * It may also attempt to consume a grass block to grow back its fur.</p>
     *
     * @return True if this sheep has been sheared
     */
    boolean isSheared();

    /**
     * Sets whether this sheep is sheared or not.
     * <p>A sheared sheep may not return a wool block from shearing.
     * It may also attempt to consume a grass block to grow back its fur.</p>
     *
     * @param sheared Whether this sheep is sheared or not
     */
    void setSheared(boolean sheared);

}
