/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.service.command.sponge;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Optional;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextBuilder;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.util.command.CommandCallable;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandMapping;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.ImmutableCommandMapping;
import org.spongepowered.api.util.command.InvocationCommandException;
import org.spongepowered.api.util.command.dispatcher.Dispatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContextualDispatcher implements Dispatcher {

    private Map<CommandMapping, CommandRegistrar> commands = new HashMap<CommandMapping, CommandRegistrar>();
    private Map<String, AliasContext> contexts = new HashMap<String, AliasContext>();
    private boolean enableNotFoundMessages;

    private String shortDescription;
    private String usage;
    private Text help;

    public ContextualDispatcher(boolean enableNotFoundMessages, String shortDescription, Text help, String usage) {
        this.enableNotFoundMessages = enableNotFoundMessages;
        this.shortDescription = shortDescription;
        this.help = help;
        this.usage = usage;
    }

    public ContextualDispatcher(boolean enableNotFoundMessages) {
        this(enableNotFoundMessages, "", Texts.of(), "");
    }

    /**
     * Get the number of registered commands.
     *
     * @return The number of commands
     */
    public synchronized int size() {
        return this.commands.keySet().size();
    }

    /**
     * Get a set of {@link CommandRegistrar}s that have registered command(s)
     * with this CommandService.
     *
     * @return a set of CommandRegistrars
     */
    public Set<CommandRegistrar> getRegistrars() {
        return Collections.unmodifiableSet(new HashSet<CommandRegistrar>(this.commands.values()));
    }

    /**
     * Get a set of commands owned by the given {@link CommandRegistrar}.
     *
     * @param registrar The registrar
     * @return A set of mappings
     */
    public Set<CommandMapping> getOwnedBy(CommandRegistrar registrar) {
        Set<CommandMapping> mappings = new HashSet<CommandMapping>();
        for (CommandMapping m : this.commands.keySet()) {
            if (this.commands.get(m) == registrar) {
                mappings.add(m);
            }
        }
        return mappings;
    }

    /**
     * Register a given command using the given list of aliases.
     *
     * <p>The first alias becomes the "primary alias."</p>
     *
     * @param registrar The {@link CommandRegistrar} registering the command
     * @param callable The command
     * @param alias An array of aliases
     * @return The registered command mapping
     * @throws IllegalArgumentException Thrown if a command name is invalid
     */
    public synchronized CommandMapping register(CommandCallable callable, CommandRegistrar registrar, List<String> aliases)
            throws IllegalArgumentException {

        checkNotNull(aliases);
        checkNotNull(callable);
        checkNotNull(registrar);

        for (String alias : aliases) {
            if (alias.contains(":")) {
                throw new IllegalArgumentException("Command alias must not contain ':'.");
            }
        }

        ImmutableCommandMapping mapping = new ImmutableCommandMapping(callable, aliases.get(0), aliases);

        this.commands.put(mapping, registrar);

        return mapping;

    }

    /**
     * Register a given command using the given list of aliases.
     *
     * <p>The first alias becomes the "primary alias."</p>
     *
     * @param registrar The {@link CommandRegistrar} registering the command
     * @param callable The command
     * @param alias An array of aliases
     * @return The registered command mapping
     * @throws IllegalArgumentException Thrown if a command name is invalid
     */
    public synchronized CommandMapping register(CommandCallable callable, CommandRegistrar registrar, String... aliases)
            throws IllegalArgumentException {
        return this.register(callable, registrar, Arrays.asList(aliases));
    }

    @Override
    public boolean containsMapping(CommandMapping mapping) {
        return this.commands.containsKey(mapping);
    }

    /**
     * Remove a command identified by the given mapping.
     *
     * @param mapping The mapping
     * @return The previous mapping associated with the alias, if one was found
     */
    public synchronized Optional<CommandMapping> removeMapping(CommandMapping mapping) {
        if (this.containsMapping(mapping)) {
            this.commands.remove(mapping);
            return Optional.of(mapping);
        }
        return Optional.absent();
    }

    @Override
    public boolean call(CommandSource source, String arguments, List<String> parents) throws CommandException {
        String[] parts = arguments.split(" +", 2);
        String alias = parts[0].toLowerCase();
        Optional<CommandMapping> mapping = resolveMapping(alias, source);
        if (mapping.isPresent()) {
            List<String> passedParents = new ArrayList<String>(parents.size() + 1);
            passedParents.addAll(parents);
            passedParents.add(parts[0]);

            try {
                mapping.get().getCallable().call(source, parts.length > 1 ? parts[1] : "", Collections.unmodifiableList(passedParents));
            } catch (CommandException c) {
                throw c;
            } catch (Throwable t) {
                throw new InvocationCommandException(t);
            }
            return true;
        }
        else {
            if (this.enableNotFoundMessages) {
                boolean useSimple = true;
                if (alias.contains(":") && alias.indexOf(":") != 0 && (alias.length() - 1) > 0) {
                    String prefix = alias.substring(0, alias.indexOf(":") - 1);
                    String realAlias = alias.substring(alias.indexOf(":") + 1);
                    String rName = prefix;
                    outer: for (CommandRegistrar registrar : this.getRegistrars()) {
                        for (String p : registrar.getPrefixes()) {
                            if (prefix.equalsIgnoreCase(p)) {
                                rName = registrar.getFriendlyName();
                                break outer;
                            }
                        }
                    }

                    List<CommandRegistrar> potentialRegistrars = new ArrayList<CommandRegistrar>();

                    for (CommandMapping m : this.getAll(realAlias)) {
                        potentialRegistrars.add(this.commands.get(m));
                    }

                    if (potentialRegistrars.size() > 0) {
                        useSimple = false;
                        TextBuilder builder =
                                Texts.builder("Command /" + realAlias + " was not found in " + rName + ". Did you mean any of the following:\n");
                        builder.color(TextColors.RED);
                        TextBuilder builder2;
                        int index = 0;
                        for (CommandRegistrar r : potentialRegistrars) {
                            builder2 = Texts.builder("/" + r.getRegistrarName() + ":" + realAlias);
                            builder2.color(TextColors.GOLD);
                            Text cmd = builder2.build();
                            builder2 =
                                    Texts.builder((index != potentialRegistrars.size() - 1 ? ", " : "?")
                                            + (index == potentialRegistrars.size() - 2 ? " or " : ""));
                            builder2.color(TextColors.RED);
                            Text seperator = builder2.build();
                            builder.append(cmd, seperator);
                            ++index;
                        }
                        Text msg = builder.build();
                        source.sendMessage(msg);
                    }
                }
                if (useSimple) {
                    TextBuilder builder = Texts.builder("Command /" + alias + "not found.");
                    builder.color(TextColors.RED);
                    source.sendMessage(builder.build());
                }
            }

        }
        return false;
    }

    @Override
    public synchronized boolean testPermission(CommandSource source) {
        for (CommandMapping mapping : this.commands.keySet()) {
            if (!mapping.getCallable().testPermission(source)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String getShortDescription(CommandSource source) {
        return shortDescription;
    }

    @Override
    public Text getHelp(CommandSource source) {
        return help;
    }

    @Override
    public String getUsage(CommandSource source) {
        return usage;
    }

    @Override
    public List<String> getSuggestions(CommandSource source, String arguments) throws CommandException {
        String[] parts = arguments.split(" +", 2);
        List<String> suggestions = new ArrayList<String>();

        if (parts.length == 1) { // Auto completing commands
            String incompleteCommand = parts[0].toLowerCase();

            synchronized (this) {
                for (CommandMapping mapping : this.commands.keySet()) {
                    for (String alias : mapping.getAllAliases()) {
                        if (alias.toLowerCase().startsWith(incompleteCommand)) {
                            suggestions.add(alias);
                        }
                    }
                }
            }
        } else { // Complete using subcommand
            Optional<CommandMapping> mapping = resolveMapping(parts[0], source);

            if (mapping.isPresent()) {
                suggestions.addAll(mapping.get().getCallable().getSuggestions(source, parts.length > 1 ? parts[1] : ""));
            }
        }

        return Collections.unmodifiableList(suggestions);
    }

    @Override
    public synchronized Set<CommandMapping> getCommands() {
        return Collections.unmodifiableSet(this.commands.keySet());
    }

    @Override
    public synchronized Set<String> getPrimaryAliases() {
        Set<String> aliases = new HashSet<String>();
        for (CommandMapping m : this.commands.keySet()) {
            aliases.add(m.getPrimaryAlias());
        }
        return aliases;
    }

    @Override
    public synchronized Set<String> getAliases() {
        Set<String> aliases = new HashSet<String>();
        for (CommandMapping m : this.commands.keySet()) {
            aliases.addAll(m.getAllAliases());
        }
        return aliases;
    }

    @Override
    public synchronized Set<? extends CommandMapping> getAll(String alias) {
        return this.getAll(alias, false);
    }

    /**
     * Gets all {@link CommandMapping}s attached to an alias.
     *
     * @param alias The alias to search for
     * @param primaryOnly If only primary aliases should be considered
     * @return All {@link CommandMapping}s attached to an alias
     */
    public synchronized Set<CommandMapping> getAll(String alias, boolean primaryOnly) {
        Set<CommandMapping> mappings = new HashSet<CommandMapping>();
        for (CommandMapping m : this.commands.keySet()) {
            if (primaryOnly) {
                if (m.getPrimaryAlias().equals(alias)) {
                    mappings.add(m);
                }
            }
            else {
                if (m.getAllAliases().contains(alias)) {
                    mappings.add(m);
                }
            }
        }
        return mappings;
    }

    @Override
    public Optional<CommandMapping> resolveMapping(String alias, CommandSource source) {

        checkNotNull(alias);
        checkNotNull(source);

        alias = alias.toLowerCase();
        Optional<CommandRegistrar> registrar = Optional.absent();
        String realAlias = alias;
        if (alias.contains(":") && alias.indexOf(":") != 0 && (alias.length() - 1) > 0) {
            realAlias = alias.substring(alias.indexOf(":") + 1);
            String prefix = alias.substring(0, alias.indexOf(":") - 1);
            for (CommandRegistrar r : this.getRegistrars()) {
                Set<String> prefixes = new HashSet<String>(r.getPrefixes());
                prefixes.add(r.getRegistrarName());
                for (String p : prefixes) {
                    if (p.equalsIgnoreCase(prefix)) {
                        registrar = Optional.of(r);
                    }
                }
            }
        }
        else {
            Optional<AliasContext> context = Optional.fromNullable(this.contexts.get(alias));
            if (context.isPresent()) {
                registrar = context.get().getRegistrar(realAlias, source, this.getRegistrars());
            }
        }

        final String finalAlias = realAlias;
        Comparator<CommandMapping> sorter = new Comparator<CommandMapping>() {

            @Override
            public int compare(CommandMapping m1, CommandMapping m2) {
                boolean p1 = m1.getPrimaryAlias().equalsIgnoreCase(finalAlias);
                boolean p2 = m2.getPrimaryAlias().equalsIgnoreCase(finalAlias);
                if (p1 && p2 || !p1 && !p2) {
                    return 0;
                }
                else if (p1 && !p2) {
                    return -1;
                }
                else {
                    return 1;
                }
            }

        };

        List<CommandMapping> consideredMappings = new ArrayList<CommandMapping>(this.getAll(finalAlias));
        Collections.sort(consideredMappings, sorter);
        for (CommandMapping mapping : consideredMappings) {
            if (registrar.isPresent()) {
                if (registrar.isPresent() && this.commands.get(mapping) == registrar.get()) {
                    return Optional.of(mapping);
                }
            }
            else {
                return Optional.of(mapping);
            }
        }
        return Optional.absent();
    }

    @Override
    public boolean containsAlias(String alias) {
        alias = alias.toLowerCase();
        for (CommandMapping mapping : this.commands.keySet()) {
            if (mapping.getAllAliases().contains(alias)) {
                return true;
            }
        }
        return false;
    }

    public void setAliasContext(String alias, AliasContext context) {
        this.contexts.put(alias, context);
    }

    public Optional<AliasContext> getAliasContext(String alias) {
        return Optional.fromNullable(this.contexts.get(alias));
    }

}
