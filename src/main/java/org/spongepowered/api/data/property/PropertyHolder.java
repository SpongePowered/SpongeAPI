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

import java.util.Collection;
import java.util.Optional;

public interface PropertyHolder {

    /**
     * Attempts to retrieve a specific {@link Property} type of this
     * {@link PropertyHolder}. If the property is not applicable,
     * {@link Optional#empty()} is returned.
     *
     * <p>{@link Property}s can define various immutable information about a
     * {@link PropertyHolder} that is dependent on the instance of the holder.
     * As {@link Property}s cannot be changed, the {@link PropertyHolder} can
     * not change the information about it's own properties either.</p>
     *
     * @param propertyClass The property class
     * @param <T> The type of property
     * @return The property, if available
     */
    <T extends Property<?, ?>> Optional<T> getProperty(Class<T> propertyClass);

    /**
     * Gets an immutable collection of all known {@link Property}s pertaining
     * to this {@link PropertyHolder}.
     *
     * <p>{@link Property}s can not be changed such that the property is
     * attached to the instance of the residing {@link PropertyHolder}.</p>
     *
     * @return An immutable collection of all known {@link Property}s
     */
    Collection<Property<?, ?>> getApplicableProperties();

}
