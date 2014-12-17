/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.world.chunk;

import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.world.World;

import com.flowpowered.math.vector.Vector2i;

/**
 * Represents a chunk generator that is used to generate a {@link Chunk}.
 */
public interface ChunkGenerator {

    /**
     * Generates the blocks for the chunk for the given world at the given
     * position. Generates an array of arrays containing 16*16*16 = 4096 blocks.
     * Any null in this array inner array will be replaced by the worlds default
     * block type usually air. Any null in the outer array can be used to
     * decrease generation overhead and reduce the worlds save size.
     *
     * @param world The world the chunk will be generated in
     * @param position The position of the new chunk
     * @return The blocks contained in the chunk
     * @see ChunkGeneratorUtil#getBlockLocation(int, int, int)
     */
    BlockType[][] generate(World world, Vector2i position);

}
