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
package org.spongepowered.api.service.persistence;

import com.google.common.base.Optional;
import org.spongepowered.api.service.persistence.data.DataContainer;

/**
 * Represents a source that data may be serialized to and from. The source
 * may exist asynchronous to the game server itself.
 * <p>A {@link DataSource} may not always be available for serialization
 * purposes, so {@link #isClosed()} should be checked to avoid exceptions.
 * </p>
 */
public interface DataSource {

    /**
     * Deserializes the given class type from this source.
     *
     * <p>A DataSource may have restrictions on the type of data it can
     * handle. Inferring that a source can handle a particular kind of data
     * is not safe.</p>
     *
     * @param clazz The class to deserialize to
     * @param <T> The type of object to produce
     * @return The newly deserialized object, if available
     * @throws InvalidDataException If the data is incompatible with this source
     */
    <T extends DataSerializable> Optional<T> deserialize(Class<T> clazz)
            throws InvalidDataException;

    /**
     * Deserializes all data existing in this source into a single {@link
     * DataContainer}. This can be used for passing around data containers
     * without knowing the contents.
     *
     * @return A data container containing all data from this source
     */
    Optional<DataContainer> deserialize();

    /**
     * Serializes the given {@link DataSerializable} to this source.
     *
     * <p>A DataSource may have restrictions on the type of data it can
     * handle. Inferring that a source can handle a particular kind of data
     * is not safe.</p>
     *
     * @param section The data object to serialize
     * @throws InvalidDataException If the data object is incompatible with this source
     */
    void serialize(DataSerializable section) throws InvalidDataException;

    /**
     * Checks whether this source is still available for serialization operations.
     *
     * @return Whether this source is still usable
     */
    boolean isClosed();

}
