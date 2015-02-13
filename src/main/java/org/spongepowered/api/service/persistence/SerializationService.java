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
 * A service that manages {@link DataSerializableBuilder}s and sometimes the
 * deserialization of various {@link DataSerializable}s.
 */
public interface SerializationService {

    /**
     * Registers a {@link DataSerializableBuilder} that will dynamically build
     * the given {@link DataSerializable} from a {@link DataContainer}.
     *
     * <p>Builders may not always exist for a given {@link DataSerializable},
     * nor is it guaranteed that a provided builder will function with all
     * {@link DataContainer}s.
     * </p>
     *
     * @param clazz The class of the {@link DataSerializable}
     * @param builder The builder that can build the data serializable
     * @param <T> The type of data serializable
     */
    <T extends DataSerializable> void registerBuilder(Class<T> clazz,
            DataSerializableBuilder<T> builder);

    /**
     * Attempts to retrieve the {@link DataSerializableBuilder} for the desired {@link
     * DataSerializable} class.
     *
     * <p>Builders may not always exist for a given {@link DataSerializable}, nor is it
     * guaranteed that a provided builder will function with all {@link DataContainer}s.</p>
     *
     * @param clazz The class of the data serializable
     * @param <T> The type of data serializable
     * @return The builder, if available
     */
    <T extends DataSerializable>  Optional<DataSerializableBuilder<T>> getBuilder(Class<T> clazz);

}
