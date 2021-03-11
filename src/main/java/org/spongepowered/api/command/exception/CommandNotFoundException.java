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
package org.spongepowered.api.command.exception;

import net.kyori.adventure.text.Component;

import java.util.Objects;

/**
 * This exception is thrown when a sender tries to execute a command that does
 * not exist.
 */
public class CommandNotFoundException extends CommandException {

    private static final long serialVersionUID = -7714518367616848051L;

    private final String command;

    /**
     * Create an exception with a custom message.
     *
     * @param message The message
     * @param command The command that was queried for
     */
    public CommandNotFoundException(final Component message, final String command) {
        super(message);
        this.command = Objects.requireNonNull(command, "command");
    }

    /**
     * Returns the command that was queried for.
     *
     * @return The command
     */
    public String command() {
        return this.command;
    }
}
