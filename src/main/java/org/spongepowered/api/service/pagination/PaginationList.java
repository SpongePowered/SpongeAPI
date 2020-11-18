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

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.CopyableBuilder;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Represents an immutable iterable of {@link Component}s, which can be sent to
 * a {@link Audience}.
 *
 * <p>An instance of this class may be obtained using {@link Builder}.</p>
 */
public interface PaginationList {

    /**
     * Creates a new {@link Builder} to build a pagination list.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getServiceProvider().paginationService().builder();
    }

    /**
     * Gets the contents of this pagination list.
     *
     * @return The contents of this pagination list
     */
    Iterable<Component> getContents();

    /**
     * Gets the title text to be used in the title bar of this pagination.
     *
     * @return The title text
     */
    Optional<Component> getTitle();

    /**
     * Gets the header to be displayed for this output on all pages after the
     * title bar but before the contents, if available.
     *
     * <p>Header and footer will use this Text's style and color for
     * formatting.</p>
     *
     * @return The header to be displayed
     */
    Optional<Component> getHeader();

    /**
     * Gets the footer to be displayed for this output on all pages after the
     * contents and page navigation bar, if available.
     *
     * @return The footer
     */
    Optional<Component> getFooter();

    /**
     * Gets the padding character to be used when centering headers and footers.
     *
     * @return The padding character
     */
    Component getPadding();

    /**
     * Gets the maximum amount of lines that will be sent per page.
     *
     * <p>This defaults to the maximum amount of lines that can be displayed
     * on a source's screen at one time if not specified.</p>
     *
     * @return The maximum amount of lines that will be sent per page
     */
    int getLinesPerPage();

    /**
     * Sends the first page of the constructed pagination list
     * to the specified message receiver.
     *
     * @param receiver The receiver to send the first page to
     * @see PaginationList#sendTo(Audience, int) to send a specific page
     */
    default void sendTo(final Audience receiver) {
        this.sendTo(receiver, 1);
    }

    /**
     * Send the specified page of the constructed pagination list
     * to the specified message receiver.
     *
     * <p>A page that is out of bounds will result in a friendly
     * error message being sent to the receiver.</p>
     *
     * <p>Pages start at an index of 1.</p>
     *
     * @param receiver The receiver to send the page to
     * @param page The page to send, starting at an index of 1
     */
    void sendTo(Audience receiver, int page);

    /**
     * Sends the first page of the constructed pagination list to
     * all {@link Audience}s within an {@link Iterable}.
     *
     * @param receivers The message receivers to send the first page to
     * @see PaginationList#sendTo(Iterable, int) to send a specific page
     */
    default void sendTo(final Iterable<Audience> receivers) {
        this.sendTo(receivers, 1);
    }

    /**
     * Sends the specified page of the constructed pagination list
     * all {@link Audience}s within an {@link Iterable}.
     *
     * @param receivers The message receivers to send the page to
     * @param page The page to send
     */
    default void sendTo(final Iterable<Audience> receivers, final int page) {
        Objects.requireNonNull(receivers, "The iterable of receivers cannot be null!");
        for (final Audience receiver : receivers) {
            this.sendTo(receiver, page);
        }
    }

    /**
     * Builds a paginated output for an iterable of {@link Component}s.
     */
    interface Builder extends CopyableBuilder<PaginationList, Builder> {

        /**
         * Sets the contents of this output as an iterable.
         *
         * <p>If this {@link Iterable} is a {@link List}, bidirectional
         * navigation is supported. Otherwise, only going to the next page will
         * be supported.</p>
         *
         * @param contents The contents to output
         * @return This builder
         */
        Builder contents(Iterable<Component> contents);

        /**
         * Sets the contents of this output to be the given array of contents.
         *
         * @param contents The contents to output
         * @return This builder
         */
        Builder contents(Component... contents);

        /**
         * Sets the title text to be used in the title bar of this pagination.
         *
         * <p>This should be less than one line long.</p>
         *
         * @param title The title to use
         * @return This builder
         */
        Builder title(@Nullable Component title);

        /**
         * Sets the header to be displayed for this output on all pages after
         * the title bar but before the contents.
         *
         * <p>The header and footer will use this Text's style and color for
         * formatting.</p>
         *
         * <p>If the header is not specified, or passed in as <code>null</code>,
         * it will be omitted when displaying the list.</p>
         *
         * @param header The header to set
         * @return This builder
         */
        Builder header(@Nullable Component header);

        /**
         * Sets the footer to be displayed for this output on all pages after
         * the contents and page navigation bar.
         *
         * <p>If the footer is not specified, or passed in as <code>null</code>,
         * it will be omitted when displaying the list.</p>
         *
         * @param footer The footer to set
         * @return This builder
         */
        Builder footer(@Nullable Component footer);

        /**
         * Sets the padding character to be used when centering headers and
         * footers.
         *
         * @param padding The padding to use
         * @return This builder
         */
        Builder padding(Component padding);

        /**
         * Sets the maximum number of lines that can be displayed per page.
         *
         * <p>This defaults to the maximum amount of lines that can be displayed
         * on a source's screen at one time if not specified.</p>
         *
         * @param linesPerPage The maximum number of lines to display per page
         * @return This builder
         */
        Builder linesPerPage(int linesPerPage);

        /**
         * Creates a {@link PaginationList} from this pagination builder.
         *
         * @return The pagination list
         * @throws IllegalStateException If no contents were specified
         */
        PaginationList build();

        /**
         * Sends the constructed pagination list to the given receiver.
         *
         * @param receiver The receiver to send the list to
         * @return The constructed pagination list
         */
        default PaginationList sendTo(final Audience receiver) {
            final PaginationList list = this.build();
            list.sendTo(receiver);
            return list;
        }

        /**
         * Sends the constructed pagination list to all
         * {@link Audience}s within an {@link Iterable}.
         *
         * @param receivers The message receivers to send the list to
         * @return The constructed pagination list
         */
        default PaginationList sendTo(final Iterable<Audience> receivers) {
            Objects.requireNonNull(receivers, "The iterable of receivers cannot be null!");
            final PaginationList list = this.build();
            for (final Audience r : receivers) {
                list.sendTo(r);
            }
            return list;
        }

    }
}
