package me.jows404.pluginTemplate.managers;

import me.jows404.pluginTemplate.TemplatePlugin;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {

    private final TemplatePlugin plugin;

    public ConfigManager(TemplatePlugin plugin) {
        this.plugin = plugin;
    }

    public void loadConfig() {
        plugin.saveDefaultConfig();
        plugin.reloadConfig();

        FileConfiguration config = plugin.getConfig();

        if (!config.getBoolean("enabled")) {
            plugin.getLogger().warning("'enabled' missing in config.yml - using default (true)");
        }
    }

    public void reloadConfig() {
        plugin.reloadConfig();
        plugin.getLogger().info("Configuration reloaded!");
    }

    public boolean isEnabled() {
        return plugin.getConfig().getBoolean("enabled", true);
    }
}
