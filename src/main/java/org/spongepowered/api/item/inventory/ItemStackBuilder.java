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

import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.tileentity.TileEntity;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.item.ItemType;

/**
 * Represents a builder interface to create an {@link ItemStack}.
 */
public interface ItemStackBuilder {

    /**
     * Sets the {@link ItemType} of the item stack.
     *
     * @param itemType The type of item
     * @return This builder, for chaining
     */
    ItemStackBuilder itemType(ItemType itemType);

    /**
     * Sets the quantity of the item stack.
     *
     * @param quantity The quantity of the item stack
     * @return This builder, for chaining
     * @throws IllegalArgumentException If the quantity is outside the allowed bounds
     */
    ItemStackBuilder quantity(int quantity) throws IllegalArgumentException;

    /**
     * Sets the {@link DataManipulator} to add to the {@link ItemStack}.
     *
     * @param itemData The item data to set
     * @return This builder, for chaining
     * @throws IllegalArgumentException If the item data is incompatible with the item
     */
    ItemStackBuilder itemData(DataManipulator<?, ?> itemData) throws IllegalArgumentException;

    /**
     * Sets the {@link ImmutableDataManipulator} to add to the
     * {@link ItemStack}.
     *
     * @param itemData The item data to set
     * @return This builder, for chaining
     * @throws IllegalArgumentException If the item data is incompatible
     */
    ItemStackBuilder itemData(ImmutableDataManipulator<?, ?> itemData) throws IllegalArgumentException;

    /**
     * Sets all the settings in this builder from the item stack blueprint.
     *
     * @param itemStack The item stack to copy
     * @return This builder, for chaining
     */
    ItemStackBuilder fromItemStack(ItemStack itemStack);

    /**
     * Sets the data to recreate a {@link BlockState} in a held {@link ItemStack}
     * state.
     *
     * @param blockState The block state to use
     * @return This builder, for chaining
     */
    default ItemStackBuilder fromBlockState(BlockState blockState) {
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
     * @param container The container to deserialize
     * @return This bulder, for chaining
     */
    ItemStackBuilder fromContainer(DataView container);

    /**
     * Reconstructs this builder to use the {@link ItemStackSnapshot}
     * for all the values and data it may contain.
     *
     * @param snapshot The snapshot
     * @return This builder, for chaining
     */
    default ItemStackBuilder fromSnapshot(ItemStackSnapshot snapshot) {
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
    ItemStackBuilder fromBlockSnapshot(BlockSnapshot blockSnapshot);

    /**
     * Resets all information regarding the item stack to be created.
     *
     * @return This builder, for chaining
     */
    ItemStackBuilder reset();

    /**
     * Builds an instance of an ItemStack.
     *
     * @return A new instance of an ItemStack
     * @throws IllegalStateException If the item stack is not completed
     */
    ItemStack build() throws IllegalStateException;

}
