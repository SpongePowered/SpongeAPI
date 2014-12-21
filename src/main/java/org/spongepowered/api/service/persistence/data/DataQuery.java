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

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Represents a query that can be done on views. Queries do not depend on
 * their separator, it is just a way to construct them.
 */
public final class DataQuery {

    /**
     * The parts that make up this query.
     */
    private final String[] parts;

    /**
     * Constructs a query using the given separator and path.
     *
     * <p>As an example, {@code new Query("/", "a/b/c")} and
     * {@code new Query(".", "a.b.c")} represent the same path but are
     * constructed using different separators.</p>
     *
     * @param separator The separator
     * @param path The path
     */
    public DataQuery(String separator, String path) {
        this.parts = path.split(Pattern.quote(separator));
    }

    /**
     * Constructs a query using the given separator character and path.
     *
     * <p>As an example, {@code new Query('/', "a/b/c")} and
     * {@code new Query('.', "a.b.c")} represent the same path but are
     * constructed using different separators.</p>
     *
     * @param separator The separator
     * @param path The path
     */
    public DataQuery(char separator, String path) {
        this(String.valueOf(separator), path);
    }

    /**
     * Constructs a query using the given parts.
     *
     * @param parts The parts
     */
    public DataQuery(String... parts) {
        this.parts = parts.clone();
    }

    /**
     * Constructs a query using the given parts.
     *
     * @param parts The parts
     */
    public DataQuery(List<String> parts) {
       this(parts.toArray(new String[0]));
    }

    /**
     * Gets the parts that make up this query.
     *
     * @return The parts of this query
     */
    public List<String> getParts() {
        return new ImmutableList.Builder<String>().add(parts).build();
    }

    /**
     * Returns a new query that is made up of this query's parts followed by the
     * given query's parts.
     *
     * @param that The given query to follow this one
     * @return The constructed query
     */
    public DataQuery then(DataQuery that) {
        ImmutableList.Builder<String> builder =
                new ImmutableList.Builder<String>();

        builder.addAll(getParts());
        builder.addAll(that.getParts());

        return new DataQuery(builder.build());
    }

    /**
     * Returns the parts of this query as individual queries.
     *
     * @return The constructed queries
     */
    public List<DataQuery> getQueryParts() {
        ImmutableList.Builder<DataQuery> builder =
                new ImmutableList.Builder<DataQuery>();

        for (String part: getParts()) {
            builder.add(new DataQuery(part));
        }

        return builder.build();
    }

    /**
     * Gets this query as a string separated by the given separator.
     *
     * @param separator The separator
     * @return This query as a string
     */
    public String asString(String separator) {
        StringBuilder builder = new StringBuilder();

        if (parts.length > 0) {
            builder.append(parts[0]);
        }

        for (int i = 1; i < parts.length; i++) {
            builder.append(separator);
            builder.append(parts[i]);
        }

        return builder.toString();
    }

    /**
     * Gets this query as a string separated by the given separator character.
     *
     * @param separator The separator
     * @return This query as a string
     */
    public String asString(char separator) {
        return asString(String.valueOf(separator));
    }

}
