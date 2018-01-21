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

import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of the possible {@link BlockChangeFlag}s.
 *
 * <p>{@link BlockChangeFlag}s can be combined using the
 * {@link BlockChangeFlag#andFlag(BlockChangeFlag)} and
 * {@link BlockChangeFlag#andNotFlag(BlockChangeFlag)} operators.</p>
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public final class BlockChangeFlags {

    // SORTFIELDS:ON

    /**
     * All the available flags are applied through the AND operator.
     */
    public static final BlockChangeFlag ALL = DummyObjectProvider.createFor(BlockChangeFlag.class, "ALL");

    /**
     * A flag that defines whether a block change should notify
     * neighboring blocks.
     */
    public static final BlockChangeFlag NEIGHBOR = DummyObjectProvider.createFor(BlockChangeFlag.class, "NEIGHBOR");

    /**
     * The {@link #NEIGHBOR} and {@link #OBSERVER} flags combined
     * with the AND operator.
     */
    public static final BlockChangeFlag NEIGHBOR_OBSERVER = DummyObjectProvider.createFor(BlockChangeFlag.class, "NEIGHBOR_OBSERVER");

    /**
     * The {@link #NEIGHBOR} and {@link #PHYSICS} flags combined
     * with the AND operator.
     */
    public static final BlockChangeFlag NEIGHBOR_PHYSICS = DummyObjectProvider.createFor(BlockChangeFlag.class, "NEIGHBOR_PHYSICS");

    /**
     * The {@link #NEIGHBOR}, {@link #PHYSICS} and {@link #OBSERVER} flags
     * combined with the AND operator.
     */
    public static final BlockChangeFlag NEIGHBOR_PHYSICS_OBSERVER = DummyObjectProvider.createFor(BlockChangeFlag.class, "NEIGHBOR_PHYSICS_OBSERVER");

    /**
     * No flags are set, triggers nothing.
     */
    public static final BlockChangeFlag NONE = DummyObjectProvider.createFor(BlockChangeFlag.class, "NONE");

    /**
     * A flag that defines whether to update observer blocks, different
     * from notifying neighbors in that neighbor notifications
     * can cause further block notification loops (like redstone),
     * whereas this focuses on {@link BlockTypes#OBSERVER} blocks
     * being told of updates.
     */
    public static final BlockChangeFlag OBSERVER = DummyObjectProvider.createFor(BlockChangeFlag.class, "OBSERVER");

    /**
     * A flag that defines whether a block change should
     * perform block physics checks or not. If not, no checks
     * are performed.
     */
    public static final BlockChangeFlag PHYSICS = DummyObjectProvider.createFor(BlockChangeFlag.class, "PHYSICS");

    /**
     * The {@link #PHYSICS} and {@link #OBSERVER} flags combined with
     * the AND operator.
     */
    public static final BlockChangeFlag PHYSICS_OBSERVER = DummyObjectProvider.createFor(BlockChangeFlag.class, "PHYSICS_OBSERVER");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private BlockChangeFlags() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
