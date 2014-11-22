package org.spongepowered.api.recipe.custom;

import java.util.List;

import org.spongepowered.api.recipe.Recipe;

/**
 * Custom handler for mods which add new ways to create items. For example,
 * if some mod adds an owen, it may require custom recipes.
 */
public interface RecipeHandler {
    
    /**
     * Gets list of recipe classes, which should handled by this. When plugin
     * then tries to register one of them, {@link #registerRecipe(Recipe)}
     * will called with the corresponding recipe.
     * 
     * <p>When a plugin tries to unregister a recipe, only difference is
     * that {@link #unregisterRecipe(Recipe)} will called instead.</p>
     * @return List of handled recipe classes
     */
    List<Class<Recipe>> getHandledClasses();
    
    /**
     * Should register new recipe to your mods recipe registry.
     * @param recipe Recipe to register
     */
    void registerRecipe(Recipe recipe);
    
    /**
     * Should unregister the recipe from your mods recipe registry.
     * @param recipe Recipe to unregister
     */
    void unregisterRecipe(Recipe recipe);
}
