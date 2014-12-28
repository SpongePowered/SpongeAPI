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

package org.spongepowered.api.item.data;

import com.google.common.base.Optional;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.text.message.Message;

import java.util.List;

/**
 * Represents the item data for a books like {@link ItemTypes#WRITTEN_BOOK}.
 */
public interface Book extends ItemData {

    /**
     * Checks whether this book has a title.
     *
     * @return True, if this book has a title
     */
    boolean hasTitle();

    /**
     * Gets the title of this book.
     *
     * @return The title of this book
     */
    Optional<Message> getTitle();

    /**
     * Checks whether this book has an author.
     *
     * @return True, if this book has aan author
     */
    boolean hasAuthor();

    /**
     * Gets the author of this book.
     *
     * @return The author of this book
     */
    Optional<Message> getAuthor();

    /**
     * Checks whether this book has any pages.
     *
     * @return True, if this book has pages
     */
    boolean hasPages();

    /**
     * Gets the specified page.
     *
     * @param index The page to return
     * @return The page with the given index
     * @throws IndexOutOfBoundsException if {@code index < 0} or
     *             {@code index >= getPageCount()}
     */
    Message getPage(int index) throws IndexOutOfBoundsException;

    /**
     * Get a list of all pages of this book.
     *
     * @return A list of all pages in this book
     */
    List<Message> getPages();

    /**
     * Gets the number of pages in this book.
     *
     * @return The number of pages in this book
     */
    int getPageCount();

    public static interface BookBuilder extends ItemDataBuilder {

        // TODO: Add methods for builder

        @Override
        Book build();

    }

}
