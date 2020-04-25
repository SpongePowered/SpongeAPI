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
package org.spongepowered.api.data.type;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.Cycleable;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Optional;

@CatalogedBy(RailDirections.class)
public interface RailDirection extends CatalogType, Cycleable<RailDirection> {

    /**
     * Returns the {@link RailDirection} from the given facing directions.
     *
     * @param firstDirection The first direction
     * @param secondDirection The second direction
     * @return The {@link RailDirection}
     * @throws IllegalArgumentException If the given directions don't differ
     */
    static RailDirection fromFaces(final Direction firstDirection, final Direction secondDirection) {
        checkNotNull(firstDirection, "firstDirection");
        checkNotNull(secondDirection, "secondDirection");

        Direction cardinalFirstDirection = Direction.getClosest(firstDirection.asOffset(), Direction.Division.CARDINAL);
        Direction cardinalSecondDirection = Direction.getClosest(secondDirection.asOffset(), Direction.Division.CARDINAL);

        if (cardinalFirstDirection.equals(cardinalSecondDirection)) {
            throw new IllegalArgumentException("The directions should be different!");
        }

        for (RailDirection currentRailDirection: Sponge.getRegistry().getAllForMinecraft(RailDirection.class)) {
            if (currentRailDirection.isFacing(cardinalFirstDirection) && currentRailDirection.isFacing(cardinalSecondDirection)) {
                return currentRailDirection;
            }
        }

        throw new AssertionError();
    }

    /**
     * Returns the {@link RailDirection} from the given ascending direction.
     *
     * @param ascendingDirection The ascending direction
     * @return The {@link RailDirection}
     */
    static RailDirection fromAscendingDirection(final Direction ascendingDirection) {
        checkNotNull(ascendingDirection, "ascendingDirection");

        Direction cardinalAscendingDirection = Direction.getClosest(ascendingDirection.asOffset(), Direction.Division.CARDINAL);

        for (RailDirection currentRailDirection: Sponge.getRegistry().getAllForMinecraft(RailDirection.class)) {
            Optional<Direction> currentAscendingDirectionBox = currentRailDirection.getAscendingDirection();

            if (currentAscendingDirectionBox.isPresent()) {
                Direction currentAscendingDirection = currentAscendingDirectionBox.get();

                if (currentAscendingDirection.equals(cardinalAscendingDirection)) {
                    return currentRailDirection;
                }
            }
        }

        throw new AssertionError();
    }

    /**
     * Returns the direction it's ascending to, if this rail direction is ascending.
     *
     * @return The ascending direction, if possible
     */
    Optional<Direction> getAscendingDirection();

    /**
     * Returns the first direction of this rail direction.
     *
     * @return The first direction
     * @see RailDirection#getSecondDirection()
     */
    Direction getFirstDirection();

    /**
     * Returns the second direction of this rail direction.
     *
     * @return The second direction
     * @see RailDirection#getFirstDirection()
     */
    Direction getSecondDirection();

    /**
     * Checks if the rail direction is facing to the given direction.
     *
     * <p>Any {@link RailDirection} always has two facing directions.</p>
     *
     * @param direction The direction
     * @return <b>true</b> if it's facing, else <b>false</b>
     */
    boolean isFacing(Direction direction);
}
