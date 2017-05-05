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
 * An enumeration of all the available {@link TriggerType}s in minecraft.
 */
public final class TriggerTypes {

    // SORTFIELDS:ON

    public static final TriggerType ARBITRARY_PLAYER_TICK = DummyObjectProvider.createFor(TriggerType.class, "ARBITRARY_PLAYER_TICK");

    public static final TriggerType BRED_ANIMALS = DummyObjectProvider.createFor(TriggerType.class, "BRED_ANIMALS");

    public static final TriggerType BREWED_POTION = DummyObjectProvider.createFor(TriggerType.class, "BREWED_POTION");

    public static final TriggerType CONSTRUCT_BEACON = DummyObjectProvider.createFor(TriggerType.class, "CONSTRUCT_BEACON");

    public static final TriggerType CONSUME_ITEM = DummyObjectProvider.createFor(TriggerType.class, "CONSUME_ITEM");

    public static final TriggerType CURSE_ZOMBIE_VILLAGER = DummyObjectProvider.createFor(TriggerType.class, "CONSUME_ITEM");

    public static final TriggerType ENCHANTED_ITEM = DummyObjectProvider.createFor(TriggerType.class, "ENCHANTED_ITEM");

    public static final TriggerType ENTER_BLOCK = DummyObjectProvider.createFor(TriggerType.class, "ENTER_BLOCK");

    public static final TriggerType ENTITY_HURT_PLAYER = DummyObjectProvider.createFor(TriggerType.class, "ENTITY_HURT_PLAYER");

    public static final TriggerType ENTITY_KILLED_PLAYER = DummyObjectProvider.createFor(TriggerType.class, "ENTITY_KILLED_PLAYER");

    public static final TriggerType IMPOSSIBLE = DummyObjectProvider.createFor(TriggerType.class, "IMPOSSIBLE");

    public static final TriggerType INVENTORY_CHANGED = DummyObjectProvider.createFor(TriggerType.class, "INVENTORY_CHANGED");

    public static final TriggerType ITEM_DURABILITY_CHANGED = DummyObjectProvider.createFor(TriggerType.class, "ITEM_DURABILITY_CHANGED");

    public static final TriggerType LOCATION = DummyObjectProvider.createFor(TriggerType.class, "LOCATION");

    public static final TriggerType PLACED_BLOCK = DummyObjectProvider.createFor(TriggerType.class, "PLACED_BLOCK");

    public static final TriggerType PLAYER_HURT_ENTITY = DummyObjectProvider.createFor(TriggerType.class, "PLAYER_HURT_ENTITY");

    public static final TriggerType PLAYER_KILLED_ENTITY = DummyObjectProvider.createFor(TriggerType.class, "PLAYER_KILLED_ENTITY");

    public static final TriggerType RECIPE_UNLOCKED = DummyObjectProvider.createFor(TriggerType.class, "RECIPE_UNLOCKED");

    public static final TriggerType SLEPT_IN_BED = DummyObjectProvider.createFor(TriggerType.class, "SLEPT_IN_BED");

    public static final TriggerType SUMMONED_ENTITY = DummyObjectProvider.createFor(TriggerType.class, "SUMMONED_ENTITY");

    public static final TriggerType TAME_ANIMAL = DummyObjectProvider.createFor(TriggerType.class, "TAME_ANIMAL");

    public static final TriggerType TICK = DummyObjectProvider.createFor(TriggerType.class, "TICK");

    public static final TriggerType USED_ENDER_EYE = DummyObjectProvider.createFor(TriggerType.class, "USED_ENDER_EYE");

    public static final TriggerType VILLAGER_TRADE = DummyObjectProvider.createFor(TriggerType.class, "VILLAGER_TRADE");

    public static final TriggerType CHANGED_DIMENSION = DummyObjectProvider.createFor(TriggerType.class, "CHANGED_DIMENSION");

    // SORTFIELDS:OFF

    private TriggerTypes() {
    }
}
