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

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.world.volume.Volume;
import org.spongepowered.math.vector.Vector3i;

import java.lang.ref.WeakReference;

public final class VolumeResult<V extends Volume, T> {

    public  static <V extends Volume, T> VolumeResult<V, T> of(V volume, T type, Vector3i position)  {
        return new VolumeResult<>(checkNotNull(volume, "volume"), checkNotNull(type, "type"), checkNotNull(position, "position"));
    }

    private final WeakReference<V> reference;
    private final WeakReference<T> type;
    private final Vector3i position;

    private VolumeResult(V volume, T type, Vector3i position) {
        this.reference = new WeakReference<>(volume);
        this.type = new WeakReference<>(type);
        this.position = position;
    }

    public V getVolume() {
        return this.reference.get();
    }

    public Vector3i getPosition() {
        return this.position;
    }

    public T getType() {
        return this.type.get();
    }

}
