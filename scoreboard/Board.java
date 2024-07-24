package dev.sumando.mhub.adapters.board;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.DisplaySlot;
import java.util.ArrayList;
import java.util.List;

public class Board extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PrefixChangeListener(this), this);
    }

    public String getTitle(Player player) {
        return ChatColor.translateAlternateColorCodes('&', "&6&lmHub Network");
    }

    public List<String> getLines(Player player) {
        List<String> lines = new ArrayList<>();
        lines.add("&7&m--------------------");
        lines.add("&fOnline&7:");
        lines.add("&6" + getServer().getOnlinePlayers().size() + "&7/&65,000");
        lines.add("");
        lines.add("Rank&7: ");
        lines.add("Expires&7: &6" + getExpireTime());
        lines.add("&6&7&m--------------------");
        lines.add("&7&omhub.xyz");
        return lines;
    }

    private String getExpireTime() {
        return "Never";
    }

    public void createScoreboard(Player player) {
        ScoreboardManager manager = org.bukkit.Bukkit.getScoreboardManager();
        if (manager == null) {
            getLogger().warning("ScoreboardManager is null!");
            return;
        }

        Scoreboard scoreboard = manager.getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("test", "dummy");
        objective.setDisplayName(getTitle(player)); // Establece el título aquí
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        List<String> lines = getLines(player);
        int score = lines.size();
        for (String line : lines) {
            objective.getScore(ChatColor.translateAlternateColorCodes('&', line)).setScore(score--);
        }

        player.setScoreboard(scoreboard);
    }
}
