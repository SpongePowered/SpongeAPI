/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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
package org.spongepowered.api.world.extent;

import org.spongepowered.api.world.TileTick;

import com.flowpowered.math.vector.Vector3i;

import java.util.Collection;

/**
 * 
 * A block volume containing {@link TileTick}s.
 *
 */
public interface TileTickVolume extends BlockVolume {

    /**
     * Gets a collection of all {@link TileTick}s in this volume.
     * 
     * @return A collection of all TileTicks in this volume
     */
    Collection<TileTick> getTileTicks();

    /**
     * Gets a collection of all {@link TileTick}s in the specified position.
     * 
     * @param position The position to check
     * @return A collection of all TileTicks in the specified position
     */
    Collection<TileTick> getTileTicksAt(Vector3i position);

    /**
     * Adds a new {@link TileTick} to this volume. The block type is not an
     * argument, as it will be inferred from the block at the specified
     * position.
     * 
     * @param position The position to put the TileTick at
     * @param ticks How many ticks until the TileTick should be processed
     * @param priority The priority of the TileTick
     * @return The newly created TileTick
     */
    TileTick addTileTick(Vector3i position, int ticks, int priority);

    /**
     * Removes a {@link TileTick} from this volume.
     * 
     * @param tick The TileTick to remove.
     */
    void removeTileTick(TileTick tick);

}
