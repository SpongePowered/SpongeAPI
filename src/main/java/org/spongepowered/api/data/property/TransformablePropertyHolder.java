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
import org.spongepowered.api.data.property.item.CookedProperty;
import org.spongepowered.api.item.ItemTypes;

import java.util.Optional;

/**
 * Represents a {@link PropertyHolder} that can be transformed into another
 * {@link PropertyHolder} by modifying supported {@link Property}s.
 *
 * @param <T> The property holder type
 */
public interface TransformablePropertyHolder<T extends TransformablePropertyHolder<T>> extends PropertyHolder {

    /**
     * Transforms this property holder with the given {@link Property}. The
     * transformed property holder will be returned if the {@link Property}
     * and property value are supported.
     * <p>For example, this can be used to transform a {@link ItemTypes#BEEF}
     * into a {@link ItemTypes#COOKED_BEEF} when applying the
     * {@link CookedProperty} with a {@code true} value.
     *
     * @param property The property
     * @return The transformed property holder, if successful
     */
    Optional<T> transformWith(Property<?, ?> property);
}
