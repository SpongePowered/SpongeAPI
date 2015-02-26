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

package org.spongepowered.api.world;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.world.extent.Extent;

/**
 * A chunk is a specific grid-aligned partition of a {@link Extent}.
 *
 * <p>In Minecraft, the chunk is 16 by 16 blocks on the X and Z axes. The height
 * of each chunk varies between worlds.</p>
 */
public interface Chunk extends Extent {

    /**
     * Get the position of the chunk.
     *
     * <p>The returned position is 3-dimensional with the Y-coordinate set to
     * be the base (lowest) Y-position of the chunk. As 3-dimensional chunks
     * do not yet exist in Minecraft, the returned position will always have
     * a {@code y} set to 0.</p>
     *
     * @return The position
     */
    Vector3i getPosition();

    /**
     * Gets whether or not this chunk is currently loaded.
     *
     * @return Whether or not this chunk is loaded
     */
    boolean isLoaded();

    /**
     * Gets the world the chunk is in.
     *
     * @return The world
     */
    World getWorld();

    /**
     * Gets if the chunk has been populated by the generator.
     *
     * @return Whether or not the chunk has been populated.
     */
    boolean isPopulated();

    /**
     * Loads this chunk, and generates if specified and required.
     *
     * @param generate Whether or not to generate the chunk
     *                 if it does not yet exist
     *
     * @return If the chunk was successfully loaded
     */
    boolean loadChunk(boolean generate);

    /**
     * Unloads this chunk, if possible.
     *
     * @return Whether or not the chunk unloaded
     */
    boolean unloadChunk();
}
