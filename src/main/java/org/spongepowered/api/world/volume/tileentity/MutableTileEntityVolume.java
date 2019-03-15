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
package org.spongepowered.api.world.volume.tileentity;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.block.tileentity.TileEntity;
import org.spongepowered.api.world.volume.MutableVolume;
import org.spongepowered.api.world.volume.block.MutableBlockVolume;
import org.spongepowered.api.world.volume.block.worker.MutableBlockVolumeStream;
import org.spongepowered.api.world.volume.tileentity.worker.MutableTileEntityStream;

public interface MutableTileEntityVolume<M extends MutableTileEntityVolume<M>> extends StreamableTileEntityVolume<M>, MutableBlockVolume<M>, MutableVolume {

    default void addTileEntity(Vector3i pos, TileEntity tileEntity) {
        addTileEntity(pos.getX(), pos.getY(), pos.getZ(), tileEntity);
    }

    void addTileEntity(int x, int y, int z, TileEntity tileEntity);

    default void removeTileEntity(Vector3i pos) {
        removeTileEntity(pos.getX(), pos.getY(), pos.getZ());
    }

    void removeTileEntity(int x, int y, int z);

    @Override
    M getView(Vector3i newMin, Vector3i newMax);

    @Override
    MutableTileEntityStream<M> toTileEntityStream();

    @Override
    MutableBlockVolumeStream<M> toBlockStream();
}
