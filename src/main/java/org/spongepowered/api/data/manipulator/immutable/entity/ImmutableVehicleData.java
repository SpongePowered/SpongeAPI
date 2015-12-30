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

import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.mutable.entity.VehicleData;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntitySnapshot;

/**
 * An {@link ImmutableDataManipulator} that handles the current "passenger" if
 * the owning {@link Entity} is considered to be a "vehicle" or another
 * {@link Entity} is currently riding the owning {@link Entity}.
 */
public interface ImmutableVehicleData extends ImmutableDataManipulator<ImmutableVehicleData, VehicleData> {

    /**
     * Gets the {@link ImmutableValue} for the current "vehicle" being ridden.
     *
     * @return The immutable value for the vehicle being ridden
     */
    ImmutableValue<EntitySnapshot> vehicle();

    /**
     * Gets the base {@link ImmutableValue} for the "base vehicle" being ridden
     * such that the current vehicle may be riding another {@link Entity},
     * causing that entity to be called the "base vehicle".
     *
     * @return The immutable value for the base vehicle
     */
    ImmutableValue<EntitySnapshot> baseVehicle();


}
