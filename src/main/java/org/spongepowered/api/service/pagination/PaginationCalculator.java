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

import org.spongepowered.api.text.Text;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.text.channel.MessageReceiver;

/**
 * Implementations of PaginationCalculator handle calculating output-specific pagination data.
 */
public interface PaginationCalculator<T extends MessageReceiver> {

    /**
     * Get the maxinum number of lines that can be displayed on a source's screen.
     * @param source The source to check
     * @return The maximum number of displayable lines, or -1 for unlimited
     */
    int getLinesPerPage(T source);

    /**
     * Get the length in lines of the provided text.
     *
     * @param source The source to check for
     * @param text The text to get the length of
     * @return The text's length
     */
    int getLines(T source, Text text);

    /**
     * Return a new text object that contains the provided input centered with the given padding character.
     *
     * @param source The source to center for
     * @param text The text to pad
     * @param padding The padding character
     * @return The centered text
     */
    Text center(T source, Text text, String padding);

}
