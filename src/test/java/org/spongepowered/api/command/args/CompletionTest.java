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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.hamcrest.CoreMatchers;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.parsing.InputTokenizer;
import org.spongepowered.api.command.args.parsing.SingleArg;
import org.spongepowered.api.text.TestPlainTextSerializer;
import org.spongepowered.api.text.Text;

import java.util.List;
import java.util.stream.Collectors;

/*
 * Tests tab completion in commands when optionals are involved
 */
@RunWith(Parameterized.class)
public class CompletionTest {

    private static final CommandElement first = GenericArguments.optionalWeak(
            GenericArguments.choices(
                    Text.of("first"), ImmutableMap.of("arg", "arg", "arg1", "arg1", "test1", "test1")));

    private static final CommandElement firstNotOptional =
            GenericArguments.choices(
                    Text.of("first"), ImmutableMap.of("arg", "arg", "arg1", "arg1", "test1", "test1"));
    private static final CommandElement flag = GenericArguments.flags().valueFlag(first, "-flag").buildWith(GenericArguments.none());
    private static final CommandElement second = GenericArguments.optionalWeak(
            GenericArguments.choices(
                    Text.of("second"), ImmutableMap.of("arg", "arg", "arg2", "arg2", "test2", "test2")));
    private static final CommandElement secondNotOptional =
            GenericArguments.choices(Text.of("third"), ImmutableMap.of("arg3", "arg3", "arg4", "arg4"));
    private static final CommandElement integer = GenericArguments.integer(Text.of("int"));

    private static final CommandElement secondFlag = GenericArguments.flags().valueFlag(firstNotOptional, "-flag").buildWith(second);
    private static final CommandElement secondFlagNotOptional = GenericArguments.flags().valueFlag(firstNotOptional, "-flag").buildWith(secondNotOptional);
    private static final CommandElement secondFlagInt = GenericArguments.flags().valueFlag(firstNotOptional, "-flag").buildWith(integer);
    private static final CommandElement secondFlagWithInt = GenericArguments.flags().valueFlag(integer, "-flag").buildWith(secondNotOptional);

    private static final CommandElement third = GenericArguments.optionalWeak(
            GenericArguments.choices(Text.of("third"), ImmutableMap.of("arg3", "arg3", "arg4", "arg4")));
    private static final CommandElement thirdNotOptional =
            GenericArguments.choices(Text.of("third"), ImmutableMap.of("arg3", "arg3", "arg4", "arg4"));
    private static final CommandElement sflag2 = GenericArguments.flags().valueFlag(secondNotOptional, "f").buildWith(GenericArguments.none());
    private static final CommandElement element1 = GenericArguments.seq(first, second, third);
    private static final CommandElement element2 = GenericArguments.seq(first, second, thirdNotOptional);
    private static final CommandElement element3 = GenericArguments.seq(first, secondNotOptional, thirdNotOptional);

    private static final CommandElement tr = GenericArguments.optionalWeak(GenericArguments.markTrue(Text.of("true")));
    private static final CommandElement element4 = GenericArguments.seq(tr, first, second);

    @Parameterized.Parameters(name = "{index}: {0} - {1}")
    public static List<Object[]> getTests() {
        ImmutableList.Builder<Object[]> tests = ImmutableList.builder();
        tests.add(new Object[] { "", Lists.newArrayList("arg", "arg1", "test1", "arg2", "test2", "arg3", "arg4"), element1 });
        tests.add(new Object[] { "a", Lists.newArrayList("arg", "arg1", "arg2", "arg3", "arg4"), element1 });
        tests.add(new Object[] { "arg a", Lists.newArrayList("arg", "arg2", "arg3", "arg4"), element1 });
        tests.add(new Object[] { "arg a", Lists.newArrayList("arg3", "arg4"), element3 });
        tests.add(new Object[] { "arg", Lists.newArrayList("arg", "arg1", "arg2", "arg3", "arg4"), element1 });
        tests.add(new Object[] { "arg1", Lists.newArrayList("arg1"), element1 });
        tests.add(new Object[] { "arg1 arg", Lists.newArrayList("arg", "arg2", "arg3", "arg4"), element1});
        tests.add(new Object[] { "arg", Lists.newArrayList("arg", "arg1", "arg2", "arg3", "arg4"), element2});
        tests.add(new Object[] { "arg1", Lists.newArrayList("arg1"), element2});
        tests.add(new Object[] { "arg1", Lists.newArrayList("arg1"), element3});
        tests.add(new Object[] { "arg1 arg", Lists.newArrayList("arg3", "arg4"), element3});
        tests.add(new Object[] { "arg1", Lists.newArrayList("arg1"), element4});
        tests.add(new Object[] { "t", Lists.newArrayList("test1", "test2"), element4});
        tests.add(new Object[] { "--f", Lists.newArrayList("--flag"), flag}); // got an optional value
        tests.add(new Object[] { "-f a", Lists.newArrayList("arg3", "arg4"), sflag2}); // not got an optional value
        tests.add(new Object[] { "-f arg", Lists.newArrayList("arg3", "arg4"), sflag2}); // not got an optional value
        tests.add(new Object[] { "-f arg4", Lists.newArrayList("arg4"), sflag2}); // not got an optional value
        tests.add(new Object[] { "--flag a", Lists.newArrayList("arg", "arg1"), secondFlagNotOptional});
        tests.add(new Object[] { "--flag a", Lists.newArrayList("arg", "arg1"), secondFlagInt});
        tests.add(new Object[] { "--flag=a", Lists.newArrayList("--flag=arg", "--flag=arg1"), secondFlagNotOptional});
        tests.add(new Object[] { "--flag=a", Lists.newArrayList("--flag=arg", "--flag=arg1"), secondFlag});
        tests.add(new Object[] { "--flag=a", Lists.newArrayList("--flag=arg", "--flag=arg1"), secondFlagInt});
        tests.add(new Object[] { "--flag=a", Lists.newArrayList(), secondFlagWithInt});
        tests.add(new Object[] { "--flag=b", Lists.newArrayList(), secondFlag});
        tests.add(new Object[] { "--flag a", Lists.newArrayList("arg3", "arg4"), secondFlagWithInt}); // the flag has no completable value,
                                                                                                                 // best we can do.
        return tests.build();
    }

    @Parameterized.Parameter
    public String input;

    @Parameterized.Parameter(1)
    public List<String> output;

    @Parameterized.Parameter(2)
    public CommandElement element;

    @Before
    public void initialize() throws Exception {
        TestPlainTextSerializer.inject();
    }

    @Test
    public void testTabCompletion() throws ArgumentParseException {
        List<SingleArg> args = InputTokenizer.quotedStrings(false).tokenize(this.input, true);
        CommandArgs commandArgs = new CommandArgs(this.input, args);
        List<String> results = this.element.complete(Mockito.mock(CommandSource.class), commandArgs, new CommandContext());

        Assert.assertThat("Expected [" + String.join(", ", this.output) + "] but got ["
                + String.join(", ", results) + "] from arg string \""
                        + args.stream().map(SingleArg::getValue).collect(Collectors.joining(" ")) + "\"",
                results,
                IsIterableContainingInAnyOrder.containsInAnyOrder(this.output.stream().map(CoreMatchers::equalTo).collect(Collectors.toList())));
    }

}
