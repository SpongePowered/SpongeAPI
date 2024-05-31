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

import org.spongepowered.api.ResourceKeyed;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.inventory.ItemStack;

import java.util.function.Supplier;

/**
 * Represents a modifier to a value in a {@link Attribute} which is transformed
 * by an {@link AttributeOperation}.
 *
 * <p>Modifiers are usually found on {@link ItemStack}s.</p>
 */
public interface AttributeModifier extends ResourceKeyed {

    /**
     * Creates a new {@link Builder} to create an {@link AttributeModifier}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    /**
     * Gets this modifier's operation.
     *
     * @return The operation
     */
    AttributeOperation operation();

    /**
     * Gets the amount this attribute will be modified by.
     *
     * @return The amount
     */
    double amount();

    /**
     * Represents a builder class to create {@link AttributeModifier}s.
     *
     * @see AttributeModifier
     */
    interface Builder extends org.spongepowered.api.util.ResourceKeyedBuilder<AttributeModifier, Builder> {

        /**
         * Sets the operation of this attribute modifier.
         *
         * @param operation The operation
         * @return This builder
         */
        default Builder operation(Supplier<? extends AttributeOperation> operation) {
            return this.operation(operation.get());
        }

        /**
         * Sets the operation of this attribute modifier.
         *
         * @param operation The operation
         * @return This builder
         */
        Builder operation(final AttributeOperation operation);

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
         * @return The attribute modifier.
         */
        @Override
        AttributeModifier build();
    }
}
