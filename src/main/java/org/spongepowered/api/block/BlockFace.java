/**
 + * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 + *
 + * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
 + *
 + * Permission is hereby granted, free of charge, to any person obtaining a copy
 + * of this software and associated documentation files (the "Software"), to deal
 + * in the Software without restriction, including without limitation the rights
 + * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 + * copies of the Software, and to permit persons to whom the Software is
 + * furnished to do so, subject to the following conditions:
 + *
 + * The above copyright notice and this permission notice shall be included in
 + * all copies or substantial portions of the Software.
 + *
 + * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 + * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 + * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 + * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 + * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 + * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 + * THE SOFTWARE.
 + */
package org.spongepowered.api.block;

public enum BlockFace {
    NORTH(0, 0, -1),
    EAST(1, 0, 0),
    SOUTH(0, 0, 1),
    WEST(-1, 0, 0),
    UP(0, 1, 0),
    DOWN(0, -1, 0),
    SELF(0, 0, 0),

    NORTH_EAST(NORTH, EAST),
    NORTH_WEST(NORTH, WEST),
    SOUTH_EAST(SOUTH, EAST),
    SOUTH_WEST(SOUTH, WEST),
    WEST_NORTH_WEST(WEST, NORTH_WEST),
    NORTH_NORTH_WEST(NORTH, NORTH_WEST),
    NORTH_NORTH_EAST(NORTH, NORTH_EAST),
    EAST_NORTH_EAST(EAST, NORTH_EAST),
    EAST_SOUTH_EAST(EAST, SOUTH_EAST),
    SOUTH_SOUTH_EAST(SOUTH, SOUTH_EAST),
    SOUTH_SOUTH_WEST(SOUTH, SOUTH_WEST),
    WEST_SOUTH_WEST(WEST, SOUTH_WEST);

    private final int modX;
    private final int modY;
    private final int modZ;

    /**
     * Creates a new BlockFace (cardinal directions).
     * @param modX Change in X value from current Voxel
     * @param modY Change in Y value from current Voxel
     * @param modZ Change in Z value from current Voxel
     */
    private BlockFace(final int modX, final int modY, final int modZ) {
        this.modX = modX;
        this.modY = modY;
        this.modZ = modZ;
    }

    /**
     * Creates a new BlockFace (non-cardinal directions).
     * @param face1 First BlockFace for calculation
     * @param face2 Second BlockFace for calculation
     */
    private BlockFace(final BlockFace face1, final BlockFace face2) {
        this.modX = face1.getModX() + face2.getModX();
        this.modY = face1.getModY() + face2.getModY();
        this.modZ = face1.getModZ() + face2.getModZ();
    }

    /**
     * Gets the change in X value from current Voxel.
     * @return modX
     */
    public int getModX() {
        return modX;
    }

    /**
     * Gets the change in Y value from current Voxel.
     * @return modY
     */
    public int getModY() {
        return modY;
    }

    /**
     * Gets the change in Z value from current Voxel.
     * @return modZ
     */
    public int getModZ() {
        return modZ;
    }

    /**
     * Calculates the opposite BlockFace from the current BlockFace.
     * @return The opposite BlockFace
     */
    public BlockFace getOppositeFace() {
        switch (this) {
            case NORTH:
                return BlockFace.SOUTH;

            case SOUTH:
                return BlockFace.NORTH;

            case EAST:
                return BlockFace.WEST;

            case WEST:
                return BlockFace.EAST;

            case UP:
                return BlockFace.DOWN;

            case DOWN:
                return BlockFace.UP;

            case NORTH_EAST:
                return BlockFace.SOUTH_WEST;

            case NORTH_WEST:
                return BlockFace.SOUTH_EAST;

            case SOUTH_EAST:
                return BlockFace.NORTH_WEST;

            case SOUTH_WEST:
                return BlockFace.NORTH_EAST;

            case WEST_NORTH_WEST:
                return BlockFace.EAST_SOUTH_EAST;

            case NORTH_NORTH_WEST:
                return BlockFace.SOUTH_SOUTH_EAST;

            case NORTH_NORTH_EAST:
                return BlockFace.SOUTH_SOUTH_WEST;

            case EAST_NORTH_EAST:
                return BlockFace.WEST_SOUTH_WEST;

            case EAST_SOUTH_EAST:
                return BlockFace.WEST_NORTH_WEST;

            case SOUTH_SOUTH_EAST:
                return BlockFace.NORTH_NORTH_WEST;

            case SOUTH_SOUTH_WEST:
                return BlockFace.NORTH_NORTH_EAST;

            case WEST_SOUTH_WEST:
                return BlockFace.EAST_NORTH_EAST;

            default:
                return BlockFace.SELF;
        }
    }
}
