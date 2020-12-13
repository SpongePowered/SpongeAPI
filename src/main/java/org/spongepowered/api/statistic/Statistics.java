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

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registries;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

/**
 * An enumeration of all available {@link Statistic}s from the vanilla game.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class Statistics {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<Statistic> ANIMALS_BRED = Statistics.key(ResourceKey.sponge("animals_bred"));

    public static final DefaultedRegistryReference<Statistic> AVIATE_ONE_CM = Statistics.key(ResourceKey.sponge("aviate_one_cm"));

    public static final DefaultedRegistryReference<Statistic> BELL_RING = Statistics.key(ResourceKey.sponge("bell_ring"));

    public static final DefaultedRegistryReference<Statistic> BOAT_ONE_CM = Statistics.key(ResourceKey.sponge("boat_one_cm"));

    public static final DefaultedRegistryReference<Statistic> CLEAN_ARMOR = Statistics.key(ResourceKey.sponge("clean_armor"));

    public static final DefaultedRegistryReference<Statistic> CLEAN_BANNER = Statistics.key(ResourceKey.sponge("clean_banner"));

    public static final DefaultedRegistryReference<Statistic> CLEAN_SHULKER_BOX = Statistics.key(ResourceKey.sponge("clean_shulker_box"));

    public static final DefaultedRegistryReference<Statistic> CLIMB_ONE_CM = Statistics.key(ResourceKey.sponge("climb_one_cm"));

    public static final DefaultedRegistryReference<Statistic> CROUCH_ONE_CM = Statistics.key(ResourceKey.sponge("crouch_one_cm"));

    public static final DefaultedRegistryReference<Statistic> DAMAGE_ABSORBED = Statistics.key(ResourceKey.sponge("damage_absorbed"));

    public static final DefaultedRegistryReference<Statistic> DAMAGE_BLOCKED_BY_SHIELD = Statistics.key(ResourceKey.sponge("damage_blocked_by_shield"));

    public static final DefaultedRegistryReference<Statistic> DAMAGE_DEALT = Statistics.key(ResourceKey.sponge("damage_dealt"));

    public static final DefaultedRegistryReference<Statistic> DAMAGE_DEALT_ABSORBED = Statistics.key(ResourceKey.sponge("damage_dealt_absorbed"));

    public static final DefaultedRegistryReference<Statistic> DAMAGE_DEALT_RESISTED = Statistics.key(ResourceKey.sponge("damage_dealt_resisted"));

    public static final DefaultedRegistryReference<Statistic> DAMAGE_RESISTED = Statistics.key(ResourceKey.sponge("damage_resisted"));

    public static final DefaultedRegistryReference<Statistic> DAMAGE_TAKEN = Statistics.key(ResourceKey.sponge("damage_taken"));

    public static final DefaultedRegistryReference<Statistic> DEATHS = Statistics.key(ResourceKey.sponge("deaths"));

    public static final DefaultedRegistryReference<Statistic> DROP = Statistics.key(ResourceKey.sponge("drop"));

    public static final DefaultedRegistryReference<Statistic> EAT_CAKE_SLICE = Statistics.key(ResourceKey.sponge("eat_cake_slice"));

    public static final DefaultedRegistryReference<Statistic> ENCHANT_ITEM = Statistics.key(ResourceKey.sponge("enchant_item"));

    public static final DefaultedRegistryReference<Statistic> FALL_ONE_CM = Statistics.key(ResourceKey.sponge("fall_one_cm"));

    public static final DefaultedRegistryReference<Statistic> FILL_CAULDRON = Statistics.key(ResourceKey.sponge("fill_cauldron"));

    public static final DefaultedRegistryReference<Statistic> FISH_CAUGHT = Statistics.key(ResourceKey.sponge("fish_caught"));

    public static final DefaultedRegistryReference<Statistic> FLY_ONE_CM = Statistics.key(ResourceKey.sponge("fly_one_cm"));

    public static final DefaultedRegistryReference<Statistic> HORSE_ONE_CM = Statistics.key(ResourceKey.sponge("horse_one_cm"));

    public static final DefaultedRegistryReference<Statistic> INSPECT_DISPENSER = Statistics.key(ResourceKey.sponge("inspect_dispenser"));

    public static final DefaultedRegistryReference<Statistic> INSPECT_DROPPER = Statistics.key(ResourceKey.sponge("inspect_dropper"));

    public static final DefaultedRegistryReference<Statistic> INSPECT_HOPPER = Statistics.key(ResourceKey.sponge("inspect_hopper"));

    public static final DefaultedRegistryReference<Statistic> INTERACT_WITH_ANVIL = Statistics.key(ResourceKey.sponge("interact_with_anvil"));

    public static final DefaultedRegistryReference<Statistic> INTERACT_WITH_BEACON = Statistics.key(ResourceKey.sponge("interact_with_beacon"));

    public static final DefaultedRegistryReference<Statistic> INTERACT_WITH_BLAST_FURNACE = Statistics.key(ResourceKey.sponge("interact_with_blast_furnace"));

    public static final DefaultedRegistryReference<Statistic> INTERACT_WITH_BREWINGSTAND = Statistics.key(ResourceKey.sponge("interact_with_brewingstand"));

    public static final DefaultedRegistryReference<Statistic> INTERACT_WITH_CAMPFIRE = Statistics.key(ResourceKey.sponge("interact_with_campfire"));

    public static final DefaultedRegistryReference<Statistic> INTERACT_WITH_CARTOGRAPHY_TABLE = Statistics.key(ResourceKey.sponge("interact_with_cartography_table"));

    public static final DefaultedRegistryReference<Statistic> INTERACT_WITH_CRAFTING_TABLE = Statistics.key(ResourceKey.sponge("interact_with_crafting_table"));

    public static final DefaultedRegistryReference<Statistic> INTERACT_WITH_FURNACE = Statistics.key(ResourceKey.sponge("interact_with_furnace"));

    public static final DefaultedRegistryReference<Statistic> INTERACT_WITH_GRINDSTONE = Statistics.key(ResourceKey.sponge("interact_with_grindstone"));

    public static final DefaultedRegistryReference<Statistic> INTERACT_WITH_LECTERN = Statistics.key(ResourceKey.sponge("interact_with_lectern"));

    public static final DefaultedRegistryReference<Statistic> INTERACT_WITH_LOOM = Statistics.key(ResourceKey.sponge("interact_with_loom"));

    public static final DefaultedRegistryReference<Statistic> INTERACT_WITH_SMITHING_TABLE = Statistics.key(ResourceKey.sponge("interact_with_smithing_table"));

    public static final DefaultedRegistryReference<Statistic> INTERACT_WITH_SMOKER = Statistics.key(ResourceKey.sponge("interact_with_smoker"));

    public static final DefaultedRegistryReference<Statistic> INTERACT_WITH_STONECUTTER = Statistics.key(ResourceKey.sponge("interact_with_stonecutter"));

    public static final DefaultedRegistryReference<Statistic> JUMP = Statistics.key(ResourceKey.sponge("jump"));

    public static final DefaultedRegistryReference<Statistic> LEAVE_GAME = Statistics.key(ResourceKey.sponge("leave_game"));

    public static final DefaultedRegistryReference<Statistic> MINECART_ONE_CM = Statistics.key(ResourceKey.sponge("minecart_one_cm"));

    public static final DefaultedRegistryReference<Statistic> MOB_KILLS = Statistics.key(ResourceKey.sponge("mob_kills"));

    public static final DefaultedRegistryReference<Statistic> OPEN_BARREL = Statistics.key(ResourceKey.sponge("open_barrel"));

    public static final DefaultedRegistryReference<Statistic> OPEN_CHEST = Statistics.key(ResourceKey.sponge("open_chest"));

    public static final DefaultedRegistryReference<Statistic> OPEN_ENDERCHEST = Statistics.key(ResourceKey.sponge("open_enderchest"));

    public static final DefaultedRegistryReference<Statistic> OPEN_SHULKER_BOX = Statistics.key(ResourceKey.sponge("open_shulker_box"));

    public static final DefaultedRegistryReference<Statistic> PIG_ONE_CM = Statistics.key(ResourceKey.sponge("pig_one_cm"));

    public static final DefaultedRegistryReference<Statistic> PLAY_NOTEBLOCK = Statistics.key(ResourceKey.sponge("play_noteblock"));

    public static final DefaultedRegistryReference<Statistic> PLAY_ONE_MINUTE = Statistics.key(ResourceKey.sponge("play_one_minute"));

    public static final DefaultedRegistryReference<Statistic> PLAY_RECORD = Statistics.key(ResourceKey.sponge("play_record"));

    public static final DefaultedRegistryReference<Statistic> PLAYER_KILLS = Statistics.key(ResourceKey.sponge("player_kills"));

    public static final DefaultedRegistryReference<Statistic> POT_FLOWER = Statistics.key(ResourceKey.sponge("pot_flower"));

    public static final DefaultedRegistryReference<Statistic> RAID_TRIGGER = Statistics.key(ResourceKey.sponge("raid_trigger"));

    public static final DefaultedRegistryReference<Statistic> RAID_WIN = Statistics.key(ResourceKey.sponge("raid_win"));

    public static final DefaultedRegistryReference<Statistic> SLEEP_IN_BED = Statistics.key(ResourceKey.sponge("sleep_in_bed"));

    public static final DefaultedRegistryReference<Statistic> SNEAK_TIME = Statistics.key(ResourceKey.sponge("sneak_time"));

    public static final DefaultedRegistryReference<Statistic> SPRINT_ONE_CM = Statistics.key(ResourceKey.sponge("sprint_one_cm"));

    public static final DefaultedRegistryReference<Statistic> STRIDER_ONE_CM = Statistics.key(ResourceKey.sponge("strider_one_cm"));

    public static final DefaultedRegistryReference<Statistic> SWIM_ONE_CM = Statistics.key(ResourceKey.sponge("swim_one_cm"));

    public static final DefaultedRegistryReference<Statistic> TALKED_TO_VILLAGER = Statistics.key(ResourceKey.sponge("talked_to_villager"));

    public static final DefaultedRegistryReference<Statistic> TARGET_HIT = Statistics.key(ResourceKey.sponge("target_hit"));

    public static final DefaultedRegistryReference<Statistic> TIME_SINCE_DEATH = Statistics.key(ResourceKey.sponge("time_since_death"));

    public static final DefaultedRegistryReference<Statistic> TIME_SINCE_REST = Statistics.key(ResourceKey.sponge("time_since_rest"));

    public static final DefaultedRegistryReference<Statistic> TRADED_WITH_VILLAGER = Statistics.key(ResourceKey.sponge("traded_with_villager"));

    public static final DefaultedRegistryReference<Statistic> TRIGGER_TRAPPED_CHEST = Statistics.key(ResourceKey.sponge("trigger_trapped_chest"));

    public static final DefaultedRegistryReference<Statistic> TUNE_NOTEBLOCK = Statistics.key(ResourceKey.sponge("tune_noteblock"));

    public static final DefaultedRegistryReference<Statistic> USE_CAULDRON = Statistics.key(ResourceKey.sponge("use_cauldron"));

    public static final DefaultedRegistryReference<Statistic> WALK_ON_WATER_ONE_CM = Statistics.key(ResourceKey.sponge("walk_on_water_one_cm"));

    public static final DefaultedRegistryReference<Statistic> WALK_ONE_CM = Statistics.key(ResourceKey.sponge("walk_one_cm"));

    public static final DefaultedRegistryReference<Statistic> WALK_UNDER_WATER_ONE_CM = Statistics.key(ResourceKey.sponge("walk_under_water_one_cm"));

    // SORTFIELDS:OFF

    // @formatter:on

    private Statistics() {
    }

    private static DefaultedRegistryReference<Statistic> key(final ResourceKey location) {
        return RegistryKey.<Statistic>of(Registries.STATISTIC.registry(), location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
