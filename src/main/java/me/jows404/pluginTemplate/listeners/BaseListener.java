package me.jows404.pluginTemplate.listeners;

import me.jows404.pluginTemplate.TemplatePlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class BaseListener implements Listener {

    // final : set exactly one and never change
    private final TemplatePlugin plugin;

    public BaseListener(TemplatePlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();


    }

}
