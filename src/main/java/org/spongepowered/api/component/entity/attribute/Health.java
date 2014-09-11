package org.spongepowered.api.component.entity.attribute;

import org.spongepowered.api.component.entity.EntityComponent;

/**
 * Gives the attribute "health" to an {@link org.spongepowered.api.entity.Entity}.
 */
public interface Health extends EntityComponent {
    /**
     * Gets the value of the current health
     * @return The value
     */
    double getHealth();

    /**
     * Sets the value for the health
     * @param value The value
     */
    void setHealth(double value);
}
