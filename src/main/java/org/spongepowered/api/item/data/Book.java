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

import org.spongepowered.api.GameProfile;
import org.spongepowered.api.item.meta.BookGeneration;
import org.spongepowered.api.text.message.Message;

import com.google.common.base.Optional;

import java.util.List;

/**
 * Represents a book item.
 */
public interface Book extends ItemData {

    /**
     * Gets if this book's selectors and scoreboard references have been
     * resolved. This occur the first time it is opened.
     * 
     * @return If this book's selectors and scoreboard references have been
     *         resolved
     */
    boolean hasBeenResolved();

    /**
     * Gets the {@link BookGeneration} of this book.
     * 
     * @return The BookGeneration of this book
     */
    BookGeneration getGeneration();

    /**
     * Sets the {@link BookGeneration} of this book.
     * 
     * @param generation The new BookGeneration of this book
     */
    void setGeneration(BookGeneration generation);
    
    /**
     * Gets the author of this book.
     * 
     * @return The author of this book
     */
    GameProfile getAuthor();
    
    /**
     * Sets the author of this book.
     * 
     * @param profile The new author of this book
     */
    void setAuthor(GameProfile profile);
    
    /**
     * Gets the title of this book.
     * 
     * @return The title of this book
     */
    Message getTitle();
    
    /**
     * Sets the title of this book.
     * 
     * @param title The new title of this book
     */
    void setTitle(Message title);
    
    /**
     * Gets a list containing the pages of this book.
     * 
     * @return The pages of this book
     */
    List<Message> getPages();
    
    /**
     * Gets the text contained in a certain page.
     * 
     * @param page The page number
     * @return The page's text, or Optional.absent() if the page does not exist.
     */
    Optional<Message> getPage(int page);
    
    /**
     * Sets the text contained in a certain page. Note: If a book is being read,
     * it must be closed and reopened for pages to update client-side.
     * 
     * @param page The page number
     * @param text The page's new text
     */
    void setPage(int page, Message text);

    /**
     * Removes a certain page. Note: If a book is being read, it must be closed
     * and reopened for pages to update client-side.
     * 
     * @param page The page number
     */
    void removePage(int page, Message text);
}
