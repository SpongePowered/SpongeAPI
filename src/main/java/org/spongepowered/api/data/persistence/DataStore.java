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
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.data.value.Value;

public interface DataStore {

    TypeToken<? extends DataHolder> getSupportedToken();

    /**
     * Serializes the values of the {@link DataManipulator}
     * into the {@link DataView}.
     *
     * @param dataManipulator The data manipulator
     * @param view The data view to serialize to
     */
    DataView serialize(DataManipulator dataManipulator, DataView view);

    default DataView serialize(Iterable<Value<?>> values, DataView view) {
        return serialize(DataManipulator.immutableOf(values), view);
    }

    /**
     * Serializes the {@link Value}s.
     *
     * @param values The value container
     */
    default DataView serialize(Iterable<Value<?>> values) {
        return serialize(DataManipulator.immutableOf(values));
    }

    /**
     * Serializes the values of the {@link DataManipulator}.
     *
     * @param dataManipulator The data manipulator
     */
    default DataView serialize(DataManipulator dataManipulator) {
        final DataView dataView = DataContainer.createNew();
        serialize(dataManipulator, dataView);
        return dataView;
    }

    /**
     * Deserializes the data from the {@link DataView} and puts
     * it in the {@link org.spongepowered.api.data.DataManipulator.Mutable}.
     *
     * @param dataManipulator The mutable data manipulator
     * @param view The data view to deserialize
     */
    void deserialize(DataManipulator.Mutable dataManipulator, DataView view);

    /**
     * Deserializes the {@link DataView} as a {@link org.spongepowered.api.data.DataManipulator.Mutable}.
     *
     * @param view The data view to deserialize
     * @return The value store
     */
    default DataManipulator.Mutable deserialize(DataView view) {
        final DataManipulator.Mutable dataManipulator = DataManipulator.of();
        deserialize(dataManipulator, view);
        return dataManipulator;
    }

}
