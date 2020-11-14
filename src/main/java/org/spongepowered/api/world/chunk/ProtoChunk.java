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

import org.spongepowered.api.Game;
import org.spongepowered.api.Server;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.world.ProtoWorld;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.volume.entity.ReadableEntityVolume;
import org.spongepowered.api.world.volume.game.HeightAwareVolume;
import org.spongepowered.api.world.volume.game.LocationBaseDataHolder;
import org.spongepowered.api.world.volume.game.UpdatableVolume;
import org.spongepowered.api.world.volume.biome.MutableBiomeVolume;
import org.spongepowered.api.world.volume.block.MutableBlockVolume;
import org.spongepowered.api.world.volume.block.entity.MutableBlockEntityVolume;
import org.spongepowered.math.vector.Vector3i;

/**
 * A chunk is a specific grid-aligned partition of a {@link ProtoWorld}.
 *
 * <p>ProtoChunk is exposed as a superinterface due to the nature of needing
 * chunk like structures for various purposes, whether it's for world generation,
 * chunk loading from storage, or empty chunks on clients. Traditionally, a
 * usable "live" proto chunk instance will be a {@link Chunk} with a valid
 * {@link World} instance.</p>
 */
public interface ProtoChunk<P extends ProtoChunk<P>> extends
        MutableBlockVolume<P>,
        MutableBlockEntityVolume<P>,
        MutableBiomeVolume<P>,
        ReadableEntityVolume,
        UpdatableVolume,
        LocationBaseDataHolder.Mutable,
        HeightAwareVolume {

    /**
     * Adds the {@link Entity} to this {@link ProtoChunk chunk}. It is not
     * guaranteed this will succeed in all cases, as {@link #getState()}
     * does play a role in whether an entity can be directly added or not.
     *
     * <p>This method should realistically be used only during world
     * generation, and therefor will likely emit warnings if attempting to
     * add entities to live {@link Chunk} instances.</p>
     *
     * @param entity The entity to add
     */
    void addEntity(Entity entity);

    /**
     * Gets this {@link ProtoChunk}'s current {@link ChunkState}.
     * The {@link ChunkState} stipulates the potential validity of various
     * operations that can be performed, including but not limited to:
     * {@link #getWorld()}, etc. Usually,
     * this {@link ProtoChunk} is tied always to a {@link ProtoWorld},
     * but the validity of that world may also be questionable for feature
     * processing.
     *
     * <p>It can be expected however that if {@link #isEmpty()} returns
     * {@code false}, usually this status will likewise be {@link ChunkStates#EMPTY}.</p>
     *
     * @return This chunk's state
     */
    ChunkState getState();

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
    Vector3i getChunkPosition();

    /**
     * Gets the containing {@link ProtoWorld} of this {@link ProtoChunk}. As
     * it may vary based on the status of both {@link Game} and {@link Server},
     * this {@link ProtoChunk} may be likewise used for world generation, in
     * which case, the {@link ProtoWorld} would not be a {@link World} instance.
     *
     * <p>It can be inferred however, that if {@link #getState()} returns
     * {@link ChunkStates#WORLD_READY}, the {@link ProtoWorld} would be a
     * {@link World} instance. Inversely, if {@link #getState()} returns
     * {@link ChunkStates#EMPTY}, the {@link ProtoWorld} would not be a
     * valid {@link World} object.</p>
     *
     * @return The parented world
     */
    ProtoWorld<?> getWorld();

    /**
     * Gets the regional difficulty factor for this chunk. In vanilla, it is
     * dependent on the playtime of the world, inhabited time of the chunk, the
     * phase of the moon, and the current difficulty setting. This number ranges
     * from 0.75-1.5 on easy, 1.5-4.0 on normal, and 2.25-6.75 on hard.
     *
     * <p>This value is used for display only in vanilla.</p>
     *
     * @return The regional difficulty factor for this chunk
     */
    double getRegionalDifficultyFactor();

    /**
     * Gets the regional difficulty percentage for this chunk. It is calculated
     * by taking the regional difficulty factor and using the following rules:
     * If the factor is less than 2.0, the percentage is 0%. If the factor is
     * greater than 4.0, the percentage is 100%. Otherwise, the percentage is
     * the factor minus 2.0, divided by 2.0.
     *
     * <p>This is the value that is used in vanilla to find which effects are
     * caused by the regional difficulty.</p>
     *
     * @return The regional difficulty percentage for this chunk
     */
    double getRegionalDifficultyPercentage();

    void setInhabitedTime(long newInhabitedTime);

    long getInhabitedTime();

}
