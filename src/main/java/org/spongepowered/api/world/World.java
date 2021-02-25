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
import org.spongepowered.api.Server;
import org.spongepowered.api.effect.Viewer;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.registry.ScopedRegistryHolder;
import org.spongepowered.api.service.context.ContextSource;
import org.spongepowered.api.util.annotation.DoNotStore;
import org.spongepowered.api.world.chunk.Chunk;
import org.spongepowered.api.world.storage.WorldProperties;
import org.spongepowered.api.world.volume.archetype.ArchetypeVolumeCreator;
import org.spongepowered.api.world.volume.block.PhysicsAwareMutableBlockVolume;
import org.spongepowered.api.world.weather.WeatherUniverse;
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
public interface World<W extends World<W, L>, L extends Location<W, L>> extends ForwardingAudience, ProtoWorld<W>, LocationCreator<W, L>,
        PhysicsAwareMutableBlockVolume<W>, ContextSource, Viewer, ArchetypeVolumeCreator, WeatherUniverse, ScopedRegistryHolder {

    /**
     * Gets the {@link WorldProperties properties}.
     *
     * @return The properties
     */
    WorldProperties getProperties();

    @SuppressWarnings("unchecked")
    default W getWorld() {
        return (W) this;
    }

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
        Objects.requireNonNull(position, "position");
        return this.getClosestPlayer(position.getX(), position.getY(), position.getZ(), distance, player -> true);
    }

    default Optional<? extends Player> getClosestPlayer(final Vector3i position, final double distance, final Predicate<? super Player> predicate) {
        Objects.requireNonNull(position, "position");
        Objects.requireNonNull(predicate, "predicate");
        return this.getClosestPlayer(position.getX(), position.getY(), position.getZ(), distance, predicate);
    }

    default Optional<? extends Player> getClosestPlayer(final Entity entity, final double distance) {
        Objects.requireNonNull(entity, "entity");
        final Vector3d position = entity.getLocation().getPosition();
        return this.getClosestPlayer(position.getFloorX(), position.getFloorY(), position.getFloorZ(), distance, player -> true);
    }

    default Optional<? extends Player> getClosestPlayer(final Entity entity, final double distance, final Predicate<? super Player> predicate) {
        Objects.requireNonNull(entity, "entity");
        Objects.requireNonNull(predicate, "predicate");
        final Vector3d position = entity.getLocation().getPosition();
        return this.getClosestPlayer(position.getFloorX(), position.getFloorY(), position.getFloorZ(), distance, predicate);
    }

    default Optional<? extends Player> getClosestPlayer(final int x, final int y, final int z, final double distance) {
        return this.getClosestPlayer(x, y, z, distance, player -> true);
    }

    Optional<? extends Player> getClosestPlayer(int x, int y, int z, double distance, Predicate<? super Player> predicate);

    /**
     * {@inheritDoc}
     * This gets a guaranteed {@link Chunk} at the desired block position; however,
     * the {@link Chunk} instance may be {@link Chunk#isEmpty() empty}, and
     * likewise, may not be generated, valid, pre-existing. It is important to
     * check for these cases prior to attmepting to modify the chunk.
     *
     * <p>Note that this is still different from {@link #getChunk(Vector3i)}
     * due to it being a relative block position which can vary depending on
     * implementation and other mods installed.</p>
     *
     * @param blockPosition The block position to be transformed for relative chunk position
     * @return The available chunk at that position
     */
    @Override
    Chunk getChunkAtBlock(final Vector3i blockPosition);

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
    default Chunk getChunk(final Vector3i chunkPos) {
        Objects.requireNonNull(chunkPos, "chunkPos");
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
    default Optional<Chunk> loadChunk(final Vector3i chunkPosition, final boolean shouldGenerate) {
        Objects.requireNonNull(chunkPosition, "chunkPosition");
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
}
