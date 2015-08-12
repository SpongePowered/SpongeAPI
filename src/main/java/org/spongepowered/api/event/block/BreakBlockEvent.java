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
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.ExperienceEvent;
import org.spongepowered.api.event.GameEvent;
import org.spongepowered.api.world.Location;

/**
 * Base events for when a target {@link BlockState} at a {@link Location} is broken.
 */
public interface BreakBlockEvent extends GameEvent, ExperienceEvent, Cancellable {

    /**
     * Gets the target {@link Location} being broken.
     *
     * @return The Location
     */
    Location getTargetLocation();

    /**
     * Gets the target {@link BlockState} being broken.
     *
     * @return The BlockState
     */
    BlockState getTargetBlock();

    /**
     * Gets a mutable snapshot copy of the {@link BlockType} and data that resided at {@link BreakBlockEvent#getTargetLocation()}
     * as a {@link BlockSnapshot}.
     *
     * @return The BlockSnapshot
     */
    BlockSnapshot getTargetSnapshot();

    /**
     * Gets the original {@link BlockState} that will replace the BlockState at {@link BreakBlockEvent#getTargetLocation()}
     * un-affected by event changes.
     *
     * <p>
     *     Typically this will be a BlockState whose {@link BlockState#getType()} returns {@link BlockTypes#AIR}.
     * </p>
     *
     * @return The original replacement BlockState
     */
    BlockState getOriginalReplacementBlock();

    /**
     * Gets the {@link BlockState} that will replace the BlockState at {@link BreakBlockEvent#getTargetLocation()}
     * after event resolution.
     *
     * <p>
     *     Typically this will be a BlockState whose {@link BlockState#getType()} returns {@link BlockTypes#AIR}.
     * </p>
     *
     * @return The replacement BlockState
     */
    BlockState getReplacementBlock();

    /**
     * Sets the {@link BlockState} that will replace the BlockState at {@link BreakBlockEvent#getTargetLocation()}
     * after event resolution.
     *
     * <p>
     *     This will also set the {@link BlockSnapshot} that will be returned in
     * </p>
     * @param block The BlockState that will replace the broken one
     */
    void setReplacementBlock(BlockState block);

    /**
     * Sets the {@link BlockType} and data at the {@link BreakBlockEvent#getTargetLocation()} to the values contained
     * in the {@link BlockSnapshot}.
     *
     * <p>
     *     After this method is called, {@link BreakBlockEvent#getReplacementBlock()} will equal {@link BlockSnapshot#getState()}
     * </p>
     *
     * @param snapshot The BlockSnapshot to pull values from
     */
    void setReplacementSnapshot(BlockSnapshot snapshot);

}
