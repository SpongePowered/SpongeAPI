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

package org.spongepowered.api.item.generator;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.data.manipulators.items.EnchantmentData;
import org.spongepowered.api.item.Enchantment;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackBuilder;
import org.spongepowered.api.util.SupplierUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Helper class containing mutators for {@link ItemStackBuilder}s. This class
 * can be used for {@link ItemStackGenerator}s.
 */
public final class ItemStackBuilderMutators {

    // ItemType

    /**
     * Creates a mutator, that modifies the builders to always use the given
     * {@link ItemType}.
     *
     * @param type The item type to use
     * @return The newly generated mutator
     */
    public static ItemStackBuilderMutator type(ItemType type) {
        return types(SupplierUtil.fixed(type));
    }

    /**
     * Creates a mutator, that modifies the builders to use a random
     * {@link ItemType}.
     *
     * @param types The possible item types to use
     * @return The newly generated mutator
     * @throws IllegalArgumentException If the given item types are empty
     */
    public static ItemStackBuilderMutator types(Supplier<ItemType> types) throws IllegalArgumentException {
        return new ItemTypeRandomizer(types);
    }

    /**
     * Applies a random {@link ItemType} to the {@link ItemStackBuilder}.
     */
    private static class ItemTypeRandomizer implements ItemStackBuilderMutator {

        private final Supplier<ItemType> types;

        ItemTypeRandomizer(Supplier<ItemType> types) {
            this.types = checkNotNull(types, "types");
        }

        @Override
        public void apply(ItemStackBuilder builder) {
            builder.itemType(this.types.get());
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .add("types", this.types)
                    .toString();
        }

    }

    // Quantity

    /**
     * Creates a mutator, that modifies the builders to always use the given
     * value as quantity.
     *
     * @param quantity The quantity to use
     * @return The newly generated mutator
     */
    public static ItemStackBuilderMutator quantity(int quantity) {
        return quantity(SupplierUtil.fixed(quantity));
    }

    /**
     * Creates a mutator, that modifies the builders to set the quantity based
     * on the given supplier
     *
     * @param supplier The supplier for the quantity
     * @return The newly generated mutator
     */
    public static ItemStackBuilderMutator quantity(Supplier<Integer> supplier) {
        return new ItemCountRandomizer(supplier);
    }

    /**
     * Applies a random quantity provided by the randomizer.
     */
    private static class ItemCountRandomizer implements ItemStackBuilderMutator {

        private final Supplier<Integer> randomizer;

        ItemCountRandomizer(Supplier<Integer> randomizer) {
            this.randomizer = checkNotNull(randomizer, "randomizer");
        }

        @Override
        public void apply(ItemStackBuilder builder) {
            builder.quantity(this.randomizer.get());
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .add("randomizer", this.randomizer)
                    .toString();
        }

    }

    // Data

    public static <T extends DataManipulator<T>> ItemStackBuilderMutator data(T data) {
        return new DataRandomizer<T>(Suppliers.ofInstance(data));
    }

    public static <T extends DataManipulator<T>> ItemStackBuilderMutator data(Supplier<T> supplier) {
        return new DataRandomizer<T>(supplier);
    }

    private static class DataRandomizer<T extends DataManipulator<T>> implements ItemStackBuilderMutator {

        private final Supplier<T> itemData;

        DataRandomizer(Supplier<T> itemData) {
            super();
            this.itemData = checkNotNull(itemData, "itemData");
        }

        @Override
        public void apply(ItemStackBuilder builder) {
            builder.itemData(this.itemData.get());
        }

    }

    // Enchantments

    /**
     * Creates a mutator, that modifies the builders to add the given
     * enchantment with a random level to the item stack, if it is applicable.
     * If the builder already has this enchantment the current level will be
     * overwritten.
     *
     * @param enchantment The enchantment to add
     * @return The newly generated mutator
     */
    public static ItemStackBuilderMutator enchantment(Enchantment enchantment) {
        return enchantments(1, checkNotNull(enchantment, "enchantment"));
    }

    /**
     * Creates a mutator, that modifies the builders to add a given number of
     * {@link Enchantment}s. The {@link Enchantment}s are chosen at random, but
     * it is ensured that the enchantments are applicable to the item stacks. If
     * the builder already has the enchantments the current level will be
     * overwritten.
     *
     * @param count The maximum number of enchantments to add
     * @param enchantments The list of possible enchantments
     * @return The newly generated mutator
     */
    public static ItemStackBuilderMutator enchantments(int count, Enchantment... enchantments) {
        return enchantments(count, Arrays.asList(checkNotNull(enchantments, "enchantments")));
    }

    /**
     * Creates a mutator, that modifies the builders to add a given number of
     * {@link Enchantment}s. The {@link Enchantment}s are chosen at random, but
     * it is ensured that the enchantments are applicable to the item stacks. If
     * the builder already has the enchantments the current level will be
     * overwritten.
     *
     * @param count The maximum number of enchantments to add
     * @param enchantments The list of possible enchantments
     * @return The newly generated mutator
     */
    public static ItemStackBuilderMutator enchantments(int count, Collection<Enchantment> enchantments) {
        return enchantments(SupplierUtil.fixed(count), enchantments);
    }

    /**
     * Creates a mutator, that modifies the builders to add a given number of
     * {@link Enchantment}s. The {@link Enchantment}s are chosen at random, but
     * it is ensured that the enchantments are applicable to the item stacks. If
     * the builder already has the enchantments the current level will be
     * overwritten.
     *
     * @param count The maximum number of enchantments to add
     * @param enchantments The list of possible enchantments
     * @return The newly generated mutator
     */
    public static ItemStackBuilderMutator enchantments(Supplier<Integer> count, Enchantment... enchantments) {
        return enchantments(count, Arrays.asList(checkNotNull(enchantments, "enchantments")));
    }

    /**
     * Creates a mutator, that modifies the builders to add a given number of
     * {@link Enchantment}s. The {@link Enchantment}s are chosen at random, but
     * it is ensured that the enchantments are applicable to the item stacks. If
     * the builder already has the enchantments the current level will be
     * overwritten.
     *
     * @param count The maximum number of enchantments to add
     * @param enchantments The list of possible enchantments
     * @return The newly generated mutator
     */
    public static ItemStackBuilderMutator enchantments(Supplier<Integer> count, Collection<Enchantment> enchantments) {
        return new EnchantmentRandomizer(count, checkNotNull(enchantments, "enchantments"));
    }

    private static class EnchantmentRandomizer implements ItemStackBuilderMutator {

        private final Supplier<Integer> count;
        private final List<Enchantment> enchantments;

        EnchantmentRandomizer(Supplier<Integer> count, Collection<Enchantment> enchantments) {
            super();
            this.count = checkNotNull(count, "count");
            this.enchantments = ImmutableList.copyOf(enchantments);
        }

        @Override
        public void apply(ItemStackBuilder builder) {
            ItemStack stack = builder.build();
            final Optional<EnchantmentData> optionalData = stack.getOrCreate(EnchantmentData.class);
            final int count = this.count.get();
            if (optionalData.isPresent()) {
                final EnchantmentData data = optionalData.get();
                final List<Enchantment> enchantments = new ArrayList<Enchantment>(this.enchantments);
                Collections.shuffle(enchantments);
                final Iterator<Enchantment> it = enchantments.iterator();
                int applied = 0;
                while (it.hasNext()) {
                    final Enchantment enchantment = it.next();
                    if (enchantment.canBeAppliedToStack(stack)) {
                        applied++;
                        data.set(enchantment, randomLevel(enchantment));
                        builder.itemData(data);
                        if (applied >= count) {
                            break;
                        }
                        stack = builder.build();
                    }
                }
            }
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .add("count", this.count)
                    .add("enchantments", Arrays.toString(this.enchantments.toArray()))
                    .toString();
        }

        int randomLevel(Enchantment enchantment) {
            return SupplierUtil.randomIntBetween(enchantment.getMinimumLevel(), enchantment.getMaximumLevel());
        }

    }

}
