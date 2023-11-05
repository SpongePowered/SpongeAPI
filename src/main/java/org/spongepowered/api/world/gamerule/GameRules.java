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
package org.spongepowered.api.world.gamerule;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registry;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

/**
 * An enumeration of all the possible game rules in vanilla minecraft.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class GameRules {

    // @formatter:off
    // SORTFIELDS:ON
    public static final DefaultedRegistryReference<GameRule<Boolean>> ANNOUNCE_ADVANCEMENTS = GameRules.key(ResourceKey.sponge("announce_advancements"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> BLOCK_EXPLOSION_DROP_DECAY = GameRules.key(ResourceKey.sponge("block_explosion_drop_decay"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> COMMAND_BLOCK_OUTPUT = GameRules.key(ResourceKey.sponge("command_block_output"));

    public static final DefaultedRegistryReference<GameRule<Integer>> COMMAND_MODIFICATION_BLOCK_LIMIT = GameRules.key(ResourceKey.sponge("command_modification_block_limit"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> DISABLE_ELYTRA_MOVEMENT_CHECK = GameRules.key(ResourceKey.sponge("disable_elytra_movement_check"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> DISABLE_RAIDS = GameRules.key(ResourceKey.sponge("disable_raids"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> DO_DAYLIGHT_CYCLE = GameRules.key(ResourceKey.sponge("do_daylight_cycle"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> DO_ENTITY_DROPS = GameRules.key(ResourceKey.sponge("do_entity_drops"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> DO_FIRE_TICK = GameRules.key(ResourceKey.sponge("do_fire_tick"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> DO_IMMEDIATE_RESPAWN = GameRules.key(ResourceKey.sponge("do_immediate_respawn"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> DO_INSOMNIA = GameRules.key(ResourceKey.sponge("do_insomnia"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> DO_LIMITED_CRAFTING = GameRules.key(ResourceKey.sponge("do_limited_crafting"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> DO_MOB_LOOT = GameRules.key(ResourceKey.sponge("do_mob_loot"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> DO_MOB_SPAWNING = GameRules.key(ResourceKey.sponge("do_mob_spawning"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> DO_PATROL_SPAWNING = GameRules.key(ResourceKey.sponge("do_patrol_spawning"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> DO_TILE_DROPS = GameRules.key(ResourceKey.sponge("do_tile_drops"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> DO_TRADER_SPAWNING = GameRules.key(ResourceKey.sponge("do_trader_spawning"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> DO_VINES_SPREAD = GameRules.key(ResourceKey.sponge("do_vines_spread"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> DO_WARDEN_SPAWNING = GameRules.key(ResourceKey.sponge("do_warden_spawning"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> DO_WEATHER_CYCLE = GameRules.key(ResourceKey.sponge("do_weather_cycle"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> DROWNING_DAMAGE = GameRules.key(ResourceKey.sponge("drowning_damage"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> ENDER_PEARLS_VANISH_ON_DEATH = GameRules.key(ResourceKey.sponge("ender_pearls_vanish_on_death"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> FALL_DAMAGE = GameRules.key(ResourceKey.sponge("fall_damage"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> FIRE_DAMAGE = GameRules.key(ResourceKey.sponge("fire_damage"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> FORGIVE_DEAD_PLAYERS = GameRules.key(ResourceKey.sponge("forgive_dead_players"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> FREEZE_DAMAGE = GameRules.key(ResourceKey.sponge("freeze_damage"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> GLOBAL_SOUND_EVENTS = GameRules.key(ResourceKey.sponge("global_sound_events"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> KEEP_INVENTORY = GameRules.key(ResourceKey.sponge("keep_inventory"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> LAVA_SOURCE_CONVERSION = GameRules.key(ResourceKey.sponge("lava_source_conversion"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> LOG_ADMIN_COMMANDS = GameRules.key(ResourceKey.sponge("log_admin_commands"));

    public static final DefaultedRegistryReference<GameRule<Integer>> MAX_COMMAND_CHAIN_LENGTH = GameRules.key(ResourceKey.sponge("max_command_chain_length"));

    public static final DefaultedRegistryReference<GameRule<Integer>> MAX_ENTITY_CRAMMING = GameRules.key(ResourceKey.sponge("max_entity_cramming"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> MOB_EXPLOSION_DROP_DECAY = GameRules.key(ResourceKey.sponge("mob_explosion_drop_decay"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> MOB_GRIEFING = GameRules.key(ResourceKey.sponge("mob_griefing"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> NATURAL_REGENERATION = GameRules.key(ResourceKey.sponge("natural_regeneration"));

    public static final DefaultedRegistryReference<GameRule<Integer>> PLAYERS_SLEEPING_PERCENTAGE = GameRules.key(ResourceKey.sponge("players_sleeping_percentage"));

    public static final DefaultedRegistryReference<GameRule<Integer>> RANDOM_TICK_SPEED = GameRules.key(ResourceKey.sponge("random_tick_speed"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> REDUCED_DEBUG_INFO = GameRules.key(ResourceKey.sponge("reduced_debug_info"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> SEND_COMMAND_FEEDBACK = GameRules.key(ResourceKey.sponge("send_command_feedback"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> SHOW_DEATH_MESSAGES = GameRules.key(ResourceKey.sponge("show_death_messages"));

    public static final DefaultedRegistryReference<GameRule<Integer>> SNOW_ACCUMULATION_HEIGHT = GameRules.key(ResourceKey.sponge("snow_accumulation_height"));

    public static final DefaultedRegistryReference<GameRule<Integer>> SPAWN_RADIUS = GameRules.key(ResourceKey.sponge("spawn_radius"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> SPECTATORS_GENERATE_CHUNKS = GameRules.key(ResourceKey.sponge("spectators_generate_chunks"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> TNT_EXPLOSION_DROP_DECAY = GameRules.key(ResourceKey.sponge("tnt_explosion_drop_decay"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> UNIVERSAL_ANGER = GameRules.key(ResourceKey.sponge("universal_anger"));

    public static final DefaultedRegistryReference<GameRule<Boolean>> WATER_SOURCE_CONVERSION = GameRules.key(ResourceKey.sponge("water_source_conversion"));

    // SORTFIELDS:OFF
    // @formatter:on
    private GameRules() {
    }

    public static Registry<GameRule<?>> registry() {
        return Sponge.game().registry(RegistryTypes.GAME_RULE);
    }

    private static <T> DefaultedRegistryReference<GameRule<T>> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.GAME_RULE, location).asDefaultedReference(Sponge::game);
    }
}
