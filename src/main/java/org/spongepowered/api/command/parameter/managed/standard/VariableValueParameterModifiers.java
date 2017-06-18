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
package org.spongepowered.api.command.parameter.managed.standard;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.parameter.ArgumentParseException;
import org.spongepowered.api.command.parameter.managed.ValueParameterModifier;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Optional;
import java.util.function.Function;

// TODO: Better name?
public class VariableValueParameterModifiers {

    private VariableValueParameterModifiers() {}

    /**
     * Creates a builder that can build a modifier that supplies a default value
     * if a parameter cannot parse an argument.
     *
     * @return The builder
     */
    public static DefaultValueModifierBuilder defaultValueModifierBuilder() {
        return Sponge.getRegistry().createBuilder(DefaultValueModifierBuilder.class);
    }

    /**
     * Creates a builder that can build a modifier that instructs a parameter to
     * execute the specified number of times.
     *
     * @return The builder
     */
    public static RepeatedValueModifierBuilder repeatedValueModifierBuilder() {
        return Sponge.getRegistry().createBuilder(RepeatedValueModifierBuilder.class);
    }

    /**
     * A builder that creates a {@link ValueParameterModifier} that supplies
     * a default value if the parameter in question fails to parse an argument.
     */
    public interface DefaultValueModifierBuilder extends ResettableBuilder<ValueParameterModifier, DefaultValueModifierBuilder> {

        /**
         * Sets the {@link Function} that supplies the default value.
         *
         * <p>If this function returns {@link Optional#empty()}, the parameter
         * will throw an {@link ArgumentParseException}, as if the element was
         * not optional.</p>
         *
         * @param defaultValueFunction The {@link Function} that supplies the
         *                             default value, if any
         * @return This builder, for chaining
         */
        DefaultValueModifierBuilder setDefaultValueFunction(Function<Cause, Optional<?>> defaultValueFunction);

        /**
         * Builds this {@link ValueParameterModifier}.
         *
         * @return The modifier
         * @throws IllegalStateException if the default value function has not
         *                               been set
         */
        ValueParameterModifier build();

    }

    /**
     * A builder the creates a {@link ValueParameterModifier} that causes a
     * parameter to parse a specified number of arguments.
     */
    public interface RepeatedValueModifierBuilder extends ResettableBuilder<ValueParameterModifier, RepeatedValueModifierBuilder> {

        /**
         * Sets how many times a parameter should execute
         *
         * @param numberOfTimes The number of times to execute
         * @return This builder, for chaining
         * @throws IllegalArgumentException if numberOfTimes is zero or negative
         */
        RepeatedValueModifierBuilder setNumberOfTimes(int numberOfTimes);

        /**
         * Builds this {@link ValueParameterModifier}.
         *
         * @return The modifier
         * @throws IllegalStateException if the number of arguments to parse
         *                               has not been set
         */
        ValueParameterModifier build();

    }

}
