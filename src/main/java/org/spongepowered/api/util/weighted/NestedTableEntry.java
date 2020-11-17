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
package org.spongepowered.api.util.weighted;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.StringJoiner;

/**
 * Represents a {@link RandomObjectTable} which is nested inside the entry of
 * another table.
 *
 * @param <T> The entry type
 */
public class NestedTableEntry<T> extends TableEntry<T> {

    private final RandomObjectTable<T> table;

    /**
     * Creates a new {@link NestedTableEntry} with the provided
     * {@code weight} and {@link RandomObjectTable table}.
     *
     * @param weight The weight to apply to the entry
     * @param table The table itself
     */
    public NestedTableEntry(final double weight, final RandomObjectTable<T> table) {
        super(weight);
        this.table = Objects.requireNonNull(table);
    }

    /**
     * Retrieves entries from the nested table.
     * 
     * @param rand The random object to use
     * @return The retrieved entries
     */
    public List<T> get(final Random rand) {
        return this.table.get(rand);
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof NestedTableEntry)) {
            return false;
        }
        final NestedTableEntry<?> c = (NestedTableEntry<?>) o;
        return this.table.equals(c.table);
    }

    @Override
    public int hashCode() {
        int r = 1;
        final long w = Double.doubleToLongBits(this.getWeight());
        r = r * 37 + (int) (w ^ (w >>> 32));
        r = r * 37 + this.table.hashCode();
        return r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", NestedTableEntry.class.getSimpleName() + "[", "]")
            .add("table=" + this.table)
            .toString();
    }
}
