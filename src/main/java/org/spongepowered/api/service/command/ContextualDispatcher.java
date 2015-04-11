package org.spongepowered.api.service.command;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.spongepowered.api.util.command.dispatcher.CommandMessageFormatting.debug;
import static org.spongepowered.api.util.command.dispatcher.CommandMessageFormatting.error;
import static org.spongepowered.api.util.command.dispatcher.TranslationPlaceholder._;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.TextBuilder;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandMapping;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.CommandSpec;
import org.spongepowered.api.util.command.ImmutableCommandMapping;
import org.spongepowered.api.util.command.args.ArgumentParseException;
import org.spongepowered.api.util.command.dispatcher.Dispatcher;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContextualDispatcher implements Dispatcher {

    private Map<CommandMapping, PluginContainer> commands = Maps.newHashMap();
    private Map<String, AliasContext> contexts = Maps.newHashMap();

    public CommandMapping register(CommandSpec spec, PluginContainer container, String... aliases) {
        checkNotNull(aliases, "aliases");
        return this.register(spec, container, Arrays.asList(aliases));
    }

    public synchronized CommandMapping register(CommandSpec spec, PluginContainer container, List<String> aliases) {
        checkNotNull(aliases, "aliases");
        checkNotNull(spec, "spec");
        checkNotNull(container, "container");

        String primary = aliases.get(0);
        List<String> secondary = aliases.subList(1, aliases.size());

        CommandMapping mapping = new ImmutableCommandMapping(spec, primary, secondary);

        commands.put(mapping, container);

        return mapping;
    }

    public synchronized Optional<CommandMapping> removeMapping(CommandMapping mapping) {
        if (this.containsMapping(mapping)) {
            this.commands.remove(mapping);
            return Optional.of(mapping);
        }
        return Optional.absent();
    }

    @Override
    public synchronized Set<CommandMapping> getCommands() {
        return new HashSet<CommandMapping>(commands.keySet());
    }

    @Override
    public synchronized Set<String> getPrimaryAliases() {
        Set<String> primaryAliases = Sets.newHashSet();
        for (CommandMapping mapping : this.getCommands()) {
            primaryAliases.add(mapping.getPrimaryAlias());
        }
        return primaryAliases;
    }

    @Override
    public synchronized Set<String> getAliases() {
        Set<String> aliases = Sets.newHashSet();
        for (CommandMapping mapping : this.getCommands()) {
            aliases.addAll(mapping.getAllAliases());
        }
        return aliases;
    }

    @Override
    public synchronized Optional<CommandMapping> getFirst(String alias) {
        Set<CommandMapping> mappings = this.getAll(alias);
        if (mappings.size() > 0) {
            return Optional.of(mappings.iterator().next());
        }
        return Optional.absent();
    }

    @Override
    public synchronized Set<CommandMapping> getAll(String alias) {
        Set<CommandMapping> mappings = Sets.newHashSet();
        for (CommandMapping mapping : this.getCommands()) {
            if (mapping.getAllAliases().contains(alias)) {
                mappings.add(mapping);
            }
        }
        return mappings;
    }

    @Override
    public synchronized boolean containsAlias(String alias) {
        return this.getFirst(alias).isPresent();
    }

    @Override
    public boolean containsMapping(CommandMapping mapping) {
        return this.getCommands().contains(mapping);
    }

    @Override
    public Optional<CommandResult> process(CommandSource source, String arguments) {
        final String[] argSplit = arguments.split(" ", 2);
        final String alias = argSplit[0].toLowerCase();
        Optional<CommandMapping> mapping = this.resolveMapping(alias, source);
        if (mapping.isPresent()) {
            try {
                return Optional.of(mapping.get().getSpec().process(source, argSplit[1]));
            } catch (CommandException e) {
                if (e.getText() != null) {
                    source.sendMessage(error(e.getText()));
                }
            } catch (Throwable t) {
                source.sendMessage(error(_("Error occurred while executing command: %s", String.valueOf(t.getMessage()))));
                t.printStackTrace();
            }
        }
        else{
            String prefix = "";
            String command = alias;
            if (alias.contains(":") && alias.length() - 1 > alias.indexOf(":") && alias.indexOf(":") != 0) {
                prefix = alias.substring(0, alias.indexOf(":") - 1).toLowerCase();
                command = alias.substring(alias.indexOf(":") + 1);
            }
            
            if(!this.containsAlias(alias)){
                source.sendMessage(error(_("Command not found: %s", command)));
                return Optional.absent();
            }
            
            if (prefix != "") {
                PluginContainer container = null;
                for (PluginContainer c : this.commands.values()) {
                    Set<String> prefixes = new HashSet<String>(c.getCommandPrefixes());
                    prefixes.add(c.getId());
                    Set<String> realPrefixes = Sets.newHashSet();
                    for (String s : prefixes) {
                        realPrefixes.add(s.toLowerCase());
                    }
                    if (realPrefixes.contains(prefix)) {
                        container = c;
                    }
                }

                boolean found = (container != null);
                if (!found) {
                    for (CommandMapping m : this.commands.keySet()) {
                        if (this.commands.get(m) == container) {
                            found = true;
                        }
                    }
                }

                if (!found) {
                    Set<PluginContainer> containers = Sets.newHashSet();

                    for (CommandMapping m : this.getAll(command)) {
                        PluginContainer c = this.commands.get(m);
                        Set<String> prefixes = new HashSet<String>(c.getCommandPrefixes());
                        prefixes.add(c.getId());
                        if (prefixes.contains(prefix)) {
                            containers.add(c);
                        }
                    }

                    TextBuilder masterBuilder =
                            Texts.builder(
                                    "Command " + command + " was not found in " + container.getName() + ". Did you mean any of the following:\n")
                                    .color(TextColors.RED);
                    int i = 0;
                    for(PluginContainer c : containers){
                        Set<String> prefixes = new HashSet<String>(c.getCommandPrefixes());
                        prefixes.add(c.getId());

                        TextBuilder builder = Texts.builder(" /" + prefixes.iterator().next() + ":" + command).color(TextColors.GOLD);
                        masterBuilder.append(builder.build());
                        String seperator = i != (containers.size() - 1) ? "," : "?";
                        if (i == containers.size() - 2) {
                            seperator = ", or";
                        }
                        builder = Texts.builder(seperator).color(TextColors.RED);
                        masterBuilder.append(builder.build());
                        i++;
                    }

                    source.sendMessage(masterBuilder.build());

                }
            }
        }
        return Optional.absent();
    }

    @Override
    public List<String> complete(CommandSource source, String arguments) {
        final String[] argSplit = arguments.split(" ", 2);
        final String alias = argSplit[0];
        Optional<CommandMapping> mapping = this.resolveMapping(alias, source);
        if (!mapping.isPresent() || argSplit.length == 1) {
            List<String> completions = Lists.newArrayList();
            for (CommandMapping m : this.getCommands()) {
                try {
                    m.getSpec().checkPermission(source);
                } catch (CommandException e) {
                    continue;
                }
                for (String a : m.getAllAliases()) {
                    if (a.startsWith(alias)) {
                        completions.add(a);
                    }
                }
            }
        }

        try {
            mapping.get().getSpec().checkPermission(source);
        } catch (CommandException ex) {
            return Collections.emptyList();
        }
        try {
            return mapping.get().getSpec().complete(source, argSplit[1]);
        } catch (ArgumentParseException e) {
            source.sendMessage(debug(e.getText()));
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<CommandMapping> resolveMapping(String alias, CommandSource source) {
        PluginContainer plugin = null;
        String prefix = null;
        
        if (alias.contains(":") && alias.length() - 1 > alias.indexOf(":") && alias.indexOf(":") != 0) {
            prefix = alias.substring(0, alias.indexOf(":") - 1).toLowerCase();
            alias = alias.substring(alias.indexOf(":") + 1).toLowerCase();
        }
        else if(this.contexts.containsKey(alias.toLowerCase())){
            AliasContext context = this.contexts.get(alias.toLowerCase());
            if(context.getPluginId(source).isPresent()){
                prefix = context.getPluginId(source).get();
            }
        }
        
        if(prefix != null){
            for (PluginContainer p : this.commands.values()) {
                Set<String> prefixes = new HashSet<String>(p.getCommandPrefixes());
                prefixes.add(p.getId());
                if (prefixes.contains(prefix)) {
                    plugin = p;
                    break;
                }
            }
        }
        
        for(CommandMapping m : commands.keySet()){
            if (m.getAllAliases().contains(alias)) {
                if (plugin != null) {
                    if (commands.get(m) == plugin) {
                        return Optional.of(m);
                    }
                }
                else {
                    return Optional.of(m);
                }
            }
        }

        return Optional.absent();
    }

    public synchronized int size() {
        return this.commands.keySet().size();
    }

    public void setContext(String alias, AliasContext context) {
        contexts.put(alias.toLowerCase(), context);
    }

}
