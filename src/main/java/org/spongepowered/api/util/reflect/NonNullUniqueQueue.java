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

package org.spongepowered.api.util.reflect;

import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;

/**
 * A queue implementation that only permits an object to be added to the
 * queue once, while also rejecting null offers.
 *
 * @param <E> The contained type
 */
class NonNullUniqueQueue<E> extends AbstractQueue<E> implements Queue<E> {

    private final Queue<E> queue = new ArrayDeque<E>();
    private final Set<E> set = new HashSet<E>();

    @Override
    public Iterator<E> iterator() {
        return this.queue.iterator();
    }

    @Override
    public int size() {
        return this.queue.size();
    }

    @Override
    public boolean offer(E o) {
        return o != null && this.set.add(o) && this.queue.offer(o);
    }

    @Override
    public E poll() {
        return this.queue.poll();
    }

    @Override
    public E peek() {
        return this.queue.peek();
    }
}
