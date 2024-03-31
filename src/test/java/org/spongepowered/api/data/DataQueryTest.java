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
package org.spongepowered.api.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.spongepowered.api.data.persistence.DataQuery;

import java.util.ArrayList;
import java.util.List;

class DataQueryTest {

    /**
     * Method: of()
     */
    @Test
    void testOf() {
        DataQuery.of();
        DataQuery.of("derp");
    }

    /**
     * Method: of(char separator, String path)
     */
    @Test
    void testOfForSeparatorPath() {
        final DataQuery first = DataQuery.of('.', "this.test.equals");
        final DataQuery second = DataQuery.of(',', "this,test,equals");
        final DataQuery complex = DataQuery.of('蒂', "this蒂test蒂equals");
        final DataQuery test = DataQuery.of("this", "test", "equals");
        Assertions.assertEquals(first, test);
        Assertions.assertEquals(first, second);
        Assertions.assertEquals(first, complex);
        Assertions.assertEquals(second, complex);
        Assertions.assertEquals(second, first);
        Assertions.assertEquals(second, test);
    }

    /**
     * Method: of(String... parts)
     */
    @Test
    void testOfParts() {
        final DataQuery first = DataQuery.of("this", "parts", "equal");
        final DataQuery second = DataQuery.of('.', "this.parts.equal");
        Assertions.assertEquals(first, second);
        Assertions.assertEquals(second, first);
    }

    /**
     * Method: parts()
     */
    @Test
    void testGetParts() {
        final DataQuery query = DataQuery.of("this", "parts", "test");
        final List<String> parts = new ArrayList<>();
        parts.add("this");
        parts.add("parts");
        parts.add("test");
        Assertions.assertEquals(query.parts(), parts);
    }

    /**
     * Method: then(DataQuery that)
     */
    @Test
    void testThen() {
        final DataQuery query = DataQuery.of("this", "testing");
        final DataQuery other = DataQuery.of("this");
        final DataQuery test = other.then(DataQuery.of("testing"));
        Assertions.assertEquals(query, test);
        Assertions.assertEquals(test, query);
    }

    /**
     * Method: queryParts()
     */
    @Test
    void testGetQueryParts() {
        final DataQuery full = DataQuery.of("this", "test", "query");
        final DataQuery part1 = DataQuery.of("this");
        final DataQuery part2 = DataQuery.of("test");
        final DataQuery part3 = DataQuery.of("query");
        final List<DataQuery> parts = full.queryParts();
        final List<DataQuery> built = List.of(part1, part2, part3);
        Assertions.assertEquals(parts, built);
        Assertions.assertEquals(built, parts);
        Assertions.assertTrue(built.containsAll(parts));
        Assertions.assertTrue(parts.containsAll(built));
    }

    /**
     * Method: pop()
     */
    @Test
    void testPop() {
        final DataQuery prePopped = DataQuery.of("this", "test", "query");
        final DataQuery expected = DataQuery.of("this", "test");
        Assertions.assertEquals(prePopped.pop(), expected);
        final DataQuery empty = DataQuery.of();
        final DataQuery emptyPopped = empty.pop();
        Assertions.assertEquals(emptyPopped, empty);

        final DataQuery single = DataQuery.of("single");
        Assertions.assertEquals(single.pop(), empty);
    }

    /**
     * Method: last()
     */
    @Test
    void testLast() {
        final DataQuery full = DataQuery.of("first", "test");
        final DataQuery lastExpected = DataQuery.of("test");
        Assertions.assertEquals(full.last(), lastExpected);
        Assertions.assertEquals(lastExpected, full.last());
    }

    /**
     * Method: equals(Object obj)
     */
    @Test
    void testEquals() {
        final DataQuery query1 = DataQuery.of("test");
        final DataQuery query2 = DataQuery.of("test");
        final DataQuery nonEqual = DataQuery.of("nope");
        Assertions.assertEquals(query1, query1);
        Assertions.assertEquals(query1, query2);
        Assertions.assertNotEquals(query1, nonEqual);
    }

}
