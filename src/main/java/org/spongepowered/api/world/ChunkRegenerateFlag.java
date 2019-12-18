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
package org.spongepowered.api.world;

import org.spongepowered.api.util.annotation.CatalogedBy;

/**
 * A flag of sorts that determines whether a chunk regeneration will perform
 * various tasks such as creating a chunk, or preserving entities.
 */
@CatalogedBy(ChunkRegenerateFlags.class)
public interface ChunkRegenerateFlag {

    /**
     * Gets whether this flag defines that a chunk should be created if it does
     * not exist.
     *
     * @return True if this is set to create chunks
     */
    boolean create();

    /**
     * Gets whether this flag will preserve entities in chunks that are
     * regenerated.
     * 
     * Note: It is up to the implementation to decide whether this will
     * include moving entities to safe locations.
     *
     * @return True if this is set to preserve entities
     */
    boolean entities();

    /**
     * Gets the equivalent {@link ChunkRegenerateFlag} of this flag with all
     * other flags while having the desired {@code create} as defined by the
     * parameter.
     *
     * @param create Whether to create chunk
     * @return The relative flag with the desired create
     */
    ChunkRegenerateFlag withCreate(boolean create);

    /**
     * Gets the equivalent {@link ChunkRegenerateFlag} of this flag with all
     * other flags while having the desired {@code entities} as defined by the
     * parameter.
     *
     * @param entities Whether to preserve entities
     * @return The relative flag with the desired entities
     */
    ChunkRegenerateFlag withEntities(boolean entities);

    /**
     * Gets the equivalent {@link ChunkRegenerateFlag} of this flag with the
     * {@code true}s set for this flag and the provided {@code flag}, such that
     * only if both flags have the same {@code true} flags set will persist.
     *
     * <p>For example, if this flag has {@link #create()} and the incoming flag
     * has {@link #create()} returning {@code true}, the resulting flag will
     * have {@link #create()} return {@code true} as well. The inverse is also
     * true. If either has differing flags for any of the above methods, the
     * resulting flag will have a {@code false} value.</p>
     *
     * @param flag The incoming flag to and with this flag
     * @return The resulting flag with matched values
     */
    ChunkRegenerateFlag andFlag(ChunkRegenerateFlag flag);

    /**
     * Gets the equivalent {@link ChunkRegenerateFlag} of this flag with the
     * {@code true}s set for this flag and the provided {@code flag}, such that
     * only if both flags have the same {@code true} flags set will persist.
     *
     * <p>For example, if this flag has {@link #create()} and the incoming flag
     * has {@link #create()} returning {@code true}, the resulting flag will
     * have {@link #create()} return {@code true} as well. The inverse is also
     * true. If either has differing flags for any of the above methods, the
     * resulting flag will have a {@code false} value.</p>
     *
     * @param flag The incoming flag to and with this flag
     * @return The resulting flag with matched values
     */
    ChunkRegenerateFlag andNotFlag(ChunkRegenerateFlag flag);

    public interface Factory {

        ChunkRegenerateFlag empty();
    }
}
