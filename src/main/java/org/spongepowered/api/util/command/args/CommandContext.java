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
package org.spongepowered.api.util.command.args;

import static org.spongepowered.api.util.command.args.TranslationPlaceholder.t;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandSource;

import java.util.Collection;
import java.util.Collections;

/**
 * Context that a command is executed in.
 * This object stores parsed arguments from other commands
 */
public final class CommandContext {
    private final Multimap<String, Object> parsedArgs;

    /**
     * Create a new empty CommandContext.
     */
    public CommandContext() {
        this.parsedArgs = ArrayListMultimap.create();
    }

    /**
     * Get all values for the given argument. May return an empty list if no values are present.
     *
     * @param key The key to get values for
     * @param <T> the type of value to get
     * @return the collection of all values
     */
    @SuppressWarnings("unchecked")
    public <T> Collection<T> getAll(String key) {
        return Collections.unmodifiableCollection((Collection) this.parsedArgs.get(key));
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
            return Optional.absent();
        } else {
            return Optional.fromNullable((T) values.iterator().next());
        }
    }

    /**
     * Insert an argument into this context.
     *
     * @param key the key to store the arg under
     * @param value the value for this argument
     */
    public void putArg(String key, Object value) {
        Preconditions.checkNotNull(value, "value");
        this.parsedArgs.put(key, value);
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
}
