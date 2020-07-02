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

import org.spongepowered.api.command.CommandCause;
import org.spongepowered.api.event.cause.Cause;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * The {@link CommandContext} contains the parsed arguments for a
 * command, and any other information that might be important when
 * executing a command.
 *
 * <p>This context also contain methods that determine the
 * {@link Cause} of the command.</p>
 */
public interface CommandContext extends CommandCause {

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
    default <T> Optional<T> getOne(final Parameter.Value<T> parameter) throws IllegalArgumentException {
        return this.getOne(parameter.getKey());
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
    <T> Optional<T> getOne(Parameter.Key<? super T> key) throws IllegalArgumentException;

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
    default  <T> T requireOne(final Parameter.Value<T> parameter) throws NoSuchElementException, IllegalArgumentException {
        return this.requireOne(parameter.getKey());
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
    <T> T requireOne(Parameter.Key<? super T> key) throws NoSuchElementException, IllegalArgumentException;

    /**
     * Gets all values for the given argument. May return an empty list if no
     * values are present.
     *
     * @param parameter the {@link Parameter} associated with the argument
     * @param <T> the expected type of the argument
     * @return the argument
     */
    default <T> Collection<? extends T> getAll(final Parameter.Value<T> parameter) {
        return this.getAll(parameter.getKey());
    }

    /**
     * Gets all values for the given argument. May return an empty list if no
     * values are present.
     *
     * @param key The key to get values for
     * @param <T> the type of value to get
     * @return the collection of all values
     */
    <T> Collection<? extends T> getAll(Parameter.Key<? super T> key);

    /**
     * A builder for creating this context.
     */
    interface Builder extends CommandContext {

        /**
         * Adds a parsed object into the context, for use by commands.
         *
         * @param <T> The type of parameter key
         * @param parameter The key to store the entry under.
         * @param value The collection of objects to store.
         */
        default <T> void putEntry(final Parameter.Value<? super T> parameter, final T value) {
            this.putEntry(parameter.getKey(), value);
        }

        /**
         * Adds a collection of parsed objects into the context, for use by commands.
         *
         * @param <T> The type of parameter key
         * @param parameter The key to store the entry under.
         * @param value The collection of objects to store.
         */
        default <T> void putEntries(final Parameter.Value<? super T> parameter, final Collection<T> value) {
            value.forEach(val -> this.putEntry(parameter, val));
        }

        /**
         * Adds a collection of parsed objects into the context, for use by commands.
         *
         * @param <T> The type of parameter key
         * @param parameter The key to store the entry under.
         * @param value The collection of objects to store.
         */
        default <T> void putEntries(final Parameter.Key<? super T> parameter, final Collection<T> value) {
            value.forEach(val -> this.putEntry(parameter, val));
        }

        /**
         * Adds a parsed object into the context, for use by commands.
         *
         * @param <T> The type of parameter key
         * @param key The key to store the entry under.
         * @param object The object to store.
         */
        <T> void putEntry(Parameter.Key<? super T> key, T object);

        /**
         * Starts a {@link Transaction} which allows for this builder to be
         * returned to a previous state if necessary.
         *
         * <p>Multiple transactions can be started on the same builder, however,
         * they must be either {@link #commit(Transaction) committed} or
         * {@link #rollback(Transaction) rolledback} in reverse order (that is,
         * the last transaction must be committed first)</p>
         *
         * <p>Transactions must not be held on to for longer than necessary.</p>
         *
         * @return The state.
         */
        Transaction startTransaction();

        /**
         * Creates a {@link CommandContext}.
         *
         * <p>If {@link Transaction}s are still open at this point, they will all
         * be {@link #commit(Transaction) committed}.</p>
         *
         * @param input The input argument string.
         * @return The context
         */
        CommandContext build(String input);

        /**
         * Commits the specified {@link Transaction} if it was the most recently
         * created transaction.
         *
         * @param transaction The transaction to commit.
         * @throws IllegalArgumentException Thrown if there are newer
         *  transactions to commit first, if this transaction is not active, or
         *  if this transaction is not part of this builder.
         */
        void commit(Transaction transaction) throws IllegalArgumentException;

        /**
         * Cancels the specified {@link Transaction} if it was the most recently
         * created transaction.
         *
         * @param transaction The transaction to rollback.
         * @throws IllegalArgumentException Thrown if there are newer
         *  transactions to commit first, if this transaction is not active, or
         *  if this transaction is not part of this builder.
         */
        void rollback(Transaction transaction) throws IllegalArgumentException;

        /**
         * A transaction on a context builder.
         */
        interface Transaction { }
    }

}
