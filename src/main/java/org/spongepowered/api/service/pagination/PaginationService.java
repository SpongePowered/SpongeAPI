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

import java.util.Optional;
import net.kyori.adventure.audience.Audience;

/**
 * This service allows pagination of output to users.
 */
public interface PaginationService {

    /**
     * Gets a new pagination builder to send paginated output to a player.
     *
     * @return The pagination builder
     */
    PaginationList.Builder builder();

    /**
     * Gets the last known page index of a certain {@link PaginationList} viewed by an {@link Audience}.
     * If the {@link Audience} is reading another {@link PaginationList}, the last known page number of this
     * given list may still be saved and returned.
     *
     * <p>After some time, the list is forgotten about, at which point the page index will return empty.
     *
     * @param audience the audience member who may or may not have viewed any paginated output
     * @param list     the paginated output that the audience member may be viewing
     * @return the last known page index, if it exists
     */
    Optional<Integer> currentPage(Audience audience, PaginationList list);
}
