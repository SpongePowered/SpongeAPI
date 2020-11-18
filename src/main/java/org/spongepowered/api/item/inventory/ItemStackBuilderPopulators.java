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

import static org.spongepowered.api.util.weighted.VariableAmount.baseWithRandomAddition;
import static org.spongepowered.api.util.weighted.VariableAmount.fixed;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.value.ListValue;
import org.spongepowered.api.data.value.SetValue;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.enchantment.Enchantment;
import org.spongepowered.api.item.enchantment.EnchantmentType;
import org.spongepowered.api.util.Tuple;
import org.spongepowered.api.util.weighted.VariableAmount;
import org.spongepowered.api.util.weighted.WeightedTable;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * A factory for generating {@link BiConsumer}s to apply to an
 * {@link ItemStack.Builder}, usually through an {@link ItemStackGenerator}.
 *
 * <p>Note that the {@link BiConsumer}s are expected to utilize the passed in
 * {@link Random} and use the builder as necessary.</p>
 */
public final class ItemStackBuilderPopulators {

    /**
     * Creates a new {@link BiConsumer} to set the {@link ItemStack.Builder}
     * to use the provided {@link ItemStackSnapshot} as a "default". Note
     * that the normal behavior of the builder is to reset according to
     * the snapshot.
     *
     * @param snapshot The snapshot to set the builder to use
     * @return The new biconsumer to apply to an itemstack builder
     */
    public static BiConsumer<ItemStack.Builder, Random> itemStack(ItemStackSnapshot snapshot) {
        Objects.requireNonNull(snapshot, "ItemStackSnapshot cannot be null!");
        return (builder, random) -> builder.fromSnapshot(snapshot);
    }

    /**
     * Creates a new {@link BiConsumer} that uses a randomized selection
     * of the provided {@link ItemStackSnapshot}s. The builder, when called will
     * only use one at random selection to default to.
     *
     * @param snapshot The first snapshot
     * @param snapshots The additional snapshots
     * @return The new biconsumer to apply to an itemstack builder
     */
    public static BiConsumer<ItemStack.Builder, Random> itemStacks(ItemStackSnapshot snapshot, ItemStackSnapshot... snapshots) {
        Objects.requireNonNull(snapshot, "ItemStackSnapshot cannot be null!");
        final WeightedTable<ItemStackSnapshot> table = new WeightedTable<>(1);
        table.add(snapshot, 1);
        for (ItemStackSnapshot stackSnapshot : snapshots) {
            table.add(Objects.requireNonNull(stackSnapshot, "ItemStackSnapshot cannot be null!"), 1);
        }
        return (builder, random) -> builder.fromSnapshot(table.get(random).get(0));
    }

    /**
     * Creates a new {@link BiConsumer} that defines the provided
     * {@link ItemType}.
     *
     * @param itemType The given item type
     * @return The new biconsumer to apply to an itemstack builder
     */
    public static BiConsumer<ItemStack.Builder, Random> item(ItemType itemType) {
        Objects.requireNonNull(itemType, "ItemType cannot be null!");
        return (builder, random) -> builder.itemType(itemType);
    }

    /**
     * Creates a new {@link BiConsumer} that defines the provided
     * {@link ItemType}, provided that the {@link Supplier} does not
     * return null.
     *
     * <p>Note that the {@link Supplier} is not queried for an
     * {@link ItemType} until the generated {@link BiConsumer} is
     * called.</p>
     *
     * @param supplier The supplier of the item type
     * @return The new biconsumer to apply to an itemstack builder
     */
    public static BiConsumer<ItemStack.Builder, Random> item(Supplier<? extends ItemType> supplier) {
        Objects.requireNonNull(supplier, "Supplier cannot be null!");
        return (builder, random) -> builder.itemType(Objects.requireNonNull(supplier.get(), "Supplier returned a null ItemType"));
    }

    /**
     * Creates a new {@link BiConsumer} that provides a random
     * {@link ItemType} of the provided item types.
     *
     * <p>Note that the desired {@link ItemType} given to the builder is only
     * defined at the time of calling {@link BiConsumer#accept(Object, Object)}.
     * </p>
     *
     * @param itemType The first item type
     * @param itemTypes The additional item types
     * @return The new biconsumer to apply to an item stack builder
     */
    public static BiConsumer<ItemStack.Builder, Random> items(ItemType itemType, ItemType... itemTypes) {
        return items(ImmutableList.<ItemType>builder().add(itemType).addAll(Arrays.asList(itemTypes)).build());
    }

    /**
     * Creates a new {@link BiConsumer} that provides a random
     * {@link ItemType} from the provided collection of item types.
     *
     * @param itemTypes The item types to use
     * @return The new biconsumer to apply to an itemstack builder
     */
    public static BiConsumer<ItemStack.Builder, Random> items(final Collection<ItemType> itemTypes) {
        final ImmutableList<ItemType> copiedItemTypes = ImmutableList.copyOf(itemTypes);
        return (builder, random) -> builder.itemType(copiedItemTypes.get(random.nextInt(copiedItemTypes.size())));
    }

    /**
     * Creates a new {@link BiConsumer} that sets the desired quantity
     * for creating an {@link ItemStack}.
     *
     * <p>Note that the default behavior of the item stack builder is still
     * expected to take place. Negative values are not allowed.</p>
     *
     * @param amount The variable amount
     * @return The new biconsumer to apply to an itemstack builder
     */
    public static BiConsumer<ItemStack.Builder, Random> quantity(VariableAmount amount) {
        Objects.requireNonNull(amount, "VariableAmount cannot be null!");
        return (builder, random) -> builder.quantity(amount.getFlooredAmount(random));
    }

    /**
     * Creates a new {@link BiConsumer} that sets the desired quantity
     * for creating an {@link ItemStack}. The supplier is not queried for
     * a {@link VariableAmount} until the generated bi consumer is
     * called on.
     *
     * <p>Note that the default behavior of an item stack builder is still
     * expected to take place. Negative values are not allowed.</p>
     *
     * @param supplier The supplier of the variable amount
     * @return The new biconsumer to apply to an itemstack builder
     */
    public static BiConsumer<ItemStack.Builder, Random> quantity(Supplier<VariableAmount> supplier) {
        Objects.requireNonNull(supplier, "Supplier cannot be null!");
        return (builder, random) -> builder.quantity(supplier.get().getFlooredAmount(random));
    }

    /**
     * Creates a new {@link BiConsumer} that sets the provided {@link Key}'ed
     * object where the value is possibly ignored or not supported. No checks
     * on whether the key or object is supported until called upon.
     *
     * <p>Note that custom data is not supported through this method, use
     * {@link #values(Iterable)} or any variant thereof for applying custom data.</p>
     *
     * @param key The key to use
     * @param value The value to use
     * @param <E> The type of value
     * @return The new biconsumer to apply to an itemstack builder
     */
    public static <E> BiConsumer<ItemStack.Builder, Random> keyValue(Key<? extends Value<E>> key, E value) {
        return (builder, random) -> {
            final ItemStack itemStack = builder.build();
            final DataTransactionResult dataTransactionResult = itemStack.offer(key, value);
            if (dataTransactionResult.isSuccessful()) {
                builder.from(itemStack);
            }
        };
    }

    /**
     * Creates a new {@link BiConsumer} that sets a single provided
     * value with the provided {@link Key}. Only a single value is chosen
     * to provide to the itemstack builder.
     *
     * <p>Note that custom data is not supported through this method, use
     * {@link #values(Iterable)} or any variant thereof for applying custom data.</p>
     *
     * @param key The key to use
     * @param values The pool of possible values
     * @param <E> The type of value
     * @return The new biconsumer to apply to an itemstack builder
     */
    public static <E> BiConsumer<ItemStack.Builder, Random> keyValues(Key<? extends Value<E>> key, Iterable<E> values) {
        Objects.requireNonNull(values, "Iterable cannot be null!");
        Objects.requireNonNull(key, "Key cannot be null!");
        WeightedTable<E> tableEntries = new WeightedTable<>(1);
        for (E e : values) {
            tableEntries.add(Objects.requireNonNull(e, "Value cannot be null!"), 1);
        }
        return (builder, random) -> {
            final ItemStack itemStack = builder.build();
            final DataTransactionResult dataTransactionResult = itemStack.offer(key, tableEntries.get(random).get(0));
            if (dataTransactionResult.isSuccessful()) {
                builder.from(itemStack);
            }
        };
    }

    /**
     * Creates a new {@link BiConsumer} where the {@link Key} is responsible
     * for a {@link List} based {@link org.spongepowered.api.data.value.Value.Mutable}. Given that the provided elements
     * are chosen with a {@link Random}, it's not clear that the elements will
     * be added in bundles or in the same iteration order.
     *
     * <p>Note that custom data is not supported through this method, use
     * {@link #values(Iterable)} or any variant thereof for applying custom data.</p>
     *
     * @param key The key to use
     * @param elementPool The pool of possible values
     * @param amount The variable amount of elements to add
     * @param <E> The type of elements
     * @return The new biconsumer to apply to an itemstack builder
     */
    public static <E> BiConsumer<ItemStack.Builder, Random> listValues(Key<? extends ListValue.Mutable<E>> key, List<E> elementPool, VariableAmount amount) {
        Objects.requireNonNull(key, "Key cannot be null!");
        Objects.requireNonNull(elementPool, "Element pool cannot be null!");
        Objects.requireNonNull(amount, "VariableAmount cannot be null!");
        if (elementPool.isEmpty()) {
            throw new IllegalArgumentException("Element pool cannot be empty!");
        }
        WeightedTable<E> elementTable = new WeightedTable<>(amount);
        for (E element : elementPool) {
            elementTable.add(Objects.requireNonNull(element, "Element cannot be null!"), 1);
        }
        return listValues(key, elementTable);
    }

    /**
     * Creates a new {@link BiConsumer} where the {@link Key} is responsible
     * for a {@link List} based {@link org.spongepowered.api.data.value.Value.Mutable}. Given that the provided elements
     * are chosen with a {@link Random}, it's not clear that the elements will
     * be added in bundles or in the same iteration order. The default variance
     * is provided as {@link VariableAmount#baseWithRandomAddition(double, double)}
     * where at the least, a single element is chosen, and at most the entire
     * collection is chosen.
     *
     * <p>Note that custom data is not supported through this method, use
     * {@link #values(Iterable)} or any variant thereof for applying custom data.</p>
     *
     * @param key The key to use
     * @param elementPool The pool of possible values
     * @param <E> The type of elements
     * @return The new biconsumer to apply to an itemstack builder
     */
    public static <E> BiConsumer<ItemStack.Builder, Random> listValues(Key<? extends ListValue.Mutable<E>> key, List<E> elementPool) {
        return listValues(key, elementPool, baseWithRandomAddition(1, elementPool.size() - 1));
    }

    /**
     * Creates a new {@link BiConsumer} where the {@link Key} is responsible
     * for a {@link List} based {@link org.spongepowered.api.data.value.Value.Mutable}. Given the {@link WeightedTable}
     * is already generated, the values requested are only retrieved when
     * the generated biconsumer is called upon.
     *
     * <p>Note that custom data is not supported through this method, use
     * {@link #values(Iterable)} or any variant thereof for applying custom data.</p>
     *
     * @param key The key to use
     * @param weightedTable The weighted table
     * @param <E> The type of elements
     * @return The new biconsumer to apply to an itemstack builder
     */
    public static <E> BiConsumer<ItemStack.Builder, Random> listValues(Key<? extends ListValue.Mutable<E>> key, WeightedTable<E> weightedTable) {
        Objects.requireNonNull(weightedTable, "Weighted table cannot be null!");
        Objects.requireNonNull(key, "Key cannot be null!");
        return setValue(key, random -> ImmutableList.copyOf(weightedTable.get(random)));

    }

    /**
     * Creates a new {@link BiConsumer} where the {@link Key} is responsible
     * for a {@link List} based {@link org.spongepowered.api.data.value.Value.Mutable}. Given the
     * {@link WeightedTable} is exclusively used with {@link Function}s,
     * the {@link Function}s themselves are queried with a {@link Random}
     * and expected to present a singular element of the defined type. It's
     * expected that there are multiple functions to provide additional
     * elements for a particular key'ed {@link org.spongepowered.api.data.value.ListValue.Mutable}.
     *
     * <p>An example usage of this can be for generating a randomized list
     * of {@link Enchantment}s with varying enchantment levels.</p>
     *
     * <p>Note that custom data is not supported through this method, use
     * {@link #values(Iterable)} or any variant thereof for applying custom data.</p>
     *
     * @param key The key to use
     * @param weightedTable The weighted table containing all the desired
     *     functions producing the randomized elements
     * @param <E> The type of element
     * @return The new biconsumer to apply to an itemstack builder
     */
    public static <E> BiConsumer<ItemStack.Builder, Random> listValueSuppliers(Key<? extends ListValue<E>> key,
            WeightedTable<Function<Random, E>> weightedTable) {
        Objects.requireNonNull(key, "Key cannot be null!");
        Objects.requireNonNull(weightedTable, "WeightedTable cannot be null!");
        return (builder, random) -> {
            final ItemStack itemStack = builder.build();
            final List<Function<Random, E>> suppliers = weightedTable.get(random);
            final List<E> suppliedElements = suppliers.stream()
                    .map(randomEFunction -> randomEFunction.apply(random))
                    .collect(Collectors.toList());
            final DataTransactionResult result = itemStack.offer(key, suppliedElements);
            if (result.isSuccessful()) {
                builder.from(itemStack);
            }
        };
    }

    public static <E> BiConsumer<ItemStack.Builder, Random> listValueSuppliers(Supplier<? extends Key<? extends ListValue<E>>> key,
                                                                               WeightedTable<Function<Random, E>> weightedTable) {
        Objects.requireNonNull(key, "Key cannot be null!");
        Objects.requireNonNull(weightedTable, "WeightedTable cannot be null!");
        return (builder, random) -> {
            final ItemStack itemStack = builder.build();
            final List<Function<Random, E>> suppliers = weightedTable.get(random);
            final List<E> suppliedElements = suppliers.stream()
                    .map(randomEFunction -> randomEFunction.apply(random))
                    .collect(Collectors.toList());
            final DataTransactionResult result = itemStack.offer(key.get(), suppliedElements);
            if (result.isSuccessful()) {
                builder.from(itemStack);
            }
        };
    }

    /**
     * Creates a new {@link BiConsumer} where the {@link Key} is responsible
     * for a {@link Set} based {@link org.spongepowered.api.data.value.Value.Mutable}. Given the {@link Set} of element
     * to act as a pool, the consumer will pull a random amount of the
     * given pool and apply it as a new {@link Set}.
     *
     * <p>Note that custom data is not supported through this method, use
     * {@link #values(Iterable)} or any variant thereof for applying custom data.</p>
     *
     * @param key The key to use
     * @param elementPool The set of elements to use as a pool
     * @param <E> The type of element
     * @return The new biconsumer to apply to an itemstack builder
     */
    public static <E> BiConsumer<ItemStack.Builder, Random> setValues(Key<? extends SetValue.Mutable<E>> key, Set<E> elementPool) {
        Objects.requireNonNull(key, "Key cannot be null!");
        Objects.requireNonNull(elementPool, "ElementPool cannot be null!");
        return setValues(key, elementPool, baseWithRandomAddition(1, elementPool.size() - 1));
    }

    /**
     * Creates a new {@link BiConsumer} where the {@link Key} is responsible
     * for a {@link Set} based {@link org.spongepowered.api.data.value.Value.Mutable}. Given the {@link Set} of
     * elements to act as a pool, the consumer will pull a variable amount
     * based on the provided {@link VariableAmount}, and apply it as a new
     * {@link Set}.
     *
     * @param key The key to use
     * @param elementPool The set of elements to use as a pool
     * @param amount The variable amount of elements to get
     * @param <E> The type of element
     * @return The new biconsumer to apply to an itemstack builder
     */
    public static <E> BiConsumer<ItemStack.Builder, Random> setValues(Key<? extends SetValue.Mutable<E>> key, Set<E> elementPool, VariableAmount amount) {
        Objects.requireNonNull(key, "Key cannot be null!");
        Objects.requireNonNull(elementPool, "Element pool cannot be null!");
        Objects.requireNonNull(amount, "VariableAmount cannot be null!");
        if (elementPool.isEmpty()) {
            throw new IllegalArgumentException("Element pool cannot be empty!");
        }
        WeightedTable<E> elementTable = new WeightedTable<>(amount);
        for (E element : elementPool) {
            elementTable.add(element, 1);
        }
        return setValues(key, elementTable);
    }

    /**
     * Creates a new {@link BiConsumer} where the {@link Key} is
     * responsible for a {@link Set} based {@link org.spongepowered.api.data.value.Value.Mutable}. Given
     * the provided {@link WeightedTable}, the consumer will retrieve
     * a {@link List} of values and add them as a new {@link Set}.
     *
     * @param key The key to use
     * @param weightedTable The weighted table acting as an element pool
     * @param <E> The type of element
     * @return The new biconsumer to apply to an itemstack builder
     */
    public static <E> BiConsumer<ItemStack.Builder, Random> setValues(Key<? extends SetValue.Mutable<E>> key, WeightedTable<E> weightedTable) {
        Objects.requireNonNull(weightedTable, "WeightedTable cannot be null!");
        Objects.requireNonNull(key, "Key cannot be null!");
        if (weightedTable.isEmpty()) {
            throw new IllegalArgumentException("WeightedTable cannot be empty!");
        }
        return setValue(key, random -> ImmutableSet.copyOf(weightedTable.get(random)));
    }

    /*Note : This is used internally only, no validation is performed.*/
    private static <E> BiConsumer<ItemStack.Builder, Random> setValue(Key<? extends Value<E>> key, Function<Random, E> element) {
        return (builder, random) -> {
            final ItemStack itemStack = builder.build();
            final DataTransactionResult result = itemStack.offer(key, element.apply(random));
            if (result.isSuccessful()) {
                builder.from(itemStack);
            }
        };
    }

    /**
     * Creates a new {@link BiConsumer} that applies the provided {@link org.spongepowered.api.data.value.Value.Mutable}
     * to the generated {@link ItemStack}.
     *
     * @param value The value to use
     * @param <E> The type of element
     * @param <V> The type of value
     * @return The new biconsumer to apply to an itemstack builder
     */
    public static <E, V extends Value<E>> BiConsumer<ItemStack.Builder, Random> value(V value) {
        return (builder, random) -> {
            final ItemStack itemStack = builder.build();
            final DataTransactionResult dataTransactionResult = itemStack.offer(value);
            if (dataTransactionResult.isSuccessful()) {
                builder.from(itemStack);
            }
        };
    }

    /**
     * Creates a new {@link BiConsumer} that applies a random selection of the
     * provided {@link Value}s.
     *
     * @param values The iterable collection of values to choose from
     * @param <E> The type of element
     * @param <V> The type of value
     * @return The new biconsumer to apply to an itemstack builder
     */
    public static <E, V extends Value<E>> BiConsumer<ItemStack.Builder, Random> values(Iterable<V> values) {
        WeightedTable<V> tableEntries = new WeightedTable<>(1);
        for (V value : values) {
            tableEntries.add(Objects.requireNonNull(value, "Value cannot be null!"), 1);
        }
        return ((builder, random) -> {
            final V value = tableEntries.get(random).get(0);
            final ItemStack itemStack = builder.build();
            final DataTransactionResult result = itemStack.offer(value);
            if (result.isSuccessful()) {
                builder.from(itemStack);
            }
        });
    }

    /**
     * Creates a new {@link BiConsumer} that provides a {@link VariableAmount}
     * of {@link Value}s from the provided pool. Note that no
     * validation can be performed, however the builder will ignore unsupported
     * data.
     *
     * @param manipulators The manipulator pool to use
     * @param rolls The variable amount of manipulators to apply
     * @return The new biconsumer to apply to an itemstack builder
     */
    public static BiConsumer<ItemStack.Builder, Random> values(Collection<Value.Immutable<?>> manipulators, VariableAmount rolls) {
        Objects.requireNonNull(manipulators, "Manipulators cannot be null!");
        Objects.requireNonNull(rolls, "VariableAmount cannot be null!");
        final ImmutableList<Value.Immutable<?>> copied = ImmutableList.copyOf(manipulators);
        final WeightedTable<Value.Immutable<?>> table = new WeightedTable<>();
        table.setRolls(rolls);
        copied.forEach(manipulator1 -> table.add(manipulator1, 1));
        return values(table);
    }

    /**
     * Creates a new {@link BiConsumer} that provides a variable
     * amount of {@link Value}s from the provided
     * {@link WeightedTable}. Note that no validation can be performed, however
     * the builder will ignore unsupported data.
     *
     * @param weightedTable The weighted table containing manipulators
     * @return The new biconsumer to apply to an itemstack builder
     */
    public static BiConsumer<ItemStack.Builder, Random> values(WeightedTable<Value.Immutable<?>> weightedTable) {
        Objects.requireNonNull(weightedTable, "WeightedTable cannot be null!");
        return (builder, random) -> weightedTable.get(random).forEach(builder::add);
    }

    /**
     * Creates a new {@link BiConsumer} that takes the provided
     * {@link EnchantmentType} and applies it to the generated {@link ItemStack}.
     * The enchantmentType level is varied based on vanilla mechanics.
     *
     * @param enchantmentType The singular enchantmentType to add
     * @return The new biconsumer to apply to an itemstack builder
     */
    public static BiConsumer<ItemStack.Builder, Random> enchantment(EnchantmentType enchantmentType) {
        return enchantment(fixed(1), enchantmentType);
    }

    /**
     * Creates a new {@link BiConsumer} that takes the provided
     * {@link EnchantmentType} and applies it to the generated {@link ItemStack}.
     * The enchantmentType level is defined by the variable amount provided.
     *
     * @param level The variance in enchantmentType level
     * @param enchantmentType The enchantmentType to add
     * @return The new biconsumer to apply to an itemstack builder
     */
    public static BiConsumer<ItemStack.Builder, Random> enchantment(VariableAmount level, EnchantmentType enchantmentType) {
        Objects.requireNonNull(level, "VariableAmount cannot be null!");
        Objects.requireNonNull(enchantmentType, "EnchantmentType cannot be null!");
        return enchantments(fixed(1), ImmutableList.of(new Tuple<>(enchantmentType, level)));
    }

    /**
     * Creates a new {@link BiConsumer} that takes the provided
     * {@link Collection} of {@link EnchantmentType}s and applies a
     * singular {@link EnchantmentType} with varying levels to the generated
     * {@link ItemStack}.
     *
     * @param enchantmentTypes The enchantment pool to choose from
     * @return The new biconsumer to apply to an itemstack builder
     */
    public static BiConsumer<ItemStack.Builder, Random> enchantmentsWithVanillaLevelVariance(Collection<EnchantmentType> enchantmentTypes) {
        return enchantmentsWithVanillaLevelVariance(fixed(1), ImmutableList.copyOf(enchantmentTypes));
    }

    /**
     * Creates a new {@link BiConsumer} that takes the provided
     * {@link EnchantmentType}s and applies a variable amount of enchantmentTypes
     * with varying levels to the generated {@link ItemStack}.
     *
     * @param amount The variable amount of enchantmentTypes to use
     * @param enchantmentType The first enchantmentType to add
     * @param enchantmentTypes The additional enchantmentTypes to use
     * @return The new biconsumer to apply to an itemstack builder
     */
    public static BiConsumer<ItemStack.Builder, Random> enchantmentsWithVanillaLevelVariance(VariableAmount amount, EnchantmentType enchantmentType,
            EnchantmentType... enchantmentTypes) {
        return enchantmentsWithVanillaLevelVariance(amount,
                ImmutableList.<EnchantmentType>builder().add(enchantmentType).addAll(Arrays.asList(enchantmentTypes)).build());
    }

    /**
     * Creates a new {@link BiConsumer} that takes the provided
     * {@link Collection} of {@link EnchantmentType}s and applies a varying amount
     * of generated enchantments to the generated {@link ItemStack}.
     *
     * @param amount The varying amount of enchantments to use
     * @param itemEnchantmentTypes The enchantment pool to use
     * @return The new biconsumer to apply to an itemstack builder
     */
    public static BiConsumer<ItemStack.Builder, Random> enchantmentsWithVanillaLevelVariance(VariableAmount amount,
            Collection<EnchantmentType> itemEnchantmentTypes) {
        Objects.requireNonNull(amount, "Variable amount cannot be null!");
        Objects.requireNonNull(itemEnchantmentTypes, "EnchantmentType collection cannot be null!");
        List<Tuple<EnchantmentType, VariableAmount>> list = itemEnchantmentTypes.stream()
                .map(enchantment -> {
                    Objects.requireNonNull(enchantment, "EnchantmentType cannot be null!");
                    final int minimum = enchantment.getMinimumLevel();
                    final int maximum = enchantment.getMaximumLevel();
                    return new Tuple<>(enchantment, baseWithRandomAddition(minimum, maximum - minimum));
                })
                .collect(Collectors.toList());
        return enchantments(amount, list);
    }

    /**
     * Creates a new {@link BiConsumer} that takes the provided
     * {@link Collection} of coupled {@link EnchantmentType} and
     * {@link VariableAmount} to apply varying enchantments of varying amounts
     * to the generated {@link ItemStack}.
     *
     * @param amount The varying amount of enchantments
     * @param enchantments The collection of enchantment tuples combining the
     *     enchantment and the variable amount of level to apply
     * @return The new biconsumer to apply to an itemstack builder
     */
    public static BiConsumer<ItemStack.Builder, Random> enchantments(VariableAmount amount,
            Collection<Tuple<EnchantmentType, VariableAmount>> enchantments) {
        Objects.requireNonNull(amount, "VariableAmount cannot be null!");
        final WeightedTable<Function<Random, Enchantment>> suppliers = new WeightedTable<>(amount);
        for (Tuple<EnchantmentType, VariableAmount> enchantment : enchantments) {
            suppliers.add(random ->
                Enchantment.builder().type(enchantment.getFirst()).level(enchantment.getSecond().getFlooredAmount(random)).build(), 1);
        }
        return listValueSuppliers(Keys.APPLIED_ENCHANTMENTS, suppliers);
    }

    // Suppress default constructor to ensure non-instantiability.
    private ItemStackBuilderPopulators() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
