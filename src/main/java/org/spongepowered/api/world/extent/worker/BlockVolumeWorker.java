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

import org.spongepowered.api.world.extent.BlockVolume;
import org.spongepowered.api.world.extent.MutableBlockVolume;
import org.spongepowered.api.world.extent.worker.procedure.BlockVolumeMapper;
import org.spongepowered.api.world.extent.worker.procedure.BlockVolumeMerger;
import org.spongepowered.api.world.extent.worker.procedure.BlockVolumeReducer;
import org.spongepowered.api.world.extent.worker.procedure.BlockVolumeVisitor;

import java.util.function.BiFunction;

/**
 * A worker for a block volume. Used to perform operations on all the blocks it
 * contains. When operations are done on multiple volumes, they are aligned on
 * their minimum coordinates. The other volumes must be at least as big as the
 * backing one.
 *
 * @param <V> The type of volume being worked on
 */
public interface BlockVolumeWorker<V extends BlockVolume> {

    /**
     * Returns the volume this worker operates on.
     *
     * @return The backing volume
     */
    V getVolume();

    /**
     * Applies a mapping operation to all the blocks in the volume and saves the
     * results to the destination volume.
     * @param mapper The mapping operation
     * @param destination The destination volume
     */
    void map(BlockVolumeMapper mapper, MutableBlockVolume destination);

    /**
     * Applies a merging operation to the blocks of the operating volume and an
     * external one. Saves the results to the destination volume.
     *
     * @param second The volume to merge with
     * @param merger The merging operation
     * @param destination The destination volume
     */
    void merge(BlockVolume second, BlockVolumeMerger merger, MutableBlockVolume destination);

    /**
     * Iterates this block volume, calling the visitor on each coordinate
     * triplet.
     *
     * @param visitor The visitor
     */
    void iterate(BlockVolumeVisitor<V> visitor);

    /**
     * Applies a reduction operation to the volume. The identity should be the
     * result of no reduction being applied. For example, the additive identity
     * is 0, the multiplicative one is 1 and the set union one is the empty
     * set.
     *
     * @param reducer The reducing operation
     * @param merge Merges two reductions into one
     * @param identity The identity of the operation
     * @param <T> The type of the reduction
     * @return The reduction
     */
    <T> T reduce(BlockVolumeReducer<T> reducer, BiFunction<T, T, T> merge, T identity);

}
