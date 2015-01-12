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
package org.spongepowered.api.service.permission.context;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * The context that a permission check occurs in. Instances of a context are
 * designed to function as cache keys, meaning they should be fairly lightweight
 * and not hold references to large objects
 */
public final class Context {
    public static final String WORLD_KEY = "world";

    private final String type;
    private final String name;

    /**
     * Create a new context instance
     *
     * @param type Context type. Must not be null.
     * @param name Context name. Must not be null.
     */
    public Context(String type, String name) {
        checkNotNull(type, "type");
        checkNotNull(name, "name");
        this.type = type;
        this.name = name;
    }

    /**
     * Get the type.
     *
     * @return the type of item this context represents, for example for a world
     *         this would be {@code world}
     */
    public String getType() {
        return type;
    }

    /**
     * Get the name.
     *
     * @return the specific name of the item involved in this context, for
     *         example if the type were {@code world} this would be the name of the
     *         world.
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Context context = (Context) o;

        if (!name.equals(context.name)
                || !type.equals(context.type)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
