package org.spongepowered.api.recipe;

import org.spongepowered.api.item.inventory.ItemStack;

/**
 * Main class for ALL recipes.
 */
public class Recipe {
    
    protected ItemStack result;
    
    /**
     * Gets result of recipe.
     * @return Result
     */
    public ItemStack getResult() {
        return this.result;
    }
}
