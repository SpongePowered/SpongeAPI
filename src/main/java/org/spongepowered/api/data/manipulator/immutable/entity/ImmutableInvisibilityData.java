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
import org.spongepowered.api.data.manipulator.mutable.entity.InvisibilityData;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.entity.Entity;

/**
 * An {@link ImmutableDataManipulator} for the "vanish" state. If present,
 * the {@link Entity} is rendered "vanish".
 */
public interface ImmutableInvisibilityData extends ImmutableDataManipulator<ImmutableInvisibilityData, InvisibilityData> {

    /**
     * Gets the {@link ImmutableValue} of the "invisible" state of an
     * {@link Entity}.
     *
     * <p>Note that this is different from the {@link #vanish()} state as when an
     * {@link Entity} is "invisible", update packets are still sent to all clients
     * and the server. Likewise, no </p>
     *
     * @return The immutable value of the invisible state
     */
    ImmutableValue<Boolean> invisible();

    /**
     * Gets the {@link ImmutableValue} of the "vanish" state of an
     * {@link Entity}.
     *
     * @return The immutable value of the vanish state
     */
    ImmutableValue<Boolean> vanish();


    /**
     * Gets the {@link Value} of whether an {@link Entity} that is "vanished" will
     * be ignored for collision detection. The collision detection can affect
     * collisions with other {@link Entity entities}, blocks, etc.
     *
     * @return The value of the collision detection state
     */
    ImmutableValue<Boolean> ignoresCollisionDetection();

    /**
     * Gets the {@link Value} of whether an {@link Entity} that is "vanished" will
     * be ignored when other {@link Entity entities} are processing possible "targets"
     * for their AI.
     *
     * @return The value of the targetable detection state
     */
    ImmutableValue<Boolean> untargetable();

}
