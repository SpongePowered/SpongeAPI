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
package org.spongepowered.api.event.world.chunk;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.world.Chunk;

/**
 * Called when a {@link Chunk} is performing a save.
 */
public interface SaveChunkEvent extends Event {

    /**
     * Gets the position of the {@link Chunk}.
     *
     * @return the position
     */
    Vector3i getChunkPosition();

    /**
     * Called before the {@link Chunk} is saved. Cancelling this will prevent any of
     * the chunk's data being written to it's storage container.
     */
    interface Pre extends SaveChunkEvent, TargetChunkEvent, Cancellable {}

    /**
     * Called after the {@link Chunk} is saved. Guaranteed to exist in the chunk's
     * storage container.
     *
     * Depending on the implementation, this event may be called off-thread.
     */
    interface Post extends SaveChunkEvent {}
}
