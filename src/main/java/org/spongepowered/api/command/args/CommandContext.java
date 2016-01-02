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

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandSource;

import java.util.HashMap;
import java.util.Map;

/**
 * Context that a command is executed in.
 * This object stores parsed arguments from other commands
 */
public final class CommandContext {
    private final Map<String, Object> parsedArgs;

    /**
     * Create a new empty CommandContext.
     */
    public CommandContext() {
        this.parsedArgs = new HashMap<>();
    }

    @SuppressWarnings("unchecked")
    public <T> T get(CommandElement.Value<T> element) {
        Object ret = this.parsedArgs.get(ArgUtils.textToArgKey(checkNotNull(element, "Must provide a non-null CommandElement").getKey()));
        if (ret == null) {
            throw new IllegalStateException("Unable to find value for argument " + element.getKey().toPlain() + " in CommandContext");
        }
        return (T) ret;
    }

    public <T> void putArg(CommandElement.Value<T> element, T value) {
        if (this.parsedArgs.putIfAbsent(ArgUtils.textToArgKey(element.getKey()), value) != null) {
            throw new IllegalStateException("A value was already present for CommandElement with key " + element.getKey().toPlain());
        }
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
    public boolean hasAny(CommandElement.Value<?> key) {
        return this.parsedArgs.containsKey(ArgUtils.textToArgKey(checkNotNull(key, "Must provide a non-null CommandElement").getKey()));
    }
}
