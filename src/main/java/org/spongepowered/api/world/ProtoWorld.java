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

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.data.property.LocationBasePropertyHolder;
import org.spongepowered.api.util.RandomProvider;
import org.spongepowered.api.world.chunk.ProtoChunk;
import org.spongepowered.api.world.gen.TerrainGenerator;
import org.spongepowered.api.world.storage.WorldProperties;
import org.spongepowered.api.world.volume.ChunkVolume;
import org.spongepowered.api.world.volume.InteractableVolume;
import org.spongepowered.api.world.volume.LocationCompositeValueStore;
import org.spongepowered.api.world.volume.ReadableRegion;
import org.spongepowered.api.world.volume.UpdatableVolume;
import org.spongepowered.api.world.volume.biome.MutableBiomeVolume;
import org.spongepowered.api.world.volume.block.MutableBlockVolume;
import org.spongepowered.api.world.volume.entity.MutableEntityVolume;
import org.spongepowered.api.world.volume.tileentity.MutableTileEntityVolume;

public interface ProtoWorld<P extends ProtoWorld<P>> extends
        ReadableRegion<P>,
        MutableBiomeVolume<P>, // Because this is mutable
        MutableBlockVolume<P>, // Because this is mutable
        MutableEntityVolume<P>, // Because this is mutable
        MutableTileEntityVolume<P>, // Because this is mutable
        ChunkVolume,
        InteractableVolume,
        LocationBasePropertyHolder,
        LocationCompositeValueStore,
        UpdatableVolume,
        RandomProvider
{

    ProtoChunk<?> getChunk(int cx, int cy, int cz);

    World getWorld();

    @Override
    P getView(Vector3i newMin, Vector3i newMax);


    /**
     * Gets the seed of this world.
     *
     * @return The seed
     */
    long getSeed();


    /**
     * Gets the {@link TerrainGenerator} for this world.
     *
     * <p>Any changes made to the world generator will only affect newly
     * generated chunks.</p>
     *
     * @return The world generator
     */
    TerrainGenerator<?> getTerrainGenerator();

    /**
     * Gets the properties for this world.
     *
     * @return The properties
     */
    WorldProperties getProperties();
}
