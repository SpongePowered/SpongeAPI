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
package org.spongepowered.api.world.volume.worker;

import org.spongepowered.api.world.BlockChangeFlags;
import org.spongepowered.api.world.volume.MutableVolume;
import org.spongepowered.api.world.volume.UnmodifiableVolume;
import org.spongepowered.api.world.volume.worker.function.VolumeFiller;
import org.spongepowered.api.world.volume.worker.function.VolumeMapper;
import org.spongepowered.api.world.volume.worker.function.VolumeMerger;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Similar to {@link VolumeStream} but allows altering the underlying
 * {@link MutableVolume}.
 *
 * @param <V> The type of mutable volume
 * @param <U> The unmodifiable volume type, for viewing
 * @param <I> The type of object being iterated over
 */
public interface MutableVolumeStream<V extends MutableVolume, U extends UnmodifiableVolume, I> extends VolumeStream<V, U, I, V> {

    @Override
    MutableVolumeStream<V, U, I> filter(Predicate<VolumeResult<V, ? super I>> predicate);

    @Override
    <T> MutableVolumeStream<V, U, T> map(VolumeMapper<I, U, T> mapper);

    @Override
    <T> MutableVolumeStream<V, U, T> map(Function<VolumeResult<U, I>, T> mapper);

    void apply(VolumeMapper<I, U, V> mapper);

    void apply(Function<VolumeResult<V, I>, V> function);

    default void merge(V second, VolumeMerger<I, U> merger) {
        merge(second, merger, getVolume());
    }

    <T> void fill(Function<VolumeResult<V, I>, T> function);

    void fill(VolumeFiller<I> filler);
}
