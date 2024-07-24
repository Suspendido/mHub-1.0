package dev.sumando.mhub.managers.payloads;

import dev.sumando.mhub.mHub;
import dev.sumando.mhub.adapters.board.Adapter;
import dev.sumando.mhub.adapters.tab.TabProvider;
import dev.sumando.mhub.utility.animation.ScoreboardAnimated;
import io.github.thatkawaiisam.assemble.Assemble;
import io.github.thatkawaiisam.assemble.AssembleStyle;
import lombok.Getter;
import me.lucanius.edge.Edge;

public class ProviderPayload {

    @Getter private static ProviderPayload instance;
    private final mHub mHub;

    @Getter private Edge tabHandler;


    public ProviderPayload(mHub mHub) {
        this.mHub = mHub;
    }

    public void registerProviders() {
        tabHandler = new Edge(mHub, new TabProvider());

        ScoreboardAnimated.init();
        Assemble assemble = new Assemble(mHub, new Adapter());
        assemble.setTicks(2);
        assemble.setAssembleStyle(AssembleStyle.MODERN);

    }
}
