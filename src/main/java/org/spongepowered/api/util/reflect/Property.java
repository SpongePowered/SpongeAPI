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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Optional;

import java.lang.reflect.Method;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * A property is a getter with possibly a setter pair.
 */
public final class Property {

    private final String name;
    private final Class<?> type;
    private final Method accessor;
    private final Optional<Method> mutator;

    /**
     * Create a new property.
     *
     * @param name The name of the property
     * @param type The type of property
     * @param accessor The accessor
     * @param mutator The mutator
     */
    public Property(String name, Class<?> type, Method accessor, @Nullable Method mutator) {
        checkNotNull(name, "name");
        checkNotNull(type, "type");
        checkNotNull(accessor, "accessor");
        this.name = name;
        this.type = type;
        this.accessor = accessor;
        this.mutator = Optional.fromNullable(mutator);
    }

    /**
     * Get the name of the property.
     *
     * @return The name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the type of the paramteer.
     *
     * @return The type
     */
    public Class<?> getType() {
        return this.type;
    }

    /**
     * Get the method representing the accessor.
     *
     * @return The accessor
     */
    public Method getAccessor() {
        return this.accessor;
    }

    /**
     * Get the method representing the mutator, which or may not exist.
     *
     * @return The mutator
     */
    public Optional<Method> getMutator() {
        return this.mutator;
    }

    /**
     * Tests whether the {@link Nullable} annotation has been applied
     * to this property.
     *
     * @return True if the annotation has been applied
     */
    public boolean hasNullable() {
        return getAccessor().getAnnotation(Nullable.class) != null;
    }

    /**
     * Tests whether the {@link Nonnull} annotation has been applied
     * to this property.
     *
     * @return True if the annotation has been applied
     */
    public boolean hasNonnull() {
        return getAccessor().getAnnotation(Nonnull.class) != null;
    }

}
