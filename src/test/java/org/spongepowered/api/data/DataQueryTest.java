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

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import com.google.common.collect.ImmutableList;
import org.hamcrest.MatcherAssert;
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
        DataQuery first = DataQuery.of('.', "this.test.equals");
        DataQuery second = DataQuery.of(',', "this,test,equals");
        DataQuery complex = DataQuery.of('\u8482', "this\u8482test\u8482equals");
        DataQuery test = DataQuery.of("this", "test", "equals");
        MatcherAssert.assertThat(first, is(equalTo(test)));
        MatcherAssert.assertThat(first, is(equalTo(second)));
        MatcherAssert.assertThat(first, is(equalTo(complex)));
        MatcherAssert.assertThat(second, is(equalTo(complex)));
        MatcherAssert.assertThat(second, is(equalTo(first)));
        MatcherAssert.assertThat(second, is(equalTo(test)));
    }

    /**
     * Method: of(String... parts)
     */
    @Test
    void testOfParts() {
        DataQuery first = DataQuery.of("this", "parts", "equal");
        DataQuery second = DataQuery.of('.', "this.parts.equal");
        MatcherAssert.assertThat(first, is(equalTo(second)));
        MatcherAssert.assertThat(second, is(equalTo(first)));
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
        MatcherAssert.assertThat(query.parts(), is(equalTo(parts)));
    }

    /**
     * Method: then(DataQuery that)
     */
    @Test
    void testThen() {
        final DataQuery query = DataQuery.of("this", "testing");
        final DataQuery other = DataQuery.of("this");
        final DataQuery test = other.then(DataQuery.of("testing"));
        MatcherAssert.assertThat(query, is(equalTo(test)));
        MatcherAssert.assertThat(test, is(equalTo(query)));
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
        final List<DataQuery> built = ImmutableList.of(part1, part2, part3);
        MatcherAssert.assertThat(parts, equalTo(built));
        MatcherAssert.assertThat(built, equalTo(parts));
        MatcherAssert.assertThat(built.containsAll(parts), is(true));
        MatcherAssert.assertThat(parts.containsAll(built), is(true));
    }

    /**
     * Method: pop()
     */
    @Test
    void testPop() {
        DataQuery prePopped = DataQuery.of("this", "test", "query");
        DataQuery expected = DataQuery.of("this", "test");
        MatcherAssert.assertThat(prePopped.pop(), equalTo(expected));
        DataQuery empty = DataQuery.of();
        DataQuery emptyPopped = empty.pop();
        MatcherAssert.assertThat(emptyPopped, equalTo(empty));

        DataQuery single = DataQuery.of("single");
        MatcherAssert.assertThat(single.pop(), equalTo(empty));
    }

    /**
     * Method: last()
     */
    @Test
    void testLast() {
        final DataQuery full = DataQuery.of("first", "test");
        final DataQuery lastExpected = DataQuery.of("test");
        MatcherAssert.assertThat(full.last(), equalTo(lastExpected));
        MatcherAssert.assertThat(lastExpected, equalTo(full.last()));
    }

    /**
     * Method: equals(Object obj)
     */
    @Test
    void testEquals() {
        DataQuery query1 = DataQuery.of("test");
        DataQuery query2 = DataQuery.of("test");
        DataQuery nonEqual = DataQuery.of("nope");
        MatcherAssert.assertThat(query1, equalTo(query1));
        MatcherAssert.assertThat(query1, equalTo(query2));
        MatcherAssert.assertThat(query1, is(not(nonEqual)));
    }

}
