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
 * The context that a given service check occurs in.
 *
 * <p>Instances of a context are designed to function as cache keys, meaning
 * they should be fairly lightweight and not hold references to large
 * objects.</p>
 *
 * <p>Contexts consist of a "type" (or key) and a "name" (or value).</p>
 *
 * <p>Some common context keys are expressed as static parameters.</p>
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
     * Create a new context instance
     *
     * @param type Context type. Must not be null.
     * @param name Context name. Must not be null.
     */
    public Context(String type, String name) {
        checkNotNull(type, "type");
        checkNotNull(name, "name");
        this.wrapped = Maps.immutableEntry(type, name);
    }

    /**
     * Gets the context type.
     *
     * <p>For example, if the context represented a world, the type would be
     * {@code world}</p>
     *
     * @return The type of item this context represents
     */
    public String getType() {
        return getKey();
    }

    /**
     * Gets the context name.
     *
     * <p>For example, if the context represented a world, the name would be
     * the name of the world.</p>
     *
     * @return The specific name of the item involved in this context
     */
    public String getName() {
        return getValue();
    }

    @Override
    public String getKey() {
        return this.wrapped.getKey();
    }

    @Override
    public String getValue() {
        return this.wrapped.getValue();
    }

    @Override
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
        return this.wrapped.toString();
    }
}
