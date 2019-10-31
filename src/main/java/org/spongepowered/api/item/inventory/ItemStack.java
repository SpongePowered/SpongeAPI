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
import org.spongepowered.api.block.entity.BlockEntity;
import org.spongepowered.api.data.DataHolderBuilder;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.SerializableDataHolder;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.text.translation.Translatable;

import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Represents a stack of a specific {@link ItemType}. Supports serialization and
 * can be compared using the comparators listed in {@link ItemStackComparators}.
 *
 * <p>{@link ItemStack}s have a variety of properties and data. It is advised to
 * use {@link ValueContainer#get(Key)} in order to retrieve information regarding
 * this item stack.</p>
 */
public interface ItemStack extends SerializableDataHolder.Mutable, Translatable {

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
     * Creates a new {@link ItemStack} of the provided {@link ItemType} and quantity of 1
     *
     * @param itemType The item type
     * @return The new item stack
     */
    static ItemStack of(ItemType itemType) {
        return of(itemType, 1);
    }

    /**
     * Returns an empty {@link ItemStack}.
     *
     * @return The empty ItemStack
     */
    static ItemStack empty() {
        return builder().itemType(ItemTypes.AIR).build();
    }

    /**
     * Gets the {@link ItemType} of this {@link ItemStack}.
     *
     * @return The item type
     */
    ItemType getType();

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
     * Gets the maximum quantity per stack. By default, returns
     * {@link ItemType#getMaxStackQuantity()}, unless a
     * different value has been set for this specific stack.
     *
     * @return Max stack quantity
     */
    int getMaxStackQuantity();

    /**
     * Gets the {@link ItemStackSnapshot} of this {@link ItemStack}. All
     * known {@link Value}s existing on this {@link ItemStack} are added
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

    /**
     * Returns true if {@link #getQuantity()} is zero and therefore this
     * ItemStack is empty.
     *
     * <p>In Vanilla empty ItemStacks are not rendered by the client.</p>
     *
     * @return True if this ItemStack is empty
     */
    boolean isEmpty();

    @Override
    ItemStack copy();

    interface Builder extends DataHolderBuilder.Mutable<ItemStack, Builder> {

        /**
         * Sets the {@link ItemType} of the item stack.
         *
         * @param itemType The type of item
         * @return This builder, for chaining
         */
        Builder itemType(ItemType itemType);

        ItemType getCurrentItem();

        /**
         * Sets the quantity of the item stack.
         *
         * @param quantity The quantity of the item stack
         * @return This builder, for chaining
         * @throws IllegalArgumentException If the quantity is outside the
         *      allowed bounds
         */
        Builder quantity(int quantity) throws IllegalArgumentException;

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
            final BlockType blockType = blockState.getType();
            checkArgument(blockType.getItem().isPresent(), "Missing valid ItemType for BlockType: " + blockType.getKey().toString());
            itemType(blockType.getItem().get());
            blockState.getValues().forEach(this::add);
            return this;
        }

        /**
         * Attempts to reconstruct the builder with all of the data from
         * {@link ItemStack#toContainer()} including all custom data.
         *
         * @param container The container to translate
         * @return This builder, for chaining
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
         * and {@link BlockEntity} related data if necessary for creating an
         * {@link ItemStack} representation.
         *
         * @param blockSnapshot The snapshot to use
         * @return This builder, for chaining
         */
        Builder fromBlockSnapshot(BlockSnapshot blockSnapshot);

        default Builder apply(Predicate<Builder> predicate, Consumer<Builder> consumer) {
            if (predicate.test(this)) {
                consumer.accept(this);
            }
            return this;
        }

        /**
         * Builds an instance of an ItemStack.
         *
         * @return A new instance of an ItemStack
         * @throws IllegalStateException If the item stack is not completed
         */
        ItemStack build() throws IllegalStateException;
    }
}
