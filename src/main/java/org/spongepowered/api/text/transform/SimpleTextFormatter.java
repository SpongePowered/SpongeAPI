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
 * A basic implementation of {@link TextFormatter} backed by an
 * {@link ArrayList}.
 */
public class SimpleTextFormatter implements TextFormatter<SimpleTextTemplateApplier> {

    protected final List<SimpleTextTemplateApplier> parts;

    /**
     * Constructs a new {@link SimpleTextFormatter} with the specified amount
     * of initial {@link TextTemplateApplier}s.
     *
     * @param initialSize Initial amount of Parts
     */
    public SimpleTextFormatter(int initialSize) {
        checkArgument(initialSize >= 0, "initial size must be greater than or equal to zero");
        this.parts = new ArrayList<>(initialSize);
        for (int i = 0; i < initialSize; i++) {
            this.parts.add(new SimpleTextTemplateApplier());
        }
    }

    /**
     * Constructs an empty text formatter.
     */
    public SimpleTextFormatter() {
        this(0);
    }

    @Override
    public ImmutableList<SimpleTextTemplateApplier> getAll() {
        return ImmutableList.copyOf(this.parts);
    }

    @Override
    public SimpleTextTemplateApplier get(int i) {
        return this.parts.get(i);
    }

    @Override
    public SimpleTextTemplateApplier set(int i, SimpleTextTemplateApplier element) {
        return this.parts.set(i, element);
    }

    @Override
    public int size() {
        return this.parts.size();
    }

    @Override
    public boolean isEmpty() {
        return this.parts.isEmpty();
    }

    @Override
    public boolean contains(SimpleTextTemplateApplier element) {
        return this.parts.contains(element);
    }

    @Override
    public void clear() {
        this.parts.clear();
    }

    @Override
    public boolean add(SimpleTextTemplateApplier element) {
        return this.parts.add(element);
    }

    @Override
    public boolean add(Collection<SimpleTextTemplateApplier> elements) {
        return this.parts.addAll(elements);
    }

    @Override
    public void insert(int i, SimpleTextTemplateApplier element) {
        this.parts.add(i, element);
    }

    @Override
    public void insert(int i, Collection<SimpleTextTemplateApplier> elements) {
        this.parts.addAll(i, elements);
    }

    @Override
    public boolean remove(SimpleTextTemplateApplier element) {
        return this.parts.remove(element);
    }

    @Override
    public boolean remove(Collection<SimpleTextTemplateApplier> elements) {
        return this.parts.removeAll(elements);
    }

    @Override
    public boolean retain(Collection<SimpleTextTemplateApplier> elements) {
        return this.parts.retainAll(elements);
    }

}
