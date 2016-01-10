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

import org.spongepowered.api.world.extent.BiomeArea;
import org.spongepowered.api.world.extent.MutableBiomeArea;
import org.spongepowered.api.world.extent.worker.procedure.BiomeAreaFiller;
import org.spongepowered.api.world.extent.worker.procedure.BiomeAreaMapper;
import org.spongepowered.api.world.extent.worker.procedure.BiomeAreaMerger;

/**
 * Similar to {@link BiomeAreaWorker} but adds support for mutating the backing
 * area.
 *
 * @param <A> The type of area being worked on
 */
public interface MutableBiomeAreaWorker<A extends MutableBiomeArea> extends BiomeAreaWorker<A> {

    /**
     * Similar to {@link BiomeAreaWorker#map(BiomeAreaMapper,
     * MutableBiomeArea)} but uses the operating area as the destination.
     * Precautions must be taken as the area is modified while the operation is
     * being performed, and so the surrounding blocks might not be the original
     * ones.
     *
     * @param mapper The mapping operation
     */
    default void map(BiomeAreaMapper mapper) {
        map(mapper, getArea());
    }

    /**
     * Similar to {@link BiomeAreaWorker#merge(BiomeArea, BiomeAreaMerger,
     * MutableBiomeArea)} but uses the operating area as the destination.
     * Precautions must be taken as the area is modified while the operation is
     * being performed, and so the surrounding blocks might not be the original
     * ones.
     *
     * @param merger The merging operation
     */
    default void merge(BiomeArea right, BiomeAreaMerger merger) {
        merge(right, merger, getArea());
    }

    /**
     * Applies a filler operation to the area.
     *
     * @param filler The filler operation
     */
    void fill(BiomeAreaFiller filler);

}
