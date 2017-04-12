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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a pool of tables which are rolled sequentially when retrieving
 * entries.
 *
 * @param <T> The entry type
 */
public class LootTable<T> {

    private List<RandomObjectTable<T>> pool = new ArrayList<>();

    /**
     * Creates a new {@link LootTable}.
     */
    public LootTable() {

    }

    /**
     * Adds a table to the pool.
     * 
     * @param table The new table
     */
    public void addTable(RandomObjectTable<T> table) {
        this.pool.add(checkNotNull(table));
    }

    /**
     * Adds all tables from the given {@link LootTable} to this LootTable's pool.
     * 
     * @param other The other loot table
     */
    public void addAll(LootTable<T> other) {
        this.pool.addAll(other.pool);
    }

    /**
     * Removes a table from the pool.
     * 
     * @param table The table to remove
     * @return If the pool contained the table
     */
    public boolean removeTable(RandomObjectTable<T> table) {
        return this.pool.remove(table);
    }
    
    /**
     * Gets all tables in the pool.
     * 
     * @return The tables
     */
    public List<RandomObjectTable<T>> getTables() {
        return ImmutableList.copyOf(this.pool);
    }
    
    /**
     * Clears all tables from the pool.
     */
    public void clearPool() {
        this.pool.clear();
    }

    /**
     * Gets a List of objects as retrieved from all pools.
     * 
     * @param rand The random object to use
     * @return The retrieved entries
     */
    public List<T> get(Random rand) {
        List<T> results = Lists.newArrayList();
        for (RandomObjectTable<T> pool : this.pool) {
            results.addAll(pool.get(rand));
        }
        return results;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LootTable)) {
            return false;
        }
        LootTable<?> c = (LootTable<?>) o;
        if (this.pool.size() != c.pool.size()) {
            return false;
        }
        for (int i = 0; i < this.pool.size(); i++) {
            if (!this.pool.get(i).equals(c.pool.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int r = 1;
        for (RandomObjectTable<T> table : this.pool) {
            r = r * 37 + table.hashCode();
        }
        return r;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("pool", this.pool).toString();
    }

}
