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

import com.google.common.base.Optional;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.Location;

/**
 * A {@link BlockConsumer} that returns the first block matching the
 * {@link BlockSearchCondition}.
 */
public class FirstMatchBlockConsumer implements BlockConsumer {

    private final BlockSearchCondition matchCondition;
    private Optional<Location> match = Optional.absent();

    /**
     * Creates a new FirstMatchBlockConsumer with the given search condition
     *
     * @param matchCondition The match condition
     */
    public FirstMatchBlockConsumer(BlockSearchCondition matchCondition) {
        super();
        this.matchCondition = matchCondition;
    }

    @Override
    public boolean apply(Location location, Direction faceDirection) {
        if (this.matchCondition.apply(location, faceDirection)) {
            this.match = Optional.of(location);
            return true;
        }
        return false;
    }

    /**
     * Gets the match if one was found.
     * 
     * @return The match if one was found
     */
    public Optional<Location> getMatch() {
        return this.match;
    }

}
