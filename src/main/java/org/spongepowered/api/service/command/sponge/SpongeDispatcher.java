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

import org.spongepowered.api.plugin.PluginManager;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.message.Message;
import org.spongepowered.api.text.message.MessageBuilder;
import org.spongepowered.api.text.message.Messages;
import org.spongepowered.api.util.command.CommandCallable;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandMapping;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.dispatcher.Dispatcher;

import com.google.common.base.Optional;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A simple implementation of a {@link Dispatcher}.
 */
public class SpongeDispatcher implements Dispatcher {

    public SpongeDispatcher(PluginManager pluginManager) {
        this.pluginManager = pluginManager;
    }

    /**
     * The map of plugins and commands.
     */
    private final Multimap<String, CommandMapping> commands = HashMultimap.create();

    /**
     * Field used to check if this is a modification of the default
     * SimpleDispatcher, to disable plugin-prefixing and command-source
     * resolution.
     */
    private final boolean isExtended = !(this.getClass() == SpongeDispatcher.class);

    /**
     * The {@link PluginManager}.
     */
    private final PluginManager pluginManager;

    /**
     * A map used for configuring certain aliases to certain plugins under
     * certain {@link CommandSource}s.
     */
    private final Map<String, AliasContext> aliasContexts = Maps.newHashMap();

    /**
     * Register a command with this Dispatcher.
     * 
     * @param command The {@link CommandCallable} representing this command.
     * @param primaryAlias The primary alias for the command.
     * @param aliases All aliases for the command.
     * @param plugin The ID of the plugin registering the command.
     * @return If present, a {@link CommandMapping} representing the command.
     */
    public Optional<CommandMapping> register(CommandCallable command, String primaryAlias, List<String> aliases, String plugin)
            throws IllegalArgumentException {

        checkNotNull(command);
        checkNotNull(primaryAlias);
        checkNotNull(aliases);
        checkNotNull(plugin);

        if (!pluginManager.isLoaded(plugin)) {
            throw new IllegalArgumentException("There is no plugin by the name of " + plugin + "!");
        }

        CommandMapping commandMapping = new SpongeCommandMapping(command, primaryAlias, plugin, aliases);
        commands.put(plugin, commandMapping);

        return Optional.of(commandMapping);
    }

    /**
     * Remove a mapping identified by the given alias.
     *
     * @param alias The alias
     * @param plugin The plugin the mapping is owned by. If this is
     *        Optional.absent(), the plugin is ignored.
     * @return The previous mapping associated with the alias, if one was found
     */
    public synchronized Optional<CommandMapping> remove(String alias, Optional<String> plugin) {
        return this.remove(alias, false, plugin);
    }

    /**
     * Remove a mapping identified by the given alias.
     *
     * @param alias The alias
     * @param primaryOnly If the search should ignore non-primary aliases.
     * @return The previous mapping associated with the alias, if one was found
     */
    public synchronized Optional<CommandMapping> remove(String alias, boolean primaryOnly) {
        return this.remove(alias, primaryOnly, Optional.<String>absent());
    }

    /**
     * Remove a mapping identified by the given alias.
     *
     * @param alias The alias
     * @return The previous mapping associated with the alias, if one was found
     */
    public synchronized Optional<CommandMapping> remove(String alias) {
        return this.remove(alias, false, Optional.<String>absent());
    }

    /**
     * Remove a mapping identified by the given alias.
     *
     * @param alias The alias
     * @param primaryOnly If the search should ignore non-primary aliases.
     * @param plugin The plugin the mapping is owned by. If this is
     *        Optional.absent(), the plugin is ignored.
     * @return The previous mapping associated with the alias, if one was found
     */
    public synchronized Optional<CommandMapping> remove(String alias, boolean primaryOnly, Optional<String> plugin) {
        checkNotNull(alias);
        Iterator<String> it = commands.keys().iterator();
        while (it.hasNext()) {
            String k = it.next();
            Iterator<CommandMapping> mappings = commands.get(k).iterator();

            while (mappings.hasNext()) {
                CommandMapping v = mappings.next();
                boolean remove = true;

                if (primaryOnly) {
                    remove = v.getPrimaryAlias().equalsIgnoreCase(alias);

                } else {
                    remove = v.getAllAliases().contains(alias);
                }
                if (plugin.isPresent()) {
                    remove = remove && (k.equalsIgnoreCase(plugin.get()));
                }
                if (remove) {
                    return this.removeMapping(v);
                }
            }
        }
        return Optional.absent();
    }

    /**
     * Remove all mappings identified by the given aliases.
     *
     * @param c A collection of aliases
     * @param plugin The plugin the mapping is owned by. If this is
     *        Optional.absent(), the plugin is ignored.
     * @return Whether any were found
     */
    public synchronized boolean removeAll(Collection<?> c, Optional<String> plugin) {
        return this.removeAll(c, false, plugin);
    }

    /**
     * Remove all mappings identified by the given aliases.
     *
     * @param c A collection of aliases
     * @param primaryOnly If the search should ignore non-primary aliases.
     * @return Whether any were found
     */
    public synchronized boolean removeAll(Collection<?> c, boolean primaryOnly) {
        return this.removeAll(c, primaryOnly, Optional.<String>absent());
    }

    /**
     * Remove all mappings identified by the given aliases.
     *
     * @param c A collection of aliases
     * @return Whether any were found
     */
    public synchronized boolean removeAll(Collection<?> c) {
        return this.removeAll(c, false, Optional.<String>absent());
    }

    /**
     * Remove all mappings identified by the given aliases.
     *
     * @param c A collection of aliases
     * @param primaryOnly If the search should ignore non-primary aliases.
     * @param plugin The plugin the mapping is owned by. If this is
     *        Optional.absent(), the plugin is ignored.
     * @return Whether any were found
     */
    public synchronized boolean removeAll(Collection<?> c, boolean primaryOnly, Optional<String> plugin) {
        checkNotNull(c);

        boolean found = false;

        for (Object alias : c) {
            if (this.remove((String) alias, primaryOnly, plugin).isPresent()) {
                found = true;
            }
        }

        return found;
    }

    /**
     * Remove a command identified by the given mapping.
     *
     * @param mapping The mapping
     * @return The previous mapping associated with the alias, if one was found
     */
    public synchronized Optional<CommandMapping> removeMapping(CommandMapping mapping) {
        checkNotNull(mapping);

        CommandMapping found = null;

        Iterator<CommandMapping> it = commands.values().iterator();
        while (it.hasNext()) {
            CommandMapping current = it.next();
            if (current.equals(mapping)) {
                it.remove();
                found = current;
            }
        }

        return Optional.fromNullable(found);
    }

    /**
     * Remove all mappings contained with the given collection.
     *
     * @param c The collection
     * @return Whether the at least one command was removed
     */
    public synchronized boolean removeMappings(Collection<?> c) {
        checkNotNull(c);

        boolean found = false;

        Iterator<CommandMapping> it = commands.values().iterator();
        while (it.hasNext()) {
            if (c.contains(it.next())) {
                it.remove();
                found = true;
            }
        }

        return found;
    }

    /**
     * Gets a list of all registered {@link CommandMapping}s.
     * 
     * @return A list of all registered {@link CommandMapping}s.
     */
    @Override
    public synchronized Set<CommandMapping> getCommands() {
        return ImmutableSet.copyOf(commands.values());
    }

    /**
     * Gets a list of all registered primary aliases.
     * 
     * @return A list of all registered primary aliases.
     */
    @Override
    public synchronized Map<String, Integer> getPrimaryAliases() {
        Map<String, Integer> aliases = new HashMap<String, Integer>();

        for (CommandMapping mapping : commands.values()) {
            if (aliases.containsKey(mapping.getPrimaryAlias())) {
                aliases.put(mapping.getPrimaryAlias(), aliases.get(mapping.getPrimaryAlias()) + 1);

            } else {
                aliases.put(mapping.getPrimaryAlias(), 1);
            }
        }

        return Collections.unmodifiableMap(aliases);
    }

    /**
     * Gets a list of all registered aliases.
     * 
     * @return A list of all registered aliases.
     */
    @Override
    public synchronized Map<String, Integer> getAliases() {
        Map<String, Integer> aliases = new HashMap<String, Integer>();

        for (CommandMapping mapping : commands.values()) {
            for (String alias : mapping.getAllAliases()) {
                if (aliases.containsKey(alias)) {
                    aliases.put(alias, aliases.get(alias) + 1);
                } else {
                    aliases.put(alias, 1);
                }
            }
        }

        return Collections.unmodifiableMap(aliases);
    }

    /**
     * Returns all {@link CommandMapping}s that fit the search parameters.
     * 
     * @param alias The alias of the command.
     * @param plugin The plugin to search for commands in.
     * @return The command mappings that fit the search parameters. If none were
     *         found, Optional.absent().
     */
    public synchronized Set<CommandMapping> getAll(String alias, Optional<String> plugin) {
        return this.getAll(alias, false, plugin);
    }

    /**
     * Returns all {@link CommandMapping}s that fit the search parameters.
     * 
     * @param alias The alias of the command.
     * @param primaryOnly If the search should ignore non-primary aliases.
     * @return The command mappings that fit the search parameters. If none were
     *         found, Optional.absent().
     */
    public synchronized Set<CommandMapping> getAll(String alias, boolean primaryOnly) {
        return this.getAll(alias, primaryOnly, Optional.<String>absent());
    }

    @Override
    public synchronized Set<CommandMapping> getAll(String alias) {
        return this.getAll(alias, false, Optional.<String>absent());
    }

    /**
     * Returns all {@link CommandMapping}s that fit the search parameters.
     * 
     * @param alias The alias of the command.
     * @param primaryOnly If the search should ignore non-primary aliases.
     * @param plugin The plugin to search for commands in.
     * @return The command mappings that fit the search parameters. If none were
     *         found, Optional.absent().
     */
    public synchronized Set<CommandMapping> getAll(String alias, boolean primaryOnly, Optional<String> plugin) {
        Set<CommandMapping> mappings = new HashSet<CommandMapping>();
        for (String k : commands.keys()) {
            for (CommandMapping v : commands.get(k)) {
                boolean found = true;
                if (primaryOnly) {
                    found = v.getPrimaryAlias().equalsIgnoreCase(alias);

                } else {
                    found = v.getAllAliases().contains(alias);
                }

                if (plugin.isPresent()) {
                    found = found && k.equalsIgnoreCase(plugin.get());
                }
                if (found) {
                    mappings.add(v);
                }
            }
        }
        return mappings;
    }

    /**
     * Returns true if there are any registered commands that fit the search
     * parameters.
     * 
     * @param alias The command's alias.
     * @param plugin The plugin to search in.
     * @return If there are any registered commands that fit the search
     *         parameters.
     */
    public synchronized boolean containsAlias(String alias, Optional<String> plugin) {
        return this.containsAlias(alias, false, plugin);
    }

    /**
     * Returns true if there are any registered commands that fit the search
     * parameters.
     * 
     * @param alias The command's alias.
     * @param primaryOnly If the search should ignore non-primary aliases.
     * @return If there are any registered commands that fit the search
     *         parameters.
     */
    public synchronized boolean containsAlias(String alias, boolean primaryOnly) {
        return this.containsAlias(alias, primaryOnly, Optional.<String>absent());
    }

    @Override
    public synchronized boolean containsAlias(String alias) {
        return this.containsAlias(alias, false, Optional.<String>absent());
    }

    /**
     * Returns true if there are any registered commands that fit the search
     * parameters.
     * 
     * @param alias The command's alias.
     * @param primaryOnly If the search should ignore non-primary aliases.
     * @param plugin The plugin to search in.
     * @return If there are any registered commands that fit the search
     *         parameters.
     */
    public synchronized boolean containsAlias(String alias, boolean primaryOnly, Optional<String> plugin) {
        return !this.getAll(alias, primaryOnly, plugin).isEmpty();
    }

    @Override
    public boolean containsMapping(CommandMapping mapping) {
        checkNotNull(mapping);
        for (CommandMapping test : commands.values()) {
            if (mapping.equals(test)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Get the number of registered commands.
     *
     * @return The number of commands.
     */
    public synchronized int size() {
        return commands.size();
    }

    /**
     * Calls a given command.
     * 
     * @return If the command was successful.
     */
    @Override
    public boolean call(CommandSource source, String arguments, List<String> parents) throws CommandException {
        String[] parts = arguments.split(" +", 2);
        String alias = parts[0];
        Optional<CommandMapping> mapping = resolveMapping(alias, source);

        if (mapping.isPresent()) {
            List<String> passedParents = new ArrayList<String>(parents.size() + 1);
            passedParents.addAll(parents);
            passedParents.add(alias);

            mapping.get().getCallable().call(source, parts.length > 1 ? parts[1] : "", Collections.unmodifiableList(passedParents));

            return true;
        } else if (alias.contains(":") && (alias.indexOf(":") < (alias.length() - 1)) && !isExtended) {
            // TODO: Support vanilla commands in this command-suggestion system.
            Set<CommandMapping> mappings = this.getAll(alias);
            if (!mappings.isEmpty()) {
                int colonIndex = alias.indexOf(":");
                String plugin = alias.substring(0, colonIndex - 1);
                String cmdName = alias.substring(colonIndex + 1);
                String pluginName = pluginManager.getPlugin(plugin).get().getId();
                List<Message> messages = new ArrayList<Message>();
                MessageBuilder finalBuilder = Messages.builder();
                String text = pluginName + " does not contain a command called " + cmdName + ". Did you mean: ";
                int pos = 0;
                for (CommandMapping m : mappings) {
                    SpongeCommandMapping spongeMapping = (SpongeCommandMapping) m;
                    MessageBuilder builder1 = Messages.builder("/" + spongeMapping.getRegistrar() + ":" + cmdName);
                    builder1.color(TextColors.GOLD);
                    messages.add(builder1.build());
                    if (mappings.size() > 1 && (pos != mappings.size() - 1)) {
                        String msg = (pos == mappings.size() - 2) ? ", or" : ", ";
                        MessageBuilder builder2 = Messages.builder(msg);
                        builder2.color(TextColors.RED);
                        messages.add(builder2.build());
                    }
                    ++pos;
                }
                source.sendMessage(Messages.builder(text).color(TextColors.RED).build());
                source.sendMessage(finalBuilder.append(messages).build());
                return false;
            }
        }
        source.sendMessage(Messages.builder("Error: Command not found.").color(TextColors.RED).build());
        return false;
    }

    /**
     * Tests if the given source can use all the registered commands
     * 
     * @return If the given source can use all the registered commands.
     */
    @Override
    public synchronized boolean testPermission(CommandSource source) {
        for (CommandMapping mapping : commands.values()) {
            if (!mapping.getCallable().testPermission(source)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public synchronized boolean testSource(CommandSource source) {
        for (CommandMapping mapping : commands.values()) {
            if (!mapping.getCallable().testSource(source)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns suggestions for the command.
     * 
     * @return Suggestions for the command.
     */
    @Override
    public List<String> getSuggestions(CommandSource source, String arguments) throws CommandException {
        String[] parts = arguments.split(" +", 2);
        List<String> suggestions = new ArrayList<String>();

        if (parts.length == 1) { // Auto completing commands
            String incompleteCommand = parts[0].toLowerCase();

            synchronized (this) {
                for (CommandMapping mapping : commands.values()) {
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
                mapping.get().getCallable().getSuggestions(source, parts.length > 1 ? parts[1] : "");
            }
        }

        return Collections.unmodifiableList(suggestions);
    }

    @Override
    public Optional<CommandMapping> resolveMapping(String alias, CommandSource source) {
        return this.resolveMapping(alias, source);
    }

    /**
     * Resolves the alias of a command to a {@link CommandMapping} with a
     * certain {@link CommandSource}.
     * 
     * @param alias The alias of the command.
     * @param source The {@link CommandSource} the command is being sent from.
     * @param ignoreOverride If commandsource-configuration should be disabled.
     * @return A mapping for the command, if one was found. Otherwise,
     *         Optional.absent().
     */
    public Optional<CommandMapping> resolveMapping(String alias, CommandSource source, boolean ignoreOverride) {
        Optional<String> plugin = Optional.absent();
        boolean override = false;
        alias = alias.toLowerCase();
        if (!isExtended) {
            if (alias.contains(":") && alias.indexOf(":") < (alias.length() - 1)) {
                int colonIndex = alias.indexOf(":");
                plugin = Optional.of(alias.substring(0, colonIndex - 1));
                alias = alias.substring(colonIndex + 1);
            }
        }

        if (!plugin.isPresent() && this.aliasContexts.containsKey(alias) && !isExtended && !ignoreOverride) {
            AliasContext context = this.aliasContexts.get(alias);
            if (context.appliesTo(source)) {
                String contextPlugin = context.getPluginId(source);
                if (this.pluginManager.isLoaded(contextPlugin)) {
                    plugin = Optional.of(contextPlugin);
                    override = true;
                }
            }
        }

        if (this.containsAlias(alias, true, plugin)) {
            for (CommandMapping m : this.getAll(alias, true, plugin)) {
                if (m.getCallable().testSource(source)) {
                    return Optional.of(m);
                }
            }
            for (CommandMapping m : this.getAll(alias, false, plugin)) {
                if (m.getCallable().testSource(source)) {
                    return Optional.of(m);
                }
            }
        }

        if (override) {
            return this.resolveMapping(alias, source, true);
        } else {
            return Optional.absent();
        }
    }

    @Override
    public Optional<String> getShortDescription() {
        return Optional.absent();
    }

    @Override
    public Optional<String> getHelp() {
        return Optional.absent();
    }

    @Override
    public String getUsage() {
        return "<sub-command>"; // TODO: Translate
    }

    /**
     * Set a certain alias to go to certain plugins by {@link CommandSource}s.
     * 
     * @param alias The alias.
     * @param context The {@link AliasContext} to get the plugins from.
     */
    public void addAliasContext(String alias, AliasContext context) {
        aliasContexts.put(alias.toLowerCase(), context);
    }

    /**
     * Remove a certain alias from the contexts list.
     * 
     * @param alias The alias to remove.
     */
    public void removeAliasContext(String alias) {
        aliasContexts.remove(alias.toLowerCase());
    }

}
