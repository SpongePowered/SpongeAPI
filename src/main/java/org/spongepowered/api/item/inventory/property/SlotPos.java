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

import com.flowpowered.math.vector.Vector2i;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.InventoryProperty;
import org.spongepowered.api.item.inventory.query.QueryOperationTypes;

/**
 * An inventory property which represents a position within a grid. Bear in mind
 * that this property should be queried against the relevant parent, since a
 * slot may have multiple parent inventories. 
 */
public interface SlotPos extends InventoryProperty<String, Vector2i> {

    /**
     * Create an SlotPos property which matches SlotPos properties with equal
     * value.
     *
     * @param x the x position of the slot to match
     * @param y the y position of the slot to match
     * @return new property
     */
    static SlotPos of(int x, int y) {
        return of(new Vector2i(x, y));
    }

    /**
     * Create an SlotPos property which matches SlotPos properties with equal
     * value.
     *
     * @param value the value to match
     * @return new property
     */
    static SlotPos of(Vector2i value) {
        return builder().value(value).operator(Operator.EQUAL).build();
    }

    /**
     * Creates a new {@link Builder} to create {@link SlotPos}s.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the X position of this slot within the queried parent.
     *
     * @return slot x coordinate
     */
    int getX();

    /**
     * Gets the Y position of this slot within the queried parent.
     *
     * @return slot y coordinate
     */
    int getY();

    /**
     * Represents a builder class to create {@link SlotPos}s.
     */
    interface Builder extends InventoryProperty.Builder<Vector2i, SlotPos, Builder> {
    }
}
