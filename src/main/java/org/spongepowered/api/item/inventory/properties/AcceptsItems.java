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
package org.spongepowered.api.item.inventory.properties;

import java.util.Collection;

import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.InventoryProperty;


/**
 * A property type intended for use with {@link
 * org.spongepowered.api.item.inventory.type.InputSlot}s in order to query for
 * slots which can accept items of the specified type. It is intended that the
 * semantics of the {@link #equals} will be such that the method will return
 * true if the other property contains <em>any</em> item present in this
 * property's collection.
 */
public interface AcceptsItems extends InventoryProperty<String, Collection<ItemType>> {

    /**
     * Get the list of {@link ItemType}s accepted by this slot
     */
    @Override
    public abstract Collection<ItemType> getValue();
    
    /**
     * Returns true if <em>other</em> is also an {@link AcceptsItems} property
     * and <b>any</b> item appearing in the other property's collecion appears
     * in this property's collection. In formal terms, the method returns true
     * if the size of the intersection between the two item type collections is
     * greater than zero.
     */
    @Override
    public abstract boolean equals(Object other);
}
