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
package org.spongepowered.api.registry;

import org.spongepowered.api.Game;
import org.spongepowered.api.data.type.Profession;
import org.spongepowered.api.item.merchant.TradeOfferGenerator;
import org.spongepowered.api.item.merchant.VillagerRegistry;
import org.spongepowered.api.item.recipe.RecipeRegistry;

/**
 * Provides an easy way to query various registries composed in a {@link Game}.
 */
public interface GameRegistry {

    /**
     * Retrieves the {@link CatalogRegistry}.
     *
     * @return The catalog registry
     */
    CatalogRegistry getCatalogRegistry();

    /**
     * Retrieves the {@link BuilderRegistry}.
     *
     * @return The builder registry
     */
    BuilderRegistry getBuilderRegistry();

    /**
     * Retrieves the {@link FactoryRegistry}.
     *
     * @return The factory registry
     */
    FactoryRegistry getFactoryRegistry();

    /**
     * Retrieves the {@link RecipeRegistry}.
     *
     * @return The recipe registry
     */
    RecipeRegistry getRecipeRegistry();

    /**
     * Gets the {@link VillagerRegistry} for the register mappings of
     * {@link Profession}s to {@link TradeOfferGenerator}s based on a level.
     *
     * @return The villager registry instance
     */
    VillagerRegistry getVillagerRegistry();
}
