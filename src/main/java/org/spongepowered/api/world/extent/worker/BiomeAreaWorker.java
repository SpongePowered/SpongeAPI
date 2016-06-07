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
import org.spongepowered.api.world.extent.worker.procedure.BiomeAreaVisitor;
import org.spongepowered.api.world.extent.worker.procedure.BiomeAreaMapper;
import org.spongepowered.api.world.extent.worker.procedure.BiomeAreaMerger;
import org.spongepowered.api.world.extent.worker.procedure.BiomeAreaReducer;

import java.util.function.BiFunction;

/**
 * A worker for a biome area. Used to perform operations on all the biomes it
 * contains. When operations are done on multiple areas, they are aligned on
 * their minimum coordinates. The other areas must be at least as big as the
 * backing one.
 *
 * @param <A> The type of area being worked on
 */
public interface BiomeAreaWorker<A extends BiomeArea> {

    /**
     * Returns the area this worker operates on.
     *
     * @return The backing area
     */
    A getArea();

    /**
     * Applies a mapping operation to all the biomes in the area and saves the
     * results to the destination area.
     *
     * @param mapper The mapping operation
     * @param destination The destination area
     */
    void map(BiomeAreaMapper mapper, MutableBiomeArea destination);

    /**
     * Applies a merging operation to the biomes of the operating area and an
     * external one. Saves the results to the destination area.
     *
     * @param second The area to merge with
     * @param merger The merging operation
     * @param destination The destination area
     */
    void merge(BiomeArea second, BiomeAreaMerger merger, MutableBiomeArea destination);

    /**
     * Iterates this biome area, calling the visitor on each coordinate pair.
     *
     * @param visitor The visitor
     */
    void iterate(BiomeAreaVisitor<A> visitor);

    /**
     * Applies a reduction operation to the area. The identity should be the
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
    <T> T reduce(BiomeAreaReducer<T> reducer, BiFunction<T, T, T> merge, T identity);

}
