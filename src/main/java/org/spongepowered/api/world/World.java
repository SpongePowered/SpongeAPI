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

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.audience.ForwardingAudience;
import org.spongepowered.api.Engine;
import org.spongepowered.api.Server;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.effect.Viewer;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.fluid.FluidTypes;
import org.spongepowered.api.service.context.ContextSource;
import org.spongepowered.api.util.annotation.DoNotStore;
import org.spongepowered.api.world.chunk.Chunk;
import org.spongepowered.api.world.volume.archetype.ArchetypeVolumeCreator;
import org.spongepowered.api.world.volume.block.PhysicsAwareMutableBlockVolume;
import org.spongepowered.api.world.weather.Weathers;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * A loaded Minecraft world.
 */
@DoNotStore
public interface World<W extends World<W>> extends ForwardingAudience,
    ProtoWorld<W>,
    LocationCreator,
    PhysicsAwareMutableBlockVolume<W>,
    ContextSource,
    Viewer,
    ArchetypeVolumeCreator
{

    /**
     * Gets the {@link Engine} that simulates this world.
     *
     * @return The engine
     */
    Engine getEngine();

    /**
     * Gets if this world is currently loaded.
     *
     * <p>An assumption can be made that if this returns false, this is considered a stale object.</p>
     *
     * @return True if loaded, false if not
     */
    boolean isLoaded();

    /**
     * Gets an unmodifiable collection of {@link Player players} currently in this world.
     *
     * @return The players
     */
    @Override
    Collection<? extends Player> getPlayers();

    @Override
    default Iterable<? extends Audience> audiences() {
        return this.getPlayers();
    }

    default Optional<? extends Player> getClosestPlayer(final Vector3i position, final double distance) {
        return this.getClosestPlayer(position.getX(), position.getY(), position.getZ(), distance, player -> true);
    }

    default Optional<? extends Player> getClosestPlayer(final Vector3i position, final double distance, final Predicate<? super Player> predicate) {
        return this.getClosestPlayer(position.getX(), position.getY(), position.getZ(), distance, predicate);
    }

    default Optional<? extends Player> getClosestPlayer(final Entity entity, final double distance) {
        final Vector3d position = entity.getLocation().getPosition();
        return this.getClosestPlayer(position.getFloorX(), position.getFloorY(), position.getFloorZ(), distance, player -> true);
    }

    default Optional<? extends Player> getClosestPlayer(final Entity entity, final double distance, final Predicate<? super Player> predicate) {
        final Vector3d position = entity.getLocation().getPosition();
        return this.getClosestPlayer(position.getFloorX(), position.getFloorY(), position.getFloorZ(), distance, predicate);
    }

    default Optional<? extends Player> getClosestPlayer(final int x, final int y, final int z, final double distance) {
        return this.getClosestPlayer(x, y, z, distance, player -> true);
    }

    Optional<? extends Player> getClosestPlayer(int x, int y, int z, double distance, Predicate<? super Player> predicate);

    /**
     * Gets a snapshot of this block at the current point in time.
     *
     * <p>A snapshot is disconnected from the {@link World} that it was taken
     * from so changes to the original block do not affect the snapshot.</p>
     *
     * @param position The position of the block
     * @return A snapshot
     */
    default BlockSnapshot createSnapshot(final Vector3i position) {
        Objects.requireNonNull(position);
        return this.createSnapshot(position.getX(), position.getY(), position.getZ());
    }

    /**
     * Gets a snapshot of this block at the current point in time.
     *
     * <p>A snapshot is disconnected from the {@link World} that it was taken
     * from so changes to the original block do not affect the snapshot.</p>
     *
     * @param x The x position
     * @param y The y position
     * @param z The z position
     * @return A snapshot
     */
    BlockSnapshot createSnapshot(int x, int y, int z);

    /**
     * Restores the given {@link BlockSnapshot} using the saved block position
     * stored within the snapshot.
     *
     * <p>If forced, the state of the block will change its {@link BlockType} to
     * match that of the snapshot then set the state. However, if force is set
     * to false and the {@link BlockType}s does not match, false will be
     * returned. If notifyNeighbors is true, neighboring blocks will be notified
     * of changes at the restored block location triggering physic updates.</p>
     *
     * @param snapshot The snapshot
     * @param force If true, forces block state to be set even if the
     *        {@link BlockType} does not match the snapshot one.
     * @param flag The various change flags controlling some interactions
     * @return True if the restore was successful, false otherwise
     */
    boolean restoreSnapshot(BlockSnapshot snapshot, boolean force, BlockChangeFlag flag);

    /**
     * Restores the {@link BlockSnapshot} at the given position.
     *
     * <p>If forced, the state of the block will change its {@link BlockType} to
     * match that of the snapshot then set the state. However, if force is set
     * to false and the {@link BlockType block types} do not match, false will be
     * returned. If notifyNeighbors is {@code true}, neighboring blocks will be notified
     * of changes at the restored block location triggering physics updates.</p>
     *
     * @param position The position of the block
     * @param snapshot The snapshot
     * @param force If true, forces block state to be set even if the the block type does
     *             not match the snapshot one.
     * @param flag The various change flags controlling some interactions
     * @return True if the restore was successful, false otherwise
     */
    default boolean restoreSnapshot(final Vector3i position, final BlockSnapshot snapshot, final boolean force, final BlockChangeFlag flag) {
        return this.restoreSnapshot(position.getX(), position.getY(), position.getZ(), snapshot, force, flag);
    }

    /**
     * Restores the {@link BlockSnapshot} at the given position.
     *
     * <p>If forced, the state of the block will change its {@link BlockType} to
     * match that of the snapshot then set the state. However, if force is set
     * to false and the {@link BlockType}s does not match, false will be
     * returned. If notifyNeighbors is true, neighboring blocks will be notified
     * of changes at the restored block location triggering physic updates.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param snapshot The snapshot
     * @param force If true, forces block state to be set even if the
     *        {@link BlockType} does not match the snapshot one.
     * @param flag The various change flags controlling some interactions
     * @return true if the restore was successful, false otherwise
     */
    boolean restoreSnapshot(int x, int y, int z, BlockSnapshot snapshot, boolean force, BlockChangeFlag flag);

    /**
     * {@inheritDoc}
     * This gets a guaranteed {@link Chunk} at the desired block position; however,
     * the {@link Chunk} instance may be {@link Chunk#isEmpty() empty}, and
     * likewise, may not be generated, valid, pre-existing. It is important to
     * check for these cases prior to attmepting to modify the chunk.
     *
     * <p>Note that this is still different from {@link #getChunk(Vector3i)}
     * due to the relative block position dictated by {@link Server#getChunkLayout()},
     * which can vary depending on implementation and other mods installed.</p>
     *
     * @param blockPosition The block position to be transformed for relative chunk position
     * @return The available chunk at that position
     */
    @Override
    default Chunk getChunkAtBlock(final Vector3i blockPosition) {
        Objects.requireNonNull(blockPosition);
        final Vector3i chunkPos = Sponge.getServer().getChunkLayout().forceToChunk(blockPosition);
        return this.getChunk(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ());
    }

    /**
     * {@inheritDoc}
     * This gets a guaranteed {@link Chunk} at the desired block position; however,
     * the {@link Chunk} instance may be {@link Chunk#isEmpty() empty}, and
     * likewise, may not be generated, valid, pre-existing. It is important to
     * check for these cases prior to attmepting to modify the chunk.
     *
     * <p>Note that this is still different from {@link #getChunk(Vector3i)}
     * due to the relative block position dictated by {@link Server#getChunkLayout()},
     * which can vary depending on implementation and other mods installed.</p>
     *
     * @param bx The block x coordinate
     * @param by The block y coordinate
     * @param bz The block z coordinate
     * @return The available chunk at that position
     */
    @Override
    Chunk getChunkAtBlock(int bx, int by, int bz);

    /**
     * {@inheritDoc}
     * This gets a guaranteed {@link Chunk} at the desired block position; however,
     * the {@link Chunk} instance may be {@link Chunk#isEmpty() empty}, and
     * likewise, may not be generated, valid, pre-existing. It is important to
     * check for these cases prior to attmepting to modify the chunk.
     *
     * @param chunkPos The chunk position relative to the {@link Server#getChunkLayout() chunk layout}
     * @return The available chunk at that position
     */
    @Override
    default Chunk getChunk(Vector3i chunkPos) {
        Objects.requireNonNull(chunkPos);
        return this.getChunk(chunkPos.getX(), chunkPos.getY(), chunkPos.getZ());
    }

    /**
     * {@inheritDoc}
     * This gets a guaranteed {@link Chunk} at the desired block position; however,
     * the {@link Chunk} instance may be {@link Chunk#isEmpty() empty}, and
     * likewise, may not be generated, valid, pre-existing. It is important to
     * check for these cases prior to attmepting to modify the chunk.
     *
     * @param cx The x chunk coordinate
     * @param cy The y coordinate
     * @param cz The z chunk coordinate
     * @return The available chunk at the chunk position
     */
    @Override
    Chunk getChunk(int cx, int cy, int cz);

    /**
     * Gets the chunk at the given chunk coordinate position if it exists or if
     * {@code shouldGenerate} is true and the chunk is generated.
     *
     * @param chunkPosition The position
     * @param shouldGenerate True to generate a new chunk
     * @return The loaded or generated chunk, if already generated
     */
    default Optional<Chunk> loadChunk(Vector3i chunkPosition, boolean shouldGenerate) {
        Objects.requireNonNull(chunkPosition);
        return this.loadChunk(chunkPosition.getX(), chunkPosition.getY(), chunkPosition.getZ(), shouldGenerate);
    }

    /**
     * Gets the chunk at the given chunk coordinate position if it exists or if
     * {@code shouldGenerate} is true and the chunk is generated.
     *
     * <p>In Vanilla, the y coordinate will always be 0.</p>
     *
     * @param cx The x coordinate
     * @param cy The y coordinate
     * @param cz The z coordinate
     * @param shouldGenerate True to generate a new chunk
     * @return The loaded or generated chunk, if already generated
     */
    Optional<Chunk> loadChunk(int cx, int cy, int cz, boolean shouldGenerate);

    /**
     * Returns a Collection of all actively loaded chunks in this world.
     *
     * <p>The ordering of the returned chunks is undefined.</p>
     *
     * @return The loaded chunks
     */
    Iterable<Chunk> getLoadedChunks();

    /**
     * Gets whether players can respawn.
     *
     * @return True if players can respawn, false if not
     */
    boolean allowsPlayerRespawns();

    /**
     * Gets whether water evaporates
     *
     * @return True if water evaporates, false if not
     */
    boolean doesWaterEvaporate();

    /**
     * Returns whether this world has light provided by the sky.
     *
     * @return True if light is provided by the sky, false if not
     */
    boolean hasSkylight();

    /**
     * Gets if the logic for cave worlds will run for this world.
     *
     * <p>
     *     In vanilla minecraft, a {@code true} value means:
     *     <ul>
     *         <li>{@link FluidTypes#LAVA} update 3 times slower</li>
     *         <li>Maps are half the size</li>
     *         <li>{@link Weathers#THUNDER} will not occur</li>
     *         <li>The height of the world is 128 instead of the default 256</li>
     *     </ul>
     *
     * @return True if surface like, false if not
     */
    boolean isCaveWorld();

    /**
     * Gets if the logic for surface worlds will run for this world.
     *
     * <p>
     *     In vanilla minecraft, a {@code true} value means:
     *     <ul>
     *         <li>Players can sleep here</li>
     *         <li>Zombie Pigmen will not spawn around a nether portal</li>
     *         <li>Client will render clouds</li>
     *     </ul>
     *
     * @return True if surface like, false if not
     */
    boolean isSurfaceWorld();
}
