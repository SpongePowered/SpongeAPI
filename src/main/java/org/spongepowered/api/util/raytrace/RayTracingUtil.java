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

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.vector.Vector3d;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.extent.Extent;

/**
 * A utility class for ray tracing.
 */
public final class RayTracingUtil {

    private static final Function<BlockConsumer, BlockConsumer> BLOCK_LIMITER = Functions.identity();
    private static final Function<PositionConsumer, PositionConsumer> POSITION_LIMITER = Functions.identity();

    /**
     * Starts the ray tracing from the given location.
     *
     * <p>Note: The range may be truncated by server settings.</p>
     *
     * @param location The location to start
     * @param direction The ray direction
     * @param consumer The consumer that consumes all visited blocks
     */
    public static void trace(Location location, Vector3d direction, BlockConsumer consumer) {
        trace(location.getPosition(), direction, new PostionToBlockConsumer(location.getExtent(), BLOCK_LIMITER.apply(consumer)));
    }

    /**
     * Starts the ray tracing from the given location.
     *
     * <p>Note: The range may be truncated by server settings.</p>
     *
     * @param world The world to search in
     * @param location The location to start
     * @param direction The ray direction
     * @param consumer The consumer that consumes all visited blocks
     */
    public static void trace(Extent world, Vector3d location, Vector3d direction, BlockConsumer consumer) {
        trace(location, direction, new PostionToBlockConsumer(world, BLOCK_LIMITER.apply(consumer)));
    }

    /**
     * Starts the ray tracing from the given location.
     *
     * <p>Note: The range may be truncated by server settings.</p>
     *
     * @param location The location to start
     * @param direction The ray direction
     * @param consumer The consumer that consumes all visited blocks
     */
    public static void trace(Vector3d location, Vector3d direction, PositionConsumer consumer) {
        double posX = location.getX();
        double posY = location.getY();
        double posZ = location.getZ();
        // Does not move?
        if (direction.lengthSquared() == 0) {
            consumer.apply(posX, posY, posZ, direction);
            return;
        }
        final Vector3d normalizedDirection = direction.normalize();
        final double dx = normalizedDirection.getX();
        final double dy = normalizedDirection.getY();
        final double dz = normalizedDirection.getZ();
        final double[] distances = new double[3];
        final PositionConsumer limitedConsumer = POSITION_LIMITER.apply(consumer);
        while (limitedConsumer.apply(posX, posY, posZ, direction)) {
            distances[0] = distance(posX, dx);
            distances[1] = distance(posY, dy);
            distances[2] = distance(posZ, dz);
            final double min = min(distances);
            posX = sanitize(posX + min * dx);
            posY = sanitize(posY + min * dy);
            posZ = sanitize(posZ + min * dz);
        }
    }

    // The minimum distance
    private static double min(double[] moves) {
        double min = moves[0];
        if (min > moves[1]) {
            min = moves[1];
        }
        if (min > moves[2]) {
            min = moves[2];
        }
        return min;
    }

    // times how often you have to apply the given direction to pass any borders
    private static double distance(double position, double direction) {
        if (direction == 0) {
            return Double.MAX_VALUE;
        }
        final double distanceLeft = (position % 1 + 1) % 1;
        final double absDirection = Math.abs(direction);
        if (distanceLeft == 0) {
            return 1 / absDirection;
        } else if (direction < 0) {
            return distanceLeft / absDirection;
        } else {
            return (1 - distanceLeft) / absDirection;
        }
    }

    // Sanitize the location (remove double fragments)
    private static double sanitize(double d) {
        final double dd = Math.abs(d % 1);
        if ((dd != 0 && dd < GenericMath.DBL_EPSILON * 2) || (dd != 1 && dd > 1 - GenericMath.DBL_EPSILON * 2)) {
            return Math.round(d);
        } else {
            return d;
        }
    }

    private RayTracingUtil() {
    }

}
