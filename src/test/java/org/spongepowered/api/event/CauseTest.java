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

import org.junit.Test;
import org.spongepowered.api.event.cause.Cause;

public class CauseTest {

    @Test
    public void testEmptyCause() {
        Cause.empty();
    }

    @Test
    public void testPopulatedCause() {
        Cause.of("foo");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullCause() {
        Cause.of((Object) null);
    }

    @Test
    public void testWithCause() {
        final Cause old = Cause.of("foo");
        final Cause newCause = old.with("bar");
        assert old != newCause;
        assert newCause.all().contains("foo");
        assert newCause.all().contains("bar");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullCause() {
        final Cause old = Cause.of("foo");
        final Cause newCause = old.with((Object) null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullCauses() {
        final Cause old = Cause.empty();
        final Cause newCause = old.with(null, null);
    }

    @Test
    public void testToString() {
        final Cause cause = Cause.of("foo", "bar", 1, 2, true, false);
        final String causeString = cause.toString();
        System.err.println(causeString);
    }

}
