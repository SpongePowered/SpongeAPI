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
package org.spongepowered.api.data.property;

import org.spongepowered.api.data.property.store.DoublePropertyStore;
import org.spongepowered.api.data.property.store.IntPropertyStore;
import org.spongepowered.api.data.property.store.PropertyStore;
import org.spongepowered.api.registry.CatalogRegistryModule;

public interface PropertyRegistry extends CatalogRegistryModule<Property<?>> {

    /**
     * Registers the provided {@link PropertyStore} for the given
     * {@link Property}. Note that only a single {@link PropertyStore}
     * can be registered per {@link Property}. Multiple
     * registrations will result in exceptions being thrown.
     *
     * @param property The property to register the store for
     * @param propertyStore The property store
     * @param <V> The value type of the property
     */
    <V> void register(Property<V> property, PropertyStore<V> propertyStore);

    /**
     * Retrieves the {@link PropertyStore} associated for the provided
     * {@link Property}.
     *
     * <p>If there are no registered {@link PropertyStore}s, then will the
     * returned store always return empty.</p>
     *
     * @param property The property
     * @param <V> The value type of the property
     * @return The property store
     */
    <V> PropertyStore<V> getStore(Property<V> property);

    /**
     * Retrieves the {@link IntPropertyStore} associated for the provided
     * {@link Property}.
     *
     * <p>If there are no registered {@link PropertyStore}s, then will the
     * returned store always return empty.</p>
     *
     * @param property The property
     * @return The property store
     */
    IntPropertyStore getIntStore(Property<Integer> property);

    /**
     * Retrieves the {@link DoublePropertyStore} associated for the provided
     * {@link Property}.
     *
     * <p>If there are no registered {@link PropertyStore}s, then will the
     * returned store always return empty.</p>
     *
     * @param property The property
     * @return The property store
     */
    DoublePropertyStore getDoubleStore(Property<Double> property);
}
