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

/**
 * Thrown when a command is not used properly.
 *
 * <p>When handling this exception, print the error message if it is not null.
 * Print a one line help instruction unless {@link #isFullHelpSuggested()}
 * is true, which, in that case, the full help of the command should be
 * shown.</p>
 *
 * <p>If no error message is set and full help is not to be shown, then a generic
 * "you used this command incorrectly" message should be shown.</p>
 */
public class InvalidUsageException extends CommandException {

    private static final long serialVersionUID = 5558126226273675933L;
    private final CommandCallable command;
    private final boolean fullHelpSuggested;

    /**
     * Constructs a new {@link InvalidUsageException} with no error message and
     * with no suggestion that full and complete help for the command should be
     * shown. This will result in a generic error message.
     *
     * @param command The command
     */
    public InvalidUsageException(CommandCallable command) {
        super();
        this.command = checkNotNull(command);
        this.fullHelpSuggested = false;
    }

    /**
     * Constructs a new {@link InvalidUsageException} with a message and with no
     * suggestion that full and complete help for the command should be shown.
     *
     * @param message The message
     * @param command The command
     */
    public InvalidUsageException(String message, CommandCallable command) {
        super(message);
        this.command = checkNotNull(command);
        this.fullHelpSuggested = false;
    }

    /**
     * Constructs a new {@link InvalidUsageException} with a message.
     *
     * @param message The message
     * @param command The command
     * @param fullHelpSuggested True if the full help for the command should be shown
     */
    public InvalidUsageException(String message, CommandCallable command, boolean fullHelpSuggested) {
        super(message);
        this.command = checkNotNull(command);
        this.fullHelpSuggested = fullHelpSuggested;
    }

    /**
     * Constructs a new {@link InvalidUsageException} with a message and throwable
     * cause.
     *
     * @param message The message
     * @param cause The cuase
     * @param command The command
     */
    public InvalidUsageException(String message, Throwable cause, CommandCallable command) {
        super(message, cause);
        this.command = checkNotNull(command);
        this.fullHelpSuggested = false;
    }

    /**
     * Constructs a new {@link InvalidUsageException} with a cause.
     *
     * @param cause The cause
     * @param command The command
     */
    public InvalidUsageException(Throwable cause, CommandCallable command) {
        super(cause);
        this.command = checkNotNull(command);
        this.fullHelpSuggested = false;
    }

    /**
     * Get the command.
     *
     * @return The command
     */
    public CommandCallable getCommand() {
        return this.command;
    }

    /**
     * Return whether the full usage of the command should be shown.
     *
     * @return Show full usage
     */
    public boolean isFullHelpSuggested() {
        return this.fullHelpSuggested;
    }

}
