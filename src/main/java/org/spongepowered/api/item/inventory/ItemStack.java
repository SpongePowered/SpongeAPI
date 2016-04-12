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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.tileentity.TileEntity;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.text.translation.Translatable;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Map;
import java.util.Set;

/**
 * Represents a stack of a specific {@link ItemType}. Supports serialization and
 * can be compared using the comparators listed in {@link ItemStackComparators}.
 *
 * <p>{@link ItemStack}s have varying properties and data, it is adviseable to
 * use {@link DataHolder#get(Class)} to retrieve different information
 * regarding this item stack.</p>
 */
public interface ItemStack extends DataHolder, DataSerializable, Translatable {

    /**
     * Creates a new {@link Builder} to build an {@link ItemStack}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Creates a new {@link ItemStack} of the provided {@link ItemType}
     * and quantity.
     *
     * @param itemType The item type
     * @param quantity The quantity
     * @return The new item stack
     */
    static ItemStack of(ItemType itemType, int quantity) {
        return builder().itemType(itemType).quantity(quantity).build();
    }


    /**
     * Gets the {@link ItemType} of this {@link ItemStack}.
     *
     * @return The item type
     */
    ItemType getItem();

    /**
     * Gets the quantity of items in this stack. This may exceed the max stack
     * size of the item, and if added to an inventory will then be divided by
     * the max stack.
     *
     * @return Quantity of items
     */
    int getQuantity();

    /**
     * Sets the quantity in this stack.
     *
     * @param quantity Quantity
     * @throws IllegalArgumentException If quantity set exceeds the
     * {@link ItemStack#getMaxStackQuantity()}
     */
    void setQuantity(int quantity) throws IllegalArgumentException;

    /**
     * Get the maximum quantity per stack. By default, returns
     * {@link ItemType#getMaxStackQuantity()}, unless a
     * different value has been set for this specific stack.
     *
     * @return Max stack quantity
     */
    int getMaxStackQuantity();

    /**
     * Gets the {@link ItemStackSnapshot} of this {@link ItemStack}. All known
     * {@link DataManipulator}s existing on this {@link ItemStack} are added
     * as copies to the {@link ItemStackSnapshot}.
     *
     * @return The newly created item stack snapshot
     */
    ItemStackSnapshot createSnapshot();

    /**
     * Returns true if the specified {@link ItemStack} has the same stack
     * size, {@link ItemType}, and data. Note that this method is not an
     * overrider of {@link Object#equals(Object)} in order to maintain
     * compatibility with the base game. Therefore, ItemStacks may not behave
     * as expected when using them in equality based constructs such as
     * {@link Map}s or {@link Set}s.
     *
     * @param that ItemStack to compare
     * @return True if this equals the ItemStack
     */
    boolean equalTo(ItemStack that);

    @Override
    ItemStack copy();
    
    interface Builder extends ResettableBuilder<ItemStack, Builder> {
        
        /**
         * Sets the {@link ItemType} of the item stack.
         *
         * @param itemType The type of item
         * @return This builder, for chaining
         */
        Builder itemType(ItemType itemType);

        /**
         * Sets the quantity of the item stack.
         *
         * @param quantity The quantity of the item stack
         * @return This builder, for chaining
         * @throws IllegalArgumentException If the quantity is outside the allowed bounds
         */
        Builder quantity(int quantity) throws IllegalArgumentException;

        /**
         * Adds a {@link Key} and related {@link Object} value to apply to the
         * resulting {@link ItemStack}. Note that the resulting
         * {@link ItemStack} may not actually accept the provided {@code Key}
         * for various reasons due to support or simply that the value itself
         * is not supported. Offering custom data is not supported through this,
         * use {@link #itemData(DataManipulator)} instead.
         *
         * @param key The key to identiy the value to
         * @param value The value to apply
         * @param <E> The type of value
         * @return This builder, for chaining
         */
        <E> Builder keyValue(Key<? extends BaseValue<E>> key, E value);

        /**
         * Sets the {@link DataManipulator} to add to the {@link ItemStack}.
         *
         * @param itemData The item data to set
         * @return This builder, for chaining
         * @throws IllegalArgumentException If the item data is incompatible with the item
         */
        Builder itemData(DataManipulator<?, ?> itemData) throws IllegalArgumentException;

        /**
         * Sets the {@link ImmutableDataManipulator} to add to the
         * {@link ItemStack}.
         *
         * @param itemData The item data to set
         * @return This builder, for chaining
         * @throws IllegalArgumentException If the item data is incompatible
         */
        Builder itemData(ImmutableDataManipulator<?, ?> itemData) throws IllegalArgumentException;

        /**
         * Adds the given {@link Key} with the given value.
         *
         * @param key The key to assign the value with
         * @param value The value to assign with the key
         * @param <V> The type of the value
         * @return This builder, for chaining
         * @throws IllegalArgumentException If the item data is incompatible
         */
        <V> Builder add(Key<? extends BaseValue<V>> key, V value) throws IllegalArgumentException;

        /**
         * Sets all the settings in this builder from the item stack blueprint.
         *
         * @param itemStack The item stack to copy
         * @return This builder, for chaining
         */
        Builder fromItemStack(ItemStack itemStack);

        /**
         * Sets the data to recreate a {@link BlockState} in a held {@link ItemStack}
         * state.
         *
         * @param blockState The block state to use
         * @return This builder, for chaining
         */
        default Builder fromBlockState(BlockState blockState) {
            checkNotNull(blockState);
            final BlockType blockType= blockState.getType();
            checkArgument(blockType.getItem().isPresent(), "Missing valid ItemType for BlockType: " + blockType.getId());
            itemType(blockType.getItem().get());
            blockState.getContainers().forEach(this::itemData);
            return this;
        }

        /**
         * Attempts to reconstruct the builder with all of the data from
         * {@link ItemStack#toContainer()} including all custom data.
         *
         * @param container The container to translate
         * @return This bulder, for chaining
         */
        Builder fromContainer(DataView container);

        /**
         * Reconstructs this builder to use the {@link ItemStackSnapshot}
         * for all the values and data it may contain.
         *
         * @param snapshot The snapshot
         * @return This builder, for chaining
         */
        default Builder fromSnapshot(ItemStackSnapshot snapshot) {
            return fromItemStack(snapshot.createStack());
        }

        /**
         * Attempts to reconstruct a {@link BlockSnapshot} including all data
         * and {@link TileEntity} related data if necessary for creating an
         * {@link ItemStack} representation.
         *
         * @param blockSnapshot The snapshot to use
         * @return This builder, for chaining
         */
        Builder fromBlockSnapshot(BlockSnapshot blockSnapshot);

        /**
         * Builds an instance of an ItemStack.
         *
         * @return A new instance of an ItemStack
         * @throws IllegalStateException If the item stack is not completed
         */
        ItemStack build() throws IllegalStateException;        
    }
}
