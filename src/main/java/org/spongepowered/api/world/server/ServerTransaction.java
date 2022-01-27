package org.spongepowered.api.world.server;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.event.entity.SpawnEntityEvent;

import java.util.Optional;

public final class ServerTransaction {

    @Nullable private final SpawnEntityEvent entities;
    private final ChangeBlockEvent.@Nullable Post changeBlockEvent;

    public ServerTransaction(
        @Nullable final SpawnEntityEvent entities,
        final ChangeBlockEvent.@Nullable Post changeBlockEvent
    ) {
        this.entities = entities;
        this.changeBlockEvent = changeBlockEvent;
    }

    public Optional<SpawnEntityEvent> entities() {
        return Optional.ofNullable(this.entities);
    }

    public Optional<ChangeBlockEvent.Post> blocks() {
        return Optional.ofNullable(this.changeBlockEvent);
    }

}
