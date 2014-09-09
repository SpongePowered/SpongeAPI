package org.spongepowered.example;

import org.spongepowered.api.command.Command;
import org.spongepowered.api.command.CommandSender;

public class HelloWorldCommand implements Command {

    @Override
    public String getCommandName() {
        return "Hello";
    }

    @Override
    public String getCommandUsage(CommandSender sender) {
        return "Shows a message";
    }

    @Override
    public void processCommand(CommandSender sender, String[] args) {
        sender.sendRawText("World");
    }
}
