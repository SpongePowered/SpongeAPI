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

package org.spongepowered.api.util;

/**
 * An exception for when a problem exists between keyboard and chair.
 */
public class PEBKACException extends UnsupportedOperationException {

    private static final long serialVersionUID = 6434648270429319820L;

    /**
     * Constructs a new {@link PEBKACException}.
     */
    public PEBKACException() {
        super();
    }

    /**
     * Constructs a new {@link PEBKACException} with the given message.
     * 
     * @param msg The exception message
     */
    public PEBKACException(String msg) {
        super(msg);
    }

    /**
     * Constructs a new {@link PEBKACException} with the given message and
     * cause.
     * 
     * @param msg The exception message
     * @param cause The cause of the exception
     */
    public PEBKACException(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     * Constructs a new {@link PEBKACException} with the given cause.
     * 
     * @param cause The cause of the exception
     */
    public PEBKACException(Throwable cause) {
        super(cause);
    }

}
