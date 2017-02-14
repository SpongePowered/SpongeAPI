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
package org.spongepowered.api.world.extent.worker;

import org.spongepowered.api.world.extent.BiomeVolume;
import org.spongepowered.api.world.extent.MutableBiomeVolume;
import org.spongepowered.api.world.extent.worker.procedure.BiomeVolumeFiller;
import org.spongepowered.api.world.extent.worker.procedure.BiomeVolumeMapper;
import org.spongepowered.api.world.extent.worker.procedure.BiomeVolumeMerger;

/**
 * Similar to {@link BiomeVolumeWorker} but adds support for mutating the backing
 * volume.
 *
 * @param <A> The type of volume being worked on
 */
public interface MutableBiomeVolumeWorker<A extends MutableBiomeVolume> extends BiomeVolumeWorker<A> {

    /**
     * Similar to {@link BiomeVolumeWorker#map(BiomeVolumeMapper,
     * MutableBiomeVolume)} but uses the operating volume as the destination.
     * Precautions must be taken as the volume is modified while the operation
     * is being performed, and so the surrounding blocks might not be the
     * original ones.
     *
     * @param mapper The mapping operation
     */
    default void map(BiomeVolumeMapper mapper) {
        map(mapper, getVolume());
    }

    /**
     * Similar to {@link BiomeVolumeWorker#merge(BiomeVolume, BiomeVolumeMerger,
     * MutableBiomeVolume)} but uses the operating volume as the destination.
     * Precautions must be taken as the volume is modified while the operation
     * is being performed, and so the surrounding blocks might not be the
     * original ones.
     *
     * @param right the right-hand operand for the merge operation
     * @param merger The merging operation
     */
    default void merge(BiomeVolume right, BiomeVolumeMerger merger) {
        merge(right, merger, getVolume());
    }

    /**
     * Applies a filler operation to the volume.
     *
     * @param filler The filler operation
     */
    void fill(BiomeVolumeFiller filler);

}
