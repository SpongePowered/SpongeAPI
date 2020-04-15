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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import com.flowpowered.math.GenericMath;
import com.flowpowered.math.imaginary.Quaterniond;
import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;
import com.google.common.collect.ImmutableSet;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.property.block.FullBlockSelectionBoxProperty;
import org.spongepowered.api.data.property.entity.EyeLocationProperty;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.util.Functional;
import org.spongepowered.api.util.Tuple;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.extent.Extent;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import javax.annotation.Nullable;

/**
 * A block ray which traces a line and returns all block boundaries intersected
 * in order, starting from the start location. If the ray starts in a block,
 * that block is never returned because it is never entered (the ray is already
 * inside).
 *
 * <p>This class implements the {@link Iterator} interface with the exception
 * of {@link Iterator#remove()}.</p>
 *
 * <p>Filters determine what blocks the {@link BlockRay} should accept. First
 * the continuation filter(s) (provided by
 * {@link BlockRayBuilder#whilst(Predicate)}) are checked. If any of the
 * provided filters return {@code false} then the iterator ends there - no more
 * matches may be made by this ray.</p>
 *
 * <p>If this ray has not been stopped, the selection filter(s) (provided by
 * {@link BlockRayBuilder#select(Predicate)}) are called. If any of the
 * provided filters returns {@code false} then the iterator proceeds to the
 * next block and it is never returned as a {@link BlockRayHit}. Otherwise
 * the block is returned and the iterator is paused, awaiting a {@link #next()}
 * call to resume tracing. If the distance limit is enabled then it is applied
 * before both continuation and select checks and acts like the a {@code false}
 * result has been returned by a continuation filter.</p>
 *
 * <p>Any one instance of a {@link Predicate} should only be run on one path.
 * It is not specified that {@link Predicate}s have to be stateless, pure
 * functions. They are allowed to keep state along an individual path, based on
 * the assertion that a single instance is only called on one path.</p>
 *
 * <p>Filters are most useful for limiting the target block a player is looking
 * at based on some metric, like transparency, block model, or even distance.
 * The standard Bukkit-like behavior for finding the target block can be
 * achieved with using {@link BlockRay#ONLY_AIR_FILTER} as the
 * continue filter, combined with
 * {@link #continueAfterFilter(Predicate, int)} with a second argument of 1, to
 * enable the ray to iterate such that it can select the block just after the
 * last air. A {@link #notAirFilter()} can then be used as the select filter
 * to select the non-air block. Thus:</p>
 *
 * <pre>
 * BlockRay.from(fromLocation)
 *     .to(toLocation)
 *     .select(BlockRay.notAirFilter())
 *     .whilst(BlockRay.continueAfterFilter(BlockRay.onlyAirFilter(), 1))
 *     .build();
 * </pre>
 *
 * <p>will scan the blocks between the two specified locations to locate the
 * first non-air block along the line from the {@code fromLocation} to the
 * {@code toLocation}.</p>
 *
 * <p>To get a block ray for an entities' line of sight, use
 * <pre>{@code BlockRay.from(entity);}</pre></p>
 *
 * @param <E> The extent in which this ray is being cast
 * @see BlockRayHit
 */
public class BlockRay<E extends Extent> implements Iterator<BlockRayHit<E>> {

    @SuppressWarnings("rawtypes")
    private static final Predicate ONLY_AIR_FILTER = blockTypeFilter(BlockTypes.AIR);
    @SuppressWarnings("rawtypes")
    static final Predicate ALL_FILTER = input -> true;

    private static final Vector3d X_POSITIVE = Vector3d.UNIT_X;
    private static final Vector3d X_NEGATIVE = X_POSITIVE.negate();
    private static final Vector3d Y_POSITIVE = Vector3d.UNIT_Y;
    private static final Vector3d Y_NEGATIVE = Y_POSITIVE.negate();
    private static final Vector3d Z_POSITIVE = Vector3d.UNIT_Z;
    private static final Vector3d Z_NEGATIVE = Z_POSITIVE.negate();
    // Skipping and ending test predicates
    private final Predicate<BlockRayHit<E>> selectFilter;
    private final Predicate<BlockRayHit<E>> continueFilter;
    private final Predicate<BlockRayHit<E>> targetBlockFilter;
    // Extent to iterate in
    private final E extent;
    // Starting position
    private final Vector3d position;
    // Direction of the ray
    private final Vector3d direction;
    // Perform narrow phase intersections for blocks with smaller selection boxes
    private final boolean narrowPhase;
    // The directions the faces are passed through
    private final Vector3d xNormal;
    private final Vector3d yNormal;
    private final Vector3d zNormal;
    // The directions the edges and corners are passed through, lazily computed
    private Vector3d xyzNormal;
    private Vector3d xyNormal;
    private Vector3d xzNormal;
    private Vector3d yzNormal;
    // The plane increments for the direction
    private final int xPlaneIncrement;
    private final int yPlaneIncrement;
    private final int zPlaneIncrement;
    // The current coordinates
    private double xCurrent;
    private double yCurrent;
    private double zCurrent;
    // The current passed face
    private Vector3d normalCurrent;
    // The next plane values
    private int xPlaneNext;
    private int yPlaneNext;
    private int zPlaneNext;
    // The solutions for the nearest plane intersections
    private double xPlaneT;
    private double yPlaneT;
    private double zPlaneT;
    // Limits to help prevent infinite iteration
    private final double distanceLimit;
    // Last block hit
    private BlockRayHit<E> hit;
    // If hasNext() is called, we need to move ahead to check the next hit
    private boolean ahead;

    private BlockRay(Predicate<BlockRayHit<E>> selectFilter, Predicate<BlockRayHit<E>> continueFilter, E extent, Vector3d position, Vector3d direction,
            boolean narrowPhase, double distanceLimit, @Nullable TargetBlockFilter<E> targetBlockFilter) {
        checkArgument(direction.lengthSquared() != 0, "Direction cannot be the zero vector");

        this.selectFilter = selectFilter;
        this.continueFilter = continueFilter;

        this.extent = extent;
        this.position = position;
        this.direction = direction;

        this.narrowPhase = narrowPhase;

        this.distanceLimit = distanceLimit;
        this.targetBlockFilter = targetBlockFilter == null ? input -> true : targetBlockFilter;

        // Figure out the direction of the ray for each axis
        if (this.direction.getX() >= 0) {
            this.xPlaneIncrement = 1;
            this.xNormal = X_NEGATIVE;
        } else {
            this.xPlaneIncrement = -1;
            this.xNormal = X_POSITIVE;
        }
        if (this.direction.getY() >= 0) {
            this.yPlaneIncrement = 1;
            this.yNormal = Y_NEGATIVE;
        } else {
            this.yPlaneIncrement = -1;
            this.yNormal = Y_POSITIVE;
        }
        if (this.direction.getZ() >= 0) {
            this.zPlaneIncrement = 1;
            this.zNormal = Z_NEGATIVE;
        } else {
            this.zPlaneIncrement = -1;
            this.zNormal = Z_POSITIVE;
        }

        reset();
    }

    /**
     * Resets the iterator; it will iterate from the starting location again.
     */
    public final void reset() {
        // Start at the position
        this.xCurrent = this.position.getX();
        this.yCurrent = this.position.getY();
        this.zCurrent = this.position.getZ();

        // First planes are for the block that contains the coordinates
        this.xPlaneNext = GenericMath.floor(this.xCurrent);
        // noinspection SuspiciousNameCombination
        this.yPlaneNext = GenericMath.floor(this.yCurrent);
        this.zPlaneNext = GenericMath.floor(this.zCurrent);

        // Correct the next planes for the direction when inside the block
        if (this.xCurrent - this.xPlaneNext != 0 && this.direction.getX() >= 0) {
            this.xPlaneNext++;
        }
        if (this.yCurrent - this.yPlaneNext != 0 && this.direction.getY() >= 0) {
            this.yPlaneNext++;
        }
        if (this.zCurrent - this.zPlaneNext != 0 && this.direction.getZ() >= 0) {
            this.zPlaneNext++;
        }

        // Compute the first intersection solutions for each plane
        this.xPlaneT = (this.xPlaneNext - this.position.getX()) / this.direction.getX();
        this.yPlaneT = (this.yPlaneNext - this.position.getY()) / this.direction.getY();
        this.zPlaneT = (this.zPlaneNext - this.position.getZ()) / this.direction.getZ();

        // We start in the block, no plane has been entered yet
        this.normalCurrent = Vector3d.ZERO;

        // Reset the block
        this.ahead = false;
        this.hit = null;
    }

    @Override
    public boolean hasNext() {
        if (this.ahead) {
            // We already checked
            return true;
        }
        try {
            advance();
            this.ahead = true;
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    @Override
    public BlockRayHit<E> next() {
        if (this.ahead) {
            // We already advanced in hasNext()
            this.ahead = false;
        } else {
            advance();
        }
        return this.hit;
    }

    /**
     * Traces the block ray to the end and returns the last block
     * accepted by the filter, or none if the extent or block limit was reached.
     * This advances the iterator.
     *
     * @return The last block of the ray, if any
     */
    public Optional<BlockRayHit<E>> end() {
        BlockRayHit<E> last = null;
        while (hasNext()) {
            last = next();
        }
        return Optional.ofNullable(last);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    private void advance() {
        while (!advanceOneBlock()) {
        }
    }

    private boolean advanceOneBlock() {
        /*
            The ray can be modeled using the following parametric equations:
                x = d_x * t + p_x
                y = d_y * t + p_y
                z = d_z * t + p_z
            Where d is the direction vector, p the starting point and t is in |R.

            The block boundary grid can be modeled as an infinity of perpendicular planes
            on the x, y and z axes, on integer coordinates, spaced 1 unit away.

            Such a plane has an equation:
                A = n
            Where A is the axis label and n is in |Z

            The solution of the intersection between the above ray and such a plane is:
                n = d_A * t_s + p_A
                t_s = (n - p_A) / d_A

                x_s = d_x * t_s + p_x
                y_s = d_y * t_s + p_y
                z_s = d_z * t_s + p_z

            Where t_s is the solution parameter and x_s, y_s, z_s are the intersection coordinates.
            A small optimization is that A_s = n, which also helps with rounding errors.

            The iterator solves these equations and provides the solutions in increasing order with respect to t_s.
        */

        if (this.direction.getX() == 0) {
            if (this.direction.getY() == 0) {
                // Only zPlaneT exists
                zIntersect();
            } else if (this.direction.getZ() == 0) {
                // Only yPlaneT exists
                yIntersect();
            } else {
                // yPlaneT and zPlaneT exist
                solveIntersections();
            }
        } else if (this.direction.getY() == 0) {
            if (this.direction.getZ() == 0) {
                // Only xPlaneT exists
                xIntersect();
            } else {
                // xPlaneT and zPlaneT exist
                solveIntersections();
            }
        } else {
            // xPlaneT and yPlaneT exist
            solveIntersections();
        }

        BlockRayHit<E> hit = new BlockRayHit<>(this.extent, this.xCurrent, this.yCurrent, this.zCurrent, this.direction, this.normalCurrent);

        // Make sure we actually have a block
        if (!hit.mapBlock(Extent::containsBlock)) {
            throw new NoSuchElementException("Extent limit reached");
        }

        // Now if using the narrow phase, test on small selection boxes, if needed
        if (this.narrowPhase && !hit.getExtent().getProperty(hit.getBlockPosition(), FullBlockSelectionBoxProperty.class)
                .map(FullBlockSelectionBoxProperty::getValue).orElse(true)) {
            // Get the selection box and perform the narrow phase intersection test
            final Optional<Tuple<Vector3d, Vector3d>> intersection = hit.mapBlock(Extent::getBlockSelectionBox)
                .flatMap(aabb -> aabb.intersects(this.position, this.direction));
            // Create the new narrow hit if there was an intersection
            if (intersection.isPresent()) {
                final Tuple<Vector3d, Vector3d> pair = intersection.get();
                final Vector3d narrowHit = pair.getFirst();
                hit = new BlockRayHit<>(this.extent, narrowHit.getX(), narrowHit.getY(), narrowHit.getZ(), this.direction, pair.getSecond());
            } else {
                // Otherwise return false to attempt the next block
                return false;
            }
        }

        // Check the distance limit if in use
        if (this.distanceLimit >= 0 && this.position.distanceSquared(hit.getPosition()) > this.distanceLimit * this.distanceLimit) {
            throw new NoSuchElementException("Distance limit reached");
        }

        // Check the block end filter (see continueWhen())
        if (!this.continueFilter.test(hit) || !this.targetBlockFilter.test(hit)) {
            throw new NoSuchElementException("Filter limit reached");
        }

        // Check the block skip filter (see selectWhen())
        if (!this.selectFilter.test(hit)) {
            return false;
        }

        this.hit = hit;
        return true;
    }

    private void solveIntersections() {
        if (this.xPlaneT == this.yPlaneT) {
            if (this.xPlaneT == this.zPlaneT) {
                // xPlaneT, yPlaneT and zPlaneT are equal
                xyzIntersect();
            } else {
                // xPlaneT and yPlaneT are equal
                xyIntersect();
            }
        } else if (this.xPlaneT == this.zPlaneT) {
            // xPlaneT and zPlaneT are equal
            xzIntersect();
        } else if (this.yPlaneT == this.zPlaneT) {
            // yPlaneT and zPlaneT are equal
            yzIntersect();
        } else if (this.xPlaneT < this.yPlaneT) {
            if (this.xPlaneT < this.zPlaneT) {
                // xPlaneT is smallest
                xIntersect();
            } else {
                // zPlaneT is smallest
                zIntersect();
            }
        } else if (this.yPlaneT < this.zPlaneT) {
            // yPlaneT is smallest
            yIntersect();
        } else {
            // zPlaneT is smallest
            zIntersect();
        }
    }

    private void xyzIntersect() {
        this.xCurrent = this.xPlaneNext;
        this.yCurrent = this.yPlaneNext;
        this.zCurrent = this.zPlaneNext;
        this.normalCurrent = getXyzNormal();
        // Prepare next intersection
        this.xPlaneNext += this.xPlaneIncrement;
        this.yPlaneNext += this.yPlaneIncrement;
        this.zPlaneNext += this.zPlaneIncrement;
        this.xPlaneT = (this.xPlaneNext - this.position.getX()) / this.direction.getX();
        this.yPlaneT = (this.yPlaneNext - this.position.getY()) / this.direction.getY();
        this.zPlaneT = (this.zPlaneNext - this.position.getZ()) / this.direction.getZ();
    }

    private void xyIntersect() {
        this.xCurrent = this.xPlaneNext;
        this.yCurrent = this.yPlaneNext;
        this.zCurrent = this.direction.getZ() * this.xPlaneT + this.position.getZ();
        this.normalCurrent = getXyNormal();
        // Prepare next intersection
        this.xPlaneNext += this.xPlaneIncrement;
        this.yPlaneNext += this.yPlaneIncrement;
        this.xPlaneT = (this.xPlaneNext - this.position.getX()) / this.direction.getX();
        this.yPlaneT = (this.yPlaneNext - this.position.getY()) / this.direction.getY();
    }

    private void xzIntersect() {
        this.xCurrent = this.xPlaneNext;
        this.yCurrent = this.direction.getY() * this.xPlaneT + this.position.getY();
        this.zCurrent = this.zPlaneNext;
        this.normalCurrent = getXzNormal();
        // Prepare next intersection
        this.xPlaneNext += this.xPlaneIncrement;
        this.zPlaneNext += this.zPlaneIncrement;
        this.xPlaneT = (this.xPlaneNext - this.position.getX()) / this.direction.getX();
        this.zPlaneT = (this.zPlaneNext - this.position.getZ()) / this.direction.getZ();
    }

    private void yzIntersect() {
        this.xCurrent = this.direction.getX() * this.yPlaneT + this.position.getX();
        this.yCurrent = this.yPlaneNext;
        this.zCurrent = this.zPlaneNext;
        this.normalCurrent = getYzNormal();
        // Prepare next intersection
        this.yPlaneNext += this.yPlaneIncrement;
        this.zPlaneNext += this.zPlaneIncrement;
        this.yPlaneT = (this.yPlaneNext - this.position.getY()) / this.direction.getY();
        this.zPlaneT = (this.zPlaneNext - this.position.getZ()) / this.direction.getZ();
    }

    private void xIntersect() {
        this.xCurrent = this.xPlaneNext;
        this.yCurrent = this.direction.getY() * this.xPlaneT + this.position.getY();
        this.zCurrent = this.direction.getZ() * this.xPlaneT + this.position.getZ();
        this.normalCurrent = this.xNormal;
        // Prepare next intersection
        this.xPlaneNext += this.xPlaneIncrement;
        this.xPlaneT = (this.xPlaneNext - this.position.getX()) / this.direction.getX();
    }

    private void yIntersect() {
        this.xCurrent = this.direction.getX() * this.yPlaneT + this.position.getX();
        this.yCurrent = this.yPlaneNext;
        this.zCurrent = this.direction.getZ() * this.yPlaneT + this.position.getZ();
        this.normalCurrent = this.yNormal;
        // Prepare next intersection
        this.yPlaneNext += this.yPlaneIncrement;
        this.yPlaneT = (this.yPlaneNext - this.position.getY()) / this.direction.getY();
    }

    private void zIntersect() {
        this.xCurrent = this.direction.getX() * this.zPlaneT + this.position.getX();
        this.yCurrent = this.direction.getY() * this.zPlaneT + this.position.getY();
        this.zCurrent = this.zPlaneNext;
        this.normalCurrent = this.zNormal;
        // Prepare next intersection
        this.zPlaneNext += this.zPlaneIncrement;
        this.zPlaneT = (this.zPlaneNext - this.position.getZ()) / this.direction.getZ();
    }

    private Vector3d getXyzNormal() {
        if (this.xyzNormal == null) {
            this.xyzNormal = this.xNormal.add(this.yNormal).add(this.zNormal).normalize();
        }
        return this.xyzNormal;
    }

    private Vector3d getXyNormal() {
        if (this.xyNormal == null) {
            this.xyNormal = this.xNormal.add(this.yNormal).normalize();
        }
        return this.xyNormal;
    }

    private Vector3d getXzNormal() {
        if (this.xzNormal == null) {
            this.xzNormal = this.xNormal.add(this.zNormal).normalize();
        }
        return this.xzNormal;
    }

    private Vector3d getYzNormal() {
        if (this.yzNormal == null) {
            this.yzNormal = this.yNormal.add(this.zNormal).normalize();
        }
        return this.yzNormal;
    }

    /**
     * Initializes a block ray builder with the given starting location.
     *
     * @param start The starting location
     * @param <E> The extent to be applied in
     * @return A new block ray builder
     */
    public static <E extends Extent> BlockRayBuilder<E> from(Location<E> start) {
        checkNotNull(start, "start");
        return from(start.getExtent(), start.getPosition());
    }

    /**
     * Initializes a block ray builder with the given starting location.
     *
     * @param extent The extent in which to trace the ray
     * @param start The starting position
     * @param <E> The extent to be applied in
     * @return A new block ray builder
     */
    public static <E extends Extent> BlockRayBuilder<E> from(E extent, Vector3d start) {
        checkNotNull(extent, "extent");
        checkNotNull(start, "start");
        return new BlockRayBuilder<>(extent, start);
    }

    /**
     * Initializes a block ray builder for the entity's eye.
     * If the eye location isn't defined for the entity, the
     * regular location is used. This sets both the starting
     * point and direction.
     *
     * @param entity The entity
     * @return A new block ray builder
     */
    public static BlockRayBuilder<World> from(Entity entity) {
        checkNotNull(entity, "entity");
        final Vector3d rotation = entity.getRotation();
        final Vector3d direction = Quaterniond.fromAxesAnglesDeg(rotation.getX(), -rotation.getY(), rotation.getZ()).getDirection();
        final Location<World> location = entity.getLocation();
        final Optional<EyeLocationProperty> data = entity.getProperty(EyeLocationProperty.class);
        final Vector3d position = data.map(EyeLocationProperty::getValue).orElse(location.getPosition());
        return from(location.getExtent(), position).direction(direction);
    }

    /**
     * A builder for block ray, which also implements {@link Iterable}, making it
     * useful for 'advanced for loops'. Use {@link #from(Location)} to get an instance.
     *
     * @param <E> The type of the extent for the block ray
     */
    public static class BlockRayBuilder<E extends Extent> implements Iterable<BlockRayHit<E>> {

        private static final double DEFAULT_DISTANCE_LIMIT = 1000;
        private final E extent;
        private final Vector3d position;
        private Predicate<BlockRayHit<E>> selectFilter = allFilter();
        private Predicate<BlockRayHit<E>> whilstFilter = allFilter();
        private final Set<ContinueAfterFilter<E>> resettablePredicates = new HashSet<>();
        private Vector3d direction = null;
        private double distanceLimit = DEFAULT_DISTANCE_LIMIT;
        private boolean narrowPhase = true;
        private TargetBlockFilter<E> targetBlockPredicate;

        private BlockRayBuilder(E extent, Vector3d position) {
            this.extent = extent;
            this.position = position;
        }

        /**
         * Adds the filter to the block ray.
         * The block ray will skip over blocks that do not pass this predicate.
         * This is optional.
         * Multiple filters will be ANDed together.
         *
         * @deprecated Use {@link #select(Predicate)}
         * @param skipFilter The filter to add
         * @return This for chained calls
         */
        @Deprecated
        public BlockRayBuilder<E> skipFilter(final Predicate<BlockRayHit<E>> skipFilter) {
            if (this.selectFilter == ALL_FILTER) {
                return this.select(skipFilter);
            } else {
                return this.select(Functional.predicateAnd(this.selectFilter, skipFilter));
            }
        }

        /**
         * Adds filters to the block ray.
         * The block ray will skip over blocks that do not pass this predicate.
         * This is optional.
         * Multiple filters will be ANDed together.
         *
         * @deprecated Use {@link #select(Predicate)}
         * @param skipFilters The filters to add
         * @return This for chained calls
         */
        @SafeVarargs
        @SuppressWarnings("varargs")
        @Deprecated
        public final BlockRayBuilder<E> skipFilter(final Predicate<BlockRayHit<E>>... skipFilters) {
            Predicate<BlockRayHit<E>> func = Functional.predicateAnd(skipFilters);
            if (this.selectFilter == ALL_FILTER) {
                return this.select(func);
            } else {
                return this.select(Functional.predicateAnd(this.selectFilter, func));
            }
        }

        /**
         * Adds a filter to the {@link BlockRay} that determines whether a
         * potential {@link BlockRayHit} is a valid result, and should
         * therefore be returned by the {@link BlockRay}, pausing the ray
         * trace. A ray trace that has been paused due to a {@link BlockRayHit}
         * being returned by virtue of this predicate may be continued by
         * calling {@link #next()} on the associated {@link BlockRay}.
         *
         * <p><strong>Take care when using this in combination with
         * {@link #whilst(Predicate)}</strong>. For any predicate
         * supplied here to match a {@link BlockRayHit}, it must also be
         * allowed by any predicates supplied to
         * {@link #whilst(Predicate)}.</p>
         *
         * <p>Only one filter may be applied using this method. If a second
         * filter is applied, it will overwrite the first.</p>
         *
         * <p>This is optional. If not specified, defaults to
         * {@link #allFilter()}.</p>
         *
         * @see #whilst(Predicate)
         * @param filter A filter which determines whether a ray has
         *  completed
         * @return This builder, for chaining.
         */
        public final BlockRayBuilder<E> select(final Predicate<BlockRayHit<E>> filter) {
            checkNotNull(filter, "filter");
            this.selectFilter = filter;
            return this;
        }

        /**
         * Adds a filter to the {@link BlockRay} that determines the conditions
         * upon which a {@link BlockRay} may continue to iterate. Such a filter
         * <strong>does not</strong> cause a {@link BlockRayHit} to be returned,
         * instead, it defines the point in which a {@link BlockRay} trace should
         * be considered to be at its end and should not attempt to trace further.
         *
         * <p>The block ray will continue while the {@link BlockRayHit}s that are
         * supplied to this {@link Predicate} return {@code true}. It will
         * <strong>end</strong> when a {@link BlockRayHit} fails the supplied
         * predicate - at which point the iteration will end and no further calls
         * to {@link BlockRay#next()} will be possible.</p>
         *
         * <p>For example, if you supply the following filter to this method:
         * </p>
         *
         * <pre>
         *     input -> {
         *         BlockType type = input.getLocation().getBlockType();
         *         return type == BlockTypes.AIR || type == BlockTypes.WATER;
         *     }
         * </pre>
         *
         * <p>then the {@link BlockRay} will trace through air and water,
         * stopping when at the boundary of any other block not matched
         * by the predicate.</p>
         *
         * <p>Only one filter may be applied using this method. If a second
         * filter is applied, it will overwrite the first.</p>
         *
         * <p>This is optional. If not specified, defaults to
         * {@link #allFilter()}</p>
         *
         * <p>If you wish to cause the ray to return a {@link BlockRayHit},
         * supply a predicate to {@link #select(Predicate)} instead.
         * </p>
         *
         * @see #select(Predicate)
         * @param filter The filter to add
         * @return This builder, for chaining.
         */
        public final BlockRayBuilder<E> whilst(final Predicate<BlockRayHit<E>> filter) {
            checkNotNull(filter, "filter");
            this.whilstFilter = filter;
            return this;
        }

        /**
         * Adds the filter to the block ray.
         * The block ray will end if a block does not pass this predicate.
         * This is optional.
         * Multiple filters will be ANDed together.
         *
         * @deprecated Confusing name. Use {@link #whilst(Predicate)}
         *  instead.
         * @param stopFilter The filter to add
         * @return This for chained calls
         */
        @Deprecated
        public BlockRayBuilder<E> stopFilter(final Predicate<BlockRayHit<E>> stopFilter) {
            if (this.whilstFilter == ALL_FILTER) {
                return this.whilst(stopFilter);
            } else {
                return this.whilst(Functional.predicateAnd(this.whilstFilter, stopFilter));
            }
        }

        /**
         * Adds filters to the block ray.
         * The block ray will end if a block does not pass this predicate.
         * This is optional.
         * Multiple filters will be ANDed together.
         *
         * @param stopFilters The filters to add
         * @return This for chained calls
         */
        @SafeVarargs
        @SuppressWarnings("varargs")
        @Deprecated
        public final BlockRayBuilder<E> stopFilter(final Predicate<BlockRayHit<E>>... stopFilters) {
            Predicate<BlockRayHit<E>> func = Functional.predicateAnd(stopFilters);
            if (this.whilstFilter == ALL_FILTER) {
                return this.whilst(func);
            } else {
                return this.whilst(Functional.predicateAnd(this.whilstFilter, func));
            }
        }

        /**
         * Sets the direction and ending location. This or setting the direction
         * is required and can only be done once.
         *
         * @param end The ending location
         * @return This for chained calls
         */
        public BlockRayBuilder<E> to(Vector3d end) {
            checkState(this.direction == null, "Direction has already been set");
            checkNotNull(end, "end");
            checkArgument(!this.position.equals(end), "Start and end cannot be equal");
            this.direction = end.sub(this.position).normalize();
            this.targetBlockPredicate = new TargetBlockFilter<>(end);
            return this;
        }

        /**
         * Sets the direction. This or setting the ending location is required
         * and can only be done once.
         *
         * @param direction The direction
         * @return This for chained calls
         */
        public BlockRayBuilder<E> direction(Vector3d direction) {
            checkState(this.direction == null, "Direction has already been set");
            checkNotNull(direction, "direction");
            checkArgument(direction.lengthSquared() != 0, "Direction must be a non-zero vector");
            this.direction = direction.normalize();
            return this;
        }

        /**
         * Sets the maximum distance before stopping.
         * This is a safeguard to prevent infinite iteration.
         * Default value is 1000. Use a negative value to disable this.
         *
         * @param distanceLimit The distance limit
         * @return This for chained calls
         */
        public BlockRayBuilder<E> distanceLimit(double distanceLimit) {
            this.distanceLimit = distanceLimit;
            return this;
        }

        /**
         * Sets whether or not to perform narrow phase intersections. The
         * narrow phase performs intersections with the block selection boxes
         * if they are smaller than a voxel. This is necessary to obtain
         * correct intersections with small blocks like: signs, buttons,
         * fences, etc. This is enabled by default.
         *
         * @param enable Whether or not to enable the narrow phase
         * @return This for chained calls
         */
        public BlockRayBuilder<E> narrowPhase(boolean enable) {
            this.narrowPhase = enable;
            return this;
        }

        /**
         * Gets the starting position of the block ray. Given here since some
         * filters might require it.
         *
         * @return The position of the block ray
         */
        public Vector3d position() {
            return this.position;
        }

        /**
         * Returns a block ray build from the settings. An ending location or
         * direction needs to have been set.
         *
         * @return A block ray
         */
        public BlockRay<E> build() {
            checkState(this.direction != null, "Either end point or direction needs to be set");
            return new BlockRay<>(this.selectFilter, this.whilstFilter, this.extent, this.position, this.direction, this.narrowPhase,
                    this.distanceLimit, this.targetBlockPredicate);
        }

        @Override
        public Iterator<BlockRayHit<E>> iterator() {
            return build();
        }

        /**
         * Iterates the built block ray until the end
         * and returns the last hit, if any.
         *
         * @return The last block hit, if any
         * @see #build()
         * @see BlockRay#end()
         */
        public Optional<BlockRayHit<E>> end() {
            return build().end();
        }
    }

    /**
     * A filter that returns {@code true} for any input.
     *
     * <p>In the absence of any other filter, this is the default filter applied
     * to:</p>
     *
     * <ul>
     *     <li>{@link BlockRayBuilder#whilst(Predicate)}</li>
     *     <li>{@link BlockRayBuilder#select(Predicate)}</li>
     * </ul>
     *
     * <p><strong>Be careful:</strong> if no other constraints are placed on
     * {@link BlockRayBuilder#whilst(Predicate)} and
     * {@link BlockRayBuilder#select(Predicate)} is given a {@link Predicate}
     * that has a narrower focus, a ray may never find a match and therefore
     * continue endlessly.</p>
     *
     * @param <E> The extent to be applied in
     * @return A filter that accepts all blocks
     */
    @SuppressWarnings("unchecked")
    public static <E extends Extent> Predicate<BlockRayHit<E>> allFilter() {
        return ALL_FILTER;
    }

    /**
     * A filter that will only return {@code true} when the {@link BlockRayHit}
     * represents {@link BlockTypes#AIR}.
     *
     * <p>This is provided for convenience, as the default behavior in previous
     * systems was to pass through air blocks only until a non-air block was
     * hit.</p>
     *
     * @param <E> The extent to be applied in
     * @return A filter that only accepts air blocks
     */
    @SuppressWarnings("unchecked")
    public static <E extends Extent> Predicate<BlockRayHit<E>> onlyAirFilter() {
        return ONLY_AIR_FILTER;
    }

    /**
     * A filter that will return {@code true} when the {@link BlockRayHit}
     * <strong>does not</strong> represent {@link BlockTypes#AIR}.
     *
     * @param <E> The extent to be applied in
     * @return A filter that only accepts air blocks
     */
    @SuppressWarnings("unchecked")
    public static <E extends Extent> Predicate<BlockRayHit<E>> notAirFilter() {
        return ONLY_AIR_FILTER.negate();
    }

    /**
     * A filter that will only return {@code true} when the {@link BlockRayHit}
     * represents the supplied {@link BlockType}.
     *
     * @param type The type of block to allow
     * @param <E> The extent to be applied in
     * @return The filter instance
     */
    public static <E extends Extent> Predicate<BlockRayHit<E>> blockTypeFilter(final BlockType type) {
        return lastHit -> lastHit.getExtent().getBlockType(lastHit.getBlockX(), lastHit.getBlockY(), lastHit.getBlockZ()).equals(type);
    }

    /**
     * A filter that will return {@code true} when the {@link BlockRayHit}
     * represents <strong>any</strong> of the supplied {@link BlockType}s.
     *
     * @param types The type of block to allow
     * @param <E> The extent to be applied in
     * @return The filter instance
     */
    public static <E extends Extent> Predicate<BlockRayHit<E>> blockTypeFilter(final BlockType... types) {
        return lastHit -> {
            for (BlockType type : types) {
                if (lastHit.getExtent().getBlockType(lastHit.getBlockX(), lastHit.getBlockY(), lastHit.getBlockZ()).equals(type)) {
                    return true;
                }
            }

            return false;
        };
    }

    /**
     * Creates a filter that displaces a {@code false} result from the wrapped
     * {@link Predicate} by the provided {@code numberOfBlocks}, if this number
     * is positive.
     *
     * <p>If {@code numberOfBlocks} is non-positive, this filter will mirror
     * the behavior of the provided filter.</p>
     *
     * @param filter The filter to extend
     * @param numberOfBlocks The number of blocks to extend it by
     * @param <E> The extent to be applied in
     * @return The extended block filter
     */
    public static <E extends Extent> Predicate<BlockRayHit<E>> continueAfterFilter(Predicate<BlockRayHit<E>> filter, int numberOfBlocks) {
        return new ContinueAfterFilter<>(filter, numberOfBlocks);
    }

    private static class ContinueAfterFilter<E extends Extent> implements Predicate<BlockRayHit<E>> {

        private final Predicate<BlockRayHit<E>> filter;
        final int numberOfBlocks;
        int extraBlockCount = 0;

        ContinueAfterFilter(Predicate<BlockRayHit<E>> filter, int numberOfBlocks) {
            this.filter = filter;
            this.numberOfBlocks = numberOfBlocks;
        }

        @Override
        public boolean test(BlockRayHit<E> lastHit) {
            if (this.extraBlockCount <= 0) {
                if (!this.filter.test(lastHit)) {
                    this.extraBlockCount = 1;
                }
                return true;
            }
            return this.extraBlockCount++ < this.numberOfBlocks;
        }

        public void reset() {
            this.extraBlockCount = 0;
        }

    }

    private static class TargetBlockFilter<E extends Extent> implements Predicate<BlockRayHit<E>> {

        private final Vector3i target;

        TargetBlockFilter(Vector3d target) {
            this.target = target.toInt();
        }

        @Override
        public boolean test(BlockRayHit<E> lastHit) {
            return lastHit.getBlockX() != this.target.getX() || lastHit.getBlockY() != this.target.getY()
                || lastHit.getBlockZ() != this.target.getZ();
        }

    }

}
