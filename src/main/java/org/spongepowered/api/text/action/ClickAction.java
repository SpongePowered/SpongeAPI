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
package org.spongepowered.api.text.action;

import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.text.Text;

import java.net.URL;
import java.util.function.Consumer;

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
    ClickAction(R result) {
        super(result);
    }

    @Override
    public void applyTo(Text.Builder builder) {
        builder.onClick(this);
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
        OpenUrl(URL url) {
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
        RunCommand(String command) {
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
        ChangePage(int page) {
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
        SuggestCommand(String command) {
            super(command);
        }

    }

    /**
     * Execute a callback.
     */
    public static final class ExecuteCallback extends ClickAction<Consumer<CommandSource>> {

        /**
         * Constructs a new {@link ExecuteCallback} that will execute the given
         * runnable on the server when clicked. The callback will expire after
         * some amount of time (not particularly instantly, but not like
         * overnight really either).
         *
         * @param result The callback
         */
        ExecuteCallback(Consumer<CommandSource> result) {
            super(result);
        }
    }

}
