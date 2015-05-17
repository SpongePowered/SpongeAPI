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

import static com.google.common.base.Preconditions.checkNotNull;

import com.flowpowered.math.vector.Vector3d;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.Location;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 */
public final class BlockSearchConditions {

    public static final BlockSearchCondition TRUE = new Fixed(true);
    public static final BlockSearchCondition FALSE = new Fixed(false);

    private static class Fixed implements BlockSearchCondition {

        private final boolean result;

        Fixed(boolean result) {
            super();
            this.result = result;
        }

        @Override
        public boolean apply(Location location, Direction faceDirection) {
            return this.result;
        }

    }

    private static abstract class Multi implements BlockSearchCondition {

        final List<BlockSearchCondition> conditions;

        Multi(Collection<? extends BlockSearchCondition> conditions) {
            super();
            this.conditions = ImmutableList.copyOf(checkNotNull(conditions, "conditions"));
        }

    }

    public static BlockSearchCondition and(BlockSearchCondition... conditions) {
        return and(Arrays.asList(checkNotNull(conditions, "conditions")));
    }

    public static BlockSearchCondition and(Collection<? extends BlockSearchCondition> conditions) {
        return new And(conditions);
    }

    private static class And extends Multi {

        And(Collection<? extends BlockSearchCondition> conditions) {
            super(conditions);
        }

        @Override
        public boolean apply(Location location, Direction faceDirection) {
            for (BlockSearchCondition condition : this.conditions) {
                if (!condition.apply(location, faceDirection)) {
                    return false;
                }
            }
            return true;
        }

    }

    public static BlockSearchCondition or(BlockSearchCondition... conditions) {
        return or(Arrays.asList(checkNotNull(conditions, "conditions")));
    }

    public static BlockSearchCondition or(Collection<? extends BlockSearchCondition> conditions) {
        return new Or(conditions);
    }

    private static class Or extends Multi {

        Or(Collection<? extends BlockSearchCondition> conditions) {
            super(conditions);
        }

        @Override
        public boolean apply(Location location, Direction faceDirection) {
            for (BlockSearchCondition condition : this.conditions) {
                if (condition.apply(location, faceDirection)) {
                    return true;
                }
            }
            return false;
        }

    }

    public static BlockSearchCondition locationFilter(Predicate<Location> filter) {
        return new LocationFilter(filter);
    }

    private static class LocationFilter implements BlockSearchCondition {

        private final Predicate<Location> filter;

        LocationFilter(Predicate<Location> filter) {
            super();
            this.filter = filter;
        }

        @Override
        public boolean apply(Location location, Direction faceDirection) {
            return this.filter.apply(location);
        }

    }

    public static BlockSearchCondition columnFilter(Vector3d direction) {
        return columnFilter(Direction.getClosestAxis(checkNotNull(direction, "direction")).getOpposite());
    }

    public static BlockSearchCondition columnFilter(Direction faceDirection) {
        return faceFilter(Predicates.equalTo(checkNotNull(faceDirection, "faceDirection")));
    }

    public static BlockSearchCondition faceFilter(Predicate<Direction> filter) {
        return new DirectionFilter(filter);
    }

    private static class DirectionFilter implements BlockSearchCondition {

        private final Predicate<Direction> filter;

        DirectionFilter(Predicate<Direction> filter) {
            super();
            this.filter = checkNotNull(filter, "filter");
        }

        @Override
        public boolean apply(Location location, Direction faceDirection) {
            return this.filter.apply(faceDirection);
        }

    }

}
