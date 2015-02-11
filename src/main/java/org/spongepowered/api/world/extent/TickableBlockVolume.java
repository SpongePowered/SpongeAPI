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

import org.spongepowered.api.block.BlockLoc;
import org.spongepowered.api.world.TileTick;

import com.flowpowered.math.vector.Vector3d;

import java.util.Set;

public interface TickableBlockVolume extends BlockVolume {

    /**
     * Gets a set of {@link TileTick}s in this volume.
     * 
     * @return A set of TileTicks in this volume
     */
    public Set<TileTick> getTileTicks();

    /**
     * Adds a {@link TileTick} to this volume.
     * 
     * @param tick The TileTick to add to this volume
     */
    public void addTick(TileTick tick);

    /**
     * Adds a new {@link TileTick} to this volume.
     * 
     * @param location The location of the TileTick
     * @param ticks How long until the TileTick should be processed
     * @param priority The priority of the TileTick
     * @return The created TileTick
     */
    public TileTick addTick(BlockLoc location, int ticks, int priority);

    /**
     * Removes a {@link TileTick} from this volume.
     * 
     * @param tick The TileTick to remove
     */
    public void removeTick(TileTick tick);

    /**
     * Gets a set of {@link TileTick}s at a certain position in this volume.
     * 
     * @param position The position to check
     * @return The TileTicks found at the position.
     */
    public Set<TileTick> getTicksAt(Vector3d position);

}
