package dev.sumando.mhub.managers;

import dev.sumando.mhub.mHub;
import dev.sumando.mhub.managers.payloads.CMDPayload;
import dev.sumando.mhub.managers.payloads.ListenerPayload;
import dev.sumando.mhub.managers.payloads.ProviderPayload;
import dev.sumando.mhub.task.TaskManager;

public class ManagerLoader {

    private final TaskManager taskManager;
    private final ProviderPayload providerPayload;
    private final CMDPayload cmdPayload;
    private final ListenerPayload listenerPayload;

    public ManagerLoader(mHub mHub) {
        this.taskManager = new TaskManager(mHub);
        this.providerPayload = new ProviderPayload(mHub);
        this.cmdPayload = new CMDPayload(mHub);
        this.listenerPayload = new ListenerPayload(mHub);
    }

    public void enable() {
        load();
    }

    public void load() {
        taskManager.registerTask();
        providerPayload.registerProviders();
        cmdPayload.registerCMD();
        listenerPayload.register();
    }

    public void disable() {
        taskManager.unregisterTask();
        if (providerPayload.getTabHandler() != null && providerPayload.getTabHandler().getService() != null) {
            providerPayload.getTabHandler().getService().destroy();
        }
    }

}
