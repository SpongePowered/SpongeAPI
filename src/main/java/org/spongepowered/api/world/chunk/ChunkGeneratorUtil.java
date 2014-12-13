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

import com.google.common.base.Optional;

/**
 *
 */
public final class ChunkGeneratorUtil {

    private ChunkGeneratorUtil() {
    }

    public static int[] getBlockLocation(final int x, final int y, final int z) {
        return new int[] { y >> 4, (y & 0xF) << 8 | z << 4 | x };
    }

    public static void setBlockType(final BlockType[][] result, final int x, final int y, final int z, final BlockType type) {
        if (result[y >> 4] == null) {
            result[y >> 4] = new BlockType[4096];
        }
        result[y >> 4][(y & 0xF) << 8 | z << 4 | x] = type;
    }

    public static Optional<BlockType> getBlock(final BlockType[][] result, final int x, final int y, final int z) {
        if (result[y >> 4] == null) {
            return Optional.absent();
        }
        return Optional.fromNullable(result[y >> 4][(y & 0xF) << 8 | z << 4 | x]);
    }
}
