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

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * A table of weighted entry, each entry is given a weight, the higher the
 * weight the more likely the chance that the entry is chosen. Each roll will
 * only return a single entries value.
 *
 * @param <T> The entry type
 */
public class WeightedTable<T> extends RandomObjectTable<T> {

    private double totalWeight = 0;

    /**
     * Creates a new {@link WeightedTable} with a default roll
     * count of {@code 1}.
     */
    public WeightedTable() {
        super(1);
    }

    /**
     * Creates a new {@link WeightedTable} with the provided
     * number of {@code rolls}.
     *
     * @param rolls The rolls for variance
     */
    public WeightedTable(int rolls) {
        super(rolls);
    }

    /**
     * Creates a new {@link WeightedTable} with the provided
     * {@link VariableAmount} for the amount of rolls and variance.
     *
     * @param rolls The rolls for variance
     */
    public WeightedTable(VariableAmount rolls) {
        super(rolls);
    }

    @Override
    public boolean add(TableEntry<T> entry) {
        boolean added = super.add(entry);
        if (added) {
            recalculateWeight();
        }
        return added;
    }

    @Override
    public boolean add(T object, double weight) {
        boolean added = super.add(object, weight);
        if (added) {
            recalculateWeight();
        }
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends TableEntry<T>> c) {
        boolean added = super.addAll(c);
        if (added) {
            recalculateWeight();
        }
        return added;
    }

    @Override
    public boolean remove(Object entry) {
        boolean removed = super.remove(entry);
        if (removed) {
            recalculateWeight();
        }
        return removed;
    }

    @Override
    public boolean removeObject(Object entry) {
        boolean removed = super.removeObject(entry);
        if (removed) {
            recalculateWeight();
        }
        return removed;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean removed = super.removeAll(c);
        if (removed) {
            recalculateWeight();
        }
        return removed;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean removed = super.retainAll(c);
        if (removed) {
            recalculateWeight();
        }
        return removed;
    }

    @Override
    public void clear() {
        super.clear();
        recalculateWeight();
    }

    /**
     * Recalculates the total weight of all entries in this table.
     */
    protected void recalculateWeight() {
        this.totalWeight = 0;
        for (Iterator<TableEntry<T>> it = this.entries.iterator(); it.hasNext();) {
            TableEntry<T> entry = it.next();
            if (entry.getWeight() < 0) {
                // Negative weights on entries will really break this, so we
                // remove them if found, this is fine as a negatively weighted
                // entry should never be picked anyway
                it.remove();
            } else {
                this.totalWeight += entry.getWeight();
            }
        }
    }

    @Override
    public List<T> get(Random rand) {
        List<T> results = Lists.newArrayList();
        if (this.entries.isEmpty()) {
            return results;
        }
        int rolls = getRolls().getFlooredAmount(rand);
        for (int i = 0; i < rolls; i++) {
            double roll = rand.nextDouble() * this.totalWeight;
            for (Iterator<TableEntry<T>> it = this.entries.iterator(); it.hasNext();) {
                TableEntry<T> next = it.next();
                roll -= next.getWeight();
                if (roll <= 0) {
                    if (next instanceof NestedTableEntry) {
                        results.addAll(((NestedTableEntry<T>) next).get(rand));
                    } else if (next instanceof WeightedObject) {
                        results.add(((WeightedObject<T>) next).get());
                    }
                    break;
                }
            }
        }
        return results;
    }

    @Override
    public Iterator<TableEntry<T>> iterator() {
        return new Itr();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof WeightedTable)) {
            return false;
        }
        WeightedTable<?> c = (WeightedTable<?>) o;
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
        r.append("WeightedTable (rolls=").append(getRolls());
        r.append(",entries=").append(this.entries.size()).append(") {\n");
        for (TableEntry<T> entry : this.entries) {
            r.append("\t").append(entry.toString()).append("\n");
        }
        r.append("}");
        return r.toString();
    }

    /**
     * An iterator which will properly trigger a rebuild of the total weight on
     * removal.
     */
    private class Itr implements Iterator<TableEntry<T>> {

        private final Iterator<TableEntry<T>> iter;

        protected Itr() {
            this.iter = WeightedTable.super.iterator();
        }

        @Override
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override
        public TableEntry<T> next() {
            return this.iter.next();
        }

        @Override
        public void remove() {
            this.iter.remove();
            WeightedTable.this.recalculateWeight();
        }

    }
}
