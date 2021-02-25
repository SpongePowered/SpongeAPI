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

import org.spongepowered.api.Engine;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.util.RandomProvider;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.api.world.volume.biome.BiomeVolume;
import org.spongepowered.api.world.volume.block.BlockVolume;
import org.spongepowered.api.world.volume.block.PhysicsAwareMutableBlockVolume;
import org.spongepowered.api.world.volume.block.entity.BlockEntityVolume;
import org.spongepowered.api.world.volume.entity.EntityVolume;
import org.spongepowered.api.world.volume.game.GenerationVolume;
import org.spongepowered.api.world.volume.game.LocationBaseDataHolder;
import org.spongepowered.api.world.volume.game.MutableGameVolume;
import org.spongepowered.api.world.volume.game.Region;
import org.spongepowered.api.world.volume.game.UpdatableVolume;
import org.spongepowered.math.vector.Vector3i;

import java.util.Objects;

public interface ProtoWorld<P extends ProtoWorld<P>> extends
    Region<P>,
    BiomeVolume.Mutable<P>, // Because this is mutable
    BlockVolume.Mutable<P>, // Because this is mutable
    EntityVolume.Mutable<P>, // Because this is mutable
    BlockEntityVolume.Mutable<P>, // Because this is mutable
    GenerationVolume.Mutable,
    LocationBaseDataHolder.Mutable,
    UpdatableVolume,
    RandomProvider,
    PhysicsAwareMutableBlockVolume<P>,
    MutableGameVolume
{

    /**
     * Gets the {@link Engine} that simulates this world.
     *
     * @return The engine
     */
    Engine getEngine();

    /**
     * Gets the seed of this world.
     *
     * @return The seed
     */
    long getSeed();

    /**
     * Gets the current {@link Difficulty}.
     *
     * @return The difficulty for this world
     */
    Difficulty getDifficulty();

    @Override
    default boolean setBlock(final Vector3i position, final BlockState state, final BlockChangeFlag flag) {
        Objects.requireNonNull(position, "position");

        return this.setBlock(position.getX(), position.getY(), position.getZ(), Objects.requireNonNull(state, "state"), Objects.requireNonNull(flag, "flag"));
    }

    @Override
    boolean setBlock(int x, int y, int z, BlockState state, BlockChangeFlag flag);

    @Override
    default boolean removeBlock(final Vector3i position) {
        Objects.requireNonNull(position, "position");

        return this.removeBlock(position.getX(), position.getY(), position.getZ());
    }

    @Override
    boolean removeBlock(int x, int y, int z);
}
