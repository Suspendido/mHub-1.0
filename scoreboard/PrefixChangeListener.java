package dev.sumando.mhub.adapters.board;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PrefixChangeListener implements Listener {

    private final Board plugin;

    public PrefixChangeListener(Board plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        plugin.createScoreboard(player);
    }
}

