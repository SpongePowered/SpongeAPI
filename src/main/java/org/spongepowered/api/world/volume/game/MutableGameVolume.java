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
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.world.BlockChangeFlag;
import org.spongepowered.api.world.LightType;
import org.spongepowered.math.vector.Vector3i;

public interface MutableGameVolume {

    default boolean setBlock(Vector3i position, BlockState state, BlockChangeFlag flag) {
        return this.setBlock(position.getX(), position.getY(), position.getZ(), state, flag);
    }

    boolean setBlock(int x, int y, int z, BlockState state, BlockChangeFlag flag);

    boolean spawnEntity(Entity entity);

    default boolean removeBlock(Vector3i pos) {
        return this.removeBlock(pos.getX(), pos.getY(), pos.getZ());
    }

    boolean removeBlock(int x, int y, int z);

    boolean destroyBlock(Vector3i pos, boolean performDrops);
}
