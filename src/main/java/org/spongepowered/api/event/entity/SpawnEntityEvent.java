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
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.event.block.BlockEvent;
import org.spongepowered.api.event.world.WorldEvent;
import org.spongepowered.api.event.entity.living.TargetLivingEvent;

/**
 * Raised when an {@link Entity} is spawned. This usually follows the chain of
 * the various entity creation events: {@link PreCreateEntityEvent},
 * {@link CreateEntityEvent}, and finally {@link SpawnEntityEvent}.
 */
public interface SpawnEntityEvent extends TargetEntityEvent, CauseTracked {

    interface SourceBlock extends SpawnEntityEvent, BlockEvent { }

    interface SourceWorld extends SpawnEntityEvent, WorldEvent { }

    interface TargetLiving extends SpawnEntityEvent, TargetLivingEvent {

        /**
         * Represents an event where a {@link Living} entity may be "checked"
         * for any restrictions of spawning at the suggested
         * {@link #getTargetTransform()} location.
         */
        interface CheckSpawn extends TargetLiving { }

    }

}
