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
import static org.spongepowered.api.command.args.GenericArguments.string;
import static org.spongepowered.api.util.SpongeApiTranslationHelper.t;

import com.google.common.collect.ImmutableList;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.GuavaCollectors;
import org.spongepowered.api.util.StartsWithPredicate;
import org.spongepowered.api.command.CommandSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
        this.childElement = childElement;
        this.usageFlags = usageFlags;
        this.shortFlags = shortFlags;
        this.longFlags = longFlags;
        this.unknownShortFlagBehavior = unknownShortFlagBehavior;
        this.unknownLongFlagBehavior = unknownLongFlagBehavior;
        this.anchorFlags = anchorFlags;
    }

    public static CommandFlags withFlags(Element<?>... elements) {
        return GenericArguments.flags().flag(elements).build();
    }

    /**
     * Attributes for a flag:
     * - number of occurrences (and/or to restrict)
     * - known aliases
     * - value parser
     *
     * Things to support:
     *
     * - add to context multiple times to combine Collections
     * - context default values
     */

    public static <T> Element<T> valueFlag(CommandElement.Value<T> value, String... keys) {
        return new Element<T>(value, keys);
    }

    /**
     * Create an element for a flag with any of the provided specifications that has no value.
     * This flag will be exposed in a {@link CommandContext} under the key equivalent to the first flag in the specification array.
     * The specifications are handled as so for each element in the {@code specs} array:
     * <ul>
     *     <li>If the element starts with -, the remainder of the element is interpreted as a long flag</li>
     *     <li>Otherwise, each code point of the element is interpreted as a short flag</li>
     * </ul>
     *
     * @param keys The flag specifications
     * @return this
     */
    public static Element<Boolean> flag(String... keys) {
        return valueFlag(markTrue(keys[0]), keys);
    }

    public static class UnknownFlagHandler<T> extends CommandElement.Value<Map<String, T>> {
        private final CommandElement.Value<T> el;

        protected UnknownFlagHandler(CommandElement.Value<T> el) {
            super(el.getKey());
            this.el = el;
        }

        @Override
        protected Map<String, T> parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            throw new UnsupportedOperationException("Not yet implemented");
        }
    }

    public static class Element<T> extends CommandElement.Value<Optional<T>> {
        private final CommandElement.Value<T> element;
        private final List<String> flags;

        protected Element(CommandElement.Value<T> element, String... keys) {
            super(element.getKey());
            this.element = element;
            final ImmutableList.Builder<String> flags = ImmutableList.builder();
            for (String spec : keys) {
                if (spec.startsWith("-")) {
                    final String flagKey = spec.substring(1);
                    flags.add(flagKey.toLowerCase());
                } else {
                    spec.codePoints()
                            .mapToObj(cpt -> new String(new int[] { cpt }, 0, 1))
                            .forEach(flags::add);
                }
            }
            this.flags = flags.build();
        }

        public List<String> getFlags() {
            return this.flags;
        }

        @Override
        protected Optional<T> parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            return Optional.of(this.element.parseValue(source, args));
        }
    }

    /**
     * A flag that can be specified multiple times
     * @param <T>
     */
    public static class MultiElement<T> extends Element<Collection<? extends T>> {
        protected MultiElement(Value<Collection<? extends T>> element, String... keys) {
            super(element, keys);
        }
    }

    @Override
    public void parse(CommandSource source, CommandArgs args, CommandContext context) throws ArgumentParseException {
        Object startIdx = args.getState();
        String arg;
        while (args.hasNext()) {
            arg = args.next();
            boolean ignore;
            if (arg.startsWith("-")) {
                Object flagStartIdx = args.getState();
                if (arg.startsWith("--")) { // Long flag
                    String longFlag = arg.substring(2);
                    ignore = !parseLongFlag(source, longFlag, args, context);
                } else {
                    arg = arg.substring(1);
                    ignore = !parseShortFlags(source, arg, args, context);
                }
                if (!ignore) {
                    args.removeArgs(flagStartIdx, args.getState());
                }
            } else if (this.anchorFlags) {
                break;
            }
        }

        args.setState(startIdx);
        if (this.childElement != null) {
            this.childElement.parse(source, args, context);
        }

    }

    private boolean parseLongFlag(CommandSource source, String longFlag, CommandArgs args, CommandContext context) throws ArgumentParseException {
        if (longFlag.contains("=")) {
            final String[] flagSplit = longFlag.split("=", 2);
            longFlag = flagSplit[0];
            String value = flagSplit[1];
            CommandElement element = this.longFlags.get(longFlag.toLowerCase());
            if (element == null) {
                // TODO
            } else {
                args.insertArg(value);
                element.parse(source, args, context);
            }
        } else {
            CommandElement element = this.longFlags.get(longFlag.toLowerCase());
            if (element == null) {
                // TODO
            } else {
                element.parse(source, args, context);
            }
        }
        return true;
    }

    @SuppressWarnings("fallthrough")
    private boolean parseShortFlags(CommandSource source, String shortFlags, CommandArgs args, CommandContext context) throws ArgumentParseException {
        for (int i = 0; i < shortFlags.length(); ++i) {
            final String flagChar = shortFlags.substring(i, i + 1);
            CommandElement element = this.shortFlags.get(flagChar);
            if (element == null) {
                // TODO: Unknown flag handling
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
                builder.add("-");
                builder.add(it.next());
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
    public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) throws ArgumentParseException {
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
    private List<String> tabCompleteLongFlag(String longFlag, CommandSource src, CommandArgs args, CommandContext context)
            throws ArgumentParseException {
        if (longFlag.contains("=")) {
            final String[] flagSplit = longFlag.split("=", 2);
            longFlag = flagSplit[0];
            String value = flagSplit[1];
            CommandElement element = this.longFlags.get(longFlag.toLowerCase());
            if (element == null) { // Whole flag is specified, we'll go to value
                //context.putArg(longFlag, value);
            } else {
                args.insertArg(value);
                final String finalLongFlag = longFlag;
                Object position = args.getState();
                try {
                    element.parse(src, args, context);
                } catch (ArgumentParseException ex) {
                    args.setState(position);
                    return ImmutableList.copyOf(
                        element.complete(src, args, context).stream().map(input -> "--" + finalLongFlag + "=" + input).collect(Collectors.toList()));
                }
            }
        } else {
            CommandElement element = this.longFlags.get(longFlag.toLowerCase());
            if (element == null) {
                List<String> retStrings = this.longFlags.keySet().stream()
                    .filter(new StartsWithPredicate(longFlag))
                    .map(arg -> "--" + arg)
                    .collect(GuavaCollectors.toImmutableList());
                if (retStrings.isEmpty() && this.unknownLongFlagBehavior == UnknownFlagBehavior.ACCEPT_VALUE) { // Then we probably have a
                // following arg specified, if there's anything
                    args.nextIfPresent();
                    return null;
                }
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
    private List<String> tabCompleteShortFlags(String shortFlags, CommandSource src, CommandArgs args, CommandContext context)
            throws ArgumentParseException {
        for (int i = 0; i < shortFlags.length(); ++i) {
            final String flagChar = shortFlags.substring(i, i + 1);
            CommandElement element = this.shortFlags.get(flagChar);
            if (element == null) {
                if (i == 0 && this.unknownShortFlagBehavior == UnknownFlagBehavior.ACCEPT_VALUE) {
                    args.nextIfPresent();
                    return null;
                }

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

    public enum UnknownFlagBehavior {
        /**
         * Throw an {@link ArgumentParseException} when an unknown flag is encountered.
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
         * Act as if the unknown flag is an ordinary argument.
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

        private static final Function<String, CommandElement> MARK_TRUE_FUNC = GenericArguments::markTrue;

        public Builder flag(Element<?>... flags) {
            return this; // TODO
        }

        /**
         * Allow a flag with any of the provided specifications that has no value but requires the source to have a specific permission to specify
         * the command.
         *
         * @see #flag(String...) for details on the format
         * @param flagPermission The required permission
         * @param specs The flag specifications
         * @return this
         */
        public Builder permissionFlag(final String flagPermission, String... specs) {
            //return flag(input -> requiringPermission(markTrue(input), flagPermission), specs);
            return this; // TODO
        }

        /**
         * If this is true, any long flag (--) will be accepted and added as a flag.
         *
         * @param acceptsArbitraryLongFlags Whether any long flag is accepted
         * @return this
         */
        public Builder setAcceptsArbitraryLongFlags(boolean acceptsArbitraryLongFlags) {
            setUnknownLongFlagBehavior(UnknownFlagBehavior.ACCEPT_NONVALUE);
            return this;
        }

        public CommandElement.Value<Map<String, Object>> getUnknownFlagHolder() {
            return null; // TODO
        }

        /**
         * Set how long flags that are not registered should be handled when encountered.
         *
         * @param behavior The behavior to use
         * @return this
         */
        public Builder setUnknownLongFlagBehavior(UnknownFlagBehavior behavior) {
            this.unknownLongFlagBehavior = behavior;
            return this;
        }

        /**
         * Set how long flags that are not registered should be handled when encountered.
         *
         * @param behavior The behavior to use
         * @return this
         */
        public Builder setUnknownShortFlagBehavior(UnknownFlagBehavior behavior) {
            this.unknownShortFlagBehavior = behavior;
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
         * @return the new command element
         */
        public CommandFlags build() {
            /*return new CommandFlags(this.usageFlags, this.shortFlags, this.longFlags, this.unknownShortFlagBehavior,
                    this.unknownLongFlagBehavior, this.anchorFlags);*/
            return null; // TODO
        }
    }
}
