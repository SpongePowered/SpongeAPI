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
package org.spongepowered.api.world.server;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DirectionRelativeDataHolder;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.event.Cause;
import org.spongepowered.api.event.EventContext;
import org.spongepowered.api.event.cause.entity.SpawnType;
import org.spongepowered.api.event.entity.SpawnEntityEvent;
import org.spongepowered.api.fluid.FluidType;
import org.spongepowered.api.scheduler.ScheduledUpdate;
import org.spongepowered.api.scheduler.TaskPriority;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.Ticks;
import org.spongepowered.api.world.BlockChangeFlag;
import org.spongepowered.api.world.LocatableBlock;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.volume.entity.EntityVolume;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.function.BiFunction;

/**
 * A position within a particular {@link ServerWorld}.
 *
 * <p>Locations are immutable. Methods that change the properties of the
 * location create a new instance.</p>
 */
public interface ServerLocation extends DataHolder.Mutable, DirectionRelativeDataHolder.Mutable, Location<ServerWorld, ServerLocation>, DataSerializable {

    static ServerLocation of(final ServerWorld world, final double x, final double y, final double z) {
        return Sponge.game().factoryProvider().provide(Factory.class).create(world, new Vector3d(x, y, z));
    }

    static ServerLocation of(final ResourceKey worldKey, final double x, final double y, final double z) {
        return Sponge.game().factoryProvider().provide(Factory.class).create(worldKey, new Vector3d(x, y, z));
    }

    static ServerLocation of(final ServerWorld world, final Vector3d position) {
        return Sponge.game().factoryProvider().provide(Factory.class).create(world, position);
    }

    static ServerLocation of(final ResourceKey worldKey, final Vector3d position) {
        return Sponge.game().factoryProvider().provide(Factory.class).create(worldKey, position);
    }

    static ServerLocation of(final ServerWorld world, final int x, final int y, final int z) {
        return Sponge.game().factoryProvider().provide(Factory.class).create(world, new Vector3i(x, y, z));
    }

    static ServerLocation of(final ResourceKey worldKey, final int x, final int y, final int z) {
        return Sponge.game().factoryProvider().provide(Factory.class).create(worldKey, new Vector3i(x, y, z));
    }

    static ServerLocation of(final ServerWorld world, final Vector3i position) {
        return Sponge.game().factoryProvider().provide(Factory.class).create(world, position);
    }

    static ServerLocation of(final ResourceKey worldKey, final Vector3i position) {
        return Sponge.game().factoryProvider().provide(Factory.class).create(worldKey, position);
    }

    /**
     * Gets the {@link UUID} of the world.
     *
     * @return The world unique id
     */
    ResourceKey worldKey();

    /**
     * Gets a {@link LocatableBlock}.
     *
     * @return The locatable block of this location.
     */
    LocatableBlock asLocatableBlock();

    /**
     * Calls the mapper function on the world and position.
     *
     * @param mapper The mapper
     * @param <T> The return type of the mapper
     * @return The results of the mapping
     */
    <T> T map(BiFunction<ServerWorld, Vector3d, T> mapper);

    /**
     * Calls the mapper function on the world and block position.
     *
     * @param mapper The mapper
     * @param <T> The return type of the mapper
     * @return The results of the mapping
     */
    <T> T mapBlock(BiFunction<ServerWorld, Vector3i, T> mapper);

    /**
     * Calls the mapper function on the world and chunk position.
     *
     * @param mapper The mapper
     * @param <T> The return type of the mapper
     * @return The results of the mapping
     */
    <T> T mapChunk(BiFunction<ServerWorld, Vector3i, T> mapper);

    /**
     * Calls the mapper function on the world and biome position.
     *
     * @param mapper The mapper
     * @param <T> The return type of the mapper
     * @return The results of the mapping
     */
    <T> T mapBiome(BiFunction<ServerWorld, Vector3i, T> mapper);

    /**
     * Replace the block at this position with a copy of the given snapshot.
     *
     * <p>Changing the snapshot afterwards will not affect the block that has
     * been placed at this location.</p>
     *  @param snapshot The snapshot
     * @param force If true, forces block state to be set even if the
     * {@link BlockType} does not match the snapshot one.
     * @param flag The various change flags controlling some interactions
     * @return True if the snapshot restore was successful
     */
    boolean restoreSnapshot(BlockSnapshot snapshot, boolean force, BlockChangeFlag flag);

    /**
     * Remove the block at this position by replacing it with
     * {@link BlockTypes#AIR}.
     *
     * <p>This will remove any extended block data at the given position.</p>
     * @return True if the block change was successful
     */
    boolean removeBlock();

    /**
     * Create an entity instance at the given position.
     *
     * <p>Creating an entity does not spawn the entity into the world. An entity
     * created means the entity can be spawned at the given location. If
     * {@link Optional#empty()} was returned, the entity is not able to spawn at
     * the given location. Furthermore, this allows for the {@link Entity} to be
     * customized further prior to traditional "ticking" and processing by core
     * systems.</p>
     *
     * @param type The type
     * @return An entity, if one was created
     * @throws IllegalArgumentException If the position or entity type is not
     *     valid to create
     * @throws IllegalStateException If a constructor cannot be found
     * @see EntityVolume.Mutable#createEntity(EntityType, Vector3d)
     */
    <E extends Entity> E createEntity(EntityType<E> type);

    /**
     * Spawns an {@link Entity} using the already set properties (world,
     * position, rotation) and applicable {@link Value}s with the
     * specified {@link Cause} for spawning the entity.
     *
     * <p>Note that for the {@link Cause} to be useful in the expected
     * {@link SpawnEntityEvent}, a {@link SpawnType} should be provided in the
     * {@link EventContext} for other plugins to understand and have finer
     * control over the event.</p>
     *
     * <p>The requirements involve that all necessary setup of states and data
     * is already preformed on the entity retrieved from the various
     * {@link EntityVolume.Mutable#createEntity(EntityType,Vector3d)} methods.
     * Calling this will make the now-spawned entity able to be processed by
     * various systems.</p>
     *
     * <p>If the entity was unable to spawn, the entity is not removed, but it
     * should be taken note that there can be many reasons for a failure.</p>
     *
     * @param entity The entity to spawn
     * @return True if successful, false if not
     * @see EntityVolume.Mutable#spawnEntity(Entity)
     */
    boolean spawnEntity(Entity entity);

    /**
     * Similar to {@link #spawnEntity(Entity)} except where multiple
     * entities can be attempted to be spawned with a customary {@link Cause}.
     * The recommended use is to easily process the entity spawns without
     * interference with the cause tracking system.
     *
     * @param entities The entities which spawned correctly, or empty if none
     * @return True if any of the entities were successfully spawned
     * @see EntityVolume.Mutable#spawnEntities(Iterable)
     */
    Collection<Entity> spawnEntities(Iterable<? extends Entity> entities);

    /**
     * Gets the highest {@link ServerLocation} at this location.
     *
     * @return The highest location at this location
     * @see World#highestPositionAt(Vector3i)
     */
    ServerLocation asHighestLocation();

    /**
     * Gets a snapshot of this block at the current point in time.
     *
     * <p>A snapshot is disconnected from the {@link World} that it was taken
     * from so changes to the original block do not affect the snapshot.</p>
     *
     * @return A snapshot
     */
    BlockSnapshot createSnapshot();

    /**
     * Gets a list of {@link ScheduledUpdate}s for the block at this location.
     *
     * @return A list of scheduled block updates on this location
     */
    Collection<? extends ScheduledUpdate<BlockType>> scheduledBlockUpdates();

    /**
     * Adds a new {@link ScheduledUpdate} for the block at this location.
     *
     * @param delay The delay before the scheduled update should be processed
     * @param temporalUnit The temporal unit of the delay
     * @return The newly created scheduled update
     */
    ScheduledUpdate<BlockType> scheduleBlockUpdate(int delay, TemporalUnit temporalUnit);

    /**
     * Adds a new {@link ScheduledUpdate} for the block at this location.
     *
     * @param delay The delay, in {@link Ticks}, before the scheduled update
     *              should be processed
     * @param priority The priority of the scheduled update
     * @return The newly created scheduled update
     * @throws IllegalArgumentException if the delay is infinite
     */
    ScheduledUpdate<BlockType> scheduleBlockUpdate(Ticks delay, TaskPriority priority);

    /**
     * Adds a new {@link ScheduledUpdate} for the block at this location.
     *
     * @param delay The delay before the scheduled update should be processed
     * @param temporalUnit The temporal unit of the delay
     * @param priority The priority of the scheduled update
     * @return The newly created scheduled update
     */
    ScheduledUpdate<BlockType> scheduleBlockUpdate(int delay, TemporalUnit temporalUnit, TaskPriority priority);

    /**
     * Adds a new {@link ScheduledUpdate} for the block at this location.
     *
     * @param delay The delay, in {@link Ticks}, before the scheduled update
     *              should be processed
     * @return The newly created scheduled update
     * @throws IllegalArgumentException if the delay is infinite
     */
    ScheduledUpdate<BlockType> scheduleBlockUpdate(Ticks delay);

    /**
     * Adds a new {@link ScheduledUpdate} for the block at this location.
     *
     * @param delay The delay before the scheduled update should be processed
     * @return The newly created scheduled update
     */
    ScheduledUpdate<BlockType> scheduleBlockUpdate(Duration delay);

    /**
     * Adds a new {@link ScheduledUpdate} for the block at this location.
     *
     * @param delay The delay before the scheduled update should be processed
     * @param priority The priority of the scheduled update
     * @return The newly created scheduled update
     */
    ScheduledUpdate<BlockType> scheduleBlockUpdate(Duration delay, TaskPriority priority);

    /**
     * Gets a list of {@link ScheduledUpdate}s for the fluid at this location.
     *
     * @return A list of scheduled fluid updates on this location
     */
    Collection<? extends ScheduledUpdate<FluidType>> scheduledFluidUpdates();

    /**
     * Adds a new {@link ScheduledUpdate} for the fluid at this location.
     *
     * @param delay The delay before the scheduled update should be processed
     * @param temporalUnit The temporal unit of the delay
     * @return The newly created scheduled update
     */
    ScheduledUpdate<FluidType> scheduleFluidUpdate(int delay, TemporalUnit temporalUnit);

    /**
     * Adds a new {@link ScheduledUpdate} for the fluid at this location.
     *
     * @param delay The delay before the scheduled update should be processed
     * @param temporalUnit The temporal unit of the delay
     * @param priority The priority of the scheduled update
     * @return The newly created scheduled update
     */
    ScheduledUpdate<FluidType> scheduleFluidUpdate(int delay, TemporalUnit temporalUnit, TaskPriority priority);

    /**
     * Adds a new {@link ScheduledUpdate} for the fluid at this location.
     *
     * @param ticks The delay, in {@link Ticks}, before the scheduled update
     *              should be processed
     * @return The newly created scheduled update
     * @throws IllegalArgumentException if the delay is infinite
     */
    ScheduledUpdate<FluidType> scheduleFluidUpdate(Ticks ticks);

    /**
     * Adds a new {@link ScheduledUpdate} for the fluid at this location.
     *
     * @param ticks The delay, in {@link Ticks}, before the scheduled update
     *              should be processed
     * @param priority The priority of the scheduled update
     * @return The newly created scheduled update
     * @throws IllegalArgumentException if the delay is infinite
     */
    ScheduledUpdate<FluidType> scheduleFluidUpdate(Ticks ticks, TaskPriority priority);

    /**
     * Adds a new {@link ScheduledUpdate} for the fluid at this location.
     *
     * @param delay The delay before the scheduled update should be processed
     * @return The newly created scheduled update
     */
    ScheduledUpdate<FluidType> scheduleFluidUpdate(Duration delay);

    /**
     * Adds a new {@link ScheduledUpdate} for the fluid at this location.
     *
     * @param delay The delay before the scheduled update should be processed
     * @param priority The priority of the scheduled update
     * @return The newly created scheduled update
     */
    ScheduledUpdate<FluidType> scheduleFluidUpdate(Duration delay, TaskPriority priority);

    @Override
    ServerLocation withWorld(ServerWorld world);

    @Override
    ServerLocation withPosition(Vector3d position);

    @Override
    ServerLocation withBlockPosition(Vector3i position);

    @Override
    ServerLocation sub(Vector3d v);

    @Override
    ServerLocation sub(Vector3i v);

    @Override
    ServerLocation sub(double x, double y, double z);

    @Override
    ServerLocation add(Vector3d v);

    @Override
    ServerLocation add(Vector3i v);

    @Override
    ServerLocation add(double x, double y, double z);

    @Override
    ServerLocation relativeTo(Direction direction);

    @Override
    ServerLocation relativeToBlock(Direction direction);

    interface Factory {
        ServerLocation create(ServerWorld world, Vector3d position);

        ServerLocation create(ServerWorld world, Vector3i blockPosition);

        ServerLocation create(ResourceKey worldKey, Vector3d position);

        ServerLocation create(ResourceKey worldKey, Vector3i blockPosition);
    }
}
