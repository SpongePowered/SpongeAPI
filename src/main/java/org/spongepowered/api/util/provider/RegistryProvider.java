package org.spongepowered.api.util.provider;

import org.spongepowered.api.GameDictionary;
import org.spongepowered.api.GameRegistry;
import org.spongepowered.api.data.DataManipulatorRegistry;
import org.spongepowered.api.data.ImmutableDataRegistry;
import org.spongepowered.api.item.recipe.RecipeRegistry;

public interface RegistryProvider extends Provider {
    /**
     * Retrieves the GameDictionary (item dictionary) for this RegistryProvider.
     *
     * @return The item dictionary
     */
    GameDictionary getGameDictionary();

    /**
     * Retrieves the GameRegistry for this RegistryProvider.
     *
     * @return The game registry
     */
    GameRegistry getGameRegistry();

    /**
     * Retrieves the RecipeRegistry for this RegistryProvider.
     *
     * @return The recipe registry
     */
    RecipeRegistry getRecipeRegistry();

    /**
     * Retrieves the {@link DataManipulatorRegistry} for this {@link RegistryProvider}.
     *
     * @return The manipulator registry
     */
    DataManipulatorRegistry getManipulatorRegistry();

    /**
     * Retrieves the {@link ImmutableDataRegistry} for this {@link RegistryProvider}.
     *
     * @return The immutable data registry
     */
    ImmutableDataRegistry getImmutableDataRegistry();
}
