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
package org.spongepowered.api.util.command;

import static org.spongepowered.api.util.command.TranslationPlaceholder.t;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import org.spongepowered.api.service.command.GameArguments;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextBuilder;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.args.ArgumentParseException;
import org.spongepowered.api.util.command.args.CommandArgs;
import org.spongepowered.api.util.command.args.CommandElement;
import org.spongepowered.api.util.command.args.GenericArguments;
import org.spongepowered.api.util.command.args.parsing.InputTokenizer;
import org.spongepowered.api.util.command.args.parsing.InputTokenizers;
import org.spongepowered.api.util.command.dispatcher.CommandMessageFormatting;
import org.spongepowered.api.util.command.dispatcher.SimpleDispatcher;

import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * Specification for how command arguments should be parsed.
 */
public final class CommandSpec implements CommandCallable {
    private final CommandElement args;
    private final CommandExecutor executor;
    @Nullable private final Text description;
    @Nullable private final Text extendedDescription;
    @Nullable private final String permission;
    private final InputTokenizer argumentParser;

    private CommandSpec(CommandElement args, CommandExecutor executor, @Nullable Text description, @Nullable Text extendedDescription,
            @Nullable String permission, InputTokenizer parser) {
        this.args = args;
        this.executor = executor;
        this.permission = permission;
        this.description = description;
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
        private CommandElement args = GenericArguments.none();
        @Nullable
        private Text description;
        @Nullable
        private Text extendedDescription;
        @Nullable
        private String permission;
        private CommandExecutor executor;
        private InputTokenizer argumentParser = InputTokenizers.quotedStrings(false);

        private Builder() {}

        /**
         * Set the permission that will be checked before using this command.
         *
         * @param permission The permission to check
         * @return this
         */
        public Builder setPermission(String permission) {
            this.permission = permission;
            return this;
        }

        /**
         * Set the callback that will handle this command's execution.
         *
         * @param executor The executor that will be called with this command's parsed arguments
         * @return this
         */
        public Builder setExecutor(CommandExecutor executor) {
            Preconditions.checkNotNull(executor, "executor");
            this.executor = executor;
            return this;
        }

        /**
         * Set the child arguments for this command. If the executor has already been set, that executor is used as a fallback executor for further
         * commands.
         *
         * @param children The children to use
         * @return this
         */
        public Builder setChildren(Map<List<String>, CommandSpec> children) {
            Preconditions.checkNotNull(children, "children");
            SimpleDispatcher childDispatcher = new SimpleDispatcher(this.executor);
            for (Map.Entry<List<String>, CommandSpec> spec : children.entrySet()) {
                childDispatcher.register(spec.getValue(), spec.getKey());
            }
            setArguments(childDispatcher);
            setExecutor(childDispatcher);
            return this;
        }

        /**
         * A short, one-line description of this command's purpose.
         *
         * @param description The description to set
         * @return this
         */
        public Builder setDescription(@Nullable Text description) {
            this.description = description;
            return this;
        }

        /**
         * Sets an extended description to use in longer help listings for this command.
         * Will be appended to the short description and the command's usage.
         *
         * @param extendedDescription The description to set
         * @return this
         */
        public Builder setExtendedDescription(@Nullable Text extendedDescription) {
            this.extendedDescription = extendedDescription;
            return this;
        }

        /**
         * Set the argument specification for this command.
         * Generally, for a multi-argument command the {@link GenericArguments#seq(CommandElement...)} method is used to parse a sequence of args
         *
         * @see GenericArguments
         * @see GameArguments
         * @param args The arguments object to use
         * @return this
         */
        public Builder setArguments(CommandElement args) {
            Preconditions.checkNotNull(args, "args");
            this.args = args;
            return this;
        }

        /**
         * Set the argument parser to be used to convert input from a string into a list of argument tokens.
         *
         * @see InputTokenizers for common input parser implementations
         * @param parser The parser to use
         * @return this
         */
        public Builder setArgumentParser(InputTokenizer parser) {
            Preconditions.checkNotNull(parser, "parser");
            this.argumentParser = parser;
            return this;
        }

        /**
         * Create a new {@link CommandSpec} based on the data provided in this builder.
         *
         * @return the new spec
         */
        public CommandSpec build() {
            Preconditions.checkNotNull(this.executor, "An executor is required");

            return new CommandSpec(this.args, this.executor, this.description, this.extendedDescription, this.permission,
                    this.argumentParser);
        }
    }

    /**
     * Check the relevant permission for this command with the provided source, throwing an exception if the source does not have permission to use
     * the command.
     *
     * @param source The source to check
     * @throws CommandException if the source does not have permission
     */
    public void checkPermission(CommandSource source) throws CommandException {
        Preconditions.checkNotNull(source, "source");
        if (!testPermission(source)) {
            throw new CommandPermissionException();
        }
    }

    /**
     * Process this command with existing arguments and context objects.
     *
     * @param args The arguments to process with
     * @param context The context to put data in
     * @throws ArgumentParseException if an invalid argument is provided
     */
    public void populateContext(CommandArgs args, CommandContext context) throws ArgumentParseException {
        this.args.parse(args, context);
        if (args.hasNext()) {
            args.next();
            throw args.createError(t("Too many arguments!"));
        }
    }

    /**
     * Return tab completion results using the existing parsed arguments and context. Primarily useful when including a subcommand in an existing
     * specification.
     *
     * @param source The source to parse arguments for
     * @param args The arguments object
     * @param context The context object
     * @return possible completions, or an empty list if none
     */
    public List<String> complete(CommandSource source, CommandArgs args, CommandContext context) {
        Preconditions.checkNotNull(source, "source");
        List<String> ret = this.args.complete(source, args, context);
        return ret == null ? ImmutableList.<String>of() : ImmutableList.copyOf(ret);
    }

    /**
     * Get the active executor for this command. Generally not a good idea to call this directly,
     * unless you are handling arg parsing specially
     *
     * @return The active executor for this command
     */
    public CommandExecutor getExecutor() {
        return this.executor;
    }

    /**
     * Get the active input tokenizer used for this commmand.
     *
     * @return This command's input tokenizer
     */
    public InputTokenizer getInputTokenizer() {
        return this.argumentParser;
    }


    @Override
    public boolean process(CommandSource source, String arguments) throws CommandException {
        checkPermission(source);
        final CommandArgs args = new CommandArgs(arguments, getInputTokenizer().tokenize(arguments, false));
        final CommandContext context = new CommandContext();
        this.populateContext(args, context);
        getExecutor().execute(source, context);
        return true;
    }

    @Override
    public List<String> getSuggestions(CommandSource source, String arguments) throws CommandException {
        CommandArgs args = new CommandArgs(arguments, getInputTokenizer().tokenize(arguments, true));
        return complete(source, args, new CommandContext());
    }

    @Override
    public boolean testPermission(CommandSource source) {
        return this.permission == null || source.hasPermission(this.permission);
    }

    /**
     * Get a short, one-line description used with this command if any is present
     *
     * @return the short description.
     */
    @Override
    public Optional<Text> getShortDescription(CommandSource source) {
        return Optional.fromNullable(this.description);
    }

    /**
     * Get the usage for this command appropriate for the provided command source.
     *
     * @param source The source
     * @return the usage for the source
     */
    @Override
    public Text getUsage(CommandSource source) {
        Preconditions.checkNotNull(source, "source");
        return this.args.getUsage(source);
    }

    /**
     * Return a longer description for this command. This description is composed of at least all present of the short description, the usage
     * statement, and the extended description
     * @param source The source to get the extended description for
     * @return the extended description
     */
    @Override
    public Optional<Text> getHelp(CommandSource source) {
        Preconditions.checkNotNull(source, "source");
        TextBuilder builder = Texts.builder();
        Optional<Text> desc = getShortDescription(source);
        if (desc.isPresent()) {
            builder.append(desc.get(), CommandMessageFormatting.NEWLINE_TEXT);
        }
        builder.append(getUsage(source));
        if (this.extendedDescription != null) {
            builder.append(CommandMessageFormatting.NEWLINE_TEXT, this.extendedDescription);
        }
        return Optional.of(builder.build());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CommandSpec)) {
            return false;
        }

        CommandSpec that = (CommandSpec) o;

        if (!this.args.equals(that.args)) {
            return false;
        }
        if (!this.argumentParser.equals(that.argumentParser)) {
            return false;
        }
        if (this.description != null ? !this.description.equals(that.description) : that.description != null) {
            return false;
        }
        if (!this.executor.equals(that.executor)) {
            return false;
        }
        if (this.extendedDescription != null ? !this.extendedDescription.equals(that.extendedDescription) : that.extendedDescription != null) {
            return false;
        }
        if (this.permission != null ? !this.permission.equals(that.permission) : that.permission != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = this.args.hashCode();
        result = 31 * result + this.executor.hashCode();
        result = 31 * result + (this.description != null ? this.description.hashCode() : 0);
        result = 31 * result + (this.extendedDescription != null ? this.extendedDescription.hashCode() : 0);
        result = 31 * result + (this.permission != null ? this.permission.hashCode() : 0);
        result = 31 * result + this.argumentParser.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CommandSpec{"
                + "args=" + this.args
                + ", executor=" + this.executor
                + ", description=" + this.description
                + ", extendedDescription=" + this.extendedDescription
                + ", permission='" + this.permission + '\''
                + ", argumentParser=" + this.argumentParser
                + '}';
    }
}

