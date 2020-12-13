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

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registries;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

/**
 * An enumeration of vanilla {@link SoundType}s.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class SoundTypes {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<SoundType> AMBIENT_BASALT_DELTAS_ADDITIONS = SoundTypes.key(ResourceKey.sponge("ambient.basalt_deltas.additions"));

    public static final DefaultedRegistryReference<SoundType> AMBIENT_BASALT_DELTAS_LOOP = SoundTypes.key(ResourceKey.sponge("ambient.basalt_deltas.loop"));

    public static final DefaultedRegistryReference<SoundType> AMBIENT_BASALT_DELTAS_MOOD = SoundTypes.key(ResourceKey.sponge("ambient.basalt_deltas.mood"));

    public static final DefaultedRegistryReference<SoundType> AMBIENT_CAVE = SoundTypes.key(ResourceKey.sponge("ambient.cave"));

    public static final DefaultedRegistryReference<SoundType> AMBIENT_CRIMSON_FOREST_ADDITIONS = SoundTypes.key(ResourceKey.sponge("ambient.crimson_forest.additions"));

    public static final DefaultedRegistryReference<SoundType> AMBIENT_CRIMSON_FOREST_LOOP = SoundTypes.key(ResourceKey.sponge("ambient.crimson_forest.loop"));

    public static final DefaultedRegistryReference<SoundType> AMBIENT_CRIMSON_FOREST_MOOD = SoundTypes.key(ResourceKey.sponge("ambient.crimson_forest.mood"));

    public static final DefaultedRegistryReference<SoundType> AMBIENT_NETHER_WASTES_ADDITIONS = SoundTypes.key(ResourceKey.sponge("ambient.nether_wastes.additions"));

    public static final DefaultedRegistryReference<SoundType> AMBIENT_NETHER_WASTES_LOOP = SoundTypes.key(ResourceKey.sponge("ambient.nether_wastes.loop"));

    public static final DefaultedRegistryReference<SoundType> AMBIENT_NETHER_WASTES_MOOD = SoundTypes.key(ResourceKey.sponge("ambient.nether_wastes.mood"));

    public static final DefaultedRegistryReference<SoundType> AMBIENT_SOUL_SAND_VALLEY_ADDITIONS = SoundTypes.key(ResourceKey.sponge("ambient.soul_sand_valley.additions"));

    public static final DefaultedRegistryReference<SoundType> AMBIENT_SOUL_SAND_VALLEY_LOOP = SoundTypes.key(ResourceKey.sponge("ambient.soul_sand_valley.loop"));

    public static final DefaultedRegistryReference<SoundType> AMBIENT_SOUL_SAND_VALLEY_MOOD = SoundTypes.key(ResourceKey.sponge("ambient.soul_sand_valley.mood"));

    public static final DefaultedRegistryReference<SoundType> AMBIENT_UNDERWATER_ENTER = SoundTypes.key(ResourceKey.sponge("ambient.underwater.enter"));

    public static final DefaultedRegistryReference<SoundType> AMBIENT_UNDERWATER_EXIT = SoundTypes.key(ResourceKey.sponge("ambient.underwater.exit"));

    public static final DefaultedRegistryReference<SoundType> AMBIENT_UNDERWATER_LOOP = SoundTypes.key(ResourceKey.sponge("ambient.underwater.loop"));

    public static final DefaultedRegistryReference<SoundType> AMBIENT_UNDERWATER_LOOP_ADDITIONS = SoundTypes.key(ResourceKey.sponge("ambient.underwater.loop.additions"));

    public static final DefaultedRegistryReference<SoundType> AMBIENT_UNDERWATER_LOOP_ADDITIONS_RARE = SoundTypes.key(ResourceKey.sponge("ambient.underwater.loop.additions.rare"));

    public static final DefaultedRegistryReference<SoundType> AMBIENT_UNDERWATER_LOOP_ADDITIONS_ULTRA_RARE = SoundTypes.key(ResourceKey.sponge("ambient.underwater.loop.additions.ultra_rare"));

    public static final DefaultedRegistryReference<SoundType> AMBIENT_WARPED_FOREST_ADDITIONS = SoundTypes.key(ResourceKey.sponge("ambient.warped_forest.additions"));

    public static final DefaultedRegistryReference<SoundType> AMBIENT_WARPED_FOREST_LOOP = SoundTypes.key(ResourceKey.sponge("ambient.warped_forest.loop"));

    public static final DefaultedRegistryReference<SoundType> AMBIENT_WARPED_FOREST_MOOD = SoundTypes.key(ResourceKey.sponge("ambient.warped_forest.mood"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_ANCIENT_DEBRIS_BREAK = SoundTypes.key(ResourceKey.sponge("block.ancient_debris.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_ANCIENT_DEBRIS_FALL = SoundTypes.key(ResourceKey.sponge("block.ancient_debris.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_ANCIENT_DEBRIS_HIT = SoundTypes.key(ResourceKey.sponge("block.ancient_debris.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_ANCIENT_DEBRIS_PLACE = SoundTypes.key(ResourceKey.sponge("block.ancient_debris.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_ANCIENT_DEBRIS_STEP = SoundTypes.key(ResourceKey.sponge("block.ancient_debris.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_ANVIL_BREAK = SoundTypes.key(ResourceKey.sponge("block.anvil.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_ANVIL_DESTROY = SoundTypes.key(ResourceKey.sponge("block.anvil.destroy"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_ANVIL_FALL = SoundTypes.key(ResourceKey.sponge("block.anvil.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_ANVIL_HIT = SoundTypes.key(ResourceKey.sponge("block.anvil.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_ANVIL_LAND = SoundTypes.key(ResourceKey.sponge("block.anvil.land"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_ANVIL_PLACE = SoundTypes.key(ResourceKey.sponge("block.anvil.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_ANVIL_STEP = SoundTypes.key(ResourceKey.sponge("block.anvil.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_ANVIL_USE = SoundTypes.key(ResourceKey.sponge("block.anvil.use"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BAMBOO_BREAK = SoundTypes.key(ResourceKey.sponge("block.bamboo.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BAMBOO_FALL = SoundTypes.key(ResourceKey.sponge("block.bamboo.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BAMBOO_HIT = SoundTypes.key(ResourceKey.sponge("block.bamboo.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BAMBOO_PLACE = SoundTypes.key(ResourceKey.sponge("block.bamboo.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BAMBOO_STEP = SoundTypes.key(ResourceKey.sponge("block.bamboo.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BAMBOO_SAPLING_BREAK = SoundTypes.key(ResourceKey.sponge("block.bamboo_sapling.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BAMBOO_SAPLING_HIT = SoundTypes.key(ResourceKey.sponge("block.bamboo_sapling.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BAMBOO_SAPLING_PLACE = SoundTypes.key(ResourceKey.sponge("block.bamboo_sapling.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BARREL_CLOSE = SoundTypes.key(ResourceKey.sponge("block.barrel.close"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BARREL_OPEN = SoundTypes.key(ResourceKey.sponge("block.barrel.open"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BASALT_BREAK = SoundTypes.key(ResourceKey.sponge("block.basalt.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BASALT_FALL = SoundTypes.key(ResourceKey.sponge("block.basalt.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BASALT_HIT = SoundTypes.key(ResourceKey.sponge("block.basalt.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BASALT_PLACE = SoundTypes.key(ResourceKey.sponge("block.basalt.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BASALT_STEP = SoundTypes.key(ResourceKey.sponge("block.basalt.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BEACON_ACTIVATE = SoundTypes.key(ResourceKey.sponge("block.beacon.activate"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BEACON_AMBIENT = SoundTypes.key(ResourceKey.sponge("block.beacon.ambient"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BEACON_DEACTIVATE = SoundTypes.key(ResourceKey.sponge("block.beacon.deactivate"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BEACON_POWER_SELECT = SoundTypes.key(ResourceKey.sponge("block.beacon.power_select"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BEEHIVE_DRIP = SoundTypes.key(ResourceKey.sponge("block.beehive.drip"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BEEHIVE_ENTER = SoundTypes.key(ResourceKey.sponge("block.beehive.enter"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BEEHIVE_EXIT = SoundTypes.key(ResourceKey.sponge("block.beehive.exit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BEEHIVE_SHEAR = SoundTypes.key(ResourceKey.sponge("block.beehive.shear"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BEEHIVE_WORK = SoundTypes.key(ResourceKey.sponge("block.beehive.work"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BELL_RESONATE = SoundTypes.key(ResourceKey.sponge("block.bell.resonate"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BELL_USE = SoundTypes.key(ResourceKey.sponge("block.bell.use"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BLASTFURNACE_FIRE_CRACKLE = SoundTypes.key(ResourceKey.sponge("block.blastfurnace.fire_crackle"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BONE_BLOCK_BREAK = SoundTypes.key(ResourceKey.sponge("block.bone_block.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BONE_BLOCK_FALL = SoundTypes.key(ResourceKey.sponge("block.bone_block.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BONE_BLOCK_HIT = SoundTypes.key(ResourceKey.sponge("block.bone_block.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BONE_BLOCK_PLACE = SoundTypes.key(ResourceKey.sponge("block.bone_block.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BONE_BLOCK_STEP = SoundTypes.key(ResourceKey.sponge("block.bone_block.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BREWING_STAND_BREW = SoundTypes.key(ResourceKey.sponge("block.brewing_stand.brew"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BUBBLE_COLUMN_BUBBLE_POP = SoundTypes.key(ResourceKey.sponge("block.bubble_column.bubble_pop"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BUBBLE_COLUMN_UPWARDS_AMBIENT = SoundTypes.key(ResourceKey.sponge("block.bubble_column.upwards_ambient"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BUBBLE_COLUMN_UPWARDS_INSIDE = SoundTypes.key(ResourceKey.sponge("block.bubble_column.upwards_inside"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BUBBLE_COLUMN_WHIRLPOOL_AMBIENT = SoundTypes.key(ResourceKey.sponge("block.bubble_column.whirlpool_ambient"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_BUBBLE_COLUMN_WHIRLPOOL_INSIDE = SoundTypes.key(ResourceKey.sponge("block.bubble_column.whirlpool_inside"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_CAMPFIRE_CRACKLE = SoundTypes.key(ResourceKey.sponge("block.campfire.crackle"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_CHAIN_BREAK = SoundTypes.key(ResourceKey.sponge("block.chain.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_CHAIN_FALL = SoundTypes.key(ResourceKey.sponge("block.chain.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_CHAIN_HIT = SoundTypes.key(ResourceKey.sponge("block.chain.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_CHAIN_PLACE = SoundTypes.key(ResourceKey.sponge("block.chain.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_CHAIN_STEP = SoundTypes.key(ResourceKey.sponge("block.chain.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_CHEST_CLOSE = SoundTypes.key(ResourceKey.sponge("block.chest.close"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_CHEST_LOCKED = SoundTypes.key(ResourceKey.sponge("block.chest.locked"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_CHEST_OPEN = SoundTypes.key(ResourceKey.sponge("block.chest.open"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_CHORUS_FLOWER_DEATH = SoundTypes.key(ResourceKey.sponge("block.chorus_flower.death"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_CHORUS_FLOWER_GROW = SoundTypes.key(ResourceKey.sponge("block.chorus_flower.grow"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_COMPARATOR_CLICK = SoundTypes.key(ResourceKey.sponge("block.comparator.click"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_COMPOSTER_EMPTY = SoundTypes.key(ResourceKey.sponge("block.composter.empty"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_COMPOSTER_FILL = SoundTypes.key(ResourceKey.sponge("block.composter.fill"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_COMPOSTER_FILL_SUCCESS = SoundTypes.key(ResourceKey.sponge("block.composter.fill_success"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_COMPOSTER_READY = SoundTypes.key(ResourceKey.sponge("block.composter.ready"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_CONDUIT_ACTIVATE = SoundTypes.key(ResourceKey.sponge("block.conduit.activate"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_CONDUIT_AMBIENT = SoundTypes.key(ResourceKey.sponge("block.conduit.ambient"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_CONDUIT_AMBIENT_SHORT = SoundTypes.key(ResourceKey.sponge("block.conduit.ambient.short"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_CONDUIT_ATTACK_TARGET = SoundTypes.key(ResourceKey.sponge("block.conduit.attack.target"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_CONDUIT_DEACTIVATE = SoundTypes.key(ResourceKey.sponge("block.conduit.deactivate"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_CORAL_BLOCK_BREAK = SoundTypes.key(ResourceKey.sponge("block.coral_block.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_CORAL_BLOCK_FALL = SoundTypes.key(ResourceKey.sponge("block.coral_block.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_CORAL_BLOCK_HIT = SoundTypes.key(ResourceKey.sponge("block.coral_block.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_CORAL_BLOCK_PLACE = SoundTypes.key(ResourceKey.sponge("block.coral_block.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_CORAL_BLOCK_STEP = SoundTypes.key(ResourceKey.sponge("block.coral_block.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_CROP_BREAK = SoundTypes.key(ResourceKey.sponge("block.crop.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_DISPENSER_DISPENSE = SoundTypes.key(ResourceKey.sponge("block.dispenser.dispense"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_DISPENSER_FAIL = SoundTypes.key(ResourceKey.sponge("block.dispenser.fail"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_DISPENSER_LAUNCH = SoundTypes.key(ResourceKey.sponge("block.dispenser.launch"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_ENCHANTMENT_TABLE_USE = SoundTypes.key(ResourceKey.sponge("block.enchantment_table.use"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_END_GATEWAY_SPAWN = SoundTypes.key(ResourceKey.sponge("block.end_gateway.spawn"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_END_PORTAL_SPAWN = SoundTypes.key(ResourceKey.sponge("block.end_portal.spawn"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_END_PORTAL_FRAME_FILL = SoundTypes.key(ResourceKey.sponge("block.end_portal_frame.fill"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_ENDER_CHEST_CLOSE = SoundTypes.key(ResourceKey.sponge("block.ender_chest.close"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_ENDER_CHEST_OPEN = SoundTypes.key(ResourceKey.sponge("block.ender_chest.open"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_FENCE_GATE_CLOSE = SoundTypes.key(ResourceKey.sponge("block.fence_gate.close"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_FENCE_GATE_OPEN = SoundTypes.key(ResourceKey.sponge("block.fence_gate.open"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_FIRE_AMBIENT = SoundTypes.key(ResourceKey.sponge("block.fire.ambient"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_FIRE_EXTINGUISH = SoundTypes.key(ResourceKey.sponge("block.fire.extinguish"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_FUNGUS_BREAK = SoundTypes.key(ResourceKey.sponge("block.fungus.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_FUNGUS_FALL = SoundTypes.key(ResourceKey.sponge("block.fungus.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_FUNGUS_HIT = SoundTypes.key(ResourceKey.sponge("block.fungus.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_FUNGUS_PLACE = SoundTypes.key(ResourceKey.sponge("block.fungus.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_FUNGUS_STEP = SoundTypes.key(ResourceKey.sponge("block.fungus.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_FURNACE_FIRE_CRACKLE = SoundTypes.key(ResourceKey.sponge("block.furnace.fire_crackle"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_GILDED_BLACKSTONE_BREAK = SoundTypes.key(ResourceKey.sponge("block.gilded_blackstone.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_GILDED_BLACKSTONE_FALL = SoundTypes.key(ResourceKey.sponge("block.gilded_blackstone.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_GILDED_BLACKSTONE_HIT = SoundTypes.key(ResourceKey.sponge("block.gilded_blackstone.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_GILDED_BLACKSTONE_PLACE = SoundTypes.key(ResourceKey.sponge("block.gilded_blackstone.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_GILDED_BLACKSTONE_STEP = SoundTypes.key(ResourceKey.sponge("block.gilded_blackstone.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_GLASS_BREAK = SoundTypes.key(ResourceKey.sponge("block.glass.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_GLASS_FALL = SoundTypes.key(ResourceKey.sponge("block.glass.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_GLASS_HIT = SoundTypes.key(ResourceKey.sponge("block.glass.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_GLASS_PLACE = SoundTypes.key(ResourceKey.sponge("block.glass.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_GLASS_STEP = SoundTypes.key(ResourceKey.sponge("block.glass.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_GRASS_BREAK = SoundTypes.key(ResourceKey.sponge("block.grass.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_GRASS_FALL = SoundTypes.key(ResourceKey.sponge("block.grass.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_GRASS_HIT = SoundTypes.key(ResourceKey.sponge("block.grass.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_GRASS_PLACE = SoundTypes.key(ResourceKey.sponge("block.grass.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_GRASS_STEP = SoundTypes.key(ResourceKey.sponge("block.grass.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_GRAVEL_BREAK = SoundTypes.key(ResourceKey.sponge("block.gravel.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_GRAVEL_FALL = SoundTypes.key(ResourceKey.sponge("block.gravel.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_GRAVEL_HIT = SoundTypes.key(ResourceKey.sponge("block.gravel.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_GRAVEL_PLACE = SoundTypes.key(ResourceKey.sponge("block.gravel.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_GRAVEL_STEP = SoundTypes.key(ResourceKey.sponge("block.gravel.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_GRINDSTONE_USE = SoundTypes.key(ResourceKey.sponge("block.grindstone.use"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_HONEY_BLOCK_BREAK = SoundTypes.key(ResourceKey.sponge("block.honey_block.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_HONEY_BLOCK_FALL = SoundTypes.key(ResourceKey.sponge("block.honey_block.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_HONEY_BLOCK_HIT = SoundTypes.key(ResourceKey.sponge("block.honey_block.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_HONEY_BLOCK_PLACE = SoundTypes.key(ResourceKey.sponge("block.honey_block.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_HONEY_BLOCK_SLIDE = SoundTypes.key(ResourceKey.sponge("block.honey_block.slide"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_HONEY_BLOCK_STEP = SoundTypes.key(ResourceKey.sponge("block.honey_block.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_IRON_DOOR_CLOSE = SoundTypes.key(ResourceKey.sponge("block.iron_door.close"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_IRON_DOOR_OPEN = SoundTypes.key(ResourceKey.sponge("block.iron_door.open"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_IRON_TRAPDOOR_CLOSE = SoundTypes.key(ResourceKey.sponge("block.iron_trapdoor.close"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_IRON_TRAPDOOR_OPEN = SoundTypes.key(ResourceKey.sponge("block.iron_trapdoor.open"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_LADDER_BREAK = SoundTypes.key(ResourceKey.sponge("block.ladder.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_LADDER_FALL = SoundTypes.key(ResourceKey.sponge("block.ladder.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_LADDER_HIT = SoundTypes.key(ResourceKey.sponge("block.ladder.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_LADDER_PLACE = SoundTypes.key(ResourceKey.sponge("block.ladder.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_LADDER_STEP = SoundTypes.key(ResourceKey.sponge("block.ladder.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_LANTERN_BREAK = SoundTypes.key(ResourceKey.sponge("block.lantern.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_LANTERN_FALL = SoundTypes.key(ResourceKey.sponge("block.lantern.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_LANTERN_HIT = SoundTypes.key(ResourceKey.sponge("block.lantern.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_LANTERN_PLACE = SoundTypes.key(ResourceKey.sponge("block.lantern.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_LANTERN_STEP = SoundTypes.key(ResourceKey.sponge("block.lantern.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_LAVA_AMBIENT = SoundTypes.key(ResourceKey.sponge("block.lava.ambient"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_LAVA_EXTINGUISH = SoundTypes.key(ResourceKey.sponge("block.lava.extinguish"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_LAVA_POP = SoundTypes.key(ResourceKey.sponge("block.lava.pop"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_LEVER_CLICK = SoundTypes.key(ResourceKey.sponge("block.lever.click"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_LILY_PAD_PLACE = SoundTypes.key(ResourceKey.sponge("block.lily_pad.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_LODESTONE_BREAK = SoundTypes.key(ResourceKey.sponge("block.lodestone.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_LODESTONE_FALL = SoundTypes.key(ResourceKey.sponge("block.lodestone.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_LODESTONE_HIT = SoundTypes.key(ResourceKey.sponge("block.lodestone.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_LODESTONE_PLACE = SoundTypes.key(ResourceKey.sponge("block.lodestone.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_LODESTONE_STEP = SoundTypes.key(ResourceKey.sponge("block.lodestone.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_METAL_BREAK = SoundTypes.key(ResourceKey.sponge("block.metal.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_METAL_FALL = SoundTypes.key(ResourceKey.sponge("block.metal.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_METAL_HIT = SoundTypes.key(ResourceKey.sponge("block.metal.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_METAL_PLACE = SoundTypes.key(ResourceKey.sponge("block.metal.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_METAL_STEP = SoundTypes.key(ResourceKey.sponge("block.metal.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_METAL_PRESSURE_PLATE_CLICK_OFF = SoundTypes.key(ResourceKey.sponge("block.metal_pressure_plate.click_off"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_METAL_PRESSURE_PLATE_CLICK_ON = SoundTypes.key(ResourceKey.sponge("block.metal_pressure_plate.click_on"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHER_BRICKS_BREAK = SoundTypes.key(ResourceKey.sponge("block.nether_bricks.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHER_BRICKS_FALL = SoundTypes.key(ResourceKey.sponge("block.nether_bricks.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHER_BRICKS_HIT = SoundTypes.key(ResourceKey.sponge("block.nether_bricks.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHER_BRICKS_PLACE = SoundTypes.key(ResourceKey.sponge("block.nether_bricks.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHER_BRICKS_STEP = SoundTypes.key(ResourceKey.sponge("block.nether_bricks.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHER_GOLD_ORE_BREAK = SoundTypes.key(ResourceKey.sponge("block.nether_gold_ore.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHER_GOLD_ORE_FALL = SoundTypes.key(ResourceKey.sponge("block.nether_gold_ore.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHER_GOLD_ORE_HIT = SoundTypes.key(ResourceKey.sponge("block.nether_gold_ore.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHER_GOLD_ORE_PLACE = SoundTypes.key(ResourceKey.sponge("block.nether_gold_ore.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHER_GOLD_ORE_STEP = SoundTypes.key(ResourceKey.sponge("block.nether_gold_ore.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHER_ORE_BREAK = SoundTypes.key(ResourceKey.sponge("block.nether_ore.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHER_ORE_FALL = SoundTypes.key(ResourceKey.sponge("block.nether_ore.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHER_ORE_HIT = SoundTypes.key(ResourceKey.sponge("block.nether_ore.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHER_ORE_PLACE = SoundTypes.key(ResourceKey.sponge("block.nether_ore.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHER_ORE_STEP = SoundTypes.key(ResourceKey.sponge("block.nether_ore.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHER_SPROUTS_BREAK = SoundTypes.key(ResourceKey.sponge("block.nether_sprouts.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHER_SPROUTS_FALL = SoundTypes.key(ResourceKey.sponge("block.nether_sprouts.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHER_SPROUTS_HIT = SoundTypes.key(ResourceKey.sponge("block.nether_sprouts.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHER_SPROUTS_PLACE = SoundTypes.key(ResourceKey.sponge("block.nether_sprouts.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHER_SPROUTS_STEP = SoundTypes.key(ResourceKey.sponge("block.nether_sprouts.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHER_WART_BREAK = SoundTypes.key(ResourceKey.sponge("block.nether_wart.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHERITE_BLOCK_BREAK = SoundTypes.key(ResourceKey.sponge("block.netherite_block.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHERITE_BLOCK_FALL = SoundTypes.key(ResourceKey.sponge("block.netherite_block.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHERITE_BLOCK_HIT = SoundTypes.key(ResourceKey.sponge("block.netherite_block.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHERITE_BLOCK_PLACE = SoundTypes.key(ResourceKey.sponge("block.netherite_block.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHERITE_BLOCK_STEP = SoundTypes.key(ResourceKey.sponge("block.netherite_block.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHERRACK_BREAK = SoundTypes.key(ResourceKey.sponge("block.netherrack.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHERRACK_FALL = SoundTypes.key(ResourceKey.sponge("block.netherrack.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHERRACK_HIT = SoundTypes.key(ResourceKey.sponge("block.netherrack.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHERRACK_PLACE = SoundTypes.key(ResourceKey.sponge("block.netherrack.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NETHERRACK_STEP = SoundTypes.key(ResourceKey.sponge("block.netherrack.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NOTE_BLOCK_BANJO = SoundTypes.key(ResourceKey.sponge("block.note_block.banjo"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NOTE_BLOCK_BASEDRUM = SoundTypes.key(ResourceKey.sponge("block.note_block.basedrum"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NOTE_BLOCK_BASS = SoundTypes.key(ResourceKey.sponge("block.note_block.bass"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NOTE_BLOCK_BELL = SoundTypes.key(ResourceKey.sponge("block.note_block.bell"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NOTE_BLOCK_BIT = SoundTypes.key(ResourceKey.sponge("block.note_block.bit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NOTE_BLOCK_CHIME = SoundTypes.key(ResourceKey.sponge("block.note_block.chime"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NOTE_BLOCK_COW_BELL = SoundTypes.key(ResourceKey.sponge("block.note_block.cow_bell"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NOTE_BLOCK_DIDGERIDOO = SoundTypes.key(ResourceKey.sponge("block.note_block.didgeridoo"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NOTE_BLOCK_FLUTE = SoundTypes.key(ResourceKey.sponge("block.note_block.flute"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NOTE_BLOCK_GUITAR = SoundTypes.key(ResourceKey.sponge("block.note_block.guitar"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NOTE_BLOCK_HARP = SoundTypes.key(ResourceKey.sponge("block.note_block.harp"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NOTE_BLOCK_HAT = SoundTypes.key(ResourceKey.sponge("block.note_block.hat"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NOTE_BLOCK_IRON_XYLOPHONE = SoundTypes.key(ResourceKey.sponge("block.note_block.iron_xylophone"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NOTE_BLOCK_PLING = SoundTypes.key(ResourceKey.sponge("block.note_block.pling"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NOTE_BLOCK_SNARE = SoundTypes.key(ResourceKey.sponge("block.note_block.snare"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NOTE_BLOCK_XYLOPHONE = SoundTypes.key(ResourceKey.sponge("block.note_block.xylophone"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NYLIUM_BREAK = SoundTypes.key(ResourceKey.sponge("block.nylium.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NYLIUM_FALL = SoundTypes.key(ResourceKey.sponge("block.nylium.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NYLIUM_HIT = SoundTypes.key(ResourceKey.sponge("block.nylium.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NYLIUM_PLACE = SoundTypes.key(ResourceKey.sponge("block.nylium.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_NYLIUM_STEP = SoundTypes.key(ResourceKey.sponge("block.nylium.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_PISTON_CONTRACT = SoundTypes.key(ResourceKey.sponge("block.piston.contract"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_PISTON_EXTEND = SoundTypes.key(ResourceKey.sponge("block.piston.extend"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_PORTAL_AMBIENT = SoundTypes.key(ResourceKey.sponge("block.portal.ambient"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_PORTAL_TRAVEL = SoundTypes.key(ResourceKey.sponge("block.portal.travel"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_PORTAL_TRIGGER = SoundTypes.key(ResourceKey.sponge("block.portal.trigger"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_PUMPKIN_CARVE = SoundTypes.key(ResourceKey.sponge("block.pumpkin.carve"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_REDSTONE_TORCH_BURNOUT = SoundTypes.key(ResourceKey.sponge("block.redstone_torch.burnout"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_RESPAWN_ANCHOR_AMBIENT = SoundTypes.key(ResourceKey.sponge("block.respawn_anchor.ambient"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_RESPAWN_ANCHOR_CHARGE = SoundTypes.key(ResourceKey.sponge("block.respawn_anchor.charge"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_RESPAWN_ANCHOR_DEPLETE = SoundTypes.key(ResourceKey.sponge("block.respawn_anchor.deplete"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_RESPAWN_ANCHOR_SET_SPAWN = SoundTypes.key(ResourceKey.sponge("block.respawn_anchor.set_spawn"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_ROOTS_BREAK = SoundTypes.key(ResourceKey.sponge("block.roots.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_ROOTS_FALL = SoundTypes.key(ResourceKey.sponge("block.roots.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_ROOTS_HIT = SoundTypes.key(ResourceKey.sponge("block.roots.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_ROOTS_PLACE = SoundTypes.key(ResourceKey.sponge("block.roots.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_ROOTS_STEP = SoundTypes.key(ResourceKey.sponge("block.roots.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SAND_BREAK = SoundTypes.key(ResourceKey.sponge("block.sand.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SAND_FALL = SoundTypes.key(ResourceKey.sponge("block.sand.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SAND_HIT = SoundTypes.key(ResourceKey.sponge("block.sand.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SAND_PLACE = SoundTypes.key(ResourceKey.sponge("block.sand.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SAND_STEP = SoundTypes.key(ResourceKey.sponge("block.sand.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SCAFFOLDING_BREAK = SoundTypes.key(ResourceKey.sponge("block.scaffolding.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SCAFFOLDING_FALL = SoundTypes.key(ResourceKey.sponge("block.scaffolding.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SCAFFOLDING_HIT = SoundTypes.key(ResourceKey.sponge("block.scaffolding.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SCAFFOLDING_PLACE = SoundTypes.key(ResourceKey.sponge("block.scaffolding.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SCAFFOLDING_STEP = SoundTypes.key(ResourceKey.sponge("block.scaffolding.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SHROOMLIGHT_BREAK = SoundTypes.key(ResourceKey.sponge("block.shroomlight.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SHROOMLIGHT_FALL = SoundTypes.key(ResourceKey.sponge("block.shroomlight.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SHROOMLIGHT_HIT = SoundTypes.key(ResourceKey.sponge("block.shroomlight.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SHROOMLIGHT_PLACE = SoundTypes.key(ResourceKey.sponge("block.shroomlight.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SHROOMLIGHT_STEP = SoundTypes.key(ResourceKey.sponge("block.shroomlight.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SHULKER_BOX_CLOSE = SoundTypes.key(ResourceKey.sponge("block.shulker_box.close"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SHULKER_BOX_OPEN = SoundTypes.key(ResourceKey.sponge("block.shulker_box.open"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SLIME_BLOCK_BREAK = SoundTypes.key(ResourceKey.sponge("block.slime_block.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SLIME_BLOCK_FALL = SoundTypes.key(ResourceKey.sponge("block.slime_block.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SLIME_BLOCK_HIT = SoundTypes.key(ResourceKey.sponge("block.slime_block.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SLIME_BLOCK_PLACE = SoundTypes.key(ResourceKey.sponge("block.slime_block.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SLIME_BLOCK_STEP = SoundTypes.key(ResourceKey.sponge("block.slime_block.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SMITHING_TABLE_USE = SoundTypes.key(ResourceKey.sponge("block.smithing_table.use"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SMOKER_SMOKE = SoundTypes.key(ResourceKey.sponge("block.smoker.smoke"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SNOW_BREAK = SoundTypes.key(ResourceKey.sponge("block.snow.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SNOW_FALL = SoundTypes.key(ResourceKey.sponge("block.snow.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SNOW_HIT = SoundTypes.key(ResourceKey.sponge("block.snow.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SNOW_PLACE = SoundTypes.key(ResourceKey.sponge("block.snow.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SNOW_STEP = SoundTypes.key(ResourceKey.sponge("block.snow.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SOUL_SAND_BREAK = SoundTypes.key(ResourceKey.sponge("block.soul_sand.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SOUL_SAND_FALL = SoundTypes.key(ResourceKey.sponge("block.soul_sand.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SOUL_SAND_HIT = SoundTypes.key(ResourceKey.sponge("block.soul_sand.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SOUL_SAND_PLACE = SoundTypes.key(ResourceKey.sponge("block.soul_sand.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SOUL_SAND_STEP = SoundTypes.key(ResourceKey.sponge("block.soul_sand.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SOUL_SOIL_BREAK = SoundTypes.key(ResourceKey.sponge("block.soul_soil.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SOUL_SOIL_FALL = SoundTypes.key(ResourceKey.sponge("block.soul_soil.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SOUL_SOIL_HIT = SoundTypes.key(ResourceKey.sponge("block.soul_soil.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SOUL_SOIL_PLACE = SoundTypes.key(ResourceKey.sponge("block.soul_soil.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SOUL_SOIL_STEP = SoundTypes.key(ResourceKey.sponge("block.soul_soil.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_STEM_BREAK = SoundTypes.key(ResourceKey.sponge("block.stem.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_STEM_FALL = SoundTypes.key(ResourceKey.sponge("block.stem.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_STEM_HIT = SoundTypes.key(ResourceKey.sponge("block.stem.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_STEM_PLACE = SoundTypes.key(ResourceKey.sponge("block.stem.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_STEM_STEP = SoundTypes.key(ResourceKey.sponge("block.stem.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_STONE_BREAK = SoundTypes.key(ResourceKey.sponge("block.stone.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_STONE_FALL = SoundTypes.key(ResourceKey.sponge("block.stone.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_STONE_HIT = SoundTypes.key(ResourceKey.sponge("block.stone.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_STONE_PLACE = SoundTypes.key(ResourceKey.sponge("block.stone.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_STONE_STEP = SoundTypes.key(ResourceKey.sponge("block.stone.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_STONE_BUTTON_CLICK_OFF = SoundTypes.key(ResourceKey.sponge("block.stone_button.click_off"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_STONE_BUTTON_CLICK_ON = SoundTypes.key(ResourceKey.sponge("block.stone_button.click_on"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_STONE_PRESSURE_PLATE_CLICK_OFF = SoundTypes.key(ResourceKey.sponge("block.stone_pressure_plate.click_off"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_STONE_PRESSURE_PLATE_CLICK_ON = SoundTypes.key(ResourceKey.sponge("block.stone_pressure_plate.click_on"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SWEET_BERRY_BUSH_BREAK = SoundTypes.key(ResourceKey.sponge("block.sweet_berry_bush.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_SWEET_BERRY_BUSH_PLACE = SoundTypes.key(ResourceKey.sponge("block.sweet_berry_bush.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_TRIPWIRE_ATTACH = SoundTypes.key(ResourceKey.sponge("block.tripwire.attach"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_TRIPWIRE_CLICK_OFF = SoundTypes.key(ResourceKey.sponge("block.tripwire.click_off"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_TRIPWIRE_CLICK_ON = SoundTypes.key(ResourceKey.sponge("block.tripwire.click_on"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_TRIPWIRE_DETACH = SoundTypes.key(ResourceKey.sponge("block.tripwire.detach"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_VINE_STEP = SoundTypes.key(ResourceKey.sponge("block.vine.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WART_BLOCK_BREAK = SoundTypes.key(ResourceKey.sponge("block.wart_block.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WART_BLOCK_FALL = SoundTypes.key(ResourceKey.sponge("block.wart_block.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WART_BLOCK_HIT = SoundTypes.key(ResourceKey.sponge("block.wart_block.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WART_BLOCK_PLACE = SoundTypes.key(ResourceKey.sponge("block.wart_block.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WART_BLOCK_STEP = SoundTypes.key(ResourceKey.sponge("block.wart_block.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WATER_AMBIENT = SoundTypes.key(ResourceKey.sponge("block.water.ambient"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WEEPING_VINES_BREAK = SoundTypes.key(ResourceKey.sponge("block.weeping_vines.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WEEPING_VINES_FALL = SoundTypes.key(ResourceKey.sponge("block.weeping_vines.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WEEPING_VINES_HIT = SoundTypes.key(ResourceKey.sponge("block.weeping_vines.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WEEPING_VINES_PLACE = SoundTypes.key(ResourceKey.sponge("block.weeping_vines.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WEEPING_VINES_STEP = SoundTypes.key(ResourceKey.sponge("block.weeping_vines.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WET_GRASS_BREAK = SoundTypes.key(ResourceKey.sponge("block.wet_grass.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WET_GRASS_FALL = SoundTypes.key(ResourceKey.sponge("block.wet_grass.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WET_GRASS_HIT = SoundTypes.key(ResourceKey.sponge("block.wet_grass.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WET_GRASS_PLACE = SoundTypes.key(ResourceKey.sponge("block.wet_grass.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WET_GRASS_STEP = SoundTypes.key(ResourceKey.sponge("block.wet_grass.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WOOD_BREAK = SoundTypes.key(ResourceKey.sponge("block.wood.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WOOD_FALL = SoundTypes.key(ResourceKey.sponge("block.wood.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WOOD_HIT = SoundTypes.key(ResourceKey.sponge("block.wood.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WOOD_PLACE = SoundTypes.key(ResourceKey.sponge("block.wood.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WOOD_STEP = SoundTypes.key(ResourceKey.sponge("block.wood.step"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WOODEN_BUTTON_CLICK_OFF = SoundTypes.key(ResourceKey.sponge("block.wooden_button.click_off"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WOODEN_BUTTON_CLICK_ON = SoundTypes.key(ResourceKey.sponge("block.wooden_button.click_on"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WOODEN_DOOR_CLOSE = SoundTypes.key(ResourceKey.sponge("block.wooden_door.close"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WOODEN_DOOR_OPEN = SoundTypes.key(ResourceKey.sponge("block.wooden_door.open"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WOODEN_PRESSURE_PLATE_CLICK_OFF = SoundTypes.key(ResourceKey.sponge("block.wooden_pressure_plate.click_off"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON = SoundTypes.key(ResourceKey.sponge("block.wooden_pressure_plate.click_on"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WOODEN_TRAPDOOR_CLOSE = SoundTypes.key(ResourceKey.sponge("block.wooden_trapdoor.close"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WOODEN_TRAPDOOR_OPEN = SoundTypes.key(ResourceKey.sponge("block.wooden_trapdoor.open"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WOOL_BREAK = SoundTypes.key(ResourceKey.sponge("block.wool.break"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WOOL_FALL = SoundTypes.key(ResourceKey.sponge("block.wool.fall"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WOOL_HIT = SoundTypes.key(ResourceKey.sponge("block.wool.hit"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WOOL_PLACE = SoundTypes.key(ResourceKey.sponge("block.wool.place"));

    public static final DefaultedRegistryReference<SoundType> BLOCK_WOOL_STEP = SoundTypes.key(ResourceKey.sponge("block.wool.step"));

    public static final DefaultedRegistryReference<SoundType> ENCHANT_THORNS_HIT = SoundTypes.key(ResourceKey.sponge("enchant.thorns.hit"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ARMOR_STAND_BREAK = SoundTypes.key(ResourceKey.sponge("entity.armor_stand.break"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ARMOR_STAND_FALL = SoundTypes.key(ResourceKey.sponge("entity.armor_stand.fall"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ARMOR_STAND_HIT = SoundTypes.key(ResourceKey.sponge("entity.armor_stand.hit"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ARMOR_STAND_PLACE = SoundTypes.key(ResourceKey.sponge("entity.armor_stand.place"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ARROW_HIT = SoundTypes.key(ResourceKey.sponge("entity.arrow.hit"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ARROW_HIT_PLAYER = SoundTypes.key(ResourceKey.sponge("entity.arrow.hit_player"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ARROW_SHOOT = SoundTypes.key(ResourceKey.sponge("entity.arrow.shoot"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_BAT_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.bat.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_BAT_DEATH = SoundTypes.key(ResourceKey.sponge("entity.bat.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_BAT_HURT = SoundTypes.key(ResourceKey.sponge("entity.bat.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_BAT_LOOP = SoundTypes.key(ResourceKey.sponge("entity.bat.loop"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_BAT_TAKEOFF = SoundTypes.key(ResourceKey.sponge("entity.bat.takeoff"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_BEE_DEATH = SoundTypes.key(ResourceKey.sponge("entity.bee.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_BEE_HURT = SoundTypes.key(ResourceKey.sponge("entity.bee.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_BEE_LOOP = SoundTypes.key(ResourceKey.sponge("entity.bee.loop"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_BEE_LOOP_AGGRESSIVE = SoundTypes.key(ResourceKey.sponge("entity.bee.loop_aggressive"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_BEE_POLLINATE = SoundTypes.key(ResourceKey.sponge("entity.bee.pollinate"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_BEE_STING = SoundTypes.key(ResourceKey.sponge("entity.bee.sting"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_BLAZE_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.blaze.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_BLAZE_BURN = SoundTypes.key(ResourceKey.sponge("entity.blaze.burn"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_BLAZE_DEATH = SoundTypes.key(ResourceKey.sponge("entity.blaze.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_BLAZE_HURT = SoundTypes.key(ResourceKey.sponge("entity.blaze.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_BLAZE_SHOOT = SoundTypes.key(ResourceKey.sponge("entity.blaze.shoot"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_BOAT_PADDLE_LAND = SoundTypes.key(ResourceKey.sponge("entity.boat.paddle_land"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_BOAT_PADDLE_WATER = SoundTypes.key(ResourceKey.sponge("entity.boat.paddle_water"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_CAT_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.cat.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_CAT_BEG_FOR_FOOD = SoundTypes.key(ResourceKey.sponge("entity.cat.beg_for_food"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_CAT_DEATH = SoundTypes.key(ResourceKey.sponge("entity.cat.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_CAT_EAT = SoundTypes.key(ResourceKey.sponge("entity.cat.eat"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_CAT_HISS = SoundTypes.key(ResourceKey.sponge("entity.cat.hiss"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_CAT_HURT = SoundTypes.key(ResourceKey.sponge("entity.cat.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_CAT_PURR = SoundTypes.key(ResourceKey.sponge("entity.cat.purr"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_CAT_PURREOW = SoundTypes.key(ResourceKey.sponge("entity.cat.purreow"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_CAT_STRAY_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.cat.stray_ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_CHICKEN_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.chicken.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_CHICKEN_DEATH = SoundTypes.key(ResourceKey.sponge("entity.chicken.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_CHICKEN_EGG = SoundTypes.key(ResourceKey.sponge("entity.chicken.egg"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_CHICKEN_HURT = SoundTypes.key(ResourceKey.sponge("entity.chicken.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_CHICKEN_STEP = SoundTypes.key(ResourceKey.sponge("entity.chicken.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_COD_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.cod.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_COD_DEATH = SoundTypes.key(ResourceKey.sponge("entity.cod.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_COD_FLOP = SoundTypes.key(ResourceKey.sponge("entity.cod.flop"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_COD_HURT = SoundTypes.key(ResourceKey.sponge("entity.cod.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_COW_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.cow.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_COW_DEATH = SoundTypes.key(ResourceKey.sponge("entity.cow.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_COW_HURT = SoundTypes.key(ResourceKey.sponge("entity.cow.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_COW_MILK = SoundTypes.key(ResourceKey.sponge("entity.cow.milk"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_COW_STEP = SoundTypes.key(ResourceKey.sponge("entity.cow.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_CREEPER_DEATH = SoundTypes.key(ResourceKey.sponge("entity.creeper.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_CREEPER_HURT = SoundTypes.key(ResourceKey.sponge("entity.creeper.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_CREEPER_PRIMED = SoundTypes.key(ResourceKey.sponge("entity.creeper.primed"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_DOLPHIN_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.dolphin.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_DOLPHIN_AMBIENT_WATER = SoundTypes.key(ResourceKey.sponge("entity.dolphin.ambient_water"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_DOLPHIN_ATTACK = SoundTypes.key(ResourceKey.sponge("entity.dolphin.attack"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_DOLPHIN_DEATH = SoundTypes.key(ResourceKey.sponge("entity.dolphin.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_DOLPHIN_EAT = SoundTypes.key(ResourceKey.sponge("entity.dolphin.eat"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_DOLPHIN_HURT = SoundTypes.key(ResourceKey.sponge("entity.dolphin.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_DOLPHIN_JUMP = SoundTypes.key(ResourceKey.sponge("entity.dolphin.jump"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_DOLPHIN_PLAY = SoundTypes.key(ResourceKey.sponge("entity.dolphin.play"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_DOLPHIN_SPLASH = SoundTypes.key(ResourceKey.sponge("entity.dolphin.splash"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_DOLPHIN_SWIM = SoundTypes.key(ResourceKey.sponge("entity.dolphin.swim"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_DONKEY_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.donkey.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_DONKEY_ANGRY = SoundTypes.key(ResourceKey.sponge("entity.donkey.angry"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_DONKEY_CHEST = SoundTypes.key(ResourceKey.sponge("entity.donkey.chest"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_DONKEY_DEATH = SoundTypes.key(ResourceKey.sponge("entity.donkey.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_DONKEY_EAT = SoundTypes.key(ResourceKey.sponge("entity.donkey.eat"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_DONKEY_HURT = SoundTypes.key(ResourceKey.sponge("entity.donkey.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_DRAGON_FIREBALL_EXPLODE = SoundTypes.key(ResourceKey.sponge("entity.dragon_fireball.explode"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_DROWNED_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.drowned.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_DROWNED_AMBIENT_WATER = SoundTypes.key(ResourceKey.sponge("entity.drowned.ambient_water"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_DROWNED_DEATH = SoundTypes.key(ResourceKey.sponge("entity.drowned.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_DROWNED_DEATH_WATER = SoundTypes.key(ResourceKey.sponge("entity.drowned.death_water"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_DROWNED_HURT = SoundTypes.key(ResourceKey.sponge("entity.drowned.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_DROWNED_HURT_WATER = SoundTypes.key(ResourceKey.sponge("entity.drowned.hurt_water"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_DROWNED_SHOOT = SoundTypes.key(ResourceKey.sponge("entity.drowned.shoot"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_DROWNED_STEP = SoundTypes.key(ResourceKey.sponge("entity.drowned.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_DROWNED_SWIM = SoundTypes.key(ResourceKey.sponge("entity.drowned.swim"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_EGG_THROW = SoundTypes.key(ResourceKey.sponge("entity.egg.throw"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ELDER_GUARDIAN_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.elder_guardian.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ELDER_GUARDIAN_AMBIENT_LAND = SoundTypes.key(ResourceKey.sponge("entity.elder_guardian.ambient_land"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ELDER_GUARDIAN_CURSE = SoundTypes.key(ResourceKey.sponge("entity.elder_guardian.curse"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ELDER_GUARDIAN_DEATH = SoundTypes.key(ResourceKey.sponge("entity.elder_guardian.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ELDER_GUARDIAN_DEATH_LAND = SoundTypes.key(ResourceKey.sponge("entity.elder_guardian.death_land"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ELDER_GUARDIAN_FLOP = SoundTypes.key(ResourceKey.sponge("entity.elder_guardian.flop"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ELDER_GUARDIAN_HURT = SoundTypes.key(ResourceKey.sponge("entity.elder_guardian.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ELDER_GUARDIAN_HURT_LAND = SoundTypes.key(ResourceKey.sponge("entity.elder_guardian.hurt_land"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ENDER_DRAGON_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.ender_dragon.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ENDER_DRAGON_DEATH = SoundTypes.key(ResourceKey.sponge("entity.ender_dragon.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ENDER_DRAGON_FLAP = SoundTypes.key(ResourceKey.sponge("entity.ender_dragon.flap"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ENDER_DRAGON_GROWL = SoundTypes.key(ResourceKey.sponge("entity.ender_dragon.growl"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ENDER_DRAGON_HURT = SoundTypes.key(ResourceKey.sponge("entity.ender_dragon.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ENDER_DRAGON_SHOOT = SoundTypes.key(ResourceKey.sponge("entity.ender_dragon.shoot"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ENDER_EYE_DEATH = SoundTypes.key(ResourceKey.sponge("entity.ender_eye.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ENDER_EYE_LAUNCH = SoundTypes.key(ResourceKey.sponge("entity.ender_eye.launch"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ENDER_PEARL_THROW = SoundTypes.key(ResourceKey.sponge("entity.ender_pearl.throw"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ENDERMAN_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.enderman.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ENDERMAN_DEATH = SoundTypes.key(ResourceKey.sponge("entity.enderman.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ENDERMAN_HURT = SoundTypes.key(ResourceKey.sponge("entity.enderman.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ENDERMAN_SCREAM = SoundTypes.key(ResourceKey.sponge("entity.enderman.scream"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ENDERMAN_STARE = SoundTypes.key(ResourceKey.sponge("entity.enderman.stare"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ENDERMAN_TELEPORT = SoundTypes.key(ResourceKey.sponge("entity.enderman.teleport"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ENDERMITE_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.endermite.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ENDERMITE_DEATH = SoundTypes.key(ResourceKey.sponge("entity.endermite.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ENDERMITE_HURT = SoundTypes.key(ResourceKey.sponge("entity.endermite.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ENDERMITE_STEP = SoundTypes.key(ResourceKey.sponge("entity.endermite.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_EVOKER_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.evoker.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_EVOKER_CAST_SPELL = SoundTypes.key(ResourceKey.sponge("entity.evoker.cast_spell"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_EVOKER_CELEBRATE = SoundTypes.key(ResourceKey.sponge("entity.evoker.celebrate"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_EVOKER_DEATH = SoundTypes.key(ResourceKey.sponge("entity.evoker.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_EVOKER_HURT = SoundTypes.key(ResourceKey.sponge("entity.evoker.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_EVOKER_PREPARE_ATTACK = SoundTypes.key(ResourceKey.sponge("entity.evoker.prepare_attack"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_EVOKER_PREPARE_SUMMON = SoundTypes.key(ResourceKey.sponge("entity.evoker.prepare_summon"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_EVOKER_PREPARE_WOLOLO = SoundTypes.key(ResourceKey.sponge("entity.evoker.prepare_wololo"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_EVOKER_FANGS_ATTACK = SoundTypes.key(ResourceKey.sponge("entity.evoker_fangs.attack"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_EXPERIENCE_BOTTLE_THROW = SoundTypes.key(ResourceKey.sponge("entity.experience_bottle.throw"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_EXPERIENCE_ORB_PICKUP = SoundTypes.key(ResourceKey.sponge("entity.experience_orb.pickup"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_FIREWORK_ROCKET_BLAST = SoundTypes.key(ResourceKey.sponge("entity.firework_rocket.blast"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_FIREWORK_ROCKET_BLAST_FAR = SoundTypes.key(ResourceKey.sponge("entity.firework_rocket.blast_far"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_FIREWORK_ROCKET_LARGE_BLAST = SoundTypes.key(ResourceKey.sponge("entity.firework_rocket.large_blast"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_FIREWORK_ROCKET_LARGE_BLAST_FAR = SoundTypes.key(ResourceKey.sponge("entity.firework_rocket.large_blast_far"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_FIREWORK_ROCKET_LAUNCH = SoundTypes.key(ResourceKey.sponge("entity.firework_rocket.launch"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_FIREWORK_ROCKET_SHOOT = SoundTypes.key(ResourceKey.sponge("entity.firework_rocket.shoot"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_FIREWORK_ROCKET_TWINKLE = SoundTypes.key(ResourceKey.sponge("entity.firework_rocket.twinkle"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_FIREWORK_ROCKET_TWINKLE_FAR = SoundTypes.key(ResourceKey.sponge("entity.firework_rocket.twinkle_far"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_FISH_SWIM = SoundTypes.key(ResourceKey.sponge("entity.fish.swim"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_FISHING_BOBBER_RETRIEVE = SoundTypes.key(ResourceKey.sponge("entity.fishing_bobber.retrieve"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_FISHING_BOBBER_SPLASH = SoundTypes.key(ResourceKey.sponge("entity.fishing_bobber.splash"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_FISHING_BOBBER_THROW = SoundTypes.key(ResourceKey.sponge("entity.fishing_bobber.throw"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_FOX_AGGRO = SoundTypes.key(ResourceKey.sponge("entity.fox.aggro"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_FOX_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.fox.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_FOX_BITE = SoundTypes.key(ResourceKey.sponge("entity.fox.bite"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_FOX_DEATH = SoundTypes.key(ResourceKey.sponge("entity.fox.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_FOX_EAT = SoundTypes.key(ResourceKey.sponge("entity.fox.eat"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_FOX_HURT = SoundTypes.key(ResourceKey.sponge("entity.fox.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_FOX_SCREECH = SoundTypes.key(ResourceKey.sponge("entity.fox.screech"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_FOX_SLEEP = SoundTypes.key(ResourceKey.sponge("entity.fox.sleep"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_FOX_SNIFF = SoundTypes.key(ResourceKey.sponge("entity.fox.sniff"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_FOX_SPIT = SoundTypes.key(ResourceKey.sponge("entity.fox.spit"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_FOX_TELEPORT = SoundTypes.key(ResourceKey.sponge("entity.fox.teleport"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_GENERIC_BIG_FALL = SoundTypes.key(ResourceKey.sponge("entity.generic.big_fall"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_GENERIC_BURN = SoundTypes.key(ResourceKey.sponge("entity.generic.burn"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_GENERIC_DEATH = SoundTypes.key(ResourceKey.sponge("entity.generic.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_GENERIC_DRINK = SoundTypes.key(ResourceKey.sponge("entity.generic.drink"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_GENERIC_EAT = SoundTypes.key(ResourceKey.sponge("entity.generic.eat"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_GENERIC_EXPLODE = SoundTypes.key(ResourceKey.sponge("entity.generic.explode"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_GENERIC_EXTINGUISH_FIRE = SoundTypes.key(ResourceKey.sponge("entity.generic.extinguish_fire"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_GENERIC_HURT = SoundTypes.key(ResourceKey.sponge("entity.generic.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_GENERIC_SMALL_FALL = SoundTypes.key(ResourceKey.sponge("entity.generic.small_fall"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_GENERIC_SPLASH = SoundTypes.key(ResourceKey.sponge("entity.generic.splash"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_GENERIC_SWIM = SoundTypes.key(ResourceKey.sponge("entity.generic.swim"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_GHAST_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.ghast.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_GHAST_DEATH = SoundTypes.key(ResourceKey.sponge("entity.ghast.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_GHAST_HURT = SoundTypes.key(ResourceKey.sponge("entity.ghast.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_GHAST_SCREAM = SoundTypes.key(ResourceKey.sponge("entity.ghast.scream"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_GHAST_SHOOT = SoundTypes.key(ResourceKey.sponge("entity.ghast.shoot"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_GHAST_WARN = SoundTypes.key(ResourceKey.sponge("entity.ghast.warn"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_GUARDIAN_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.guardian.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_GUARDIAN_AMBIENT_LAND = SoundTypes.key(ResourceKey.sponge("entity.guardian.ambient_land"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_GUARDIAN_ATTACK = SoundTypes.key(ResourceKey.sponge("entity.guardian.attack"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_GUARDIAN_DEATH = SoundTypes.key(ResourceKey.sponge("entity.guardian.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_GUARDIAN_DEATH_LAND = SoundTypes.key(ResourceKey.sponge("entity.guardian.death_land"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_GUARDIAN_FLOP = SoundTypes.key(ResourceKey.sponge("entity.guardian.flop"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_GUARDIAN_HURT = SoundTypes.key(ResourceKey.sponge("entity.guardian.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_GUARDIAN_HURT_LAND = SoundTypes.key(ResourceKey.sponge("entity.guardian.hurt_land"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HOGLIN_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.hoglin.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HOGLIN_ANGRY = SoundTypes.key(ResourceKey.sponge("entity.hoglin.angry"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HOGLIN_ATTACK = SoundTypes.key(ResourceKey.sponge("entity.hoglin.attack"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HOGLIN_CONVERTED_TO_ZOMBIFIED = SoundTypes.key(ResourceKey.sponge("entity.hoglin.converted_to_zombified"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HOGLIN_DEATH = SoundTypes.key(ResourceKey.sponge("entity.hoglin.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HOGLIN_HURT = SoundTypes.key(ResourceKey.sponge("entity.hoglin.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HOGLIN_RETREAT = SoundTypes.key(ResourceKey.sponge("entity.hoglin.retreat"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HOGLIN_STEP = SoundTypes.key(ResourceKey.sponge("entity.hoglin.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HORSE_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.horse.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HORSE_ANGRY = SoundTypes.key(ResourceKey.sponge("entity.horse.angry"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HORSE_ARMOR = SoundTypes.key(ResourceKey.sponge("entity.horse.armor"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HORSE_BREATHE = SoundTypes.key(ResourceKey.sponge("entity.horse.breathe"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HORSE_DEATH = SoundTypes.key(ResourceKey.sponge("entity.horse.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HORSE_EAT = SoundTypes.key(ResourceKey.sponge("entity.horse.eat"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HORSE_GALLOP = SoundTypes.key(ResourceKey.sponge("entity.horse.gallop"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HORSE_HURT = SoundTypes.key(ResourceKey.sponge("entity.horse.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HORSE_JUMP = SoundTypes.key(ResourceKey.sponge("entity.horse.jump"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HORSE_LAND = SoundTypes.key(ResourceKey.sponge("entity.horse.land"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HORSE_SADDLE = SoundTypes.key(ResourceKey.sponge("entity.horse.saddle"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HORSE_STEP = SoundTypes.key(ResourceKey.sponge("entity.horse.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HORSE_STEP_WOOD = SoundTypes.key(ResourceKey.sponge("entity.horse.step_wood"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HOSTILE_BIG_FALL = SoundTypes.key(ResourceKey.sponge("entity.hostile.big_fall"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HOSTILE_DEATH = SoundTypes.key(ResourceKey.sponge("entity.hostile.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HOSTILE_HURT = SoundTypes.key(ResourceKey.sponge("entity.hostile.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HOSTILE_SMALL_FALL = SoundTypes.key(ResourceKey.sponge("entity.hostile.small_fall"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HOSTILE_SPLASH = SoundTypes.key(ResourceKey.sponge("entity.hostile.splash"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HOSTILE_SWIM = SoundTypes.key(ResourceKey.sponge("entity.hostile.swim"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HUSK_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.husk.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HUSK_CONVERTED_TO_ZOMBIE = SoundTypes.key(ResourceKey.sponge("entity.husk.converted_to_zombie"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HUSK_DEATH = SoundTypes.key(ResourceKey.sponge("entity.husk.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HUSK_HURT = SoundTypes.key(ResourceKey.sponge("entity.husk.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_HUSK_STEP = SoundTypes.key(ResourceKey.sponge("entity.husk.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ILLUSIONER_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.illusioner.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ILLUSIONER_CAST_SPELL = SoundTypes.key(ResourceKey.sponge("entity.illusioner.cast_spell"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ILLUSIONER_DEATH = SoundTypes.key(ResourceKey.sponge("entity.illusioner.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ILLUSIONER_HURT = SoundTypes.key(ResourceKey.sponge("entity.illusioner.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ILLUSIONER_MIRROR_MOVE = SoundTypes.key(ResourceKey.sponge("entity.illusioner.mirror_move"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ILLUSIONER_PREPARE_BLINDNESS = SoundTypes.key(ResourceKey.sponge("entity.illusioner.prepare_blindness"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ILLUSIONER_PREPARE_MIRROR = SoundTypes.key(ResourceKey.sponge("entity.illusioner.prepare_mirror"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_IRON_GOLEM_ATTACK = SoundTypes.key(ResourceKey.sponge("entity.iron_golem.attack"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_IRON_GOLEM_DAMAGE = SoundTypes.key(ResourceKey.sponge("entity.iron_golem.damage"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_IRON_GOLEM_DEATH = SoundTypes.key(ResourceKey.sponge("entity.iron_golem.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_IRON_GOLEM_HURT = SoundTypes.key(ResourceKey.sponge("entity.iron_golem.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_IRON_GOLEM_REPAIR = SoundTypes.key(ResourceKey.sponge("entity.iron_golem.repair"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_IRON_GOLEM_STEP = SoundTypes.key(ResourceKey.sponge("entity.iron_golem.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ITEM_BREAK = SoundTypes.key(ResourceKey.sponge("entity.item.break"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ITEM_PICKUP = SoundTypes.key(ResourceKey.sponge("entity.item.pickup"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ITEM_FRAME_ADD_ITEM = SoundTypes.key(ResourceKey.sponge("entity.item_frame.add_item"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ITEM_FRAME_BREAK = SoundTypes.key(ResourceKey.sponge("entity.item_frame.break"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ITEM_FRAME_PLACE = SoundTypes.key(ResourceKey.sponge("entity.item_frame.place"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ITEM_FRAME_REMOVE_ITEM = SoundTypes.key(ResourceKey.sponge("entity.item_frame.remove_item"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ITEM_FRAME_ROTATE_ITEM = SoundTypes.key(ResourceKey.sponge("entity.item_frame.rotate_item"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_LEASH_KNOT_BREAK = SoundTypes.key(ResourceKey.sponge("entity.leash_knot.break"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_LEASH_KNOT_PLACE = SoundTypes.key(ResourceKey.sponge("entity.leash_knot.place"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_LIGHTNING_BOLT_IMPACT = SoundTypes.key(ResourceKey.sponge("entity.lightning_bolt.impact"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_LIGHTNING_BOLT_THUNDER = SoundTypes.key(ResourceKey.sponge("entity.lightning_bolt.thunder"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_LINGERING_POTION_THROW = SoundTypes.key(ResourceKey.sponge("entity.lingering_potion.throw"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_LLAMA_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.llama.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_LLAMA_ANGRY = SoundTypes.key(ResourceKey.sponge("entity.llama.angry"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_LLAMA_CHEST = SoundTypes.key(ResourceKey.sponge("entity.llama.chest"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_LLAMA_DEATH = SoundTypes.key(ResourceKey.sponge("entity.llama.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_LLAMA_EAT = SoundTypes.key(ResourceKey.sponge("entity.llama.eat"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_LLAMA_HURT = SoundTypes.key(ResourceKey.sponge("entity.llama.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_LLAMA_SPIT = SoundTypes.key(ResourceKey.sponge("entity.llama.spit"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_LLAMA_STEP = SoundTypes.key(ResourceKey.sponge("entity.llama.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_LLAMA_SWAG = SoundTypes.key(ResourceKey.sponge("entity.llama.swag"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_MAGMA_CUBE_DEATH = SoundTypes.key(ResourceKey.sponge("entity.magma_cube.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_MAGMA_CUBE_DEATH_SMALL = SoundTypes.key(ResourceKey.sponge("entity.magma_cube.death_small"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_MAGMA_CUBE_HURT = SoundTypes.key(ResourceKey.sponge("entity.magma_cube.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_MAGMA_CUBE_HURT_SMALL = SoundTypes.key(ResourceKey.sponge("entity.magma_cube.hurt_small"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_MAGMA_CUBE_JUMP = SoundTypes.key(ResourceKey.sponge("entity.magma_cube.jump"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_MAGMA_CUBE_SQUISH = SoundTypes.key(ResourceKey.sponge("entity.magma_cube.squish"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_MAGMA_CUBE_SQUISH_SMALL = SoundTypes.key(ResourceKey.sponge("entity.magma_cube.squish_small"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_MINECART_INSIDE = SoundTypes.key(ResourceKey.sponge("entity.minecart.inside"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_MINECART_RIDING = SoundTypes.key(ResourceKey.sponge("entity.minecart.riding"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_MOOSHROOM_CONVERT = SoundTypes.key(ResourceKey.sponge("entity.mooshroom.convert"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_MOOSHROOM_EAT = SoundTypes.key(ResourceKey.sponge("entity.mooshroom.eat"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_MOOSHROOM_MILK = SoundTypes.key(ResourceKey.sponge("entity.mooshroom.milk"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_MOOSHROOM_SHEAR = SoundTypes.key(ResourceKey.sponge("entity.mooshroom.shear"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_MOOSHROOM_SUSPICIOUS_MILK = SoundTypes.key(ResourceKey.sponge("entity.mooshroom.suspicious_milk"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_MULE_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.mule.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_MULE_ANGRY = SoundTypes.key(ResourceKey.sponge("entity.mule.angry"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_MULE_CHEST = SoundTypes.key(ResourceKey.sponge("entity.mule.chest"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_MULE_DEATH = SoundTypes.key(ResourceKey.sponge("entity.mule.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_MULE_EAT = SoundTypes.key(ResourceKey.sponge("entity.mule.eat"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_MULE_HURT = SoundTypes.key(ResourceKey.sponge("entity.mule.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_OCELOT_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.ocelot.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_OCELOT_DEATH = SoundTypes.key(ResourceKey.sponge("entity.ocelot.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_OCELOT_HURT = SoundTypes.key(ResourceKey.sponge("entity.ocelot.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PAINTING_BREAK = SoundTypes.key(ResourceKey.sponge("entity.painting.break"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PAINTING_PLACE = SoundTypes.key(ResourceKey.sponge("entity.painting.place"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PANDA_AGGRESSIVE_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.panda.aggressive_ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PANDA_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.panda.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PANDA_BITE = SoundTypes.key(ResourceKey.sponge("entity.panda.bite"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PANDA_CANT_BREED = SoundTypes.key(ResourceKey.sponge("entity.panda.cant_breed"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PANDA_DEATH = SoundTypes.key(ResourceKey.sponge("entity.panda.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PANDA_EAT = SoundTypes.key(ResourceKey.sponge("entity.panda.eat"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PANDA_HURT = SoundTypes.key(ResourceKey.sponge("entity.panda.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PANDA_PRE_SNEEZE = SoundTypes.key(ResourceKey.sponge("entity.panda.pre_sneeze"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PANDA_SNEEZE = SoundTypes.key(ResourceKey.sponge("entity.panda.sneeze"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PANDA_STEP = SoundTypes.key(ResourceKey.sponge("entity.panda.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PANDA_WORRIED_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.panda.worried_ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.parrot.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_DEATH = SoundTypes.key(ResourceKey.sponge("entity.parrot.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_EAT = SoundTypes.key(ResourceKey.sponge("entity.parrot.eat"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_FLY = SoundTypes.key(ResourceKey.sponge("entity.parrot.fly"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_HURT = SoundTypes.key(ResourceKey.sponge("entity.parrot.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_BLAZE = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.blaze"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_CREEPER = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.creeper"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_DROWNED = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.drowned"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_ELDER_GUARDIAN = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.elder_guardian"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_ENDER_DRAGON = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.ender_dragon"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_ENDERMITE = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.endermite"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_EVOKER = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.evoker"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_GHAST = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.ghast"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_GUARDIAN = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.guardian"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_HOGLIN = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.hoglin"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_HUSK = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.husk"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_ILLUSIONER = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.illusioner"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_MAGMA_CUBE = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.magma_cube"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_PHANTOM = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.phantom"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_PIGLIN = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.piglin"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_PIGLIN_BRUTE = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.piglin_brute"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_PILLAGER = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.pillager"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_RAVAGER = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.ravager"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_SHULKER = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.shulker"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_SILVERFISH = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.silverfish"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_SKELETON = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.skeleton"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_SLIME = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.slime"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_SPIDER = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.spider"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_STRAY = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.stray"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_VEX = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.vex"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_VINDICATOR = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.vindicator"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_WITCH = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.witch"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_WITHER = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.wither"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_WITHER_SKELETON = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.wither_skeleton"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_ZOGLIN = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.zoglin"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_ZOMBIE = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.zombie"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_IMITATE_ZOMBIE_VILLAGER = SoundTypes.key(ResourceKey.sponge("entity.parrot.imitate.zombie_villager"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PARROT_STEP = SoundTypes.key(ResourceKey.sponge("entity.parrot.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PHANTOM_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.phantom.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PHANTOM_BITE = SoundTypes.key(ResourceKey.sponge("entity.phantom.bite"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PHANTOM_DEATH = SoundTypes.key(ResourceKey.sponge("entity.phantom.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PHANTOM_FLAP = SoundTypes.key(ResourceKey.sponge("entity.phantom.flap"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PHANTOM_HURT = SoundTypes.key(ResourceKey.sponge("entity.phantom.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PHANTOM_SWOOP = SoundTypes.key(ResourceKey.sponge("entity.phantom.swoop"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PIG_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.pig.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PIG_DEATH = SoundTypes.key(ResourceKey.sponge("entity.pig.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PIG_HURT = SoundTypes.key(ResourceKey.sponge("entity.pig.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PIG_SADDLE = SoundTypes.key(ResourceKey.sponge("entity.pig.saddle"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PIG_STEP = SoundTypes.key(ResourceKey.sponge("entity.pig.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PIGLIN_ADMIRING_ITEM = SoundTypes.key(ResourceKey.sponge("entity.piglin.admiring_item"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PIGLIN_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.piglin.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PIGLIN_ANGRY = SoundTypes.key(ResourceKey.sponge("entity.piglin.angry"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PIGLIN_CELEBRATE = SoundTypes.key(ResourceKey.sponge("entity.piglin.celebrate"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PIGLIN_CONVERTED_TO_ZOMBIFIED = SoundTypes.key(ResourceKey.sponge("entity.piglin.converted_to_zombified"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PIGLIN_DEATH = SoundTypes.key(ResourceKey.sponge("entity.piglin.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PIGLIN_HURT = SoundTypes.key(ResourceKey.sponge("entity.piglin.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PIGLIN_JEALOUS = SoundTypes.key(ResourceKey.sponge("entity.piglin.jealous"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PIGLIN_RETREAT = SoundTypes.key(ResourceKey.sponge("entity.piglin.retreat"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PIGLIN_STEP = SoundTypes.key(ResourceKey.sponge("entity.piglin.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PIGLIN_BRUTE_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.piglin_brute.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PIGLIN_BRUTE_ANGRY = SoundTypes.key(ResourceKey.sponge("entity.piglin_brute.angry"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PIGLIN_BRUTE_CONVERTED_TO_ZOMBIFIED = SoundTypes.key(ResourceKey.sponge("entity.piglin_brute.converted_to_zombified"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PIGLIN_BRUTE_DEATH = SoundTypes.key(ResourceKey.sponge("entity.piglin_brute.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PIGLIN_BRUTE_HURT = SoundTypes.key(ResourceKey.sponge("entity.piglin_brute.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PIGLIN_BRUTE_STEP = SoundTypes.key(ResourceKey.sponge("entity.piglin_brute.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PILLAGER_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.pillager.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PILLAGER_CELEBRATE = SoundTypes.key(ResourceKey.sponge("entity.pillager.celebrate"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PILLAGER_DEATH = SoundTypes.key(ResourceKey.sponge("entity.pillager.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PILLAGER_HURT = SoundTypes.key(ResourceKey.sponge("entity.pillager.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PLAYER_ATTACK_CRIT = SoundTypes.key(ResourceKey.sponge("entity.player.attack.crit"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PLAYER_ATTACK_KNOCKBACK = SoundTypes.key(ResourceKey.sponge("entity.player.attack.knockback"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PLAYER_ATTACK_NODAMAGE = SoundTypes.key(ResourceKey.sponge("entity.player.attack.nodamage"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PLAYER_ATTACK_STRONG = SoundTypes.key(ResourceKey.sponge("entity.player.attack.strong"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PLAYER_ATTACK_SWEEP = SoundTypes.key(ResourceKey.sponge("entity.player.attack.sweep"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PLAYER_ATTACK_WEAK = SoundTypes.key(ResourceKey.sponge("entity.player.attack.weak"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PLAYER_BIG_FALL = SoundTypes.key(ResourceKey.sponge("entity.player.big_fall"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PLAYER_BREATH = SoundTypes.key(ResourceKey.sponge("entity.player.breath"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PLAYER_BURP = SoundTypes.key(ResourceKey.sponge("entity.player.burp"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PLAYER_DEATH = SoundTypes.key(ResourceKey.sponge("entity.player.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PLAYER_HURT = SoundTypes.key(ResourceKey.sponge("entity.player.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PLAYER_HURT_DROWN = SoundTypes.key(ResourceKey.sponge("entity.player.hurt_drown"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PLAYER_HURT_ON_FIRE = SoundTypes.key(ResourceKey.sponge("entity.player.hurt_on_fire"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PLAYER_HURT_SWEET_BERRY_BUSH = SoundTypes.key(ResourceKey.sponge("entity.player.hurt_sweet_berry_bush"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PLAYER_LEVELUP = SoundTypes.key(ResourceKey.sponge("entity.player.levelup"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PLAYER_SMALL_FALL = SoundTypes.key(ResourceKey.sponge("entity.player.small_fall"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PLAYER_SPLASH = SoundTypes.key(ResourceKey.sponge("entity.player.splash"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PLAYER_SPLASH_HIGH_SPEED = SoundTypes.key(ResourceKey.sponge("entity.player.splash.high_speed"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PLAYER_SWIM = SoundTypes.key(ResourceKey.sponge("entity.player.swim"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_POLAR_BEAR_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.polar_bear.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_POLAR_BEAR_AMBIENT_BABY = SoundTypes.key(ResourceKey.sponge("entity.polar_bear.ambient_baby"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_POLAR_BEAR_DEATH = SoundTypes.key(ResourceKey.sponge("entity.polar_bear.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_POLAR_BEAR_HURT = SoundTypes.key(ResourceKey.sponge("entity.polar_bear.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_POLAR_BEAR_STEP = SoundTypes.key(ResourceKey.sponge("entity.polar_bear.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_POLAR_BEAR_WARNING = SoundTypes.key(ResourceKey.sponge("entity.polar_bear.warning"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PUFFER_FISH_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.puffer_fish.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PUFFER_FISH_BLOW_OUT = SoundTypes.key(ResourceKey.sponge("entity.puffer_fish.blow_out"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PUFFER_FISH_BLOW_UP = SoundTypes.key(ResourceKey.sponge("entity.puffer_fish.blow_up"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PUFFER_FISH_DEATH = SoundTypes.key(ResourceKey.sponge("entity.puffer_fish.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PUFFER_FISH_FLOP = SoundTypes.key(ResourceKey.sponge("entity.puffer_fish.flop"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PUFFER_FISH_HURT = SoundTypes.key(ResourceKey.sponge("entity.puffer_fish.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_PUFFER_FISH_STING = SoundTypes.key(ResourceKey.sponge("entity.puffer_fish.sting"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_RABBIT_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.rabbit.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_RABBIT_ATTACK = SoundTypes.key(ResourceKey.sponge("entity.rabbit.attack"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_RABBIT_DEATH = SoundTypes.key(ResourceKey.sponge("entity.rabbit.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_RABBIT_HURT = SoundTypes.key(ResourceKey.sponge("entity.rabbit.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_RABBIT_JUMP = SoundTypes.key(ResourceKey.sponge("entity.rabbit.jump"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_RAVAGER_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.ravager.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_RAVAGER_ATTACK = SoundTypes.key(ResourceKey.sponge("entity.ravager.attack"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_RAVAGER_CELEBRATE = SoundTypes.key(ResourceKey.sponge("entity.ravager.celebrate"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_RAVAGER_DEATH = SoundTypes.key(ResourceKey.sponge("entity.ravager.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_RAVAGER_HURT = SoundTypes.key(ResourceKey.sponge("entity.ravager.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_RAVAGER_ROAR = SoundTypes.key(ResourceKey.sponge("entity.ravager.roar"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_RAVAGER_STEP = SoundTypes.key(ResourceKey.sponge("entity.ravager.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_RAVAGER_STUNNED = SoundTypes.key(ResourceKey.sponge("entity.ravager.stunned"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SALMON_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.salmon.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SALMON_DEATH = SoundTypes.key(ResourceKey.sponge("entity.salmon.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SALMON_FLOP = SoundTypes.key(ResourceKey.sponge("entity.salmon.flop"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SALMON_HURT = SoundTypes.key(ResourceKey.sponge("entity.salmon.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SHEEP_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.sheep.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SHEEP_DEATH = SoundTypes.key(ResourceKey.sponge("entity.sheep.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SHEEP_HURT = SoundTypes.key(ResourceKey.sponge("entity.sheep.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SHEEP_SHEAR = SoundTypes.key(ResourceKey.sponge("entity.sheep.shear"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SHEEP_STEP = SoundTypes.key(ResourceKey.sponge("entity.sheep.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SHULKER_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.shulker.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SHULKER_CLOSE = SoundTypes.key(ResourceKey.sponge("entity.shulker.close"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SHULKER_DEATH = SoundTypes.key(ResourceKey.sponge("entity.shulker.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SHULKER_HURT = SoundTypes.key(ResourceKey.sponge("entity.shulker.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SHULKER_HURT_CLOSED = SoundTypes.key(ResourceKey.sponge("entity.shulker.hurt_closed"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SHULKER_OPEN = SoundTypes.key(ResourceKey.sponge("entity.shulker.open"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SHULKER_SHOOT = SoundTypes.key(ResourceKey.sponge("entity.shulker.shoot"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SHULKER_TELEPORT = SoundTypes.key(ResourceKey.sponge("entity.shulker.teleport"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SHULKER_BULLET_HIT = SoundTypes.key(ResourceKey.sponge("entity.shulker_bullet.hit"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SHULKER_BULLET_HURT = SoundTypes.key(ResourceKey.sponge("entity.shulker_bullet.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SILVERFISH_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.silverfish.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SILVERFISH_DEATH = SoundTypes.key(ResourceKey.sponge("entity.silverfish.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SILVERFISH_HURT = SoundTypes.key(ResourceKey.sponge("entity.silverfish.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SILVERFISH_STEP = SoundTypes.key(ResourceKey.sponge("entity.silverfish.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SKELETON_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.skeleton.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SKELETON_DEATH = SoundTypes.key(ResourceKey.sponge("entity.skeleton.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SKELETON_HURT = SoundTypes.key(ResourceKey.sponge("entity.skeleton.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SKELETON_SHOOT = SoundTypes.key(ResourceKey.sponge("entity.skeleton.shoot"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SKELETON_STEP = SoundTypes.key(ResourceKey.sponge("entity.skeleton.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SKELETON_HORSE_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.skeleton_horse.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SKELETON_HORSE_AMBIENT_WATER = SoundTypes.key(ResourceKey.sponge("entity.skeleton_horse.ambient_water"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SKELETON_HORSE_DEATH = SoundTypes.key(ResourceKey.sponge("entity.skeleton_horse.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SKELETON_HORSE_GALLOP_WATER = SoundTypes.key(ResourceKey.sponge("entity.skeleton_horse.gallop_water"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SKELETON_HORSE_HURT = SoundTypes.key(ResourceKey.sponge("entity.skeleton_horse.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SKELETON_HORSE_JUMP_WATER = SoundTypes.key(ResourceKey.sponge("entity.skeleton_horse.jump_water"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SKELETON_HORSE_STEP_WATER = SoundTypes.key(ResourceKey.sponge("entity.skeleton_horse.step_water"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SKELETON_HORSE_SWIM = SoundTypes.key(ResourceKey.sponge("entity.skeleton_horse.swim"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SLIME_ATTACK = SoundTypes.key(ResourceKey.sponge("entity.slime.attack"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SLIME_DEATH = SoundTypes.key(ResourceKey.sponge("entity.slime.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SLIME_DEATH_SMALL = SoundTypes.key(ResourceKey.sponge("entity.slime.death_small"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SLIME_HURT = SoundTypes.key(ResourceKey.sponge("entity.slime.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SLIME_HURT_SMALL = SoundTypes.key(ResourceKey.sponge("entity.slime.hurt_small"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SLIME_JUMP = SoundTypes.key(ResourceKey.sponge("entity.slime.jump"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SLIME_JUMP_SMALL = SoundTypes.key(ResourceKey.sponge("entity.slime.jump_small"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SLIME_SQUISH = SoundTypes.key(ResourceKey.sponge("entity.slime.squish"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SLIME_SQUISH_SMALL = SoundTypes.key(ResourceKey.sponge("entity.slime.squish_small"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SNOW_GOLEM_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.snow_golem.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SNOW_GOLEM_DEATH = SoundTypes.key(ResourceKey.sponge("entity.snow_golem.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SNOW_GOLEM_HURT = SoundTypes.key(ResourceKey.sponge("entity.snow_golem.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SNOW_GOLEM_SHEAR = SoundTypes.key(ResourceKey.sponge("entity.snow_golem.shear"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SNOW_GOLEM_SHOOT = SoundTypes.key(ResourceKey.sponge("entity.snow_golem.shoot"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SNOWBALL_THROW = SoundTypes.key(ResourceKey.sponge("entity.snowball.throw"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SPIDER_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.spider.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SPIDER_DEATH = SoundTypes.key(ResourceKey.sponge("entity.spider.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SPIDER_HURT = SoundTypes.key(ResourceKey.sponge("entity.spider.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SPIDER_STEP = SoundTypes.key(ResourceKey.sponge("entity.spider.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SPLASH_POTION_BREAK = SoundTypes.key(ResourceKey.sponge("entity.splash_potion.break"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SPLASH_POTION_THROW = SoundTypes.key(ResourceKey.sponge("entity.splash_potion.throw"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SQUID_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.squid.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SQUID_DEATH = SoundTypes.key(ResourceKey.sponge("entity.squid.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SQUID_HURT = SoundTypes.key(ResourceKey.sponge("entity.squid.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_SQUID_SQUIRT = SoundTypes.key(ResourceKey.sponge("entity.squid.squirt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_STRAY_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.stray.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_STRAY_DEATH = SoundTypes.key(ResourceKey.sponge("entity.stray.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_STRAY_HURT = SoundTypes.key(ResourceKey.sponge("entity.stray.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_STRAY_STEP = SoundTypes.key(ResourceKey.sponge("entity.stray.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_STRIDER_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.strider.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_STRIDER_DEATH = SoundTypes.key(ResourceKey.sponge("entity.strider.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_STRIDER_EAT = SoundTypes.key(ResourceKey.sponge("entity.strider.eat"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_STRIDER_HAPPY = SoundTypes.key(ResourceKey.sponge("entity.strider.happy"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_STRIDER_HURT = SoundTypes.key(ResourceKey.sponge("entity.strider.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_STRIDER_RETREAT = SoundTypes.key(ResourceKey.sponge("entity.strider.retreat"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_STRIDER_SADDLE = SoundTypes.key(ResourceKey.sponge("entity.strider.saddle"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_STRIDER_STEP = SoundTypes.key(ResourceKey.sponge("entity.strider.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_STRIDER_STEP_LAVA = SoundTypes.key(ResourceKey.sponge("entity.strider.step_lava"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_TNT_PRIMED = SoundTypes.key(ResourceKey.sponge("entity.tnt.primed"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_TROPICAL_FISH_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.tropical_fish.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_TROPICAL_FISH_DEATH = SoundTypes.key(ResourceKey.sponge("entity.tropical_fish.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_TROPICAL_FISH_FLOP = SoundTypes.key(ResourceKey.sponge("entity.tropical_fish.flop"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_TROPICAL_FISH_HURT = SoundTypes.key(ResourceKey.sponge("entity.tropical_fish.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_TURTLE_AMBIENT_LAND = SoundTypes.key(ResourceKey.sponge("entity.turtle.ambient_land"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_TURTLE_DEATH = SoundTypes.key(ResourceKey.sponge("entity.turtle.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_TURTLE_DEATH_BABY = SoundTypes.key(ResourceKey.sponge("entity.turtle.death_baby"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_TURTLE_EGG_BREAK = SoundTypes.key(ResourceKey.sponge("entity.turtle.egg_break"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_TURTLE_EGG_CRACK = SoundTypes.key(ResourceKey.sponge("entity.turtle.egg_crack"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_TURTLE_EGG_HATCH = SoundTypes.key(ResourceKey.sponge("entity.turtle.egg_hatch"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_TURTLE_HURT = SoundTypes.key(ResourceKey.sponge("entity.turtle.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_TURTLE_HURT_BABY = SoundTypes.key(ResourceKey.sponge("entity.turtle.hurt_baby"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_TURTLE_LAY_EGG = SoundTypes.key(ResourceKey.sponge("entity.turtle.lay_egg"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_TURTLE_SHAMBLE = SoundTypes.key(ResourceKey.sponge("entity.turtle.shamble"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_TURTLE_SHAMBLE_BABY = SoundTypes.key(ResourceKey.sponge("entity.turtle.shamble_baby"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_TURTLE_SWIM = SoundTypes.key(ResourceKey.sponge("entity.turtle.swim"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VEX_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.vex.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VEX_CHARGE = SoundTypes.key(ResourceKey.sponge("entity.vex.charge"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VEX_DEATH = SoundTypes.key(ResourceKey.sponge("entity.vex.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VEX_HURT = SoundTypes.key(ResourceKey.sponge("entity.vex.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VILLAGER_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.villager.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VILLAGER_CELEBRATE = SoundTypes.key(ResourceKey.sponge("entity.villager.celebrate"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VILLAGER_DEATH = SoundTypes.key(ResourceKey.sponge("entity.villager.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VILLAGER_HURT = SoundTypes.key(ResourceKey.sponge("entity.villager.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VILLAGER_NO = SoundTypes.key(ResourceKey.sponge("entity.villager.no"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VILLAGER_TRADE = SoundTypes.key(ResourceKey.sponge("entity.villager.trade"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VILLAGER_WORK_ARMORER = SoundTypes.key(ResourceKey.sponge("entity.villager.work_armorer"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VILLAGER_WORK_BUTCHER = SoundTypes.key(ResourceKey.sponge("entity.villager.work_butcher"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VILLAGER_WORK_CARTOGRAPHER = SoundTypes.key(ResourceKey.sponge("entity.villager.work_cartographer"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VILLAGER_WORK_CLERIC = SoundTypes.key(ResourceKey.sponge("entity.villager.work_cleric"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VILLAGER_WORK_FARMER = SoundTypes.key(ResourceKey.sponge("entity.villager.work_farmer"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VILLAGER_WORK_FISHERMAN = SoundTypes.key(ResourceKey.sponge("entity.villager.work_fisherman"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VILLAGER_WORK_FLETCHER = SoundTypes.key(ResourceKey.sponge("entity.villager.work_fletcher"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VILLAGER_WORK_LEATHERWORKER = SoundTypes.key(ResourceKey.sponge("entity.villager.work_leatherworker"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VILLAGER_WORK_LIBRARIAN = SoundTypes.key(ResourceKey.sponge("entity.villager.work_librarian"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VILLAGER_WORK_MASON = SoundTypes.key(ResourceKey.sponge("entity.villager.work_mason"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VILLAGER_WORK_SHEPHERD = SoundTypes.key(ResourceKey.sponge("entity.villager.work_shepherd"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VILLAGER_WORK_TOOLSMITH = SoundTypes.key(ResourceKey.sponge("entity.villager.work_toolsmith"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VILLAGER_WORK_WEAPONSMITH = SoundTypes.key(ResourceKey.sponge("entity.villager.work_weaponsmith"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VILLAGER_YES = SoundTypes.key(ResourceKey.sponge("entity.villager.yes"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VINDICATOR_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.vindicator.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VINDICATOR_CELEBRATE = SoundTypes.key(ResourceKey.sponge("entity.vindicator.celebrate"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VINDICATOR_DEATH = SoundTypes.key(ResourceKey.sponge("entity.vindicator.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_VINDICATOR_HURT = SoundTypes.key(ResourceKey.sponge("entity.vindicator.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WANDERING_TRADER_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.wandering_trader.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WANDERING_TRADER_DEATH = SoundTypes.key(ResourceKey.sponge("entity.wandering_trader.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WANDERING_TRADER_DISAPPEARED = SoundTypes.key(ResourceKey.sponge("entity.wandering_trader.disappeared"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WANDERING_TRADER_DRINK_MILK = SoundTypes.key(ResourceKey.sponge("entity.wandering_trader.drink_milk"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WANDERING_TRADER_DRINK_POTION = SoundTypes.key(ResourceKey.sponge("entity.wandering_trader.drink_potion"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WANDERING_TRADER_HURT = SoundTypes.key(ResourceKey.sponge("entity.wandering_trader.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WANDERING_TRADER_NO = SoundTypes.key(ResourceKey.sponge("entity.wandering_trader.no"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WANDERING_TRADER_REAPPEARED = SoundTypes.key(ResourceKey.sponge("entity.wandering_trader.reappeared"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WANDERING_TRADER_TRADE = SoundTypes.key(ResourceKey.sponge("entity.wandering_trader.trade"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WANDERING_TRADER_YES = SoundTypes.key(ResourceKey.sponge("entity.wandering_trader.yes"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WITCH_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.witch.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WITCH_CELEBRATE = SoundTypes.key(ResourceKey.sponge("entity.witch.celebrate"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WITCH_DEATH = SoundTypes.key(ResourceKey.sponge("entity.witch.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WITCH_DRINK = SoundTypes.key(ResourceKey.sponge("entity.witch.drink"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WITCH_HURT = SoundTypes.key(ResourceKey.sponge("entity.witch.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WITCH_THROW = SoundTypes.key(ResourceKey.sponge("entity.witch.throw"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WITHER_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.wither.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WITHER_BREAK_BLOCK = SoundTypes.key(ResourceKey.sponge("entity.wither.break_block"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WITHER_DEATH = SoundTypes.key(ResourceKey.sponge("entity.wither.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WITHER_HURT = SoundTypes.key(ResourceKey.sponge("entity.wither.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WITHER_SHOOT = SoundTypes.key(ResourceKey.sponge("entity.wither.shoot"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WITHER_SPAWN = SoundTypes.key(ResourceKey.sponge("entity.wither.spawn"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WITHER_SKELETON_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.wither_skeleton.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WITHER_SKELETON_DEATH = SoundTypes.key(ResourceKey.sponge("entity.wither_skeleton.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WITHER_SKELETON_HURT = SoundTypes.key(ResourceKey.sponge("entity.wither_skeleton.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WITHER_SKELETON_STEP = SoundTypes.key(ResourceKey.sponge("entity.wither_skeleton.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WOLF_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.wolf.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WOLF_DEATH = SoundTypes.key(ResourceKey.sponge("entity.wolf.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WOLF_GROWL = SoundTypes.key(ResourceKey.sponge("entity.wolf.growl"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WOLF_HOWL = SoundTypes.key(ResourceKey.sponge("entity.wolf.howl"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WOLF_HURT = SoundTypes.key(ResourceKey.sponge("entity.wolf.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WOLF_PANT = SoundTypes.key(ResourceKey.sponge("entity.wolf.pant"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WOLF_SHAKE = SoundTypes.key(ResourceKey.sponge("entity.wolf.shake"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WOLF_STEP = SoundTypes.key(ResourceKey.sponge("entity.wolf.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_WOLF_WHINE = SoundTypes.key(ResourceKey.sponge("entity.wolf.whine"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOGLIN_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.zoglin.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOGLIN_ANGRY = SoundTypes.key(ResourceKey.sponge("entity.zoglin.angry"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOGLIN_ATTACK = SoundTypes.key(ResourceKey.sponge("entity.zoglin.attack"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOGLIN_DEATH = SoundTypes.key(ResourceKey.sponge("entity.zoglin.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOGLIN_HURT = SoundTypes.key(ResourceKey.sponge("entity.zoglin.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOGLIN_STEP = SoundTypes.key(ResourceKey.sponge("entity.zoglin.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOMBIE_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.zombie.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOMBIE_ATTACK_IRON_DOOR = SoundTypes.key(ResourceKey.sponge("entity.zombie.attack_iron_door"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOMBIE_ATTACK_WOODEN_DOOR = SoundTypes.key(ResourceKey.sponge("entity.zombie.attack_wooden_door"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOMBIE_BREAK_WOODEN_DOOR = SoundTypes.key(ResourceKey.sponge("entity.zombie.break_wooden_door"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOMBIE_CONVERTED_TO_DROWNED = SoundTypes.key(ResourceKey.sponge("entity.zombie.converted_to_drowned"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOMBIE_DEATH = SoundTypes.key(ResourceKey.sponge("entity.zombie.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOMBIE_DESTROY_EGG = SoundTypes.key(ResourceKey.sponge("entity.zombie.destroy_egg"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOMBIE_HURT = SoundTypes.key(ResourceKey.sponge("entity.zombie.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOMBIE_INFECT = SoundTypes.key(ResourceKey.sponge("entity.zombie.infect"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOMBIE_STEP = SoundTypes.key(ResourceKey.sponge("entity.zombie.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOMBIE_HORSE_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.zombie_horse.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOMBIE_HORSE_DEATH = SoundTypes.key(ResourceKey.sponge("entity.zombie_horse.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOMBIE_HORSE_HURT = SoundTypes.key(ResourceKey.sponge("entity.zombie_horse.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOMBIE_VILLAGER_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.zombie_villager.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOMBIE_VILLAGER_CONVERTED = SoundTypes.key(ResourceKey.sponge("entity.zombie_villager.converted"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOMBIE_VILLAGER_CURE = SoundTypes.key(ResourceKey.sponge("entity.zombie_villager.cure"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOMBIE_VILLAGER_DEATH = SoundTypes.key(ResourceKey.sponge("entity.zombie_villager.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOMBIE_VILLAGER_HURT = SoundTypes.key(ResourceKey.sponge("entity.zombie_villager.hurt"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOMBIE_VILLAGER_STEP = SoundTypes.key(ResourceKey.sponge("entity.zombie_villager.step"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOMBIFIED_PIGLIN_AMBIENT = SoundTypes.key(ResourceKey.sponge("entity.zombified_piglin.ambient"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOMBIFIED_PIGLIN_ANGRY = SoundTypes.key(ResourceKey.sponge("entity.zombified_piglin.angry"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOMBIFIED_PIGLIN_DEATH = SoundTypes.key(ResourceKey.sponge("entity.zombified_piglin.death"));

    public static final DefaultedRegistryReference<SoundType> ENTITY_ZOMBIFIED_PIGLIN_HURT = SoundTypes.key(ResourceKey.sponge("entity.zombified_piglin.hurt"));

    public static final DefaultedRegistryReference<SoundType> EVENT_RAID_HORN = SoundTypes.key(ResourceKey.sponge("event.raid.horn"));

    public static final DefaultedRegistryReference<SoundType> ITEM_ARMOR_EQUIP_CHAIN = SoundTypes.key(ResourceKey.sponge("item.armor.equip_chain"));

    public static final DefaultedRegistryReference<SoundType> ITEM_ARMOR_EQUIP_DIAMOND = SoundTypes.key(ResourceKey.sponge("item.armor.equip_diamond"));

    public static final DefaultedRegistryReference<SoundType> ITEM_ARMOR_EQUIP_ELYTRA = SoundTypes.key(ResourceKey.sponge("item.armor.equip_elytra"));

    public static final DefaultedRegistryReference<SoundType> ITEM_ARMOR_EQUIP_GENERIC = SoundTypes.key(ResourceKey.sponge("item.armor.equip_generic"));

    public static final DefaultedRegistryReference<SoundType> ITEM_ARMOR_EQUIP_GOLD = SoundTypes.key(ResourceKey.sponge("item.armor.equip_gold"));

    public static final DefaultedRegistryReference<SoundType> ITEM_ARMOR_EQUIP_IRON = SoundTypes.key(ResourceKey.sponge("item.armor.equip_iron"));

    public static final DefaultedRegistryReference<SoundType> ITEM_ARMOR_EQUIP_LEATHER = SoundTypes.key(ResourceKey.sponge("item.armor.equip_leather"));

    public static final DefaultedRegistryReference<SoundType> ITEM_ARMOR_EQUIP_NETHERITE = SoundTypes.key(ResourceKey.sponge("item.armor.equip_netherite"));

    public static final DefaultedRegistryReference<SoundType> ITEM_ARMOR_EQUIP_TURTLE = SoundTypes.key(ResourceKey.sponge("item.armor.equip_turtle"));

    public static final DefaultedRegistryReference<SoundType> ITEM_AXE_STRIP = SoundTypes.key(ResourceKey.sponge("item.axe.strip"));

    public static final DefaultedRegistryReference<SoundType> ITEM_BOOK_PAGE_TURN = SoundTypes.key(ResourceKey.sponge("item.book.page_turn"));

    public static final DefaultedRegistryReference<SoundType> ITEM_BOOK_PUT = SoundTypes.key(ResourceKey.sponge("item.book.put"));

    public static final DefaultedRegistryReference<SoundType> ITEM_BOTTLE_EMPTY = SoundTypes.key(ResourceKey.sponge("item.bottle.empty"));

    public static final DefaultedRegistryReference<SoundType> ITEM_BOTTLE_FILL = SoundTypes.key(ResourceKey.sponge("item.bottle.fill"));

    public static final DefaultedRegistryReference<SoundType> ITEM_BOTTLE_FILL_DRAGONBREATH = SoundTypes.key(ResourceKey.sponge("item.bottle.fill_dragonbreath"));

    public static final DefaultedRegistryReference<SoundType> ITEM_BUCKET_EMPTY = SoundTypes.key(ResourceKey.sponge("item.bucket.empty"));

    public static final DefaultedRegistryReference<SoundType> ITEM_BUCKET_EMPTY_FISH = SoundTypes.key(ResourceKey.sponge("item.bucket.empty_fish"));

    public static final DefaultedRegistryReference<SoundType> ITEM_BUCKET_EMPTY_LAVA = SoundTypes.key(ResourceKey.sponge("item.bucket.empty_lava"));

    public static final DefaultedRegistryReference<SoundType> ITEM_BUCKET_FILL = SoundTypes.key(ResourceKey.sponge("item.bucket.fill"));

    public static final DefaultedRegistryReference<SoundType> ITEM_BUCKET_FILL_FISH = SoundTypes.key(ResourceKey.sponge("item.bucket.fill_fish"));

    public static final DefaultedRegistryReference<SoundType> ITEM_BUCKET_FILL_LAVA = SoundTypes.key(ResourceKey.sponge("item.bucket.fill_lava"));

    public static final DefaultedRegistryReference<SoundType> ITEM_CHORUS_FRUIT_TELEPORT = SoundTypes.key(ResourceKey.sponge("item.chorus_fruit.teleport"));

    public static final DefaultedRegistryReference<SoundType> ITEM_CROP_PLANT = SoundTypes.key(ResourceKey.sponge("item.crop.plant"));

    public static final DefaultedRegistryReference<SoundType> ITEM_CROSSBOW_HIT = SoundTypes.key(ResourceKey.sponge("item.crossbow.hit"));

    public static final DefaultedRegistryReference<SoundType> ITEM_CROSSBOW_LOADING_END = SoundTypes.key(ResourceKey.sponge("item.crossbow.loading_end"));

    public static final DefaultedRegistryReference<SoundType> ITEM_CROSSBOW_LOADING_MIDDLE = SoundTypes.key(ResourceKey.sponge("item.crossbow.loading_middle"));

    public static final DefaultedRegistryReference<SoundType> ITEM_CROSSBOW_LOADING_START = SoundTypes.key(ResourceKey.sponge("item.crossbow.loading_start"));

    public static final DefaultedRegistryReference<SoundType> ITEM_CROSSBOW_QUICK_CHARGE_1 = SoundTypes.key(ResourceKey.sponge("item.crossbow.quick_charge_1"));

    public static final DefaultedRegistryReference<SoundType> ITEM_CROSSBOW_QUICK_CHARGE_2 = SoundTypes.key(ResourceKey.sponge("item.crossbow.quick_charge_2"));

    public static final DefaultedRegistryReference<SoundType> ITEM_CROSSBOW_QUICK_CHARGE_3 = SoundTypes.key(ResourceKey.sponge("item.crossbow.quick_charge_3"));

    public static final DefaultedRegistryReference<SoundType> ITEM_CROSSBOW_SHOOT = SoundTypes.key(ResourceKey.sponge("item.crossbow.shoot"));

    public static final DefaultedRegistryReference<SoundType> ITEM_ELYTRA_FLYING = SoundTypes.key(ResourceKey.sponge("item.elytra.flying"));

    public static final DefaultedRegistryReference<SoundType> ITEM_FIRECHARGE_USE = SoundTypes.key(ResourceKey.sponge("item.firecharge.use"));

    public static final DefaultedRegistryReference<SoundType> ITEM_FLINTANDSTEEL_USE = SoundTypes.key(ResourceKey.sponge("item.flintandsteel.use"));

    public static final DefaultedRegistryReference<SoundType> ITEM_HOE_TILL = SoundTypes.key(ResourceKey.sponge("item.hoe.till"));

    public static final DefaultedRegistryReference<SoundType> ITEM_HONEY_BOTTLE_DRINK = SoundTypes.key(ResourceKey.sponge("item.honey_bottle.drink"));

    public static final DefaultedRegistryReference<SoundType> ITEM_LODESTONE_COMPASS_LOCK = SoundTypes.key(ResourceKey.sponge("item.lodestone_compass.lock"));

    public static final DefaultedRegistryReference<SoundType> ITEM_NETHER_WART_PLANT = SoundTypes.key(ResourceKey.sponge("item.nether_wart.plant"));

    public static final DefaultedRegistryReference<SoundType> ITEM_SHIELD_BLOCK = SoundTypes.key(ResourceKey.sponge("item.shield.block"));

    public static final DefaultedRegistryReference<SoundType> ITEM_SHIELD_BREAK = SoundTypes.key(ResourceKey.sponge("item.shield.break"));

    public static final DefaultedRegistryReference<SoundType> ITEM_SHOVEL_FLATTEN = SoundTypes.key(ResourceKey.sponge("item.shovel.flatten"));

    public static final DefaultedRegistryReference<SoundType> ITEM_SWEET_BERRIES_PICK_FROM_BUSH = SoundTypes.key(ResourceKey.sponge("item.sweet_berries.pick_from_bush"));

    public static final DefaultedRegistryReference<SoundType> ITEM_TOTEM_USE = SoundTypes.key(ResourceKey.sponge("item.totem.use"));

    public static final DefaultedRegistryReference<SoundType> ITEM_TRIDENT_HIT = SoundTypes.key(ResourceKey.sponge("item.trident.hit"));

    public static final DefaultedRegistryReference<SoundType> ITEM_TRIDENT_HIT_GROUND = SoundTypes.key(ResourceKey.sponge("item.trident.hit_ground"));

    public static final DefaultedRegistryReference<SoundType> ITEM_TRIDENT_RETURN = SoundTypes.key(ResourceKey.sponge("item.trident.return"));

    public static final DefaultedRegistryReference<SoundType> ITEM_TRIDENT_RIPTIDE_1 = SoundTypes.key(ResourceKey.sponge("item.trident.riptide_1"));

    public static final DefaultedRegistryReference<SoundType> ITEM_TRIDENT_RIPTIDE_2 = SoundTypes.key(ResourceKey.sponge("item.trident.riptide_2"));

    public static final DefaultedRegistryReference<SoundType> ITEM_TRIDENT_RIPTIDE_3 = SoundTypes.key(ResourceKey.sponge("item.trident.riptide_3"));

    public static final DefaultedRegistryReference<SoundType> ITEM_TRIDENT_THROW = SoundTypes.key(ResourceKey.sponge("item.trident.throw"));

    public static final DefaultedRegistryReference<SoundType> ITEM_TRIDENT_THUNDER = SoundTypes.key(ResourceKey.sponge("item.trident.thunder"));

    public static final DefaultedRegistryReference<SoundType> MUSIC_CREATIVE = SoundTypes.key(ResourceKey.sponge("music.creative"));

    public static final DefaultedRegistryReference<SoundType> MUSIC_CREDITS = SoundTypes.key(ResourceKey.sponge("music.credits"));

    public static final DefaultedRegistryReference<SoundType> MUSIC_DRAGON = SoundTypes.key(ResourceKey.sponge("music.dragon"));

    public static final DefaultedRegistryReference<SoundType> MUSIC_END = SoundTypes.key(ResourceKey.sponge("music.end"));

    public static final DefaultedRegistryReference<SoundType> MUSIC_GAME = SoundTypes.key(ResourceKey.sponge("music.game"));

    public static final DefaultedRegistryReference<SoundType> MUSIC_MENU = SoundTypes.key(ResourceKey.sponge("music.menu"));

    public static final DefaultedRegistryReference<SoundType> MUSIC_NETHER_BASALT_DELTAS = SoundTypes.key(ResourceKey.sponge("music.nether.basalt_deltas"));

    public static final DefaultedRegistryReference<SoundType> MUSIC_NETHER_CRIMSON_FOREST = SoundTypes.key(ResourceKey.sponge("music.nether.crimson_forest"));

    public static final DefaultedRegistryReference<SoundType> MUSIC_NETHER_NETHER_WASTES = SoundTypes.key(ResourceKey.sponge("music.nether.nether_wastes"));

    public static final DefaultedRegistryReference<SoundType> MUSIC_NETHER_SOUL_SAND_VALLEY = SoundTypes.key(ResourceKey.sponge("music.nether.soul_sand_valley"));

    public static final DefaultedRegistryReference<SoundType> MUSIC_NETHER_WARPED_FOREST = SoundTypes.key(ResourceKey.sponge("music.nether.warped_forest"));

    public static final DefaultedRegistryReference<SoundType> MUSIC_UNDER_WATER = SoundTypes.key(ResourceKey.sponge("music.under_water"));

    public static final DefaultedRegistryReference<SoundType> MUSIC_DISC_11 = SoundTypes.key(ResourceKey.sponge("music_disc.11"));

    public static final DefaultedRegistryReference<SoundType> MUSIC_DISC_13 = SoundTypes.key(ResourceKey.sponge("music_disc.13"));

    public static final DefaultedRegistryReference<SoundType> MUSIC_DISC_BLOCKS = SoundTypes.key(ResourceKey.sponge("music_disc.blocks"));

    public static final DefaultedRegistryReference<SoundType> MUSIC_DISC_CAT = SoundTypes.key(ResourceKey.sponge("music_disc.cat"));

    public static final DefaultedRegistryReference<SoundType> MUSIC_DISC_CHIRP = SoundTypes.key(ResourceKey.sponge("music_disc.chirp"));

    public static final DefaultedRegistryReference<SoundType> MUSIC_DISC_FAR = SoundTypes.key(ResourceKey.sponge("music_disc.far"));

    public static final DefaultedRegistryReference<SoundType> MUSIC_DISC_MALL = SoundTypes.key(ResourceKey.sponge("music_disc.mall"));

    public static final DefaultedRegistryReference<SoundType> MUSIC_DISC_MELLOHI = SoundTypes.key(ResourceKey.sponge("music_disc.mellohi"));

    public static final DefaultedRegistryReference<SoundType> MUSIC_DISC_PIGSTEP = SoundTypes.key(ResourceKey.sponge("music_disc.pigstep"));

    public static final DefaultedRegistryReference<SoundType> MUSIC_DISC_STAL = SoundTypes.key(ResourceKey.sponge("music_disc.stal"));

    public static final DefaultedRegistryReference<SoundType> MUSIC_DISC_STRAD = SoundTypes.key(ResourceKey.sponge("music_disc.strad"));

    public static final DefaultedRegistryReference<SoundType> MUSIC_DISC_WAIT = SoundTypes.key(ResourceKey.sponge("music_disc.wait"));

    public static final DefaultedRegistryReference<SoundType> MUSIC_DISC_WARD = SoundTypes.key(ResourceKey.sponge("music_disc.ward"));

    public static final DefaultedRegistryReference<SoundType> PARTICLE_SOUL_ESCAPE = SoundTypes.key(ResourceKey.sponge("particle.soul_escape"));

    public static final DefaultedRegistryReference<SoundType> UI_BUTTON_CLICK = SoundTypes.key(ResourceKey.sponge("ui.button.click"));

    public static final DefaultedRegistryReference<SoundType> UI_CARTOGRAPHY_TABLE_TAKE_RESULT = SoundTypes.key(ResourceKey.sponge("ui.cartography_table.take_result"));

    public static final DefaultedRegistryReference<SoundType> UI_LOOM_SELECT_PATTERN = SoundTypes.key(ResourceKey.sponge("ui.loom.select_pattern"));

    public static final DefaultedRegistryReference<SoundType> UI_LOOM_TAKE_RESULT = SoundTypes.key(ResourceKey.sponge("ui.loom.take_result"));

    public static final DefaultedRegistryReference<SoundType> UI_STONECUTTER_SELECT_RECIPE = SoundTypes.key(ResourceKey.sponge("ui.stonecutter.select_recipe"));

    public static final DefaultedRegistryReference<SoundType> UI_STONECUTTER_TAKE_RESULT = SoundTypes.key(ResourceKey.sponge("ui.stonecutter.take_result"));

    public static final DefaultedRegistryReference<SoundType> UI_TOAST_CHALLENGE_COMPLETE = SoundTypes.key(ResourceKey.sponge("ui.toast.challenge_complete"));

    public static final DefaultedRegistryReference<SoundType> UI_TOAST_IN = SoundTypes.key(ResourceKey.sponge("ui.toast.in"));

    public static final DefaultedRegistryReference<SoundType> UI_TOAST_OUT = SoundTypes.key(ResourceKey.sponge("ui.toast.out"));

    public static final DefaultedRegistryReference<SoundType> WEATHER_RAIN = SoundTypes.key(ResourceKey.sponge("weather.rain"));

    public static final DefaultedRegistryReference<SoundType> WEATHER_RAIN_ABOVE = SoundTypes.key(ResourceKey.sponge("weather.rain.above"));

    // SORTFIELDS:OFF

    // @formatter:on

    private SoundTypes() {
    }

    private static DefaultedRegistryReference<SoundType> key(final ResourceKey location) {
        return RegistryKey.<SoundType>of(Registries.SOUND_TYPE.registry(), location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
