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
package org.spongepowered.api.event;

import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.EventContext;
import org.spongepowered.api.event.impl.AbstractEvent;
import org.spongepowered.api.util.annotation.eventgen.AbsoluteSortPosition;
import org.spongepowered.api.util.annotation.eventgen.ImplementedBy;
import org.spongepowered.api.util.annotation.eventgen.PropertySettings;

/**
 * An event called within Sponge.
 *
 * <p>This is a marker interface, which must be implemented by any event used
 * with the Sponge event bus.</p>
 */
@ImplementedBy(value = AbstractEvent.class, priority = Integer.MIN_VALUE)
public interface Event {

    /**
     * Gets the cause for the event.
     *
     * @return The cause
     */
    @AbsoluteSortPosition(0)
    Cause getCause();

    /**
     * Gets the source of the event (the first object in the cause).
     * 
     * @return The event source
     */
    @PropertySettings(requiredParameter = false, generateMethods = false)
    default Object getSource() {
        return getCause().root();
    }

    /**
     * Gets the context of the event.
     * 
     * @return The event context
     */
    @PropertySettings(requiredParameter = false, generateMethods = false)
    default EventContext getContext() {
        return getCause().getContext();
    }
}
