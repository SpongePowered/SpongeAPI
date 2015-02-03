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
import org.spongepowered.api.entity.Entity;

import javax.annotation.Nullable;

/**
 * Leashables are entities that can be interacted with by players wielding a {@link org.spongepowered.api.item.ItemTypes#LEAD}
 */
public interface Leashable {

    /**
     * Returns whether this Leashable is leashed.
     *
     * @return True if this Leashable is leashed
     */
    boolean isLeashed();

    /**
     * Sets whether this Leashable is leashed or not.
     *
     * @param leashed Whether this Leashable is leashed or not
     */
    void setLeashed(boolean leashed);

    /**
     * Gets the holder of this leashed entity, if available.
     *
     * @return The leash holder, if available
     */
    Optional<Entity> getLeashHolder();

    /**
     * Sets the holder of this leashed entity.
     *
     * @param entity The entity to hold the leash
     */
    void setLeashHolder(@Nullable Entity entity);

}
