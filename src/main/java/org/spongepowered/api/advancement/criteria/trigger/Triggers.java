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
package org.spongepowered.api.advancement.criteria.trigger;

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

/**
 * An enumeration of all the available {@link Trigger}s in minecraft.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public final class Triggers {

    // SORTFIELDS:ON

    public static final Supplier<Trigger<?>> BRED_ANIMALS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "BRED_ANIMALS");

    public static final Supplier<Trigger<?>> BREWED_POTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "BREWED_POTION");

    public static final Supplier<Trigger<?>> CHANGED_DIMENSION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "CHANGED_DIMENSION");

    public static final Supplier<Trigger<?>> CONSTRUCT_BEACON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "CONSTRUCT_BEACON");

    public static final Supplier<Trigger<?>> CONSUME_ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "CONSUME_ITEM");

    public static final Supplier<Trigger<?>> CURED_ZOMBIE_VILLAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "CURED_ZOMBIE_VILLAGER");

    public static final Supplier<Trigger<?>> ENCHANTED_ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "ENCHANTED_ITEM");

    public static final Supplier<Trigger<?>> ENTER_BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "ENTER_BLOCK");

    public static final Supplier<Trigger<?>> ENTITY_HURT_PLAYER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "ENTITY_HURT_PLAYER");

    public static final Supplier<Trigger<?>> ENTITY_KILLED_PLAYER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "ENTITY_KILLED_PLAYER");

    public static final Supplier<Trigger<?>> IMPOSSIBLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "IMPOSSIBLE");

    public static final Supplier<Trigger<?>> INVENTORY_CHANGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "INVENTORY_CHANGED");

    public static final Supplier<Trigger<?>> ITEM_DURABILITY_CHANGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "ITEM_DURABILITY_CHANGED");

    public static final Supplier<Trigger<?>> LEVITATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "LEVITATION");

    public static final Supplier<Trigger<?>> LOCATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "LOCATION");

    public static final Supplier<Trigger<?>> NETHER_TRAVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "NETHER_TRAVEL");

    public static final Supplier<Trigger<?>> PLACED_BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "PLACED_BLOCK");

    public static final Supplier<Trigger<?>> PLAYER_HURT_ENTITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "PLAYER_HURT_ENTITY");

    public static final Supplier<Trigger<?>> PLAYER_KILLED_ENTITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "PLAYER_KILLED_ENTITY");

    public static final Supplier<Trigger<?>> RECIPE_UNLOCKED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "RECIPE_UNLOCKED");

    public static final Supplier<Trigger<?>> SLEPT_IN_BED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "SLEPT_IN_BED");

    public static final Supplier<Trigger<?>> SUMMONED_ENTITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "SUMMONED_ENTITY");

    public static final Supplier<Trigger<?>> TAME_ANIMAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "TAME_ANIMAL");

    public static final Supplier<Trigger<?>> TICK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "TICK");

    public static final Supplier<Trigger<?>> USED_ENDER_EYE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "USED_ENDER_EYE");

    public static final Supplier<Trigger<?>> USED_TOTEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "USED_TOTEM");

    public static final Supplier<Trigger<?>> VILLAGER_TRADE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "VILLAGER_TRADE");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private Triggers() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
