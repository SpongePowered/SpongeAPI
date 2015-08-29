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

package org.spongepowered.api.event.block;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableMap;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockTransaction;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.Location;

/**
 * Called when a block at a {@link Location} triggers an update to one or more
 * {@link BlockState}s. There are always two ways to mark an "update" as being
 * "invalid" and "cancelled": {@link #filterDirections(Predicate)} will apply a
 * {@link Predicate} such that if the predicate returns <code>false</code>, the
 * {@link BlockTransaction} is marked "invalid" and therefor will not receive
 * an "update", and secondly through {@link #filter(Predicate)}
 * will apply a similar {@link Predicate} that if returning <code>false</code>,
 * the same {@link BlockTransaction} will be marked as "invalid" and therefor
 * will not receive an "update".
 */
public interface UpdateNeighborBlockEvent extends ChangeBlockEvent {

    /**
     * Gets the {@link ImmutableMap} of {@link Direction} to
     * {@link BlockTransaction} of the {@link BlockState}s that will be marked
     * for "updating". If a {@link BlockTransaction#isValid()} returns
     * <code>false</code>, the location will not be "updated".
     *
     * @return The map
     */
    ImmutableMap<Direction, BlockTransaction> getRelatives();

    /**
     * Filters out {@link Direction}s of the {@link BlockTransaction}s to be
     * marked as "valid" after this event. If the
     * {@link Predicate#apply(Object)} returns <code>false</code>, the
     * {@link BlockTransaction} for that {@link Direction} is marked as
     * "invalid" and will not receive an "update".
     *
     * @param predicate The predicate to use for filtering.
     */
    void filterDirections(Predicate<Direction> predicate);

    interface Ignite extends UpdateNeighborBlockEvent {

        interface SourceBlock extends Ignite, UpdateNeighborBlockEvent.SourceBlock { }

    }

    interface Spread extends UpdateNeighborBlockEvent {

        /**
         * Gets the {@link BlockState} that is being spread.
         *
         * <p>
         *     This block may or may not be the same as {@link BlockEvent#getSourceBlock()}.
         * </p>
         *
         * @return The BlockState
         */
        BlockState getSpreadingBlock();

        interface SourceBlock extends Spread, UpdateNeighborBlockEvent.SourceBlock { }

    }

    interface Burn extends UpdateNeighborBlockEvent {

        interface SourceBlock extends Burn, UpdateNeighborBlockEvent.SourceBlock { }

    }

    interface Power extends UpdateNeighborBlockEvent {

        interface SourceBlock extends Power, UpdateNeighborBlockEvent.SourceBlock { }

    }

    interface SourceBlock extends UpdateNeighborBlockEvent, ChangeBlockEvent.SourceBlock { }

}
