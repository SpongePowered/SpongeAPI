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
package org.spongepowered.api.data.property;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class NonnullAbstractProperty<K, V> extends AbstractProperty<K, V> {

    /**
     * Initialise key to default, and value to the supplied value.
     *
     * @param value The value of the property
     */
    protected NonnullAbstractProperty(V value) {
        super(checkNotNull(value, "value"));
    }

    /**
     * Initialise the value to the specified value and use the specified
     * operator, use the default key.
     *
     * @param value The property value
     * @param op The operator for the property
     */
    protected NonnullAbstractProperty(V value, @Nullable Operator op) {
        super(checkNotNull(value, "value"), op);
    }

    /**
     * Use the specified key and value and set operator to the default.
     *
     * @param key The key identifying the property
     * @param value The property value
     */
    protected NonnullAbstractProperty(@Nullable K key, V value) {
        super(key, checkNotNull(value, "value"));
    }

    protected NonnullAbstractProperty(@Nullable K key, V value, @Nullable Operator op) {
        super(key, checkNotNull(value, "value"), op);
    }

    @Nonnull
    @Override
    public V getValue() {
        return super.getValue();
    }
}
