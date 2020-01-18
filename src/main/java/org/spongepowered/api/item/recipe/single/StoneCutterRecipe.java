package org.spongepowered.api.item.recipe.single;

import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.recipe.Recipe;
import org.spongepowered.api.util.CatalogBuilder;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.function.Predicate;

/**
 * A StoneCutter Recipe.
 */
public interface StoneCutterRecipe extends Recipe {

    static StoneCutterRecipe.Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(StoneCutterRecipe.Builder.class);
    }

    /**
     * Builds a simple furnace recipe.
     */
    interface Builder extends ResettableBuilder<StoneCutterRecipe, StoneCutterRecipe.Builder> {

        /**
         * Sets the ingredient and returns this builder.
         *
         * @param ingredient The ingredient
         *
         * @return This builder, for chaining
         */
        ResultStep ingredient(ItemType ingredient);

        /**
         * Sets the ingredient and exemplary ingredient.
         *
         * @param predicate The ingredient predicate
         * @param exemplaryIngredient The exemplary ingredient for the recipe book
         *
         * @return This builder, for chaining
         */
        ResultStep ingredient(Predicate<ItemStackSnapshot> predicate, ItemType exemplaryIngredient);

        interface ResultStep extends StoneCutterRecipe.Builder {

            /**
             * Changes the result and returns this builder. The result is the
             * {@link ItemStack} created when the recipe is fulfilled.
             *
             * @param result The output of this recipe
             * @return This builder, for chaining
             */
            EndStep result(ItemStackSnapshot result);

            /**
             * Changes the result and returns this builder. The result is the
             * {@link ItemStack} created when the recipe is fulfilled.
             *
             * @param result The output of this recipe
             * @return This builder, for chaining
             */
            default EndStep result(ItemStack result) {
                return this.result(result.createSnapshot());
            }

        }

        interface EndStep extends StoneCutterRecipe.Builder, CatalogBuilder<StoneCutterRecipe, Builder> {

            @Override
            EndStep key(CatalogKey key);

            /**
             * Builds the {@link StoneCutterRecipe}.
             *
             * @return The built stone cutter recipe
             * @throws IllegalStateException If not all the recipe builder steps are completed
             *                               or the {@link #key(CatalogKey)} isn't set.
             */
            @Override
            StoneCutterRecipe build() throws IllegalStateException;
        }
    }
}
