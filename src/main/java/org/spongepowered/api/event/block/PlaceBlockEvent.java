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
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

/**
 * Base event for when {@link BlockState}s at {@link Location<World>}s are
 * being placed.
 */
public interface PlaceBlockEvent extends ChangeBlockEvent {

    /**
     * An event where the source is a block.
     */
    interface SourceBlock extends PlaceBlockEvent, ChangeBlockEvent.SourceBlock { }

    /**
     * An event where the source is an {@link Entity}.
     */
    interface SourceEntity extends PlaceBlockEvent, ChangeBlockEvent.SourceEntity { }

    /**
     * An event where the source is a {@link Living}.
     */
    interface SourceLiving extends SourceEntity, ChangeBlockEvent.SourceLiving { }

    /**
     * An event where the source is a {@link Human}.
     */
    interface SourceHuman extends SourceLiving, ChangeBlockEvent.SourceHuman { }

    /**
     * An event where the source is a {@link Player}.
     */
    interface SourcePlayer extends SourceHuman, ChangeBlockEvent.SourcePlayer { }

}
