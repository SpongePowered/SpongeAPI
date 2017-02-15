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
package org.spongepowered.api.item.inventory.property;

import org.spongepowered.api.data.Property;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.Coerce;

/**
 * The Title of an Inventory, viewable by players looking at the Inventory.
 */
public class InventoryTitle extends AbstractInventoryProperty<String, Text> {

    public static final String PROPERTY_NAME = "inventorytitle";

    /**
     * Creates a new {@link InventoryTitle} to be displayed on an {@link Inventory}.
     *
     * @param value The text value to display
     */
    public InventoryTitle(Text value) {
        super(value);
    }

    @Override
    public int compareTo(Property<?, ?> other) {
        if (other == null) {
            return 1;
        }
        return this.getValue().toString().compareTo(Coerce.toString(other.getValue()));
    }

    /**
     * Creates a new {@link InventoryTitle} with the provided {@link Text}.
     *
     * @param value The text value to display
     * @return The new inventory title
     */
    public static InventoryTitle of(Text value) {
        return new InventoryTitle(value);
    }

}
