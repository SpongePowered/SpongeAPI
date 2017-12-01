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
package org.spongepowered.api.item.enchantment;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.item.inventory.ItemStack;

/**
 * Represents an {@link EnchantmentType} on an {@link ItemStack} that is paired
 * with a level.
 *
 * <p>The contract of enchantments is that their level will always be between
 * {@link Short#MIN_VALUE} and {@link Short#MAX_VALUE}, but it is not guaranteed
 * they will work properly outside of {@link EnchantmentType#getMinimumLevel()}
 * and {@link EnchantmentType#getMaximumLevel()}.</p>
 */
public interface Enchantment extends DataSerializable {

    /**
     * Creates a new {@link Builder} to create an {@link Enchantment}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Enchantment.Builder.class);
    }

    /**
     * Creates a new {@link Enchantment} with the provided
     * {@link EnchantmentType} and level.
     *
     * @param enchantmentType The enchantment type
     * @param level The enchantment level
     * @return The created enchantment
     * @throws IllegalArgumentException If the level is smaller than
     *     {@link Short#MIN_VALUE} or larger than {@link Short#MAX_VALUE}
     */
    static Enchantment of(EnchantmentType enchantmentType, int level) throws IllegalArgumentException {
        return builder()
                .type(enchantmentType)
                .level(level)
                .build();
    }

    /**
     * Gets the {@link EnchantmentType} for this enchantment.
     *
     * @return The enchantment type of this enchantment
     */
    EnchantmentType getType();

    /**
     * Gets the level of this enchantment.
     *
     * @return The level of this enchantment
     */
    int getLevel();

    /**
     * Represents a builder interface which can be used
     * to create a {@link Enchantment}.
     */
    interface Builder extends DataBuilder<Enchantment> {

        /**
         * Sets the {@link EnchantmentType} for this enchantment.
         *
         * @param enchantmentType The desired enchantment type
         * @return The modified builder, for chaining
         */
        Builder type(EnchantmentType enchantmentType);

        /**
         * Sets the level for this enchantment.
         *
         * <p>This level must be between {@link Short#MIN_VALUE} and
         * {@link Short#MAX_VALUE}, but there is no guarantee all levels will
         * work properly without error. It is recommended for reliable results
         * you stay between {@link EnchantmentType#getMinimumLevel()} and
         * {@link EnchantmentType#getMaximumLevel()}, or at least larger
         * than <code>0</code> and less than {@link Short#MAX_VALUE}.</p>
         *
         * @param level The desired level
         * @return The modified builder for chaining
         * @throws IllegalArgumentException If the level is smaller than
         *     {@link Short#MIN_VALUE} or larger than {@link Short#MAX_VALUE}
         */
        Builder level(int level) throws IllegalArgumentException;

        /**
         * Builds an instance of a {@link Enchantment} based on the entered
         * information.
         *
         * @return The created enchantment
         * @throws IllegalStateException If a required value was not specified
         */
        Enchantment build() throws IllegalStateException;

    }

}
