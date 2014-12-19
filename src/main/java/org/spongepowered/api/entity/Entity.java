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

import com.flowpowered.math.vector.Vector2f;
import com.google.common.base.Optional;
import org.spongepowered.api.util.DataHolder;
import org.spongepowered.api.util.Identifiable;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

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
     * Gets the current world this entity resides in.
     *
     * @return The current world this entity resides in
     */
    World getWorld();

    /**
     * Get the location of this entity
     *
     * @return The location
     */
    Location getLocation();

    /**
     * Sets the location of this entity. This is equivalent to a teleport,
     * and also moves this entity's passengers.
     *
     * @param location The location to set
     * @return True if the teleport was successful
     */
    boolean setLocation(Location location);

    /**
     * Gets the rotation as a Vector2f.
     *
     * @return The rotation as a Vector2f
     */
    Vector2f getRotation();

    /**
     * Sets the rotation of this entity.
     *
     * @param rotation The rotation to set the entity to
     */
    void setRotation(Vector2f rotation);

    /**
     * Gets the entity passenger that rides this entity, if available.
     *
     * @return The passenger entity, if it exists
     */
    Optional<Entity> getPassenger();

    /**
     * Gets the entity vehicle that this entity is riding, if available.
     *
     * @return The vehicle entity, if it exists
     */
    Optional<Entity> getVehicle();

    /**
     * Gets the entity vehicle that is the base of what ever stack the current
     * entity is a part of. This can be the current entity, if it is not riding any vehicle.
     *
     * <p>The returned entity can never ride another entity, that would make
     * the ridden entity the base of the stack.</p>
     *
     * @return The vehicle entity
     */
    Entity getBaseVehicle();

    /**
     * Sets the passenger entity(the entity that rides this one).
     *
     * @param entity The entity passenger, or null to eject
     * @return True if the set was successful
     */
    boolean setPassenger(@Nullable Entity entity);

    /**
     * Sets the vehicle entity(the entity that is ridden by this one).
     *
     * @param entity The entity vehicle, or null to dismount
     * @return True if the set was successful
     */
    boolean setVehicle(@Nullable Entity entity);

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
     * Gets the delay in ticks before this entity will catch fire after being in a burning block.
     *
     * @return The delay before catching fire
     */
    int getFireDelay();
}
