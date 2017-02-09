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
package org.spongepowered.api.util.blockray;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.extent.Extent;

import java.util.function.BiFunction;

/**
 * Represents a block hit by a ray. Stores more information than a regular
 * location. Extra object are lazily computed and cached.
 *
 * @param <E> The extent containing the hit
 */
public class BlockRayHit<E extends Extent> {

    private final E extent;
    private final double x;
    private final double y;
    private final double z;
    private Vector3d position = null;
    private final int xBlock;
    private final int yBlock;
    private final int zBlock;
    private Vector3i blockPosition = null;
    private final Vector3d direction;
    private final Vector3d normal;
    private Direction[] faces = null;
    private Location<E> location = null;

    /**
     * Constructs a new block ray hit from the extent that contains it, the
     * coordinates and the face that was entered.
     *
     * @param extent The extent of the block
     * @param x The x coordinate of the block
     * @param y The y coordinate of the block
     * @param z The x coordinate of the block
     * @param direction A normal vector of the ray direction
     * @param normal The normal of the entered face, edge or corner
     */
    public BlockRayHit(E extent, double x, double y, double z, Vector3d direction, Vector3d normal) {
        this.extent = extent;
        this.x = x;
        this.y = y;
        this.z = z;
        this.direction = direction;
        this.normal = normal;
        // Take into account the face through which we entered
        // so we know which block is the correct one
        if (x % 1 == 0 && normal.getX() > 0) {
            this.xBlock = (int) x - 1;
        } else {
            this.xBlock = GenericMath.floor(x);
        }
        if (y % 1 == 0 && normal.getY() > 0) {
            this.yBlock = (int) y - 1;
        } else {
            //noinspection SuspiciousNameCombination
            this.yBlock = GenericMath.floor(y);
        }
        if (z % 1 == 0 && normal.getZ() > 0) {
            this.zBlock = (int) z - 1;
        } else {
            this.zBlock = GenericMath.floor(z);
        }
    }

    /**
     * Returns the extent that contains the block.
     *
     * @return The extent
     */
    public E getExtent() {
        return this.extent;
    }

    /**
     * Returns the x coordinate of the intersection.
     *
     * @return The x coordinate
     */
    public double getX() {
        return this.x;
    }

    /**
     * Returns the y coordinate of the intersection.
     *
     * @return The y coordinate
     */
    public double getY() {
        return this.y;
    }

    /**
     * Returns the z coordinate of the intersection.
     *
     * @return The z coordinate
     */
    public double getZ() {
        return this.z;
    }

    /**
     * Returns the position of the intersection.
     *
     * @return The intersection coordinates
     */
    public Vector3d getPosition() {
        if (this.position == null) {
            this.position = new Vector3d(this.x, this.y, this.z);
        }
        return this.position;
    }

    /**
     * Returns the x coordinate of the block that was hit.
     *
     * @return The x coordinate
     */
    public int getBlockX() {
        return this.xBlock;
    }

    /**
     * Returns the y coordinate of the block that was hit.
     *
     * @return The y coordinate
     */
    public int getBlockY() {
        return this.yBlock;
    }

    /**
     * Returns the z coordinate of the block that was hit.
     *
     * @return The z coordinate
     */
    public int getBlockZ() {
        return this.zBlock;
    }

    /**
     * Returns the position of the block that was hit.
     *
     * @return The coordinates of the hit block
     */
    public Vector3i getBlockPosition() {
        if (this.blockPosition == null) {
            this.blockPosition = new Vector3i(this.xBlock, this.yBlock, this.zBlock);
        }
        return this.blockPosition;
    }

    /**
     * Returns the location of the hit block, <b>not the intersection
     * location</b>.
     *
     * @return The location of the hit block
     */
    public Location<E> getLocation() {
        if (this.location == null) {
            this.location = new Location<>(this.extent, this.xBlock, this.yBlock, this.zBlock);
        }
        return this.location;
    }

    /**
     * Returns the direction of the ray as a normalized vector.
     *
     * @return The ray direction
     */
    public Vector3d getDirection() {
        return this.direction;
    }

    /**
     * Returns the normal of the entered face, edge or corner.
     * Edges and corners use the average of the surrounding faces.
     *
     * @return The entered face, edge or corner normal
     */
    public Vector3d getNormal() {
        return this.normal;
    }

    /**
     * Returns all the intersected faces. In most cases, this is only one face,
     * but if the ray enters an edge, two faces are returned (the ones
     * that form it). Similarly for corners, but three faces.
     *
     * @return An array of intersected faces, between one and three in length
     */
    public Direction[] getFaces() {
        if (this.faces == null) {
            this.faces = new Direction[(this.normal.getX() != 0 ? 1 : 0) + (this.normal.getY() != 0 ? 1 : 0) + (this.normal.getZ() != 0 ? 1 : 0)];
            int index = 0;
            if (this.normal.getX() != 0) {
                this.faces[index++] = this.normal.getX() > 0 ? Direction.EAST : Direction.WEST;
            }
            if (this.normal.getY() != 0) {
                this.faces[index++] = this.normal.getY() > 0 ? Direction.UP : Direction.DOWN;
            }
            if (this.normal.getZ() != 0) {
                this.faces[index] = this.normal.getZ() > 0 ? Direction.SOUTH : Direction.NORTH;
            }
        }
        return this.faces;
    }

    /**
     * Calls the mapper function on the extent and position.
     *
     * @param mapper The mapper
     * @param <T> The return type of the mapper
     * @return The results of the mapping
     */
    public <T> T map(BiFunction<E, Vector3d, T> mapper) {
        return mapper.apply(this.extent, getPosition());
    }

    /**
     * Calls the mapper function on the extent and block position.
     *
     * @param mapper The mapper
     * @param <T> The return type of the mapper
     * @return The results of the mapping
     */
    public <T> T mapBlock(BiFunction<E, Vector3i, T> mapper) {
        return mapper.apply(this.extent, getBlockPosition());
    }

    @Override
    public String toString() {
        return "BlockRayHit{" + getPosition() + " in " + getExtent() + "}";
    }

}
