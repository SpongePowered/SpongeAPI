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
package org.spongepowered.api.text.transform;

import com.google.common.collect.ImmutableList;

import java.util.Collection;
import java.util.Iterator;

/**
 * Implementation of {@link PartitionedTextFormatter} that has a fixed amount
 * of partitions.
 */
public class FixedPartitionedTextFormatter implements PartitionedTextFormatter<SimpleTextFormatter> {

    final SimpleTextFormatter[] partitions;

    public FixedPartitionedTextFormatter(int size) {
        this.partitions = new SimpleTextFormatter[size];
        for (int i = 0; i < size; i++) {
            this.partitions[i] = new SimpleTextFormatter();
        }
    }

    public FixedPartitionedTextFormatter() {
        this(2);
    }

    @Override
    public ImmutableList<SimpleTextFormatter> getAll() {
        return ImmutableList.copyOf(this.partitions);
    }

    @Override
    public SimpleTextFormatter get(int i) {
        return partitions[i];
    }

    @Override
    public SimpleTextFormatter set(int i, SimpleTextFormatter element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return partitions.length;
    }

    /**
     * Returns true if each partition is empty.
     *
     * @return True if each partition is empty
     */
    @Override
    public boolean isEmpty() {
        boolean empty = true;
        for (SimpleTextFormatter partition : this) {
            empty &= partition.isEmpty();
        }
        return empty;
    }

    @Override
    public boolean contains(SimpleTextFormatter element) {
        for (SimpleTextFormatter partition : this) {
            if (element.equals(partition)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Clears each partition. Retains the actual partitions themselves.
     */
    @Override
    public void clear() {
        forEach(SimpleTextFormatter::clear);
    }

    @Override
    public boolean add(SimpleTextFormatter element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(Collection<SimpleTextFormatter> elements) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(Iterable<SimpleTextFormatter> elements) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(Iterator<SimpleTextFormatter> elements) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void insert(int i, SimpleTextFormatter element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void insert(int i, Collection<SimpleTextFormatter> elements) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void insert(int i, Iterable<SimpleTextFormatter> elements) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void insert(int i, Iterator<SimpleTextFormatter> elements) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(SimpleTextFormatter element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Collection<SimpleTextFormatter> elements) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Iterable<SimpleTextFormatter> elements) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Iterator<SimpleTextFormatter> elements) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retain(Collection<SimpleTextFormatter> elements) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retain(Iterable<SimpleTextFormatter> elements) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retain(Iterator<SimpleTextFormatter> elements) {
        throw new UnsupportedOperationException();
    }

}
