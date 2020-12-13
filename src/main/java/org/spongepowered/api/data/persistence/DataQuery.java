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
package org.spongepowered.api.data.persistence;

import com.google.common.collect.ImmutableList;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Spliterator;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.regex.Pattern;

/**
 * Represents a query that can be done on views. Queries do not depend on
 * their separator, it is just a way to construct them.
 */
public final class DataQuery implements Iterable<String> {

    private static final DataQuery EMPTY = new DataQuery();

    /**
     * The parts that make up this query.
     */
    private final ImmutableList<String> parts;

    private @MonotonicNonNull ImmutableList<DataQuery> queryParts; //lazy loaded

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
    private DataQuery(final char separator, final String path) {
        this(path.split(Pattern.quote(String.valueOf(separator))));
    }

    /**
     * Constructs a query using the given parts.
     *
     * @param parts The parts
     */
    private DataQuery(final String... parts) {
        this.parts = ImmutableList.copyOf(parts);
    }

    /**
     * Constructs a query using the given parts.
     *
     * @param parts The parts
     */
    private DataQuery(final List<String> parts) {
        this.parts = ImmutableList.copyOf(parts);
    }

    /**
     * Gets an empty {@link DataQuery}. This query is constant and never
     * changes and therefor can be called multiple times returning the
     * same instance.
     *
     * @return An empty data query
     */
    public static DataQuery of() {
        return DataQuery.EMPTY;
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
    public static DataQuery of(final char separator, final String path) {
        return new DataQuery(separator, path);
    }

    /**
     * Constructs a query using the given parts.
     *
     * @param parts The parts
     * @return The newly constructed {@link DataQuery}
     */
    public static DataQuery of(final String... parts) {
        if (parts.length == 0) {
            return DataQuery.EMPTY;
        }
        return new DataQuery(parts);
    }

    /**
     * Constructs a query using the given parts.
     *
     * @param parts The parts
     * @return The newly constructed {@link DataQuery}
     */
    public static DataQuery of(final List<String> parts) {
        if (parts.isEmpty()) {
            return DataQuery.EMPTY;
        }
        return new DataQuery(parts);
    }

    /**
     * Gets the parts that make up this query. The returned list is immutable.
     *
     * @return The parts of this query
     */
    public List<String> getParts() {
        return this.parts;
    }

    /**
     * Returns a new query that is made up of this query's parts followed by the
     * given query's parts.
     *
     * @param that The given query to follow this one
     * @return The constructed query
     */
    public DataQuery then(final DataQuery that) {
        final ImmutableList.Builder<String> builder = new ImmutableList.Builder<>();

        builder.addAll(this.parts);
        builder.addAll(that.parts);

        return new DataQuery(builder.build());
    }

    /**
     * Returns a new query that is made up of this query's parts followed by the
     * given query.
     *
     * @param that The given query to follow this one
     * @return The constructed query
     */
    public DataQuery then(final String that) {
        final ImmutableList.Builder<String> builder =
            new ImmutableList.Builder<>();

        builder.addAll(this.parts);
        builder.add(that);

        return new DataQuery(builder.build());
    }

    /**
     * Returns the parts of this query as individual queries. The returned list
     * is immutable.
     *
     * @return The constructed queries
     */
    public List<DataQuery> getQueryParts() {
        if (this.queryParts == null) {
            final ImmutableList.Builder<DataQuery> builder = ImmutableList.builder();
            for (final String part : this.getParts()) {
                builder.add(new DataQuery(part));
            }
            this.queryParts = builder.build();
        }
        return this.queryParts;
    }

    /**
     * Returns a {@link DataQuery} where the last node is "popped" off. If this
     * query is already the top level query, then the {@link DataQuery#of()} is
     * returned.
     *
     * @return The next level query
     */
    public DataQuery pop() {
        if (this.parts.size() <= 1) {
            return DataQuery.of();
        }
        final ImmutableList.Builder<String> builder = ImmutableList.builder();
        for (int i = 0; i < this.parts.size() - 1; i++) {
            builder.add(this.parts.get(i));
        }
        return new DataQuery(builder.build());
    }

    /**
     * Returns a {@link DataQuery} where the first node is "popped" off. If this
     * query is already the top level query, then the {@link DataQuery#of()} is
     * returned.
     *
     * @return The next level query
     */
    public DataQuery popFirst() {
        if (this.parts.size() <= 1) {
            return DataQuery.of();
        }
        final ImmutableList.Builder<String> builder = ImmutableList.builder();
        for (int i = 1; i < this.parts.size(); i++) {
            builder.add(this.parts.get(i));
        }
        return new DataQuery(builder.build());
    }

    /**
     * Gets the last entry of this {@link DataQuery}. If this query is
     * a single entry query or an empty query, it returns itself.
     *
     * @return The last entry as a data query, if not already last
     */
    public DataQuery last() {
        if (this.parts.size() <= 1) {
            return this;
        }
        return new DataQuery(this.parts.get(this.parts.size() - 1));
    }

    /**
     * Gets this query as a string separated by the given separator.
     *
     * @param separator The separator
     * @return This query as a string
     */
    public String asString(final String separator) {
        final StringJoiner stringJoiner = new StringJoiner(separator);
        this.parts.forEach(stringJoiner::add);
        return stringJoiner.toString();
    }

    /**
     * Gets this query as a string separated by the given separator character.
     *
     * @param separator The separator
     * @return This query as a string
     */
    public String asString(final char separator) {
        return this.asString(String.valueOf(separator));
    }

    @Override
    public String toString() {
        return this.asString('.');
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.parts);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        final DataQuery other = (DataQuery) obj;
        return Objects.equals(this.parts, other.parts);
    }

    @Override
    public Iterator<String> iterator() {
        return this.parts.iterator();
    }

    @Override
    public void forEach(final Consumer<? super String> action) {
        this.parts.forEach(action);
    }

    @Override
    public Spliterator<String> spliterator() {
        return this.parts.spliterator();
    }

}
