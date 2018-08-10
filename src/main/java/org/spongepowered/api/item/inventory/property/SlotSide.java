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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.inventory.InventoryProperty;
import org.spongepowered.api.util.Direction;

/**
 * property which represents a "side" for a particular slot, for use in querying
 * "sided inventories".
 */
public interface SlotSide extends InventoryProperty<String, Direction> {

    /**
     * Create a SlotSide property which matches SlotSide properties with equal
     * value.
     * 
     * @param value the value to match
     * @return new property
     */
    static SlotSide of(Direction value) {
        return builder().value(value).operator(Operator.EQUAL).build();
    }

    /**
     * Creates a new {@link Builder} to create {@link SlotSide}s.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Represents a builder class to create {@link SlotSide}s.
     */
    interface Builder extends InventoryProperty.Builder<Direction, SlotSide, Builder> {

    }

}
