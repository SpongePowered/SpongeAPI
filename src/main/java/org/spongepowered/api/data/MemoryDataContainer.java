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

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;

import java.util.Optional;

/**
 * The default implementation of {@link DataContainer} that can be instantiated
 * for any use. This is the primary implementation of any {@link DataView} that
 * is used throughout both SpongeAPI and Sponge implementation.
 *
 * @deprecated To be removed in future releases to avoid implementation bugs
 *     being part of the API.
 */
@Deprecated
public class MemoryDataContainer extends MemoryDataView implements DataContainer {

    /**
     * Creates a new {@link MemoryDataContainer} with a default
     * {@link org.spongepowered.api.data.DataView.SafetyMode} of
     * {@link org.spongepowered.api.data.DataView.SafetyMode#ALL_DATA_CLONED}.
     *
     * @deprecated Use {@link DataContainer#createNew()}
     */
    @Deprecated
    public MemoryDataContainer() {
        this(DataView.SafetyMode.ALL_DATA_CLONED);
    }

    /**
     * Creates a new {@link MemoryDataContainer} with the provided
     * {@link org.spongepowered.api.data.DataView.SafetyMode}.
     *
     * @param safety The safety mode to use
     * @see org.spongepowered.api.data.DataView.SafetyMode
     *
     * @deprecated Use {@link DataContainer#createNew(org.spongepowered.api.data.DataView.SafetyMode)}
     */
    @Deprecated
    public MemoryDataContainer(DataView.SafetyMode safety) {
        super(safety);
    }

    @Override
    public Optional<DataView> getParent() {
        return Optional.empty();
    }

    @Override
    public final DataContainer getContainer() {
        return this;
    }

    @Override
    public DataContainer set(DataQuery path, Object value) {
        return (DataContainer) super.set(path, value);
    }

    @Override
    public <E> DataContainer set(Key<? extends BaseValue<E>> key, E value) {
        return set(checkNotNull(key).getQuery(), value);
    }

    @Override
    public DataContainer remove(DataQuery path) {
        return (DataContainer) super.remove(path);
    }

}
