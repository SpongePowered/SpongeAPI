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

import com.google.common.reflect.TypeToken;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.MutableDataManipulator;
import org.spongepowered.api.data.value.MutableValueStore;
import org.spongepowered.api.data.value.Value;

public interface DataStore {

    // What is this? The supported container type? Maybe a predicate?
    TypeToken<?> getSupportedToken();

    //DataView serialize(Iterable<Value<?>> values, DataView view);

    /**
     * Serializes the {@link Value}s.
     *
     * @param values The value container
     */
    default DataView serialize(Iterable<Value<?>> values) {
        return serialize(ImmutableDataManipulator.viewOf(values));
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
     * Serializes the values of the {@link DataManipulator}
     * into the {@link DataView}.
     *
     * @param dataManipulator The data manipulator
     * @param view The data view to serialize to
     */
    void serialize(DataManipulator dataManipulator, DataView view);

    //Iterable<Value.Mutable<?>> deserialize(DataView view);

    /**
     * Deserializes the {@link DataView} as a {@link MutableValueStore}.
     *
     * @param view The data view to deserialize
     * @return The value store
     */
    default DataManipulator deserialize(DataView view) {
        final MutableDataManipulator dataManipulator = MutableDataManipulator.of();
        deserialize(dataManipulator, view);
        return dataManipulator;
    }

    /**
     * Deserializes the data from the {@link DataView} and puts
     * it in the {@link MutableValueStore}.
     *
     * @param dataManipulator The mutable data manipulator
     * @param view The data view to deserialize
     */
    void deserialize(MutableDataManipulator dataManipulator, DataView view);
}
