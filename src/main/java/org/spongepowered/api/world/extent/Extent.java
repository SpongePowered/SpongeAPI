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
package org.spongepowered.api.world.extent;

import static com.google.common.base.Preconditions.checkNotNull;

import com.flowpowered.math.vector.Vector2i;
import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.ScheduledBlockUpdate;
import org.spongepowered.api.data.property.LocationBasePropertyHolder;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.util.AABB;
import org.spongepowered.api.util.Identifiable;
import org.spongepowered.api.util.PositionOutOfBoundsException;
import org.spongepowered.api.world.BlockChangeFlag;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.extent.worker.MutableBiomeVolumeWorker;
import org.spongepowered.api.world.extent.worker.MutableBlockVolumeWorker;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Nullable;

/**
 * A mutable object containing blocks, tile entities, entities, and possibly
 * other game objects.
 */
public interface Extent extends EntityUniverse, TileEntityVolume, InteractableVolume, MutableBiomeVolume, LocationCompositeValueStore, Identifiable,
    LocationBasePropertyHolder {

    /**
     * Gets a location in this extent at the given position. Essentially, this
     * is a 3D pointer in the extent.
     *
     * @param position The position
     * @return The location in this extent
     */
    Location<? extends Extent> getLocation(Vector3i position);

    /**
     * Gets a location in this extent at the given position. Essentially, this
     * is a 3D pointer in the extent.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return The location in this extent
     */
    default Location<? extends Extent> getLocation(int x, int y, int z) {
        return getLocation(new Vector3i(x, y, z));
    }

    /**
     * Gets a location in this extent at the given position. Essentially, this
     * is a 3D pointer in the extent. This method supports sub-block positions.
     * Block-related methods use flooring to get integer coordinates.
     *
     * @param position The position
     * @return The location in this extent
     */
    Location<? extends Extent> getLocation(Vector3d position);

    /**
     * Gets a location in this extent at the given position. Essentially, this
     * is a 3D pointer in the extent. This method supports sub-block positions.
     * Block-related methods use flooring to get integer coordinates.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return The location in this extent
     */
    default Location<? extends Extent> getLocation(double x, double y, double z) {
        return getLocation(new Vector3i(x, y, z));
    }

    /**
     * Get the y value of the highest block that sunlight can reach in the given
     * column.
     *
     * <p>This method ignores all transparent blocks, providing the highest
     * opaque block.</p>
     *
     * @return The y value of the highest opaque block
     */
    int getHighestYAt(int x, int z);

    /**
     * Get the y value of the highest block that sunlight can reach in the given
     * column.
     *
     * <p>This method ignores all transparent blocks, providing the highest
     * opaque block.</p>
     *
     * @return The y value of the highest opaque block
     */
    default int getHighestYAt(Vector2i column) {
        return this.getHighestYAt(column.getX(), column.getY());
    }

    /**
     * Get the {@link Location} of the highest block that sunlight can reach in
     * the given column.
     *
     * <p>This method ignores all transparent blocks, providing the highest
     * opaque block.</p>
     *
     * @param position The column position
     * @return The highest opaque position
     */
    default Vector3i getHighestPositionAt(Vector3i position) {
        return new Vector3i(position.getX(), getHighestYAt(position.getX(), position.getZ()), position.getZ());
    }

    /**
     * Returns the y level that precipitation ends falling in the given column.
     *
     * <p>A value is still returned for columns in biomes which do not
     * receive precipitation.</p>
     *
     * @return The y level that precipitation ends
     */
    int getPrecipitationLevelAt(int x, int z);

    /**
     * Returns the y level that precipitation ends falling in the given column.
     *
     * <p>A value is still returned for columns in biomes which do not
     * receive precipitation.</p>
     *
     * @return The y level that precipitation ends
     */
    default int getPrecipitationLevelAt(Vector2i column) {
        return this.getPrecipitationLevelAt(column.getX(), column.getY());
    }

    /**
     * Returns the position that precipitation ends falling in the column
     * of the given position.
     *
     * <p>A position is still returned for positions in biomes which do not
     * receive precipitation.</p>
     *
     * @return The position that precipitation ends
     */
    default Vector3i getPrecipitationLevelAt(Vector3i position) {
        return new Vector3i(position.getX(), this.getPrecipitationLevelAt(position.getX(), position.getZ()), position.getZ());
    }

    /**
     * Sets the block at the given position in the world with the provided
     * {@link Cause} will be used for any events thrown. Note that the
     * difference between this an {@link MutableBlockVolume#setBlock(Vector3i, BlockState, Cause)} is
     * that no block tracking chaining will take place. Note that there is
     * a requirement that the {@link PluginContainer} of the plugin calling
     * this method is <strong>REQUIRED</strong>.
     *
     * @param position The position
     * @param blockState The block
     * @param flag The various change flags controlling some interactions
     * @param cause The cause to use
     * @return Whether the block change was successful
     * @throws PositionOutOfBoundsException If the position is outside of the
     *         bounds of the volume
     */
    default boolean setBlock(Vector3i position, BlockState blockState, BlockChangeFlag flag, Cause cause) {
        return setBlock(position.getX(), position.getY(), position.getZ(), blockState, flag, cause);
    }

    /**
     * Sets the block at the given position in the world with the provided
     * {@link Cause} will be used for any events thrown. Note that the
     * difference between this an {@link MutableBlockVolume#setBlock(Vector3i, BlockState, Cause)} is
     * that no block tracking chaining will take place. Note that there is
     * a requirement that the {@link PluginContainer} of the plugin calling
     * this method is <strong>REQUIRED</strong>.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param blockState The block
     * @param flag The various change flags controlling some interactions
     * @param cause The cause to use
     * @return Whether the block change was successful
     * @throws PositionOutOfBoundsException If the position is outside of the
     *         bounds of the volume
     */
    boolean setBlock(int x, int y, int z, BlockState blockState, BlockChangeFlag flag, Cause cause);

    /**
     * Sets the block at the given position in the world with the provided
     * {@link Cause} will be used for any events thrown. Note that the
     * difference between this an {@link MutableBlockVolume#setBlockType(Vector3i, BlockType, Cause)} is
     * that no block tracking chaining will take place. Note that there is
     * a requirement that the {@link PluginContainer} of the plugin calling
     * this method is <strong>REQUIRED</strong>.
     *
     * @param position The position
     * @param type The block type
     * @param flag The various change flags controlling some interactions
     * @param cause The cause to use
     * @return Whether the block change was successful
     * @throws PositionOutOfBoundsException If the position is outside of the
     *         bounds of the volume
     */
    default boolean setBlockType(Vector3i position, BlockType type, BlockChangeFlag flag, Cause cause) {
        return setBlock(position.getX(), position.getY(), position.getZ(), type.getDefaultState(), flag, cause);
    }

    /**
     * Sets the block at the given position in the world with the provided
     * {@link Cause} will be used for any events thrown. Note that the
     * difference between this an {@link MutableBlockVolume#setBlockType(Vector3i, BlockType, Cause)} is
     * that no block tracking chaining will take place. Note that there is
     * a requirement that the {@link PluginContainer} of the plugin calling
     * this method is <strong>REQUIRED</strong>.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param type The block
     * @param flag The various change flags controlling some interactions
     * @param cause The cause to use
     * @return Whether the block change was successful
     * @throws PositionOutOfBoundsException If the position is outside of the
     *         bounds of the volume
     */
    default boolean setBlockType(int x, int y, int z, BlockType type, BlockChangeFlag flag, Cause cause) {
        return setBlock(x, y, z, type.getDefaultState(), flag, cause);
    }

    /**
     * Gets a snapshot of this block at the current point in time.
     *
     * <p>A snapshot is disconnected from the {@link Extent} that it was taken
     * from so changes to the original block do not affect the snapshot.</p>
     *
     * @param position The position of the block
     * @return A snapshot
     */
    default BlockSnapshot createSnapshot(Vector3i position) {
        return createSnapshot(position.getX(), position.getY(), position.getZ());
    }

    /**
     * Gets a snapshot of this block at the current point in time.
     *
     * <p>A snapshot is disconnected from the {@link Extent} that it was taken
     * from so changes to the original block do not affect the snapshot.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
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
     * @param cause The cause of the snapshot restore
     * @return true if the restore was successful, false otherwise
     */
    boolean restoreSnapshot(BlockSnapshot snapshot, boolean force, BlockChangeFlag flag, Cause cause);

    /**
     * Restores the {@link BlockSnapshot} at the given position.
     *
     * <p>If forced, the state of the block will change its {@link BlockType} to
     * match that of the snapshot then set the state. However, if force is set
     * to false and the {@link BlockType}s does not match, false will be
     * returned. If notifyNeighbors is true, neighboring blocks will be notified
     * of changes at the restored block location triggering physic updates.</p>
     *
     * @param position The position of the block
     * @param snapshot The snapshot
     * @param force If true, forces block state to be set even if the
     *        {@link BlockType} does not match the snapshot one.
     * @param flag The various change flags controlling some interactions
     * @param cause The cause of this operation
     * @return true if the restore was successful, false otherwise
     */
    default boolean restoreSnapshot(Vector3i position, BlockSnapshot snapshot, boolean force, BlockChangeFlag flag, Cause cause) {
        return restoreSnapshot(position.getX(), position.getY(), position.getZ(), snapshot, force, flag, cause);
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
     * @param cause The cause of the snapshot restore
     * @return true if the restore was successful, false otherwise
     */
    boolean restoreSnapshot(int x, int y, int z, BlockSnapshot snapshot, boolean force, BlockChangeFlag flag, Cause cause);

    /**
     * Gets a list of {@link ScheduledBlockUpdate}s on this block.
     *
     * @param position The position of the block
     * @return A list of ScheduledBlockUpdates on this block
     */
    default Collection<ScheduledBlockUpdate> getScheduledUpdates(Vector3i position) {
        return getScheduledUpdates(position.getX(), position.getY(), position.getZ());
    }

    /**
     * Gets a list of {@link ScheduledBlockUpdate}s on this block.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return A list of ScheduledBlockUpdates on this block
     */
    Collection<ScheduledBlockUpdate> getScheduledUpdates(int x, int y, int z);

    /**
     * Adds a new {@link ScheduledBlockUpdate} to this block.
     *
     * @param position The position of the block
     * @param priority The priority of the scheduled update
     * @param ticks The ticks until the scheduled update should be processed
     * @return The newly created scheduled update
     */
    default ScheduledBlockUpdate addScheduledUpdate(Vector3i position, int priority, int ticks) {
        return addScheduledUpdate(position.getX(), position.getY(), position.getZ(), priority, ticks);
    }

    /**
     * Adds a new {@link ScheduledBlockUpdate} to this block.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param priority The priority of the scheduled update
     * @param ticks The ticks until the scheduled update should be processed
     * @return The newly created scheduled update
     */
    ScheduledBlockUpdate addScheduledUpdate(int x, int y, int z, int priority, int ticks);

    /**
     * Removes a {@link ScheduledBlockUpdate} from this block.
     *
     * @param position The position of the block
     * @param update The ScheduledBlockUpdate to remove
     */
    default void removeScheduledUpdate(Vector3i position, ScheduledBlockUpdate update) {
        removeScheduledUpdate(position.getX(), position.getY(), position.getZ(), update);
    }

    /**
     * Removes a {@link ScheduledBlockUpdate} from this block.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param update The ScheduledBlockUpdate to remove
     */
    void removeScheduledUpdate(int x, int y, int z, ScheduledBlockUpdate update);

    /**
     * Gets whether or not this extent is currently loaded.
     *
     * @return Whether or not this extent is loaded
     */
    boolean isLoaded();

    /**
     * Returns a new extent that is the same or smaller than the current extent.
     * This does not copy the data, it only provides a new view of the extent.
     *
     * @param newMin The new minimum coordinates in this extent
     * @param newMax The new maximum coordinates in this extent
     * @return The new extent with the new bounds
     * @throws PositionOutOfBoundsException If the new minimum and maximum are
     *         outside the current extent
     */
    Extent getExtentView(Vector3i newMin, Vector3i newMax);

    @Override
    MutableBiomeVolumeWorker<? extends Extent> getBiomeWorker();

    @Override
    MutableBlockVolumeWorker<? extends Extent> getBlockWorker(Cause cause);

    /**
     * Gets the {@link UUID}, if available, of the user who created the
     * {@link BlockSnapshot} at passed block position.
     *
     * @param pos The position to be checked
     * @return The {@link UUID} if one exists
     */
    default Optional<UUID> getCreator(Vector3i pos) {
        return getCreator(pos.getX(), pos.getY(), pos.getZ());
    }

    /**
     * Gets the {@link UUID}, if available, of the user who created the
     * {@link BlockSnapshot} at passed block position.
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param z The z coordinate
     * @return The {@link UUID} if one exists
     */
    Optional<UUID> getCreator(int x, int y, int z);

    /**
     * Gets the {@link UUID}, if available, of the user who last notified the
     * {@link BlockSnapshot} located at passed block position.
     *
     * @param pos The position to be checked
     * @return The {@link UUID} if one exists
     */
    default Optional<UUID> getNotifier(Vector3i pos) {
        return getNotifier(pos.getX(), pos.getY(), pos.getZ());
    }

    /**
     * Gets the {@link UUID}, if available, of the user who last notified the
     * {@link BlockSnapshot} located at passed block coordinates.
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param z The z coordinate
     * @return The {@link UUID} if available
     */
    Optional<UUID> getNotifier(int x, int y, int z);

    /**
     * Sets the {@link UUID} of the user who created the {@link BlockSnapshot}
     * located at passed block position.
     *
     * @param pos The block position where the user data should be applied
     * @param uuid The {@link UUID} to set as creator
     */
    default void setCreator(Vector3i pos, @Nullable UUID uuid) {
        setCreator(pos.getX(), pos.getY(), pos.getZ(), uuid);
    }

    /**
     * Sets the {@link UUID} of the user who created the {@link BlockSnapshot}
     * located at passed block coordinates.
     *
     * @param x The x coordinate where the user data should be applied
     * @param y The y coordinate where the user data should be applied
     * @param z The z coordinate where the user data should be applied
     * @param uuid The {@link UUID} to set as creator
     */
    void setCreator(int x, int y, int z, @Nullable UUID uuid);

    /**
     * Sets the {@link UUID} of the user who last notified the
     * {@link BlockSnapshot} located at passed block position.
     *
     * @param pos The block position where the user data should be applied
     * @param uuid The {@link UUID} to set as notifier
     */
    default void setNotifier(Vector3i pos, @Nullable UUID uuid) {
        setNotifier(pos.getX(), pos.getY(), pos.getZ(), uuid);
    }

    /**
     * Sets the {@link UUID} of the user who last notified the
     * {@link BlockSnapshot} located at passed block coordinates.
     *
     * @param x The x coordinate where the user data should be applied
     * @param y The y coordinate where the user data should be applied
     * @param z The z coordinate where the user data should be applied
     * @param uuid The {@link UUID} to set as notifier
     */
    void setNotifier(int x, int y, int z, @Nullable UUID uuid);

    /**
     * Gets the bounding box used to select blocks, which appears
     * as a black outline on a vanilla client.
     *
     * @param pos The position of the block from which to get the selection box
     * @return The selection box
     */
    default Optional<AABB> getBlockSelectionBox(Vector3i pos) {
        checkNotNull(pos, "pos");
        return getBlockSelectionBox(pos.getX(), pos.getY(), pos.getZ());
    }

    /**
     * Gets the bounding box used to select blocks, which appears
     * as a black outline on a vanilla client.
     *
     * @param x The x coord of the block from which to get the selection box
     * @param y The y coord of the block from which to get the selection box
     * @param z The z coord of the block from which to get the selection box
     * @return The selection box
     */
    Optional<AABB> getBlockSelectionBox(int x, int y, int z);

    /**
     * Gets all the block collision boxes that intersect the bounding box, in
     * no particular order. There may be more than one box per block.
     *
     * @param box The intersection box
     * @return All the intersecting block collision boxes
     */
    Set<AABB> getIntersectingBlockCollisionBoxes(AABB box);

    /**
     * Gets all the collision boxes that intersect the bounding box owned by
     * the entity, in no particular order. There may be more than one box per
     * block. This also includes entities. Will return an empty set if the
     * owner does not have a bounding box.
     *
     * @param owner The entity that owns the bounding box
     * @return All the intersecting collision boxes
     */
    default Set<AABB> getIntersectingCollisionBoxes(Entity owner) {
        checkNotNull(owner, "owner");
        return owner.getBoundingBox()
            .map(box -> getIntersectingCollisionBoxes(owner, box))
            .orElse(Collections.emptySet());
    }

    /**
     * Gets all the collision boxes that intersect the bounding box owned by
     * the entity, in no particular order. There may be more than one box per
     * block. This also includes entities.
     *
     * @param owner The entity that owns the bounding box
     * @param box The intersection box
     * @return All the intersecting collision boxes
     */
    Set<AABB> getIntersectingCollisionBoxes(Entity owner, AABB box);

    /**
     * Creates a new archetype volume from the specified section of this extent.
     * The archetype's volume will be shifted such that the position given in
     * the origin will be the origin of the volume.
     *
     * @param min The minimum point of the volume to copy
     * @param max The maximum point of the volume to copy
     * @param origin The eventual origin on the new archetype volume
     * @return The archetype volume
     */
    ArchetypeVolume createArchetypeVolume(Vector3i min, Vector3i max, Vector3i origin);

}
