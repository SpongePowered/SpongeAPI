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

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
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
    private final ImmutableList<String> parts;

    /**
     * Constructs a query using the given separator character and path.
     *
     * <p>As an example, {@code new DataQuery('/', "a/b/c")} and
     * {@code new DataQuery('.', "a.b.c")} represent the same path but are
     * constructed using different separators.</p>
     *
     * @param separator The separator
     * @param path The path
     */
    public DataQuery(char separator, String path) {
        this(path.split(Pattern.quote(String.valueOf(separator))));
    }

    /**
     * Constructs a query using the given parts.
     *
     * @param parts The parts
     */
    public DataQuery(String... parts) {
        this.parts = ImmutableList.copyOf(parts);
    }

    /**
     * Constructs a query using the given parts.
     *
     * @param parts The parts
     */
    public DataQuery(List<String> parts) {
        this.parts = ImmutableList.copyOf(parts);
    }

    /**
     * Constructs a query using the given separator character and path.
     *
     * <p>As an example, {@code new DataQuery('/', "a/b/c")} and
     * {@code new DataQuery('.', "a.b.c")} represent the same path but are
     * constructed using different separators.</p>
     *
     * @param separator The separator
     * @param path The path
     * @return The newly constructed {@link DataQuery}
     */
    public static DataQuery of(char separator, String path) {
        return new DataQuery(separator, path);
    }

    /**
     * Constructs a query using the given parts.
     *
     * @param parts The parts
     * @return The newly constructed {@link DataQuery}
     */
    public static DataQuery of(String... parts) {
        return new DataQuery(parts);
    }

    /**
     * Constructs a query using the given parts.
     *
     * @param parts The parts
     * @return The newly constructed {@link DataQuery}
     */
    public static DataQuery of(List<String> parts) {
        return new DataQuery(parts);
    }

    /**
     * Gets the parts that make up this query.
     *
     * @return The parts of this query
     */
    public ImmutableList<String> getParts() {
        return this.parts;
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

        builder.addAll(this.parts);
        builder.addAll(that.parts);

        return new DataQuery(builder.build());
    }

    /**
     * Returns the parts of this query as individual queries.
     *
     * @return The constructed queries
     */
    public ImmutableList<DataQuery> getQueryParts() {
        ImmutableList.Builder<DataQuery> builder =
                new ImmutableList.Builder<DataQuery>();

        for (String part : getParts()) {
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
        return Joiner.on(separator).join(this.parts);
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

    @Override
    public String toString() {
        return asString('.');
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.parts);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final DataQuery other = (DataQuery) obj;
        return Objects.equal(this.parts, other.parts);
    }
}
