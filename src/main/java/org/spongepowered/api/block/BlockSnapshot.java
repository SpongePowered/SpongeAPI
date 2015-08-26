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
package org.spongepowered.api.block;

import org.spongepowered.api.block.tileentity.TileEntity;
import org.spongepowered.api.data.LocateableSnapshot;

/**
 * An immutable representation of a {@link BlockState} and any extra data that
 * may be associated with it, including {@link TileEntity} related data..
 */
public interface BlockSnapshot extends LocateableSnapshot<BlockSnapshot> {

    /**
     * Gets the {@link BlockState}.
     *
     * @return The BlockState
     */
    BlockState getState();

    /**
     * Creates a new {@link BlockSnapshot} with the provided
     * {@link BlockState}. Any additional data associated with a
     * {@link TileEntity} or custom data may be lost.
     *
     * @param blockState The block state
     * @return The new snapshot
     */
    BlockSnapshot withState(BlockState blockState);

}
