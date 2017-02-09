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
package org.spongepowered.api.command.args.parsing;

import org.spongepowered.api.command.args.ArgumentParseException;
import org.spongepowered.api.text.Text;

class TokenizerState {
    private final boolean lenient;
    private final String buffer;
    private int index = -1;

    TokenizerState(String buffer, boolean lenient) {
        this.buffer = buffer;
        this.lenient = lenient;
    }

    // Utility methods
    public boolean hasMore() {
        return this.index + 1 < this.buffer.length();
    }

    public int peek() throws ArgumentParseException {
        if (!hasMore()) {
            throw createException(Text.of("Buffer overrun while parsing args"));
        }
        return this.buffer.codePointAt(this.index + 1);
    }

    public int next() throws ArgumentParseException {
        if (!hasMore()) {
            throw createException(Text.of("Buffer overrun while parsing args"));
        }
        return this.buffer.codePointAt(++this.index);
    }

    public ArgumentParseException createException(Text message) {
        return new ArgumentParseException(message, this.buffer, this.index);
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public int getIndex() {
        return this.index;
    }
}
