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
package org.spongepowered.api.command;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.TextMessageException;

/**
 * Thrown when an executed command raises an error or when execution of
 * the command failed.
 */
public class CommandException extends TextMessageException {

    private static final long serialVersionUID = 4626722485860074825L;

    private final boolean includeUsage;
    private final boolean friendly;

    /**
     * Constructs a new {@link CommandException} with the given message.
     *
     * <p>This exception is "friendly", and can be displayed to users.</p>
     *
     * @param message The detail message
     */
    public CommandException(Text message) {
        this(message, false);
    }

    /**
     * Constructs a new {@link CommandException} with the given message and
     * the given cause.
     *
     * <p>This exception is "friendly", and can be displayed to users.</p>
     *
     * @param message The detail message
     * @param cause The cause
     */
    public CommandException(Text message, Throwable cause) {
        this(message, cause, false);
    }

    /**
     * Constructs a new {@link CommandException} with the given message.
     *
     * @param message The detail message
     * @param includeUsage Whether to include usage in the exception
     */
    public CommandException(Text message, boolean includeUsage) {
        this(message, includeUsage, true);
    }

    /**
     * Constructs a new {@link CommandException} with the given message.
     *
     * @param message The detail message
     * @param includeUsage If the command usage should be included
     * @param friendly If this exception is friendly and can
     *     be displayed to users
     */
    public CommandException(Text message, boolean includeUsage, boolean friendly) {
        super(message);
        this.includeUsage = includeUsage;
        this.friendly = friendly;
    }

    /**
     * Constructs a new {@link CommandException} with the given message and
     * the given cause.
     *
     * @param message The detail message
     * @param cause The cause
     * @param includeUsage Whether to include the usage in the exception
     */
    public CommandException(Text message, Throwable cause, boolean includeUsage) {
        this(message, cause, includeUsage, true);
    }

    /**
     * Constructs a new {@link CommandException} with the given message and
     * the given cause.
     *
     * @param message The detail message
     * @param cause The cause
     * @param includeUsage If the command usage should be included
     * @param friendly If this exception is friendly and can
     *     be displayed to users
     */
    public CommandException(Text message, Throwable cause, boolean includeUsage, boolean friendly) {
        super(message, cause);
        this.includeUsage = includeUsage;
        this.friendly = friendly;
    }

    /**
     * Gets whether the exception should include usage in
     * the presentation of the exception/stack-trace.
     *
     * @return Whether to include usage in the exception
     */
    public boolean shouldIncludeUsage() {
        return this.includeUsage;
    }

    /**
     * Gets if this exception is "friendly".
     *
     * @return If this exception is friendly.
     */
    public boolean isFriendly() {
        return this.friendly;
    }

}
