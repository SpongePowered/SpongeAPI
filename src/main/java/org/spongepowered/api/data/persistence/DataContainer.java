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
package org.spongepowered.api.data.persistence;

import org.spongepowered.api.Sponge;

/**
 * Represents a data structure that contains data. A DataContainer is
 * an object that can be considered a root {@link DataView}.
 */
@SuppressWarnings("deprecation")
public interface DataContainer extends DataView {

    /**
     * Creates a new {@link DataContainer} with a default
     * {@link DataView.SafetyMode} of
     * {@link DataView.SafetyMode#ALL_DATA_CLONED}.
     *
     * @return A new data container
     */
    static DataContainer createNew() {
        return Sponge.getDataManager().createContainer();
    }

    /**
     * Creates a new {@link DataContainer} with the provided
     * {@link DataView.SafetyMode}.
     *
     * @param safety The safety mode to use
     * @see DataView.SafetyMode
     * @return A new data container with the provided safety mode
     */
    static DataContainer createNew(SafetyMode safety) {
        return Sponge.getDataManager().createContainer(safety);
    }

    @Override
    DataContainer set(DataQuery path, Object value);

    @Override
    DataContainer remove(DataQuery path);
}
