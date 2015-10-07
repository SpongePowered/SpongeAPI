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

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.event.action.InteractEvent;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.Location;

/**
 * Base event for all interactions involving a {@link BlockState} at a
 * {@link Location}.
 */
public interface InteractBlockEvent extends InteractEvent, TargetBlockEvent {

    /**
     * Gets the target "side" of the {@link BlockState} being interacted with
     * or {@link Direction#NONE} if not known.
     *
     * @return An optional containing the side being interacted with or
     *     {@link Direction#NONE}
     */
    Direction getTargetSide();

    /**
     * An event where the targeted block is being interacted with the client's
     * "primary" button.
     *
     * <p>This is usually left-click.</p>
     */
    interface Primary extends InteractBlockEvent {}

    /**
     * An event where the targeted block is being interacted with the client's
     * "secondary" button.
     *
     * <p>This is usually right-click.</p>
     */
    interface Secondary extends InteractBlockEvent {}
}
