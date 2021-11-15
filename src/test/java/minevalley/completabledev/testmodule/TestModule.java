package minevalley.completabledev.testmodule;

import eu.minevalley.core.api.CoreModule;
import eu.minevalley.core.api.CoreServer;

@CoreModule.Module(
    name = "TestModule",
    version = "1.1",
    authors = {
        "CompletableDev"
    }
)
public final class TestModule extends CoreModule {

    public TestModule(CoreServer server) {
        super(server);
    }

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {

    }
}
