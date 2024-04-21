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
import org.spongepowered.api.event.Cause;
import org.spongepowered.api.event.impl.entity.AbstractAffectEntityEvent;
import org.spongepowered.api.event.impl.entity.AbstractSpawnEntityEvent;
import org.spongepowered.api.util.annotation.eventgen.GenerateFactoryMethod;
import org.spongepowered.api.util.annotation.eventgen.ImplementedBy;

/**
 * Raised when an {@link Entity} is spawned. This usually follows the chain of
 * the various entity creation events: {@link ConstructEntityEvent.Pre},
 * {@link ConstructEntityEvent.Post}, and finally {@link SpawnEntityEvent}.
 *
 * <p>Note: To determine the {@link Cause}, refer to package
 * org.spongepowered.api.event.cause.entity.spawn.</p>
 */
@GenerateFactoryMethod
@ImplementedBy(value = AbstractSpawnEntityEvent.class, priority = 2)
public interface SpawnEntityEvent extends AffectEntityEvent {

    /**
     * An event that is thrown prior to an {@link Entity} being
     * potentially added to a {@link org.spongepowered.api.world.World} such that
     * any relational recording or transacting/association of the spawn to another
     * action, such as a {@link org.spongepowered.api.event.block.ChangeBlockEvent block change}
     * will be omitted. This does have the advantage that the cancellation of this event
     * will result in no awareness to the client that the entity was being
     * spawned and later cancelled.
     */
    @ImplementedBy(value = AbstractAffectEntityEvent.class, priority = 2)
    interface Pre extends AffectEntityEvent {}

    interface Custom extends SpawnEntityEvent {}
}
