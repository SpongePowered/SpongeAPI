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
package org.spongepowered.api.service.event;

import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.EventHandler;
import org.spongepowered.api.event.Order;
import org.spongepowered.api.event.Subscribe;

/**
 * Manages the registration of event handlers and the dispatching of events.
 */
public interface EventManager {

    /**
     * Registers {@link Event} methods annotated with @{@link Subscribe} in the
     * specified object.
     *
     * @param plugin The plugin instance
     * @param obj The object
     * @throws IllegalArgumentException Thrown if {@code plugin} is not a plugin
     *         instance
     */
    void register(Object plugin, Object obj);

    /**
     * Registers an event handler for a specific event class.
     *
     * <p>Normally, the annotation-based way in
     * {@link #register(Object, Object)} should be preferred over this way. This
     * method exists primarily to support dynamic event registration like needed
     * in scripting plugins.</p>
     *
     * @param plugin The plugin instance
     * @param eventClass The event to listen to
     * @param handler The handler to receive the events
     * @param <T> The type of the event
     */
    <T extends Event> void register(Object plugin, Class<T> eventClass, EventHandler<? super T> handler);

    /**
     * Registers an event handler with the specified order for a specific event
     * class.
     *
     * <p>Normally, the annotation-based way in
     * {@link #register(Object, Object)} should be preferred over this way. This
     * method exists primarily to support dynamic event registration like needed
     * in scripting plugins.</p>
     *
     * @param plugin The plugin instance
     * @param eventClass The event to listen to
     * @param order The order the handler will get called at
     * @param handler The handler to receive the events
     * @param <T> The type of the event
     */
    <T extends Event> void register(Object plugin, Class<T> eventClass, Order order, EventHandler<? super T> handler);

    /**
     * Un-registers an object from receiving {@link Event}s.
     *
     * @param obj The object
     */
    void unregister(Object obj);

    /**
     * Un-registers all event handlers of a plugin.
     *
     * @param plugin The plugin instance
     */
    void unregisterPlugin(Object plugin);

    /**
     * Calls a {@link Event} to all handlers that handle it.
     *
     * @param event The event
     * @return True if cancelled, false if not
     */
    boolean post(Event event);

}
