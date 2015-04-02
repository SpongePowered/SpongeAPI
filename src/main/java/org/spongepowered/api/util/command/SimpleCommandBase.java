package org.spongepowered.api.util.command;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collections;
import java.util.List;

import org.spongepowered.api.text.Text;

/**
 * An abstract base class that can be extended to easily create simple commands.
 */
public abstract class SimpleCommandBase implements CommandCallable {

    private final String permission;
    private final String shortDescription;
    private final Text help;
    private final String usage;

    /**
     * Creates a new command.
     *
     * @param permission The permission needed to execute the command
     * @param shortDescription A command description
     * @param help A formatted help message
     * @param usage A description of the command arguments
     */
    public SimpleCommandBase(String permission, String shortDescription, Text help, String usage) {
        checkNotNull(permission);
        checkNotNull(shortDescription);
        checkNotNull(help);
        checkNotNull(usage);

        this.permission = permission;
        this.shortDescription = shortDescription;
        this.help = help;
        this.usage = usage;
    }

    @Override
    public boolean testPermission(CommandSource source) {
        return source.hasPermission(this.permission);
    }

    @Override
    public String getShortDescription(CommandSource source) {
        return this.shortDescription;
    }

    @Override
    public Text getHelp(CommandSource source) {
        return this.help;
    }

    @Override
    public String getUsage(CommandSource source) {
        return this.usage;
    }

    @Override
    public List<String> getSuggestions(CommandSource source, String arguments) throws CommandException {
        return Collections.<String>emptyList();
    }
    
}
