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
 * An Agent represents a {@link Living} that has AI.
 * In the future Sponge will allow for custom AIs, but for now vanilla behavior can only be disabled.
 */
public interface Agent extends Living {

    /**
     * Returns whether AI is currently enabled for this Agent.
     *
     * @return A boolean for whether AI is currently enabled
     */
    boolean isAiEnabled();

    /**
     * Sets whether AI is currently enabled for this Agent.
     *
     * @param aiEnabled True if AI should be enabled for this Agent
     */
    void setAiEnabled(boolean aiEnabled);

    /**
     * Returns whether this entity is leashed.
     *
     * @return True if this entity is leashed
     */
    boolean isLeashed();

    /**
     * Sets whether this entity is leashed or not.
     *
     * @param leashed Whether this entity is leashed or not
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

    /**
     * Returns whether this living entity can pick up items.
     *
     * @return Whether this entity can pick up items
     */
    boolean getCanPickupItems();

    /**
     * Sets whether this entity can pick up items or not.
     *
     * @param canPickupItems Whether this entity can pick up items
     */
    void setCanPickupItems(boolean canPickupItems);

    // TODO for 1.1 add methods like getTarget, setTarget, etc.
}
