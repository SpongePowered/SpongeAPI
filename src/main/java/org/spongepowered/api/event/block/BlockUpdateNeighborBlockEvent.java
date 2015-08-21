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

import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.world.World;
import com.google.common.base.Predicate;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.event.action.ChangeBlockEvent;

import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.Location;

import java.util.Map;

/**
 * Called when a {@link BlockState} triggers an update to one or more {@link 
 * BlockState}s.
 */
public interface BlockUpdateNeighborBlockEvent extends ChangeBlockEvent {

    /**
     * Gets a mutable copy of the original {@link Map} containing the {@link 
     * Direction} (face) and {@link BlockSnapshot} relative from {@link
     * BlockEvent#getLocation()} unaffected by event changes.
     *
     * <p>ie. If the {@link BlockEvent#getBlock()} is redstone and is providing 
     * power to another {@link BlockState}, this map would contain the direction
     * from {@link BlockEvent#getLocation()} and the location in that direction.
     *
     * To get the direction or face of the target being powered, use 
     * {@link Direction#getOpposite()}.</p>
     *
     * @return The map
     */
    Map<Direction, BlockSnapshot> getSnapshotRelatives();

    /**
     * Gets a mutable {@link Map} containing the {@link Direction} (face) and 
     * {@link Location} relative from {@link BlockEvent#getLocation()}.
     *
     * <p>ie. If the {@link BlockEvent#getBlock()} is redstone and is providing 
     * power to another {@link BlockState}, this map would contain the direction
     * from {@link BlockEvent#getLocation()} and the location in that direction.
     *
     * To get the direction or face of the target being powered, use 
     * {@link Direction#getOpposite()}.</p>
     *
     * @return The map
     */
    Map<Direction, Location<World>> getRelatives();

    /**
     * Filters out {@link Direction}s from 
     * {@link BlockUpdateNeighborBlockEvent#getRelatives()} to be affected by 
     * this event.
     *
     * @param predicate The predicate to use for filtering.
     * @return The filtered map
     */
    Map<Direction, Location<World>> filterDirections(Predicate<Direction> predicate);
}
