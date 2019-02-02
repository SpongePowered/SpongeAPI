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
package org.spongepowered.api.command.parameter;

import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.EventContextKeys;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.text.channel.MessageReceiver;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.world.Location;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * The {@link CommandContext} contains the parsed arguments for a
 * command, and any other information that might be important.
 */
public interface CommandContext {

    /**
     * Gets the {@link Cause} of the command execution.
     */
    Cause getCause();

    /**
     * Gets the {@link MessageChannel} that should be the target for any
     * messages sent by the command (by default).
     *
     * <p>The {@link MessageChannel} will be selected in the following way
     * from the {@link Cause} in {@link #getCause()}:</p>
     *
     * <ul>
     *    <li>The {@link EventContextKeys#MESSAGE_CHANNEL}, if any</li>
     *    <li>A message channel containing the <strong>first</strong>
     *    {@link MessageReceiver} in the {@link Cause}</li>
     *    <li>{@link MessageChannel#TO_CONSOLE}</li>
     * </ul>
     *
     * <p>Note that this returns a {@link MessageChannel} and not what
     * may be thought of as a traditional entity executing the command.
     * For the entity the invoked the command, check the
     * {@link Cause#root()} of the {@link #getCause()}.</p>
     *
     * @return The default message channel for any messages.
     */
    MessageChannel getTargetMessageChannel();

    /**
     * Get the {@link Subject} that will be selected for permission checks
     * during command execution (by default).
     *
     * <p>The {@link Subject} will be selected in the following way from the
     * {@link Cause} in {@link #getCause()}:</p>
     *
     * <ul>
     *    <li>The {@link EventContextKeys#SUBJECT}, if any</li>
     *    <li>The <strong>first</strong> {@link Subject} in the {@link Cause}</li>
     * </ul>
     *
     * <p>If no {@link Subject} is returned, permission checks should be done on
     * the console.</p>
     *
     * <p><strong>Note:</strong> while it might be tempting to use this as the
     * invoker of the command, the {@link Cause#root()} and this might be
     * different. Command executors should generally use the root of the
     * {@link Cause} as the target of their command.</p>
     *
     * @return The {@link Subject} responsible, if any.
     */
    Optional<Subject> getSubject();

    /**
     * Gets the {@link Location} that this command is associated with.
     *
     * <p>If not explicit location is set, the following are checked in order:
     *
     * <ul>
     *     <li>{@link #getTargetBlock()}</li>
     *     <li>the location of the first locatable in the {@link Cause}</li>
     * </ul>
     *
     * @return The {@link Location}, if it exists
     */
    // TODO: is this really how this will work? Check, update JDs as necessary.
    Optional<Location> getLocation();

    /**
     * Returns the target block {@link Location}, if applicable.
     *
     * @return The {@link BlockSnapshot} if applicable, or an empty optional.
     */
    Optional<BlockSnapshot> getTargetBlock();

    /**
     * Returns whether this context has any value for the given argument key.
     *
     * @param key The key to look up
     * @return whether there are any values present
     */
    boolean hasAny(Parameter.Key<?> key);

    /**
     * Gets the value for the given key if the key has only one value.
     *
     * @param parameter the {@link Parameter} associated with the argument
     * @param <T> the expected type of the argument
     * @return the argument
     * @throws IllegalArgumentException if more than one value for the key was
     *                                  found
     */
    default <T> Optional<T> getOne(Parameter.Value<T> parameter) throws IllegalArgumentException {
        return getOne(parameter.getKey());
    }

    /**
     * Gets the value for the given key if the key has only one value.
     *
     * @param key the key to get
     * @param <T> the expected type of the argument
     * @return the argument
     * @throws IllegalArgumentException if more than one value for the key was
     *                                  found
     */
    <T> Optional<T> getOne(Parameter.Key<T> key) throws IllegalArgumentException;

    /**
     * Gets the value for the given key if the key has only one value,
     * otherwise, throws a {@link NoSuchElementException}.
     *
     * @param parameter the {@link Parameter} associated with the argument
     * @param <T> the expected type of the argument
     * @return the argument
     * @throws NoSuchElementException if no value for the key was found
     * @throws IllegalArgumentException if more than one value for the key was
     *                                  found
     */
    default  <T> T requireOne(Parameter.Value<T> parameter) throws NoSuchElementException, IllegalArgumentException {
        return requireOne(parameter.getKey());
    }

    /**
     * Gets the value for the given key if the key has only one value,
     * otherwise, throws a {@link NoSuchElementException}.
     *
     * @param key the key to get
     * @param <T> the expected type of the argument
     * @return the argument
     * @throws NoSuchElementException if no value for the key was found
     * @throws IllegalArgumentException if more than one value for the key was
     *                                  found
     */
    <T> T requireOne(Parameter.Key<T> key) throws NoSuchElementException, IllegalArgumentException;

    /**
     * Gets all values for the given argument. May return an empty list if no#
     * values are present.
     *
     * @param parameter the {@link Parameter} associated with the argument
     * @param <T> the expected type of the argument
     * @return the argument
     */
    default <T> Collection<? extends T> getAll(Parameter.Value<T> parameter) {
        return getAll(parameter.getKey());
    }

    /**
     * Gets all values for the given argument. May return an empty list if no
     * values are present.
     *
     * @param key The key to get values for
     * @param <T> the type of value to get
     * @return the collection of all values
     */
    <T> Collection<? extends T> getAll(Parameter.Key<T> key);

    interface Builder extends ResettableBuilder<CommandContext, Builder>, CommandContext {

        /**
         * Adds a parsed object into the context, for use by commands.
         *
         * @param parameter The key to store the entry under.
         * @param value The collection of objects to store.
         */
        default <T> void putEntry(Parameter.Value<T> parameter, T value) {
            putEntry(parameter.getKey(), value);
        }

        /**
         * Adds a collection of parsed objects into the context, for use by commands.
         *
         * @param parameter The key to store the entry under.
         * @param value The collection of objects to store.
         */
        default <T> void putEntries(Parameter.Value<T> parameter, Collection<T> value) {
            value.forEach(val -> putEntry(parameter, val));
        }

        /**
         * Adds a collection of parsed objects into the context, for use by commands.
         *
         * @param parameter The key to store the entry under.
         * @param value The collection of objects to store.
         */
        default <T> void putEntries(Parameter.Key<T> parameter, Collection<T> value) {
            value.forEach(val -> putEntry(parameter, val));
        }

        /**
         * Adds a parsed object into the context, for use by commands.
         *
         * @param key The key to store the entry under.
         * @param object The object to store.
         */
        <T> void putEntry(Parameter.Key<T> key, T object);

        /**
         * Creates a snapshot of this context and returns a state object that can
         * be used to restore the context to this state.
         *
         * @return The state.
         */
        State getState();

        /**
         * Uses a previous snapshot of the context and restores it to that state.
         *
         * @param state The state obtained from {@link #getState()}
         */
        void setState(State state);

        /**
         * An immutable snapshot of a {@link CommandContext.Builder}.
         *
         * <p>No assumptions should be made about the form of this state object,
         * it is not defined in the API and may change at any time.</p>
         */
        interface State {}
    }

}
