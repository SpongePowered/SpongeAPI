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

import com.google.common.base.Objects;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Creates a WeightedTable that is completely immutable, but still is able
 * to be changed via its proxy table.
 *
 * @param <T> Item type
 */
public class UnmodifiableWeightedTable<T> extends WeightedTable<T> {

    private final WeightedTable<T> table;

    /**
     * Creates a new {@link UnmodifiableWeightedTable} with the provided
     * {@link WeightedTable}.
     *
     * @param table The table to provide
     */
    public UnmodifiableWeightedTable(WeightedTable<T> table) {
        super();
        this.table = table;
    }

    /**
     * Creates a new {@link UnmodifiableWeightedTable} with the provided
     * {@link WeightedTable} and {@code rolls}.
     *
     * @param table The table
     * @param rolls The rolls
     */
    public UnmodifiableWeightedTable(WeightedTable<T> table, int rolls) {
        super(rolls);
        this.table = table;
    }

    /**
     * Creates a new {@link UnmodifiableWeightedTable} with the provided
     * {@link WeightedTable} and {@link VariableAmount rolls}.
     *
     * @param table The table
     * @param rolls The rolls
     */
    public UnmodifiableWeightedTable(WeightedTable<T> table, VariableAmount rolls) {
        super(rolls);
        this.table = table;
    }

    // FORBIDDEN METHODS

    @Override
    public boolean add(TableEntry<T> entry) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(T object, double weight) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends TableEntry<T>> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setRolls(VariableAmount rolls) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setRolls(int rolls) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object entry) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeObject(Object entry) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeIf(Predicate<? super TableEntry<T>> filter) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    // PROXY METHODS

    @Override
    public Iterator<TableEntry<T>> iterator() {
        Iterator<TableEntry<T>> it = this.table.iterator();
        return new Iterator<TableEntry<T>>() {
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public TableEntry<T> next() {
                return it.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public void forEachRemaining(Consumer<? super TableEntry<T>> action) {
                it.forEachRemaining(action);
            }
        };
    }

    @Override
    public boolean contains(Object o) {
        return this.table.contains(o);
    }

    @Override
    public VariableAmount getRolls() {
        return this.table.getRolls();
    }

    @Override
    public List<T> get(Random rand) {
        return this.table.get(rand);
    }

    @Override
    public boolean containsObject(Object obj) {
        return this.table.containsObject(obj);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.table.containsAll(c);
    }

    @Override
    public boolean containsAllObjects(Collection<?> c) {
        return this.table.containsAllObjects(c);
    }

    @Override
    public boolean isEmpty() {
        return this.table.isEmpty();
    }

    @Override
    public int size() {
        return this.table.size();
    }

    @Override
    public List<TableEntry<T>> getEntries() {
        return this.table.getEntries();
    }

    @Override
    public Object[] toArray() {
        return this.table.toArray();
    }

    @Override
    public <R> R[] toArray(R[] a) {
        return this.table.toArray(a);
    }

    @Override
    public Spliterator<TableEntry<T>> spliterator() {
        return this.table.spliterator();
    }

    @Override
    public Stream<TableEntry<T>> stream() {
        return this.table.stream();
    }

    @Override
    public Stream<TableEntry<T>> parallelStream() {
        return this.table.parallelStream();
    }

    @Override
    public void forEach(Consumer<? super TableEntry<T>> action) {
        this.table.forEach(action);
    }

    @Override
    public String toString() {
        return this.table.toString();
    }

    @Override
    public int hashCode() {
        return this.table.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        UnmodifiableWeightedTable<?> that = (UnmodifiableWeightedTable<?>) o;
        return Objects.equal(this.table, that.table);
    }
}
