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

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DataQueryTest {

    /**
     * Method: of()
     */
    @Test
    public void testOf() {
        DataQuery.of();
        DataQuery.of("derp");
    }

    /**
     * Method: of(char separator, String path)
     */
    @Test
    public void testOfForSeparatorPath() {
        DataQuery first = DataQuery.of('.', "this.test.equals");
        DataQuery second = DataQuery.of(',', "this,test,equals");
        DataQuery complex = DataQuery.of('\u8482', "this\u8482test\u8482equals");
        DataQuery test = DataQuery.of("this", "test", "equals");
        assertThat(first.equals(test), is(true));
        assertThat(first.equals(second), is(true));
        assertThat(first.equals(complex), is(true));
        assertThat(second.equals(complex), is(true));
        assertThat(second.equals(first), is(true));
        assertThat(second.equals(test), is(true));
    }

    /**
     * Method: of(String... parts)
     */
    @Test
    public void testOfParts() {
        DataQuery first = DataQuery.of("this", "parts", "equal");
        DataQuery second = DataQuery.of('.', "this.parts.equal");
        assertThat(first.equals(second), is(true));
        assertThat(second.equals(first), is(true));
    }

    /**
     * Method: getParts()
     */
    @Test
    public void testGetParts() {
        final DataQuery query = DataQuery.of("this", "parts", "test");
        final List<String> parts = new ArrayList<>();
        parts.add("this");
        parts.add("parts");
        parts.add("test");
        assertThat(query.getParts().equals(parts), is(true));
    }

    /**
     * Method: then(DataQuery that)
     */
    @Test
    public void testThen() {
        final DataQuery query = DataQuery.of("this", "testing");
        final DataQuery other = DataQuery.of("this");
        final DataQuery test = other.then(DataQuery.of("testing"));
        assertThat(query.equals(test), is(true));
        assertThat(test.equals(query), is(true));
    }

    /**
     * Method: getQueryParts()
     */
    @Test
    public void testGetQueryParts() {
        final DataQuery full = DataQuery.of("this", "test", "query");
        final DataQuery part1 = DataQuery.of("this");
        final DataQuery part2 = DataQuery.of("test");
        final DataQuery part3 = DataQuery.of("query");
        final List<DataQuery> parts = full.getQueryParts();
        final List<DataQuery> built = ImmutableList.of(part1, part2, part3);
        assertThat(parts.equals(built), is(true));
        assertThat(built.equals(parts), is(true));
        assertThat(built.containsAll(parts), is(true));
        assertThat(parts.containsAll(built), is(true));
    }

    /**
     * Method: pop()
     */
    @Test
    public void testPop() {
        DataQuery prePopped = DataQuery.of("this", "test", "query");
        DataQuery expected = DataQuery.of("this", "test");
        assertThat(prePopped.pop().equals(expected), is(true));
        DataQuery empty = DataQuery.of();
        DataQuery emptyPopped = empty.pop();
        assertThat(emptyPopped.equals(empty), is(true));

        DataQuery single = DataQuery.of("single");
        assertThat(single.pop().equals(empty), is(true));
    }

    /**
     * Method: last()
     */
    @Test
    public void testLast() {
        final DataQuery full = DataQuery.of("first", "test");
        final DataQuery lastExpected = DataQuery.of("test");
        assertThat(full.last().equals(lastExpected), is(true));
        assertThat(lastExpected.equals(full.last()), is(true));
    }

    /**
     * Method: equals(Object obj)
     */
    @Test
    public void testEquals() {
        DataQuery query1 = DataQuery.of("test");
        DataQuery query2 = DataQuery.of("test");
        DataQuery nonEqual = DataQuery.of("nope");
        assertThat(query1.equals(query1), is(true));
        assertThat(query1.equals(query2), is(true));
        assertThat(query1.equals(nonEqual), is(false));
    }

}
