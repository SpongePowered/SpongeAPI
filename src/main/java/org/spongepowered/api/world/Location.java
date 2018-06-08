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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.block.tileentity.TileEntity;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.Queries;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.merge.MergeFunction;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.data.property.DirectionRelativePropertyHolder;
import org.spongepowered.api.data.property.Property;
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
import org.spongepowered.api.world.volume.entity.MutableEntityVolume;

import java.lang.ref.WeakReference;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.Collection;
import java.util.Objects;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.UUID;
import java.util.function.BiFunction;

import javax.annotation.Nullable;

/**
 * A position within a particular {@link World}.
 *
 * <p>This class is primarily a helper class to represent a location in a
 * particular {@link World}. The methods provided are proxy methods to ones on
 * {@link World}.</p>
 *
 * <p>Each instance can be used to either represent a block or a location on a
 * continuous coordinate system. Internally, positions are stored using doubles.
 * When a block-related method is used, the components of the position are each
 * rounded to an integer.</p>
 *
 * <p>Locations are immutable. Methods that change the properties of the
 * location create a new instance.</p>
 */
public final class Location implements DataHolder, DirectionRelativePropertyHolder {

    private final UUID worldUniqueId;
    // A weak reference to the world in case it gets unloaded
    @Nullable private WeakReference<World> world;

    // Lazily computed, either position or blockPosition is set by the constructor
    @Nullable
    private Vector3d position = null;
    @Nullable
    private Vector3i blockPosition = null;
    @Nullable
    private Vector3i chunkPosition = null;
    @Nullable
    private Vector3i biomePosition = null;
    private int hash = 0;

    /**
     * Create a new instance.
     *
     * @param world The world
     * @param position The position
     */
    public Location(World world, Vector3d position) {
        this.world = new WeakReference<>(checkNotNull(world, "world"));
        this.worldUniqueId = world.getUniqueId();
        this.position = checkNotNull(position, "position");
    }

    /**
     * Create a new instance.
     *
     * @param world The world
     * @param x The X-axis position
     * @param y The Y-axis position
     * @param z The Z-axis position
     */
    public Location(World world, double x, double y, double z) {
        this(world, new Vector3d(x, y, z));
    }

    /**
     * Create a new instance.
     *
     * @param world The world
     * @param blockPosition The position
     */
    public Location(World world, Vector3i blockPosition) {
        this.world = new WeakReference<>(checkNotNull(world, "world"));
        this.worldUniqueId = world.getUniqueId();
        this.blockPosition = checkNotNull(blockPosition, "blockPosition");
    }

    /**
     * Create a new instance.
     *
     * @param world The world
     * @param x The X-axis position
     * @param y The Y-axis position
     * @param z The Z-axis position
     */
    public Location(World world, int x, int y, int z) {
        this(world, new Vector3i(x, y, z));
    }

    /**
     * Create a new instance.
     *
     * @param worldUniqueId The unique id of the world
     * @param position The position
     */
    public Location(UUID worldUniqueId, Vector3d position) {
        this.worldUniqueId = checkNotNull(worldUniqueId, "worldUniqueId");
        this.position = checkNotNull(position, "position");
    }

    /**
     * Create a new instance.
     *
     * @param worldUniqueId The unique id of the world
     * @param x The X-axis position
     * @param y The Y-axis position
     * @param z The Z-axis position
     */
    public Location(UUID worldUniqueId, double x, double y, double z) {
        this(worldUniqueId, new Vector3d(x, y, z));
    }

    /**
     * Create a new instance.
     *
     * @param worldUniqueId The unique id of the world
     * @param blockPosition The position
     */
    public Location(UUID worldUniqueId, Vector3i blockPosition) {
        this.worldUniqueId = checkNotNull(worldUniqueId, "worldUniqueId");
        this.blockPosition = checkNotNull(blockPosition, "blockPosition");
    }

    /**
     * Create a new instance.
     *
     * @param worldUniqueId The unique id of the world
     * @param x The X-axis position
     * @param y The Y-axis position
     * @param z The Z-axis position
     */
    public Location(UUID worldUniqueId, int x, int y, int z) {
        this(worldUniqueId, new Vector3i(x, y, z));
    }

    /**
     * Gets the underlying {@link World}.
     *
     * @return The world
     * @throws IllegalStateException If the {@link World} is unavailable
     * @see #isAvailable()
     */
    public World getWorld() {
        return getWorldIfAvailable().orElseThrow(() ->
                new IllegalStateException(String.format("The world %s is not available", this.worldUniqueId)));
    }

    /**
     * Gets the underlying {@link World} if it's available. A {@link World}
     * is available when it exists and is loaded.
     *
     * @return The world, if available
     * @see #isAvailable()
     */
    public Optional<World> getWorldIfAvailable() {
        final World currentWorld = this.world == null ? null : this.world.get();
        if (currentWorld != null) {
            return Optional.of(currentWorld);
        }
        final Optional<World> optWorld = Sponge.getServer().getWorld(this.worldUniqueId);
        if (!optWorld.isPresent()) {
            return Optional.empty();
        }
        this.world = new WeakReference<>(optWorld.get());
        return optWorld;
    }

    /**
     * Gets the {@link UUID} of the world.
     *
     * @return The world unique id
     */
    public UUID getWorldUniqueId() {
        return this.worldUniqueId;
    }

    /**
     * Gets whether this location is available. A location is
     * available when the target {@link World} exists and is loaded.
     *
     * @return Is available
     */
    public boolean isAvailable() {
        return getWorldIfAvailable().isPresent();
    }

    /**
     * Gets whether this location is valid. A location is valid
     * when the target {@link World} exists, this can be loaded
     * or unloaded.
     *
     * @return Is valid
     */
    public boolean isValid() {
        if (isAvailable()) {
            return true;
        }
        return Sponge.getServer().getWorldProperties(this.worldUniqueId).isPresent();
    }

    /**
     * Gets the underlying position.
     *
     * @return The underlying position
     */
    public Vector3d getPosition() {
        if (this.position == null) {
            checkState(this.blockPosition != null);
            this.position = getBlockPosition().toDouble();
        }
        return this.position;
    }

    /**
     * Gets the underlying block position.
     *
     * @return The underlying block position
     */
    public Vector3i getBlockPosition() {
        if (this.blockPosition == null) {
            checkState(this.position != null);
            this.blockPosition = getPosition().toInt();
        }
        return this.blockPosition;
    }

    /**
     * Gets the underlying chunk position.
     *
     * @return The underlying chunk position
     */
    public Vector3i getChunkPosition() {
        if (this.chunkPosition == null) {
            this.chunkPosition = Sponge.getServer().getChunkLayout().forceToChunk(getBlockPosition());
        }
        return this.chunkPosition;
    }

    /**
     * Gets the underlying biome position.
     *
     * @return The underlying biome position
     */
    public Vector3i getBiomePosition() {
        if (this.biomePosition == null) {
            final Vector3i blockPosition = getBlockPosition();
            this.biomePosition = new Vector3i(blockPosition.getX(), 0, blockPosition.getZ());
        }
        return this.biomePosition;
    }

    /**
     * Gets the X component of this instance's position.
     *
     * @return The x component
     */
    public double getX() {
        return getPosition().getX();
    }

    /**
     * Gets the Y component of this instance's position.
     *
     * @return The y component
     */
    public double getY() {
        return getPosition().getY();
    }

    /**
     * Gets the Z component of this instance's position.
     *
     * @return The z component
     */
    public double getZ() {
        return getPosition().getZ();
    }

    /**
     * Gets the floored X component of this instance's position.
     *
     * @return The floored x component
     */
    public int getBlockX() {
        return getBlockPosition().getX();
    }

    /**
     * Gets the floored Y component of this instance's position.
     *
     * @return The floored y component
     */
    public int getBlockY() {
        return getBlockPosition().getY();
    }

    /**
     * Gets the floored Z component of this instance's position.
     *
     * @return The floored z component
     */
    public int getBlockZ() {
        return getBlockPosition().getZ();
    }

    /**
     * Returns true if this location is in the given world. This is implemented
     * as an {@link Object#equals(Object)} check.
     *
     * @param world The world to check
     * @return Whether this location is in the world
     */
    public boolean inWorld(World world) {
        return getWorld().equals(world);
    }

    /**
     * Returns true if this location has a biome at its
     * {@link #getBiomePosition()}.
     *
     * @return Whether or not there is a biome at this location.
     */
    public boolean hasBiome() {
        return getWorld().containsBiome(getBiomePosition());
    }

    /**
     * Returns true if this location has a block at its
     * {@link #getBlockPosition()} ()}.
     *
     * @return Whether or not there is a block at this location.
     */
    public boolean hasBlock() {
        return getWorld().containsBlock(getBlockPosition());
    }

    /**
     * Gets a {@link LocatableBlock} if the parent {@link World} of this
     * {@link Location} is a {@link World}.
     *
     * @return The locatable block of this location, if available
     */
    public Optional<LocatableBlock> getLocatableBlock() {
        return getWorld() instanceof World
               ? Optional.of(
                LocatableBlock
                        .builder()
                        .world(getWorld())
                        .position(this.getBlockPosition())
                        .build()
                )
               : Optional.empty();
    }

    /**
     * Create a new instance with a new World.
     *
     * @param world The new world
     * @return A new instance
     */
    public Location setWorld(World world) {
        checkNotNull(world, "world");
        if (world == getWorld()) {
            return this;
        }
        return new Location(world, getPosition());
    }

    /**
     * Create a new instance with a new position.
     *
     * @param position The new position
     * @return A new instance
     */
    public Location setPosition(Vector3d position) {
        checkNotNull(position, "position");
        if (position == getPosition()) {
            return this;
        }
        return new Location(getWorld(), position);
    }

    /**
     * Create a new instance with a new block position.
     *
     * @param position The new position
     * @return A new instance
     */
    public Location setBlockPosition(Vector3i position) {
        checkNotNull(position, "position");
        if (position == getBlockPosition()) {
            return this;
        }
        return new Location(getWorld(), position);
    }

    /**
     * Subtract another Vector3d to the position on this instance, returning
     * a new Location instance.
     *
     * @param v The vector to subtract
     * @return A new instance
     */
    public Location sub(Vector3d v) {
        return sub(v.getX(), v.getY(), v.getZ());
    }

    /**
     * Subtract another Vector3i to the position on this instance, returning
     * a new Location instance.
     *
     * @param v The vector to subtract
     * @return A new instance
     */
    public Location sub(Vector3i v) {
        return sub(v.getX(), v.getY(), v.getZ());
    }

    /**
     * Subtract vector components to the position on this instance, returning a
     * new Location instance.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return A new instance
     */
    public Location sub(double x, double y, double z) {
        return setPosition(getPosition().sub(x, y, z));
    }

    /**
     * Add another Vector3d to the position on this instance, returning a new
     * Location instance.
     *
     * @param v The vector to add
     * @return A new instance
     */
    public Location add(Vector3d v) {
        return add(v.getX(), v.getY(), v.getZ());
    }

    /**
     * Add another Vector3i to the position on this instance, returning a new
     * Location instance.
     *
     * @param v The vector to add
     * @return A new instance
     */
    public Location add(Vector3i v) {
        return add(v.getX(), v.getY(), v.getZ());
    }

    /**
     * Add vector components to the position on this instance, returning a new
     * Location instance.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return A new instance
     */
    public Location add(double x, double y, double z) {
        return setPosition(getPosition().add(x, y, z));
    }

    /**
     * Calls the mapper function on the world and position.
     *
     * @param mapper The mapper
     * @param <T> The return type of the mapper
     * @return The results of the mapping
     */
    public <T> T map(BiFunction<World, Vector3d, T> mapper) {
        return mapper.apply(getWorld(), getPosition());
    }

    /**
     * Calls the mapper function on the world and block position.
     *
     * @param mapper The mapper
     * @param <T> The return type of the mapper
     * @return The results of the mapping
     */
    public <T> T mapBlock(BiFunction<World, Vector3i, T> mapper) {
        return mapper.apply(getWorld(), getBlockPosition());
    }

    /**
     * Calls the mapper function on the world and chunk position.
     *
     * @param mapper The mapper
     * @param <T> The return type of the mapper
     * @return The results of the mapping
     */
    public <T> T mapChunk(BiFunction<World, Vector3i, T> mapper) {
        return mapper.apply(getWorld(), getChunkPosition());
    }

    /**
     * Calls the mapper function on the world and biome position.
     *
     * @param mapper The mapper
     * @param <T> The return type of the mapper
     * @return The results of the mapping
     */
    public <T> T mapBiome(BiFunction<World, Vector3i, T> mapper) {
        return mapper.apply(getWorld(), getBiomePosition());
    }

    /**
     * Gets the location next to this one in the given direction.
     * Always moves by a unit amount, even diagonally.
     *
     * @param direction The direction to move in
     * @return The location in that direction
     */
    public Location getRelative(Direction direction) {
        return add(direction.asOffset());
    }

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
    public Location getBlockRelative(Direction direction) {
        checkArgument(!direction.isSecondaryOrdinal(), "Secondary cardinal directions can't be used here");
        return add(direction.asBlockOffset());
    }

    /**
     * Gets the block at this location.
     *
     * @return The biome at this location
     */
    public BiomeType getBiome() {
        return getWorld().getBiome(getBiomePosition());
    }

    /**
     * Gets the {@link BlockState} for this position.
     *
     * @return The block state
     */
    public BlockState getBlock() {
        return getWorld().getBlock(getBlockPosition());
    }

    /**
     * Gets the {@link FluidState} for this position.
     *
     * @return The fluid state
     */
    public FluidState getFluid() {
        return getWorld().getFluid(getBlockPosition());
    }

    /**
     * Checks for whether the block at this position contains tile entity data.
     *
     * @return True if the block at this position has tile entity data, false
     *      otherwise
     */
    public boolean hasTileEntity() {
        return getWorld().getTileEntity(getBlockPosition()).isPresent();
    }

    /**
     * Gets the associated {@link TileEntity} on this block.
     *
     * @return The associated tile entity, if available
     */
    public Optional<TileEntity> getTileEntity() {
        return getWorld().getTileEntity(getBlockPosition());
    }

    /**
     * Replace the block at this position with a new state.
     *
     * <p>This will remove any extended block data at the given position.</p>
     *
     * @param state The new block state
     * @return True if the block change was successful
     */
    public boolean setBlock(BlockState state) {
        return getWorld().setBlock(getBlockPosition(), state);
    }

    /**
     * Replace the block at this position with a new state.
     *
     * <p>This will remove any extended block data at the given position.</p>
     *  @param state The new block state
     * @param flag The various change flags controlling some interactions
     * @return True if the block change was successful
     */
    public boolean setBlock(BlockState state, BlockChangeFlag flag) {
        return getWorld().setBlock(getBlockPosition(), state, flag);
    }

    /**
     * Replace the block type at this position by a new type.
     *
     * <p>This will remove any extended block data at the given position.</p>
     *
     * @param type The new type
     * @return True if the block change was successful
     */
    public boolean setBlockType(BlockType type) {
        return getWorld().setBlock(getBlockPosition(), type.getDefaultState());
    }

    /**
     * Replace the block type at this position by a new type.
     *
     * <p>This will remove any extended block data at the given position.</p>
     * @param type The new type
     * @param flag The various change flags controlling some interactions
     * @return True if the block change was successful
     */
    public boolean setBlockType(BlockType type, BlockChangeFlag flag) {
        return getWorld().setBlock(getBlockPosition(), type.getDefaultState(), flag);
    }

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
    public boolean restoreSnapshot(BlockSnapshot snapshot, boolean force, BlockChangeFlag flag) {
        return getWorld().restoreSnapshot(getBlockPosition(), snapshot, force, flag);
    }

    /**
     * Remove the block at this position by replacing it with
     * {@link BlockTypes#AIR}.
     *
     * <p>This will remove any extended block data at the given position.</p>
     * @return True if the block change was successful
     */
    public boolean removeBlock() {
        return getWorld().removeBlock(getBlockPosition());
    }

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
    public Entity createEntity(EntityType type) {
        return this.getWorld().createEntity(type, this.getPosition());
    }

    /**
     * Spawns an {@link Entity} using the already set properties (world,
     * position, rotation) and applicable {@link DataManipulator}s with the
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
    public boolean spawnEntity(Entity entity) {
        return this.getWorld().spawnEntity(entity);
    }

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
    public Collection<Entity> spawnEntities(Iterable<? extends Entity> entities) {
        return this.getWorld().spawnEntities(entities);
    }

    /**
     * Gets the highest {@link Location} at this location.
     *
     * @return The highest location at this location
     * @see World#getHighestPositionAt(Vector3i)
     */
    public Location asHighestLocation() {
        return this.setBlockPosition(this.getWorld().getHighestPositionAt(getBlockPosition()));
    }

    @Override
    public <T extends DataManipulator<?, ?>> Optional<T> get(Class<T> containerClass) {
        return getWorld().get(getBlockPosition(), containerClass);
    }

    @Override
    public <T extends DataManipulator<?, ?>> Optional<T> getOrCreate(Class<T> containerClass) {
        return getWorld().getOrCreate(getBlockPosition(), containerClass);
    }

    @Override
    public boolean supports(Class<? extends DataManipulator<?, ?>> holderClass) {
        return getWorld().supports(getBlockPosition(), holderClass);
    }

    @Override
    public <E> DataTransactionResult offer(Key<? extends Value<E>> key, E value) {
        return getWorld().offer(getBlockPosition(), key, value);
    }

    @Override
    public DataTransactionResult offer(DataManipulator<?, ?> valueContainer, MergeFunction function) {
        return getWorld().offer(getBlockPosition(), valueContainer, function);
    }

    @Override
    public DataTransactionResult remove(Class<? extends DataManipulator<?, ?>> containerClass) {
        return getWorld().remove(getBlockPosition(), containerClass);
    }

    @Override
    public DataTransactionResult remove(Value<?> value) {
        return getWorld().remove(getBlockPosition(), value.getKey());
    }

    @Override
    public DataTransactionResult remove(Key<?> key) {
        return getWorld().remove(getBlockPosition(), key);
    }

    @Override
    public DataTransactionResult undo(DataTransactionResult result) {
        return getWorld().undo(getBlockPosition(), result);
    }

    @Override
    public DataTransactionResult copyFrom(DataHolder that, MergeFunction function) {
        return getWorld().copyFrom(getBlockPosition(), that, function);
    }

    @Override
    public Collection<DataManipulator<?, ?>> getContainers() {
        return getWorld().getManipulators(getBlockPosition());
    }

    /**
     * Gets a snapshot of this block at the current point in time.
     *
     * <p>A snapshot is disconnected from the {@link World} that it was taken
     * from so changes to the original block do not affect the snapshot.</p>
     *
     * @return A snapshot
     */
    public BlockSnapshot createSnapshot() {
        return getWorld().createSnapshot(getBlockPosition());
    }

    /**
     * Gets a list of {@link ScheduledUpdate}s for the block at this location.
     *
     * @return A list of scheduled block updates on this location
     */
    public Collection<ScheduledUpdate<BlockType>> getScheduledBlockUpdates() {
        return getWorld().getScheduledBlockUpdates().getScheduledAt(getBlockPosition());
    }

    /**
     * Adds a new {@link ScheduledUpdate} for the block at this location.
     *
     * @param delay The delay before the scheduled update should be processed
     * @param temporalUnit The temporal unit of the delay
     * @return The newly created scheduled update
     */
    public ScheduledUpdate<BlockType> scheduleBlockUpdate(int delay, TemporalUnit temporalUnit) {
        return getWorld().getScheduledBlockUpdates().schedule(getBlockPosition(), getBlock().getType(), delay, temporalUnit);
    }

    /**
     * Adds a new {@link ScheduledUpdate} for the block at this location.
     *
     * @param delay The delay before the scheduled update should be processed
     * @param temporalUnit The temporal unit of the delay
     * @param priority The priority of the scheduled update
     * @return The newly created scheduled update
     */
    public ScheduledUpdate<BlockType> scheduleBlockUpdate(int delay, TemporalUnit temporalUnit, TaskPriority priority) {
        return getWorld().getScheduledBlockUpdates().schedule(getBlockPosition(), getBlock().getType(), delay, temporalUnit, priority);
    }

    /**
     * Adds a new {@link ScheduledUpdate} for the block at this location.
     *
     * @param delay The delay before the scheduled update should be processed
     * @return The newly created scheduled update
     */
    public ScheduledUpdate<BlockType> scheduleBlockUpdate(Duration delay) {
        return getWorld().getScheduledBlockUpdates().schedule(getBlockPosition(), getBlock().getType(), delay);
    }

    /**
     * Adds a new {@link ScheduledUpdate} for the block at this location.
     *
     * @param delay The delay before the scheduled update should be processed
     * @param priority The priority of the scheduled update
     * @return The newly created scheduled update
     */
    public ScheduledUpdate<BlockType> scheduleBlockUpdate(Duration delay, TaskPriority priority) {
        return getWorld().getScheduledBlockUpdates().schedule(getBlockPosition(), getBlock().getType(), delay, priority);
    }

    /**
     * Gets a list of {@link ScheduledUpdate}s for the fluid at this location.
     *
     * @return A list of scheduled fluid updates on this location
     */
    public Collection<ScheduledUpdate<FluidType>> getScheduledFluidUpdates() {
        return getWorld().getScheduledFluidUpdates().getScheduledAt(getBlockPosition());
    }

    /**
     * Adds a new {@link ScheduledUpdate} for the fluid at this location.
     *
     * @param delay The delay before the scheduled update should be processed
     * @param temporalUnit The temporal unit of the delay
     * @return The newly created scheduled update
     */
    public ScheduledUpdate<FluidType> scheduleFluidUpdate(int delay, TemporalUnit temporalUnit) {
        return getWorld().getScheduledFluidUpdates().schedule(getBlockPosition(), getFluid().getType(), delay, temporalUnit);
    }

    /**
     * Adds a new {@link ScheduledUpdate} for the fluid at this location.
     *
     * @param delay The delay before the scheduled update should be processed
     * @param temporalUnit The temporal unit of the delay
     * @param priority The priority of the scheduled update
     * @return The newly created scheduled update
     */
    public ScheduledUpdate<FluidType> scheduleFluidUpdate(int delay, TemporalUnit temporalUnit, TaskPriority priority) {
        return getWorld().getScheduledFluidUpdates().schedule(getBlockPosition(), getFluid().getType(), delay, temporalUnit, priority);
    }

    /**
     * Adds a new {@link ScheduledUpdate} for the fluid at this location.
     *
     * @param delay The delay before the scheduled update should be processed
     * @return The newly created scheduled update
     */
    public ScheduledUpdate<FluidType> scheduleFluidUpdate(Duration delay) {
        return getWorld().getScheduledFluidUpdates().schedule(getBlockPosition(), getFluid().getType(), delay);
    }

    /**
     * Adds a new {@link ScheduledUpdate} for the fluid at this location.
     *
     * @param delay The delay before the scheduled update should be processed
     * @param priority The priority of the scheduled update
     * @return The newly created scheduled update
     */
    public ScheduledUpdate<FluidType> scheduleFluidUpdate(Duration delay, TaskPriority priority) {
        return getWorld().getScheduledFluidUpdates().schedule(getBlockPosition(), getFluid().getType(), delay, priority);
    }

    @Override
    public <V> Optional<V> getProperty(Property<V> property) {
        return getWorld().getProperty(getBlockPosition(), property);
    }

    @Override
    public OptionalInt getIntProperty(Property<Integer> property) {
        return getWorld().getIntProperty(getBlockPosition(), property);
    }

    @Override
    public OptionalDouble getDoubleProperty(Property<Double> property) {
        return getWorld().getDoubleProperty(getBlockPosition(), property);
    }

    @Override
    public Map<Property<?>, ?> getProperties() {
        return getWorld().getProperties(getBlockPosition());
    }

    @Override
    public <V> Optional<V> getProperty(Direction direction, Property<V> property) {
        return getWorld().getProperty(getBlockPosition(), direction, property);
    }

    @Override
    public OptionalInt getIntProperty(Direction direction, Property<Integer> property) {
        return getWorld().getIntProperty(getBlockPosition(), direction, property);
    }

    @Override
    public OptionalDouble getDoubleProperty(Direction direction, Property<Double> property) {
        return getWorld().getDoubleProperty(getBlockPosition(), direction, property);
    }

    @Override
    public boolean validateRawData(DataView container) {
        return getWorld().validateRawData(getBlockPosition(), container);
    }

    @Override
    public void setRawData(DataView container) throws InvalidDataException {
        getWorld().setRawData(getBlockPosition(), container);
    }

    @Override
    public int getContentVersion() {
        // 1 - Legacy Extent generic location that stored only block types and positions
        // 2 - World based locations that stores the position
        return 2;
    }

    @Override
    public DataContainer toContainer() {
        final DataContainer container = DataContainer.createNew();
        container.set(Queries.CONTENT_VERSION, getContentVersion());
        container.set(Queries.WORLD_ID, getWorld().getUniqueId().toString());
        container.set(Queries.POSITION_X, getX());
        container.set(Queries.POSITION_Y, getY());
        container.set(Queries.POSITION_Z, getZ());
        return container;
    }

    @Override
    public <E> Optional<E> get(Key<? extends Value<E>> key) {
        return getWorld().get(getBlockPosition(), key);
    }

    @Override
    public <E, V extends Value<E>> Optional<V> getValue(Key<V> key) {
        return getWorld().getValue(getBlockPosition(), key);
    }

    @Override
    public boolean supports(Key<?> key) {
        return getWorld().supports(getBlockPosition(), key);
    }

    @Override
    public Location copy() {
        return this;
    }

    @Override
    public Set<Key<?>> getKeys() {
        return getWorld().getKeys(getBlockPosition());
    }

    @Override
    public Set<Value.Immutable<?>> getValues() {
        return getWorld().getValues(getBlockPosition());
    }

    @Override
    public String toString() {
        final String name = getWorldIfAvailable().map(World::getName).orElse(null);
        return "Location{" + getPosition() + " in " + getWorldUniqueId() + (name == null ? "" : " (" + name + ")") + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Location)) {
            return false;
        }
        final Location other = (Location) obj;
        return other.worldUniqueId.equals(this.worldUniqueId) &&
                other.getPosition().equals(getPosition());
    }

    @Override
    public int hashCode() {
        int hash = this.hash;
        if (hash == 0) {
            this.hash = hash = Objects.hash(getWorldUniqueId(), getPosition());
        }
        return hash;
    }
}
