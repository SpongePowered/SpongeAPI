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

import java.util.Collections;
import java.util.List;

import org.spongepowered.api.text.Text;

/**
 * An abstract base class that can be extended to easily create simple commands.
 */
public abstract class SimpleCommandBase implements CommandCallable {

    private final String permission;
    private final String shortDescription;
    private final Text help;
    private final String usage;

    /**
     * Creates a new command.
     *
     * @param permission The permission needed to execute the command
     * @param shortDescription A command description
     * @param help A formatted help message
     * @param usage A description of the command arguments
     */
    public SimpleCommandBase(String permission, String shortDescription, Text help, String usage) {
        checkNotNull(permission);
        checkNotNull(shortDescription);
        checkNotNull(help);
        checkNotNull(usage);

        this.permission = permission;
        this.shortDescription = shortDescription;
        this.help = help;
        this.usage = usage;
    }

    @Override
    public boolean testPermission(CommandSource source) {
        return source.hasPermission(this.permission);
    }

    @Override
    public String getShortDescription(CommandSource source) {
        return this.shortDescription;
    }

    @Override
    public Text getHelp(CommandSource source) {
        return this.help;
    }

    @Override
    public String getUsage(CommandSource source) {
        return this.usage;
    }

    @Override
    public List<String> getSuggestions(CommandSource source, String arguments) throws CommandException {
        return Collections.<String>emptyList();
    }

}
