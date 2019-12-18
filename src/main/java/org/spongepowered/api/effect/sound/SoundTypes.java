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

    public static final Supplier<SoundType> AMBIENT_CAVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "AMBIENT_CAVE");

    public static final Supplier<SoundType> AMBIENT_UNDERWATER_ENTER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "AMBIENT_UNDERWATER_ENTER");

    public static final Supplier<SoundType> AMBIENT_UNDERWATER_EXIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "AMBIENT_UNDERWATER_EXIT");

    public static final Supplier<SoundType> AMBIENT_UNDERWATER_LOOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "AMBIENT_UNDERWATER_LOOP");

    public static final Supplier<SoundType> AMBIENT_UNDERWATER_LOOP_ADDITIONS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "AMBIENT_UNDERWATER_LOOP_ADDITIONS");

    public static final Supplier<SoundType> AMBIENT_UNDERWATER_LOOP_ADDITIONS_RARE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "AMBIENT_UNDERWATER_LOOP_ADDITIONS_RARE");

    public static final Supplier<SoundType> AMBIENT_UNDERWATER_LOOP_ADDITIONS_ULTRA_RARE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "AMBIENT_UNDERWATER_LOOP_ADDITIONS_ULTRA_RARE");

    public static final Supplier<SoundType> BLOCK_ANVIL_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_ANVIL_BREAK");

    public static final Supplier<SoundType> BLOCK_ANVIL_DESTROY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_ANVIL_DESTROY");

    public static final Supplier<SoundType> BLOCK_ANVIL_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_ANVIL_FALL");

    public static final Supplier<SoundType> BLOCK_ANVIL_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_ANVIL_HIT");

    public static final Supplier<SoundType> BLOCK_ANVIL_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_ANVIL_LAND");

    public static final Supplier<SoundType> BLOCK_ANVIL_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_ANVIL_PLACE");

    public static final Supplier<SoundType> BLOCK_ANVIL_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_ANVIL_STEP");

    public static final Supplier<SoundType> BLOCK_ANVIL_USE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_ANVIL_USE");

    public static final Supplier<SoundType> BLOCK_BAMBOO_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_BAMBOO_BREAK");

    public static final Supplier<SoundType> BLOCK_BAMBOO_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_BAMBOO_FALL");

    public static final Supplier<SoundType> BLOCK_BAMBOO_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_BAMBOO_HIT");

    public static final Supplier<SoundType> BLOCK_BAMBOO_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_BAMBOO_PLACE");

    public static final Supplier<SoundType> BLOCK_BAMBOO_SAPLING_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_BAMBOO_SAPLING_BREAK");

    public static final Supplier<SoundType> BLOCK_BAMBOO_SAPLING_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_BAMBOO_SAPLING_HIT");

    public static final Supplier<SoundType> BLOCK_BAMBOO_SAPLING_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_BAMBOO_SAPLING_PLACE");

    public static final Supplier<SoundType> BLOCK_BAMBOO_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_BAMBOO_STEP");

    public static final Supplier<SoundType> BLOCK_BARREL_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_BARREL_CLOSE");

    public static final Supplier<SoundType> BLOCK_BARREL_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_BARREL_OPEN");

    public static final Supplier<SoundType> BLOCK_BEACON_ACTIVATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_BEACON_ACTIVATE");

    public static final Supplier<SoundType> BLOCK_BEACON_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_BEACON_AMBIENT");

    public static final Supplier<SoundType> BLOCK_BEACON_DEACTIVATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_BEACON_DEACTIVATE");

    public static final Supplier<SoundType> BLOCK_BEACON_POWER_SELECT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_BEACON_POWER_SELECT");

    public static final Supplier<SoundType> BLOCK_BELL_RESONATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_BELL_RESONATE");

    public static final Supplier<SoundType> BLOCK_BELL_USE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_BELL_USE");

    public static final Supplier<SoundType> BLOCK_BLASTFURNACE_FIRE_CRACKLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_BLASTFURNACE_FIRE_CRACKLE");

    public static final Supplier<SoundType> BLOCK_BREWING_STAND_BREW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_BREWING_STAND_BREW");

    public static final Supplier<SoundType> BLOCK_BUBBLE_COLUMN_BUBBLE_POP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_BUBBLE_COLUMN_BUBBLE_POP");

    public static final Supplier<SoundType> BLOCK_BUBBLE_COLUMN_UPWARDS_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_BUBBLE_COLUMN_UPWARDS_AMBIENT");

    public static final Supplier<SoundType> BLOCK_BUBBLE_COLUMN_UPWARDS_INSIDE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_BUBBLE_COLUMN_UPWARDS_INSIDE");

    public static final Supplier<SoundType> BLOCK_BUBBLE_COLUMN_WHIRLPOOL_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_BUBBLE_COLUMN_WHIRLPOOL_AMBIENT");

    public static final Supplier<SoundType> BLOCK_BUBBLE_COLUMN_WHIRLPOOL_INSIDE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_BUBBLE_COLUMN_WHIRLPOOL_INSIDE");

    public static final Supplier<SoundType> BLOCK_CAMPFIRE_CRACKLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_CAMPFIRE_CRACKLE");

    public static final Supplier<SoundType> BLOCK_CHEST_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_CHEST_CLOSE");

    public static final Supplier<SoundType> BLOCK_CHEST_LOCKED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_CHEST_LOCKED");

    public static final Supplier<SoundType> BLOCK_CHEST_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_CHEST_OPEN");

    public static final Supplier<SoundType> BLOCK_CHORUS_FLOWER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_CHORUS_FLOWER_DEATH");

    public static final Supplier<SoundType> BLOCK_CHORUS_FLOWER_GROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_CHORUS_FLOWER_GROW");

    public static final Supplier<SoundType> BLOCK_COMPARATOR_CLICK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_COMPARATOR_CLICK");

    public static final Supplier<SoundType> BLOCK_COMPOSTER_EMPTY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_COMPOSTER_EMPTY");

    public static final Supplier<SoundType> BLOCK_COMPOSTER_FILL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_COMPOSTER_FILL");

    public static final Supplier<SoundType> BLOCK_COMPOSTER_FILL_SUCCESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_COMPOSTER_FILL_SUCCESS");

    public static final Supplier<SoundType> BLOCK_COMPOSTER_READY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_COMPOSTER_READY");

    public static final Supplier<SoundType> BLOCK_CONDUIT_ACTIVATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_CONDUIT_ACTIVATE");

    public static final Supplier<SoundType> BLOCK_CONDUIT_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_CONDUIT_AMBIENT");

    public static final Supplier<SoundType> BLOCK_CONDUIT_AMBIENT_SHORT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_CONDUIT_AMBIENT_SHORT");

    public static final Supplier<SoundType> BLOCK_CONDUIT_ATTACK_TARGET = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_CONDUIT_ATTACK_TARGET");

    public static final Supplier<SoundType> BLOCK_CONDUIT_DEACTIVATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_CONDUIT_DEACTIVATE");

    public static final Supplier<SoundType> BLOCK_CORAL_BLOCK_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_CORAL_BLOCK_BREAK");

    public static final Supplier<SoundType> BLOCK_CORAL_BLOCK_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_CORAL_BLOCK_FALL");

    public static final Supplier<SoundType> BLOCK_CORAL_BLOCK_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_CORAL_BLOCK_HIT");

    public static final Supplier<SoundType> BLOCK_CORAL_BLOCK_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_CORAL_BLOCK_PLACE");

    public static final Supplier<SoundType> BLOCK_CORAL_BLOCK_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_CORAL_BLOCK_STEP");

    public static final Supplier<SoundType> BLOCK_CROP_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_CROP_BREAK");

    public static final Supplier<SoundType> BLOCK_DISPENSER_DISPENSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_DISPENSER_DISPENSE");

    public static final Supplier<SoundType> BLOCK_DISPENSER_FAIL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_DISPENSER_FAIL");

    public static final Supplier<SoundType> BLOCK_DISPENSER_LAUNCH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_DISPENSER_LAUNCH");

    public static final Supplier<SoundType> BLOCK_ENCHANTMENT_TABLE_USE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_ENCHANTMENT_TABLE_USE");

    public static final Supplier<SoundType> BLOCK_ENDER_CHEST_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_ENDER_CHEST_CLOSE");

    public static final Supplier<SoundType> BLOCK_ENDER_CHEST_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_ENDER_CHEST_OPEN");

    public static final Supplier<SoundType> BLOCK_END_GATEWAY_SPAWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_END_GATEWAY_SPAWN");

    public static final Supplier<SoundType> BLOCK_END_PORTAL_FRAME_FILL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_END_PORTAL_FRAME_FILL");

    public static final Supplier<SoundType> BLOCK_END_PORTAL_SPAWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_END_PORTAL_SPAWN");

    public static final Supplier<SoundType> BLOCK_FENCE_GATE_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_FENCE_GATE_CLOSE");

    public static final Supplier<SoundType> BLOCK_FENCE_GATE_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_FENCE_GATE_OPEN");

    public static final Supplier<SoundType> BLOCK_FIRE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_FIRE_AMBIENT");

    public static final Supplier<SoundType> BLOCK_FIRE_EXTINGUISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_FIRE_EXTINGUISH");

    public static final Supplier<SoundType> BLOCK_FURNACE_FIRE_CRACKLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_FURNACE_FIRE_CRACKLE");

    public static final Supplier<SoundType> BLOCK_GLASS_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_GLASS_BREAK");

    public static final Supplier<SoundType> BLOCK_GLASS_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_GLASS_FALL");

    public static final Supplier<SoundType> BLOCK_GLASS_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_GLASS_HIT");

    public static final Supplier<SoundType> BLOCK_GLASS_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_GLASS_PLACE");

    public static final Supplier<SoundType> BLOCK_GLASS_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_GLASS_STEP");

    public static final Supplier<SoundType> BLOCK_GRASS_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_GRASS_BREAK");

    public static final Supplier<SoundType> BLOCK_GRASS_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_GRASS_FALL");

    public static final Supplier<SoundType> BLOCK_GRASS_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_GRASS_HIT");

    public static final Supplier<SoundType> BLOCK_GRASS_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_GRASS_PLACE");

    public static final Supplier<SoundType> BLOCK_GRASS_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_GRASS_STEP");

    public static final Supplier<SoundType> BLOCK_GRAVEL_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_GRAVEL_BREAK");

    public static final Supplier<SoundType> BLOCK_GRAVEL_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_GRAVEL_FALL");

    public static final Supplier<SoundType> BLOCK_GRAVEL_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_GRAVEL_HIT");

    public static final Supplier<SoundType> BLOCK_GRAVEL_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_GRAVEL_PLACE");

    public static final Supplier<SoundType> BLOCK_GRAVEL_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_GRAVEL_STEP");

    public static final Supplier<SoundType> BLOCK_GRINDSTONE_USE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_GRINDSTONE_USE");

    public static final Supplier<SoundType> BLOCK_IRON_DOOR_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_IRON_DOOR_CLOSE");

    public static final Supplier<SoundType> BLOCK_IRON_DOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_IRON_DOOR_OPEN");

    public static final Supplier<SoundType> BLOCK_IRON_TRAPDOOR_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_IRON_TRAPDOOR_CLOSE");

    public static final Supplier<SoundType> BLOCK_IRON_TRAPDOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_IRON_TRAPDOOR_OPEN");

    public static final Supplier<SoundType> BLOCK_LADDER_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_LADDER_BREAK");

    public static final Supplier<SoundType> BLOCK_LADDER_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_LADDER_FALL");

    public static final Supplier<SoundType> BLOCK_LADDER_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_LADDER_HIT");

    public static final Supplier<SoundType> BLOCK_LADDER_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_LADDER_PLACE");

    public static final Supplier<SoundType> BLOCK_LADDER_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_LADDER_STEP");

    public static final Supplier<SoundType> BLOCK_LANTERN_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_LANTERN_BREAK");

    public static final Supplier<SoundType> BLOCK_LANTERN_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_LANTERN_FALL");

    public static final Supplier<SoundType> BLOCK_LANTERN_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_LANTERN_HIT");

    public static final Supplier<SoundType> BLOCK_LANTERN_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_LANTERN_PLACE");

    public static final Supplier<SoundType> BLOCK_LANTERN_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_LANTERN_STEP");

    public static final Supplier<SoundType> BLOCK_LAVA_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_LAVA_AMBIENT");

    public static final Supplier<SoundType> BLOCK_LAVA_EXTINGUISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_LAVA_EXTINGUISH");

    public static final Supplier<SoundType> BLOCK_LAVA_POP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_LAVA_POP");

    public static final Supplier<SoundType> BLOCK_LEVER_CLICK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_LEVER_CLICK");

    public static final Supplier<SoundType> BLOCK_LILY_PAD_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_LILY_PAD_PLACE");

    public static final Supplier<SoundType> BLOCK_METAL_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_METAL_BREAK");

    public static final Supplier<SoundType> BLOCK_METAL_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_METAL_FALL");

    public static final Supplier<SoundType> BLOCK_METAL_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_METAL_HIT");

    public static final Supplier<SoundType> BLOCK_METAL_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_METAL_PLACE");

    public static final Supplier<SoundType> BLOCK_METAL_PRESSURE_PLATE_CLICK_OFF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_METAL_PRESSURE_PLATE_CLICK_OFF");

    public static final Supplier<SoundType> BLOCK_METAL_PRESSURE_PLATE_CLICK_ON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_METAL_PRESSURE_PLATE_CLICK_ON");

    public static final Supplier<SoundType> BLOCK_METAL_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_METAL_STEP");

    public static final Supplier<SoundType> BLOCK_NETHER_WART_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_NETHER_WART_BREAK");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_BANJO = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_NOTE_BLOCK_BANJO");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_BASEDRUM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_NOTE_BLOCK_BASEDRUM");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_BASS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_NOTE_BLOCK_BASS");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_BELL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_NOTE_BLOCK_BELL");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_BIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_NOTE_BLOCK_BIT");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_CHIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_NOTE_BLOCK_CHIME");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_COW_BELL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_NOTE_BLOCK_COW_BELL");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_DIDGERIDOO = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_NOTE_BLOCK_DIDGERIDOO");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_FLUTE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_NOTE_BLOCK_FLUTE");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_GUITAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_NOTE_BLOCK_GUITAR");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_HARP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_NOTE_BLOCK_HARP");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_HAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_NOTE_BLOCK_HAT");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_IRON_XYLOPHONE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_NOTE_BLOCK_IRON_XYLOPHONE");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_PLING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_NOTE_BLOCK_PLING");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_SNARE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_NOTE_BLOCK_SNARE");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_XYLOPHONE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_NOTE_BLOCK_XYLOPHONE");

    public static final Supplier<SoundType> BLOCK_PISTON_CONTRACT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_PISTON_CONTRACT");

    public static final Supplier<SoundType> BLOCK_PISTON_EXTEND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_PISTON_EXTEND");

    public static final Supplier<SoundType> BLOCK_PORTAL_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_PORTAL_AMBIENT");

    public static final Supplier<SoundType> BLOCK_PORTAL_TRAVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_PORTAL_TRAVEL");

    public static final Supplier<SoundType> BLOCK_PORTAL_TRIGGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_PORTAL_TRIGGER");

    public static final Supplier<SoundType> BLOCK_PUMPKIN_CARVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_PUMPKIN_CARVE");

    public static final Supplier<SoundType> BLOCK_REDSTONE_TORCH_BURNOUT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_REDSTONE_TORCH_BURNOUT");

    public static final Supplier<SoundType> BLOCK_SAND_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_SAND_BREAK");

    public static final Supplier<SoundType> BLOCK_SAND_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_SAND_FALL");

    public static final Supplier<SoundType> BLOCK_SAND_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_SAND_HIT");

    public static final Supplier<SoundType> BLOCK_SAND_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_SAND_PLACE");

    public static final Supplier<SoundType> BLOCK_SAND_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_SAND_STEP");

    public static final Supplier<SoundType> BLOCK_SCAFFOLDING_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_SCAFFOLDING_BREAK");

    public static final Supplier<SoundType> BLOCK_SCAFFOLDING_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_SCAFFOLDING_FALL");

    public static final Supplier<SoundType> BLOCK_SCAFFOLDING_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_SCAFFOLDING_HIT");

    public static final Supplier<SoundType> BLOCK_SCAFFOLDING_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_SCAFFOLDING_PLACE");

    public static final Supplier<SoundType> BLOCK_SCAFFOLDING_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_SCAFFOLDING_STEP");

    public static final Supplier<SoundType> BLOCK_SHULKER_BOX_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_SHULKER_BOX_CLOSE");

    public static final Supplier<SoundType> BLOCK_SHULKER_BOX_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_SHULKER_BOX_OPEN");

    public static final Supplier<SoundType> BLOCK_SLIME_BLOCK_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_SLIME_BLOCK_BREAK");

    public static final Supplier<SoundType> BLOCK_SLIME_BLOCK_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_SLIME_BLOCK_FALL");

    public static final Supplier<SoundType> BLOCK_SLIME_BLOCK_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_SLIME_BLOCK_HIT");

    public static final Supplier<SoundType> BLOCK_SLIME_BLOCK_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_SLIME_BLOCK_PLACE");

    public static final Supplier<SoundType> BLOCK_SLIME_BLOCK_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_SLIME_BLOCK_STEP");

    public static final Supplier<SoundType> BLOCK_SMOKER_SMOKE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_SMOKER_SMOKE");

    public static final Supplier<SoundType> BLOCK_SNOW_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_SNOW_BREAK");

    public static final Supplier<SoundType> BLOCK_SNOW_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_SNOW_FALL");

    public static final Supplier<SoundType> BLOCK_SNOW_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_SNOW_HIT");

    public static final Supplier<SoundType> BLOCK_SNOW_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_SNOW_PLACE");

    public static final Supplier<SoundType> BLOCK_SNOW_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_SNOW_STEP");

    public static final Supplier<SoundType> BLOCK_STONE_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_STONE_BREAK");

    public static final Supplier<SoundType> BLOCK_STONE_BUTTON_CLICK_OFF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_STONE_BUTTON_CLICK_OFF");

    public static final Supplier<SoundType> BLOCK_STONE_BUTTON_CLICK_ON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_STONE_BUTTON_CLICK_ON");

    public static final Supplier<SoundType> BLOCK_STONE_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_STONE_FALL");

    public static final Supplier<SoundType> BLOCK_STONE_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_STONE_HIT");

    public static final Supplier<SoundType> BLOCK_STONE_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_STONE_PLACE");

    public static final Supplier<SoundType> BLOCK_STONE_PRESSURE_PLATE_CLICK_OFF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_STONE_PRESSURE_PLATE_CLICK_OFF");

    public static final Supplier<SoundType> BLOCK_STONE_PRESSURE_PLATE_CLICK_ON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_STONE_PRESSURE_PLATE_CLICK_ON");

    public static final Supplier<SoundType> BLOCK_STONE_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_STONE_STEP");

    public static final Supplier<SoundType> BLOCK_SWEET_BERRY_BUSH_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_SWEET_BERRY_BUSH_BREAK");

    public static final Supplier<SoundType> BLOCK_SWEET_BERRY_BUSH_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_SWEET_BERRY_BUSH_PLACE");

    public static final Supplier<SoundType> BLOCK_TRIPWIRE_ATTACH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_TRIPWIRE_ATTACH");

    public static final Supplier<SoundType> BLOCK_TRIPWIRE_CLICK_OFF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_TRIPWIRE_CLICK_OFF");

    public static final Supplier<SoundType> BLOCK_TRIPWIRE_CLICK_ON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_TRIPWIRE_CLICK_ON");

    public static final Supplier<SoundType> BLOCK_TRIPWIRE_DETACH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_TRIPWIRE_DETACH");

    public static final Supplier<SoundType> BLOCK_WATER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_WATER_AMBIENT");

    public static final Supplier<SoundType> BLOCK_WET_GRASS_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_WET_GRASS_BREAK");

    public static final Supplier<SoundType> BLOCK_WET_GRASS_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_WET_GRASS_FALL");

    public static final Supplier<SoundType> BLOCK_WET_GRASS_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_WET_GRASS_HIT");

    public static final Supplier<SoundType> BLOCK_WET_GRASS_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_WET_GRASS_PLACE");

    public static final Supplier<SoundType> BLOCK_WET_GRASS_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_WET_GRASS_STEP");

    public static final Supplier<SoundType> BLOCK_WOODEN_BUTTON_CLICK_OFF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_WOODEN_BUTTON_CLICK_OFF");

    public static final Supplier<SoundType> BLOCK_WOODEN_BUTTON_CLICK_ON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_WOODEN_BUTTON_CLICK_ON");

    public static final Supplier<SoundType> BLOCK_WOODEN_DOOR_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_WOODEN_DOOR_CLOSE");

    public static final Supplier<SoundType> BLOCK_WOODEN_DOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_WOODEN_DOOR_OPEN");

    public static final Supplier<SoundType> BLOCK_WOODEN_PRESSURE_PLATE_CLICK_OFF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_WOODEN_PRESSURE_PLATE_CLICK_OFF");

    public static final Supplier<SoundType> BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON");

    public static final Supplier<SoundType> BLOCK_WOODEN_TRAPDOOR_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_WOODEN_TRAPDOOR_CLOSE");

    public static final Supplier<SoundType> BLOCK_WOODEN_TRAPDOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_WOODEN_TRAPDOOR_OPEN");

    public static final Supplier<SoundType> BLOCK_WOOD_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_WOOD_BREAK");

    public static final Supplier<SoundType> BLOCK_WOOD_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_WOOD_FALL");

    public static final Supplier<SoundType> BLOCK_WOOD_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_WOOD_HIT");

    public static final Supplier<SoundType> BLOCK_WOOD_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_WOOD_PLACE");

    public static final Supplier<SoundType> BLOCK_WOOD_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_WOOD_STEP");

    public static final Supplier<SoundType> BLOCK_WOOL_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_WOOL_BREAK");

    public static final Supplier<SoundType> BLOCK_WOOL_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_WOOL_FALL");

    public static final Supplier<SoundType> BLOCK_WOOL_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_WOOL_HIT");

    public static final Supplier<SoundType> BLOCK_WOOL_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_WOOL_PLACE");

    public static final Supplier<SoundType> BLOCK_WOOL_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "BLOCK_WOOL_STEP");

    public static final Supplier<SoundType> ENCHANT_THORNS_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENCHANT_THORNS_HIT");

    public static final Supplier<SoundType> ENTITY_ARMOR_STAND_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ARMOR_STAND_BREAK");

    public static final Supplier<SoundType> ENTITY_ARMOR_STAND_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ARMOR_STAND_FALL");

    public static final Supplier<SoundType> ENTITY_ARMOR_STAND_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ARMOR_STAND_HIT");

    public static final Supplier<SoundType> ENTITY_ARMOR_STAND_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ARMOR_STAND_PLACE");

    public static final Supplier<SoundType> ENTITY_ARROW_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ARROW_HIT");

    public static final Supplier<SoundType> ENTITY_ARROW_HIT_PLAYER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ARROW_HIT_PLAYER");

    public static final Supplier<SoundType> ENTITY_ARROW_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ARROW_SHOOT");

    public static final Supplier<SoundType> ENTITY_BAT_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_BAT_AMBIENT");

    public static final Supplier<SoundType> ENTITY_BAT_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_BAT_DEATH");

    public static final Supplier<SoundType> ENTITY_BAT_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_BAT_HURT");

    public static final Supplier<SoundType> ENTITY_BAT_LOOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_BAT_LOOP");

    public static final Supplier<SoundType> ENTITY_BAT_TAKEOFF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_BAT_TAKEOFF");

    public static final Supplier<SoundType> ENTITY_BLAZE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_BLAZE_AMBIENT");

    public static final Supplier<SoundType> ENTITY_BLAZE_BURN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_BLAZE_BURN");

    public static final Supplier<SoundType> ENTITY_BLAZE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_BLAZE_DEATH");

    public static final Supplier<SoundType> ENTITY_BLAZE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_BLAZE_HURT");

    public static final Supplier<SoundType> ENTITY_BLAZE_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_BLAZE_SHOOT");

    public static final Supplier<SoundType> ENTITY_BOAT_PADDLE_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_BOAT_PADDLE_LAND");

    public static final Supplier<SoundType> ENTITY_BOAT_PADDLE_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_BOAT_PADDLE_WATER");

    public static final Supplier<SoundType> ENTITY_CAT_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_CAT_AMBIENT");

    public static final Supplier<SoundType> ENTITY_CAT_BEG_FOR_FOOD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_CAT_BEG_FOR_FOOD");

    public static final Supplier<SoundType> ENTITY_CAT_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_CAT_DEATH");

    public static final Supplier<SoundType> ENTITY_CAT_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_CAT_EAT");

    public static final Supplier<SoundType> ENTITY_CAT_HISS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_CAT_HISS");

    public static final Supplier<SoundType> ENTITY_CAT_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_CAT_HURT");

    public static final Supplier<SoundType> ENTITY_CAT_PURR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_CAT_PURR");

    public static final Supplier<SoundType> ENTITY_CAT_PURREOW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_CAT_PURREOW");

    public static final Supplier<SoundType> ENTITY_CAT_STRAY_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_CAT_STRAY_AMBIENT");

    public static final Supplier<SoundType> ENTITY_CHICKEN_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_CHICKEN_AMBIENT");

    public static final Supplier<SoundType> ENTITY_CHICKEN_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_CHICKEN_DEATH");

    public static final Supplier<SoundType> ENTITY_CHICKEN_EGG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_CHICKEN_EGG");

    public static final Supplier<SoundType> ENTITY_CHICKEN_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_CHICKEN_HURT");

    public static final Supplier<SoundType> ENTITY_CHICKEN_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_CHICKEN_STEP");

    public static final Supplier<SoundType> ENTITY_COD_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_COD_AMBIENT");

    public static final Supplier<SoundType> ENTITY_COD_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_COD_DEATH");

    public static final Supplier<SoundType> ENTITY_COD_FLOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_COD_FLOP");

    public static final Supplier<SoundType> ENTITY_COD_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_COD_HURT");

    public static final Supplier<SoundType> ENTITY_COW_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_COW_AMBIENT");

    public static final Supplier<SoundType> ENTITY_COW_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_COW_DEATH");

    public static final Supplier<SoundType> ENTITY_COW_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_COW_HURT");

    public static final Supplier<SoundType> ENTITY_COW_MILK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_COW_MILK");

    public static final Supplier<SoundType> ENTITY_COW_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_COW_STEP");

    public static final Supplier<SoundType> ENTITY_CREEPER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_CREEPER_DEATH");

    public static final Supplier<SoundType> ENTITY_CREEPER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_CREEPER_HURT");

    public static final Supplier<SoundType> ENTITY_CREEPER_PRIMED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_CREEPER_PRIMED");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_DOLPHIN_AMBIENT");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_AMBIENT_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_DOLPHIN_AMBIENT_WATER");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_DOLPHIN_ATTACK");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_DOLPHIN_DEATH");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_DOLPHIN_EAT");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_DOLPHIN_HURT");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_JUMP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_DOLPHIN_JUMP");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_PLAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_DOLPHIN_PLAY");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_SPLASH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_DOLPHIN_SPLASH");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_SWIM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_DOLPHIN_SWIM");

    public static final Supplier<SoundType> ENTITY_DONKEY_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_DONKEY_AMBIENT");

    public static final Supplier<SoundType> ENTITY_DONKEY_ANGRY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_DONKEY_ANGRY");

    public static final Supplier<SoundType> ENTITY_DONKEY_CHEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_DONKEY_CHEST");

    public static final Supplier<SoundType> ENTITY_DONKEY_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_DONKEY_DEATH");

    public static final Supplier<SoundType> ENTITY_DONKEY_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_DONKEY_HURT");

    public static final Supplier<SoundType> ENTITY_DRAGON_FIREBALL_EXPLODE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_DRAGON_FIREBALL_EXPLODE");

    public static final Supplier<SoundType> ENTITY_DROWNED_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_DROWNED_AMBIENT");

    public static final Supplier<SoundType> ENTITY_DROWNED_AMBIENT_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_DROWNED_AMBIENT_WATER");

    public static final Supplier<SoundType> ENTITY_DROWNED_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_DROWNED_DEATH");

    public static final Supplier<SoundType> ENTITY_DROWNED_DEATH_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_DROWNED_DEATH_WATER");

    public static final Supplier<SoundType> ENTITY_DROWNED_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_DROWNED_HURT");

    public static final Supplier<SoundType> ENTITY_DROWNED_HURT_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_DROWNED_HURT_WATER");

    public static final Supplier<SoundType> ENTITY_DROWNED_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_DROWNED_SHOOT");

    public static final Supplier<SoundType> ENTITY_DROWNED_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_DROWNED_STEP");

    public static final Supplier<SoundType> ENTITY_DROWNED_SWIM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_DROWNED_SWIM");

    public static final Supplier<SoundType> ENTITY_EGG_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_EGG_THROW");

    public static final Supplier<SoundType> ENTITY_ELDER_GUARDIAN_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ELDER_GUARDIAN_AMBIENT");

    public static final Supplier<SoundType> ENTITY_ELDER_GUARDIAN_AMBIENT_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ELDER_GUARDIAN_AMBIENT_LAND");

    public static final Supplier<SoundType> ENTITY_ELDER_GUARDIAN_CURSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ELDER_GUARDIAN_CURSE");

    public static final Supplier<SoundType> ENTITY_ELDER_GUARDIAN_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ELDER_GUARDIAN_DEATH");

    public static final Supplier<SoundType> ENTITY_ELDER_GUARDIAN_DEATH_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ELDER_GUARDIAN_DEATH_LAND");

    public static final Supplier<SoundType> ENTITY_ELDER_GUARDIAN_FLOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ELDER_GUARDIAN_FLOP");

    public static final Supplier<SoundType> ENTITY_ELDER_GUARDIAN_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ELDER_GUARDIAN_HURT");

    public static final Supplier<SoundType> ENTITY_ELDER_GUARDIAN_HURT_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ELDER_GUARDIAN_HURT_LAND");

    public static final Supplier<SoundType> ENTITY_ENDERMAN_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ENDERMAN_AMBIENT");

    public static final Supplier<SoundType> ENTITY_ENDERMAN_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ENDERMAN_DEATH");

    public static final Supplier<SoundType> ENTITY_ENDERMAN_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ENDERMAN_HURT");

    public static final Supplier<SoundType> ENTITY_ENDERMAN_SCREAM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ENDERMAN_SCREAM");

    public static final Supplier<SoundType> ENTITY_ENDERMAN_STARE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ENDERMAN_STARE");

    public static final Supplier<SoundType> ENTITY_ENDERMAN_TELEPORT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ENDERMAN_TELEPORT");

    public static final Supplier<SoundType> ENTITY_ENDERMITE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ENDERMITE_AMBIENT");

    public static final Supplier<SoundType> ENTITY_ENDERMITE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ENDERMITE_DEATH");

    public static final Supplier<SoundType> ENTITY_ENDERMITE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ENDERMITE_HURT");

    public static final Supplier<SoundType> ENTITY_ENDERMITE_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ENDERMITE_STEP");

    public static final Supplier<SoundType> ENTITY_ENDER_DRAGON_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ENDER_DRAGON_AMBIENT");

    public static final Supplier<SoundType> ENTITY_ENDER_DRAGON_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ENDER_DRAGON_DEATH");

    public static final Supplier<SoundType> ENTITY_ENDER_DRAGON_FLAP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ENDER_DRAGON_FLAP");

    public static final Supplier<SoundType> ENTITY_ENDER_DRAGON_GROWL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ENDER_DRAGON_GROWL");

    public static final Supplier<SoundType> ENTITY_ENDER_DRAGON_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ENDER_DRAGON_HURT");

    public static final Supplier<SoundType> ENTITY_ENDER_DRAGON_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ENDER_DRAGON_SHOOT");

    public static final Supplier<SoundType> ENTITY_ENDER_EYE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ENDER_EYE_DEATH");

    public static final Supplier<SoundType> ENTITY_ENDER_EYE_LAUNCH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ENDER_EYE_LAUNCH");

    public static final Supplier<SoundType> ENTITY_ENDER_PEARL_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ENDER_PEARL_THROW");

    public static final Supplier<SoundType> ENTITY_EVOKER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_EVOKER_AMBIENT");

    public static final Supplier<SoundType> ENTITY_EVOKER_CAST_SPELL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_EVOKER_CAST_SPELL");

    public static final Supplier<SoundType> ENTITY_EVOKER_CELEBRATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_EVOKER_CELEBRATE");

    public static final Supplier<SoundType> ENTITY_EVOKER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_EVOKER_DEATH");

    public static final Supplier<SoundType> ENTITY_EVOKER_FANGS_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_EVOKER_FANGS_ATTACK");

    public static final Supplier<SoundType> ENTITY_EVOKER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_EVOKER_HURT");

    public static final Supplier<SoundType> ENTITY_EVOKER_PREPARE_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_EVOKER_PREPARE_ATTACK");

    public static final Supplier<SoundType> ENTITY_EVOKER_PREPARE_SUMMON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_EVOKER_PREPARE_SUMMON");

    public static final Supplier<SoundType> ENTITY_EVOKER_PREPARE_WOLOLO = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_EVOKER_PREPARE_WOLOLO");

    public static final Supplier<SoundType> ENTITY_EXPERIENCE_BOTTLE_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_EXPERIENCE_BOTTLE_THROW");

    public static final Supplier<SoundType> ENTITY_EXPERIENCE_ORB_PICKUP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_EXPERIENCE_ORB_PICKUP");

    public static final Supplier<SoundType> ENTITY_FIREWORK_ROCKET_BLAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_FIREWORK_ROCKET_BLAST");

    public static final Supplier<SoundType> ENTITY_FIREWORK_ROCKET_BLAST_FAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_FIREWORK_ROCKET_BLAST_FAR");

    public static final Supplier<SoundType> ENTITY_FIREWORK_ROCKET_LARGE_BLAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_FIREWORK_ROCKET_LARGE_BLAST");

    public static final Supplier<SoundType> ENTITY_FIREWORK_ROCKET_LARGE_BLAST_FAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_FIREWORK_ROCKET_LARGE_BLAST_FAR");

    public static final Supplier<SoundType> ENTITY_FIREWORK_ROCKET_LAUNCH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_FIREWORK_ROCKET_LAUNCH");

    public static final Supplier<SoundType> ENTITY_FIREWORK_ROCKET_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_FIREWORK_ROCKET_SHOOT");

    public static final Supplier<SoundType> ENTITY_FIREWORK_ROCKET_TWINKLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_FIREWORK_ROCKET_TWINKLE");

    public static final Supplier<SoundType> ENTITY_FIREWORK_ROCKET_TWINKLE_FAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_FIREWORK_ROCKET_TWINKLE_FAR");

    public static final Supplier<SoundType> ENTITY_FISHING_BOBBER_RETRIEVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_FISHING_BOBBER_RETRIEVE");

    public static final Supplier<SoundType> ENTITY_FISHING_BOBBER_SPLASH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_FISHING_BOBBER_SPLASH");

    public static final Supplier<SoundType> ENTITY_FISHING_BOBBER_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_FISHING_BOBBER_THROW");

    public static final Supplier<SoundType> ENTITY_FISH_SWIM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_FISH_SWIM");

    public static final Supplier<SoundType> ENTITY_FOX_AGGRO = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_FOX_AGGRO");

    public static final Supplier<SoundType> ENTITY_FOX_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_FOX_AMBIENT");

    public static final Supplier<SoundType> ENTITY_FOX_BITE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_FOX_BITE");

    public static final Supplier<SoundType> ENTITY_FOX_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_FOX_DEATH");

    public static final Supplier<SoundType> ENTITY_FOX_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_FOX_EAT");

    public static final Supplier<SoundType> ENTITY_FOX_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_FOX_HURT");

    public static final Supplier<SoundType> ENTITY_FOX_SCREECH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_FOX_SCREECH");

    public static final Supplier<SoundType> ENTITY_FOX_SLEEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_FOX_SLEEP");

    public static final Supplier<SoundType> ENTITY_FOX_SNIFF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_FOX_SNIFF");

    public static final Supplier<SoundType> ENTITY_FOX_SPIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_FOX_SPIT");

    public static final Supplier<SoundType> ENTITY_GENERIC_BIG_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_GENERIC_BIG_FALL");

    public static final Supplier<SoundType> ENTITY_GENERIC_BURN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_GENERIC_BURN");

    public static final Supplier<SoundType> ENTITY_GENERIC_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_GENERIC_DEATH");

    public static final Supplier<SoundType> ENTITY_GENERIC_DRINK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_GENERIC_DRINK");

    public static final Supplier<SoundType> ENTITY_GENERIC_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_GENERIC_EAT");

    public static final Supplier<SoundType> ENTITY_GENERIC_EXPLODE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_GENERIC_EXPLODE");

    public static final Supplier<SoundType> ENTITY_GENERIC_EXTINGUISH_FIRE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_GENERIC_EXTINGUISH_FIRE");

    public static final Supplier<SoundType> ENTITY_GENERIC_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_GENERIC_HURT");

    public static final Supplier<SoundType> ENTITY_GENERIC_SMALL_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_GENERIC_SMALL_FALL");

    public static final Supplier<SoundType> ENTITY_GENERIC_SPLASH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_GENERIC_SPLASH");

    public static final Supplier<SoundType> ENTITY_GENERIC_SWIM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_GENERIC_SWIM");

    public static final Supplier<SoundType> ENTITY_GHAST_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_GHAST_AMBIENT");

    public static final Supplier<SoundType> ENTITY_GHAST_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_GHAST_DEATH");

    public static final Supplier<SoundType> ENTITY_GHAST_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_GHAST_HURT");

    public static final Supplier<SoundType> ENTITY_GHAST_SCREAM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_GHAST_SCREAM");

    public static final Supplier<SoundType> ENTITY_GHAST_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_GHAST_SHOOT");

    public static final Supplier<SoundType> ENTITY_GHAST_WARN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_GHAST_WARN");

    public static final Supplier<SoundType> ENTITY_GUARDIAN_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_GUARDIAN_AMBIENT");

    public static final Supplier<SoundType> ENTITY_GUARDIAN_AMBIENT_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_GUARDIAN_AMBIENT_LAND");

    public static final Supplier<SoundType> ENTITY_GUARDIAN_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_GUARDIAN_ATTACK");

    public static final Supplier<SoundType> ENTITY_GUARDIAN_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_GUARDIAN_DEATH");

    public static final Supplier<SoundType> ENTITY_GUARDIAN_DEATH_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_GUARDIAN_DEATH_LAND");

    public static final Supplier<SoundType> ENTITY_GUARDIAN_FLOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_GUARDIAN_FLOP");

    public static final Supplier<SoundType> ENTITY_GUARDIAN_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_GUARDIAN_HURT");

    public static final Supplier<SoundType> ENTITY_GUARDIAN_HURT_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_GUARDIAN_HURT_LAND");

    public static final Supplier<SoundType> ENTITY_HORSE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_HORSE_AMBIENT");

    public static final Supplier<SoundType> ENTITY_HORSE_ANGRY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_HORSE_ANGRY");

    public static final Supplier<SoundType> ENTITY_HORSE_ARMOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_HORSE_ARMOR");

    public static final Supplier<SoundType> ENTITY_HORSE_BREATHE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_HORSE_BREATHE");

    public static final Supplier<SoundType> ENTITY_HORSE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_HORSE_DEATH");

    public static final Supplier<SoundType> ENTITY_HORSE_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_HORSE_EAT");

    public static final Supplier<SoundType> ENTITY_HORSE_GALLOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_HORSE_GALLOP");

    public static final Supplier<SoundType> ENTITY_HORSE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_HORSE_HURT");

    public static final Supplier<SoundType> ENTITY_HORSE_JUMP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_HORSE_JUMP");

    public static final Supplier<SoundType> ENTITY_HORSE_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_HORSE_LAND");

    public static final Supplier<SoundType> ENTITY_HORSE_SADDLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_HORSE_SADDLE");

    public static final Supplier<SoundType> ENTITY_HORSE_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_HORSE_STEP");

    public static final Supplier<SoundType> ENTITY_HORSE_STEP_WOOD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_HORSE_STEP_WOOD");

    public static final Supplier<SoundType> ENTITY_HOSTILE_BIG_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_HOSTILE_BIG_FALL");

    public static final Supplier<SoundType> ENTITY_HOSTILE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_HOSTILE_DEATH");

    public static final Supplier<SoundType> ENTITY_HOSTILE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_HOSTILE_HURT");

    public static final Supplier<SoundType> ENTITY_HOSTILE_SMALL_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_HOSTILE_SMALL_FALL");

    public static final Supplier<SoundType> ENTITY_HOSTILE_SPLASH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_HOSTILE_SPLASH");

    public static final Supplier<SoundType> ENTITY_HOSTILE_SWIM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_HOSTILE_SWIM");

    public static final Supplier<SoundType> ENTITY_HUSK_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_HUSK_AMBIENT");

    public static final Supplier<SoundType> ENTITY_HUSK_CONVERTED_TO_ZOMBIE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_HUSK_CONVERTED_TO_ZOMBIE");

    public static final Supplier<SoundType> ENTITY_HUSK_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_HUSK_DEATH");

    public static final Supplier<SoundType> ENTITY_HUSK_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_HUSK_HURT");

    public static final Supplier<SoundType> ENTITY_HUSK_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_HUSK_STEP");

    public static final Supplier<SoundType> ENTITY_ILLUSIONER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ILLUSIONER_AMBIENT");

    public static final Supplier<SoundType> ENTITY_ILLUSIONER_CAST_SPELL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ILLUSIONER_CAST_SPELL");

    public static final Supplier<SoundType> ENTITY_ILLUSIONER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ILLUSIONER_DEATH");

    public static final Supplier<SoundType> ENTITY_ILLUSIONER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ILLUSIONER_HURT");

    public static final Supplier<SoundType> ENTITY_ILLUSIONER_MIRROR_MOVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ILLUSIONER_MIRROR_MOVE");

    public static final Supplier<SoundType> ENTITY_ILLUSIONER_PREPARE_BLINDNESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ILLUSIONER_PREPARE_BLINDNESS");

    public static final Supplier<SoundType> ENTITY_ILLUSIONER_PREPARE_MIRROR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ILLUSIONER_PREPARE_MIRROR");

    public static final Supplier<SoundType> ENTITY_IRON_GOLEM_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_IRON_GOLEM_ATTACK");

    public static final Supplier<SoundType> ENTITY_IRON_GOLEM_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_IRON_GOLEM_DEATH");

    public static final Supplier<SoundType> ENTITY_IRON_GOLEM_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_IRON_GOLEM_HURT");

    public static final Supplier<SoundType> ENTITY_IRON_GOLEM_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_IRON_GOLEM_STEP");

    public static final Supplier<SoundType> ENTITY_ITEM_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ITEM_BREAK");

    public static final Supplier<SoundType> ENTITY_ITEM_FRAME_ADD_ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ITEM_FRAME_ADD_ITEM");

    public static final Supplier<SoundType> ENTITY_ITEM_FRAME_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ITEM_FRAME_BREAK");

    public static final Supplier<SoundType> ENTITY_ITEM_FRAME_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ITEM_FRAME_PLACE");

    public static final Supplier<SoundType> ENTITY_ITEM_FRAME_REMOVE_ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ITEM_FRAME_REMOVE_ITEM");

    public static final Supplier<SoundType> ENTITY_ITEM_FRAME_ROTATE_ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ITEM_FRAME_ROTATE_ITEM");

    public static final Supplier<SoundType> ENTITY_ITEM_PICKUP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ITEM_PICKUP");

    public static final Supplier<SoundType> ENTITY_LEASH_KNOT_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_LEASH_KNOT_BREAK");

    public static final Supplier<SoundType> ENTITY_LEASH_KNOT_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_LEASH_KNOT_PLACE");

    public static final Supplier<SoundType> ENTITY_LIGHTNING_BOLT_IMPACT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_LIGHTNING_BOLT_IMPACT");

    public static final Supplier<SoundType> ENTITY_LIGHTNING_BOLT_THUNDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_LIGHTNING_BOLT_THUNDER");

    public static final Supplier<SoundType> ENTITY_LINGERING_POTION_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_LINGERING_POTION_THROW");

    public static final Supplier<SoundType> ENTITY_LLAMA_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_LLAMA_AMBIENT");

    public static final Supplier<SoundType> ENTITY_LLAMA_ANGRY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_LLAMA_ANGRY");

    public static final Supplier<SoundType> ENTITY_LLAMA_CHEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_LLAMA_CHEST");

    public static final Supplier<SoundType> ENTITY_LLAMA_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_LLAMA_DEATH");

    public static final Supplier<SoundType> ENTITY_LLAMA_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_LLAMA_EAT");

    public static final Supplier<SoundType> ENTITY_LLAMA_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_LLAMA_HURT");

    public static final Supplier<SoundType> ENTITY_LLAMA_SPIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_LLAMA_SPIT");

    public static final Supplier<SoundType> ENTITY_LLAMA_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_LLAMA_STEP");

    public static final Supplier<SoundType> ENTITY_LLAMA_SWAG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_LLAMA_SWAG");

    public static final Supplier<SoundType> ENTITY_MAGMA_CUBE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_MAGMA_CUBE_DEATH");

    public static final Supplier<SoundType> ENTITY_MAGMA_CUBE_DEATH_SMALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_MAGMA_CUBE_DEATH_SMALL");

    public static final Supplier<SoundType> ENTITY_MAGMA_CUBE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_MAGMA_CUBE_HURT");

    public static final Supplier<SoundType> ENTITY_MAGMA_CUBE_HURT_SMALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_MAGMA_CUBE_HURT_SMALL");

    public static final Supplier<SoundType> ENTITY_MAGMA_CUBE_JUMP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_MAGMA_CUBE_JUMP");

    public static final Supplier<SoundType> ENTITY_MAGMA_CUBE_SQUISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_MAGMA_CUBE_SQUISH");

    public static final Supplier<SoundType> ENTITY_MAGMA_CUBE_SQUISH_SMALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_MAGMA_CUBE_SQUISH_SMALL");

    public static final Supplier<SoundType> ENTITY_MINECART_INSIDE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_MINECART_INSIDE");

    public static final Supplier<SoundType> ENTITY_MINECART_RIDING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_MINECART_RIDING");

    public static final Supplier<SoundType> ENTITY_MOOSHROOM_CONVERT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_MOOSHROOM_CONVERT");

    public static final Supplier<SoundType> ENTITY_MOOSHROOM_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_MOOSHROOM_EAT");

    public static final Supplier<SoundType> ENTITY_MOOSHROOM_MILK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_MOOSHROOM_MILK");

    public static final Supplier<SoundType> ENTITY_MOOSHROOM_SHEAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_MOOSHROOM_SHEAR");

    public static final Supplier<SoundType> ENTITY_MOOSHROOM_SUSPICIOUS_MILK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_MOOSHROOM_SUSPICIOUS_MILK");

    public static final Supplier<SoundType> ENTITY_MULE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_MULE_AMBIENT");

    public static final Supplier<SoundType> ENTITY_MULE_CHEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_MULE_CHEST");

    public static final Supplier<SoundType> ENTITY_MULE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_MULE_DEATH");

    public static final Supplier<SoundType> ENTITY_MULE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_MULE_HURT");

    public static final Supplier<SoundType> ENTITY_OCELOT_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_OCELOT_AMBIENT");

    public static final Supplier<SoundType> ENTITY_OCELOT_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_OCELOT_DEATH");

    public static final Supplier<SoundType> ENTITY_OCELOT_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_OCELOT_HURT");

    public static final Supplier<SoundType> ENTITY_PAINTING_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PAINTING_BREAK");

    public static final Supplier<SoundType> ENTITY_PAINTING_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PAINTING_PLACE");

    public static final Supplier<SoundType> ENTITY_PANDA_AGGRESSIVE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PANDA_AGGRESSIVE_AMBIENT");

    public static final Supplier<SoundType> ENTITY_PANDA_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PANDA_AMBIENT");

    public static final Supplier<SoundType> ENTITY_PANDA_BITE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PANDA_BITE");

    public static final Supplier<SoundType> ENTITY_PANDA_CANT_BREED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PANDA_CANT_BREED");

    public static final Supplier<SoundType> ENTITY_PANDA_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PANDA_DEATH");

    public static final Supplier<SoundType> ENTITY_PANDA_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PANDA_EAT");

    public static final Supplier<SoundType> ENTITY_PANDA_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PANDA_HURT");

    public static final Supplier<SoundType> ENTITY_PANDA_PRE_SNEEZE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PANDA_PRE_SNEEZE");

    public static final Supplier<SoundType> ENTITY_PANDA_SNEEZE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PANDA_SNEEZE");

    public static final Supplier<SoundType> ENTITY_PANDA_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PANDA_STEP");

    public static final Supplier<SoundType> ENTITY_PANDA_WORRIED_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PANDA_WORRIED_AMBIENT");

    public static final Supplier<SoundType> ENTITY_PARROT_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_AMBIENT");

    public static final Supplier<SoundType> ENTITY_PARROT_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_DEATH");

    public static final Supplier<SoundType> ENTITY_PARROT_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_EAT");

    public static final Supplier<SoundType> ENTITY_PARROT_FLY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_FLY");

    public static final Supplier<SoundType> ENTITY_PARROT_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_HURT");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_BLAZE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_BLAZE");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_CREEPER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_CREEPER");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_DROWNED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_DROWNED");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_ELDER_GUARDIAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_ELDER_GUARDIAN");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_ENDERMAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_ENDERMAN");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_ENDERMITE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_ENDERMITE");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_ENDER_DRAGON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_ENDER_DRAGON");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_EVOKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_EVOKER");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_GHAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_GHAST");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_GUARDIAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_GUARDIAN");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_HUSK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_HUSK");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_ILLUSIONER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_ILLUSIONER");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_MAGMA_CUBE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_MAGMA_CUBE");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_PANDA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_PANDA");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_PHANTOM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_PHANTOM");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_PILLAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_PILLAGER");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_POLAR_BEAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_POLAR_BEAR");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_RAVAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_RAVAGER");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_SHULKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_SHULKER");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_SILVERFISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_SILVERFISH");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_SKELETON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_SKELETON");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_SLIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_SLIME");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_SPIDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_SPIDER");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_STRAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_STRAY");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_VEX = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_VEX");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_VINDICATOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_VINDICATOR");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_WITCH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_WITCH");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_WITHER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_WITHER");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_WITHER_SKELETON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_WITHER_SKELETON");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_WOLF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_WOLF");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_ZOMBIE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_ZOMBIE");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_ZOMBIE_PIGMAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_ZOMBIE_PIGMAN");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_ZOMBIE_VILLAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_IMITATE_ZOMBIE_VILLAGER");

    public static final Supplier<SoundType> ENTITY_PARROT_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PARROT_STEP");

    public static final Supplier<SoundType> ENTITY_PHANTOM_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PHANTOM_AMBIENT");

    public static final Supplier<SoundType> ENTITY_PHANTOM_BITE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PHANTOM_BITE");

    public static final Supplier<SoundType> ENTITY_PHANTOM_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PHANTOM_DEATH");

    public static final Supplier<SoundType> ENTITY_PHANTOM_FLAP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PHANTOM_FLAP");

    public static final Supplier<SoundType> ENTITY_PHANTOM_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PHANTOM_HURT");

    public static final Supplier<SoundType> ENTITY_PHANTOM_SWOOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PHANTOM_SWOOP");

    public static final Supplier<SoundType> ENTITY_PIG_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PIG_AMBIENT");

    public static final Supplier<SoundType> ENTITY_PIG_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PIG_DEATH");

    public static final Supplier<SoundType> ENTITY_PIG_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PIG_HURT");

    public static final Supplier<SoundType> ENTITY_PIG_SADDLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PIG_SADDLE");

    public static final Supplier<SoundType> ENTITY_PIG_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PIG_STEP");

    public static final Supplier<SoundType> ENTITY_PILLAGER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PILLAGER_AMBIENT");

    public static final Supplier<SoundType> ENTITY_PILLAGER_CELEBRATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PILLAGER_CELEBRATE");

    public static final Supplier<SoundType> ENTITY_PILLAGER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PILLAGER_DEATH");

    public static final Supplier<SoundType> ENTITY_PILLAGER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PILLAGER_HURT");

    public static final Supplier<SoundType> ENTITY_PLAYER_ATTACK_CRIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PLAYER_ATTACK_CRIT");

    public static final Supplier<SoundType> ENTITY_PLAYER_ATTACK_KNOCKBACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PLAYER_ATTACK_KNOCKBACK");

    public static final Supplier<SoundType> ENTITY_PLAYER_ATTACK_NODAMAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PLAYER_ATTACK_NODAMAGE");

    public static final Supplier<SoundType> ENTITY_PLAYER_ATTACK_STRONG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PLAYER_ATTACK_STRONG");

    public static final Supplier<SoundType> ENTITY_PLAYER_ATTACK_SWEEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PLAYER_ATTACK_SWEEP");

    public static final Supplier<SoundType> ENTITY_PLAYER_ATTACK_WEAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PLAYER_ATTACK_WEAK");

    public static final Supplier<SoundType> ENTITY_PLAYER_BIG_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PLAYER_BIG_FALL");

    public static final Supplier<SoundType> ENTITY_PLAYER_BREATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PLAYER_BREATH");

    public static final Supplier<SoundType> ENTITY_PLAYER_BURP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PLAYER_BURP");

    public static final Supplier<SoundType> ENTITY_PLAYER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PLAYER_DEATH");

    public static final Supplier<SoundType> ENTITY_PLAYER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PLAYER_HURT");

    public static final Supplier<SoundType> ENTITY_PLAYER_HURT_DROWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PLAYER_HURT_DROWN");

    public static final Supplier<SoundType> ENTITY_PLAYER_HURT_ON_FIRE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PLAYER_HURT_ON_FIRE");

    public static final Supplier<SoundType> ENTITY_PLAYER_HURT_SWEET_BERRY_BUSH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PLAYER_HURT_SWEET_BERRY_BUSH");

    public static final Supplier<SoundType> ENTITY_PLAYER_LEVELUP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PLAYER_LEVELUP");

    public static final Supplier<SoundType> ENTITY_PLAYER_SMALL_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PLAYER_SMALL_FALL");

    public static final Supplier<SoundType> ENTITY_PLAYER_SPLASH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PLAYER_SPLASH");

    public static final Supplier<SoundType> ENTITY_PLAYER_SPLASH_HIGH_SPEED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PLAYER_SPLASH_HIGH_SPEED");

    public static final Supplier<SoundType> ENTITY_PLAYER_SWIM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PLAYER_SWIM");

    public static final Supplier<SoundType> ENTITY_POLAR_BEAR_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_POLAR_BEAR_AMBIENT");

    public static final Supplier<SoundType> ENTITY_POLAR_BEAR_AMBIENT_BABY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_POLAR_BEAR_AMBIENT_BABY");

    public static final Supplier<SoundType> ENTITY_POLAR_BEAR_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_POLAR_BEAR_DEATH");

    public static final Supplier<SoundType> ENTITY_POLAR_BEAR_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_POLAR_BEAR_HURT");

    public static final Supplier<SoundType> ENTITY_POLAR_BEAR_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_POLAR_BEAR_STEP");

    public static final Supplier<SoundType> ENTITY_POLAR_BEAR_WARNING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_POLAR_BEAR_WARNING");

    public static final Supplier<SoundType> ENTITY_PUFFER_FISH_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PUFFER_FISH_AMBIENT");

    public static final Supplier<SoundType> ENTITY_PUFFER_FISH_BLOW_OUT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PUFFER_FISH_BLOW_OUT");

    public static final Supplier<SoundType> ENTITY_PUFFER_FISH_BLOW_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PUFFER_FISH_BLOW_UP");

    public static final Supplier<SoundType> ENTITY_PUFFER_FISH_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PUFFER_FISH_DEATH");

    public static final Supplier<SoundType> ENTITY_PUFFER_FISH_FLOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PUFFER_FISH_FLOP");

    public static final Supplier<SoundType> ENTITY_PUFFER_FISH_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PUFFER_FISH_HURT");

    public static final Supplier<SoundType> ENTITY_PUFFER_FISH_STING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_PUFFER_FISH_STING");

    public static final Supplier<SoundType> ENTITY_RABBIT_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_RABBIT_AMBIENT");

    public static final Supplier<SoundType> ENTITY_RABBIT_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_RABBIT_ATTACK");

    public static final Supplier<SoundType> ENTITY_RABBIT_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_RABBIT_DEATH");

    public static final Supplier<SoundType> ENTITY_RABBIT_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_RABBIT_HURT");

    public static final Supplier<SoundType> ENTITY_RABBIT_JUMP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_RABBIT_JUMP");

    public static final Supplier<SoundType> ENTITY_RAVAGER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_RAVAGER_AMBIENT");

    public static final Supplier<SoundType> ENTITY_RAVAGER_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_RAVAGER_ATTACK");

    public static final Supplier<SoundType> ENTITY_RAVAGER_CELEBRATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_RAVAGER_CELEBRATE");

    public static final Supplier<SoundType> ENTITY_RAVAGER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_RAVAGER_DEATH");

    public static final Supplier<SoundType> ENTITY_RAVAGER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_RAVAGER_HURT");

    public static final Supplier<SoundType> ENTITY_RAVAGER_ROAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_RAVAGER_ROAR");

    public static final Supplier<SoundType> ENTITY_RAVAGER_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_RAVAGER_STEP");

    public static final Supplier<SoundType> ENTITY_RAVAGER_STUNNED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_RAVAGER_STUNNED");

    public static final Supplier<SoundType> ENTITY_SALMON_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SALMON_AMBIENT");

    public static final Supplier<SoundType> ENTITY_SALMON_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SALMON_DEATH");

    public static final Supplier<SoundType> ENTITY_SALMON_FLOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SALMON_FLOP");

    public static final Supplier<SoundType> ENTITY_SALMON_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SALMON_HURT");

    public static final Supplier<SoundType> ENTITY_SHEEP_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SHEEP_AMBIENT");

    public static final Supplier<SoundType> ENTITY_SHEEP_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SHEEP_DEATH");

    public static final Supplier<SoundType> ENTITY_SHEEP_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SHEEP_HURT");

    public static final Supplier<SoundType> ENTITY_SHEEP_SHEAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SHEEP_SHEAR");

    public static final Supplier<SoundType> ENTITY_SHEEP_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SHEEP_STEP");

    public static final Supplier<SoundType> ENTITY_SHULKER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SHULKER_AMBIENT");

    public static final Supplier<SoundType> ENTITY_SHULKER_BULLET_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SHULKER_BULLET_HIT");

    public static final Supplier<SoundType> ENTITY_SHULKER_BULLET_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SHULKER_BULLET_HURT");

    public static final Supplier<SoundType> ENTITY_SHULKER_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SHULKER_CLOSE");

    public static final Supplier<SoundType> ENTITY_SHULKER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SHULKER_DEATH");

    public static final Supplier<SoundType> ENTITY_SHULKER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SHULKER_HURT");

    public static final Supplier<SoundType> ENTITY_SHULKER_HURT_CLOSED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SHULKER_HURT_CLOSED");

    public static final Supplier<SoundType> ENTITY_SHULKER_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SHULKER_OPEN");

    public static final Supplier<SoundType> ENTITY_SHULKER_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SHULKER_SHOOT");

    public static final Supplier<SoundType> ENTITY_SHULKER_TELEPORT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SHULKER_TELEPORT");

    public static final Supplier<SoundType> ENTITY_SILVERFISH_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SILVERFISH_AMBIENT");

    public static final Supplier<SoundType> ENTITY_SILVERFISH_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SILVERFISH_DEATH");

    public static final Supplier<SoundType> ENTITY_SILVERFISH_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SILVERFISH_HURT");

    public static final Supplier<SoundType> ENTITY_SILVERFISH_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SILVERFISH_STEP");

    public static final Supplier<SoundType> ENTITY_SKELETON_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SKELETON_AMBIENT");

    public static final Supplier<SoundType> ENTITY_SKELETON_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SKELETON_DEATH");

    public static final Supplier<SoundType> ENTITY_SKELETON_HORSE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SKELETON_HORSE_AMBIENT");

    public static final Supplier<SoundType> ENTITY_SKELETON_HORSE_AMBIENT_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SKELETON_HORSE_AMBIENT_WATER");

    public static final Supplier<SoundType> ENTITY_SKELETON_HORSE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SKELETON_HORSE_DEATH");

    public static final Supplier<SoundType> ENTITY_SKELETON_HORSE_GALLOP_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SKELETON_HORSE_GALLOP_WATER");

    public static final Supplier<SoundType> ENTITY_SKELETON_HORSE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SKELETON_HORSE_HURT");

    public static final Supplier<SoundType> ENTITY_SKELETON_HORSE_JUMP_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SKELETON_HORSE_JUMP_WATER");

    public static final Supplier<SoundType> ENTITY_SKELETON_HORSE_STEP_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SKELETON_HORSE_STEP_WATER");

    public static final Supplier<SoundType> ENTITY_SKELETON_HORSE_SWIM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SKELETON_HORSE_SWIM");

    public static final Supplier<SoundType> ENTITY_SKELETON_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SKELETON_HURT");

    public static final Supplier<SoundType> ENTITY_SKELETON_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SKELETON_SHOOT");

    public static final Supplier<SoundType> ENTITY_SKELETON_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SKELETON_STEP");

    public static final Supplier<SoundType> ENTITY_SLIME_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SLIME_ATTACK");

    public static final Supplier<SoundType> ENTITY_SLIME_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SLIME_DEATH");

    public static final Supplier<SoundType> ENTITY_SLIME_DEATH_SMALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SLIME_DEATH_SMALL");

    public static final Supplier<SoundType> ENTITY_SLIME_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SLIME_HURT");

    public static final Supplier<SoundType> ENTITY_SLIME_HURT_SMALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SLIME_HURT_SMALL");

    public static final Supplier<SoundType> ENTITY_SLIME_JUMP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SLIME_JUMP");

    public static final Supplier<SoundType> ENTITY_SLIME_JUMP_SMALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SLIME_JUMP_SMALL");

    public static final Supplier<SoundType> ENTITY_SLIME_SQUISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SLIME_SQUISH");

    public static final Supplier<SoundType> ENTITY_SLIME_SQUISH_SMALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SLIME_SQUISH_SMALL");

    public static final Supplier<SoundType> ENTITY_SNOWBALL_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SNOWBALL_THROW");

    public static final Supplier<SoundType> ENTITY_SNOW_GOLEM_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SNOW_GOLEM_AMBIENT");

    public static final Supplier<SoundType> ENTITY_SNOW_GOLEM_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SNOW_GOLEM_DEATH");

    public static final Supplier<SoundType> ENTITY_SNOW_GOLEM_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SNOW_GOLEM_HURT");

    public static final Supplier<SoundType> ENTITY_SNOW_GOLEM_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SNOW_GOLEM_SHOOT");

    public static final Supplier<SoundType> ENTITY_SPIDER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SPIDER_AMBIENT");

    public static final Supplier<SoundType> ENTITY_SPIDER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SPIDER_DEATH");

    public static final Supplier<SoundType> ENTITY_SPIDER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SPIDER_HURT");

    public static final Supplier<SoundType> ENTITY_SPIDER_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SPIDER_STEP");

    public static final Supplier<SoundType> ENTITY_SPLASH_POTION_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SPLASH_POTION_BREAK");

    public static final Supplier<SoundType> ENTITY_SPLASH_POTION_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SPLASH_POTION_THROW");

    public static final Supplier<SoundType> ENTITY_SQUID_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SQUID_AMBIENT");

    public static final Supplier<SoundType> ENTITY_SQUID_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SQUID_DEATH");

    public static final Supplier<SoundType> ENTITY_SQUID_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SQUID_HURT");

    public static final Supplier<SoundType> ENTITY_SQUID_SQUIRT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_SQUID_SQUIRT");

    public static final Supplier<SoundType> ENTITY_STRAY_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_STRAY_AMBIENT");

    public static final Supplier<SoundType> ENTITY_STRAY_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_STRAY_DEATH");

    public static final Supplier<SoundType> ENTITY_STRAY_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_STRAY_HURT");

    public static final Supplier<SoundType> ENTITY_STRAY_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_STRAY_STEP");

    public static final Supplier<SoundType> ENTITY_TNT_PRIMED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_TNT_PRIMED");

    public static final Supplier<SoundType> ENTITY_TROPICAL_FISH_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_TROPICAL_FISH_AMBIENT");

    public static final Supplier<SoundType> ENTITY_TROPICAL_FISH_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_TROPICAL_FISH_DEATH");

    public static final Supplier<SoundType> ENTITY_TROPICAL_FISH_FLOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_TROPICAL_FISH_FLOP");

    public static final Supplier<SoundType> ENTITY_TROPICAL_FISH_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_TROPICAL_FISH_HURT");

    public static final Supplier<SoundType> ENTITY_TURTLE_AMBIENT_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_TURTLE_AMBIENT_LAND");

    public static final Supplier<SoundType> ENTITY_TURTLE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_TURTLE_DEATH");

    public static final Supplier<SoundType> ENTITY_TURTLE_DEATH_BABY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_TURTLE_DEATH_BABY");

    public static final Supplier<SoundType> ENTITY_TURTLE_EGG_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_TURTLE_EGG_BREAK");

    public static final Supplier<SoundType> ENTITY_TURTLE_EGG_CRACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_TURTLE_EGG_CRACK");

    public static final Supplier<SoundType> ENTITY_TURTLE_EGG_HATCH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_TURTLE_EGG_HATCH");

    public static final Supplier<SoundType> ENTITY_TURTLE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_TURTLE_HURT");

    public static final Supplier<SoundType> ENTITY_TURTLE_HURT_BABY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_TURTLE_HURT_BABY");

    public static final Supplier<SoundType> ENTITY_TURTLE_LAY_EGG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_TURTLE_LAY_EGG");

    public static final Supplier<SoundType> ENTITY_TURTLE_SHAMBLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_TURTLE_SHAMBLE");

    public static final Supplier<SoundType> ENTITY_TURTLE_SHAMBLE_BABY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_TURTLE_SHAMBLE_BABY");

    public static final Supplier<SoundType> ENTITY_TURTLE_SWIM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_TURTLE_SWIM");

    public static final Supplier<SoundType> ENTITY_VEX_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VEX_AMBIENT");

    public static final Supplier<SoundType> ENTITY_VEX_CHARGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VEX_CHARGE");

    public static final Supplier<SoundType> ENTITY_VEX_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VEX_DEATH");

    public static final Supplier<SoundType> ENTITY_VEX_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VEX_HURT");

    public static final Supplier<SoundType> ENTITY_VILLAGER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VILLAGER_AMBIENT");

    public static final Supplier<SoundType> ENTITY_VILLAGER_CELEBRATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VILLAGER_CELEBRATE");

    public static final Supplier<SoundType> ENTITY_VILLAGER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VILLAGER_DEATH");

    public static final Supplier<SoundType> ENTITY_VILLAGER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VILLAGER_HURT");

    public static final Supplier<SoundType> ENTITY_VILLAGER_NO = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VILLAGER_NO");

    public static final Supplier<SoundType> ENTITY_VILLAGER_TRADE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VILLAGER_TRADE");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_ARMORER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VILLAGER_WORK_ARMORER");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_BUTCHER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VILLAGER_WORK_BUTCHER");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_CARTOGRAPHER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VILLAGER_WORK_CARTOGRAPHER");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_CLERIC = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VILLAGER_WORK_CLERIC");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_FARMER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VILLAGER_WORK_FARMER");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_FISHERMAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VILLAGER_WORK_FISHERMAN");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_FLETCHER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VILLAGER_WORK_FLETCHER");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_LEATHERWORKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VILLAGER_WORK_LEATHERWORKER");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_LIBRARIAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VILLAGER_WORK_LIBRARIAN");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_MASON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VILLAGER_WORK_MASON");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_SHEPHERD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VILLAGER_WORK_SHEPHERD");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_TOOLSMITH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VILLAGER_WORK_TOOLSMITH");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_WEAPONSMITH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VILLAGER_WORK_WEAPONSMITH");

    public static final Supplier<SoundType> ENTITY_VILLAGER_YES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VILLAGER_YES");

    public static final Supplier<SoundType> ENTITY_VINDICATOR_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VINDICATOR_AMBIENT");

    public static final Supplier<SoundType> ENTITY_VINDICATOR_CELEBRATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VINDICATOR_CELEBRATE");

    public static final Supplier<SoundType> ENTITY_VINDICATOR_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VINDICATOR_DEATH");

    public static final Supplier<SoundType> ENTITY_VINDICATOR_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_VINDICATOR_HURT");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WANDERING_TRADER_AMBIENT");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WANDERING_TRADER_DEATH");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_DISAPPEARED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WANDERING_TRADER_DISAPPEARED");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_DRINK_MILK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WANDERING_TRADER_DRINK_MILK");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_DRINK_POTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WANDERING_TRADER_DRINK_POTION");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WANDERING_TRADER_HURT");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_NO = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WANDERING_TRADER_NO");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_REAPPEARED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WANDERING_TRADER_REAPPEARED");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_TRADE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WANDERING_TRADER_TRADE");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_YES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WANDERING_TRADER_YES");

    public static final Supplier<SoundType> ENTITY_WITCH_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WITCH_AMBIENT");

    public static final Supplier<SoundType> ENTITY_WITCH_CELEBRATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WITCH_CELEBRATE");

    public static final Supplier<SoundType> ENTITY_WITCH_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WITCH_DEATH");

    public static final Supplier<SoundType> ENTITY_WITCH_DRINK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WITCH_DRINK");

    public static final Supplier<SoundType> ENTITY_WITCH_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WITCH_HURT");

    public static final Supplier<SoundType> ENTITY_WITCH_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WITCH_THROW");

    public static final Supplier<SoundType> ENTITY_WITHER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WITHER_AMBIENT");

    public static final Supplier<SoundType> ENTITY_WITHER_BREAK_BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WITHER_BREAK_BLOCK");

    public static final Supplier<SoundType> ENTITY_WITHER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WITHER_DEATH");

    public static final Supplier<SoundType> ENTITY_WITHER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WITHER_HURT");

    public static final Supplier<SoundType> ENTITY_WITHER_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WITHER_SHOOT");

    public static final Supplier<SoundType> ENTITY_WITHER_SKELETON_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WITHER_SKELETON_AMBIENT");

    public static final Supplier<SoundType> ENTITY_WITHER_SKELETON_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WITHER_SKELETON_DEATH");

    public static final Supplier<SoundType> ENTITY_WITHER_SKELETON_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WITHER_SKELETON_HURT");

    public static final Supplier<SoundType> ENTITY_WITHER_SKELETON_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WITHER_SKELETON_STEP");

    public static final Supplier<SoundType> ENTITY_WITHER_SPAWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WITHER_SPAWN");

    public static final Supplier<SoundType> ENTITY_WOLF_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WOLF_AMBIENT");

    public static final Supplier<SoundType> ENTITY_WOLF_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WOLF_DEATH");

    public static final Supplier<SoundType> ENTITY_WOLF_GROWL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WOLF_GROWL");

    public static final Supplier<SoundType> ENTITY_WOLF_HOWL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WOLF_HOWL");

    public static final Supplier<SoundType> ENTITY_WOLF_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WOLF_HURT");

    public static final Supplier<SoundType> ENTITY_WOLF_PANT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WOLF_PANT");

    public static final Supplier<SoundType> ENTITY_WOLF_SHAKE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WOLF_SHAKE");

    public static final Supplier<SoundType> ENTITY_WOLF_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WOLF_STEP");

    public static final Supplier<SoundType> ENTITY_WOLF_WHINE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_WOLF_WHINE");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ZOMBIE_AMBIENT");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_ATTACK_IRON_DOOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ZOMBIE_ATTACK_IRON_DOOR");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_ATTACK_WOODEN_DOOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ZOMBIE_ATTACK_WOODEN_DOOR");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_BREAK_WOODEN_DOOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ZOMBIE_BREAK_WOODEN_DOOR");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_CONVERTED_TO_DROWNED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ZOMBIE_CONVERTED_TO_DROWNED");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ZOMBIE_DEATH");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_DESTROY_EGG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ZOMBIE_DESTROY_EGG");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_HORSE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ZOMBIE_HORSE_AMBIENT");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_HORSE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ZOMBIE_HORSE_DEATH");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_HORSE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ZOMBIE_HORSE_HURT");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ZOMBIE_HURT");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_INFECT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ZOMBIE_INFECT");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_PIGMAN_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ZOMBIE_PIGMAN_AMBIENT");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_PIGMAN_ANGRY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ZOMBIE_PIGMAN_ANGRY");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_PIGMAN_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ZOMBIE_PIGMAN_DEATH");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_PIGMAN_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ZOMBIE_PIGMAN_HURT");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ZOMBIE_STEP");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_VILLAGER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ZOMBIE_VILLAGER_AMBIENT");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_VILLAGER_CONVERTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ZOMBIE_VILLAGER_CONVERTED");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_VILLAGER_CURE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ZOMBIE_VILLAGER_CURE");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_VILLAGER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ZOMBIE_VILLAGER_DEATH");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_VILLAGER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ZOMBIE_VILLAGER_HURT");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_VILLAGER_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ENTITY_ZOMBIE_VILLAGER_STEP");

    public static final Supplier<SoundType> EVENT_RAID_HORN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "EVENT_RAID_HORN");

    public static final Supplier<SoundType> ITEM_ARMOR_EQUIP_CHAIN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_ARMOR_EQUIP_CHAIN");

    public static final Supplier<SoundType> ITEM_ARMOR_EQUIP_DIAMOND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_ARMOR_EQUIP_DIAMOND");

    public static final Supplier<SoundType> ITEM_ARMOR_EQUIP_ELYTRA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_ARMOR_EQUIP_ELYTRA");

    public static final Supplier<SoundType> ITEM_ARMOR_EQUIP_GENERIC = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_ARMOR_EQUIP_GENERIC");

    public static final Supplier<SoundType> ITEM_ARMOR_EQUIP_GOLD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_ARMOR_EQUIP_GOLD");

    public static final Supplier<SoundType> ITEM_ARMOR_EQUIP_IRON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_ARMOR_EQUIP_IRON");

    public static final Supplier<SoundType> ITEM_ARMOR_EQUIP_LEATHER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_ARMOR_EQUIP_LEATHER");

    public static final Supplier<SoundType> ITEM_ARMOR_EQUIP_TURTLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_ARMOR_EQUIP_TURTLE");

    public static final Supplier<SoundType> ITEM_AXE_STRIP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_AXE_STRIP");

    public static final Supplier<SoundType> ITEM_BOOK_PAGE_TURN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_BOOK_PAGE_TURN");

    public static final Supplier<SoundType> ITEM_BOOK_PUT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_BOOK_PUT");

    public static final Supplier<SoundType> ITEM_BOTTLE_EMPTY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_BOTTLE_EMPTY");

    public static final Supplier<SoundType> ITEM_BOTTLE_FILL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_BOTTLE_FILL");

    public static final Supplier<SoundType> ITEM_BOTTLE_FILL_DRAGONBREATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_BOTTLE_FILL_DRAGONBREATH");

    public static final Supplier<SoundType> ITEM_BUCKET_EMPTY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_BUCKET_EMPTY");

    public static final Supplier<SoundType> ITEM_BUCKET_EMPTY_FISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_BUCKET_EMPTY_FISH");

    public static final Supplier<SoundType> ITEM_BUCKET_EMPTY_LAVA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_BUCKET_EMPTY_LAVA");

    public static final Supplier<SoundType> ITEM_BUCKET_FILL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_BUCKET_FILL");

    public static final Supplier<SoundType> ITEM_BUCKET_FILL_FISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_BUCKET_FILL_FISH");

    public static final Supplier<SoundType> ITEM_BUCKET_FILL_LAVA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_BUCKET_FILL_LAVA");

    public static final Supplier<SoundType> ITEM_CHORUS_FRUIT_TELEPORT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_CHORUS_FRUIT_TELEPORT");

    public static final Supplier<SoundType> ITEM_CROP_PLANT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_CROP_PLANT");

    public static final Supplier<SoundType> ITEM_CROSSBOW_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_CROSSBOW_HIT");

    public static final Supplier<SoundType> ITEM_CROSSBOW_LOADING_END = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_CROSSBOW_LOADING_END");

    public static final Supplier<SoundType> ITEM_CROSSBOW_LOADING_MIDDLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_CROSSBOW_LOADING_MIDDLE");

    public static final Supplier<SoundType> ITEM_CROSSBOW_LOADING_START = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_CROSSBOW_LOADING_START");

    public static final Supplier<SoundType> ITEM_CROSSBOW_QUICK_CHARGE_1 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_CROSSBOW_QUICK_CHARGE_1");

    public static final Supplier<SoundType> ITEM_CROSSBOW_QUICK_CHARGE_2 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_CROSSBOW_QUICK_CHARGE_2");

    public static final Supplier<SoundType> ITEM_CROSSBOW_QUICK_CHARGE_3 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_CROSSBOW_QUICK_CHARGE_3");

    public static final Supplier<SoundType> ITEM_CROSSBOW_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_CROSSBOW_SHOOT");

    public static final Supplier<SoundType> ITEM_ELYTRA_FLYING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_ELYTRA_FLYING");

    public static final Supplier<SoundType> ITEM_FIRECHARGE_USE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_FIRECHARGE_USE");

    public static final Supplier<SoundType> ITEM_FLINTANDSTEEL_USE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_FLINTANDSTEEL_USE");

    public static final Supplier<SoundType> ITEM_HOE_TILL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_HOE_TILL");

    public static final Supplier<SoundType> ITEM_NETHER_WART_PLANT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_NETHER_WART_PLANT");

    public static final Supplier<SoundType> ITEM_SHIELD_BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_SHIELD_BLOCK");

    public static final Supplier<SoundType> ITEM_SHIELD_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_SHIELD_BREAK");

    public static final Supplier<SoundType> ITEM_SHOVEL_FLATTEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_SHOVEL_FLATTEN");

    public static final Supplier<SoundType> ITEM_SWEET_BERRIES_PICK_FROM_BUSH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_SWEET_BERRIES_PICK_FROM_BUSH");

    public static final Supplier<SoundType> ITEM_TOTEM_USE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_TOTEM_USE");

    public static final Supplier<SoundType> ITEM_TRIDENT_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_TRIDENT_HIT");

    public static final Supplier<SoundType> ITEM_TRIDENT_HIT_GROUND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_TRIDENT_HIT_GROUND");

    public static final Supplier<SoundType> ITEM_TRIDENT_RETURN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_TRIDENT_RETURN");

    public static final Supplier<SoundType> ITEM_TRIDENT_RIPTIDE_1 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_TRIDENT_RIPTIDE_1");

    public static final Supplier<SoundType> ITEM_TRIDENT_RIPTIDE_2 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_TRIDENT_RIPTIDE_2");

    public static final Supplier<SoundType> ITEM_TRIDENT_RIPTIDE_3 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_TRIDENT_RIPTIDE_3");

    public static final Supplier<SoundType> ITEM_TRIDENT_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_TRIDENT_THROW");

    public static final Supplier<SoundType> ITEM_TRIDENT_THUNDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ITEM_TRIDENT_THUNDER");

    public static final Supplier<SoundType> MUSIC_CREATIVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "MUSIC_CREATIVE");

    public static final Supplier<SoundType> MUSIC_CREDITS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "MUSIC_CREDITS");

    public static final Supplier<SoundType> MUSIC_DISC_11 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "MUSIC_DISC_11");

    public static final Supplier<SoundType> MUSIC_DISC_13 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "MUSIC_DISC_13");

    public static final Supplier<SoundType> MUSIC_DISC_BLOCKS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "MUSIC_DISC_BLOCKS");

    public static final Supplier<SoundType> MUSIC_DISC_CAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "MUSIC_DISC_CAT");

    public static final Supplier<SoundType> MUSIC_DISC_CHIRP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "MUSIC_DISC_CHIRP");

    public static final Supplier<SoundType> MUSIC_DISC_FAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "MUSIC_DISC_FAR");

    public static final Supplier<SoundType> MUSIC_DISC_MALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "MUSIC_DISC_MALL");

    public static final Supplier<SoundType> MUSIC_DISC_MELLOHI = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "MUSIC_DISC_MELLOHI");

    public static final Supplier<SoundType> MUSIC_DISC_STAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "MUSIC_DISC_STAL");

    public static final Supplier<SoundType> MUSIC_DISC_STRAD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "MUSIC_DISC_STRAD");

    public static final Supplier<SoundType> MUSIC_DISC_WAIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "MUSIC_DISC_WAIT");

    public static final Supplier<SoundType> MUSIC_DISC_WARD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "MUSIC_DISC_WARD");

    public static final Supplier<SoundType> MUSIC_DRAGON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "MUSIC_DRAGON");

    public static final Supplier<SoundType> MUSIC_END = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "MUSIC_END");

    public static final Supplier<SoundType> MUSIC_GAME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "MUSIC_GAME");

    public static final Supplier<SoundType> MUSIC_MENU = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "MUSIC_MENU");

    public static final Supplier<SoundType> MUSIC_NETHER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "MUSIC_NETHER");

    public static final Supplier<SoundType> MUSIC_UNDER_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "MUSIC_UNDER_WATER");

    public static final Supplier<SoundType> UI_BUTTON_CLICK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "UI_BUTTON_CLICK");

    public static final Supplier<SoundType> UI_CARTOGRAPHY_TABLE_TAKE_RESULT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "UI_CARTOGRAPHY_TABLE_TAKE_RESULT");

    public static final Supplier<SoundType> UI_LOOM_SELECT_PATTERN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "UI_LOOM_SELECT_PATTERN");

    public static final Supplier<SoundType> UI_LOOM_TAKE_RESULT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "UI_LOOM_TAKE_RESULT");

    public static final Supplier<SoundType> UI_STONECUTTER_SELECT_RECIPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "UI_STONECUTTER_SELECT_RECIPE");

    public static final Supplier<SoundType> UI_STONECUTTER_TAKE_RESULT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "UI_STONECUTTER_TAKE_RESULT");

    public static final Supplier<SoundType> UI_TOAST_CHALLENGE_COMPLETE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "UI_TOAST_CHALLENGE_COMPLETE");

    public static final Supplier<SoundType> UI_TOAST_IN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "UI_TOAST_IN");

    public static final Supplier<SoundType> UI_TOAST_OUT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "UI_TOAST_OUT");

    public static final Supplier<SoundType> WEATHER_RAIN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "WEATHER_RAIN");

    public static final Supplier<SoundType> WEATHER_RAIN_ABOVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "WEATHER_RAIN_ABOVE");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private SoundTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
