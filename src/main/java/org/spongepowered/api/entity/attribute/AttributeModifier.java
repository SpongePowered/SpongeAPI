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
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.Identifiable;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.UUID;
import java.util.function.Supplier;

/**
 * Represents a modifier to a value in a {@link Attribute} which is transformed
 * by an {@link AttributeOperation}.
 *
 * <p>Modifiers are usually found on {@link ItemStack}s.</p>
 */
public interface AttributeModifier extends Identifiable {

    /**
     * Creates a new {@link Builder} to create an {@link AttributeModifier}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Gets the attribute name.
     *
     * @return The name
     */
    String getName();

    /**
     * Gets this modifier's operation.
     *
     * @return The operation
     */
    AttributeOperation getOperation();

    /**
     * Gets the amount this attribute will be modified by.
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
         * Sets the id of this attribute modifier.
         *
         * @param id The id
         * @return This builder
         */
        Builder id(UUID id);

        /**
         * Sets this attribute modifier to have a random id.
         *
         * @return This builder
         */
        default Builder randomId() {
            return this.id(UUID.randomUUID());
        }

        /**
         * Sets the name of this attribute modifier.
         *
         * <p>The name of an attribute modifier corresponds to the translation
         * displayed when listing all the modifiers on an item.</p>
         *
         * <p>The format of the translations is
         * <code>attribute.name.yournamehere</code>.</p>
         *
         * @param name The name
         * @return This builder
         */
        Builder name(String name);

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
        AttributeModifier build();
    }
}
