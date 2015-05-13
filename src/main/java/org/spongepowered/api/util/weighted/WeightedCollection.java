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

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Represents a mutable collection of weighted objects. This collection is not
 * thread-safe and must be externally synchronized if that is required.
 * 
 * @param <T> The weighted object type
 */
public class WeightedCollection<T extends WeightedObject<?>> implements Collection<T> {

    private final List<T> objects;
    private int totalWeight = 0;

    /**
     * Creates a new {@link WeightedCollection}.
     */
    public WeightedCollection() {
        this.objects = Lists.newArrayList();
    }

    /**
     * Selects a random value from this list based on their weight.
     * 
     * <p>If the list is empty then null will be returned.</p>
     * 
     * @param rand The random object to use for selection
     * @return The selected value, or null if the list was empty
     */
    public T get(Random rand) {
        int target = rand.nextInt(this.totalWeight);
        int current = 0;
        for (Iterator<T> it = iterator(); it.hasNext();) {
            T obj = it.next();
            current += obj.getWeight();
            if (current > target) {
                return obj;
            }
        }
        return null;
    }

    private void rebuildWeight() {
        this.totalWeight = 0;
        for (T obj : this.objects) {
            this.totalWeight += obj.getWeight();
        }
    }

    /**
     * Adds the given weighted object to the collection. The object may not be
     * null.
     * 
     * @param object The weighted object
     * @throws NullPointerException If the object is null
     */
    @Override
    public boolean add(T object) {
        checkNotNull(object, "object");
        boolean result = this.objects.add(object);
        rebuildWeight();
        return result;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        boolean result = this.objects.addAll(collection);
        rebuildWeight();
        return result;
    }

    @Override
    public void clear() {
        this.objects.clear();
        this.totalWeight = 0;
    }

    @Override
    public boolean contains(Object object) {
        return this.objects.contains(object);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return this.objects.containsAll(collection);
    }

    @Override
    public boolean isEmpty() {
        return this.objects.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    @Override
    public boolean remove(Object object) {
        boolean result = this.objects.remove(object);
        rebuildWeight();
        return result;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean result = this.objects.removeAll(collection);
        rebuildWeight();
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean result = this.objects.retainAll(collection);
        rebuildWeight();
        return result;
    }

    @Override
    public int size() {
        return this.objects.size();
    }

    @Override
    public Object[] toArray() {
        return this.objects.toArray();
    }

    @Override
    public <E> E[] toArray(E[] array) {
        return this.objects.toArray(array);
    }

    /**
     * An iterator which will properly trigger a rebuild of the total weight on
     * removal.
     */
    private class Itr implements Iterator<T> {

        private final Iterator<T> iter;

        protected Itr() {
            this.iter = WeightedCollection.this.objects.iterator();
        }

        @Override
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override
        public T next() {
            return this.iter.next();
        }

        @Override
        public void remove() {
            this.iter.remove();
            WeightedCollection.this.rebuildWeight();
        }

    }

}
