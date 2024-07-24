package dev.sumando.mhub.cmd;

import dev.sumando.mhub.utility.Util;
import lombok.Getter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class BuildCMD implements CommandExecutor {
    @Getter
    private static final HashMap<UUID, Player> players = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("hub.build")) {
                if (args.length == 0) {
                    if (!players.containsKey(player.getUniqueId())) {
                        players.put(player.getUniqueId(), player);
                        player.sendMessage(Util.translate("&aBuild Mode has been enabled"));
                    } else {
                        player.sendMessage(Util.translate("&cUse for disable buildmode /build disable"));
                    }
                } else if (args.length == 1 && args[0].equalsIgnoreCase("disable")) {
                    if (players.containsKey(player.getUniqueId())) {
                        players.remove(player.getUniqueId());
                        player.sendMessage(Util.translate("&cBuild Mode has been disabled"));
                    }
                } else {
                    player.sendMessage(Util.translate("&cUsage: /build [disable]"));
                }
            } else {
                player.sendMessage(Util.translate("&cYou do not have permission to use this command"));
            }
        }
        return true;
    }
}
