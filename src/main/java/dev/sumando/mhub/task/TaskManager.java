package dev.sumando.mhub.task;

import dev.sumando.mhub.mHub;
import dev.sumando.mhub.task.payload.ActionPayload;
import org.bukkit.scheduler.BukkitTask;

public class TaskManager {

    private final mHub mHub;
    private BukkitTask actionTask;

    public TaskManager(mHub mHub) {
        this.mHub = mHub;
    }

    public void registerTask() {
        actionTask = new ActionPayload().runTaskTimer(mHub, 0L, 60L);
    }

    public void unregisterTask() {
        if (actionTask != null) {
            actionTask.cancel();
            actionTask = null; // Limpia la referencia después de la cancelación xde
        }
    }
}
