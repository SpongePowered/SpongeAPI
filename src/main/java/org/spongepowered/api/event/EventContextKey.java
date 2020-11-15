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
package org.spongepowered.api.event;

import io.leangen.geantyref.TypeToken;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.CatalogBuilder;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.lang.reflect.Type;

/**
 * A key for values in the {@link EventContext}.
 *
 * @param <T> The type of the value stored with this key
 */
@CatalogedBy(EventContextKeys.class)
public interface EventContextKey<T> extends CatalogType {

    /**
     * Creates a builder to be used for creating a new {@link EventContextKey}.
     *
     * @return The constructed builder
     */
    @SuppressWarnings("unchecked")
    static Builder<?> builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Gets the allowed type for the value of this key.
     *
     * <p>This is a concrete type equal to the parameter {@code T}</p>
     *
     * @return The allowed type
     */
    Type getAllowedType();

    /**
     * Return whether the value is an instance of this key's value type.
     *
     * @param value value to check
     * @return if instance
     */
    boolean isInstance(Object value);

    /**
     * Cast the provided value to the value type.
     *
     * @param value value
     * @return the casted value
     * @throws ClassCastException if {@code value} is not of the correct type
     */
    T cast(Object value);

    interface Builder<T> extends CatalogBuilder<EventContextKey<T>, Builder<T>> {

        <N> Builder<N> type(Class<N> allowedType);

        <N> Builder<N> type(TypeToken<N> allowedType);
    }
}
