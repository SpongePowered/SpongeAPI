package org.spongepowered.api.item.recipe;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.recipe.crafting.CraftingRecipe;
import org.spongepowered.api.item.recipe.single.StoneCutterRecipe;
import org.spongepowered.api.item.recipe.smelting.SmeltingRecipe;

import java.util.function.Supplier;

/**
 * An enumeration of all {@link RecipeType}s in vanilla minecraft.
 */
public class RecipeTypes {
    // SORTFIELDS:ON

    // CRAFTING_SHAPED - CRAFTING_SHAPELESS
    public static final Supplier<RecipeType<CraftingRecipe>> CRAFTING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RecipeType.class, "CRAFTING");
    public static final Supplier<RecipeType<SmeltingRecipe>> SMELTING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RecipeType.class, "SMELTING");
    public static final Supplier<RecipeType<SmeltingRecipe>> BLASTING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RecipeType.class, "BLASTING");
    public static final Supplier<RecipeType<SmeltingRecipe>> SMOKING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RecipeType.class, "SMOKING");
    public static final Supplier<RecipeType<SmeltingRecipe>> CAMPFIRE_COOKING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RecipeType.class, "CAMPFIRE_COOKING");
    public static final Supplier<RecipeType<StoneCutterRecipe>> STONECUTTING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RecipeType.class, "STONECUTTING");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private RecipeTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
