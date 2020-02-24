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
package org.spongepowered.api.item.inventory;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.util.CopyableBuilder;

import java.util.Collection;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * A simple generator that takes a {@link Random} and generates
 * an {@link ItemStack}.
 */
public interface ItemStackGenerator extends Function<Random, ItemStack> {

    /**
     * Creates a new builder to build an {@link ItemStackGenerator}.
     *
     * @return The builder to create an itemstack generator
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * A builder to add various {@link BiConsumer}s that will be applied in order
     * to an {@link ItemStackGenerator}. Normally, most all biconsumers can be
     * created from {@link ItemStackBuilderPopulators}.
     */
    interface Builder extends CopyableBuilder<ItemStackGenerator, Builder> {

        /**
         * Adds a new biconsumer in the current order.
         *
         * @param consumer The consumer that mutates an itemstack builder
         * @return This builder, for chaining
         */
        Builder add(BiConsumer<ItemStack.Builder, Random> consumer);

        /**
         * Adds all the provided biconsumers from the provided collection.
         *
         * @param collection The collection of consumer to add
         * @return This builder, for chaining
         */
        Builder addAll(Collection<BiConsumer<ItemStack.Builder, Random>> collection);

        /**
         * Sets the base {@link ItemType} for the {@link ItemStackGenerator}. A
         * base type must be set to avoid issues.
         *
         * @param itemType The base item type
         * @return This builder, for chaining
         */
        default Builder baseItem(Supplier<? extends ItemType> itemType) {
            return this.baseItem(itemType.get());
        }

        /**
         * Sets the base {@link ItemType} for the {@link ItemStackGenerator}. A
         * base type must be set to avoid issues.
         *
         * @param itemType The base item type
         * @return This builder, for chaining
         */
        Builder baseItem(ItemType itemType);

        /**
         * Creates a new {@link ItemStackGenerator} with all of the added
         * {@link BiConsumer}s.
         *
         * @return The newly created itemstack generator
         */
        ItemStackGenerator build();

    }
}
