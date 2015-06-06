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
package org.spongepowered.api.data.merge;

import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.ValueStore;

public abstract class MergeStrategy {

    // return true if you modified something or false if you didn't
    public abstract <E> boolean merge(Key<E> key, ValueStore<?> from, ValueStore<?> to);

    public MergeStrategy andThen(final MergeStrategy that) {
        final MergeStrategy self = this;
        return new MergeStrategy() {
            @Override
            public <E> boolean merge(Key<E> key, ValueStore<?> from, ValueStore<?> to) {
                return self.merge(key, from, to) || that.merge(key, from, to);
            }
        };
    }

    public static final MergeStrategy IGNORE_ALL = new MergeStrategy() {
        @Override
        public <E> boolean merge(Key<E> key, ValueStore<?> from, ValueStore<?> to) {
            return false;
        }
    };

    public static final MergeStrategy FORCE_NOTHING = new MergeStrategy() {
        @Override
        public <E> boolean merge(Key<E> key, ValueStore<?> from, ValueStore<?> to) {
            return true;
        }
    };

}
