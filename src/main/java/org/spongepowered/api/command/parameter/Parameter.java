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
package org.spongepowered.api.command.parameter;

import io.leangen.geantyref.TypeToken;
import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Game;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Server;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.command.Command;
import org.spongepowered.api.command.CommandCause;
import org.spongepowered.api.command.CommandExecutor;
import org.spongepowered.api.command.exception.ArgumentParseException;
import org.spongepowered.api.command.parameter.managed.ValueCompleter;
import org.spongepowered.api.command.parameter.managed.ValueParameter;
import org.spongepowered.api.command.parameter.managed.ValueParameterModifier;
import org.spongepowered.api.command.parameter.managed.ValueParser;
import org.spongepowered.api.command.parameter.managed.ValueUsage;
import org.spongepowered.api.command.parameter.managed.operator.Operator;
import org.spongepowered.api.command.parameter.managed.standard.ResourceKeyedValueParameters;
import org.spongepowered.api.command.parameter.managed.standard.VariableValueParameters;
import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.Cause;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.DefaultedRegistryType;
import org.spongepowered.api.registry.Registry;
import org.spongepowered.api.registry.RegistryHolder;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryType;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.util.Builder;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.world.server.ServerLocation;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.configurate.util.Types;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.plugin.PluginContainer;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Defines how an element of a command argument string should be parsed.
 *
 * <p>Parameters that parse input and return an object into the
 * {@link CommandContext} should be of type {@link Parameter.Value} in
 * order to maximize type safety. However, there are also other important
 * ways that parameters can be used:</p>
 *
 * <ul>
 *     <li>{@link #firstOfBuilder(Parameter)} allows for multiple parameters that
 *     do not have the same return type to attempt to parse an input
 *     successfully.</li>
 *     <li>{@link #seqBuilder(Parameter)} allows for the grouping of multiple
 *     parameters that will be executed one after another.</li>
 *     <li>{@link Subcommand}s can be placed anywhere in a parameter
 *     chain where a {@link Parameter} can be added, if successfully parsed,
 *     any containing {@link Command} would take precedence and its
 *     {@link Command#process(CommandCause, ArgumentReader.Mutable)} method will be called instead
 *     of any parent.</li>
 * </ul>
 *
 * <p>{@link Parameter}s are intended for use with {@link org.spongepowered.api.command.Command.Builder}s.
 * </p>
 */
public interface Parameter {

    /**
     * Creates a {@link Parameter.Key} for storing values against.
     *
     * @param key The string key
     * @param typeToken The type of value that this key represents
     * @param <T> The type
     * @return The {@link Key}
     */
    static <T> Key<T> key(@NonNull final String key, @NonNull final TypeToken<T> typeToken) {
        return Sponge.game().builderProvider().provide(Key.Builder.class).build(key, typeToken);
    }

    /**
     * Creates a {@link Parameter.Key} for storing values against.
     *
     * @param key The string key
     * @param type The type of value that this key represents. Must not omit any
     *             type parameters.
     * @param <T> The type
     * @return The {@link Key}
     */
    static <T> Key<T> key(@NonNull final String key, @NonNull final Class<T> type) {
        Types.requireCompleteParameters(type);
        return Sponge.game().builderProvider().provide(Key.Builder.class).build(key, type);
    }

    /**
     * Gets a builder that builds a {@link Parameter.Value}.
     *
     * <p>If your parameter type is generic, use
     * {@link #builder(TypeToken)} instead.</p>
     *
     * @param <T> The type of parameter
     * @param valueClass The type of value class
     * @return The {@link Value.Builder}
     */
    static <T> Value.Builder<T> builder(@NonNull final Class<T> valueClass) {
        return Sponge.game().factoryProvider().provide(Factory.class).createParameterBuilder(valueClass);
    }

    /**
     * Gets a builder that builds a {@link Parameter.Value}.
     *
     * @param <T> The type of parameter
     * @param typeToken The type of value class as a {@link TypeToken}
     * @return The {@link Value.Builder}
     */
    static <T> Value.Builder<T> builder(@NonNull final TypeToken<T> typeToken) {
        return Sponge.game().factoryProvider().provide(Factory.class).createParameterBuilder(typeToken);
    }

    /**
     * Gets a builder that builds a {@link Parameter.Value}.
     *
     * <p>If your parameter type is generic, use
     * {@link #builder(TypeToken, ValueParameter)} instead.</p>
     *
     * @param <T> The type of parameter
     * @param valueClass The type of value class as a {@link Class}
     * @param parameter The value parameter
     * @return The {@link Value.Builder}
     */
    static <T> Value.Builder<T> builder(@NonNull final Class<T> valueClass, @NonNull final ValueParameter<? extends T> parameter) {
        return Parameter.builder(valueClass).addParser(parameter);
    }

    /**
     * Gets a builder that builds a {@link Parameter.Value}.
     *
     * @param <T> The type of parameter
     * @param typeToken The type of value class as a {@link TypeToken}
     * @param parameter The value parameter
     * @return The {@link Value.Builder}
     */
    static <T> Value.Builder<T> builder(@NonNull final TypeToken<T> typeToken, @NonNull final ValueParameter<? extends T> parameter) {
        return Parameter.builder(typeToken).addParser(parameter);
    }

    /**
     * Gets a builder that builds a {@link Parameter.Value}.
     *
     * @param <T> The type of parameter
     * @param <V> The {@link ValueParameter} to be used as a parser
     * @param parameter The value parameter
     * @param valueClass The type of value class
     * @return The {@link Value.Builder}
     */
    static <T, V extends ValueParameter<T>> Value.Builder<T> builder(@NonNull final Class<T> valueClass, @NonNull final DefaultedRegistryReference<V> parameter) {
        return Parameter.builder(valueClass, parameter.get());
    }

    /**
     * Gets a builder that builds a {@link Parameter.Value}.
     *
     * @param <T> The type of parameter
     * @param <V> The {@link ValueParameter} to be used as a parser
     * @param parameter The value parameter
     * @param typeToken The type of value class as a {@link TypeToken}
     * @return The {@link Value.Builder}
     */
    static <T, V extends ValueParameter<T>> Value.Builder<T> builder(@NonNull final TypeToken<T> typeToken, @NonNull final Supplier<V> parameter) {
        return Parameter.builder(typeToken, parameter.get());
    }

    /**
     * Gets a {@link Parameter} that represents a subcommand.
     *
     * <p>If a {@link Subcommand} alias in a parameter chain
     * is successfully matched, then element parsing will continue
     * with the parameters supplied to {@link Command}. It is
     * implementation dependent as to what happens if a subcommand
     * fails to parse.</p>
     *
     * @param subcommand The {@link Command} to execute
     * @param alias The first alias of the subcommand
     * @param aliases Subsequent aliases, if any
     * @return The {@link Subcommand} for use in a {@link Parameter} chain
     */
    static Subcommand subcommand(final Command.@NonNull Parameterized subcommand, @NonNull final String alias, final String @NonNull... aliases) {
        final Subcommand.Builder builder = Sponge.game().builderProvider().provide(Subcommand.Builder.class)
                .subcommand(subcommand)
                .addAlias(alias);
        for (final String a : aliases) {
            builder.addAlias(a);
        }

        return builder.build();
    }

    /**
     * Returns a {@link Parameter.FirstOfBuilder} that allows plugins to attempt
     * to parse an argument using the supplied parameters in order. Once a
     * parameter has parsed the argument successfully, no more parameters
     * supplied here will be attempted.
     *
     * @param parameter The first {@link Parameter}
     * @return The {@link Parameter.FirstOfBuilder} to continue chaining
     */
    static Parameter.FirstOfBuilder firstOfBuilder(@NonNull final Parameter parameter) {
        return Sponge.game().builderProvider().provide(FirstOfBuilder.class).or(parameter);
    }

    /**
     * Returns a {@link Parameter} that attempts to parse an argument using the
     * supplied parameters in order. Once a parameter has parsed the argument
     * successfully, no more parameters supplied here will be attempted.
     *
     * @param first The first {@link Parameter} that should be used for parsing
     * @param second The second {@link Parameter} that should be used for
     *               parsing, should the first {@link Parameter} fail to do so
     * @param parameters The remaining {@link Parameter}s
     * @return The {@link Parameter}
     */
    static Parameter firstOf(@NonNull final Parameter first, @NonNull final Parameter second, final Parameter @NonNull... parameters) {
        return Sponge.game().builderProvider().provide(FirstOfBuilder.class).or(first).or(second).orFirstOf(parameters).build();
    }

    /**
     * Returns a {@link Parameter} that attempts to parse an argument using the
     * supplied parameters in order. Once a parameter has parsed the argument
     * successfully, no more parameters supplied here will be attempted.
     *
     * @param parameters The {@link Parameter}s
     * @return The {@link Parameter}
     */
    static Parameter firstOf(@NonNull final Iterable<Parameter> parameters) {
        return Sponge.game().builderProvider().provide(FirstOfBuilder.class).orFirstOf(parameters).build();
    }

    /**
     * Returns a {@link Parameter.SequenceBuilder} that parses arguments using
     * the supplied parameters in order.
     *
     * @param parameter The first {@link Parameter} in the sequence
     * @return The {@link Parameter.SequenceBuilder}, to continue building the
     *         chain
     */
    static Parameter.SequenceBuilder seqBuilder(@NonNull final Parameter parameter) {
        return Sponge.game().builderProvider().provide(SequenceBuilder.class).then(parameter);
    }

    /**
     * Returns a {@link Parameter} that parses arguments using the supplied
     * parameters in order.
     *
     * @param first The first {@link Parameter} that should be used for parsing
     * @param second The second {@link Parameter} that should be used for
     *               parsing
     * @param parameters The subsequent {@link Parameter}s to parse
     * @return The {@link Parameter}
     */
    static Parameter seq(@NonNull final Parameter first, @NonNull final Parameter second, final Parameter @NonNull... parameters) {
        return Sponge.game().builderProvider().provide(SequenceBuilder.class).then(first).then(second).then(parameters).build();
    }

    /**
     * Returns a {@link Parameter} that parses arguments using the supplied
     * parameters in order.
     *
     * @param parameters The {@link Parameter}s
     * @return The {@link Parameter}
     */
    static Parameter seq(@NonNull final Iterable<Parameter> parameters) {
        return Sponge.game().builderProvider().provide(SequenceBuilder.class).then(parameters).build();
    }

    // Convenience methods for getting the common parameter types - all in once place.
    // Modifiers (for the most part) are on the Parameter.Builder itself.

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#BIG_DECIMAL}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<BigDecimal> bigDecimal() {
        return Parameter.builder(BigDecimal.class, ResourceKeyedValueParameters.BIG_DECIMAL);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#BIG_INTEGER}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<BigInteger> bigInteger() {
        return Parameter.builder(BigInteger.class, ResourceKeyedValueParameters.BIG_INTEGER);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#BLOCK_STATE}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<BlockState> blockState() {
        return Parameter.builder(BlockState.class, ResourceKeyedValueParameters.BLOCK_STATE);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#BOOLEAN}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<Boolean> bool() {
        return Parameter.builder(Boolean.class, ResourceKeyedValueParameters.BOOLEAN);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#COLOR}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<Color> color() {
        return Parameter.builder(Color.class, ResourceKeyedValueParameters.COLOR);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#DATA_CONTAINER}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<DataContainer> dataContainer() {
        return Parameter.builder(DataContainer.class, ResourceKeyedValueParameters.DATA_CONTAINER);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#DATE_TIME}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<LocalDateTime> dateTime() {
        return Parameter.builder(LocalDateTime.class, ResourceKeyedValueParameters.DATE_TIME);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#DURATION}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<Duration> duration() {
        return Parameter.builder(Duration.class, ResourceKeyedValueParameters.DURATION);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#DOUBLE}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<Double> doubleNumber() {
        return Parameter.builder(Double.class, ResourceKeyedValueParameters.DOUBLE);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#ENTITY}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<Entity> entity() {
        return Parameter.builder(Entity.class, ResourceKeyedValueParameters.ENTITY);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#ENTITY}
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<Entity> entityOrTarget() {
        return Parameter.entity().addParser(ResourceKeyedValueParameters.TARGET_ENTITY);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#TEXT_FORMATTING_CODE}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<Component> formattingCodeText() {
        return Parameter.builder(Component.class, ResourceKeyedValueParameters.TEXT_FORMATTING_CODE);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#TEXT_FORMATTING_CODE_ALL}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<Component> formattingCodeTextOfRemainingElements() {
        return Parameter.builder(Component.class, ResourceKeyedValueParameters.TEXT_FORMATTING_CODE_ALL);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#INTEGER}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<Integer> integerNumber() {
        return Parameter.builder(Integer.class, ResourceKeyedValueParameters.INTEGER);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#IP}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<InetAddress> ip() {
        return Parameter.builder(InetAddress.class, ResourceKeyedValueParameters.IP);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#ITEM_STACK_SNAPSHOT}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<ItemStackSnapshot> itemStackSnapshot() {
        return Parameter.builder(ItemStackSnapshot.class, ResourceKeyedValueParameters.ITEM_STACK_SNAPSHOT);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#TEXT_JSON}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<Component> jsonText() {
        return Parameter.builder(Component.class, ResourceKeyedValueParameters.TEXT_JSON);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#TEXT_JSON_ALL}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<Component> jsonTextOfRemainingElements() {
        return Parameter.builder(Component.class, ResourceKeyedValueParameters.TEXT_JSON_ALL);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#LOCATION}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<ServerLocation> location() {
        return Parameter.builder(ServerLocation.class, ResourceKeyedValueParameters.LOCATION);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#LONG}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<Long> longNumber() {
        return Parameter.builder(Long.class, ResourceKeyedValueParameters.LONG);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#OPERATOR}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<Operator> operator() {
        return Parameter.builder(Operator.class, ResourceKeyedValueParameters.OPERATOR);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#PLAYER}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<ServerPlayer> player() {
        return Parameter.builder(ServerPlayer.class, ResourceKeyedValueParameters.PLAYER);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#PLAYER}, else the target
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<ServerPlayer> playerOrTarget() {
        return Parameter.player().addParser(ResourceKeyedValueParameters.TARGET_PLAYER);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#PLUGIN}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<PluginContainer> plugin() {
        return Parameter.builder(PluginContainer.class, ResourceKeyedValueParameters.PLUGIN);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link VariableValueParameters#doubleRange()}, using the specified
     * bounds (inclusive).
     *
     * @param min The minimum value.
     * @param max The maximum value.
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<Double> rangedDouble(final double min, final double max) {
        return Parameter.builder(Double.class).addParser(VariableValueParameters.doubleRange().min(min).max(max).build());
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link VariableValueParameters#integerRange()}, using the specified
     * bounds (inclusive).
     *
     * @param min The minimum value.
     * @param max The maximum value.
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<Integer> rangedInteger(final int min, final int max) {
        return Parameter.builder(Integer.class).addParser(VariableValueParameters.integerRange().min(min).max(max).build());
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#REMAINING_JOINED_STRINGS}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<String> remainingJoinedStrings() {
        return Parameter.builder(String.class, ResourceKeyedValueParameters.REMAINING_JOINED_STRINGS);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#RESOURCE_KEY}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<ResourceKey> resourceKey() {
        return Parameter.builder(ResourceKey.class, ResourceKeyedValueParameters.RESOURCE_KEY);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#STRING}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<String> string() {
        return Parameter.builder(String.class, ResourceKeyedValueParameters.STRING);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#URL}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<URL> url() {
        return Parameter.builder(URL.class, ResourceKeyedValueParameters.URL);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#USER}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<User> user() {
        return Parameter.builder(User.class, ResourceKeyedValueParameters.USER);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#UUID}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<UUID> uuid() {
        return Parameter.builder(UUID.class, ResourceKeyedValueParameters.UUID);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to
     * {@link ResourceKeyedValueParameters#VECTOR3D}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<Vector3d> vector3d() {
        return Parameter.builder(Vector3d.class, ResourceKeyedValueParameters.VECTOR3D);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} set to {@link ResourceKeyedValueParameters#WORLD}.
     *
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<ServerWorld> world() {
        return Parameter.builder(ServerWorld.class, ResourceKeyedValueParameters.WORLD);
    }

    /**
     * Creates a builder that has the {@link ValueParameter} that allows you to
     * choose from cataloged types.
     *
     * <p>See {@link VariableValueParameters.RegistryEntryBuilder
     * #defaultNamespace(String)} for how default namespaces work.</p>
     *
     * <p>If the {@link Game} or {@link Server} scoped {@link RegistryHolder}
     * is required,
     * {@link VariableValueParameters.RegistryEntryBuilder#GLOBAL_HOLDER_PROVIDER}
     * or {@link VariableValueParameters.RegistryEntryBuilder#SERVER_HOLDER_PROVIDER}
     * may be used.</p>
     *
     * @param type The registry value type to check for choices
     * @param holderProvider A {@link Function} that provides the appropriate
     *      {@link RegistryHolder} to get the appropriate {@link Registry}
     * @param registryKey The {@link RegistryKey} that represents the target
     *      {@link Registry}
     * @param defaultNamespaces The default namespaces that will be used with the
     *  provided value if the supplied argument is un-namespaced
     * @param <T> The type of registry value
     * @return A {@link Parameter.Value.Builder}
     */
    static <T> Parameter.Value.Builder<T> registryElement(
            final TypeToken<T> type,
            @NonNull final Function<CommandContext, RegistryHolder> holderProvider,
            @NonNull final RegistryType<T> registryKey,
            @NonNull final String @NonNull... defaultNamespaces) {
        final VariableValueParameters.RegistryEntryBuilder<? extends T> vvp =
                VariableValueParameters.registryEntryBuilder(holderProvider, registryKey);
        for (final String namespace : defaultNamespaces) {
            vvp.defaultNamespace(namespace);
        }
        return Parameter.builder(type, vvp.build());
    }

    /**
     * Creates a builder that has the {@link ValueParameter} that allows you to
     * choose from types registered in a given {@link Registry}.
     *
     * <p>See {@link VariableValueParameters.RegistryEntryBuilder
     * #defaultNamespace(String)} for how default namespaces work.</p>
     *
     * @param type The registry value type to check for choices
     * @param registryType The {@link DefaultedRegistryType} to use
     *          when retrieving objects
     * @param defaultNamespaces The default namespaces that will be used with the
     *  provided value if the supplied argument is un-namespaced
     * @param <T> The type of registyr value
     * @return A {@link Parameter.Value.Builder}
     */
    static <T> Parameter.Value.Builder<T> registryElement(
            final TypeToken<T> type,
            @NonNull final DefaultedRegistryType<T> registryType,
            @NonNull final String @NonNull... defaultNamespaces) {
        final VariableValueParameters.RegistryEntryBuilder<? extends T> vvp =
                VariableValueParameters.registryEntryBuilder(registryType);
        for (final String namespace : defaultNamespaces) {
            vvp.defaultNamespace(namespace);
        }
        return Parameter.builder(type, vvp.build());
    }

    /**
     * Creates a builder that has a {@link ValueParameter} that allows you to
     * specify a set of choices that must be chosen from
     *
     * <p>This will return a parser that will return {@link String}s</p>
     *
     * @param choices The choices
     * @return A {@link Parameter.Value.Builder}
     */
    static Parameter.Value.Builder<String> choices(final String @NonNull... choices) {
        final VariableValueParameters.StaticChoicesBuilder<String> builder = VariableValueParameters
                .staticChoicesBuilder(String.class)
                .showInUsage(true);
        for (final String choice : choices) {
            builder.addChoice(choice, choice);
        }

        return Parameter.builder(String.class, builder.build());
    }

    /**
     * Creates a builder that has a {@link ValueParameter} that allows you to
     * specify a set of choices that must be chosen from. These choices map to
     * objects that will get put in the {@link CommandContext} when a choice is
     * selected.
     *
     * @param <T> The type of parameter
     * @param returnType The type of object that will be returned by the parser
     *                   to be built by this builder.
     * @param choices The choices
     * @return A {@link Parameter.Value.Builder}
     */
    static <T> Parameter.Value.Builder<T> choices(@NonNull final Class<T> returnType, @NonNull final Map<String, ? extends T> choices) {
        return Parameter.builder(returnType, VariableValueParameters.staticChoicesBuilder(returnType)
                .addChoices(choices)
                .showInUsage(true).build());
    }

    /**
     * Creates a builder that has a {@link ValueParameter} that allows you to
     * specify a set of choices that must be chosen from. These choices map to
     * objects that will get put in the {@link CommandContext} when a choice is
     * selected, through the use of the {@code valueFunction}.
     *
     * @param <T> The type of parameter
     * @param returnType The type of object that will be returned by the parser
     *                   to be built by this builder.
     * @param valueFunction The function that returns an object to put in the
     *      {@link CommandContext} based on the supplied choice
     * @param choices The choices
     * @return A {@link Parameter.Value.Builder}
     */
    static <T> Parameter.Value.Builder<T> choices(
            @NonNull final Class<T> returnType,
            @NonNull final Function<String, ? extends T> valueFunction,
            @NonNull final Supplier<? extends Collection<String>> choices) {

        return Parameter.builder(returnType,
                VariableValueParameters
                        .dynamicChoicesBuilder(returnType)
                        .showInUsage(true)
                        .choices(choices)
                        .results(valueFunction)
                        .build());
    }

    /**
     * Creates a builder that has a {@link ValueParameter} that requires an
     * argument that matches the name of a supplied {@link Enum} type
     *
     * @param enumClass The {@link Enum} class type
     * @param <T> The type of {@link Enum}
     * @return A {@link Parameter.Value.Builder}
     */
    static <T extends Enum<T>> Parameter.Value.Builder<T> enumValue(@NonNull final Class<T> enumClass) {
        return Parameter.builder(enumClass, VariableValueParameters.enumChoices(enumClass));
    }

    /**
     * Creates a builder that has a {@link ValueParameter} that requires an
     * argument to be a literal specified
     *
     * @param returnType The type of object that will be returned by the parser
     *                   to be built by this builder.
     * @param returnedValue The object to put in the {@link CommandContext} if
     *      the literal matches.
     * @param literal The literal to match
     * @param <T> The type of value
     * @return A {@link Parameter.Value.Builder}
     */
    static <T> Parameter.Value.Builder<T> literal(
            @NonNull final Class<T> returnType,
            @NonNull final T returnedValue,
            final String @NonNull... literal) {
        final Collection<String> iterable = Arrays.asList(literal);
        return Parameter.literal(returnType, returnedValue, () -> iterable);
    }

    /**
     * Creates a builder that has a {@link ValueParameter} that requires an
     * argument to be a literal specified
     *
     * @param <T> The type of parameter
     * @param returnedValue The object to put in the {@link CommandContext} if
     *      the literal matches
     * @param literalSupplier A function that provies the literal to match at
     *      invocation
     * @param returnType The type of return
     * @return A {@link Parameter.Value.Builder}
     */
    static <T> Parameter.Value.Builder<T> literal(
            @NonNull final Class<T> returnType,
            @NonNull final T returnedValue,
            @NonNull final Supplier<? extends Collection<String>> literalSupplier) {
        return Parameter.builder(returnType,
                VariableValueParameters.literalBuilder(returnType)
                        .returnValue(() -> returnedValue)
                        .literal(literalSupplier).build());
    }

    /**
     * Gets whether this parameter is optional.
     *
     * <p>An optional parameter will not throw an exception if it cannot parse
     * an input, instead passing control to another parameter.</p>
     *
     * @return true if optional, else false.
     */
    boolean isOptional();

    /**
     * Gets whether this parameter is known to be able to be explicitly
     * considered a terminal parameter without regarding its place in a
     * command.
     *
     * <p>A terminal parameter will pass control to the command's associated
     * {@link CommandExecutor} if the parameter consumes the end of an input
     * string.</p>
     *
     * <p>Because this parameter may be reused across multiple commands, there
     * may be some circumstances where this parameter will act as a terminal
     * parameter but this is false, such as when this is at the end of a
     * parameter chain or the following parameters are all optional. The return
     * value from this method generally will return whether this element is
     * terminal <strong>without</strong> regard to other parameters in a
     * command.</p>
     *
     * @return true if known to be terminal.
     */
    boolean isTerminal();

    /**
     * A {@link Key}
     *
     * @param <T> The type.
     */
    interface Key<T> {

        /**
         * Gets the string key associated with this parameter.
         *
         * @return The key.
         */
        String key();

        /**
         * Gets the {@link TypeToken} of the type of object that this parameter
         * should return from parsing.
         *
         * @return The {@link TypeToken}
         */
        Type type();

        /**
         * Return whether the value is an instance of this key's value type.
         *
         * @param value value to check
         * @return if instance
         */
        boolean isInstance(Object value);

        /**
         * Cast the provided value to the value type.
         *
         * @param value value
         * @return the casted value
         * @throws ClassCastException if {@code value} is not of the correct type
         */
        T cast(Object value);

        /**
         * A "builder" that allows for keys to be built.
         */
        interface Builder extends ResettableBuilder<Key<?>, Builder> {

            /**
             * Creates a key with the provided key and value class it
             * represents.
             *
             * @param key The key
             * @param typeToken The {@link TypeToken} that represents the
             *                   type of value it stores
             * @param <T> The type of the value represented by the key
             * @return The built {@link Key}
             */
            <T> Key<T> build(@NonNull String key, @NonNull TypeToken<T> typeToken);

            /**
             * Creates a key with the provided key and value class it
             * represents.
             *
             * @param key The key
             * @param type The {@link Class} that represents the
             *                   non-parameterized type of value it stores
             * @param <T> The type of the value represented by the key
             * @return The built {@link Key}
             */
            <T> Key<T> build(@NonNull String key, @NonNull Class<T> type);
        }

    }

    /**
     * Represents a {@link Parameter} that attempts to parse an argument to
     * obtain a value of type {@code T}.
     *
     * <p>This type of {@link Parameter} will attempt to parse an input
     * using the {@link ValueParser}s in the order that they are returned in
     * {@link #parsers()}. If a {@link ValueParser} fails to parse an
     * argument, the next in the list will be tried, if the final
     * {@link ValueParser} cannot parse the argument, this element will
     * throw a {@link ArgumentParseException}.</p>
     *
     * @param <T> The type of value returned from the {@link ValueParser}s
     */
    interface Value<T> extends Parameter {

        /**
         * The key that a parameter result is stored under.
         *
         * @return The key.
         */
        Key<T> key();

        /**
         * The {@link ValueParser}s to use when parsing an argument. They will be
         * tried in this order.
         *
         * <p>There must always be at least one {@link ValueParser}. If this element
         * is optional and has a default result, it will be the last element in the
         * returned {@link Collection}.</p>
         *
         * @return The parameters.
         */
        Collection<ValueParser<? extends T>> parsers();

        /**
         * Gets the {@link ValueCompleter} associated with this {@link Value}.
         *
         * @return The {@link ValueCompleter}.
         */
        ValueCompleter completer();

        /**
         * Gets the {@link ValueParameterModifier} that affects this parameter,
         * if any.
         *
         * @return The {@link ValueParameterModifier}, if set.
         */
        Optional<ValueParameterModifier<T>> modifier();

        /**
         * Gets the {@link ValueUsage} associated with this {@link Value}, if
         * any was set.
         *
         * @return The {@link ValueUsage}, if set.
         */
        Optional<ValueUsage> valueUsage();

        /**
         * Gets a {@link Predicate} that indicates whether a given {@link Cause}
         * should parse this {@link Parameter}.
         *
         * @return the predicate
         */
        Predicate<CommandCause> requirement();

        /**
         * Parses the next element(s) in the {@link CommandContext}.
         *
         * @param reader The {@link ArgumentReader.Mutable} containing the strings
         *               that need to be parsed
         * @param context The {@link CommandContext.Builder} that contains the
         *                current state of the execution
         * @throws ArgumentParseException thrown if the parameter could not be
         *      parsed
         */
        void parse(ArgumentReader.@NonNull Mutable reader, CommandContext.@NonNull Builder context) throws ArgumentParseException;

        /**
         * Returns potential completions of the current tokenized argument. The
         * completion will be based on {@link ArgumentReader#remaining()}.
         *
         * @param reader The {@link ArgumentReader} containing the strings that need
         *               to be parsed
         * @param context The {@link CommandContext} that contains the
         *                current state of the execution.
         * @return The potential completions.
         * @throws ArgumentParseException thrown if the parameter could not be
         *      parsed
         */
        List<String> complete(ArgumentReader.@NonNull Immutable reader, @NonNull CommandContext context) throws ArgumentParseException;

        /**
         * Gets the usage of this parameter.
         *
         * @param cause The {@link CommandCause} that requested the usage
         * @return The usage
         */
        String usage(CommandCause cause);

        /**
         * If set, this parameter will repeat until the argument string has
         * been parsed.
         *
         * @return if true, consumes all arguments
         */
        boolean willConsumeAllRemaining();

        /**
         * Builds a {@link Parameter} from constituent components.
         */
        interface Builder<T> extends org.spongepowered.api.util.Builder<Value<T>, Builder<T>> {

            /**
             * The key that the parameter will place parsed values into.
             *
             * <p>This is a mandatory element.</p>
             *
             * @param key The key.
             * @return This builder, for chaining
             */
            Builder<T> key(String key);

            /**
             * The key that the parameter will place parsed values into.
             *
             * <p>This is a mandatory element.</p>
             *
             * @param key The key.
             * @return This builder, for chaining
             */
            Builder<T> key(Parameter.Key<T> key);

            /**
             * The {@link ValueParser} that will extract the value(s) from the
             * parameters. If this is a {@link ValueParameter}, the object's
             * complete and usage methods will be used for completion and usage
             * unless this builder's {@link #suggestions(ValueCompleter)}} and
             * {@link #usage(ValueUsage)} methods are specified.
             *
             * @param parser The {@link ValueParameter} to use
             * @return This builder, for chaining
             */
            Builder<T> addParser(ValueParser<? extends T> parser);

            /**
             * The {@link ValueParser} that will extract the value(s) from the
             * parameters. If this is a {@link ValueParameter}, the object's
             * complete and usage methods will be used for completion and usage
             * unless this builder's {@link #suggestions(ValueCompleter)}} and
             * {@link #usage(ValueUsage)} methods are specified.
             *
             * @param <V> The {@link ValueParser} to be used as a parser
             * @param parser The {@link ValueParser} to use
             * @return This builder, for chaining
             */
            default <V extends ValueParser<? extends T>> Builder<T> addParser(@NonNull final DefaultedRegistryReference<V> parser) {
                return this.addParser(parser.get());
            }

            /**
             * Provides a function that provides tab completions
             *
             * <p>Optional. If this is <code>null</code> (or never set),
             * completions will either be done via the supplied
             * {@link Builder#addParser(ValueParser)} or will just return an empty
             * list. If this is supplied, no modifiers will run on completion.</p>
             *
             * @param completer The {@link ValueCompleter}
             * @return This builder, for chaining
             */
            Builder<T> suggestions(@Nullable ValueCompleter completer);

            /**
             * Provides a modifier that allows for the modification of the
             * outcome of an argument parse or a completion. This is primarily
             * intended for use with Mojang/Sponge standard parameters, allowing
             * developers to tweak the input of a standard parameter without
             * having to worry about completion types.
             *
             * <p>Developers should only use this when they use a parameter
             * type that they do not control. If you are using this with a
             * {@link ValueParameter}, {@link ValueParser} or
             * {@link ValueCompleter} that you control (that is, able to modify
             * the source of), it is strongly recommended that you do that
             * instead. For more information about how a modifier should be
             * used, read the {@link ValueParameterModifier} docs instead.</p>
             *
             * <p>Optional. If this is <code>null</code> (or never set), any
             * outcomes will not be modified.</p>
             *
             * @param modifier The modifier
             * @return This builder, for chaning
             */
            Builder<T> modifier(@Nullable ValueParameterModifier<T> modifier);

            /**
             * Sets the usage. The {@link Function} accepts the parameter key
             * and the calling {@link Cause}.
             *
             * <p>Optional. If this is <code>null</code> (or never set),
             * the usage string will either be provided via the supplied
             * {@link #addParser(ValueParser)} or will just return
             * the parameter's key. If this is supplied, no modifiers will run on
             * usage.</p>
             *
             * @param usage The function
             * @return This builder, for chaining
             */
            Builder<T> usage(@Nullable ValueUsage usage);

            /**
             * Sets a function that determines what is required of the
             * appropriate {@link Subject} in the provided {@link Cause} before
             * this parameter is parsed.
             *
             * <p>If the source does not have this permission, this parameter
             * will simply be skipped. Consider combining this with
             * {@link #optional()} so that those with permission can also skip
             * this parameter.</p>
             *
             * @param permission The permission to check for, or {@code null} for
             *                   no check.
             * @return This builder, for chaining
             */
            Builder<T> requiredPermission(@Nullable String permission);

            /**
             * Sets a function that determines what is required of the provided
             * {@link Cause} before this parameter attempts to parse.
             *
             * <p>If this is set to {@code null}, this parameter will always
             * attempt to parse, subject to other modifiers.</p>
             *
             * <p><strong>Note:</strong> this will overwrite any requirements set
             * using {@link #requiredPermission(String)}}.</p>
             *
             * @param executionRequirements A function that sets the
             * @return This builder, for chaining
             */
            Builder<T> requirements(@Nullable Predicate<CommandCause> executionRequirements);

            /**
             * If set, this parameter will repeat until the argument string has
             * been parsed.
             *
             * <p>For example, if you have the argument string,</p>
             *
             * <pre>
             *     1 2 3 4
             * </pre>
             *
             * <p>and you use {@link ResourceKeyedValueParameters#INTEGER} without
             * setting this method, this parameter will parse the first element,
             * 1, and the remaining elements will be left for the next parameter
             * in the chain. If you call this method, the resulting
             * {@link Parameter.Value} will continuously parse the argument string
             * until either:</p>
             * <ul>
             *     <li>The entire argument string has been parsed, in which case
             *     the parsing is considered complete and command execution will
             *     continue</li>
             *     <li>A part of the argument string could not be parsed, in which
             *     case an exception will be raised. If this element is also marked
             *     as {@link #optional()}, then parsing will continue
             *     as if nothing has been parsed.</li>
             * </ul>
             *
             * <p>Unless marked as optional, this element must be able to consume
             * at least one argument. This will automatically mark the element
             * as {@link #terminal() terminal}.</p>
             *
             * @return This builder, for chaining
             */
            Builder<T> consumeAllRemaining();

            /**
             * Marks this parameter as optional, such that if an argument does not
             * exist <em>or</em> cannot be parsed, an exception is not thrown, and
             * no value is returned.
             *
             * @return This builder, for chaining
             */
            Builder<T> optional();

            /**
             * Marks this parameter as a <em>terminal</em> parameter. Any
             * terminal parameter can be considered as a point where argument
             * parsing can stop, allowing control to pass to the command's
             * associated {@link CommandExecutor}.
             *
             * <p>Note that a parameter may be considered terminal even if this
             * isn't set, including if the parameter will consume the rest of
             * the argument string, or if all following arguments are
             * {@link #optional()}. In these scenarios, the built parameter
             * <strong>may</strong> not be aware of its terminal status.</p>
             *
             * @return This builder, for chaining.
             */
            Builder<T> terminal();

            /**
             * Creates a {@link Parameter} from the builder.
             *
             * @return The {@link Parameter}
             */
            @Override
            Parameter.Value<T> build();

        }

    }

    /**
     * A {@link Subcommand} represents a literal argument where, if parsed, should
     * indicate to the command processor that the
     * {@link CommandExecutor} of the command
     * should change.
     */
    interface Subcommand extends Parameter {

        /**
         * The command that is parsed and potentially run when this subcommand
         * is parsed.
         *
         * @return The command to run.
         */
        Command.Parameterized command();

        /**
         * The alias for the subcommand.
         *
         * @return The subcommand.
         */
        Set<String> aliases();

        interface Builder extends org.spongepowered.api.util.Builder<Subcommand, Builder> {

            /**
             * Sets an alias for the subcommand. This can be executed more
             * than once.
             *
             * @param alias The alias
             * @return This builder, for chaining
             */
            Builder addAlias(String alias);

            /**
             * Sets the {@link Command.Parameterized} to execute for this subcommand.
             *
             * @param command The {@link Command.Parameterized}
             * @return This builder, for chaining.
             */
            Builder subcommand(Command.Parameterized command);

            /**
             * Builds this subcommand parameter.
             *
             * <p>An alias and the command must be set, else a
             * {@link IllegalStateException} will be thrown.</p>
             *
             * @return The {@link Subcommand}
             */
            @Override
            Subcommand build();

        }

    }

    /**
     * A parameter that consists of multiple parameters
     */
    interface Multi extends Parameter {

        /**
         * Returns the child parameters.
         *
         * @return the child parameters
         */
        List<Parameter> childParameters();
    }

    /**
     * Specifies a builder for creating a {@link Parameter} that returns a
     * parameter that concatenates all parameters into a single
     * parameter to be executed one by one.
     */
    interface SequenceBuilder extends Builder<Multi, SequenceBuilder> {

        /**
         * Sets that this sequence of parameters is optional, and will be
         * ignored if it isn't specified - but will throw an error if this
         * is passed something to parse that it cannot parse.
         *
         * @return This builder, for chaining
         */
        SequenceBuilder terminal();

        /**
         * Sets that this parameter is weak optional and will be ignored if it
         * cannot parse the next element(s).
         *
         * @return This builder, for chaining
         */
        SequenceBuilder optional();

        /**
         * Defines the next parameter in the parameter sequence.
         *
         * @param parameter The parameter
         * @return This builder, for chaining
         */
        SequenceBuilder then(Parameter parameter);

        /**
         * Adds a set of {@link Parameter}s to this builder.
         *
         * <p>The parameters will be parsed in the provided order.</p>
         *
         * @param parameters The parameters to add
         * @return This builder, for chaining
         */
        default SequenceBuilder then(final Parameter @NonNull... parameters) {
            return this.then(Arrays.asList(parameters));
        }

        /**
         * Adds a set of {@link Parameter}s to this builder.
         *
         * <p>The parameters will be parsed in the provided order.</p>
         *
         * @param parameters The parameters to add
         * @return This builder, for chaining
         */
        default SequenceBuilder then(@NonNull final Iterable<Parameter> parameters) {
            for (final Parameter parameter : parameters) {
                this.then(parameter);
            }

            return this;
        }

        /**
         * Creates a {@link Parameter} from the builder.
         *
         * @return The {@link Parameter}
         */
        @Override
        Multi build();

    }

    /**
     * Specifies a builder for creating a {@link Parameter} that returns a
     * parameter that concatenates all parameters into a single
     * parameter to be executed one by one.
     */
    interface FirstOfBuilder extends Builder<Multi, FirstOfBuilder> {

        /**
         * Sets that this parameter is optional, and will be ignored if it isn't
         * specified - but will throw an error if this is passed something to
         * parse that it cannot parse.
         *
         * @return This builder, for chaining
         */
        FirstOfBuilder terminal();

        /**
         * Sets that this parameter is weak optional and will be ignored if it
         * cannot parse the next element(s).
         *
         * @return This builder, for chaining
         */
        FirstOfBuilder optional();

        /**
         * Adds a parameter that can be used to parse an argument. Parameters
         * are checked in the order they are added to the builder.
         *
         * @param parameter The parameter
         * @return This builder, for chaining
         */
        FirstOfBuilder or(Parameter parameter);

        /**
         * Adds a set of {@link Parameter}s to this builder.
         *
         * <p>The parameters will be parsed in the provided order until one
         * succeeds.</p>
         *
         * @param parameters The parameters to add
         * @return This builder, for chaining
         */
        default FirstOfBuilder orFirstOf(final Parameter @NonNull... parameters) {
            return this.orFirstOf(Arrays.asList(parameters));
        }

        /**
         * Adds a set of {@link Parameter}s to this builder.
         *
         * <p>The parameters will be parsed in the provided order until one
         * succeeds.</p>
         *
         * @param parameters The parameters to add
         * @return This builder, for chaining
         */
        default FirstOfBuilder orFirstOf(@NonNull final Iterable<Parameter> parameters) {
            for (final Parameter parameter : parameters) {
                this.or(parameter);
            }

            return this;
        }

        /**
         * Creates a {@link Multi} from the builder.
         *
         * @return The {@link Multi}
         */
        @Override
        Multi build();

    }

    /**
     * Contains methods to create the generic builders.
     */
    interface Factory {

        /**
         * Creates a {@link Parameter.Value.Builder} of the indicated generic type.
         *
         * @param parameterClass The class
         * @param <T> The type of object that will be returned by the built
         *            {@link Parameter.Value}
         * @return The builder.
         */
        <T> Value.Builder<T> createParameterBuilder(TypeToken<T> parameterClass);

        /**
         * Creates a {@link Parameter.Value.Builder} of the indicated generic type.
         *
         * @param parameterClass The class
         * @param <T> The type of object that will be returned by the built
         *            {@link Parameter.Value}
         * @return The builder.
         */
        <T> Value.Builder<T> createParameterBuilder(Class<T> parameterClass);

    }

}
