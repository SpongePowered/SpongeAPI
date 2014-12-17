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

package org.spongepowered.api.event.world.chunk;

import org.spongepowered.api.world.World;
import org.spongepowered.api.world.chunk.Chunk;
import org.spongepowered.api.world.chunk.ChunkPopulator;

/**
 * Called when a {@link Chunk} will be (re)populated.
 */
public interface ChunkPrePopulateEvent extends ChunkEvent {

    /**
     * Use the {@link World}s default chunk populator.
     */
    void setDefaultPopulator();

    /**
     * Checks whether the {@link World}s default populator is used to populate
     * the chunk.
     *
     * @return True, if the worlds default populator is used. False otherwise
     */
    boolean isDefaultPopulator();

    /**
     * Gets the populator that will be used to populate the chunk.
     *
     * @return The populator that will be used to populate the chunk
     */
    ChunkPopulator getPopulator();

    /**
     * Checks whether the given world supports custom {@link ChunkPopulator}s
     * and can be used for the given chunk.
     *
     * @return True, if custom populators are supported. False otherwise
     */
    boolean supportsCustomPopulators();

    /**
     * Sets a custom populator that will be used to populate the given chunk.
     *
     * @param populator The custom populator to populate the chunk
     * @throws IllegalStateException If custom populate are not supported
     * @see #supportsCustomPopulators()
     */
    void setCustomGenerator(ChunkPopulator populator) throws IllegalStateException;

}
