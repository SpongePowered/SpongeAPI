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
package org.spongepowered.api.command.args;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.spongepowered.api.util.SpongeApiTranslationHelper.t;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.world.Location;

import java.util.Collection;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Context that a command is executed in.
 * This object stores parsed arguments from other commands
 */
public final class CommandContext {

    /**
     * The argument key for a target block position that may be present
     * during tab completion, of type {@link Location Location&lt;World&gt;}.
     */
    public static final String TARGET_BLOCK_ARG = "targetblock-pos048658"; // Random junk afterwards so we don't accidentally conflict with other args

    /**
     * The argument key to indicate that a tab completion is taking place.
     */
    public static final String TAB_COMPLETION = "tab-complete-50456"; // Random junk afterwards so we don't accidentally conflict with other args

    private final Multimap<String, Object> parsedArgs;

    /**
     * Create a new empty CommandContext.
     */
    public CommandContext() {
        this.parsedArgs = ArrayListMultimap.create();
    }

    /**
     * Gets all values for the given argument. May return an empty list if no
     * values are present.
     *
     * @param key The key to get values for
     * @param <T> the type of value to get
     * @return the collection of all values
     */
    @SuppressWarnings("unchecked")
    public <T> Collection<T> getAll(String key) {
        return Collections.unmodifiableCollection((Collection<T>) this.parsedArgs.get(key));
    }

    /**
     * Gets all values for the given argument. May return an empty list if no
     * values are present.
     *
     * @param key The key to get values for
     * @param <T> the type of value to get
     * @return the collection of all values
     */
    public <T> Collection<T> getAll(Text key) {
        return getAll(ArgUtils.textToArgKey(key));
    }

    /**
     * Gets the value for the given key if the key has only one value.
     *
     * <p>An empty {@link Optional} indicates that there are either zero or more
     * than one values for the given key. Use {@link #hasAny(Text)} to verify
     * which.</p>
     *
     * @param key the key to get
     * @param <T> the expected type of the argument
     * @return the argument
     */
    @SuppressWarnings("unchecked")
    public <T> Optional<T> getOne(String key) {
        Collection<Object> values = this.parsedArgs.get(key);
        if (values.size() != 1) {
            return Optional.empty();
        }
        return Optional.ofNullable((T) values.iterator().next());
    }

    /**
     * Gets the value for the given key if the key has only one value.
     *
     * <p>An empty {@link Optional} indicates that there are either zero or more
     * than one values for the given key. Use {@link #hasAny(Text)} to verify
     * which.</p>
     *
     * @param key the key to get
     * @param <T> the expected type of the argument
     * @return the argument
     */
    public <T> Optional<T> getOne(Text key) {
        return getOne(ArgUtils.textToArgKey(key));
    }

    /**
     * Gets the value for the given key if the key has only one value, throws an
     * exception otherwise.
     *
     * @param key the key to get
     * @param <T> the expected type of the argument
     * @return the argument
     * @throws java.util.NoSuchElementException if there is no element with the
     *      associated key
     * @throws IllegalArgumentException if there are more than one element
     *      associated with the key (thus, the argument is illegal in this
     *      context)
     * @throws ClassCastException if the element type is not what is expected
     *      by the caller
     */
    @SuppressWarnings("unchecked")
    public <T> T requireOne(String key)
            throws NoSuchElementException, IllegalArgumentException, ClassCastException {
        Collection<Object> values = this.parsedArgs.get(key);
        if (values.size() == 1) {
            return (T) values.iterator().next();
        } else if (values.isEmpty()) {
            throw new NoSuchElementException();
        }

        throw new IllegalArgumentException();
    }

    /**
     * Gets the value for the given key if the key has only one value, throws an
     * exception otherwise.
     *
     * @param key the key to get
     * @param <T> the expected type of the argument
     * @return the argument
     * @throws java.util.NoSuchElementException if there is no element with the
     *      associated key
     * @throws IllegalArgumentException if there are more than one element
     *      associated with the key (thus, the argument is illegal in this
     *      context)
     * @throws ClassCastException if the element type is not what is expected
     */
    public <T> T requireOne(Text key)
            throws NoSuchElementException, IllegalArgumentException, ClassCastException {
        return requireOne(ArgUtils.textToArgKey(key));
    }

    /**
     * Insert an argument into this context.
     *
     * @param key the key to store the arg under
     * @param value the value for this argument
     */
    public void putArg(String key, Object value) {
        checkNotNull(value, "value");
        this.parsedArgs.put(key, value);
    }

    /**
     * Insert an argument into this context.
     *
     * @param key the key to store the arg under
     * @param value the value for this argument
     */
    public void putArg(Text key, Object value) {
        putArg(ArgUtils.textToArgKey(key), value);
    }

    /**
     * Perform a permissions check, throwing an exception if the required
     * permissions are not present.
     *
     * @param commander the source to check against
     * @param permission The permission to check
     * @throws CommandException if the source does not have permission
     */
    public void checkPermission(CommandSource commander, String permission) throws CommandException {
        if (!commander.hasPermission(permission)) {
            throw new CommandException(t("You do not have permission to use this command!"));
        }
    }

    /**
     * Returns whether this context has any value for the given argument key.
     *
     * @param key The key to look up
     * @return whether there are any values present
     */
    public boolean hasAny(String key) {
        return this.parsedArgs.containsKey(key);
    }

    /**
     * Returns whether this context has any value for the given argument key.
     *
     * @param key The key to look up
     * @return whether there are any values present
     */
    public boolean hasAny(Text key) {
        return hasAny(ArgUtils.textToArgKey(key));
    }

    /**
     * Gets a snapshot of the data inside this context to allow it to be
     * restored later.
     *
     * <p>This is only guaranteed to create a <em>shallow copy</em> of the
     * backing store. If any value is mutable, any changes to that value
     * will be reflected in this snapshot. It is therefore not recommended
     * that you keep this snapshot around for longer than is necessary.</p>
     *
     * @return The {@link Snapshot} containing the current state of the
     *      {@link CommandContext}
     */
    public Snapshot createSnapshot() {
        return new Snapshot(this.parsedArgs);
    }

    /**
     * Resets a {@link CommandContext} to a previous state using a previously
     * created {@link Snapshot}.
     *
     * @param snapshot The {@link Snapshot} to restore this context with
     */
    public void applySnapshot(Snapshot snapshot) {
        this.parsedArgs.clear();
        this.parsedArgs.putAll(snapshot.args);
    }

    /**
     * A snapshot of a {@link CommandContext}. This object does not contain any
     * public API methods, a snapshot should be considered a black box.
     */
    public final class Snapshot {

        final Multimap<String, Object> args;

        Snapshot(Multimap<String, Object> args) {
            this.args = ArrayListMultimap.create(args);
        }

    }
}
