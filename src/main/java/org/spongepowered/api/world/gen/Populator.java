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
package org.spongepowered.api.world.gen;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.world.Chunk;
import org.spongepowered.api.world.gen.populator.RandomObject;

import java.util.Random;

/**
 * After the initial terrain has been generated, the populators step in to add
 * trees, grass, flowers, ores, etc.
 *
 * <p>A populator has access to some nearby chunks, so it can more easily place
 * objects that cross chunk boundaries.</p>
 *
 * <p>Instead of directly implementing this interface, it may be easier to
 * implement {@link PopulatorObject} instead, and use the {@link RandomObject}
 * populator to get a populator that spawns that object.</p>
 *
 * @see PopulatorObject
 */
public interface Populator {

    /**
     * Applies the populator to the given chunk. The chunks at
     * {@code (chunkX + 1, chunkZ)}, {@code (chunkX, chunkZ + 1)} and
     * {@code (chunkX + 1, chunkZ + 1)} will at least have been generated
     * (although they do not have to be populated) to allow
     * {@link PopulatorObject}s to overlap across chunk boundaries.
     *
     * <p>This means that there are only four chunks guaranteed to be loaded.
     * Other chunks in the world may or may not be loaded. Avoid touching those
     * chunks, trying to get/set a block there may cause the chunk to be loaded,
     * which is a bad thing during terrain population.</p>
     *
     * <p>Those four chunks form an area of 32x32 columns that you can populate,
     * from {@code (block x, block z) (chunkX * 16, chunkZ * 16)} to
     * {@code (chunkX * 16 + 31, chunkZ * 16 + 31)}. See <b>Figure 1</b>. To
     * effectively use this area, it is recommend to make sure the centers of
     * all objects are placed from
     * {@code (block x, block z) (chunkX * 16 + 8, chunkZ * 16 + 8)} to
     * {@code (chunkX * 16 + 23, chunkZ * 16 + 23)}. This ensures both that each
     * object can extend 8 blocks on the x and z axis from its center and that
     * every area in the world is populated exactly once.</p>
     *
     * <pre>
     *       +----------+----------+ . . The chunk provided as a parameter
     *       |          |          | . . to this method.
     *       |          |          |
     *       |     #####|#####     | ### The area you should populate.
     *       |     #####|#####     | ###
     *       +----------+----------+
     *       | . . #####|#####     |
     *       | . . #####|#####     |
     *       | . . . . .|          |
     *       | . . . . .|          |
     *       +----------+----------+
     * </pre>
     * 
     * <p><b>Figure 1</b> <i>The four chunks guanteed to be loaded, along with
     * the area you are allowed to populate.</i></p>
     *
     * <p>The following code guantantees that the center of your object is
     * placed with its center in the recommend area:
     * 
     * <pre>
     *  {@link Vector3i} chunkStartBlockPos = chunk.getPosition().mul(16);
     *  Vector3i populationAreaStartBlockPos = chunkStartBlockPos.add(8, 0, 8);
     *  Vector3i objectCenterBlockPos = populationAreaStart.add( random.nextInt(16), justSomeValueForY, random.nextInt(16));
     * </pre>
     *
     * @param chunk The provided chunk.
     * @param random A random number generator. This random number generator is
     *        based on the world seed and the chunk position. It is shared with
     *        with other populators.
     */
    void populate(Chunk chunk, Random random);

}
