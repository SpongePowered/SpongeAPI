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
package org.spongepowered.api.event.action;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.GameEvent;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.List;

/**
 * Base event for when {@link BlockState}s at {@link Location<World>}s are being
 * changed.
 */
public interface ChangeBlockEvent extends GameEvent, CauseTracked, Cancellable {

    /**
     * Gets an {@link ImmutableList<BlockSnapshot>} of the block data un-affected by event changes.
     *
     * @return The ImmutableList
     */
    ImmutableList<BlockSnapshot> getSnapshots();

    /**
     * Gets the {@link List<Location<World>>} who will be affected after event resolution.
     *
     * @return The List
     */
    List<Location<World>> getLocations();

    /**
     * Gets the original {@link BlockState} that will replace the BlockStates in 
     * {@link ChangeBlockEvent#getSnapshots()} unaffected by event changes.
     *
     * @return The original replacement BlockState
     */
    BlockState getOriginalReplacementBlock();

    /**
     * Gets the {@link BlockState} that will replace the BlockStates in 
     * {@link ChangeBlockEvent#getLocations()} after event resolution.
     *
     * @return The replacement BlockState
     */
    BlockState getReplacementBlock();

    /**
     * Sets the {@link BlockState} that will replace the BlockStates in 
     * {@link ChangeBlockEvent#getLocations()} after event resolution.
     *
     * @param block The BlockState
     */
    void setReplacementBlock(BlockState block);

    /**
     * Gets the first {@link BlockState} within 
     * {@link ChangeBlockEvent#getSnapshots()} that will be changed
     * to {@link ChangeBlockEvent#getReplacementBlock()}.
     *
     * @return The BlockState
     */
    BlockState getTargetBlock();

    /**
     * Gets the first {@link Location<World>} within 
     * {@link ChangeBlockEvent#getSnapshots()} being changed.
     *
     * @return The Location
     */
    Location<World> getTargetLocation();

    /**
     * Filters out {@link Location<World>}'s from 
     * {@link ChangeBlockEvent#getLocations()} to be affected by this event.
     *
     * @param predicate The predicate to use for filtering
     * @return The filtered list
     */
    List<Location<World>> filterBlockLocations(Predicate<Location<World>> predicate);

}
