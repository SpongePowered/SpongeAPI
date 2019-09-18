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
package org.spongepowered.api.world.volume.game;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.world.World;
import org.spongepowered.math.vector.Vector3i;

import java.util.function.Predicate;

public interface ReadableGenerationVolume extends HeightAwareVolume {

    default boolean hasBlockState(Vector3i pos) {
        return hasBlockState(pos.getX(), pos.getY(), pos.getZ(), block -> true);
    }

    default boolean hasBlockState(Vector3i pos, Predicate<? super BlockState> predicate) {
        return hasBlockState(pos.getX(), pos.getY(), pos.getZ(), predicate);
    }

    boolean hasBlockState(int x, int y, int z, Predicate<? super BlockState> predicate);

    default int getMaximumHeight() {
        return this instanceof World ? ((World) this).getBlockMax().getY() : 256;
    }

}
