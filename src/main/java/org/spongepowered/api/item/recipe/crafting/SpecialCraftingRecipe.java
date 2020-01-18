package org.spongepowered.api.item.recipe.crafting;

import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.crafting.CraftingInventory;
import org.spongepowered.api.util.CatalogBuilder;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.world.World;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * Recipes with custom matching/result logic.
 * <p>By default special recipes cannot be displayed in a recipe book.</p>
 * <p>But providing both a fixed/exemplary shaped or shapeless recipe shape
 * ({@link Builder#matching(CraftingRecipe)}/{@link Builder#matching(BiPredicate, CraftingRecipe)})
 * and a fixed/exemplary result
 * ({@link Builder.ResultStep#result(ItemStack)}/{@link Builder.ResultStep#result(Function, ItemStack)})
 * Sponge can provide a recipe book entry anyways.</p>
 */
public interface SpecialCraftingRecipe extends CraftingRecipe {

    /**
     * Creates a new {@link SpecialCraftingRecipe.Builder} to build a {@link SpecialCraftingRecipe}.
     *
     * @return The new builder
     */
    static SpecialCraftingRecipe.Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(SpecialCraftingRecipe.Builder.class);
    }

    interface Builder extends ResettableBuilder<SpecialCraftingRecipe, SpecialCraftingRecipe.Builder> {

        /**
         * Sets the recipe matcher.
         *
         * @param biPredicate The matching predicate
         *
         * @return This builder, for chaining
         */
        SpecialCraftingRecipe.Builder.ResultStep matching(BiPredicate<CraftingInventory, World> biPredicate);

        /**
         * Sets the recipe matcher and an exemplary shape from another CraftingRecipe.
         * <p>The example should match one of the allowed shapes, as it will be used for the recipe book.</p>
         *
         * @param biPredicate The matching predicate.
         * @param exemplaryShape The recipe used for the exemplary shape.
         *
         * @return This builder, for chaining
         */
        SpecialCraftingRecipe.Builder.ResultStep matching(BiPredicate<CraftingInventory, World> biPredicate, CraftingRecipe exemplaryShape);

        /**
         * Sets the recipe matcher from another CraftingRecipe
         *
         * @param shape The recipe used for the shape.
         *
         * @return This builder, for chaining
         */
        SpecialCraftingRecipe.Builder.ResultStep matching(CraftingRecipe shape);

        /**
         * In this Step set the result of the Recipe.
         * <p>Optionally configure the remaining items.</p>
         */
        interface ResultStep extends SpecialCraftingRecipe.Builder {

            /**
             * Sets the remainingItems function. The function must return a list of the same size as the input CraftingInventory.
             *
             * @param remainingItemsFunction the remaining items function
             *
             * @return This builder, for chaining
             */
            ResultStep remainingItems(Function<CraftingInventory, List<ItemStack>> remainingItemsFunction);

            /**
             * Sets the result function.
             *
             * @param resultFunction The result function
             *
             * @return This builder, for chaining
             */
            EndStep result(Function<CraftingInventory, ItemStack> resultFunction);

            /**
             * Sets the result function and an exemplary result.
             * <p>The example should match one of the possible crafting results, as it will be used for the recipe book.</p>
             *
             * @param resultFunction The result function
             * @param exemplaryResult The exemplary result
             *
             * @return This builder, for chaining
             */
            EndStep result(Function<CraftingInventory, ItemStack> resultFunction, ItemStack exemplaryResult);

            /**
             * Sets the result
             *
             * @param result The result
             *
             * @return This builder, for chaining
             */
            EndStep result(ItemStack result);
        }

        interface EndStep extends SpecialCraftingRecipe.Builder, CatalogBuilder<SpecialCraftingRecipe, SpecialCraftingRecipe.Builder> {

            @Override
            EndStep key(CatalogKey key);

            /**
             * Builds the {@link SpecialCraftingRecipe}.
             *
             * @return The built special crafting recipe
             * @throws IllegalStateException If not all the recipe builder steps are completed
             *                               or the {@link #key(CatalogKey)} isn't set.
             */
            @Override
            SpecialCraftingRecipe build() throws IllegalStateException;
        }

    }

}
