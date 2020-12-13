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

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.world.volume.Volume;
import org.spongepowered.math.vector.Vector3i;

import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Supplier;

public interface VolumeElement<V extends Volume, T> {

    static <W extends Volume, T> VolumeElement<W, T> of(final Supplier<W> volume, final Supplier<? extends T> type, final Vector3i position) {
        return new VolumeElement<W, T>() {
            public W getVolume() {
                return volume.get();
            }

            public Vector3i getPosition() {
                return position;
            }

            public T getType() {
                return type.get();
            }

            @Override
            public String toString() {
                return new StringJoiner(", ", VolumeElement.class.getSimpleName() + "[", "]")
                    .add("reference=" + volume.get())
                    .add("type=" + type.get())
                    .add("position=" + position)
                    .toString();
            }

            @Override
            public boolean equals(final @Nullable Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || this.getClass() != o.getClass()) {
                    return false;
                }
                final VolumeElement<@NonNull ?, ?> that = (VolumeElement<@NonNull ?, ?>) o;
                return volume.get().equals(that.getVolume()) &&
                    type.get().equals(that.getType()) &&
                    position.equals(that.getPosition());
            }

            @Override
            public int hashCode() {
                return Objects.hash(volume.get(), type.get(), position);
            }
        };
    }

    static <V extends Volume, T> VolumeElement<V, T> of(final V volume, final Supplier<? extends T> type, final Vector3i position) {
        final WeakReference<V> volumeRef = new WeakReference<>(volume);
        final Supplier<V> volumeSupplier = () -> Objects.requireNonNull(volumeRef.get(), "Volume de-referenced");
        return VolumeElement.of(volumeSupplier, type, position);
    }

    static <V extends Volume, T> VolumeElement<V, T> of(final V volume, final T type, final Vector3i position) {
        final WeakReference<V> volumeRef = new WeakReference<>(volume);
        final Supplier<V> volumeSupplier = () -> Objects.requireNonNull(volumeRef.get(), "Volume de-referenced");
        final WeakReference<T> typeRef = new WeakReference<>(type);
        final Supplier<T> typeSupplier = () -> Objects.requireNonNull(typeRef.get(), "Element instance de-referenced");
        return VolumeElement.of(volumeSupplier, typeSupplier, position);
    }

    /**
     * Gets the target volume of this element that the element belongs to.
     * Should not be leaked out of usage of a {@link VolumeStream} or any of
     * its companion functions.
     *
     * @return
     */
    V getVolume();

    Vector3i getPosition();

    T getType();

}
