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

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.volume.MutableVolume;
import org.spongepowered.api.world.volume.UnmodifiableVolume;
import org.spongepowered.api.world.volume.Volume;
import org.spongepowered.api.world.volume.entity.StreamableEntityVolume;
import org.spongepowered.api.world.volume.worker.function.VolumeConsumer;
import org.spongepowered.api.world.volume.worker.function.VolumeMapper;
import org.spongepowered.api.world.volume.worker.function.VolumeMerger;
import org.spongepowered.api.world.volume.worker.function.VolumePredicate;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Equivalent to a {@link Stream} of {@link VolumeResult}s, with the added
 * benefit of being intrinsic to a specific type of {@link Volume} and {@code I}
 * element type per position. While it is recommended to verify the {@link Volume}
 * is equivalent to a live {@link World} instance, some volumes may be mutable, or
 * {@link UnmodifiableVolume} such that asynchronous access may be allowed. The
 * cases where a {@link Volume} may be available for streaming is dependent on
 * the type of volume, such as {@link StreamableEntityVolume}, {@link }
 * @param <V>
 * @param <U>
 * @param <I>
 * @param <M>
 */
public interface VolumeStream<V extends Volume, U extends UnmodifiableVolume, I, M extends MutableVolume> {

    V getVolume();

    VolumeStream<V, U, I, M> filter(VolumePredicate<V, U, I, M> predicate);

    default VolumeStream<V, U, I, M> filter(Predicate<VolumeResult<V, ? super I>> predicate) {
        return filter((volume, element, x, y, z) -> predicate.test(VolumeResult.of(volume, element, new Vector3i(x, y, z))));
    }

    <T> VolumeStream<V, U, T, M> map(VolumeMapper<I, U, T> mapper);

    default <T> VolumeStream<V, U, T, M> map(Function<VolumeResult<U, I>, T> mapper) {
        return map(((volume, value, x, y, z) -> mapper.apply(VolumeResult.of(volume, value, new Vector3i(x, y, z)))));
    }

    long count();

    boolean allMatch(VolumePredicate<? super V, ? super U, ? super I, ? super M> predicate);

    boolean allMatch(Predicate<VolumeResult<? super V, ? super I>> predicate);

    boolean noneMatch(VolumePredicate<? super V, ? super U, ? super I, ? super M> predicate);

    boolean noneMatch(Predicate<VolumeResult<? super V, ? super I>> predicate);

    boolean anyMatch(VolumePredicate<? super V, ? super U, ? super I, ? super M> predicate);

    boolean anyMatch(Predicate<VolumeResult<? super V, ? super I>> predicate);

    Optional<VolumeResult<V, I>> findFirst();

    Optional<VolumeResult<V, I>> findAny();

    Stream<VolumeResult<V, I>> toStream();

    void merge(V second, VolumeMerger<I, U> merger, M destination);

    void forEach(VolumeConsumer<V, I> visitor);

    void forEach(Consumer<VolumeResult<V, I>> consumer);



}
