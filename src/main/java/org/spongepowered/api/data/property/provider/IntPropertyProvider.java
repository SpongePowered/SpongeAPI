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
package org.spongepowered.api.data.property.provider;

import org.spongepowered.api.data.property.DirectionRelativePropertyHolder;
import org.spongepowered.api.data.property.PropertyHolder;
import org.spongepowered.api.util.Direction;

import java.util.Optional;
import java.util.OptionalInt;

/**
 * A property store for int value types.
 */
public interface IntPropertyProvider extends PropertyProvider<Integer> {

    /**
     * Gets the desired property value for the provided {@link PropertyHolder} at
     * present time. A property may not be the same throughout the course of
     * the lifetime of the {@link PropertyHolder}.
     *
     * @param propertyHolder The data holder to get a property from
     * @return The property value
     */
    OptionalInt getIntFor(PropertyHolder propertyHolder);

    /**
     * Gets the desired property value for the provided {@link DirectionRelativePropertyHolder}
     * and {@link Direction} at present time. A property may not be the same throughout
     * the course of the lifetime of the {@link PropertyHolder}.
     *
     * @param propertyHolder The direction relative property holder
     * @param direction The direction
     * @return The property value
     */
    default OptionalInt getIntFor(DirectionRelativePropertyHolder propertyHolder, Direction direction) {
        return propertyHolder instanceof PropertyHolder ? getIntFor((PropertyHolder) propertyHolder) : OptionalInt.empty();
    }

    @Override
    default Optional<Integer> getFor(PropertyHolder propertyHolder) {
        final OptionalInt optionalInt = getIntFor(propertyHolder);
        return optionalInt.isPresent() ? Optional.of(optionalInt.getAsInt()) : Optional.empty();
    }

    @Override
    default Optional<Integer> getFor(DirectionRelativePropertyHolder propertyHolder, Direction direction) {
        final OptionalInt optionalInt = getIntFor(propertyHolder, direction);
        return optionalInt.isPresent() ? Optional.of(optionalInt.getAsInt()) : Optional.empty();
    }
}
