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

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Implementation of {@link PartitionedTextFormatter} that allows for
 * modifications on the partitions.
 */
public class DynamicPartitionedTextFormatter implements PartitionedTextFormatter<SimpleTextFormatter> {

    protected final List<SimpleTextFormatter> partitions;

    /**
     * Creates a new {@link DynamicPartitionedTextFormatter}.
     *
     * @param initialSize The initial size of partitions
     */
    public DynamicPartitionedTextFormatter(int initialSize) {
        checkArgument(initialSize >= 0, "initial size must be greater than or equal to zero");
        this.partitions = new ArrayList<>(initialSize);
        for (int i = 0; i < initialSize; i++) {
            this.partitions.add(new SimpleTextFormatter());
        }
    }

    /**
     * creates a new partitioned text formatter.
     */
    public DynamicPartitionedTextFormatter() {
        this(0);
    }

    @Override
    public ImmutableList<SimpleTextFormatter> getAll() {
        return ImmutableList.copyOf(this.partitions);
    }

    @Override
    public SimpleTextFormatter get(int i) {
        return this.partitions.get(i);
    }

    @Override
    public SimpleTextFormatter set(int i, SimpleTextFormatter element) {
        return this.partitions.set(i, element);
    }

    @Override
    public int size() {
        return this.partitions.size();
    }

    @Override
    public boolean isEmpty() {
        return this.partitions.isEmpty();
    }

    @Override
    public boolean contains(SimpleTextFormatter element) {
        return this.partitions.contains(element);
    }

    @Override
    public void clear() {
        this.partitions.clear();
    }

    @Override
    public boolean add(SimpleTextFormatter element) {
        return this.partitions.add(element);
    }

    @Override
    public boolean add(Collection<SimpleTextFormatter> elements) {
        return this.partitions.addAll(elements);
    }

    @Override
    public void insert(int i, SimpleTextFormatter element) {
        this.partitions.add(i, element);
    }

    @Override
    public void insert(int i, Collection<SimpleTextFormatter> elements) {
        this.partitions.addAll(i, elements);
    }

    @Override
    public boolean remove(SimpleTextFormatter element) {
        return this.partitions.remove(element);
    }

    @Override
    public boolean remove(Collection<SimpleTextFormatter> elements) {
        return this.partitions.removeAll(elements);
    }

    @Override
    public boolean retain(Collection<SimpleTextFormatter> elements) {
        return this.partitions.retainAll(elements);
    }

}
