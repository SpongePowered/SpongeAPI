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

import java.util.NoSuchElementException;
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
    Cause currentCause();

    /**
     * Gets an {@link EventContext} object on the current contextual
     * information.
     * 
     * @return The current event context
     */
    EventContext currentContext();

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
    StackFrame pushCauseFrame();

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
    void popCauseFrame(StackFrame handle);

    /**
     * Adds the given object to the current context under the given key.
     * 
     * @param key The context key
     * @param value The object
     * @param <T> The type of the value stored with the event context key
     * @return The cause stack manager, for chaining
     * @see EventContextKeys
     */
    <T> CauseStackManager addContext(EventContextKey<T> key, T value);

    /**
     * Gets the context value with the given key.
     * 
     * @param key The context key
     * @param <T> The type of the value stored with the event context key
     * @return The context object, if present
     */
    <T> Optional<T> context(EventContextKey<T> key);

    /**
     * Gets the context value with the given key.
     * 
     * <p>If the key is not available, {@link NoSuchElementException} will be
     * thrown.</p>
     * 
     * @param key The context key
     * @param <T> The type of the value stored with the event context key
     * @return The context object, if present
     */
    default <T> T requireContext(EventContextKey<T> key) {
        final Optional<T> optional = this.context(key);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new NoSuchElementException(String.format("Could not retrieve value for key '%s'", key.toString()));
    }

    /**
     * Removes the given context key from the current context.
     * 
     * @param key The key to clear
     * @param <T> The type of the value stored with the event context key
     * @return The existing context value, if it was present
     * @see EventContextKeys
     */
    <T> Optional<T> removeContext(EventContextKey<T> key);

    interface StackFrame extends AutoCloseable {

        /**
         * Gets the current {@link Cause} object from the current cause stack.
         *
         * @return A cause of the current stack.
         * @see CauseStackManager#currentCause()
         */
        Cause currentCause();

        /**
         * Gets an {@link EventContext} object on the current contextual
         * information.
         *
         * @return The current event context
         * @see CauseStackManager#currentContext()
         */
        EventContext currentContext();

        /**
         * Pushes an object to the current cause stack which will associate
         * it with all events through from api actions until it is
         * popped off again.
         *
         * @param obj The object to push to the stack
         * @return The stack frame, for chaining
         * @see CauseStackManager#pushCause(Object)
         */
        StackFrame pushCause(Object obj);

        /**
         * Pops the most recently pushed cause object off of the stack and
         * returns it.
         *
         * @return The last pushed object
         * @see CauseStackManager#popCause()
         */
        Object popCause();

        /**
         * Adds the given object to the current context under the given key.
         *
         * @param key The context key
         * @param value The object
         * @param <T> The type of value key
         * @return The stack frame, for chaining
         * @see EventContextKeys
         * @see CauseStackManager#addContext(EventContextKey, Object)
         */
        <T> StackFrame addContext(EventContextKey<T> key, T value);

        /**
         * Removes the given context key from the current context.
         *
         * @param key The key to clear
         * @param <T> The type of value key
         * @return The existing context value, if it was present
         * @see EventContextKeys
         * @see CauseStackManager#removeContext(EventContextKey)
         */
        <T> Optional<T> removeContext(EventContextKey<T> key);

        @Override
        void close();

    }
}
