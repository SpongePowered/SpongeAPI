package org.spongepowered.api.component;

import org.spongepowered.api.Game;

/**
 * Represents a data holder for a {@link org.spongepowered.api.component.ComponentHolder}.
 */
public interface Component<H> {
    /**
     * Returns the{@link org.spongepowered.api.component.ComponentHolder} holding this component.
     * @return The holder
     */
    H getHolder();

    /**
     * Gets the {@link org.spongepowered.api.Game} object.
     * @return The game
     */
    Game getGame();
}
