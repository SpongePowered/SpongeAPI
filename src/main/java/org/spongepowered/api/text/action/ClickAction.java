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

import java.net.URL;

/**
 * Represents a {@link TextAction} that responds to clicks.
 *
 * @param <R> The type of the result of the action
 */
public abstract class ClickAction<R> extends TextAction<R> {

    /**
     * Constructs a new {@link ClickAction} with the given result.
     *
     * @param result The result of the click action
     */
    protected ClickAction(R result) {
        super(result);
    }

    /**
     * Opens a url.
     */
    public static final class OpenUrl extends ClickAction<URL> {

        /**
         * Constructs a new {@link OpenUrl} instance that will ask the player to
         * open an URL when it is clicked.
         *
         * @param url The url to open
         */
        public OpenUrl(URL url) {
            super(url);
        }

    }

    /**
     * Runs a command.
     */
    public static final class RunCommand extends ClickAction<String> {

        /**
         * Constructs a new {@link RunCommand} instance that will run a command
         * on the client when it is clicked.
         *
         * @param command The command to execute
         */
        public RunCommand(String command) {
            super(command);
        }

    }

    /**
     * For books, changes pages.
     */
    public static final class ChangePage extends ClickAction<Integer> {

        /**
         * Constructs a new {@link ChangePage} instance that will change the
         * page in a book when it is clicked.
         *
         * @param page The book page to switch to
         */
        public ChangePage(int page) {
            super(page);
        }

    }

    /**
     * Suggests a command in the prompt.
     */
    public static final class SuggestCommand extends ClickAction<String> {

        /**
         * Constructs a new {@link SuggestCommand} instance that will suggest
         * the player a command when it is clicked.
         *
         * @param command The command to suggest
         */
        public SuggestCommand(String command) {
            super(command);
        }

    }

}
