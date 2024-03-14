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
package org.spongepowered.api.world.chunk;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.util.Ticks;
import org.spongepowered.api.util.annotation.DoNotStore;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.WorldLike;
import org.spongepowered.api.world.generation.GenerationRegion;
import org.spongepowered.api.world.volume.biome.BiomeVolume;
import org.spongepowered.api.world.volume.block.BlockVolume;
import org.spongepowered.api.world.volume.block.entity.BlockEntityVolume;
import org.spongepowered.api.world.volume.game.HeightAwareVolume;
import org.spongepowered.api.world.volume.game.LocationBaseDataHolder;
import org.spongepowered.api.world.volume.game.UpdatableVolume;
import org.spongepowered.math.vector.Vector3i;

/**
 * A chunk is a specific grid-aligned partition of a {@link WorldLike}.
 *
 * <p>Chunk is exposed as a superinterface due to the nature of needing
 * chunk like structures for various purposes, whether it's for world generation,
 * chunk loading from storage, or empty chunks on clients. Traditionally, a
 * usable "live" proto chunk instance will be a {@link WorldChunk} with a valid
 * {@link World} instance.</p>
 *
 * <p>A chunk may not be attached to a {@link World} or {@link GenerationRegion}
 * if it is in the process of being generated.</p>
 */
@DoNotStore
public interface Chunk<P extends Chunk<P>> extends
    BlockVolume.Modifiable<P>,
    BlockEntityVolume.Modifiable<P>,
    BiomeVolume.Modifiable<P>,
    UpdatableVolume,
    LocationBaseDataHolder.Mutable,
    HeightAwareVolume {

    /**
     * Adds the {@link Entity} to this {@link Chunk chunk}. It is not
     * guaranteed this will succeed in all cases, as {@link #state()}
     * does play a role in whether an entity can be directly added or not.
     *
     * <p>This method should realistically be used only during world
     * generation, and therefore will likely emit warnings if attempting to
     * add entities to live {@link WorldChunk} instances.</p>
     *
     * @param entity The entity to add
     */
    void addEntity(Entity entity);

    /**
     * Gets this {@link Chunk}'s current {@link ChunkState}.
     * The {@link ChunkState} stipulates the potential validity of various
     * operations that can be performed.
     *
     * <p>A fully generated chunk will return {@link ChunkStates#FULL} - though
     * care should be taken as the chunk may be an {@link #isEmpty() empty} one.
     * </p>
     *
     * @return This chunk's state
     */
    ChunkState state();

    /**
     * Gets whether this chunk is empty.
     *
     * @return Whether this chunk is empty
     */
    boolean isEmpty();

    /**
     * Gets the position of the chunk.
     *
     * <p>The returned position is 3-dimensional with the Y-coordinate set to be
     * the base (lowest) Y-position of the chunk. As 3-dimensional chunks do not
     * yet exist in Minecraft, the returned position will always have a
     * {@code y} set to 0.</p>
     *
     * @return The position
     */
    Vector3i chunkPosition();

    /**
     * Gets the {@link Ticks number of ticks} players have been present in this
     * chunk, used for calculation of the regional difficulty factor. In vanilla,
     * it is increased by the number of players in the chunk every tick, and is
     * capped at 3,600,000 ticks (50 hours).
     *
     * @return The number of ticks
     */
    Ticks inhabitedTime();

    /**
     * Sets the {@link Ticks number of ticks} players have been present in this
     * chunk.
     *
     * @see #inhabitedTime()
     * @param newInhabitedTime The {@link Ticks} to set this value to
     * @throws IllegalArgumentException If the inhabited time is infinite
     */
    void setInhabitedTime(Ticks newInhabitedTime);

}
