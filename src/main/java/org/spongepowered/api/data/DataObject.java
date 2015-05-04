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
import org.spongepowered.api.data.prop.GetterProp;
import org.spongepowered.api.data.prop.Prop;
import org.spongepowered.api.data.prop.SetterProp;

/**
 * Represents some container of arbitrary data values.
 *
 * @param <D> The type of data that this DataObject is restricted to
 */
public interface DataObject<D> {

    /**
     * Gets some value that is known to be present.
     *
     * @param prop The property
     * @param <E> The type of value
     * @return The value
     * @throws UnsupportedOperationException If the value is not present
     */
    <E> E getUnsafe(GetterProp<E, ? extends D> prop) throws UnsupportedOperationException;

    /**
     * Gets some value.
     *
     * @param prop The property
     * @param <E> The type of value
     * @return The value
     * @throws UnsupportedOperationException If the value is not present
     */
    <E> Optional<E> get(GetterProp<E, ? extends D> prop) throws UnsupportedOperationException;

    /**
     * Gets some value, or the default.
     *
     * @param prop The property
     * @param defaultValue The value if the prop does not exist
     * @param <E> The type of value
     * @return The value
     * @throws UnsupportedOperationException If the value is not present
     */
    <E> E getOrElse(GetterProp<E, ? extends D> prop, E defaultValue) throws UnsupportedOperationException;

    /**
     * Sets some value.
     *
     * @param prop The property
     * @param value The value to set
     * @param <E> The type of value
     * @return This object
     */
    <E> DataObject<D> set(SetterProp<E, ? extends D> prop, E value);

    /**
     * Sets some value, if it can be set.
     *
     * @param prop The property
     * @param value The value to set
     * @param <E> The type of value
     * @return This object
     */
    <E> DataObject<D> setIfPresent(SetterProp<E, ? extends D> prop, E value);

    /**
     * Gets a data object with further restrictions on data.
     *
     * <p>As an example, use this to get a data "manipulator" from a more generic data object.</p>
     *
     * @param clazz The class of data to restrict to
     * @param <V> The type of data to restrict to
     * @return The nested data object
     */
    <V extends D> DataObject<V> restrict(Class<V> clazz);

    /**
     * Gets a data object with further restrictions on data.
     *
     * <p>As an example, use this to get a data "manipulator" from a more generic data object.</p>
     *
     * @param prop The prop to restrict to
     * @param <V> The type of data to restrict to
     * @return The nested data object
     */
    <E, V extends D> DataObject<V> restrict(Prop<E, V> prop);

    /**
     * Copies all keys in the given data object to those which are supported in the current data object.
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
