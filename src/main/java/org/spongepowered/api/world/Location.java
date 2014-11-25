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

package org.spongepowered.api.world;

import org.spongepowered.api.block.Block;
import org.spongepowered.api.math.Vector3d;
import org.spongepowered.api.math.Vector3f;
import org.spongepowered.api.math.Vector3i;
import org.spongepowered.api.math.Vectors;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A position within a particular {@link World}.
 *
 * <p>Locations are immutable. Methods that change the properties of the
 * location create a new instance.</p>
 */
public class Location {

    private final World world;
    private final Vector3d position;

    /**
     * Create a new instance.
     *
     * @param world The world
     * @param position The position
     */
    public Location(World world, Vector3d position) {
        checkNotNull(world);
        checkNotNull(position);
        this.world = world;
        this.position = position;
    }

    /**
     * Create a new instance.
     *
     * @param world The world
     * @param position The position
     */
    public Location(World world, Vector3f position) {
        this(world, position.toDouble());
    }

    /**
     * Create a new instance.
     *
     * @param world The world
     * @param position The position
     */
    public Location(World world, Vector3i position) {
        this(world, position.toDouble());
    }

    /**
     * Create a new instance.
     *
     * @param world The world
     * @param x The x position
     * @param y The y position
     * @param z The z position
     */
    public Location(World world, double x, double y, double z) {
        this(world, Vectors.create3d(x, y, z));
    }

    /**
     * Get the underlying world.
     *
     * @return The world
     */
    public World getWorld() {
        return world;
    }

    /**
     * Create a new instance with a new world.
     *
     * @param world The new world
     * @return A new instance
     */
    public Location setWorld(World world) {
        checkNotNull(world);
        if (world == getWorld()) {
            return this;
        }
        return new Location(world, getPosition());
    }

    /**
     * Get the underlying position.
     *
     * @return The underlying position
     */
    public Vector3d getPosition() {
        return position;
    }

    /**
     * Create a new instance with a new position.
     *
     * @param position The new position
     * @return A new instance
     */
    public Location setPosition(Vector3d position) {
        checkNotNull(position);
        if (position == getPosition()) {
            return this;
        }
        return new Location(getWorld(), position);
    }

    /**
     * Add another Vector3d to the position on this instance, returning
     * a new Location instance.
     *
     * @param v The vector to add
     * @return A new instance
     */
    public Location add(Vector3d v) {
        return setPosition(getPosition().add(v));
    }

    /**
     * Add vector components to the position on this instance, returning
     * a new Location instance.
     *
     * @param x The x component
     * @param y The y component
     * @param z The z component
     * @return A new instance
     */
    public Location add(double x, double y, double z) {
        return setPosition(getPosition().add(x, y, z));
    }

    /**
     * Get the block at this position.
     *
     * @return The block
     */
    public Block getBlock() {
        return getWorld().getBlock(getPosition());
    }

    /**
     * Create a new location instance from a {@link Block} residing
     * inside a {@link World}.
     *
     * @param block The block
     * @return The location
     */
    public static Location fromBlock(Block block) {
        if (block.getExtent() instanceof World) {
            return new Location((World) block.getExtent(), block.getPosition());
        } else {
            throw new IllegalArgumentException("The given block is not in an instance of a World");
        }
    }

}
