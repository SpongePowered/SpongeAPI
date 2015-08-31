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

import org.spongepowered.api.data.Property;

import java.util.Optional;

public interface PropertyRegistry {

    /**
     * Registers the provided {@link PropertyStore} for the given
     * {@link Property} {@link Class}. Note that only a single
     * {@link PropertyStore} can be registered per {@link Property}. Multiple
     * registrations will result in exceptions being thrown.
     *
     * @param propertyClass The property class
     * @param propertyStore The property store
     * @param <T> The type of property
     */
    <T extends Property<?, ?>> void register(Class<T> propertyClass, PropertyStore<T> propertyStore);

    /**
     * Retrieves the {@link PropertyStore} associated for the provided
     * {@link Property} class.
     *
     * @param propertyClass The property class
     * @param <T> The type of property
     * @return The property store, if available
     */
    <T extends Property<?, ?>> Optional<PropertyStore<T>> getStore(Class<T> propertyClass);

}
