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

package org.spongepowered.api.event.cause.entity.health;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.cause.Cause;

import java.util.function.Function;

/**
 * Represents a modifier that will apply a function on a damage value to
 * deal towards an entity such that the raw damage is the input of a
 * {@link Function} such that the output will be the final damage applied
 * to the {@link Entity}.
 */
public interface HealthModifier {

    /**
     * Gets the {@link HealthModifierType} for this {@link HealthModifier}.
     *
     * @return The damage modifier type
     */
    HealthModifierType getType();

    /**
     * Gets the cause of this {@link HealthModifier}.
     *
     * @return The cause of this damage modifier
     */
    Cause getCause();

}
