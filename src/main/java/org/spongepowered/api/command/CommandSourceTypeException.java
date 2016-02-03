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

/**
 * Exception thrown when a CommandSource tries to execute a command that cannot
 * be executed by that CommandSource type.
 */
public class CommandSourceTypeException extends CommandException {

    private static final long serialVersionUID = -4945570277201224948L;

    /**
     * Creates a new exception with the specified expected class.
     *
     * @param expected class of source type
     */
    public CommandSourceTypeException(Class<? extends CommandSource> expected) {
        super(Text.of("Only users of type " + expected.getName() + " may execute this command."));
    }

    /**
     * Creates a new exception with the specified message.
     *
     * @param message to display
     */
    public CommandSourceTypeException(Text message) {
        super(message);
    }

    /**
     * Creates a new exception with the specified message and original cause.
     *
     * @param message to display
     * @param cause original cause
     */
    public CommandSourceTypeException(Text message, Throwable cause) {
        super(message, cause);
    }
}
