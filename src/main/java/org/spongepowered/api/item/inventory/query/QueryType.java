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

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.util.annotation.CatalogedBy;

/**
 * Represents a possible type of operation for an {@link Inventory#query inventory query}.
 */
@CatalogedBy(QueryTypes.class)
public interface QueryType extends CatalogType {

    /**
     * A type of query that requires no parameters. It can directly be used as a query.
     */
    interface NoParam extends QueryType {
        Query toQuery();
    }

    /**
     * A type of query that requires one parameter.
     *
     * @param <T> The parameter type for the query
     */
    interface OneParam<T> extends QueryType {

        /**
         * Returns the query for given parameter.
         *
         * @param param The parameter
         *
         * @return The new query
         */
        Query of(T param);

    }

    /**
     * A type of query that requires two parameters.
     *
     * @param <T1> The first parameter type for the query
     * @param <T2> The second parameter type for the query
     */
    interface TwoParam<T1, T2> extends QueryType {

        /**
         * Returns the query for given parameters.
         *
         * @param param1 The first parameter
         * @param param2 The second parameter
         *
         * @return The new query
         */
        Query of(T1 param1, T2 param2);
    }
}
