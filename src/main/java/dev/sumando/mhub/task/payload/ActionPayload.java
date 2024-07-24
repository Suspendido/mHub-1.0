package dev.sumando.mhub.task.payload;

import dev.sumando.mhub.utility.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ActionPayload extends BukkitRunnable {

    public boolean toggle = true;

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (toggle) {
                Util.sendActionBar(player, Util.translate("&fThere is currently &6&l25% OFF SALE &fat our store")); // MESSAGE THE ACTION BAR
            } else {
                Util.sendActionBar(player, Util.translate("&fJoin our &6dsc.gg/premade &ffor updates and more")); // MESSAGE THE ACTION BAR
            }

            toggle = !toggle;
        }
    }
}
