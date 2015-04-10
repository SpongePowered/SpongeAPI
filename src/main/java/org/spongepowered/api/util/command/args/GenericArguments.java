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
package org.spongepowered.api.util.command.args;

import static org.spongepowered.api.util.command.args.TranslationPlaceholder.t;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextBuilder;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.StartsWithPredicate;
import org.spongepowered.api.util.command.CommandContext;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.dispatcher.CommandMessageFormatting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;


/**
 * Class containing factory methods for common command elements.
 */
public class GenericArguments {

    private GenericArguments() {}

    /**
     * Expects no arguments.
     *
     * @return An expectation of no arguments
     */
    public static CommandElement none() {
        return new SequenceCommandElement(ImmutableList.<CommandElement>of());
    }

    private static CommandElement markTrue(String flag) {
        return new MarkTrueCommandElement(flag);
    }

    private static class MarkTrueCommandElement extends CommandElement {
        public MarkTrueCommandElement(String flag) {
            super(Texts.of(flag));
        }

        @Override
        protected Object parseValue(CommandArgs args) throws ArgumentParseException {
            return true;
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            return Collections.emptyList();
        }
    }

    /**
     * Get a builder to create a command element that parses flags.
     *
     * @return the newly created builder
     */
    public static FlagCommandElementBuilder flags() {
        return new FlagCommandElementBuilder();
    }

    public static class FlagCommandElementBuilder {
        private final Map<List<String>, CommandElement> usageFlags = new HashMap<List<String>, CommandElement>();
        private final Map<String, CommandElement> shortFlags = new HashMap<String, CommandElement>();
        private final Map<String, CommandElement> longFlags = new HashMap<String, CommandElement>();
        private boolean acceptsArbitraryLongFlags = true;
        private boolean anchorFlags = false;

        /**
         * Allow a flag with any of the provided specifications that has no value.
         * This flag will be exposed in a {@link CommandContext} under the key equivalent to the first flag in the specification array.
         * The specifications are handled as so for each element in the {@code specs} array:
         * <ul>
         *     <li>If the element starts with -, the remainder of the element is interpreted as a long flag</li>
         *     <li>Otherwise, each code point of the element is interpreted as a short flag</li>
         * </ul>
         *
         * @param specs The flag specifications
         * @return this
         */
        public FlagCommandElementBuilder flag(String... specs) {
            final List<String> availableFlags = new ArrayList<String>(specs.length);
            CommandElement el = null;
            for (String spec : specs) {
                if (spec.startsWith("-")) {
                    final String flagKey = spec.substring(1);
                    if (el == null) {
                        el = markTrue(flagKey);
                    }
                    availableFlags.add(flagKey);
                    this.longFlags.put(flagKey.toLowerCase(), el);
                } else {
                    for (int i = 0; i < spec.length(); ++i) {
                        final String flagKey = spec.substring(i, i + 1);
                        if (el == null) {
                            el = markTrue(flagKey);
                        }
                        availableFlags.add(flagKey);
                        this.shortFlags.put(flagKey, el);
                    }
                }
            }
            this.usageFlags.put(availableFlags, el);
            return this;
        }

        /**
         * Allow a flag with any of the provided specifications, with the given command element. The flag may be present multiple times, and may
         * therefore have multiple values.
         *
         * @see #flag(String...) for information on how the flag specifications are parsed
         * @param value The command element used to parse any occurrences
         * @param specs The flag specifications
         * @return this
         */
        public FlagCommandElementBuilder valueFlag(CommandElement value, String... specs) {
            final List<String> availableFlags = new ArrayList<String>(specs.length);
            String valueStore = null;
            for (String spec : specs) {
                if (spec.startsWith("-")) {
                    availableFlags.add(spec);
                    final String flagKey = spec.substring(1);
                    if (valueStore == null) {
                        valueStore = flagKey;
                    }
                    this.longFlags.put(flagKey.toLowerCase(), value);
                } else {
                    for (int i = 0; i < spec.length(); ++i) {
                        final String flagKey = spec.substring(i, i + 1);
                        if (valueStore == null) {
                            valueStore = flagKey;
                        }
                        availableFlags.add(flagKey);
                        this.shortFlags.put(flagKey, value);
                    }
                }
            }
            this.usageFlags.put(availableFlags, markTrue(valueStore));
            return this;
        }

        /**
         * If this is true, any long flag (--) will be accepted and added as a flag.
         *
         * @param acceptsArbitraryLongFlags Whether any long flag is accepted
         * @return this
         */
        public FlagCommandElementBuilder setAcceptsArbitraryLongFlags(boolean acceptsArbitraryLongFlags) {
            this.acceptsArbitraryLongFlags = acceptsArbitraryLongFlags;
            return this;
        }

        /**
         * Whether flags should be anchored to the beginning of the text (so flags will
         * only be picked up if they are at the beginning of the input).
         *
         * @param anchorFlags Whether flags are anchored
         * @return this
         */
        public FlagCommandElementBuilder setAnchorFlags(boolean anchorFlags) {
            this.anchorFlags = anchorFlags;
            return this;
        }

        /**
         * Build a flag command element using the given command element to handle all non-flag arguments.
         *
         * @param wrapped The wrapped command element
         * @return the new command element
         */
        public CommandElement buildWith(CommandElement wrapped) {
            return new FlagCommandElement(wrapped, this.usageFlags, this.shortFlags, this.longFlags, this.acceptsArbitraryLongFlags, this
                    .anchorFlags);
        }
    }

    private static class FlagCommandElement extends CommandElement {
        private final CommandElement childElement;
        private final Map<List<String>, CommandElement> usageFlags;
        private final Map<String, CommandElement> shortFlags;
        private final Map<String, CommandElement> longFlags;
        private final boolean acceptArbitraryLongFlags;
        private final boolean anchorFlags;

        protected FlagCommandElement(CommandElement childElement, Map<List<String>, CommandElement> usageFlags,
                Map<String, CommandElement> shortFlags, Map<String, CommandElement> longFlags, boolean acceptArbitraryLongFlags,
                boolean anchorFlags) {
            super(null);
            this.childElement = childElement;
            this.usageFlags = usageFlags;
            this.shortFlags = shortFlags;
            this.longFlags = longFlags;
            this.acceptArbitraryLongFlags = acceptArbitraryLongFlags;
            this.anchorFlags = anchorFlags;
        }

        @Override
        public void parse(CommandArgs args, CommandContext context) throws ArgumentParseException {
            Object startIdx = args.getState();
            String arg;
            while (args.hasNext()) {
                arg = args.next();
                if (arg.startsWith("-")) {
                    Object flagStartIdx = args.getState();
                    if (arg.startsWith("--")) { // Long flag
                        String longFlag = arg.substring(2);
                        parseLongFlag(longFlag, args, context);
                    } else {
                        arg = arg.substring(1);
                        parseShortFlags(arg, args, context);
                    }
                    args.removeArgs(flagStartIdx, args.getState());
                } else if (this.anchorFlags) {
                    break;
                }
            }

            args.setState(startIdx);
            if (this.childElement != null) {
                this.childElement.parse(args, context);
            }

        }

        private void parseLongFlag(String longFlag, CommandArgs args, CommandContext context) throws ArgumentParseException {
            if (longFlag.contains("=")) {
                final String[] flagSplit = longFlag.split("=", 2);
                longFlag = flagSplit[0];
                String value = flagSplit[1];
                CommandElement element = this.longFlags.get(longFlag.toLowerCase());
                if (element == null) {
                    if (!this.acceptArbitraryLongFlags) {
                        throw args.createError(t("Unknown long flag %s specified", args));
                    }
                    context.putArg(longFlag, value);
                } else {
                    args.insertArg(value);
                    element.parse(args, context);
                }
            } else {
                CommandElement element = this.longFlags.get(longFlag.toLowerCase());
                if (element == null) {
                    if (!this.acceptArbitraryLongFlags) {
                        throw args.createError(t("Unknown long flag %s specified", args));
                    }
                    context.putArg(longFlag, true);
                } else {
                    element.parse(args, context);
                }
            }
        }

        private void parseShortFlags(String shortFlags, CommandArgs args, CommandContext context) throws ArgumentParseException {
            for (int i = 0; i < shortFlags.length(); ++i) {
                final String flagChar = shortFlags.substring(i, i + 1);
                CommandElement element = this.shortFlags.get(flagChar);
                if (element == null) {
                    throw args.createError(t("Unknown short flag %s specified", flagChar));
                }
                element.parse(args, context);
            }
        }

        @Override
        public Text getUsage(CommandSource src) {
            final List<Object> builder = new ArrayList<Object>();
            for (Map.Entry<List<String>, CommandElement> arg : this.usageFlags.entrySet()) {
                builder.add("[");
                for (Iterator<String> it = arg.getKey().iterator(); it.hasNext();) {
                    builder.add("-");
                    builder.add(it.next());
                    if (it.hasNext()) {
                        builder.add("|");
                    }
                }
                if (!(arg.getValue() instanceof MarkTrueCommandElement)) { // true flag
                    builder.add(" ");
                    builder.add(arg.getValue().getUsage(src));
                }
                builder.add("]");
                builder.add(" ");
            }

            if (this.childElement != null) {
                builder.add(this.childElement.getUsage(src));
            }
            return Texts.of(builder.toArray());
        }

        @Override
        protected Object parseValue(CommandArgs args) throws ArgumentParseException {
            return null;
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            Object startIdx = args.getState();
            Optional<String> arg;
            while (args.hasNext()) {
                arg = args.nextIfPresent();
                if (arg.get().startsWith("-")) {
                    Object flagStartIdx = args.getState();
                    if (arg.get().startsWith("--")) { // Long flag
                        String longFlag = arg.get().substring(2);
                        List<String> ret = tabCompleteLongFlag(longFlag, src, args, context);
                        if (ret != null) {
                            return ret;
                        }
                    } else {
                        final String argStr = arg.get().substring(1);
                        List<String> ret = tabCompleteShortFlags(argStr, src, args, context);
                        if (ret != null) {
                            return ret;
                        }
                    }
                    args.removeArgs(flagStartIdx, args.getState());
                } else if (this.anchorFlags) {
                    break;
                }
            }

            args.setState(startIdx);
            if (this.childElement != null) {
                return this.childElement.complete(src, args, context);
            } else {
                return Collections.emptyList();
            }
        }

        private List<String> tabCompleteLongFlag(String longFlag, CommandSource src, CommandArgs args, CommandContext context) {
            if (longFlag.contains("=")) {
                final String[] flagSplit = longFlag.split("=", 2);
                longFlag = flagSplit[0];
                String value = flagSplit[1];
                CommandElement element = this.longFlags.get(longFlag.toLowerCase());
                if (element == null) { // Whole flag is specified, we'll go to value
                    context.putArg(longFlag, value);
                } else {
                    args.insertArg(value);
                    final String finalLongFlag = longFlag;
                    Object position = args.getState();
                    try {
                        element.parse(args, context);
                    } catch (ArgumentParseException ex) {
                        args.setState(position);
                        return ImmutableList.copyOf(Iterables.transform(element.complete(src, args, context), new Function<String, String>() {
                            @Nullable
                            @Override
                            public String apply(@Nullable String input) {
                                return "--" + finalLongFlag + "=" + input;
                            }
                        }));
                    }
                }
            } else {
                CommandElement element = this.longFlags.get(longFlag.toLowerCase());
                if (element == null) {
                    return ImmutableList.copyOf(Iterables.transform(Iterables.filter(this.longFlags.keySet(), new StartsWithPredicate(longFlag
                            .toLowerCase())), new Function<String, String>() {
                                @Nullable
                                @Override
                                public String apply(@Nullable String input) {
                                    return "--" + input;
                                }
                            }));
                } else {
                    boolean complete = false;
                    Object state = args.getState();
                    try {
                        element.parse(args, context);
                    } catch (ArgumentParseException ex) {
                        complete = true;
                    }
                    if (!args.hasNext()) {
                        complete = true;
                    }
                    if (complete) {
                        args.setState(state);
                        return element.complete(src, args, context);
                    }
                }
            }
            return null;
        }

        private  List<String> tabCompleteShortFlags(String shortFlags, CommandSource src, CommandArgs args, CommandContext context) {
            for (int i = 0; i < shortFlags.length(); ++i) {
                final String flagChar = shortFlags.substring(i, i + 1);
                CommandElement element = this.shortFlags.get(flagChar);
                if (element == null) {
                    continue;
                }
                Object start = args.getState();
                try {
                    element.parse(args, context);
                } catch (ArgumentParseException ex) {
                    args.setState(start);
                    return element.complete(src, args, context);
                }
            }
            return null;
        }
    }

    /**
     * Consumes a series of arguments. Usage is the elements concated
     *
     * @param elements The series of arguments to expect
     * @return the element to match the input
     */
    public static CommandElement seq(CommandElement... elements) {
        return new SequenceCommandElement(ImmutableList.copyOf(elements));
    }

    private static class SequenceCommandElement extends CommandElement {
        private final List<CommandElement> elements;

        private SequenceCommandElement(List<CommandElement> elements) {
            super(null);
            this.elements = elements;
        }

        @Override
        public void parse(CommandArgs args, CommandContext context) throws ArgumentParseException {
            for (CommandElement element : this.elements) {
                element.parse(args, context);
            }
        }

        @Override
        protected Object parseValue(CommandArgs args) throws ArgumentParseException {
            return null;
        }

        @Override
        public  List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            for (Iterator<CommandElement> it = this.elements.iterator(); it.hasNext(); ) {
                CommandElement element = it.next();
                Object startState = args.getState();
                try {
                    element.parse(args, context);
                    Object endState = args.getState();
                    if (!args.hasNext()) {
                        args.setState(startState);
                        List<String> inputs = element.complete(src, args, context);
                        args.previous();
                        if (!inputs.contains(args.next())) { // Tabcomplete returns results to complete the last word in an argument.
                            // If the last word is one of the completions, the command is most likely complete
                            return inputs;
                        }

                        args.setState(endState);
                    }
                } catch (ArgumentParseException e) {
                    args.setState(startState);
                    return element.complete(src, args, context);
                }

                if (!it.hasNext()) {
                    args.setState(startState);
                }
            }
            return Collections.emptyList();
        }

        @Override
        public  Text getUsage(CommandSource commander) {
            final TextBuilder build = Texts.builder();
            for (Iterator<CommandElement> it = this.elements.iterator(); it.hasNext();) {
                build.append(it.next().getUsage(commander));
                if (it.hasNext()) {
                    build.append(CommandMessageFormatting.SPACE_TEXT);
                }
            }
            return build.build();
        }
    }

    /**
     * Return an argument that allows selecting from a limited set of values.
     * If there are 5 or fewer choices available, the choices will be shown in the command usage. Otherwise, the usage
     * will only display only the key. To override this behavior, see {@link #choices(Text, Map, boolean)}.
     *
     * @param key The key to store the resulting value under
     * @param choices The choices users can choose from
     * @return the element to match the input
     */
    public static CommandElement choices(Text key, Map<String, ?> choices) {
        return choices(key, choices, choices.size() <= 5);
    }

    /**
     * Return an argument that allows selecting from a limited set of values.
     * Unless {@code choicesInUsage} is true, general command usage will only display the provided key
     *
     * @param key The key to store the resulting value under
     * @param choices The choices users can choose from
     * @param choicesInUsage Whether to display the available choices, or simply the provided key, as part of usage
     * @return the element to match the input
     */
    public static CommandElement choices(Text key, Map<String, ?> choices, boolean choicesInUsage) {
        return new ChoicesCommandElement(key, ImmutableMap.copyOf(choices), choicesInUsage);
    }

    private static class ChoicesCommandElement extends CommandElement {
        private final Map<String, Object> choices;
        private final boolean choicesInUsage;

        private ChoicesCommandElement(Text key, Map<String, Object> choices, boolean choicesInUsage) {
            super(key);
            this.choices = choices;
            this.choicesInUsage = choicesInUsage;
        }

        @Override
        public Object parseValue(CommandArgs args) throws ArgumentParseException {
            Object value = this.choices.get(args.next());
            if (value == null) {
                throw args.createError(t("Argument was not a valid choice. Valid choices: %s", this.choices.keySet().toString()));
            }
            return value;
        }

        @Override
        public  List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            final String prefix = args.nextIfPresent().or("");
            return ImmutableList.copyOf(Iterables.filter(this.choices.keySet(), new StartsWithPredicate(prefix)));
        }

        @Override
        public Text getUsage(CommandSource commander) {
            if (this.choicesInUsage) {
                final TextBuilder build = Texts.builder();
                for (Iterator<String> it = this.choices.keySet().iterator(); it.hasNext();) {
                    build.append(Texts.of(it.next()));
                    if (it.hasNext()) {
                        build.append(CommandMessageFormatting.PIPE_TEXT);
                    }
                }
                return build.build();
            } else {
                return super.getUsage(commander);
            }
        }
    }


    /**
     * Returns a command element that matches the first of the provided elements that parses.
     * Tab completion matches from all options
     *
     * @param elements The elements to check against
     * @return The command element matching the first passing of the elements provided
     */
    public static CommandElement firstParsing(CommandElement... elements) {
        return new FirstParsingCommandElement(ImmutableList.copyOf(elements));
    }

    private static class FirstParsingCommandElement extends CommandElement {
        private final List<CommandElement> elements;

        private FirstParsingCommandElement(List<CommandElement> elements) {
            super(null);
            this.elements = elements;
        }

        @Override
        public void parse(CommandArgs args, CommandContext context) throws ArgumentParseException {
            ArgumentParseException firstException = null;
            for (CommandElement element : this.elements) {
                Object startState = args.getState();
                try {
                    element.parse(args, context);
                    return;
                } catch (ArgumentParseException ex) {
                    if (firstException == null) {
                        firstException = ex;
                    }
                    args.setState(startState);
                }
            }
            if (firstException != null) {
                throw firstException;
            }
        }

        @Override
        protected Object parseValue(CommandArgs args) throws ArgumentParseException {
            return null;
        }

        @Override
        public  List<String> complete(final CommandSource src, final CommandArgs args, final CommandContext context) {
            return ImmutableList.copyOf(Iterables.concat(Iterables.transform(this.elements, new Function<CommandElement, Iterable<String>>() {
                @Nullable
                @Override
                public Iterable<String> apply(CommandElement input) {
                    Object startState = args.getState();
                    List<String> ret = input.complete(src, args, context);
                    args.setState(startState);
                    return ret;
                }
            })));
        }

        @Override
        public  Text getUsage(CommandSource commander) {
            final TextBuilder ret = Texts.builder();
            for (Iterator<CommandElement> it = this.elements.iterator(); it.hasNext();) {
                ret.append(it.next().getUsage(commander));
                if (it.hasNext()) {
                    ret.append(CommandMessageFormatting.PIPE_TEXT);
                }
            }
            return ret.build();
        }
    }

    /**
     * Make the provided command element optional
     * This means the command element is not required. However, if the element is provided with invalid format and there
     * are no more args specified, any errors will still be passed on.
     *
     * @param element The element to optionally require
     * @return the element to match the input
     */
    public static CommandElement optional(CommandElement element) {
        return new OptionalCommandElement(element, null, false);
    }

    /**
     * Make the provided command element optional
     * This means the command element is not required. However, if the element is provided with invalid format and there
     * are no more args specified, any errors will still be passed on. If the given element's key and {@code value} are not
     * null and this element is not provided the element's key will be set to the given value.
     *
     * @param element The element to optionally require
     * @param value The default value to set
     * @return the element to match the input
     */
    public static CommandElement optional(CommandElement element, Object value) {
        return new OptionalCommandElement(element, value, false);
    }

    /**
     * Make the provided command element optional
     * This means the command element is not required.
     * If the argument is provided but of invalid format, it will be skipped.
     *
     * @param element The element to optionally require
     * @return the element to match the input
     */
    public static CommandElement optionalWeak(CommandElement element) {
        return new OptionalCommandElement(element, null, true);
    }

    /**
     * Make the provided command element optional
     * This means the command element is not required.
     * If the argument is provided but of invalid format, it will be skipped.
     * If the given element's key and {@code value} are not null and this element is not provided the element's key will
     * be set to the given value.
     *
     * @param element The element to optionally require
     * @param value The default value to set
     * @return the element to match the input
     */
    public static CommandElement optionalWeak(CommandElement element, Object value) {
        return new OptionalCommandElement(element, value, true);
    }

    private static class OptionalCommandElement extends CommandElement {
        private final CommandElement element;
        private final Object value;
        private final boolean considerInvalidFormatEmpty;

        private OptionalCommandElement(CommandElement element, Object value, boolean considerInvalidFormatEmpty) {
            super(null);
            this.element = element;
            this.value = value;
            this.considerInvalidFormatEmpty = considerInvalidFormatEmpty;
        }

        @Override
        public void parse(CommandArgs args, CommandContext context) throws ArgumentParseException {
            if (!args.hasNext()) {
                if (this.element.getKey() != null && this.value != null) {
                    context.putArg(Texts.toPlain(this.element.getKey()), this.value);
                }
                return;
            }
            Object startState = args.getState();
            try {
                this.element.parse(args, context);
            } catch (ArgumentParseException ex) {
                if (this.considerInvalidFormatEmpty || args.hasNext()) { // If there are more args, suppress. Otherwise, throw the error
                    args.setState(startState);
                    if (this.element.getKey() != null && this.value != null) {
                        context.putArg(Texts.toPlain(this.element.getKey()), this.value);
                    }
                } else {
                    throw ex;
                }
            }
        }

        @Override
        protected Object parseValue(CommandArgs args) throws ArgumentParseException {
            return args.hasNext() ? null : this.element.parseValue(args);
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            return this.element.complete(src, args, context);
        }

        @Override
        public Text getUsage(CommandSource src) {
            return Texts.of("[", this.element.getUsage(src), "]");
        }
    }

    /**
     * Require a given command element to be provided a certain number of times
     * Command values will be stored under their provided keys in the CommandContext
     *
     * @param element The element to repeat
     * @param times The number of times to repeat the element.
     * @return the element to match the input
     */
    public static CommandElement repeated(CommandElement element, int times) {
        return new RepeatedCommandElement(element, times);
    }

    private static class RepeatedCommandElement extends CommandElement {
        private final CommandElement element;
        private final int times;


        protected RepeatedCommandElement(CommandElement element, int times) {
            super(null);
            this.element = element;
            this.times = times;
        }

        @Override
        public void parse(CommandArgs args, CommandContext context) throws ArgumentParseException {
            for (int i = 0; i < this.times; ++i) {
                this.element.parse(args, context);
            }
        }

        @Override
        protected Object parseValue(CommandArgs args) throws ArgumentParseException {
            return null;
        }

        @Override
        public  List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            for (int i = 0; i < this.times; ++i) {
                Object startState = args.getState();
                try {
                    this.element.parse(args, context);
                } catch (ArgumentParseException e) {
                    args.setState(startState);
                    return this.element.complete(src, args, context);
                }
            }
            return Collections.emptyList();
        }

        @Override
        public  Text getUsage(CommandSource src) {
            return Texts.of(this.times, '*', this.element.getUsage(src));
        }
    }

    /**
     * Require all remaining args to match as many instances of CommandElement as will fit
     * Command element values will be stored under their provided keys in the CommandContext.
     *
     * @param element The element to repeat
     * @return the element to match the input
     */
    public static CommandElement allOf(CommandElement element) {
        return new AllOfCommandElement(element);
    }

    private static class AllOfCommandElement extends CommandElement {
        private final CommandElement element;


        protected AllOfCommandElement(CommandElement element) {
            super(null);
            this.element = element;
        }

        @Override
        public void parse(CommandArgs args, CommandContext context) throws ArgumentParseException {
            while (args.hasNext()) {
                this.element.parse(args, context);
            }
        }

        @Override
        protected Object parseValue(CommandArgs args) throws ArgumentParseException {
            return null;
        }

        @Override
        public  List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            while (args.hasNext()) {
                Object startState = args.getState();
                try {
                    this.element.parse(args, context);
                } catch (ArgumentParseException e) {
                    args.setState(startState);
                    return this.element.complete(src, args, context);
                }
            }
            return Collections.emptyList();
        }

        @Override
        public Text getUsage(CommandSource context) {
            return Texts.of(this.element.getUsage(context), CommandMessageFormatting.PLUS_TEXT);
        }
    }

    // -- Argument types for basic java types

    /**
     * Parent class that specifies elemenents as having no tab completions. Useful for inputs with a very large domain, like strings and integers
     */
    private abstract static class KeyElement extends CommandElement {
        private KeyElement(Text key) {
            super(key);
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            return Collections.emptyList();
        }
    }

    /**
     * Require an argument to be a string. Any provided argument will fit in under this argument
     *
     * @param key The key to store the parsed argument under
     * @return the element to match the input
     */
    public static CommandElement string(Text key) {
        return new StringElement(key);
    }

    private static class StringElement extends KeyElement {

        private StringElement(Text key) {
            super(key);
        }

        @Override
        public Object parseValue(CommandArgs args) throws ArgumentParseException {
            return args.next();
        }
    }


    /**
     * Require an argument to be an integer (base 10).
     *
     * @param key The key to store the parsed argument under
     * @return the element to match the input
     */
    public static CommandElement integer(Text key) {
        return new IntegerElement(key);
    }

    private static class IntegerElement extends KeyElement {

        private IntegerElement(Text key) {
            super(key);
        }

        @Override
        public Object parseValue(CommandArgs args) throws ArgumentParseException {
            final String input = args.next();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                throw args.createError(t("Expected an integer, but input '%s' was not", input));
            }
        }
    }

    private static final Map<String, Boolean> BOOLEAN_CHOICES = ImmutableMap.<String, Boolean>builder()
            .put("true", true)
            .put("t", true)
            .put("y", true)
            .put("yes", true)
            .put("verymuchso", true)
            .put("false", false)
            .put("f", false)
            .put("n", false)
            .put("no", false)
            .put("notatall", false)
            .build();

    /**
     * Require an argument to be a boolean.
     * The recognized true values are:
     * <ul>
     *     <li>true</li>
     *     <li>t</li>
     *     <li>yes</li>
     *     <li>y</li>
     *     <li>verymuchso</li>
     * </ul>
     * The recognized false values are:
     * <ul>
     *     <li>false</li>
     *     <li>f</li>
     *     <li>no</li>
     *     <li>n</li>
     *     <li>notatall</li>
     * </ul>
     *
     * @param key The key to store the parsed argument under
     * @return the element to match the input
     */
    public static CommandElement bool(Text key) {
        return GenericArguments.choices(key, BOOLEAN_CHOICES);
    }

    /**
     * Require the argument to be a key under the provided enum.
     *
     * @param key The key to store the matched enum value under
     * @param type The enum class to get enum constants from
     * @param <T> The type of enum
     * @return the element to match the input
     */
    public static <T extends Enum<T>> CommandElement enumValue(Text key, Class<T> type) {
        return new EnumValueElement<T>(key, type);
    }

    private static class EnumValueElement<T extends Enum<T>> extends CommandElement {
        private final Class<T> type;

        private EnumValueElement(Text key, Class<T> type) {
            super(key);
            this.type = type;
        }

        @Override
        public Object parseValue(CommandArgs args) throws ArgumentParseException {
            final String value = args.next().toUpperCase();
            try {
                return Enum.valueOf(this.type, value);
            } catch (IllegalArgumentException ex) {
                throw args.createError(t("Enum value %s not valid", value));
            }
        }

        @Override
        public  List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            Iterable<String> validValues = Iterables.transform(Arrays.asList(this.type.getEnumConstants()), new Function<T, String>() {
                @Nullable
                @Override
                public String apply(T input) {
                    return input.name();
                }
            });

            final Optional<String> nextArg = args.nextIfPresent();
            if (nextArg.isPresent()) {
                validValues = Iterables.filter(validValues, new StartsWithPredicate(nextArg.get()));
            }
            return ImmutableList.copyOf(validValues);
        }
    }

    /**
     * Require one or more strings, which are combined into a single, space-separated string.
     *
     * @param key The key to store the parsed argument under
     * @return the element to match the input
     */
    public static CommandElement remainingJoinedStrings(Text key) {
        return new RemainingJoinedStringsCommandElement(key, false);
    }

    private static class RemainingJoinedStringsCommandElement extends KeyElement {
        private final boolean raw;

        private RemainingJoinedStringsCommandElement(Text key, boolean raw) {
            super(key);
            this.raw = raw;
        }

        @Override
        protected Object parseValue(CommandArgs args) throws ArgumentParseException {
            if (this.raw) {
                args.next();
                String ret = args.getRaw().substring(args.getRawPosition());
                while (args.hasNext()) { // Consume remaining args
                    args.next();
                }
                return ret;
            } else {
                final StringBuilder ret = new StringBuilder(args.next());
                while (args.hasNext()) {
                    ret.append(' ').append(args.next());
                }
                return ret.toString();
            }
        }

        @Override
        public Text getUsage(CommandSource src) {
            return Texts.of(super.getUsage(src), "...");
        }
    }
}
