package dev.sumando.mhub.cmd;

import dev.sumando.mhub.utility.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DevCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        Player player = (Player) sender;

        player.sendMessage(Util.translate("&7&m---------------"));
        player.sendMessage(Util.translate("&6&lAuthor: &9Suspendido & lil_Toby"));
        player.sendMessage(Util.translate("&7&m---------------"));

        return true;
    }
}
