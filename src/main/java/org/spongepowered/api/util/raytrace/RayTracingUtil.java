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
import org.spongepowered.api.world.extent.Extent;

/**
 * A utility class for ray tracing.
 */
public final class RayTracingUtil {

    /**
     * This applies some server side restrictions on {@link PositionConsumer}s.
     * Example limits execution to 200 times.
     */
    private static final Function<PositionConsumer, PositionConsumer> POSITION_LIMITER = Functions.identity();
    private static final PositionToBlockAdapterFactory FACE_BLOCKADAPTER = new SimplePositionToBlockAdapterFactory();
    private static final PositionToBlockAdapterFactory SOLIDBOX_BLOCKADAPTER = FACE_BLOCKADAPTER;
    private static final PositionToBlockAdapterFactory INTERACTBOX_BLOCKADAPTER = FACE_BLOCKADAPTER;

    /**
     * Wraps the given BlockConsumer in a {@link PositionConsumer}. This does
     * not check whether the block has been actually hit (Example button).
     *
     * @param world The world to search in
     * @param consumer The consumer that consumes all visited blocks
     * @return The wrapped consumer
     */
    public static PositionConsumer wrapFace(Extent world, BlockConsumer consumer) {
        return FACE_BLOCKADAPTER.wrap(world, consumer);
    }

    /**
     * Wraps the given BlockConsumer in a {@link PositionConsumer}. This tries
     * to check whether the solid box of the block has been hit. This wrapper
     * makes some assumptions on blocks, so it might not act the same as the
     * client.
     *
     * @param world The world to search in
     * @param consumer The consumer that consumes all visited blocks
     * @return The wrapped consumer
     */
    public static PositionConsumer wrapSolidBox(Extent world, BlockConsumer consumer) {
        return SOLIDBOX_BLOCKADAPTER.wrap(world, consumer);
    }

    /**
     * Wraps the given BlockConsumer in a {@link PositionConsumer}. This tries
     * to check whether the interact box of the block has been hit. This wrapper
     * makes some assumptions on blocks, so it might not act the same as the
     * client.
     *
     * @param world The world to search in
     * @param consumer The consumer that consumes all visited blocks
     * @return The wrapped consumer
     */
    public static PositionConsumer wrapInteractBox(Extent world, BlockConsumer consumer) {
        return INTERACTBOX_BLOCKADAPTER.wrap(world, consumer);
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
        // Our current location during ray tracing
        double posX = location.getX();
        double posY = location.getY();
        double posZ = location.getZ();

        if (direction.lengthSquared() == 0) {
            // If we don't move  we won't ever pass the borders of a block
            consumer.apply(posX, posY, posZ, direction);
            return;
        }
        final Vector3d normalizedDirection = direction.normalize();
        // The velocity we are moving with on each axis
        final double vX = normalizedDirection.getX();
        final double vY = normalizedDirection.getY();
        final double vZ = normalizedDirection.getZ();
        // Contains the times how often you have to apply the velocity until you
        // reach the next borders of a block for each axis
        final double[] distances = new double[3];

        // Apply some server side restrictions on position consumers
        final PositionConsumer limitedConsumer = POSITION_LIMITER.apply(consumer);

        // Start calculating ray tracing, starting with the origin
        while (limitedConsumer.apply(posX, posY, posZ, direction)) {
            // Calculate how many times we have to apply the velocity to reach the next block
            distances[0] = distance(posX, vX);
            distances[1] = distance(posY, vY);
            distances[2] = distance(posZ, vZ);
            // We don't want to miss a border, so we use the minimum
            final double min = min(distances);
            // And move that minimum time forward
            posX = sanitize(posX + min * vX);
            posY = sanitize(posY + min * vY);
            posZ = sanitize(posZ + min * vZ);
        }
    }

    /**
     * Calculates the minimum of those three array elements.
     *
     * @param values The values to get the minimum from
     * @return The minimum value
     */
    private static double min(double[] values) {
        double min = values[0];
        if (min > values[1]) {
            min = values[1];
        }
        if (min > values[2]) {
            min = values[2];
        }
        return min;
    }

    /**
     * Calculates how often you have to apply the given velocity until you reach
     * the next borders of a block on a single axis.
     *
     * @param position The position you are currently at on the current axis
     * @param velocity The velocity on the current axis
     * @return The total number of times you have to apply the given velocity to
     *         reach the next block borders
     */
    private static double distance(double position, double velocity) {
        if (velocity == 0) {
            // Do we move at all? If not we will never hit the borders
            return Double.MAX_VALUE;
        }
        // Calculate the distance to the next block border towards negative infinity
        final double distanceRemaining = (position % 1 + 1) % 1;
        final double absVelocity = Math.abs(velocity);
        if (distanceRemaining == 0) {
            // Are we currently at a border? Then we need to move an entire block
            return 1 / absVelocity;
        } else if (velocity < 0) {
            // Do we move towards negative infinity?
            return distanceRemaining / absVelocity;
        } else {
            // Otherwise calculate the remaining distance in the other direction
            return (1 - distanceRemaining) / absVelocity;
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
