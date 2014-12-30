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
package org.spongepowered.api.entity.living;

import com.google.common.base.Optional;
import org.spongepowered.api.entity.Tamer;

/**
 * Represents an Agent that can be tamed by a Tamer.
 */
public interface Tameable extends Agent {

    /**
     * Checks if this is tamed
     * <p>If something is tamed then no other tamer is able to tame this
     * entity through normal methods.</p>
     *
     * @return True if this has been tamed
     */
    boolean isTamed();

    /**
     * Sets if this has been tamed. Not necessary if the method setOwner has
     * been used, as it tames automatically.
     * <p>If something is tamed then no other tamer is able to tame this
     * entity through normal methods.</p>
     *
     * @param tame True if tame
     */
    void setTamed(boolean tame);

    /**
     * Gets the current owning Tamer.
     *
     * @return The tamer, if available
     */
    Optional<Tamer> getOwner();

    /**
     * Sets this to be owned by given {@link Tamer}.
     * <p>If the tamer is null, this entity will become untamed and become
     * tameable by other tamers.</p>
     *
     * @param tamer The Tamer who should own this
     */
    void setOwner(Tamer tamer);

}
