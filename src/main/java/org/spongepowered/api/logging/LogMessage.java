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
package org.spongepowered.api.logging;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;

import java.util.Optional;

/**
 * Represents a log message that may be either a {@link Text} or {@link String}.
 */
public interface LogMessage {

    /**
     * If an exception was logged along with this message, the return value of this method will contain it.
     *
     * @return An optional exception to be logged as part of this message
     */
    Optional<Throwable> getThrowable();

    /**
     * Get the time this message was logged at.
     *
     * @return THe time this message was logged at
     */
    long getTime();

    /**
     * Get the formatted {@link Text} representation of this message. If this message was not originally provided as a Text, it will be converted
     * on first use
     * @return The message as formattable Text
     */
    Text getMessage();

    /**
     * Get the plain message if a String message was passed, or return the Text message converted using {@link Texts#toPlain(Text)}.
     *
     * @return The plain message
     */
    String getPlainMessage();
}
