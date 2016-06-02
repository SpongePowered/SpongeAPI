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

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.util.Direction;

import java.util.Map;
import java.util.function.Predicate;

/**
 * Called when a block triggers an update to neighboring {link BlockType}s in
 * one or more {@link Direction}s. There is a way to mark an "update" as being 
 * "invalid" or "cancelled": {@link #filterDirections(Predicate)} will apply a
 * {@link Predicate} such that if the predicate returns <code>false</code>, the
 * {@link Direction} will be removed from the {@link #getNeighbors()} map.
 */
public interface NotifyNeighborBlockEvent extends Event, Cancellable {

    /**
     * Gets the immutable {@link Map} of {@link Direction} to {@link 
     * BlockState} of the {@link BlockType} that would normally be
     * notified of changes.
     *
     * @return The original directions map
     */
    Map<Direction, BlockState> getOriginalNeighbors();

    /**
     * Gets an immutable {@link Map} of {@link Direction} to
     * {@link BlockState} of the {@link BlockType} that will be notified of
     * an update. If a {@link Direction} is not required or needing to be
     * excluded from an update, {@link #filterDirections(Predicate)} will
     * perform that exclusion.
     *
     * @return The map
     */
    Map<Direction, BlockState> getNeighbors();

    /**
     * Filters out {@link Direction}s of the {@link BlockState}s to be
     * marked as "valid" after this event. If the
     * {@link Predicate#test(Object)} returns <code>false</code>, the
     * {@link BlockState} is removed from {@link #getNeighbors()} map.
     *
     * @param predicate The predicate to use for filtering.
     */
    void filterDirections(Predicate<Direction> predicate);

}
