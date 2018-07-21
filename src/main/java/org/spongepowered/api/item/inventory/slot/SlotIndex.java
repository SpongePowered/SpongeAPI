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

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.base.MoreObjects;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.Slot;

/**
 * Represents the index of a {@link Slot}
 * within an {@link Inventory}.
 */
public final class SlotIndex implements Comparable<SlotIndex> {

    /**
     * Constructs a new {@link SlotIndex} with the given index value.
     *
     * @param index The index
     * @throws IllegalArgumentException If a negative index value is provided
     */
    public static SlotIndex of(int index) {
        return new SlotIndex(index);
    }

    private final int index;

    private SlotIndex(int index) {
        checkArgument(index >= 0, "Slot index can never be negative");
        this.index = index;
    }

    /**
     * Gets the index.
     *
     * @return The index
     */
    public int getIndex() {
        return this.index;
    }

    @Override
    public int compareTo(SlotIndex o) {
        return Integer.compare(this.index, o.index);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper("SlotIndex")
                .add("index", this.index)
                .toString();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof SlotIndex && ((SlotIndex) obj).index == this.index;
    }

    @Override
    public int hashCode() {
        return this.index;
    }
}
