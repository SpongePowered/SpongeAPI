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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * An abstract table holding weighted objects. Objects may be retrieved from the
 * table according to weight or chance.
 *
 * @param <T> The type of entry
 */
public abstract class RandomObjectTable<T> implements Collection<TableEntry<T>> {

    protected final List<TableEntry<T>> entries = Lists.newArrayList();
    private VariableAmount rolls;

    /**
     * Creates a new {@link RandomObjectTable} with the provided number of rolls.
     *
     * @see RandomObjectTable#getRolls()
     * @param rolls the rolls
     */
    public RandomObjectTable(int rolls) {
        if (rolls < 0) {
            throw new IllegalArgumentException("Rolls cannot be negative!");
        }
        this.rolls = VariableAmount.fixed(rolls);
    }

    /**
     * Creates a new {@link RandomObjectTable} with the provided number of rolls.
     *
     * @see RandomObjectTable#getRolls()
     * @param rolls the rolls
     */
    public RandomObjectTable(VariableAmount rolls) {
        this.rolls = Objects.requireNonNull(rolls);
    }

    /**
     * Gets the number of times this table will roll while retrieving items. For
     * each roll a complete pass through of the table will occur.
     * 
     * @return The number of rolls
     */
    public VariableAmount getRolls() {
        return this.rolls;
    }

    /**
     * Sets the number of times this table will roll while retrieving items.
     * 
     * @param rolls The new roll count
     */
    public void setRolls(VariableAmount rolls) {
        this.rolls = Objects.requireNonNull(rolls);
    }

    /**
     * Sets the number of times this table will roll while retrieving items.
     * 
     * @param rolls The new roll count
     */
    public void setRolls(int rolls) {
        if (rolls < 0) {
            throw new IllegalArgumentException("Rolls cannot be negative!");
        }
        this.rolls = VariableAmount.fixed(rolls);
    }

    @Override
    public boolean add(TableEntry<T> entry) {
        Objects.requireNonNull(entry);
        if (entry.getWeight() < 0) {
            throw new IllegalArgumentException("Weight cannot be negative!");
        }
        return this.entries.add(entry);
    }

    /**
     * Adds the given object to the table with the given weight.
     * 
     * @param object The new object
     * @param weight The weight of the object
     * @return If the object was successfully added
     */
    public boolean add(T object, double weight) {
        Objects.requireNonNull(object);
        if (weight < 0) {
            throw new IllegalArgumentException("Weight cannot be negative!");
        }
        return add(new WeightedObject<>(object, weight));
    }

    @Override
    public boolean addAll(Collection<? extends TableEntry<T>> c) {
        boolean flag = false;
        for (TableEntry<T> e : c) {
            if (e != null) {
                add(e);
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public boolean contains(Object o) {
        return this.entries.contains(o);
    }

    /**
     * Gets if this table contains the given object, the object may either be a
     * {@link TableEntry} or the object contained within.
     * 
     * @param obj The object to check for
     * @return If the object is contained within the table
     */
    public boolean containsObject(Object obj) {
        boolean entry = this.entries.contains(obj);
        if (entry) {
            return true;
        }
        for (TableEntry<T> e : this.entries) {
            if (e instanceof WeightedObject && ((WeightedObject<T>) e).get().equals(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.entries.containsAll(c);
    }

    /**
     * Gets if this table contains all of the given objects, the objects may
     * either be {@link TableEntry}s or the objects contained within the
     * entries.
     * 
     * @param c The objects to check for
     * @return If all of the objects are contained within the table
     */
    public boolean containsAllObjects(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return this.entries.isEmpty();
    }

    @Override
    public boolean remove(Object entry) {
        return this.entries.remove(entry);
    }

    /**
     * Removes the first instance of an entry in this table which is a
     * {@link WeightedObject} entry and contains the given object.
     * 
     * @param object The object to remove
     * @return If the table was changed as a result
     */
    public boolean removeObject(Object object) {
        boolean flag = this.entries.remove(object);
        if (flag) {
            return true;
        }
        for (Iterator<TableEntry<T>> it = this.entries.iterator(); it.hasNext();) {
            TableEntry<T> e = it.next();
            if (e instanceof WeightedObject && ((WeightedObject<T>) e).get().equals(object)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.entries.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.entries.retainAll(c);
    }

    @Override
    public void clear() {
        this.entries.clear();
    }

    @Override
    public int size() {
        return this.entries.size();
    }

    /**
     * Performs a number of rolls according to the number of rolls defined by
     * {@link #getRolls()} and returns items from the table for each roll.
     * 
     * @param rand The random object to use
     * @return The returned items, may be empty but not null
     */
    public abstract List<T> get(Random rand);

    /**
     * Gets the entries in the table. Note that the specific sub class of this
     * abstract table will determine the context that the entry weights should
     * be interpreted in (either weights or chances).
     * 
     * @return The raw entries
     */
    public List<TableEntry<T>> getEntries() {
        return ImmutableList.copyOf(this.entries);
    }

    @Override
    public Iterator<TableEntry<T>> iterator() {
        return this.entries.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.entries.toArray();
    }

    @Override
    public <R> R[] toArray(R[] a) {
        return this.entries.toArray(a);
    }
}
