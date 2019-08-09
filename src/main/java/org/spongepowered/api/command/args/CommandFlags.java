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

import static org.spongepowered.api.command.args.GenericArguments.markTrue;
import static org.spongepowered.api.command.args.GenericArguments.requiringPermission;
import static org.spongepowered.api.util.SpongeApiTranslationHelper.t;

import com.google.common.collect.ImmutableList;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.StartsWithPredicate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

public final class CommandFlags extends CommandElement {
    @Nullable
    private final CommandElement childElement;
    private final Map<List<String>, CommandElement> usageFlags;
    private final Map<String, CommandElement> shortFlags;
    private final Map<String, CommandElement> longFlags;
    private final UnknownFlagBehavior unknownShortFlagBehavior;
    private final UnknownFlagBehavior unknownLongFlagBehavior;
    private final boolean anchorFlags;

    protected CommandFlags(@Nullable CommandElement childElement, Map<List<String>, CommandElement> usageFlags,
            Map<String, CommandElement> shortFlags, Map<String, CommandElement> longFlags, UnknownFlagBehavior unknownShortFlagBehavior,
            UnknownFlagBehavior unknownLongFlagBehavior, boolean anchorFlags) {
        super(null);
        this.childElement = childElement;
        this.usageFlags = usageFlags;
        this.shortFlags = shortFlags;
        this.longFlags = longFlags;
        this.unknownShortFlagBehavior = unknownShortFlagBehavior;
        this.unknownLongFlagBehavior = unknownLongFlagBehavior;
        this.anchorFlags = anchorFlags;
    }

    @Override
    public void parse(CommandSource source, CommandArgs args, CommandContext context) throws ArgumentParseException {
        CommandArgs.Snapshot state = args.getSnapshot();
        while (args.hasNext()) {
            String arg = args.next();
            if (arg.startsWith("-")) {
                CommandArgs.Snapshot start = args.getSnapshot();
                boolean remove;
                if (arg.startsWith("--")) { // Long flag
                    remove = parseLongFlag(source, arg.substring(2), args, context);
                } else {
                    remove = parseShortFlags(source, arg.substring(1), args, context);
                }
                if (remove) {
                    args.removeArgs(start, args.getSnapshot());
                }
            } else if (this.anchorFlags) {
                break;
            }
        }
        // We removed the arguments so we don't parse them as they have already been parsed as flags,
        // so don't restore them here!
        args.applySnapshot(state, false);
        if (this.childElement != null) {
            this.childElement.parse(source, args, context);
        }
    }

    private boolean parseLongFlag(CommandSource source, String longFlag, CommandArgs args, CommandContext context) throws ArgumentParseException {
        String[] flagSplit = longFlag.split("=", 2);
        String flag = flagSplit[0].toLowerCase();
        CommandElement element = this.longFlags.get(flag);
        if (element == null) {
            switch (this.unknownLongFlagBehavior) {
                case ERROR:
                    throw args.createError(t("Unknown long flag %s specified", flagSplit[0]));
                case ACCEPT_NONVALUE:
                    context.putArg(flag, flagSplit.length == 2 ? flagSplit[1] : true);
                    return true;
                case ACCEPT_VALUE:
                    context.putArg(flag, flagSplit.length == 2 ? flagSplit[1] : args.next());
                    return true;
                case IGNORE:
                    return false;
                default:
                    throw new Error("New UnknownFlagBehavior added without corresponding case clauses");
            }
        } else if (flagSplit.length == 2) {
            args.insertArg(flagSplit[1]);
        }
        element.parse(source, args, context);
        return true;
    }

    private boolean parseShortFlags(CommandSource source, String shortFlags, CommandArgs args, CommandContext context) throws ArgumentParseException {
        for (int i = 0; i < shortFlags.length(); i++) {
            String shortFlag = shortFlags.substring(i, i + 1);
            CommandElement element = this.shortFlags.get(shortFlag);
            if (element == null) {
                switch (this.unknownShortFlagBehavior) {
                    case IGNORE:
                        if (i == 0) {
                            return false;
                        }
                        throw args.createError(t("Unknown short flag %s specified", shortFlag));
                    case ERROR:
                        throw args.createError(t("Unknown short flag %s specified", shortFlag));
                    case ACCEPT_NONVALUE:
                        context.putArg(shortFlag, true);
                        break;
                    case ACCEPT_VALUE:
                        context.putArg(shortFlag, args.next());
                        break;
                    default:
                        throw new Error("New UnknownFlagBehavior added without corresponding case clauses");
                }
            } else {
                element.parse(source, args, context);
            }
        }
        return true;
    }

    @Override
    public Text getUsage(CommandSource src) {
        final List<Object> builder = new ArrayList<>();
        for (Map.Entry<List<String>, CommandElement> arg : this.usageFlags.entrySet()) {
            builder.add("[");
            for (Iterator<String> it = arg.getKey().iterator(); it.hasNext();) {
                String flag = it.next();
                builder.add(flag.length() > 1 ? "--" : "-");
                builder.add(flag);
                if (it.hasNext()) {
                    builder.add("|");
                }
            }
            Text usage = arg.getValue().getUsage(src);
            if (usage.toPlain().trim().length() > 0) {
                builder.add(" ");
                builder.add(usage);
            }
            builder.add("]");
            builder.add(" ");
        }

        if (this.childElement != null) {
            builder.add(this.childElement.getUsage(src));
        }
        return Text.of(builder.toArray());
    }

    @Override
    protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
        return null;
    }

    @Override
    public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
        CommandArgs.Snapshot state = args.getSnapshot();
        while (args.hasNext()) {
            String next = args.nextIfPresent().get();
            if (next.startsWith("-")) {
                CommandArgs.Snapshot start = args.getSnapshot();
                List<String> ret;
                if (next.startsWith("--")) {
                    ret = tabCompleteLongFlag(next.substring(2), src, args, context);
                } else {
                    ret = tabCompleteShortFlags(next.substring(1), src, args, context);
                }
                if (ret != null) {
                    return ret;
                }
                args.removeArgs(start, args.getSnapshot());
            } else if (this.anchorFlags) {
                break;
            }
        }
        // the modifications are intentional
        args.applySnapshot(state, false);

        // Prevent tab completion gobbling up an argument if the value parsed.
        if (!args.hasNext() && !args.getRaw().matches("\\s+$")) {
            return ImmutableList.of();
        }
        return this.childElement != null ? childElement.complete(src, args, context) : ImmutableList.of();
    }

    @Nullable
    private List<String> tabCompleteLongFlag(String longFlag, CommandSource src, CommandArgs args, CommandContext context) {
        String[] flagSplit = longFlag.split("=", 2);
        boolean isSplitFlag = flagSplit.length == 2;
        CommandElement element = this.longFlags.get(flagSplit[0].toLowerCase());
        if (element == null || !isSplitFlag && !args.hasNext()) {
            return this.longFlags.keySet().stream()
                    .filter(new StartsWithPredicate(flagSplit[0]))
                    .map(f -> "--" + f)
                    .collect(Collectors.toList());
        } else if (isSplitFlag) {
            args.insertArg(flagSplit[1]);
        }
        CommandArgs.Snapshot state = args.getSnapshot();
        List<String> completion;
        try {
            element.parse(src, args, context);
            if (args.getSnapshot().equals(state)) {
                // Not iterated, but succeeded. Check completions to account for optionals
                completion = element.complete(src, args, context);
            } else {
                args.previous();
                String res = args.peek();
                completion = element.complete(src, args, context);
                if (!completion.contains(res)) {
                    completion = ImmutableList.<String>builder().addAll(completion).add(res).build();
                }
            }
        } catch (ArgumentParseException ex) {
            args.applySnapshot(state);
            completion = element.complete(src, args, context);
        }

        if (completion.isEmpty()) {
            if (isSplitFlag) {
                return ImmutableList.of(); // so we don't overwrite the flag
            }
            return null;
        }

        if (isSplitFlag) {
            return completion.stream().map(x -> "--" + flagSplit[0] + "=" + x).collect(Collectors.toList());
        }
        return completion;
    }

    @Nullable
    private List<String> tabCompleteShortFlags(String shortFlags, CommandSource src, CommandArgs args, CommandContext context) {
        for (int i = 0; i < shortFlags.length(); i++) {
            CommandElement element = this.shortFlags.get(shortFlags.substring(i, i+ 1));
            if (element == null) {
                if (i == 0 && this.unknownShortFlagBehavior == UnknownFlagBehavior.ACCEPT_VALUE) {
                    args.nextIfPresent();
                    return null;
                }
            } else {
                CommandArgs.Snapshot start = args.getSnapshot();
                try {
                    element.parse(src, args, context);

                    // if the iterator hasn't moved, then just try to complete, no point going backwards.
                    if (args.getSnapshot().equals(start)) {
                        return element.complete(src, args, context);
                    }

                    // if we managed to parse this, then go back to get the completions for it.
                    args.previous();
                    String currentText = args.peek();

                    // ensure this is returned as a valid option
                    List<String> elements = element.complete(src, args, context);
                    if (!elements.contains(currentText)) {
                        return ImmutableList.<String>builder().add(args.peek()).addAll(element.complete(src, args, context)).build();
                    } else {
                        return elements;
                    }
                } catch (ArgumentParseException ex) {
                    args.applySnapshot(start);
                    return element.complete(src, args, context);
                }
            }
        }
        return null;
    }

    /**
     * Indicates to the flag parser how it should treat an argument that looks
     * like a flag that it does not recognise.
     */
    public enum UnknownFlagBehavior {
        /**
         * Throw an {@link ArgumentParseException} when an unknown flag is
         * encountered.
         */
        ERROR,
        /**
         * Mark the flag as a non-value flag.
         */
        ACCEPT_NONVALUE,

        /**
         * Mark the flag as a string-valued flag.
         */
        ACCEPT_VALUE,
        /**
         * Act as if the unknown flag is an ordinary argument, allowing the
         * parsers specified in {@link Builder#buildWith(CommandElement)} to
         * attempt to parse the element instead.
         */
        IGNORE

    }

    public static class Builder {
        private final Map<List<String>, CommandElement> usageFlags = new HashMap<>();
        private final Map<String, CommandElement> shortFlags = new HashMap<>();
        private final Map<String, CommandElement> longFlags = new HashMap<>();
        private UnknownFlagBehavior unknownLongFlagBehavior = UnknownFlagBehavior.ERROR;
        private UnknownFlagBehavior unknownShortFlagBehavior = UnknownFlagBehavior.ERROR;
        private boolean anchorFlags = false;

        Builder() {}

        private static final Function<String, CommandElement> MARK_TRUE_FUNC = input -> markTrue(Text.of(input));

        private Builder flag(Function<String, CommandElement> func, String... specs) {
            final List<String> availableFlags = new ArrayList<>(specs.length);
            CommandElement el = null;
            for (String spec : specs) {
                if (spec.startsWith("-")) {
                    final String flagKey = spec.substring(1);
                    if (el == null) {
                        el = func.apply(flagKey);
                    }
                    availableFlags.add(flagKey);
                    this.longFlags.put(flagKey.toLowerCase(), el);
                } else {
                    for (int i = 0; i < spec.length(); ++i) {
                        final String flagKey = spec.substring(i, i + 1);
                        if (el == null) {
                            el = func.apply(flagKey);
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
         * Allow a flag with any of the provided specifications that has no
         * value. This flag will be exposed in a {@link CommandContext} under
         * the key equivalent to the first flag in the specification array.
         * The specifications are handled as so for each element in the
         * {@code specs} array:
         * <ul>
         *     <li>If the element starts with -, the remainder of the element
         *     is interpreted as a long flag (so, "-flag" means "--flag" will
         *     be matched in an argument string)</li>
         *     <li>Otherwise, each code point of the element is interpreted
         *     as a short flag (meaning "flag" will cause "-f", "-l", "-a" and
         *     "-g" to be matched in an argument string, storing "true" under
         *     the key "f".)</li>
         * </ul>
         *
         * @param specs The flag specifications
         * @return this
         */
        public Builder flag(String... specs) {
            return flag(MARK_TRUE_FUNC, specs);
        }

        /**
         * Allow a flag with any of the provided specifications that has no
         * value but requires the source to have a specific permission to
         * specify the command.
         *
         * @see #flag(String...) for details on the format
         * @param flagPermission The required permission
         * @param specs The flag specifications
         * @return this
         */
        public Builder permissionFlag(final String flagPermission, String... specs) {
            return flag(input -> requiringPermission(markTrue(Text.of(input)), flagPermission), specs);
        }

        /**
         * Allow a flag with any of the provided specifications, with the given
         * command element. The flag may be present multiple times, and may
         * therefore have multiple values.
         *
         * @see #flag(String...) for information on how the flag specifications
         *     are parsed
         * @param value The command element used to parse any occurrences
         * @param specs The flag specifications
         * @return this
         */
        public Builder valueFlag(CommandElement value, String... specs) {
            return flag(ignore -> value, specs);
        }

        /**
         * If this is true, any long flag (--) will be accepted and added as a
         * flag. If false, unknown long flags are considered errors.
         *
         * @param acceptsArbitraryLongFlags Whether any long flag is accepted
         * @return this
         *
         * @deprecated in favor of
         *         {@link #setUnknownLongFlagBehavior(UnknownFlagBehavior)}.
         */
        @Deprecated
        public Builder setAcceptsArbitraryLongFlags(boolean acceptsArbitraryLongFlags) {
            setUnknownLongFlagBehavior(acceptsArbitraryLongFlags ? UnknownFlagBehavior.ACCEPT_NONVALUE : UnknownFlagBehavior.ERROR);
            return this;
        }

        /**
         * Sets how long flags that are not registered should be handled when
         * encountered.
         *
         * @param behavior The behavior to use
         * @return this
         */
        public Builder setUnknownLongFlagBehavior(UnknownFlagBehavior behavior) {
            this.unknownLongFlagBehavior = behavior;
            return this;
        }

        /**
         * Sets how long flags that are not registered should be handled when
         * encountered.
         *
         * <p>If a command that supports flags accepts negative numbers (or
         * arguments that may begin with a dash), setting this to
         * {@link UnknownFlagBehavior#IGNORE} will cause these elements to
         * be ignored by the flag parser and will be parsed by the command's
         * non-flag elements instead.</p>
         *
         * @param behavior The behavior to use
         * @return this
         */
        public Builder setUnknownShortFlagBehavior(UnknownFlagBehavior behavior) {
            this.unknownShortFlagBehavior = behavior;
            return this;
        }

        /**
         * Whether flags should be anchored to the beginning of the text (so
         * flags will only be picked up if they are at the beginning of the
         * input).
         *
         * @param anchorFlags Whether flags are anchored
         * @return this
         */
        public Builder setAnchorFlags(boolean anchorFlags) {
            this.anchorFlags = anchorFlags;
            return this;
        }

        /**
         * Build a flag command element using the given command element to
         * handle all non-flag arguments.
         *
         * <p>If you wish to add multiple elements here, wrap them in
         * {@link GenericArguments#seq(CommandElement...)}</p>
         *
         * @param wrapped The wrapped command element
         * @return the new command element
         */
        public CommandElement buildWith(CommandElement wrapped) {
            return new CommandFlags(wrapped, this.usageFlags, this.shortFlags, this.longFlags, this.unknownShortFlagBehavior,
                    this.unknownLongFlagBehavior, this.anchorFlags);
        }
    }
}
