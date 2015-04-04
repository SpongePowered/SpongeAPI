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

package org.spongepowered.api.service.command;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Optional;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.api.event.message.CommandEvent;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.plugin.PluginManager;
import org.spongepowered.api.service.command.sponge.CommandRegistrar;
import org.spongepowered.api.service.event.EventManager;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.command.CommandCallable;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandMapping;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.dispatcher.SimpleDispatcher;
import org.spongepowered.api.util.event.Order;
import org.spongepowered.api.util.event.Subscribe;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

/**
 * A simple implementation of {@link CommandService}.
 *
 * <p>
 * Note: An instance of this class should be registered with the sponge
 * {@link EventManager} in order to receive {@link CommandEvent}s in the
 * {@link #onCommandEvent(CommandEvent)} method.
 * </p>
 */
public class SimpleCommandService implements CommandService {

    private static final Logger log = LoggerFactory.getLogger(SimpleCommandService.class);

    private final PluginManager pluginManager;
    private final SimpleDispatcher dispatcher = new SimpleDispatcher();
    private final Multimap<CommandRegistrar, CommandMapping> owners = HashMultimap.create();
    private final Object lock = new Object();

    /**
     * Construct a simple {@link CommandService}.
     *
     * @param pluginManager The plugin manager to get the
     *            {@link PluginContainer} for a given plugin
     */
    @Inject
    public SimpleCommandService(PluginManager pluginManager) {
        checkNotNull(pluginManager, "pluginManager");
        this.pluginManager = pluginManager;
    }

    /**
     * Receive {@link CommandEvent}s.
     *
     * @param event The event received
     */
    @Subscribe(order = Order.LAST)
    public void onCommandEvent(final CommandEvent event) {
        try {
            if (call(event.getSource(), event.getCommand() + " " + event.getArguments(), Collections.<String>emptyList())) {
                event.setCancelled(true);
            }
        } catch (CommandException e) {
            event.setCancelled(true);
            log.warn("Failed to execute a command", e);
        }
    }

    @Override
    public Optional<CommandMapping> register(Object registrar, CommandCallable callable, String... alias) {
        return register(registrar, callable, Arrays.asList(alias));
    }

    @Override
    public Optional<CommandMapping> register(Object registrar, CommandCallable callable, List<String> aliases) {
        return register(registrar, callable, aliases, Functions.<List<String>>identity());
    }

    @Override
    public Optional<CommandMapping> register(Object registrar, CommandCallable callable, List<String> aliases,
            Function<List<String>, List<String>> callback) {
        checkNotNull(registrar);

        CommandRegistrar realRegistrar = null;
        if (registrar instanceof CommandRegistrar) {
            realRegistrar = (CommandRegistrar) registrar;
        }
        else {
            Optional<PluginContainer> plugin = pluginManager.fromInstance(registrar);
            if (plugin.isPresent()) {
                realRegistrar = plugin.get();
            }
        }
        if (realRegistrar == null) {
            throw new IllegalArgumentException("The provided registrar object is neither a CommandRegistrar or an instance of a plugin!");
        }
        synchronized (this.lock) {

            Optional<CommandMapping> mapping = this.dispatcher.register(callable, aliases, callback);

            if (mapping.isPresent()) {
                this.owners.put(realRegistrar, mapping.get());
            }

            return mapping;
        }
    }

    public Optional<CommandMapping> remove(String alias) {
        synchronized (this.lock) {
            Optional<CommandMapping> removed = this.dispatcher.remove(alias);

            if (removed.isPresent()) {
                forgetMapping(removed.get());
            }

            return removed;
        }
    }

    @Override
    public Optional<CommandMapping> removeMapping(CommandMapping mapping) {
        synchronized (this.lock) {
            Optional<CommandMapping> removed = this.dispatcher.removeMapping(mapping);

            if (removed.isPresent()) {
                forgetMapping(removed.get());
            }

            return removed;
        }
    }

    private void forgetMapping(CommandMapping mapping) {
        Iterator<CommandMapping> it = this.owners.values().iterator();
        while (it.hasNext()) {
            if (it.next().equals(mapping)) {
                it.remove();
                break;
            }
        }
    }

    @Override
    public Set<CommandRegistrar> getCommandRegistrars() {
        synchronized (this.lock) {
            return ImmutableSet.copyOf(this.owners.keySet());
        }
    }

    @Override
    public Set<CommandMapping> getCommands() {
        return this.dispatcher.getCommands();
    }

    @Override
    public Set<CommandMapping> getOwnedBy(CommandRegistrar registrar) {
        synchronized (this.lock) {
            return ImmutableSet.copyOf(this.owners.get(registrar));
        }
    }

    @Override
    public Set<String> getPrimaryAliases() {
        return this.dispatcher.getPrimaryAliases();
    }

    @Override
    public Set<String> getAliases() {
        return this.dispatcher.getAliases();
    }

    @Override
    public Set<CommandMapping> getAll(String alias) {
        return this.dispatcher.getAll(alias);
    }

    @Override
    public boolean containsAlias(String alias) {
        return this.dispatcher.containsAlias(alias);
    }

    @Override
    public boolean containsMapping(CommandMapping mapping) {
        return this.dispatcher.containsMapping(mapping);
    }

    @Override
    public boolean call(CommandSource source, String arguments, List<String> parents) throws CommandException {
        return this.dispatcher.call(source, arguments, parents);
    }

    @Override
    public boolean testPermission(CommandSource source) {
        return this.dispatcher.testPermission(source);
    }

    @Override
    public List<String> getSuggestions(CommandSource source, String arguments) throws CommandException {
        return this.dispatcher.getSuggestions(source, arguments);
    }

    @Override
    public String getShortDescription(CommandSource source) {
        return this.dispatcher.getShortDescription(source);
    }

    @Override
    public Text getHelp(CommandSource source) {
        return this.dispatcher.getHelp(source);
    }

    @Override
    public String getUsage(CommandSource source) {
        return this.dispatcher.getUsage(source);
    }

    @Override
    public int size() {
        return this.dispatcher.size();
    }

    @Override
    public Optional<? extends CommandMapping> resolveMapping(String alias, CommandSource source) {
        return this.dispatcher.resolveMapping(alias, source);
    }

}
