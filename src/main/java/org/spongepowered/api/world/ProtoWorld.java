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
import org.spongepowered.api.world.chunk.ProtoChunk;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.api.world.gen.TerrainGenerator;
import org.spongepowered.api.world.storage.WorldProperties;
import org.spongepowered.api.world.volume.biome.MutableBiomeVolume;
import org.spongepowered.api.world.volume.block.MutableBlockVolume;
import org.spongepowered.api.world.volume.block.PhysicsAwareMutableBlockVolume;
import org.spongepowered.api.world.volume.block.entity.StreamableBlockEntityVolume;
import org.spongepowered.api.world.volume.entity.MutableEntityVolume;
import org.spongepowered.api.world.volume.game.GenerationVolume;
import org.spongepowered.api.world.volume.game.LocationBaseDataHolder;
import org.spongepowered.api.world.volume.game.MutableGameVolume;
import org.spongepowered.api.world.volume.game.ReadableRegion;
import org.spongepowered.api.world.volume.game.UpdatableVolume;
import org.spongepowered.math.vector.Vector3i;

public interface ProtoWorld<P extends ProtoWorld<P>> extends
        ReadableRegion<BoundedWorldView<P>>,
        MutableBiomeVolume<BoundedWorldView<P>>, // Because this is mutable
        MutableBlockVolume<BoundedWorldView<P>>, // Because this is mutable
        MutableEntityVolume<BoundedWorldView<P>>, // Because this is mutable
        StreamableBlockEntityVolume<BoundedWorldView<P>>, // Because this is mutable
        GenerationVolume,
        LocationBaseDataHolder.Mutable,
        UpdatableVolume,
        RandomProvider,
        PhysicsAwareMutableBlockVolume<BoundedWorldView<P>>,
        MutableGameVolume
{

    ProtoChunk<?> getChunk(int cx, int cy, int cz);

    @Override
    BoundedWorldView<P> getView(Vector3i newMin, Vector3i newMax);


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

    /**
     * Gets the current {@link Difficulty}.
     *
     * @see WorldProperties#getDifficulty()
     * @return The difficulty for this world
     */
    default Difficulty getDifficulty() {
        return getProperties().getDifficulty();
    }

    @Override
    default boolean setBlock(Vector3i position, BlockState state, BlockChangeFlag flag) {
        return setBlock(position.getX(), position.getY(), position.getZ(), state, flag);
    }

    @Override
    boolean setBlock(int x, int y, int z, BlockState state, BlockChangeFlag flag);

    @Override
    default boolean removeBlock(Vector3i position) {
        return removeBlock(position.getX(), position.getY(), position.getZ());
    }

    @Override
    boolean removeBlock(int x, int y, int z);

}
