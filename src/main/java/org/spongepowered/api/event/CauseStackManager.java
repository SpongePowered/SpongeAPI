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
import org.spongepowered.api.event.cause.EventContextKey;
import org.spongepowered.api.event.cause.EventContextKeys;

import java.util.Optional;

/**
 * Provides an interface into the system managing the cause and contextual
 * information for events being thrown. This allows plugins to attach more
 * contextual information to events which may be triggered from their api
 * interactions.
 * 
 * <p>For example a plugin may wish to push a player into the cause stack before
 * spawning an entity to expose to any plugin listening for SpawnEntityEvents
 * that the player is the reason that the entity was spawned.</p>
 * 
 * <p>This system will automatically handle associating a plugin with actions
 * performed inside of event listeners, command executors, and scheduled
 * tasks.</p>
 */
public interface CauseStackManager {

    /**
     * Gets the current {@link Cause} object from the current cause stack.
     * 
     * @return A cause of the current stack.
     */
    Cause getCurrentCause();

    /**
     * Gets an {@link EventContext} object on the current contextual
     * information.
     * 
     * @return The current event context
     */
    EventContext getCurrentContext();

    /**
     * Pushes an object to the current cause stack which will associate it with
     * all events through from api actions until it is popped off again.
     * 
     * @param obj The object to push to the stack
     * @return The cause stack manager, for chaining
     */
    CauseStackManager pushCause(Object obj);

    /**
     * Pops the most recently pushed cause object off of the stack and returns
     * it.
     * 
     * @return The last pushed object
     */
    Object popCause();

    /**
     * Pops the most recently <b>n</b> pushed cause objects off of the stack.
     * 
     * @param n The number of causes to pop
     */
    void popCauses(int n);

    /**
     * Retrieves but does not remove the most recently pushed cause object.
     * 
     * @return The last pushed object
     */
    Object peekCause();

    /**
     * Pushes a frame of the current cause stack and context state.
     * 
     * @return A handle for the frame which must be passed back to pop the frame
     *         from the stack
     */
    Object pushCauseFrame();

    /**
     * Replaces the current cause stack and context with the cause frame at the
     * top of the frame stack.
     * 
     * <p>The frame handle is required to ensure that frames are popped of in
     * order and are not left in the stack. If an attempt is made to pop a frame
     * which is not the head of the frame stack then an error will be thrown as
     * this indicates that a frame was not popped properly.</p>
     * 
     * @param handle The frame handle to pop
     */
    void popCauseFrame(Object handle);

    /**
     * Returns an {@link AutoCloseable} frame handle which should be used in a
     * try-with-resource block the frame will be automatically popped from the
     * frame stack when the handle is closed.
     * 
     * @return The frame handle
     */
    AutoCloseable createCauseFrame();

    /**
     * Adds the given object to the current context under the given key.
     * 
     * @param key The context key
     * @param value The object
     * @return The cause stack manager, for chaining
     * @see EventContextKeys
     */
    <T> CauseStackManager addContext(EventContextKey<T> key, T value);

    /**
     * Gets the context value with the given key.
     * 
     * @param key The context key
     * @return The context object, if present
     */
    <T> Optional<T> getContext(EventContextKey<T> key);

    /**
     * Removes the given context key from the current context.
     * 
     * @param key The key to clear
     * @return The existing context value, if it was present
     * @see EventContextKeys
     */
    <T> Optional<T> removeContext(EventContextKey<T> key);

}
