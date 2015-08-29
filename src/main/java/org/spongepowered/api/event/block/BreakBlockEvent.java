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

/**
 * Base event for when {@link BlockState}s at {@link Location <World>}s are
 * being broke.
 */
public interface BreakBlockEvent extends ChangeBlockEvent {

    /**
     * Called when a {@link BlockState} breaks another {@link BlockState} at a
     * {@link Location}.
     */
    interface SourceBlock extends BreakBlockEvent, ChangeBlockEvent.SourceBlock { }

    /**
     * Called when an {@link Entity} breaks a {@link BlockState} at a
     * {@link Location}.
     */
    interface SourceEntity extends BreakBlockEvent, ChangeBlockEvent.SourceEntity { }

    /**
     * Called when a {@link Living} breaks a {@link BlockState} at a
     * {@link Location}.
     */
    interface SourceLiving extends SourceEntity, ChangeBlockEvent.SourceLiving { }

    /**
     * Called when a {@link Human} breaks a {@link BlockState} at a
     * {@link Location}.
     */
    interface SourceHuman extends SourceLiving, ChangeBlockEvent.SourceHuman { }

    /**
     * Called when a {@link Player} breaks a {@link BlockState} at a
     * {@link Location}.
     */
    interface SourcePlayer extends SourceHuman, ChangeBlockEvent.SourcePlayer { }
}
