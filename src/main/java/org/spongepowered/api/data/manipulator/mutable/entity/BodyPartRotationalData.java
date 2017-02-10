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
package org.spongepowered.api.data.manipulator.mutable.entity;

import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.immutable.entity.ImmutableBodyPartRotationalData;
import org.spongepowered.api.data.type.BodyPart;
import org.spongepowered.api.data.value.mutable.MapValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.entity.living.ArmorStand;
import org.spongepowered.api.entity.living.Humanoid;

/**
 * Represents the mapped rotational data for all known body parts. Usually
 * applicable to {@link Humanoid}s and {@link ArmorStand}s.
 */
public interface BodyPartRotationalData extends DataManipulator<BodyPartRotationalData, ImmutableBodyPartRotationalData> {

    /**
     * Gets the {@link MapValue} of {@link BodyPart}s to {@link Vector3d}
     * rotations.
     *
     * @return The map value of body parts to rotations
     * @see Keys#BODY_ROTATIONS
     */
    MapValue<BodyPart, Vector3d> partRotation();

    /**
     * Gets the direction the headpiece is aiming at.
     *
     * @return The direction the headpiece is aiming at
     * @see Keys#HEAD_ROTATION
     */
    Value<Vector3d> headDirection();

    /**
     * Gets the direction the body is aiming at.
     *
     * @return The direction the body is aiming at
     * @see Keys#CHEST_ROTATION
     */
    Value<Vector3d> bodyRotation();

    /**
     * Gets the direction the left arm is aiming at.
     *
     * @return The direction the left arm is aiming at
     * @see Keys#LEFT_ARM_ROTATION
     */
    Value<Vector3d> leftArmDirection();

    /**
     * Gets the direction the right arm is aiming at.
     *
     * @return The direction the right arm is aiming at
     * @see Keys#RIGHT_ARM_ROTATION
     */
    Value<Vector3d> rightArmDirection();

    /**
     * Gets the direction the left leg is aiming at.
     *
     * @return The direction the left leg is aiming at
     * @see Keys#LEFT_LEG_ROTATION
     */
    Value<Vector3d> leftLegDirection();

    /**
     * Gets the direction the right leg is aiming at.
     *
     * @return The direction the right leg is aiming at
     * @see Keys#RIGHT_LEG_ROTATION
     */
    Value<Vector3d> rightLegDirection();

}
