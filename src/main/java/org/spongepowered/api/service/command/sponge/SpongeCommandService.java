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

import com.google.common.base.Function;
import com.google.common.base.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.api.event.message.CommandEvent;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.plugin.PluginManager;
import org.spongepowered.api.service.command.CommandService;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.CommandCallable;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandMapping;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.event.Order;
import org.spongepowered.api.util.event.Subscribe;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class SpongeCommandService implements CommandService {

    private final SpongeDispatcher dispatcher;
    private final PluginManager manager;

    private static final Logger log = LoggerFactory.getLogger(SpongeCommandService.class);

    public SpongeCommandService(PluginManager manager, boolean enableNotFoundMessages, String shortDescription, Text help, String usage) {
        this.dispatcher = new SpongeDispatcher(enableNotFoundMessages, shortDescription, help, usage);
        this.manager = manager;
    }

    public SpongeCommandService(PluginManager manager, boolean enableNotFoundMessages) {
        this(manager, enableNotFoundMessages, "", Texts.of(), "");
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
    public Set<CommandMapping> getCommands() {
        return this.dispatcher.getCommands();
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
    public Set<? extends CommandMapping> getAll(String alias) {
        return this.dispatcher.getAll(alias);
    }

    @Override
    public Optional<? extends CommandMapping> resolveMapping(String alias, CommandSource source) {
        return this.dispatcher.resolveMapping(alias, source);
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
        return true;
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
    public List<String> getSuggestions(CommandSource source, String arguments) throws CommandException {
        return this.getSuggestions(source, arguments);
    }

    @Override
    public Optional<CommandMapping> register(Object registrar, CommandCallable callable, String... aliases) throws IllegalArgumentException {
        return this.register(registrar, callable, aliases);
    }

    @Override
    public Optional<CommandMapping> register(Object registrar, CommandCallable callable, List<String> aliases,
            Function<List<String>, List<String>> callback) throws IllegalArgumentException {
        return this.register(registrar, callable, aliases);
    }

    @Override
    public Optional<CommandMapping> register(Object registrar, CommandCallable callable, List<String> aliases) throws IllegalArgumentException {
        CommandRegistrar realRegistrar = null;
        if (registrar instanceof CommandRegistrar) {
            realRegistrar = (CommandRegistrar) registrar;
        }
        else {
            Optional<PluginContainer> plugin = this.manager.fromInstance(registrar);
            if (plugin.isPresent()) {
                realRegistrar = plugin.get();
            }
        }
        if (realRegistrar == null) {
            throw new IllegalArgumentException("The provided registrar object is neither a CommandRegistrar or an instance of a plugin!");
        }
        return Optional.of(this.dispatcher.register(callable, realRegistrar, aliases));
    }

    @Override
    public Optional<CommandMapping> removeMapping(CommandMapping mapping) {
        return this.dispatcher.removeMapping(mapping);
    }

    @Override
    public Set<CommandRegistrar> getCommandRegistrars() {
        return this.dispatcher.getRegistrars();
    }

    @Override
    public Set<CommandMapping> getOwnedBy(CommandRegistrar registrar) {
        return this.dispatcher.getOwnedBy(registrar);
    }

    @Override
    public int size() {
        return this.dispatcher.size();
    }

    public void setAliasContext(String alias, AliasContext context) {
        this.dispatcher.setAliasContext(alias, context);
    }

    public Optional<AliasContext> getAliasContext(String alias) {
        return this.dispatcher.getAliasContext(alias);
    }

}
