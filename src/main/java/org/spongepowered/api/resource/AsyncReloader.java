package org.spongepowered.api.resource;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.resource.pack.Pack;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public interface AsyncReloader {

    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    ResourceManager getResourceManager();

    Executor getWorker();

    Executor getEngine();

    interface Builder extends ResettableBuilder<AsyncReloader, Builder> {

        Builder manager(ReloadableResourceManager manager);

        Builder engine(Executor engine);

        Builder packs(Pack... packs);

        Builder action(CompletableFuture<Void> action);

        AsyncReloader build();
    }
}
