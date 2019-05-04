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
import org.spongepowered.api.data.value.CompositeValueStore;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.ValueContainer;

public interface DataStore {

    // What is this? The supported container type? Maybe a predicate?
    TypeToken<?> getSupportedToken();

    //DataView serialize(Iterable<Value<?>> values, DataView view);

    /**
     * Serializes the values from the {@link ValueContainer}.
     *
     * @param valueContainer The value container
     */
    default DataView serialize(ValueContainer valueContainer) {
        final DataView dataView = DataContainer.createNew();
        serialize(valueContainer, dataView);
        return dataView;
    }

    /**
     * Serializes the values from the {@link ValueContainer}
     * into the {@link DataView}.
     *
     * @param valueContainer The value container
     * @param view The data view to serialize to
     */
    void serialize(ValueContainer valueContainer, DataView view);

    //Iterable<Value.Mutable<?>> deserialize(DataView view);

    /**
     * Deserializes the {@link DataView} as a {@link CompositeValueStore}.
     *
     * @param view The data view to deserialize
     * @return The value store
     */
    default CompositeValueStore deserialize(DataView view) {
        final CompositeValueStore valueStore = CompositeValueStore.of();
        deserialize(valueStore, view);
        return valueStore;
    }

    /**
     * Deserializes the data from the {@link DataView} and puts
     * it in the {@link CompositeValueStore}.
     *
     * @param valueStore The value store
     * @param view The data view to deserialize
     */
    void deserialize(CompositeValueStore valueStore, DataView view);
}
