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
package org.spongepowered.api.text;

import com.google.common.collect.ImmutableList;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Collection;

/**
 * Represents a view of the Book GUI on the client. A BookView is not
 * associated with any Book {@link ItemStack} that exists on the server and is
 * simply for displaying {@link Text} to the player. This BookView is read-only
 * as it is currently impossible to tell the client to open an unsigned book.
 */
public interface BookView extends DataSerializable {

    /**
     * Returns the title of the book to be displayed.
     *
     * @return Title of book
     */
    Text getTitle();

    /**
     * Returns the author of the book to be displayed.
     *
     * @return Author of book
     */
    Text getAuthor();

    /**
     * Returns a list of pages that will be displayed to the client.
     *
     * @return List of pages in book
     */
    ImmutableList<Text> getPages();

    /**
     * Returns a new {@link Builder} for chaining.
     *
     * @return Builder for chaining
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Builder class to assist in creation of a new {@link BookView}.
     */
    interface Builder extends ResettableBuilder<BookView, Builder> {

        /**
         * Sets the title of the {@link BookView}.
         *
         * @param title Title of BookView
         * @return This builder
         */
        Builder title(Text title);

        /**
         * Sets the author of the {@link BookView}.
         *
         * @param author Author of BookView
         * @return This builder
         */
        Builder author(Text author);

        /**
         * Adds a page to the end of the {@link BookView}.
         *
         * @param page Page to add
         * @return This builder
         */
        Builder addPage(Text page);

        /**
         * Adds multiple pages to the end of the {@link BookView}.
         *
         * @param pages Pages to add
         * @return This builder
         */
        Builder addPages(Collection<Text> pages);

        /**
         * Adds multiple pages to the end of the {@link BookView}.
         *
         * @param pages Pages to add
         * @return This builder
         */
        Builder addPages(Text... pages);

        /**
         * Inserts a page at the specified index of the {@link BookView}.
         *
         * @param i Index to insert page at
         * @param page Page to insert
         * @return This builder
         */
        Builder insertPage(int i, Text page);

        /**
         * Inserts multiple pages at the specified index of the
         * {@link BookView}.
         *
         * @param i Index to insert pages at
         * @param pages Pages to insert
         * @return This builder
         */
        Builder insertPages(int i, Collection<Text> pages);

        /**
         * Inserts multiple pages at the specified index of the
         * {@link BookView}.
         *
         * @param i Index to insert pages at
         * @param pages Pages to insert
         * @return This builder
         */
        Builder insertPages(int i, Text... pages);

        /**
         * Removes a page from the {@link BookView}.
         *
         * @param page Page to remove
         * @return This builder
         */
        Builder removePage(Text page);

        /**
         * Removes the page at the specified index of the {@link BookView}.
         *
         * @param i Index of page to remove
         * @return This builder
         */
        Builder removePage(int i);

        /**
         * Removes multiple pages from the {@link BookView}.
         *
         * @param pages Pages to remove
         * @return This builder
         */
        Builder removePages(Collection<Text> pages);

        /**
         * Removes multiple pages from the {@link BookView}.
         *
         * @param pages Pages to remove
         * @return This builder
         */
        Builder removePages(Text... pages);

        /**
         * Removes all pages from the {@link BookView}.
         *
         * @return This builder
         */
        Builder clearPages();

        /**
         * Creates a new {@link BookView} from the current state of this
         * builder.
         *
         * @return New BookView
         */
        BookView build();
    }
}
