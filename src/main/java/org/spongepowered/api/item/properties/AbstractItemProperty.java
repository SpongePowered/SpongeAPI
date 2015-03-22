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
package org.spongepowered.api.item.properties;

import com.google.common.base.Objects;

import javax.annotation.Nullable;

/**
 * Base class for {@link ItemProperty} implementations which stubs out all of the
 * common boilerplate functionality.
 *
 * @param <K> Key type, use {@link String} if no particular key type is required
 * @param <V> Value type
 */
public abstract class AbstractItemProperty<K, V> implements ItemProperty<K, V> {

    /**
     * Operator for comparing to other properties. Operators should always be
     * applied by consumers in a &lt;this&gt; &lt;OPERATOR&gt; &lt;other&gt;
     * pattern
     */
    protected final Operator operator;

    /**
     * The key.
     */
    private final K key;

    /**
     * The value.
     */
    @Nullable
    protected V value;

    /**
     * Initialise internal values to defaults, use this ctor if you plan to
     * override {@link #getKey} and {@link #getValue} yourself.
     */
    protected AbstractItemProperty() {
        this(null);
    }

    /**
     * Initialise key to default, and value to the supplied value.
     *
     * @param value The value of the property
     */
    protected AbstractItemProperty(@Nullable V value) {
        this(value, null);
    }

    /**
     * Initialise the value to the specified value and use the specified
     * operator, use the default key.
     *
     * @param value The property value
     * @param op The operator for the property
     */
    protected AbstractItemProperty(@Nullable V value, Operator op) {
        this(null, value, op);
    }

    /**
     * Use the specified key and value and set operator to the default.
     *
     * @param key The key identifying the property
     * @param value The property value
     */
    protected AbstractItemProperty(@Nullable K key, @Nullable V value) {
        this(key, value, null);
    }

    protected AbstractItemProperty(@Nullable K key, @Nullable V value, @Nullable Operator op) {
        this.key = key != null ? key : this.getDefaultKey(value);
        this.value = value;
        this.operator = op != null ? op : this.getDefaultOperator(this.key, value);
    }

    /**
     * Get the default value for {@link #key}, used in case null is passed in
     * (since we can't have a null key). In general this should return the class
     * name of the property itself but subclasses are free to alter this
     * behaviour if they wish.
     *
     * @param value Value passed in to the ctor, supplied in case a subclass
     *      wants to return a specific default key based on the value
     * @return default key to use. Must not be null!
     */
    @SuppressWarnings("unchecked")
    protected K getDefaultKey(@Nullable V value) {
        return (K) this.getClass().getSimpleName();
    }

    /**
     * Return the default operator to use, based on the supplied key and value.
     *
     * @param key Property key
     * @param value Property initial value, may be null
     * @return operator to use
     */
    protected Operator getDefaultOperator(K key, @Nullable V value) {
        return Operator.defaultOperator();
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public Operator getOperator() {
        return this.operator;
    }

    @Override
    public boolean matches(@Nullable ItemProperty<?, ?> other) {
        return this.getOperator().compare(this, other);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (!(obj instanceof ItemProperty)) {
            return false;
        }

        ItemProperty<?, ?> other = (ItemProperty<?, ?>) obj;
        return Objects.equal(other.getKey(), this.getKey()) && Objects.equal(other.getValue(), this.getValue());
    }

    @Override
    public int hashCode() {
        return this.hashCodeOf(this.getKey()) ^ this.hashCodeOf(this.getValue()) * 37;
    }

    /**
     * Convenience method to avoid null-checking. Returns 0 if <em>value</em> is
     * null.
     *
     * @param value The value to get the hashcode of
     * @return The hashcode value
     */
    protected int hashCodeOf(Object value) {
        return value != null ? value.hashCode() : 0;
    }

}
