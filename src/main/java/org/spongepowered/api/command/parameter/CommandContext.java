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

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.identity.Identified;
import net.kyori.adventure.identity.Identity;
import net.kyori.adventure.text.Component;
import org.spongepowered.api.command.Command;
import org.spongepowered.api.command.CommandCause;
import org.spongepowered.api.command.parameter.managed.Flag;
import org.spongepowered.api.service.permission.SubjectProxy;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * The {@link CommandContext} contains the parsed arguments for a command, and
 * any other information that might be important when executing a command.
 *
 * <p>For information about the cause of the command, the {@link CommandCause}
 * is available (see {@link #cause()}. Some popular tasks that operate
 * on the {@link CommandCause} are also directly available on this context,
 * namely permission checks (via {@link SubjectProxy}) and sending a message to
 * the {@link CommandCause}'s {@link Audience} (via {@link #sendMessage}).</p>
 */
public interface CommandContext extends SubjectProxy {

    /**
     * Gets the {@link Command.Parameterized} that is being executed, if it
     * exists.
     *
     * @return The {@link Command.Parameterized}.
     */
    Optional<Command.Parameterized> executedCommand();

    /**
     * Gets the {@link CommandCause} associated with this context.
     *
     * @return The {@link CommandCause}
     */
    CommandCause cause();

    /**
     * Gets if a flag with given alias was specified at least once.
     *
     * <p>If the flag has multiple aliases, (for example, {@code -f} and
     * {@code --flag}, passing {@code f} or {@code flag} to this method will
     * return the same result, regardless of the alias specified by the user.
     * </p>
     *
     * @param flagAlias The flag's alias (without a prefixed dash)
     * @return If the flag was specified
     */
    boolean hasFlag(String flagAlias);

    /**
     * Gets if the given flag was specified once.
     *
     * @param flag The {@link Flag}
     * @return If the flag was specified
     */
    boolean hasFlag(Flag flag);

    /**
     * Returns how many times a given flag was invoked for this command.
     *
     * <p>If the flag has multiple aliases, (for example, {@code -f} and
     * {@code --flag}, passing {@code f} or {@code flag} to this method will
     * return the same result, regardless of the alias specified by the user.
     * </p>
     *
     * @param flagKey The flag's alias (without a prefixed dash)
     * @return The number of times the flag was specified
     */
    int flagInvocationCount(String flagKey);

    /**
     * Returns how many times a given {@link Flag} was invoked for this command.
     *
     * @param flag The {@link Flag}
     * @return The number of times the flag was specified
     */
    int flagInvocationCount(Flag flag);

    /**
     * Returns whether this context has any value for the given argument key.
     *
     * @param parameter the {@link Parameter} associated with the argument
     * @return whether there are any values present
     */
    boolean hasAny(final Parameter.Value<?> parameter);

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
    <T> Optional<T> one(final Parameter.Value<T> parameter) throws IllegalArgumentException;

    /**
     * Gets the value for the given key if the key has only one value.
     *
     * @param key the key to get
     * @param <T> the expected type of the argument
     * @return the argument
     * @throws IllegalArgumentException if more than one value for the key was
     *                                  found
     */
    <T> Optional<T> one(Parameter.Key<T> key) throws IllegalArgumentException;

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
    <T> T requireOne(final Parameter.Value<T> parameter) throws NoSuchElementException, IllegalArgumentException;

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
     * Gets all values for the given argument. May return an empty list if no
     * values are present.
     *
     * @param parameter the {@link Parameter} associated with the argument
     * @param <T> the expected type of the argument
     * @return the argument
     */
    <T> Collection<? extends T> all(final Parameter.Value<T> parameter);

    /**
     * Gets all values for the given argument. May return an empty list if no
     * values are present.
     *
     * @param key The key to get values for
     * @param <T> the type of value to get
     * @return the collection of all values
     */
    <T> Collection<? extends T> all(Parameter.Key<T> key);

    /**
     * Sends a message via {@link CommandCause#audience()}
     *
     * @see Audience#sendMessage(Identified, Component)
     *
     * @param source The {@link Identified} that is the sender of the message
     * @param message The message to send
     */
    void sendMessage(Identified source, Component message);

    /**
     * Sends a message via {@link CommandCause#audience()}
     *
     * @see Audience#sendMessage(Identity, Component)
     *
     * @param source The {@link Identity} of the sender of the message
     * @param message The message to send
     */
    void sendMessage(Identity source, Component message);

    /**
     * A builder for creating this context.
     */
    interface Builder extends CommandContext {

        /**
         * Adds a flag invocation to the context.
         *
         * @param flag The flag to add the invocation for.
         */
        void addFlagInvocation(Flag flag);

        /**
         * Adds a parsed object into the context, for use by commands.
         *
         * @param <T> The type of parameter key
         * @param parameter The key to store the entry under.
         * @param value The collection of objects to store.
         */
        default <T> void putEntry(final Parameter.Value<? super T> parameter, final T value) {
            this.putEntry(parameter.key(), value);
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
        <T> void putEntry(Parameter.Key<T> key, T object);

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
