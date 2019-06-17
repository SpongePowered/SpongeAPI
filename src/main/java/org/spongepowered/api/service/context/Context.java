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
package org.spongepowered.api.service.context;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Encapsulates a single attribute about the state or circumstances of a
 * {@link Contextual}.
 *
 * <p>A {@link Contextual}'s overall "context" is made up multiple
 * {@link Context} instances, usually stored together in a
 * {@link java.util.Set}.</p>
 *
 * <p>Any single {@link Context} attribute is made up of a <b>key</b> and a
 * <b>value</b>. The key represents the type of context, and the value is just
 * that, the value associated with the key. Some common/shared keys are
 * expressed as static fields on this class for convenience.</p>
 *
 * <p>For example, a context encapsulating a {@link Contextual}s circumstance
 * within a given world would have key of "world" and a value equal to the name
 * of the world.</p>
 *
 * <p>{@link Context} is immutable. The {@link #setValue(String)} inherited from
 * {@link java.util.Map.Entry} is not supported.</p>
 */
public final class Context implements Map.Entry<String, String> {
    public static final String USER_KEY = "user";
    public static final String WORLD_KEY = "world";
    public static final String DIMENSION_KEY = "dimension";
    public static final String REMOTE_IP_KEY = "remoteip";
    public static final String LOCAL_HOST_KEY = "localhost";
    public static final String LOCAL_IP_KEY = "localip";
    public static final String LOCAL_PORT_KEY = "localport"; // This portkey is an old boot

    private final Map.Entry<String, String> wrapped;

    /**
     * Create a new context instance.
     *
     * @param key Context key. Must not be null.
     * @param value Context value. Must not be null.
     */
    public Context(String key, String value) {
        checkNotNull(key, "key");
        checkNotNull(value, "value");
        this.wrapped = Maps.immutableEntry(key, value);
    }

    /**
     * Gets the context key.
     *
     * @return The key
     */
    @Override
    public String getKey() {
        return this.wrapped.getKey();
    }

    /**
     * Gets the context value.
     *
     * @return The value
     */
    @Override
    public String getValue() {
        return this.wrapped.getValue();
    }

    /**
     * Alias method for {@link #getKey()}.
     *
     * @return The type of the context
     * @deprecated The presence of this method is misleading - the context
     *             "type" is the same value as the "key". They are not separate
     *             attributes, as the presence of two distinct methods would
     *             otherwise suggest.
     */
    @Deprecated
    public String getType() {
        return getKey();
    }

    /**
     * Alias method for {@link #getValue()}.
     *
     * @return The specific name of the item involved in this context
     * @deprecated This method name is misleading - contexts only have a "key"
     *             and "value". It is not immediately clear what "name" relates
     *             to. (it could reasonably be either key or value)
     */
    @Deprecated
    public String getName() {
        return getValue();
    }

    @Override
    @Deprecated
    public String setValue(String value) {
        throw new UnsupportedOperationException("Contexts are immutable");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return o instanceof Map.Entry<?, ?> && this.wrapped.equals(o);
    }

    @Override
    public int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override
    public String toString() {
        return getKey() + "=" + getValue();
    }
}
