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
package org.spongepowered.api.entity.attribute;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.attribute.operation.AttributeOperation;
import org.spongepowered.api.util.Identifiable;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.UUID;

/**
 * An attribute modifier.
 */
public interface AttributeModifier extends Identifiable {

    /**
     * Creates a new {@link Builder} to create {@link AttributeModifier}s.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the attribute modifier name.
     *
     * @return The name
     */
    String getName();

    /**
     * Gets the operation this modifier uses.
     *
     * @return The operation
     */
    AttributeOperation getOperation();

    /**
     * Gets the amount used when applying the operation
     *
     * @return The amount
     */
    double getAmount();

    /**
     * Represents a builder class to create {@link AttributeModifier}s.
     *
     * @see AttributeModifier
     */
    interface Builder extends ResettableBuilder<AttributeModifier, Builder> {

        /**
         * Sets the id of the attribute modifier.
         *
         * @param id The id
         * @return This builder
         */
        Builder id(UUID id);

        /**
         * Sets the id of the attribute modifier.
         *
         * @param name The name
         * @return This builder
         */
        Builder name(String name);

        /**
         * Sets the id of the attribute modifier.
         *
         * @param operation The operation
         * @return This builder
         */
        Builder operation(AttributeOperation operation);

        /**
         * Sets the amount of the attribute modifier.
         *
         * @param amount The amount
         * @return This builder
         */
        Builder amount(double amount);

        /**
         * Build the attribute modifier from the values in this builder.
         *
         * @return The attribute modifier
         */
        AttributeModifier build();
    }

}
