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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Objects;

import java.util.Map;

/**
 * The context that a service check occurs in. Instances of a context are
 * designed to function as cache keys, meaning they should be fairly lightweight
 * and not hold references to large objects
 */
public final class Context implements Map.Entry<String, String> {
    public static final String USER_KEY = "user";
    public static final String WORLD_KEY = "world";
    public static final String DIMENSION_KEY = "dimension";
    public static final String REMOTE_IP_KEY = "remoteip";
    public static final String LOCAL_HOST_KEY = "localhost";
    public static final String LOCAL_IP_KEY = "localip";
    public static final String LOCAL_PORT_KEY = "localport"; // This portkey is an old boot

    private final String key;
    private final String value;
    private final int weight;

    /**
     * Create a new context instance
     *
     * @param type Context type. Must not be null.
     * @param name Context name. Must not be null.
     * @param weight Context weight. Must be greater than or equal to 1. Default is 1.
     */
    public Context(String type, String name, int weight) {
        this.key = checkNotNull(type, "type");
        this.value = checkNotNull(name, "name");
        checkArgument(weight >= 1, "weight must be >= 1");
        this.weight = weight;
    }

    /**
     * Create a new context instance with the default weight
     *
     * @param type Context type. Must not be null.
     * @param name Context name. Must not be null.
     */
    public Context(String type, String name) {
        this(type, name, 1);
    }

    /**
     * Get the type.
     *
     * @return the type of item this context represents, for example for a world
     *         this would be {@code world}
     */
    public String getType() {
        return getKey();
    }

    /**
     * Get the name.
     *
     * @return the specific name of the item involved in this context, for
     *         example if the type were {@code world} this would be the name of the
     *         world.
     */
    public String getName() {
        return getValue();
    }

    /**
     * Get the weight.
     *
     * <p>This value should be used to calculate the total weight of a Context set. A value of
     * 1 is considered default. The weight of a set is calculated by adding the weights of each
     * contained Context. Higher value = higher/heavier priority.</p>
     *
     * @return the weight of the context pair.
     */
    public int getWeight() {
        return this.weight;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public String setValue(String value) {
        throw new UnsupportedOperationException("Contexts are immutable");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry<?, ?> other = (Map.Entry<?, ?>) obj;
            return Objects.equal(this.getKey(), other.getKey()) && Objects.equal(this.getValue(), other.getValue());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.key.hashCode() ^ this.value.hashCode();
    }

    @Override
    public String toString() {
        return "Context(key=" + this.key + ", value=" + this.value + ", weight=" + this.weight + ")";
    }
}
