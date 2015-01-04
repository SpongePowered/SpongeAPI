/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.service.persistence.data;

import com.google.common.base.Optional;

/**
 * A data holder object allows the access of additional data on the object
 * that is not simply expressed by its basic type.
 *
 * <p>For example, a chest block, which is of the chest type, also has
 * inventory. This inventory is considered extra data, which can
 * be accessed via {@link #getData(Class)}, provided that an implementation
 * exposes that extra data.</p>
 */
public interface DataHolder {

    /**
     * Get an instance of the given data class for this block.
     *
     * <p>For example, if this block represents a sign,
     * {@code getData(Sign.class)} would yield an instance of
     * {@code Sign} to change the contents of the sign. However, if
     * this block does not represent a sign, then an instance will not
     * be returned.</p>
     *
     * @param dataClass The data class
     * @param <T> The type of data
     * @return An instance of the class
     */
    <T> Optional<T> getData(Class<T> dataClass);

}
