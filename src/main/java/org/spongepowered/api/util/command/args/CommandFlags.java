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
import com.google.common.collect.Iterables;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.StartsWithPredicate;
import org.spongepowered.api.util.command.CommandSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

class CommandFlags extends CommandElement {
    @Nullable
    private final CommandElement childElement;
    private final Map<List<String>, CommandElement> usageFlags;
    private final Map<String, CommandElement> shortFlags;
    private final Map<String, CommandElement> longFlags;
    private final boolean acceptArbitraryLongFlags;
    private final boolean anchorFlags;

    protected CommandFlags(@Nullable CommandElement childElement, Map<List<String>, CommandElement> usageFlags,
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
    public void parse(CommandSource source, CommandArgs args, CommandContext context) throws ArgumentParseException {
        Object startIdx = args.getState();
        String arg;
        while (args.hasNext()) {
            arg = args.next();
            if (arg.startsWith("-")) {
                Object flagStartIdx = args.getState();
                if (arg.startsWith("--")) { // Long flag
                    String longFlag = arg.substring(2);
                    parseLongFlag(source, longFlag, args, context);
                } else {
                    arg = arg.substring(1);
                    parseShortFlags(source, arg, args, context);
                }
                args.removeArgs(flagStartIdx, args.getState());
            } else if (this.anchorFlags) {
                break;
            }
        }

        args.setState(startIdx);
        if (this.childElement != null) {
            this.childElement.parse(source, args, context);
        }

    }

    private void parseLongFlag(CommandSource source, String longFlag, CommandArgs args, CommandContext context) throws ArgumentParseException {
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
                element.parse(source, args, context);
            }
        } else {
            CommandElement element = this.longFlags.get(longFlag.toLowerCase());
            if (element == null) {
                if (!this.acceptArbitraryLongFlags) {
                    throw args.createError(t("Unknown long flag %s specified", args));
                }
                context.putArg(longFlag, true);
            } else {
                element.parse(source, args, context);
            }
        }
    }

    private void parseShortFlags(CommandSource source, String shortFlags, CommandArgs args, CommandContext context) throws ArgumentParseException {
        for (int i = 0; i < shortFlags.length(); ++i) {
            final String flagChar = shortFlags.substring(i, i + 1);
            CommandElement element = this.shortFlags.get(flagChar);
            if (element == null) {
                throw args.createError(t("Unknown short flag %s specified", flagChar));
            }
            element.parse(source, args, context);
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
            if (!(arg.getValue() instanceof GenericArguments.MarkTrueCommandElement)) { // true flag
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
    protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
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

    @Nullable
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
                    element.parse(src, args, context);
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
                    element.parse(src, args, context);
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

    @Nullable
    private  List<String> tabCompleteShortFlags(String shortFlags, CommandSource src, CommandArgs args, CommandContext context) {
        for (int i = 0; i < shortFlags.length(); ++i) {
            final String flagChar = shortFlags.substring(i, i + 1);
            CommandElement element = this.shortFlags.get(flagChar);
            if (element == null) {
                continue;
            }
            Object start = args.getState();
            try {
                element.parse(src, args, context);
            } catch (ArgumentParseException ex) {
                args.setState(start);
                return element.complete(src, args, context);
            }
        }
        return null;
    }

    public static class Builder {
        private final Map<List<String>, CommandElement> usageFlags = new HashMap<List<String>, CommandElement>();
        private final Map<String, CommandElement> shortFlags = new HashMap<String, CommandElement>();
        private final Map<String, CommandElement> longFlags = new HashMap<String, CommandElement>();
        private boolean acceptsArbitraryLongFlags = true;
        private boolean anchorFlags = false;

        Builder() {}

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
        public Builder flag(String... specs) {
            final List<String> availableFlags = new ArrayList<String>(specs.length);
            CommandElement el = null;
            for (String spec : specs) {
                if (spec.startsWith("-")) {
                    final String flagKey = spec.substring(1);
                    if (el == null) {
                        el = GenericArguments.markTrue(flagKey);
                    }
                    availableFlags.add(flagKey);
                    this.longFlags.put(flagKey.toLowerCase(), el);
                } else {
                    for (int i = 0; i < spec.length(); ++i) {
                        final String flagKey = spec.substring(i, i + 1);
                        if (el == null) {
                            el = GenericArguments.markTrue(flagKey);
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
        public Builder valueFlag(CommandElement value, String... specs) {
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
            if (valueStore != null) { // Null if no valid flags were provided. Maybe we should throw an IllegalArgumentExcetpiion
                this.usageFlags.put(availableFlags, GenericArguments.markTrue(valueStore));
            }
            return this;
        }

        /**
         * If this is true, any long flag (--) will be accepted and added as a flag.
         *
         * @param acceptsArbitraryLongFlags Whether any long flag is accepted
         * @return this
         */
        public Builder setAcceptsArbitraryLongFlags(boolean acceptsArbitraryLongFlags) {
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
        public Builder setAnchorFlags(boolean anchorFlags) {
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
            return new CommandFlags(wrapped, this.usageFlags, this.shortFlags, this.longFlags, this.acceptsArbitraryLongFlags, this
                    .anchorFlags);
        }
    }
}
