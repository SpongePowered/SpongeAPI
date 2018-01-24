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
package org.spongepowered.api.statistic;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of all available {@link Statistic}s from the vanilla game.
 */
public final class Statistics {

    // SORTFIELDS:ON

    public static final Statistic ANIMALS_BRED = DummyObjectProvider.createFor(Statistic.class, "ANIMALS_BRED");

    public static final Statistic ARMOR_CLEANED = DummyObjectProvider.createFor(Statistic.class, "ARMOR_CLEANED");

    public static final Statistic AVIATE_ONE_CM = DummyObjectProvider.createFor(Statistic.class, "AVIATE_ONE_CM");

    public static final Statistic BANNER_CLEANED = DummyObjectProvider.createFor(Statistic.class, "BANNER_CLEANED");

    public static final Statistic BEACON_INTERACTION = DummyObjectProvider.createFor(Statistic.class, "BEACON_INTERACTION");

    public static final Statistic BOAT_ONE_CM = DummyObjectProvider.createFor(Statistic.class, "BOAT_ONE_CM");

    public static final Statistic BREWINGSTAND_INTERACTION = DummyObjectProvider.createFor(Statistic.class, "BREWINGSTAND_INTERACTION");

    public static final Statistic CAKE_SLICES_EATEN = DummyObjectProvider.createFor(Statistic.class, "CAKE_SLICES_EATEN");

    public static final Statistic CAULDRON_FILLED = DummyObjectProvider.createFor(Statistic.class, "CAULDRON_FILLED");

    public static final Statistic CAULDRON_USED = DummyObjectProvider.createFor(Statistic.class, "CAULDRON_USED");

    public static final Statistic CHEST_OPENED = DummyObjectProvider.createFor(Statistic.class, "CHEST_OPENED");

    public static final Statistic CLIMB_ONE_CM = DummyObjectProvider.createFor(Statistic.class, "CLIMB_ONE_CM");

    public static final Statistic CRAFTING_TABLE_INTERACTION = DummyObjectProvider.createFor(Statistic.class, "CRAFTING_TABLE_INTERACTION");

    public static final Statistic CROUCH_ONE_CM = DummyObjectProvider.createFor(Statistic.class, "CROUCH_ONE_CM");

    public static final Statistic DAMAGE_DEALT = DummyObjectProvider.createFor(Statistic.class, "DAMAGE_DEALT");

    public static final Statistic DAMAGE_TAKEN = DummyObjectProvider.createFor(Statistic.class, "DAMAGE_TAKEN");

    public static final Statistic DEATHS = DummyObjectProvider.createFor(Statistic.class, "DEATHS");

    public static final Statistic DISPENSER_INSPECTED = DummyObjectProvider.createFor(Statistic.class, "DISPENSER_INSPECTED");

    public static final Statistic DIVE_ONE_CM = DummyObjectProvider.createFor(Statistic.class, "DIVE_ONE_CM");

    public static final Statistic DROP = DummyObjectProvider.createFor(Statistic.class, "DROP");

    public static final Statistic DROPPER_INSPECTED = DummyObjectProvider.createFor(Statistic.class, "DROPPER_INSPECTED");

    public static final Statistic ENDERCHEST_OPENED = DummyObjectProvider.createFor(Statistic.class, "ENDERCHEST_OPENED");

    public static final Statistic FALL_ONE_CM = DummyObjectProvider.createFor(Statistic.class, "FALL_ONE_CM");

    public static final Statistic FISH_CAUGHT = DummyObjectProvider.createFor(Statistic.class, "FISH_CAUGHT");

    public static final Statistic FLOWER_POTTED = DummyObjectProvider.createFor(Statistic.class, "FLOWER_POTTED");

    public static final Statistic FURNACE_INTERACTION = DummyObjectProvider.createFor(Statistic.class, "FURNACE_INTERACTION");

    public static final Statistic HOPPER_INSPECTED = DummyObjectProvider.createFor(Statistic.class, "HOPPER_INSPECTED");

    public static final Statistic HORSE_ONE_CM = DummyObjectProvider.createFor(Statistic.class, "HORSE_ONE_CM");

    public static final Statistic ITEM_ENCHANTED = DummyObjectProvider.createFor(Statistic.class, "ITEM_ENCHANTED");

    public static final Statistic JUMP = DummyObjectProvider.createFor(Statistic.class, "JUMP");

    public static final Statistic LEAVE_GAME = DummyObjectProvider.createFor(Statistic.class, "LEAVE_GAME");

    public static final Statistic MINECART_ONE_CM = DummyObjectProvider.createFor(Statistic.class, "MINECART_ONE_CM");

    public static final Statistic MOB_KILLS = DummyObjectProvider.createFor(Statistic.class, "MOB_KILLS");

    public static final Statistic NOTEBLOCK_PLAYED = DummyObjectProvider.createFor(Statistic.class, "NOTEBLOCK_PLAYED");

    public static final Statistic NOTEBLOCK_TUNED = DummyObjectProvider.createFor(Statistic.class, "NOTEBLOCK_TUNED");

    public static final Statistic OPEN_SHULKER_BOX = DummyObjectProvider.createFor(Statistic.class, "OPEN_SHULKER_BOX");

    public static final Statistic PIG_ONE_CM = DummyObjectProvider.createFor(Statistic.class, "PIG_ONE_CM");

    public static final Statistic PLAYER_KILLS = DummyObjectProvider.createFor(Statistic.class, "PLAYER_KILLS");

    public static final Statistic RECORD_PLAYED = DummyObjectProvider.createFor(Statistic.class, "RECORD_PLAYED");

    public static final Statistic SLEEP_IN_BED = DummyObjectProvider.createFor(Statistic.class, "SLEEP_IN_BED");

    public static final Statistic SNEAK_TIME = DummyObjectProvider.createFor(Statistic.class, "SNEAK_TIME");

    public static final Statistic SPRINT_ONE_CM = DummyObjectProvider.createFor(Statistic.class, "SPRINT_ONE_CM");

    public static final Statistic SWIM_ONE_CM = DummyObjectProvider.createFor(Statistic.class, "SWIM_ONE_CM");

    public static final Statistic TALKED_TO_VILLAGER = DummyObjectProvider.createFor(Statistic.class, "TALKED_TO_VILLAGER");

    public static final Statistic TIME_PLAYED = DummyObjectProvider.createFor(Statistic.class, "TIME_PLAYED");

    public static final Statistic TIME_SINCE_DEATH = DummyObjectProvider.createFor(Statistic.class, "TIME_SINCE_DEATH");

    public static final Statistic TRADED_WITH_VILLAGER = DummyObjectProvider.createFor(Statistic.class, "TRADED_WITH_VILLAGER");

    public static final Statistic TRAPPED_CHEST_TRIGGERED = DummyObjectProvider.createFor(Statistic.class, "TRAPPED_CHEST_TRIGGERED");

    public static final Statistic WALK_ONE_CM = DummyObjectProvider.createFor(Statistic.class, "WALK_ONE_CM");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private Statistics() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
