package me.jows404.pluginTemplate.managers;

import me.jows404.pluginTemplate.TemplatePlugin;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class MessageManager {

    private final TemplatePlugin plugin;
    private FileConfiguration messages;

    public MessageManager(TemplatePlugin plugin) {
        this.plugin = plugin;
    }

    private void loadMessages() {
        File messageFile = new File(plugin.getDataFolder(), "messages.yml");

        if (!messageFile.exists()) {
            plugin.saveResource("messages.yml", false);
        }

        messages = YamlConfiguration.loadConfiguration(messageFile);
    }

    public String getMessage(String key) {
        String prefix = messages.getString("prefix", "&e[&6Plugin&8]&r");
        String message = messages.getString("messages." + key, "&cMessage not found: " + key);

        return colorize(prefix + " " + message);
    }

    public String colorize(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
