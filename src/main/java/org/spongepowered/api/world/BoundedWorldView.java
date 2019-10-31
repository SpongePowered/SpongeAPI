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
package org.spongepowered.api.world;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.util.RandomProvider;
import org.spongepowered.api.world.volume.biome.MutableBiomeVolume;
import org.spongepowered.api.world.volume.block.MutableBlockVolume;
import org.spongepowered.api.world.volume.block.PhysicsAwareMutableBlockVolume;
import org.spongepowered.api.world.volume.block.entity.StreamableBlockEntityVolume;
import org.spongepowered.api.world.volume.entity.MutableEntityVolume;
import org.spongepowered.api.world.volume.game.GenerationVolume;
import org.spongepowered.api.world.volume.game.LocationBaseDataHolder;
import org.spongepowered.api.world.volume.game.MutableGameVolume;
import org.spongepowered.api.world.volume.game.ReadableRegion;
import org.spongepowered.math.vector.Vector3i;

/**
 * A "downsized" or "bounded" view on a {@link ProtoWorld world} that has
 * a custom set bound of what it has access to, specifically the area
 * contained within {@link #getBlockMin()} and {@link #getBlockMax()} will
 * be restricted based on the view defined by
 * {@link ProtoWorld#getView(Vector3i, Vector3i)} such that access to coordinates
 * outside the bounds will result in a
 * {@link org.spongepowered.api.util.PositionOutOfBoundsException}. It is
 * still considered unsafe to perform operations on this view outside the
 * control of the parented {@link ProtoWorld world's} context, or otherwise
 * the world's thread context.
 *
 * @param <P> The type of world to reflect back on
 */
public interface BoundedWorldView<P extends ProtoWorld<P>> extends
        ReadableRegion<BoundedWorldView<P>>,
        MutableBiomeVolume<BoundedWorldView<P>>, // Because this is mutable
        MutableBlockVolume<BoundedWorldView<P>>, // Because this is mutable
        MutableEntityVolume<BoundedWorldView<P>>, // Because this is mutable
        StreamableBlockEntityVolume<BoundedWorldView<P>>, // Because this is mutable
        GenerationVolume,
        LocationBaseDataHolder.Mutable,
        RandomProvider,
        PhysicsAwareMutableBlockVolume<BoundedWorldView<P>>,
        MutableGameVolume {

    @Override
    default boolean setBlock(Vector3i position, BlockState state, BlockChangeFlag flag) {
        return setBlock(position.getX(), position.getY(), position.getZ(), state, flag);
    }

    @Override
    default boolean removeBlock(Vector3i position) {
        return false;
    }

    @Override
    boolean removeBlock(int x, int y, int z);

    P getWorld();

}
