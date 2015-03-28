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
package org.spongepowered.api.net;

/**
 * An exception that is thrown when a channel registration fails.
 *
 * <p>Examples may include: Attempting to register an already registered channel.</p>
 */
public class ChannelRegistrationException extends RuntimeException {

    private static final long serialVersionUID = 7258019249864102811L;

    /**
     * Constructs a new {@link ChannelRegistrationException}.
     */
    public ChannelRegistrationException() {
        super();
    }

    /**
     * Constructs a new {@link ChannelRegistrationException} with a message.
     *
     * @param message The message to include in the stacktrace
     */
    public ChannelRegistrationException(String message) {
        super(message);
    }

    /**
     * Constructs a new {@link ChannelRegistrationException} with the specified message and
     * cause.
     *
     * @param message The exception message
     * @param cause The cause of this exception
     */
    public ChannelRegistrationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new {@link ChannelRegistrationException} with the specified cause and a
     * null message.
     *
     * @param cause The cause of this exception
     */
    public ChannelRegistrationException(Throwable cause) {
        super(cause);
    }
}
