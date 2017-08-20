package org.spongepowered.api.network;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface NetworkPlayerList {

    Optional<NetworkPlayer> getPlayer(UUID uniqueId);

    Optional<NetworkPlayer> getPlayer(String name);

    Collection<NetworkPlayer> getPlayers();
}
