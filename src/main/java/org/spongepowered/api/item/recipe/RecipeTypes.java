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

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.recipe.cooking.CookingRecipe;
import org.spongepowered.api.item.recipe.crafting.CraftingRecipe;
import org.spongepowered.api.item.recipe.single.StoneCutterRecipe;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registries;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

/**
 * An enumeration of all {@link RecipeType}s in vanilla minecraft.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class RecipeTypes {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<RecipeType<CraftingRecipe>> CRAFTING = RecipeTypes.key(ResourceKey.minecraft("crafting"));

    public static final DefaultedRegistryReference<RecipeType<CookingRecipe>> SMELTING = RecipeTypes.key(ResourceKey.minecraft("smelting"));

    public static final DefaultedRegistryReference<RecipeType<CookingRecipe>> BLASTING = RecipeTypes.key(ResourceKey.minecraft("blasting"));

    public static final DefaultedRegistryReference<RecipeType<CookingRecipe>> SMOKING = RecipeTypes.key(ResourceKey.minecraft("smoking"));

    public static final DefaultedRegistryReference<RecipeType<CookingRecipe>> CAMPFIRE_COOKING = RecipeTypes.key(ResourceKey.minecraft("campfire_cooking"));

    public static final DefaultedRegistryReference<RecipeType<StoneCutterRecipe>> STONECUTTING = RecipeTypes.key(ResourceKey.minecraft("stonecutting"));

    // SORTFIELDS:OFF

    // @formatter:on

    private RecipeTypes() {
    }

    private static <T extends Recipe> DefaultedRegistryReference<RecipeType<T>> key(final ResourceKey location) {
        return RegistryKey.of(Registries.RECIPE_TYPE, location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
