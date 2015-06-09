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
import org.spongepowered.api.data.manipulator.mutable.entity.EyeLocationData;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.entity.Entity;

/**
 * An {@link ImmutableDataManipulator} for the "eye location" of an
 * {@link Entity}.
 */
public interface ImmutableEyeLocationData extends ImmutableDataManipulator<ImmutableEyeLocationData, EyeLocationData> {

    /**
     * Gets the {@link ImmutableValue} for the "height" from the base of an
     * {@link Entity} bounding box to the current eye height. This can be known
     * as the "camera height".
     *
     * @return The immutable value for the eye height
     */
    ImmutableValue<Double> eyeHeight();

    /**
     * Gets the {@link ImmutableValue} for the "eye" location in a 3d plane.
     * This is different from an {@link Entity}'s position as the eye location
     * is always adjusted for the actual eye location, which may differ from
     * the base {@link Entity}'s location. This can be known as the "camera"
     * position.
     *
     * @return The location value
     */
    ImmutableValue<Vector3d> eyeLocation();

}
