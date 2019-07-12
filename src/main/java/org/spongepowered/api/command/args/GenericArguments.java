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
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandMessageFormatting;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.source.ProxySource;
import org.spongepowered.api.command.source.RemoteSource;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.persistence.DataTranslators;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.service.user.UserStorageService;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.selector.Selector;
import org.spongepowered.api.text.serializer.TextParseException;
import org.spongepowered.api.text.serializer.TextSerializer;
import org.spongepowered.api.text.serializer.TextSerializers;
import org.spongepowered.api.util.StartsWithPredicate;
import org.spongepowered.api.util.Tristate;
import org.spongepowered.api.util.blockray.BlockRay;
import org.spongepowered.api.util.blockray.BlockRayHit;
import org.spongepowered.api.world.DimensionType;
import org.spongepowered.api.world.Locatable;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.extent.EntityUniverse;
import org.spongepowered.api.world.storage.WorldProperties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.annotation.Nullable;


/**
 * Class containing factory methods for common command elements.
 */
public final class GenericArguments {

    private static final CommandElement NONE = new SequenceCommandElement(ImmutableList.<CommandElement>of());

    private GenericArguments() {}

    /**
     * Expects no arguments, returns no values.
     *
     * @return An expectation of no arguments
     */
    public static CommandElement none() {
        return NONE;
    }

    /**
     * Expects no arguments. Adds 'true' to the context when parsed.
     *
     * <p>This will return only one value.</p>
     *
     * @param key the key to store 'true' under
     * @return the argument
     */
    public static CommandElement markTrue(Text key) {
        return new MarkTrueCommandElement(key);
    }

    /**
     * Expect an argument to represent online players, or if nothing matches
     * and the source is a {@link Player}, give the player. If nothing matches
     * and the source is not a player, throw an exception.
     *
     * <p>Gives values of type {@link Player}.</p>
     *
     * <p>This argument accepts the following inputs:</p>
     *
     * <ul>
     *     <li>A player's name</li>
     *     <li>A regex that matches the beginning of one or more player's names
     *     </li>
     *     <li>A selector</li>
     * </ul>
     *
     * <p>This may return multiple players. If you must only return one, wrap
     * this element in an {@link #onlyOne(CommandElement)} call.</p>
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement playerOrSource(Text key) {
        return new PlayerCommandElement(key, true);
    }

    /**
     * Expect an argument to represent online players. Returns values of type
     * {@link Player}.
     *
     * <p>This argument accepts the following inputs:</p>
     *
     * <ul>
     *     <li>A player's name</li>
     *     <li>A regex that matches the beginning of one or more player's names
     *     </li>
     *     <li>A selector</li>
     * </ul>
     *
     * <p>This may return multiple players. If you must only return one, wrap
     * this element in an {@link #onlyOne(CommandElement)} call.</p>
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement player(Text key) {
        return new PlayerCommandElement(key, false);
    }

    /**
     * Expect an argument to represent players who have been online at some
     * point, as a {@link User}.
     *
     * <p>This argument accepts the following inputs:</p>
     *
     * <ul>
     *     <li>A player's name (offline or online)</li>
     *     <li>A regex that matches the beginning of one or more player's names
     *     </li>
     *     <li>A selector</li>
     * </ul>
     *
     * <p>This may return multiple {@link User}s. If you must only return one,
     * wrap this element in an {@link #onlyOne(CommandElement)} call.</p>
     *
     * <p>This may not return the {@link Player} object for an online user. If
     * you wish to operate on an associated {@link Player} object if the user is
     * online, use {@link User#getPlayer()}.</p>
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement user(Text key) {
        return new UserCommandElement(key, false);
    }

    /**
     * Expect an argument to represent players who have been online at some
     * point, as a {@link User}, or if nothing matches and the source is a
     * {@link User}, give the user. If nothing matches and the source is not
     * a {@link User}, throw an exception.
     *
     * <p>This argument accepts the following inputs:</p>
     *
     * <ul>
     *     <li>A player's name (offline or online)</li>
     *     <li>A regex that matches the beginning of one or more player's names
     *     </li>
     *     <li>A selector</li>
     * </ul>
     *
     * <p>This may return multiple {@link User}s. If you must only return one,
     * wrap this element in an {@link #onlyOne(CommandElement)} call.</p>
     *
     * <p>This may not return the {@link Player} object for an online user. If
     * you wish to operate on an associated {@link Player} object if the user is
     * online, use {@link User#getPlayer()}.</p>
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement userOrSource(Text key) {
        return new UserCommandElement(key, true);
    }

    /**
     * Expect an argument to represent a world. This returns
     * {@link WorldProperties} objects rather than an actual {@link World} in
     * order to include unloaded worlds.
     *
     * <p>This argument accepts the following inputs:</p>
     *
     * <ul>
     *     <li>A world's name</li>
     *     <li>A regex that matches the beginning of one or more world's names
     *     </li>
     * </ul>
     *
     * <p>This may return multiple {@link WorldProperties}s. If you must only
     * return one, wrap this element in an {@link #onlyOne(CommandElement)}
     * call.</p>
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement world(Text key) {
        return new WorldPropertiesCommandElement(key);
    }

    /**
     * Expect an argument to represent a dimension. Returns values of type
     * {@link DimensionType}.
     *
     * <p>This argument accepts the following inputs:</p>
     *
     * <ul>
     *     <li>A dimension's id</li>
     *     <li>A regex that matches the beginning of one or more dimension id
     *     </li>
     * </ul>
     *
     * <p>This may return multiple {@link DimensionType}s. If you must only
     * return one, wrap this element in an {@link #onlyOne(CommandElement)}
     * call.</p>
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
     * <p>This will return one value.</p>
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement vector3d(Text key) {
        return new Vector3dCommandElement(key);
    }

    /**
     * Expect an argument to represent a {@link Location}.
     *
     * <p>This will return one value.</p>
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement location(Text key) {
        return new LocationCommandElement(key);
    }

    /**
     * Expect an argument that is a member of the specified {@link CatalogType}
     * T.
     *
     * <p>This argument accepts the following inputs:</p>
     *
     * <ul>
     *     <li>The value's {@link CatalogType#getId()}</li>
     *     <li>A regex that matches the beginning of one or more ids</li>
     * </ul>
     *
     * <p>This may return multiple instances of T. If you must only return one,
     * wrap this element in an {@link #onlyOne(CommandElement)} call.</p>
     *
     * @param key The key to store the resolved value under
     * @param catalogType The expected {@link CatalogType}
     * @param <T> The type to return
     * @return the argument
     */
    public static <T extends CatalogType> CommandElement catalogedElement(Text key, Class<T> catalogType) {
        return new CatalogedTypeCommandElement<>(key, catalogType);
    }

    /**
     * Expect an argument to represent a {@link PluginContainer}'s id.
     *
     * <p>This argument accepts the following inputs:</p>
     *
     * <ul>
     *     <li>The specified {@link PluginContainer}'s id</li>
     *     <li>A regex that matches the beginning of one or more plugin id</li>
     * </ul>
     *
     * <p>This may return multiple {@link PluginContainer}s. If you must only
     * return one, wrap this element in an {@link #onlyOne(CommandElement)}
     * call.</p>
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

        MarkTrueCommandElement(Text key) {
            super(key);
        }

        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            return true;
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            return Collections.emptyList();
        }

        @Override
        public Text getUsage(CommandSource src) {
            return Text.EMPTY;
        }
    }

    /**
     * Gets a builder to create a command element that parses flags.
     *
     * <p>There should only be ONE of these in a command element sequence if you
     * wish to use flags. A {@link CommandFlags.Builder} can handle multiple
     * flags that have different behaviors. Using multiple builders in the same
     * sequence may cause unexpected behavior.</p>
     *
     * <p>Any command elements that are not associated with flags should be
     * placed into the {@link CommandFlags.Builder#buildWith(CommandElement)}
     * parameter, allowing the flags to be used throughout the argument string.
     * </p>
     *
     * @return the newly created builder
     */
    public static CommandFlags.Builder flags() {
        return new CommandFlags.Builder();
    }

    /**
     * Consumes a series of arguments. Usage is the elements concatenated
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
            Set<String> completions = Sets.newHashSet();
            for (CommandElement element : elements) {
                CommandArgs.Snapshot state = args.getSnapshot();
                try {
                    element.parse(src, args, context);
                    if (state.equals(args.getSnapshot())) {
                        completions.addAll(element.complete(src, args, context));
                        args.applySnapshot(state);
                    } else if (args.hasNext()) {
                        completions.clear();
                    } else {
                        args.applySnapshot(state);
                        completions.addAll(element.complete(src, args, context));
                        if (!(element instanceof OptionalCommandElement)) {
                            break;
                        }
                        args.applySnapshot(state);
                    }
                } catch (ArgumentParseException ignored) {
                    args.applySnapshot(state);
                    completions.addAll(element.complete(src, args, context));
                    break;
                }
            }
            return Lists.newArrayList(completions);
        }

        @Override
        public Text getUsage(CommandSource commander) {
            final Text.Builder build = Text.builder();
            for (Iterator<CommandElement> it = this.elements.iterator(); it.hasNext();) {
                Text usage = it.next().getUsage(commander);
                if (!usage.isEmpty()) {
                    build.append(usage);
                    if (it.hasNext()) {
                        build.append(CommandMessageFormatting.SPACE_TEXT);
                    }
                }
            }
            return build.build();
        }
    }

    /**
     * Return an argument that allows selecting from a limited set of values.
     *
     * <p>If there are 5 or fewer choices available, the choices will be shown
     * in the command usage. Otherwise, the usage will only display only the
     * key.</p>
     *
     * <p>Choices are <strong>case sensitive</strong>. If you do not require
     * case sensitivity, see {@link #choicesInsensitive(Text, Map)}.</p>
     *
     * <p>To override this behavior, see
     * {@link #choices(Text, Map, boolean, boolean)}.</p>
     *
     * <p>When parsing, only one choice may be selected, returning its
     * associated value.</p>
     *
     * @param key The key to store the resulting value under
     * @param choices The choices users can choose from
     * @return the element to match the input
     */
    public static CommandElement choices(Text key, Map<String, ?> choices) {
        return choices(key, choices, choices.size() <= ChoicesCommandElement.CUTOFF, true);
    }

    /**
     * Return an argument that allows selecting from a limited set of values.
     *
     * <p>If there are 5 or fewer choices available, the choices will be shown
     * in the command usage. Otherwise, the usage will only display only the
     * key.</p>
     *
     * <p>Choices are <strong>not case sensitive</strong>. If you require
     * case sensitivity, see {@link #choices(Text, Map)}</p>
     *
     * <p>To override this behavior, see
     * {@link #choices(Text, Map, boolean, boolean)}.</p>
     *
     * <p>When parsing, only one choice may be selected, returning its
     * associated value.</p>
     *
     * @param key The key to store the resulting value under
     * @param choices The choices users can choose from
     * @return the element to match the input
     */
    public static CommandElement choicesInsensitive(Text key, Map<String, ?> choices) {
        return choices(key, choices, choices.size() <= ChoicesCommandElement.CUTOFF, false);
    }

    /**
     * Return an argument that allows selecting from a limited set of values.
     *
     * <p>Unless {@code choicesInUsage} is true, general command usage will only
     * display the provided key.</p>
     *
     * <p>Choices are <strong>case sensitive</strong>. If you do not require
     * case sensitivity, see {@link #choices(Text, Map, boolean, boolean)}</p>
     *
     * <p>When parsing, only one choice may be selected, returning its
     * associated value.</p>
     *
     * @param key The key to store the resulting value under
     * @param choices The choices users can choose from
     * @param choicesInUsage Whether to display the available choices, or simply
     *      the provided key, as part of usage
     * @return the element to match the input
     */
    public static CommandElement choices(Text key, Map<String, ?> choices, boolean choicesInUsage) {
        return choices(key, choices, choicesInUsage, true);
    }

    /**
     * Return an argument that allows selecting from a limited set of values.
     *
     * <p>Unless {@code choicesInUsage} is true, general command usage will only
     * display the provided key.</p>
     *
     * <p>When parsing, only one choice may be selected, returning its
     * associated value.</p>
     *
     * @param key The key to store the resulting value under
     * @param choices The choices users can choose from
     * @param choicesInUsage Whether to display the available choices, or simply
     *      the provided key, as part of usage
     * @param caseSensitive Whether the matches should be case sensitive
     * @return the element to match the input
     */
    public static CommandElement choices(Text key, Map<String, ?> choices, boolean choicesInUsage, boolean caseSensitive) {
        if (!caseSensitive) {
            Map<String, Object> immChoices = choices.entrySet().stream()
                    .collect(ImmutableMap.toImmutableMap(x -> x.getKey().toLowerCase(), Map.Entry::getValue));
            return choices(key, immChoices::keySet, selection -> immChoices.get(selection.toLowerCase()), choicesInUsage);
        }
        Map<String, Object> immChoices = ImmutableMap.copyOf(choices);
        return choices(key, immChoices::keySet, immChoices::get, choicesInUsage);
    }

    /**
     * Return an argument that allows selecting from a limited set of values.
     *
     * <p>If there are 5 or fewer choices available, the choices will be shown
     * in the command usage. Otherwise, the usage will only display only the
     * key.</p>
     *
     * <p>To override this behavior, see {@link #choices(Text, Map, boolean)}.
     * </p>
     *
     * <p>Only one choice may be selected, returning its associated value.</p>
     *
     * @param key The key to store the resulting value under
     * @param keys The function that will supply available keys
     * @param values The function that maps an element of {@code key} to a value
     *      and any other key to {@code null}
     * @return the element to match the input
     */
    public static CommandElement choices(Text key, Supplier<Collection<String>> keys, Function<String, ?> values) {
        return new ChoicesCommandElement(key, keys, values, Tristate.UNDEFINED);
    }

    /**
     * Return an argument that allows selecting from a limited set of values.
     * Unless {@code choicesInUsage} is true, general command usage will only
     * display the provided key.
     *
     * <p>Only one choice may be selected, returning its associated value.</p>
     *
     * @param key The key to store the resulting value under
     * @param keys The function that will supply available keys
     * @param values The function that maps an element of {@code key} to a value
     *      and any other key to {@code null}
     * @param choicesInUsage Whether to display the available choices, or simply
     *      the provided key, as part of usage
     * @return the element to match the input
     */
    public static CommandElement choices(Text key, Supplier<Collection<String>> keys, Function<String, ?> values, boolean choicesInUsage) {
        return new ChoicesCommandElement(key, keys, values, choicesInUsage ? Tristate.TRUE : Tristate.FALSE);
    }

    private static class ChoicesCommandElement extends CommandElement {
        private static final int CUTOFF = 5;
        private final Supplier<Collection<String>> keySupplier;
        private final Function<String, ?> valueSupplier;
        private final Tristate choicesInUsage;

        ChoicesCommandElement(Text key, Supplier<Collection<String>> keySupplier, Function<String, ?> valueSupplier, Tristate choicesInUsage) {
            super(key);
            this.keySupplier = keySupplier;
            this.valueSupplier = valueSupplier;
            this.choicesInUsage = choicesInUsage;
        }

        @Override
        public Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            Object value = this.valueSupplier.apply(args.next());
            if (value == null) {
                throw args.createError(t("Argument was not a valid choice. Valid choices: %s", this.keySupplier.get().toString()));
            }
            return value;
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            final String prefix = args.nextIfPresent().orElse("");
            return this.keySupplier.get().stream().filter(new StartsWithPredicate(prefix)).collect(ImmutableList.toImmutableList());
        }

        @Override
        public Text getUsage(CommandSource commander) {
            Collection<String> keys = this.keySupplier.get();
            if (this.choicesInUsage == Tristate.TRUE || (this.choicesInUsage == Tristate.UNDEFINED && keys.size() <= CUTOFF)) {
                final Text.Builder build = Text.builder();
                build.append(CommandMessageFormatting.LT_TEXT);
                for (Iterator<String> it = keys.iterator(); it.hasNext();) {
                    build.append(Text.of(it.next()));
                    if (it.hasNext()) {
                        build.append(CommandMessageFormatting.PIPE_TEXT);
                    }
                }
                build.append(CommandMessageFormatting.GT_TEXT);
                return build.build();
            }
            return super.getUsage(commander);
        }
    }


    /**
     * Returns a command element that matches the first of the provided elements
     * that parses tab completion matches from all options.
     *
     * @param elements The elements to check against
     * @return The command element matching the first passing of the elements
     *      provided
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
            for (CommandElement element : this.elements) {
                CommandArgs.Snapshot startState = args.getSnapshot();
                CommandContext.Snapshot contextSnapshot = context.createSnapshot();
                try {
                    element.parse(source, args, context);
                    return;
                } catch (ArgumentParseException ex) {
                    lastException = ex;
                    args.applySnapshot(startState);
                    context.applySnapshot(contextSnapshot);
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
            return ImmutableList.copyOf(Iterables.concat(Iterables.transform(this.elements,
                input -> {
                    if (input == null) {
                        return ImmutableList.of();
                    }

                    CommandArgs.Snapshot snapshot = args.getSnapshot();
                    List<String> ret = input.complete(src, args, context);
                    args.applySnapshot(snapshot);
                    return ret;
                })));
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
     * Make the provided command element optional.
     *
     * <p>This means the command element is not required. However, if the
     * element is provided with invalid format and there are no more args
     * specified, any errors will still be passed on.</p>
     *
     * @param element The element to optionally require
     * @return the element to match the input
     */
    public static CommandElement optional(CommandElement element) {
        return new OptionalCommandElement(element, null, false);
    }

    /**
     * Make the provided command element optional.
     *
     * <p>This means the command element is not required. However, if the
     * element is provided with invalid format and there are no more args
     * specified, any errors will still be passed on. If the given element's key
     * and {@code value} are not null and this element is not provided the
     * element's key will be set to the given value.</p>
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
     * <p>Make the provided command element optional.</p>
     *
     * <p>This means the command element is not required.</p>
     *
     * <ul>
     *     <li>If the argument is provided but of invalid format, it will be
     *     skipped.</li>
     *     <li>If the given element's key and {@code value} are not null and
     *     this element is not provided the element's key will be set to the
     *     given value.</li>
     * </ul>
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
            CommandArgs.Snapshot startState = args.getSnapshot();
            try {
                this.element.parse(source, args, context);
            } catch (ArgumentParseException ex) {
                if (this.considerInvalidFormatEmpty || args.hasNext()) { // If there are more args, suppress. Otherwise, throw the error
                    args.applySnapshot(startState);
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
            return this.element.complete(src, args, context);
        }

        @Override
        public Text getUsage(CommandSource src) {
            return Text.of("[", this.element.getUsage(src), "]");
        }
    }

    /**
     * Require a given command element to be provided a certain number of times.
     *
     * <p>Command values will be stored under their provided keys in the
     * <tt>CommandContext</tt>.</p>
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
                CommandArgs.Snapshot startState = args.getSnapshot();
                try {
                    this.element.parse(src, args, context);
                } catch (ArgumentParseException e) {
                    args.applySnapshot(startState);
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
     * Require all remaining args to match as many instances of
     * {@link CommandElement} as will fit. Command element values will be stored
     * under their provided keys in the CommandContext.
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
                CommandArgs.Snapshot startState = args.getSnapshot();
                try {
                    this.element.parse(src, args, context);
                } catch (ArgumentParseException e) {
                    args.applySnapshot(startState);
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
     * Parent class that specifies elements as having no tab completions.
     * Useful for inputs with a very large domain, like strings and integers.
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
     * Require an argument to be a string. Any provided argument will fit in
     * under this argument.
     *
     * <p>Gives values of type {@link String}. This will return only one value.
     * </p>
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
     *
     * <p>Gives values of type {@link Integer}. This will return only one value.
     * </p>
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
     *
     * <p>Gives values of type {@link Long}. This will return only one value.
     * </p>
     *
     * @param key The key to store the parsed argument under
     * @return the element to match the input
     */
    public static CommandElement longNum(Text key) {
        return new NumericElement<>(key, Long::parseLong, Long::parseLong, input -> t("Expected a long, but input '%s' was not", input));
    }

    /**
     * Require an argument to be an double-precision floating point number.
     *
     * <p>Gives values of type {@link Double}. This will return only one value.
     * </p>
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
     *
     * <p>The recognized true values are:</p>
     *
     * <ul>
     *     <li>true</li>
     *     <li>t</li>
     *     <li>yes</li>
     *     <li>y</li>
     *     <li>verymuchso</li>
     * </ul>
     *
     *
     * <p>The recognized false values are:</p>
     *
     * <ul>
     *     <li>false</li>
     *     <li>f</li>
     *     <li>no</li>
     *     <li>n</li>
     *     <li>notatall</li>
     * </ul>
     *
     * <p>Gives values of type {@link Boolean}. This will return only one value.
     * </p>
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
     * <p>Gives values of type <tt>T</tt>. This will return only one value.</p>
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
        private final Class<T> type;
        private final Map<String, T> values;

        EnumValueElement(Text key, Class<T> type) {
            super(key);
            this.type = type;
            this.values = Arrays.stream(type.getEnumConstants())
                .collect(Collectors.toMap(value -> value.name().toLowerCase(),
                    Function.identity(), (value, value2) -> {
                        throw new UnsupportedOperationException(type.getCanonicalName() + " contains more than one enum constant "
                            + "with the same name, only differing by capitalization, which is unsupported.");
                    }
                ));
        }

        @Override
        protected Iterable<String> getChoices(CommandSource source) {
            return this.values.keySet();
        }

        @Override
        protected Object getValue(String choice) throws IllegalArgumentException {
            T value = this.values.get(choice.toLowerCase());
            if (value == null) {
                throw new IllegalArgumentException("No enum constant " + this.type.getCanonicalName() + "." + choice);
            }

            return value;
        }
    }

    /**
     * Require one or more strings, which are combined into a single,
     * space-separated string.
     *
     * <p>Gives values of type {@link String}. This will return only one value.
     * </p>
     *
     * @param key The key to store the parsed argument under
     * @return the element to match the input
     */
    public static CommandElement remainingJoinedStrings(Text key) {
        return new RemainingJoinedStringsCommandElement(key, false);
    }

    /**
     * Require one or more strings, without any processing, which are combined
     * into a single, space-separated string.
     *
     * <p>Gives values of type {@link String}. This will return only one value.
     * </p>
     *
     * @param key The key to store the parsed argument under
     * @return the element to match the input
     */
    public static CommandElement remainingRawJoinedStrings(Text key) {
        return new RemainingJoinedStringsCommandElement(key, true);
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
            }
            final StringBuilder ret = new StringBuilder(args.next());
            while (args.hasNext()) {
                ret.append(' ').append(args.next());
            }
            return ret.toString();
        }

        @Override
        public Text getUsage(CommandSource src) {
            return Text.of(CommandMessageFormatting.LT_TEXT, getKey(), CommandMessageFormatting.ELLIPSIS_TEXT, CommandMessageFormatting.GT_TEXT);
        }
    }

    /**
     * Expect a literal sequence of arguments. This element matches the input
     * against a predefined array of arguments expected to be present,
     * case-insensitively.
     *
     * <p>This will return only one value.</p>
     *
     * @param key The key to add to the context. Will be set to a value of true
     *      if this element matches
     * @param expectedArgs The sequence of arguments expected
     * @return the appropriate command element
     */
    public static CommandElement literal(Text key, String... expectedArgs) {
        return new LiteralCommandElement(key, ImmutableList.copyOf(expectedArgs), true);
    }

    /**
     * Expect a literal sequence of arguments. This element matches the input
     * against a predefined array of arguments expected to be present,
     * case-insensitively.
     *
     * <p>This will return only one value.</p>
     *
     * @param key The key to store this argument as
     * @param putValue The value to put at key if this argument matches. May be
     *      <tt>null</tt>
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

    private static class UserCommandElement extends SelectorCommandElement {

        private final boolean returnSource;

        protected UserCommandElement(@Nullable Text key, boolean returnSource) {
            super(key);
            this.returnSource = returnSource;
        }

        @SuppressWarnings({"unchecked", "ConstantConditions"})
        @Nullable
        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            CommandArgs.Snapshot state = args.getSnapshot();
            try {
                return Iterables.filter((Iterable<User>) super.parseValue(source, args), e -> e instanceof User);
            } catch (ArgumentParseException ex2) {
                if (this.returnSource) {
                    args.applySnapshot(state);
                    return tryReturnSource(source, args);
                }
                throw ex2;
            }
        }

        @Override
        protected Iterable<String> getChoices(CommandSource source) {
            return Sponge.getGame().getServiceManager().provideUnchecked(UserStorageService.class).getAll().stream()
                    .map(GameProfile::getName)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(ImmutableList.toImmutableList());
        }

        @Override
        protected Object getValue(String choice) throws IllegalArgumentException {
            return Sponge.getGame().getServiceManager().provideUnchecked(UserStorageService.class).get(choice)
                    .orElseThrow(() -> new IllegalArgumentException("Input value '" + choice + "' was not a user!"));
        }

        @Override
        public void parse(CommandSource source, CommandArgs args, CommandContext context) throws ArgumentParseException {
            // If we're not completing, then we want to use the UserStorageService directly
            // to get any direct match.
            @Nullable Text key = getKey();
            if (key != null && !context.hasAny(CommandContext.TAB_COMPLETION)) {
                if (this.returnSource && !args.hasNext()) {
                    context.putArg(key, tryReturnSource(source, args));
                    return;
                }

                CommandArgs.Snapshot state = args.getSnapshot();
                String element = args.next();
                try {
                    Optional<User> match = Sponge.getServiceManager().provideUnchecked(UserStorageService.class).get(element);
                    if (match.isPresent()) {
                        context.putArg(key, match.get());
                        return;
                    }
                } catch (IllegalArgumentException ignored) {
                    // Intentionally ignored
                    // If it's not an exact match, we just let this carry on to parse using the pattern element
                }

                args.applySnapshot(state);
            }

            super.parse(source, args, context);
        }

        private User tryReturnSource(CommandSource source, CommandArgs args) throws ArgumentParseException {
            if (source instanceof User) {
                return ((User) source);
            } else if (source instanceof ProxySource && ((ProxySource) source).getOriginalSource() instanceof User) {
                return (User) ((ProxySource) source).getOriginalSource();
            } else {
                throw args.createError(t("No users matched and source was not a user!"));
            }
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

            CommandArgs.Snapshot state = args.getSnapshot();
            try {
                return Iterables.filter((Iterable<Entity>)super.parseValue(source, args), e -> e instanceof Player);
            } catch (ArgumentParseException ex) {
                if (this.returnSource) {
                    args.applySnapshot(state);
                    return tryReturnSource(source, args);
                }
                throw ex;
            }
        }

        @Override
        protected Iterable<String> getChoices(CommandSource source) {
            return Sponge.getGame().getServer().getOnlinePlayers().stream()
                .map(input -> input == null ? null : input.getName())
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
     * A command element which represents a world or dimension.
     *
     * <p>Accepted formats:</p>
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
        @Override
        public Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            final String next = args.peek();
            if (next.startsWith("#")) {
                String specifier = next.substring(1);
                if (specifier.equalsIgnoreCase("first")) {
                    args.next();
                    return Sponge.getGame().getServer().getAllWorldProperties().stream().filter(input -> input != null && input.isEnabled())
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
                    final DimensionType type = ((Iterable<DimensionType>) this.dimensionTypeElement.parseValue(source, args)).iterator().next();
                    Iterable<WorldProperties> ret = Sponge.getGame().getServer().getAllWorldProperties().stream().filter(input -> input != null
                            && input.isEnabled() && input.getDimensionType().equals(type)).collect(Collectors.toList());
                    return firstOnly ? ret.iterator().next() : ret;
                }
            }

            return super.parseValue(source, args);
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            Iterable<String> choices = getCompletionChoices(src);
            final Optional<String> nextArg = args.nextIfPresent();
            if (nextArg.isPresent()) {
                choices = Iterables.filter(choices, input -> getFormattedPattern(nextArg.get()).matcher(input).find());
            }
            return ImmutableList.copyOf(choices);
        }

        protected Iterable<String> getCompletionChoices(CommandSource source) {
            return Iterables.concat(getChoices(source), ImmutableSet.of("#first", "#me"),
                    Iterables.transform(Sponge.getGame().getRegistry()
                            .getAllOf(DimensionType.class), input2 -> "#" + input2.getId()));
        }

        @Override
        protected Iterable<String> getChoices(CommandSource source) {
            return Sponge.getGame().getServer().getAllWorldProperties().stream()
                    .map(input -> input.getWorldName())
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
     * A {@link Vector3d} command element.
     *
     * <p>It has the following syntax:</p>
     *
     * <blockquote><pre> x,y,z
     * x y z.</pre></blockquote>
     *
     * <p>Each element can be relative to a location? so
     * <tt>parseRelativeDouble()</tt> -- relative is ~(num)</p>
     *
     */
    private static class Vector3dCommandElement extends CommandElement {
        private static final ImmutableSet<String> SPECIAL_TOKENS = ImmutableSet.of("#target", "#me");

        protected Vector3dCommandElement(@Nullable Text key) {
            super(key);
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
                    throw args.createError(t("Comma-separated location must have 3 elements, not %s", split.length));
                }
                xStr = split[0];
                yStr = split[1];
                zStr = split[2];
            } else if (xStr.equals("#target") && source instanceof Entity) {
                Optional<BlockRayHit<World>> hit = BlockRay
                        .from(((Entity) source))
                        .stopFilter(BlockRay.continueAfterFilter(BlockRay.onlyAirFilter(), 1))
                        .build()
                        .end();
                if (!hit.isPresent()) {
                    throw args.createError(t("No target block is available! Stop stargazing!"));
                }
                return hit.get().getPosition();
            } else if (xStr.equalsIgnoreCase("#me") && source instanceof Locatable) {
                return ((Locatable) source).getLocation().getPosition();
            } else {
                yStr = args.next();
                zStr = args.next();
            }
            final double x = parseRelativeDouble(args, xStr, source instanceof Locatable ? ((Locatable) source).getLocation().getX() : null);
            final double y = parseRelativeDouble(args, yStr, source instanceof Locatable ? ((Locatable) source).getLocation().getY() : null);
            final double z = parseRelativeDouble(args, zStr, source instanceof Locatable ? ((Locatable) source).getLocation().getZ() : null);

            return new Vector3d(x, y, z);
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            Optional<String> arg = args.nextIfPresent();
            // Traverse through the possible arguments. We can't really complete arbitrary integers
            if (arg.isPresent()) {
                if (arg.get().startsWith("#")) {
                    return SPECIAL_TOKENS.stream().filter(new StartsWithPredicate(arg.get())).collect(ImmutableList.toImmutableList());
                } else if (arg.get().contains(",") || !args.hasNext()) {
                    return ImmutableList.of(arg.get());
                } else {
                    arg = args.nextIfPresent();
                    if (args.hasNext()) {
                        return ImmutableList.of(args.nextIfPresent().get());
                    }
                    return ImmutableList.of(arg.get());
                }
            }
            return ImmutableList.of();
        }

        private double parseRelativeDouble(CommandArgs args, String arg, @Nullable Double relativeTo) throws ArgumentParseException {
            boolean relative = arg.startsWith("~");
            if (relative) {
                if (relativeTo == null) {
                    throw args.createError(t("Relative position specified but source does not have a position"));
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
     * An element representing a location.
     *
     * <p>Listens to:</p>
     *
     * <ul>
     *     <li>#spawn:&lt;world></li>
     *     <li>#me: Location of the current source</li>
     * </ul>
     */
    private static class LocationCommandElement extends CommandElement {
        private final WorldPropertiesCommandElement worldParser;
        private final Vector3dCommandElement vectorParser;

        protected LocationCommandElement(Text key) {
            super(key);
            this.worldParser = new WorldPropertiesCommandElement(null);
            this.vectorParser = new Vector3dCommandElement(null);
        }

        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            CommandArgs.Snapshot state = args.getSnapshot();
            if (args.peek().startsWith("@")) { // We are a selector
                return Selector.parse(args.next()).resolve(source).stream()
                        .map(Entity::getLocation)
                        .collect(ImmutableSet.toImmutableSet());
            }

            Object world;
            Object vec = null;
            try {
                world = checkNotNull(this.worldParser.parseValue(source, args), "worldVal");
            } catch (ArgumentParseException ex) {
                args.applySnapshot(state);
                if (!(source instanceof Locatable)) {
                    throw args.createError(t("Source must have a location in order to have a fallback world"));
                }
                world = ((Locatable) source).getWorld().getProperties();
                try {
                    vec = checkNotNull(this.vectorParser.parseValue(source, args), "vectorVal");
                } catch (ArgumentParseException ex2) {
                    args.applySnapshot(state);
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
            CommandArgs.Snapshot state = args.getSnapshot();
            Optional<String> nextPossibility = args.nextIfPresent();
            if (nextPossibility.isPresent() && nextPossibility.get().startsWith("@")) {
                return Selector.complete(nextPossibility.get());
            }
            args.applySnapshot(state);
            List<String> ret;
            if ((ret = this.worldParser.complete(src, args, context)).isEmpty()) {
                args.applySnapshot(state);
                ret = this.vectorParser.complete(src, args, context);
            }
            return ret;
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
     * Restricts the given command element to only insert one value into the
     * context at the provided key.
     *
     * <p>If more than one value is returned by an element, or the target key
     * already contains a value, this will throw an
     * {@link ArgumentParseException}</p>
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
     * <p>If the element attempts to parse an argument and the user does not
     * have the permission, a {@link ArgumentParseException} will be thrown.</p>
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

    /**
     * Expect an argument to represent an {@link Entity}.
     *
     * <p>This argument accepts the following inputs:</p>
     *
     * <ul>
     *     <li>A player's name</li>
     *     <li>An entity's {@link UUID}</li>
     *     <li>A regex that matches the beginning of one or more player's names
     *     or entities UUIDs.
     *     </li>
     *     <li>A selector</li>
     * </ul>
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement entity(Text key) {
        return new EntityCommandElement(key, false, false, (EntityType) null);
    }

    /**
     * Expect an argument to represent an {@link Entity} of the specified type.
     *
     * <p>This argument accepts the following inputs:</p>
     *
     * <ul>
     *     <li>A player's name (if appropriate)</li>
     *     <li>An entity's {@link UUID}</li>
     *     <li>A regex that matches the beginning of one or more player's names
     *     or entities UUIDs.
     *     </li>
     *     <li>A selector</li>
     * </ul>
     *
     * @param key The key to store under
     * @param clazz The type which the entity must subclass
     * @return the argument
     */
    public static CommandElement entity(Text key, Class<? extends Entity> clazz) {
        return new EntityCommandElement(key, false, false, clazz);
    }

    /**
     * Expect an argument to represent an {@link Entity} of the specified
     * {@link EntityType}.
     *
     * <p>This argument accepts the following inputs:</p>
     *
     * <ul>
     *     <li>A player's name (if appropriate)</li>
     *     <li>An entity's {@link UUID}</li>
     *     <li>A regex that matches the beginning of one or more player's names
     *     or entities UUIDs.
     *     </li>
     *     <li>A selector</li>
     * </ul>
     *
     * @param key The key to store under
     * @param type The type which the entity must be
     * @return the argument
     */
    public static CommandElement entity(Text key, EntityType type) {
        return new EntityCommandElement(key, false, false, type);
    }

    /**
     * Expect an argument to represent an {@link Entity}, or if the argument is
     * not present and the {@link CommandSource} is an entity, return the
     * source.
     *
     * <p>This argument accepts the following inputs:</p>
     *
     * <ul>
     *     <li>A player's name</li>
     *     <li>An entity's {@link UUID}</li>
     *     <li>A regex that matches the beginning of one or more player's names
     *     or entities UUIDs.
     *     </li>
     *     <li>A selector</li>
     * </ul>
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement entityOrSource(Text key) {
        return new EntityCommandElement(key, true, false, (EntityType) null);
    }

    /**
     * Expect an argument to represent an {@link Entity}, or if the argument is
     * not present and the {@link CommandSource} is looking at an entity,
     * return that entity.
     *
     * <p>This argument accepts the following inputs:</p>
     *
     * <ul>
     *     <li>A player's name</li>
     *     <li>An entity's {@link UUID}</li>
     *     <li>A regex that matches the beginning of one or more player's names
     *     or entities UUIDs.
     *     </li>
     *     <li>A selector</li>
     * </ul>
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement entityOrTarget(Text key) {
        return new EntityCommandElement(key, false, true, (EntityType) null);
    }

    /**
     * Expect an argument to represent an {@link Entity} of the specified type,
     * or if the argument is not present and the {@link CommandSource} is
     * looking at an applicable entity, return that entity.
     *
     * <p>This argument accepts the following inputs:</p>
     *
     * <ul>
     *     <li>A player's name (if appropriate)</li>
     *     <li>An entity's {@link UUID}</li>
     *     <li>A regex that matches the beginning of one or more player's names
     *     or entities UUIDs.
     *     </li>
     *     <li>A selector</li>
     * </ul>
     *
     * @param key The key to store under
     * @param clazz The type which the entity must subclass
     * @return the argument
     */
    public static CommandElement entityOrTarget(Text key, Class<? extends Entity> clazz) {
        return new EntityCommandElement(key, false, true, clazz);
    }

    /**
     * Expect an argument to represent an {@link Entity} of the specified
     * {@link EntityType}, or if the argument is not present and the
     * {@link CommandSource} is looking at an applicable entity, return that
     * entity.
     *
     * <p>This argument accepts the following inputs:</p>
     *
     * <ul>
     *     <li>A player's name (if appropriate)</li>
     *     <li>An entity's {@link UUID}</li>
     *     <li>A regex that matches the beginning of one or more player's names
     *     or entities UUIDs.
     *     </li>
     *     <li>A selector</li>
     * </ul>
     *
     * @param key The key to store under
     * @param type The type which the entity must be
     * @return the argument
     */
    public static CommandElement entityOrTarget(Text key, EntityType type) {
        return new EntityCommandElement(key, false, true, type);
    }

    private static class EntityCommandElement extends SelectorCommandElement {

        private final boolean returnTarget;
        private final boolean returnSource;
        @Nullable
        private final Class<? extends Entity> clazz;
        @Nullable
        private final EntityType type;

        protected EntityCommandElement(Text key, boolean returnSource, boolean returnTarget,
                                       @Nullable Class<? extends Entity> clazz) {
            super(key);
            this.returnSource = returnSource;
            this.returnTarget = returnTarget;
            this.clazz = clazz;
            this.type = null;
        }

        protected EntityCommandElement(Text key, boolean returnSource, boolean returnTarget,
                                       @Nullable EntityType type) {
            super(key);
            this.returnSource = returnSource;
            this.returnTarget = returnTarget;
            this.clazz = null;
            this.type = type;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            if (!args.hasNext()) {
                if (this.returnSource) {
                    return tryReturnSource(source, args, true);
                }
                if (this.returnTarget) {
                    return tryReturnTarget(source, args);
                }
            }

            CommandArgs.Snapshot state = args.getSnapshot();
            try {
                Iterable<Entity> entities = (Iterable<Entity>) super.parseValue(source, args);
                for (Entity entity : entities) {
                    if (!this.checkEntity(entity)) {
                        Text name;
                        if (this.type == null) {
                            name = Sponge.getRegistry().getAllOf(EntityType.class).stream()
                                    .filter(t -> t.getEntityClass().equals(this.clazz)).findFirst()
                                    .map(EntityType::getTranslation).<Text>map(Text::of)
                                    .orElse(Text.of(this.clazz.getSimpleName()));
                        } else {
                            name = Text.of(this.type);
                        }
                        throw args.createError(Text.of("The entity is not of the required type! (", name, ")"));
                    }
                }
                return entities;
            } catch (ArgumentParseException ex) {
                if (this.returnSource) {
                    args.applySnapshot(state);
                    return tryReturnSource(source, args, true);
                }
                throw ex;
            }
        }

        @Override
        protected Iterable<String> getChoices(CommandSource source) {
            Set<String> worldEntities = Sponge.getServer().getWorlds().stream().flatMap(x -> x.getEntities().stream())
                    .filter(this::checkEntity)
                    .map(x -> x.getUniqueId().toString())
                    .collect(Collectors.toSet());
            Collection<Player> players = Sponge.getServer().getOnlinePlayers();
            if (!players.isEmpty() && checkEntity(players.iterator().next())) {
                final Set<String> setToReturn = new HashSet<>(worldEntities); // to ensure mutability
                players.forEach(x -> setToReturn.add(x.getName()));
                return setToReturn;
            }

            return worldEntities;
        }

        @Override
        protected Object getValue(String choice) throws IllegalArgumentException {
            UUID uuid;
            try {
                uuid = UUID.fromString(choice);
            } catch (IllegalArgumentException ignored) {
                // Player could be a name
                return Sponge.getServer().getPlayer(choice)
                        .orElseThrow(() -> new IllegalArgumentException("Input value " + choice + " does not represent a valid entity"));
            }
            boolean found = false;
            for (World world : Sponge.getServer().getWorlds()) {
                Optional<Entity> ret = world.getEntity(uuid);
                if (ret.isPresent()) {
                    Entity entity = ret.get();
                    if (this.checkEntity(entity)) {
                        return entity;
                    }
                    found = true;
                }
            }
            if (found) {
                throw new IllegalArgumentException("Input value " + choice + " was not an entity of the required type!");
            }
            throw new IllegalArgumentException("Input value " + choice + " was not an entity");
        }

        private Entity tryReturnSource(CommandSource source, CommandArgs args, boolean check) throws ArgumentParseException {
            if (source instanceof Entity && (!check || this.checkEntity((Entity) source))) {
                return (Entity) source;
            }
            if (source instanceof ProxySource) {
                CommandSource proxy = ((ProxySource) source).getOriginalSource();
                if (proxy instanceof Entity && (!check || this.checkEntity((Entity) proxy))) {
                    return (Entity) proxy;
                }
            }
            throw args.createError(t("No entities matched and source was not an entity!"));
        }

        private Entity tryReturnTarget(CommandSource source, CommandArgs args) throws ArgumentParseException {
            Entity entity = tryReturnSource(source, args, false);
            return entity.getWorld().getIntersectingEntities(entity, 10).stream()
                    .filter(e -> !e.getEntity().equals(entity)).map(EntityUniverse.EntityHit::getEntity)
                    .filter(this::checkEntity).findFirst()
                    .orElseThrow(() -> args.createError(t("No entities matched and source was not looking at a valid entity!")));
        }

        private boolean checkEntity(Entity entity) {
            if (this.clazz == null && this.type == null) {
                return true;
            } else if (this.clazz == null) {
                return entity.getType().equals(this.type);
            } else {
                return this.clazz.isAssignableFrom(entity.getClass());
            }
        }

        @Override
        public Text getUsage(CommandSource src) {
            return src instanceof Entity && (this.returnSource || this.returnTarget) ? Text.of("[", this.getKey(), "]") : super.getUsage(src);
        }
    }

    /**
     * Expect an argument to represent a {@link URL}.
     *
     * <p>This will return only one value.</p>
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement url(Text key) {
        return new UrlElement(key);
    }

    private static class UrlElement extends KeyElement {

        protected UrlElement(Text key) {
            super(key);
        }

        @Nullable
        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            String str = args.next();
            URL url;
            try {
                url = new URL(str);
            } catch (MalformedURLException ex) {
                throw new ArgumentParseException(Text.of("Invalid URL!"), ex, str, 0);
            }
            try {
                url.toURI();
            } catch (URISyntaxException ex) {
                throw new ArgumentParseException(Text.of("Invalid URL!"), ex, str, 0);
            }
            return url;
        }
    }

    /**
     * Expect an argument to return an IP address, in the form of an
     * {@link InetAddress}.
     *
     * <p>This will return only one value.</p>
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement ip(Text key) {
        return new IpElement(key, false);
    }

    /**
     * Expect an argument to return an IP address, in the form of an
     * {@link InetAddress}, or if nothing matches and the source is a
     * {@link RemoteSource}, return the source's address.
     *
     * <p>This will return only one value.</p>
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement ipOrSource(Text key) {
        return new IpElement(key, true);
    }

    private static class IpElement extends KeyElement {

        private final boolean self;
        private final PlayerCommandElement possiblePlayer;

        protected IpElement(Text key, boolean self) {
            super(key);
            this.self = self;
            this.possiblePlayer = new PlayerCommandElement(key, false);
        }

        @Nullable
        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            if (!args.hasNext() && this.self) {
                if (source instanceof RemoteSource) {
                    return ((RemoteSource) source).getConnection().getAddress().getAddress();
                } else {
                    throw args.createError(Text.of("No IP address was specified!"));
                }
            }
            CommandArgs.Snapshot state = args.getSnapshot();
            String s = args.next();
            try {
                return InetAddress.getByName(s);
            } catch (UnknownHostException e) {
                try {
                    return ((Player) this.possiblePlayer.parseValue(source, args)).getConnection().getAddress().getAddress();
                } catch (ArgumentParseException ex) {
                    if (this.self && source instanceof RemoteSource) {
                        args.applySnapshot(state);
                        return ((RemoteSource) source).getConnection().getAddress().getAddress();
                    }
                    throw args.createError(Text.of("Invalid IP address!"));
                }
            }
        }

        @Override
        public Text getUsage(CommandSource src) {
            return src instanceof RemoteSource && this.self ? Text.of("[", super.getUsage(src), "]") : super.getUsage(src);
        }

    }

    /**
     * Expect an argument to return a {@link BigDecimal}.
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement bigDecimal(Text key) {
        return new BigDecimalElement(key);
    }

    private static class BigDecimalElement extends KeyElement {

        protected BigDecimalElement(Text key) {
            super(key);
        }

        @Nullable
        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            String next = args.next();
            try {
                return new BigDecimal(next);
            } catch (NumberFormatException ex) {
                throw args.createError(Text.of("Expected a number, but input " + next + " was not"));
            }
        }
    }

    /**
     * Expect an argument to return a {@link BigInteger}.
     *
     * <p>This will return only one value.</p>
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement bigInteger(Text key) {
        return new BigIntegerElement(key);
    }

    private static class BigIntegerElement extends KeyElement {

        protected BigIntegerElement(Text key) {
            super(key);
        }

        @Nullable
        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            String integerString = args.next();
            try {
                return new BigInteger(integerString);
            } catch (NumberFormatException ex) {
                throw args.createError(Text.of("Expected an integer, but input " + integerString + " was not"));
            }
        }
    }

    /**
     * Expect an argument to be a valid {@link DataContainer}.
     *
     * <p>This will return only one value.</p>
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement dataContainer(Text key) {
        return new DataElement(key);
    }

    private static class DataElement extends RemainingJoinedStringsCommandElement {

        protected DataElement(Text key) {
            super(key, true);
        }

        @Nullable
        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            String argument = (String) super.parseValue(source, args);
            Callable<BufferedReader> reader = () -> new BufferedReader(new StringReader(argument));
            ConfigurationLoader<? extends ConfigurationNode> loader = HoconConfigurationLoader.builder()
                    .setSource(reader).build();
            ConfigurationNode node;
            try {
                node = loader.load();
            } catch (IOException ex) {
                throw args.createError(Text.of("Node parsing failed: ", ex.getMessage()));
            }
            return DataTranslators.CONFIGURATION_NODE.translate(node);
        }

    }

    /**
     * Expect an argument to be a {@link UUID}.
     *
     * <p>This will return only one value.</p>
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement uuid(Text key) {
        return new UuidElement(key);
    }

    private static class UuidElement extends KeyElement {

        protected UuidElement(Text key) {
            super(key);
        }

        @Nullable
        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            try {
                return UUID.fromString(args.next());
            } catch (IllegalArgumentException ex) {
                throw args.createError(Text.of("Invalid UUID!"));
            }
        }

    }

    /**
     * Expect an argument to be valid {@link Text}.
     *
     * <p>This will return only one value.</p>
     *
     * @param key The key to store under
     * @param serializer The serializer to parse the text with
     * @param allRemaining If true, consumes all remaining arguments; if false,
     *                     uses a single argument
     * @return the argument
     */
    public static CommandElement text(Text key, TextSerializer serializer, boolean allRemaining) {
        return new TextCommandElement(key, serializer, allRemaining);
    }

    private static class TextCommandElement extends KeyElement {

        private final TextSerializer serializer;
        private final boolean allRemaining;
        private final RemainingJoinedStringsCommandElement joinedElement;

        protected TextCommandElement(Text key, TextSerializer serializer, boolean allRemaining) {
            super(key);
            this.serializer = serializer;
            this.allRemaining = allRemaining;
            this.joinedElement = allRemaining ? new RemainingJoinedStringsCommandElement(key, false) : null;
        }

        @Nullable
        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            String arg = this.allRemaining ? (String) this.joinedElement.parseValue(source, args) : args.next();
            try {
                return this.serializer.deserialize(arg);
            } catch (TextParseException ex) {
                if (this.serializer == TextSerializers.JSON) {
                    if (ex.getMessage() == null) {
                        throw args.createError(Text.of("Invalid JSON text!"));
                    } else {
                        throw args.createError(Text.of("Invalid JSON text: ", ex.getMessage()));
                    }
                } else {
                    if (ex.getMessage() == null) {
                        throw args.createError(Text.of("Invalid text!"));
                    } else {
                        throw args.createError(Text.of("Invalid text: ", ex.getMessage()));
                    }
                }
            }
        }
    }

    /**
     * Expect an argument to be a date-time, in the form of a
     * {@link LocalDateTime}. If no date is specified, {@link LocalDate#now()}
     * is used; if no time is specified, {@link LocalTime#MIDNIGHT} is used.
     *
     * <p>Date-times are expected in the ISO-8601 format.</p>
     *
     * <p>This will return only one value.</p>
     *
     * @param key The key to store under
     * @return the argument
     * @see <a href="https://en.wikipedia.org/wiki/ISO_8601">ISO-8601</a>
     */
    public static CommandElement dateTime(Text key) {
        return new DateTimeElement(key, false);
    }

    /**
     * Expect an argument to be a date-time, in the form of a
     * {@link LocalDateTime}. If no date is specified, {@link LocalDate#now()}
     * is used; if no time is specified, {@link LocalTime#MIDNIGHT} is used.
     *
     * <p>If no argument at all is specified, defaults to
     * {@link LocalDateTime#now()}.</p>
     *
     * <p>Date-times are expected in the ISO-8601 format.</p>
     *
     * <p>This will return only one value.</p>
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement dateTimeOrNow(Text key) {
        return new DateTimeElement(key, true);
    }

    private static class DateTimeElement extends CommandElement {

        private final boolean returnNow;

        protected DateTimeElement(Text key, boolean returnNow) {
            super(key);
            this.returnNow = returnNow;
        }

        @Nullable
        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            if (!args.hasNext() && this.returnNow) {
                return LocalDateTime.now();
            }
            CommandArgs.Snapshot state = args.getSnapshot();
            String date = args.next();
            try {
                return LocalDateTime.parse(date);
            } catch (DateTimeParseException ex) {
                try {
                    return LocalDateTime.of(LocalDate.now(), LocalTime.parse(date));
                } catch (DateTimeParseException ex2) {
                    try {
                        return LocalDateTime.of(LocalDate.parse(date), LocalTime.MIDNIGHT);
                    } catch (DateTimeParseException ex3) {
                        if (this.returnNow) {
                            args.applySnapshot(state);
                            return LocalDateTime.now();
                        }
                        throw args.createError(Text.of("Invalid date-time!"));
                    }
                }
            }
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            String date = LocalDateTime.now().withNano(0).toString();
            if (date.startsWith(args.nextIfPresent().orElse(""))) {
                return ImmutableList.of(date);
            } else {
                return ImmutableList.of();
            }
        }

        @Override
        public Text getUsage(CommandSource src) {
            if (!this.returnNow) {
                return super.getUsage(src);
            } else {
                return Text.of("[", this.getKey(), "]");
            }
        }
    }

    /**
     * Expect an argument to be a {@link Duration}.
     *
     * <p>Durations are expected in the following format: {@code #D#H#M#S}.
     * This is not case sensitive.</p>
     *
     * <p>This will return only one value.</p>
     *
     * @param key The key to store under
     * @return the argument
     */
    public static CommandElement duration(Text key) {
        return new DurationElement(key);
    }

    private static class DurationElement extends KeyElement {

        protected DurationElement(Text key) {
            super(key);
        }

        @Nullable
        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            String s = args.next().toUpperCase();
            if (!s.contains("T")) {
                if (s.contains("D")) {
                    if (s.contains("H") || s.contains("M") || s.contains("S")) {
                        s = s.replace("D", "DT");
                    }
                } else {
                    if (s.startsWith("P")) {
                        s = "PT" + s.substring(1);
                    } else {
                        s = "T" + s;
                    }
                }
            }
            if (!s.startsWith("P")) {
                s = "P" + s;
            }
            try {
                return Duration.parse(s);
            } catch (DateTimeParseException ex) {
                throw args.createError(Text.of("Invalid duration!"));
            }
        }
    }

    /**
     * Uses a custom set of suggestions for an argument. The provided
     * suggestions will replace the regular ones.
     *
     * @param argument The element to replace the suggestions of
     * @param suggestions The suggestions to use
     * @return the argument
     */
    public static CommandElement withSuggestions(CommandElement argument, Iterable<String> suggestions) {
        return withSuggestions(argument, suggestions, true);
    }

    /**
     * Uses a custom set of suggestions for an argument. The provided
     * suggestions will replace the regular ones.
     *
     * <p>If {@code requireBegin} is false, then the already typed argument
     * will not be used to filter the provided suggestions.</p>
     *
     * @param argument The element to replace the suggestions of
     * @param suggestions The suggestions to use
     * @param requireBegin Whether or not to require the current argument to
     *                     begin provided arguments
     * @return the argument
     */
    public static CommandElement withSuggestions(CommandElement argument, Iterable<String> suggestions, boolean requireBegin) {
        return withSuggestions(argument, (s) -> suggestions, requireBegin);
    }

    /**
     * Uses a custom set of suggestions for an argument. The provided
     * suggestions will replace the regular ones.
     *
     * @param argument The element to replace the suggestions of
     * @param suggestions A function to return the suggestions to use
     * @return the argument
     */
    public static CommandElement withSuggestions(CommandElement argument, Function<CommandSource, Iterable<String>> suggestions) {
        return withSuggestions(argument, suggestions, true);
    }

    /**
     * Uses a custom set of suggestions for an argument. The provided
     * suggestions will replace the regular ones.
     *
     * <p>If {@code requireBegin} is false, then the already typed argument
     * will not be used to filter the provided suggestions.</p>
     *
     * @param argument The element to replace the suggestions of
     * @param suggestions A function to return the suggestions to use
     * @param requireBegin Whether or not to require the current argument to
     *                     begin provided arguments
     * @return the argument
     */
    public static CommandElement withSuggestions(CommandElement argument, Function<CommandSource,
        Iterable<String>> suggestions, boolean requireBegin) {
        return new WithSuggestionsElement(argument, suggestions, requireBegin);
    }

    /**
     * Filters an argument's suggestions. A suggestion will only be used if it
     * matches the predicate.
     *
     * @param argument The element to filter the suggestions of
     * @param predicate The predicate to test suggestions against
     * @return the argument
     */
    public static CommandElement withConstrainedSuggestions(CommandElement argument, Predicate<String> predicate) {
        return new FilteredSuggestionsElement(argument, predicate);
    }

    private static class WithSuggestionsElement extends CommandElement {

        private final CommandElement wrapped;
        private final Function<CommandSource, Iterable<String>> suggestions;
        private final boolean requireBegin;

        protected WithSuggestionsElement(CommandElement wrapped, Function<CommandSource, Iterable<String>> suggestions, boolean requireBegin) {
            super(wrapped.getKey());
            this.wrapped = wrapped;
            this.suggestions = suggestions;
            this.requireBegin = requireBegin;
        }

        @Nullable
        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            return this.wrapped.parseValue(source, args);
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            if (this.requireBegin) {
                String arg = args.nextIfPresent().orElse("");
                return ImmutableList.copyOf(Iterables.filter(this.suggestions.apply(src), f -> f.startsWith(arg)));
            } else {
                return ImmutableList.copyOf(this.suggestions.apply(src));
            }
        }

    }

    private static class FilteredSuggestionsElement extends CommandElement {

        private final CommandElement wrapped;
        private final Predicate<String> predicate;

        protected FilteredSuggestionsElement(CommandElement wrapped, Predicate<String> predicate) {
            super(wrapped.getKey());
            this.wrapped = wrapped;
            this.predicate = predicate;
        }

        @Nullable
        @Override
        protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            return this.wrapped.parseValue(source, args);
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
            return this.wrapped.complete(src, args, context).stream().filter(this.predicate).collect(ImmutableList.toImmutableList());
        }

    }

}
