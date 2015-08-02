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
package org.spongepowered.api.entity;

import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.manipulator.TargetedLocationData;
import org.spongepowered.api.util.Identifiable;
import org.spongepowered.api.util.RelativePositions;
import org.spongepowered.api.world.Chunk;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.TeleportHelper;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.storage.WorldProperties;

import java.util.EnumSet;
import java.util.UUID;

/**
 * An entity is a Minecraft entity.
 *
 * <p>Examples of entities include:</p>
 *
 * <ul>
 *     <li>Zombies</li>
 *     <li>Sheep</li>
 *     <li>Players</li>
 *     <li>Dropped items</li>
 *     <li>Dropped experience points</li>
 *     <li>etc.</li>
 * </ul>
 *
 * <p>Blocks and items (when they are in inventories) are not entities.</p>
 */
public interface Entity extends Identifiable, DataHolder, DataSerializable {

    /**
     * Get the type of entity.
     *
     * @return The type of entity
     */
    EntityType getType();

    /**
     * Gets the current chunk this entity resides in.
     * 
     * @return The current chunk this entity resides in
     */
    Chunk getChunk();
    
    /**
     * Gets the current world this entity resides in.
     *
     * @return The current world this entity resides in
     */
    World getWorld();

    /**
     * Get the location of this entity.
     *
     * @return The location
     */
    Location getLocation();

    /**
     * Sets the location of this entity. This is equivalent to a teleport,
     * and also moves this entity's passengers.
     *
     * @param location The location to set
     */
    void setLocation(Location location);

    /**
     * Moves the entity to the specified location, and sets the rotation.
     *
     * <p>The format of the rotation is represented by:</p>
     *
     * <ul><code>x -> pitch</code>, <code>y -> yaw</code>, <code>z -> roll
     * </code></ul>
     *
     * @param location The location to set
     * @param rotation The rotation to set
     */
    void setLocationAndRotation(Location location, Vector3d rotation);

    /**
     * Moves the entity to the specified location, and sets the rotation. {@link RelativePositions}
     * listed inside the EnumSet are considered relative.
     *
     * <p>The format of the rotation is represented by:</p>
     *
     * <ul><code>x -> pitch</code>, <code>y -> yaw</code>, <code>z -> roll
     * </code></ul>
     *
     * @param location The location to set
     * @param rotation The rotation to set
     * @param relativePositions The coordinates to set relatively
     */
    void setLocationAndRotation(Location location, Vector3d rotation, EnumSet<RelativePositions> relativePositions);

    /**
     * Sets the location of this entity using a safe one from {@link TeleportHelper#getSafeLocation(Location)}. This is equivalent to a
     * teleport and also moves this entity's passengers.
     *
     * @param location The location to set
     * @return True if location was set successfully, false if location couldn't be set as no safe location was found
     */
    boolean setLocationSafely(Location location);

    /**
     * Sets the location using a safe one from {@link TeleportHelper#getSafeLocation(Location)} and the rotation of this entity.
     *
     * <p>The format of the rotation is represented by:</p>
     *
     * <ul><code>x -> pitch</code>, <code>y -> yaw</code>, <code>z -> roll
     * </code></ul>
     *
     * @param location The location to set
     * @param rotation The rotation to set
     * @return True if location was set successfully, false if location couldn't be set as no safe location was found
     */
    boolean setLocationAndRotationSafely(Location location, Vector3d rotation);

    /**
     * Sets the location using a safe one from
     * {@link TeleportHelper#getSafeLocation(Location)} and the rotation of this
     * entity. {@link RelativePositions} listed inside the EnumSet are
     * considered relative.
     *
     * <p>The format of the rotation is represented by:</p>
     *
     * <ul><code>x -> pitch</code>, <code>y -> yaw</code>, <code>z -> roll
     * </code></ul>
     *
     * @param location The location to set
     * @param rotation The rotation to set
     * @param relativePositions The coordinates to set relatively
     * @return True if location was set successfully, false if location
     *     couldn't be set as no safe location was found
     */
    boolean setLocationAndRotationSafely(Location location, Vector3d rotation, EnumSet<RelativePositions> relativePositions);

    /**
     * Sets the location of this entity to a new position in a world which does
     * not have to be loaded (but must at least be enabled).
     *
     * <p>If the target world is loaded then this is equivalent to
     * setting the location via {@link TargetedLocationData}.</p>
     *
     * <p>If the target world is unloaded but is enabled according to its
     * {@link WorldProperties#isEnabled()} then this will first load the world
     * before transferring the entity to that world.</p>
     *
     * <p>If the target world is unloaded and not enabled then the transfer
     * will fail.</p>
     *
     * @param worldName The name of the world to transfer to
     * @param position The position in the target world
     * @return True if the teleport was successful
     */
    boolean transferToWorld(String worldName, Vector3d position);

    /**
     * Sets the location of this entity to a new position in a world which does
     * not have to be loaded (but must at least be enabled).
     *
     * <p>If the target world is loaded then this is equivalent to
     * setting the location via {@link TargetedLocationData}.</p>
     *
     * <p>If the target world is unloaded but is enabled according to its
     * {@link WorldProperties#isEnabled()} then this will first load the world
     * before transferring the entity to that world.</p>
     *
     * <p>If the target world is unloaded and not enabled then the transfer
     * will fail.</p>
     *
     * @param uuid The UUID of the target world to transfer to
     * @param position The position in the target world
     * @return True if the teleport was successful
     */
    boolean transferToWorld(UUID uuid, Vector3d position);

    /**
     * Gets the rotation as a Vector3f.
     *
     * <p>The format of the rotation is represented by:</p>
     *
     * <ul><code>x -> pitch</code>, <code>y -> yaw</code>, <code>z -> roll
     * </code></ul>
     *
     * @return The rotation as a Vector3f
     */
    Vector3d getRotation();

    /**
     * Sets the rotation of this entity.
     *
     * <p>The format of the rotation is represented by:</p>
     *
     * <ul><code>x -> pitch</code>, <code>y -> yaw</code>, <code>z -> roll
     * </code></ul>
     *
     * @param rotation The rotation to set the entity to
     */
    void setRotation(Vector3d rotation);

    /**
     * Returns whether this entity is on the ground (not in the air) or not.
     *
     * @return Whether this entity is on the ground or not
     */
    boolean isOnGround();

    /**
     * Returns whether this entity has been removed.
     *
     * @return True if this entity has been removed
     */
    boolean isRemoved();

    /**
     * Returns whether this entity is still loaded in a world/chunk.
     *
     * @return True if this entity is still loaded
     */
    boolean isLoaded();

    /**
     * Mark this entity for removal in the very near future, preferably
     * within one game tick.
     */
    void remove();

}
