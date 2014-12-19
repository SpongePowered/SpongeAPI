/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.util.command;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * An immutable command mapping instance that returns the same objects that
 * this instance is constructed with.
 */
public class ImmutableCommandMapping implements CommandMapping {

    private final String primary;
    private final Set<String> aliases;
    private final CommandCallable callable;

    /**
     * Create a new instance.
     *
     * @param callable The command callable
     * @param primary The primary alias
     * @param alias A list of all aliases
     * @throws IllegalArgumentException Thrown if aliases are duplicated
     */
    public ImmutableCommandMapping(CommandCallable callable, String primary, String... alias) {
        this(callable, primary, Arrays.asList(checkNotNull(alias)));
    }

    /**
     * Create a new instance.
     *
     * @param callable The command callable
     * @param primary The primary alias
     * @param aliases A collection of all aliases
     * @throws IllegalArgumentException Thrown if aliases are duplicated
     */
    public ImmutableCommandMapping(CommandCallable callable, String primary, Collection<String> aliases) {
        checkNotNull(callable);
        checkNotNull(primary);
        checkNotNull(aliases);
        this.primary = primary;
        this.aliases = new HashSet<String>(aliases);
        this.aliases.add(primary);
        this.callable = callable;
    }

    @Override
    public String getPrimaryAlias() {
        return primary;
    }

    @Override
    public Set<String> getAllAliases() {
        return Collections.unmodifiableSet(aliases);
    }

    @Override
    public CommandCallable getCallable() {
        return callable;
    }

    @Override
    public String toString() {
        return "ImmutableCommandMapping{"
               + "primary='" + primary + '\''
               + ", aliases=" + aliases
               + ", callable=" + callable
               + '}';
    }
}
