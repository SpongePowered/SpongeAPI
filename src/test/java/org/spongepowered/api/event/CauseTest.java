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

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.mockito.Mockito;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.NamedCause;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CauseTest {

    @Test
    public void testPopulatedCause() {
        Cause.builder().named("foo", "foo").build();
    }

    @Test(expected = NullPointerException.class)
    public void testNullCause() {
        Cause.builder().named("null", null);
    }

    @Test
    public void testWithCause() {
        final Cause old = Cause.source("foo").build();
        final Cause newCause = old.with(NamedCause.of("derp", "bar"));
        assertThat(old, not(newCause));
        List<?> list = newCause.all();
        assertThat(list.contains("foo"), is(true));
        assertThat(list.contains("bar"), is(true));
    }

    @Test(expected = NullPointerException.class)
    public void testWithNullCause() {
        final Cause old = Cause.source("foo").build();
        old.with(null);
    }

    @Test
    public void testToString() {
        final Cause cause = Cause.builder().named("foo","foo").named("bar","bar").named("numero1", 1).named("duo", 2).build();
        final String causeString = cause.toString();
        assertThat(causeString.isEmpty(), is(false));
    }

    @Test
    public void testBefore() {
        final Cause cause = Cause.builder().named("foo","foo").named("numero1", 1).named("duo", 2).build();
        final Optional<?> optional = cause.before(Integer.class);
        assertThat(optional.isPresent(), is(true));
        assertThat(optional.get(), is("foo"));
    }

    @Test
    public void testAfter() {
        final Cause cause = Cause.builder().named("foo","foo").named("numero1", 1).named("duo", 2).build();
        final Optional<?> optional = cause.after(Integer.class);
        assertThat(optional.isPresent(), is(true));
        assertThat(optional.get(), is(2));
    }

    @Test
    public void testNoneAfter() {
        final Cause cause = Cause.builder().named("foo","foo").named("numero1", 1).build();
        final Optional<?> optional = cause.after(Integer.class);
        assertThat(optional.isPresent(), is(false));
    }

    @Test
    public void testNoneBefore() {
        final Cause cause = Cause.builder().named("foo","foo").named("numero1", 1).build();
        final Optional<?> optional = cause.before(String.class);
        assertThat(optional.isPresent(), is(false));
    }

    @Test
    public void testNoneOf() {
        final Cause cause = Cause.builder().named("foo","foo").named("numero1", 1).named("duo", 2).named("trio", 3).build();
        assertThat(cause.noneOf(Integer.class), hasSize(1));
        assertThat(cause.noneOf(Integer.class).get(0), is("foo"));
    }

    @Test
    public void testNamedCause() {
        final Player player = Mockito.mock(Player.class);
        final NamedCause ownerCause = NamedCause.of(NamedCause.OWNER, player);
        final Cause playerCause = Cause.builder().named(ownerCause).build();
        Optional<Player> optional = playerCause.get(NamedCause.OWNER, Player.class);
        assertThat(optional.isPresent(), is(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalNamedCause() {
        final Player player = Mockito.mock(Player.class);
        final Player playerB = Mockito.mock(Player.class);
        final NamedCause namedA = NamedCause.of(NamedCause.OWNER, player);
        final NamedCause namedB = NamedCause.of(NamedCause.OWNER, playerB);
        Cause.of(namedA, namedB);
        // The line above should throw an exception!
    }

    @Test
    public void testNamedCauseMap() {
        final Player player = Mockito.mock(Player.class);
        final NamedCause owner = NamedCause.of(NamedCause.OWNER, player);
        final Living entity = Mockito.mock(Living.class);
        final NamedCause living = NamedCause.of("summoned", entity);
        final Cause cause = Cause.of(living, owner);
        final Map<String, Object> map = cause.getNamedCauses();
        assertThat(map.containsKey(NamedCause.OWNER), is(true));
        assertThat(map.containsKey("summoned"), is(true));
        int index = 0;
        final List<Object> all = cause.all();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            assertThat(all.get(index), equalTo(entry.getValue()));
            index++;
        }
    }

    @Test
    public void testNamedBefore() {
        final Player player = Mockito.mock(Player.class);
        final NamedCause owner = NamedCause.of(NamedCause.OWNER, player);
        final Living entity = Mockito.mock(Living.class);
        final NamedCause living = NamedCause.of("summoned", entity);
        final Cause cause = Cause.of(living, owner);
        final Optional<?> optional = cause.before(NamedCause.OWNER);
        assertThat(optional.isPresent(), is(true));
    }

    @Test
    public void testNoNamedBefore() {
        final Player player = Mockito.mock(Player.class);
        final NamedCause owner = NamedCause.of(NamedCause.OWNER, player);
        final Cause cause = Cause.of(owner);
        final Optional<?> optional = cause.before(NamedCause.OWNER);
        assertThat(optional.isPresent(), is(false));
    }

    @Test
    public void testNamedAfter() {
        final Player player = Mockito.mock(Player.class);
        final NamedCause owner = NamedCause.of(NamedCause.OWNER, player);
        final Living entity = Mockito.mock(Living.class);
        final NamedCause living = NamedCause.of("summoned", entity);
        final Cause cause = Cause.of(living, owner);
        final Optional<?> optional = cause.after("summoned");
        assertThat(optional.isPresent(), is(true));
    }

    @Test
    public void testNoNamedAfter() {
        final Player player = Mockito.mock(Player.class);
        final NamedCause owner = NamedCause.of(NamedCause.OWNER, player);
        final Cause cause = Cause.of(owner);
        final Optional<?> optional = cause.after(NamedCause.OWNER);
        assertThat(optional.isPresent(), is(false));
    }

    @Test
    public void testNamedWith() {
        final Cause cause = Cause.of(NamedCause.of("Test Block", Mockito.mock(BlockSnapshot.class)));
        User user = Mockito.mock(User.class);
        User owner = Mockito.mock(User.class);
        final Cause enhanced = cause.with(NamedCause.of(NamedCause.NOTIFIER, user)).with(NamedCause.of(NamedCause.OWNER, owner));

        final Optional<User> optional = enhanced.first(User.class);
        assertThat(optional.isPresent(), is(true));
        List<Object> allCauses = enhanced.all();
        assertThat(allCauses, hasSize(3));
    }

    @Test
    public void testListedArray() {
        final List<String> fooList = ImmutableList.of("foo", "bar", "baz", "floof");
        final Cause cause = Cause.builder()
                .suggestNamed("foo", "foo")
                .suggestNamed("bar", "bar")
                .suggestNamed("baz", "baz")
                .suggestNamed("floof", "floof")
                .build();
        final List<String> stringList = cause.allOf(String.class);
        assertThat(stringList.isEmpty(), is(false));
        assertThat(stringList.equals(fooList), is(true));
    }


}
