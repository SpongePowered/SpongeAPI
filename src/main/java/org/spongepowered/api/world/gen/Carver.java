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

import com.flowpowered.math.vector.Vector2i;
import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.world.volume.composite.ReadableCompositeVolume;

import java.util.Random;

/**
 * To represent IWorldCarver
 * @param <C>
 */
public interface Carver<C extends FeatureConfig> {

    C getConfig();

    /**
     * Gets whether this carver will carve at the targeted chunk position.
     *
     *    boolean func_212246_a(IBlockReader p_212246_1_, Random p_212246_2_, int p_212246_3_, int p_212246_4_, C p_212246_5_);
     *
     * Examples:
     * CaveCarver will check if the random's next float will beat the probability of the Carving config object.
     *
     * Equivalent to
     * @param volume The volume (equivalent to IBlockReader)
     * @param random The random
     * @param chunkPosition The chunk's position
     * @param config The config object
     * @return True if {@link #carve(GenerationRegion, Random, Vector2i, Vector3i, FeatureConfig)} will be called
     */
    boolean canCarve(ReadableCompositeVolume volume, Random random, Vector2i chunkPosition, C config);

    /**
     * Functional equivalent to #carve(IWorld region, Random random, int chunkx, int chunkz, int originalX, int originalZ, BitSet mask, C config);
     * Some notes about some carvers: Some carvers will limit attempts
     * by reducing randoms by chaining multiple calls to {@link Random#nextInt()}.
     *
     * The rand
     * @param worldGenRegion Since we don't need to worry about providing IWorld as a live World, we can get
     *      away with providing a {@link GenerationRegion} as the world provider, since it
     *      will actively limit which chunks can be accessed, it also serves as the container for
     *      the mutable block area that the carver will likely need to both access for nearby
     *      blocks (checking for fluids mostly), and actual air block placement. It must be understood
     *      that the region could possibly not be a valid world, or it could be pointing to
     *      a world that has chunks being regenerated, so TileEntities and Entities are not
     *      to be worked with at this time of generation.
     * @param random The random instance bieng used for generation
     * @param chunkPosition The chunk, that is being generated, position in relation to the
     *      chunk format (multiply by 16 to get to block psotion)
     * @param center The center of the chunk, equivalent to chunkX and chunkZ
     * @param config
     */
    void carve(GenerationRegion worldGenRegion, Random random, Vector2i chunkPosition, Vector3i center, C config);

}
