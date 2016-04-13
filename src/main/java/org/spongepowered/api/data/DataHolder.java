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

import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.data.property.PropertyHolder;
import org.spongepowered.api.data.value.mutable.CompositeValueStore;

/**
 * A data holder object allows the access of additional data on the object
 * that is not simply expressed by its basic type.
 */
public interface DataHolder extends DataSerializable, PropertyHolder, CompositeValueStore<DataHolder, DataManipulator<?, ?>> {

    /**
     * Validates the container with known data required to set the raw data to
     * this {@link DataHolder}. If the container is incomplete or contains
     * invalid data, <code>false</code> is returned.
     *
     * <p>This validation should be checked prior to calling
     * {@link #setRawData(DataView)} to avoid exceptions.</p>
     *
     * @param container The raw data to validate
     * @return True if the data is valid
     */
    boolean validateRawData(DataView container);

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
    void setRawData(DataView container) throws InvalidDataException;
}
