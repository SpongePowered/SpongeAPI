package org.spongepowered.api.command.args.parsing;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.spongepowered.api.command.args.ArgumentParseException;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class SpaceSplitInputTokenizerTest {

    private static List<String> parseFrom(String args) throws ArgumentParseException {
        return InputTokenizer.spaceSplitString().tokenize(args, false).stream().map(SingleArg::getValue).collect(Collectors.toList());
    }

    @Test
    public void testEmptyString() throws ArgumentParseException {
        assertEquals(ImmutableList.of(), parseFrom(""));
    }

    @Test
    public void testSpaceString() throws ArgumentParseException {
        assertEquals(ImmutableList.of(""), parseFrom(" "));
    }

    @Test
    public void testStandardString() throws ArgumentParseException {
        assertEquals(ImmutableList.of("arg1", "arg2", "arg3"), parseFrom("arg1 arg2 arg3"));
    }

    @Test
    public void testDoubleSpacedString() throws ArgumentParseException {
        assertEquals(ImmutableList.of("arg1", "arg2", "arg3"), parseFrom("arg1 arg2  arg3"));
    }

    @Test
    public void testTrailingSpaceString() throws ArgumentParseException {
        assertEquals(ImmutableList.of("arg1", "arg2", "arg3", ""), parseFrom("arg1 arg2 arg3 "));
    }
}
