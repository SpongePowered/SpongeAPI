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
package org.spongepowered.api.data.value;

import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Living;

import java.util.Optional;

/**
 * The abstract base interface for all of the "Value API". In short, a
 * {@link BaseValue} is a "wrapper" around an actual value from a
 * {@link ValueContainer}. The actual value may come from various sources of
 * the {@link ValueContainer}, but usually it's a generic dynamic system for
 * being able to fetch values from object fields without having to know the
 * type of {@link Class} of the {@link ValueContainer}, the getters and
 * setters for that particular value. The driving force behind this is that
 * instead of having a traditional hierarchical structure of data that is
 * possible to be retrieved from an {@link Entity}, {@link Living}, etc.,
 * all that is required is <pre>{@code container.supports(Keys.HEALTH) ?
 * container.get(Keys.HEALTH).get() : 0 }</pre> where the container is simply
 * a {@link ValueContainer}, nothing more, nothing less.
 *
 * <p>The advantage of this is that now, these various known and unknown
 * {@link Value}s can be retrieved by simple java generics:
 * {@link ValueContainer#getValue(Key)}. While having a {@link Value} for
 * something so primitive as the current health of a {@link Living} entity,
 * the power is wielded when a {@link Value} can be offered up to multiple
 * {@link ValueContainer}s without worrying about whether it's supported or not,
 * or getting the right cast information.</p>
 *
 * @param <E> The type of element wrapped by this value
 */
public interface BaseValue<E> {

    /**
     * Gets the held value. Usually all held values are "filled" and not
     * "defaulted"; however, in the case that the actual value is not set or
     * {@link #exists()} returns false, the {@link #getDefault()} value is
     * returned.
     *
     * @return The held value
     */
    E get();

    /**
     * Checks that the underlying value exists (or "set").
     *
     * @return True if the value exists or was set
     */
    boolean exists();

    /**
     * Gets the default value. There is always a default value, however,
     * usability of the default value may be questionable in certain
     * circumstances.
     *
     * @return The default value
     */
    E getDefault();

    /**
     * Gets the direct value. Since some values may be absent for various
     * reasons, the {@link #get()} would return the {@link #getDefault()} when
     * necessary.
     *
     * @return The direct value, if available
     */
    Optional<E> getDirect();

    /**
     * Gets the key for this {@link BaseValue}.
     *
     * @return The key for this value
     */
    Key<? extends BaseValue<E>> getKey();

}
