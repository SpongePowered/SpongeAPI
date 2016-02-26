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
import static org.spongepowered.api.command.args.GenericArguments.optional;
import static org.spongepowered.api.util.SpongeApiTranslationHelper.t;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandMapping;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.dispatcher.SimpleDispatcher;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.GuavaCollectors;
import org.spongepowered.api.util.StartsWithPredicate;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Wrapper CommandElement to allow commands to be embedded into parent commands
 */
public class ChildCommand {
    private static final AtomicInteger COUNTER = new AtomicInteger(Integer.MIN_VALUE);


    public static Map.Entry<CommandElement.Value<ChildCommand>, CommandExecutor> forChildren(Map<List<String>, CommandSpec> children) {
        ChildElement element = createElement(children);
        CommandExecutor ex =  (src, args) -> args.get(element).execute(src);
        return Maps.immutableEntry(element, ex);
    }

    private static ChildElement createElement(Map<List<String>, CommandSpec> children) {
        ChildElement element = new ChildElement();
        for (Map.Entry<List<String>, ? extends CommandSpec> spec : children.entrySet()) {
            element.registerCommand(spec.getValue(), spec.getKey());
        }
        return element;

    }

    public static Map.Entry<CommandElement.Value<Optional<ChildCommand>>, CommandExecutor> forChildrenWithFallback(Map<List<String>, CommandSpec>
            children, CommandExecutor fallbackExecutor) {
        checkNotNull(fallbackExecutor, "fallbackExecutor");

        CommandElement.Value<Optional<ChildCommand>> element = optional(createElement(children));
        CommandExecutor ex =  (src, args) -> {
            Optional<ChildCommand> val = args.get(element);
            if (val.isPresent()) {
                return val.get().execute(src);
            } else {
                return fallbackExecutor.execute(src, args);
            }
        };
        return Maps.immutableEntry(element, ex);

    }


    private static class ChildElement extends CommandElement.Value<ChildCommand> {
        private final SimpleDispatcher dispatcher = new SimpleDispatcher(SimpleDispatcher.FIRST_DISAMBIGUATOR);

        protected ChildElement() {
            super(Text.of("childcommand_", String.valueOf(COUNTER.getAndIncrement())));
        }

        public Optional<CommandMapping> registerCommand(CommandSpec spec, List<String> aliases) {
            return this.dispatcher.register(spec, aliases);
        }

        @Override
        protected ChildCommand parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
            String childName = args.next();
            CommandMapping mapping = dispatcher.get(childName, source).orElseThrow(() -> args.createError(t("Input command %s was not a valid "
                    + "subcommand", childName)));
            CommandSpec child = ((CommandSpec) mapping.getCallable()); // Only CommandSpecs can be registered, so this is safe
            CommandContext ctx = new CommandContext();
            child.populateContext(source, args, ctx);
            return new ChildCommand(child, ctx);
        }

        @Override
        public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) throws ArgumentParseException {
            String arg = args.next();
            if (args.hasNext()) { //  Then we are beginning the child command
                Optional<CommandMapping> ret = dispatcher.get(arg, src);
                if (!ret.isPresent()) {
                    return ImmutableList.of();
                } else {
                    return ((CommandSpec) ret.get().getCallable()).complete(src, args, context);
                }
            } else { // Still completing parent command
                return dispatcher.getCommands().stream()
                        .filter(mapping -> mapping.getCallable().testPermission(src))
                        .flatMap(mapping -> mapping.getAllAliases().stream())
                        .filter(new StartsWithPredicate(arg))
                        .collect(GuavaCollectors.toImmutableList());
            }
        }

        @Override
        public Text getUsage(CommandSource src) {
            return this.dispatcher.getUsage(src);
        }
    }

    private final CommandSpec command;
    private final CommandContext arguments;

    private ChildCommand(CommandSpec command, CommandContext arguments) {
        this.command = command;
        this.arguments = arguments;
    }

    private CommandContext getArguments() {
        return this.arguments;
    }

    public CommandResult execute(CommandSource source) throws CommandException {
        command.checkPermission(source);
        return command.getExecutor().execute(source, arguments);
    }

}
