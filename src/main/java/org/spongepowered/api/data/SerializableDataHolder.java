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

import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.item.ItemType;

/**
 * Represents a {@link DataHolder} that can be serialized into a {@link DataContainer}.
 */
public interface SerializableDataHolder extends DataSerializable, CopyableDataHolder {

    /**
     * Returns the raw extra data of this {@link SerializableDataHolder}.
     *
     * <p>The format of the {@link DataView}'s contained data is dependent on the type
     * of {@link DataHolder.Mutable} this is. In some cases, the format is specified
     * based on a more specific type, such as for {@link EntityType}s, or
     * {@link ItemType}s.</p>
     * <p>The data can be modified and set back using
     * {@link Mutable#setRawData(DataView)} or {@link Immutable#withRawData(DataView)}
     * methods.</p>
     * <p><b>Warning:</b> Be aware of the safety mode of the returned container.
     * The container may contain mutable values, such as arrays, that may not be
     * cloned, and thus changing them may inadvertently change the internal state
     * of the {@link DataHolder}.</p>
     *
     * @return The raw data
     */
    DataContainer rawData();

    /**
     * Validates the container with known data required to set the raw data to
     * this {@link SerializableDataHolder}. If the container is incomplete or contains
     * invalid data, <code>false</code> is returned.
     *
     * <p>This validation should be checked prior to calling
     * {@link Mutable#setRawData(DataView)} or
     * {@link Immutable#withRawData(DataView)}
     * to avoid exceptions.</p>
     *
     * @param container The raw data to validate
     * @return True if the data is valid
     */
    boolean validateRawData(DataView container);

    @Override
    SerializableDataHolder copy();

    interface Mutable extends SerializableDataHolder, DataHolder.Mutable {

        /**
         * Attempts to set all data of this {@link DataHolder} according to the
         * {@link DataView}'s held information. Using this to modify unknown data
         * that is not supported by Data API. The format of the {@link DataView}'s
         * contained data is dependent on the type of {@link DataHolder.Mutable}
         * this is. In some cases, the format is specified based on a more specific
         * type, such as for {@link EntityType}s, or {@link ItemType}s.
         *
         * <p>This setter is used to provide setting custom data that is not
         * represented by the Data API, including forge mods and other
         * unknown data. Attempts to validate the provided view is not always
         * possible due to the nature of the data being parsed by the implementation,
         * and only understood by clients. Other cases where the data <b>can</b>
         * be validated and the data is incompatible will end up throwing an
         * {@link InvalidDataException}.</p>
         *
         * @param container A container containing all raw data to set on this
         *     data holder
         * @throws InvalidDataException If the container is missing or has invalid
         *     data that this holder will refuse
         * @see SerializableDataHolder#rawData()
         */
        void setRawData(DataView container) throws InvalidDataException;

        @Override
        SerializableDataHolder.Mutable copy();
    }

    interface Immutable<I extends Immutable<I>> extends SerializableDataHolder, DataHolder.Immutable<I> {

        /**
         * Attempts to set all data of this {@link DataHolder} according to the
         * {@link DataView}'s held information. Using this to modify unknown data
         * that is not supported by Data API. The format of the {@link DataView}'s
         * contained data is dependent on the type of {@link DataHolder.Immutable}
         * this is. In some cases, the format is specified based on a more specific
         * type, such as for {@link EntityType}s, or {@link ItemType}s.
         *
         * <p>This setter is used to provide setting custom data that is not
         * represented by the Data API, including forge mods and other
         * unknown data. Attempts to validate the provided view is not always
         * possible due to the nature of the data being parsed by the implementation,
         * and only understood by clients. Other cases where the data <b>can</b>
         * be validated and the data is incompatible will end up throwing an
         * {@link InvalidDataException}.</p>
         *
         * @param container A container containing all raw data to set on this
         *     data holder
         * @return The new immutable data holder containing the raw data
         * @throws InvalidDataException If the container is missing or has invalid
         *     data that this holder will refuse
         * @see SerializableDataHolder#rawData()
         */
        I withRawData(DataView container) throws InvalidDataException;

        @Override
        I copy();
    }
}
