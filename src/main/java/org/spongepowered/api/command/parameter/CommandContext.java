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

import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.world.Locatable;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * The {@link CommandContext} contains the parsed arguments for a
 * command, and any other information that might be important.
 */
public interface CommandContext {

    // TODO: Better descriptions
    /**
     * Gets the {@link CommandSource} that this command acts as if it was
     * requested by
     *
     * @return The {@link CommandSource}
     */
    Optional<CommandSource> getCommandSource();

    /**
     * Gets the {@link Entity} that this command originated from.
     *
     * @return The {@link Entity}
     */
    Optional<Entity> getEntityTarget();

    /**
     * Gets the {@link Subject} that permission checks should be performed upon,
     * if any.
     *
     * @return The {@link Subject}
     */
    Optional<Subject> getSubject();

    /**
     * Gets the {@link Location} that this command is associated with.
     *
     * <p>If not explicit location is set, the following are checked in order:
     *
     * <ul>
     *     <li>{@link #getTargetBlock()}</li>
     *     <li>the location of {@link #getEntityTarget()}</li>
     *     <li>the location of {@link #getCommandSource()} if a
     *     {@link Locatable}</li>
     * </ul>
     *
     * @return The {@link Location}, if it exists
     */
    Optional<Location<World>> getLocation();

    /**
     * Returns the target block {@link Location}, if applicable.
     *
     * <p>This is different to {@link #getLocation()}, in that it is not
     * associated with the cause</p>
     *
     * @return The {@link Location} if applicable, or an empty optional.
     */
    // TODO: Check this - is this needed?
    Optional<Location<World>> getTargetBlock();

    /**
     * Returns if the current command being parsed is for a tab completion.
     *
     * @return {@code true} if so
     */
    boolean isCompletion();

    /**
     * Returns whether this context has any value for the given argument key.
     *
     * @param key The key to look up
     * @return whether there are any values present
     */
    boolean hasAny(Text key);

    /**
     * Returns whether this context has any value for the given argument key.
     *
     * @param key The key to look up
     * @return whether there are any values present
     */
    boolean hasAny(String key);

    /**
     * Gets the value for the given key if the key has only one value.
     *
     * @param key the key to get
     * @param <T> the expected type of the argument
     * @return the argument
     */
    <T> Optional<T> getOne(Text key);

    /**
     * Gets the value for the given key if the key has only one value.
     *
     * @param key the key to get
     * @param <T> the expected type of the argument
     * @return the argument
     */
    <T> Optional<T> getOne(String key);

    /**
     * Gets the value for the given key if the key has only one value,
     * otherwise, throws a {@link NoSuchElementException}.
     *
     * @param key the key to get
     * @param <T> the expected type of the argument
     * @return the argument
     */
    <T> T getOneUnchecked(Text key);

    /**
     * Gets the value for the given key if the key has only one value,
     * otherwise, throws a {@link NoSuchElementException}.
     *
     * @param key the key to get
     * @param <T> the expected type of the argument
     * @return the argument
     */
    <T> T getOneUnchecked(String key);

    /**
     * Gets all values for the given argument. May return an empty list if no
     * values are present.
     *
     * @param key The key to get values for
     * @param <T> the type of value to get
     * @return the collection of all values
     */
    <T> Collection<T> getAll(Text key);

    /**
     * Gets all values for the given argument. May return an empty list if no
     * values are present.
     *
     * @param key The key to get values for
     * @param <T> the type of value to get
     * @return the collection of all values
     */
    <T> Collection<T> getAll(String key);

    /**
     * Adds a parsed object into the context, for use by commands.
     *
     * <p>If the object that is added to the context a {@link Collection}, it
     * will be unwrapped and each entry will be added to the context
     * individually. However, this does not recurse - collections can be added
     * to the context by adding a collection containing a collection.</p>
     *
     * @param key The key to store the entry under.
     * @param object The object to store.
     */
    void putEntry(Text key, Object object);

    /**
     * Adds a parsed object into the context, for use by commands.
     *
     * <p>If the object that is added to the context a {@link Collection}, it
     * will be unwrapped and each entry will be added to the context
     * individually. However, this does not recurse - collections can be added
     * to the context by adding a collection containing a collection.</p>
     *
     * @param key The key to store the entry under.
     * @param object The object to store.
     */
    void putEntry(String key, Object object);

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
     * An immutable snapshot of a {@link CommandContext}.
     *
     * <p>No assumptions should be made about the form of this state object,
     * it is not defined in the API and may change at any time.</p>
     */
    interface State {}

}
