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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.spongepowered.api.event.cause.entity.ModifierFunction;

import java.util.function.DoubleUnaryOperator;

public class HealthFunction implements ModifierFunction<HealthModifier> {

    public static final DoubleUnaryOperator NO_HEALTH = value -> 0.0d;

    public static HealthFunction of(HealthModifier first, DoubleUnaryOperator second) {
        return new HealthFunction(first, second);
    }

    private final HealthModifier modifier;
    private final DoubleUnaryOperator function;

    /**
     * Creates a new {@link HealthFunction} with the provided
     * {@link HealthModifier}. The caveat is that the provided
     * {@link DoubleUnaryOperator} is by default going to provide {@code 0}
     * healing modifications.
     *
     * @param modifier The damage modifier
     */
    public HealthFunction(HealthModifier modifier) {
        this(modifier, NO_HEALTH);
    }

    /**
     * Creates a new {@link HealthFunction} with the provided
     * {@link HealthModifier} and function.
     *
     * @param modifier
     * @param function
     */
    public HealthFunction(HealthModifier modifier, DoubleUnaryOperator function) {
        this.modifier = checkNotNull(modifier, "modifier");
        this.function = checkNotNull(function, "function");
    }

    /**
     * Gets the {@link HealthModifier} for this function.
     *
     * @return The health modifier
     */
    @Override
    public HealthModifier getModifier() {
        return this.modifier;
    }

    /**
     * Gets the {@link DoubleUnaryOperator} for this function.
     *
     * @return The healing function
     */
    @Override
    public DoubleUnaryOperator getFunction() {
        return this.function;
    }


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("HealthModifer", this.modifier)
                .add("Function", this.function)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HealthFunction that = (HealthFunction) o;
        return Objects.equal(this.modifier, that.modifier) &&
               Objects.equal(this.function, that.function);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.modifier, this.function);
    }
}
