package org.spongepowered.api.stats.achievement;

import com.google.common.base.Optional;

/**
 * Represents an in-game achievement which may be earned by or given to players.
 */
public interface Achievement {

    /**
     * Returns the parent of this achievement, if there is one.
     *
     * @return The parent of this achievement
     */
    Optional<Achievement> getParent();

}
