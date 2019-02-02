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
package org.spongepowered.api.command.parameter;

import org.spongepowered.api.util.ResettableBuilder;

import java.util.List;

/**
 * Completions to send back to the client
 */
// TODO: are we exposing this? If not, this just becomes CompletionsBuilder
public interface Completions {

    interface Builder extends ResettableBuilder<Completions, Builder> {

        /**
         * Gets the command that is being completed.
         *
         * @return The input string
         */
        String getInput();

        /**
         * Gets the argument(s) that require completion.
         *
         * @return The argument(s)
         */
        String getRemaining();

        /**
         * Add a potential completion to the builder.
         *
         * @param completion The completion.
         */
        Builder suggestion(String completion);

        /**
         * Add a potential completion to the builder with a tooltip.
         *
         * @param completion The completion.
         * @param tooltip The tooltip to display.
         */
        Builder suggestion(String completion, String tooltip);

        /**
         * Add a potential completion to the builder.
         *
         * @param completion The completion.
         */
        Builder suggestion(int completion);

        /**
         * Add a potential completion to the builder with a tooltip.
         *
         * @param completion The completion.
         * @param tooltip The tooltip to display.
         */
        Builder suggestion(int completion, String tooltip);

        /**
         * Builds a list of {@link String}s that represent the potential
         * suggestions.
         *
         * @return The list of strings.
         */
        List<String> buildList();

    }

}
