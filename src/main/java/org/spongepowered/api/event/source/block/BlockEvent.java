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
package org.spongepowered.api.event.source.block;

import com.google.common.base.Optional;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.event.GameEvent;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

/**
 * Base event for all events with a {@link BlockState}, with an {@link 
 * Optional<Direction>} side, at a {@link Location} as the source.
 */
public interface BlockEvent extends GameEvent, CauseTracked {

    /**
     * Gets the source {@link Location}.
     *
     * @return The source Location
     */
    Location<World> getSourceLocation();

    /**
     * Gets the source {@link BlockState}.
     *
     * @return The source BlockState
     */
    BlockState getSourceBlock();

    /**
     * Gets the source "side" as a {@link Direction}.
     *
     * <p>Depending on the event, this may or may not be known(hence the 
     * optional)</p>
     *
     * @return An optional containing the side or {@link Optional#absent()} if 
     *     not known
     */
    Optional<Direction> getSourceSide();
}
