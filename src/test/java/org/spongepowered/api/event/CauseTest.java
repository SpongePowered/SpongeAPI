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

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.equalToObject;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;

import com.google.common.collect.ImmutableList;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.spongepowered.api.matcher.SpongeMatchers;

import java.util.List;
import java.util.Optional;

class CauseTest {

    @Test
    void testPopulatedCause() {
        Cause.builder().append("foo").build(EventContext.empty());
    }

    @Test
    void testNullCause() {
        Assertions.assertThrows(NullPointerException.class, () -> Cause.builder().append(null));
    }

    @Test
    void testWithCause() {
        final Cause old = Cause.of(EventContext.empty(), "foo");
        final Cause newCause = old.with("bar");
        MatcherAssert.assertThat(old, is(not(newCause)));
        List<?> list = newCause.all();
        MatcherAssert.assertThat(list, containsInAnyOrder("foo", "bar"));
    }

    @Test
    void testWithNullCause() {
        final Cause old = Cause.of(EventContext.empty(), "foo");
        Assertions.assertThrows(NullPointerException.class, () -> old.with((Object) null));
    }

    @Test
    void testToString() {
        final Cause cause = Cause.builder().append("foo").append("bar").append(1).append(2).build(EventContext.empty());
        final String causeString = cause.toString();
        MatcherAssert.assertThat(causeString, not(emptyString()));
    }

    @Test
    void testBefore() {
        final Cause cause = Cause.builder().append("foo").append(1).append(2).build(EventContext.empty());
        final Optional<?> optional = cause.before(Integer.class);
        MatcherAssert.assertThat(optional, is(SpongeMatchers.present()));
        MatcherAssert.assertThat(optional, SpongeMatchers.valueIs(equalToObject("foo")));
    }

    @Test
    void testAfter() {
        final Cause cause = Cause.builder().append("foo").append(1).append(2).build(EventContext.empty());
        final Optional<?> optional = cause.after(Integer.class);
        MatcherAssert.assertThat(optional, is(SpongeMatchers.present()));
        MatcherAssert.assertThat(optional, SpongeMatchers.valueIs(equalToObject(2)));
    }

    @Test
    void testNoneAfter() {
        final Cause cause = Cause.builder().append("foo").append(1).build(EventContext.empty());
        final Optional<?> optional = cause.after(Integer.class);
        MatcherAssert.assertThat(optional, is(not(SpongeMatchers.present())));
    }

    @Test
    void testNoneBefore() {
        final Cause cause = Cause.builder().append("foo").append(1).build(EventContext.empty());
        final Optional<?> optional = cause.before(String.class);
        MatcherAssert.assertThat(optional, is(not(SpongeMatchers.present())));
    }

    @Test
    void testNoneOf() {
        final Cause cause = Cause.builder().append("foo").append(1).append(2).append(3).build(EventContext.empty());
        MatcherAssert.assertThat(cause.noneOf(Integer.class), hasSize(1));
        MatcherAssert.assertThat(cause.noneOf(Integer.class).get(0), is("foo"));
    }

    @Test
    void testListedArray() {
        final List<String> fooList = ImmutableList.of("foo", "bar", "baz", "floof");
        final Cause cause = Cause.builder().append("foo").append("bar").append("baz").append("floof").build(EventContext.empty());
        final List<String> stringList = cause.allOf(String.class);
        MatcherAssert.assertThat(stringList, is(not(empty())));
        MatcherAssert.assertThat(stringList, is(fooList));
    }

}
