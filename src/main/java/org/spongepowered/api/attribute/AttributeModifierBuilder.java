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

package org.spongepowered.api.attribute;

/**
 * A builder used to create {@link AttributeModifier}s.
 */
public interface AttributeModifierBuilder {

    /**
     * Sets the value of the {@link AttributeModifier} to be built.
     *
     * @param value The value to use
     * @return This builder, for chaining
     * @throws IllegalArgumentException If the value is under the minimum or
     *         above the maximum of the attribute
     */
    AttributeModifierBuilder value(double value) throws IllegalArgumentException;

    /**
     * Sets the {@link Operation} of the {@link AttributeModifier} to be built.
     *
     * @param operation The Operation to use
     * @return This builder, for chaining
     */
    AttributeModifierBuilder operation(Operation operation);

    /**
     * Builds the {@link AttributeModifier} with the set parameters.
     *
     * @return The AttributeModifier with the set parameters
     */
    AttributeModifier build();

    /**
     * Resets this builder, to be used again.
     * 
     * @return This builder, for chaining
     */
    AttributeModifierBuilder reset();

}
