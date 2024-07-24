package dev.sumando.mhub.hotbar;

import dev.sumando.mhub.utility.ItemBuilder;
import dev.sumando.mhub.utility.Util;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;

public class HotbarHandler {

    public static void onGiveItems(Player player) {
        player.getInventory().setItem(3, enderpearl);
        player.getInventory().setItem(4, selector);
        player.getInventory().setItem(5, viewPlayer);
    }


    public static ItemStack enderpearl = new ItemBuilder(Material.ENDER_PEARL)
            .name(Util.translate("&5&lEnderpearl"))
            .setQuantity(64)
            .setLore(Collections.singletonList(Util.translate("&7Right click to use")))
            .build();

    public static ItemStack selector = new ItemBuilder(Material.NETHER_STAR)
            .name(Util.translate("&5&lServer Selector"))
            .setLore(Collections.singletonList(Util.translate("&7Right click to use")))
            .build();

    public static ItemStack viewPlayer = new ItemBuilder(Material.getMaterial(351), 1, (short) 10)
            .name(Util.translate("&a&lPlayers Visible"))
            .setLore(Collections.singletonList(Util.translate("&7Right click to hide players")))
            .build();

    public static ItemStack offPlayer = new ItemBuilder(Material.getMaterial(351), 1, (short) 8)
            .name(Util.translate("&5&lPlayers Hidden"))
            .setLore(Collections.singletonList(Util.translate("&7Right click to show players")))
            .build();

    public static ItemStack hub = new ItemBuilder(Material.BEACON)
            .name(Util.translate("&5&lHub-1"))
            .setLore(Collections.singletonList(Util.translate("&7Right click to use")))
            .build();

    public static ItemStack hub2 = new ItemBuilder(Material.BEACON)
            .name(Util.translate("&5&lHub-2"))
            .setLore(Collections.singletonList(Util.translate("&7Right click to use")))
            .build();




}
