package dev.sumando.mhub.utility;

import net.minecraft.server.v1_8_R3.ChatComponentText;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class Util {

    public static String translate(String input) {
        return ChatColor.translateAlternateColorCodes('&', input).replace("\n", "\n");
    }

    public static List<String> translate(List<String> input) {
        return input.stream().map(Util::translate).collect(Collectors.toList());
    }

    public static void log(String s) {
        Bukkit.getConsoleSender().sendMessage(translate(s));
    }

    public static String truncateLine(String line) {
        return line.length() > 30 ? line.substring(0, 30) : line;
    }

    public static void sendActionBar(Player player, String message) {
        IChatBaseComponent chatComponent = new ChatComponentText(message);
        PacketPlayOutChat packet = new PacketPlayOutChat(chatComponent, (byte) 2);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }
}