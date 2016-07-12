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
import java.util.Optional;

/**
 * Context that a command is executed in.
 * This object stores parsed arguments from other commands
 */
public final class CommandContext {
    /**
     * The argument key for a target block position that may be present during tab completion, of type {@link Location Location&lt;World>}
     */
    public static final String TARGET_BLOCK_ARG = "target-block-pos-048658"; // Random junk afterwards so we don't accidentally conflict with other args

    /**
     * The argument key which represents that a command context is being used
     * for tab completation.
     */
    public static final String TAB_COMPLETION_CONTEXT = "tab-completion-context-963485";

    private Multimap<String, Object> parsedArgs;

    /**
     * Create a new empty CommandContext.
     */
    public CommandContext() {
        this.parsedArgs = ArrayListMultimap.create();
    }

    /**
     * Creates a {@link org.spongepowered.api.command.args.CommandContext.Snapshot}
     * of the current state of this command context.
     *
     * @return The snapshot
     */
    Snapshot createSnapshot() {
        return new Snapshot(ArrayListMultimap.create(this.parsedArgs));
    }

    /**
     * Restores the {@link org.spongepowered.api.command.args.CommandContext.Snapshot}
     * values.
     *
     * @param snapshot The snapshot
     */
    void restoreSnapshot(Snapshot snapshot) {
        this.parsedArgs = ArrayListMultimap.create(snapshot.parsedArgs);
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
     * Get all values for the given argument. May return an empty list if no values are present.
     *
     * @param key The key to get values for
     * @param <T> the type of value to get
     * @return the collection of all values
     */
    @SuppressWarnings("unchecked")
    public <T> Collection<T> getAll(Text key) {
        return getAll(ArgUtils.textToArgKey(key));
    }

    /**
     * Gets the value for the given key if the key has only one value.
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
        } else {
            return Optional.ofNullable((T) values.iterator().next());
        }
    }

    /**
     * Gets the value for the given key if the key has only one value.
     *
     * @param key the key to get
     * @param <T> the expected type of the argument
     * @return the argument
     */
    @SuppressWarnings("unchecked")
    public <T> Optional<T> getOne(Text key) {
        return getOne(ArgUtils.textToArgKey(key));
    }

    /**
     * Insert an argument into this context.
     *
     * @param key the key to store the arg under
     * @param value the value for this argument
     */
    public void putArg(String key, Object value) {
        checkNotNull(key, "key");
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
     * Removes all the arguments with the specified
     * key from this context.
     *
     * @param key the key the args are stored under
     */
    public void removeArgs(String key) {
        checkNotNull(key, "key");
        this.parsedArgs.removeAll(key);
    }

    /**
     * Removes all the arguments with the specified
     * key from this context.
     *
     * @param key the key the args are stored under
     */
    public void removeArgs(Text key) {
        removeArgs(ArgUtils.textToArgKey(key));
    }

    /**
     * Removes an argument from this context.
     *
     * @param key the key the arg is stored under
     * @param value the value of the argument
     */
    public void removeArg(String key, Object value) {
        checkNotNull(key, "key");
        checkNotNull(value, "value");
        this.parsedArgs.remove(key, value);
    }

    /**
     * Removes an argument from this context.
     *
     * @param key the key the arg is stored under
     * @param value the value of the argument
     */
    public void removeArg(Text key, Object value) {
        removeArg(ArgUtils.textToArgKey(key), value);
    }

    /**
     * Perform a permissions check, throwing an exception if the required permissions are not present.
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
     * A snapshot of the {@link CommandContext}.
     */
    static final class Snapshot {

        private final Multimap<String, Object> parsedArgs;

        Snapshot(Multimap<String, Object> parsedArgs) {
            this.parsedArgs = parsedArgs;
        }
    }
}
