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

import java.util.List;

import org.spongepowered.api.Game;
import org.spongepowered.api.world.World;

public interface Entity {

	/**
	 * 
	 * @return a unique id for this entity
	 */
	int getEntityId();
	/**
	 * 
	 * @return distance this entity has fallen
	 */
	float getFallDistance();
	/**
	 * 
	 * @return the entity's current fire ticks (ticks before the entity stops being on fire).
	 */
	int getFireTicks();
	
	//EntityDamagEvent getLastDamageCause();
	//Location getLocation();
	//Location getLocation(Location loc);
	/**
	 * 
	 * @return the entity's maximum fire ticks.
	 */
	int getMaxFireTicks();
	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return a list of entities within a bounding box centered around this entity
	 */
	List<Entity> getNerabyEntities(double x, double y, double z);
	/**
	 * 
	 * @return the primary passenger of a vehicle.
	 */
	Entity getPassenger();
	/** Replacement for getServer
	 * 
	 * @return  Gets the Game that contains this Entity
	 */
	Game getGame();
	/**
	 * 
	 * @return the amount of ticks this entity has lived for.
	 */
	int getTicksLived();
	
	//EntityType getType();
	//UUID getUniqueId();
	/**
	 * 
	 * @return the vehicle that this player is inside.
	 */
	Entity GetVehicle();
	//Vector getVelocity();
	/**
	 * 
	 * @return the current world this entity is in
	 */
	World getWorld();
	/**
	 * 
	 * @return true if entity has been marked for removal
	 */
	
	boolean isDead();
	/**
	 * 
	 * @return Check if vehicle has passengers
	 */
	boolean isEmpty();
	/**
	 * 
	 * @return if the entity is in a vehicile
	 */
	boolean isInsideVehicle();
	/**
	 * 
	 * @return returns true if entity is standing on block
	 */
	boolean isOnGround();
	/**
	 * 
	 * @return returns false if the entity has died or has been despawned
	 */
	boolean isValid();
	/**
	 * 
	 * @return  leave current vehicle
	 */
	boolean leaveVehicle();
	//void playEffect(EntityEffect type);
	/**
	 * 
	 * Mark entity for removal
	 */
	void remove();
	/**
	 * 
	 * Sets the fall distance for this entity
	 */
	void setFallDistance(float distance);
	/**
	 * 
	 * Set the entity's current fire ticks
	 */
	void setFireTicks(int ticks);
	//void setLastDamageCause(EntityDamageEvent event);
	/**
	 * 
	 * Set the passenger of this Vechicle
	 */
	boolean setPassenger(Entity passenger);
	/**
	 * Sets the amount of ticks this entity has lived for.
	 * @return 
	 */
	void setTicksLived(int value);
	//void setVelocity(Vector velocity);
	/**
	 * Teleports the Entity to another entity
	 * @return Success?
	 */
	boolean teleport(Entity destination);
	
}

