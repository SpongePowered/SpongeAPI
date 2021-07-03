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

import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.event.HoverEventSource;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.SerializableDataHolder;
import org.spongepowered.api.data.value.ListValue;
import org.spongepowered.api.data.value.SetValue;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.projectile.source.EntityProjectileSource;
import org.spongepowered.api.util.AABB;
import org.spongepowered.api.util.Identifiable;
import org.spongepowered.api.util.RandomProvider;
import org.spongepowered.api.util.RelativePositions;
import org.spongepowered.api.util.Ticks;
import org.spongepowered.api.util.Transform;
import org.spongepowered.api.util.annotation.DoNotStore;
import org.spongepowered.api.world.Locatable;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.schematic.Schematic;
import org.spongepowered.api.world.server.ServerLocation;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.math.imaginary.Quaterniond;
import org.spongepowered.math.vector.Vector3d;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

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
@DoNotStore
public interface Entity extends Identifiable, HoverEventSource<HoverEvent.ShowEntity>, Locatable, EntityProjectileSource, Sound.Emitter,
        SerializableDataHolder.Mutable, RandomProvider {

    /**
     * Gets the {@link EntityType}.
     *
     * @return The type
     */
    EntityType<?> type();

    /**
     * Creates an {@link EntitySnapshot}.
     *
     * @return The snapshot
     */
    EntitySnapshot createSnapshot();

    @Override
    Entity copy();

    /**
     * Creates an {@link EntityArchetype} for use with {@link Schematic}s.
     *
     * @return The archetype
     */
    EntityArchetype createArchetype();

    /**
     * Gets the position of this entity
     *
     * @return The position of this entity
     */
    Vector3d position();

    /**
     * Sets the position of this entity.
     *
     * @param position The position to set
     * @return True if set, false if not
     */
    boolean setPosition(Vector3d position);

    /**
     * Sets the location of this entity.
     *
     * @param location The location to set
     * @return True if location was set successfully, false otherwise
     */
    boolean setLocation(ServerLocation location);

    /**
     * Gets the rotation.
     *
     * <p>The format of the rotation is represented by:</p>
     *
     * <p>{@code x -> pitch}, {@code y -> yaw}, {@code z -> roll}</p>
     *
     * @return The rotation
     */
    Vector3d rotation();

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
     * Gets the unit vector representing the direction of this entity.
     *
     * @return The direction
     */
    default Vector3d direction() {
        final Vector3d rotation = this.rotation();
        return Quaterniond.fromAxesAnglesDeg(rotation.x(), -rotation.y(), rotation.z()).direction();
    }

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
    boolean setLocationAndRotation(ServerLocation location, Vector3d rotation);

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
    boolean setLocationAndRotation(ServerLocation location, Vector3d rotation, EnumSet<RelativePositions> relativePositions);

    /**
     * Gets the scale.
     *
     * @return The entity scale
     */
    Vector3d scale();

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
    Transform transform();

    /**
     * Sets the {@link Transform}.
     *
     * @param transform The transform to set
     * @return True if the transform was set successfully, false if the transform couldn't be set
     */
    boolean setTransform(Transform transform);

    /**
     * Sets the {@link ServerLocation} of this entity to the {@link ServerWorld}'s spawn
     * point.
     *
     * @param world The world to transfer to
     * @return Whether the transfer was successful, returns false if the action
     *      is cancelled or not possible (eg. because the entity has been
     *      removed)
     */
    default boolean transferToWorld(final ServerWorld world) {
        Objects.requireNonNull(world, "World cannot be null");
        return this.transferToWorld(world, world.properties().spawnPosition().toDouble());
    }

    /**
     * Sets the {@link ServerLocation} of this entity to a new position in a world.
     *
     * @param world The world to transfer to
     * @param position The position in the target world
     * @return Whether the transfer was successful, returns false if the action
     *      is cancelled or not possible (eg. because the entity has been
     *      removed)
     */
    boolean transferToWorld(ServerWorld world, Vector3d position);

    /**
     * Gets the entity's bounding box, usually for collisions and interaction.
     * The box has an offset matching the entity's positions. That is to say, it
     * is absolutely positioned and not relative to the entity.
     *
     * @return The axis aligned bounding box
     */
    Optional<AABB> boundingBox();

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
    default boolean damage(final double damage, final Supplier<? extends DamageSource> damageSource) {
        return this.damage(damage, damageSource.get());
    }

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
     * @see World#nearbyEntities(Vector3d, double)
     * @param distance The distance
     * @return The collection of nearby entities
     */
    default Collection<? extends Entity> nearbyEntities(final double distance) {
        if (distance <= 0) {
            throw new IllegalArgumentException("Distance must be greater than 0!");
        }
        return this.world().nearbyEntities(this.location().position(), distance);
    }

    /**
     * Gets the nearby entities that satisfy the desired predicate.
     *
     * @see World#entities(AABB, Predicate)
     * @param distance The distance
     * @param predicate The predicate to use
     * @return The collection of entities
     */
    default Collection<? extends Entity> nearbyEntities(final double distance, final Predicate<? super Entity> predicate) {
        Objects.requireNonNull(predicate, "Predicate cannot be null");
        return this.world().entities(this.boundingBox().get().expand(distance, distance, distance), predicate);
    }

    /**
     * Returns whether this entity can see the provided {@link Entity}.
     *
     * @param entity The entity to check visibility for
     * @return {@code true} if this entity can see the provided entity
     */
    default boolean canSee(final Entity entity) {
        Objects.requireNonNull(entity, "Entity cannot be null");
        final Optional<Boolean> optional = entity.get(Keys.VANISH);
        return !optional.isPresent() || !optional.get();
    }

    /**
     * {@link Keys#DISPLAY_NAME}
     *
     * @return The display name of this entity
     */
    default Value.Mutable<Component> displayName() {
        return this.requireValue(Keys.DISPLAY_NAME).asMutable();
    }

    /**
     * {@link Keys#FALL_DISTANCE}
     *
     * @return The fall distance
     */
    default Value.Mutable<Double> fallDistance() {
        return this.requireValue(Keys.FALL_DISTANCE).asMutable();
    }

    /**
     * {@link Keys#PASSENGERS}
     *
     * @return The list of passengers that may be riding this entity
     */
    default ListValue.Mutable<Entity> passengers() {
        return this.requireValue(Keys.PASSENGERS).asMutable();
    }

    /**
     * {@link Keys#VEHICLE}
     *
     * @return The vehicle this entity may be riding
     */
    default Optional<Value.Mutable<Entity>> vehicle() {
        return this.getValue(Keys.VEHICLE).map(Value::asMutable);
    }

    /**
     * {@link Keys#BASE_VEHICLE}
     *
     * @return The "base vehicle" of the entity vehicle riding chain
     */
    default Value<Entity> baseVehicle() {
        return this.requireValue(Keys.BASE_VEHICLE);
    }

    /**
     * {@link Keys#ON_GROUND}
     *
     * @return Whether this entity is on the ground
     */
    default Value<Boolean> onGround() {
        return this.requireValue(Keys.ON_GROUND).asMutable();
    }

    /**
     * {@link Keys#VELOCITY}
     *
     * @return The velocity of this entity
     */
    default Value.Mutable<Vector3d> velocity() {
        return this.requireValue(Keys.VELOCITY).asMutable();
    }

    /**
     * {@link Keys#IS_GRAVITY_AFFECTED}
     *
     * @return Whether this entity is affected by gravity
     */
    default Value.Mutable<Boolean> gravityAffected() {
        return this.requireValue(Keys.IS_GRAVITY_AFFECTED).asMutable();
    }

    /**
     * {@link Keys#IS_SILENT}
     *
     * @return Whether this entity is silent
     */
    default Value.Mutable<Boolean> silent() {
        return this.requireValue(Keys.IS_SILENT).asMutable();
    }

    /**
     * {@link Keys#CREATOR}
     *
     * @return The unique id of the creator of this entity
     */
    default Optional<Value.Mutable<UUID>> creator() {
        return this.getValue(Keys.CREATOR).map(Value::asMutable);
    }

    /**
     * {@link Keys#NOTIFIER}
     *
     * @return The unique id of the notifier of this entity
     */
    default Optional<Value.Mutable<UUID>> notifier() {
        return this.getValue(Keys.NOTIFIER).map(Value::asMutable);
    }

    /**
     * {@link Keys#FIRE_TICKS}
     *
     * @return The amount of time in ticks the entity is will continue burn for
     */
    default Optional<Value.Mutable<Ticks>> fireTicks() {
        return this.getValue(Keys.FIRE_TICKS).map(Value::asMutable);
    }

    /**
     * {@link Keys#FIRE_DAMAGE_DELAY}
     *
     * @return The amount of time to delay in ticks before the entity will be burned by fire
     */
    default Value.Mutable<Ticks> fireImmuneTicks() {
        return this.requireValue(Keys.FIRE_DAMAGE_DELAY).asMutable();
    }

    /**
     * {@link Keys#TRANSIENT}
     *
     * @return The transient state
     */
    default Value.Mutable<Boolean> isTransient() {
        return this.requireValue(Keys.TRANSIENT).asMutable();
    }

    /**
     * {@link Keys#AGE}
     *
     * @return The age of this entity
     */
    default Value.Mutable<Integer> age() {
        return this.requireValue(Keys.AGE).asMutable();
    }

    /**
     * {@link Keys#BASE_SIZE}
     *
     * @return The base size of the entity
     */
    default Value<Double> baseSize() {
        return this.requireValue(Keys.BASE_SIZE);
    }

    /**
     * {@link Keys#EYE_HEIGHT}
     *
     * @return The height of the eyes
     */
    default Value<Double> eyeHeight() {
        return this.requireValue(Keys.EYE_HEIGHT);
    }

    /**
     * {@link Keys#EYE_POSITION}
     *
     * @return The position of the eyes
     */
    default Value<Vector3d> eyePosition() {
        return this.requireValue(Keys.EYE_POSITION);
    }

    /**
     * {@link Keys#HEIGHT}
     *
     * @return The height of the entity
     */
    default Value<Double> height() {
        return this.requireValue(Keys.HEIGHT);
    }

    /**
     * {@link Keys#INVULNERABILITY_TICKS}
     *
     * @return The amount of ticks the entity will remain invulnerable for
     */
    default Value.Mutable<Ticks> invulnerabilityTicks() {
        return this.requireValue(Keys.INVULNERABILITY_TICKS).asMutable();
    }

    /**
     * {@link Keys#IS_CUSTOM_NAME_VISIBLE}
     *
     * @return Whether a custom name is visible on the entity
     */
    default Value.Mutable<Boolean> customNameVisible() {
        return this.requireValue(Keys.IS_CUSTOM_NAME_VISIBLE).asMutable();
    }

    /**
     * {@link Keys#IS_GLOWING}
     *
     * @return Whether the entity has a glowing outline
     */
    default Value.Mutable<Boolean> glowing() {
        return this.requireValue(Keys.IS_GLOWING).asMutable();
    }

    /**
     * {@link Keys#IS_INVISIBLE}
     *
     * @return Whether the entity is currently invisible
     */
    default Value.Mutable<Boolean> invisible() {
        return this.requireValue(Keys.IS_INVISIBLE).asMutable();
    }

    /**
     * {@link Keys#INVULNERABLE}
     *
     * @return Whether the entity is invulnerable
     */
    default Value.Mutable<Boolean> invulnerable() {
        return this.requireValue(Keys.INVULNERABLE).asMutable();
    }

    /**
     * {@link Keys#IS_SNEAKING}
     *
     * @return Whether the entity is sneaking
     */
    default Value.Mutable<Boolean> sneaking() {
        return this.requireValue(Keys.IS_SNEAKING).asMutable();
    }

    /**
     * {@link Keys#IS_SPRINTING}
     *
     * @return Whether the entity is sprinting
     */
    default Value.Mutable<Boolean> sprinting() {
        return this.requireValue(Keys.IS_SPRINTING).asMutable();
    }

    /**
     * {@link Keys#IS_WET}
     *
     * @return Whether the entity is wet
     */
    default Value<Boolean> wet() {
        return this.requireValue(Keys.IS_WET).asMutable();
    }

    /**
     * {@link Keys#MAX_AIR}
     *
     * @return The max air supply
     */
    default Value.Mutable<Integer> maxAir() {
        return this.requireValue(Keys.MAX_AIR).asMutable();
    }

    /**
     * {@link Keys#REMAINING_AIR}
     *
     * @return The remaining air supply
     */
    default Value.Mutable<Integer> remainingAir() {
        return this.requireValue(Keys.REMAINING_AIR).asMutable();
    }

    /**
     * {@link Keys#SCOREBOARD_TAGS}
     *
     * @return The scoreboard tags applied to the entity
     */
    default SetValue.Mutable<String> scoreboardTags() {
        return this.requireValue(Keys.SCOREBOARD_TAGS).asMutable();
    }

    /**
     * {@link Keys#VANISH}
     *
     * @return Whether the entity is vanished
     */
    default Value.Mutable<Boolean> vanish() {
        return this.requireValue(Keys.VANISH).asMutable();
    }

    /**
     * {@link Keys#VANISH_IGNORES_COLLISION}
     *
     * @return Whether the entity ignores collision with other entities
     */
    default Value.Mutable<Boolean> vanishIgnoresCollision() {
        return this.requireValue(Keys.VANISH_IGNORES_COLLISION).asMutable();
    }

    /**
     * {@link Keys#VANISH_PREVENTS_TARGETING}
     *
     * @return Whether the entity can be targeted for attack by another entity
     */
    default Value.Mutable<Boolean> vanishPreventsTargeting() {
        return this.requireValue(Keys.VANISH_PREVENTS_TARGETING).asMutable();
    }

    /**
     * {@link Keys#CUSTOM_NAME}
     *
     * @return The custom name of the entity
     */
    default Optional<Value.Mutable<Component>> customName() {
        return this.getValue(Keys.CUSTOM_NAME).map(Value::asMutable);
    }

    /**
     * {@link Keys#SWIFTNESS}
     *
     * @return The current swiftness of the entity
     */
    default Optional<Value.Mutable<Double>> swiftness() {
        return this.getValue(Keys.SWIFTNESS).map(Value::asMutable);
    }

    @Override
    HoverEvent<HoverEvent.ShowEntity> asHoverEvent(final UnaryOperator<HoverEvent.ShowEntity> op);
}
