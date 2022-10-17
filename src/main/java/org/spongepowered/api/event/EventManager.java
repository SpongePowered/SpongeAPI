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

import org.spongepowered.plugin.PluginContainer;

import java.lang.invoke.MethodHandles;

/**
 * Manages the registration of event listeners and the dispatching of events.
 */
public interface EventManager {

    /**
     * Submits a new {@link EventListenerRegistration listener registration} to this manager.
     * @param registration The registration
     * @param <E> The event type
     * @return This manager, for fluency
     */
    <E extends Event> EventManager registerListener(EventListenerRegistration<E> registration);

    /**
     * Registers {@link Event} methods annotated with @{@link Listener} in the
     * specified object.
     *
     * <p>This will not include any methods declared in supertypes, but will
     * test for private and package-private listener methods.</p>
     *
     * @param plugin The plugin container
     * @param obj The object
     * @return This manager, for fluency
     */
    EventManager registerListeners(PluginContainer plugin, Object obj);

    /**
     * Registers {@link Event} methods annotated with @{@link Listener} in the
     * specified object.
     *
     * <p>This will not include any methods declared in supertypes, but will
     * test for private and package-private listener methods.</p>
     *
     * <p>The provided lookup will be used for privileged access to the listener object.</p>
     *
     * @param plugin The plugin container
     * @param obj The object
     * @param lookup The lookup with which to access the listener object
     * @return This manager, for fluency
     */
    EventManager registerListeners(PluginContainer plugin, Object obj, MethodHandles.Lookup lookup);

    /**
     * Un-registers an object from receiving {@link Event}s.
     *
     * <p>If the provided object is a {@link PluginContainer plugin}, all events associated
     * with that plugin will be unregistered.</p>
     *
     * @param obj The object
     * @return This manager, for fluency
     */
    EventManager unregisterListeners(Object obj);

    /**
     * Calls an {@link Event} to all listeners that listen to it.
     *
     * @param event The event
     * @return True if cancelled, false if not
     */
    boolean post(Event event);

}
