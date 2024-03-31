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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        Assertions.assertNotEquals(old, newCause);
        final List<?> list = newCause.all();
        Assertions.assertTrue(list.contains("foo"));
        Assertions.assertTrue(list.contains("bar"));
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
        Assertions.assertFalse(causeString.isEmpty());
    }

    @Test
    void testBefore() {
        final Cause cause = Cause.builder().append("foo").append(1).append(2).build(EventContext.empty());
        final Optional<?> optional = cause.before(Integer.class);
        Assertions.assertTrue(optional.isPresent());
        Assertions.assertEquals(optional.get(), "foo");
    }

    @Test
    void testAfter() {
        final Cause cause = Cause.builder().append("foo").append(1).append(2).build(EventContext.empty());
        final Optional<?> optional = cause.after(Integer.class);
        Assertions.assertTrue(optional.isPresent());
        Assertions.assertEquals(optional.get(), 2);
    }

    @Test
    void testNoneAfter() {
        final Cause cause = Cause.builder().append("foo").append(1).build(EventContext.empty());
        final Optional<?> optional = cause.after(Integer.class);
        Assertions.assertTrue(optional.isEmpty());
    }

    @Test
    void testNoneBefore() {
        final Cause cause = Cause.builder().append("foo").append(1).build(EventContext.empty());
        final Optional<?> optional = cause.before(String.class);
        Assertions.assertTrue(optional.isEmpty());
    }

    @Test
    void testNoneOf() {
        final Cause cause = Cause.builder().append("foo").append(1).append(2).append(3).build(EventContext.empty());
        Assertions.assertEquals(cause.noneOf(Integer.class).size(), 1);
        Assertions.assertEquals(cause.noneOf(Integer.class).get(0), "foo");
    }

    @Test
    void testListedArray() {
        final List<String> fooList = List.of("foo", "bar", "baz", "floof");
        final Cause cause = Cause.builder().append("foo").append("bar").append("baz").append("floof").build(EventContext.empty());
        final List<String> stringList = cause.allOf(String.class);
        Assertions.assertFalse(stringList.isEmpty());
        Assertions.assertEquals(stringList, fooList);
    }

}
