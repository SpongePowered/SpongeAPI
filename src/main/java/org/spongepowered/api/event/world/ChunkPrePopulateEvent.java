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

package org.spongepowered.api.event.world;

import org.spongepowered.api.world.Chunk;
import org.spongepowered.api.world.gen.Populator;

/**
 * Called when a {@link Chunk} is about to be populated.
 */
public interface ChunkPrePopulateEvent extends ChunkEvent {

    /**
     * Returns an iterator over all pending populators.
     * 
     * @return The populators
     */
    Iterable<Populator> getPendingPopulators();

    /**
     * Adds a new populator to the list of pending populators at the given
     * index. If the index is greater than the number of populators then the
     * new populator is simply added to the end of the list.
     * 
     * @param populator The new populator
     * @param index The index to add the populator at
     */
    void insertPopulator(Populator populator, int index);

}
