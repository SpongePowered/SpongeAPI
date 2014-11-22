package org.spongepowered.api.recipe;

import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;

/**
 * A smelting recipe. Applies usually when something is 
 * smelted/cooked in furnace.
 */
public class SmeltingRecipe extends Recipe {
    
    protected ItemType material;
    
    /**
     * Creates a new smelting recipe.
     * @param result Result of the recipe
     * @param material Material used
     */
    public SmeltingRecipe(ItemStack result, ItemType material) {
        this.result = result;
        this.material = material;
    }
    
    /**
     * Gets the material used in this recipe.
     * @return Material used
     */
    public ItemType getMaterial() {
        return this.material;
    }
}
