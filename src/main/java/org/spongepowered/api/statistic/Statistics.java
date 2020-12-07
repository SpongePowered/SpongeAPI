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

    public static final Supplier<Statistic> AVIATE_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "aviate_one_cm");

    public static final Supplier<Statistic> BELL_RING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "bell_ring");

    public static final Supplier<Statistic> BOAT_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "boat_one_cm");

    public static final Supplier<Statistic> CLEAN_ARMOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "clean_armor");

    public static final Supplier<Statistic> CLEAN_BANNER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "clean_banner");

    public static final Supplier<Statistic> CLEAN_SHULKER_BOX = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "clean_shulker_box");

    public static final Supplier<Statistic> CLIMB_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "climb_one_cm");

    public static final Supplier<Statistic> CROUCH_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "crouch_one_cm");

    public static final Supplier<Statistic> DAMAGE_ABSORBED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "damage_absorbed");

    public static final Supplier<Statistic> DAMAGE_BLOCKED_BY_SHIELD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "damage_blocked_by_shield");

    public static final Supplier<Statistic> DAMAGE_DEALT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "damage_dealt");

    public static final Supplier<Statistic> DAMAGE_DEALT_ABSORBED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "damage_dealt_absorbed");

    public static final Supplier<Statistic> DAMAGE_DEALT_RESISTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "damage_dealt_resisted");

    public static final Supplier<Statistic> DAMAGE_RESISTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "damage_resisted");

    public static final Supplier<Statistic> DAMAGE_TAKEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "damage_taken");

    public static final Supplier<Statistic> DEATHS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "deaths");

    public static final Supplier<Statistic> DROP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "drop");

    public static final Supplier<Statistic> EAT_CAKE_SLICE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "eat_cake_slice");

    public static final Supplier<Statistic> ENCHANT_ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "enchant_item");

    public static final Supplier<Statistic> FALL_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "fall_one_cm");

    public static final Supplier<Statistic> FILL_CAULDRON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "fill_cauldron");

    public static final Supplier<Statistic> FISH_CAUGHT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "fish_caught");

    public static final Supplier<Statistic> FLY_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "fly_one_cm");

    public static final Supplier<Statistic> HORSE_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "horse_one_cm");

    public static final Supplier<Statistic> INSPECT_DISPENSER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "inspect_dispenser");

    public static final Supplier<Statistic> INSPECT_DROPPER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "inspect_dropper");

    public static final Supplier<Statistic> INSPECT_HOPPER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "inspect_hopper");

    public static final Supplier<Statistic> INTERACT_WITH_ANVIL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "interact_with_anvil");

    public static final Supplier<Statistic> INTERACT_WITH_BEACON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "interact_with_beacon");

    public static final Supplier<Statistic> INTERACT_WITH_BLAST_FURNACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "interact_with_blast_furnace");

    public static final Supplier<Statistic> INTERACT_WITH_BREWINGSTAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "interact_with_brewingstand");

    public static final Supplier<Statistic> INTERACT_WITH_CAMPFIRE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "interact_with_campfire");

    public static final Supplier<Statistic> INTERACT_WITH_CARTOGRAPHY_TABLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "interact_with_cartography_table");

    public static final Supplier<Statistic> INTERACT_WITH_CRAFTING_TABLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "interact_with_crafting_table");

    public static final Supplier<Statistic> INTERACT_WITH_FURNACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "interact_with_furnace");

    public static final Supplier<Statistic> INTERACT_WITH_GRINDSTONE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "interact_with_grindstone");

    public static final Supplier<Statistic> INTERACT_WITH_LECTERN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "interact_with_lectern");

    public static final Supplier<Statistic> INTERACT_WITH_LOOM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "interact_with_loom");

    public static final Supplier<Statistic> INTERACT_WITH_SMITHING_TABLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "interact_with_smithing_table");

    public static final Supplier<Statistic> INTERACT_WITH_SMOKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "interact_with_smoker");

    public static final Supplier<Statistic> INTERACT_WITH_STONECUTTER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "interact_with_stonecutter");

    public static final Supplier<Statistic> JUMP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "jump");

    public static final Supplier<Statistic> LEAVE_GAME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "leave_game");

    public static final Supplier<Statistic> MINECART_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "minecart_one_cm");

    public static final Supplier<Statistic> MOB_KILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "mob_kills");

    public static final Supplier<Statistic> OPEN_BARREL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "open_barrel");

    public static final Supplier<Statistic> OPEN_CHEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "open_chest");

    public static final Supplier<Statistic> OPEN_ENDERCHEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "open_enderchest");

    public static final Supplier<Statistic> OPEN_SHULKER_BOX = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "open_shulker_box");

    public static final Supplier<Statistic> PIG_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "pig_one_cm");

    public static final Supplier<Statistic> PLAY_NOTEBLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "play_noteblock");

    public static final Supplier<Statistic> PLAY_ONE_MINUTE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "play_one_minute");

    public static final Supplier<Statistic> PLAY_RECORD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "play_record");

    public static final Supplier<Statistic> PLAYER_KILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "player_kills");

    public static final Supplier<Statistic> POT_FLOWER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "pot_flower");

    public static final Supplier<Statistic> RAID_TRIGGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "raid_trigger");

    public static final Supplier<Statistic> RAID_WIN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "raid_win");

    public static final Supplier<Statistic> SLEEP_IN_BED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "sleep_in_bed");

    public static final Supplier<Statistic> SNEAK_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "sneak_time");

    public static final Supplier<Statistic> SPRINT_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "sprint_one_cm");

    public static final Supplier<Statistic> STRIDER_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "strider_one_cm");

    public static final Supplier<Statistic> SWIM_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "swim_one_cm");

    public static final Supplier<Statistic> TALKED_TO_VILLAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "talked_to_villager");

    public static final Supplier<Statistic> TARGET_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "target_hit");

    public static final Supplier<Statistic> TIME_SINCE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "time_since_death");

    public static final Supplier<Statistic> TIME_SINCE_REST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "time_since_rest");

    public static final Supplier<Statistic> TRADED_WITH_VILLAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "traded_with_villager");

    public static final Supplier<Statistic> TRIGGER_TRAPPED_CHEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "trigger_trapped_chest");

    public static final Supplier<Statistic> TUNE_NOTEBLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "tune_noteblock");

    public static final Supplier<Statistic> USE_CAULDRON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "use_cauldron");

    public static final Supplier<Statistic> WALK_ON_WATER_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "walk_on_water_one_cm");

    public static final Supplier<Statistic> WALK_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "walk_one_cm");

    public static final Supplier<Statistic> WALK_UNDER_WATER_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "walk_under_water_one_cm");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private Statistics() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
