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

import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.command.completion.CommandCompleter;

import java.util.List;

/**
 * A command that can be executed.
 *
 * <p>Implementations are not required to implement a sane
 * {@link java.lang.Object#equals(Object)} but may choose to do so.</p>
 */
public interface CommandCallable extends CommandCompleter {

    /**
     * Execute the command based on input arguments.
     *
     * <p>The implementing class must perform the necessary permission
     * checks.</p>
     *
     * @param source The caller of the command
     * @param arguments The raw arguments for this command
     * @param parents A stack of parent commands, where the first entry is
     *                the root command
     * @return Whether a command was processed
     * @throws CommandException Thrown on a command error
     */
    boolean call(CommandSource source, String arguments, List<String> parents) throws CommandException;

    /**
     * Test whether this command can probably be executed by the given source.
     *
     * <p>If implementations are unsure if the command can be executed by
     * the source, {@code true} should be returned. Return values of this method
     * may be used to determine whether this command is listed in command
     * listings.</p>
     *
     * @param source The caller of the command
     * @return Whether permission is (probably) granted
     */
    boolean testPermission(CommandSource source);

    /**
     * Get a short one-line description of this command.
     *
     * <p>The help system may display the description in the command list.</p>
     *
     * @param source The source of the help request
     * @return A description
     */
    String getShortDescription(CommandSource source);

    /**
     * Get a longer formatted help message about this command.
     * 
     * <p>It is recommended to use the default text color and style. Sections 
     * with text actions (e.g. hyperlinks) should be underlined.</p>
     * 
     * <p>Multi-line messages can be created by separating the lines with 
     * {@code \n}.</p>
     * 
     * <p>The help system may display this message when a source requests 
     * detailed information about a command.</p>
     *
     * @param source The source of the help request
     * @return A help text
     */
    Text getHelp(CommandSource source);

    /**
     * Get the usage string of this command.
     *
     * <p>A usage string may look like
     * {@code [-w &lt;world&gt;] &lt;var1&gt; &lt;var2&gt;}.</p>
     * 
     * <p>The string must not contain the command alias.</p>
     *
     * @param source The source of the help request
     * @return A usage string
     */
    String getUsage(CommandSource source);

}
