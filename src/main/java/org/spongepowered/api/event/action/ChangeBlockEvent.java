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
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.GameEvent;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.Map;

/**
 * Base event for when {@link BlockState}s at {@link Location<World>}s are being
 * changed.
 */
public interface ChangeBlockEvent extends GameEvent, CauseTracked, Cancellable {

    /**
     * Gets a mutable copy of the original {@link Location<World>}s with their 
     * {@link BlockState}s being changed.
     *
     * @return The original map
     */
    Map<Location<World>, BlockState> getOriginalTargetBlocks();

    /**
     * Gets the mutable map of {@link Location<World>}s with their 
     * {@link BlockState}s that will be affected by the change dictated
     * in {@link ChangeBlockEvent#getReplacementBlock()} after event resolution.
     *
     * @return The map
     */
    Map<Location<World>, BlockState> getTargetBlocks();

    /**
     * Gets the original {@link BlockState} that will replace the BlockStates in 
     * {@link ChangeBlockEvent#getTargetBlocks()} unaffected by event changes.
     *
     * @return The original replacement BlockState
     */
    BlockState getOriginalReplacementBlock();

    /**
     * Gets the {@link BlockState} that will replace the BlockStates in 
     * {@link ChangeBlockEvent#getTargetBlocks()} after event resolution.
     *
     * @return The replacement BlockState
     */
    BlockState getReplacementBlock();

    /**
     * Sets the {@link BlockState} that will replace the BlockStates in 
     * {@link ChangeBlockEvent#getTargetBlocks()} after event resolution.
     *
     * @param block The BlockState
     */
    void setReplacementBlock(BlockState block);

    /**
     * Gets the first {@link BlockState} within 
     * {@link ChangeBlockEvent#getOriginalTargetBlocks()} that will be changed 
     * to {@link ChangeBlockEvent#getReplacementBlock()}.
     *
     * @return The BlockState
     */
    BlockState getFirstTargetBlock();

    /**
     * Gets the first {@link Location<World>} within 
     * {@link ChangeBlockEvent#getOriginalTargetBlocks()} being changed.
     *
     * @return The Location
     */
    Location<World> getFirstTargetLocation();

    /**
     * Filters out {@link Location<World>}'s from 
     * {@link ChangeBlockEvent#getTargetBlocks()} to be affected by this event.
     *
     * @param predicate The predicate to use for filtering
     * @return The filtered map
     */
    Map<Location<World>, BlockState> filterLocations(Predicate<Location<World>> predicate);

    /**
     * Filters out {@link BlockState}'s from 
     * {@link ChangeBlockEvent#getTargetBlocks()} to be affected by this event.
     *
     * @param predicate The predicate to use for filtering
     * @return The filtered map
     */
    Map<Location<World>, BlockState> filterBlocks(Predicate<BlockState> predicate);

    /**
     * Filters out {@link BlockState}'s based on their {@link BlockType} from 
     * {@link ChangeBlockEvent#getTargetBlocks()} to
     * be affected by this event.
     *
     * @param predicate The predicate to use for filtering
     * @return The filtered map
     */
    Map<Location<World>, BlockState> filterBlockTypes(Predicate<BlockType> predicate);
}
