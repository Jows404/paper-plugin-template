package me.jows404.pluginTemplate;

import me.jows404.pluginTemplate.commands.BaseCommand;
import me.jows404.pluginTemplate.listeners.BaseListener;
import me.jows404.pluginTemplate.managers.ConfigManager;
import me.jows404.pluginTemplate.managers.MessageManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class TemplatePlugin extends JavaPlugin {

    // Singleton Pattern
    // One copy shared across entire JVM
    private static TemplatePlugin instance;
    private ConfigManager configManager;
    private MessageManager messageManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        // Initialize managers
        configManager = new ConfigManager(this);
        configManager.loadConfig();

        messageManager = new MessageManager(this);

        // Register listeners
        getServer().getPluginManager().registerEvents(new BaseListener(this), this);

        // Register commands
        getCommand("template").setExecutor(new BaseCommand(this));

        getLogger().info("TemplatePlugin has been enabled!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static TemplatePlugin getInstance() {
        return instance;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public MessageManager getMessageManager() {
        return messageManager;
    }
}
