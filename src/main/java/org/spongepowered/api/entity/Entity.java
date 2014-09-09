/**
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
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

import java.util.UUID;

public interface Entity {

    /**
     * Get id of the entity.
     * Used for communication with the client.
     *
     * @return Id of entity
     */
    int getID();

    /**
     * Get unique id of entity
     * Used for identifying the entity.
     *
     * @return Unique entity id
     */
    UUID getUniqueID();

    /**
     * Check if the entity is standing on a solid block.
     *
     * @return Entity on ground?
     */
    boolean isOnGround();

    /**
     * Check if the entity is alive.
     *
     * @return Entity alive?
     */
    boolean isAlive();

    /**
     * Check if the entity is dead.
     *
     * @return Entity dead?
     */
    boolean isDead();

    /**
     * Get height of the entity in blocks/meters.
     *
     * @return Height of entity
     */
    double getHeight();

    /**
     * Get width of the entity in blocks/meters.
     *
     * @return Width of entity
     */
    double getWidth();

    /**
     * Get length of the entity in blocks/meters.
     *
     * @return Length of entity
     */
    double getLength();

    /**
     * Get the current distance the entity has been falling for.
     *
     * @return Entity falling distance
     */
    float getFallDistance();

    /**
     * Set the currenct distance the entity has been falling for.
     *
     * @param fallDistance Entity falling distance
     */
    void setFallDistance(float fallDistance);

    /**
     * Get the amount of ticks the entity has lived for.
     * Ex. 40 (= 2 seconds)
     *
     * @return Entity alive ticks
     */
    int getTicksLived();

    /**
     * Set the amount of ticks the entity has lived for.
     * Ex. 40 (= 2 seconds)
     *
     * @param ticksLived Entity alive ticks
     */
    void setTicksLived(int ticksLived);

    /**
     * Get the amount of ticks the entity will be put on fire for when interacting with lava or fire.
     * Ex. 40 (= 2 seconds)
     *
     * @return Entity max fire ticks.
     */
    int getMaxFireTicks();

    /**
     * Get the remaining ticks the entity is on fire for.
     *
     * @return Entity fire ticks
     */
    int getFireTicks();

    /**
     * Set the remaining ticks the entity is on fire for.
     *
     * @param fireTicks Entity fire ticks
     */
    void setFireTicks(int fireTicks);

    /**
     * Check if the entity is in water.
     *
     * @return Entity in water?
     */
    boolean isInWater();

    /**
     * Get the amount of ticks the entity will not be damaged for.
     *
     * @return Entity no-damage ticks
     */
    int getNoDamageTicks();

    /**
     * Set the amount of ticks the entity will not be damaged for.
     *
     * @param noDamageTicks Entity no-damage ticks
     */
    void setNoDamageTicks(int noDamageTicks);

    /**
     * Check if the entity is invulnerable to fire.
     *
     * @return Entity invulnerable to fire?
     */
    boolean isFireProof();

    /**
     * Set if the entity should be invulnerable to fire.
     *
     * @param fireProof Entity invulnerable to fire
     */
    void setFireProof(boolean fireProof);

    /**
     * Get the amount of ticks the entity is ignored by portal blocks
     *
     * @return Portal cooldown in ticks
     */
    int getPortalCooldown();

    /**
     * Set the amount of ticks the entity is ignored by portal blocks
     *
     * @param portalCooldown Portal cooldown in ticks
     */
    void setPortalCooldown(int portalCooldown);

    /**
     * Check if the entity is invulnerable to all damage.
     *
     * @return Enity invulnerable?
     */
    boolean isInvulnerable();

    /**
     * Set if the entity is invulnerable to all damage.
     *
     * @param invulnerable Entity invulnerable
     */
    void setInvulnerable(boolean invulnerable);

    /**
     * Teleport the entity to another entity.
     *
     * @param entity Entity to teleport to
     */
    void teleport(Entity entity);

    /**
     * Get the entity that has this entity as passenger.
     *
     * @return Vehicle if the entity is inside of a vehicle, otherwise null.
     */
    Entity getVehicle();

    /**
     * Check if the entity is inside of a vehicle.
     *
     * @return Entity inside vehicle?
     */
    boolean isInsideVehicle();

    /**
     * Set an entity to be passenger of this entity.
     *
     * @param entity Entity to be used as passenger.
     */
    void setPassenger(Entity entity);
}
