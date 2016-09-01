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
package org.spongepowered.api.data.key;

import com.google.common.reflect.TypeToken;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataQuery;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.data.value.mutable.Value;

/**
 * Represents a key to an underlying {@link BaseValue} such that the underlying
 * value can be retrieved from a {@link ValueContainer}. As well, a {@link Key}
 * can be used for {@link DataSerializable}s with the included
 * {@link #getQuery()} to retrieve the recommended {@link DataQuery} to use.
 *
 * @param <V> The type of {@link BaseValue}
 */
public interface Key<V extends BaseValue<?>> extends CatalogType {

    /**
     * Gets the class of the {@link Value} this {@link Key} is representing.
     *
     * @return The value class
     */
    TypeToken<V> getValueToken();

    /**
     * Gets the class of the element of the {@link Value} this {@link Key}
     * is representing.
     *
     * @return The element class
     */
    TypeToken<?> getElementToken();

    /**
     * Gets the {@link DataQuery} for recommended use with
     * {@link DataContainer}s.
     *
     * @return The recommended {@link DataQuery} for use
     */
    DataQuery getQuery();

}
