package dev.sumando.mhub;

import dev.sumando.mhub.managers.ManagerLoader;
import dev.sumando.mhub.adapters.board.Adapter;
import dev.sumando.mhub.task.TaskManager;
import dev.sumando.mhub.utility.Util;
import dev.sumando.mhub.utility.animation.ScoreboardAnimated;
import io.github.thatkawaiisam.assemble.Assemble;
import io.github.thatkawaiisam.assemble.AssembleStyle;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class mHub extends JavaPlugin {

    @Getter
    private static mHub instance;

    private TaskManager taskManager;
    private ManagerLoader loader;


    @Override
    public void onEnable() {
        instance = this;

        this.loader = new ManagerLoader(this);
        this.loader.enable();

        Util.log("&6mHub has been enabled!");
    }

    @Override
    public void onDisable() {
        this.loader.disable();
    }
}
