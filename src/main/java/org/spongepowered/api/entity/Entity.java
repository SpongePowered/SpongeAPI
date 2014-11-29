/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

import com.google.common.base.Optional;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.math.EulerDirection;
import org.spongepowered.api.math.Vector3d;
import org.spongepowered.api.math.Vector3f;
import org.spongepowered.api.util.DataHolder;
import org.spongepowered.api.util.Identifiable;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.extent.Extent;

import javax.annotation.Nullable;

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
public interface Entity extends Identifiable, EntityState, DataHolder {

    /**
     * Mark this entity for removal in the very near future, preferably
     * within one game tick.
     */
    void remove();

    /**
     * Simulates the interaction with this object as if a player had done so.
     *
     * @param interactionType The type of interaction performed on this entity
     */
    void interact(EntityInteractionType interactionType);

    /**
     * Simulates the interaction with this object using the given item as if
     * the player had done so.
     *
     * @param itemStack       The item
     * @param interactionType The type of interaction performed on this entity
     */
    void interactWith(ItemStack itemStack, EntityInteractionType interactionType);

    /**
     * Returns whether this entity is on the ground (not in the air) or not.
     *
     * @return Whether this entity is on the ground or not
     */
    boolean isOnGround();

    /**
     * Get the location of this entity.
     *
     * @return The location
     */
    Location getLocation();

    /**
     * Teleport the entity to a location.
     *
     * @param location The location
     */
    void teleport(Location location);

    /**
     * Teleport the entity to a location.
     *
     * @param extent The new extent
     * @param position The new position
     */
    void teleport(Extent extent, Vector3d position);

    /**
     * Gets the position.
     *
     * @return The position
     */
    Vector3d getPosition();

    /**
     * Sets the position.
     *
     * @param position The position to set to
     */
    void setPosition(Vector3d position);

    /**
     * Gets the current world this entity resides in.
     *
     * @return The current world this entity resides in
     */
    World getWorld();

    /**
     * Teleports this entity to the target position specified by the vector
     * and, if available, the world.
     *
     * @param position The position to teleport to
     * @param world The world to teleport to, if available
     */
    void teleport(Vector3d position, @Nullable World world);

    /**
     * Teleports this entity to the target position specified by x, y, z,
     * and world.
     *
     * @param x The x coordinate
     * @param y The y coordinate
     * @param z The z coordinate
     * @param world The world to teleport to, if available
     */
    void teleport(double x, double y, double z, @Nullable World world);

    /**
     * Get the X component of this instance's position.
     *
     * @return The x component
     */
    double getX();

    /**
     * Get the Y component of this instance's position.
     *
     * @return The y component
     */
    double getY();

    /**
     * Get the Z component of this instance's position.
     *
     * @return The z component
     */
    double getZ();

    /**
     * Gets the rotation as a vector.
     * This does not support the roll component of the entity's rotation.
     *
     * @return A possibly, but not necessarily, unit vector
     */
    Vector3f getVectorRotation();

    /**
     * Sets the rotation to a vector.
     * This does not support the roll component of the entity's rotation,
     * any previous roll value will be removed.
     *
     * @param rotation The rotation to set the entity to
     */
    void setVectorRotation(Vector3f rotation);

    /**
     * Gets the rotation as a EulerDirection.
     *
     * @return The rotation as a EulerDirection
     */
    EulerDirection getRotation();

    /**
     * Sets the rotation.
     *
     * @param rotation The rotation to set the entity to
     */
    void setRotation(EulerDirection rotation);

    /**
     * Mount the entity provided.
     *
     * @param entity The entity to mount
     */
    void mount(Entity entity);

    /**
     * Dismount from the currently mounted entity.
     */
    void dismount();

    /**
     * Eject any entity mounted on this entity
     */
    void eject();

    /**
     * Gets the entity that is riding this entity.
     *
     * @return The riding entity, if it exists
     */
    Optional<Entity> getRider();

    /**
     * Gets the entity that this entity is riding.
     *
     * @return The entity being ridden, if it exists
     */
    Optional<Entity> getRiding();

    /**
     * Gets the current x/z size of this entity.
     *
     * @return The width of this entity
     */
    float getBase();

    /**
     * Gets the current y height of this entity.
     *
     * @return The current y height
     */
    float getHeight();

    /**
     * Gets the current size scale of this entity.
     *
     * @return The current scale of the bounding box
     */
    float getScale();

    /**
     * Returns whether this entity is considered dead and ready for removal.
     *
     * @return True if this entity is dead
     */
    boolean isDead();

    /**
     * Returns whether this entity is still loaded in a world/chunk.
     *
     * @return True if this entity is still loaded
     */
    boolean isValid();

    /**
     * Gets the ticks remaining of being lit on fire.
     *
     * @return The remaining fire ticks
     */
    int getFireTicks();

    /**
     * Sets the remaining ticks of being lit on fire.
     *
     * @param ticks The ticks of being lit on fire
     */
    void setFireTicks(int ticks);

    /**
     * Gets the maximum ticks this entity can be on fire.
     *
     * @return The maximum fire ticks this entity can be on fire
     */
    int getMaxFireTicks();

}
