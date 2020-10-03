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

    public static final Supplier<Trigger<?>> BEE_NEST_DESTROYED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "bee_nest_destroyed");

    public static final Supplier<Trigger<?>> BRED_ANIMALS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "bred_animals");

    public static final Supplier<Trigger<?>> BREWED_POTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "brewed_potion");

    public static final Supplier<Trigger<?>> CHANGED_DIMENSION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "changed_dimension");

    public static final Supplier<Trigger<?>> CHANNELED_LIGHTNING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "channeled_lightning");

    public static final Supplier<Trigger<?>> CONSTRUCT_BEACON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "construct_beacon");

    public static final Supplier<Trigger<?>> CONSUME_ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "consume_item");

    public static final Supplier<Trigger<?>> CURED_ZOMBIE_VILLAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "cured_zombie_villager");

    public static final Supplier<Trigger<?>> EFFECTS_CHANGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "effects_changed");

    public static final Supplier<Trigger<?>> ENCHANTED_ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "enchanted_item");

    public static final Supplier<Trigger<?>> ENTER_BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "enter_block");

    public static final Supplier<Trigger<?>> ENTITY_HURT_PLAYER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "entity_hurt_player");

    public static final Supplier<Trigger<?>> ENTITY_KILLED_PLAYER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "entity_killed_player");

    public static final Supplier<Trigger<?>> FILLED_BUCKET = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "filled_bucket");

    public static final Supplier<Trigger<?>> FISHING_ROD_HOOKED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "fishing_rod_hooked");

    public static final Supplier<Trigger<?>> HERO_OF_THE_VILLAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "hero_of_the_village");

    public static final Supplier<Trigger<?>> IMPOSSIBLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "impossible");

    public static final Supplier<Trigger<?>> INVENTORY_CHANGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "inventory_changed");

    public static final Supplier<Trigger<?>> ITEM_DURABILITY_CHANGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "item_durability_changed");

    public static final Supplier<Trigger<?>> KILLED_BY_CROSSBOW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "killed_by_crossbow");

    public static final Supplier<Trigger<?>> LEVITATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "levitation");

    public static final Supplier<Trigger<?>> LOCATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "location");

    public static final Supplier<Trigger<?>> NETHER_TRAVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "nether_travel");

    public static final Supplier<Trigger<?>> PLACED_BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "placed_block");

    public static final Supplier<Trigger<?>> PLAYER_HURT_ENTITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "player_hurt_entity");

    public static final Supplier<Trigger<?>> PLAYER_KILLED_ENTITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "player_killed_entity");

    public static final Supplier<Trigger<?>> RECIPE_UNLOCKED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "recipe_unlocked");

    public static final Supplier<Trigger<?>> SAFELY_HARVEST_HONEY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "safely_harvest_honey");

    public static final Supplier<Trigger<?>> SHOT_CROSSBOW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "shot_crossbow");

    public static final Supplier<Trigger<?>> SLEPT_IN_BED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "slept_in_bed");

    public static final Supplier<Trigger<?>> SLIDE_DOWN_BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "slide_down_block");

    public static final Supplier<Trigger<?>> SUMMONED_ENTITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "summoned_entity");

    public static final Supplier<Trigger<?>> TAME_ANIMAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "tame_animal");

    public static final Supplier<Trigger<?>> TICK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "tick");

    public static final Supplier<Trigger<?>> USED_ENDER_EYE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "used_ender_eye");

    public static final Supplier<Trigger<?>> USED_TOTEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "used_totem");

    public static final Supplier<Trigger<?>> VILLAGER_TRADE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "villager_trade");

    public static final Supplier<Trigger<?>> VOLUNTARY_EXILE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Trigger.class, "voluntary_exile");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private Triggers() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
