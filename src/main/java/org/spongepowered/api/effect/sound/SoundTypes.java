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
package org.spongepowered.api.effect.sound;

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

/**
 * An enumeration of vanilla {@link SoundType}s.
 */
public final class SoundTypes {

    // SORTFIELDS:ON

    public static final Supplier<SoundType> AMBIENT_CAVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient_cave");

    public static final Supplier<SoundType> AMBIENT_UNDERWATER_ENTER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient_underwater_enter");

    public static final Supplier<SoundType> AMBIENT_UNDERWATER_EXIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient_underwater_exit");

    public static final Supplier<SoundType> AMBIENT_UNDERWATER_LOOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient_underwater_loop");

    public static final Supplier<SoundType> AMBIENT_UNDERWATER_LOOP_ADDITIONS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient_underwater_loop_additions");

    public static final Supplier<SoundType> AMBIENT_UNDERWATER_LOOP_ADDITIONS_RARE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient_underwater_loop_additions_rare");

    public static final Supplier<SoundType> AMBIENT_UNDERWATER_LOOP_ADDITIONS_ULTRA_RARE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient_underwater_loop_additions_ultra_rare");

    public static final Supplier<SoundType> BLOCK_ANVIL_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_anvil_break");

    public static final Supplier<SoundType> BLOCK_ANVIL_DESTROY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_anvil_destroy");

    public static final Supplier<SoundType> BLOCK_ANVIL_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_anvil_fall");

    public static final Supplier<SoundType> BLOCK_ANVIL_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_anvil_hit");

    public static final Supplier<SoundType> BLOCK_ANVIL_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_anvil_land");

    public static final Supplier<SoundType> BLOCK_ANVIL_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_anvil_place");

    public static final Supplier<SoundType> BLOCK_ANVIL_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_anvil_step");

    public static final Supplier<SoundType> BLOCK_ANVIL_USE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_anvil_use");

    public static final Supplier<SoundType> BLOCK_BAMBOO_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_bamboo_break");

    public static final Supplier<SoundType> BLOCK_BAMBOO_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_bamboo_fall");

    public static final Supplier<SoundType> BLOCK_BAMBOO_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_bamboo_hit");

    public static final Supplier<SoundType> BLOCK_BAMBOO_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_bamboo_place");

    public static final Supplier<SoundType> BLOCK_BAMBOO_SAPLING_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_bamboo_sapling_break");

    public static final Supplier<SoundType> BLOCK_BAMBOO_SAPLING_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_bamboo_sapling_hit");

    public static final Supplier<SoundType> BLOCK_BAMBOO_SAPLING_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_bamboo_sapling_place");

    public static final Supplier<SoundType> BLOCK_BAMBOO_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_bamboo_step");

    public static final Supplier<SoundType> BLOCK_BARREL_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_barrel_close");

    public static final Supplier<SoundType> BLOCK_BARREL_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_barrel_open");

    public static final Supplier<SoundType> BLOCK_BEACON_ACTIVATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_beacon_activate");

    public static final Supplier<SoundType> BLOCK_BEACON_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_beacon_ambient");

    public static final Supplier<SoundType> BLOCK_BEACON_DEACTIVATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_beacon_deactivate");

    public static final Supplier<SoundType> BLOCK_BEACON_POWER_SELECT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_beacon_power_select");

    public static final Supplier<SoundType> BLOCK_BEEHIVE_DROP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_beehive_drop");

    public static final Supplier<SoundType> BLOCK_BEEHIVE_ENTER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_beehive_enter");

    public static final Supplier<SoundType> BLOCK_BEEHIVE_EXIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_beehive_exit");

    public static final Supplier<SoundType> BLOCK_BEEHIVE_SHEAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_beehive_shear");

    public static final Supplier<SoundType> BLOCK_BEEHIVE_WORK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_beehive_work");

    public static final Supplier<SoundType> BLOCK_BELL_RESONATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_bell_resonate");

    public static final Supplier<SoundType> BLOCK_BELL_USE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_bell_use");

    public static final Supplier<SoundType> BLOCK_BLASTFURNACE_FIRE_CRACKLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_blastfurnace_fire_crackle");

    public static final Supplier<SoundType> BLOCK_BREWING_STAND_BREW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_brewing_stand_brew");

    public static final Supplier<SoundType> BLOCK_BUBBLE_COLUMN_BUBBLE_POP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_bubble_column_bubble_pop");

    public static final Supplier<SoundType> BLOCK_BUBBLE_COLUMN_UPWARDS_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_bubble_column_upwards_ambient");

    public static final Supplier<SoundType> BLOCK_BUBBLE_COLUMN_UPWARDS_INSIDE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_bubble_column_upwards_inside");

    public static final Supplier<SoundType> BLOCK_BUBBLE_COLUMN_WHIRLPOOL_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_bubble_column_whirlpool_ambient");

    public static final Supplier<SoundType> BLOCK_BUBBLE_COLUMN_WHIRLPOOL_INSIDE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_bubble_column_whirlpool_inside");

    public static final Supplier<SoundType> BLOCK_CAMPFIRE_CRACKLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_campfire_crackle");

    public static final Supplier<SoundType> BLOCK_CHEST_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_chest_close");

    public static final Supplier<SoundType> BLOCK_CHEST_LOCKED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_chest_locked");

    public static final Supplier<SoundType> BLOCK_CHEST_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_chest_open");

    public static final Supplier<SoundType> BLOCK_CHORUS_FLOWER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_chorus_flower_death");

    public static final Supplier<SoundType> BLOCK_CHORUS_FLOWER_GROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_chorus_flower_grow");

    public static final Supplier<SoundType> BLOCK_COMPARATOR_CLICK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_comparator_click");

    public static final Supplier<SoundType> BLOCK_COMPOSTER_EMPTY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_composter_empty");

    public static final Supplier<SoundType> BLOCK_COMPOSTER_FILL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_composter_fill");

    public static final Supplier<SoundType> BLOCK_COMPOSTER_FILL_SUCCESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_composter_fill_success");

    public static final Supplier<SoundType> BLOCK_COMPOSTER_READY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_composter_ready");

    public static final Supplier<SoundType> BLOCK_CONDUIT_ACTIVATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_conduit_activate");

    public static final Supplier<SoundType> BLOCK_CONDUIT_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_conduit_ambient");

    public static final Supplier<SoundType> BLOCK_CONDUIT_AMBIENT_SHORT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_conduit_ambient_short");

    public static final Supplier<SoundType> BLOCK_CONDUIT_ATTACK_TARGET = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_conduit_attack_target");

    public static final Supplier<SoundType> BLOCK_CONDUIT_DEACTIVATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_conduit_deactivate");

    public static final Supplier<SoundType> BLOCK_CORAL_BLOCK_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_coral_block_break");

    public static final Supplier<SoundType> BLOCK_CORAL_BLOCK_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_coral_block_fall");

    public static final Supplier<SoundType> BLOCK_CORAL_BLOCK_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_coral_block_hit");

    public static final Supplier<SoundType> BLOCK_CORAL_BLOCK_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_coral_block_place");

    public static final Supplier<SoundType> BLOCK_CORAL_BLOCK_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_coral_block_step");

    public static final Supplier<SoundType> BLOCK_CROP_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_crop_break");

    public static final Supplier<SoundType> BLOCK_DISPENSER_DISPENSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_dispenser_dispense");

    public static final Supplier<SoundType> BLOCK_DISPENSER_FAIL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_dispenser_fail");

    public static final Supplier<SoundType> BLOCK_DISPENSER_LAUNCH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_dispenser_launch");

    public static final Supplier<SoundType> BLOCK_ENCHANTMENT_TABLE_USE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_enchantment_table_use");

    public static final Supplier<SoundType> BLOCK_ENDER_CHEST_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_ender_chest_close");

    public static final Supplier<SoundType> BLOCK_ENDER_CHEST_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_ender_chest_open");

    public static final Supplier<SoundType> BLOCK_END_GATEWAY_SPAWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_end_gateway_spawn");

    public static final Supplier<SoundType> BLOCK_END_PORTAL_FRAME_FILL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_end_portal_frame_fill");

    public static final Supplier<SoundType> BLOCK_END_PORTAL_SPAWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_end_portal_spawn");

    public static final Supplier<SoundType> BLOCK_FENCE_GATE_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_fence_gate_close");

    public static final Supplier<SoundType> BLOCK_FENCE_GATE_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_fence_gate_open");

    public static final Supplier<SoundType> BLOCK_FIRE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_fire_ambient");

    public static final Supplier<SoundType> BLOCK_FIRE_EXTINGUISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_fire_extinguish");

    public static final Supplier<SoundType> BLOCK_FURNACE_FIRE_CRACKLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_furnace_fire_crackle");

    public static final Supplier<SoundType> BLOCK_GLASS_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_glass_break");

    public static final Supplier<SoundType> BLOCK_GLASS_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_glass_fall");

    public static final Supplier<SoundType> BLOCK_GLASS_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_glass_hit");

    public static final Supplier<SoundType> BLOCK_GLASS_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_glass_place");

    public static final Supplier<SoundType> BLOCK_GLASS_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_glass_step");

    public static final Supplier<SoundType> BLOCK_GRASS_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_grass_break");

    public static final Supplier<SoundType> BLOCK_GRASS_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_grass_fall");

    public static final Supplier<SoundType> BLOCK_GRASS_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_grass_hit");

    public static final Supplier<SoundType> BLOCK_GRASS_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_grass_place");

    public static final Supplier<SoundType> BLOCK_GRASS_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_grass_step");

    public static final Supplier<SoundType> BLOCK_GRAVEL_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_gravel_break");

    public static final Supplier<SoundType> BLOCK_GRAVEL_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_gravel_fall");

    public static final Supplier<SoundType> BLOCK_GRAVEL_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_gravel_hit");

    public static final Supplier<SoundType> BLOCK_GRAVEL_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_gravel_place");

    public static final Supplier<SoundType> BLOCK_GRAVEL_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_gravel_step");

    public static final Supplier<SoundType> BLOCK_GRINDSTONE_USE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_grindstone_use");

    public static final Supplier<SoundType> BLOCK_IRON_DOOR_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_iron_door_close");

    public static final Supplier<SoundType> BLOCK_IRON_DOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_iron_door_open");

    public static final Supplier<SoundType> BLOCK_IRON_TRAPDOOR_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_iron_trapdoor_close");

    public static final Supplier<SoundType> BLOCK_IRON_TRAPDOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_iron_trapdoor_open");

    public static final Supplier<SoundType> BLOCK_LADDER_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_ladder_break");

    public static final Supplier<SoundType> BLOCK_LADDER_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_ladder_fall");

    public static final Supplier<SoundType> BLOCK_LADDER_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_ladder_hit");

    public static final Supplier<SoundType> BLOCK_LADDER_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_ladder_place");

    public static final Supplier<SoundType> BLOCK_LADDER_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_ladder_step");

    public static final Supplier<SoundType> BLOCK_LANTERN_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_lantern_break");

    public static final Supplier<SoundType> BLOCK_LANTERN_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_lantern_fall");

    public static final Supplier<SoundType> BLOCK_LANTERN_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_lantern_hit");

    public static final Supplier<SoundType> BLOCK_LANTERN_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_lantern_place");

    public static final Supplier<SoundType> BLOCK_LANTERN_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_lantern_step");

    public static final Supplier<SoundType> BLOCK_LAVA_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_lava_ambient");

    public static final Supplier<SoundType> BLOCK_LAVA_EXTINGUISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_lava_extinguish");

    public static final Supplier<SoundType> BLOCK_LAVA_POP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_lava_pop");

    public static final Supplier<SoundType> BLOCK_LEVER_CLICK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_lever_click");

    public static final Supplier<SoundType> BLOCK_LILY_PAD_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_lily_pad_place");

    public static final Supplier<SoundType> BLOCK_METAL_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_metal_break");

    public static final Supplier<SoundType> BLOCK_METAL_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_metal_fall");

    public static final Supplier<SoundType> BLOCK_METAL_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_metal_hit");

    public static final Supplier<SoundType> BLOCK_METAL_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_metal_place");

    public static final Supplier<SoundType> BLOCK_METAL_PRESSURE_PLATE_CLICK_OFF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_metal_pressure_plate_click_off");

    public static final Supplier<SoundType> BLOCK_METAL_PRESSURE_PLATE_CLICK_ON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_metal_pressure_plate_click_on");

    public static final Supplier<SoundType> BLOCK_METAL_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_metal_step");

    public static final Supplier<SoundType> BLOCK_NETHER_WART_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_nether_wart_break");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_BANJO = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_note_block_banjo");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_BASEDRUM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_note_block_basedrum");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_BASS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_note_block_bass");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_BELL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_note_block_bell");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_BIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_note_block_bit");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_CHIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_note_block_chime");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_COW_BELL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_note_block_cow_bell");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_DIDGERIDOO = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_note_block_didgeridoo");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_FLUTE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_note_block_flute");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_GUITAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_note_block_guitar");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_HARP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_note_block_harp");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_HAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_note_block_hat");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_IRON_XYLOPHONE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_note_block_iron_xylophone");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_PLING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_note_block_pling");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_SNARE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_note_block_snare");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_XYLOPHONE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_note_block_xylophone");

    public static final Supplier<SoundType> BLOCK_PISTON_CONTRACT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_piston_contract");

    public static final Supplier<SoundType> BLOCK_PISTON_EXTEND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_piston_extend");

    public static final Supplier<SoundType> BLOCK_PORTAL_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_portal_ambient");

    public static final Supplier<SoundType> BLOCK_PORTAL_TRAVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_portal_travel");

    public static final Supplier<SoundType> BLOCK_PORTAL_TRIGGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_portal_trigger");

    public static final Supplier<SoundType> BLOCK_PUMPKIN_CARVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_pumpkin_carve");

    public static final Supplier<SoundType> BLOCK_REDSTONE_TORCH_BURNOUT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_redstone_torch_burnout");

    public static final Supplier<SoundType> BLOCK_SAND_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_sand_break");

    public static final Supplier<SoundType> BLOCK_SAND_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_sand_fall");

    public static final Supplier<SoundType> BLOCK_SAND_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_sand_hit");

    public static final Supplier<SoundType> BLOCK_SAND_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_sand_place");

    public static final Supplier<SoundType> BLOCK_SAND_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_sand_step");

    public static final Supplier<SoundType> BLOCK_SCAFFOLDING_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_scaffolding_break");

    public static final Supplier<SoundType> BLOCK_SCAFFOLDING_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_scaffolding_fall");

    public static final Supplier<SoundType> BLOCK_SCAFFOLDING_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_scaffolding_hit");

    public static final Supplier<SoundType> BLOCK_SCAFFOLDING_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_scaffolding_place");

    public static final Supplier<SoundType> BLOCK_SCAFFOLDING_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_scaffolding_step");

    public static final Supplier<SoundType> BLOCK_SHULKER_BOX_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_shulker_box_close");

    public static final Supplier<SoundType> BLOCK_SHULKER_BOX_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_shulker_box_open");

    public static final Supplier<SoundType> BLOCK_SLIME_BLOCK_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_slime_block_break");

    public static final Supplier<SoundType> BLOCK_SLIME_BLOCK_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_slime_block_fall");

    public static final Supplier<SoundType> BLOCK_SLIME_BLOCK_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_slime_block_hit");

    public static final Supplier<SoundType> BLOCK_SLIME_BLOCK_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_slime_block_place");

    public static final Supplier<SoundType> BLOCK_SLIME_BLOCK_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_slime_block_step");

    public static final Supplier<SoundType> BLOCK_SMOKER_SMOKE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_smoker_smoke");

    public static final Supplier<SoundType> BLOCK_SNOW_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_snow_break");

    public static final Supplier<SoundType> BLOCK_SNOW_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_snow_fall");

    public static final Supplier<SoundType> BLOCK_SNOW_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_snow_hit");

    public static final Supplier<SoundType> BLOCK_SNOW_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_snow_place");

    public static final Supplier<SoundType> BLOCK_SNOW_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_snow_step");

    public static final Supplier<SoundType> BLOCK_STONE_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_stone_break");

    public static final Supplier<SoundType> BLOCK_STONE_BUTTON_CLICK_OFF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_stone_button_click_off");

    public static final Supplier<SoundType> BLOCK_STONE_BUTTON_CLICK_ON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_stone_button_click_on");

    public static final Supplier<SoundType> BLOCK_STONE_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_stone_fall");

    public static final Supplier<SoundType> BLOCK_STONE_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_stone_hit");

    public static final Supplier<SoundType> BLOCK_STONE_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_stone_place");

    public static final Supplier<SoundType> BLOCK_STONE_PRESSURE_PLATE_CLICK_OFF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_stone_pressure_plate_click_off");

    public static final Supplier<SoundType> BLOCK_STONE_PRESSURE_PLATE_CLICK_ON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_stone_pressure_plate_click_on");

    public static final Supplier<SoundType> BLOCK_STONE_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_stone_step");

    public static final Supplier<SoundType> BLOCK_SWEET_BERRY_BUSH_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_sweet_berry_bush_break");

    public static final Supplier<SoundType> BLOCK_SWEET_BERRY_BUSH_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_sweet_berry_bush_place");

    public static final Supplier<SoundType> BLOCK_TRIPWIRE_ATTACH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_tripwire_attach");

    public static final Supplier<SoundType> BLOCK_TRIPWIRE_CLICK_OFF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_tripwire_click_off");

    public static final Supplier<SoundType> BLOCK_TRIPWIRE_CLICK_ON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_tripwire_click_on");

    public static final Supplier<SoundType> BLOCK_TRIPWIRE_DETACH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_tripwire_detach");

    public static final Supplier<SoundType> BLOCK_WATER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_water_ambient");

    public static final Supplier<SoundType> BLOCK_WET_GRASS_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_wet_grass_break");

    public static final Supplier<SoundType> BLOCK_WET_GRASS_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_wet_grass_fall");

    public static final Supplier<SoundType> BLOCK_WET_GRASS_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_wet_grass_hit");

    public static final Supplier<SoundType> BLOCK_WET_GRASS_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_wet_grass_place");

    public static final Supplier<SoundType> BLOCK_WET_GRASS_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_wet_grass_step");

    public static final Supplier<SoundType> BLOCK_WOODEN_BUTTON_CLICK_OFF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_wooden_button_click_off");

    public static final Supplier<SoundType> BLOCK_WOODEN_BUTTON_CLICK_ON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_wooden_button_click_on");

    public static final Supplier<SoundType> BLOCK_WOODEN_DOOR_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_wooden_door_close");

    public static final Supplier<SoundType> BLOCK_WOODEN_DOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_wooden_door_open");

    public static final Supplier<SoundType> BLOCK_WOODEN_PRESSURE_PLATE_CLICK_OFF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_wooden_pressure_plate_click_off");

    public static final Supplier<SoundType> BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_wooden_pressure_plate_click_on");

    public static final Supplier<SoundType> BLOCK_WOODEN_TRAPDOOR_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_wooden_trapdoor_close");

    public static final Supplier<SoundType> BLOCK_WOODEN_TRAPDOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_wooden_trapdoor_open");

    public static final Supplier<SoundType> BLOCK_WOOD_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_wood_break");

    public static final Supplier<SoundType> BLOCK_WOOD_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_wood_fall");

    public static final Supplier<SoundType> BLOCK_WOOD_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_wood_hit");

    public static final Supplier<SoundType> BLOCK_WOOD_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_wood_place");

    public static final Supplier<SoundType> BLOCK_WOOD_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_wood_step");

    public static final Supplier<SoundType> BLOCK_WOOL_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_wool_break");

    public static final Supplier<SoundType> BLOCK_WOOL_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_wool_fall");

    public static final Supplier<SoundType> BLOCK_WOOL_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_wool_hit");

    public static final Supplier<SoundType> BLOCK_WOOL_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_wool_place");

    public static final Supplier<SoundType> BLOCK_WOOL_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block_wool_step");

    public static final Supplier<SoundType> ENCHANT_THORNS_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "enchant_thorns_hit");

    public static final Supplier<SoundType> ENTITY_ARMOR_STAND_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_armor_stand_break");

    public static final Supplier<SoundType> ENTITY_ARMOR_STAND_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_armor_stand_fall");

    public static final Supplier<SoundType> ENTITY_ARMOR_STAND_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_armor_stand_hit");

    public static final Supplier<SoundType> ENTITY_ARMOR_STAND_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_armor_stand_place");

    public static final Supplier<SoundType> ENTITY_ARROW_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_arrow_hit");

    public static final Supplier<SoundType> ENTITY_ARROW_HIT_PLAYER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_arrow_hit_player");

    public static final Supplier<SoundType> ENTITY_ARROW_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_arrow_shoot");

    public static final Supplier<SoundType> ENTITY_BAT_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_bat_ambient");

    public static final Supplier<SoundType> ENTITY_BAT_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_bat_death");

    public static final Supplier<SoundType> ENTITY_BAT_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_bat_hurt");

    public static final Supplier<SoundType> ENTITY_BAT_LOOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_bat_loop");

    public static final Supplier<SoundType> ENTITY_BAT_TAKEOFF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_bat_takeoff");

    public static final Supplier<SoundType> ENTITY_BEE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_bee_death");

    public static final Supplier<SoundType> ENTITY_BEE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_bee_hurt");

    public static final Supplier<SoundType> ENTITY_BEE_LOOP_AGGRESSIVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_bee_loop_aggressive");

    public static final Supplier<SoundType> ENTITY_BEE_LOOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_bee_loop");

    public static final Supplier<SoundType> ENTITY_BEE_STING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_bee_sting");

    public static final Supplier<SoundType> ENTITY_BEE_POLLINATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_bee_pollinate");

    public static final Supplier<SoundType> ENTITY_BLAZE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_blaze_ambient");

    public static final Supplier<SoundType> ENTITY_BLAZE_BURN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_blaze_burn");

    public static final Supplier<SoundType> ENTITY_BLAZE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_blaze_death");

    public static final Supplier<SoundType> ENTITY_BLAZE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_blaze_hurt");

    public static final Supplier<SoundType> ENTITY_BLAZE_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_blaze_shoot");

    public static final Supplier<SoundType> ENTITY_BOAT_PADDLE_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_boat_paddle_land");

    public static final Supplier<SoundType> ENTITY_BOAT_PADDLE_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_boat_paddle_water");

    public static final Supplier<SoundType> ENTITY_CAT_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_cat_ambient");

    public static final Supplier<SoundType> ENTITY_CAT_BEG_FOR_FOOD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_cat_beg_for_food");

    public static final Supplier<SoundType> ENTITY_CAT_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_cat_death");

    public static final Supplier<SoundType> ENTITY_CAT_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_cat_eat");

    public static final Supplier<SoundType> ENTITY_CAT_HISS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_cat_hiss");

    public static final Supplier<SoundType> ENTITY_CAT_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_cat_hurt");

    public static final Supplier<SoundType> ENTITY_CAT_PURR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_cat_purr");

    public static final Supplier<SoundType> ENTITY_CAT_PURREOW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_cat_purreow");

    public static final Supplier<SoundType> ENTITY_CAT_STRAY_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_cat_stray_ambient");

    public static final Supplier<SoundType> ENTITY_CHICKEN_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_chicken_ambient");

    public static final Supplier<SoundType> ENTITY_CHICKEN_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_chicken_death");

    public static final Supplier<SoundType> ENTITY_CHICKEN_EGG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_chicken_egg");

    public static final Supplier<SoundType> ENTITY_CHICKEN_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_chicken_hurt");

    public static final Supplier<SoundType> ENTITY_CHICKEN_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_chicken_step");

    public static final Supplier<SoundType> ENTITY_COD_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_cod_ambient");

    public static final Supplier<SoundType> ENTITY_COD_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_cod_death");

    public static final Supplier<SoundType> ENTITY_COD_FLOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_cod_flop");

    public static final Supplier<SoundType> ENTITY_COD_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_cod_hurt");

    public static final Supplier<SoundType> ENTITY_COW_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_cow_ambient");

    public static final Supplier<SoundType> ENTITY_COW_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_cow_death");

    public static final Supplier<SoundType> ENTITY_COW_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_cow_hurt");

    public static final Supplier<SoundType> ENTITY_COW_MILK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_cow_milk");

    public static final Supplier<SoundType> ENTITY_COW_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_cow_step");

    public static final Supplier<SoundType> ENTITY_CREEPER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_creeper_death");

    public static final Supplier<SoundType> ENTITY_CREEPER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_creeper_hurt");

    public static final Supplier<SoundType> ENTITY_CREEPER_PRIMED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_creeper_primed");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_dolphin_ambient");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_AMBIENT_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_dolphin_ambient_water");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_dolphin_attack");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_dolphin_death");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_dolphin_eat");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_dolphin_hurt");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_JUMP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_dolphin_jump");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_PLAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_dolphin_play");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_SPLASH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_dolphin_splash");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_SWIM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_dolphin_swim");

    public static final Supplier<SoundType> ENTITY_DONKEY_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_donkey_ambient");

    public static final Supplier<SoundType> ENTITY_DONKEY_ANGRY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_donkey_angry");

    public static final Supplier<SoundType> ENTITY_DONKEY_CHEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_donkey_chest");

    public static final Supplier<SoundType> ENTITY_DONKEY_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_donkey_death");

    public static final Supplier<SoundType> ENTITY_DONKEY_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_donkey_hurt");

    public static final Supplier<SoundType> ENTITY_DRAGON_FIREBALL_EXPLODE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_dragon_fireball_explode");

    public static final Supplier<SoundType> ENTITY_DROWNED_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_drowned_ambient");

    public static final Supplier<SoundType> ENTITY_DROWNED_AMBIENT_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_drowned_ambient_water");

    public static final Supplier<SoundType> ENTITY_DROWNED_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_drowned_death");

    public static final Supplier<SoundType> ENTITY_DROWNED_DEATH_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_drowned_death_water");

    public static final Supplier<SoundType> ENTITY_DROWNED_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_drowned_hurt");

    public static final Supplier<SoundType> ENTITY_DROWNED_HURT_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_drowned_hurt_water");

    public static final Supplier<SoundType> ENTITY_DROWNED_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_drowned_shoot");

    public static final Supplier<SoundType> ENTITY_DROWNED_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_drowned_step");

    public static final Supplier<SoundType> ENTITY_DROWNED_SWIM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_drowned_swim");

    public static final Supplier<SoundType> ENTITY_EGG_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_egg_throw");

    public static final Supplier<SoundType> ENTITY_ELDER_GUARDIAN_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_elder_guardian_ambient");

    public static final Supplier<SoundType> ENTITY_ELDER_GUARDIAN_AMBIENT_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_elder_guardian_ambient_land");

    public static final Supplier<SoundType> ENTITY_ELDER_GUARDIAN_CURSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_elder_guardian_curse");

    public static final Supplier<SoundType> ENTITY_ELDER_GUARDIAN_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_elder_guardian_death");

    public static final Supplier<SoundType> ENTITY_ELDER_GUARDIAN_DEATH_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_elder_guardian_death_land");

    public static final Supplier<SoundType> ENTITY_ELDER_GUARDIAN_FLOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_elder_guardian_flop");

    public static final Supplier<SoundType> ENTITY_ELDER_GUARDIAN_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_elder_guardian_hurt");

    public static final Supplier<SoundType> ENTITY_ELDER_GUARDIAN_HURT_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_elder_guardian_hurt_land");

    public static final Supplier<SoundType> ENTITY_ENDERMAN_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_enderman_ambient");

    public static final Supplier<SoundType> ENTITY_ENDERMAN_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_enderman_death");

    public static final Supplier<SoundType> ENTITY_ENDERMAN_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_enderman_hurt");

    public static final Supplier<SoundType> ENTITY_ENDERMAN_SCREAM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_enderman_scream");

    public static final Supplier<SoundType> ENTITY_ENDERMAN_STARE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_enderman_stare");

    public static final Supplier<SoundType> ENTITY_ENDERMAN_TELEPORT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_enderman_teleport");

    public static final Supplier<SoundType> ENTITY_ENDERMITE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_endermite_ambient");

    public static final Supplier<SoundType> ENTITY_ENDERMITE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_endermite_death");

    public static final Supplier<SoundType> ENTITY_ENDERMITE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_endermite_hurt");

    public static final Supplier<SoundType> ENTITY_ENDERMITE_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_endermite_step");

    public static final Supplier<SoundType> ENTITY_ENDER_DRAGON_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_ender_dragon_ambient");

    public static final Supplier<SoundType> ENTITY_ENDER_DRAGON_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_ender_dragon_death");

    public static final Supplier<SoundType> ENTITY_ENDER_DRAGON_FLAP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_ender_dragon_flap");

    public static final Supplier<SoundType> ENTITY_ENDER_DRAGON_GROWL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_ender_dragon_growl");

    public static final Supplier<SoundType> ENTITY_ENDER_DRAGON_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_ender_dragon_hurt");

    public static final Supplier<SoundType> ENTITY_ENDER_DRAGON_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_ender_dragon_shoot");

    public static final Supplier<SoundType> ENTITY_ENDER_EYE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_ender_eye_death");

    public static final Supplier<SoundType> ENTITY_ENDER_EYE_LAUNCH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_ender_eye_launch");

    public static final Supplier<SoundType> ENTITY_ENDER_PEARL_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_ender_pearl_throw");

    public static final Supplier<SoundType> ENTITY_EVOKER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_evoker_ambient");

    public static final Supplier<SoundType> ENTITY_EVOKER_CAST_SPELL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_evoker_cast_spell");

    public static final Supplier<SoundType> ENTITY_EVOKER_CELEBRATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_evoker_celebrate");

    public static final Supplier<SoundType> ENTITY_EVOKER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_evoker_death");

    public static final Supplier<SoundType> ENTITY_EVOKER_FANGS_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_evoker_fangs_attack");

    public static final Supplier<SoundType> ENTITY_EVOKER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_evoker_hurt");

    public static final Supplier<SoundType> ENTITY_EVOKER_PREPARE_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_evoker_prepare_attack");

    public static final Supplier<SoundType> ENTITY_EVOKER_PREPARE_SUMMON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_evoker_prepare_summon");

    public static final Supplier<SoundType> ENTITY_EVOKER_PREPARE_WOLOLO = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_evoker_prepare_wololo");

    public static final Supplier<SoundType> ENTITY_EXPERIENCE_BOTTLE_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_experience_bottle_throw");

    public static final Supplier<SoundType> ENTITY_EXPERIENCE_ORB_PICKUP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_experience_orb_pickup");

    public static final Supplier<SoundType> ENTITY_FIREWORK_ROCKET_BLAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_firework_rocket_blast");

    public static final Supplier<SoundType> ENTITY_FIREWORK_ROCKET_BLAST_FAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_firework_rocket_blast_far");

    public static final Supplier<SoundType> ENTITY_FIREWORK_ROCKET_LARGE_BLAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_firework_rocket_large_blast");

    public static final Supplier<SoundType> ENTITY_FIREWORK_ROCKET_LARGE_BLAST_FAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_firework_rocket_large_blast_far");

    public static final Supplier<SoundType> ENTITY_FIREWORK_ROCKET_LAUNCH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_firework_rocket_launch");

    public static final Supplier<SoundType> ENTITY_FIREWORK_ROCKET_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_firework_rocket_shoot");

    public static final Supplier<SoundType> ENTITY_FIREWORK_ROCKET_TWINKLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_firework_rocket_twinkle");

    public static final Supplier<SoundType> ENTITY_FIREWORK_ROCKET_TWINKLE_FAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_firework_rocket_twinkle_far");

    public static final Supplier<SoundType> ENTITY_FISHING_BOBBER_RETRIEVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_fishing_bobber_retrieve");

    public static final Supplier<SoundType> ENTITY_FISHING_BOBBER_SPLASH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_fishing_bobber_splash");

    public static final Supplier<SoundType> ENTITY_FISHING_BOBBER_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_fishing_bobber_throw");

    public static final Supplier<SoundType> ENTITY_FISH_SWIM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_fish_swim");

    public static final Supplier<SoundType> ENTITY_FOX_AGGRO = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_fox_aggro");

    public static final Supplier<SoundType> ENTITY_FOX_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_fox_ambient");

    public static final Supplier<SoundType> ENTITY_FOX_BITE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_fox_bite");

    public static final Supplier<SoundType> ENTITY_FOX_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_fox_death");

    public static final Supplier<SoundType> ENTITY_FOX_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_fox_eat");

    public static final Supplier<SoundType> ENTITY_FOX_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_fox_hurt");

    public static final Supplier<SoundType> ENTITY_FOX_SCREECH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_fox_screech");

    public static final Supplier<SoundType> ENTITY_FOX_SLEEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_fox_sleep");

    public static final Supplier<SoundType> ENTITY_FOX_SNIFF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_fox_sniff");

    public static final Supplier<SoundType> ENTITY_FOX_SPIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_fox_spit");

    public static final Supplier<SoundType> ENTITY_GENERIC_BIG_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_generic_big_fall");

    public static final Supplier<SoundType> ENTITY_GENERIC_BURN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_generic_burn");

    public static final Supplier<SoundType> ENTITY_GENERIC_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_generic_death");

    public static final Supplier<SoundType> ENTITY_GENERIC_DRINK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_generic_drink");

    public static final Supplier<SoundType> ENTITY_GENERIC_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_generic_eat");

    public static final Supplier<SoundType> ENTITY_GENERIC_EXPLODE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_generic_explode");

    public static final Supplier<SoundType> ENTITY_GENERIC_EXTINGUISH_FIRE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_generic_extinguish_fire");

    public static final Supplier<SoundType> ENTITY_GENERIC_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_generic_hurt");

    public static final Supplier<SoundType> ENTITY_GENERIC_SMALL_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_generic_small_fall");

    public static final Supplier<SoundType> ENTITY_GENERIC_SPLASH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_generic_splash");

    public static final Supplier<SoundType> ENTITY_GENERIC_SWIM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_generic_swim");

    public static final Supplier<SoundType> ENTITY_GHAST_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_ghast_ambient");

    public static final Supplier<SoundType> ENTITY_GHAST_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_ghast_death");

    public static final Supplier<SoundType> ENTITY_GHAST_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_ghast_hurt");

    public static final Supplier<SoundType> ENTITY_GHAST_SCREAM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_ghast_scream");

    public static final Supplier<SoundType> ENTITY_GHAST_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_ghast_shoot");

    public static final Supplier<SoundType> ENTITY_GHAST_WARN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_ghast_warn");

    public static final Supplier<SoundType> ENTITY_GUARDIAN_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_guardian_ambient");

    public static final Supplier<SoundType> ENTITY_GUARDIAN_AMBIENT_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_guardian_ambient_land");

    public static final Supplier<SoundType> ENTITY_GUARDIAN_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_guardian_attack");

    public static final Supplier<SoundType> ENTITY_GUARDIAN_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_guardian_death");

    public static final Supplier<SoundType> ENTITY_GUARDIAN_DEATH_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_guardian_death_land");

    public static final Supplier<SoundType> ENTITY_GUARDIAN_FLOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_guardian_flop");

    public static final Supplier<SoundType> ENTITY_GUARDIAN_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_guardian_hurt");

    public static final Supplier<SoundType> ENTITY_GUARDIAN_HURT_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_guardian_hurt_land");

    public static final Supplier<SoundType> ENTITY_HORSE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_horse_ambient");

    public static final Supplier<SoundType> ENTITY_HORSE_ANGRY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_horse_angry");

    public static final Supplier<SoundType> ENTITY_HORSE_ARMOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_horse_armor");

    public static final Supplier<SoundType> ENTITY_HORSE_BREATHE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_horse_breathe");

    public static final Supplier<SoundType> ENTITY_HORSE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_horse_death");

    public static final Supplier<SoundType> ENTITY_HORSE_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_horse_eat");

    public static final Supplier<SoundType> ENTITY_HORSE_GALLOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_horse_gallop");

    public static final Supplier<SoundType> ENTITY_HORSE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_horse_hurt");

    public static final Supplier<SoundType> ENTITY_HORSE_JUMP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_horse_jump");

    public static final Supplier<SoundType> ENTITY_HORSE_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_horse_land");

    public static final Supplier<SoundType> ENTITY_HORSE_SADDLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_horse_saddle");

    public static final Supplier<SoundType> ENTITY_HORSE_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_horse_step");

    public static final Supplier<SoundType> ENTITY_HORSE_STEP_WOOD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_horse_step_wood");

    public static final Supplier<SoundType> ENTITY_HOSTILE_BIG_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_hostile_big_fall");

    public static final Supplier<SoundType> ENTITY_HOSTILE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_hostile_death");

    public static final Supplier<SoundType> ENTITY_HOSTILE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_hostile_hurt");

    public static final Supplier<SoundType> ENTITY_HOSTILE_SMALL_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_hostile_small_fall");

    public static final Supplier<SoundType> ENTITY_HOSTILE_SPLASH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_hostile_splash");

    public static final Supplier<SoundType> ENTITY_HOSTILE_SWIM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_hostile_swim");

    public static final Supplier<SoundType> ENTITY_HUSK_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_husk_ambient");

    public static final Supplier<SoundType> ENTITY_HUSK_CONVERTED_TO_ZOMBIE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_husk_converted_to_zombie");

    public static final Supplier<SoundType> ENTITY_HUSK_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_husk_death");

    public static final Supplier<SoundType> ENTITY_HUSK_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_husk_hurt");

    public static final Supplier<SoundType> ENTITY_HUSK_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_husk_step");

    public static final Supplier<SoundType> ENTITY_ILLUSIONER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_illusioner_ambient");

    public static final Supplier<SoundType> ENTITY_ILLUSIONER_CAST_SPELL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_illusioner_cast_spell");

    public static final Supplier<SoundType> ENTITY_ILLUSIONER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_illusioner_death");

    public static final Supplier<SoundType> ENTITY_ILLUSIONER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_illusioner_hurt");

    public static final Supplier<SoundType> ENTITY_ILLUSIONER_MIRROR_MOVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_illusioner_mirror_move");

    public static final Supplier<SoundType> ENTITY_ILLUSIONER_PREPARE_BLINDNESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_illusioner_prepare_blindness");

    public static final Supplier<SoundType> ENTITY_ILLUSIONER_PREPARE_MIRROR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_illusioner_prepare_mirror");

    public static final Supplier<SoundType> ENTITY_IRON_GOLEM_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_iron_golem_attack");

    public static final Supplier<SoundType> ENTITY_IRON_GOLEM_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_iron_golem_death");

    public static final Supplier<SoundType> ENTITY_IRON_GOLEM_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_iron_golem_hurt");

    public static final Supplier<SoundType> ENTITY_IRON_GOLEM_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_iron_golem_step");

    public static final Supplier<SoundType> ENTITY_ITEM_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_item_break");

    public static final Supplier<SoundType> ENTITY_ITEM_FRAME_ADD_ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_item_frame_add_item");

    public static final Supplier<SoundType> ENTITY_ITEM_FRAME_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_item_frame_break");

    public static final Supplier<SoundType> ENTITY_ITEM_FRAME_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_item_frame_place");

    public static final Supplier<SoundType> ENTITY_ITEM_FRAME_REMOVE_ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_item_frame_remove_item");

    public static final Supplier<SoundType> ENTITY_ITEM_FRAME_ROTATE_ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_item_frame_rotate_item");

    public static final Supplier<SoundType> ENTITY_ITEM_PICKUP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_item_pickup");

    public static final Supplier<SoundType> ENTITY_LEASH_KNOT_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_leash_knot_break");

    public static final Supplier<SoundType> ENTITY_LEASH_KNOT_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_leash_knot_place");

    public static final Supplier<SoundType> ENTITY_LIGHTNING_BOLT_IMPACT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_lightning_bolt_impact");

    public static final Supplier<SoundType> ENTITY_LIGHTNING_BOLT_THUNDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_lightning_bolt_thunder");

    public static final Supplier<SoundType> ENTITY_LINGERING_POTION_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_lingering_potion_throw");

    public static final Supplier<SoundType> ENTITY_LLAMA_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_llama_ambient");

    public static final Supplier<SoundType> ENTITY_LLAMA_ANGRY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_llama_angry");

    public static final Supplier<SoundType> ENTITY_LLAMA_CHEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_llama_chest");

    public static final Supplier<SoundType> ENTITY_LLAMA_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_llama_death");

    public static final Supplier<SoundType> ENTITY_LLAMA_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_llama_eat");

    public static final Supplier<SoundType> ENTITY_LLAMA_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_llama_hurt");

    public static final Supplier<SoundType> ENTITY_LLAMA_SPIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_llama_spit");

    public static final Supplier<SoundType> ENTITY_LLAMA_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_llama_step");

    public static final Supplier<SoundType> ENTITY_LLAMA_SWAG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_llama_swag");

    public static final Supplier<SoundType> ENTITY_MAGMA_CUBE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_magma_cube_death");

    public static final Supplier<SoundType> ENTITY_MAGMA_CUBE_DEATH_SMALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_magma_cube_death_small");

    public static final Supplier<SoundType> ENTITY_MAGMA_CUBE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_magma_cube_hurt");

    public static final Supplier<SoundType> ENTITY_MAGMA_CUBE_HURT_SMALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_magma_cube_hurt_small");

    public static final Supplier<SoundType> ENTITY_MAGMA_CUBE_JUMP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_magma_cube_jump");

    public static final Supplier<SoundType> ENTITY_MAGMA_CUBE_SQUISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_magma_cube_squish");

    public static final Supplier<SoundType> ENTITY_MAGMA_CUBE_SQUISH_SMALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_magma_cube_squish_small");

    public static final Supplier<SoundType> ENTITY_MINECART_INSIDE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_minecart_inside");

    public static final Supplier<SoundType> ENTITY_MINECART_RIDING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_minecart_riding");

    public static final Supplier<SoundType> ENTITY_MOOSHROOM_CONVERT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_mooshroom_convert");

    public static final Supplier<SoundType> ENTITY_MOOSHROOM_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_mooshroom_eat");

    public static final Supplier<SoundType> ENTITY_MOOSHROOM_MILK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_mooshroom_milk");

    public static final Supplier<SoundType> ENTITY_MOOSHROOM_SHEAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_mooshroom_shear");

    public static final Supplier<SoundType> ENTITY_MOOSHROOM_SUSPICIOUS_MILK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_mooshroom_suspicious_milk");

    public static final Supplier<SoundType> ENTITY_MULE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_mule_ambient");

    public static final Supplier<SoundType> ENTITY_MULE_CHEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_mule_chest");

    public static final Supplier<SoundType> ENTITY_MULE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_mule_death");

    public static final Supplier<SoundType> ENTITY_MULE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_mule_hurt");

    public static final Supplier<SoundType> ENTITY_OCELOT_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_ocelot_ambient");

    public static final Supplier<SoundType> ENTITY_OCELOT_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_ocelot_death");

    public static final Supplier<SoundType> ENTITY_OCELOT_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_ocelot_hurt");

    public static final Supplier<SoundType> ENTITY_PAINTING_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_painting_break");

    public static final Supplier<SoundType> ENTITY_PAINTING_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_painting_place");

    public static final Supplier<SoundType> ENTITY_PANDA_AGGRESSIVE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_panda_aggressive_ambient");

    public static final Supplier<SoundType> ENTITY_PANDA_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_panda_ambient");

    public static final Supplier<SoundType> ENTITY_PANDA_BITE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_panda_bite");

    public static final Supplier<SoundType> ENTITY_PANDA_CANT_BREED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_panda_cant_breed");

    public static final Supplier<SoundType> ENTITY_PANDA_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_panda_death");

    public static final Supplier<SoundType> ENTITY_PANDA_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_panda_eat");

    public static final Supplier<SoundType> ENTITY_PANDA_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_panda_hurt");

    public static final Supplier<SoundType> ENTITY_PANDA_PRE_SNEEZE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_panda_pre_sneeze");

    public static final Supplier<SoundType> ENTITY_PANDA_SNEEZE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_panda_sneeze");

    public static final Supplier<SoundType> ENTITY_PANDA_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_panda_step");

    public static final Supplier<SoundType> ENTITY_PANDA_WORRIED_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_panda_worried_ambient");

    public static final Supplier<SoundType> ENTITY_PARROT_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_ambient");

    public static final Supplier<SoundType> ENTITY_PARROT_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_death");

    public static final Supplier<SoundType> ENTITY_PARROT_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_eat");

    public static final Supplier<SoundType> ENTITY_PARROT_FLY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_fly");

    public static final Supplier<SoundType> ENTITY_PARROT_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_hurt");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_BLAZE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_blaze");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_CREEPER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_creeper");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_DROWNED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_drowned");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_ELDER_GUARDIAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_elder_guardian");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_ENDERMITE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_endermite");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_ENDER_DRAGON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_ender_dragon");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_EVOKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_evoker");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_GHAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_ghast");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_GUARDIAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_guardian");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_HUSK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_husk");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_ILLUSIONER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_illusioner");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_MAGMA_CUBE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_magma_cube");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_PHANTOM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_phantom");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_PILLAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_pillager");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_RAVAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_ravager");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_SHULKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_shulker");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_SILVERFISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_silverfish");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_SKELETON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_skeleton");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_SLIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_slime");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_SPIDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_spider");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_STRAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_stray");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_VEX = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_vex");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_VINDICATOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_vindicator");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_WITCH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_witch");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_WITHER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_wither");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_WITHER_SKELETON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_wither_skeleton");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_ZOMBIE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_zombie");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_ZOMBIE_VILLAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_imitate_zombie_villager");

    public static final Supplier<SoundType> ENTITY_PARROT_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_parrot_step");

    public static final Supplier<SoundType> ENTITY_PHANTOM_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_phantom_ambient");

    public static final Supplier<SoundType> ENTITY_PHANTOM_BITE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_phantom_bite");

    public static final Supplier<SoundType> ENTITY_PHANTOM_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_phantom_death");

    public static final Supplier<SoundType> ENTITY_PHANTOM_FLAP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_phantom_flap");

    public static final Supplier<SoundType> ENTITY_PHANTOM_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_phantom_hurt");

    public static final Supplier<SoundType> ENTITY_PHANTOM_SWOOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_phantom_swoop");

    public static final Supplier<SoundType> ENTITY_PIG_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_pig_ambient");

    public static final Supplier<SoundType> ENTITY_PIG_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_pig_death");

    public static final Supplier<SoundType> ENTITY_PIG_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_pig_hurt");

    public static final Supplier<SoundType> ENTITY_PIG_SADDLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_pig_saddle");

    public static final Supplier<SoundType> ENTITY_PIG_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_pig_step");

    public static final Supplier<SoundType> ENTITY_PILLAGER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_pillager_ambient");

    public static final Supplier<SoundType> ENTITY_PILLAGER_CELEBRATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_pillager_celebrate");

    public static final Supplier<SoundType> ENTITY_PILLAGER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_pillager_death");

    public static final Supplier<SoundType> ENTITY_PILLAGER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_pillager_hurt");

    public static final Supplier<SoundType> ENTITY_PLAYER_ATTACK_CRIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_player_attack_crit");

    public static final Supplier<SoundType> ENTITY_PLAYER_ATTACK_KNOCKBACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_player_attack_knockback");

    public static final Supplier<SoundType> ENTITY_PLAYER_ATTACK_NODAMAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_player_attack_nodamage");

    public static final Supplier<SoundType> ENTITY_PLAYER_ATTACK_STRONG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_player_attack_strong");

    public static final Supplier<SoundType> ENTITY_PLAYER_ATTACK_SWEEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_player_attack_sweep");

    public static final Supplier<SoundType> ENTITY_PLAYER_ATTACK_WEAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_player_attack_weak");

    public static final Supplier<SoundType> ENTITY_PLAYER_BIG_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_player_big_fall");

    public static final Supplier<SoundType> ENTITY_PLAYER_BREATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_player_breath");

    public static final Supplier<SoundType> ENTITY_PLAYER_BURP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_player_burp");

    public static final Supplier<SoundType> ENTITY_PLAYER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_player_death");

    public static final Supplier<SoundType> ENTITY_PLAYER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_player_hurt");

    public static final Supplier<SoundType> ENTITY_PLAYER_HURT_DROWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_player_hurt_drown");

    public static final Supplier<SoundType> ENTITY_PLAYER_HURT_ON_FIRE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_player_hurt_on_fire");

    public static final Supplier<SoundType> ENTITY_PLAYER_HURT_SWEET_BERRY_BUSH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_player_hurt_sweet_berry_bush");

    public static final Supplier<SoundType> ENTITY_PLAYER_LEVELUP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_player_levelup");

    public static final Supplier<SoundType> ENTITY_PLAYER_SMALL_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_player_small_fall");

    public static final Supplier<SoundType> ENTITY_PLAYER_SPLASH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_player_splash");

    public static final Supplier<SoundType> ENTITY_PLAYER_SPLASH_HIGH_SPEED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_player_splash_high_speed");

    public static final Supplier<SoundType> ENTITY_PLAYER_SWIM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_player_swim");

    public static final Supplier<SoundType> ENTITY_POLAR_BEAR_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_polar_bear_ambient");

    public static final Supplier<SoundType> ENTITY_POLAR_BEAR_AMBIENT_BABY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_polar_bear_ambient_baby");

    public static final Supplier<SoundType> ENTITY_POLAR_BEAR_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_polar_bear_death");

    public static final Supplier<SoundType> ENTITY_POLAR_BEAR_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_polar_bear_hurt");

    public static final Supplier<SoundType> ENTITY_POLAR_BEAR_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_polar_bear_step");

    public static final Supplier<SoundType> ENTITY_POLAR_BEAR_WARNING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_polar_bear_warning");

    public static final Supplier<SoundType> ENTITY_PUFFER_FISH_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_puffer_fish_ambient");

    public static final Supplier<SoundType> ENTITY_PUFFER_FISH_BLOW_OUT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_puffer_fish_blow_out");

    public static final Supplier<SoundType> ENTITY_PUFFER_FISH_BLOW_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_puffer_fish_blow_up");

    public static final Supplier<SoundType> ENTITY_PUFFER_FISH_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_puffer_fish_death");

    public static final Supplier<SoundType> ENTITY_PUFFER_FISH_FLOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_puffer_fish_flop");

    public static final Supplier<SoundType> ENTITY_PUFFER_FISH_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_puffer_fish_hurt");

    public static final Supplier<SoundType> ENTITY_PUFFER_FISH_STING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_puffer_fish_sting");

    public static final Supplier<SoundType> ENTITY_RABBIT_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_rabbit_ambient");

    public static final Supplier<SoundType> ENTITY_RABBIT_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_rabbit_attack");

    public static final Supplier<SoundType> ENTITY_RABBIT_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_rabbit_death");

    public static final Supplier<SoundType> ENTITY_RABBIT_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_rabbit_hurt");

    public static final Supplier<SoundType> ENTITY_RABBIT_JUMP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_rabbit_jump");

    public static final Supplier<SoundType> ENTITY_RAVAGER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_ravager_ambient");

    public static final Supplier<SoundType> ENTITY_RAVAGER_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_ravager_attack");

    public static final Supplier<SoundType> ENTITY_RAVAGER_CELEBRATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_ravager_celebrate");

    public static final Supplier<SoundType> ENTITY_RAVAGER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_ravager_death");

    public static final Supplier<SoundType> ENTITY_RAVAGER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_ravager_hurt");

    public static final Supplier<SoundType> ENTITY_RAVAGER_ROAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_ravager_roar");

    public static final Supplier<SoundType> ENTITY_RAVAGER_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_ravager_step");

    public static final Supplier<SoundType> ENTITY_RAVAGER_STUNNED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_ravager_stunned");

    public static final Supplier<SoundType> ENTITY_SALMON_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_salmon_ambient");

    public static final Supplier<SoundType> ENTITY_SALMON_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_salmon_death");

    public static final Supplier<SoundType> ENTITY_SALMON_FLOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_salmon_flop");

    public static final Supplier<SoundType> ENTITY_SALMON_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_salmon_hurt");

    public static final Supplier<SoundType> ENTITY_SHEEP_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_sheep_ambient");

    public static final Supplier<SoundType> ENTITY_SHEEP_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_sheep_death");

    public static final Supplier<SoundType> ENTITY_SHEEP_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_sheep_hurt");

    public static final Supplier<SoundType> ENTITY_SHEEP_SHEAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_sheep_shear");

    public static final Supplier<SoundType> ENTITY_SHEEP_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_sheep_step");

    public static final Supplier<SoundType> ENTITY_SHULKER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_shulker_ambient");

    public static final Supplier<SoundType> ENTITY_SHULKER_BULLET_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_shulker_bullet_hit");

    public static final Supplier<SoundType> ENTITY_SHULKER_BULLET_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_shulker_bullet_hurt");

    public static final Supplier<SoundType> ENTITY_SHULKER_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_shulker_close");

    public static final Supplier<SoundType> ENTITY_SHULKER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_shulker_death");

    public static final Supplier<SoundType> ENTITY_SHULKER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_shulker_hurt");

    public static final Supplier<SoundType> ENTITY_SHULKER_HURT_CLOSED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_shulker_hurt_closed");

    public static final Supplier<SoundType> ENTITY_SHULKER_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_shulker_open");

    public static final Supplier<SoundType> ENTITY_SHULKER_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_shulker_shoot");

    public static final Supplier<SoundType> ENTITY_SHULKER_TELEPORT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_shulker_teleport");

    public static final Supplier<SoundType> ENTITY_SILVERFISH_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_silverfish_ambient");

    public static final Supplier<SoundType> ENTITY_SILVERFISH_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_silverfish_death");

    public static final Supplier<SoundType> ENTITY_SILVERFISH_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_silverfish_hurt");

    public static final Supplier<SoundType> ENTITY_SILVERFISH_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_silverfish_step");

    public static final Supplier<SoundType> ENTITY_SKELETON_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_skeleton_ambient");

    public static final Supplier<SoundType> ENTITY_SKELETON_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_skeleton_death");

    public static final Supplier<SoundType> ENTITY_SKELETON_HORSE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_skeleton_horse_ambient");

    public static final Supplier<SoundType> ENTITY_SKELETON_HORSE_AMBIENT_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_skeleton_horse_ambient_water");

    public static final Supplier<SoundType> ENTITY_SKELETON_HORSE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_skeleton_horse_death");

    public static final Supplier<SoundType> ENTITY_SKELETON_HORSE_GALLOP_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_skeleton_horse_gallop_water");

    public static final Supplier<SoundType> ENTITY_SKELETON_HORSE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_skeleton_horse_hurt");

    public static final Supplier<SoundType> ENTITY_SKELETON_HORSE_JUMP_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_skeleton_horse_jump_water");

    public static final Supplier<SoundType> ENTITY_SKELETON_HORSE_STEP_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_skeleton_horse_step_water");

    public static final Supplier<SoundType> ENTITY_SKELETON_HORSE_SWIM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_skeleton_horse_swim");

    public static final Supplier<SoundType> ENTITY_SKELETON_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_skeleton_hurt");

    public static final Supplier<SoundType> ENTITY_SKELETON_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_skeleton_shoot");

    public static final Supplier<SoundType> ENTITY_SKELETON_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_skeleton_step");

    public static final Supplier<SoundType> ENTITY_SLIME_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_slime_attack");

    public static final Supplier<SoundType> ENTITY_SLIME_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_slime_death");

    public static final Supplier<SoundType> ENTITY_SLIME_DEATH_SMALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_slime_death_small");

    public static final Supplier<SoundType> ENTITY_SLIME_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_slime_hurt");

    public static final Supplier<SoundType> ENTITY_SLIME_HURT_SMALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_slime_hurt_small");

    public static final Supplier<SoundType> ENTITY_SLIME_JUMP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_slime_jump");

    public static final Supplier<SoundType> ENTITY_SLIME_JUMP_SMALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_slime_jump_small");

    public static final Supplier<SoundType> ENTITY_SLIME_SQUISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_slime_squish");

    public static final Supplier<SoundType> ENTITY_SLIME_SQUISH_SMALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_slime_squish_small");

    public static final Supplier<SoundType> ENTITY_SNOWBALL_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_snowball_throw");

    public static final Supplier<SoundType> ENTITY_SNOW_GOLEM_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_snow_golem_ambient");

    public static final Supplier<SoundType> ENTITY_SNOW_GOLEM_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_snow_golem_death");

    public static final Supplier<SoundType> ENTITY_SNOW_GOLEM_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_snow_golem_hurt");

    public static final Supplier<SoundType> ENTITY_SNOW_GOLEM_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_snow_golem_shoot");

    public static final Supplier<SoundType> ENTITY_SPIDER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_spider_ambient");

    public static final Supplier<SoundType> ENTITY_SPIDER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_spider_death");

    public static final Supplier<SoundType> ENTITY_SPIDER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_spider_hurt");

    public static final Supplier<SoundType> ENTITY_SPIDER_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_spider_step");

    public static final Supplier<SoundType> ENTITY_SPLASH_POTION_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_splash_potion_break");

    public static final Supplier<SoundType> ENTITY_SPLASH_POTION_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_splash_potion_throw");

    public static final Supplier<SoundType> ENTITY_SQUID_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_squid_ambient");

    public static final Supplier<SoundType> ENTITY_SQUID_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_squid_death");

    public static final Supplier<SoundType> ENTITY_SQUID_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_squid_hurt");

    public static final Supplier<SoundType> ENTITY_SQUID_SQUIRT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_squid_squirt");

    public static final Supplier<SoundType> ENTITY_STRAY_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_stray_ambient");

    public static final Supplier<SoundType> ENTITY_STRAY_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_stray_death");

    public static final Supplier<SoundType> ENTITY_STRAY_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_stray_hurt");

    public static final Supplier<SoundType> ENTITY_STRAY_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_stray_step");

    public static final Supplier<SoundType> ENTITY_TNT_PRIMED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_tnt_primed");

    public static final Supplier<SoundType> ENTITY_TROPICAL_FISH_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_tropical_fish_ambient");

    public static final Supplier<SoundType> ENTITY_TROPICAL_FISH_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_tropical_fish_death");

    public static final Supplier<SoundType> ENTITY_TROPICAL_FISH_FLOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_tropical_fish_flop");

    public static final Supplier<SoundType> ENTITY_TROPICAL_FISH_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_tropical_fish_hurt");

    public static final Supplier<SoundType> ENTITY_TURTLE_AMBIENT_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_turtle_ambient_land");

    public static final Supplier<SoundType> ENTITY_TURTLE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_turtle_death");

    public static final Supplier<SoundType> ENTITY_TURTLE_DEATH_BABY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_turtle_death_baby");

    public static final Supplier<SoundType> ENTITY_TURTLE_EGG_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_turtle_egg_break");

    public static final Supplier<SoundType> ENTITY_TURTLE_EGG_CRACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_turtle_egg_crack");

    public static final Supplier<SoundType> ENTITY_TURTLE_EGG_HATCH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_turtle_egg_hatch");

    public static final Supplier<SoundType> ENTITY_TURTLE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_turtle_hurt");

    public static final Supplier<SoundType> ENTITY_TURTLE_HURT_BABY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_turtle_hurt_baby");

    public static final Supplier<SoundType> ENTITY_TURTLE_LAY_EGG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_turtle_lay_egg");

    public static final Supplier<SoundType> ENTITY_TURTLE_SHAMBLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_turtle_shamble");

    public static final Supplier<SoundType> ENTITY_TURTLE_SHAMBLE_BABY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_turtle_shamble_baby");

    public static final Supplier<SoundType> ENTITY_TURTLE_SWIM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_turtle_swim");

    public static final Supplier<SoundType> ENTITY_VEX_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_vex_ambient");

    public static final Supplier<SoundType> ENTITY_VEX_CHARGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_vex_charge");

    public static final Supplier<SoundType> ENTITY_VEX_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_vex_death");

    public static final Supplier<SoundType> ENTITY_VEX_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_vex_hurt");

    public static final Supplier<SoundType> ENTITY_VILLAGER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_villager_ambient");

    public static final Supplier<SoundType> ENTITY_VILLAGER_CELEBRATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_villager_celebrate");

    public static final Supplier<SoundType> ENTITY_VILLAGER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_villager_death");

    public static final Supplier<SoundType> ENTITY_VILLAGER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_villager_hurt");

    public static final Supplier<SoundType> ENTITY_VILLAGER_NO = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_villager_no");

    public static final Supplier<SoundType> ENTITY_VILLAGER_TRADE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_villager_trade");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_ARMORER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_villager_work_armorer");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_BUTCHER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_villager_work_butcher");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_CARTOGRAPHER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_villager_work_cartographer");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_CLERIC = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_villager_work_cleric");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_FARMER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_villager_work_farmer");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_FISHERMAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_villager_work_fisherman");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_FLETCHER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_villager_work_fletcher");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_LEATHERWORKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_villager_work_leatherworker");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_LIBRARIAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_villager_work_librarian");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_MASON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_villager_work_mason");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_SHEPHERD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_villager_work_shepherd");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_TOOLSMITH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_villager_work_toolsmith");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_WEAPONSMITH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_villager_work_weaponsmith");

    public static final Supplier<SoundType> ENTITY_VILLAGER_YES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_villager_yes");

    public static final Supplier<SoundType> ENTITY_VINDICATOR_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_vindicator_ambient");

    public static final Supplier<SoundType> ENTITY_VINDICATOR_CELEBRATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_vindicator_celebrate");

    public static final Supplier<SoundType> ENTITY_VINDICATOR_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_vindicator_death");

    public static final Supplier<SoundType> ENTITY_VINDICATOR_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_vindicator_hurt");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wandering_trader_ambient");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wandering_trader_death");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_DISAPPEARED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wandering_trader_disappeared");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_DRINK_MILK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wandering_trader_drink_milk");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_DRINK_POTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wandering_trader_drink_potion");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wandering_trader_hurt");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_NO = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wandering_trader_no");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_REAPPEARED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wandering_trader_reappeared");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_TRADE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wandering_trader_trade");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_YES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wandering_trader_yes");

    public static final Supplier<SoundType> ENTITY_WITCH_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_witch_ambient");

    public static final Supplier<SoundType> ENTITY_WITCH_CELEBRATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_witch_celebrate");

    public static final Supplier<SoundType> ENTITY_WITCH_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_witch_death");

    public static final Supplier<SoundType> ENTITY_WITCH_DRINK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_witch_drink");

    public static final Supplier<SoundType> ENTITY_WITCH_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_witch_hurt");

    public static final Supplier<SoundType> ENTITY_WITCH_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_witch_throw");

    public static final Supplier<SoundType> ENTITY_WITHER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wither_ambient");

    public static final Supplier<SoundType> ENTITY_WITHER_BREAK_BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wither_break_block");

    public static final Supplier<SoundType> ENTITY_WITHER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wither_death");

    public static final Supplier<SoundType> ENTITY_WITHER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wither_hurt");

    public static final Supplier<SoundType> ENTITY_WITHER_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wither_shoot");

    public static final Supplier<SoundType> ENTITY_WITHER_SKELETON_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wither_skeleton_ambient");

    public static final Supplier<SoundType> ENTITY_WITHER_SKELETON_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wither_skeleton_death");

    public static final Supplier<SoundType> ENTITY_WITHER_SKELETON_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wither_skeleton_hurt");

    public static final Supplier<SoundType> ENTITY_WITHER_SKELETON_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wither_skeleton_step");

    public static final Supplier<SoundType> ENTITY_WITHER_SPAWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wither_spawn");

    public static final Supplier<SoundType> ENTITY_WOLF_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wolf_ambient");

    public static final Supplier<SoundType> ENTITY_WOLF_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wolf_death");

    public static final Supplier<SoundType> ENTITY_WOLF_GROWL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wolf_growl");

    public static final Supplier<SoundType> ENTITY_WOLF_HOWL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wolf_howl");

    public static final Supplier<SoundType> ENTITY_WOLF_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wolf_hurt");

    public static final Supplier<SoundType> ENTITY_WOLF_PANT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wolf_pant");

    public static final Supplier<SoundType> ENTITY_WOLF_SHAKE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wolf_shake");

    public static final Supplier<SoundType> ENTITY_WOLF_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wolf_step");

    public static final Supplier<SoundType> ENTITY_WOLF_WHINE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_wolf_whine");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_zombie_ambient");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_ATTACK_IRON_DOOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_zombie_attack_iron_door");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_ATTACK_WOODEN_DOOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_zombie_attack_wooden_door");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_BREAK_WOODEN_DOOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_zombie_break_wooden_door");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_CONVERTED_TO_DROWNED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_zombie_converted_to_drowned");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_zombie_death");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_DESTROY_EGG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_zombie_destroy_egg");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_HORSE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_zombie_horse_ambient");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_HORSE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_zombie_horse_death");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_HORSE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_zombie_horse_hurt");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_zombie_hurt");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_INFECT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_zombie_infect");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_PIGMAN_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_zombie_pigman_ambient");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_PIGMAN_ANGRY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_zombie_pigman_angry");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_PIGMAN_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_zombie_pigman_death");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_PIGMAN_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_zombie_pigman_hurt");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_zombie_step");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_VILLAGER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_zombie_villager_ambient");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_VILLAGER_CONVERTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_zombie_villager_converted");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_VILLAGER_CURE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_zombie_villager_cure");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_VILLAGER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_zombie_villager_death");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_VILLAGER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_zombie_villager_hurt");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_VILLAGER_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity_zombie_villager_step");

    public static final Supplier<SoundType> EVENT_RAID_HORN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "event_raid_horn");

    public static final Supplier<SoundType> ITEM_ARMOR_EQUIP_CHAIN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_armor_equip_chain");

    public static final Supplier<SoundType> ITEM_ARMOR_EQUIP_DIAMOND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_armor_equip_diamond");

    public static final Supplier<SoundType> ITEM_ARMOR_EQUIP_ELYTRA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_armor_equip_elytra");

    public static final Supplier<SoundType> ITEM_ARMOR_EQUIP_GENERIC = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_armor_equip_generic");

    public static final Supplier<SoundType> ITEM_ARMOR_EQUIP_GOLD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_armor_equip_gold");

    public static final Supplier<SoundType> ITEM_ARMOR_EQUIP_IRON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_armor_equip_iron");

    public static final Supplier<SoundType> ITEM_ARMOR_EQUIP_LEATHER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_armor_equip_leather");

    public static final Supplier<SoundType> ITEM_ARMOR_EQUIP_TURTLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_armor_equip_turtle");

    public static final Supplier<SoundType> ITEM_AXE_STRIP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_axe_strip");

    public static final Supplier<SoundType> ITEM_BOOK_PAGE_TURN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_book_page_turn");

    public static final Supplier<SoundType> ITEM_BOOK_PUT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_book_put");

    public static final Supplier<SoundType> ITEM_BOTTLE_EMPTY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_bottle_empty");

    public static final Supplier<SoundType> ITEM_BOTTLE_FILL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_bottle_fill");

    public static final Supplier<SoundType> ITEM_BOTTLE_FILL_DRAGONBREATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_bottle_fill_dragonbreath");

    public static final Supplier<SoundType> ITEM_BUCKET_EMPTY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_bucket_empty");

    public static final Supplier<SoundType> ITEM_BUCKET_EMPTY_FISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_bucket_empty_fish");

    public static final Supplier<SoundType> ITEM_BUCKET_EMPTY_LAVA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_bucket_empty_lava");

    public static final Supplier<SoundType> ITEM_BUCKET_FILL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_bucket_fill");

    public static final Supplier<SoundType> ITEM_BUCKET_FILL_FISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_bucket_fill_fish");

    public static final Supplier<SoundType> ITEM_BUCKET_FILL_LAVA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_bucket_fill_lava");

    public static final Supplier<SoundType> ITEM_CHORUS_FRUIT_TELEPORT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_chorus_fruit_teleport");

    public static final Supplier<SoundType> ITEM_CROP_PLANT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_crop_plant");

    public static final Supplier<SoundType> ITEM_CROSSBOW_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_crossbow_hit");

    public static final Supplier<SoundType> ITEM_CROSSBOW_LOADING_END = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_crossbow_loading_end");

    public static final Supplier<SoundType> ITEM_CROSSBOW_LOADING_MIDDLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_crossbow_loading_middle");

    public static final Supplier<SoundType> ITEM_CROSSBOW_LOADING_START = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_crossbow_loading_start");

    public static final Supplier<SoundType> ITEM_CROSSBOW_QUICK_CHARGE_1 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_CROSSBOW_QUICK_CHARGE_1");

    public static final Supplier<SoundType> ITEM_CROSSBOW_QUICK_CHARGE_2 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_CROSSBOW_QUICK_CHARGE_2");

    public static final Supplier<SoundType> ITEM_CROSSBOW_QUICK_CHARGE_3 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_CROSSBOW_QUICK_CHARGE_3");

    public static final Supplier<SoundType> ITEM_CROSSBOW_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_crossbow_shoot");

    public static final Supplier<SoundType> ITEM_ELYTRA_FLYING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_elytra_flying");

    public static final Supplier<SoundType> ITEM_FIRECHARGE_USE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_firecharge_use");

    public static final Supplier<SoundType> ITEM_FLINTANDSTEEL_USE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_flintandsteel_use");

    public static final Supplier<SoundType> ITEM_HOE_TILL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_hoe_till");

    public static final Supplier<SoundType> ITEM_NETHER_WART_PLANT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_nether_wart_plant");

    public static final Supplier<SoundType> ITEM_SHIELD_BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_shield_block");

    public static final Supplier<SoundType> ITEM_SHIELD_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_shield_break");

    public static final Supplier<SoundType> ITEM_SHOVEL_FLATTEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_shovel_flatten");

    public static final Supplier<SoundType> ITEM_SWEET_BERRIES_PICK_FROM_BUSH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_sweet_berries_pick_from_bush");

    public static final Supplier<SoundType> ITEM_TOTEM_USE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_totem_use");

    public static final Supplier<SoundType> ITEM_TRIDENT_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_trident_hit");

    public static final Supplier<SoundType> ITEM_TRIDENT_HIT_GROUND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_trident_hit_ground");

    public static final Supplier<SoundType> ITEM_TRIDENT_RETURN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_trident_return");

    public static final Supplier<SoundType> ITEM_TRIDENT_RIPTIDE_1 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_TRIDENT_RIPTIDE_1");

    public static final Supplier<SoundType> ITEM_TRIDENT_RIPTIDE_2 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_TRIDENT_RIPTIDE_2");

    public static final Supplier<SoundType> ITEM_TRIDENT_RIPTIDE_3 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_TRIDENT_RIPTIDE_3");

    public static final Supplier<SoundType> ITEM_TRIDENT_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_trident_throw");

    public static final Supplier<SoundType> ITEM_TRIDENT_THUNDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item_trident_thunder");

    public static final Supplier<SoundType> MUSIC_CREATIVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_creative");

    public static final Supplier<SoundType> MUSIC_CREDITS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_credits");

    public static final Supplier<SoundType> MUSIC_DISC_11 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "MUSIC_DISC_11");

    public static final Supplier<SoundType> MUSIC_DISC_13 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "MUSIC_DISC_13");

    public static final Supplier<SoundType> MUSIC_DISC_BLOCKS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_disc_blocks");

    public static final Supplier<SoundType> MUSIC_DISC_CAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_disc_cat");

    public static final Supplier<SoundType> MUSIC_DISC_CHIRP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_disc_chirp");

    public static final Supplier<SoundType> MUSIC_DISC_FAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_disc_far");

    public static final Supplier<SoundType> MUSIC_DISC_MALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_disc_mall");

    public static final Supplier<SoundType> MUSIC_DISC_MELLOHI = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_disc_mellohi");

    public static final Supplier<SoundType> MUSIC_DISC_STAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_disc_stal");

    public static final Supplier<SoundType> MUSIC_DISC_STRAD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_disc_strad");

    public static final Supplier<SoundType> MUSIC_DISC_WAIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_disc_wait");

    public static final Supplier<SoundType> MUSIC_DISC_WARD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_disc_ward");

    public static final Supplier<SoundType> MUSIC_DRAGON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_dragon");

    public static final Supplier<SoundType> MUSIC_END = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_end");

    public static final Supplier<SoundType> MUSIC_GAME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_game");

    public static final Supplier<SoundType> MUSIC_MENU = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_menu");

    public static final Supplier<SoundType> MUSIC_NETHER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_nether");

    public static final Supplier<SoundType> MUSIC_UNDER_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_under_water");

    public static final Supplier<SoundType> UI_BUTTON_CLICK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ui_button_click");

    public static final Supplier<SoundType> UI_CARTOGRAPHY_TABLE_TAKE_RESULT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ui_cartography_table_take_result");

    public static final Supplier<SoundType> UI_LOOM_SELECT_PATTERN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ui_loom_select_pattern");

    public static final Supplier<SoundType> UI_LOOM_TAKE_RESULT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ui_loom_take_result");

    public static final Supplier<SoundType> UI_STONECUTTER_SELECT_RECIPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ui_stonecutter_select_recipe");

    public static final Supplier<SoundType> UI_STONECUTTER_TAKE_RESULT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ui_stonecutter_take_result");

    public static final Supplier<SoundType> UI_TOAST_CHALLENGE_COMPLETE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ui_toast_challenge_complete");

    public static final Supplier<SoundType> UI_TOAST_IN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ui_toast_in");

    public static final Supplier<SoundType> UI_TOAST_OUT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ui_toast_out");

    public static final Supplier<SoundType> WEATHER_RAIN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "weather_rain");

    public static final Supplier<SoundType> WEATHER_RAIN_ABOVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "weather_rain_above");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private SoundTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
