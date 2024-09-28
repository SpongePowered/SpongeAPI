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
package org.spongepowered.api.data;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.data.value.Value;

public interface DataPerspectiveResolver<V extends Value<E>, E> {

    /**
     * Gets the {@link Key} this resolver supports.
     *
     * @return The key
     */
    Key<V> key();

    /**
     * When multiple plugins provide the same key this is used to
     * merge and pick the best.
     *
     * @return The merged value
     */
    E merge(Iterable<E> values);

    /**
     * When data holders value changes when looking at perspective of.
     *
     * @param dataHolder The data holder which value was overridden.
     * @param perspective The perspective it is perceived from.
     * @param value The value.
     */
    void apply(DataHolder dataHolder, DataPerspective perspective, @Nullable E value);
}
