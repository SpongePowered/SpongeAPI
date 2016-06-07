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
package org.spongepowered.api.data.persistence;

import com.google.common.reflect.TypeToken;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataQuery;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.MemoryDataView;

import java.util.Optional;

/**
 * A compatibility object to serialize and deserialize any type of
 * {@link Object} that is not a {@link DataSerializable}. Natively,
 * {@link MemoryDataView} will attempt to locate a {@code DataSerializer}
 * during {@link DataView#set(DataQuery, Object)}.
 *
 * @param <T> The type of object that this serializer and handle
 */
public interface DataSerializer<T> {

    TypeToken<T> getToken();

    /**
     * Attempts to deserialize the {@code T} object from the provided
     * {@link DataView}.
     *
     * @param view The data view to deserialize the object from
     * @return The object, deserialized, if available
     * @throws InvalidDataException If the dataview contained invalid data
     */
    Optional<T> deserialize(DataView view) throws InvalidDataException;

    /**
     * Serializes the provided object to a {@link DataContainer}.
     *
     * @param obj The object to serialize
     * @return The object serialized to a container
     * @throws InvalidDataException If the desired object is not supported
     *     for any reason
     */
    DataContainer serialize(T obj) throws InvalidDataException;
}
