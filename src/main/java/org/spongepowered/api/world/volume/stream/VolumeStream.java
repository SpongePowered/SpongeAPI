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
package org.spongepowered.api.world.volume.stream;

import org.spongepowered.api.world.volume.MutableVolume;
import org.spongepowered.api.world.volume.Volume;
import org.spongepowered.math.vector.Vector3i;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * A specialized {@link Stream}&lt;{@link VolumeElement}&lt;{@link Volume}, {@code T}&gt;&gt;
 * that is lazily evaluated and backed/populated by the particular {@link Volume}. Much like
 * {@link Stream}, there are intermediary operations that can be performed on the stream,
 * and terminal operations. While a {@link Volume} has many applications, on occasion work
 * is requested to be performed in "bulk" or given a specific "work area".
 *
 * <p><strong>Intermediary Operations</strong>
 * <p>These operations are performed on each individual {@link VolumeElement}&lt;{@link Volume},
 * {@code T}&gt; such that either the element is inspected or filtering can be performed.
 * They are as follows:
 * <ul>
 *     <li>{@link #filter(VolumePredicate)}</li>
 *     <li>{@link #filter(Predicate)}</li>
 *     <li>{@link #map(VolumeMapper) map(VolumeMapper&lt;V, T&gt;)}</li>
 *     <li>{@link #map(Function) map(Function&lt;VolumeElement&lt;V, T&gt;&gt;)}</li>
 * </ul>
 * <p><strong>Terminal Operations</strong>
 * <p>These operations are consuming the entirety of the stream, after all
 * intermediary operations are performed on elements, perhaps filtering, or
 * perhaps supplying different instances as "replacements".
 * TODO flesh out the description of VolumeStream
 *
 * @param <V> The type of volume backing this Stream
 * @param <T> The type of element being iterated on
 */
public interface VolumeStream<V extends Volume, T> {

    V getVolume();

    VolumeStream<V, T> filter(VolumePredicate<V, T> predicate);

    default VolumeStream<V, T> filter(final Predicate<VolumeElement<V, ? super T>> predicate) {
        return this.filter((volume, element, x, y, z) -> predicate.test(VolumeElement.of(volume, element, new Vector3i(x, y, z))));
    }

    VolumeStream<V, T> map(VolumeMapper<V, T> mapper);

    default VolumeStream<V, T> map(final Function<VolumeElement<V, T>, ? extends T> mapper) {
        return this.map(((volume, value, x, y, z) -> mapper.apply(VolumeElement.of(volume, value, new Vector3i(x, y, z)))));
    }

    VolumeStream<V, Optional<? extends T>> flatMap(VolumeFlatMapper<V, T> mapper);

    default VolumeStream<V, Optional<? extends T>> flatMap(final Function<VolumeElement<V, T>, Optional<? extends T>> mapper) {
        return this.flatMap((volume, value, x, y, z) -> mapper.apply(VolumeElement.of(volume, value, new Vector3i(x, y,z))));
    }

    long count();

    boolean allMatch(VolumePredicate<V, ? super T> predicate);

    default boolean allMatch(final Predicate<VolumeElement<V, ? super T>> predicate) {
        return this.allMatch(((volume, element, x, y, z) -> predicate.test(VolumeElement.of(volume, element, new Vector3i(x, y, z)))));
    }

    boolean noneMatch(VolumePredicate<V, ? super T> predicate);

    default boolean noneMatch(final Predicate<VolumeElement<V, ? super T>> predicate) {
        return this.noneMatch((volume, element, x, y, z) -> predicate.test(VolumeElement.of(volume, element, new Vector3i(x, y, z))));
    }

    boolean anyMatch(VolumePredicate<V, ? super T> predicate);

    default boolean anyMatch(final Predicate<VolumeElement<V, ? super T>> predicate) {
        return this.anyMatch((volume, element, x, y, z) -> predicate.test(VolumeElement.of(volume, element, new Vector3i(x, y, z))));
    }

    Optional<VolumeElement<V, T>> findFirst();

    Optional<VolumeElement<V, T>> findAny();

    Stream<VolumeElement<V, T>> toStream();

    default <W extends MutableVolume> void apply(final VolumeCollector<W, T, ?> collector) {
        this.applyUntil(collector, (result) -> true);
    }

    <W extends MutableVolume, R> void applyUntil(VolumeCollector<W, T, R> collector, Predicate<R> predicate);

    void forEach(VolumeConsumer<V, T> visitor);

    default void forEach(final Consumer<VolumeElement<V, T>> consumer) {
        this.forEach((volume, type, x, y, z) -> consumer.accept(VolumeElement.of(volume, type, new Vector3i(x, y, z))));
    }

}
