/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.util.event.callback;

import com.google.common.collect.Iterators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.api.util.event.Cancellable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * A collection of callbacks.
 *
 * <p>Entries in the list cannot be removed, but new entries can be added.</p>
 *
 * <p>A misbehavior callback (one that throws an exception) will not halt
 * the processing of other callbacks.</p>
 */
public final class CallbackList implements Collection<EventCallback> {

    private static final Logger log = LoggerFactory.getLogger(CallbackList.class);
    private final List<EventCallback> callbacks = new ArrayList<EventCallback>();

    /**
     * Execute all callbacks in the correct order.
     */
    public void runAll() {
        for (EventCallback callback : this.callbacks) {
            try {
                callback.run();
            } catch (Exception e) {
                log.error("Failed to run an event callback", e);
            }
        }
    }

    /**
     * Cancel all callbacks.
     */
    public void cancelAll() {
        for (EventCallback callback : this.callbacks) {
            if (callback instanceof Cancellable) {
                ((Cancellable) callback).setCancelled(true);
            }
        }
    }

    @Override
    public int size() {
        return this.callbacks.size();
    }

    @Override
    public boolean isEmpty() {
        return this.callbacks.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.callbacks.contains(o);
    }

    @Override
    public Iterator<EventCallback> iterator() {
        return Iterators.unmodifiableIterator(this.callbacks.iterator());
    }

    @Override
    public Object[] toArray() {
        return this.callbacks.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return this.callbacks.toArray(a);
    }

    @Override
    public boolean add(EventCallback callback) {
        return this.callbacks.add(callback);
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Cannot remove entries from the callback list");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.callbacks.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends EventCallback> c) {
        return this.callbacks.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Cannot remove entries from the callback list");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Cannot remove entries from the callback list");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Cannot remove entries from the callback list");
    }

}
