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
package org.spongepowered.api.command.spec;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.spongepowered.api.command.args.GenericArguments.firstParsing;
import static org.spongepowered.api.command.args.GenericArguments.optional;
import static org.spongepowered.api.util.SpongeApiTranslationHelper.t;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import org.spongepowered.api.command.CommandCallable;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandPermissionException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.ArgumentParseException;
import org.spongepowered.api.command.args.ChildCommandElementExecutor;
import org.spongepowered.api.command.args.CommandArgs;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.args.parsing.InputTokenizer;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Nullable;

/**
 * Specification for how command arguments should be parsed.
 */
public final class CommandSpec implements CommandCallable {

    private final CommandElement args;
    private final CommandExecutor executor;
    private final Optional<Text> description;
    @Nullable private final Text extendedDescription;
    @Nullable private final String permission;
    private final InputTokenizer argumentParser;

    CommandSpec(CommandElement args, CommandExecutor executor, @Nullable Text description, @Nullable Text extendedDescription,
            @Nullable String permission, InputTokenizer parser) {
        this.args = args;
        this.executor = executor;
        this.permission = permission;
        this.description = Optional.ofNullable(description);
        this.extendedDescription = extendedDescription;
        this.argumentParser = parser;
    }

    /**
     * Return a new builder for a CommandSpec.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for command specs.
     */
    public static final class Builder {

        private static final CommandElement DEFAULT_ARG = GenericArguments.none();
        private CommandElement args = DEFAULT_ARG;
        @Nullable
        private Text description;
        @Nullable
        private Text extendedDescription;
        @Nullable
        private String permission;
        @Nullable
        private CommandExecutor executor;
        @Nullable
        private Map<List<String>, CommandCallable> childCommandMap;
        private InputTokenizer argumentParser = InputTokenizer.quotedStrings(false);

        Builder() {}

        /**
         * Sets the permission that will be checked before using this command.
         *
         * @param permission The permission to check
         * @return this
         */
        public Builder permission(String permission) {
            this.permission = permission;
            return this;
        }

        /**
         * Sets the callback that will handle this command's execution.
         *
         * @param executor The executor that will be called with this command's
         *     parsed arguments
         * @return this
         */
        public Builder executor(CommandExecutor executor) {
            checkNotNull(executor, "executor");
            this.executor = executor;
            return this;
        }

        /**
         * Adds more child arguments for this command.
         * If an executor or arguments are set, they are used as fallbacks.
         *
         * @param children The children to use
         * @return this
         */
        public Builder children(Map<List<String>, ? extends CommandCallable> children) {
            checkNotNull(children, "children");
            if (this.childCommandMap == null) {
                this.childCommandMap = new HashMap<>();
            }
            this.childCommandMap.putAll(children);
            return this;
        }

        /**
         * Add a single child command to this command.
         *
         * @param child The child to add
         * @param aliases Aliases to make the child available under. First
         *     one is primary and is the only one guaranteed to be listed in
         *     usage outputs.
         *
         * @return this
         */
        public Builder child(CommandCallable child, String... aliases) {
            if (this.childCommandMap == null) {
                this.childCommandMap = new HashMap<>();
            }
            this.childCommandMap.put(ImmutableList.copyOf(aliases), child);
            return this;
        }

        /**
         * Add a single child command to this command.
         *
         * @param child The child to add.
         * @param aliases Aliases to make the child available under. First
         *     one is primary and is the only one guaranteed to be listed in
         *     usage outputs.
         *
         * @return this
         */
        public Builder child(CommandCallable child, Collection<String> aliases) {
            if (this.childCommandMap == null) {
                this.childCommandMap = new HashMap<>();
            }
            this.childCommandMap.put(ImmutableList.copyOf(aliases), child);
            return this;
        }

        /**
         * A short, one-line description of this command's purpose.
         *
         * @param description The description to set
         * @return this
         */
        public Builder description(@Nullable Text description) {
            this.description = description;
            return this;
        }

        /**
         * Sets an extended description to use in longer help listings for this
         * command. Will be appended to the short description and the command's
         * usage.
         *
         * @param extendedDescription The description to set
         * @return this
         */
        public Builder extendedDescription(@Nullable Text extendedDescription) {
            this.extendedDescription = extendedDescription;
            return this;
        }

        /**
         * Sets the argument specification for this command. Generally, for a
         * multi-argument command the {@link GenericArguments#seq(CommandElement...)}
         * method is used to parse a sequence of args.
         *
         * @see GenericArguments
         * @param args The arguments object to use
         * @return this
         */
        public Builder arguments(CommandElement args) {
            checkNotNull(args, "args");
            this.args = args;
            return this;
        }

        /**
         * Sets the argument specification for this command. This method accepts
         * a sequence of arguments. This is equivalent to calling {@code
         * arguments(seq(args))}.
         *
         * @see GenericArguments
         * @param args The arguments object to use
         * @return this
         */
        public Builder arguments(CommandElement... args) {
            checkNotNull(args, "args");
            this.args = GenericArguments.seq(args);
            return this;
        }

        /**
         * Sets the input tokenizer to be used to convert input from a string
         * into a list of argument tokens.
         *
         * @see InputTokenizer for common input parser implementations
         * @param parser The parser to use
         * @return this
         */
        public Builder inputTokenizer(InputTokenizer parser) {
            checkNotNull(parser, "parser");
            this.argumentParser = parser;
            return this;
        }

        /**
         * Create a new {@link CommandSpec} based on the data provided in this
         * builder.
         *
         * @return the new spec
         */
        public CommandSpec build() {
            if (this.childCommandMap == null) {
                checkNotNull(this.executor, "An executor is required");
            } else {
                ChildCommandElementExecutor childDispatcher = new ChildCommandElementExecutor(this.executor);
                for (Map.Entry<List<String>, ? extends CommandCallable> spec : this.childCommandMap.entrySet()) {
                    childDispatcher.register(spec.getValue(), spec.getKey());
                }

                if (this.args == DEFAULT_ARG) {
                    arguments(this.executor == null ? childDispatcher : optional(childDispatcher));
                } else {
                    if (this.executor == null) {
                        arguments(this.args, childDispatcher);
                    } else {
                        arguments(firstParsing(childDispatcher, this.args));
                    }
                }
                executor(childDispatcher);
            }

            return new CommandSpec(this.args, this.executor, this.description, this.extendedDescription, this.permission,
                    this.argumentParser);
        }
    }

    /**
     * Check the relevant permission for this command with the provided source,
     * throwing an exception if the source does not have permission to use
     * the command.
     *
     * @param source The source to check
     * @throws CommandException if the source does not have permission
     */
    public void checkPermission(CommandSource source) throws CommandException {
        checkNotNull(source, "source");
        if (!testPermission(source)) {
            throw new CommandPermissionException();
        }
    }

    /**
     * Process this command with existing arguments and context objects.
     *
     *
     * @param source The source to populate the context with
     * @param args The arguments to process with
     * @param context The context to put data in
     * @throws ArgumentParseException if an invalid argument is provided
     */
    public void populateContext(CommandSource source, CommandArgs args, CommandContext context) throws ArgumentParseException {
        this.args.parse(source, args, context);
        if (args.hasNext()) {
            args.next();
            throw args.createError(t("Too many arguments!"));
        }
    }

    /**
     * Return tab completion results using the existing parsed arguments and
     * context. Primarily useful when including a subcommand in an existing
     * specification.
     *
     * @param source The source to parse arguments for
     * @param args The arguments object
     * @param context The context object
     * @return possible completions, or an empty list if none
     */
    public List<String> complete(CommandSource source, CommandArgs args, CommandContext context) {
        checkNotNull(source, "source");
        List<String> ret = this.args.complete(source, args, context);
        return ret == null ? ImmutableList.<String>of() : ImmutableList.copyOf(ret);
    }

    /**
     * Gets the active executor for this command. Generally not a good idea to
     * call this directly, unless you are handling arg parsing specially
     *
     * @return The active executor for this command
     */
    public CommandExecutor getExecutor() {
        return this.executor;
    }

    /**
     * Gets the active input tokenizer used for this command.
     *
     * @return This command's input tokenizer
     */
    public InputTokenizer getInputTokenizer() {
        return this.argumentParser;
    }

    @Override
    public CommandResult process(CommandSource source, String arguments) throws CommandException {
        checkPermission(source);
        final CommandArgs args = new CommandArgs(arguments, getInputTokenizer().tokenize(arguments, false));
        final CommandContext context = new CommandContext();
        this.populateContext(source, args, context);
        return getExecutor().execute(source, context);
    }

    @Override
    public List<String> getSuggestions(CommandSource source, String arguments, @Nullable Location<World> targetPos) throws CommandException {
        CommandArgs args = new CommandArgs(arguments, getInputTokenizer().tokenize(arguments, true));
        CommandContext ctx = new CommandContext();
        if (targetPos != null) {
            ctx.putArg(CommandContext.TARGET_BLOCK_ARG, targetPos);
        }
        return complete(source, args, ctx);
    }

    @Override
    public boolean testPermission(CommandSource source) {
        return this.permission == null || source.hasPermission(this.permission);
    }

    /**
     * Gets a short, one-line description used with this command if any is
     * present
     *
     * @return the short description.
     */
    @Override
    public Optional<Text> getShortDescription(CommandSource source) {
        return this.description;
    }

    /**
     * Gets the usage for this command appropriate for the provided command
     * source.
     *
     * @param source The source
     * @return the usage for the source
     */
    @Override
    public Text getUsage(CommandSource source) {
        checkNotNull(source, "source");
        return this.args.getUsage(source);
    }

    /**
     * Return a longer description for this command. This description is
     * composed of at least all present of the short description, the usage
     * statement, and the extended description
     *
     * @param source The source to get the extended description for
     * @return the extended description
     */
    @Override
    public Optional<Text> getHelp(CommandSource source) {
        checkNotNull(source, "source");
        Text.Builder builder = Text.builder();
        Optional<Text> desc = getShortDescription(source);
        if (desc.isPresent()) {
            builder.append(desc.get(), Text.NEW_LINE);
        }
        builder.append(getUsage(source));
        if (this.extendedDescription != null) {
            builder.append(Text.NEW_LINE, this.extendedDescription);
        }
        return Optional.of(builder.build());
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CommandSpec that = (CommandSpec) o;
        return Objects.equal(this.args, that.args)
                && Objects.equal(this.executor, that.executor)
                && Objects.equal(this.description, that.description)
                && Objects.equal(this.extendedDescription, that.extendedDescription)
                && Objects.equal(this.permission, that.permission)
                && Objects.equal(this.argumentParser, that.argumentParser);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.args, this.executor, this.description, this.extendedDescription, this.permission, this.argumentParser);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("args", this.args)
                .add("executor", this.executor)
                .add("description", this.description)
                .add("extendedDescription", this.extendedDescription)
                .add("permission", this.permission)
                .add("argumentParser", this.argumentParser)
                .toString();
    }
}
