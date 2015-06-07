package org.spongepowered.api.util.provider;

import org.spongepowered.api.GameProfile;

import java.util.UUID;

public interface GameProfileProvider extends Provider {
    /**
     * Creates a new {@link GameProfile} using the specified unique identifier and name.
     *
     * @param uuid The unique identifier for the profile
     * @param name The name for the profile
     * @return The created profile
     */
    GameProfile createGameProfile(UUID uuid, String name);
}
