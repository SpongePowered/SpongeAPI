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
import org.spongepowered.api.data.value.CompositeValueStore;
import org.spongepowered.api.service.persistence.InvalidDataException;

import java.util.Collection;

/**
 * A data holder object allows the access of additional data on the object
 * that is not simply expressed by its basic type.
 */
public interface DataHolder extends DataSerializable, CompositeValueStore<DataHolder> {

    /**
     * Gets an copied collection of all known {@link DataManipulator}s
     * belonging to this {@link DataHolder}. An individual
     * {@link DataManipulator} can be used for creating new data to replace on
     * this {@link DataHolder}.
     *
     * @return A collection of copied data manipulators belonging to this
     *     data holder
     */
    Collection<DataManipulator<?>> getManipulators();

    /**
     * Attempts to retrieve a specific {@link Property} type of this
     * {@link DataHolder}. If the property is not applicable,
     * {@link Optional#absent()} is returned.
     *
     * <p>{@link Property}s can define various immutable information about a
     * {@link DataHolder} that is dependent on the instance of the holder.
     * As {@link Property}s cannot be changed, the {@link DataHolder} can
     * not change the information about it's own properties either.</p>
     *
     * @param propertyClass The property class
     * @param <T> The type of property
     * @return The property, if available
     */
    <T extends Property<?, ?>> Optional<T> getProperty(Class<T> propertyClass);

    /**
     * Gets an immutable collection of all known {@link Property}s pertaining to
     * this {@link DataHolder}.
     *
     * <p>{@link Property}s can not be changed such that the property is attached
     * to the instance of the residing {@link DataHolder}.</p>
     *
     * @return An immutable collection of all known {@link Property}s
     */
    Collection<Property<?, ?>> getProperties();

    /**
     * Validates the container with known data required to set the raw data to
     * this {@link DataHolder}. If the container is incomplete or contains
     * invalid data, <code>false</code> is returned.
     *
     * <p>This validation should be checked prior to calling
     * {@link #setRawData(DataContainer)} to avoid exceptions.</p>
     *
     * @param container The raw data to validate
     * @return True if the data is valid
     */
    boolean validateRawData(DataContainer container);

    /**
     * Attempts to set all data of this {@link DataHolder} according to the
     * {@link DataContainer}'s held information. Using this to modify known
     * {@link DataManipulator} is unsupported and if the data is invalid, an
     * {@link InvalidDataException} is thrown.
     *
     * <p>This setter is used to provide setting custom data that is not
     * represented by the Data API, including forge mods and other
     * unknown data. Attempts at validating known {@link DataManipulator}s
     * contained in the data container are made with the assumption that all
     * necessary data exists.</p>
     *
     * @param container A container containing all raw data to set on this
     *     data holder
     * @throws InvalidDataException If the container is missing or has invalid
     *     data that this holder will refuse
     */
    void setRawData(DataContainer container) throws InvalidDataException;

}
