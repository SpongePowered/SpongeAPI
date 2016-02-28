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

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * This is a variant of the {@link RandomObjectTable} which uses a 0-1 chance
 * attached to every entry. When rolled the a chance roll is calculated for each
 * entry and <strong>all</strong> entries which pass are returned.
 *
 * @param <T> The entry type
 */
public class ChanceTable<T> extends RandomObjectTable<T> {

    /**
     * Creates a new {@link ChanceTable} with a default roll count of 1.
     */
    public ChanceTable() {
        super(1);
    }

    /**
     * Creates a new {@link ChanceTable}.
     * 
     * @param rolls The number of rolls to perform
     */
    public ChanceTable(int rolls) {
        super(rolls);
    }

    @Override
    public List<T> get(Random rand) {
        List<T> results = Lists.newArrayList();
        if (this.entries.isEmpty()) {
            return results;
        }
        int rolls = getRolls().getFlooredAmount(rand);
        for (int i = 0; i < rolls; i++) {
            for (Iterator<TableEntry<T>> it = this.entries.iterator(); it.hasNext();) {
                TableEntry<T> next = it.next();
                if (rand.nextDouble() < next.getWeight()) {
                    if (next instanceof NestedTableEntry) {
                        results.addAll(((NestedTableEntry<T>) next).get(rand));
                    } else if (next instanceof WeightedObject) {
                        results.add(((WeightedObject<T>) next).get());
                    }
                }
            }
        }
        return results;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ChanceTable)) {
            return false;
        }
        ChanceTable<?> c = (ChanceTable<?>) o;
        if (getRolls() != c.getRolls()) {
            return false;
        }
        if (this.entries.size() != c.entries.size()) {
            return false;
        }
        for (int i = 0; i < this.entries.size(); i++) {
            if (!this.entries.get(i).equals(c.entries.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int r = 1;
        r = r * 37 + getRolls().hashCode();
        for (TableEntry<T> entry : this.entries) {
            r = r * 37 + entry.hashCode();
        }
        return r;
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("ChanceTable (rolls=").append(getRolls());
        r.append(",entries=").append(this.entries.size()).append(") {\n");
        for (TableEntry<T> entry : this.entries) {
            r.append("\t").append(entry.toString()).append("\n");
        }
        r.append("}");
        return r.toString();
    }
}
