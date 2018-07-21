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

import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface PropertyHolder {

    /**
     * Attempts to retrieve a value for the specified {@link Property}. If
     * the property is not applicable, {@link Optional#empty()} is returned.
     *
     * <p>{@link Property}s can define various immutable information about a
     * {@link PropertyHolder} that is dependent on the instance of the holder.
     * As {@link Property}s cannot be changed, the {@link PropertyHolder} can
     * not change the information about it's own properties either.</p>
     *
     * <p>The catalog {@link Properties} lists most of the available properties.</p>
     *
     * @param property The property to retrieve the value for
     * @param <V> The property value type
     * @return The property value, if available
     */
    <V> Optional<V> getProperty(Property<V> property);

    /**
     * Attempts to retrieve a integer value for the specified int {@link Property}. If
     * the property is not applicable, {@link Optional#empty()} is returned.
     *
     * @param property The property to retrieve the value for
     * @return The integer property value, if available
     * @see #getProperty(Property)
     */
    OptionalInt getIntProperty(Property<Integer> property);

    /**
     * Attempts to retrieve a double value for the specified int {@link Property}. If
     * the property is not applicable, {@link Optional#empty()} is returned.
     *
     * @param property The property to retrieve the value for
     * @return The double property value, if available
     * @see #getProperty(Property)
     */
    OptionalDouble getDoubleProperty(Property<Double> property);

    /**
     * Gets an immutable map of all known {@link Property}s that
     * are supported by this {@link PropertyHolder} mapped to their value.
     *
     * <p>{@link Property}s can not be changed such that the property is
     * attached to the instance of the residing {@link PropertyHolder}.</p>
     *
     * @return An immutable collection of all known {@link Property}s
     */
    Map<Property<?>, ?> getProperties();
}
