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
package org.spongepowered.api.service.persistence.data;

import com.google.common.base.Optional;

/**
 * Represents a query to a {@link DataContainer} or {@link DataView} to fetch
 * data.
 */
public final class DataQuery {
    private final char separator;
    private final String path;

    public DataQuery(final char separator, String path) {
        this.separator = separator;
        this.path = path;
    }

    public char getSeparator() {
        return this.separator;
    }

    public String getFirst() {
        return this.path.substring(this.path.indexOf(this.separator));
    }

    public String getPath() {
        return this.path;
    }

    public boolean hasNext() {
        return this.path.indexOf(this.separator) != -1;
    }

    public Optional<DataQuery> next() {
        int index = this.path.indexOf(this.separator);
        if (index == -1) {
            return Optional.absent();
        }

        return Optional.of(new DataQuery(this.separator, this.path.substring(this.path.indexOf(this.separator) + 1)));
    }

}
