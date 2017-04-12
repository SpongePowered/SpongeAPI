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

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * A flag of sorts that determines whether a block change will perform various
 * interactions, such as notifying neighboring blocks, performing block phsyics
 * on placement, etc.
 */
public enum BlockChangeFlag {

    ALL(Flags.NEIGHBOR_MASK | Flags.PHYSICS_MASK),
    NEIGHBOR(Flags.NEIGHBOR_MASK),
    PHYSICS(Flags.PHYSICS_MASK),
    NEIGHBOR_PHYSICS(Flags.NEIGHBOR_MASK | Flags.PHYSICS_MASK),
    NONE()
    ;

    private final boolean updateNeighbors;
    private final boolean performBlockPhysics;
    private final int rawFlag;

    BlockChangeFlag() {
        this.updateNeighbors = false;
        this.performBlockPhysics = false;
        this.rawFlag = 0;
    }

    BlockChangeFlag(int flag) {
        this.updateNeighbors = (flag & Flags.NEIGHBOR_MASK) != 0;
        this.performBlockPhysics = (flag & Flags.PHYSICS_MASK) != 0;
        this.rawFlag = flag;
    }

    /**
     * Gets whether this flag defines that a block change should
     * notify neighboring blocks.
     *
     * @return True if this is set to notify neighboring blocks
     */
    public boolean updateNeighbors() {
        return this.updateNeighbors;
    }

    /**
     * Gets whether this flag defines that a block change should
     * perform block physics checks or not. If not, no checks
     * are performed.
     *
     * @return True if this is set to perform block physics on placement
     */
    public boolean performBlockPhysics() {
        return this.performBlockPhysics;
    }


    /**
     * Gets the equivalent {@link BlockChangeFlag} of this flag with all
     * other flags while having the desired {@code updateNeighbors}
     * as defined by the parameter.
     *
     * @param updateNeighbors Whether to update neighboring blocks
     * @return The relative flag with the desired update neighbors
     */
    public BlockChangeFlag setUpdateNeighbors(boolean updateNeighbors) {
        if (this.updateNeighbors == updateNeighbors) {
            return this;
        }
        final int maskedFlag = (updateNeighbors ? Flags.NEIGHBOR_MASK : 0)
                               | (this.performBlockPhysics ? Flags.PHYSICS_MASK : 0);
        for (BlockChangeFlag blockChangeFlag : values()) {
            if (blockChangeFlag.rawFlag == maskedFlag) {
                return blockChangeFlag;
            }
        }
        return this;
    }

    /**
     * Gets the equivalent {@link BlockChangeFlag} of this flag
     * with all other flags while having the desired {@code performBlockPhysics}
     * as defined by the parameter.
     *
     * @param performBlockPhysics Whether to perform block physics
     * @return The relative flag with the desired block physics
     */
    public BlockChangeFlag setPerformBlockPhysics(boolean performBlockPhysics) {
        if (this.performBlockPhysics == performBlockPhysics) {
            return this;
        }
        final int maskedFlag = (this.updateNeighbors ? Flags.NEIGHBOR_MASK : 0)
                               | (performBlockPhysics ? Flags.PHYSICS_MASK : 0);

        for (BlockChangeFlag blockChangeFlag : values()) {
            if (blockChangeFlag.rawFlag == maskedFlag) {
                return blockChangeFlag;
            }
        }
        return this;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("updateNeighbors", this.updateNeighbors)
                .add("performBlockPhysics", this.performBlockPhysics)
                .toString();
    }

    static final class Flags {
        private static final int NEIGHBOR_MASK = 0b010;
        private static final int PHYSICS_MASK = 0b100;
    }



}
