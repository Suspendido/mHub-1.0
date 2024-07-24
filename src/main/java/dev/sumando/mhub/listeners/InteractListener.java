package dev.sumando.mhub.listeners;

import dev.sumando.mhub.hotbar.HotbarHandler;
import dev.sumando.mhub.menus.types.SelectorMenu;
import dev.sumando.mhub.utility.Util;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.Objects;

public class InteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack item = event.getItem();

        if (action == Action.RIGHT_CLICK_BLOCK || action == Action.RIGHT_CLICK_AIR) {
            if (item == null) return;

            if (item.equals(HotbarHandler.selector)) {
                handleSelector(player);
            } else if (item.equals(HotbarHandler.viewPlayer)) {
                togglePlayerVisibility(player, false);
            } else if (item.equals(HotbarHandler.offPlayer)) {
                togglePlayerVisibility(player, true);
            } else if (item.equals(HotbarHandler.enderpearl)) {
                handleEnderpearl(player, event);
            }
        }
    }

    private void handleSelector(Player player) {
        SelectorMenu selectorMenu = new SelectorMenu(9, Util.translate("&5Selector Menu"));
        selectorMenu.createMenu(selectorMenu.getInventory(), player);

        player.openInventory(selectorMenu.getInventory());
        player.getInventory().setItem(20, HotbarHandler.hub);
        player.getInventory().setItem(22, HotbarHandler.hub2);

        player.updateInventory();
        player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
    }

    private void togglePlayerVisibility(Player player, boolean show) {
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (show) {
                player.showPlayer(onlinePlayer);
            } else {
                player.hidePlayer(onlinePlayer);
            }
        }

        if (show) {
            player.getInventory().setItemInHand(HotbarHandler.viewPlayer);
        } else {
            player.getInventory().setItemInHand(HotbarHandler.offPlayer);
        }

        player.updateInventory();
    }

    private void handleEnderpearl(Player player, PlayerInteractEvent event) {
        Vector direction = player.getLocation().getDirection().normalize().multiply(1.5F);

        event.setCancelled(true);

        player.getInventory().setItem(3, HotbarHandler.enderpearl);
        player.setVelocity(direction);
        player.updateInventory();
        player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0F, 1.0F);
    }
}

