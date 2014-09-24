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

import org.spongepowered.api.component.attribute.Flammable;
import org.spongepowered.api.component.attribute.Movable;
import org.spongepowered.api.component.attribute.Positionable;
import org.spongepowered.api.component.attribute.Rotatable;
import org.spongepowered.api.math.Vector3d;
import org.spongepowered.api.world.World;

import java.util.UUID;

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
public interface Entity extends Flammable, Movable, Positionable, Rotatable {

    /**
     * Gets the unique ID for this entity
     *
     * @return The entity's {@link UUID}
     */
    UUID getUniqueID();
    
    /**
     * Gets the world that this entity is in
     * 
     * @return World containing this entity
     */
    World getWorld();
    
    /**
     * Teleports this entity to a target position.
     * 
     * <p>If world parameter is null, it will teleport an entity to a position
     * in the same world.</p>
     * 
     * @param position The Vector3d to teleport this entity to
     * @param world The world to teleport this entity to. Can be null
     * @see #teleport(double, double, double, World)
     */
    void teleport(Vector3d position, @Nullable World world);
    
    /**
     * Teleports this entity to a coordinate specified by x, y, z.
     * 
     * <p>If world parameter is null, it will teleport an entity to the 
     * coordinates in the same world</p>
     * 
     * @param x The x coordinate
     * @param y The y coordinate
     * @param z The z coordinate
     * @param world The world these coordinates reside in. Can be null
     * @see #teleport(Vector3d, World)
     */
    void teleport(double x, double y, double z, @Nullable World world);

}
