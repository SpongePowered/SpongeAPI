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

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

/**
 * An enumeration of all available {@link Statistic}s from the vanilla game.
 */
public final class Statistics {

    // SORTFIELDS:ON

    public static final Supplier<Statistic> ANIMALS_BRED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "animals_bred");

    public static final Supplier<Statistic> ARMOR_CLEANED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "armor_cleaned");

    public static final Supplier<Statistic> AVIATE_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "aviate_one_cm");

    public static final Supplier<Statistic> BANNER_CLEANED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "banner_cleaned");

    public static final Supplier<Statistic> BEACON_INTERACTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "beacon_interaction");

    public static final Supplier<Statistic> BOAT_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "boat_one_cm");

    public static final Supplier<Statistic> BREWINGSTAND_INTERACTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "brewingstand_interaction");

    public static final Supplier<Statistic> CAKE_SLICES_EATEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "cake_slices_eaten");

    public static final Supplier<Statistic> CAULDRON_FILLED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "cauldron_filled");

    public static final Supplier<Statistic> CAULDRON_USED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "cauldron_used");

    public static final Supplier<Statistic> CHEST_OPENED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "chest_opened");

    public static final Supplier<Statistic> CLIMB_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "climb_one_cm");

    public static final Supplier<Statistic> CRAFTING_TABLE_INTERACTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "crafting_table_interaction");

    public static final Supplier<Statistic> CROUCH_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "crouch_one_cm");

    public static final Supplier<Statistic> DAMAGE_DEALT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "damage_dealt");

    public static final Supplier<Statistic> DAMAGE_TAKEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "damage_taken");

    public static final Supplier<Statistic> DEATHS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "deaths");

    public static final Supplier<Statistic> DISPENSER_INSPECTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "dispenser_inspected");

    public static final Supplier<Statistic> DIVE_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "dive_one_cm");

    public static final Supplier<Statistic> DROP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "drop");

    public static final Supplier<Statistic> DROPPER_INSPECTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "dropper_inspected");

    public static final Supplier<Statistic> ENDERCHEST_OPENED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "enderchest_opened");

    public static final Supplier<Statistic> FALL_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "fall_one_cm");

    public static final Supplier<Statistic> FISH_CAUGHT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "fish_caught");

    public static final Supplier<Statistic> FLOWER_POTTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "flower_potted");

    public static final Supplier<Statistic> FURNACE_INTERACTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "furnace_interaction");

    public static final Supplier<Statistic> HOPPER_INSPECTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "hopper_inspected");

    public static final Supplier<Statistic> HORSE_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "horse_one_cm");

    public static final Supplier<Statistic> ITEM_ENCHANTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "item_enchanted");

    public static final Supplier<Statistic> JUMP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "jump");

    public static final Supplier<Statistic> LEAVE_GAME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "leave_game");

    public static final Supplier<Statistic> MINECART_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "minecart_one_cm");

    public static final Supplier<Statistic> MOB_KILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "mob_kills");

    public static final Supplier<Statistic> NOTEBLOCK_PLAYED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "noteblock_played");

    public static final Supplier<Statistic> NOTEBLOCK_TUNED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "noteblock_tuned");

    public static final Supplier<Statistic> OPEN_SHULKER_BOX = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "open_shulker_box");

    public static final Supplier<Statistic> PIG_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "pig_one_cm");

    public static final Supplier<Statistic> PLAYER_KILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "player_kills");

    public static final Supplier<Statistic> RECORD_PLAYED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "record_played");

    public static final Supplier<Statistic> SLEEP_IN_BED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "sleep_in_bed");

    public static final Supplier<Statistic> SNEAK_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "sneak_time");

    public static final Supplier<Statistic> SPRINT_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "sprint_one_cm");

    public static final Supplier<Statistic> SWIM_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "swim_one_cm");

    public static final Supplier<Statistic> TALKED_TO_VILLAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "talked_to_villager");

    public static final Supplier<Statistic> TIME_PLAYED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "time_played");

    public static final Supplier<Statistic> TIME_SINCE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "time_since_death");

    public static final Supplier<Statistic> TRADED_WITH_VILLAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "traded_with_villager");

    public static final Supplier<Statistic> TRAPPED_CHEST_TRIGGERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "trapped_chest_triggered");

    public static final Supplier<Statistic> WALK_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "walk_one_cm");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private Statistics() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
