package org.spongepowered.api.util.blockray;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.extent.Extent;

/**
 * Represents a block hit by a ray. Stores more information than a regular location.
 * Extra object are lazily computed and cached.
 */
public class BlockRayHit {

    private final Extent extent;
    private final double x, y, z;
    private Vector3d position = null;
    private final int xBlock, yBlock, zBlock;
    private Vector3i blockPosition = null;
    private final Vector3d direction;
    private final Vector3d normal;
    private Direction[] faces = null;
    private Location location = null;

    /**
     * Constructs a new block ray hit from the extent that contains it, the coordinates
     * and the face that was entered.
     *
     * @param extent The extent of the block
     * @param x The x coordinate of the block
     * @param y The y coordinate of the block
     * @param z The x coordinate of the block
     * @param direction A normal vector of the ray direction
     * @param normal The normal of the entered face, edge or corner
     */
    public BlockRayHit(Extent extent, double x, double y, double z, Vector3d direction, Vector3d normal) {
        this.extent = extent;
        this.x = x;
        this.y = y;
        this.z = z;
        this.direction = direction;
        this.normal = normal;
        // Take into account the face through which we entered
        // so we know which block is the correct one
        this.xBlock = GenericMath.floor(x) - (normal.getX() > 0 ? 1 : 0);
        //noinspection SuspiciousNameCombination
        this.yBlock = GenericMath.floor(y) - (normal.getY() > 0 ? 1 : 0);
        this.zBlock = GenericMath.floor(z) - (normal.getZ() > 0 ? 1 : 0);
    }

    /**
     * Returns the extent that contains the block.
     *
     * @return The extent
     */
    public Extent getExtent() {
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
            this.position = new Vector3d(x, y, z);
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
     * Returns the location of the hit block, <b>not the intersection location</b>.
     *
     * @return The location of the hit block
     */
    public Location getLocation() {
        if (this.location == null) {
            this.location = new Location(this.extent, this.xBlock, this.yBlock, this.zBlock);
        }
        return location;
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
     * but if the ray enters an edge, two faces are returned (the ones that form it).
     * Similarly for corners, but three faces.
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
}
