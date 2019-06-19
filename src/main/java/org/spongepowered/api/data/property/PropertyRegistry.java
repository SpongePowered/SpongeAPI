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

import org.spongepowered.api.data.property.provider.DoublePropertyProvider;
import org.spongepowered.api.data.property.provider.IntPropertyProvider;
import org.spongepowered.api.data.property.provider.PropertyProvider;
import org.spongepowered.api.registry.CatalogRegistryModule;

public interface PropertyRegistry extends CatalogRegistryModule<Property<?>> {

    /**
     * Registers the provided {@link PropertyProvider} for the given
     * {@link Property}.
     *
     * @param property The property to register the store for
     * @param propertyProvider The property provider
     * @param <V> The value type of the property
     */
    <V> void register(Property<V> property, PropertyProvider<V> propertyProvider);

    /**
     * Retrieves the {@link PropertyProvider} associated for the provided
     * {@link Property}.
     *
     * <p>If there are no registered {@link PropertyProvider}s, then will the
     * returned provider always return empty.</p>
     *
     * @param property The property
     * @param <V> The value type of the property
     * @return The property provider
     */
    <V> PropertyProvider<V> getProvider(Property<V> property);

    /**
     * Retrieves the {@link IntPropertyProvider} associated for the provided
     * {@link Property}.
     *
     * <p>If there are no registered {@link PropertyProvider}s, then will the
     * returned provider always return empty.</p>
     *
     * @param property The property
     * @return The property provider
     */
    IntPropertyProvider getIntProvider(Property<Integer> property);

    /**
     * Retrieves the {@link DoublePropertyProvider} associated for the provided
     * {@link Property}.
     *
     * <p>If there are no registered {@link PropertyProvider}s, then will the
     * returned provider always return empty.</p>
     *
     * @param property The property
     * @return The property provider
     */
    DoublePropertyProvider getDoubleProvider(Property<Double> property);
}
