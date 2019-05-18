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
package org.spongepowered.api.event.impl;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.Order;

/**
 * An abstract event that can be extended for any and all custom events as
 * necessary.
 */
public abstract class AbstractEvent implements Event {

    /**
     * Called once all fields have been set by the generated
     * constructor in a subclass.
     *
     * <p>This method should be used
     * to initialize any fields that depend on parameters
     * passed to the constructor.</p>
     */
    protected void init() {}

    /**
     * This field is automatically set by the event manager.
     * It represents the {@link Order} of the event handler currently
     * processing the event. When no handler is processing the event,
     * it will be set to <code>null</code>
     */
    @Nullable
    public Order currentOrder;

}
