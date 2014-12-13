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

package org.spongepowered.api.world.chunk;

/**
 * Represents the generation state of a chunk.
 */
public enum ChunkState {

    /**
     * The chunk is not generated yet or no information are cached for the
     * chunk.
     */
    NOTAVAILABLE,
    /**
     * The chunk is generated.
     */
    GENERATED,
    /**
     * The chunks is generated and populated,
     */
    POPULATED,
    /**
     * The chunks is fully generated,
     */
    DECORATED,
    /**
     * The chunks is fully generated and loaded,
     */
    LOADED;

    /**
     * Gets whether the chunk is at least generated.
     *
     * @return Whether the chunk is generated
     */
    public boolean isGenerated() {
        return ordinal() >= GENERATED.ordinal();
    }

    /**
     * Gets whether the chunk is at least populated.
     *
     * @return Whether the chunk is populated
     */
    public boolean isPopulated() {
        return ordinal() >= POPULATED.ordinal();
    }

    /**
     * Gets whether the chunk is at least decorated.
     *
     * @return Whether the chunk is decorated
     */
    public boolean isDecorated() {
        return ordinal() >= DECORATED.ordinal();
    }

    /**
     * Gets whether the chunk is loaded.
     *
     * @return Whether the chunk is loaded
     */
    public boolean isLoaded() {
        return ordinal() >= LOADED.ordinal();
    }

}
