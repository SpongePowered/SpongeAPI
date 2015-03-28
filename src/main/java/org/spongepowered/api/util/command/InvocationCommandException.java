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

/**
 * Thrown when invocation of a command fails, wrapping the exception that
 * is thrown.
 */
public class InvocationCommandException extends CommandException {

    private static final long serialVersionUID = 7859473889077167378L;

    /**
     * Constructs a new {@link InvocationCommandException}.
     */
    public InvocationCommandException() {
        super();
    }

    /**
     * Constructs a new {@link InvocationCommandException} with a message.
     *
     * @param message The detail message
     */
    public InvocationCommandException(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the given message and the given cause.
     *
     * @param message The detail message
     * @param cause The cause
     */
    public InvocationCommandException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified cause and a detail
     * message of.
     *
     * @param cause The cause
     */
    public InvocationCommandException(Throwable cause) {
        super(cause);
    }
}
