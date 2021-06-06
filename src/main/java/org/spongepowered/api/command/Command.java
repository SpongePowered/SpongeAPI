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

import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.exception.ArgumentParseException;
import org.spongepowered.api.command.exception.CommandException;
import org.spongepowered.api.command.manager.CommandMapping;
import org.spongepowered.api.command.parameter.ArgumentReader;
import org.spongepowered.api.command.parameter.CommandContext;
import org.spongepowered.api.command.parameter.Parameter;
import org.spongepowered.api.command.parameter.managed.Flag;
import org.spongepowered.api.command.registrar.CommandRegistrar;
import org.spongepowered.api.command.registrar.tree.CommandTreeNode;
import org.spongepowered.api.command.registrar.tree.CommandTreeNodeTypes;
import org.spongepowered.api.event.Cause;
import org.spongepowered.api.event.EventContext;
import org.spongepowered.api.event.lifecycle.RegisterCommandEvent;
import org.spongepowered.api.service.permission.PermissionDescription;
import org.spongepowered.api.service.permission.Subject;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * The Command interface is the low-level interface that all commands in the
 * Sponge ecosystem inherit.
 *
 * <p><strong>Most</strong> plugins are highly recommended (but not obligated)
 * to use {@link Command#builder()} to create commands. The
 * {@link Builder} allows plugins to take advantage of a higher level
 * of abstraction, such as argument parsers and simple child command handling,
 * removing the need for boilerplate code. Such {@link Parameterized} commands
 * should register themselves during the {@link RegisterCommandEvent
 * RegisterCommandEvent&lt;Command.Parameterized>} event.</p>
 *
 * <p>Plugins that do not want to use the {@link Builder} or any third-party
 * command system should implement the {@link Raw} sub-interface instead. Such
 * {@link Raw} commands should  register themselves during the
 * {@link RegisterCommandEvent RegisterCommandEvent&lt;Command.Raw>}
 * event.</p>
 *
 * <p>Plugins <strong>must not</strong> implement the {@link Parameterized}
 * sub-interface themselves.</p>
 *
 * <p>Upon execution, commands are provided with a {@link CommandCause},
 * providing the {@link Cause} and {@link EventContext} that invoked the
 * command. See the {@link CommandCause} documentation for more information
 * of the structure of this cause.</p>
 */
public interface Command {

    /**
     * Gets a builder for building a {@link Command}.
     *
     * @return The {@link Builder}
     */
    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    /**
     * Execute the command based on input arguments.
     *
     * <p>The implementing class must perform the necessary permission
     * checks.</p>
     *
     * @param cause The {@link CommandCause} of the invocation of command
     * @param arguments The raw arguments for this command
     * @return The result of a command being processed
     * @throws CommandException Thrown on a command error
     */
    CommandResult process(CommandCause cause, ArgumentReader.Mutable arguments) throws CommandException;

    /**
     * Gets a list of completions based on input.
     *
     * <p>If a completion is chosen by the user, it will replace the last
     * word.</p>
     *
     * @param cause The {@link CommandCause} of the command
     * @param arguments The arguments entered up to this point
     * @return A list of suggestions
     * @throws CommandException Thrown if there was a parsing error
     */
    List<CommandCompletion> complete(CommandCause cause, ArgumentReader.Mutable arguments) throws CommandException;

    /**
     * Test whether this command can probably be executed given this
     * {@link Cause}.
     *
     * <p>If implementations are unsure if the command can be executed by
     * the source, {@code true} should be returned. Return values of this method
     * may be used to determine whether this command is listed in command
     * listings.</p>
     *
     * @param cause The {@link Cause} to check
     * @return Whether this command will execute
     */
    boolean canExecute(CommandCause cause);

    /**
     * Gets a short one-line description of this command.
     *
     * <p>The help system may display the description in the command list, or
     * in any other function that displays a command list. It is therefore
     * recommended that any description here is kept very short.</p>
     *
     * @see CommandRegistrar#shortDescription(CommandCause, CommandMapping)
     *
     * @param cause The {@link CommandCause} of the help request
     * @return A description
     */
    Optional<Component> shortDescription(CommandCause cause);

    /**
     * Gets a longer formatted help message about this command.
     *
     * <p>The help system may display this description when displaying details
     * about this specific command. It should not contain the description
     * provided by {@link #shortDescription(CommandCause)}.</p>
     *
     * @param cause The {@link Cause} of the help request
     * @return A description
     */
    Optional<Component> extendedDescription(CommandCause cause);

    /**
     * Gets a longer formatted help message about this command. This will
     * typically comprise of {@link #shortDescription(CommandCause)}
     * and {@link #extendedDescription(CommandCause)} together.
     *
     * <p>The help system may display this message when a source requests
     * detailed information about a command.</p>
     *
     * @see CommandRegistrar#help(CommandCause, CommandMapping)
     *
     * @param cause The {@link Cause} of the help request
     * @return A help text
     */
    default Optional<Component> help(@NonNull final CommandCause cause) {
        final Optional<Component> shortDesc = this.shortDescription(cause);
        final Optional<Component> extended = this.extendedDescription(cause);
        if (extended.isPresent()) {
            if (shortDesc.isPresent()) {
                return Optional.of(Component.text().append(shortDesc.get(), Component.newline(), Component.newline(), extended.get()).build());
            } else {
                return extended;
            }
        }
        return shortDesc;
    }

    /**
     * Gets the usage string of this command.
     *
     * <p>A usage string may look like
     * {@code [<world>] <var1> <var2>}.</p>
     *
     * <p>The string must not contain the command alias.</p>
     *
     * @param cause The {@link Cause} of the help request
     * @return A usage string
     */
    Component usage(CommandCause cause);

    /**
     * A raw command that also contains a {@link CommandTreeNode} to provide
     * hints to the client for command completion.
     */
    interface Raw extends Command {

        /**
         * Gets the {@link CommandTreeNode} that represents the argument
         * pattern for this command.
         *
         * <p>Defaults to a command with an optional string argument string that
         * is greedy.</p>
         *
         * @return The tree.
         */
        default CommandTreeNode.Root commandTree() {
            return CommandTreeNode.root().executable().child("arguments",
                    CommandTreeNodeTypes.STRING.get().createNode().greedy().executable().customCompletions());
        }

    }

    /**
     * A {@link Command} that has distinct steps for parsing arguments and
     * executing a command based on those arguments.
     *
     * <p>Plugins must not attempt to create their own instance of this
     * interface, and instead must use {@link Command#builder()} to do
     * so.</p>
     */
    interface Parameterized extends Command {

        /**
         * The {@link List} of {@link Flag}s that this {@link Command} contains.
         *
         * @return A copy of the collection of {@link Flag}s.
         */
        List<Flag> flags();

        /**
         * The {@link List} of {@link Parameter}s that this {@link Command}
         * contains.
         *
         * @return A copy of the collection of {@link Parameter}s.
         */
        List<Parameter> parameters();

        /**
         * A {@link List} of direct {@link Parameter.Subcommand subcommands}
         * that this command contains.
         *
         * <p>A direct subcommand is one that is specified directly after the
         * literal the invokes this command, e.g. on the command {@code /foo},
         * {@code bar} is a direct subcommand if it was specified in
         * {@link Builder#addChild(Parameterized, String...)}
         * or {@link Builder#addChildren(Map)} with the alias
         * {@code bar}. This will not contain any subcommands that were
         * registered via
         * {@link Builder#addParameter(Parameter)}</p>
         *
         * @return A copy of the collection of subcommands.
         */
        List<Parameter.Subcommand> subcommands();

        /**
         * Gets whether
         * {@link Builder#terminal(boolean)} was
         * explicitly set to {@code true}, such that this command will
         * execute without any arguments, regardless of the command's
         * {@link #parameters() parameters} or
         * {@link #subcommands() subcommands}.
         *
         * @return if this {@link Command.Parameterized} is terminal.
         */
        boolean isTerminal();

        /**
         * Gets a {@link Predicate} that backs {@link #canExecute(CommandCause)}.
         *
         * @return The predicate.
         */
        Predicate<CommandCause> executionRequirements();

        /**
         * Parses the parameters based on the provided {@link #parameters()}
         *
         * @param cause The {@link Cause} of this parse
         * @param arguments The argument {@link String}
         * @return The {@link CommandContext}
         * @throws ArgumentParseException if a parameter could not be parsed
         */
        CommandContext parseArguments(CommandCause cause, ArgumentReader.Mutable arguments) throws ArgumentParseException;

        /**
         * Gets the {@link CommandExecutor} for this command, if one exists.
         *
         * @return The {@link CommandExecutor}, if it exists.
         */
        Optional<CommandExecutor> executor();

        /**
         * Processes the command by parsing the arguments, then
         * executing command based on these arguments.
         *
         * <p>By default, this will call {@link #parseArguments(CommandCause, ArgumentReader.Mutable)}
         * and pass the resulting {@link CommandContext} to
         * {@link CommandExecutor#execute(CommandContext)}, if this command has
         * an executor. If it does not, this will throw a
         * {@link CommandException}.</p>
         *
         * @param cause The {@link Cause} of the command
         * @param arguments The raw arguments for this command
         * @return The result of a command being processed
         * @throws CommandException Thrown on a command error
         */
        @Override
        default CommandResult process(final CommandCause cause, final ArgumentReader.Mutable arguments) throws CommandException {
            if (this.executor().isPresent()) {
                return this.executor().get().execute(this.parseArguments(cause, arguments));
            }
            throw new CommandException(Component.text("This command does not have an executor!"));
        }

    }

    /**
     * A high level {@link Builder} for creating a
     * {@link Command.Parameterized}.
     *
     * <p>When creating a command, ensure that a {@link CommandExecutor}
     * <strong>and/or</strong> a child command is specified.</p>
     */
    interface Builder extends org.spongepowered.api.util.Builder<Parameterized, Builder> {

        /**
         * Adds a {@link Command.Parameterized} as a top-level child to this
         * command, using the supplied keys. The keys are case insensitive.
         *
         * <p>Children added here will be added to the beginning of the
         * {@link Parameter}s. Note that if you wish to add a subcommand
         * in the middle of the parameters, you can do so by creating a
         * {@link org.spongepowered.api.command.parameter.Parameter.Subcommand}
         * and adding that as a {@link #addParameter(Parameter)} at the
         * appropriate time.</p>
         *
         * @param child The {@link Command} that is a child.
         * @param keys The keys to register as a sub command.
         * @return This builder, for chaining
         * @throws IllegalArgumentException thrown if a child key is already
         *                                  in the builder, or there are no keys
         *                                  supplied
         */
        default Builder addChild(final Command.Parameterized child, final String... keys) {
            return this.addChild(child, Arrays.asList(keys));
        }

        /**
         * Adds a {@link Command.Parameterized} as a child to this command,
         * under the supplied keys. The keys are case insensitive.
         *
         * <p>Children added here will be added to the beginning of the
         * {@link Parameter}s. Note that if you wish to add a subcommand
         * in the middle of the parameters, you can do so by creating a
         * {@link org.spongepowered.api.command.parameter.Parameter.Subcommand}
         * and adding that as a {@link #addParameter(Parameter)} at the
         * appropriate time.</p>
         *
         * @param child The {@link Command} that is a child.
         * @param keys The keys to register as a sub command.
         * @return This builder, for chaining
         * @throws IllegalArgumentException thrown if a child key is already
         *                                  in the builder
         */
        Builder addChild(Command.Parameterized child, Iterable<String> keys);

        /**
         * Adds multiple {@link Command.Parameterized} as children to this
         * command, under the supplied keys. The keys are case insensitive.
         *
         * <p>Children added here will be added to the beginning of the
         * {@link Parameter}s. Note that if you wish to add a subcommand
         * in the middle of the parameters, you can do so by creating a
         * {@link Parameter.Subcommand} and adding that as a
         * {@link #addParameter(Parameter)} at the appropriate time.</p>
         *
         * @param children The {@link Map} that contains a mapping of keys to
         *                 their respective {@link Command} children.
         * @return This builder, for chaining
         * @throws IllegalArgumentException thrown if a child key is already
         *                                  in the builder
         */
        default Builder addChildren(final Map<? extends Iterable<String>, ? extends Command.Parameterized> children) {
            for (final Map.Entry<? extends Iterable<String>, ? extends Command.Parameterized> child : children.entrySet()) {
                this.addChild(child.getValue(), child.getKey());
            }

            return this;
        }

        /**
         * Adds a flag to this command. Flags are always the first arguments of
         * a command. There are no set rules for the order of execution of
         * flags (unlike {@link #addParameter(Parameter)}), and all flags are
         * considered optional.
         *
         * <p>Duplicate keys and/or duplicate aliases may not be provided.</p>
         *
         * @param flag The {@link Flag} to support
         * @return Ths builder, for chaining
         */
        Builder addFlag(Flag flag);

        /**
         * Adds multiple {@link Flag flags} to this command.
         *
         * @see #addFlag(Flag) for more information about flags.
         *
         * @param flags The flags
         * @return This builder, for chaining
         */
        default Builder addFlags(final Flag... flags) {
            for (final Flag flag : flags) {
                this.addFlag(flag);
            }
            return this;
        }

        /**
         * Adds multiple {@link Flag flags} to this command.
         *
         * @see #addFlag(Flag) for more information about flags.
         *
         * @param flags The flags
         * @return This builder, for chaining
         */
        default Builder addFlags(final Iterable<Flag> flags) {
            for (final Flag flag : flags) {
                this.addFlag(flag);
            }
            return this;
        }

        /**
         * Adds a parameter for use when parsing arguments. When executing a
         * command, they will be executed in the order they are added to this
         * builder.
         *
         * @param parameter The parameter to add to the parameter list
         * @return This builder, for chaining
         */
        Builder addParameter(Parameter parameter);

        /**
         * Adds parameters to use when parsing arguments. Parameters will be
         * used in the order provided here.
         *
         * @param parameters The {@link Parameter}s to use
         * @return This builder, for chaining
         */
        default Builder addParameters(final Parameter... parameters) {
            return this.addParameters(Arrays.asList(parameters));
        }

        /**
         * Adds parameters to use when parsing arguments. Parameters will be
         * used in the order provided here.
         *
         * @param parameters The {@link Parameter}s to use
         * @return This builder, for chaining
         */
        default Builder addParameters(final Iterable<Parameter> parameters) {
            for (final Parameter parameter : parameters) {
                this.addParameter(parameter);
            }

            return this;
        }

        /**
         * Provides the logic of the command.
         *
         * <p>This is only optional if child commands are specified. This will
         * replace any previous executor that has been set.</p>
         *
         * @param executor The {@link CommandExecutor} that will run the command
         * @return This builder, for chaining
         */
        Builder executor(CommandExecutor executor);

        /**
         * Provides the description for this command, which is dependent on the
         * {@link Cause} that requests it.
         *
         * <p>A one line summary should be provided to
         * {@link #shortDescription(Component)}</p>
         *
         * <p>It is recommended to use the default text color and style. Sections
         * with text actions (e.g. hyperlinks) should be underlined.</p>
         *
         * @param extendedDescriptionFunction A function that provides a
         *      relevant description based on the supplied {@link Cause}
         * @return This builder, for chaining
         */
        Builder extendedDescription(Function<CommandCause, Optional<Component>> extendedDescriptionFunction);

        /**
         * Provides the description for this command.
         *
         * <p>A one line summary should be provided to
         * {@link #shortDescription(Component)}</p>
         *
         * @param extendedDescription The description to use, or {@code null}
         *                            for no description.
         * @return This builder, for chaining
         */
        default Builder extendedDescription(@Nullable final Component extendedDescription) {
            // Done outside the lambda so that we don't have to recreate the object each time.
            final Optional<Component> text = Optional.ofNullable(extendedDescription);
            return this.extendedDescription((cause) -> text);
        }

        /**
         * Provides a simple description for this command, typically no more
         * than one line, which is dependent on the {@link Cause} that requests
         * it.
         *
         * <p>Fuller descriptions should be provided through
         * {@link #extendedDescription(Function)}</p>
         *
         * @param descriptionFunction A function that provides a relevant
         *      description based on the supplied {@link Cause}
         * @return This builder, for chaining
         */
        Builder shortDescription(Function<CommandCause, Optional<Component>> descriptionFunction);

        /**
         * Provides a simple description for this command, typically no more
         * than one line.
         *
         * <p>Fuller descriptions should be provided through
         * {@link #extendedDescription(Component)}</p>
         *
         * <p>It is recommended to use the default text color and style. Sections
         * with text actions (e.g. hyperlinks) should be underlined.</p>
         *
         * @param description The description to use, or {@code null} for no
         *                    description
         * @return This builder, for chaining
         */
        default Builder shortDescription(@Nullable final Component description) {
            // Done outside the lambda so that we don't have to recreate the object each time.
            final Optional<Component> text = Optional.ofNullable(description);
            return this.shortDescription((cause) -> text);
        }

        /**
         * The permission that the responsible {@link Subject} in the given
         * {@link Cause} requires to run this command, or {@code null} if no
         * permission is required. Calling this method will overwrite anything
         * set via {@link #executionRequirements(Predicate)}, or will replace
         * the previous permission set by this method.
         *
         * <p>Any permission checks set here will be performed during the
         * {@link Command#canExecute(CommandCause)}.</p>
         *
         * @param permission The permission that is required, or {@code null}
         *                   for no permission
         * @return This builder, for chaining
         */
        Builder permission(@Nullable String permission);

        /**
         * The permission that the responsible {@link Subject} in the given
         * {@link Cause} requires to run this command.
         *
         * <p>For more control over whether a command can be executed, use
         * {@link #executionRequirements(Predicate)}. However, note that
         * setting a permission here will not override anything set in
         * {@link #executionRequirements(Predicate)}, both will be checked
         * during execution.</p>
         *
         * <p>Any permission checks set here will be performed during the
         * {@link Command#canExecute(CommandCause)}.</p>
         *
         * <p>Calling this repeatedly will not add additional permission
         * checks, instead replacing the permission check. If multiple
         * permission checks are required, use
         * {@link #executionRequirements(Predicate)}.</p>
         *
         * @param permission The description for the required permission.
         * @return This builder, for chaining
         */
        default Builder permission(PermissionDescription permission) {
            return this.permission(Objects.requireNonNull(permission, "permission").id());
        }

        /**
         * Sets a function that determines what is required of the provided
         * {@link Cause} before this command executes. Calling this method
         * will overwrite anything set via {@link #permission(String)} or
         * anything previously set via this method.
         *
         * <p>Any requirements set here will be performed as part of
         * {@link Command#canExecute(CommandCause)}.</p>
         *
         * @param executionRequirements A function that sets the
         * @return This builder, for chaining
         */
        Builder executionRequirements(@Nullable Predicate<CommandCause> executionRequirements);

        /**
         * Sets whether this command is considered "terminal" in its own right,
         * that is, can be executed on its own if no arguments are supplied when
         * invoked, regardless of whether any supplied {@link Parameter}s are
         * mandatory.
         *
         * @see Parameter#isTerminal()
         * @see Parameter.Value.Builder#terminal()
         *
         * @param terminal Whether to mark this command as terminal
         * @return This builder, for chaining
         */
        Builder terminal(boolean terminal);

        /**
         * Builds this command, creating a {@link Command.Parameterized}
         * object.
         *
         * <p>To build the command, <strong>one</strong> of the following is
         * required:</p>
         *
         * <ul>
         *     <li>A {@link CommandExecutor} is provided using
         *     {@link #executor(CommandExecutor)}</li>
         *     <li>At least one {@link Command} is set to be a child command
         *     using {@link #addChild(Parameterized, Iterable)} or
         *     {@link #addChildren(Map)}
         *     </li>
         * </ul>
         *
         * <p>If these conditions are not fulfilled, an
         * {@link IllegalStateException} will be thrown.</p>
         *
         * @return The command, ready for registration
         * @throws IllegalStateException if the builder is not complete
         */
        @Override
        Command.Parameterized build();

    }

}
