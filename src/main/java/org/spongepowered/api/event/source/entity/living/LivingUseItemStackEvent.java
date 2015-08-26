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
package org.spongepowered.api.event.source.entity.living;

import org.spongepowered.api.event.source.entity.EntityUseItemStackEvent;

/**
 * Called when an entity consumes an itemstack for any reason.
 * <p>Examples may include: A player eating food, a witch drinking a 
 * potion, etc.</p>
 */
public interface LivingUseItemStackEvent extends EntityUseItemStackEvent, LivingEvent {


    interface Start extends EntityUseItemStackEvent.Start, LivingUseItemStackEvent {

    }

    interface Tick extends EntityUseItemStackEvent.Tick, LivingUseItemStackEvent {

    }

    interface Stop extends EntityUseItemStackEvent.Stop, LivingUseItemStackEvent {

    }

    interface Finish extends EntityUseItemStackEvent.Finish, LivingUseItemStackEvent {

    }

}
