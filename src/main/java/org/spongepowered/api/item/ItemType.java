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
package org.spongepowered.api.item;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.ItemDictionary;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.data.Property;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.text.translation.Translatable;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Optional;

/**
 * A type of item.
 */
@CatalogedBy(ItemTypes.class)
public interface ItemType extends CatalogType, Translatable, ItemDictionary.Entry {

    /**
     * Gets the corresponding {@link BlockType} of this item if one exists.
     * 
     *  @return The Block
     */
    Optional<BlockType> getBlock();

    /**
     * Gets the id of this item.
     *
     * <p>Ex. Minecraft registers a golden carrot as
     * "minecraft:golden_carrot".</p>
     *
     * @return The id
     */
    @Override
    String getName();

    /**
     * Get the default maximum quantity for
     * {@link ItemStack}s of this item.
     *
     * @return Max stack quantity
     */
    int getMaxStackQuantity();

    /**
     * Gets the default {@link Property} of this {@link ItemType}.
     *
     * <p>While item stacks do have properties, generally, there is an
     * intrinsic default property for many item types. However, it should be
     * considered that when mods are introducing their own custom items, they
     * too could introduce different item properties based on various data on
     * the item stack. The default properties retrieved from here should merely
     * be considered as a default, not as a definitive property.</p>
     *
     * @param propertyClass The item property class
     * @param <T> The type of item property
     * @return The item property, if available
     */
    <T extends Property<?, ?>> Optional<T> getDefaultProperty(Class<T> propertyClass);
    
    @Override
    default ItemType getType() {
        return this;
    }
    
    @Override
    default boolean matches(ItemStack stack) {
        return checkNotNull(stack, "stack").getItem().equals(this);
    }

    @Override
    default boolean isSpecific() {
        return false;
    }

    @Override
    default ItemStackSnapshot getTemplate() {
        return ItemStack.of(this, 1).createSnapshot();
    }

}
