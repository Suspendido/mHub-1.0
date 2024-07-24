package dev.sumando.mhub.menus;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public abstract class MenuCreator {

    private final int size;
    private final String title;
    @Getter
    private final Inventory inventory;

    public MenuCreator(int size, String title) {
        this.size = size;
        this.title = title;
        this.inventory = Bukkit.createInventory(null, size, title);
    }

    public abstract void createMenu(Inventory inventory, Player player);

}
