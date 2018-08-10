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
package org.spongepowered.api.command.args;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.spongepowered.api.command.args.GenericArguments.allOf;
import static org.spongepowered.api.command.args.GenericArguments.bool;
import static org.spongepowered.api.command.args.GenericArguments.choices;
import static org.spongepowered.api.command.args.GenericArguments.choicesInsensitive;
import static org.spongepowered.api.command.args.GenericArguments.enumValue;
import static org.spongepowered.api.command.args.GenericArguments.firstParsing;
import static org.spongepowered.api.command.args.GenericArguments.integer;
import static org.spongepowered.api.command.args.GenericArguments.longNum;
import static org.spongepowered.api.command.args.GenericArguments.none;
import static org.spongepowered.api.command.args.GenericArguments.optional;
import static org.spongepowered.api.command.args.GenericArguments.optionalWeak;
import static org.spongepowered.api.command.args.GenericArguments.remainingJoinedStrings;
import static org.spongepowered.api.command.args.GenericArguments.repeated;
import static org.spongepowered.api.command.args.GenericArguments.seq;
import static org.spongepowered.api.command.args.GenericArguments.string;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import org.spongepowered.api.Game;
import org.spongepowered.api.Server;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.parsing.InputTokenizer;
import org.spongepowered.api.command.args.parsing.SingleArg;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.text.TestPlainTextSerializer;
import org.spongepowered.api.text.Text;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Tests for all argument types contained in GenericArguments.
 */
public class GenericArgumentsTest {

    private static final CommandSource MOCK_SOURCE = Mockito.mock(CommandSource.class);
    static final CommandExecutor NULL_EXECUTOR = (src, args) -> CommandResult.empty();

    @Before
    public void initialize() throws Exception {
        TestPlainTextSerializer.inject();
    }

    private static Text untr(String string) {
        return Text.of(string);
    }

    @Rule
    public ExpectedException expected = ExpectedException.none();

    private static CommandContext parseForInput(String input, CommandElement element) throws ArgumentParseException {
        CommandSpec spec = CommandSpec.builder()
                .arguments(element)
                .executor(NULL_EXECUTOR)
                .build();
        final CommandArgs args = new CommandArgs(input, spec.getInputTokenizer().tokenize(input, false));
        final CommandContext context = new CommandContext();
        spec.populateContext(MOCK_SOURCE, args, context);
        return context;
    }

    @Test(expected = CommandException.class)
    public void testNone() throws ArgumentParseException {
        parseForInput("a", none());
    }

    @Test
    public void testSequence() throws ArgumentParseException {
        CommandElement el = seq(string(untr("one")), string(untr("two")), string(untr("three")));
        CommandContext context = parseForInput("a b c", el);
        assertEquals("a", context.getOne("one").get());
        assertEquals("b", context.getOne("two").get());
        assertEquals("c", context.getOne("three").get());

        this.expected.expect(ArgumentParseException.class);
        parseForInput("a b", el);
    }

    @Test
    public void testChoices() throws ArgumentParseException {
        CommandElement el = choices(untr("val"), ImmutableMap.of("a", "one", "b", "two"));
        CommandContext context = parseForInput("a", el);
        assertEquals("one", context.getOne("val").get());

        this.expected.expect(ArgumentParseException.class);
        parseForInput("A", el);
    }

    @Test
    public void testChoicesInsensitive() throws ArgumentParseException {
        CommandElement el = choicesInsensitive(untr("val"), ImmutableMap.of("a", "one", "b", "two"));
        CommandContext context = parseForInput("A", el);
        assertEquals("one", context.getOne("val").get());

        this.expected.expect(ArgumentParseException.class);
        parseForInput("c", el);
    }

    @Test
    public void testFirstParsing() throws ArgumentParseException {
        CommandElement el = firstParsing(integer(untr("val")), string(untr("val")));
        CommandContext context = parseForInput("word", el);
        assertEquals("word", context.getOne("val").get());

        context = parseForInput("42", el);
        assertEquals(42, context.getOne("val").get());
    }

    @Test
    public void testOptional() throws ArgumentParseException {
        CommandElement el = optional(string(untr("val")));
        CommandContext context = parseForInput("", el);
        assertFalse(context.getOne("val").isPresent());

        el = optional(string(untr("val")), "def");
        context = parseForInput("", el);
        assertEquals("def", context.getOne("val").get());

        el = seq(optionalWeak(integer(untr("val"))), string(untr("str")));
        context = parseForInput("hello", el);
        assertEquals("hello", context.getOne("str").get());

        el = seq(optional(integer(untr("val")), string(untr("str"))));
        this.expected.expect(ArgumentParseException.class);
        parseForInput("hello", el);
    }

    @Test
    public void testRepeated() throws ArgumentParseException {
        CommandContext context = parseForInput("1 1 2 3 5", repeated(integer(untr("key")), 5));
        assertEquals(ImmutableList.<Object>of(1, 1, 2, 3, 5), ImmutableList.copyOf(context.getAll("key")));
    }

    @Test
    public void testAllOf() throws ArgumentParseException {
        CommandContext context = parseForInput("2 4 8 16 32 64 128", allOf(integer(untr("key"))));
        assertEquals(ImmutableList.<Object>of(2, 4, 8, 16, 32, 64, 128), ImmutableList.copyOf(context.getAll("key")));
    }

    @Test
    public void testString() throws ArgumentParseException {
        CommandContext context = parseForInput("\"here it is\"", string(untr("a value")));
        assertEquals("here it is", context.getOne("a value").get());
    }

    @Test
    public void testInteger() throws ArgumentParseException {
        CommandElement el = integer(untr("a value"));
        CommandContext context = parseForInput("52", el);
        assertEquals(52, context.getOne("a value").get());

        assertEquals(0xdead, parseForInput("0xdead", el).getOne("a value").get());
        assertEquals(0b101010, parseForInput("0b101010", el).getOne("a value").get());

        this.expected.expect(ArgumentParseException.class);
        parseForInput("notanumber", integer(untr("a value")));
    }

    @Test
    public void testLong() throws ArgumentParseException {
        CommandContext context = parseForInput("524903294023901", longNum(untr("a value")));
        assertEquals(524903294023901L, context.getOne("a value").get());

        this.expected.expect(ArgumentParseException.class);
        parseForInput("notanumber", integer(untr("a value")));
    }

    @Test
    public void testBool() throws ArgumentParseException {
        CommandElement boolEl = bool(untr("val"));
        assertEquals(true, parseForInput("true", boolEl).getOne("val").get());
        assertEquals(true, parseForInput("t", boolEl).getOne("val").get());
        assertEquals(false, parseForInput("f", boolEl).getOne("val").get());

        this.expected.expect(ArgumentParseException.class);
        parseForInput("notabool", boolEl);
    }

    private enum TestEnum {
        ONE, TWO, RED
    }

    @Test
    public void testEnumValue() throws ArgumentParseException {
        CommandElement enumEl = enumValue(untr("val"), TestEnum.class);
        assertEquals(TestEnum.ONE, parseForInput("one", enumEl).getOne("val").get());
        assertEquals(TestEnum.TWO, parseForInput("TwO", enumEl).getOne("val").get());
        assertEquals(TestEnum.RED, parseForInput("RED", enumEl).getOne("val").get());

        this.expected.expect(ArgumentParseException.class);
        parseForInput("notanel", enumEl);
    }

    @Test
    public void testRemainingJoinedStrings() throws ArgumentParseException {
        CommandElement remainingJoined = remainingJoinedStrings(untr("val"));
        assertEquals("one", parseForInput("one", remainingJoined).getOne("val").get());
        assertEquals("one big string", parseForInput("one big string", remainingJoined).getOne("val").get());
    }

    private CommandElement getPlayerElement() throws Exception {
        // Create two fake players
        Player player1 = Mockito.mock(Player.class);
        Mockito.when(player1.getName()).thenReturn("test1");
        Player player2 = Mockito.mock(Player.class);
        Mockito.when(player2.getName()).thenReturn("test2");

        Server mock = Mockito.mock(Server.class);
        Mockito.when(mock.getOnlinePlayers()).thenReturn(Lists.newArrayList(player1, player2));
        Mockito.when(mock.getPlayer(Mockito.anyString())).thenReturn(Optional.empty());
        Mockito.when(mock.getPlayer("test1")).thenReturn(Optional.of(player1));
        Mockito.when(mock.getPlayer("test2")).thenReturn(Optional.of(player2));

        Game gameMock = Mockito.mock(Game.class);
        Mockito.when(gameMock.getServer()).thenReturn(mock);
        Field field = Sponge.class.getDeclaredField("game");
        field.setAccessible(true);
        field.set(null, gameMock);

        // Create element
        return GenericArguments.player(Text.of("player"));
    }

    @Test
    public void testGettingSinglePlayer() throws Exception {
        CommandArgs args = new CommandArgs("test1", Lists.newArrayList(new SingleArg("test1", 0, 5)));
        CommandContext context = new CommandContext();
        CommandSource source = Mockito.mock(CommandSource.class);
        getPlayerElement().parse(source, args, context);
        assertEquals("test1", context.<Player>getOne(Text.of("player")).get().getName());
    }

    @Test
    public void testGettingBothPlayers() throws Exception {
        CommandArgs args = new CommandArgs("test", Lists.newArrayList(new SingleArg("test", 0, 5)));
        CommandContext context = new CommandContext();
        CommandSource source = Mockito.mock(CommandSource.class);
        getPlayerElement().parse(source, args, context);
        Collection<Player> cpl = context.getAll(Text.of("player"));
        assertEquals(2, cpl.size());
        Collection<String> s = cpl.stream().map(User::getName).collect(Collectors.toList());
        assertTrue(s.contains("test1"));
        assertTrue(s.contains("test2"));
    }

    @Test
    public void testFirstParsingWhenFirstSequenceSucceeds() throws ArgumentParseException {
        CommandArgs args = new CommandArgs("test test",
                InputTokenizer.spaceSplitString().tokenize("test test", true));
        CommandContext context = new CommandContext();
        CommandElement sut = GenericArguments.firstParsing(
                GenericArguments.seq(GenericArguments.literal(Text.of("test"), "test"),
                        GenericArguments.literal(Text.of("test1"), "test")),
                GenericArguments.seq(GenericArguments.literal(Text.of("test2"), "test"),
                        GenericArguments.literal(Text.of("test3"), "test"))
        );

        sut.parse(MOCK_SOURCE, args, context);
        assertFalse(context.hasAny("test2"));
        assertFalse(context.hasAny("test3"));
        assertTrue(context.hasAny("test"));
        assertTrue(context.hasAny("test"));
    }

    @Test
    public void testFirstParsingWhenFirstSequenceFails() throws ArgumentParseException {
        CommandArgs args = new CommandArgs("test test",
                InputTokenizer.spaceSplitString().tokenize("test test", true));
        CommandContext context = new CommandContext();
        CommandElement sut = GenericArguments.firstParsing(
                GenericArguments.seq(GenericArguments.literal(Text.of("test"), "test"),
                        GenericArguments.literal(Text.of("test1"), "notatest")),
                GenericArguments.seq(GenericArguments.literal(Text.of("test2"), "test"),
                        GenericArguments.literal(Text.of("test3"), "test"))
        );

        sut.parse(MOCK_SOURCE, args, context);
        assertTrue(context.hasAny("test2"));
        assertTrue(context.hasAny("test3"));
        assertFalse(context.hasAny("test"));
        assertFalse(context.hasAny("test1"));
    }

}
