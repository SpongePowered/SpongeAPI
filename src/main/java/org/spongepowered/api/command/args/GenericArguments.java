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

import static com.google.common.base.Preconditions.checkNotNull;
import static org.spongepowered.api.util.SpongeApiTranslationHelper.t;

import com.flowpowered.math.vector.Vector3d;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandMessageFormatting;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.source.LocatedSource;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.service.user.UserStorageService;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.GuavaCollectors;
import org.spongepowered.api.util.StartsWithPredicate;
import org.spongepowered.api.util.blockray.BlockRay;
import org.spongepowered.api.util.blockray.BlockRayHit;
import org.spongepowered.api.world.DimensionType;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.storage.WorldProperties;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

/**
 * Class containing factory methods for common command elements.
 */
public final class GenericArguments {

    private static final CommandElement NONE = new SequenceCommandElement(ImmutableList.<CommandElement>of());

    private GenericArguments() {}

    /**
     * Expects no arguments.
     *
     * @return An expectation of no arguments
     */
    public static CommandElement none() {
        return NONE;
    }

    static CommandElement.Value<Boolean> markTrue(String flag) {
        return new MarkTrueCommandElement(flag);
    }

    /**
     * Expect an argument to represent an online player,
     * or if nothing matches and the source is a {@link Player}, give the player. If nothing matches and the source is not a player, throw an
     * exception
     * Gives value of type {@link Player}
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement.Value<Collection<? extends Player>> playerOrSource(Text key) {
        return new PlayerCommandElement(key, true);
    }

    /**
     * Expect an argument to represent an online player.
     * Gives value of type {@link Player}
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement.Value<Collection<? extends Player>> player(Text key) {
        return new PlayerCommandElement(key, false);
    }

    /**
     * Expect an argument to represent a player who has been online at some point, as a {@link User}
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement.Value<Collection<? extends User>> user(Text key) {
        return new UserCommandElement(key);
    }

    /**
     * Expect an argument to represent a world. This gives a WorldProperties object rather than an actual world in order to include unloaded worlds
     * as well
     * Gives values of type {@link WorldProperties}
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement.Value<Collection<? extends WorldProperties>> world(Text key) {
        return new WorldPropertiesCommandElement(key);
    }

    /**
     * Expect an argument to represent a dimension.
     * Gives values of tye {@link DimensionType}
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement.Value<Collection<? extends DimensionType>> dimension(Text key) {
        return catalogedElement(key, DimensionType.class);
    }

    /**
     * Expect an argument to represent a {@link Vector3d}.
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement.Value<Vector3d> vector3d(Text key) {
        return new Vector3dCommandElement(key);
    }

    /**
     * Expect an argument to represent a {@link Location}.
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement.Value<Location> location(Text key) {
        return new LocationCommandElement(key);
    }

    /**
     * Expect an argument that is a member of the specified catalog type T.
     *
     * @param key The key to store the resolved value under
     * @param catalogType The type expected
     * @param <T> The type to return
     * @return the argument
     */
    public static <T extends CatalogType> CommandElement.Value<Collection<? extends T>> catalogedElement(Text key, Class<T> catalogType) {
        return new CatalogedTypeCommandElement<>(key, catalogType);
    }

    static class MarkTrueCommandElement extends CommandElement.Value<Boolean> {
        public MarkTrueCommandElement(String flag) {
            super(Text.of(flag));
        }

        @Override
        protected Boolean parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            return true;
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            return Collections.emptyList();
        }
    }

    /**
     * Gets a builder to create a command element that parses flags.
     *
     * @return the newly created builder
     */
    public static CommandFlags.Builder flags() {
        return new CommandFlags.Builder();
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
            this.elements = elements;
        }

        @Override
        public void parse(CommandSource source, CommandArgs args, CommandContext context) throws ArgumentParseException {
            for (CommandElement element : this.elements) {
                element.parse(source, args, context);
            }
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            for (Iterator<CommandElement> it = this.elements.iterator(); it.hasNext(); ) {
                CommandElement element = it.next();
                Object startState = args.getState();
                try {
                    element.parse(src, args, context);
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
        public Text getUsage(CommandSource commander) {
            final Text.Builder build = Text.builder();
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
    public static <T> CommandElement.Value<T> choices(Text key, Map<String, T> choices) {
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
    public static <T> CommandElement.Value<T> choices(Text key, Map<String, T> choices, boolean choicesInUsage) {
        return new ChoicesCommandElement<>(key, ImmutableMap.copyOf(choices), choicesInUsage);
    }

    private static class ChoicesCommandElement<T> extends CommandElement.Value<T> {
        private final Map<String, T> choices;
        private final boolean choicesInUsage;

        private ChoicesCommandElement(Text key, Map<String, T> choices, boolean choicesInUsage) {
            super(key);
            this.choices = choices;
            this.choicesInUsage = choicesInUsage;
        }

        @Override
        public T parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            T value = this.choices.get(args.next());
            if (value == null) {
                throw args.createError(t("Argument was not a valid choice. Valid choices: %s", this.choices.keySet().toString()));
            }
            return value;
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            final String prefix = args.nextIfPresent().orElse("");
            return this.choices.keySet().stream().filter(new StartsWithPredicate(prefix)).collect(GuavaCollectors.toImmutableList());
        }

        @Override
        public Text getUsage(CommandSource commander) {
            if (this.choicesInUsage) {
                final Text.Builder build = Text.builder();
                build.append(CommandMessageFormatting.LT_TEXT);
                for (Iterator<String> it = this.choices.keySet().iterator(); it.hasNext();) {
                    build.append(Text.of(it.next()));
                    if (it.hasNext()) {
                        build.append(CommandMessageFormatting.PIPE_TEXT);
                    }
                }
                build.append(CommandMessageFormatting.GT_TEXT);
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
            this.elements = elements;
        }

        @Override
        public void parse(CommandSource source, CommandArgs args, CommandContext context) throws ArgumentParseException {
            ArgumentParseException lastException = null;
            for (CommandElement element : this.elements) {
                Object startState = args.getState();
                try {
                    element.parse(source, args, context);
                    return;
                } catch (ArgumentParseException ex) {
                    lastException = ex;
                    args.setState(startState);
                }
            }
            if (lastException != null) {
                throw lastException;
            }
        }

        @Override
        public List<String> complete(final CommandSource src, final CommandArgs args, final CommandContext context) {
            return this.elements.stream()
                    .flatMap(input -> {
                        Object startState = args.getState();
                        List<String> ret = input.complete(src, args, context);
                        args.setState(startState);
                        return ret.stream();
                    })
                    .collect(GuavaCollectors.toImmutableList());
        }

        @Override
        public Text getUsage(CommandSource commander) {
            final Text.Builder ret = Text.builder();
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
    public static <T> CommandElement.Value<Optional<T>> optional(CommandElement.Value<T> element) {
        return new OptionalCommandElement<>(element, false);
    }

    /**
     * Make the provided command element optional
     * This means the command element is not required.
     * If the argument is provided but of invalid format, it will be skipped.
     *
     * @param element The element to optionally require
     * @return the element to match the input
     */
    public static <T> CommandElement.Value<Optional<T>> optionalWeak(CommandElement.Value<T> element) {
        return new OptionalCommandElement<>(element, true);
    }

    private static class OptionalCommandElement<T> extends CommandElement.Value<Optional<T>> {
        private final CommandElement.Value<T> element;
        private final boolean considerInvalidFormatEmpty;

        private OptionalCommandElement(CommandElement.Value<T> element, boolean considerInvalidFormatEmpty) {
            super(element.getKey());
            this.element = element;
            this.considerInvalidFormatEmpty = considerInvalidFormatEmpty;
        }

        @Override
        protected Optional<T> parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            if (!args.hasNext()) {
                return Optional.empty();
            }
            Object startState = args.getState();
            try {
                return Optional.of(this.element.parseValue(source, args));
            } catch (ArgumentParseException ex) {
                if (this.considerInvalidFormatEmpty || args.hasNext()) { // If there are more args, suppress. Otherwise, throw the error
                    args.setState(startState);
                    return Optional.empty();
                } else {
                    throw ex;
                }
            }
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            return this.element.complete(src, args, context);
        }

        @Override
        public Text getUsage(CommandSource src) {
            return Text.of("[", this.element.getUsage(src), "]");
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
            this.element = element;
            this.times = times;
        }

        @Override
        public void parse(CommandSource source, CommandArgs args, CommandContext context) throws ArgumentParseException {
            for (int i = 0; i < this.times; ++i) {
                this.element.parse(source, args, context);
            }
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            for (int i = 0; i < this.times; ++i) {
                Object startState = args.getState();
                try {
                    this.element.parse(src, args, context);
                } catch (ArgumentParseException e) {
                    args.setState(startState);
                    return this.element.complete(src, args, context);
                }
            }
            return Collections.emptyList();
        }

        @Override
        public Text getUsage(CommandSource src) {
            return Text.of(this.times, '*', this.element.getUsage(src));
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
            this.element = element;
        }

        @Override
        public void parse(CommandSource source, CommandArgs args, CommandContext context) throws ArgumentParseException {
            while (args.hasNext()) {
                this.element.parse(source, args, context);
            }
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            while (args.hasNext()) {
                Object startState = args.getState();
                try {
                    this.element.parse(src, args, context);
                } catch (ArgumentParseException e) {
                    args.setState(startState);
                    return this.element.complete(src, args, context);
                }
            }
            return Collections.emptyList();
        }

        @Override
        public Text getUsage(CommandSource context) {
            return Text.of(this.element.getUsage(context), CommandMessageFormatting.STAR_TEXT);
        }
    }

    // -- Argument types for basic java types

    /**
     * Require an argument to be a string. Any provided argument will fit in under this argument.
     * Gives values of type {@link String}.
     *
     * @param key The key to store the parsed argument under
     * @return the element to match the input
     */
    public static CommandElement.Value<String> string(Text key) {
        return new StringElement(key);
    }

    private static class StringElement extends CommandElement.Value<String> {

        private StringElement(Text key) {
            super(key);
        }

        @Override
        public String parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            return args.next();
        }
    }


    /**
     * Require an argument to be an integer (base 10).
     * Gives values of type {@link Integer}
     *
     * @param key The key to store the parsed argument under
     * @return the element to match the input
     */
    public static CommandElement.Value<Integer> integer(Text key) {
        return new IntegerElement(key);
    }

    private static class IntegerElement extends CommandElement.Value<Integer> {

        private IntegerElement(Text key) {
            super(key);
        }

        @Override
        public Integer parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            final String input = args.next();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                throw args.createError(t("Expected an integer, but input '%s' was not", input));
            }
        }
    }

    /**
     * Require an argument to be an double-precision floating point number.
     * Gives values of type {@link Double}
     *
     * @param key The key to store the parsed argument under
     * @return the element to match the input
     */
    public static CommandElement.Value<Double> doubleNum(Text key) {
        return new DoubleNumElement(key);
    }

    private static class DoubleNumElement extends CommandElement.Value<Double> {

        private DoubleNumElement(Text key) {
            super(key);
        }

        @Override
        public Double parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            final String input = args.next();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException ex) {
                throw args.createError(t("Expected a number, but input '%s' was not", input));
            }
        }
    }

    private static final Map<String, Boolean> BOOLEAN_CHOICES = ImmutableMap.<String, Boolean>builder()
            .put("true", true)
            .put("t", true)
            .put("y", true)
            .put("yes", true)
            .put("verymuchso", true)
            .put("1", true)
            .put("false", false)
            .put("f", false)
            .put("n", false)
            .put("no", false)
            .put("notatall", false)
            .put("0", false)
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
     * Gives values of type {@link Boolean}
     *
     * @param key The key to store the parsed argument under
     * @return the element to match the input
     */
    public static CommandElement.Value<Boolean> bool(Text key) {
        return GenericArguments.choices(key, BOOLEAN_CHOICES);
    }

    /**
     * Require the argument to be a key under the provided enum.
     * Gives values of type T
     *
     * @param key The key to store the matched enum value under
     * @param type The enum class to get enum constants from
     * @param <T> The type of enum
     * @return the element to match the input
     */
    public static <T extends Enum<T>> CommandElement.Value<Collection<? extends T>> enumValue(Text key, Class<T> type) {
        return new EnumValueElement<>(key, type);
    }

    private static class EnumValueElement<T extends Enum<T>> extends PatternMatchingCommandElement<T> {
        private final Class<T> type;

        private EnumValueElement(Text key, Class<T> type) {
            super(key);
            this.type = type;
        }

        @Override
        protected Iterable<String> getChoices(CommandSource source) {
            return Arrays.asList(this.type.getEnumConstants()).stream()
                .map(input -> input == null ? null : input.name())
                .collect(Collectors.toList());
        }

        @Override
        protected T getValue(String choice) throws IllegalArgumentException {
            return Enum.valueOf(this.type, choice.toUpperCase());
        }
    }

    /**
     * Require one or more strings, which are combined into a single, space-separated string.
     * Gives values of type {@link String}
     *
     * @param key The key to store the parsed argument under
     * @return the element to match the input
     */
    public static CommandElement.Value<String> remainingJoinedStrings(Text key) {
        return new RemainingJoinedStringsCommandElement(key, false);
    }

    private static class RemainingJoinedStringsCommandElement extends CommandElement.Value<String> {
        private final boolean raw;

        private RemainingJoinedStringsCommandElement(Text key, boolean raw) {
            super(key);
            this.raw = raw;
        }

        @Override
        protected String parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
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
            return Text.of(CommandMessageFormatting.LT_TEXT, getKey(), CommandMessageFormatting.ELLIPSIS_TEXT, CommandMessageFormatting.GT_TEXT);
        }
    }

    /**
     * Expect a literal sequence of arguments. This element matches the input against a predefined array of arguments expected to be present,
     * case-insensitively.
     *
     * @param key The key to add to the context. Will be set to a value of true if this element matches
     * @param expectedArgs The sequence of arguments expected
     * @return the appropriate command element
     */
    public static CommandElement.Value<Boolean> literal(Text key, String... expectedArgs) {
        return new LiteralCommandElement<>(key, ImmutableList.copyOf(expectedArgs), true);
    }

    /**
     * Expect a literal sequence of arguments. This element matches the input against a predefined array of arguments expected to be present,
     * case-insensitively.
     *
     * @param key The key to store this argument as
     * @param putValue The value to put at key if this argument matches. May be null
     * @param expectedArgs The sequence of arguments expected
     * @return the appropriate command element
     */
    public static <T> CommandElement.Value<T> literal(Text key, T putValue, String... expectedArgs) {
        return new LiteralCommandElement<>(key, ImmutableList.copyOf(expectedArgs), putValue);
    }

    private static class LiteralCommandElement<T> extends CommandElement.Value<T> {
        private final List<String> expectedArgs;
        private final T putValue;

        protected LiteralCommandElement(Text key, List<String> expectedArgs, T putValue) {
            super(key);
            this.expectedArgs = ImmutableList.copyOf(expectedArgs);
            this.putValue = putValue;
        }

        @Override
        protected T parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            for (String arg : this.expectedArgs) {
                String current;
                if (!(current = args.next()).equalsIgnoreCase(arg)) {
                    throw args.createError(t("Argument %s did not match expected next argument %s", current, arg));
                }
            }
            return this.putValue;
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            for (String arg : this.expectedArgs) {
                final Optional<String> next = args.nextIfPresent();
                if (!next.isPresent()) {
                    break;
                } else if (args.hasNext()) {
                    if (!next.get().equalsIgnoreCase(arg)) {
                        break;
                    }
                } else {
                    if (arg.toLowerCase().startsWith(next.get().toLowerCase())) { // Case-insensitive compare
                        return ImmutableList.of(arg); // TODO: Possibly complete all remaining args? Does that even work
                    }
                }
            }
            return ImmutableList.of();
        }

        @Override
        public Text getUsage(CommandSource src) {
            return Text.of(Joiner.on(' ').join(this.expectedArgs));
        }
    }

    private static class UserCommandElement extends PatternMatchingCommandElement<User> {
        private final PlayerCommandElement possiblePlayer;

        protected UserCommandElement(Text key) {
            super(key);
            this.possiblePlayer = new PlayerCommandElement(key, false);
        }

        @Override
        protected Collection<? extends User> parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            Object state = args.getState();
            try {
                return possiblePlayer.parseValue(source, args);
            } catch (ArgumentParseException ex) {
                args.setState(state);
                return super.parseValue(source, args);
            }
        }

        @Override
        protected Iterable<String> getChoices(CommandSource source) {
            return Iterables.transform(Sponge.getGame().getServiceManager().provideUnchecked(UserStorageService.class).getAll(), GameProfile::getName);
        }

        @Override
        protected User getValue(String choice) throws IllegalArgumentException {
            return Sponge.getGame().getServiceManager().provideUnchecked(UserStorageService.class).get(choice).get();
        }
    }

    private static class PlayerCommandElement extends PatternMatchingCommandElement<Player> {
        private final boolean returnSource;

        protected PlayerCommandElement(Text key, boolean returnSource) {
            super(key);
            this.returnSource = returnSource;
        }

        @Override
        protected Collection<? extends Player> parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            // TODO: Make player name resolution better -- support selectors, etc
            if (!args.hasNext() && this.returnSource) {
                return Collections.singleton(tryReturnSource(source, args));
            }

            Object state = args.getState();
            try {
                return super.parseValue(source, args);
            } catch (ArgumentParseException ex) {
                if (this.returnSource) {
                    args.setState(state);
                    return Collections.singleton(tryReturnSource(source, args));
                } else {
                    throw ex;
                }
            }
        }

        @Override
        protected Iterable<String> getChoices(CommandSource source) {
            return Sponge.getGame().getServer().getOnlinePlayers().stream()
                .map(input -> input == null ? null : input.getName())
                .collect(Collectors.toList());
        }

        @Override
        protected Player getValue(String choice) throws IllegalArgumentException {
            Optional<Player> ret = Sponge.getGame().getServer().getPlayer(choice);
            if (!ret.isPresent()) {
                throw new IllegalArgumentException("Input value " + choice + " was not a player");
            }
            return ret.get();
        }

        private Player tryReturnSource(CommandSource source, CommandArgs args) throws ArgumentParseException {
            if (source instanceof Player) {
                return ((Player) source);
            } else {
                throw args.createError(t("No players matched and source was not a player!"));
            }
        }

        @Override
        public Text getUsage(CommandSource src) {
            return src instanceof Player && this.returnSource ? Text.of("[", super.getUsage(src), "]") : super.getUsage(src);
        }
    }

    /**
     * Acceped formats:
     *
     * <ul>
     *     <li>#first</li>
     *     <li>#&lt;dimension></li>
     *     <li>&lt;name></li>
     *     <li>#me</li>
     * </ul>
     */
    private static class WorldPropertiesCommandElement extends PatternMatchingCommandElement<WorldProperties> {
        private final CommandElement.Value<? extends DimensionType> dimensionTypeElement;

        protected WorldPropertiesCommandElement(Text key) {
            super(key);
            this.dimensionTypeElement = onlyOne(dimension(key));
        }

        @Override
        public Collection<? extends WorldProperties> parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            final String next = args.peek();
            if (next.startsWith("#")) {
                String specifier = next.substring(1);
                if (specifier.equalsIgnoreCase("first")) {
                    args.next();
                    return Collections.singleton(Iterables.filter(Sponge.getGame().getServer().getAllWorldProperties(), input -> {
                            return input != null && input.isEnabled();
                    }).iterator().next());
                } else if (specifier.equalsIgnoreCase("me") && source instanceof LocatedSource) {
                    args.next();
                    return Collections.singleton(((LocatedSource) source).getWorld().getProperties());
                } else {
                    boolean firstOnly = false;
                    if (specifier.endsWith(":first")) {
                        firstOnly = true;
                        specifier = specifier.substring(0, specifier.length() - 6);
                    }
                    args.next();
                    args.insertArg(specifier);
                    final DimensionType type = this.dimensionTypeElement.parseValue(source, args);
                    Iterable<WorldProperties> ret = Iterables.filter(Sponge.getGame().getServer().getAllWorldProperties(), input -> {
                            return input != null && input.isEnabled() && input.getDimensionType().equals(type);
                    });
                    return firstOnly ? Collections.singleton(ret.iterator().next()) : ImmutableList.copyOf(ret);
                }
            }

            return super.parseValue(source, args);
        }

        @Override
        protected Iterable<String> getChoices(CommandSource source) {
            return Iterables.concat(Sponge.getGame().getServer().getAllWorldProperties().stream()
                .map(input -> input == null || !input.isEnabled() ? null : input.getWorldName())
                .collect(Collectors.toList()), ImmutableSet.of("#first", "#me"), Iterables.transform(Sponge.getGame().getRegistry().getAllOf(DimensionType
                    .class),
                    input2 -> "#" + input2.getId()));
        }

        @Override
        protected WorldProperties getValue(String choice) throws IllegalArgumentException {
            Optional<WorldProperties> ret = Sponge.getGame().getServer().getWorldProperties(choice);
            if (!ret.isPresent()) {
                throw new IllegalArgumentException("Provided argument " + choice + " did not match a WorldProperties");
            }
            return ret.get();
        }
    }

    /**
     * Syntax:
     * x,y,z
     * x y z.
     * each element can be relative to a location? so parseRelativeDouble() -- relative is ~(num)
     *
     */
    private static class Vector3dCommandElement extends CommandElement.Value<Vector3d> {
        private static final ImmutableSet<String> SPECIAL_TOKENS = ImmutableSet.of("#target", "#me");

        protected Vector3dCommandElement(Text key) {
            super(key);
        }

        @Override
        protected Vector3d parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            String xStr;
            String yStr;
            String zStr;
            xStr = args.next();
            if (xStr.contains(",")) {
                String[] split = xStr.split(",");
                if (split.length != 3) {
                    throw args.createError(t("Comma-separated location must have 3 elements, not %s", split.length));
                }
                xStr = split[0];
                yStr = split[1];
                zStr = split[2];
            } else if (xStr.equals("#target") && source instanceof Entity) {
                Optional<BlockRayHit<World>> hit = BlockRay.from(((Entity) source)).filter(BlockRay.onlyAirFilter()).build().end();
                if (!hit.isPresent()) {
                    throw args.createError(t("No target block is available! Stop stargazing!"));
                }
                return hit.get().getPosition();
            } else if (xStr.equalsIgnoreCase("#me") && source instanceof LocatedSource) {
                return ((LocatedSource) source).getLocation().getPosition();
            } else {
                yStr = args.next();
                zStr = args.next();
            }
            final double x = parseRelativeDouble(args, xStr, source instanceof LocatedSource ? ((LocatedSource) source).getLocation().getX() : null);
            final double y = parseRelativeDouble(args, yStr, source instanceof LocatedSource ? ((LocatedSource) source).getLocation().getY() : null);
            final double z = parseRelativeDouble(args, zStr, source instanceof LocatedSource ? ((LocatedSource) source).getLocation().getZ() : null);

            return new Vector3d(x, y, z);
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            Optional<String> arg = args.nextIfPresent();
            // Traverse through the possible arguments. We can't really complete arbitrary integers
            if (arg.isPresent()) {
                if (arg.get().startsWith("#")) {
                    return SPECIAL_TOKENS.stream().filter(new StartsWithPredicate(arg.get())).collect(GuavaCollectors.toImmutableList());
                } else if (arg.get().contains(",") || !args.hasNext()) {
                    return ImmutableList.of(arg.get());
                } else {
                    arg = args.nextIfPresent();
                    if (args.hasNext()) {
                        return ImmutableList.of(args.nextIfPresent().get());
                    } else {
                        return ImmutableList.of(arg.get());
                    }
                }
            } else {
                return ImmutableList.of();
            }
        }

        private double parseRelativeDouble(CommandArgs args, String arg, @Nullable Double relativeTo) throws ArgumentParseException {
            boolean relative = arg.startsWith("~");
            if (relative) {
                if (relativeTo == null) {
                    throw args.createError(t("Relative position specified but source does not have a postion"));
                }
                arg = arg.substring(1);
                if (arg.isEmpty()) {
                    return relativeTo;
                }
            }
            try {
                double ret = Double.parseDouble(arg);
                return relative ? ret + relativeTo : ret;
            } catch (NumberFormatException e) {
                throw args.createError(t("Expected input %s to be a double, but was not", arg));
            }
        }
    }

    /**
     * Listens to:
     * <ul>
     *     <li>#spawn:&lt;world></li>
     *     <li>#me: Location of the current source</li>
     * </ul>
     */
    private static class LocationCommandElement extends CommandElement.Value<Location> {
        private final WorldPropertiesCommandElement worldParser;
        private final Vector3dCommandElement vectorParser;

        protected LocationCommandElement(Text key) {
            super(key);
            this.worldParser = new WorldPropertiesCommandElement(null);
            this.vectorParser = new Vector3dCommandElement(null);
        }

        @Override
        protected Location parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            Object state = args.getState();
            Object world;
            Object vec = null;
            try {
                world = checkNotNull(this.worldParser.parseValue(source, args), "worldVal");
            } catch (ArgumentParseException ex) {
                args.setState(state);
                if (!(source instanceof LocatedSource)) {
                    throw args.createError(t("Source must have a location in order to have a fallback world"));
                }
                world = ((LocatedSource) source).getWorld().getProperties();
                try {
                    vec = checkNotNull(this.vectorParser.parseValue(source, args), "vectorVal");
                } catch (ArgumentParseException ex2) {
                    args.setState(state);
                    throw ex;
                }
            }
            if (vec == null) {
                vec = checkNotNull(this.vectorParser.parseValue(source, args), "vectorVal");
            }

            if (world instanceof Collection<?>) {
                // multiple values
                if (((Collection<?>) world).size() != 1) {
                    throw args.createError(t("A location must be specified in only one world!"));
                }
                world = ((Collection<?>) world).iterator().next();
            }
            WorldProperties targetWorldProps = ((WorldProperties) world);
            Optional<World> targetWorld = Sponge.getGame().getServer().getWorld(targetWorldProps.getUniqueId());
            Vector3d vector = (Vector3d) vec;
            return new Location<>(targetWorld.get(), vector);
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            Object state = args.getState();
            List<String> ret;
            if ((ret = this.worldParser.complete(src, args, context)).isEmpty()) {
                args.setState(state);
                ret = this.vectorParser.complete(src, args, context);
            }
            return ret;
        }
    }

    private static class CatalogedTypeCommandElement<T extends CatalogType> extends PatternMatchingCommandElement<T> {
        private final Class<T> catalogType;

        protected CatalogedTypeCommandElement(Text key, Class<T> catalogType) {
            super(key);
            this.catalogType = catalogType;
        }

        @Override
        protected Iterable<String> getChoices(CommandSource source) {
            return Sponge.getGame().getRegistry().getAllOf(this.catalogType).stream()
                .<String>map(input -> {
                    return input == null ? null : input.getId(); // TODO: ids or names?
                })
                .collect(Collectors.toList());
        }

        @Override
        protected T getValue(String choice) throws IllegalArgumentException {
            final Optional<T> ret = Sponge.getGame().getRegistry().getType(this.catalogType, choice);
            if (!ret.isPresent()) {
                throw new IllegalArgumentException("Invalid input " + choice + " was found");
            }
            return ret.get();
        }
    }

    /**
     * Restricts the given command element to only insert one value into the context at the provided key.
     *
     * @param element The element to restrict
     * @return the restricted element
     */
    public static <T> CommandElement.Value<T> onlyOne(CommandElement.Value<? extends Collection<? extends T>> element) {
        return new OnlyOneCommandElement<>(element);
    }

    private static class OnlyOneCommandElement<T> extends CommandElement.Value<T> {
        private final CommandElement.Value<? extends Iterable<? extends T>> element;

        protected OnlyOneCommandElement(CommandElement.Value<? extends Collection<? extends T>> element) {
            super(element.getKey());
            this.element = element;
        }

        /*@Override
        public void parse(CommandSource source, CommandArgs args, CommandContext context) throws ArgumentParseException {
            this.element.parse(source, args, context);
            if (context.get(this.element).size() > 1) {
                throw args.createError(t("Argument %s may have only one value!",  this.element.getKey()));
            }
        }*/

        @Override
        public Text getUsage(CommandSource src) {
            return this.element.getUsage(src);
        }

        @Override
        protected T parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            Iterable<? extends T> iterable = this.element.parseValue(source, args);
            Iterator<? extends T> iter = iterable.iterator();
            if (!iter.hasNext()) {
                throw args.createError(t("Argument %s may have only one value!",  this.element.getKey()));
            }
            T ret = iter.next();
            if (iter.hasNext()) {
                throw args.createError(t("Argument %s may have only one value!", this.element.getKey()));
            }
            return ret;
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            return this.element.complete(src, args, context);
        }
    }

    /**
     * Checks a permission for a given command argument to be used.
     *
     * @param element The element to wrap
     * @param permission The permission to check
     * @return the element
     */
    public static CommandElement requiringPermission(CommandElement element, String permission) {
        return new PermissionCommandElement(element, permission);
    }

    private static class PermissionCommandElement extends CommandElement {
        private final CommandElement element;
        private final String permission;

        protected PermissionCommandElement(CommandElement element, String permission) {
            this.element = element;
            this.permission = permission;
        }

        private void checkPermission(CommandSource source, CommandArgs args) throws ArgumentParseException {
            if (!source.hasPermission(this.permission)) {
                if (element instanceof CommandElement.Value<?>) {
                    throw args.createError(t("You do not have permission to use the %s argument", ((Value<?>) element).getKey()));
                } else {
                    throw args.createError(t("You do not have permission to use this argument"));

                }
            }
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            if (!src.hasPermission(this.permission)) {
                return ImmutableList.of();
            }
            return this.element.complete(src, args, context);
        }

        @Override
        public void parse(CommandSource source, CommandArgs args, CommandContext context) throws ArgumentParseException {
            checkPermission(source, args);
            this.element.parse(source, args, context);
        }

        @Override
        public Text getUsage(CommandSource src) {
            return this.element.getUsage(src);
        }
    }
}
