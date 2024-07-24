package dev.sumando.mhub.managers.payloads;

import dev.sumando.mhub.mHub;
import dev.sumando.mhub.cmd.BuildCMD;
import dev.sumando.mhub.cmd.DevCMD;

public class CMDPayload {

    private final mHub mHub;

    public CMDPayload(mHub atlasHub) {
        this.mHub = atlasHub;
    }

    public void registerCMD() {
        mHub.getCommand("build").setExecutor(new BuildCMD());
        mHub.getCommand("dev").setExecutor(new DevCMD());
    }

}
