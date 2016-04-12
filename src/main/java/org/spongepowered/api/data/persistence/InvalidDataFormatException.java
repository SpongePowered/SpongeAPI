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
package org.spongepowered.api.data.persistence;

/**
 * An exception that occurs when a {@link DataFormat} is unable to translate
 * from a particular input.
 */
public class InvalidDataFormatException extends UnsupportedOperationException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new {@link InvalidDataFormatException}.
     */
    public InvalidDataFormatException() {
        super();
    }

    /**
     * Constructs a new {@link InvalidDataFormatException} with a message.
     *
     * @param message The message to display with the exception
     */
    public InvalidDataFormatException(String message) {
        super(message);
    }

    /**
     * Constructs a new {@link InvalidDataFormatException} with the specified
     * message and cause.
     *
     * @param message The exception message
     * @param cause The cause of this exception
     */
    public InvalidDataFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new {@link InvalidDataFormatException} with the specified
     * cause and a null message.
     *
     * @param cause The cause of this exception
     */
    public InvalidDataFormatException(Throwable cause) {
        super(cause);
    }
}
