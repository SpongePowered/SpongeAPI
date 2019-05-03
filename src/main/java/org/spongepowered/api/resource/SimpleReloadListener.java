package org.spongepowered.api.resource;


import java.util.concurrent.CompletableFuture;

public interface SimpleReloadListener extends AsyncReloadListener {
    @Override
    default CompletableFuture<Void> listen(Staging stg, AsyncReloader reloader) {
        return stg.setup(null).thenRunAsync(() -> onReload(reloader.getResourceManager()), reloader.getEngine());
    }

    void onReload(ResourceManager manager);
}
