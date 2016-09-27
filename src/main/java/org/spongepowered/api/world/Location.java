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
import com.google.common.base.Objects;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.block.ScheduledBlockUpdate;
import org.spongepowered.api.block.tileentity.TileEntity;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.Property;
import org.spongepowered.api.data.Queries;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.merge.MergeFunction;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.entity.SpawnEntityEvent;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.biome.BiomeType;
import org.spongepowered.api.world.extent.EntityUniverse;
import org.spongepowered.api.world.extent.Extent;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

import javax.annotation.Nullable;

/**
 * A position within a particular {@link Extent}.
 *
 * <p>This class is primarily a helper class to represent a location in a
 * particular {@link Extent}. The methods provided are proxy methods to ones on
 * {@link Extent}.</p>
 *
 * <p>Each instance can be used to either represent a block or a location on a
 * continuous coordinate system. Internally, positions are stored using doubles.
 * When a block-related method is used, the components of the position are each
 * rounded to an integer.</p>
 *
 * <p>Locations are immutable. Methods that change the properties of the
 * location create a new instance.</p>
 *
 * @param <E> The type of extent containing this location
 */
public final class Location<E extends Extent> implements DataHolder {

    private final WeakReference<E> extent;
    // Lazily computed, either position or blockPosition is set by the constructor
    @Nullable
    private Vector3d position = null;
    @Nullable
    private Vector3i blockPosition = null;
    @Nullable
    private Vector3i chunkPosition = null;
    @Nullable
    private Vector3i biomePosition = null;

    /**
     * Create a new instance.
     *
     * @param extent The extent
     * @param position The position
     */
    public Location(E extent, Vector3d position) {
        this.extent = new WeakReference<>(checkNotNull(extent, "extent"));
        this.position = checkNotNull(position, "position");
    }

    /**
     * Create a new instance.
     *
     * @param extent The extent
     * @param x The X-axis position
     * @param y The Y-axis position
     * @param z The Z-axis position
     */
    public Location(E extent, double x, double y, double z) {
        this(extent, new Vector3d(x, y, z));
    }

    /**
     * Create a new instance.
     *
     * @param extent The extent
     * @param blockPosition The position
     */
    public Location(E extent, Vector3i blockPosition) {
        this.extent = new WeakReference<>(checkNotNull(extent, "extent"));
        this.blockPosition = checkNotNull(blockPosition, "blockPosition");
    }

    /**
     * Create a new instance.
     *
     * @param extent The extent
     * @param x The X-axis position
     * @param y The Y-axis position
     * @param z The Z-axis position
     */
    public Location(E extent, int x, int y, int z) {
        this(extent, new Vector3i(x, y, z));
    }

    /**
     * Gets the underlying extent.
     *
     * <p>Note: This can be null if the {@link Extent} is unloaded and garbage
     * collected.</p>
     *
     * @return The extent, if available
     * @throws IllegalStateException If the {@link Extent} is null
     */
    public E getExtent() {
        final E currentExtent = this.extent.get();
        if (currentExtent == null) {
            throw new IllegalStateException();
        }
        return currentExtent;
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
     * Returns true if this location is in the given extent. This is implemented
     * as an {@link Object#equals(Object)} check.
     *
     * @param extent The extent to check
     * @return Whether this location is in the extent
     */
    public boolean inExtent(Extent extent) {
        return getExtent().equals(extent);
    }

    /**
     * Returns true if this location has a biome at its
     * {@link #getBiomePosition()}.
     *
     * @return Whether or not there is a biome at this location.
     */
    public boolean hasBiome() {
        return getExtent().containsBiome(getBiomePosition());
    }

    /**
     * Returns true if this location has a block at its
     * {@link #getBlockPosition()} ()}.
     *
     * @return Whether or not there is a block at this location.
     */
    public boolean hasBlock() {
        return getExtent().containsBlock(getBlockPosition());
    }

    /**
     * Gets a {@link LocatableBlock} if the parent {@link Extent} of this
     * {@link Location} is a {@link World}.
     *
     * @return The locatable block of this location, if available
     */
    public Optional<LocatableBlock> getLocatableBlock() {
        return getExtent() instanceof World
               ? Optional.of(
                LocatableBlock
                        .builder()
                        .world((World) getExtent())
                        .position(this.getBlockPosition())
                        .build()
                )
               : Optional.empty();
    }

    /**
     * Create a new instance with a new extent.
     *
     * @param extent The new extent
     * @return A new instance
     */
    public Location<E> setExtent(E extent) {
        checkNotNull(extent, "extent");
        if (extent == getExtent()) {
            return this;
        }
        return new Location<>(extent, getPosition());
    }

    /**
     * Create a new instance with a new position.
     *
     * @param position The new position
     * @return A new instance
     */
    public Location<E> setPosition(Vector3d position) {
        checkNotNull(position, "position");
        if (position == getPosition()) {
            return this;
        }
        return new Location<>(getExtent(), position);
    }

    /**
     * Create a new instance with a new block position.
     *
     * @param position The new position
     * @return A new instance
     */
    public Location<E> setBlockPosition(Vector3i position) {
        checkNotNull(position, "position");
        if (position == getBlockPosition()) {
            return this;
        }
        return new Location<>(getExtent(), position);
    }

    /**
     * Subtract another Vector3d to the position on this instance, returning
     * a new Location instance.
     *
     * @param v The vector to subtract
     * @return A new instance
     */
    public Location<E> sub(Vector3d v) {
        return sub(v.getX(), v.getY(), v.getZ());
    }

    /**
     * Subtract another Vector3i to the position on this instance, returning
     * a new Location instance.
     *
     * @param v The vector to subtract
     * @return A new instance
     */
    public Location<E> sub(Vector3i v) {
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
    public Location<E> sub(double x, double y, double z) {
        return setPosition(getPosition().sub(x, y, z));
    }

    /**
     * Add another Vector3d to the position on this instance, returning a new
     * Location instance.
     *
     * @param v The vector to add
     * @return A new instance
     */
    public Location<E> add(Vector3d v) {
        return add(v.getX(), v.getY(), v.getZ());
    }

    /**
     * Add another Vector3i to the position on this instance, returning a new
     * Location instance.
     *
     * @param v The vector to add
     * @return A new instance
     */
    public Location<E> add(Vector3i v) {
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
    public Location<E> add(double x, double y, double z) {
        return setPosition(getPosition().add(x, y, z));
    }

    /**
     * Calls the mapper function on the extent and position.
     *
     * @param mapper The mapper
     * @param <T> The return type of the mapper
     * @return The results of the mapping
     */
    public <T> T map(BiFunction<E, Vector3d, T> mapper) {
        return mapper.apply(getExtent(), getPosition());
    }

    /**
     * Calls the mapper function on the extent and block position.
     *
     * @param mapper The mapper
     * @param <T> The return type of the mapper
     * @return The results of the mapping
     */
    public <T> T mapBlock(BiFunction<E, Vector3i, T> mapper) {
        return mapper.apply(getExtent(), getBlockPosition());
    }

    /**
     * Calls the mapper function on the extent and chunk position.
     *
     * @param mapper The mapper
     * @param <T> The return type of the mapper
     * @return The results of the mapping
     */
    public <T> T mapChunk(BiFunction<E, Vector3i, T> mapper) {
        return mapper.apply(getExtent(), getChunkPosition());
    }

    /**
     * Calls the mapper function on the extent and biome position.
     *
     * @param mapper The mapper
     * @param <T> The return type of the mapper
     * @return The results of the mapping
     */
    public <T> T mapBiome(BiFunction<E, Vector3i, T> mapper) {
        return mapper.apply(getExtent(), getBiomePosition());
    }

    /**
     * Gets the location next to this one in the given direction.
     * Always moves by a unit amount, even diagonally.
     *
     * @param direction The direction to move in
     * @return The location in that direction
     */
    public Location<E> getRelative(Direction direction) {
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
    public Location<E> getBlockRelative(Direction direction) {
        checkArgument(!direction.isSecondaryOrdinal(), "Secondary cardinal directions can't be used here");
        return add(direction.asBlockOffset());
    }

    /**
     * Gets the block at this location.
     *
     * @return The biome at this location
     */
    public BiomeType getBiome() {
        return getExtent().getBiome(getBiomePosition());
    }

    /**
     * Gets the base type of block.
     *
     * <p>The type does not include block data such as the contents of
     * inventories.</p>
     *
     * @return The type of block
     */
    public BlockType getBlockType() {
        return getExtent().getBlockType(getBlockPosition());
    }

    /**
     * Gets the {@link BlockState} for this position.
     *
     * @return The block state
     */
    public BlockState getBlock() {
        return getExtent().getBlock(getBlockPosition());
    }

    /**
     * Checks for whether the block at this position contains tile entity data.
     *
     * @return True if the block at this position has tile entity data, false
     *      otherwise
     */
    public boolean hasTileEntity() {
        return getExtent().getTileEntity(getBlockPosition()).isPresent();
    }

    /**
     * Gets the associated {@link TileEntity} on this block.
     *
     * @return The associated tile entity, if available
     */
    public Optional<TileEntity> getTileEntity() {
        return getExtent().getTileEntity(getBlockPosition());
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
        return getExtent().setBlock(getBlockPosition(), state);
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
        return getExtent().setBlock(getBlockPosition(), state, flag);
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
        return getExtent().setBlockType(getBlockPosition(), type);
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
        return getExtent().setBlockType(getBlockPosition(), type, flag);
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
        return getExtent().restoreSnapshot(getBlockPosition(), snapshot, force, flag);
    }

    /**
     * Remove the block at this position by replacing it with
     * {@link BlockTypes#AIR}.
     *
     * <p>This will remove any extended block data at the given position.</p>
     * @return True if the block change was successful
     */
    @SuppressWarnings("ConstantConditions")
    public boolean removeBlock() {
        return getExtent().setBlockType(getBlockPosition(), BlockTypes.AIR, BlockChangeFlag.ALL);
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
     * @see EntityUniverse#createEntity(EntityType, Vector3d)
     */
    public Entity createEntity(EntityType type) {
        return this.getExtent().createEntity(type, this.getPosition());
    }

    // TODO change this cause advisory
    /**
     * Spawns an {@link Entity} using the already set properties (extent,
     * position, rotation) and applicable {@link DataManipulator}s with the
     * specified {@link Cause} for spawning the entity.
     *
     * <p>Note that for the {@link Cause} to be useful in the expected
     * {@link SpawnEntityEvent}, a {@link SpawnCause} should be provided in the
     * {@link Cause} for other plugins to understand and have finer control over
     * the event.</p>
     *
     * <p>The requirements involve that all necessary setup of states and data
     * is already preformed on the entity retrieved from the various
     * {@link EntityUniverse#createEntity(EntityType,Vector3d)} methods. Calling
     * this will make the now-spawned entity able to be processed by various
     * systems.</p>
     *
     * <p>If the entity was unable to spawn, the entity is not removed, but it
     * should be taken note that there can be many reasons for a failure.</p>
     *
     * @param entity The entity to spawn
     * @return True if successful, false if not
     * @see EntityUniverse#spawnEntity(Entity)
     */
    public boolean spawnEntity(Entity entity) {
        return this.getExtent().spawnEntity(entity);
    }

    /**
     * Similar to {@link #spawnEntity(Entity, Cause)} except where multiple
     * entities can be attempted to be spawned with a customary {@link Cause}.
     * The recommended use is to easily process the entity spawns without
     * interference with the cause tracking system.
     *
     * @param entities The entities to be spawned
     * @return True if any of the entities were successfully spawned
     * @see EntityUniverse#spawnEntities(Iterable, Cause)
     */
    public boolean spawnEntities(Iterable<? extends Entity> entities) {
        return this.getExtent().spawnEntities(entities);
    }

    /**
     * Gets the highest {@link Location} at this location.
     *
     * @return The highest location at this location
     * @see Extent#getHighestPositionAt(Vector3i)
     */
    public Location<E> asHighestLocation() {
        return this.setBlockPosition(this.getExtent().getHighestPositionAt(getBlockPosition()));
    }

    @Override
    public DataTransactionResult remove(Class<? extends DataManipulator<?, ?>> containerClass) {
        return getExtent().remove(getBlockPosition(), containerClass);
    }

    @Override
    public DataTransactionResult remove(BaseValue<?> value) {
        return getExtent().remove(getBlockPosition(), value.getKey());
    }

    @Override
    public DataTransactionResult remove(Key<?> key) {
        return getExtent().remove(getBlockPosition(), key);
    }

    /**
     * Gets a snapshot of this block at the current point in time.
     *
     * <p>A snapshot is disconnected from the {@link Extent} that it was taken
     * from so changes to the original block do not affect the snapshot.</p>
     *
     * @return A snapshot
     */
    public BlockSnapshot createSnapshot() {
        return getExtent().createSnapshot(getBlockPosition());
    }

    /**
     * Gets a list of {@link ScheduledBlockUpdate}s on this block.
     *
     * @return A list of ScheduledBlockUpdates on this block
     */
    public Collection<ScheduledBlockUpdate> getScheduledUpdates() {
        return getExtent().getScheduledUpdates(getBlockPosition());
    }

    /**
     * Adds a new {@link ScheduledBlockUpdate} to this block.
     *
     * @param priority The priority of the scheduled update
     * @param ticks The ticks until the scheduled update should be processed
     * @return The newly created scheduled update
     */
    public ScheduledBlockUpdate addScheduledUpdate(int priority, int ticks) {
        return getExtent().addScheduledUpdate(getBlockPosition(), priority, ticks);
    }

    /**
     * Removes a {@link ScheduledBlockUpdate} from this block.
     *
     * @param update The ScheduledBlockUpdate to remove
     */
    public void removeScheduledUpdate(ScheduledBlockUpdate update) {
        getExtent().removeScheduledUpdate(getBlockPosition(), update);
    }

    @Override
    public <T extends Property<?, ?>> Optional<T> getProperty(Class<T> propertyClass) {
        return getExtent().getProperty(getBlockPosition(), propertyClass);
    }

    @Override
    public Collection<Property<?, ?>> getApplicableProperties() {
        return getExtent().getProperties(getBlockPosition());
    }

    @Override
    public boolean validateRawData(DataView container) {
        return getExtent().validateRawData(getBlockPosition(), container);
    }

    @Override
    public void setRawData(DataView container) throws InvalidDataException {
        getExtent().setRawData(getBlockPosition(), container);
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    @Override
    public DataContainer toContainer() {
        final DataContainer container = DataContainer.createNew();
        container.set(Queries.CONTENT_VERSION, getContentVersion());
        if (getExtent() instanceof World) {
            container.set(Queries.WORLD_NAME, ((World) getExtent()).getName());
            container.set(Queries.WORLD_ID, getExtent().getUniqueId().toString());
        } else if (getExtent() instanceof Chunk) {
            container.set(Queries.CHUNK_X, ((Chunk) getExtent()).getPosition().getX())
                .set(Queries.CHUNK_Y, ((Chunk) getExtent()).getPosition().getY())
                .set(Queries.CHUNK_Z, ((Chunk) getExtent()).getPosition().getZ())
                .set(Queries.WORLD_NAME, ((Chunk) getExtent()).getWorld().getName())
                .set(Queries.WORLD_ID, ((Chunk) getExtent()).getWorld().getUniqueId().toString());
        }
        container.set(Queries.BLOCK_TYPE, this.getExtent().getBlockType(getBlockPosition()).getId())
            .set(Queries.POSITION_X, this.getX())
            .set(Queries.POSITION_Y, this.getY())
            .set(Queries.POSITION_Z, this.getZ());
        return container;
    }

    @Override
    public <T extends DataManipulator<?, ?>> Optional<T> get(Class<T> containerClass) {
        return getExtent().get(getBlockPosition(), containerClass);
    }

    @Override
    public <T> Optional<T> get(Key<? extends BaseValue<T>> key) {
        return getExtent().get(getBlockPosition(), key);
    }

    @Override
    public <T extends DataManipulator<?, ?>> Optional<T> getOrCreate(Class<T> containerClass) {
        return getExtent().getOrCreate(getBlockPosition(), containerClass);
    }

    @Override
    public <T> DataTransactionResult offer(Key<? extends BaseValue<T>> key, T value) {
        return getExtent().offer(getBlockPosition(), key, value);
    }

    @Override
    public DataTransactionResult offer(Iterable<DataManipulator<?, ?>> valueHolders) {
        return getExtent().offer(getBlockPosition(), valueHolders);
    }

    @Override
    public DataTransactionResult offer(Iterable<DataManipulator<?, ?>> values, MergeFunction function) {
        return getExtent().offer(getBlockPosition(), values, function);
    }

    @Override
    public <T> DataTransactionResult offer(BaseValue<T> value) {
        return getExtent().offer(getBlockPosition(), value);
    }

    @Override
    public DataTransactionResult offer(DataManipulator<?, ?> valueContainer) {
        return getExtent().offer(getBlockPosition(), valueContainer);
    }

    @Override
    public DataTransactionResult offer(DataManipulator<?, ?> valueContainer, MergeFunction function) {
        return getExtent().offer(getBlockPosition(), valueContainer, function);
    }

    @Override
    public DataTransactionResult undo(DataTransactionResult result) {
        return getExtent().undo(getBlockPosition(), result);
    }

    @Override
    public boolean supports(Class<? extends DataManipulator<?, ?>> holderClass) {
        return getExtent().supports(getBlockPosition(), holderClass);
    }

    @Override
    public boolean supports(Key<?> key) {
        return getExtent().supports(getBlockPosition(), key);
    }

    @Override
    public <T> DataTransactionResult transform(Key<? extends BaseValue<T>> key, Function<T, T> function) {
        return getExtent().transform(getBlockPosition(), key, function);
    }

    @Override
    public DataTransactionResult copyFrom(DataHolder that) {
        return getExtent().copyFrom(getBlockPosition(), that);
    }

    @Override
    public DataTransactionResult copyFrom(DataHolder that, MergeFunction strategy) {
        return getExtent().copyFrom(getBlockPosition(), that, strategy);
    }

    @Override
    public Collection<DataManipulator<?, ?>> getContainers() {
        return getExtent().getManipulators(getBlockPosition());
    }

    @Override
    public <T, V extends BaseValue<T>> Optional<V> getValue(Key<V> key) {
        return getExtent().getValue(getBlockPosition(), key);
    }

    @Override
    public Location<E> copy() {
        return new Location<>(getExtent(), getPosition());
    }

    @Override
    public Set<Key<?>> getKeys() {
        return getExtent().getKeys(getBlockPosition());
    }

    @Override
    public Set<ImmutableValue<?>> getValues() {
        return getExtent().getValues(getBlockPosition());
    }

    @Override
    public String toString() {
        return "Location{" + getPosition() + " in " + getExtent() + "}";
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getExtent(), getPosition());
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Location<?>)) {
            return false;
        }
        Location<?> otherLoc = (Location<?>) other;
        return otherLoc.getExtent().equals(getExtent())
            && otherLoc.getPosition().equals(getPosition());
    }

}
