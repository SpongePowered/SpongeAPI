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

    public static final Supplier<SoundType> AMBIENT_BASALT_DELTAS_ADDITIONS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient.basalt_deltas.additions");

    public static final Supplier<SoundType> AMBIENT_BASALT_DELTAS_LOOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient.basalt_deltas.loop");

    public static final Supplier<SoundType> AMBIENT_BASALT_DELTAS_MOOD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient.basalt_deltas.mood");

    public static final Supplier<SoundType> AMBIENT_CAVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient.cave");

    public static final Supplier<SoundType> AMBIENT_CRIMSON_FOREST_ADDITIONS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient.crimson_forest.additions");

    public static final Supplier<SoundType> AMBIENT_CRIMSON_FOREST_LOOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient.crimson_forest.loop");

    public static final Supplier<SoundType> AMBIENT_CRIMSON_FOREST_MOOD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient.crimson_forest.mood");

    public static final Supplier<SoundType> AMBIENT_NETHER_WASTES_ADDITIONS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient.nether_wastes.additions");

    public static final Supplier<SoundType> AMBIENT_NETHER_WASTES_LOOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient.nether_wastes.loop");

    public static final Supplier<SoundType> AMBIENT_NETHER_WASTES_MOOD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient.nether_wastes.mood");

    public static final Supplier<SoundType> AMBIENT_SOUL_SAND_VALLEY_ADDITIONS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient.soul_sand_valley.additions");

    public static final Supplier<SoundType> AMBIENT_SOUL_SAND_VALLEY_LOOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient.soul_sand_valley.loop");

    public static final Supplier<SoundType> AMBIENT_SOUL_SAND_VALLEY_MOOD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient.soul_sand_valley.mood");

    public static final Supplier<SoundType> AMBIENT_UNDERWATER_ENTER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient.underwater.enter");

    public static final Supplier<SoundType> AMBIENT_UNDERWATER_EXIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient.underwater.exit");

    public static final Supplier<SoundType> AMBIENT_UNDERWATER_LOOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient.underwater.loop");

    public static final Supplier<SoundType> AMBIENT_UNDERWATER_LOOP_ADDITIONS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient.underwater.loop.additions");

    public static final Supplier<SoundType> AMBIENT_UNDERWATER_LOOP_ADDITIONS_RARE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient.underwater.loop.additions.rare");

    public static final Supplier<SoundType> AMBIENT_UNDERWATER_LOOP_ADDITIONS_ULTRA_RARE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient.underwater.loop.additions.ultra_rare");

    public static final Supplier<SoundType> AMBIENT_WARPED_FOREST_ADDITIONS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient.warped_forest.additions");

    public static final Supplier<SoundType> AMBIENT_WARPED_FOREST_LOOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient.warped_forest.loop");

    public static final Supplier<SoundType> AMBIENT_WARPED_FOREST_MOOD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ambient.warped_forest.mood");

    public static final Supplier<SoundType> BLOCK_ANCIENT_DEBRIS_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.ancient_debris.break");

    public static final Supplier<SoundType> BLOCK_ANCIENT_DEBRIS_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.ancient_debris.fall");

    public static final Supplier<SoundType> BLOCK_ANCIENT_DEBRIS_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.ancient_debris.hit");

    public static final Supplier<SoundType> BLOCK_ANCIENT_DEBRIS_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.ancient_debris.place");

    public static final Supplier<SoundType> BLOCK_ANCIENT_DEBRIS_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.ancient_debris.step");

    public static final Supplier<SoundType> BLOCK_ANVIL_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.anvil.break");

    public static final Supplier<SoundType> BLOCK_ANVIL_DESTROY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.anvil.destroy");

    public static final Supplier<SoundType> BLOCK_ANVIL_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.anvil.fall");

    public static final Supplier<SoundType> BLOCK_ANVIL_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.anvil.hit");

    public static final Supplier<SoundType> BLOCK_ANVIL_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.anvil.land");

    public static final Supplier<SoundType> BLOCK_ANVIL_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.anvil.place");

    public static final Supplier<SoundType> BLOCK_ANVIL_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.anvil.step");

    public static final Supplier<SoundType> BLOCK_ANVIL_USE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.anvil.use");

    public static final Supplier<SoundType> BLOCK_BAMBOO_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.bamboo.break");

    public static final Supplier<SoundType> BLOCK_BAMBOO_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.bamboo.fall");

    public static final Supplier<SoundType> BLOCK_BAMBOO_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.bamboo.hit");

    public static final Supplier<SoundType> BLOCK_BAMBOO_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.bamboo.place");

    public static final Supplier<SoundType> BLOCK_BAMBOO_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.bamboo.step");

    public static final Supplier<SoundType> BLOCK_BAMBOO_SAPLING_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.bamboo_sapling.break");

    public static final Supplier<SoundType> BLOCK_BAMBOO_SAPLING_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.bamboo_sapling.hit");

    public static final Supplier<SoundType> BLOCK_BAMBOO_SAPLING_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.bamboo_sapling.place");

    public static final Supplier<SoundType> BLOCK_BARREL_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.barrel.close");

    public static final Supplier<SoundType> BLOCK_BARREL_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.barrel.open");

    public static final Supplier<SoundType> BLOCK_BASALT_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.basalt.break");

    public static final Supplier<SoundType> BLOCK_BASALT_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.basalt.fall");

    public static final Supplier<SoundType> BLOCK_BASALT_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.basalt.hit");

    public static final Supplier<SoundType> BLOCK_BASALT_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.basalt.place");

    public static final Supplier<SoundType> BLOCK_BASALT_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.basalt.step");

    public static final Supplier<SoundType> BLOCK_BEACON_ACTIVATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.beacon.activate");

    public static final Supplier<SoundType> BLOCK_BEACON_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.beacon.ambient");

    public static final Supplier<SoundType> BLOCK_BEACON_DEACTIVATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.beacon.deactivate");

    public static final Supplier<SoundType> BLOCK_BEACON_POWER_SELECT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.beacon.power_select");

    public static final Supplier<SoundType> BLOCK_BEEHIVE_DRIP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.beehive.drip");

    public static final Supplier<SoundType> BLOCK_BEEHIVE_ENTER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.beehive.enter");

    public static final Supplier<SoundType> BLOCK_BEEHIVE_EXIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.beehive.exit");

    public static final Supplier<SoundType> BLOCK_BEEHIVE_SHEAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.beehive.shear");

    public static final Supplier<SoundType> BLOCK_BEEHIVE_WORK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.beehive.work");

    public static final Supplier<SoundType> BLOCK_BELL_RESONATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.bell.resonate");

    public static final Supplier<SoundType> BLOCK_BELL_USE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.bell.use");

    public static final Supplier<SoundType> BLOCK_BLASTFURNACE_FIRE_CRACKLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.blastfurnace.fire_crackle");

    public static final Supplier<SoundType> BLOCK_BONE_BLOCK_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.bone_block.break");

    public static final Supplier<SoundType> BLOCK_BONE_BLOCK_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.bone_block.fall");

    public static final Supplier<SoundType> BLOCK_BONE_BLOCK_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.bone_block.hit");

    public static final Supplier<SoundType> BLOCK_BONE_BLOCK_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.bone_block.place");

    public static final Supplier<SoundType> BLOCK_BONE_BLOCK_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.bone_block.step");

    public static final Supplier<SoundType> BLOCK_BREWING_STAND_BREW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.brewing_stand.brew");

    public static final Supplier<SoundType> BLOCK_BUBBLE_COLUMN_BUBBLE_POP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.bubble_column.bubble_pop");

    public static final Supplier<SoundType> BLOCK_BUBBLE_COLUMN_UPWARDS_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.bubble_column.upwards_ambient");

    public static final Supplier<SoundType> BLOCK_BUBBLE_COLUMN_UPWARDS_INSIDE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.bubble_column.upwards_inside");

    public static final Supplier<SoundType> BLOCK_BUBBLE_COLUMN_WHIRLPOOL_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.bubble_column.whirlpool_ambient");

    public static final Supplier<SoundType> BLOCK_BUBBLE_COLUMN_WHIRLPOOL_INSIDE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.bubble_column.whirlpool_inside");

    public static final Supplier<SoundType> BLOCK_CAMPFIRE_CRACKLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.campfire.crackle");

    public static final Supplier<SoundType> BLOCK_CHAIN_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.chain.break");

    public static final Supplier<SoundType> BLOCK_CHAIN_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.chain.fall");

    public static final Supplier<SoundType> BLOCK_CHAIN_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.chain.hit");

    public static final Supplier<SoundType> BLOCK_CHAIN_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.chain.place");

    public static final Supplier<SoundType> BLOCK_CHAIN_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.chain.step");

    public static final Supplier<SoundType> BLOCK_CHEST_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.chest.close");

    public static final Supplier<SoundType> BLOCK_CHEST_LOCKED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.chest.locked");

    public static final Supplier<SoundType> BLOCK_CHEST_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.chest.open");

    public static final Supplier<SoundType> BLOCK_CHORUS_FLOWER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.chorus_flower.death");

    public static final Supplier<SoundType> BLOCK_CHORUS_FLOWER_GROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.chorus_flower.grow");

    public static final Supplier<SoundType> BLOCK_COMPARATOR_CLICK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.comparator.click");

    public static final Supplier<SoundType> BLOCK_COMPOSTER_EMPTY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.composter.empty");

    public static final Supplier<SoundType> BLOCK_COMPOSTER_FILL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.composter.fill");

    public static final Supplier<SoundType> BLOCK_COMPOSTER_FILL_SUCCESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.composter.fill_success");

    public static final Supplier<SoundType> BLOCK_COMPOSTER_READY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.composter.ready");

    public static final Supplier<SoundType> BLOCK_CONDUIT_ACTIVATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.conduit.activate");

    public static final Supplier<SoundType> BLOCK_CONDUIT_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.conduit.ambient");

    public static final Supplier<SoundType> BLOCK_CONDUIT_AMBIENT_SHORT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.conduit.ambient.short");

    public static final Supplier<SoundType> BLOCK_CONDUIT_ATTACK_TARGET = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.conduit.attack.target");

    public static final Supplier<SoundType> BLOCK_CONDUIT_DEACTIVATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.conduit.deactivate");

    public static final Supplier<SoundType> BLOCK_CORAL_BLOCK_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.coral_block.break");

    public static final Supplier<SoundType> BLOCK_CORAL_BLOCK_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.coral_block.fall");

    public static final Supplier<SoundType> BLOCK_CORAL_BLOCK_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.coral_block.hit");

    public static final Supplier<SoundType> BLOCK_CORAL_BLOCK_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.coral_block.place");

    public static final Supplier<SoundType> BLOCK_CORAL_BLOCK_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.coral_block.step");

    public static final Supplier<SoundType> BLOCK_CROP_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.crop.break");

    public static final Supplier<SoundType> BLOCK_DISPENSER_DISPENSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.dispenser.dispense");

    public static final Supplier<SoundType> BLOCK_DISPENSER_FAIL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.dispenser.fail");

    public static final Supplier<SoundType> BLOCK_DISPENSER_LAUNCH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.dispenser.launch");

    public static final Supplier<SoundType> BLOCK_ENCHANTMENT_TABLE_USE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.enchantment_table.use");

    public static final Supplier<SoundType> BLOCK_END_GATEWAY_SPAWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.end_gateway.spawn");

    public static final Supplier<SoundType> BLOCK_END_PORTAL_SPAWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.end_portal.spawn");

    public static final Supplier<SoundType> BLOCK_END_PORTAL_FRAME_FILL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.end_portal_frame.fill");

    public static final Supplier<SoundType> BLOCK_ENDER_CHEST_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.ender_chest.close");

    public static final Supplier<SoundType> BLOCK_ENDER_CHEST_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.ender_chest.open");

    public static final Supplier<SoundType> BLOCK_FENCE_GATE_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.fence_gate.close");

    public static final Supplier<SoundType> BLOCK_FENCE_GATE_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.fence_gate.open");

    public static final Supplier<SoundType> BLOCK_FIRE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.fire.ambient");

    public static final Supplier<SoundType> BLOCK_FIRE_EXTINGUISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.fire.extinguish");

    public static final Supplier<SoundType> BLOCK_FUNGUS_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.fungus.break");

    public static final Supplier<SoundType> BLOCK_FUNGUS_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.fungus.fall");

    public static final Supplier<SoundType> BLOCK_FUNGUS_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.fungus.hit");

    public static final Supplier<SoundType> BLOCK_FUNGUS_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.fungus.place");

    public static final Supplier<SoundType> BLOCK_FUNGUS_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.fungus.step");

    public static final Supplier<SoundType> BLOCK_FURNACE_FIRE_CRACKLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.furnace.fire_crackle");

    public static final Supplier<SoundType> BLOCK_GILDED_BLACKSTONE_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.gilded_blackstone.break");

    public static final Supplier<SoundType> BLOCK_GILDED_BLACKSTONE_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.gilded_blackstone.fall");

    public static final Supplier<SoundType> BLOCK_GILDED_BLACKSTONE_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.gilded_blackstone.hit");

    public static final Supplier<SoundType> BLOCK_GILDED_BLACKSTONE_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.gilded_blackstone.place");

    public static final Supplier<SoundType> BLOCK_GILDED_BLACKSTONE_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.gilded_blackstone.step");

    public static final Supplier<SoundType> BLOCK_GLASS_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.glass.break");

    public static final Supplier<SoundType> BLOCK_GLASS_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.glass.fall");

    public static final Supplier<SoundType> BLOCK_GLASS_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.glass.hit");

    public static final Supplier<SoundType> BLOCK_GLASS_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.glass.place");

    public static final Supplier<SoundType> BLOCK_GLASS_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.glass.step");

    public static final Supplier<SoundType> BLOCK_GRASS_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.grass.break");

    public static final Supplier<SoundType> BLOCK_GRASS_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.grass.fall");

    public static final Supplier<SoundType> BLOCK_GRASS_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.grass.hit");

    public static final Supplier<SoundType> BLOCK_GRASS_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.grass.place");

    public static final Supplier<SoundType> BLOCK_GRASS_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.grass.step");

    public static final Supplier<SoundType> BLOCK_GRAVEL_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.gravel.break");

    public static final Supplier<SoundType> BLOCK_GRAVEL_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.gravel.fall");

    public static final Supplier<SoundType> BLOCK_GRAVEL_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.gravel.hit");

    public static final Supplier<SoundType> BLOCK_GRAVEL_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.gravel.place");

    public static final Supplier<SoundType> BLOCK_GRAVEL_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.gravel.step");

    public static final Supplier<SoundType> BLOCK_GRINDSTONE_USE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.grindstone.use");

    public static final Supplier<SoundType> BLOCK_HONEY_BLOCK_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.honey_block.break");

    public static final Supplier<SoundType> BLOCK_HONEY_BLOCK_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.honey_block.fall");

    public static final Supplier<SoundType> BLOCK_HONEY_BLOCK_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.honey_block.hit");

    public static final Supplier<SoundType> BLOCK_HONEY_BLOCK_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.honey_block.place");

    public static final Supplier<SoundType> BLOCK_HONEY_BLOCK_SLIDE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.honey_block.slide");

    public static final Supplier<SoundType> BLOCK_HONEY_BLOCK_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.honey_block.step");

    public static final Supplier<SoundType> BLOCK_IRON_DOOR_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.iron_door.close");

    public static final Supplier<SoundType> BLOCK_IRON_DOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.iron_door.open");

    public static final Supplier<SoundType> BLOCK_IRON_TRAPDOOR_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.iron_trapdoor.close");

    public static final Supplier<SoundType> BLOCK_IRON_TRAPDOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.iron_trapdoor.open");

    public static final Supplier<SoundType> BLOCK_LADDER_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.ladder.break");

    public static final Supplier<SoundType> BLOCK_LADDER_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.ladder.fall");

    public static final Supplier<SoundType> BLOCK_LADDER_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.ladder.hit");

    public static final Supplier<SoundType> BLOCK_LADDER_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.ladder.place");

    public static final Supplier<SoundType> BLOCK_LADDER_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.ladder.step");

    public static final Supplier<SoundType> BLOCK_LANTERN_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.lantern.break");

    public static final Supplier<SoundType> BLOCK_LANTERN_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.lantern.fall");

    public static final Supplier<SoundType> BLOCK_LANTERN_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.lantern.hit");

    public static final Supplier<SoundType> BLOCK_LANTERN_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.lantern.place");

    public static final Supplier<SoundType> BLOCK_LANTERN_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.lantern.step");

    public static final Supplier<SoundType> BLOCK_LAVA_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.lava.ambient");

    public static final Supplier<SoundType> BLOCK_LAVA_EXTINGUISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.lava.extinguish");

    public static final Supplier<SoundType> BLOCK_LAVA_POP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.lava.pop");

    public static final Supplier<SoundType> BLOCK_LEVER_CLICK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.lever.click");

    public static final Supplier<SoundType> BLOCK_LILY_PAD_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.lily_pad.place");

    public static final Supplier<SoundType> BLOCK_LODESTONE_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.lodestone.break");

    public static final Supplier<SoundType> BLOCK_LODESTONE_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.lodestone.fall");

    public static final Supplier<SoundType> BLOCK_LODESTONE_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.lodestone.hit");

    public static final Supplier<SoundType> BLOCK_LODESTONE_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.lodestone.place");

    public static final Supplier<SoundType> BLOCK_LODESTONE_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.lodestone.step");

    public static final Supplier<SoundType> BLOCK_METAL_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.metal.break");

    public static final Supplier<SoundType> BLOCK_METAL_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.metal.fall");

    public static final Supplier<SoundType> BLOCK_METAL_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.metal.hit");

    public static final Supplier<SoundType> BLOCK_METAL_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.metal.place");

    public static final Supplier<SoundType> BLOCK_METAL_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.metal.step");

    public static final Supplier<SoundType> BLOCK_METAL_PRESSURE_PLATE_CLICK_OFF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.metal_pressure_plate.click_off");

    public static final Supplier<SoundType> BLOCK_METAL_PRESSURE_PLATE_CLICK_ON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.metal_pressure_plate.click_on");

    public static final Supplier<SoundType> BLOCK_NETHER_BRICKS_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.nether_bricks.break");

    public static final Supplier<SoundType> BLOCK_NETHER_BRICKS_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.nether_bricks.fall");

    public static final Supplier<SoundType> BLOCK_NETHER_BRICKS_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.nether_bricks.hit");

    public static final Supplier<SoundType> BLOCK_NETHER_BRICKS_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.nether_bricks.place");

    public static final Supplier<SoundType> BLOCK_NETHER_BRICKS_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.nether_bricks.step");

    public static final Supplier<SoundType> BLOCK_NETHER_GOLD_ORE_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.nether_gold_ore.break");

    public static final Supplier<SoundType> BLOCK_NETHER_GOLD_ORE_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.nether_gold_ore.fall");

    public static final Supplier<SoundType> BLOCK_NETHER_GOLD_ORE_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.nether_gold_ore.hit");

    public static final Supplier<SoundType> BLOCK_NETHER_GOLD_ORE_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.nether_gold_ore.place");

    public static final Supplier<SoundType> BLOCK_NETHER_GOLD_ORE_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.nether_gold_ore.step");

    public static final Supplier<SoundType> BLOCK_NETHER_ORE_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.nether_ore.break");

    public static final Supplier<SoundType> BLOCK_NETHER_ORE_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.nether_ore.fall");

    public static final Supplier<SoundType> BLOCK_NETHER_ORE_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.nether_ore.hit");

    public static final Supplier<SoundType> BLOCK_NETHER_ORE_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.nether_ore.place");

    public static final Supplier<SoundType> BLOCK_NETHER_ORE_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.nether_ore.step");

    public static final Supplier<SoundType> BLOCK_NETHER_SPROUTS_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.nether_sprouts.break");

    public static final Supplier<SoundType> BLOCK_NETHER_SPROUTS_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.nether_sprouts.fall");

    public static final Supplier<SoundType> BLOCK_NETHER_SPROUTS_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.nether_sprouts.hit");

    public static final Supplier<SoundType> BLOCK_NETHER_SPROUTS_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.nether_sprouts.place");

    public static final Supplier<SoundType> BLOCK_NETHER_SPROUTS_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.nether_sprouts.step");

    public static final Supplier<SoundType> BLOCK_NETHER_WART_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.nether_wart.break");

    public static final Supplier<SoundType> BLOCK_NETHERITE_BLOCK_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.netherite_block.break");

    public static final Supplier<SoundType> BLOCK_NETHERITE_BLOCK_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.netherite_block.fall");

    public static final Supplier<SoundType> BLOCK_NETHERITE_BLOCK_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.netherite_block.hit");

    public static final Supplier<SoundType> BLOCK_NETHERITE_BLOCK_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.netherite_block.place");

    public static final Supplier<SoundType> BLOCK_NETHERITE_BLOCK_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.netherite_block.step");

    public static final Supplier<SoundType> BLOCK_NETHERRACK_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.netherrack.break");

    public static final Supplier<SoundType> BLOCK_NETHERRACK_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.netherrack.fall");

    public static final Supplier<SoundType> BLOCK_NETHERRACK_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.netherrack.hit");

    public static final Supplier<SoundType> BLOCK_NETHERRACK_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.netherrack.place");

    public static final Supplier<SoundType> BLOCK_NETHERRACK_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.netherrack.step");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_BANJO = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.note_block.banjo");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_BASEDRUM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.note_block.basedrum");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_BASS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.note_block.bass");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_BELL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.note_block.bell");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_BIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.note_block.bit");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_CHIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.note_block.chime");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_COW_BELL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.note_block.cow_bell");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_DIDGERIDOO = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.note_block.didgeridoo");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_FLUTE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.note_block.flute");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_GUITAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.note_block.guitar");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_HARP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.note_block.harp");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_HAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.note_block.hat");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_IRON_XYLOPHONE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.note_block.iron_xylophone");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_PLING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.note_block.pling");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_SNARE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.note_block.snare");

    public static final Supplier<SoundType> BLOCK_NOTE_BLOCK_XYLOPHONE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.note_block.xylophone");

    public static final Supplier<SoundType> BLOCK_NYLIUM_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.nylium.break");

    public static final Supplier<SoundType> BLOCK_NYLIUM_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.nylium.fall");

    public static final Supplier<SoundType> BLOCK_NYLIUM_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.nylium.hit");

    public static final Supplier<SoundType> BLOCK_NYLIUM_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.nylium.place");

    public static final Supplier<SoundType> BLOCK_NYLIUM_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.nylium.step");

    public static final Supplier<SoundType> BLOCK_PISTON_CONTRACT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.piston.contract");

    public static final Supplier<SoundType> BLOCK_PISTON_EXTEND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.piston.extend");

    public static final Supplier<SoundType> BLOCK_PORTAL_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.portal.ambient");

    public static final Supplier<SoundType> BLOCK_PORTAL_TRAVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.portal.travel");

    public static final Supplier<SoundType> BLOCK_PORTAL_TRIGGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.portal.trigger");

    public static final Supplier<SoundType> BLOCK_PUMPKIN_CARVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.pumpkin.carve");

    public static final Supplier<SoundType> BLOCK_REDSTONE_TORCH_BURNOUT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.redstone_torch.burnout");

    public static final Supplier<SoundType> BLOCK_RESPAWN_ANCHOR_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.respawn_anchor.ambient");

    public static final Supplier<SoundType> BLOCK_RESPAWN_ANCHOR_CHARGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.respawn_anchor.charge");

    public static final Supplier<SoundType> BLOCK_RESPAWN_ANCHOR_DEPLETE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.respawn_anchor.deplete");

    public static final Supplier<SoundType> BLOCK_RESPAWN_ANCHOR_SET_SPAWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.respawn_anchor.set_spawn");

    public static final Supplier<SoundType> BLOCK_ROOTS_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.roots.break");

    public static final Supplier<SoundType> BLOCK_ROOTS_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.roots.fall");

    public static final Supplier<SoundType> BLOCK_ROOTS_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.roots.hit");

    public static final Supplier<SoundType> BLOCK_ROOTS_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.roots.place");

    public static final Supplier<SoundType> BLOCK_ROOTS_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.roots.step");

    public static final Supplier<SoundType> BLOCK_SAND_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.sand.break");

    public static final Supplier<SoundType> BLOCK_SAND_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.sand.fall");

    public static final Supplier<SoundType> BLOCK_SAND_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.sand.hit");

    public static final Supplier<SoundType> BLOCK_SAND_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.sand.place");

    public static final Supplier<SoundType> BLOCK_SAND_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.sand.step");

    public static final Supplier<SoundType> BLOCK_SCAFFOLDING_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.scaffolding.break");

    public static final Supplier<SoundType> BLOCK_SCAFFOLDING_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.scaffolding.fall");

    public static final Supplier<SoundType> BLOCK_SCAFFOLDING_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.scaffolding.hit");

    public static final Supplier<SoundType> BLOCK_SCAFFOLDING_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.scaffolding.place");

    public static final Supplier<SoundType> BLOCK_SCAFFOLDING_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.scaffolding.step");

    public static final Supplier<SoundType> BLOCK_SHROOMLIGHT_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.shroomlight.break");

    public static final Supplier<SoundType> BLOCK_SHROOMLIGHT_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.shroomlight.fall");

    public static final Supplier<SoundType> BLOCK_SHROOMLIGHT_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.shroomlight.hit");

    public static final Supplier<SoundType> BLOCK_SHROOMLIGHT_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.shroomlight.place");

    public static final Supplier<SoundType> BLOCK_SHROOMLIGHT_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.shroomlight.step");

    public static final Supplier<SoundType> BLOCK_SHULKER_BOX_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.shulker_box.close");

    public static final Supplier<SoundType> BLOCK_SHULKER_BOX_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.shulker_box.open");

    public static final Supplier<SoundType> BLOCK_SLIME_BLOCK_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.slime_block.break");

    public static final Supplier<SoundType> BLOCK_SLIME_BLOCK_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.slime_block.fall");

    public static final Supplier<SoundType> BLOCK_SLIME_BLOCK_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.slime_block.hit");

    public static final Supplier<SoundType> BLOCK_SLIME_BLOCK_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.slime_block.place");

    public static final Supplier<SoundType> BLOCK_SLIME_BLOCK_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.slime_block.step");

    public static final Supplier<SoundType> BLOCK_SMITHING_TABLE_USE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.smithing_table.use");

    public static final Supplier<SoundType> BLOCK_SMOKER_SMOKE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.smoker.smoke");

    public static final Supplier<SoundType> BLOCK_SNOW_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.snow.break");

    public static final Supplier<SoundType> BLOCK_SNOW_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.snow.fall");

    public static final Supplier<SoundType> BLOCK_SNOW_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.snow.hit");

    public static final Supplier<SoundType> BLOCK_SNOW_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.snow.place");

    public static final Supplier<SoundType> BLOCK_SNOW_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.snow.step");

    public static final Supplier<SoundType> BLOCK_SOUL_SAND_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.soul_sand.break");

    public static final Supplier<SoundType> BLOCK_SOUL_SAND_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.soul_sand.fall");

    public static final Supplier<SoundType> BLOCK_SOUL_SAND_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.soul_sand.hit");

    public static final Supplier<SoundType> BLOCK_SOUL_SAND_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.soul_sand.place");

    public static final Supplier<SoundType> BLOCK_SOUL_SAND_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.soul_sand.step");

    public static final Supplier<SoundType> BLOCK_SOUL_SOIL_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.soul_soil.break");

    public static final Supplier<SoundType> BLOCK_SOUL_SOIL_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.soul_soil.fall");

    public static final Supplier<SoundType> BLOCK_SOUL_SOIL_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.soul_soil.hit");

    public static final Supplier<SoundType> BLOCK_SOUL_SOIL_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.soul_soil.place");

    public static final Supplier<SoundType> BLOCK_SOUL_SOIL_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.soul_soil.step");

    public static final Supplier<SoundType> BLOCK_STEM_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.stem.break");

    public static final Supplier<SoundType> BLOCK_STEM_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.stem.fall");

    public static final Supplier<SoundType> BLOCK_STEM_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.stem.hit");

    public static final Supplier<SoundType> BLOCK_STEM_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.stem.place");

    public static final Supplier<SoundType> BLOCK_STEM_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.stem.step");

    public static final Supplier<SoundType> BLOCK_STONE_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.stone.break");

    public static final Supplier<SoundType> BLOCK_STONE_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.stone.fall");

    public static final Supplier<SoundType> BLOCK_STONE_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.stone.hit");

    public static final Supplier<SoundType> BLOCK_STONE_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.stone.place");

    public static final Supplier<SoundType> BLOCK_STONE_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.stone.step");

    public static final Supplier<SoundType> BLOCK_STONE_BUTTON_CLICK_OFF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.stone_button.click_off");

    public static final Supplier<SoundType> BLOCK_STONE_BUTTON_CLICK_ON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.stone_button.click_on");

    public static final Supplier<SoundType> BLOCK_STONE_PRESSURE_PLATE_CLICK_OFF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.stone_pressure_plate.click_off");

    public static final Supplier<SoundType> BLOCK_STONE_PRESSURE_PLATE_CLICK_ON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.stone_pressure_plate.click_on");

    public static final Supplier<SoundType> BLOCK_SWEET_BERRY_BUSH_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.sweet_berry_bush.break");

    public static final Supplier<SoundType> BLOCK_SWEET_BERRY_BUSH_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.sweet_berry_bush.place");

    public static final Supplier<SoundType> BLOCK_TRIPWIRE_ATTACH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.tripwire.attach");

    public static final Supplier<SoundType> BLOCK_TRIPWIRE_CLICK_OFF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.tripwire.click_off");

    public static final Supplier<SoundType> BLOCK_TRIPWIRE_CLICK_ON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.tripwire.click_on");

    public static final Supplier<SoundType> BLOCK_TRIPWIRE_DETACH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.tripwire.detach");

    public static final Supplier<SoundType> BLOCK_VINE_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.vine.step");

    public static final Supplier<SoundType> BLOCK_WART_BLOCK_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wart_block.break");

    public static final Supplier<SoundType> BLOCK_WART_BLOCK_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wart_block.fall");

    public static final Supplier<SoundType> BLOCK_WART_BLOCK_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wart_block.hit");

    public static final Supplier<SoundType> BLOCK_WART_BLOCK_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wart_block.place");

    public static final Supplier<SoundType> BLOCK_WART_BLOCK_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wart_block.step");

    public static final Supplier<SoundType> BLOCK_WATER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.water.ambient");

    public static final Supplier<SoundType> BLOCK_WEEPING_VINES_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.weeping_vines.break");

    public static final Supplier<SoundType> BLOCK_WEEPING_VINES_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.weeping_vines.fall");

    public static final Supplier<SoundType> BLOCK_WEEPING_VINES_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.weeping_vines.hit");

    public static final Supplier<SoundType> BLOCK_WEEPING_VINES_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.weeping_vines.place");

    public static final Supplier<SoundType> BLOCK_WEEPING_VINES_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.weeping_vines.step");

    public static final Supplier<SoundType> BLOCK_WET_GRASS_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wet_grass.break");

    public static final Supplier<SoundType> BLOCK_WET_GRASS_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wet_grass.fall");

    public static final Supplier<SoundType> BLOCK_WET_GRASS_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wet_grass.hit");

    public static final Supplier<SoundType> BLOCK_WET_GRASS_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wet_grass.place");

    public static final Supplier<SoundType> BLOCK_WET_GRASS_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wet_grass.step");

    public static final Supplier<SoundType> BLOCK_WOOD_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wood.break");

    public static final Supplier<SoundType> BLOCK_WOOD_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wood.fall");

    public static final Supplier<SoundType> BLOCK_WOOD_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wood.hit");

    public static final Supplier<SoundType> BLOCK_WOOD_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wood.place");

    public static final Supplier<SoundType> BLOCK_WOOD_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wood.step");

    public static final Supplier<SoundType> BLOCK_WOODEN_BUTTON_CLICK_OFF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wooden_button.click_off");

    public static final Supplier<SoundType> BLOCK_WOODEN_BUTTON_CLICK_ON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wooden_button.click_on");

    public static final Supplier<SoundType> BLOCK_WOODEN_DOOR_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wooden_door.close");

    public static final Supplier<SoundType> BLOCK_WOODEN_DOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wooden_door.open");

    public static final Supplier<SoundType> BLOCK_WOODEN_PRESSURE_PLATE_CLICK_OFF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wooden_pressure_plate.click_off");

    public static final Supplier<SoundType> BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wooden_pressure_plate.click_on");

    public static final Supplier<SoundType> BLOCK_WOODEN_TRAPDOOR_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wooden_trapdoor.close");

    public static final Supplier<SoundType> BLOCK_WOODEN_TRAPDOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wooden_trapdoor.open");

    public static final Supplier<SoundType> BLOCK_WOOL_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wool.break");

    public static final Supplier<SoundType> BLOCK_WOOL_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wool.fall");

    public static final Supplier<SoundType> BLOCK_WOOL_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wool.hit");

    public static final Supplier<SoundType> BLOCK_WOOL_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wool.place");

    public static final Supplier<SoundType> BLOCK_WOOL_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "block.wool.step");

    public static final Supplier<SoundType> ENCHANT_THORNS_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "enchant.thorns.hit");

    public static final Supplier<SoundType> ENTITY_ARMOR_STAND_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.armor_stand.break");

    public static final Supplier<SoundType> ENTITY_ARMOR_STAND_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.armor_stand.fall");

    public static final Supplier<SoundType> ENTITY_ARMOR_STAND_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.armor_stand.hit");

    public static final Supplier<SoundType> ENTITY_ARMOR_STAND_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.armor_stand.place");

    public static final Supplier<SoundType> ENTITY_ARROW_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.arrow.hit");

    public static final Supplier<SoundType> ENTITY_ARROW_HIT_PLAYER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.arrow.hit_player");

    public static final Supplier<SoundType> ENTITY_ARROW_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.arrow.shoot");

    public static final Supplier<SoundType> ENTITY_BAT_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.bat.ambient");

    public static final Supplier<SoundType> ENTITY_BAT_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.bat.death");

    public static final Supplier<SoundType> ENTITY_BAT_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.bat.hurt");

    public static final Supplier<SoundType> ENTITY_BAT_LOOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.bat.loop");

    public static final Supplier<SoundType> ENTITY_BAT_TAKEOFF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.bat.takeoff");

    public static final Supplier<SoundType> ENTITY_BEE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.bee.death");

    public static final Supplier<SoundType> ENTITY_BEE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.bee.hurt");

    public static final Supplier<SoundType> ENTITY_BEE_LOOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.bee.loop");

    public static final Supplier<SoundType> ENTITY_BEE_LOOP_AGGRESSIVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.bee.loop_aggressive");

    public static final Supplier<SoundType> ENTITY_BEE_POLLINATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.bee.pollinate");

    public static final Supplier<SoundType> ENTITY_BEE_STING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.bee.sting");

    public static final Supplier<SoundType> ENTITY_BLAZE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.blaze.ambient");

    public static final Supplier<SoundType> ENTITY_BLAZE_BURN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.blaze.burn");

    public static final Supplier<SoundType> ENTITY_BLAZE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.blaze.death");

    public static final Supplier<SoundType> ENTITY_BLAZE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.blaze.hurt");

    public static final Supplier<SoundType> ENTITY_BLAZE_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.blaze.shoot");

    public static final Supplier<SoundType> ENTITY_BOAT_PADDLE_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.boat.paddle_land");

    public static final Supplier<SoundType> ENTITY_BOAT_PADDLE_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.boat.paddle_water");

    public static final Supplier<SoundType> ENTITY_CAT_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.cat.ambient");

    public static final Supplier<SoundType> ENTITY_CAT_BEG_FOR_FOOD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.cat.beg_for_food");

    public static final Supplier<SoundType> ENTITY_CAT_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.cat.death");

    public static final Supplier<SoundType> ENTITY_CAT_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.cat.eat");

    public static final Supplier<SoundType> ENTITY_CAT_HISS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.cat.hiss");

    public static final Supplier<SoundType> ENTITY_CAT_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.cat.hurt");

    public static final Supplier<SoundType> ENTITY_CAT_PURR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.cat.purr");

    public static final Supplier<SoundType> ENTITY_CAT_PURREOW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.cat.purreow");

    public static final Supplier<SoundType> ENTITY_CAT_STRAY_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.cat.stray_ambient");

    public static final Supplier<SoundType> ENTITY_CHICKEN_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.chicken.ambient");

    public static final Supplier<SoundType> ENTITY_CHICKEN_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.chicken.death");

    public static final Supplier<SoundType> ENTITY_CHICKEN_EGG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.chicken.egg");

    public static final Supplier<SoundType> ENTITY_CHICKEN_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.chicken.hurt");

    public static final Supplier<SoundType> ENTITY_CHICKEN_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.chicken.step");

    public static final Supplier<SoundType> ENTITY_COD_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.cod.ambient");

    public static final Supplier<SoundType> ENTITY_COD_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.cod.death");

    public static final Supplier<SoundType> ENTITY_COD_FLOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.cod.flop");

    public static final Supplier<SoundType> ENTITY_COD_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.cod.hurt");

    public static final Supplier<SoundType> ENTITY_COW_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.cow.ambient");

    public static final Supplier<SoundType> ENTITY_COW_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.cow.death");

    public static final Supplier<SoundType> ENTITY_COW_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.cow.hurt");

    public static final Supplier<SoundType> ENTITY_COW_MILK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.cow.milk");

    public static final Supplier<SoundType> ENTITY_COW_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.cow.step");

    public static final Supplier<SoundType> ENTITY_CREEPER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.creeper.death");

    public static final Supplier<SoundType> ENTITY_CREEPER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.creeper.hurt");

    public static final Supplier<SoundType> ENTITY_CREEPER_PRIMED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.creeper.primed");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.dolphin.ambient");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_AMBIENT_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.dolphin.ambient_water");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.dolphin.attack");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.dolphin.death");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.dolphin.eat");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.dolphin.hurt");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_JUMP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.dolphin.jump");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_PLAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.dolphin.play");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_SPLASH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.dolphin.splash");

    public static final Supplier<SoundType> ENTITY_DOLPHIN_SWIM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.dolphin.swim");

    public static final Supplier<SoundType> ENTITY_DONKEY_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.donkey.ambient");

    public static final Supplier<SoundType> ENTITY_DONKEY_ANGRY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.donkey.angry");

    public static final Supplier<SoundType> ENTITY_DONKEY_CHEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.donkey.chest");

    public static final Supplier<SoundType> ENTITY_DONKEY_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.donkey.death");

    public static final Supplier<SoundType> ENTITY_DONKEY_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.donkey.eat");

    public static final Supplier<SoundType> ENTITY_DONKEY_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.donkey.hurt");

    public static final Supplier<SoundType> ENTITY_DRAGON_FIREBALL_EXPLODE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.dragon_fireball.explode");

    public static final Supplier<SoundType> ENTITY_DROWNED_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.drowned.ambient");

    public static final Supplier<SoundType> ENTITY_DROWNED_AMBIENT_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.drowned.ambient_water");

    public static final Supplier<SoundType> ENTITY_DROWNED_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.drowned.death");

    public static final Supplier<SoundType> ENTITY_DROWNED_DEATH_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.drowned.death_water");

    public static final Supplier<SoundType> ENTITY_DROWNED_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.drowned.hurt");

    public static final Supplier<SoundType> ENTITY_DROWNED_HURT_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.drowned.hurt_water");

    public static final Supplier<SoundType> ENTITY_DROWNED_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.drowned.shoot");

    public static final Supplier<SoundType> ENTITY_DROWNED_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.drowned.step");

    public static final Supplier<SoundType> ENTITY_DROWNED_SWIM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.drowned.swim");

    public static final Supplier<SoundType> ENTITY_EGG_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.egg.throw");

    public static final Supplier<SoundType> ENTITY_ELDER_GUARDIAN_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.elder_guardian.ambient");

    public static final Supplier<SoundType> ENTITY_ELDER_GUARDIAN_AMBIENT_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.elder_guardian.ambient_land");

    public static final Supplier<SoundType> ENTITY_ELDER_GUARDIAN_CURSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.elder_guardian.curse");

    public static final Supplier<SoundType> ENTITY_ELDER_GUARDIAN_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.elder_guardian.death");

    public static final Supplier<SoundType> ENTITY_ELDER_GUARDIAN_DEATH_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.elder_guardian.death_land");

    public static final Supplier<SoundType> ENTITY_ELDER_GUARDIAN_FLOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.elder_guardian.flop");

    public static final Supplier<SoundType> ENTITY_ELDER_GUARDIAN_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.elder_guardian.hurt");

    public static final Supplier<SoundType> ENTITY_ELDER_GUARDIAN_HURT_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.elder_guardian.hurt_land");

    public static final Supplier<SoundType> ENTITY_ENDER_DRAGON_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.ender_dragon.ambient");

    public static final Supplier<SoundType> ENTITY_ENDER_DRAGON_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.ender_dragon.death");

    public static final Supplier<SoundType> ENTITY_ENDER_DRAGON_FLAP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.ender_dragon.flap");

    public static final Supplier<SoundType> ENTITY_ENDER_DRAGON_GROWL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.ender_dragon.growl");

    public static final Supplier<SoundType> ENTITY_ENDER_DRAGON_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.ender_dragon.hurt");

    public static final Supplier<SoundType> ENTITY_ENDER_DRAGON_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.ender_dragon.shoot");

    public static final Supplier<SoundType> ENTITY_ENDER_EYE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.ender_eye.death");

    public static final Supplier<SoundType> ENTITY_ENDER_EYE_LAUNCH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.ender_eye.launch");

    public static final Supplier<SoundType> ENTITY_ENDER_PEARL_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.ender_pearl.throw");

    public static final Supplier<SoundType> ENTITY_ENDERMAN_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.enderman.ambient");

    public static final Supplier<SoundType> ENTITY_ENDERMAN_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.enderman.death");

    public static final Supplier<SoundType> ENTITY_ENDERMAN_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.enderman.hurt");

    public static final Supplier<SoundType> ENTITY_ENDERMAN_SCREAM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.enderman.scream");

    public static final Supplier<SoundType> ENTITY_ENDERMAN_STARE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.enderman.stare");

    public static final Supplier<SoundType> ENTITY_ENDERMAN_TELEPORT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.enderman.teleport");

    public static final Supplier<SoundType> ENTITY_ENDERMITE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.endermite.ambient");

    public static final Supplier<SoundType> ENTITY_ENDERMITE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.endermite.death");

    public static final Supplier<SoundType> ENTITY_ENDERMITE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.endermite.hurt");

    public static final Supplier<SoundType> ENTITY_ENDERMITE_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.endermite.step");

    public static final Supplier<SoundType> ENTITY_EVOKER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.evoker.ambient");

    public static final Supplier<SoundType> ENTITY_EVOKER_CAST_SPELL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.evoker.cast_spell");

    public static final Supplier<SoundType> ENTITY_EVOKER_CELEBRATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.evoker.celebrate");

    public static final Supplier<SoundType> ENTITY_EVOKER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.evoker.death");

    public static final Supplier<SoundType> ENTITY_EVOKER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.evoker.hurt");

    public static final Supplier<SoundType> ENTITY_EVOKER_PREPARE_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.evoker.prepare_attack");

    public static final Supplier<SoundType> ENTITY_EVOKER_PREPARE_SUMMON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.evoker.prepare_summon");

    public static final Supplier<SoundType> ENTITY_EVOKER_PREPARE_WOLOLO = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.evoker.prepare_wololo");

    public static final Supplier<SoundType> ENTITY_EVOKER_FANGS_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.evoker_fangs.attack");

    public static final Supplier<SoundType> ENTITY_EXPERIENCE_BOTTLE_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.experience_bottle.throw");

    public static final Supplier<SoundType> ENTITY_EXPERIENCE_ORB_PICKUP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.experience_orb.pickup");

    public static final Supplier<SoundType> ENTITY_FIREWORK_ROCKET_BLAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.firework_rocket.blast");

    public static final Supplier<SoundType> ENTITY_FIREWORK_ROCKET_BLAST_FAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.firework_rocket.blast_far");

    public static final Supplier<SoundType> ENTITY_FIREWORK_ROCKET_LARGE_BLAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.firework_rocket.large_blast");

    public static final Supplier<SoundType> ENTITY_FIREWORK_ROCKET_LARGE_BLAST_FAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.firework_rocket.large_blast_far");

    public static final Supplier<SoundType> ENTITY_FIREWORK_ROCKET_LAUNCH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.firework_rocket.launch");

    public static final Supplier<SoundType> ENTITY_FIREWORK_ROCKET_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.firework_rocket.shoot");

    public static final Supplier<SoundType> ENTITY_FIREWORK_ROCKET_TWINKLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.firework_rocket.twinkle");

    public static final Supplier<SoundType> ENTITY_FIREWORK_ROCKET_TWINKLE_FAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.firework_rocket.twinkle_far");

    public static final Supplier<SoundType> ENTITY_FISH_SWIM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.fish.swim");

    public static final Supplier<SoundType> ENTITY_FISHING_BOBBER_RETRIEVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.fishing_bobber.retrieve");

    public static final Supplier<SoundType> ENTITY_FISHING_BOBBER_SPLASH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.fishing_bobber.splash");

    public static final Supplier<SoundType> ENTITY_FISHING_BOBBER_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.fishing_bobber.throw");

    public static final Supplier<SoundType> ENTITY_FOX_AGGRO = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.fox.aggro");

    public static final Supplier<SoundType> ENTITY_FOX_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.fox.ambient");

    public static final Supplier<SoundType> ENTITY_FOX_BITE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.fox.bite");

    public static final Supplier<SoundType> ENTITY_FOX_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.fox.death");

    public static final Supplier<SoundType> ENTITY_FOX_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.fox.eat");

    public static final Supplier<SoundType> ENTITY_FOX_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.fox.hurt");

    public static final Supplier<SoundType> ENTITY_FOX_SCREECH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.fox.screech");

    public static final Supplier<SoundType> ENTITY_FOX_SLEEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.fox.sleep");

    public static final Supplier<SoundType> ENTITY_FOX_SNIFF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.fox.sniff");

    public static final Supplier<SoundType> ENTITY_FOX_SPIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.fox.spit");

    public static final Supplier<SoundType> ENTITY_FOX_TELEPORT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.fox.teleport");

    public static final Supplier<SoundType> ENTITY_GENERIC_BIG_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.generic.big_fall");

    public static final Supplier<SoundType> ENTITY_GENERIC_BURN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.generic.burn");

    public static final Supplier<SoundType> ENTITY_GENERIC_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.generic.death");

    public static final Supplier<SoundType> ENTITY_GENERIC_DRINK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.generic.drink");

    public static final Supplier<SoundType> ENTITY_GENERIC_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.generic.eat");

    public static final Supplier<SoundType> ENTITY_GENERIC_EXPLODE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.generic.explode");

    public static final Supplier<SoundType> ENTITY_GENERIC_EXTINGUISH_FIRE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.generic.extinguish_fire");

    public static final Supplier<SoundType> ENTITY_GENERIC_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.generic.hurt");

    public static final Supplier<SoundType> ENTITY_GENERIC_SMALL_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.generic.small_fall");

    public static final Supplier<SoundType> ENTITY_GENERIC_SPLASH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.generic.splash");

    public static final Supplier<SoundType> ENTITY_GENERIC_SWIM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.generic.swim");

    public static final Supplier<SoundType> ENTITY_GHAST_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.ghast.ambient");

    public static final Supplier<SoundType> ENTITY_GHAST_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.ghast.death");

    public static final Supplier<SoundType> ENTITY_GHAST_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.ghast.hurt");

    public static final Supplier<SoundType> ENTITY_GHAST_SCREAM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.ghast.scream");

    public static final Supplier<SoundType> ENTITY_GHAST_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.ghast.shoot");

    public static final Supplier<SoundType> ENTITY_GHAST_WARN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.ghast.warn");

    public static final Supplier<SoundType> ENTITY_GUARDIAN_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.guardian.ambient");

    public static final Supplier<SoundType> ENTITY_GUARDIAN_AMBIENT_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.guardian.ambient_land");

    public static final Supplier<SoundType> ENTITY_GUARDIAN_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.guardian.attack");

    public static final Supplier<SoundType> ENTITY_GUARDIAN_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.guardian.death");

    public static final Supplier<SoundType> ENTITY_GUARDIAN_DEATH_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.guardian.death_land");

    public static final Supplier<SoundType> ENTITY_GUARDIAN_FLOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.guardian.flop");

    public static final Supplier<SoundType> ENTITY_GUARDIAN_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.guardian.hurt");

    public static final Supplier<SoundType> ENTITY_GUARDIAN_HURT_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.guardian.hurt_land");

    public static final Supplier<SoundType> ENTITY_HOGLIN_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.hoglin.ambient");

    public static final Supplier<SoundType> ENTITY_HOGLIN_ANGRY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.hoglin.angry");

    public static final Supplier<SoundType> ENTITY_HOGLIN_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.hoglin.attack");

    public static final Supplier<SoundType> ENTITY_HOGLIN_CONVERTED_TO_ZOMBIFIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.hoglin.converted_to_zombified");

    public static final Supplier<SoundType> ENTITY_HOGLIN_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.hoglin.death");

    public static final Supplier<SoundType> ENTITY_HOGLIN_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.hoglin.hurt");

    public static final Supplier<SoundType> ENTITY_HOGLIN_RETREAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.hoglin.retreat");

    public static final Supplier<SoundType> ENTITY_HOGLIN_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.hoglin.step");

    public static final Supplier<SoundType> ENTITY_HORSE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.horse.ambient");

    public static final Supplier<SoundType> ENTITY_HORSE_ANGRY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.horse.angry");

    public static final Supplier<SoundType> ENTITY_HORSE_ARMOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.horse.armor");

    public static final Supplier<SoundType> ENTITY_HORSE_BREATHE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.horse.breathe");

    public static final Supplier<SoundType> ENTITY_HORSE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.horse.death");

    public static final Supplier<SoundType> ENTITY_HORSE_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.horse.eat");

    public static final Supplier<SoundType> ENTITY_HORSE_GALLOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.horse.gallop");

    public static final Supplier<SoundType> ENTITY_HORSE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.horse.hurt");

    public static final Supplier<SoundType> ENTITY_HORSE_JUMP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.horse.jump");

    public static final Supplier<SoundType> ENTITY_HORSE_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.horse.land");

    public static final Supplier<SoundType> ENTITY_HORSE_SADDLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.horse.saddle");

    public static final Supplier<SoundType> ENTITY_HORSE_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.horse.step");

    public static final Supplier<SoundType> ENTITY_HORSE_STEP_WOOD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.horse.step_wood");

    public static final Supplier<SoundType> ENTITY_HOSTILE_BIG_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.hostile.big_fall");

    public static final Supplier<SoundType> ENTITY_HOSTILE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.hostile.death");

    public static final Supplier<SoundType> ENTITY_HOSTILE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.hostile.hurt");

    public static final Supplier<SoundType> ENTITY_HOSTILE_SMALL_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.hostile.small_fall");

    public static final Supplier<SoundType> ENTITY_HOSTILE_SPLASH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.hostile.splash");

    public static final Supplier<SoundType> ENTITY_HOSTILE_SWIM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.hostile.swim");

    public static final Supplier<SoundType> ENTITY_HUSK_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.husk.ambient");

    public static final Supplier<SoundType> ENTITY_HUSK_CONVERTED_TO_ZOMBIE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.husk.converted_to_zombie");

    public static final Supplier<SoundType> ENTITY_HUSK_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.husk.death");

    public static final Supplier<SoundType> ENTITY_HUSK_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.husk.hurt");

    public static final Supplier<SoundType> ENTITY_HUSK_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.husk.step");

    public static final Supplier<SoundType> ENTITY_ILLUSIONER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.illusioner.ambient");

    public static final Supplier<SoundType> ENTITY_ILLUSIONER_CAST_SPELL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.illusioner.cast_spell");

    public static final Supplier<SoundType> ENTITY_ILLUSIONER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.illusioner.death");

    public static final Supplier<SoundType> ENTITY_ILLUSIONER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.illusioner.hurt");

    public static final Supplier<SoundType> ENTITY_ILLUSIONER_MIRROR_MOVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.illusioner.mirror_move");

    public static final Supplier<SoundType> ENTITY_ILLUSIONER_PREPARE_BLINDNESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.illusioner.prepare_blindness");

    public static final Supplier<SoundType> ENTITY_ILLUSIONER_PREPARE_MIRROR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.illusioner.prepare_mirror");

    public static final Supplier<SoundType> ENTITY_IRON_GOLEM_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.iron_golem.attack");

    public static final Supplier<SoundType> ENTITY_IRON_GOLEM_DAMAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.iron_golem.damage");

    public static final Supplier<SoundType> ENTITY_IRON_GOLEM_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.iron_golem.death");

    public static final Supplier<SoundType> ENTITY_IRON_GOLEM_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.iron_golem.hurt");

    public static final Supplier<SoundType> ENTITY_IRON_GOLEM_REPAIR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.iron_golem.repair");

    public static final Supplier<SoundType> ENTITY_IRON_GOLEM_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.iron_golem.step");

    public static final Supplier<SoundType> ENTITY_ITEM_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.item.break");

    public static final Supplier<SoundType> ENTITY_ITEM_PICKUP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.item.pickup");

    public static final Supplier<SoundType> ENTITY_ITEM_FRAME_ADD_ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.item_frame.add_item");

    public static final Supplier<SoundType> ENTITY_ITEM_FRAME_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.item_frame.break");

    public static final Supplier<SoundType> ENTITY_ITEM_FRAME_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.item_frame.place");

    public static final Supplier<SoundType> ENTITY_ITEM_FRAME_REMOVE_ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.item_frame.remove_item");

    public static final Supplier<SoundType> ENTITY_ITEM_FRAME_ROTATE_ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.item_frame.rotate_item");

    public static final Supplier<SoundType> ENTITY_LEASH_KNOT_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.leash_knot.break");

    public static final Supplier<SoundType> ENTITY_LEASH_KNOT_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.leash_knot.place");

    public static final Supplier<SoundType> ENTITY_LIGHTNING_BOLT_IMPACT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.lightning_bolt.impact");

    public static final Supplier<SoundType> ENTITY_LIGHTNING_BOLT_THUNDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.lightning_bolt.thunder");

    public static final Supplier<SoundType> ENTITY_LINGERING_POTION_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.lingering_potion.throw");

    public static final Supplier<SoundType> ENTITY_LLAMA_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.llama.ambient");

    public static final Supplier<SoundType> ENTITY_LLAMA_ANGRY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.llama.angry");

    public static final Supplier<SoundType> ENTITY_LLAMA_CHEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.llama.chest");

    public static final Supplier<SoundType> ENTITY_LLAMA_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.llama.death");

    public static final Supplier<SoundType> ENTITY_LLAMA_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.llama.eat");

    public static final Supplier<SoundType> ENTITY_LLAMA_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.llama.hurt");

    public static final Supplier<SoundType> ENTITY_LLAMA_SPIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.llama.spit");

    public static final Supplier<SoundType> ENTITY_LLAMA_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.llama.step");

    public static final Supplier<SoundType> ENTITY_LLAMA_SWAG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.llama.swag");

    public static final Supplier<SoundType> ENTITY_MAGMA_CUBE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.magma_cube.death");

    public static final Supplier<SoundType> ENTITY_MAGMA_CUBE_DEATH_SMALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.magma_cube.death_small");

    public static final Supplier<SoundType> ENTITY_MAGMA_CUBE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.magma_cube.hurt");

    public static final Supplier<SoundType> ENTITY_MAGMA_CUBE_HURT_SMALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.magma_cube.hurt_small");

    public static final Supplier<SoundType> ENTITY_MAGMA_CUBE_JUMP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.magma_cube.jump");

    public static final Supplier<SoundType> ENTITY_MAGMA_CUBE_SQUISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.magma_cube.squish");

    public static final Supplier<SoundType> ENTITY_MAGMA_CUBE_SQUISH_SMALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.magma_cube.squish_small");

    public static final Supplier<SoundType> ENTITY_MINECART_INSIDE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.minecart.inside");

    public static final Supplier<SoundType> ENTITY_MINECART_RIDING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.minecart.riding");

    public static final Supplier<SoundType> ENTITY_MOOSHROOM_CONVERT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.mooshroom.convert");

    public static final Supplier<SoundType> ENTITY_MOOSHROOM_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.mooshroom.eat");

    public static final Supplier<SoundType> ENTITY_MOOSHROOM_MILK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.mooshroom.milk");

    public static final Supplier<SoundType> ENTITY_MOOSHROOM_SHEAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.mooshroom.shear");

    public static final Supplier<SoundType> ENTITY_MOOSHROOM_SUSPICIOUS_MILK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.mooshroom.suspicious_milk");

    public static final Supplier<SoundType> ENTITY_MULE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.mule.ambient");

    public static final Supplier<SoundType> ENTITY_MULE_ANGRY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.mule.angry");

    public static final Supplier<SoundType> ENTITY_MULE_CHEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.mule.chest");

    public static final Supplier<SoundType> ENTITY_MULE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.mule.death");

    public static final Supplier<SoundType> ENTITY_MULE_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.mule.eat");

    public static final Supplier<SoundType> ENTITY_MULE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.mule.hurt");

    public static final Supplier<SoundType> ENTITY_OCELOT_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.ocelot.ambient");

    public static final Supplier<SoundType> ENTITY_OCELOT_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.ocelot.death");

    public static final Supplier<SoundType> ENTITY_OCELOT_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.ocelot.hurt");

    public static final Supplier<SoundType> ENTITY_PAINTING_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.painting.break");

    public static final Supplier<SoundType> ENTITY_PAINTING_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.painting.place");

    public static final Supplier<SoundType> ENTITY_PANDA_AGGRESSIVE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.panda.aggressive_ambient");

    public static final Supplier<SoundType> ENTITY_PANDA_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.panda.ambient");

    public static final Supplier<SoundType> ENTITY_PANDA_BITE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.panda.bite");

    public static final Supplier<SoundType> ENTITY_PANDA_CANT_BREED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.panda.cant_breed");

    public static final Supplier<SoundType> ENTITY_PANDA_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.panda.death");

    public static final Supplier<SoundType> ENTITY_PANDA_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.panda.eat");

    public static final Supplier<SoundType> ENTITY_PANDA_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.panda.hurt");

    public static final Supplier<SoundType> ENTITY_PANDA_PRE_SNEEZE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.panda.pre_sneeze");

    public static final Supplier<SoundType> ENTITY_PANDA_SNEEZE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.panda.sneeze");

    public static final Supplier<SoundType> ENTITY_PANDA_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.panda.step");

    public static final Supplier<SoundType> ENTITY_PANDA_WORRIED_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.panda.worried_ambient");

    public static final Supplier<SoundType> ENTITY_PARROT_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.ambient");

    public static final Supplier<SoundType> ENTITY_PARROT_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.death");

    public static final Supplier<SoundType> ENTITY_PARROT_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.eat");

    public static final Supplier<SoundType> ENTITY_PARROT_FLY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.fly");

    public static final Supplier<SoundType> ENTITY_PARROT_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.hurt");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_BLAZE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.blaze");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_CREEPER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.creeper");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_DROWNED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.drowned");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_ELDER_GUARDIAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.elder_guardian");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_ENDER_DRAGON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.ender_dragon");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_ENDERMITE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.endermite");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_EVOKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.evoker");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_GHAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.ghast");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_GUARDIAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.guardian");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_HOGLIN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.hoglin");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_HUSK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.husk");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_ILLUSIONER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.illusioner");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_MAGMA_CUBE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.magma_cube");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_PHANTOM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.phantom");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_PIGLIN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.piglin");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_PIGLIN_BRUTE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.piglin_brute");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_PILLAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.pillager");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_RAVAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.ravager");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_SHULKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.shulker");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_SILVERFISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.silverfish");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_SKELETON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.skeleton");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_SLIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.slime");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_SPIDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.spider");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_STRAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.stray");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_VEX = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.vex");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_VINDICATOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.vindicator");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_WITCH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.witch");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_WITHER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.wither");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_WITHER_SKELETON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.wither_skeleton");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_ZOGLIN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.zoglin");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_ZOMBIE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.zombie");

    public static final Supplier<SoundType> ENTITY_PARROT_IMITATE_ZOMBIE_VILLAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.imitate.zombie_villager");

    public static final Supplier<SoundType> ENTITY_PARROT_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.parrot.step");

    public static final Supplier<SoundType> ENTITY_PHANTOM_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.phantom.ambient");

    public static final Supplier<SoundType> ENTITY_PHANTOM_BITE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.phantom.bite");

    public static final Supplier<SoundType> ENTITY_PHANTOM_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.phantom.death");

    public static final Supplier<SoundType> ENTITY_PHANTOM_FLAP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.phantom.flap");

    public static final Supplier<SoundType> ENTITY_PHANTOM_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.phantom.hurt");

    public static final Supplier<SoundType> ENTITY_PHANTOM_SWOOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.phantom.swoop");

    public static final Supplier<SoundType> ENTITY_PIG_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.pig.ambient");

    public static final Supplier<SoundType> ENTITY_PIG_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.pig.death");

    public static final Supplier<SoundType> ENTITY_PIG_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.pig.hurt");

    public static final Supplier<SoundType> ENTITY_PIG_SADDLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.pig.saddle");

    public static final Supplier<SoundType> ENTITY_PIG_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.pig.step");

    public static final Supplier<SoundType> ENTITY_PIGLIN_ADMIRING_ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.piglin.admiring_item");

    public static final Supplier<SoundType> ENTITY_PIGLIN_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.piglin.ambient");

    public static final Supplier<SoundType> ENTITY_PIGLIN_ANGRY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.piglin.angry");

    public static final Supplier<SoundType> ENTITY_PIGLIN_CELEBRATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.piglin.celebrate");

    public static final Supplier<SoundType> ENTITY_PIGLIN_CONVERTED_TO_ZOMBIFIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.piglin.converted_to_zombified");

    public static final Supplier<SoundType> ENTITY_PIGLIN_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.piglin.death");

    public static final Supplier<SoundType> ENTITY_PIGLIN_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.piglin.hurt");

    public static final Supplier<SoundType> ENTITY_PIGLIN_JEALOUS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.piglin.jealous");

    public static final Supplier<SoundType> ENTITY_PIGLIN_RETREAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.piglin.retreat");

    public static final Supplier<SoundType> ENTITY_PIGLIN_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.piglin.step");

    public static final Supplier<SoundType> ENTITY_PIGLIN_BRUTE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.piglin_brute.ambient");

    public static final Supplier<SoundType> ENTITY_PIGLIN_BRUTE_ANGRY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.piglin_brute.angry");

    public static final Supplier<SoundType> ENTITY_PIGLIN_BRUTE_CONVERTED_TO_ZOMBIFIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.piglin_brute.converted_to_zombified");

    public static final Supplier<SoundType> ENTITY_PIGLIN_BRUTE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.piglin_brute.death");

    public static final Supplier<SoundType> ENTITY_PIGLIN_BRUTE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.piglin_brute.hurt");

    public static final Supplier<SoundType> ENTITY_PIGLIN_BRUTE_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.piglin_brute.step");

    public static final Supplier<SoundType> ENTITY_PILLAGER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.pillager.ambient");

    public static final Supplier<SoundType> ENTITY_PILLAGER_CELEBRATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.pillager.celebrate");

    public static final Supplier<SoundType> ENTITY_PILLAGER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.pillager.death");

    public static final Supplier<SoundType> ENTITY_PILLAGER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.pillager.hurt");

    public static final Supplier<SoundType> ENTITY_PLAYER_ATTACK_CRIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.player.attack.crit");

    public static final Supplier<SoundType> ENTITY_PLAYER_ATTACK_KNOCKBACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.player.attack.knockback");

    public static final Supplier<SoundType> ENTITY_PLAYER_ATTACK_NODAMAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.player.attack.nodamage");

    public static final Supplier<SoundType> ENTITY_PLAYER_ATTACK_STRONG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.player.attack.strong");

    public static final Supplier<SoundType> ENTITY_PLAYER_ATTACK_SWEEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.player.attack.sweep");

    public static final Supplier<SoundType> ENTITY_PLAYER_ATTACK_WEAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.player.attack.weak");

    public static final Supplier<SoundType> ENTITY_PLAYER_BIG_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.player.big_fall");

    public static final Supplier<SoundType> ENTITY_PLAYER_BREATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.player.breath");

    public static final Supplier<SoundType> ENTITY_PLAYER_BURP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.player.burp");

    public static final Supplier<SoundType> ENTITY_PLAYER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.player.death");

    public static final Supplier<SoundType> ENTITY_PLAYER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.player.hurt");

    public static final Supplier<SoundType> ENTITY_PLAYER_HURT_DROWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.player.hurt_drown");

    public static final Supplier<SoundType> ENTITY_PLAYER_HURT_ON_FIRE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.player.hurt_on_fire");

    public static final Supplier<SoundType> ENTITY_PLAYER_HURT_SWEET_BERRY_BUSH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.player.hurt_sweet_berry_bush");

    public static final Supplier<SoundType> ENTITY_PLAYER_LEVELUP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.player.levelup");

    public static final Supplier<SoundType> ENTITY_PLAYER_SMALL_FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.player.small_fall");

    public static final Supplier<SoundType> ENTITY_PLAYER_SPLASH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.player.splash");

    public static final Supplier<SoundType> ENTITY_PLAYER_SPLASH_HIGH_SPEED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.player.splash.high_speed");

    public static final Supplier<SoundType> ENTITY_PLAYER_SWIM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.player.swim");

    public static final Supplier<SoundType> ENTITY_POLAR_BEAR_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.polar_bear.ambient");

    public static final Supplier<SoundType> ENTITY_POLAR_BEAR_AMBIENT_BABY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.polar_bear.ambient_baby");

    public static final Supplier<SoundType> ENTITY_POLAR_BEAR_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.polar_bear.death");

    public static final Supplier<SoundType> ENTITY_POLAR_BEAR_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.polar_bear.hurt");

    public static final Supplier<SoundType> ENTITY_POLAR_BEAR_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.polar_bear.step");

    public static final Supplier<SoundType> ENTITY_POLAR_BEAR_WARNING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.polar_bear.warning");

    public static final Supplier<SoundType> ENTITY_PUFFER_FISH_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.puffer_fish.ambient");

    public static final Supplier<SoundType> ENTITY_PUFFER_FISH_BLOW_OUT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.puffer_fish.blow_out");

    public static final Supplier<SoundType> ENTITY_PUFFER_FISH_BLOW_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.puffer_fish.blow_up");

    public static final Supplier<SoundType> ENTITY_PUFFER_FISH_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.puffer_fish.death");

    public static final Supplier<SoundType> ENTITY_PUFFER_FISH_FLOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.puffer_fish.flop");

    public static final Supplier<SoundType> ENTITY_PUFFER_FISH_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.puffer_fish.hurt");

    public static final Supplier<SoundType> ENTITY_PUFFER_FISH_STING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.puffer_fish.sting");

    public static final Supplier<SoundType> ENTITY_RABBIT_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.rabbit.ambient");

    public static final Supplier<SoundType> ENTITY_RABBIT_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.rabbit.attack");

    public static final Supplier<SoundType> ENTITY_RABBIT_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.rabbit.death");

    public static final Supplier<SoundType> ENTITY_RABBIT_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.rabbit.hurt");

    public static final Supplier<SoundType> ENTITY_RABBIT_JUMP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.rabbit.jump");

    public static final Supplier<SoundType> ENTITY_RAVAGER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.ravager.ambient");

    public static final Supplier<SoundType> ENTITY_RAVAGER_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.ravager.attack");

    public static final Supplier<SoundType> ENTITY_RAVAGER_CELEBRATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.ravager.celebrate");

    public static final Supplier<SoundType> ENTITY_RAVAGER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.ravager.death");

    public static final Supplier<SoundType> ENTITY_RAVAGER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.ravager.hurt");

    public static final Supplier<SoundType> ENTITY_RAVAGER_ROAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.ravager.roar");

    public static final Supplier<SoundType> ENTITY_RAVAGER_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.ravager.step");

    public static final Supplier<SoundType> ENTITY_RAVAGER_STUNNED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.ravager.stunned");

    public static final Supplier<SoundType> ENTITY_SALMON_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.salmon.ambient");

    public static final Supplier<SoundType> ENTITY_SALMON_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.salmon.death");

    public static final Supplier<SoundType> ENTITY_SALMON_FLOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.salmon.flop");

    public static final Supplier<SoundType> ENTITY_SALMON_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.salmon.hurt");

    public static final Supplier<SoundType> ENTITY_SHEEP_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.sheep.ambient");

    public static final Supplier<SoundType> ENTITY_SHEEP_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.sheep.death");

    public static final Supplier<SoundType> ENTITY_SHEEP_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.sheep.hurt");

    public static final Supplier<SoundType> ENTITY_SHEEP_SHEAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.sheep.shear");

    public static final Supplier<SoundType> ENTITY_SHEEP_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.sheep.step");

    public static final Supplier<SoundType> ENTITY_SHULKER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.shulker.ambient");

    public static final Supplier<SoundType> ENTITY_SHULKER_CLOSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.shulker.close");

    public static final Supplier<SoundType> ENTITY_SHULKER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.shulker.death");

    public static final Supplier<SoundType> ENTITY_SHULKER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.shulker.hurt");

    public static final Supplier<SoundType> ENTITY_SHULKER_HURT_CLOSED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.shulker.hurt_closed");

    public static final Supplier<SoundType> ENTITY_SHULKER_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.shulker.open");

    public static final Supplier<SoundType> ENTITY_SHULKER_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.shulker.shoot");

    public static final Supplier<SoundType> ENTITY_SHULKER_TELEPORT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.shulker.teleport");

    public static final Supplier<SoundType> ENTITY_SHULKER_BULLET_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.shulker_bullet.hit");

    public static final Supplier<SoundType> ENTITY_SHULKER_BULLET_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.shulker_bullet.hurt");

    public static final Supplier<SoundType> ENTITY_SILVERFISH_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.silverfish.ambient");

    public static final Supplier<SoundType> ENTITY_SILVERFISH_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.silverfish.death");

    public static final Supplier<SoundType> ENTITY_SILVERFISH_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.silverfish.hurt");

    public static final Supplier<SoundType> ENTITY_SILVERFISH_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.silverfish.step");

    public static final Supplier<SoundType> ENTITY_SKELETON_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.skeleton.ambient");

    public static final Supplier<SoundType> ENTITY_SKELETON_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.skeleton.death");

    public static final Supplier<SoundType> ENTITY_SKELETON_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.skeleton.hurt");

    public static final Supplier<SoundType> ENTITY_SKELETON_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.skeleton.shoot");

    public static final Supplier<SoundType> ENTITY_SKELETON_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.skeleton.step");

    public static final Supplier<SoundType> ENTITY_SKELETON_HORSE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.skeleton_horse.ambient");

    public static final Supplier<SoundType> ENTITY_SKELETON_HORSE_AMBIENT_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.skeleton_horse.ambient_water");

    public static final Supplier<SoundType> ENTITY_SKELETON_HORSE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.skeleton_horse.death");

    public static final Supplier<SoundType> ENTITY_SKELETON_HORSE_GALLOP_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.skeleton_horse.gallop_water");

    public static final Supplier<SoundType> ENTITY_SKELETON_HORSE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.skeleton_horse.hurt");

    public static final Supplier<SoundType> ENTITY_SKELETON_HORSE_JUMP_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.skeleton_horse.jump_water");

    public static final Supplier<SoundType> ENTITY_SKELETON_HORSE_STEP_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.skeleton_horse.step_water");

    public static final Supplier<SoundType> ENTITY_SKELETON_HORSE_SWIM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.skeleton_horse.swim");

    public static final Supplier<SoundType> ENTITY_SLIME_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.slime.attack");

    public static final Supplier<SoundType> ENTITY_SLIME_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.slime.death");

    public static final Supplier<SoundType> ENTITY_SLIME_DEATH_SMALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.slime.death_small");

    public static final Supplier<SoundType> ENTITY_SLIME_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.slime.hurt");

    public static final Supplier<SoundType> ENTITY_SLIME_HURT_SMALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.slime.hurt_small");

    public static final Supplier<SoundType> ENTITY_SLIME_JUMP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.slime.jump");

    public static final Supplier<SoundType> ENTITY_SLIME_JUMP_SMALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.slime.jump_small");

    public static final Supplier<SoundType> ENTITY_SLIME_SQUISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.slime.squish");

    public static final Supplier<SoundType> ENTITY_SLIME_SQUISH_SMALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.slime.squish_small");

    public static final Supplier<SoundType> ENTITY_SNOW_GOLEM_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.snow_golem.ambient");

    public static final Supplier<SoundType> ENTITY_SNOW_GOLEM_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.snow_golem.death");

    public static final Supplier<SoundType> ENTITY_SNOW_GOLEM_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.snow_golem.hurt");

    public static final Supplier<SoundType> ENTITY_SNOW_GOLEM_SHEAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.snow_golem.shear");

    public static final Supplier<SoundType> ENTITY_SNOW_GOLEM_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.snow_golem.shoot");

    public static final Supplier<SoundType> ENTITY_SNOWBALL_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.snowball.throw");

    public static final Supplier<SoundType> ENTITY_SPIDER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.spider.ambient");

    public static final Supplier<SoundType> ENTITY_SPIDER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.spider.death");

    public static final Supplier<SoundType> ENTITY_SPIDER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.spider.hurt");

    public static final Supplier<SoundType> ENTITY_SPIDER_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.spider.step");

    public static final Supplier<SoundType> ENTITY_SPLASH_POTION_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.splash_potion.break");

    public static final Supplier<SoundType> ENTITY_SPLASH_POTION_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.splash_potion.throw");

    public static final Supplier<SoundType> ENTITY_SQUID_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.squid.ambient");

    public static final Supplier<SoundType> ENTITY_SQUID_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.squid.death");

    public static final Supplier<SoundType> ENTITY_SQUID_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.squid.hurt");

    public static final Supplier<SoundType> ENTITY_SQUID_SQUIRT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.squid.squirt");

    public static final Supplier<SoundType> ENTITY_STRAY_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.stray.ambient");

    public static final Supplier<SoundType> ENTITY_STRAY_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.stray.death");

    public static final Supplier<SoundType> ENTITY_STRAY_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.stray.hurt");

    public static final Supplier<SoundType> ENTITY_STRAY_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.stray.step");

    public static final Supplier<SoundType> ENTITY_STRIDER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.strider.ambient");

    public static final Supplier<SoundType> ENTITY_STRIDER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.strider.death");

    public static final Supplier<SoundType> ENTITY_STRIDER_EAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.strider.eat");

    public static final Supplier<SoundType> ENTITY_STRIDER_HAPPY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.strider.happy");

    public static final Supplier<SoundType> ENTITY_STRIDER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.strider.hurt");

    public static final Supplier<SoundType> ENTITY_STRIDER_RETREAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.strider.retreat");

    public static final Supplier<SoundType> ENTITY_STRIDER_SADDLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.strider.saddle");

    public static final Supplier<SoundType> ENTITY_STRIDER_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.strider.step");

    public static final Supplier<SoundType> ENTITY_STRIDER_STEP_LAVA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.strider.step_lava");

    public static final Supplier<SoundType> ENTITY_TNT_PRIMED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.tnt.primed");

    public static final Supplier<SoundType> ENTITY_TROPICAL_FISH_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.tropical_fish.ambient");

    public static final Supplier<SoundType> ENTITY_TROPICAL_FISH_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.tropical_fish.death");

    public static final Supplier<SoundType> ENTITY_TROPICAL_FISH_FLOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.tropical_fish.flop");

    public static final Supplier<SoundType> ENTITY_TROPICAL_FISH_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.tropical_fish.hurt");

    public static final Supplier<SoundType> ENTITY_TURTLE_AMBIENT_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.turtle.ambient_land");

    public static final Supplier<SoundType> ENTITY_TURTLE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.turtle.death");

    public static final Supplier<SoundType> ENTITY_TURTLE_DEATH_BABY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.turtle.death_baby");

    public static final Supplier<SoundType> ENTITY_TURTLE_EGG_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.turtle.egg_break");

    public static final Supplier<SoundType> ENTITY_TURTLE_EGG_CRACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.turtle.egg_crack");

    public static final Supplier<SoundType> ENTITY_TURTLE_EGG_HATCH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.turtle.egg_hatch");

    public static final Supplier<SoundType> ENTITY_TURTLE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.turtle.hurt");

    public static final Supplier<SoundType> ENTITY_TURTLE_HURT_BABY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.turtle.hurt_baby");

    public static final Supplier<SoundType> ENTITY_TURTLE_LAY_EGG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.turtle.lay_egg");

    public static final Supplier<SoundType> ENTITY_TURTLE_SHAMBLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.turtle.shamble");

    public static final Supplier<SoundType> ENTITY_TURTLE_SHAMBLE_BABY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.turtle.shamble_baby");

    public static final Supplier<SoundType> ENTITY_TURTLE_SWIM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.turtle.swim");

    public static final Supplier<SoundType> ENTITY_VEX_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.vex.ambient");

    public static final Supplier<SoundType> ENTITY_VEX_CHARGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.vex.charge");

    public static final Supplier<SoundType> ENTITY_VEX_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.vex.death");

    public static final Supplier<SoundType> ENTITY_VEX_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.vex.hurt");

    public static final Supplier<SoundType> ENTITY_VILLAGER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.villager.ambient");

    public static final Supplier<SoundType> ENTITY_VILLAGER_CELEBRATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.villager.celebrate");

    public static final Supplier<SoundType> ENTITY_VILLAGER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.villager.death");

    public static final Supplier<SoundType> ENTITY_VILLAGER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.villager.hurt");

    public static final Supplier<SoundType> ENTITY_VILLAGER_NO = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.villager.no");

    public static final Supplier<SoundType> ENTITY_VILLAGER_TRADE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.villager.trade");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_ARMORER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.villager.work_armorer");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_BUTCHER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.villager.work_butcher");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_CARTOGRAPHER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.villager.work_cartographer");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_CLERIC = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.villager.work_cleric");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_FARMER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.villager.work_farmer");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_FISHERMAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.villager.work_fisherman");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_FLETCHER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.villager.work_fletcher");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_LEATHERWORKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.villager.work_leatherworker");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_LIBRARIAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.villager.work_librarian");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_MASON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.villager.work_mason");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_SHEPHERD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.villager.work_shepherd");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_TOOLSMITH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.villager.work_toolsmith");

    public static final Supplier<SoundType> ENTITY_VILLAGER_WORK_WEAPONSMITH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.villager.work_weaponsmith");

    public static final Supplier<SoundType> ENTITY_VILLAGER_YES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.villager.yes");

    public static final Supplier<SoundType> ENTITY_VINDICATOR_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.vindicator.ambient");

    public static final Supplier<SoundType> ENTITY_VINDICATOR_CELEBRATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.vindicator.celebrate");

    public static final Supplier<SoundType> ENTITY_VINDICATOR_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.vindicator.death");

    public static final Supplier<SoundType> ENTITY_VINDICATOR_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.vindicator.hurt");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wandering_trader.ambient");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wandering_trader.death");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_DISAPPEARED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wandering_trader.disappeared");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_DRINK_MILK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wandering_trader.drink_milk");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_DRINK_POTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wandering_trader.drink_potion");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wandering_trader.hurt");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_NO = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wandering_trader.no");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_REAPPEARED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wandering_trader.reappeared");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_TRADE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wandering_trader.trade");

    public static final Supplier<SoundType> ENTITY_WANDERING_TRADER_YES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wandering_trader.yes");

    public static final Supplier<SoundType> ENTITY_WITCH_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.witch.ambient");

    public static final Supplier<SoundType> ENTITY_WITCH_CELEBRATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.witch.celebrate");

    public static final Supplier<SoundType> ENTITY_WITCH_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.witch.death");

    public static final Supplier<SoundType> ENTITY_WITCH_DRINK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.witch.drink");

    public static final Supplier<SoundType> ENTITY_WITCH_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.witch.hurt");

    public static final Supplier<SoundType> ENTITY_WITCH_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.witch.throw");

    public static final Supplier<SoundType> ENTITY_WITHER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wither.ambient");

    public static final Supplier<SoundType> ENTITY_WITHER_BREAK_BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wither.break_block");

    public static final Supplier<SoundType> ENTITY_WITHER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wither.death");

    public static final Supplier<SoundType> ENTITY_WITHER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wither.hurt");

    public static final Supplier<SoundType> ENTITY_WITHER_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wither.shoot");

    public static final Supplier<SoundType> ENTITY_WITHER_SPAWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wither.spawn");

    public static final Supplier<SoundType> ENTITY_WITHER_SKELETON_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wither_skeleton.ambient");

    public static final Supplier<SoundType> ENTITY_WITHER_SKELETON_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wither_skeleton.death");

    public static final Supplier<SoundType> ENTITY_WITHER_SKELETON_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wither_skeleton.hurt");

    public static final Supplier<SoundType> ENTITY_WITHER_SKELETON_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wither_skeleton.step");

    public static final Supplier<SoundType> ENTITY_WOLF_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wolf.ambient");

    public static final Supplier<SoundType> ENTITY_WOLF_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wolf.death");

    public static final Supplier<SoundType> ENTITY_WOLF_GROWL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wolf.growl");

    public static final Supplier<SoundType> ENTITY_WOLF_HOWL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wolf.howl");

    public static final Supplier<SoundType> ENTITY_WOLF_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wolf.hurt");

    public static final Supplier<SoundType> ENTITY_WOLF_PANT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wolf.pant");

    public static final Supplier<SoundType> ENTITY_WOLF_SHAKE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wolf.shake");

    public static final Supplier<SoundType> ENTITY_WOLF_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wolf.step");

    public static final Supplier<SoundType> ENTITY_WOLF_WHINE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.wolf.whine");

    public static final Supplier<SoundType> ENTITY_ZOGLIN_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zoglin.ambient");

    public static final Supplier<SoundType> ENTITY_ZOGLIN_ANGRY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zoglin.angry");

    public static final Supplier<SoundType> ENTITY_ZOGLIN_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zoglin.attack");

    public static final Supplier<SoundType> ENTITY_ZOGLIN_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zoglin.death");

    public static final Supplier<SoundType> ENTITY_ZOGLIN_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zoglin.hurt");

    public static final Supplier<SoundType> ENTITY_ZOGLIN_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zoglin.step");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zombie.ambient");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_ATTACK_IRON_DOOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zombie.attack_iron_door");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_ATTACK_WOODEN_DOOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zombie.attack_wooden_door");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_BREAK_WOODEN_DOOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zombie.break_wooden_door");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_CONVERTED_TO_DROWNED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zombie.converted_to_drowned");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zombie.death");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_DESTROY_EGG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zombie.destroy_egg");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zombie.hurt");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_INFECT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zombie.infect");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zombie.step");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_HORSE_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zombie_horse.ambient");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_HORSE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zombie_horse.death");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_HORSE_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zombie_horse.hurt");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_VILLAGER_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zombie_villager.ambient");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_VILLAGER_CONVERTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zombie_villager.converted");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_VILLAGER_CURE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zombie_villager.cure");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_VILLAGER_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zombie_villager.death");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_VILLAGER_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zombie_villager.hurt");

    public static final Supplier<SoundType> ENTITY_ZOMBIE_VILLAGER_STEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zombie_villager.step");

    public static final Supplier<SoundType> ENTITY_ZOMBIFIED_PIGLIN_AMBIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zombified_piglin.ambient");

    public static final Supplier<SoundType> ENTITY_ZOMBIFIED_PIGLIN_ANGRY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zombified_piglin.angry");

    public static final Supplier<SoundType> ENTITY_ZOMBIFIED_PIGLIN_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zombified_piglin.death");

    public static final Supplier<SoundType> ENTITY_ZOMBIFIED_PIGLIN_HURT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "entity.zombified_piglin.hurt");

    public static final Supplier<SoundType> EVENT_RAID_HORN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "event.raid.horn");

    public static final Supplier<SoundType> ITEM_ARMOR_EQUIP_CHAIN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.armor.equip_chain");

    public static final Supplier<SoundType> ITEM_ARMOR_EQUIP_DIAMOND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.armor.equip_diamond");

    public static final Supplier<SoundType> ITEM_ARMOR_EQUIP_ELYTRA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.armor.equip_elytra");

    public static final Supplier<SoundType> ITEM_ARMOR_EQUIP_GENERIC = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.armor.equip_generic");

    public static final Supplier<SoundType> ITEM_ARMOR_EQUIP_GOLD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.armor.equip_gold");

    public static final Supplier<SoundType> ITEM_ARMOR_EQUIP_IRON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.armor.equip_iron");

    public static final Supplier<SoundType> ITEM_ARMOR_EQUIP_LEATHER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.armor.equip_leather");

    public static final Supplier<SoundType> ITEM_ARMOR_EQUIP_NETHERITE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.armor.equip_netherite");

    public static final Supplier<SoundType> ITEM_ARMOR_EQUIP_TURTLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.armor.equip_turtle");

    public static final Supplier<SoundType> ITEM_AXE_STRIP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.axe.strip");

    public static final Supplier<SoundType> ITEM_BOOK_PAGE_TURN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.book.page_turn");

    public static final Supplier<SoundType> ITEM_BOOK_PUT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.book.put");

    public static final Supplier<SoundType> ITEM_BOTTLE_EMPTY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.bottle.empty");

    public static final Supplier<SoundType> ITEM_BOTTLE_FILL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.bottle.fill");

    public static final Supplier<SoundType> ITEM_BOTTLE_FILL_DRAGONBREATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.bottle.fill_dragonbreath");

    public static final Supplier<SoundType> ITEM_BUCKET_EMPTY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.bucket.empty");

    public static final Supplier<SoundType> ITEM_BUCKET_EMPTY_FISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.bucket.empty_fish");

    public static final Supplier<SoundType> ITEM_BUCKET_EMPTY_LAVA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.bucket.empty_lava");

    public static final Supplier<SoundType> ITEM_BUCKET_FILL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.bucket.fill");

    public static final Supplier<SoundType> ITEM_BUCKET_FILL_FISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.bucket.fill_fish");

    public static final Supplier<SoundType> ITEM_BUCKET_FILL_LAVA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.bucket.fill_lava");

    public static final Supplier<SoundType> ITEM_CHORUS_FRUIT_TELEPORT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.chorus_fruit.teleport");

    public static final Supplier<SoundType> ITEM_CROP_PLANT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.crop.plant");

    public static final Supplier<SoundType> ITEM_CROSSBOW_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.crossbow.hit");

    public static final Supplier<SoundType> ITEM_CROSSBOW_LOADING_END = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.crossbow.loading_end");

    public static final Supplier<SoundType> ITEM_CROSSBOW_LOADING_MIDDLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.crossbow.loading_middle");

    public static final Supplier<SoundType> ITEM_CROSSBOW_LOADING_START = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.crossbow.loading_start");

    public static final Supplier<SoundType> ITEM_CROSSBOW_QUICK_CHARGE_1 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.crossbow.quick_charge_1");

    public static final Supplier<SoundType> ITEM_CROSSBOW_QUICK_CHARGE_2 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.crossbow.quick_charge_2");

    public static final Supplier<SoundType> ITEM_CROSSBOW_QUICK_CHARGE_3 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.crossbow.quick_charge_3");

    public static final Supplier<SoundType> ITEM_CROSSBOW_SHOOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.crossbow.shoot");

    public static final Supplier<SoundType> ITEM_ELYTRA_FLYING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.elytra.flying");

    public static final Supplier<SoundType> ITEM_FIRECHARGE_USE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.firecharge.use");

    public static final Supplier<SoundType> ITEM_FLINTANDSTEEL_USE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.flintandsteel.use");

    public static final Supplier<SoundType> ITEM_HOE_TILL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.hoe.till");

    public static final Supplier<SoundType> ITEM_HONEY_BOTTLE_DRINK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.honey_bottle.drink");

    public static final Supplier<SoundType> ITEM_LODESTONE_COMPASS_LOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.lodestone_compass.lock");

    public static final Supplier<SoundType> ITEM_NETHER_WART_PLANT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.nether_wart.plant");

    public static final Supplier<SoundType> ITEM_SHIELD_BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.shield.block");

    public static final Supplier<SoundType> ITEM_SHIELD_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.shield.break");

    public static final Supplier<SoundType> ITEM_SHOVEL_FLATTEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.shovel.flatten");

    public static final Supplier<SoundType> ITEM_SWEET_BERRIES_PICK_FROM_BUSH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.sweet_berries.pick_from_bush");

    public static final Supplier<SoundType> ITEM_TOTEM_USE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.totem.use");

    public static final Supplier<SoundType> ITEM_TRIDENT_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.trident.hit");

    public static final Supplier<SoundType> ITEM_TRIDENT_HIT_GROUND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.trident.hit_ground");

    public static final Supplier<SoundType> ITEM_TRIDENT_RETURN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.trident.return");

    public static final Supplier<SoundType> ITEM_TRIDENT_RIPTIDE_1 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.trident.riptide_1");

    public static final Supplier<SoundType> ITEM_TRIDENT_RIPTIDE_2 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.trident.riptide_2");

    public static final Supplier<SoundType> ITEM_TRIDENT_RIPTIDE_3 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.trident.riptide_3");

    public static final Supplier<SoundType> ITEM_TRIDENT_THROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.trident.throw");

    public static final Supplier<SoundType> ITEM_TRIDENT_THUNDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "item.trident.thunder");

    public static final Supplier<SoundType> MUSIC_CREATIVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music.creative");

    public static final Supplier<SoundType> MUSIC_CREDITS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music.credits");

    public static final Supplier<SoundType> MUSIC_DRAGON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music.dragon");

    public static final Supplier<SoundType> MUSIC_END = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music.end");

    public static final Supplier<SoundType> MUSIC_GAME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music.game");

    public static final Supplier<SoundType> MUSIC_MENU = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music.menu");

    public static final Supplier<SoundType> MUSIC_NETHER_BASALT_DELTAS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music.nether.basalt_deltas");

    public static final Supplier<SoundType> MUSIC_NETHER_CRIMSON_FOREST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music.nether.crimson_forest");

    public static final Supplier<SoundType> MUSIC_NETHER_NETHER_WASTES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music.nether.nether_wastes");

    public static final Supplier<SoundType> MUSIC_NETHER_SOUL_SAND_VALLEY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music.nether.soul_sand_valley");

    public static final Supplier<SoundType> MUSIC_NETHER_WARPED_FOREST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music.nether.warped_forest");

    public static final Supplier<SoundType> MUSIC_UNDER_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music.under_water");

    public static final Supplier<SoundType> MUSIC_DISC_11 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_disc.11");

    public static final Supplier<SoundType> MUSIC_DISC_13 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_disc.13");

    public static final Supplier<SoundType> MUSIC_DISC_BLOCKS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_disc.blocks");

    public static final Supplier<SoundType> MUSIC_DISC_CAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_disc.cat");

    public static final Supplier<SoundType> MUSIC_DISC_CHIRP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_disc.chirp");

    public static final Supplier<SoundType> MUSIC_DISC_FAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_disc.far");

    public static final Supplier<SoundType> MUSIC_DISC_MALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_disc.mall");

    public static final Supplier<SoundType> MUSIC_DISC_MELLOHI = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_disc.mellohi");

    public static final Supplier<SoundType> MUSIC_DISC_PIGSTEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_disc.pigstep");

    public static final Supplier<SoundType> MUSIC_DISC_STAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_disc.stal");

    public static final Supplier<SoundType> MUSIC_DISC_STRAD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_disc.strad");

    public static final Supplier<SoundType> MUSIC_DISC_WAIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_disc.wait");

    public static final Supplier<SoundType> MUSIC_DISC_WARD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "music_disc.ward");

    public static final Supplier<SoundType> PARTICLE_SOUL_ESCAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "particle.soul_escape");

    public static final Supplier<SoundType> UI_BUTTON_CLICK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ui.button.click");

    public static final Supplier<SoundType> UI_CARTOGRAPHY_TABLE_TAKE_RESULT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ui.cartography_table.take_result");

    public static final Supplier<SoundType> UI_LOOM_SELECT_PATTERN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ui.loom.select_pattern");

    public static final Supplier<SoundType> UI_LOOM_TAKE_RESULT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ui.loom.take_result");

    public static final Supplier<SoundType> UI_STONECUTTER_SELECT_RECIPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ui.stonecutter.select_recipe");

    public static final Supplier<SoundType> UI_STONECUTTER_TAKE_RESULT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ui.stonecutter.take_result");

    public static final Supplier<SoundType> UI_TOAST_CHALLENGE_COMPLETE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ui.toast.challenge_complete");

    public static final Supplier<SoundType> UI_TOAST_IN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ui.toast.in");

    public static final Supplier<SoundType> UI_TOAST_OUT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "ui.toast.out");

    public static final Supplier<SoundType> WEATHER_RAIN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "weather.rain");

    public static final Supplier<SoundType> WEATHER_RAIN_ABOVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SoundType.class, "weather.rain.above");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private SoundTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
