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
package org.spongepowered.api.world.volume.composite;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.tileentity.TileEntity;
import org.spongepowered.api.fluid.FluidState;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.volume.Volume;
import org.spongepowered.api.world.volume.block.ReadableBlockVolume;
import org.spongepowered.api.world.volume.tileentity.ReadableTileEntityVolume;

import java.util.Optional;

/**
 * A special {@link Volume} that assumes no guarantees about the instances of
 * {@link BlockState}s, and {@link TileEntity TileEntities}. While this is
 * partially utilized for the sake of retrieving {@link BlockState}s,
 * {@link FluidState}s, and {@link TileEntity TileEntities}, there are chances
 * the volume itself is not associated with a {@link World} and the
 * {@link TileEntity} instances may yet to be fully loaded for usage by players.
 */
public interface ReadableCompositeVolume extends ReadableBlockVolume, ReadableTileEntityVolume, PrimitiveGameVolume {

    @Override
    default BlockState getBlock(Vector3i vector3i) {
        return this.getBlock(vector3i.getX(), vector3i.getY(), vector3i.getZ());
    }

    @Override
    default Optional<TileEntity> getTileEntity(Vector3i position) {
        return getTileEntity(position.getX(), position.getY(), position.getZ());
    }

}
