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

import static com.google.common.base.Preconditions.checkNotNull;

import com.flowpowered.math.vector.Vector3d;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.text.translation.Translatable;
import org.spongepowered.api.util.AABB;
import org.spongepowered.api.util.Identifiable;
import org.spongepowered.api.util.RandomProvider;
import org.spongepowered.api.util.RelativePositions;
import org.spongepowered.api.util.Transform;
import org.spongepowered.api.world.Locatable;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.TeleportHelper;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.schematic.Schematic;

import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

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
public interface Entity extends Identifiable, Locatable, DataHolder, Translatable, RandomProvider {

    /**
     * Gets the {@link EntityType}.
     *
     * @return The type
     */
    EntityType getType();

    /**
     * Creates an {@link EntitySnapshot}.
     *
     * @return The snapshot
     */
    EntitySnapshot createSnapshot();

    /**
     * Creates an {@link EntityArchetype} for use with {@link Schematic}s.
     *
     * @return The archetype
     */
    EntityArchetype createArchetype();

    /**
     * Sets the location of this entity.
     *
     * @param location The location to set
     * @return True if location was set successfully, false otherwise
     */
    boolean setLocation(Location location);

    /**
     * Sets the location of this entity using a safe one from
     * {@link TeleportHelper#getSafeLocation(Location)}.
     *
     * @param location The location to set
     * @return True if location was set successfully, false if location couldn't
     *      be set as no safe location was found
     */
    default boolean setLocationSafely(Location location) {
        return Sponge.getGame().getTeleportHelper()
                .getSafeLocation(location)
                .map(this::setLocation)
                .orElse(false);
    }

    /**
     * Gets the rotation.
     *
     * <p>The format of the rotation is represented by:</p>
     *
     * <p>{@code x -> pitch}, {@code y -> yaw}, {@code z -> roll}</p>
     *
     * @return The rotation
     */
    Vector3d getRotation();

    /**
     * Sets the rotation of this entity.
     *
     * <p>The format of the rotation is represented by:</p>
     *
     * <p>{@code x -> pitch}, {@code y -> yaw}, {@code z -> roll}</p>
     *
     * @param rotation The rotation to set the entity to
     */
    void setRotation(Vector3d rotation);

    /**
     * Moves the entity to the specified location and sets the rotation.
     *
     * <p>The format of the rotation is represented by:</p>
     *
     * <p>{@code x -> pitch}, {@code y -> yaw}, {@code z -> roll}</p>
     *
     * @param location The location to set
     * @param rotation The rotation to set
     * @return True if location was set successfully, false otherwise
     */
    boolean setLocationAndRotation(Location location, Vector3d rotation);

    /**
     * Moves the entity to the specified location and sets the rotation.
     * {@link RelativePositions} listed inside the EnumSet are considered
     * relative.
     *
     * <p>The format of the rotation is represented by:</p>
     *
     * <p>{@code x -> pitch}, {@code y -> yaw}, {@code z -> roll}</p>
     *
     * @param location The location to set
     * @param rotation The rotation to set
     * @param relativePositions The coordinates to set relatively
     * @return True if location was set successfully, false otherwise
     */
    boolean setLocationAndRotation(Location location, Vector3d rotation, EnumSet<RelativePositions> relativePositions);

    /**
     * Sets the location using a safe one from
     * {@link TeleportHelper#getSafeLocation(Location)} and the rotation of this
     * entity.
     *
     * <p>The format of the rotation is represented by:</p>
     *
     * <p>{@code x -> pitch}, {@code y -> yaw}, {@code z -> roll}</p>
     *
     * @param location The location to set
     * @param rotation The rotation to set
     * @return True if location was set successfully, false if either location
     *      couldn't be set as no safe location was found
     */
    default boolean setLocationAndRotationSafely(Location location, Vector3d rotation) {
        return Sponge.getGame().getTeleportHelper()
                .getSafeLocation(location)
                .map(safe -> this.setLocationAndRotation(safe, rotation))
                .orElse(false);
    }

    /**
     * Sets the location using a safe one from
     * {@link TeleportHelper#getSafeLocation(Location)} and the rotation of this
     * entity. {@link RelativePositions} listed inside the EnumSet are
     * considered relative.
     *
     * <p>The format of the rotation is represented by:</p>
     *
     * <p>{@code x -> pitch}, {@code y -> yaw}, {@code z -> roll}</p>
     *
     * @param location The location to set
     * @param rotation The rotation to set
     * @param relativePositions The coordinates to set relatively
     * @return True if location was set successfully, false if either location
     *      couldn't be set as no safe location was found
     */
    default boolean setLocationAndRotationSafely(Location location, Vector3d rotation, EnumSet<RelativePositions> relativePositions) {
        return Sponge.getGame().getTeleportHelper()
                .getSafeLocation(location)
                .map(safe -> this.setLocationAndRotation(safe, rotation, relativePositions))
                .orElse(false);
    }

    /**
     * Gets the scale.
     *
     * @return The entity scale
     */
    Vector3d getScale();

    /**
     * Sets the scale.
     *
     * @param scale The scale
     */
    void setScale(Vector3d scale);

    /**
     * Gets the {@link Transform}.
     *
     * @return The transform
     */
    Transform getTransform();

    /**
     * Sets the {@link Transform}.
     *
     * @param transform The transform to set
     * @return True if the transform was set successfully, false if the transform couldn't be set
     */
    boolean setTransform(Transform transform);

    /**
     * Sets the {@link Transform}using a safe location from
     * {@link TeleportHelper#getSafeLocation(Location)}.
     *
     * @param transform The transform to set
     * @return True if the transform was set successfully, or false if either
     *     the transform couldn't be set as no safe location was found
     */
    default boolean setTransformSafely(Transform transform) {
        checkNotNull(transform, "The transform cannot be null!");
        return this.setLocationAndRotationSafely(Location.of(this.getWorld(), transform.getPosition()), transform.getRotation());
    }

    /**
     * Sets the {@link Location} of this entity to the {@link World}'s spawn
     * point.
     *
     * @param world The world to transfer to
     * @return Whether the transfer was successful, returns false if the action
     *      is cancelled or not possible (eg. because the entity has been
     *      removed)
     */
    default boolean transferToWorld(World world) {
        return this.transferToWorld(world, world.getSpawnLocation().getPosition());
    }

    /**
     * Sets the {@link Location} of this entity to a new position in a world.
     *
     * @param world The world to transfer to
     * @param position The position in the target world
     * @return Whether the transfer was successful, returns false if the action
     *      is cancelled or not possible (eg. because the entity has been
     *      removed)
     */
    boolean transferToWorld(World world, Vector3d position);

    /**
     * Gets the entity's bounding box, usually for collisions and interaction.
     * The box has an offset matching the entity's positions. That is to say, it
     * is absolutely positioned and not relative to the entity.
     *
     * @return The axis aligned bounding box
     */
    Optional<AABB> getBoundingBox();

    /**
     * Gets the entity passenger that rides this entity, if available.
     *
     * @return The passenger entity, if it exists
     */
    List<Entity> getPassengers();

    /**
     * Checks if the given entity is a passenger.
     *
     * @param entity The entity passenger
     * @return If it is a passenger
     */
    boolean hasPassenger(Entity entity);

    /**
     * Sets the passenger entity(the entity that rides this one).
     *
     * @param entity The entity passenger, or null to eject
     * @return If adding the passenger succeeded
     */
    boolean addPassenger(Entity entity);

    /**
     * Removes the given entity as a passenger.
     *
     * @param entity The entity to remove as passenger
     */
    void removePassenger(Entity entity);

    /**
     * Removes all currently riding passengers from this entity.
     */
    void clearPassengers();

    /**
     * Gets the entity vehicle that this entity is riding, if available.
     *
     * @return The vehicle entity, if it exists
     */
    Optional<Entity> getVehicle();

    /**
     * Sets the vehicle entity(the entity that is ridden by this one).
     *
     * @param entity The entity vehicle, or null to dismount
     * @return True if the set was successful
     */
    boolean setVehicle(@Nullable Entity entity);

    /**
     * Gets the entity vehicle that is the base of what ever stack the current
     * entity is a part of. This can be the current entity, if it is not riding
     * any vehicle.
     *
     * <p>The returned entity can never ride another entity, that would make the
     * ridden entity the base of the stack.</p>
     *
     * @return The vehicle entity, if available
     */
    Entity getBaseVehicle();

    /**
     * Gets the {@link Vector3d} representation of this entity's current
     * velocity.
     *
     * @return The current velocity
     */
    default Vector3d getVelocity() {
        return get(Keys.VELOCITY).get();
    }

    /**
     * Sets the velocity for this entity.
     *
     * @param vector3d The vector 3d velocity
     * @return The resulting data transaction result
     */
    default DataTransactionResult setVelocity(Vector3d vector3d) {
        return offer(Keys.VELOCITY, vector3d);
    }

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

    /**
     * Damages this {@link Entity} with the given {@link DamageSource}.
     *
     * @param damage The damage to deal
     * @param damageSource The cause of the damage
     * @return True if damaging the entity was successful
     */
    boolean damage(double damage, DamageSource damageSource);

    /**
     * Gets the nearby entities within the desired distance.
     *
     * @see World#getNearbyEntities(Vector3d, double)
     * @param distance The distance
     * @return The collection of nearby entities
     */
    default Collection<Entity> getNearbyEntities(double distance) {
        return this.getWorld().getNearbyEntities(this.getLocation().getPosition(), distance);
    }

    /**
     * Gets the nearby entities that satisfy the desired predicate.
     *
     * @see World#getEntities(Predicate)
     * @param predicate The predicate to use
     * @return The collection of entities
     */
    default Collection<Entity> getNearbyEntities(Predicate<Entity> predicate) {
        checkNotNull(predicate, "Null predicate!");
        return this.getWorld().getEntities(predicate);
    }

    /**
     * Gets the {@link UUID}, if available, of the user who created this
     * {@link Entity}.
     *
     * @return The {@link UUID} if one exists
     */
    Optional<UUID> getCreator();

    /**
     * Gets the {@link UUID}, if available, of the user who last notified this
     * {@link Entity}.
     *
     * @return The {@link UUID} if one exists
     */
    Optional<UUID> getNotifier();

    /**
     * Sets the {@link UUID} of the user who created this {@link Entity}.
     *
     * @param uuid The {@link UUID} to set as creator
     */
    void setCreator(@Nullable UUID uuid);

    /**
     * Sets the {@link UUID} of the user who last notified this {@link Entity}.
     *
     * @param uuid The {@link UUID} to set as notifier
     */
    void setNotifier(@Nullable UUID uuid);

    /**
     * Returns whether this entity can see the provided {@link Entity}.
     *
     * @param entity The entity to check visibility for
     * @return {@code true} if this entity can see the provided entity
     */
    default boolean canSee(Entity entity) {
        Optional<Boolean> optional = entity.get(Keys.VANISH);
        return !optional.isPresent() || !optional.get();
    }

    /**
     * Returns whether this entity has gravity.
     *
     * @return True if this entity has gravity
     */
    default Value.Mutable<Boolean> gravity() {
        return getValue(Keys.HAS_GRAVITY).get().asMutable();
    }
}
