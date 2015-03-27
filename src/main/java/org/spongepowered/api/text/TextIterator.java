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
package org.spongepowered.api.text;

import com.google.common.collect.UnmodifiableIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.annotation.Nullable;

/**
 * Represents a recursive {@link Iterator} for {@link Text} including the text
 * itself as well as all children texts.
 */
class TextIterator extends UnmodifiableIterator<Text> {

    private final Text text;
    @Nullable private Iterator<Text> children;
    @Nullable private Iterator<Text> currentChildIterator;

    /**
     * Constructs a new {@link TextIterator} for the specified {@link Text}.
     *
     * @param text The root text for the iterator
     */
    TextIterator(Text text) {
        this.text = text;
    }

    @Override
    public boolean hasNext() {
        return this.children == null || (this.currentChildIterator != null && this.currentChildIterator.hasNext()) || this.children.hasNext();
    }

    @Override
    public Text next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (this.children == null) {
            this.children = this.text.children.iterator();
            return this.text;
        } else if (this.currentChildIterator == null || !this.currentChildIterator.hasNext()) {
            this.currentChildIterator = this.children.next().childrenIterable.iterator();
        }

        return this.currentChildIterator.next();
    }

}
