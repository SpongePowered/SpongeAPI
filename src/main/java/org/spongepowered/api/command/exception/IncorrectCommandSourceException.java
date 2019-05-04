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

import org.spongepowered.api.command.source.CommandSource;
import org.spongepowered.api.text.Text;

/**
 * This exception is thrown when the target {@link CommandSource}s is of the
 * correct type to call the target command.
 */
public class IncorrectCommandSourceException extends CommandException {
    private static final long serialVersionUID = -2927330349931825821L;

    /**
     * Create a permissions exception with a custom message.
     *
     * @param message The message
     */
    public IncorrectCommandSourceException(Text message) {
        super(message);
    }

    /**
     * Create a permissions exception with a custom message and cause.
     *
     * @param message the message
     * @param cause the cause
     */
    public IncorrectCommandSourceException(Text message, Throwable cause) {
        super(message, cause);
    }
}
