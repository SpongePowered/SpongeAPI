/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

import com.google.common.base.Optional;
import org.spongepowered.api.attribute.AttributeSource;
import org.spongepowered.api.attribute.MutableAttributeSource;
import org.spongepowered.api.item.ItemDataTransactionResult;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.data.ItemData;
import org.spongepowered.api.item.properties.ItemProperty;
import org.spongepowered.api.service.persistence.DataSerializable;
import org.spongepowered.api.service.persistence.InvalidDataException;
import org.spongepowered.api.service.persistence.data.DataContainer;
import org.spongepowered.api.service.persistence.data.DataHolder;

import java.util.Collection;

/**
 * Represents a stack of a specific {@link ItemType}. Supports serialization and
 * can be compared using the comparators listed in {@link ItemStackComparators}.
 *
 * <p>{@link ItemStack}s have varying properties and data, it is adviseable to
 * use {@link DataHolder#getData(Class)} to retrieve different information
 * regarding this item stack.</p>
 */
public interface ItemStack extends DataHolder, DataSerializable, AttributeSource {

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
     * Set the max quantity per stack. This overrides, and is entirely separate
     * from {@link ItemType#getMaxStackQuantity()}.
     *
     * @param quantity Max stack quantity
     */
    void setMaxStackQuantity(int quantity);

    /**
     * Sets the respective item data onto this {@link ItemStack}.
     *
     * <p>Certain {@link ItemData} transactions may be validated before
     * setting, in which case the item data is checked to ensure it can be
     * applied to this {@link ItemStack}. If the transaction is anything but
     * normal, the item stack is unchanged.</p>
     *
     * @param itemData The item data instance to set
     * @param <T> The type of data
     * @return The result of the transaction, if successful or not
     */
    <T extends ItemData<T>> ItemDataTransactionResult setItemData(T itemData);

    /**
     * Attempts to fetch the desired {@link ItemData} object for this
     * {@link ItemStack}. If the item data does not exist, an attempt is
     * made to create one.
     *
     * <p>Not all {@link ItemData}s can be applied to every {@link ItemStack}.
     * The limitations are not defined. However, if the item data can be applied
     * to this itemstack, the newly created item data is returned for use.</p>
     *
     * @param dataClass The item data class
     * @param <T> The type of item data
     * @return The item data data, if available and applicable
     */
    <T extends ItemData<T>> Optional<T> getOrCreateItemData(Class<T> dataClass);

    /**
     * Gets all {@link ItemProperty}(ies) belonging to this {@link ItemStack}.
     *
     * <p>The returned collection can not be modified as the properties are
     * intrinsic to the item itself.</p>
     *
     * @return An immutable collection of all properties belonging to this item
     */
    Collection<ItemProperty<?, ?>> getProperties();

    /**
     * Gets an immutable collection of all {@link ItemData} associated with
     * this {@link ItemStack}.
     *
     * <p>The returned collection can not be modified and the {@link ItemData}
     * are not live (changes to the individual item data will not change on this
     * item stack).</p>
     *
     * @return An immutable collection of all item data belonging to this item
     */
    Collection<ItemData<?>> getItemData();

    /**
     * Validates the container with known data required to set the raw data to
     * this {@link ItemStack}. If the container is incomplete or contains
     * invalid data, <code>false</code> is returned.
     *
     * <p>This validation should be checked prior to calling
     * {@link #setRawData(DataContainer)} to avoid exceptions.</p>
     *
     * @param container The raw data to validate
     * @return True if the data is valid
     */
    boolean validateData(DataContainer container);

    /**
     * Attempts to set all data of this {@link ItemStack} according to the
     * {@link DataContainer}'s held information. Using this to modify known
     * {@link ItemData} is unsupported and if the data is invalid, an
     * {@link InvalidDataException} is thrown.
     *
     * <p>This setter is used to provide setting custom data that is not
     * represented by the Items API, including forge mods and other unknown
     * data. Attempts at validating known {@link ItemData} contained in the
     * data container are made with the assumption that all necessary data
     * exists.</p>
     *
     * @param container A container containing all raw data to set on this item
     * @throws InvalidDataException If the container is missing or has invalid
     *     data that this stack will refuse
     */
    void setRawData(DataContainer container) throws InvalidDataException;

}
