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

import org.spongepowered.api.data.KeyValueMatcher;
import org.spongepowered.api.item.inventory.InventoryKeys;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.math.vector.Vector2i;

/**
 * A collection of {@link KeyValueMatcher}s that
 * can be used to query for {@link Slot}s.
 */
public final class SlotMatchers {

    /**
     * Creates a {@link KeyValueMatcher} with the default operator
     * {@link org.spongepowered.api.data.KeyValueMatcher.Operator#EQUAL} to match against slot
     * indexes.
     *
     * @param index The slot index
     * @return The property query
     */
    public static KeyValueMatcher<Integer> index(int index) {
        return KeyValueMatcher.of(InventoryKeys.SLOT_INDEX, index);
    }

    /**
     * Creates a {@link KeyValueMatcher} to match against slot indexes.
     *
     * @param index The slot index value
     * @param operator The operator
     * @return The property query
     */
    public static KeyValueMatcher<Integer> index(int index, KeyValueMatcher.Operator operator) {
        return KeyValueMatcher.of(InventoryKeys.SLOT_INDEX, index, operator);
    }

    /**
     * Creates a {@link KeyValueMatcher} with the default operator
     * {@link org.spongepowered.api.data.KeyValueMatcher.Operator#EQUAL} to match against a
     * slot position.
     *
     * @param pos The slot position
     * @return The property query
     */
    public static KeyValueMatcher<Vector2i> position(Vector2i pos) {
        return KeyValueMatcher.of(InventoryKeys.SLOT_POSITION, pos);
    }

    /**
     * Creates a {@link KeyValueMatcher} with the default operator
     * {@link org.spongepowered.api.data.KeyValueMatcher.Operator#EQUAL} to match against a
     * slot position.
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @return The property query
     */
    public static KeyValueMatcher<Vector2i> position(int x, int y) {
        return position(new Vector2i(x, y));
    }

    /**
     * Creates a {@link KeyValueMatcher} to match against a
     * slot position.
     *
     * @param pos The slot position
     * @param operator The operator
     * @return The property query
     */
    public static KeyValueMatcher<Vector2i> position(Vector2i pos, KeyValueMatcher.Operator operator) {
        return KeyValueMatcher.of(InventoryKeys.SLOT_POSITION, pos, operator);
    }

    /**
     * Creates a {@link KeyValueMatcher} to match against a
     * slot position.
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param operator The operator
     * @return The property query
     */
    public static KeyValueMatcher<Vector2i> position(int x, int y, KeyValueMatcher.Operator operator) {
        return position(new Vector2i(x, y), operator);
    }

    // Suppress default constructor to ensure non-instantiability.
    private SlotMatchers() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
