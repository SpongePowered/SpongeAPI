package org.spongepowered.api.entity.living.player;

import org.spongepowered.api.data.type.SkinPart;
import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.scoreboard.Scoreboard;

import java.util.Set;

/**
 * Base interface for {@link Player server} and {@link ClientPlayer client}
 * players.
 */
public interface BasePlayer extends Human, User {

    /**
     * Gets the skin parts that this player has allowed to render.
     *
     * @return A set of skin parts displayed
     */
    Set<SkinPart> getDisplayedSkinParts();

    /**
     * Gets the {@link Scoreboard} displayed to the player.
     *
     * @return The scoreboard displayed to the player
     */
    Scoreboard getScoreboard();

    /**
     * Sets the {@link Scoreboard} displayed to the player.
     *
     * @param scoreboard The scoreboard to display
     */
    void setScoreboard(Scoreboard scoreboard);

}
