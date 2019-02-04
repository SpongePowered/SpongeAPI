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
package org.spongepowered.api.data.property.store;

import org.spongepowered.api.data.property.DirectionRelativePropertyHolder;
import org.spongepowered.api.data.property.Property;
import org.spongepowered.api.data.property.PropertyHolder;
import org.spongepowered.api.util.Direction;

import java.util.Optional;

/**
 * Represents a handler for a {@link PropertyHolder} such that if a
 * {@link PropertyHolder} cannot properly provide the {@link Property}
 * values natively, a {@link PropertyStore} can optionally provide
 * an "override" or "customized" support of a particular {@link Property}
 * for any variants of {@link PropertyHolder}s.
 *
 * @param <V> The value type of the property
 */
public interface PropertyStore<V> {

    /**
     * Gets the desired property value for the provided {@link PropertyHolder} at
     * present time. A property may not be the same throughout the course of
     * the lifetime of the {@link PropertyHolder}.
     *
     * @param propertyHolder The data holder to get a property from
     * @return The property value
     */
    Optional<V> getFor(PropertyHolder propertyHolder);

    /**
     * Gets the desired property value for the provided {@link DirectionRelativePropertyHolder}
     * at present time, in relation to the provided {@link Direction}.
     *
     * @param propertyHolder The direction relative property holder
     * @param direction The direction in relation to
     * @return The property value
     */
    default Optional<V> getFor(DirectionRelativePropertyHolder propertyHolder, Direction direction) {
        return propertyHolder instanceof PropertyHolder ? getFor((PropertyHolder) propertyHolder) : Optional.empty();
    }

    /**
     * Gets the priority of which this {@link PropertyStore} is used for
     * handling a particular {@link PropertyHolder}. This is useful for
     * multiple possible handlers of a {@link Property} being available
     * in customized {@link PropertyHolder}s.
     *
     * <p>The priority is a measurement where the higher the priority, the
     * sooner this {@link PropertyStore} is queried such that if
     * {@link #getFor(PropertyHolder)} is called and returns a present value,
     * that present value is returned. The default priority of a
     * {@link PropertyStore} is <code>100</code>.</p>
     *
     * @return The priority
     */
    default int getPriority() {
        return 100;
    }

}
