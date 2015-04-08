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

package org.spongepowered.api.item;

import com.google.common.base.Optional;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.properties.ItemProperty;
import org.spongepowered.api.text.translation.Translatable;
import org.spongepowered.api.util.annotation.CatalogedBy;

/**
 * A type of item.
 */
@CatalogedBy(ItemTypes.class)
public interface ItemType extends CatalogType, Translatable {

    /**
     * Gets the id of this item.
     *
     * <p>Ex. Minecraft registers a golden carrot as
     * "minecraft:golden_carrot".</p>
     *
     * @return The id
     */
    String getName();

    /**
     * Get the default maximum quantity for
     * {@link ItemStack}s of this item.
     *
     * @return Max stack quantity
     */
    int getMaxStackQuantity();

    /**
     * Gets the default {@link ItemProperty} of this {@link ItemType}.
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
    <T extends ItemProperty<?, ?>> Optional<T> getDefaultProperty(Class<T> propertyClass);

}
