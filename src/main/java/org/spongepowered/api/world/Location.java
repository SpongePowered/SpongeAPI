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
package org.spongepowered.api.world;

/**
 * A location specifies a 3-dimensional point inside of a world
 */
public interface Location {

    /**
     * Gets the x coordinate of this location as it appears in the {@link World}.
     *
     * @return x coordinate
     */
    public double getX();

    /**
     * Gets the y coordinate of this location as it appears in the {@link World}.
     *
     * @return y coordinate
     */
    public double getY();

    /**
     * Gets the z coordinate of this location as it appears in the {@link World}.
     *
     * @return z coordinate
     */
    public double getZ();

    /**
     * Gets the yaw of this location in degrees.
     *
     * @return yaw yaw in degrees
     */
    public double getYaw();

    /**
     * Gets the pitch of this location in degrees.
     *
     * @return pitch pitch in degrees
     */
    public double getPitch();

    /**
     * Gets the {@link World} associated with this location
     *
     * @return world World
     */
    public World getWorld();

    /**
     * Gets the {@link org.spongepowered.api.world.Chunk} associated with this location
     *
     * @return chunk Chunk
     */
    public Chunk getChunk();

    /**
     * Add two locations together to create a third new location
     *
     * @param location another location to add
     * @return location a new location object that is the addition of this and the parameter's location
     */
    public Location add(Location location);

    /**
     * Add this location's coordinates with parameters to create new location
     *
     * @param x coordinate
     * @param y coordinate
     * @param z coordinate
     * @return location a new location object that is the addition of this and the parameter's coordinates
     */
    public Location add(double x, double y, double z);

    /**
     * Subtract <code>location</code> from this location to create a third new location
     *
     * @param location another location to add
     * @return location a new location object that is the addition of this and the parameter's location
     */
    public Location subtract(Location location);

    /**
     * Subtract coordinates from this location to create a third new location
     *
     * @param x coordinate
     * @param y coordinate
     * @param z coordinate
     * @return location a new location object that is the addition of this and the parameter's coordinates
     */
    public Location subtract(double x, double y, double z);

}
