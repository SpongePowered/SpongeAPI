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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.block.entity.BlockEntity;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DirectionRelativeDataHolder;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.EventContext;
import org.spongepowered.api.event.cause.entity.spawn.SpawnType;
import org.spongepowered.api.event.entity.SpawnEntityEvent;
import org.spongepowered.api.fluid.FluidState;
import org.spongepowered.api.fluid.FluidType;
import org.spongepowered.api.scheduler.ScheduledUpdate;
import org.spongepowered.api.scheduler.TaskPriority;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.biome.BiomeType;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.api.world.volume.entity.MutableEntityVolume;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.function.BiFunction;

/**
 * A position within a particular {@link World}.
 *
 * <p>Locations are immutable. Methods that change the properties of the
 * location create a new instance.</p>
 */
public interface Location extends DataHolder.Mutable, DirectionRelativeDataHolder.Mutable, WorldLocation<ServerWorld> {

    static Location of(World world, double x, double y, double z) {
        return Sponge.getRegistry().requireFactory(Factory.class).create(world, new Vector3d(x, y, z));
    }

    static Location of(UUID worldUniqueId, double x, double y, double z) {
        return Sponge.getRegistry().requireFactory(Factory.class).create(worldUniqueId, new Vector3d(x, y, z));
    }

    static Location of(World world, Vector3d position) {
        return Sponge.getRegistry().requireFactory(Factory.class).create(world, position);
    }

    static Location of(UUID worldUniqueId, Vector3d position) {
        return Sponge.getRegistry().requireFactory(Factory.class).create(worldUniqueId, position);
    }

    static Location of(World world, int x, int y, int z) {
        return Sponge.getRegistry().requireFactory(Factory.class).create(world, new Vector3i(x, y, z));
    }

    static Location of(UUID worldUniqueId, int x, int y, int z) {
        return Sponge.getRegistry().requireFactory(Factory.class).create(worldUniqueId, new Vector3i(x, y, z));
    }

    static Location of(World world, Vector3i position) {
        return Sponge.getRegistry().requireFactory(Factory.class).create(world, position);
    }

    static Location of(UUID worldUniqueId, Vector3i position) {
        return Sponge.getRegistry().requireFactory(Factory.class).create(worldUniqueId, position);
    }

    /**
     * Gets the underlying world. Throws a {@link IllegalStateException}
     * if the world isn't available.
     *
     * @return The underlying world
     * @see #getWorldIfAvailable()
     */
    World getWorld();

    /**
     * Gets the underlying {@link World} if it's available. A {@link World}
     * is available when it exists and is loaded.
     *
     * @return The underlying world, if available
     * @see #isAvailable()
     */
    Optional<World> getWorldIfAvailable();

    /**
     * Gets the {@link UUID} of the world.
     *
     * @return The world unique id
     */
    UUID getWorldUniqueId();

    /**
     * Gets whether this location is available. A location is
     * available when the target {@link World} exists and is loaded.
     *
     * @return Whether the location is available
     */
    boolean isAvailable();

    /**
     * Gets whether this location is valid. A location is valid
     * when the target {@link World} exists, this can be loaded
     * or unloaded.
     *
     * @return Whether the location is valid
     */
    boolean isValid();

    /**
     * Gets the underlying position.
     *
     * @return The underlying position
     */
    Vector3d getPosition();

    /**
     * Gets the underlying block position.
     *
     * @return The underlying block position
     */
    Vector3i getBlockPosition();

    /**
     * Gets the underlying chunk position.
     *
     * @return The underlying chunk position
     */
    Vector3i getChunkPosition();

    /**
     * Gets the underlying biome position.
     *
     * @return The underlying biome position
     */
    Vector3i getBiomePosition();

    /**
     * Gets the X component of this instance's position.
     *
     * @return The x component
     */
    double getX();

    /**
     * Gets the Y component of this instance's position.
     *
     * @return The y component
     */
    double getY();

    /**
     * Gets the Z component of this instance's position.
     *
     * @return The z component
     */
    double getZ();

    /**
     * Gets the floored X component of this instance's position.
     *
     * @return The floored x component
     */
    int getBlockX();

    /**
     * Gets the floored Y component of this instance's position.
     *
     * @return The floored y component
     */
    int getBlockY();

    /**
     * Gets the floored Z component of this instance's position.
     *
     * @return The floored z component
     */
    int getBlockZ();

    /**
     * Returns true if this location is in the given world. This is implemented
     * as an {@link Object#equals(Object)} check.
     *
     * @param world The world to check
     * @return Whether this location is in the world
     */
    boolean inWorld(World world);

    /**
     * Gets a {@link LocatableBlock}.
     *
     * @return The locatable block of this location.
     */
    LocatableBlock asLocatableBlock();

    /**
     * Create a new instance with a new World.
     *
     * @param world The new world
     * @return A new instance
     */
    Location withWorld(World world);

    /**
     * Create a new instance with a new position.
     *
     * @param position The new position
     * @return A new instance
     */
    Location withPosition(Vector3d position);

    /**
     * Create a new instance with a new block position.
     *
     * @param position The new position
     * @return A new instance
     */
    Location withBlockPosition(Vector3i position);

    /**
     * Subtract another Vector3d to the position on this instance, returning
     * a new Location instance.
     *
     * @param v The vector to subtract
     * @return A new instance
     */
    Location sub(Vector3d v);

    /**
     * Subtract another Vector3i to the position on this instance, returning
     * a new Location instance.
     *
     * @param v The vector to subtract
     * @return A new instance
     */
    Location sub(Vector3i v);

    /**
     * Subtract vector components to the position on this instance, returning a
     * new Location instance.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return A new instance
     */
    Location sub(double x, double y, double z);

    /**
     * Add another Vector3d to the position on this instance, returning a new
     * Location instance.
     *
     * @param v The vector to add
     * @return A new instance
     */
    Location add(Vector3d v);

    /**
     * Add another Vector3i to the position on this instance, returning a new
     * Location instance.
     *
     * @param v The vector to add
     * @return A new instance
     */
    Location add(Vector3i v);

    /**
     * Add vector components to the position on this instance, returning a new
     * Location instance.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return A new instance
     */
    Location add(double x, double y, double z);

    /**
     * Calls the mapper function on the world and position.
     *
     * @param mapper The mapper
     * @param <T> The return type of the mapper
     * @return The results of the mapping
     */
    <T> T map(BiFunction<World, Vector3d, T> mapper);

    /**
     * Calls the mapper function on the world and block position.
     *
     * @param mapper The mapper
     * @param <T> The return type of the mapper
     * @return The results of the mapping
     */
    <T> T mapBlock(BiFunction<World, Vector3i, T> mapper);

    /**
     * Calls the mapper function on the world and chunk position.
     *
     * @param mapper The mapper
     * @param <T> The return type of the mapper
     * @return The results of the mapping
     */
    <T> T mapChunk(BiFunction<World, Vector3i, T> mapper);

    /**
     * Calls the mapper function on the world and biome position.
     *
     * @param mapper The mapper
     * @param <T> The return type of the mapper
     * @return The results of the mapping
     */
     <T> T mapBiome(BiFunction<World, Vector3i, T> mapper);

    /**
     * Gets the location next to this one in the given direction.
     * Always moves by a unit amount, even diagonally.
     *
     * @param direction The direction to move in
     * @return The location in that direction
     */
    Location relativeTo(Direction direction);

    /**
     * Gets the location next to this one in the given direction.
     * Always moves by a block amount, even diagonally.
     *
     * <p>{@link org.spongepowered.api.util.Direction.Division#SECONDARY_ORDINAL}
     * directions are not a valid argument. These will throw an exception.
     * </p>
     *
     * @param direction The direction to move in
     * @return The location in that direction
     * @throws IllegalArgumentException If the direction is a
     * {@link org.spongepowered.api.util.Direction.Division#SECONDARY_ORDINAL}
     */
    Location relativeToBlock(Direction direction);

    /**
     * Gets the block at this location.
     *
     * @return The biome at this location
     */
    BiomeType getBiome();

    /**
     * Returns true if this location has a block at its
     * {@link #getBlockPosition()} ()}.
     *
     * @return Whether or not there is a block at this location.
     */
    boolean hasBlock();

    /**
     * Gets the {@link BlockState} for this position.
     *
     * @return The block state
     */
    BlockState getBlock();

    /**
     * Gets the {@link FluidState} for this position.
     *
     * @return The fluid state
     */
    FluidState getFluid();

    /**
     * Checks for whether the block at this position contains block entity data.
     *
     * @return True if the block at this position has block entity data, false
     *      otherwise
     */
    boolean hasBlockEntity();

    /**
     * Gets the associated {@link BlockEntity} on this block.
     *
     * @return The associated block entity, if available
     */
    Optional<BlockEntity> getBlockEntity();

    /**
     * Replace the block at this position with a new state.
     *
     * <p>This will remove any extended block data at the given position.</p>
     *
     * @param state The new block state
     * @return True if the block change was successful
     */
    boolean setBlock(BlockState state);

    /**
     * Replace the block at this position with a new state.
     *
     * <p>This will remove any extended block data at the given position.</p>
     *  @param state The new block state
     * @param flag The various change flags controlling some interactions
     * @return True if the block change was successful
     */
    boolean setBlock(BlockState state, BlockChangeFlag flag);

    /**
     * Replace the block type at this position by a new type.
     *
     * <p>This will remove any extended block data at the given position.</p>
     *
     * @param type The new type
     * @return True if the block change was successful
     */
    boolean setBlockType(BlockType type);

    /**
     * Replace the block type at this position by a new type.
     *
     * <p>This will remove any extended block data at the given position.</p>
     * @param type The new type
     * @param flag The various change flags controlling some interactions
     * @return True if the block change was successful
     */
    boolean setBlockType(BlockType type, BlockChangeFlag flag);

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
     * @see MutableEntityVolume#createEntity(EntityType, Vector3d)
     */
    Entity createEntity(EntityType<?> type);

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
     * {@link MutableEntityVolume#createEntity(EntityType,Vector3d)} methods.
     * Calling this will make the now-spawned entity able to be processed by
     * various systems.</p>
     *
     * <p>If the entity was unable to spawn, the entity is not removed, but it
     * should be taken note that there can be many reasons for a failure.</p>
     *
     * @param entity The entity to spawn
     * @return True if successful, false if not
     * @see MutableEntityVolume#spawnEntity(Entity)
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
     * @see MutableEntityVolume#spawnEntities(Iterable)
     */
    Collection<Entity> spawnEntities(Iterable<? extends Entity> entities);

    /**
     * Gets the highest {@link Location} at this location.
     *
     * @return The highest location at this location
     * @see World#getHighestPositionAt(Vector3i)
     */
    Location asHighestLocation();

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
    Collection<ScheduledUpdate<BlockType>> getScheduledBlockUpdates();

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
     * @param delay The delay before the scheduled update should be processed
     * @param temporalUnit The temporal unit of the delay
     * @param priority The priority of the scheduled update
     * @return The newly created scheduled update
     */
    ScheduledUpdate<BlockType> scheduleBlockUpdate(int delay, TemporalUnit temporalUnit, TaskPriority priority);

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
    Collection<ScheduledUpdate<FluidType>> getScheduledFluidUpdates();

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

    interface Factory {
        Location create(World world, Vector3d position);

        Location create(World world, Vector3i blockPosition);

        Location create(UUID worldUniqueId, Vector3d position);

        Location create(UUID worldUniqueId, Vector3i blockPosition);
    }
}
