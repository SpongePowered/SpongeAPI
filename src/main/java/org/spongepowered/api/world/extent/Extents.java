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

package org.spongepowered.api.world.extent;

import com.flowpowered.math.vector.Vector3d;

/**
 * Utility class for Extent.
 */
public class Extents {

    /**
     * Converts local vector coordinates into world coordinates relative to the
     * given Extent.
     * 
     * @param extent The extent to use
     * @param position The local coordinates
     * @return The world coordinates relative to the given Extent
     */
    public static Vector3d localToWorld(Extent extent, Vector3d position) {
        return localToWorld(extent, position.getX(), position.getY(), position.getZ());
    }

    /**
     * Converts local vector coordinates into world coordinates relative to the
     * given Extent.
     * 
     * @param extent The extent to use
     * @param x The local x coordinate
     * @param y The local y coordinate
     * @param z The local z coordinate
     * @return The world coordinates relative to the given Extent
     */
    public static Vector3d localToWorld(Extent extent, double x, double y, double z) {
        while (extent != null) {
            x -= extent.getOrigin().getX();
            y -= extent.getOrigin().getY();
            z -= extent.getOrigin().getZ();
            extent = extent.getParent().orNull();
        }

        return new Vector3d(x, y, z);
    }

    /**
     * Converts world vector coordinates into local coordinates relative to the
     * given Extent.
     * 
     * @param extent The extent to use
     * @param position The world coordinates
     * @return The local coordinates relative to the given Extent
     */
    public static Vector3d worldToLocal(Extent extent, Vector3d position) {
        return worldToLocal(extent, position.getX(), position.getY(), position.getZ());
    }

    /**
     * Converts world vector coordinates into local coordinates relative to the
     * given Extent.
     * 
     * @param extent The extent to use
     * @param x The world x coordinate
     * @param y The world y coordinate
     * @param z The world z coordinate
     * @return The local coordinates relative to the given Extent
     */
    public static Vector3d worldToLocal(Extent extent, double x, double y, double z) {
        while (extent != null) {
            x += extent.getOrigin().getX();
            y += extent.getOrigin().getY();
            z += extent.getOrigin().getZ();
            extent = extent.getParent().orNull();
        }

        return new Vector3d(x, y, z);
    }

    private Extents() {
    }
}
