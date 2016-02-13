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
package org.spongepowered.api.service.pagination;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.text.channel.MessageReceiver;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.List;

/**
 * Represents an immutable iterable of {@link Text}s, which can be sent to a {@link MessageReceiver}.
 *
 * <p>An instance of this class may be obtained using {@link Builder}.</p>
 */
public interface PaginationList {

    /**
     * Creates a new {@link Builder} to build a pagination list
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the contents of this pagination list.
     *
     * @return The contents of this pagination list
     */
    Iterable<Text> getContents();

    /**
     * Gets the title text to be used in the title bar of this pagination.
     *
     * @return The title text
     */
    Text getTitle();

    /**
     * Gets the header to be displayed for this output on all pages after the title bar but before the contents
     * Header and footer will use this Text's style and color for formatting.
     *
     * @return The header to be displayed
     */
    Text getHeader();

    /**
     * Gets the footer to be displayed for this output on all pages after the contents and page navigation bar.
     *
     * @return The footer
     */
    Text getFooter();

    /**
     * Gets the padding character to be used when centering headers and footers.
     *
     * @return The padding character
     */
    Text getPaddingString();

    /**
     * Send the constructed pagination list to the given source.
     *
     * @param source The source to send to
     */
    void sendTo(MessageReceiver source);

    /**
     * Send the constructed pagination list to the specified {@link MessageChannel}.
     * @param channel
     */
    default void sendTo(MessageChannel channel) {
        for (MessageReceiver receiver : channel.getMembers()) {
            this.sendTo(receiver);
        }
    }

    /**
     * Builds a paginated output for an iterable of {@link Text}s.
     */
    interface Builder extends ResettableBuilder<PaginationList, Builder> {

        /**
         * Set the contents of this output as an Iterable.
         * If this {@link Iterable} is a {@link List}, bidirectional navigation is supported.
         * Otherwise, only going to the next page will be supported
         *
         * @param contents The contents to output
         * @return this
         */
        Builder contents(Iterable<Text> contents);

        /**
         * Set the contents of this output to be the given array of contents.
         *
         * @param contents The contents to output
         * @return this
         */
        Builder contents(Text... contents);

        /**
         * Set the title text to be used in the title bar of this pagination.
         * This should be less than one line long.
         *
         * @param title The title to use.
         * @return this
         */
        Builder title(Text title);

        /**
         * Set the header to be displayed for this output on all pages after the title bar but before the contents
         * Header and footer will use this Text's style and color for formatting.
         *
         * @param header The header to set
         * @return this
         */
        Builder header(Text header);

        /**
         * Set the footer to be displayed for this output on all pages after the contents and page navigation bar.
         *
         * @param footer The footer to set
         * @return this
         */
        Builder footer(Text footer);

        /**
         * Set the padding character to be used when centering headers and footers.
         *
         * @param padding The padding to use
         * @return this
         */
        Builder padding(Text padding);

        /**
         * Creates a {@link PaginationList} from this pagination builder.
         *
         * @return The pagination list
         */
        PaginationList build();

        /**
         * Send the constructed pagination list to the given source.
         *
         * @param source The source to send to
         */
        void sendTo(MessageReceiver source);

        /**
         * Send the constructed pagination list to the specified {@link MessageChannel}.
         * @param channel
         */
        default void sendTo(MessageChannel channel) {
            for (MessageReceiver receiver : channel.getMembers()) {
                this.sendTo(receiver);
            }
        }

    }
}
