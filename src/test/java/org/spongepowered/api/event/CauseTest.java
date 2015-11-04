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
import org.mockito.Mockito;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.NamedCause;

import java.util.ArrayList;
import java.util.Optional;

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
        assert !causeString.isEmpty();
    }

    @Test
    public void testBefore() {
        final Cause cause = Cause.of("foo", 1, 2);
        final Optional<?> optional = cause.before(Integer.class);
        assert optional.isPresent() && optional.get().equals("foo");
    }

    @Test
    public void testAfter() {
        final Cause cause = Cause.of("foo", 1, 2);
        final Optional<?> optional = cause.after(Integer.class);
        assert optional.isPresent() && optional.get().equals(2);
    }

    @Test
    public void testNoneAfter() {
        final Cause cause = Cause.of("foo", 1);
        final Optional<?> optional = cause.after(Integer.class);
        assert !optional.isPresent();
    }

    @Test
    public void testNoneBefore() {
        final Cause cause = Cause.of("foo", 1);
        final Optional<?> optional = cause.before(String.class);
        assert !optional.isPresent();
    }

    @Test
    public void testEmpty() {
        final Cause empty = Cause.of();
        assert empty.isEmpty();
    }

    @Test
    public void testEmptyWithEmpty() {
        final Cause empty = Cause.empty();
        assert empty.with().isEmpty();
    }

    @Test
    public void testNoneOf() {
        final Cause cause = Cause.of("foo", 1, 2, 3);
        assert cause.noneOf(Integer.class).size() == 1 && cause.noneOf(Integer.class).get(0) == "foo";
    }

    @Test
    public void testJustBecauseIcan() {
        final Cause cause = Cause.of();
        final Cause testing = cause.with().with().with().with(new ArrayList<>()).with();
        assert testing.isEmpty();
        assert testing.allOf(String.class).isEmpty();
        assert testing.noneOf(String.class).isEmpty();
    }

    @Test
    public void testNamedCause() {
        final Player player = Mockito.mock(Player.class);
        final NamedCause ownerCause = NamedCause.of(NamedCause.OWNER, player);
        final Cause playerCause = Cause.of(ownerCause);
        Optional<Player> optional = playerCause.first(NamedCause.OWNER);
        assert optional.isPresent();
    }

    @Test
    public void testAbsentNamedCause() {
        final Cause emptyCause = Cause.of();
        final Optional<Object> optional = emptyCause.first(NamedCause.OWNER);
        assert !optional.isPresent();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalNamedCause() {
        final Player player = Mockito.mock(Player.class);
        final Player playerB = Mockito.mock(Player.class);
        final NamedCause namedA = NamedCause.of(NamedCause.OWNER, player);
        final NamedCause namedB = NamedCause.of(NamedCause.OWNER, playerB);
        final Cause cause = Cause.of(namedA, namedB);
        // The line above should throw an exception!
    }

}
