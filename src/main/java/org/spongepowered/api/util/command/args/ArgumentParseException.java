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
package org.spongepowered.api.util.command.args;

import com.google.common.base.Strings;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.CommandException;

/**
 * Exception thrown when an error occurs while parsing arguments.
 */
public class ArgumentParseException extends CommandException {
    private static final long serialVersionUID = -8555316116315990226L;

    private final String source;
    private final int position;

    /**
     * Return a new {@link ArgumentParseException} with the given message, source and position.
     *
     * @param message The message to use for this exception
     * @param source The source string being parsed
     * @param position The current position in the source string
     */
    public ArgumentParseException(Text message, String source, int position) {
        super(message);
        this.source = source;
        this.position = position;
    }

    /**
     * Return a new {@link ArgumentParseException} with the given message, cause, source and position.
     *
     * @param message The message to use for this exception
     * @param cause The cause for this exception
     * @param source The source string being parsed
     * @param position The current position in the source string
     */
    public ArgumentParseException(Text message, Throwable cause, String source, int position) {
        super(message, cause);
        this.source = source;
        this.position = position;
    }

    @Override
    public Text getText() {
        Text superText = super.getText();
        if (this.source == null || this.source.isEmpty()) {
            return super.getText();
        } else if (superText == null) {
            return Texts.of(getAnnotatedPosition());
        } else {
            return Texts.of(superText, '\n', getAnnotatedPosition());
        }
    }

    /**
     * Return a string pointing to the position of the arguments when this exception occurs.
     *
     * @return The appropriate position string
     */
    public String getAnnotatedPosition() {
        String source = this.source;
        int position = this.position;
        if (source.length() > 80) {
            if (position >= 37) {
                int startPos = position - 37;
                int endPos = Math.min(source.length(), position + 37);
                if (endPos < source.length()) {
                    source = "..." + source.substring(startPos, endPos) + "...";
                } else {
                    source = "..." + source.substring(startPos, endPos);
                }
                position -= 40;
            } else {
                source = source.substring(0, 77) + "...";
            }
        }
        return source + "\n" + Strings.repeat(" ", position) + "^";
    }

    /**
     * Get the position of the last fetched argument in the provided source string.
     *
     * @return The source string to get position for
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * Returns the source string arguments are being parsed from.
     *
     * @return The source string
     */
    public String getSourceString() {
        return this.source;
    }
}
