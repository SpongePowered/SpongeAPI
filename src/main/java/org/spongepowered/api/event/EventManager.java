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

import io.leangen.geantyref.TypeToken;
import org.spongepowered.plugin.PluginContainer;

/**
 * Manages the registration of event listeners and the dispatching of events.
 */
public interface EventManager {

    /**
     * Registers {@link Event} methods annotated with @{@link Listener} in the
     * specified object.
     *
     * <p>Only methods that are public will be registered and the class must be
     * public as well.</p>
     *
     * @param plugin The plugin instance
     * @param obj The object
     * @throws IllegalArgumentException Thrown if {@code plugin} is not a plugin
     *         instance
     */
    void registerListeners(PluginContainer plugin, Object obj);

    /**
     * Registers an event listener for a specific event class.
     *
     * <p>Normally, the annotation-based way in
     * {@link #registerListeners(PluginContainer, Object)} should be preferred over this way. This
     * method exists primarily to support dynamic event registration like needed
     * in scripting plugins.</p>
     *
     * @param plugin The plugin instance
     * @param eventClass The event to listen to
     * @param listener The listener to receive the events
     * @param <T> The type of the event
     */
    <T extends Event> void registerListener(PluginContainer plugin, Class<T> eventClass, EventListener<? super T> listener);

    /**
     * Registers an event listener for a specific event {@link TypeToken}.
     *
     * <p>Normally, the annotation-based way in
     * {@link #registerListeners(PluginContainer, Object)} should be preferred over this way. This
     * method exists primarily to support dynamic event registration like needed
     * in scripting plugins.</p>
     *
     * @param plugin The plugin instance
     * @param eventType The event to listen to
     * @param listener The listener to receive the events
     * @param <T> The type of the event
     */
    <T extends Event> void registerListener(PluginContainer plugin, TypeToken<T> eventType, EventListener<? super T> listener);

    /**
     * Registers an event listener with the specified order for a specific event
     * class.
     *
     * <p>Normally, the annotation-based way in
     * {@link #registerListeners(PluginContainer, Object)} should be preferred over this way. This
     * method exists primarily to support dynamic event registration like needed
     * in scripting plugins.</p>
     *
     * @param plugin The plugin instance
     * @param eventClass The event to listen to
     * @param order The order the listener will get called at
     * @param listener The listener to receive the events
     * @param <T> The type of the event
     */
    <T extends Event> void registerListener(PluginContainer plugin, Class<T> eventClass, Order order, EventListener<? super T> listener);

    /**
     * Registers an event listener with the specified order for a specific event
     * {@link TypeToken}.
     *
     * <p>Normally, the annotation-based way in
     * {@link #registerListeners(PluginContainer, Object)} should be preferred over this way. This
     * method exists primarily to support dynamic event registration like needed
     * in scripting plugins.</p>
     *
     * @param plugin The plugin instance
     * @param eventType The event to listen to
     * @param order The order the listener will get called at
     * @param listener The listener to receive the events
     * @param <T> The type of the event
     */
    <T extends Event> void registerListener(PluginContainer plugin, TypeToken<T> eventType, Order order, EventListener<? super T> listener);

    /**
     * Registers an event listener with the specified order for a specific event
     * class.
     *
     * <p>Normally, the annotation-based way in
     * {@link #registerListeners(PluginContainer, Object)} should be preferred over this way. This
     * method exists primarily to support dynamic event registration like needed
     * in scripting plugins.</p>
     *
     * @param plugin The plugin instance
     * @param eventClass The event to listen to
     * @param order The order the listener will get called at
     * @param beforeModifications Whether to call the listener before other
     *      server modifications
     * @param listener The listener to receive the events
     * @param <T> The type of the event
     */
    <T extends Event> void registerListener(PluginContainer plugin, Class<T> eventClass, Order order, boolean beforeModifications,
            EventListener<? super T> listener);

    /**
     * Registers an event listener with the specified order for a specific event
     * class.
     *
     * <p>Normally, the annotation-based way in
     * {@link #registerListeners(PluginContainer, Object)} should be preferred over this way. This
     * method exists primarily to support dynamic event registration like needed
     * in scripting plugins.</p>
     *
     * @param plugin The plugin instance
     * @param eventType The event to listen to
     * @param order The order the listener will get called at
     * @param beforeModifications Whether to call the listener before other
     *      server modifications
     * @param listener The listener to receive the events
     * @param <T> The type of the event
     */
    <T extends Event> void registerListener(PluginContainer plugin, TypeToken<T> eventType, Order order, boolean beforeModifications,
            EventListener<? super T> listener);

    /**
     * Un-registers an object from receiving {@link Event}s.
     *
     * @param obj The object
     */
    void unregisterListeners(Object obj);

    /**
     * Un-registers all event listeners of a plugin.
     *
     * @param plugin The plugin instance
     */
    void unregisterPluginListeners(PluginContainer plugin);

    /**
     * Calls a {@link Event} to all listeners that listen to it.
     *
     * @param event The event
     * @return True if cancelled, false if not
     */
    boolean post(Event event);

}
