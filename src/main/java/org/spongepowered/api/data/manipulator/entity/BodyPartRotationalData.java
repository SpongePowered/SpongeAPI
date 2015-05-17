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
package org.spongepowered.api.data.manipulator.entity;

import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.data.manipulator.MappedData;
import org.spongepowered.api.data.type.BodyPart;
import org.spongepowered.api.entity.living.ArmorStand;
import org.spongepowered.api.entity.living.Human;

/**
 * Represents the mapped rotational data for all known body parts. Usually
 * applicable to {@link Human}s and {@link ArmorStand}s.
 */
public interface BodyPartRotationalData extends MappedData<BodyPart, Vector3d, BodyPartRotationalData> {

    /**
     * Gets the direction the headpiece is aiming at.
     *
     * @return The direction the headpiece is aiming at
     */
    Vector3d getHeadDirection();

    /**
     * Sets the direction of the head.
     *
     * @param direction The direction of the head
     * @return This instance, for chaining
     */
    BodyPartRotationalData setHeadDirection(Vector3d direction);

    /**
     * Gets the direction the body is aiming at.
     *
     * @return The direction the body is aiming at
     */
    Vector3d getBodyRotation();

    /**
     * Sets the direction of the body.
     *
     * @param direction The direction of the body
     * @return This instance, for chaining
     */
    BodyPartRotationalData setBodyDirection(Vector3d direction);

    /**
     * Gets the direction the left arm is aiming at.
     *
     * @return The direction the left arm is aiming at
     */
    Vector3d getLeftArmDirection();

    /**
     * Sets the direction of the left arm.
     *
     * @param direction The direction of the left arm
     * @return This instance, for chaining
     */
    BodyPartRotationalData setLeftArmDirection(Vector3d direction);

    /**
     * Gets the direction the right arm is aiming at.
     *
     * @return The direction the right arm is aiming at
     */
    Vector3d getRightArmDirection();

    /**
     * Sets the direction of the right arm.
     *
     * @param direction The direction of the right arm
     * @return This instance, for chaining
     */
    BodyPartRotationalData setRightArmDirection(Vector3d direction);

    /**
     * Gets the direction the left leg is aiming at.
     *
     * @return The direction the left leg is aiming at
     */
    Vector3d getLeftLegDirection();

    /**
     * Sets the direction of the left leg.
     *
     * @param direction The direction of the left leg
     * @return This instance, for chaining
     */
    BodyPartRotationalData setLeftLegDirection(Vector3d direction);

    /**
     * Gets the direction the right leg is aiming at.
     *
     * @return The direction the right leg is aiming at
     */
    Vector3d getRightLegDirection();

    /**
     * Sets the direction of the right leg.
     *
     * @param direction The direction of the right leg
     * @return This instance, for chaining
     */
    BodyPartRotationalData setRightLegDirection(Vector3d direction);

}
