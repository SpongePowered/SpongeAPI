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
package org.spongepowered.api.command.manager;

import org.spongepowered.api.command.Command;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.plugin.PluginContainer;

import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Provides information about a mapping between a command and its aliases.
 */
public interface CommandMapping {

    /**
     * Gets the primary alias.
     *
     * @return The primary alias
     */
    String getPrimaryAlias();

    /**
     * Gets an immutable list of all aliases.
     *
     * <p>The returned list must contain at least one entry, of which one must
     * be the one returned by {@link #getPrimaryAlias()}.</p>
     *
     * <p>There may be several versions of the same alias with different
     * casing, although generally implementations should ignore the casing
     * of aliases.</p>
     *
     * @return A set of aliases
     */
    Set<String> getAllAliases();

    /**
     * Gets the plugin that owns the command.
     *
     * @return The plugin.
     */
    PluginContainer getOwningPlugin();

    /**
     * Gets the {@link Command} associated with this mapping, if associated
     * with the Sponge system.
     *
     * <p>An {@link Optional#empty()} does not indicate no command, rather
     * it infers that an object has registered a command via the underlying
     * engine.</p>
     *
     * @return The {@link Command}, if applicable
     */
    Optional<Command> getCommand();

    /**
     * Gets a {@link Predicate} that
     *
     * @return A {@link Predicate} that determines whether the command can be
     *         run by the given {@link Cause}.
     */
    Predicate<Cause> getRequirements();

}
