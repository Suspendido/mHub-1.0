package dev.sumando.mhub.listeners;

import dev.sumando.mhub.hotbar.HotbarHandler;
import dev.sumando.mhub.menus.types.SelectorMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class MenuListener implements Listener {

    private final Map<Player, ItemStack[]> storedInv = new HashMap<>();

    @EventHandler
    public void onOpen(InventoryOpenEvent event) {
        Player player = (Player) event.getPlayer();
        Inventory inventory = event.getInventory();

        if (inventory.getHolder() instanceof SelectorMenu) {
            storedInv.put(player, player.getInventory().getContents());

            player.getInventory().clear();

            player.getInventory().remove(HotbarHandler.enderpearl);
            player.getInventory().remove(HotbarHandler.selector);
            player.getInventory().remove(HotbarHandler.viewPlayer);
            player.getInventory().remove(HotbarHandler.offPlayer);

            if (player.getInventory().getSize() > 22) {
                player.getInventory().setItem(20, HotbarHandler.hub);
                player.getInventory().setItem(22, HotbarHandler.hub2);
            }
            player.updateInventory();
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        Inventory inventory = event.getInventory();

        player.getInventory().clear();

        if (inventory.getHolder() instanceof SelectorMenu) {
            ItemStack[] storedItems = storedInv.get(player);
            if (storedItems != null) {
                player.getInventory().setContents(storedItems);
                storedInv.remove(player);
            }

            player.getInventory().removeItem(HotbarHandler.hub);
            player.getInventory().removeItem(HotbarHandler.hub2);

            HotbarHandler.onGiveItems(player);
            player.updateInventory();
        } else {
            player.getInventory().removeItem(HotbarHandler.hub);
            player.getInventory().removeItem(HotbarHandler.hub2);
            HotbarHandler.onGiveItems(player);
            player.updateInventory();
        }

    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        event.setCancelled(true);

        Inventory inventory = event.getInventory();
        if (inventory == null) return;
        ItemStack click = event.getCurrentItem();
        if (click == null || click.getType() == Material.AIR) return;
        Material itemType = click.getType();

        if (itemType.equals(Material.DIAMOND_SWORD)) { // HCF
            event.getWhoClicked().closeInventory();
            Player player = (Player) event.getWhoClicked();

            player.getInventory().removeItem(HotbarHandler.hub);
            player.getInventory().removeItem(HotbarHandler.hub2);
            player.chat("/play hcf");
            HotbarHandler.onGiveItems(player);

            player.updateInventory();
        } else if (itemType.equals(Material.IRON_SWORD)) { // KitMap
            event.getWhoClicked().closeInventory();
            Player player = (Player) event.getWhoClicked();

            player.getInventory().removeItem(HotbarHandler.hub);
            player.getInventory().removeItem(HotbarHandler.hub2);
            player.chat("/play kitmap");
            HotbarHandler.onGiveItems(player);

            player.updateInventory();
        } else if (itemType.equals(Material.DIAMOND_AXE)) { // PRACTICE
            event.getWhoClicked().closeInventory();
            Player player = (Player) event.getWhoClicked();

            player.getInventory().removeItem(HotbarHandler.hub);
            player.getInventory().removeItem(HotbarHandler.hub2);
            player.chat("/play practice");
            HotbarHandler.onGiveItems(player);

            player.updateInventory();
        }
    }
}
