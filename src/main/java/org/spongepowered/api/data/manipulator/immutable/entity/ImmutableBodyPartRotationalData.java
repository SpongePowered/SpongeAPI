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
package org.spongepowered.api.data.manipulator.immutable.entity;

import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.mutable.entity.BodyPartRotationalData;
import org.spongepowered.api.data.type.BodyPart;
import org.spongepowered.api.data.type.BodyParts;
import org.spongepowered.api.data.value.immutable.ImmutableMapValue;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.mutable.CompositeValueStore;

/**
 * An {@link ImmutableDataManipulator} containing an {@link ImmutableMapValue}
 * matching {@link BodyPart}s to {@link Vector3d} rotations. Depending on the
 * owning {@link CompositeValueStore}, certain {@link BodyPart}s may not be
 * usable or valid.
 */
public interface ImmutableBodyPartRotationalData extends ImmutableDataManipulator<ImmutableBodyPartRotationalData, BodyPartRotationalData> {

    /**
     * Gets the {@link ImmutableMapValue} of {@link BodyPart}s to
     * {@link Vector3d} rotations.
     *
     * @return The immutable map value of body parts to rotations
     */
    ImmutableMapValue<BodyPart, Vector3d> partRotation();

    /**
     * Gets the individual {@link ImmutableValue} of the {@link Vector3d}
     * rotation for {@link BodyParts#HEAD}.
     *
     * @return The immutable rotation value for the head rotation
     */
    ImmutableValue<Vector3d> headDirection();

    /**
     * Gets the individual {@link ImmutableValue} of the {@link Vector3d}
     * rotation for {@link BodyParts#CHEST}.
     *
     * @return The immutable rotation value for the chest rotation
     */
    ImmutableValue<Vector3d> bodyRotation();

    /**
     * Gets the individual {@link ImmutableValue} of the {@link Vector3d}
     * rotation for {@link BodyParts#LEFT_ARM}.
     *
     * @return The immutable rotation value for the left arm rotation
     */
    ImmutableValue<Vector3d> leftArmDirection();

    /**
     * Gets the individual {@link ImmutableValue} of the {@link Vector3d}
     * rotation for {@link BodyParts#RIGHT_ARM}.
     *
     * @return The immutable rotation value for the right arm rotation
     */
    ImmutableValue<Vector3d> rightArmDirection();

    /**
     * Gets the individual {@link ImmutableValue} of the {@link Vector3d}
     * rotation for {@link BodyParts#LEFT_LEG}.
     *
     * @return The immutable rotation value for the left leg rotation
     */
    ImmutableValue<Vector3d> leftLegDirection();

    /**
     * Gets the individual {@link ImmutableValue} of the {@link Vector3d}
     * rotation for {@link BodyParts#RIGHT_LEG}.
     *
     * @return The immutable rotation value for the right leg rotation
     */
    ImmutableValue<Vector3d> rightLegDirection();

}
