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

import org.spongepowered.api.text.channel.MessageReceiver;

/**
 * This service allows pagination of output to users.
 */
public interface PaginationService {

    /**
     * Get a new pagination builder to send paginated output to a player.
     *
     * @return The pagination builder
     */
    PaginationList.Builder builder();

    /**
     * Register a pagination calculator for a specific type of command source.
     *
     * @param type The type of command source
     * @param calculator The calculator to register
     * @param <T> The type of paginator
     * @throws IllegalArgumentException When a calculator is registered for a command source type that already has a registered calculator
     */
    <T extends MessageReceiver> void setPaginationCalculator(Class<T> type, PaginationCalculator<? super T> calculator) throws IllegalArgumentException;

    /**
     * Returns a pagination calculator with an unlimited line count, leading to unpaginated output.
     * @return The calculator
     */
    PaginationCalculator<MessageReceiver> getUnpaginatedCalculator();

    /**
     * Create a pagination calculator providing a display of a fixed number of lines.
     *
     * @param lines The lines to display on one page
     * @return The calculator
     */
    PaginationCalculator<MessageReceiver> getFixedLinesCalculator(int lines);
}
