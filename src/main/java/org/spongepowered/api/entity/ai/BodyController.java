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

package org.spongepowered.api.entity.ai;

import org.spongepowered.api.entity.Entity;

import com.flowpowered.math.vector.Vector2f;
import com.flowpowered.math.vector.Vector2i;
import com.flowpowered.math.vector.Vector3d;

/**
 * Represents a body controller that can be used to control the body's movement
 * of the associated {@link Entity}.
 */
public interface BodyController {

    public static final Vector2f DEFAULTROTATIONSPEED = new Vector2f(Math.PI / 6, Math.PI / 6);
    public static final double DEFAULTMOVEMENTSPEED = 1;

    /**
     * Gets the {@link Entity} that is controlled by this movement controller.
     *
     * @return The entity that is controlled by this AI handler
     */
    AIControlled getAIControlled();

    /**
     * @return True, if the path finder should avoid water.
     */
    public boolean getAvoidsWater();

    /**
     * Sets whether the path finder should avoid water.
     *
     * @param avoidWater Whether the path finder should avoid water
     */
    public void setAvoidsWater(boolean avoidWater);

    /**
     * Sets whether the path finder should avoid sun light.
     *
     * @return Whether the path finder should avoid sun light
     */
    public boolean getAvoidSun();

    /**
     * Sets whether the path finder should avoid sun light.
     *
     * @param avoidSun Whether the path finder should avoid sun light
     */
    public void setAvoidSun(boolean avoidSun);

    /**
     * @return True, if the entity can break doors. False otherwise.
     */
    public boolean getCanBreakDoors();

    /**
     * Sets whether the entity can break doors.
     *
     * @param breakDoors Whether the entity can break doors
     */
    public void setBreakDoors(boolean breakDoors);

    /**
     * Gets whether the entity can open doors.
     *
     * @return Whether the entity can open doors
     */
    public boolean getCanOpenDoors();

    /**
     * Sets whether the entity can open doors.
     *
     * @param openDoors Whether the entity can open doors
     */
    public void setCanOpenDoors(boolean openDoors);

    /**
     * Sets the speed used to reach the current target.<br>
     * This value will be overwritten with the next target specification.
     *
     * @param speed The speed used to reach the current target
     */
    public void setSpeed(double speed);

    /**
     * Sets whether the entity can swim.
     *
     * @param canSwin Whether the entity can swim
     */
    public void setCanSwim(boolean canSwin);

    /**
     * Checks whether this entity has a path to his target.
     *
     * @return True, if the entity has a path and has not finished reaching its
     *         target. False otherwise
     */
    public boolean hasPath();

    /**
     * Try to find and set a path to the given target location.
     *
     * @param target The target the entity should move to
     * @param speed The entity's movement speed
     * @return True, if a path to the given target was found and will be
     *         executed
     */
    public boolean tryMoveTo(Vector3d target, double speed);

    /**
     * Try to find and set a path to the given target entity.
     *
     * @param target The target the entity should move to
     * @param speed The entity's movement speed
     * @return True, if a path to the given target was found and will be
     *         executed
     */
    public boolean tryMoveTo(Entity target, double speed);

    /**
     * Clears the current movement target.
     */
    public void clearPath();

    /**
     * Let the entity jump if possible.
     */
    public void jump();

    /**
     * Look at the given target location.
     *
     * @param target The target location to look at
     * @param rotationSpeed The rotation speed
     * @see #DEFAULTROTATIONSPEED
     */
    public void lookAt(Vector3d target, Vector2f rotationSpeed);

    /**
     * Look at the given target entity.
     *
     * @param target The target entity to look at
     * @param rotationSpeed The rotation speed
     * @see #DEFAULTROTATIONSPEED
     */
    public void lookAt(Entity target, Vector2f rotationSpeed);

    /**
     * Look in the given direction.
     *
     * @param direction The direction to look in
     * @param rotationSpeed The rotation speed
     * @see #DEFAULTROTATIONSPEED
     */
    public void lookInDirection(Vector2f direction, Vector2f rotationSpeed);

    /**
     * Look in the given direction.
     *
     * @param direction The direction to look in
     * @param rotationSpeed The rotation speed
     * @see #DEFAULTROTATIONSPEED
     */
    public void lookInDirection(Vector3d direction, Vector2f rotationSpeed);

    /**
     * Searches for a random location next to the controlled entity within the
     * given radius.
     * <p>
     * This method utilizes minecraft's RandomPositionGenerator.
     * </p>
     *
     * @param offset The maximum offset for the location
     * @return The random location the entity could try moving to
     */
    public Vector3d randomLocation(Vector2i offset);

}
