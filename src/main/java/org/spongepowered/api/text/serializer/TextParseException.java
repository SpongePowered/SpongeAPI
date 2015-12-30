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
package org.spongepowered.api.text.serializer;

/**
 * Thrown if a string fails to be parsed as formatted Text instance.
 */
public class TextParseException extends RuntimeException {

    private static final long serialVersionUID = 564822839621455085L;

    /**
     * Constructs a new {@link TextParseException}.
     */
    public TextParseException() {
    }

    /**
     * Constructs a new {@link TextParseException} with the specified message.
     *
     * @param message The exception message
     */
    public TextParseException(String message) {
        super(message);
    }

    /**
     * Constructs a new {@link TextParseException} with the specified message
     * and cause.
     *
     * @param message The exception message
     * @param cause The cause of this exception
     */
    public TextParseException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new {@link TextParseException} with the specified cause.
     *
     * @param cause The cause of this exception
     */
    public TextParseException(Throwable cause) {
        super(cause);
    }

}
