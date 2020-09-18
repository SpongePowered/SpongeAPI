/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.item.recipe;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.recipe.crafting.CraftingRecipe;
import org.spongepowered.api.item.recipe.single.StoneCutterRecipe;
import org.spongepowered.api.item.recipe.cooking.CookingRecipe;

import java.util.function.Supplier;

/**
 * An enumeration of all {@link RecipeType}s in vanilla minecraft.
 */
public class RecipeTypes {
    // SORTFIELDS:ON

    // CRAFTING_SHAPED - CRAFTING_SHAPELESS
    public static final Supplier<RecipeType<CraftingRecipe>> CRAFTING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RecipeType.class, "crafting");
    public static final Supplier<RecipeType<CookingRecipe>> SMELTING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RecipeType.class, "smelting");
    public static final Supplier<RecipeType<CookingRecipe>> BLASTING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RecipeType.class, "blasting");
    public static final Supplier<RecipeType<CookingRecipe>> SMOKING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RecipeType.class, "smoking");
    public static final Supplier<RecipeType<CookingRecipe>> CAMPFIRE_COOKING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RecipeType.class, "campfire_cooking");
    public static final Supplier<RecipeType<StoneCutterRecipe>> STONECUTTING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RecipeType.class, "stonecutting");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private RecipeTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
