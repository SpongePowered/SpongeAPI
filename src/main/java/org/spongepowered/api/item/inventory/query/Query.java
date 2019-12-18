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
package org.spongepowered.api.item.inventory.query;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.util.ResettableBuilder;

/**
 * An inventory query. See {@link QueryTypes} for possible types of queries.
 */
public interface Query {

    /**
     * Returns the query builder.
     *
     * @return The query builder
     */
    static Query.Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Query.Builder.class);
    }

    /**
     * Returns a new query matching any of the queries.
     *
     * @param queries The queries to match
     *
     * @return The new query
     */
    static Query orQueries(Query... queries) {
        return builder().or(queries).build();
    }

    /**
     * Returns a new query which combines the queries in given order with {@link Inventory#union}
     *
     * @param queries The queries to combine
     *
     * @return The new query
     */
    static Query andQueries(Query... queries) {
        return builder().and(queries).build();
    }

    /**
     * Executes this query on given inventory
     *
     * @param inventory The query
     *
     * @return The query result
     */
    Inventory execute(Inventory inventory);

    interface Builder extends ResettableBuilder<Query, Query.Builder> {

        /**
         * Builds a new query matching any of the queries.
         *
         * @param queries The queries to match
         *
         * @return This builder
         */
        Builder or(Query... queries);

        /**
         * Builds a new query which combines the queries in given order.
         * <p>The resulting inventory may contain slots multiple times.</p>
         *
         * @param queries The queries to combine
         *
         * @return This builder
         */
        Builder and(Query... queries);

        /**
         * Builds the composite query.
         *
         * @return The new composity query.
         */
        Query build();
    }
}
