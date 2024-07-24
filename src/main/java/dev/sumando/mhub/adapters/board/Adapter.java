package dev.sumando.mhub.adapters.board;

import dev.sumando.mhub.utility.animation.ScoreboardAnimated;
import io.github.thatkawaiisam.assemble.AssembleAdapter;
import me.activated.core.api.player.PlayerData;
import me.activated.core.api.rank.RankData;
import me.activated.core.api.rank.grant.Grant;
import me.activated.core.managers.player.PlayerManagement;
import me.activated.core.plugin.AquaCoreAPI;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static dev.sumando.mhub.utility.Util.translate;

public class Adapter implements AssembleAdapter {

    @Override
    public String getTitle(Player player) {

        return ScoreboardAnimated.getTitle();
    }

    @Override
    public List<String> getLines(Player player) {
        List<String> scores = new ArrayList<>();
        RankData api = AquaCoreAPI.INSTANCE.getPlayerRank(player.getUniqueId());
        PlayerData coins = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId());
        String kitMap = PlaceholderAPI.setPlaceholders(player, "&5%bungee_kitmap%/&5500");
        String hcf = PlaceholderAPI.setPlaceholders(player, "&5%bungee_hcf%/&5500");
        String practice = PlaceholderAPI.setPlaceholders(player, "&5%bungee_practice%/&5500");
        String Global = PlaceholderAPI.setPlaceholders(player, "&6%bungee_total%&7/&65000%");

        scores.add("");
        scores.add(translate("&6&lInformation"));
        scores.add(translate("&7┃ &fRank&7: " + api.getPrefix()));
        scores.add(translate("&7┃ &fDuration&7: &e" + getDuration(player)));
        scores.add(translate("&7┃ &fCoins&7: &e⛃" + coins.getCoins()));
        scores.add(translate(""));
        scores.add(translate("&6&lNetwork"));
        scores.add(translate("&7┃ &fHCF&7: " + hcf));
        scores.add(translate("&7┃ &fPractice&7: " + practice));
        scores.add(translate("&7┃ &fKitmap&7: " + kitMap));
        scores.add("");
        scores.add(translate(ScoreboardAnimated.getFooter()));

        return scores;
    }


    private String getDuration(Player player) {
        List<Grant> activeGrants = AquaCoreAPI.INSTANCE.getActiveGrants(player.getUniqueId());

        if (activeGrants == null || activeGrants.isEmpty()) {
            return "Never";
        }

        Grant grant = activeGrants.get(0);

        if (grant == null) {
            return "Never";
        }

        return grant.getNiceDuration();
    }
}