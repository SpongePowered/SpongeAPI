package org.spongepowered.api.item.inventory.crafting;

import org.spongepowered.api.item.inventory.type.GridInventory;
import org.spongepowered.api.item.recipe.crafting.CraftingRecipe;
import org.spongepowered.api.world.World;

import java.util.Optional;

/**
 * A CraftingGridInventory represents the inventory of something that can craft
 * items. This is excluding the Result slot.
 */
public interface CraftingGridInventory extends GridInventory {
    /**
     * Retrieves the recipe formed by this CraftingGridInventory, if any.
     *
     * @param world The world where the item would be crafted in
     * @return The recipe or {@link Optional#empty()} if no recipe is formed
     */
    Optional<CraftingRecipe> getRecipe(World world);
}
