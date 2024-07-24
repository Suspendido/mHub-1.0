package dev.sumando.mhub.managers.payloads;

import dev.sumando.mhub.mHub;
import dev.sumando.mhub.listeners.*;
import org.bukkit.plugin.PluginManager;

public class ListenerPayload {

    private final mHub mHub;

    public ListenerPayload(mHub mHub) {
        this.mHub = mHub;
    }

    public void register() {
        PluginManager pm = mHub.getServer().getPluginManager();

        pm.registerEvents(new JoinListener(), mHub);
        pm.registerEvents(new ProtectionListener(), mHub);
        pm.registerEvents(new InteractListener(), mHub);
        pm.registerEvents(new MenuListener(), mHub);
        //pm.registerEvents(new InvListener(), mHub);
        pm.registerEvents(new LunarListener(), mHub);

    }
}
