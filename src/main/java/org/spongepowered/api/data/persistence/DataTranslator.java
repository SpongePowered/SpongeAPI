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

import io.leangen.geantyref.TypeToken;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Map;

/**
 * A compatibility object to translate and translate any type of
 * {@link Object} that is not a {@link DataSerializable}. Natively,
 * {@link DataView} will attempt to locate a {@code DataTranslator}
 * during {@link DataView#set(DataQuery, Object)}.
 *
 * @param <T> The type of object that this translator can handle
 */
@CatalogedBy(DataTranslators.class)
public interface DataTranslator<T> extends CatalogType {

    /**
     * Gets the {@link TypeToken} of this translator.
     *
     * @see TypeToken
     * @return The type token for this translator
     */
    TypeToken<T> getToken();

    /**
     * Attempts to translate the {@code T} object from the provided
     * {@link DataView}.
     *
     * @param view The data view to translate the object from
     * @return The deserialized object
     * @throws InvalidDataException If the dataview contained invalid data
     */
    T translate(DataView view) throws InvalidDataException;

    /**
     * Serializes the provided object to a {@link DataContainer}.
     *
     * @param obj The object to translate
     * @return The object serialized to a container
     * @throws InvalidDataException If the desired object is not supported
     *     for any reason
     */
    DataContainer translate(T obj) throws InvalidDataException;

    /**
     * Serializes the {@code T} object and applies the provided
     * data to the provided {@link DataView} instead of creating
     * a new {@link DataContainer}, reducing nested information.
     *
     * @param obj The object to serialize
     * @param dataView The data view to serialize to
     * @return The provided data view, for chaining
     */
    default DataView addTo(T obj, DataView dataView) {
        for (Map.Entry<DataQuery, Object> entry : translate(obj).getValues(false).entrySet()) {
            dataView.set(entry.getKey(), entry);
        }
        return dataView;
    }
}
