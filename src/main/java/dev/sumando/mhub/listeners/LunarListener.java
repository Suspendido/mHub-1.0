package dev.sumando.mhub.listeners;

import com.lunarclient.bukkitapi.LunarClientAPI;
import dev.sumando.mhub.mHub;
import dev.sumando.mhub.utility.Util;
import me.activated.core.plugin.AquaCoreAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.ArrayList;
import java.util.List;

public class LunarListener implements Listener {

    public void updateNameTag( Player player) {
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
            Player player2 = onlinePlayer.getPlayer();
            scheduler.scheduleSyncRepeatingTask((Plugin) mHub.getInstance(), () -> LunarClientAPI.getInstance().overrideNametag(player2, (List)this.resetNameTag(player2), player), 0L, 20L);
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        this.updateNameTag(player);
    }

    public  List<String> resetNameTag(Player player) {
        List<String> tag = new ArrayList<>();
        tag.add(Util.translate(AquaCoreAPI.INSTANCE.getPlayerRank(player.getUniqueId()).getColor().toString() + AquaCoreAPI.INSTANCE.getPlayerRank(player.getUniqueId()).getPrefix()));
        tag.add(Util.translate(player.getName()));

        return tag;
    }


}
