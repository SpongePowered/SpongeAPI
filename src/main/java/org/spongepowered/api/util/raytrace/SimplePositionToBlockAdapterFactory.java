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

package org.spongepowered.api.util.raytrace;

import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.extent.Extent;

/**
 *
 */
public class SimplePositionToBlockAdapterFactory implements PositionToBlockAdapterFactory {

    @Override
    public PositionConsumer wrap(Extent world, BlockConsumer consumer) {
        return new PostionToBlockConsumer(world, consumer);
    }

    /**
     * Converts all incoming positions into blocks and forwards them to a
     * {@link BlockConsumer}.
     */
    public static class PostionToBlockConsumer implements PositionConsumer {

        private final Extent world;
        private final BlockConsumer consumer;

        /**
         * Creates a new PostionToBlockConsumer for the given world and the
         * given block consumer.
         *
         * @param world The world the locations are in
         * @param consumer The consumer that should consume the blocks
         */
        public PostionToBlockConsumer(Extent world, BlockConsumer consumer) {
            super();
            this.world = world;
            this.consumer = consumer;
        }

        @Override
        public boolean apply(double posX, double posY, double posZ, Vector3d rayDirection) {
            Direction faceDirection = null;
            if (posX % 1 == 0) {
                double dirX = rayDirection.getX();
                // Move inside the block
                posX += dirX;
                if (dirX > 0) {
                    faceDirection = Direction.NORTH;
                } else if (dirX < 0) {
                    faceDirection = Direction.SOUTH;
                }
            }
            if (posY % 1 == 0) {
                double dirY = rayDirection.getY();
                // Move inside the block
                posY += dirY;
                if (dirY > 0) {
                    faceDirection = Direction.DOWN;
                } else if (dirY < 0) {
                    faceDirection = Direction.UP;
                }
            }
            if (posZ % 1 == 0) {
                double dirZ = rayDirection.getZ();
                // Move inside the block
                posZ += dirZ;
                if (dirZ > 0) {
                    faceDirection = Direction.WEST;
                } else if (dirZ < 0) {
                    faceDirection = Direction.EAST;
                }
            }
            final Location location = new Location(this.world, posX, posY, posZ);
            return this.consumer.apply(location, faceDirection);
        }

    }

}
