package me.jows404.pluginTemplate.commands;

import me.jows404.pluginTemplate.TemplatePlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class BaseCommand implements CommandExecutor {

    private final TemplatePlugin plugin;

    public BaseCommand(TemplatePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {

        // No arguments were given
        if (args.length == 0) {
            sendHelp(commandSender);
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "reload":
                break;
            case "help":
                sendHelp(commandSender);
                break;
        }

        return true;

    }

    private void sendHelp(CommandSender sender) {
        sender.sendMessage("§8§m----------------------------------------");
        sender.sendMessage("&6&1Template Plugin Commands:");
        sender.sendMessage("&8 - &e/template help &7 - Show this help");
        sender.sendMessage("&8 - &e/template reload &7 - Reload config");
        sender.sendMessage("§8§m----------------------------------------");
    }
}
