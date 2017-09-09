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
package org.spongepowered.api.event;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.EventContext;

import java.util.List;
import java.util.Optional;

public class CauseTest {

    @Test
    public void testPopulatedCause() {
        Cause.builder().append("foo").build(EventContext.empty());
    }

    @Test(expected = NullPointerException.class)
    public void testNullCause() {
        Cause.builder().append(null);
    }

    @Test
    public void testWithCause() {
        final Cause old = Cause.of(EventContext.empty(), "foo");
        final Cause newCause = old.with("bar");
        assertThat(old, not(newCause));
        List<?> list = newCause.all();
        assertThat(list.contains("foo"), is(true));
        assertThat(list.contains("bar"), is(true));
    }

    @Test(expected = NullPointerException.class)
    public void testWithNullCause() {
        final Cause old = Cause.of(EventContext.empty(), "foo");
        old.with((Object) null);
    }

    @Test
    public void testToString() {
        final Cause cause = Cause.builder().append("foo").append("bar").append(1).append(2).build(EventContext.empty());
        final String causeString = cause.toString();
        assertThat(causeString.isEmpty(), is(false));
    }

    @Test
    public void testBefore() {
        final Cause cause = Cause.builder().append("foo").append(1).append(2).build(EventContext.empty());
        final Optional<?> optional = cause.before(Integer.class);
        assertThat(optional.isPresent(), is(true));
        assertThat(optional.get(), is("foo"));
    }

    @Test
    public void testAfter() {
        final Cause cause = Cause.builder().append("foo").append(1).append(2).build(EventContext.empty());
        final Optional<?> optional = cause.after(Integer.class);
        assertThat(optional.isPresent(), is(true));
        assertThat(optional.get(), is(2));
    }

    @Test
    public void testNoneAfter() {
        final Cause cause = Cause.builder().append("foo").append(1).build(EventContext.empty());
        final Optional<?> optional = cause.after(Integer.class);
        assertThat(optional.isPresent(), is(false));
    }

    @Test
    public void testNoneBefore() {
        final Cause cause = Cause.builder().append("foo").append(1).build(EventContext.empty());
        final Optional<?> optional = cause.before(String.class);
        assertThat(optional.isPresent(), is(false));
    }

    @Test
    public void testNoneOf() {
        final Cause cause = Cause.builder().append("foo").append(1).append(2).append(3).build(EventContext.empty());
        assertThat(cause.noneOf(Integer.class), hasSize(1));
        assertThat(cause.noneOf(Integer.class).get(0), is("foo"));
    }

    @Test
    public void testListedArray() {
        final List<String> fooList = ImmutableList.of("foo", "bar", "baz", "floof");
        final Cause cause = Cause.builder().append("foo").append("bar").append("baz").append("floof").build(EventContext.empty());
        final List<String> stringList = cause.allOf(String.class);
        assertThat(stringList.isEmpty(), is(false));
        assertThat(stringList.equals(fooList), is(true));
    }


}
