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
package org.spongepowered.api.text.action;

/**
 * Represents a {@link TextAction} that responds to shift-clicks.
 *
 * @param <R> the type of the result of the action
 */
public abstract class ShiftClickAction<R> extends TextAction<R> {

    /**
     * Constructs a new {@link ShiftClickAction} with the given result.
     *
     * @param result The result of the shift click action
     */
    protected ShiftClickAction(R result) {
        super(result);
    }

    /**
     * Inserts some text into the chat prompt.
     */
    public static final class InsertText extends ShiftClickAction<String> {

        /**
         * Constructs a new {@link InsertText} instance that will insert text at
         * the current cursor position in the chat when it is shift-clicked.
         *
         * @param text The text to insert
         */
        public InsertText(String text) {
            super(text);
        }

    }
}
