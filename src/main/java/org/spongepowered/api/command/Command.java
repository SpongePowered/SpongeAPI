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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.exception.CommandException;
import org.spongepowered.api.command.parameter.CommandContext;
import org.spongepowered.api.command.parameter.Parameter;
import org.spongepowered.api.command.parameter.flag.Flags;
import org.spongepowered.api.command.source.CommandSource;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.world.Location;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import javax.annotation.Nullable;

/**
 * The Command interface is the low-level interface that all commands in the
 * Sponge ecosystem inherit.
 *
 * <p><strong>Most</strong> plugins are highly recommended (but not obligated)
 * to use {@link Command#builder()} to create commands. The
 * {@link Command.Builder} allows plugins to take advantage of a higher level
 * of abstraction, such as argument parsers and simple child command handling,
 * removing the need for boilerplate code.</p>
 *
 * <p>Plugins are free to implement this interface should they prefer to do so.
 * Custom implementations of this class are not required to implement a sane
 * {@link Object#equals(Object)}, but are highly encouraged to do so.</p>
 *
 * <p>Commands in Sponge are provided with a {@link Cause}, which explains
 * who <em>directly</em> invoked the </p>
 */
public interface Command {

    /**
     * Gets a builder for building a {@link Command}.
     *
     * @return The {@link Builder}
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Execute the command based on input arguments.
     *
     * <p>The implementing class must perform the necessary permission
     * checks.</p>
     *
     * @param cause The {@link Cause} of the command
     * @param arguments The raw arguments for this command
     * @return The result of a command being processed
     * @throws CommandException Thrown on a command error
     */
    CommandResult process(Cause cause, String arguments) throws CommandException;

    /**
     * Gets a list of suggestions based on input.
     *
     * <p>If a suggestion is chosen by the user, it will replace the last
     * word.</p>
     *
     * @param cause The {@link Cause} of the command
     * @param arguments The arguments entered up to this point
     * @param targetPosition The position the source is looking at when
     *     performing tab completion
     * @return A list of suggestions
     * @throws CommandException Thrown if there was a parsing error
     */
    List<String> getSuggestions(Cause cause, String arguments, @Nullable Location targetPosition) throws CommandException;

    /**
     * Test whether this command can probably be executed given this
     * {@link Cause} and {@link CommandSource}.
     *
     * <p>If implementations are unsure if the command can be executed by
     * the source, {@code true} should be returned. Return values of this method
     * may be used to determine whether this command is listed in command
     * listings.</p>
     *
     * @param cause The {@link Cause} to check
     * @return Whether this command will execute
     */
    boolean canExecute(Cause cause);

    /**
     * Gets a short one-line description of this command.
     *
     * <p>The help system may display the description in the command list.</p>
     *
     * @param cause The {@link Cause} of the help request
     * @return A description
     */
    Optional<Text> getShortDescription(Cause cause);

    /**
     * Gets a longer formatted help message about this command.
     *
     * <p>It is recommended to use the default text color and style. Sections
     * with text actions (e.g. hyperlinks) should be underlined.</p>
     *
     * <p>Multi-line messages can be created by separating the lines with
     * {@code \n}.</p>
     *
     * <p>The help system may display this message when a source requests
     * detailed information about a command.</p>
     *
     * @param cause The {@link Cause} of the help request
     * @return A help text
     */
    Optional<Text> getHelp(Cause cause);

    /**
     * Gets the usage string of this command.
     *
     * <p>A usage string may look like
     * {@code [-w &lt;world&gt;] &lt;var1&gt; &lt;var2&gt;}.</p>
     *
     * <p>The string must not contain the command alias.</p>
     *
     * @param cause The {@link Cause} of the help request
     * @return A usage string
     */
    Text getUsage(Cause cause);

    /**
     *
     */
    interface Parameterized extends Command, CommandExecutor {

        /**
         * The list of {@link Parameter}s that this {@link Command}
         * contains.
         *
         * <p>This must not return {@code null}, rather, it should return an
         * empty {@link List}.</p>
         *
         * @return A copy of the list of {@link Parameter}s.
         */
        List<Parameter> parameters();

        /**
         * Parses the parameters based on the provided {@link #parameters()}
         *
         * @param cause The {@link Cause} of this parse
         * @param arguments The argument {@link String}
         * @return The {@link CommandContext}
         */
        CommandContext parseArguments(Cause cause, String arguments);

        /**
         * Processes the command by parsing the arguments, then
         * executing command based on these arguments.
         *
         * <p>By default, this will call {@link #parseArguments(Cause, String)}
         * and pass the resulting {@link CommandContext} to
         * {@link #execute(CommandContext)}.</p>
         *
         * @param cause The {@link Cause} of the command
         * @param arguments The raw arguments for this command
         * @return The result of a command being processed
         * @throws CommandException Thrown on a command error
         */
        default CommandResult process(Cause cause, String arguments) throws CommandException {
            return execute(parseArguments(cause, arguments));
        }

    }

    /**
     * A high level {@link Builder} for creating a
     * {@link Command.Parameterized}.
     *
     * <p>When creating a command, ensure that a {@link CommandExecutor}
     * <strong>and/or</strong> a child command is specified.</p>
     */
    interface Builder extends ResettableBuilder<Command.Parameterized, Builder> {

        /**
         * Adds a {@link Command} as a top-level child to this command,
         * using the supplied keys. The keys are case insensitive.
         *
         * <p>Children added here will be added to the beginning of the
         * {@link Parameter}s. Note that if you wish to add a subcommand
         * in the middle of the parameters, you can do so by creating
         * a {@link org.spongepowered.api.command.parameter.Parameter.Subcommand}
         * and adding that as a {@link #parameter(Parameter)} at the
         * appropriate time.</p>
         *
         * @param child The {@link Command} that is a child.
         * @param keys The keys to register as a sub command.
         * @return This builder, for chaining
         * @throws IllegalArgumentException thrown if a child key is already
         *                                  in the builder
         */
        default Builder child(Command child, String... keys) {
            return child(child, Arrays.asList(keys));
        }

        /**
         * Adds a {@link Command} as a child to this command, under the
         * supplied keys. The keys are case insensitive.
         *
         * <p>Children added here will be added to the beginning of the
         * {@link Parameter}s. Note that if you wish to add a subcommand
         * in the middle of the parameters, you can do so by creating
         * a {@link org.spongepowered.api.command.parameter.Parameter.Subcommand}
         * and adding that as a {@link #parameter(Parameter)} at the
         * appropriate time.</p>
         *
         * @param child The {@link Command} that is a child.
         * @param keys The keys to register as a sub command.
         * @return This builder, for chaining
         * @throws IllegalArgumentException thrown if a child key is already
         *                                  in the builder
         */
        Builder child(Command child, Iterable<String> keys);

        /**
         * Adds multiple {@link Command} as children to this command,
         * under the supplied keys. The keys are case insensitive.
         *
         * <p>Children added here will be added to the beginning of the
         * {@link Parameter}s. Note that if you wish to add a subcommand
         * in the middle of the parameters, you can do so by creating
         * a {@link org.spongepowered.api.command.parameter.Parameter.Subcommand}
         * and adding that as a {@link #parameter(Parameter)} at the
         * appropriate time.</p>
         *
         * @param children The {@link Map} that contains a mapping of keys to
         *                 their respective {@link Command} children.
         * @return This builder, for chaining
         * @throws IllegalArgumentException thrown if a child key is already
         *                                  in the builder
         */
        default Builder children(Map<? extends Iterable<String>, ? extends Command> children) {
            for (Map.Entry<? extends Iterable<String>, ? extends Command> child : children.entrySet()) {
                child(child.getValue(), child.getKey());
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
        Builder parameter(Parameter parameter);

        /**
         * Adds parameters to use when parsing arguments. Parameters will be
         * used in the order provided here.
         *
         * @param parameters The {@link Parameter}s to use
         * @return This builder, for chaining
         */
        default Builder parameters(Parameter... parameters) {
            return parameters(Arrays.asList(parameters));
        }

        /**
         * Adds parameters to use when parsing arguments. Parameters will be
         * used in the order provided here.
         *
         * @param parameters The {@link Parameter}s to use
         * @return This builder, for chaining
         */
        default Builder parameters(Iterable<Parameter> parameters) {
            for (Parameter parameter : parameters) {
                parameter(parameter);
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
        Builder setExecutor(CommandExecutor executor);

        /**
         * Provides the description for this command, which is dependent on the
         * {@link Cause} that requests it.
         *
         * <p>A one line summary should be provided to
         * {@link #setShortDescription(Text)}</p>
         *
         * @param extendedDescriptionFunction A function that provides a
         *      relevant description based on the supplied {@link Cause}
         * @return This builder, for chaining
         */
        Builder setExtendedDescription(Function<Cause, Optional<Text>> extendedDescriptionFunction);

        /**
         * Provides the description for this command.
         *
         * <p>A one line summary should be provided to
         * {@link #setShortDescription(Text)}</p>
         *
         * @param extendedDescription The description to use, or {@code null}
         *                            for no description.
         * @return This builder, for chaining
         */
        default Builder setExtendedDescription(@Nullable Text extendedDescription) {
            // Done outside the lambda so that we don't have to recreate the object each time.
            Optional<Text> text = Optional.ofNullable(extendedDescription);
            return setExtendedDescription((cause) -> text);
        }

        /**
         * The flags that this command should accept. See {@link Flags}.
         *
         * @param flags The {@link Flags} to accept
         * @return This builder, for chaining
         */
        Builder setFlags(Flags flags);

        /**
         * Provides a simple description for this command, typically no more
         * than one line, which is dependent on the {@link Cause} and the
         * responsible {@link CommandSource} that requests it.
         *
         * <p>Fuller descriptions should be provided through
         * {@link #setExtendedDescription(Function)}</p>
         *
         * @param descriptionFunction A function that provides a relevant
         *      description based on the supplied {@link Cause} and
         *      {@link CommandSource}
         * @return This builder, for chaining
         */
        Builder setShortDescription(Function<Cause, Optional<Text>> descriptionFunction);

        /**
         * Provides a simple description for this command, typically no more
         * than one line.
         *
         * <p>Fuller descriptions should be provided through
         * {@link #setExtendedDescription(Text)}</p>
         *
         * @param description The description to use, or {@code null} for no
         *                    description
         * @return This builder, for chaining
         */
        default Builder setShortDescription(@Nullable Text description) {
            // Done outside the lambda so that we don't have to recreate the object each time.
            Optional<Text> text = Optional.ofNullable(description);
            return setShortDescription((cause) -> text);
        }

        /**
         * The permission that a {@link CommandSource} requires to run this
         * command, or {@code null} if no permission is required.
         *
         * <p>For more control over whether a command can be executed, use
         * {@link #setExecutionRequirements(Predicate)}. However, note that
         * setting a permission here will not override anything set in
         * {@link #setExecutionRequirements(Predicate)}, both will be checked
         * during execution.</p>
         *
         * @param permission The permission that is required, or {@code null}
         *                   for no permission
         * @return This builder, for chaining
         */
        Builder setPermission(@Nullable String permission);

        /**
         * Sets a function that determines what is required of the provided
         * {@link Cause} and {@link CommandSource} before this command executes.
         *
         * <p>Any requirements here are in addition to the permission check
         * from {@link #setPermission(String)}</p>
         *
         * @param executionRequirements A function that sets the
         * @return This builder, for chaining
         */
        Builder setExecutionRequirements(@Nullable Predicate<Cause> executionRequirements);

        /**
         * Builds this command, creating a {@link Command.Parameterized}
         * object.
         *
         * <p>To build the command, <strong>one</strong> of the following is
         * required:</p>
         *
         * <ul>
         *     <li>A {@link CommandExecutor} is provided using
         *     {@link #setExecutor(CommandExecutor)}</li>
         *     <li>At least one {@link Command} is set to be a child command
         *     using {@link #child(Command, Iterable)} or {@link #children(Map)}
         *     </li>
         * </ul>
         *
         * <p>If these conditions are not fulfilled, an
         * {@link IllegalStateException} will be thrown.</p>
         *
         * @return The command, ready for registration
         * @throws IllegalStateException if the builder is not complete
         */
        Command.Parameterized build();

    }

}
