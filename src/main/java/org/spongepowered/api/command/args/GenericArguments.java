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
import com.flowpowered.math.vector.Vector3i;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import org.apache.commons.lang3.StringUtils;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandMessageFormatting;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.source.ProxySource;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.service.user.UserStorageService;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.selector.Selector;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.util.GuavaCollectors;
import org.spongepowered.api.util.RelativeDouble;
import org.spongepowered.api.util.RelativeVector3d;
import org.spongepowered.api.util.StartsWithPredicate;
import org.spongepowered.api.util.blockray.BlockRay;
import org.spongepowered.api.util.blockray.BlockRayHit;
import org.spongepowered.api.world.DimensionType;
import org.spongepowered.api.world.Locatable;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.storage.WorldProperties;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


/**
 * Class containing factory methods for common command elements.
 */
public final class GenericArguments {

    private static final CommandElement NONE = new CommandElement(null) {
        @Nullable
        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            return null;
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            return NullCompletionList.INSTANCE;
        }
    };

    private GenericArguments() {}

    /**
     * Expects no arguments.
     *
     * @return An expectation of no arguments
     */
    public static CommandElement none() {
        return NONE;
    }

    static CommandElement markTrue(String flag) {
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
    public static CommandElement playerOrSource(Text key) {
        return new PlayerCommandElement(key, true);
    }

    /**
     * Expect an argument to represent an online player.
     * Gives value of type {@link Player}
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement player(Text key) {
        return new PlayerCommandElement(key, false);
    }

    /**
     * Expect an argument to represent a player who has been online at some point, as a {@link User}
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement user(Text key) {
        return new UserCommandElement(key, false);
    }

	/**
	 * Expect an argument to represent a player who has been online at some point,
	 * as a {@link User}, or if nothing matches and the source is a {@link User},
	 * give the user. If nothing matches and the source is not a {@link User}, throw
	 * an exception.
	 *
	 * @param key The key to store under
	 * @return the argument
	 */
	public static CommandElement userOrSource(Text key) {
		return new UserCommandElement(key, true);
	}

    /**
     * Expect an argument to represent a world. This gives a WorldProperties object rather than an actual world in order to include unloaded worlds
     * as well
     * Gives values of type {@link WorldProperties}
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement world(Text key) {
        return new WorldPropertiesCommandElement(key);
    }

    /**
     * Expect an argument to represent a dimension.
     * Gives values of tye {@link DimensionType}
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement dimension(Text key) {
        return catalogedElement(key, DimensionType.class);
    }

    /**
     * Expect an argument to represent a {@link Vector3d}.
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement vector3d(Text key) {
        return new Vector3dCommandElement(key, false, false);
    }

    /**
     * Expect an argument to represent a {@link Vector3d}. Positions
     * support relative values, special tokens and tab completation.
     * The position can also be completed based on the block you have
     * selected.
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement targetedBlockPosition(Text key) {
        return new Vector3dCommandElement(key, true, true);
    }

    /**
     * Expect an argument to represent a {@link Vector3d}. Positions
     * support relative values, special tokens and tab completation.
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement position(Text key) {
        return new Vector3dCommandElement(key, false, true);
    }

    /**
     * Expect an argument to represent a {@link RelativeVector3d}. Positions
     * support relative values, special tokens and tab completation.
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement relativePosition(Text key) {
        return new RelativeVector3dCommandElement(key, false, true);
    }

    /**
     * Expect an argument to represent a {@link RelativeVector3d}. Positions
     * support relative values, special tokens and tab completation. The position
     * can also be completed based on the block you have selected.
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement targetedBlockRelativePosition(Text key) {
        return new RelativeVector3dCommandElement(key, true, true);
    }

    /**
     * Expect an argument to represent a {@link Location}.
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement location(Text key) {
        return new LocationCommandElement(key, false);
    }

    /**
     * Expect an argument to represent a {@link Location}. The location
     * can also be tab completed based on the block you have selected.
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement targetedBlockLocation(Text key) {
        return new LocationCommandElement(key, true);
    }

    /**
     * Expect an argument that is a member of the specified dummy type T.
     *
     * @param key The key to store the resolved value under
     * @param catalogType The type expected
     * @param <T> The type to return
     * @return the argument
     */
    public static <T extends CatalogType> CommandElement catalogedElement(Text key, Class<T> catalogType) {
        return new CatalogedTypeCommandElement<>(key, catalogType);
    }

    /**
     * Expect an argument to represent a {@link PluginContainer}'s id.
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement plugin(Text key) {
        return new PluginCommandElement(key);
    }

    private static class PluginCommandElement extends PatternMatchingCommandElement {

        protected PluginCommandElement(@Nullable Text key) {
            super(key);
        }

        @Override
        protected Iterable<String> getChoices(CommandSource source) {
            return Sponge.getPluginManager().getPlugins().stream().map(PluginContainer::getId).collect(Collectors.toList());
        }

        @Override
        protected Object getValue(String choice) throws IllegalArgumentException {
            Optional<PluginContainer> plugin = Sponge.getPluginManager().getPlugin(choice);
            return plugin.orElseThrow(() -> new IllegalArgumentException("Plugin " + choice + " was not found"));
        }
    }

    static class MarkTrueCommandElement extends CommandElement {
        public MarkTrueCommandElement(String flag) {
            super(Text.of(flag));
        }

        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
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

        SequenceCommandElement(List<CommandElement> elements) {
            super(null);
            this.elements = elements;
        }

        @Override
        public void parse(CommandSource source, CommandArgs args, CommandContext context) throws ArgumentParseException {
            for (CommandElement element : this.elements) {
                element.parse(source, args, context);
            }
        }

        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            return null;
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            for (CommandElement element : this.elements) {
                Object startState = args.getState();
                try {
                    element.parse(src, args, context);
                    Object endState = args.getState();
                    if (!args.hasNext()) {
                        args.setState(startState);
                        List<String> ret = element.complete(src, args, context);
                        args.previous();
                        if (ret != NullCompletionList.INSTANCE && !ret.contains(args.next())) {
                            // Tab complete returns results to complete the last word in an argument.
                            // If the last word is one of the completions, the command is most likely complete
                            return ret;
                        }
                        args.setState(endState);
                    }
                } catch (ArgumentParseException e) {
                    args.setState(startState);
                    List<String> ret = element.complete(src, args, context);
                    if (ret != NullCompletionList.INSTANCE) {
                        return ret;
                    }
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

        ChoicesCommandElement(Text key, Map<String, Object> choices, boolean choicesInUsage) {
            super(key);
            this.choices = choices;
            this.choicesInUsage = choicesInUsage;
        }

        @Override
        public Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            Object value = this.choices.get(args.next());
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

        FirstParsingCommandElement(List<CommandElement> elements) {
            super(null);
            this.elements = elements;
        }

        @Override
        public void parse(CommandSource source, CommandArgs args, CommandContext context) throws ArgumentParseException {
            ArgumentParseException lastException = null;
            final CommandArgs.Snapshot argsSnapshot = args.createSnapshot();
            final CommandContext.Snapshot contextSnapshot = context.createSnapshot();
            for (CommandElement element : this.elements) {
                try {
                    element.parse(source, args, context);
                    return;
                } catch (ArgumentParseException ex) {
                    lastException = ex;
                    args.restoreSnapshot(argsSnapshot);
                    context.restoreSnapshot(contextSnapshot);
                }
            }
            if (lastException != null) {
                throw lastException;
            }
        }

        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            return null;
        }

        @Override
        public List<String> complete(final CommandSource src, final CommandArgs args, final CommandContext context) {
            final CommandArgs.Snapshot argsSnapshot = args.createSnapshot();
            final List<CommandElement> elements = new ArrayList<>();
            int chainStart = (int) args.getState();
            int longestChain = -1;
            for (CommandElement element : this.elements) {
                try {
                    element.parse(src, args, context);
                } catch (ArgumentParseException ex) {
                    int chainEnd = (Integer) args.getState();
                    int chain = chainEnd - chainStart;
                    if (chain > longestChain) {
                        elements.clear();
                        elements.add(element);
                        longestChain = chain;
                    } else if (chain == longestChain) {
                        elements.add(element);
                    }
                }
                args.restoreSnapshot(argsSnapshot);
            }
            if (!elements.isEmpty()) {
                final List<String> ret0 = new ArrayList<>();
                for (Iterator<CommandElement> it = elements.iterator(); it.hasNext(); ) {
                    final CommandElement element = it.next();

                    final List<String> ret = element.complete(src, args, context);
                    ret0.addAll(ret);

                    if (it.hasNext()) {
                        args.restoreSnapshot(argsSnapshot);
                    }
                }
                return ImmutableList.copyOf(ret0);
            }
            return ImmutableList.of();
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
        @Nullable
        private final Object value;
        private final boolean considerInvalidFormatEmpty;

        OptionalCommandElement(CommandElement element, @Nullable Object value, boolean considerInvalidFormatEmpty) {
            super(null);
            this.element = element;
            this.value = value;
            this.considerInvalidFormatEmpty = considerInvalidFormatEmpty;
        }

        @Override
        public void parse(CommandSource source, CommandArgs args, CommandContext context) throws ArgumentParseException {
            if (!args.hasNext()) {
                Text key = this.element.getKey();
                if (key != null && this.value != null) {
                    context.putArg(key.toPlain(), this.value);
                }
                return;
            }
            Object startState = args.getState();
            try {
                this.element.parse(source, args, context);
            } catch (ArgumentParseException ex) {
                if (this.considerInvalidFormatEmpty || args.hasNext()) { // If there are more args, suppress. Otherwise, throw the error
                    args.setState(startState);
                    if (this.element.getKey() != null && this.value != null) {
                        context.putArg(this.element.getUntranslatedKey(), this.value);
                    }
                } else {
                    throw ex;
                }
            }
        }

        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            return args.hasNext() ? null : this.element.parseValue(source, args);
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            List<String> ret = this.element.complete(src, args, context);
            return ret.isEmpty() ? NullCompletionList.INSTANCE : ret;
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
            super(null);
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
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            return null;
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
            super(null);
            this.element = element;
        }

        @Override
        public void parse(CommandSource source, CommandArgs args, CommandContext context) throws ArgumentParseException {
            while (args.hasNext()) {
                this.element.parse(source, args, context);
            }
        }

        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            return null;
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
     * Require an argument to be a string. Any provided argument will fit in under this argument.
     * Gives values of type {@link String}.
     *
     * @param key The key to store the parsed argument under
     * @return the element to match the input
     */
    public static CommandElement string(Text key) {
        return new StringElement(key);
    }

    private static class StringElement extends KeyElement {

        StringElement(Text key) {
            super(key);
        }

        @Override
        public Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
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
    public static CommandElement integer(Text key) {
        return new NumericElement<>(key, Integer::parseInt, Integer::parseInt, input -> t("Expected an integer, but input '%s' was not", input));
    }

    private static class NumericElement<T extends Number> extends KeyElement {
        private final Function<String, T> parseFunc;
        @Nullable
        private final BiFunction<String, Integer, T> parseRadixFunction;
        private final Function<String, Text> errorSupplier;

        protected NumericElement(Text key, Function<String, T> parseFunc, @Nullable BiFunction<String, Integer, T> parseRadixFunction,
                Function<String, Text> errorSupplier) {
            super(key);
            this.parseFunc = parseFunc;
            this.parseRadixFunction = parseRadixFunction;
            this.errorSupplier = errorSupplier;
        }

        @Override
        public Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            final String input = args.next();
            try {
                if (this.parseRadixFunction != null) {
                    if (input.startsWith("0x")) {
                        return this.parseRadixFunction.apply(input.substring(2), 16);
                    } else if (input.startsWith("0b")) {
                        return this.parseRadixFunction.apply(input.substring(2), 2);
                    }
                }
                return this.parseFunc.apply(input);
            } catch (NumberFormatException ex) {
                throw args.createError(this.errorSupplier.apply(input));
            }
        }
    }

    /**
     * Require an argument to be a long (base 10).
     * Gives values of type {@link Integer}
     *
     * @param key The key to store the parsed argument under
     * @return the element to match the input
     */
    public static CommandElement longNum(Text key) {
        return new NumericElement<>(key, Long::parseLong, Long::parseLong, input -> t("Expected a long, but input '%s' was not", input));
    }

    /**
     * Require an argument to be an double-precision floating point number.
     * Gives values of type {@link Double}
     *
     * @param key The key to store the parsed argument under
     * @return the element to match the input
     */
    public static CommandElement doubleNum(Text key) {
        return new NumericElement<>(key, Double::parseDouble, null, input -> t("Expected a number, but input '%s' was not", input));
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
    public static CommandElement bool(Text key) {
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
    public static <T extends Enum<T>> CommandElement enumValue(Text key, Class<T> type) {
        return new EnumValueElement<>(key, type);
    }

    private static class EnumValueElement<T extends Enum<T>> extends PatternMatchingCommandElement {
        private final Map<String, T> choices;

        EnumValueElement(Text key, Class<T> type) {
            super(key);
            final ImmutableMap.Builder<String, T> builder = ImmutableMap.builder();
            for (T value : type.getEnumConstants()) {
                builder.put(value.name().toLowerCase(), value);
            }
            this.choices = builder.build();
        }

        @Override
        protected Iterable<String> getChoices(CommandSource source) {
            return this.choices.values().stream()
                .map(Enum::name)
                .collect(Collectors.toList());
        }

        @Override
        protected Object getValue(String choice) throws IllegalArgumentException {
            return this.choices.get(choice.toLowerCase());
        }
    }

    /**
     * Require one or more strings, which are combined into a single, space-separated string.
     * Gives values of type {@link String}
     *
     * @param key The key to store the parsed argument under
     * @return the element to match the input
     */
    public static CommandElement remainingJoinedStrings(Text key) {
        return new RemainingJoinedStringsCommandElement(key, false);
    }

    private static class RemainingJoinedStringsCommandElement extends KeyElement {
        private final boolean raw;

        RemainingJoinedStringsCommandElement(Text key, boolean raw) {
            super(key);
            this.raw = raw;
        }

        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
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
    public static CommandElement literal(Text key, String... expectedArgs) {
        return new LiteralCommandElement(key, ImmutableList.copyOf(expectedArgs), true);
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
    public static CommandElement literal(Text key, @Nullable Object putValue, String... expectedArgs) {
        return new LiteralCommandElement(key, ImmutableList.copyOf(expectedArgs), putValue);
    }

    private static class LiteralCommandElement extends CommandElement {
        private final List<String> expectedArgs;
        @Nullable
        private final Object putValue;

        protected LiteralCommandElement(@Nullable Text key, List<String> expectedArgs, @Nullable Object putValue) {
            super(key);
            this.expectedArgs = ImmutableList.copyOf(expectedArgs);
            this.putValue = putValue;
        }

        @Nullable
        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
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

    private static class UserCommandElement extends PatternMatchingCommandElement {

        private final PlayerCommandElement possiblePlayer;
        private final boolean returnSource;

        protected UserCommandElement(@Nullable Text key, boolean returnSource) {
            super(key);
            this.possiblePlayer = new PlayerCommandElement(key, returnSource);
            this.returnSource = returnSource;
        }

        @Nullable
        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            Object state = args.getState();
            try {
                return this.possiblePlayer.parseValue(source, args);
            } catch (ArgumentParseException ex) {
                args.setState(state);
                try {
                    return super.parseValue(source, args);
                } catch (ArgumentParseException ex2) {
                    if (this.returnSource && source instanceof User) {
                        return source;
                    } else {
                        throw ex2;
                    }
                }
            }
        }

        @Override
        protected Iterable<String> getChoices(CommandSource source) {
            return Sponge.getGame().getServiceManager().provideUnchecked(UserStorageService.class).getAll().stream()
                    .map(GameProfile::getName)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(GuavaCollectors.toImmutableList());
        }

        @Override
        protected Object getValue(String choice) throws IllegalArgumentException {
            return Sponge.getGame().getServiceManager().provideUnchecked(UserStorageService.class).get(choice).get();
        }
    }

    private static class PlayerCommandElement extends SelectorCommandElement {

        private final boolean returnSource;

        protected PlayerCommandElement(Text key, boolean returnSource) {
            super(key);
            this.returnSource = returnSource;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            if (!args.hasNext() && this.returnSource) {
                return tryReturnSource(source, args);
            }

            Object state = args.getState();
            try {
                return Iterables.filter((Iterable<Entity>)super.parseValue(source, args), e -> e instanceof Player);
            } catch (ArgumentParseException ex) {
                if (this.returnSource) {
                    args.setState(state);
                    return tryReturnSource(source, args);
                } else {
                    throw ex;
                }
            }
        }

        @Override
        protected Iterable<String> getChoices(CommandSource source) {
            return Sponge.getGame().getServer().getOnlinePlayers().stream()
                .map(CommandSource::getName)
                .collect(Collectors.toList());
        }

        @Override
        protected Object getValue(String choice) throws IllegalArgumentException {
            Optional<Player> ret = Sponge.getGame().getServer().getPlayer(choice);
            if (!ret.isPresent()) {
                throw new IllegalArgumentException("Input value " + choice + " was not a player");
            }
            return ret.get();
        }

        private Player tryReturnSource(CommandSource source, CommandArgs args) throws ArgumentParseException {
            if (source instanceof Player) {
                return ((Player) source);
            } else if (source instanceof ProxySource && ((ProxySource) source).getOriginalSource() instanceof Player) {
                return (Player) ((ProxySource) source).getOriginalSource();
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
     * Accepted formats:
     *
     * <ul>
     *     <li>#first</li>
     *     <li>#&lt;dimension></li>
     *     <li>&lt;name></li>
     *     <li>#me</li>
     * </ul>
     */
    private static class WorldPropertiesCommandElement extends PatternMatchingCommandElement {
        private final CommandElement dimensionTypeElement;

        protected WorldPropertiesCommandElement(@Nullable Text key) {
            super(key);
            this.dimensionTypeElement = onlyOne(catalogedElement(key, DimensionType.class));
        }

        @Nullable
        private Object parseValue0(CommandSource source, CommandArgs args)
                throws ArgumentParseException {
            final String next = args.peek();
            if (next.startsWith("#")) {
                String specifier = next.substring(1);
                if (specifier.equalsIgnoreCase("first")) {
                    args.next();
                    return Sponge.getGame().getServer().getAllWorldProperties().stream()
                            .filter(WorldProperties::isEnabled)
                            .collect(Collectors.toList()).iterator().next();
                } else if (specifier.equalsIgnoreCase("me") && source instanceof Locatable) {
                    args.next();
                    return ((Locatable) source).getWorld().getProperties();
                } else {
                    boolean firstOnly = false;
                    if (specifier.endsWith(":first")) {
                        firstOnly = true;
                        specifier = specifier.substring(0, specifier.length() - 6);
                    }
                    args.next();
                    args.insertArg(specifier);
                    @SuppressWarnings("unchecked")
                    final Object dimensionValue = this.dimensionTypeElement.parseValue(source, args);
                    final DimensionType type = ((Iterable<DimensionType>) dimensionValue).iterator().next();
                    Iterable<WorldProperties> ret = Sponge.getGame().getServer().getAllWorldProperties().stream()
                            .filter(input -> input.isEnabled() && input.getDimensionType().equals(type))
                            .collect(Collectors.toList());
                    return firstOnly ? ret.iterator().next() : ret;
                }
            }
            return null;
        }

        @Nullable
        @Override
        public Object parseValueExact(CommandSource source, CommandArgs args) throws ArgumentParseException {
            Object value = this.parseValue0(source, args);
            return value == null ? super.parseValueExact(source, args) : value;
        }

        @Nullable
        @Override
        public Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            Object value = this.parseValue0(source, args);
            return value == null ? super.parseValue(source, args) : value;
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            if (args.hasNext()) {
                final String arg = args.nextIfPresent().get();
                return ImmutableList.copyOf(Iterables.filter(getCompletionChoices(src),
                        input -> getFormattedPattern(arg).matcher(input).find()));
            }
            return Collections.emptyList();
        }

        protected Iterable<String> getCompletionChoices(CommandSource source) {
            return Iterables.concat(getChoices(source), ImmutableSet.of("#first", "#me"),
                    Iterables.transform(Sponge.getGame().getRegistry()
                            .getAllOf(DimensionType.class), input2 -> "#" + input2.getId()));
        }

        @Override
        protected Iterable<String> getChoices(CommandSource source) {
            return Sponge.getGame().getServer().getAllWorldProperties().stream()
                    .filter(WorldProperties::isEnabled)
                    .map(WorldProperties::getWorldName)
                    .collect(Collectors.toList());
        }

        @Override
        protected Object getValue(String choice) throws IllegalArgumentException {
            Optional<WorldProperties> ret = Sponge.getGame().getServer().getWorldProperties(choice);
            if (!ret.isPresent()) {
                throw new IllegalArgumentException("Provided argument " + choice + " did not match a WorldProperties");
            }
            return ret.get();
        }
    }

    /**
     * This element is used for multiple purposes:
     * - Regular vectors with 3 components
     * - Position vectors with 3 components that support
     *   relative values, position tab completion.
     *
     * Syntax:
     * x,y,z
     * x y z.
     * each element can be relative to a location? so parseRelativeDouble() -- relative is ~(num)
     *
     */
    private static class RelativeVector3dCommandElement extends CommandElement {
        private static final ImmutableSet<String> SPECIAL_TOKENS = ImmutableSet.of("#target", "#me");

        private final boolean targetBlockTabCompletion;
        private final boolean parsePosition; // Whether this element is used to parse positions

        protected RelativeVector3dCommandElement(@Nullable Text key,
                boolean targetBlockTabComplete, boolean parsePosition) {
            super(key);
            this.targetBlockTabCompletion = targetBlockTabComplete;
            this.parsePosition = parsePosition;
        }

        private String getName() {
            if (!this.parsePosition) {
                final String name = this.getUntranslatedKey();
                return name == null ? "vector" : name;
            } else {
                return "position";
            }
        }

        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            String xStr;
            String yStr;
            String zStr;
            xStr = args.next();
            if (xStr.contains(",")) {
                String[] split = xStr.split(",");
                if (split.length != 3) {
                    throw args.createError(t("Comma-separated %s must have 3 elements, not %s", getName(), split.length));
                }
                xStr = split[0];
                yStr = split[1];
                zStr = split[2];
            } else if (this.parsePosition && xStr.equals("#target") && source instanceof Entity) {
                Optional<BlockRayHit<World>> hit = BlockRay.from(((Entity) source)).filter(BlockRay.onlyAirFilter()).build().end();
                if (!hit.isPresent()) {
                    throw args.createError(t("No target block is available! Stop stargazing!"));
                }
                return new RelativeVector3d(hit.get().getPosition());
            } else if (this.parsePosition && xStr.equalsIgnoreCase("#me") && source instanceof Locatable) {
                return new RelativeVector3d(((Locatable) source).getLocation().getPosition());
            } else {
                yStr = args.next();
                zStr = args.next();
            }
            final RelativeDouble x = parseRelativeDouble(args, xStr);
            final RelativeDouble y = parseRelativeDouble(args, yStr);
            final RelativeDouble z = parseRelativeDouble(args, zStr);

            return new RelativeVector3d(x, y, z);
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            Optional<String> optArg = args.nextIfPresent();
            // Traverse through the possible arguments. We can't really complete arbitrary integers
            if (optArg.isPresent()) {
                String arg = optArg.get();
                if (this.parsePosition && arg.startsWith("#")) {
                    return SPECIAL_TOKENS.stream().filter(new StartsWithPredicate(arg))
                            .collect(GuavaCollectors.toImmutableList());
                } else if (arg.contains(",")) {
                    final int parts = arg.split(",", -1).length;
                    final int index = arg.lastIndexOf(',');

                    final Location<World> pos = this.targetBlockTabCompletion ?
                            context.<Location<World>>getOne(CommandContext.TARGET_BLOCK_ARG).orElse(null) : null;
                    final String prefix = arg.substring(0, index + 1);
                    switch (parts) {
                        case 1:
                            return this.getCommaSeparatedCompletion(src, Location::getX, prefix, pos);
                        case 2:
                            return this.getCommaSeparatedCompletion(src, Location::getY, prefix, pos);
                        case 3:
                            return this.getCommaSeparatedCompletion(src, Location::getZ, prefix, pos);
                    }
                } else {
                    if ((optArg = args.nextIfPresent()).isPresent()) {
                        final Optional<String> optArg1 = args.nextIfPresent();
                        if (optArg1.isPresent()) {
                            return this.getCompletion(src, context, Location::getZ, optArg1.get());
                        }
                        return this.getCompletion(src, context, Location::getY, optArg.get());
                    } else {
                        return this.getCompletion(src, context, Location::getX, arg);
                    }
                }
                return ImmutableList.of(arg);
            } else {
                return ImmutableList.of();
            }
        }

        private List<String> getCommaSeparatedCompletion(CommandSource src,
                Function<Location<World>, Double> function, String prefix, @Nullable Location<World> pos) {
            if (!this.parsePosition) {
                return ImmutableList.of("");
            }
            return ImmutableList.of(prefix + (pos != null ? Double.toString(function.apply(pos)) :
                    src instanceof Locatable ? "~" : ""));
        }

        private List<String> getCompletion(CommandSource src, CommandContext context,
                Function<Location<World>, Double> function, String arg) {
            if (!this.parsePosition) {
                return ImmutableList.of("");
            }
            final Optional<Location<World>> pos = this.targetBlockTabCompletion ?
                    context.<Location<World>>getOne(CommandContext.TARGET_BLOCK_ARG) : Optional.empty();
            return pos.isPresent() ? ImmutableList.of(Double.toString(function.apply(pos.get()))) :
                    src instanceof Locatable && arg.isEmpty() ? ImmutableList.of("~") : ImmutableList.of(arg);
        }

        private RelativeDouble parseRelativeDouble(CommandArgs args, String arg)
                throws ArgumentParseException {
            boolean relative = arg.startsWith("~");
            if (this.parsePosition && relative) {
                throw args.createError(t("%s doesn't support relative values.", getName()));
            }
            if (relative) {
                arg = arg.substring(1);
                if (arg.isEmpty()) {
                    return RelativeDouble.ZERO_RELATIVE;
                }
            }
            try {
                double ret = Double.parseDouble(arg);
                return new RelativeDouble(ret, relative);
            } catch (NumberFormatException e) {
                throw args.createError(t("Expected input %s to be a double, but was not", arg));
            }
        }
    }

    /**
     * Syntax:
     * x,y,z
     * x y z.
     * each element can be relative to a location? so parseRelativeDouble() -- relative is ~(num)
     *
     */
    private static class Vector3dCommandElement extends CommandElement {
        private final RelativeVector3dCommandElement element;

        protected Vector3dCommandElement(@Nullable Text key, boolean targetBlockTabComplete, boolean parsePosition) {
            super(key);
            this.element = new RelativeVector3dCommandElement(key, targetBlockTabComplete, parsePosition);
        }

        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            final RelativeVector3d relativeVector3d = (RelativeVector3d) this.element.parseValue(source, args);
            if (relativeVector3d == null) {
                return null;
            }
            if (relativeVector3d.isRelative()) { // Always false for regular vectors
                if (!(source instanceof Locatable)) {
                    throw args.createError(t("Relative position specified but source does not have a position"));
                }
                return relativeVector3d.applyToValue(((Locatable) source).getLocation().getPosition());
            }
            return relativeVector3d.applyToValue(Vector3d.ZERO);
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            return this.element.complete(src, args, context);
        }
    }

    /**
     * Listens to:
     * <ul>
     *     <li>#spawn:&lt;world></li>
     *     <li>#me: Location of the current source</li>
     * </ul>
     */
    private static class LocationCommandElement extends CommandElement {
        private final WorldPropertiesCommandElement worldParser;
        private final Vector3dCommandElement vectorParser;

        protected LocationCommandElement(Text key, boolean targetBlockTabCompletion) {
            super(key);
            this.worldParser = new WorldPropertiesCommandElement(null);
            this.vectorParser = new Vector3dCommandElement(null, targetBlockTabCompletion, true);
        }

        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            Object state = args.getState();
            if (args.peek().startsWith("@")) { // We are a selector
                return Selector.parse(args.next()).resolve(source).stream()
                        .map(Entity::getLocation)
                        .collect(GuavaCollectors.toImmutableSet());
            }

            Object world;
            Object vec = null;
            try {
                world = checkNotNull(this.worldParser.parseValue(source, args), "worldVal");
            } catch (ArgumentParseException ex) {
                args.setState(state);
                if (!(source instanceof Locatable)) {
                    throw args.createError(t("Source must have a location in order to have a fallback world"));
                }
                world = ((Locatable) source).getWorld().getProperties();
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
            Optional<String> nextPossibility = args.nextIfPresent();
            if (nextPossibility.isPresent() && nextPossibility.get().startsWith("@")) {
                return Selector.complete(nextPossibility.get());
            } else {
                args.setState(state);
                List<String> ret;
                if ((ret = this.worldParser.complete(src, args, context)).isEmpty()) {
                    args.setState(state);
                    ret = this.vectorParser.complete(src, args, context);
                }
                return ret;
            }
        }
    }

    private static class CatalogedTypeCommandElement<T extends CatalogType> extends PatternMatchingCommandElement {
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
        protected Object getValue(String choice) throws IllegalArgumentException {
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
    public static CommandElement onlyOne(CommandElement element) {
        return new OnlyOneCommandElement(element);
    }

    private static class OnlyOneCommandElement extends CommandElement {
        private final CommandElement element;

        protected OnlyOneCommandElement(CommandElement element) {
            super(element.getKey());
            this.element = element;
        }

        @Override
        public void parse(CommandSource source, CommandArgs args, CommandContext context) throws ArgumentParseException {
            this.element.parse(source, args, context);
            if (context.getAll(this.element.getUntranslatedKey()).size() > 1) {
                Text key = this.element.getKey();
                throw args.createError(t("Argument %s may have only one value!", key != null ? key : t("unknown")));
            }
        }

        @Override
        public Text getUsage(CommandSource src) {
            return this.element.getUsage(src);
        }

        @Nullable
        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            return this.element.parseValue(source, args);
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
            super(element.getKey());
            this.element = element;
            this.permission = permission;
        }

        @Nullable
        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            checkPermission(source, args);
            return this.element.parseValue(source, args);
        }

        private void checkPermission(CommandSource source, CommandArgs args) throws ArgumentParseException {
            if (!source.hasPermission(this.permission)) {
                Text key = getKey();
                throw args.createError(t("You do not have permission to use the %s argument", key != null ? key : t("unknown")));
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

    public static CommandElement entity(Text key) {
        return new EntityCommandElement(key, false);
    }

    public static CommandElement entityOrSource(Text key) {
        return new EntityCommandElement(key, true);
    }

    private static class EntityCommandElement extends SelectorCommandElement {

        private final boolean returnSource;

        protected EntityCommandElement(Text key, boolean returnSource) {
            super(key);
            this.returnSource = returnSource;
        }

        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            if (!args.hasNext() && this.returnSource) {
                return tryReturnSource(source, args);
            }

            Object state = args.getState();
            try {
                return super.parseValue(source, args);
            } catch (ArgumentParseException ex) {
                if (this.returnSource) {
                    args.setState(state);
                    return tryReturnSource(source, args);
                } else {
                    throw ex;
                }
            }
        }

        @Override
        protected Iterable<String> getChoices(CommandSource source) {
            Set<Iterable<Entity>> worldEntities = Sponge.getServer().getWorlds().stream().map(World::getEntities).collect(Collectors.toSet());
            return Iterables.transform(Iterables.concat(worldEntities), input -> {
                if (input == null) {
                    return null;
                }
                if (input instanceof Player) {
                    return ((Player)input).getName();
                }
                return input.getUniqueId().toString();
            });
        }

        @Override
        protected Object getValue(String choice) throws IllegalArgumentException {
            UUID uuid = UUID.fromString(choice);
            for (World world : Sponge.getServer().getWorlds()) {
                Optional<Entity> ret = world.getEntity(uuid);
                if (ret.isPresent()) {
                    return ret.get();
                }
            }
            throw new IllegalArgumentException("Input value " + choice + " was not an entity");
        }

        private static Entity tryReturnSource(CommandSource source, CommandArgs args) throws ArgumentParseException {
            if (source instanceof Entity) {
                return (Entity) source;
            } else if (source instanceof ProxySource && ((ProxySource) source).getOriginalSource() instanceof Entity) {
                return (Entity) ((ProxySource) source).getOriginalSource();
            } else {
                throw args.createError(t("No entities matched and source was not an entity!"));
            }
        }

        @Override
        public Text getUsage(CommandSource src) {
            return src instanceof Player && this.returnSource ? Text.of("[", super.getUsage(src), "]") : super.getUsage(src);
        }
    }

    /**
     * Gives a {@link Color}, the color can be parsed
     * in 3 different formats: literal which will match
     * some inbuilt mappings, rgb which will use 3 components
     * to parse the color and hex which will parse the
     * hex format of a color.
     *
     * @param key The key to store the color under
     * @return The element to match the input
     */
    public static CommandElement color(Text key) {
        return new ColorElement(key, null);
    }

    /**
     * Gives a {@link Color}, the color can be parsed
     * in 3 different formats: literal which will match
     * some inbuilt mappings, rgb which will use 3 components
     * to parse the color and hex which will parse the
     * hex format of a color.
     *
     * <p>The default color will be used in the tab completation,
     * it will be the first entry when completing a empty color
     * element or the only entry when completing hex or rgb.</p>
     *
     * @param key The key to store the color under
     * @param defaultColor The default color used in tab completation
     * @return The element to match the input
     */
    public static CommandElement color(Text key, @Nullable Color defaultColor) {
        return new ColorElement(key, defaultColor);
    }

    private static class ColorElement extends CommandElement {

        private static final Pattern RGB_PATTERN = Pattern.compile("^[0-9,]+$");
        private static final Map<String, Color> INBUILT_COLORS = ImmutableMap.<String, Color>builder()
                .put("black", Color.BLACK)
                .put("blue", Color.BLUE)
                .put("cyan", Color.CYAN)
                .put("darkcyan", Color.DARK_CYAN)
                .put("darkgreen", Color.DARK_GREEN)
                .put("darkmagenta", Color.DARK_MAGENTA)
                .put("gray", Color.GRAY)
                .put("green", Color.GREEN)
                .put("lime", Color.LIME)
                .put("magenta", Color.MAGENTA)
                .put("navy", Color.NAVY)
                .put("pink", Color.PINK)
                .put("purple", Color.PURPLE)
                .put("red", Color.RED)
                .put("white", Color.WHITE)
                .put("yellow", Color.YELLOW)
                .build();
        private static final List<String> INBUILT_COLOR_NAMES = ImmutableList.copyOf(INBUILT_COLORS.keySet());

        public static String findClosestColorName(String target) {
            int distance = Integer.MAX_VALUE;
            String closest = null;
            for (String name : INBUILT_COLORS.keySet()) {
                int currentDistance = StringUtils.getLevenshteinDistance(name, target);
                if (currentDistance < distance) {
                    distance = currentDistance;
                    closest = name;
                }
            }
            return closest;
        }

        @Nullable private final Color defaultColor;
        @Nullable private final ImmutableList<String> sortedColorNames;

        ColorElement(Text key, @Nullable Color defaultColor) {
            super(key);
            this.defaultColor = defaultColor;
            if (defaultColor != null) {
                for (Map.Entry<String, Color> entry : INBUILT_COLORS.entrySet()) {
                    if (entry.getValue().equals(defaultColor)) {
                        final ImmutableList.Builder<String> entries = ImmutableList.builder();
                        entries.add(entry.getKey());
                        // Add all the other colors except the first element
                        INBUILT_COLORS.keySet().stream()
                                .filter(colorName -> !colorName.equals(entry.getKey()))
                                .forEach(entries::add);
                        this.sortedColorNames = entries.build();
                        return;
                    }
                }
            }
            this.sortedColorNames = null;
        }

        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            String rStr = args.next();
            // Check for hex format if allowed
            if (rStr.startsWith("0x") || rStr.startsWith("#")) {
                // Get the hex value without the prefix
                String value = rStr.substring(rStr.startsWith("0x") ? 2 : 1);
                int hex;
                try {
                    hex = Integer.parseInt(value, 16);
                } catch (NumberFormatException e) {
                    throw args.createError(t("Expected input %s to be hexadecimal, but it was not"));
                }
                return Color.ofRgb(hex);
            }
            // Check whether the format matches
            if (RGB_PATTERN.matcher(rStr).matches()) {
                String gStr;
                String bStr;
                // Try for the comma-separated format
                if (rStr.contains(",")) {
                    String[] split = rStr.split(",");
                    if (split.length != 3) {
                        throw args.createError(t("Comma-separated color must have 3 elements, not %s", split.length));
                    }
                    rStr = split[0];
                    gStr = split[1];
                    bStr = split[2];
                } else {
                    gStr = args.next();
                    bStr = args.next();
                }
                int r = parseComponent(args, rStr, "r");
                int g = parseComponent(args, gStr, "g");
                int b = parseComponent(args, bStr, "b");
                return Color.of(new Vector3i(r, g, b));
            }
            Color color = INBUILT_COLORS.get(rStr.toLowerCase());
            if (color == null) {
                throw args.createError(t("Unknown inbuilt color: %s Did you mean: %s ?",
                        rStr, findClosestColorName(rStr)));
            }
            return color;
        }

        private static int parseComponent(CommandArgs args, String arg, String name) throws ArgumentParseException {
            try {
                int value = Integer.parseInt(arg);
                if (value < 0) {
                    throw args.createError(t("Number %s for %s component is too small, it must be at least %s",
                            value, name, 0));
                }
                if (value > 255) {
                    throw args.createError(t("Number %s for %s component is too big, it must be at most %s",
                            value, name, 255));
                }
                return value;
            } catch (NumberFormatException e) {
                throw args.createError(t("Expected input %s for %s component to be a number, but it was not",
                        arg, name));
            }
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            Optional<String> arg = args.nextIfPresent();
            if (!arg.isPresent()) {
                return ImmutableList.of();
            }
            final String rStr = arg.get();
            if (args.nextIfPresent().isPresent()) {
                if (rStr.startsWith("0x") || rStr.startsWith("#") ||
                        !RGB_PATTERN.matcher(rStr).matches() || rStr.contains(",")) {
                    return ImmutableList.of();
                }
                if (args.nextIfPresent().isPresent()) {
                    // Store the current state
                    Object state = args.getState();
                    if (args.nextIfPresent().isPresent()) {
                        // We finished the vector3d, reset before the last arg
                        args.setState(state);
                    } else {
                        // The blue is being completed
                        if (this.defaultColor != null) {
                            return ImmutableList.of(Integer.toString(this.defaultColor.getBlue()));
                        } else {
                            return ImmutableList.of();
                        }
                    }
                } else {
                    // The green is being completed
                    if (this.defaultColor != null) {
                        return ImmutableList.of(Integer.toString(this.defaultColor.getGreen()));
                    } else {
                        return ImmutableList.of();
                    }
                }
            } else {
                if (rStr.isEmpty()) {
                    if (this.sortedColorNames == null) {
                        return INBUILT_COLOR_NAMES;
                    }
                    return this.sortedColorNames;
                }
                if (rStr.startsWith("0x") || rStr.startsWith("#")) {
                    if (this.defaultColor == null) {
                        return ImmutableList.of();
                    }
                    final String prefix = rStr.charAt(0) == '#' ? "#" : "0x";
                    return ImmutableList.of(prefix + Integer.toHexString(this.defaultColor.getRgb()));
                }
                if (RGB_PATTERN.matcher(rStr).matches()) {
                    if (this.defaultColor == null) {
                        return ImmutableList.of();
                    }
                    if (rStr.contains(",")) {
                        final int parts = rStr.split(",", -1).length;
                        final int index = rStr.lastIndexOf(',');

                        final String prefix = rStr.substring(0, index + 1);
                        switch (parts) {
                            case 1:
                                return ImmutableList.of(prefix + this.defaultColor.getRed());
                            case 2:
                                return ImmutableList.of(prefix + this.defaultColor.getGreen());
                            case 3:
                                return ImmutableList.of(prefix + this.defaultColor.getBlue());
                        }
                        return ImmutableList.of();
                    }
                    return ImmutableList.of(Integer.toString(this.defaultColor.getRed()));
                } else {
                    return INBUILT_COLOR_NAMES.stream().filter(new StartsWithPredicate(rStr.toLowerCase()))
                            .collect(GuavaCollectors.toImmutableList());
                }
            }
            return ImmutableList.of();
        }
    }

}
