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
package org.spongepowered.api.event.entity;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.event.block.BlockEvent;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.event.entity.living.TargetLivingEvent;
import org.spongepowered.api.event.world.WorldEvent;
import org.spongepowered.api.world.World;

/**
 * Raised when an {@link Entity} is spawned. This usually follows the chain of
 * the various entity creation events: {@link PreCreateEntityEvent},
 * {@link ConstructEntityEvent}, and finally {@link SpawnEntityEvent}.
 */
public interface SpawnEntityEvent extends TargetEntityEvent, CauseTracked {

    /**
     * An event where a {@link BlockEvent} is the source.
     */
    interface SourceBlock extends SpawnEntityEvent, BlockEvent { }

    /**
     * An event where a {@link World} is the source.
     */
    interface SourceWorld extends SpawnEntityEvent, WorldEvent { }

    /**
     * An event where a {@link Living} is being spawned.
     */
    interface TargetLiving extends SpawnEntityEvent, TargetLivingEvent { }

}
