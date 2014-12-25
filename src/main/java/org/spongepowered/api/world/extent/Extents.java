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
