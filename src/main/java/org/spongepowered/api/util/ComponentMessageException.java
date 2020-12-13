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
package org.spongepowered.api.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainComponentSerializer;
import net.kyori.adventure.util.ComponentMessageThrowable;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * A subclass of Exception that contains a rich message that is an instance of
 * {@link Component} rather than a String. This allows formatted and localized
 * exception messages.
 */
public class ComponentMessageException extends Exception implements ComponentMessageThrowable {

    private static final long serialVersionUID = -5281221645176698853L;

    @Nullable private final Component message;

    /**
     * Constructs a new {@link ComponentMessageException}.
     */
    public ComponentMessageException() {
        this.message = null;
    }

    /**
     * Constructs a new {@link ComponentMessageException} with the given message.
     *
     * @param message The detail message
     */
    public ComponentMessageException(final Component message) {
        this.message = message;
    }

    /**
     * Constructs a new {@link ComponentMessageException} with the given message and
     * cause.
     *
     * @param message The detail message
     * @param throwable The cause
     */
    public ComponentMessageException(final Component message, final Throwable throwable) {
        super(throwable);
        this.message = message;
    }

    /**
     * Constructs a new {@link ComponentMessageException} with the given cause.
     *
     * @param throwable The cause
     */
    public ComponentMessageException(final Throwable throwable) {
        super(throwable);
        this.message = null;
    }

    @Override
    public @Nullable String getMessage() {
        final /* @Nullable */ Component message = this.componentMessage();
        return message == null ? null : PlainComponentSerializer.plain().serialize(message);
    }

    /**
     * Returns the text message for this exception, or null if nothing is
     * present.
     * 
     * @return The text for this message
     */
    @Override
    public @Nullable Component componentMessage() {
        return this.message;
    }

    @Override
    public @Nullable String getLocalizedMessage() {
        return this.getMessage();
    }
}
