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

import static org.spongepowered.api.command.CommandMessageFormatting.error;
import static org.spongepowered.api.util.SpongeApiTranslationHelper.t;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimaps;
import org.spongepowered.api.command.CommandCallable;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandMapping;
import org.spongepowered.api.command.CommandMessageFormatting;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.dispatcher.SimpleDispatcher;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.StartsWithPredicate;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nullable;

public class ChildCommandElementExecutor extends CommandElement implements CommandExecutor {
    private static final AtomicInteger COUNTER = new AtomicInteger();
    private static final CommandElement NONE = GenericArguments.none();

    @Nullable private final CommandExecutor fallbackExecutor;
    @Nullable private final CommandElement fallbackElements;
    private final SimpleDispatcher dispatcher = new SimpleDispatcher(SimpleDispatcher.FIRST_DISAMBIGUATOR);
    private final boolean fallbackOnFail;

    /**
     * Create a new combined argument element and executor to handle the
     * parsing and execution of child commands.
     *
     * @param fallbackExecutor The executor to execute if the child command
     *     has been marked optional (Generally when this is wrapped in a
     *     {@link GenericArguments#optional(CommandElement)}
     * @deprecated Use the other constructor instead. Note: this entire system
     *     will be replaced in API 8.
     */
    @Deprecated
    public ChildCommandElementExecutor(@Nullable CommandExecutor fallbackExecutor) {
        this(fallbackExecutor, null, true);
    }

    /**
     * Create a new combined argument element and executor to handle the
     * parsing and execution of child commands.
     *
     * @param fallbackExecutor The executor to execute if the child command
     *     has been marked optional (Generally when this is wrapped in a
     *     {@link GenericArguments#optional(CommandElement)}
     * @param fallbackElements The alternate {@link CommandElement}s that should
     *     be parsed if a child element fails to be parsed
     * @param fallbackOnFail If true, then if a child command cannot parse the
     *     elements, the exception is discarded and the parent command attempts
     *     to parse the elements. If false, a child command will not pass
     *     control back to the parent, displaying its own exception message
     */
    public ChildCommandElementExecutor(@Nullable CommandExecutor fallbackExecutor, @Nullable CommandElement fallbackElements,
            boolean fallbackOnFail) {
        super(Text.of("child" + COUNTER.getAndIncrement()));
        this.fallbackExecutor = fallbackExecutor;
        this.fallbackElements = NONE == fallbackElements ? null : fallbackElements;
        this.fallbackOnFail = fallbackOnFail;
    }

    /**
     * Register a child command for a given set of aliases.
     *
     * @param callable The command to register
     * @param aliases The aliases to register it as
     * @return The child command's mapping, if present
     */
    public Optional<CommandMapping> register(CommandCallable callable, List<String> aliases) {
        return this.dispatcher.register(callable, aliases);
    }

    /**
     * Register a child command for a given set of aliases.
     *
     * @param callable The command to register
     * @param aliases The aliases to register it as
     * @return The child command's mapping, if present
     */
    public Optional<CommandMapping> register(CommandCallable callable, String... aliases) {
        return this.dispatcher.register(callable, aliases);
    }

    @Override
    public List<String> complete(final CommandSource src, CommandArgs args, CommandContext context) {
        List<String> completions = Lists.newArrayList();
        if (this.fallbackElements != null) {
            CommandArgs.Snapshot state = args.getSnapshot();
            completions.addAll(this.fallbackElements.complete(src, args, context));
            args.applySnapshot(state);
        }

        final Optional<String> commandComponent = args.nextIfPresent();
        if (!commandComponent.isPresent()) {
            return ImmutableList.copyOf(filterCommands(src));
        }
        if (args.hasNext()) {
            Optional<CommandMapping> child = this.dispatcher.get(commandComponent.get(), src);
            if (!child.isPresent()) {
                return ImmutableList.of();
            }
            if (child.get().getCallable() instanceof CommandSpec) {
                return ((CommandSpec) child.get().getCallable()).complete(src, args, context);
            }
            args.nextIfPresent();
            final String arguments = args.getRaw().substring(args.getRawPosition());
            while (args.hasNext()) {
                args.nextIfPresent();
            }
            try {
                return child.get()
                        .getCallable()
                        .getSuggestions(src, arguments, context.<Location<World>>getOne(CommandContext.TARGET_BLOCK_ARG).orElse(null));
            } catch (CommandException e) {
                Text eText = e.getText();
                if (eText != null) {
                    src.sendMessage(error(eText));
                }
                return ImmutableList.of();
            }
        }
        completions.addAll(filterCommands(src).stream()
                .filter(new StartsWithPredicate(commandComponent.get()))
                .collect(ImmutableList.toImmutableList()));
        return completions;
    }

    private Set<String> filterCommands(final CommandSource src) {
        return Multimaps.filterValues(this.dispatcher.getAll(),
            input ->
                input != null && input.getCallable().testPermission(src)
        )
            .keys()
            .elementSet();
    }

    @Override
    public void parse(CommandSource source, CommandArgs args, CommandContext context) throws ArgumentParseException {
        if (this.fallbackExecutor != null && !args.hasNext()) {
            if (this.fallbackElements != null) {
                // there might be optionals to take account of that would parse this successfully.
                this.fallbackElements.parse(source, args, context);
            }

            return; // execute the fallback regardless in this scenario.
        }

        CommandArgs.Snapshot state = args.getSnapshot();
        final String key = args.next();
        Optional<CommandMapping> optionalCommandMapping = this.dispatcher.get(key, source);
        if (optionalCommandMapping.isPresent()) {
            final CommandMapping mapping = optionalCommandMapping.get();
            try {
                if ((mapping.getCallable() instanceof CommandSpec)) {
                    CommandSpec spec = ((CommandSpec) mapping.getCallable());
                    spec.populateContext(source, args, context);
                } else {
                    if (args.hasNext()) {
                        args.next();
                    }

                    context.putArg(getUntranslatedKey() + "_args", args.getRaw().substring(args.getRawPosition()));
                    while (args.hasNext()) {
                        args.next();
                    }
                }

                // Success, add to context now so that we don't execute the wrong executor in the first place.
                context.putArg(getUntranslatedKey(), mapping);
            } catch (ArgumentParseException ex) {
                // If we get here, fallback to the elements, if they exist.
                args.applySnapshot(state);
                if (this.fallbackOnFail && this.fallbackElements != null) {
                    this.fallbackElements.parse(source, args, context);
                    return;
                }

                // Get the usage
                args.next();
                if (ex instanceof ArgumentParseException.WithUsage) {
                    // This indicates a previous child failed, so we just prepend our child
                    throw new ArgumentParseException.WithUsage(ex, Text.of(key, " ", ((ArgumentParseException.WithUsage) ex).getUsage()));
                }

                throw new ArgumentParseException.WithUsage(ex, Text.of(key, " ", mapping.getCallable().getUsage(source)));
            }
        } else {
            // Not a child, so let's continue with the fallback.
            if (this.fallbackExecutor != null && this.fallbackElements != null) {
                args.applySnapshot(state);
                this.fallbackElements.parse(source, args, context);
            } else {
                // If we have no elements to parse, then we throw this error - this is the only element
                // so specifying it implicitly means we have a child command to execute.
                throw args.createError(t("Input command %s was not a valid subcommand!", key));
            }
        }
    }

    @Override
    protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
        return null;
    }

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        CommandMapping mapping = args.<CommandMapping>getOne(getUntranslatedKey()).orElse(null);
        if (mapping == null) {
            if (this.fallbackExecutor == null) {
                throw new CommandException(t("Invalid subcommand state -- no more than one mapping may be provided for child arg %s", getKey()));
            }
            return this.fallbackExecutor.execute(src, args);
        }
        if (mapping.getCallable() instanceof CommandSpec) {
            CommandSpec spec = ((CommandSpec) mapping.getCallable());
            spec.checkPermission(src);
            return spec.getExecutor().execute(src, args);
        }
        final String arguments = args.<String>getOne(getUntranslatedKey() + "_args").orElse("");
        return mapping.getCallable().process(src, arguments);
    }

    @Override
    public Text getUsage(CommandSource src) {
        Text usage = this.dispatcher.getUsage(src);
        if (this.fallbackElements == null) {
            return usage;
        }

        Text elementUsage = this.fallbackElements.getUsage(src);
        if (elementUsage.isEmpty()) {
            return usage;
        }

        return Text.of(usage, CommandMessageFormatting.PIPE_TEXT, elementUsage);
    }
}
