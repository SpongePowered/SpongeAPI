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

import org.spongepowered.api.registry.CatalogRegistryModule;

import java.util.Collection;

/**
 * A RecipeRegistry holds all registered recipes for a given game.
 */
public interface RecipeRegistry<T extends Recipe> extends CatalogRegistryModule<T> {

    /**
     * Registers the given {@link Recipe} to make it available to craft.
     *
     * @param recipe The {@link Recipe} to register
     * @deprecated Use the event {@link org.spongepowered.api.event.game.GameRegistryEvent.Register}
     */
    @Deprecated
    void register(T recipe);

    /**
     * Retrieves all recipes registered in this registry.
     *
     * @return An unmodifiable collection of registered recipes
     * @deprecated Use {@link #getAll()} instead.
     */
    @Deprecated
    Collection<T> getRecipes();

}
