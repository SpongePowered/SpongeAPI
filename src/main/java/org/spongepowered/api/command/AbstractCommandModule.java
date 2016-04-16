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
package org.spongepowered.api.command;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.annotation.Command;
import org.spongepowered.api.command.annotation.PlainDescription;
import org.spongepowered.api.command.args.CommandArgs;
import org.spongepowered.api.command.args.parsing.InputTokenizer;
import org.spongepowered.api.command.binding.Binder;
import org.spongepowered.api.command.binding.BindingBuilder;
import org.spongepowered.api.command.binding.BindingKey;
import org.spongepowered.api.command.binding.ReadOnlyDelegateBinder;
import org.spongepowered.api.command.binding.simple.SimpleBinder;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.serializer.TextSerializer;
import org.spongepowered.api.text.serializer.TextSerializers;
import org.spongepowered.api.text.translation.TextFunction;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.annotation.Nullable;

/**
 * A command module contributes configuration information to commands, and
 * registers commands with a {@link CommandManager}.
 *
 * <p>A command module is <b>not</b> re-usable.</p>
 */
public abstract class AbstractCommandModule {

    private Binder binder = new SimpleBinder();
    @SuppressWarnings("NullableProblems")
    private PluginContainer plugin;
    @SuppressWarnings("NullableProblems")
    private CommandManager manager;
    private InputTokenizer inputTokenizer = InputTokenizer.quotedStrings(false);
    private TextSerializer textSerializer = TextSerializers.FORMATTING_CODE;
    @Nullable private CommandThrowableProcessor throwableProcessor;
    @Nullable private TextFunction textFunction;
    private CommandAuthorizer authorizer = CommandAuthorizer.CALLABLE;
    private boolean configured;
    private boolean registered;

    protected AbstractCommandModule() {
    }

    /**
     * Contributes bindings and other configurations for this module to {@code binder}.
     *
     * @param plugin The plugin
     * @param manager The command manager
     */
    @SuppressWarnings("ConstantConditions")
    public final void configure(PluginContainer plugin, CommandManager manager) {
        checkState(this.manager == null, "Re-entry is not allowed.");
        this.plugin = checkNotNull(plugin, "plugin");
        this.manager = checkNotNull(manager, "manager");
        this.preConfigure();
        this.configure();
        // Create a delegating read-only binder
        this.binder = new ReadOnlyDelegateBinder(this.binder);
        this.configured = true;
    }

    private void preConfigure() {
        // Register a few of the most common arguments by default
        this.bind(CommandSource.class).toProvider((source, args, modifiers) -> source);
        this.bind(CommandArgs.class).toProvider((source, args, modifiers) -> args);
        this.bind(Game.class).toProvider((source, args, modifiers) -> Sponge.getGame());
        this.bind(Logger.class).toProvider((source, args, modifiers) -> this.plugin.getLogger());
    }

    private void noChangingRegistration(String what) {
        checkState(!this.registered, "The %s cannot be changed after commands have been registered", what);
    }

    /**
     * Determines if this command module can be installed or configured
     * through a {@link CommandManager}.
     *
     * @param install {@code true} if we should check if this module
     *     can be installed
     * @return {@code true} if this command module can be installed
     *     or configured
     */
    @SuppressWarnings("ConstantConditions")
    public final boolean canBeInstalledOrConfigured(boolean install) {
        return install ? (this.plugin == null && this.manager == null && !this.configured) : !this.configured;
    }

    /**
     * Configure this command module.
     *
     * <p>You <b>must</b> {@link #register(Object) register commands} <i>after</i>
     * you have configured any bindings, input tokenizer, etc.</p>
     */
    @SuppressWarnings("WeakerAccess")
    protected abstract void configure();

    /**
     * Create a binding builder from a class type.
     *
     * @param clazz The class
     * @param <T> The bound type
     * @return A binding builder
     */
    protected final <T> BindingBuilder<T> bind(Class<T> clazz) {
        this.noChangingRegistration("bindings");
        return this.binder.bind(clazz);
    }

    /**
     * Create a binding builder from a binding key.
     *
     * @param key The binding key
     * @param <T> The bound type
     * @return A binding builder
     */
    protected final <T> BindingBuilder<T> bind(BindingKey<T> key) {
        this.noChangingRegistration("bindings");
        return this.binder.bind(key);
    }

    /**
     * Registers all found {@link Command annotation commands}.
     *
     * <p>You <b>must</b> register commands <i>after</i> you have
     * configured any bindings, input tokenizer, etc.</p>
     *
     * @param object The object to register commands from
     */
    protected final void register(Object object) {
        this.registered = true;
        this.manager.register(this, object);
    }

    /**
     * Register a given command using the given list of aliases.
     *
     * <p>You <b>must</b> register commands <i>after</i> you have
     * configured any bindings, input tokenizer, etc.</p>
     *
     * <p>If there is a conflict with one of the aliases (i.e. that alias
     * is already assigned to another command), then the alias will be skipped.
     * It is possible for there to be no alias to be available out of
     * the provided list of aliases, which would mean that the command would not
     * be assigned to any aliases.</p>
     *
     * <p>The first non-conflicted alias becomes the "primary alias."</p>
     *
     * @param callable The command
     * @param alias An array of aliases
     * @return The registered command mapping, unless no aliases could be registered
     * @throws IllegalArgumentException Thrown if {@code plugin} is not a plugin instance
     * @see CommandManager#register(Object, CommandCallable, String...)
     */
    protected final Optional<CommandMapping> register(CommandCallable callable, String... alias) {
        return this.register(callable, Arrays.asList(alias));
    }

    /**
     * Register a given command using the given list of aliases.
     *
     * <p>You <b>must</b> register commands <i>after</i> you have
     * configured any bindings, input tokenizer, etc.</p>
     *
     * <p>If there is a conflict with one of the aliases (i.e. that alias
     * is already assigned to another command), then the alias will be skipped.
     * It is possible for there to be no alias to be available out of
     * the provided list of aliases, which would mean that the command would not
     * be assigned to any aliases.</p>
     *
     * <p>The first non-conflicted alias becomes the "primary alias."</p>
     *
     * @param callable The command
     * @param aliases A list of aliases
     * @return The registered command mapping, unless no aliases could be registered
     * @throws IllegalArgumentException Thrown if {@code plugin} is not a plugin instance
     * @see CommandManager#register(Object, CommandCallable, List)
     */
    protected final Optional<CommandMapping> register(CommandCallable callable, List<String> aliases) {
        return this.register(callable, aliases, Function.identity());
    }

    /**
     * Register a given command using a given list of aliases.
     *
     * <p>You <b>must</b> register commands <i>after</i> you have
     * configured any bindings, input tokenizer, etc.</p>
     *
     * <p>The provided callback function will be called with a list of aliases
     * that are not taken (from the list of aliases that were requested) and
     * it should return a list of aliases to actually register. Aliases may be
     * removed, and if no aliases remain, then the command will not be
     * registered. It may be possible that no aliases are available, and thus
     * the callback would receive an empty list. New aliases should not be added
     * to the list in the callback as this may cause
     * {@link IllegalArgumentException} to be thrown.</p>
     *
     * <p>The first non-conflicted alias becomes the "primary alias."</p>
     *
     * @param callable The command
     * @param aliases A list of aliases
     * @param callback The callback
     * @return The registered command mapping, unless no aliases could be registered
     * @throws IllegalArgumentException Thrown if new conflicting aliases are added in the callback
     * @throws IllegalArgumentException Thrown if {@code plugin} is not a plugin instance
     * @see CommandManager#register(Object, CommandCallable, List, Function)
     */
    protected final Optional<CommandMapping> register(CommandCallable callable, List<String> aliases, Function<List<String>, List<String>> callback) {
        this.registered = true;
        return this.manager.register(this, callable, aliases, callback);
    }

    /**
     * Gets the plugin container associated with this command module.
     *
     * @return The associated plugin container
     */
    public final PluginContainer getPlugin() {
        return this.plugin;
    }

    /**
     * Gets the binder for this dispatcher.
     *
     * @return The binder
     */
    public final Binder getBinder() {
        return this.binder;
    }

    /**
     * Gets the input tokenizer used for commands registered through
     * this command module.
     *
     * @return The input tokenizer
     */
    public final InputTokenizer getInputTokenizer() {
        return this.inputTokenizer;
    }

    /**
     * Sets the input tokenizer used for commands registered through
     * this command module.
     *
     * @param tokenizer The input tokenizer
     */
    protected final void setInputTokenizer(InputTokenizer tokenizer) {
        this.noChangingRegistration("input tokenizer");
        this.inputTokenizer = checkNotNull(tokenizer, "tokenizer");
    }

    /**
     * Gets the text serializer used for commands registered through
     * this command module that use {@link PlainDescription}.
     *
     * @return The text serializer
     */
    public final TextSerializer getTextSerializer() {
        return this.textSerializer;
    }

    /**
     * Sets the text serializer used for commands registered through
     * this command module that use {@link PlainDescription}.
     *
     * @param serializer The text serializer
     */
    protected final void setTextSerializer(TextSerializer serializer) {
        this.noChangingRegistration("text serializer");
        this.textSerializer = checkNotNull(serializer, "serializer");
    }

    /**
     * Gets the throwable processor used for commands registered through
     * this command module that use {@link PlainDescription}.
     *
     * @return The throwable processor
     */
    public final Optional<CommandThrowableProcessor> getThrowableProcessor() {
        return Optional.ofNullable(this.throwableProcessor);
    }

    /**
     * Sets the throwable processor used for commands registered through
     * this command module that use {@link PlainDescription}.
     *
     * @param processor The throwable processor
     */
    protected final void setThrowableProcessor(CommandThrowableProcessor processor) {
        this.throwableProcessor = processor;
    }

    /**
     * Gets the text function used for commands registered through
     * this command module that use {@link PlainDescription}.
     *
     * @return The text function, if present, {@link Optional#empty()} otherwise
     */
    public final Optional<TextFunction> getTextFunction() {
        return Optional.ofNullable(this.textFunction);
    }

    /**
     * Sets the text function used for commands registered through
     * this command module that use {@link PlainDescription}.
     *
     * @param function The text function
     */
    protected final void setTextFunction(TextFunction function) {
        this.textFunction = function;
    }

    /**
     * Gets the authorizer used for commands registered through
     * this command module that use {@link PlainDescription}.
     *
     * @return The authorizer
     */
    public final CommandAuthorizer getAuthorizer() {
        return this.authorizer;
    }

    /**
     * Sets the authorizer used for commands registered through
     * this command module that use {@link PlainDescription}.
     *
     * @param authorizer The authorizer
     */
    protected final void setAuthorizer(CommandAuthorizer authorizer) {
        this.authorizer = checkNotNull(authorizer, "authorizer");
    }

}
