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

import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;

/**
 * This {@link BlockConsumer} collects all visited locations until the abort
 * {@link Condition} matches.
 */
public class VisitedBlockConsumer implements BlockConsumer {

    private final List<Location> locations = new ArrayList<Location>();
    private final BlockSearchCondition abortCondition;

    /**
     * Creates a new VisitedBlockConsumer with the given abort condition.
     *
     * @param abortCondition The condition to abort on
     */
    public VisitedBlockConsumer(BlockSearchCondition abortCondition) {
        super();
        this.abortCondition = abortCondition;
    }

    @Override
    public boolean apply(Location location, Direction faceDirection) {
        this.locations.add(location);
        return this.abortCondition.apply(location, faceDirection);
    }

    /**
     * Gets the list of visited locations.
     *
     * @return The list of visited locations
     */
    public List<Location> getLocations() {
        return this.locations;
    }

}
