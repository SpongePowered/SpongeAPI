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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.source.CommandSource;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.CopyableBuilder;

import java.net.URL;
import java.util.function.Consumer;

/**
 * Represents a {@link TextAction} that responds to clicks.
 *
 * @param <R> The type of the result of the action
 */
public interface ClickAction<R> extends TextAction<R> {

    @Override
    default void applyTo(Text.Builder builder) {
        builder.onClick(this);
    }

    /**
     * Opens a url.
     */
    interface OpenUrl extends ClickAction<URL> {

        /**
         * Creates a new builder.
         *
         * @return A new builder
         */
        static Builder builder() {
            return Sponge.getRegistry().createBuilder(Builder.class);
        }

        /**
         * A builder for {@link OpenUrl} click actions.
         */
        interface Builder extends CopyableBuilder<OpenUrl, Builder> {

            /**
             * Sets the url to open.
             *
             * @param url The url
             * @return This builder
             */
            Builder url(URL url);

            /**
             * Builds the action.
             *
             * @return The built action
             */
            OpenUrl build();
        }
    }

    /**
     * Runs a command.
     */
    interface RunCommand extends ClickAction<String> {

        /**
         * Creates a new builder.
         *
         * @return A new builder
         */
        static Builder builder() {
            return Sponge.getRegistry().createBuilder(Builder.class);
        }

        /**
         * A builder for {@link RunCommand} click actions.
         */
        interface Builder extends CopyableBuilder<RunCommand, Builder> {

            /**
             * Sets the command to run.
             *
             * @param command The command
             * @return This builder
             */
            Builder command(String command);

            /**
             * Builds the action.
             *
             * @return The built action
             */
            RunCommand build();
        }
    }

    /**
     * For books, changes pages.
     */
    interface ChangePage extends ClickAction<Integer> {

        /**
         * Creates a new builder.
         *
         * @return A new builder
         */
        static Builder builder() {
            return Sponge.getRegistry().createBuilder(Builder.class);
        }

        /**
         * A builder for {@link ChangePage} click actions.
         */
        interface Builder extends CopyableBuilder<ChangePage, Builder> {

            /**
             * Sets the page to change to.
             *
             * @param page The page
             * @return This builder
             */
            Builder page(int page);

            /**
             * Builds the action.
             *
             * @return The built action
             */
            ChangePage build();
        }
    }

    /**
     * Suggests a command in the prompt.
     */
    interface SuggestCommand extends ClickAction<String> {

        /**
         * Creates a new builder.
         *
         * @return A new builder
         */
        static Builder builder() {
            return Sponge.getRegistry().createBuilder(Builder.class);
        }

        /**
         * A builder for {@link SuggestCommand} click actions.
         */
        interface Builder extends CopyableBuilder<SuggestCommand, Builder> {

            /**
             * Sets the command to suggest.
             *
             * @param command The command
             * @return This builder
             */
            Builder command(String command);

            /**
             * Builds the action.
             *
             * @return The built action
             */
            SuggestCommand build();
        }
    }

    /**
     * Execute a callback.
     */
    interface ExecuteCallback extends ClickAction<Consumer<CommandSource>> {

        /**
         * Creates a new builder.
         *
         * @return A new builder
         */
        static Builder builder() {
            return Sponge.getRegistry().createBuilder(Builder.class);
        }

        /**
         * A builder for {@link ExecuteCallback} click actions.
         */
        interface Builder extends CopyableBuilder<ExecuteCallback, Builder> {

            /**
             * Sets the callback to execute.
             *
             * @param callback The callback
             * @return This builder
             */
            Builder callback(Consumer<CommandSource> callback);

            /**
             * Builds the action.
             *
             * @return The built action
             */
            ExecuteCallback build();
        }
    }
}
