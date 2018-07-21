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
package org.spongepowered.api.item.inventory.slot;

import com.flowpowered.math.vector.Vector2i;
import org.spongepowered.api.data.property.PropertyMatcher;
import org.spongepowered.api.item.inventory.InventoryProperties;
import org.spongepowered.api.item.inventory.Slot;

/**
 * A collection of {@link PropertyMatcher}s that
 * can be used to query for {@link Slot}s.
 */
public final class SlotMatchers {

    /**
     * Creates a {@link PropertyMatcher} with the default operator
     * {@link PropertyMatcher.Operator#EQUAL} to match against slot
     * indexes.
     *
     * @param index The slot index
     * @return The property query
     */
    public static PropertyMatcher<SlotIndex> index(SlotIndex index) {
        return PropertyMatcher.of(InventoryProperties.SLOT_INDEX, index);
    }

    /**
     * Creates a {@link PropertyMatcher} with the default operator
     * {@link PropertyMatcher.Operator#EQUAL} to match against slot
     * indexes.
     *
     * @param index The slot index value
     * @return The property query
     */
    public static PropertyMatcher<SlotIndex> index(int index) {
        return index(SlotIndex.of(index));
    }

    /**
     * Creates a {@link PropertyMatcher} to match against slot indexes.
     *
     * @param index The slot index
     * @param operator The operator
     * @return The property query
     */
    public static PropertyMatcher<SlotIndex> index(SlotIndex index, PropertyMatcher.Operator operator) {
        return PropertyMatcher.of(InventoryProperties.SLOT_INDEX, index, operator);
    }

    /**
     * Creates a {@link PropertyMatcher} to match against slot indexes.
     *
     * @param index The slot index value
     * @param operator The operator
     * @return The property query
     */
    public static PropertyMatcher<SlotIndex> index(int index, PropertyMatcher.Operator operator) {
        return PropertyMatcher.of(InventoryProperties.SLOT_INDEX, SlotIndex.of(index), operator);
    }

    /**
     * Creates a {@link PropertyMatcher} with the default operator
     * {@link PropertyMatcher.Operator#EQUAL} to match against a
     * slot position.
     *
     * @param pos The slot position
     * @return The property query
     */
    public static PropertyMatcher<Vector2i> position(Vector2i pos) {
        return PropertyMatcher.of(InventoryProperties.SLOT_POSITION, pos);
    }

    /**
     * Creates a {@link PropertyMatcher} with the default operator
     * {@link PropertyMatcher.Operator#EQUAL} to match against a
     * slot position.
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @return The property query
     */
    public static PropertyMatcher<Vector2i> position(int x, int y) {
        return position(new Vector2i(x, y));
    }

    /**
     * Creates a {@link PropertyMatcher} to match against a
     * slot position.
     *
     * @param pos The slot position
     * @param operator The operator
     * @return The property query
     */
    public static PropertyMatcher<Vector2i> position(Vector2i pos, PropertyMatcher.Operator operator) {
        return PropertyMatcher.of(InventoryProperties.SLOT_POSITION, pos, operator);
    }

    /**
     * Creates a {@link PropertyMatcher} to match against a
     * slot position.
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param operator The operator
     * @return The property query
     */
    public static PropertyMatcher<Vector2i> position(int x, int y, PropertyMatcher.Operator operator) {
        return position(new Vector2i(x, y), operator);
    }

    // Suppress default constructor to ensure non-instantiability.
    private SlotMatchers() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
