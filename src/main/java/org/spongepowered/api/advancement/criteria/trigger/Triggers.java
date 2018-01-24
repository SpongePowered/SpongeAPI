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

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of all the available {@link Trigger}s in minecraft.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public final class Triggers {

    // SORTFIELDS:ON

    public static final Trigger<?> BRED_ANIMALS = DummyObjectProvider.createFor(Trigger.class, "BRED_ANIMALS");

    public static final Trigger<?> BREWED_POTION = DummyObjectProvider.createFor(Trigger.class, "BREWED_POTION");

    public static final Trigger<?> CHANGED_DIMENSION = DummyObjectProvider.createFor(Trigger.class, "CHANGED_DIMENSION");

    public static final Trigger<?> CONSTRUCT_BEACON = DummyObjectProvider.createFor(Trigger.class, "CONSTRUCT_BEACON");

    public static final Trigger<?> CONSUME_ITEM = DummyObjectProvider.createFor(Trigger.class, "CONSUME_ITEM");

    public static final Trigger<?> CURED_ZOMBIE_VILLAGER = DummyObjectProvider.createFor(Trigger.class, "CURED_ZOMBIE_VILLAGER");

    public static final Trigger<?> ENCHANTED_ITEM = DummyObjectProvider.createFor(Trigger.class, "ENCHANTED_ITEM");

    public static final Trigger<?> ENTER_BLOCK = DummyObjectProvider.createFor(Trigger.class, "ENTER_BLOCK");

    public static final Trigger<?> ENTITY_HURT_PLAYER = DummyObjectProvider.createFor(Trigger.class, "ENTITY_HURT_PLAYER");

    public static final Trigger<?> ENTITY_KILLED_PLAYER = DummyObjectProvider.createFor(Trigger.class, "ENTITY_KILLED_PLAYER");

    public static final Trigger<?> IMPOSSIBLE = DummyObjectProvider.createFor(Trigger.class, "IMPOSSIBLE");

    public static final Trigger<?> INVENTORY_CHANGED = DummyObjectProvider.createFor(Trigger.class, "INVENTORY_CHANGED");

    public static final Trigger<?> ITEM_DURABILITY_CHANGED = DummyObjectProvider.createFor(Trigger.class, "ITEM_DURABILITY_CHANGED");

    public static final Trigger<?> LEVITATION = DummyObjectProvider.createFor(Trigger.class, "LEVITATION");

    public static final Trigger<?> LOCATION = DummyObjectProvider.createFor(Trigger.class, "LOCATION");

    public static final Trigger<?> NETHER_TRAVEL = DummyObjectProvider.createFor(Trigger.class, "NETHER_TRAVEL");

    public static final Trigger<?> PLACED_BLOCK = DummyObjectProvider.createFor(Trigger.class, "PLACED_BLOCK");

    public static final Trigger<?> PLAYER_HURT_ENTITY = DummyObjectProvider.createFor(Trigger.class, "PLAYER_HURT_ENTITY");

    public static final Trigger<?> PLAYER_KILLED_ENTITY = DummyObjectProvider.createFor(Trigger.class, "PLAYER_KILLED_ENTITY");

    public static final Trigger<?> RECIPE_UNLOCKED = DummyObjectProvider.createFor(Trigger.class, "RECIPE_UNLOCKED");

    public static final Trigger<?> SLEPT_IN_BED = DummyObjectProvider.createFor(Trigger.class, "SLEPT_IN_BED");

    public static final Trigger<?> SUMMONED_ENTITY = DummyObjectProvider.createFor(Trigger.class, "SUMMONED_ENTITY");

    public static final Trigger<?> TAME_ANIMAL = DummyObjectProvider.createFor(Trigger.class, "TAME_ANIMAL");

    public static final Trigger<?> TICK = DummyObjectProvider.createFor(Trigger.class, "TICK");

    public static final Trigger<?> USED_ENDER_EYE = DummyObjectProvider.createFor(Trigger.class, "USED_ENDER_EYE");

    public static final Trigger<?> USED_TOTEM = DummyObjectProvider.createFor(Trigger.class, "USED_TOTEM");

    public static final Trigger<?> VILLAGER_TRADE = DummyObjectProvider.createFor(Trigger.class, "VILLAGER_TRADE");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private Triggers() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
