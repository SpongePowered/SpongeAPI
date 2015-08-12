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

package org.spongepowered.api.item.inventory.generator;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import org.spongepowered.api.GameRegistry;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Nullable;

/**
 * Generates an {@link ItemStack} when requested. Using the optional base
 * {@link ItemStack} and a list of {@link ItemStackBuilderMutator}s to modify
 * the outcome. Does not return null.
 */
public final class ItemStackGenerator implements Supplier<ItemStack> {

    /**
     * Create a new {@link Builder} to create new instances of
     * {@link ItemStackGenerator}s.
     *
     * @param registry The game registry required to instantiate new item stacks
     * @return The new builder
     */
    public static Builder builder(GameRegistry registry) {
        return new Builder(registry);
    }

    private final GameRegistry registry;
    private final ItemStack baseItem;
    private final List<ItemStackBuilderMutator> randomizers;

    /**
     * Creates a new {@link ItemStackGenerator}.
     *
     * @param registry The game registry required to instantiate new item stacks
     * @param baseItem The optional base item to use as blueprint for the
     *        builder
     * @param randomizers A collection containing the mutators to apply
     */
    private ItemStackGenerator(GameRegistry registry, @Nullable ItemStack baseItem, Collection<ItemStackBuilderMutator> randomizers) {
        super();
        this.registry = checkNotNull(registry, "registry");
        this.baseItem = baseItem;
        this.randomizers = ImmutableList.copyOf(checkNotNull(randomizers, "randomizers"));
    }

    @Override
    public ItemStack get() {
        final ItemStackBuilder builder = this.registry.createItemBuilder();
        if (this.baseItem != null) {
            builder.fromItemStack(this.baseItem);
        }
        for (ItemStackBuilderMutator randomizer : this.randomizers) {
            randomizer.apply(builder);
        }
        return builder.build();
    }

    /**
     * The builder to create new instances of {@link ItemStackGenerator}.
     */
    public static final class Builder {

        private final GameRegistry registry;
        private ItemStack baseItem = null;
        private final List<ItemStackBuilderMutator> randomizers = new ArrayList<ItemStackBuilderMutator>();

        private Builder(GameRegistry registry) {
            this.registry = checkNotNull(registry, "registry");
        }

        /**
         * Sets the optional base item to use as blueprint for the builders.
         *
         * @param item The base item to use
         * @return This builder
         */
        public Builder baseItem(@Nullable ItemStack item) {
            this.baseItem = item;
            return this;
        }

        /**
         * Appends the given mutator for the generator.
         *
         * @param mutator The mutator to append
         * @return This builder
         */
        public Builder add(ItemStackBuilderMutator mutator) {
            this.randomizers.add(checkNotNull(mutator, "mutator"));
            return this;
        }

        /**
         * Appends the given mutators for the generator.
         *
         * @param mutators The mutators to append
         * @return This builder
         */
        public Builder addAll(ItemStackBuilderMutator... mutators) {
            for (ItemStackBuilderMutator mutator : checkNotNull(mutators, "mutators")) {
                add(mutator);
            }
            return this;
        }

        /**
         * Appends the given mutators for the generator.
         *
         * @param mutators The mutators to append
         * @return This builder
         */
        public Builder addAll(Iterable<? extends ItemStackBuilderMutator> mutators) {
            for (ItemStackBuilderMutator mutator : checkNotNull(mutators, "mutators")) {
                add(mutator);
            }
            return this;
        }

        /**
         * Creates a new {@link ItemStackGenerator} instance with the current
         * state of the builder.
         *
         * @return The newly created generator
         * @throws IllegalStateException If the resulting generator would be
         *         invalid
         */
        public ItemStackGenerator build() throws IllegalStateException {
            if (this.baseItem == null && this.randomizers.isEmpty()) {
                throw new IllegalStateException("Base item cannot be null if randomizers are empty!");
            }
            final ItemStackGenerator generator = new ItemStackGenerator(this.registry, this.baseItem, this.randomizers);
            try {
                checkNotNull(generator.get(), "generated item stack is null");
            } catch (RuntimeException e) {
                throw new IllegalStateException("Cannot generate item stacks with this configuration!", e);
            }
            return generator;
        }

        /**
         * Clears all settings of this builder.
         *
         * @return This builder
         */
        public Builder reset() {
            this.baseItem = null;
            this.randomizers.clear();
            return this;
        }

    }
}
