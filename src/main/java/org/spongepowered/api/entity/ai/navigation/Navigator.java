/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
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
package org.spongepowered.api.entity.ai.navigation;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.mutable.entity.AgentData;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

/**
 * A navigator allows an {@link Agent} finding a route when executing
 * {@link AITask AI tasks}.
 */
public interface Navigator {

    /**
     * Gets the agent which this navigator belongs to.
     *
     * @return The owner of the navigator
     */
    Agent getOwner();

    /**
     * Gets the speed for following along the current route.
     *
     * <p>It will be multiplied by entity attribute modifiers.</p>
     *
     * @return The speed value
     */
    double getSpeed();

    /**
     * Sets the speed for following along the current route.
     *
     * <p>It will be multiplied by entity attribute modifiers.</p>
     *
     * @param speed The new speed value
     */
    void setSpeed(double speed);

    /**
     * Navigates to a block position.
     *
     * <p>Once set, the navigator will continuously try to
     * guide the agent to this location.</p>
     *
     * @param target The target location
     */
    void navigate(Location<World> target);

    /**
     * Navigates to an entity.
     *
     * <p>The actual target location is the bottom center of
     * the entity's bounding box.</p>
     *
     * <p>Once set, the navigator will continuously try to
     * guide the agent to the location of the target when this
     * method is called: the location does not automatically update.</p>
     *
     * @param target The target entity
     * @see #navigate(Location)
     */
    void navigate(Entity target);

    /**
     * Gets the current search range of the navigator.
     *
     * <p>This value is calculated after attributed modifiers are applied.</p>
     *
     * <p>The original value can be set with {@link AgentData#followRange()}.</p>
     *
     * @return The current search range
     * @see Keys#FOLLOW_RANGE
     * @see AgentData#followRange()
     */
    double getFollowRange();

}
