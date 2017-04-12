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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.Queries;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a view of the Book GUI on the client. A BookView is not
 * associated with any Book {@link ItemStack} that exists on the server and is
 * simply for displaying {@link Text} to the player. This BookView is read-only
 * as it is currently impossible to tell the client to open an unsigned book.
 */
public final class BookView implements DataSerializable {

    final Text title;
    final Text author;
    final ImmutableList<Text> pages;

    BookView(Text title, Text author, ImmutableList<Text> pages) {
        this.title = title;
        this.pages = pages;
        this.author = author;
    }

    /**
     * Returns the title of the book to be displayed.
     *
     * @return Title of book
     */
    public Text getTitle() {
        return this.title;
    }

    /**
     * Returns the author of the book to be displayed.
     *
     * @return Author of book
     */
    public Text getAuthor() {
        return this.author;
    }

    /**
     * Returns a list of pages that will be displayed to the client.
     *
     * @return List of pages in book
     */
    public ImmutableList<Text> getPages() {
        return this.pages;
    }

    /**
     * Returns a new {@link Builder} for chaining.
     *
     * @return Builder for chaining
     */
    public static BookView.Builder builder() {
        return new Builder();
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    @Override
    public DataContainer toContainer() {
        List<DataContainer> pages = this.pages.stream().map(Text::toContainer).collect(Collectors.toList());
        return DataContainer.createNew()
                .set(Queries.CONTENT_VERSION, getContentVersion())
                .set(Queries.TEXT_TITLE, this.title.toContainer())
                .set(Queries.TEXT_AUTHOR, this.author.toContainer())
                .set(Queries.TEXT_PAGE_LIST, pages);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("title", this.title)
                .add("author", this.author)
                .add("pages", this.pages)
                .toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BookView)) {
            return false;
        }
        BookView that = (BookView) obj;
        return this.title.equals(that.title) && this.author.equals(that.author) && this.pages.equals(that.pages);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.title, this.author, this.pages);
    }

    /**
     * Builder class to assist in creation of a new {@link BookView}.
     */
    public static final class Builder implements ResettableBuilder<BookView, Builder> {

        Text title = Text.EMPTY;
        Text author = Text.EMPTY;
        List<Text> pages = new ArrayList<>();

        /**
         * Sets the title of the {@link BookView}.
         *
         * @param title Title of BookView
         * @return This builder
         */
        public Builder title(Text title) {
            this.title = checkNotNull(title, "title");
            return this;
        }

        /**
         * Sets the author of the {@link BookView}.
         *
         * @param author Author of BookView
         * @return This builder
         */
        public Builder author(Text author) {
            this.author = checkNotNull(author, "author");
            return this;
        }

        /**
         * Adds a page to the end of the {@link BookView}.
         *
         * @param page Page to add
         * @return This builder
         */
        public Builder addPage(Text page) {
            this.pages.add(checkNotNull(page, "page"));
            return this;
        }

        /**
         * Adds multiple pages to the end of the {@link BookView}.
         *
         * @param pages Pages to add
         * @return This builder
         */
        public Builder addPages(Collection<Text> pages) {
            this.pages.addAll(checkNotNull(pages, "pages"));
            return this;
        }

        /**
         * Adds multiple pages to the end of the {@link BookView}.
         *
         * @param pages Pages to add
         * @return This builder
         */
        public Builder addPages(Text... pages) {
            addPages(Arrays.asList(checkNotNull(pages, "pages")));
            return this;
        }

        /**
         * Inserts a page at the specified index of the {@link BookView}.
         *
         * @param i Index to insert page at
         * @param page Page to insert
         * @return This builder
         */
        public Builder insertPage(int i, Text page) {
            this.pages.add(i, checkNotNull(page, "page"));
            return this;
        }

        /**
         * Inserts multiple pages at the specified index of the
         * {@link BookView}.
         *
         * @param i Index to insert pages at
         * @param pages Pages to insert
         * @return This builder
         */
        public Builder insertPages(int i, Collection<Text> pages) {
            this.pages.addAll(i, checkNotNull(pages, "pages"));
            return this;
        }

        /**
         * Inserts multiple pages at the specified index of the
         * {@link BookView}.
         *
         * @param i Index to insert pages at
         * @param pages Pages to insert
         * @return This builder
         */
        public Builder insertPages(int i, Text... pages) {
            insertPages(i, Arrays.asList(checkNotNull(pages, "pages")));
            return this;
        }

        /**
         * Removes a page from the {@link BookView}.
         *
         * @param page Page to remove
         * @return This builder
         */
        public Builder removePage(Text page) {
            this.pages.remove(checkNotNull(page, "page"));
            return this;
        }

        /**
         * Removes the page at the specified index of the {@link BookView}.
         *
         * @param i Index of page to remove
         * @return This builder
         */
        public Builder removePage(int i) {
            this.pages.remove(i);
            return this;
        }

        /**
         * Removes multiple pages from the {@link BookView}.
         *
         * @param pages Pages to remove
         * @return This builder
         */
        public Builder removePages(Collection<Text> pages) {
            this.pages.removeAll(checkNotNull(pages, "pages"));
            return this;
        }

        /**
         * Removes multiple pages from the {@link BookView}.
         *
         * @param pages Pages to remove
         * @return This builder
         */
        public Builder removePages(Text... pages) {
            removePages(Arrays.asList(checkNotNull(pages, "pages")));
            return this;
        }

        /**
         * Removes all pages from the {@link BookView}.
         *
         * @return This builder
         */
        public Builder clearPages() {
            this.pages.clear();
            return this;
        }

        /**
         * Creates a new {@link BookView} from the current state of this
         * builder.
         *
         * @return New BookView
         */
        public BookView build() {
            return new BookView(this.title, this.author, ImmutableList.copyOf(this.pages));
        }

        @Override
        public Builder from(BookView value) {
            return builder().title(value.title).author(value.author).addPages(value.pages);
        }

        @Override
        public Builder reset() {
            return builder();
        }

    }
}
