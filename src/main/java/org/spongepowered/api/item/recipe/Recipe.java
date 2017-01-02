package org.spongepowered.api.item.recipe;

import org.spongepowered.api.item.inventory.ItemStackSnapshot;

/**
 * A general interface for recipes
 */
public interface Recipe {
    /**
     * @return The exemplary result of this recipe
     */
    ItemStackSnapshot getExemplaryResult();
}
