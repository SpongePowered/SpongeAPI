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

import org.spongepowered.api.event.entity.living.LivingEvent;
import org.spongepowered.api.event.entity.living.human.HumanEvent;
import org.spongepowered.api.event.entity.living.player.PlayerEvent;

/**
 * An event that is called when an entity becomes leashed.
 */
public interface LeashEntityEvent extends TargetEntityEvent {

    /**
     * Called when a {@link Entity} attaches a leash to an {@link Entity}.
     */
    interface SourceEntity extends LeashEntityEvent, EntityEvent { }

    /**
     * Called when a {@link Living} attaches a leash to an {@link Entity}.
     */
    interface SourceLiving extends SourceEntity, LivingEvent { }

    /**
     * Called when a {@link Human} attaches a leash to an {@link Entity}.
     */
    interface SourceHuman extends SourceLiving, HumanEvent { }

    /**
     * Called when a {@link Player} attaches a leash to an {@link Entity}.
     */
    interface SourcePlayer extends SourceHuman, PlayerEvent { }
}
