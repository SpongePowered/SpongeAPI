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
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

/**
 * Called when a {@link BlockState} moves another {@link BlockState} from one {@link Location} to another.
 *
 * TODO BlockChangeBlock Candidate for Bulk?
 */
public interface BlockMoveBlockEvent extends BlockEvent, Cancellable {

    /**
     * Gets the target {@link BlockState} being moved.
     *
     * @return The BlockState
     */
    BlockState getTargetBlock();

    /**
     * Gets the {@link Location} the {@link BlockState} prior to the event.
     *
     * @return The original Location
     */
    Location<World> getOriginalTargetLocation();

    /**
     * Gets the {@link Location} the {@link BlockState} will be at after event 
     * resolution.
     *
     * @return The new Location
     */
    Location<World> getNewTargetLocation();

    /**
     * Sets the {@link Location} the {@link BlockState} will be at after event 
     * resolution.
     *
     * @param location The new Location
     */
    void setNewTargetLocation(Location<World> location);
}
