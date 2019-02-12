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

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.Game;
import org.spongepowered.api.Server;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.world.ProtoWorld;
import org.spongepowered.api.world.UpdatableVolume;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.biome.MutableBiomeVolume;
import org.spongepowered.api.world.volume.LightCalculatingVolume;
import org.spongepowered.api.world.volume.block.MutableBlockVolume;
import org.spongepowered.api.world.volume.composite.ReadableCompositeVolume;
import org.spongepowered.api.world.volume.tileentity.MutableTileEntityVolume;

/**
 * A chunk is a specific grid-aligned partition of a {@link ProtoWorld}.
 *
 * <p>ProtoChunk is exposed as a superinterface due to the nature of needing
 * chunk like structures for various purposes, whether it's for world generation,
 * chunk loading from storage, or empty chunks on clients. Traditionally, a
 * usable "live" proto chunk instance will be a {@link Chunk} with a valid
 * {@link World} instance.</p>
 *
 * <p>In Minecraft, the chunk is 16 by 16 blocks on the X and Z axes. The height
 * of each chunk varies between worlds.</p>
 */
public interface ProtoChunk<P extends ProtoChunk<P>> extends
    ReadableCompositeVolume,
        MutableBlockVolume<P>, MutableTileEntityVolume<P>, MutableBiomeVolume<P>, LightCalculatingVolume, UpdatableVolume {

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
     * {@link #getLight(Vector3i)}, {@link #getWorld()}, etc. Usually,
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

    @Override
    P getView(Vector3i newMin, Vector3i newMax);
}
