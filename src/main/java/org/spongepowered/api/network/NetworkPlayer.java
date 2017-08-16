package org.spongepowered.api.network;

import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.entity.living.player.tab.TabListEntry;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.text.Text;

import java.util.Optional;

/**
 * @see TabListEntry
 */
public interface NetworkPlayer {

    /**
     * Gets the {@link GameProfile} associated with this entry.
     *
     * @return The profile associated with this entry
     */
    GameProfile getProfile();

    /**
     * Gets this entry's display name.
     *
     * @return This entry's display name
     */
    Optional<Text> getDisplayName();

    /**
     * Gets the latency for this entry.
     *
     * @return The latency for this entry
     * @see TabListEntry#setLatency(int)
     */
    int getLatency();

    /**
     * Gets the {@link GameMode} this entry is in.
     *
     * @return The gamemode this entry is in
     */
    GameMode getGameMode();
}
