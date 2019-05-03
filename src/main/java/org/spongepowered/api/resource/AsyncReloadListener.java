package org.spongepowered.api.resource;

import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.CompletableFuture;

public interface AsyncReloadListener {

    CompletableFuture<Void> listen(Staging stg, AsyncReloader reloader);

    interface Staging {
        <@Nullable T> CompletableFuture<T> setup(T instance);
    }
}
