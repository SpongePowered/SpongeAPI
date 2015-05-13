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
package org.spongepowered.api.data;

import com.google.common.base.Optional;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.GetterValue;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.SetterValue;

/**
 * Represents some container of arbitrary data values.
 *
 * @param <D> The type of data that this DataObject is restricted to
 */
public interface DataObject<D> {

    boolean supports(BaseValue<?, ? extends D> value);

    /**
     * Gets some value.
     *
     * @param value The property
     * @param <E> The type of value
     * @return The value
     */
    <E> Optional<E> get(GetterValue<E, ? extends D> value);

    /**
     * Gets some value, or the default.
     *
     * @param value The property
     * @param defaultValue The value if the prop does not exist
     * @param <E> The type of value
     * @return The value
     */
    <E> E getOrElse(GetterValue<E, ? extends D> value, E defaultValue);

    /**
     * Gets some value that is known to be present.
     *
     * @param value The value
     * @param <E> The type of value
     * @return The value
     */
    <E> E tryGet(GetterValue<E, ? extends D> value);

    /**
     * Sets some value.
     *
     * @param value The property
     * @param result The value to set
     * @param <E> The type of value
     * @return This object
     */
    <E> DataObject<D> set(SetterValue<E, ? extends D> value, E result);

    /**
     * Gets a data object with further restrictions on data.
     *
     * <p>As an example, use this to get a data "manipulator" from a more generic data object.</p>
     *
     * @param clazz The class of data to restrict to
     * @param <V> The type of data to restrict to
     * @return The nested data object
     */
    <V extends D> Optional<DataObject<V>> restrict(Class<V> clazz);

    /**
     * Gets a data object with further restrictions on data.
     *
     * <p>As an example, use this to get a data "manipulator" from a more generic data object.</p>
     *
     * @param value The value to restrict to
     * @param <V> The type of data to restrict to
     * @return The nested data object
     */
    <E, V extends D>  Optional<DataObject<V>> restrict(Value<E, V> value);

    /**
     * Gets a data object with further restrictions on data.
     *
     * <p>As an example, use this to get a data "manipulator" from a more generic data object.</p>
     *
     * @param clazz The class of data to restrict to
     * @param <V> The type of data to restrict to
     * @return The nested data object
     */
    <V extends D> Optional<DataObject<V>> tryRestrict(Class<V> clazz);

    /**
     * Gets a data object with further restrictions on data.
     *
     * <p>As an example, use this to get a data "manipulator" from a more generic data object.</p>
     *
     * @param value The value to restrict to
     * @param <V> The type of data to restrict to
     * @return The nested data object
     */
    <E, V extends D> DataObject<V> tryRestrict(Value<E, V> value);

    /**
     * Copies all keys from the given data object to those which are supported in the current data object.
     *
     * @param dataObject
     * @return
     */
    DataObject<D> copyFrom(DataObject<? extends D> dataObject);

    /**
     * Copies as many keys as possible in the current data object to the given data object.
     *
     * @param dataObject
     * @return
     */
    DataObject<D> copyTo(DataObject<? super D> dataObject);

}
