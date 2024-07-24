package dev.sumando.mhub.listeners;

import dev.sumando.mhub.hotbar.HotbarHandler;
import dev.sumando.mhub.utility.Util;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(null);

        player.sendMessage(Util.translate(""));
        player.sendMessage(Util.translate("&fYou have been connected to our &5&lHub server."));
        player.sendMessage(Util.translate("&fTo navigate through servers please use &5Server Selector&f."));
        player.sendMessage(Util.translate(""));

        player.getInventory().clear();
        HotbarHandler.onGiveItems(player);
    }



}
