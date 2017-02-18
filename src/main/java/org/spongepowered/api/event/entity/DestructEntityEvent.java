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
import org.spongepowered.api.event.entity.living.TargetLivingEvent;
import org.spongepowered.api.event.message.MessageChannelEvent;
import org.spongepowered.api.util.annotation.eventgen.GenerateFactoryMethod;

/**
 * An event where the {@link Entity} is being either removed usually due to
 * the {@link Entity} being marked as "dead". Happens before {@link HarvestEntityEvent}.
 */
@GenerateFactoryMethod
public interface DestructEntityEvent extends TargetEntityEvent, MessageChannelEvent {

    /**
     * A derivative of {@link DestructEntityEvent} where the removal of the {@link Living}, the {@link TargetLivingEvent#getTargetEntity()},
     * is due to it losing its health.
     */
    interface Death extends DestructEntityEvent, TargetLivingEvent {}
}
