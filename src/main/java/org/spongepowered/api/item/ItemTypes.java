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
package org.spongepowered.api.item;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registries;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

/**
 * An enumeration of all possible {@link ItemType}s in vanilla minecraft.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class ItemTypes {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<ItemType> ACACIA_BOAT = ItemTypes.key(ResourceKey.sponge("acacia_boat"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_BUTTON = ItemTypes.key(ResourceKey.sponge("acacia_button"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_DOOR = ItemTypes.key(ResourceKey.sponge("acacia_door"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_FENCE = ItemTypes.key(ResourceKey.sponge("acacia_fence"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_FENCE_GATE = ItemTypes.key(ResourceKey.sponge("acacia_fence_gate"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_LEAVES = ItemTypes.key(ResourceKey.sponge("acacia_leaves"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_LOG = ItemTypes.key(ResourceKey.sponge("acacia_log"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_PLANKS = ItemTypes.key(ResourceKey.sponge("acacia_planks"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_PRESSURE_PLATE = ItemTypes.key(ResourceKey.sponge("acacia_pressure_plate"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_SAPLING = ItemTypes.key(ResourceKey.sponge("acacia_sapling"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_SIGN = ItemTypes.key(ResourceKey.sponge("acacia_sign"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_SLAB = ItemTypes.key(ResourceKey.sponge("acacia_slab"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_STAIRS = ItemTypes.key(ResourceKey.sponge("acacia_stairs"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_TRAPDOOR = ItemTypes.key(ResourceKey.sponge("acacia_trapdoor"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_WOOD = ItemTypes.key(ResourceKey.sponge("acacia_wood"));

    public static final DefaultedRegistryReference<ItemType> ACTIVATOR_RAIL = ItemTypes.key(ResourceKey.sponge("activator_rail"));

    public static final DefaultedRegistryReference<ItemType> AIR = ItemTypes.key(ResourceKey.sponge("air"));

    public static final DefaultedRegistryReference<ItemType> ALLIUM = ItemTypes.key(ResourceKey.sponge("allium"));

    public static final DefaultedRegistryReference<ItemType> ANCIENT_DEBRIS = ItemTypes.key(ResourceKey.sponge("ancient_debris"));

    public static final DefaultedRegistryReference<ItemType> ANDESITE = ItemTypes.key(ResourceKey.sponge("andesite"));

    public static final DefaultedRegistryReference<ItemType> ANDESITE_SLAB = ItemTypes.key(ResourceKey.sponge("andesite_slab"));

    public static final DefaultedRegistryReference<ItemType> ANDESITE_STAIRS = ItemTypes.key(ResourceKey.sponge("andesite_stairs"));

    public static final DefaultedRegistryReference<ItemType> ANDESITE_WALL = ItemTypes.key(ResourceKey.sponge("andesite_wall"));

    public static final DefaultedRegistryReference<ItemType> ANVIL = ItemTypes.key(ResourceKey.sponge("anvil"));

    public static final DefaultedRegistryReference<ItemType> APPLE = ItemTypes.key(ResourceKey.sponge("apple"));

    public static final DefaultedRegistryReference<ItemType> ARMOR_STAND = ItemTypes.key(ResourceKey.sponge("armor_stand"));

    public static final DefaultedRegistryReference<ItemType> ARROW = ItemTypes.key(ResourceKey.sponge("arrow"));

    public static final DefaultedRegistryReference<ItemType> AZURE_BLUET = ItemTypes.key(ResourceKey.sponge("azure_bluet"));

    public static final DefaultedRegistryReference<ItemType> BAKED_POTATO = ItemTypes.key(ResourceKey.sponge("baked_potato"));

    public static final DefaultedRegistryReference<ItemType> BAMBOO = ItemTypes.key(ResourceKey.sponge("bamboo"));

    public static final DefaultedRegistryReference<ItemType> BARREL = ItemTypes.key(ResourceKey.sponge("barrel"));

    public static final DefaultedRegistryReference<ItemType> BARRIER = ItemTypes.key(ResourceKey.sponge("barrier"));

    public static final DefaultedRegistryReference<ItemType> BASALT = ItemTypes.key(ResourceKey.sponge("basalt"));

    public static final DefaultedRegistryReference<ItemType> BAT_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("bat_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> BEACON = ItemTypes.key(ResourceKey.sponge("beacon"));

    public static final DefaultedRegistryReference<ItemType> BEDROCK = ItemTypes.key(ResourceKey.sponge("bedrock"));

    public static final DefaultedRegistryReference<ItemType> BEE_NEST = ItemTypes.key(ResourceKey.sponge("bee_nest"));

    public static final DefaultedRegistryReference<ItemType> BEE_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("bee_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> BEEF = ItemTypes.key(ResourceKey.sponge("beef"));

    public static final DefaultedRegistryReference<ItemType> BEEHIVE = ItemTypes.key(ResourceKey.sponge("beehive"));

    public static final DefaultedRegistryReference<ItemType> BEETROOT = ItemTypes.key(ResourceKey.sponge("beetroot"));

    public static final DefaultedRegistryReference<ItemType> BEETROOT_SEEDS = ItemTypes.key(ResourceKey.sponge("beetroot_seeds"));

    public static final DefaultedRegistryReference<ItemType> BEETROOT_SOUP = ItemTypes.key(ResourceKey.sponge("beetroot_soup"));

    public static final DefaultedRegistryReference<ItemType> BELL = ItemTypes.key(ResourceKey.sponge("bell"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_BOAT = ItemTypes.key(ResourceKey.sponge("birch_boat"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_BUTTON = ItemTypes.key(ResourceKey.sponge("birch_button"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_DOOR = ItemTypes.key(ResourceKey.sponge("birch_door"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_FENCE = ItemTypes.key(ResourceKey.sponge("birch_fence"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_FENCE_GATE = ItemTypes.key(ResourceKey.sponge("birch_fence_gate"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_LEAVES = ItemTypes.key(ResourceKey.sponge("birch_leaves"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_LOG = ItemTypes.key(ResourceKey.sponge("birch_log"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_PLANKS = ItemTypes.key(ResourceKey.sponge("birch_planks"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_PRESSURE_PLATE = ItemTypes.key(ResourceKey.sponge("birch_pressure_plate"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_SAPLING = ItemTypes.key(ResourceKey.sponge("birch_sapling"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_SIGN = ItemTypes.key(ResourceKey.sponge("birch_sign"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_SLAB = ItemTypes.key(ResourceKey.sponge("birch_slab"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_STAIRS = ItemTypes.key(ResourceKey.sponge("birch_stairs"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_TRAPDOOR = ItemTypes.key(ResourceKey.sponge("birch_trapdoor"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_WOOD = ItemTypes.key(ResourceKey.sponge("birch_wood"));

    public static final DefaultedRegistryReference<ItemType> BLACK_BANNER = ItemTypes.key(ResourceKey.sponge("black_banner"));

    public static final DefaultedRegistryReference<ItemType> BLACK_BED = ItemTypes.key(ResourceKey.sponge("black_bed"));

    public static final DefaultedRegistryReference<ItemType> BLACK_CARPET = ItemTypes.key(ResourceKey.sponge("black_carpet"));

    public static final DefaultedRegistryReference<ItemType> BLACK_CONCRETE = ItemTypes.key(ResourceKey.sponge("black_concrete"));

    public static final DefaultedRegistryReference<ItemType> BLACK_CONCRETE_POWDER = ItemTypes.key(ResourceKey.sponge("black_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> BLACK_DYE = ItemTypes.key(ResourceKey.sponge("black_dye"));

    public static final DefaultedRegistryReference<ItemType> BLACK_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("black_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> BLACK_SHULKER_BOX = ItemTypes.key(ResourceKey.sponge("black_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> BLACK_STAINED_GLASS = ItemTypes.key(ResourceKey.sponge("black_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> BLACK_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.sponge("black_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> BLACK_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("black_terracotta"));

    public static final DefaultedRegistryReference<ItemType> BLACK_WOOL = ItemTypes.key(ResourceKey.sponge("black_wool"));

    public static final DefaultedRegistryReference<ItemType> BLACKSTONE = ItemTypes.key(ResourceKey.sponge("blackstone"));

    public static final DefaultedRegistryReference<ItemType> BLACKSTONE_SLAB = ItemTypes.key(ResourceKey.sponge("blackstone_slab"));

    public static final DefaultedRegistryReference<ItemType> BLACKSTONE_STAIRS = ItemTypes.key(ResourceKey.sponge("blackstone_stairs"));

    public static final DefaultedRegistryReference<ItemType> BLACKSTONE_WALL = ItemTypes.key(ResourceKey.sponge("blackstone_wall"));

    public static final DefaultedRegistryReference<ItemType> BLAST_FURNACE = ItemTypes.key(ResourceKey.sponge("blast_furnace"));

    public static final DefaultedRegistryReference<ItemType> BLAZE_POWDER = ItemTypes.key(ResourceKey.sponge("blaze_powder"));

    public static final DefaultedRegistryReference<ItemType> BLAZE_ROD = ItemTypes.key(ResourceKey.sponge("blaze_rod"));

    public static final DefaultedRegistryReference<ItemType> BLAZE_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("blaze_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> BLUE_BANNER = ItemTypes.key(ResourceKey.sponge("blue_banner"));

    public static final DefaultedRegistryReference<ItemType> BLUE_BED = ItemTypes.key(ResourceKey.sponge("blue_bed"));

    public static final DefaultedRegistryReference<ItemType> BLUE_CARPET = ItemTypes.key(ResourceKey.sponge("blue_carpet"));

    public static final DefaultedRegistryReference<ItemType> BLUE_CONCRETE = ItemTypes.key(ResourceKey.sponge("blue_concrete"));

    public static final DefaultedRegistryReference<ItemType> BLUE_CONCRETE_POWDER = ItemTypes.key(ResourceKey.sponge("blue_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> BLUE_DYE = ItemTypes.key(ResourceKey.sponge("blue_dye"));

    public static final DefaultedRegistryReference<ItemType> BLUE_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("blue_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> BLUE_ICE = ItemTypes.key(ResourceKey.sponge("blue_ice"));

    public static final DefaultedRegistryReference<ItemType> BLUE_ORCHID = ItemTypes.key(ResourceKey.sponge("blue_orchid"));

    public static final DefaultedRegistryReference<ItemType> BLUE_SHULKER_BOX = ItemTypes.key(ResourceKey.sponge("blue_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> BLUE_STAINED_GLASS = ItemTypes.key(ResourceKey.sponge("blue_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> BLUE_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.sponge("blue_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> BLUE_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("blue_terracotta"));

    public static final DefaultedRegistryReference<ItemType> BLUE_WOOL = ItemTypes.key(ResourceKey.sponge("blue_wool"));

    public static final DefaultedRegistryReference<ItemType> BONE = ItemTypes.key(ResourceKey.sponge("bone"));

    public static final DefaultedRegistryReference<ItemType> BONE_BLOCK = ItemTypes.key(ResourceKey.sponge("bone_block"));

    public static final DefaultedRegistryReference<ItemType> BONE_MEAL = ItemTypes.key(ResourceKey.sponge("bone_meal"));

    public static final DefaultedRegistryReference<ItemType> BOOK = ItemTypes.key(ResourceKey.sponge("book"));

    public static final DefaultedRegistryReference<ItemType> BOOKSHELF = ItemTypes.key(ResourceKey.sponge("bookshelf"));

    public static final DefaultedRegistryReference<ItemType> BOW = ItemTypes.key(ResourceKey.sponge("bow"));

    public static final DefaultedRegistryReference<ItemType> BOWL = ItemTypes.key(ResourceKey.sponge("bowl"));

    public static final DefaultedRegistryReference<ItemType> BRAIN_CORAL = ItemTypes.key(ResourceKey.sponge("brain_coral"));

    public static final DefaultedRegistryReference<ItemType> BRAIN_CORAL_BLOCK = ItemTypes.key(ResourceKey.sponge("brain_coral_block"));

    public static final DefaultedRegistryReference<ItemType> BRAIN_CORAL_FAN = ItemTypes.key(ResourceKey.sponge("brain_coral_fan"));

    public static final DefaultedRegistryReference<ItemType> BREAD = ItemTypes.key(ResourceKey.sponge("bread"));

    public static final DefaultedRegistryReference<ItemType> BREWING_STAND = ItemTypes.key(ResourceKey.sponge("brewing_stand"));

    public static final DefaultedRegistryReference<ItemType> BRICK = ItemTypes.key(ResourceKey.sponge("brick"));

    public static final DefaultedRegistryReference<ItemType> BRICK_SLAB = ItemTypes.key(ResourceKey.sponge("brick_slab"));

    public static final DefaultedRegistryReference<ItemType> BRICK_STAIRS = ItemTypes.key(ResourceKey.sponge("brick_stairs"));

    public static final DefaultedRegistryReference<ItemType> BRICK_WALL = ItemTypes.key(ResourceKey.sponge("brick_wall"));

    public static final DefaultedRegistryReference<ItemType> BRICKS = ItemTypes.key(ResourceKey.sponge("bricks"));

    public static final DefaultedRegistryReference<ItemType> BROWN_BANNER = ItemTypes.key(ResourceKey.sponge("brown_banner"));

    public static final DefaultedRegistryReference<ItemType> BROWN_BED = ItemTypes.key(ResourceKey.sponge("brown_bed"));

    public static final DefaultedRegistryReference<ItemType> BROWN_CARPET = ItemTypes.key(ResourceKey.sponge("brown_carpet"));

    public static final DefaultedRegistryReference<ItemType> BROWN_CONCRETE = ItemTypes.key(ResourceKey.sponge("brown_concrete"));

    public static final DefaultedRegistryReference<ItemType> BROWN_CONCRETE_POWDER = ItemTypes.key(ResourceKey.sponge("brown_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> BROWN_DYE = ItemTypes.key(ResourceKey.sponge("brown_dye"));

    public static final DefaultedRegistryReference<ItemType> BROWN_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("brown_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> BROWN_MUSHROOM = ItemTypes.key(ResourceKey.sponge("brown_mushroom"));

    public static final DefaultedRegistryReference<ItemType> BROWN_MUSHROOM_BLOCK = ItemTypes.key(ResourceKey.sponge("brown_mushroom_block"));

    public static final DefaultedRegistryReference<ItemType> BROWN_SHULKER_BOX = ItemTypes.key(ResourceKey.sponge("brown_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> BROWN_STAINED_GLASS = ItemTypes.key(ResourceKey.sponge("brown_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> BROWN_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.sponge("brown_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> BROWN_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("brown_terracotta"));

    public static final DefaultedRegistryReference<ItemType> BROWN_WOOL = ItemTypes.key(ResourceKey.sponge("brown_wool"));

    public static final DefaultedRegistryReference<ItemType> BUBBLE_CORAL = ItemTypes.key(ResourceKey.sponge("bubble_coral"));

    public static final DefaultedRegistryReference<ItemType> BUBBLE_CORAL_BLOCK = ItemTypes.key(ResourceKey.sponge("bubble_coral_block"));

    public static final DefaultedRegistryReference<ItemType> BUBBLE_CORAL_FAN = ItemTypes.key(ResourceKey.sponge("bubble_coral_fan"));

    public static final DefaultedRegistryReference<ItemType> BUCKET = ItemTypes.key(ResourceKey.sponge("bucket"));

    public static final DefaultedRegistryReference<ItemType> CACTUS = ItemTypes.key(ResourceKey.sponge("cactus"));

    public static final DefaultedRegistryReference<ItemType> CAKE = ItemTypes.key(ResourceKey.sponge("cake"));

    public static final DefaultedRegistryReference<ItemType> CAMPFIRE = ItemTypes.key(ResourceKey.sponge("campfire"));

    public static final DefaultedRegistryReference<ItemType> CARROT = ItemTypes.key(ResourceKey.sponge("carrot"));

    public static final DefaultedRegistryReference<ItemType> CARROT_ON_A_STICK = ItemTypes.key(ResourceKey.sponge("carrot_on_a_stick"));

    public static final DefaultedRegistryReference<ItemType> CARTOGRAPHY_TABLE = ItemTypes.key(ResourceKey.sponge("cartography_table"));

    public static final DefaultedRegistryReference<ItemType> CARVED_PUMPKIN = ItemTypes.key(ResourceKey.sponge("carved_pumpkin"));

    public static final DefaultedRegistryReference<ItemType> CAT_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("cat_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> CAULDRON = ItemTypes.key(ResourceKey.sponge("cauldron"));

    public static final DefaultedRegistryReference<ItemType> CAVE_SPIDER_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("cave_spider_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> CHAIN = ItemTypes.key(ResourceKey.sponge("chain"));

    public static final DefaultedRegistryReference<ItemType> CHAIN_COMMAND_BLOCK = ItemTypes.key(ResourceKey.sponge("chain_command_block"));

    public static final DefaultedRegistryReference<ItemType> CHAINMAIL_BOOTS = ItemTypes.key(ResourceKey.sponge("chainmail_boots"));

    public static final DefaultedRegistryReference<ItemType> CHAINMAIL_CHESTPLATE = ItemTypes.key(ResourceKey.sponge("chainmail_chestplate"));

    public static final DefaultedRegistryReference<ItemType> CHAINMAIL_HELMET = ItemTypes.key(ResourceKey.sponge("chainmail_helmet"));

    public static final DefaultedRegistryReference<ItemType> CHAINMAIL_LEGGINGS = ItemTypes.key(ResourceKey.sponge("chainmail_leggings"));

    public static final DefaultedRegistryReference<ItemType> CHARCOAL = ItemTypes.key(ResourceKey.sponge("charcoal"));

    public static final DefaultedRegistryReference<ItemType> CHEST = ItemTypes.key(ResourceKey.sponge("chest"));

    public static final DefaultedRegistryReference<ItemType> CHEST_MINECART = ItemTypes.key(ResourceKey.sponge("chest_minecart"));

    public static final DefaultedRegistryReference<ItemType> CHICKEN = ItemTypes.key(ResourceKey.sponge("chicken"));

    public static final DefaultedRegistryReference<ItemType> CHICKEN_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("chicken_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> CHIPPED_ANVIL = ItemTypes.key(ResourceKey.sponge("chipped_anvil"));

    public static final DefaultedRegistryReference<ItemType> CHISELED_NETHER_BRICKS = ItemTypes.key(ResourceKey.sponge("chiseled_nether_bricks"));

    public static final DefaultedRegistryReference<ItemType> CHISELED_POLISHED_BLACKSTONE = ItemTypes.key(ResourceKey.sponge("chiseled_polished_blackstone"));

    public static final DefaultedRegistryReference<ItemType> CHISELED_QUARTZ_BLOCK = ItemTypes.key(ResourceKey.sponge("chiseled_quartz_block"));

    public static final DefaultedRegistryReference<ItemType> CHISELED_RED_SANDSTONE = ItemTypes.key(ResourceKey.sponge("chiseled_red_sandstone"));

    public static final DefaultedRegistryReference<ItemType> CHISELED_SANDSTONE = ItemTypes.key(ResourceKey.sponge("chiseled_sandstone"));

    public static final DefaultedRegistryReference<ItemType> CHISELED_STONE_BRICKS = ItemTypes.key(ResourceKey.sponge("chiseled_stone_bricks"));

    public static final DefaultedRegistryReference<ItemType> CHORUS_FLOWER = ItemTypes.key(ResourceKey.sponge("chorus_flower"));

    public static final DefaultedRegistryReference<ItemType> CHORUS_FRUIT = ItemTypes.key(ResourceKey.sponge("chorus_fruit"));

    public static final DefaultedRegistryReference<ItemType> CHORUS_PLANT = ItemTypes.key(ResourceKey.sponge("chorus_plant"));

    public static final DefaultedRegistryReference<ItemType> CLAY = ItemTypes.key(ResourceKey.sponge("clay"));

    public static final DefaultedRegistryReference<ItemType> CLAY_BALL = ItemTypes.key(ResourceKey.sponge("clay_ball"));

    public static final DefaultedRegistryReference<ItemType> CLOCK = ItemTypes.key(ResourceKey.sponge("clock"));

    public static final DefaultedRegistryReference<ItemType> COAL = ItemTypes.key(ResourceKey.sponge("coal"));

    public static final DefaultedRegistryReference<ItemType> COAL_BLOCK = ItemTypes.key(ResourceKey.sponge("coal_block"));

    public static final DefaultedRegistryReference<ItemType> COAL_ORE = ItemTypes.key(ResourceKey.sponge("coal_ore"));

    public static final DefaultedRegistryReference<ItemType> COARSE_DIRT = ItemTypes.key(ResourceKey.sponge("coarse_dirt"));

    public static final DefaultedRegistryReference<ItemType> COBBLESTONE = ItemTypes.key(ResourceKey.sponge("cobblestone"));

    public static final DefaultedRegistryReference<ItemType> COBBLESTONE_SLAB = ItemTypes.key(ResourceKey.sponge("cobblestone_slab"));

    public static final DefaultedRegistryReference<ItemType> COBBLESTONE_STAIRS = ItemTypes.key(ResourceKey.sponge("cobblestone_stairs"));

    public static final DefaultedRegistryReference<ItemType> COBBLESTONE_WALL = ItemTypes.key(ResourceKey.sponge("cobblestone_wall"));

    public static final DefaultedRegistryReference<ItemType> COBWEB = ItemTypes.key(ResourceKey.sponge("cobweb"));

    public static final DefaultedRegistryReference<ItemType> COCOA_BEANS = ItemTypes.key(ResourceKey.sponge("cocoa_beans"));

    public static final DefaultedRegistryReference<ItemType> COD = ItemTypes.key(ResourceKey.sponge("cod"));

    public static final DefaultedRegistryReference<ItemType> COD_BUCKET = ItemTypes.key(ResourceKey.sponge("cod_bucket"));

    public static final DefaultedRegistryReference<ItemType> COD_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("cod_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> COMMAND_BLOCK = ItemTypes.key(ResourceKey.sponge("command_block"));

    public static final DefaultedRegistryReference<ItemType> COMMAND_BLOCK_MINECART = ItemTypes.key(ResourceKey.sponge("command_block_minecart"));

    public static final DefaultedRegistryReference<ItemType> COMPARATOR = ItemTypes.key(ResourceKey.sponge("comparator"));

    public static final DefaultedRegistryReference<ItemType> COMPASS = ItemTypes.key(ResourceKey.sponge("compass"));

    public static final DefaultedRegistryReference<ItemType> COMPOSTER = ItemTypes.key(ResourceKey.sponge("composter"));

    public static final DefaultedRegistryReference<ItemType> CONDUIT = ItemTypes.key(ResourceKey.sponge("conduit"));

    public static final DefaultedRegistryReference<ItemType> COOKED_BEEF = ItemTypes.key(ResourceKey.sponge("cooked_beef"));

    public static final DefaultedRegistryReference<ItemType> COOKED_CHICKEN = ItemTypes.key(ResourceKey.sponge("cooked_chicken"));

    public static final DefaultedRegistryReference<ItemType> COOKED_COD = ItemTypes.key(ResourceKey.sponge("cooked_cod"));

    public static final DefaultedRegistryReference<ItemType> COOKED_MUTTON = ItemTypes.key(ResourceKey.sponge("cooked_mutton"));

    public static final DefaultedRegistryReference<ItemType> COOKED_PORKCHOP = ItemTypes.key(ResourceKey.sponge("cooked_porkchop"));

    public static final DefaultedRegistryReference<ItemType> COOKED_RABBIT = ItemTypes.key(ResourceKey.sponge("cooked_rabbit"));

    public static final DefaultedRegistryReference<ItemType> COOKED_SALMON = ItemTypes.key(ResourceKey.sponge("cooked_salmon"));

    public static final DefaultedRegistryReference<ItemType> COOKIE = ItemTypes.key(ResourceKey.sponge("cookie"));

    public static final DefaultedRegistryReference<ItemType> CORNFLOWER = ItemTypes.key(ResourceKey.sponge("cornflower"));

    public static final DefaultedRegistryReference<ItemType> COW_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("cow_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> CRACKED_NETHER_BRICKS = ItemTypes.key(ResourceKey.sponge("cracked_nether_bricks"));

    public static final DefaultedRegistryReference<ItemType> CRACKED_POLISHED_BLACKSTONE_BRICKS = ItemTypes.key(ResourceKey.sponge("cracked_polished_blackstone_bricks"));

    public static final DefaultedRegistryReference<ItemType> CRACKED_STONE_BRICKS = ItemTypes.key(ResourceKey.sponge("cracked_stone_bricks"));

    public static final DefaultedRegistryReference<ItemType> CRAFTING_TABLE = ItemTypes.key(ResourceKey.sponge("crafting_table"));

    public static final DefaultedRegistryReference<ItemType> CREEPER_BANNER_PATTERN = ItemTypes.key(ResourceKey.sponge("creeper_banner_pattern"));

    public static final DefaultedRegistryReference<ItemType> CREEPER_HEAD = ItemTypes.key(ResourceKey.sponge("creeper_head"));

    public static final DefaultedRegistryReference<ItemType> CREEPER_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("creeper_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_BUTTON = ItemTypes.key(ResourceKey.sponge("crimson_button"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_DOOR = ItemTypes.key(ResourceKey.sponge("crimson_door"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_FENCE = ItemTypes.key(ResourceKey.sponge("crimson_fence"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_FENCE_GATE = ItemTypes.key(ResourceKey.sponge("crimson_fence_gate"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_FUNGUS = ItemTypes.key(ResourceKey.sponge("crimson_fungus"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_HYPHAE = ItemTypes.key(ResourceKey.sponge("crimson_hyphae"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_NYLIUM = ItemTypes.key(ResourceKey.sponge("crimson_nylium"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_PLANKS = ItemTypes.key(ResourceKey.sponge("crimson_planks"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_PRESSURE_PLATE = ItemTypes.key(ResourceKey.sponge("crimson_pressure_plate"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_ROOTS = ItemTypes.key(ResourceKey.sponge("crimson_roots"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_SIGN = ItemTypes.key(ResourceKey.sponge("crimson_sign"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_SLAB = ItemTypes.key(ResourceKey.sponge("crimson_slab"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_STAIRS = ItemTypes.key(ResourceKey.sponge("crimson_stairs"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_STEM = ItemTypes.key(ResourceKey.sponge("crimson_stem"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_TRAPDOOR = ItemTypes.key(ResourceKey.sponge("crimson_trapdoor"));

    public static final DefaultedRegistryReference<ItemType> CROSSBOW = ItemTypes.key(ResourceKey.sponge("crossbow"));

    public static final DefaultedRegistryReference<ItemType> CRYING_OBSIDIAN = ItemTypes.key(ResourceKey.sponge("crying_obsidian"));

    public static final DefaultedRegistryReference<ItemType> CUT_RED_SANDSTONE = ItemTypes.key(ResourceKey.sponge("cut_red_sandstone"));

    public static final DefaultedRegistryReference<ItemType> CUT_RED_SANDSTONE_SLAB = ItemTypes.key(ResourceKey.sponge("cut_red_sandstone_slab"));

    public static final DefaultedRegistryReference<ItemType> CUT_SANDSTONE = ItemTypes.key(ResourceKey.sponge("cut_sandstone"));

    public static final DefaultedRegistryReference<ItemType> CUT_SANDSTONE_SLAB = ItemTypes.key(ResourceKey.sponge("cut_sandstone_slab"));

    public static final DefaultedRegistryReference<ItemType> CYAN_BANNER = ItemTypes.key(ResourceKey.sponge("cyan_banner"));

    public static final DefaultedRegistryReference<ItemType> CYAN_BED = ItemTypes.key(ResourceKey.sponge("cyan_bed"));

    public static final DefaultedRegistryReference<ItemType> CYAN_CARPET = ItemTypes.key(ResourceKey.sponge("cyan_carpet"));

    public static final DefaultedRegistryReference<ItemType> CYAN_CONCRETE = ItemTypes.key(ResourceKey.sponge("cyan_concrete"));

    public static final DefaultedRegistryReference<ItemType> CYAN_CONCRETE_POWDER = ItemTypes.key(ResourceKey.sponge("cyan_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> CYAN_DYE = ItemTypes.key(ResourceKey.sponge("cyan_dye"));

    public static final DefaultedRegistryReference<ItemType> CYAN_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("cyan_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> CYAN_SHULKER_BOX = ItemTypes.key(ResourceKey.sponge("cyan_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> CYAN_STAINED_GLASS = ItemTypes.key(ResourceKey.sponge("cyan_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> CYAN_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.sponge("cyan_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> CYAN_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("cyan_terracotta"));

    public static final DefaultedRegistryReference<ItemType> CYAN_WOOL = ItemTypes.key(ResourceKey.sponge("cyan_wool"));

    public static final DefaultedRegistryReference<ItemType> DAMAGED_ANVIL = ItemTypes.key(ResourceKey.sponge("damaged_anvil"));

    public static final DefaultedRegistryReference<ItemType> DANDELION = ItemTypes.key(ResourceKey.sponge("dandelion"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_BOAT = ItemTypes.key(ResourceKey.sponge("dark_oak_boat"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_BUTTON = ItemTypes.key(ResourceKey.sponge("dark_oak_button"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_DOOR = ItemTypes.key(ResourceKey.sponge("dark_oak_door"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_FENCE = ItemTypes.key(ResourceKey.sponge("dark_oak_fence"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_FENCE_GATE = ItemTypes.key(ResourceKey.sponge("dark_oak_fence_gate"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_LEAVES = ItemTypes.key(ResourceKey.sponge("dark_oak_leaves"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_LOG = ItemTypes.key(ResourceKey.sponge("dark_oak_log"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_PLANKS = ItemTypes.key(ResourceKey.sponge("dark_oak_planks"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_PRESSURE_PLATE = ItemTypes.key(ResourceKey.sponge("dark_oak_pressure_plate"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_SAPLING = ItemTypes.key(ResourceKey.sponge("dark_oak_sapling"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_SIGN = ItemTypes.key(ResourceKey.sponge("dark_oak_sign"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_SLAB = ItemTypes.key(ResourceKey.sponge("dark_oak_slab"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_STAIRS = ItemTypes.key(ResourceKey.sponge("dark_oak_stairs"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_TRAPDOOR = ItemTypes.key(ResourceKey.sponge("dark_oak_trapdoor"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_WOOD = ItemTypes.key(ResourceKey.sponge("dark_oak_wood"));

    public static final DefaultedRegistryReference<ItemType> DARK_PRISMARINE = ItemTypes.key(ResourceKey.sponge("dark_prismarine"));

    public static final DefaultedRegistryReference<ItemType> DARK_PRISMARINE_SLAB = ItemTypes.key(ResourceKey.sponge("dark_prismarine_slab"));

    public static final DefaultedRegistryReference<ItemType> DARK_PRISMARINE_STAIRS = ItemTypes.key(ResourceKey.sponge("dark_prismarine_stairs"));

    public static final DefaultedRegistryReference<ItemType> DAYLIGHT_DETECTOR = ItemTypes.key(ResourceKey.sponge("daylight_detector"));

    public static final DefaultedRegistryReference<ItemType> DEAD_BRAIN_CORAL = ItemTypes.key(ResourceKey.sponge("dead_brain_coral"));

    public static final DefaultedRegistryReference<ItemType> DEAD_BRAIN_CORAL_BLOCK = ItemTypes.key(ResourceKey.sponge("dead_brain_coral_block"));

    public static final DefaultedRegistryReference<ItemType> DEAD_BRAIN_CORAL_FAN = ItemTypes.key(ResourceKey.sponge("dead_brain_coral_fan"));

    public static final DefaultedRegistryReference<ItemType> DEAD_BUBBLE_CORAL = ItemTypes.key(ResourceKey.sponge("dead_bubble_coral"));

    public static final DefaultedRegistryReference<ItemType> DEAD_BUBBLE_CORAL_BLOCK = ItemTypes.key(ResourceKey.sponge("dead_bubble_coral_block"));

    public static final DefaultedRegistryReference<ItemType> DEAD_BUBBLE_CORAL_FAN = ItemTypes.key(ResourceKey.sponge("dead_bubble_coral_fan"));

    public static final DefaultedRegistryReference<ItemType> DEAD_BUSH = ItemTypes.key(ResourceKey.sponge("dead_bush"));

    public static final DefaultedRegistryReference<ItemType> DEAD_FIRE_CORAL = ItemTypes.key(ResourceKey.sponge("dead_fire_coral"));

    public static final DefaultedRegistryReference<ItemType> DEAD_FIRE_CORAL_BLOCK = ItemTypes.key(ResourceKey.sponge("dead_fire_coral_block"));

    public static final DefaultedRegistryReference<ItemType> DEAD_FIRE_CORAL_FAN = ItemTypes.key(ResourceKey.sponge("dead_fire_coral_fan"));

    public static final DefaultedRegistryReference<ItemType> DEAD_HORN_CORAL = ItemTypes.key(ResourceKey.sponge("dead_horn_coral"));

    public static final DefaultedRegistryReference<ItemType> DEAD_HORN_CORAL_BLOCK = ItemTypes.key(ResourceKey.sponge("dead_horn_coral_block"));

    public static final DefaultedRegistryReference<ItemType> DEAD_HORN_CORAL_FAN = ItemTypes.key(ResourceKey.sponge("dead_horn_coral_fan"));

    public static final DefaultedRegistryReference<ItemType> DEAD_TUBE_CORAL = ItemTypes.key(ResourceKey.sponge("dead_tube_coral"));

    public static final DefaultedRegistryReference<ItemType> DEAD_TUBE_CORAL_BLOCK = ItemTypes.key(ResourceKey.sponge("dead_tube_coral_block"));

    public static final DefaultedRegistryReference<ItemType> DEAD_TUBE_CORAL_FAN = ItemTypes.key(ResourceKey.sponge("dead_tube_coral_fan"));

    public static final DefaultedRegistryReference<ItemType> DEBUG_STICK = ItemTypes.key(ResourceKey.sponge("debug_stick"));

    public static final DefaultedRegistryReference<ItemType> DETECTOR_RAIL = ItemTypes.key(ResourceKey.sponge("detector_rail"));

    public static final DefaultedRegistryReference<ItemType> DIAMOND = ItemTypes.key(ResourceKey.sponge("diamond"));

    public static final DefaultedRegistryReference<ItemType> DIAMOND_AXE = ItemTypes.key(ResourceKey.sponge("diamond_axe"));

    public static final DefaultedRegistryReference<ItemType> DIAMOND_BLOCK = ItemTypes.key(ResourceKey.sponge("diamond_block"));

    public static final DefaultedRegistryReference<ItemType> DIAMOND_BOOTS = ItemTypes.key(ResourceKey.sponge("diamond_boots"));

    public static final DefaultedRegistryReference<ItemType> DIAMOND_CHESTPLATE = ItemTypes.key(ResourceKey.sponge("diamond_chestplate"));

    public static final DefaultedRegistryReference<ItemType> DIAMOND_HELMET = ItemTypes.key(ResourceKey.sponge("diamond_helmet"));

    public static final DefaultedRegistryReference<ItemType> DIAMOND_HOE = ItemTypes.key(ResourceKey.sponge("diamond_hoe"));

    public static final DefaultedRegistryReference<ItemType> DIAMOND_HORSE_ARMOR = ItemTypes.key(ResourceKey.sponge("diamond_horse_armor"));

    public static final DefaultedRegistryReference<ItemType> DIAMOND_LEGGINGS = ItemTypes.key(ResourceKey.sponge("diamond_leggings"));

    public static final DefaultedRegistryReference<ItemType> DIAMOND_ORE = ItemTypes.key(ResourceKey.sponge("diamond_ore"));

    public static final DefaultedRegistryReference<ItemType> DIAMOND_PICKAXE = ItemTypes.key(ResourceKey.sponge("diamond_pickaxe"));

    public static final DefaultedRegistryReference<ItemType> DIAMOND_SHOVEL = ItemTypes.key(ResourceKey.sponge("diamond_shovel"));

    public static final DefaultedRegistryReference<ItemType> DIAMOND_SWORD = ItemTypes.key(ResourceKey.sponge("diamond_sword"));

    public static final DefaultedRegistryReference<ItemType> DIORITE = ItemTypes.key(ResourceKey.sponge("diorite"));

    public static final DefaultedRegistryReference<ItemType> DIORITE_SLAB = ItemTypes.key(ResourceKey.sponge("diorite_slab"));

    public static final DefaultedRegistryReference<ItemType> DIORITE_STAIRS = ItemTypes.key(ResourceKey.sponge("diorite_stairs"));

    public static final DefaultedRegistryReference<ItemType> DIORITE_WALL = ItemTypes.key(ResourceKey.sponge("diorite_wall"));

    public static final DefaultedRegistryReference<ItemType> DIRT = ItemTypes.key(ResourceKey.sponge("dirt"));

    public static final DefaultedRegistryReference<ItemType> DISPENSER = ItemTypes.key(ResourceKey.sponge("dispenser"));

    public static final DefaultedRegistryReference<ItemType> DOLPHIN_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("dolphin_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> DONKEY_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("donkey_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> DRAGON_BREATH = ItemTypes.key(ResourceKey.sponge("dragon_breath"));

    public static final DefaultedRegistryReference<ItemType> DRAGON_EGG = ItemTypes.key(ResourceKey.sponge("dragon_egg"));

    public static final DefaultedRegistryReference<ItemType> DRAGON_HEAD = ItemTypes.key(ResourceKey.sponge("dragon_head"));

    public static final DefaultedRegistryReference<ItemType> DRIED_KELP = ItemTypes.key(ResourceKey.sponge("dried_kelp"));

    public static final DefaultedRegistryReference<ItemType> DRIED_KELP_BLOCK = ItemTypes.key(ResourceKey.sponge("dried_kelp_block"));

    public static final DefaultedRegistryReference<ItemType> DROPPER = ItemTypes.key(ResourceKey.sponge("dropper"));

    public static final DefaultedRegistryReference<ItemType> DROWNED_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("drowned_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> EGG = ItemTypes.key(ResourceKey.sponge("egg"));

    public static final DefaultedRegistryReference<ItemType> ELDER_GUARDIAN_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("elder_guardian_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> ELYTRA = ItemTypes.key(ResourceKey.sponge("elytra"));

    public static final DefaultedRegistryReference<ItemType> EMERALD = ItemTypes.key(ResourceKey.sponge("emerald"));

    public static final DefaultedRegistryReference<ItemType> EMERALD_BLOCK = ItemTypes.key(ResourceKey.sponge("emerald_block"));

    public static final DefaultedRegistryReference<ItemType> EMERALD_ORE = ItemTypes.key(ResourceKey.sponge("emerald_ore"));

    public static final DefaultedRegistryReference<ItemType> ENCHANTED_BOOK = ItemTypes.key(ResourceKey.sponge("enchanted_book"));

    public static final DefaultedRegistryReference<ItemType> ENCHANTED_GOLDEN_APPLE = ItemTypes.key(ResourceKey.sponge("enchanted_golden_apple"));

    public static final DefaultedRegistryReference<ItemType> ENCHANTING_TABLE = ItemTypes.key(ResourceKey.sponge("enchanting_table"));

    public static final DefaultedRegistryReference<ItemType> END_CRYSTAL = ItemTypes.key(ResourceKey.sponge("end_crystal"));

    public static final DefaultedRegistryReference<ItemType> END_PORTAL_FRAME = ItemTypes.key(ResourceKey.sponge("end_portal_frame"));

    public static final DefaultedRegistryReference<ItemType> END_ROD = ItemTypes.key(ResourceKey.sponge("end_rod"));

    public static final DefaultedRegistryReference<ItemType> END_STONE = ItemTypes.key(ResourceKey.sponge("end_stone"));

    public static final DefaultedRegistryReference<ItemType> END_STONE_BRICK_SLAB = ItemTypes.key(ResourceKey.sponge("end_stone_brick_slab"));

    public static final DefaultedRegistryReference<ItemType> END_STONE_BRICK_STAIRS = ItemTypes.key(ResourceKey.sponge("end_stone_brick_stairs"));

    public static final DefaultedRegistryReference<ItemType> END_STONE_BRICK_WALL = ItemTypes.key(ResourceKey.sponge("end_stone_brick_wall"));

    public static final DefaultedRegistryReference<ItemType> END_STONE_BRICKS = ItemTypes.key(ResourceKey.sponge("end_stone_bricks"));

    public static final DefaultedRegistryReference<ItemType> ENDER_CHEST = ItemTypes.key(ResourceKey.sponge("ender_chest"));

    public static final DefaultedRegistryReference<ItemType> ENDER_EYE = ItemTypes.key(ResourceKey.sponge("ender_eye"));

    public static final DefaultedRegistryReference<ItemType> ENDER_PEARL = ItemTypes.key(ResourceKey.sponge("ender_pearl"));

    public static final DefaultedRegistryReference<ItemType> ENDERMAN_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("enderman_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> ENDERMITE_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("endermite_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> EVOKER_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("evoker_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> EXPERIENCE_BOTTLE = ItemTypes.key(ResourceKey.sponge("experience_bottle"));

    public static final DefaultedRegistryReference<ItemType> FARMLAND = ItemTypes.key(ResourceKey.sponge("farmland"));

    public static final DefaultedRegistryReference<ItemType> FEATHER = ItemTypes.key(ResourceKey.sponge("feather"));

    public static final DefaultedRegistryReference<ItemType> FERMENTED_SPIDER_EYE = ItemTypes.key(ResourceKey.sponge("fermented_spider_eye"));

    public static final DefaultedRegistryReference<ItemType> FERN = ItemTypes.key(ResourceKey.sponge("fern"));

    public static final DefaultedRegistryReference<ItemType> FILLED_MAP = ItemTypes.key(ResourceKey.sponge("filled_map"));

    public static final DefaultedRegistryReference<ItemType> FIRE_CHARGE = ItemTypes.key(ResourceKey.sponge("fire_charge"));

    public static final DefaultedRegistryReference<ItemType> FIRE_CORAL = ItemTypes.key(ResourceKey.sponge("fire_coral"));

    public static final DefaultedRegistryReference<ItemType> FIRE_CORAL_BLOCK = ItemTypes.key(ResourceKey.sponge("fire_coral_block"));

    public static final DefaultedRegistryReference<ItemType> FIRE_CORAL_FAN = ItemTypes.key(ResourceKey.sponge("fire_coral_fan"));

    public static final DefaultedRegistryReference<ItemType> FIREWORK_ROCKET = ItemTypes.key(ResourceKey.sponge("firework_rocket"));

    public static final DefaultedRegistryReference<ItemType> FIREWORK_STAR = ItemTypes.key(ResourceKey.sponge("firework_star"));

    public static final DefaultedRegistryReference<ItemType> FISHING_ROD = ItemTypes.key(ResourceKey.sponge("fishing_rod"));

    public static final DefaultedRegistryReference<ItemType> FLETCHING_TABLE = ItemTypes.key(ResourceKey.sponge("fletching_table"));

    public static final DefaultedRegistryReference<ItemType> FLINT = ItemTypes.key(ResourceKey.sponge("flint"));

    public static final DefaultedRegistryReference<ItemType> FLINT_AND_STEEL = ItemTypes.key(ResourceKey.sponge("flint_and_steel"));

    public static final DefaultedRegistryReference<ItemType> FLOWER_BANNER_PATTERN = ItemTypes.key(ResourceKey.sponge("flower_banner_pattern"));

    public static final DefaultedRegistryReference<ItemType> FLOWER_POT = ItemTypes.key(ResourceKey.sponge("flower_pot"));

    public static final DefaultedRegistryReference<ItemType> FOX_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("fox_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> FURNACE = ItemTypes.key(ResourceKey.sponge("furnace"));

    public static final DefaultedRegistryReference<ItemType> FURNACE_MINECART = ItemTypes.key(ResourceKey.sponge("furnace_minecart"));

    public static final DefaultedRegistryReference<ItemType> GHAST_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("ghast_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> GHAST_TEAR = ItemTypes.key(ResourceKey.sponge("ghast_tear"));

    public static final DefaultedRegistryReference<ItemType> GILDED_BLACKSTONE = ItemTypes.key(ResourceKey.sponge("gilded_blackstone"));

    public static final DefaultedRegistryReference<ItemType> GLASS = ItemTypes.key(ResourceKey.sponge("glass"));

    public static final DefaultedRegistryReference<ItemType> GLASS_BOTTLE = ItemTypes.key(ResourceKey.sponge("glass_bottle"));

    public static final DefaultedRegistryReference<ItemType> GLASS_PANE = ItemTypes.key(ResourceKey.sponge("glass_pane"));

    public static final DefaultedRegistryReference<ItemType> GLISTERING_MELON_SLICE = ItemTypes.key(ResourceKey.sponge("glistering_melon_slice"));

    public static final DefaultedRegistryReference<ItemType> GLOBE_BANNER_PATTERN = ItemTypes.key(ResourceKey.sponge("globe_banner_pattern"));

    public static final DefaultedRegistryReference<ItemType> GLOWSTONE = ItemTypes.key(ResourceKey.sponge("glowstone"));

    public static final DefaultedRegistryReference<ItemType> GLOWSTONE_DUST = ItemTypes.key(ResourceKey.sponge("glowstone_dust"));

    public static final DefaultedRegistryReference<ItemType> GOLD_BLOCK = ItemTypes.key(ResourceKey.sponge("gold_block"));

    public static final DefaultedRegistryReference<ItemType> GOLD_INGOT = ItemTypes.key(ResourceKey.sponge("gold_ingot"));

    public static final DefaultedRegistryReference<ItemType> GOLD_NUGGET = ItemTypes.key(ResourceKey.sponge("gold_nugget"));

    public static final DefaultedRegistryReference<ItemType> GOLD_ORE = ItemTypes.key(ResourceKey.sponge("gold_ore"));

    public static final DefaultedRegistryReference<ItemType> GOLDEN_APPLE = ItemTypes.key(ResourceKey.sponge("golden_apple"));

    public static final DefaultedRegistryReference<ItemType> GOLDEN_AXE = ItemTypes.key(ResourceKey.sponge("golden_axe"));

    public static final DefaultedRegistryReference<ItemType> GOLDEN_BOOTS = ItemTypes.key(ResourceKey.sponge("golden_boots"));

    public static final DefaultedRegistryReference<ItemType> GOLDEN_CARROT = ItemTypes.key(ResourceKey.sponge("golden_carrot"));

    public static final DefaultedRegistryReference<ItemType> GOLDEN_CHESTPLATE = ItemTypes.key(ResourceKey.sponge("golden_chestplate"));

    public static final DefaultedRegistryReference<ItemType> GOLDEN_HELMET = ItemTypes.key(ResourceKey.sponge("golden_helmet"));

    public static final DefaultedRegistryReference<ItemType> GOLDEN_HOE = ItemTypes.key(ResourceKey.sponge("golden_hoe"));

    public static final DefaultedRegistryReference<ItemType> GOLDEN_HORSE_ARMOR = ItemTypes.key(ResourceKey.sponge("golden_horse_armor"));

    public static final DefaultedRegistryReference<ItemType> GOLDEN_LEGGINGS = ItemTypes.key(ResourceKey.sponge("golden_leggings"));

    public static final DefaultedRegistryReference<ItemType> GOLDEN_PICKAXE = ItemTypes.key(ResourceKey.sponge("golden_pickaxe"));

    public static final DefaultedRegistryReference<ItemType> GOLDEN_SHOVEL = ItemTypes.key(ResourceKey.sponge("golden_shovel"));

    public static final DefaultedRegistryReference<ItemType> GOLDEN_SWORD = ItemTypes.key(ResourceKey.sponge("golden_sword"));

    public static final DefaultedRegistryReference<ItemType> GRANITE = ItemTypes.key(ResourceKey.sponge("granite"));

    public static final DefaultedRegistryReference<ItemType> GRANITE_SLAB = ItemTypes.key(ResourceKey.sponge("granite_slab"));

    public static final DefaultedRegistryReference<ItemType> GRANITE_STAIRS = ItemTypes.key(ResourceKey.sponge("granite_stairs"));

    public static final DefaultedRegistryReference<ItemType> GRANITE_WALL = ItemTypes.key(ResourceKey.sponge("granite_wall"));

    public static final DefaultedRegistryReference<ItemType> GRASS = ItemTypes.key(ResourceKey.sponge("grass"));

    public static final DefaultedRegistryReference<ItemType> GRASS_BLOCK = ItemTypes.key(ResourceKey.sponge("grass_block"));

    public static final DefaultedRegistryReference<ItemType> GRASS_PATH = ItemTypes.key(ResourceKey.sponge("grass_path"));

    public static final DefaultedRegistryReference<ItemType> GRAVEL = ItemTypes.key(ResourceKey.sponge("gravel"));

    public static final DefaultedRegistryReference<ItemType> GRAY_BANNER = ItemTypes.key(ResourceKey.sponge("gray_banner"));

    public static final DefaultedRegistryReference<ItemType> GRAY_BED = ItemTypes.key(ResourceKey.sponge("gray_bed"));

    public static final DefaultedRegistryReference<ItemType> GRAY_CARPET = ItemTypes.key(ResourceKey.sponge("gray_carpet"));

    public static final DefaultedRegistryReference<ItemType> GRAY_CONCRETE = ItemTypes.key(ResourceKey.sponge("gray_concrete"));

    public static final DefaultedRegistryReference<ItemType> GRAY_CONCRETE_POWDER = ItemTypes.key(ResourceKey.sponge("gray_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> GRAY_DYE = ItemTypes.key(ResourceKey.sponge("gray_dye"));

    public static final DefaultedRegistryReference<ItemType> GRAY_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("gray_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> GRAY_SHULKER_BOX = ItemTypes.key(ResourceKey.sponge("gray_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> GRAY_STAINED_GLASS = ItemTypes.key(ResourceKey.sponge("gray_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> GRAY_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.sponge("gray_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> GRAY_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("gray_terracotta"));

    public static final DefaultedRegistryReference<ItemType> GRAY_WOOL = ItemTypes.key(ResourceKey.sponge("gray_wool"));

    public static final DefaultedRegistryReference<ItemType> GREEN_BANNER = ItemTypes.key(ResourceKey.sponge("green_banner"));

    public static final DefaultedRegistryReference<ItemType> GREEN_BED = ItemTypes.key(ResourceKey.sponge("green_bed"));

    public static final DefaultedRegistryReference<ItemType> GREEN_CARPET = ItemTypes.key(ResourceKey.sponge("green_carpet"));

    public static final DefaultedRegistryReference<ItemType> GREEN_CONCRETE = ItemTypes.key(ResourceKey.sponge("green_concrete"));

    public static final DefaultedRegistryReference<ItemType> GREEN_CONCRETE_POWDER = ItemTypes.key(ResourceKey.sponge("green_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> GREEN_DYE = ItemTypes.key(ResourceKey.sponge("green_dye"));

    public static final DefaultedRegistryReference<ItemType> GREEN_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("green_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> GREEN_SHULKER_BOX = ItemTypes.key(ResourceKey.sponge("green_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> GREEN_STAINED_GLASS = ItemTypes.key(ResourceKey.sponge("green_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> GREEN_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.sponge("green_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> GREEN_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("green_terracotta"));

    public static final DefaultedRegistryReference<ItemType> GREEN_WOOL = ItemTypes.key(ResourceKey.sponge("green_wool"));

    public static final DefaultedRegistryReference<ItemType> GRINDSTONE = ItemTypes.key(ResourceKey.sponge("grindstone"));

    public static final DefaultedRegistryReference<ItemType> GUARDIAN_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("guardian_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> GUNPOWDER = ItemTypes.key(ResourceKey.sponge("gunpowder"));

    public static final DefaultedRegistryReference<ItemType> HAY_BLOCK = ItemTypes.key(ResourceKey.sponge("hay_block"));

    public static final DefaultedRegistryReference<ItemType> HEART_OF_THE_SEA = ItemTypes.key(ResourceKey.sponge("heart_of_the_sea"));

    public static final DefaultedRegistryReference<ItemType> HEAVY_WEIGHTED_PRESSURE_PLATE = ItemTypes.key(ResourceKey.sponge("heavy_weighted_pressure_plate"));

    public static final DefaultedRegistryReference<ItemType> HOGLIN_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("hoglin_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> HONEY_BLOCK = ItemTypes.key(ResourceKey.sponge("honey_block"));

    public static final DefaultedRegistryReference<ItemType> HONEY_BOTTLE = ItemTypes.key(ResourceKey.sponge("honey_bottle"));

    public static final DefaultedRegistryReference<ItemType> HONEYCOMB = ItemTypes.key(ResourceKey.sponge("honeycomb"));

    public static final DefaultedRegistryReference<ItemType> HONEYCOMB_BLOCK = ItemTypes.key(ResourceKey.sponge("honeycomb_block"));

    public static final DefaultedRegistryReference<ItemType> HOPPER = ItemTypes.key(ResourceKey.sponge("hopper"));

    public static final DefaultedRegistryReference<ItemType> HOPPER_MINECART = ItemTypes.key(ResourceKey.sponge("hopper_minecart"));

    public static final DefaultedRegistryReference<ItemType> HORN_CORAL = ItemTypes.key(ResourceKey.sponge("horn_coral"));

    public static final DefaultedRegistryReference<ItemType> HORN_CORAL_BLOCK = ItemTypes.key(ResourceKey.sponge("horn_coral_block"));

    public static final DefaultedRegistryReference<ItemType> HORN_CORAL_FAN = ItemTypes.key(ResourceKey.sponge("horn_coral_fan"));

    public static final DefaultedRegistryReference<ItemType> HORSE_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("horse_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> HUSK_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("husk_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> ICE = ItemTypes.key(ResourceKey.sponge("ice"));

    public static final DefaultedRegistryReference<ItemType> INFESTED_CHISELED_STONE_BRICKS = ItemTypes.key(ResourceKey.sponge("infested_chiseled_stone_bricks"));

    public static final DefaultedRegistryReference<ItemType> INFESTED_COBBLESTONE = ItemTypes.key(ResourceKey.sponge("infested_cobblestone"));

    public static final DefaultedRegistryReference<ItemType> INFESTED_CRACKED_STONE_BRICKS = ItemTypes.key(ResourceKey.sponge("infested_cracked_stone_bricks"));

    public static final DefaultedRegistryReference<ItemType> INFESTED_MOSSY_STONE_BRICKS = ItemTypes.key(ResourceKey.sponge("infested_mossy_stone_bricks"));

    public static final DefaultedRegistryReference<ItemType> INFESTED_STONE = ItemTypes.key(ResourceKey.sponge("infested_stone"));

    public static final DefaultedRegistryReference<ItemType> INFESTED_STONE_BRICKS = ItemTypes.key(ResourceKey.sponge("infested_stone_bricks"));

    public static final DefaultedRegistryReference<ItemType> INK_SAC = ItemTypes.key(ResourceKey.sponge("ink_sac"));

    public static final DefaultedRegistryReference<ItemType> IRON_AXE = ItemTypes.key(ResourceKey.sponge("iron_axe"));

    public static final DefaultedRegistryReference<ItemType> IRON_BARS = ItemTypes.key(ResourceKey.sponge("iron_bars"));

    public static final DefaultedRegistryReference<ItemType> IRON_BLOCK = ItemTypes.key(ResourceKey.sponge("iron_block"));

    public static final DefaultedRegistryReference<ItemType> IRON_BOOTS = ItemTypes.key(ResourceKey.sponge("iron_boots"));

    public static final DefaultedRegistryReference<ItemType> IRON_CHESTPLATE = ItemTypes.key(ResourceKey.sponge("iron_chestplate"));

    public static final DefaultedRegistryReference<ItemType> IRON_DOOR = ItemTypes.key(ResourceKey.sponge("iron_door"));

    public static final DefaultedRegistryReference<ItemType> IRON_HELMET = ItemTypes.key(ResourceKey.sponge("iron_helmet"));

    public static final DefaultedRegistryReference<ItemType> IRON_HOE = ItemTypes.key(ResourceKey.sponge("iron_hoe"));

    public static final DefaultedRegistryReference<ItemType> IRON_HORSE_ARMOR = ItemTypes.key(ResourceKey.sponge("iron_horse_armor"));

    public static final DefaultedRegistryReference<ItemType> IRON_INGOT = ItemTypes.key(ResourceKey.sponge("iron_ingot"));

    public static final DefaultedRegistryReference<ItemType> IRON_LEGGINGS = ItemTypes.key(ResourceKey.sponge("iron_leggings"));

    public static final DefaultedRegistryReference<ItemType> IRON_NUGGET = ItemTypes.key(ResourceKey.sponge("iron_nugget"));

    public static final DefaultedRegistryReference<ItemType> IRON_ORE = ItemTypes.key(ResourceKey.sponge("iron_ore"));

    public static final DefaultedRegistryReference<ItemType> IRON_PICKAXE = ItemTypes.key(ResourceKey.sponge("iron_pickaxe"));

    public static final DefaultedRegistryReference<ItemType> IRON_SHOVEL = ItemTypes.key(ResourceKey.sponge("iron_shovel"));

    public static final DefaultedRegistryReference<ItemType> IRON_SWORD = ItemTypes.key(ResourceKey.sponge("iron_sword"));

    public static final DefaultedRegistryReference<ItemType> IRON_TRAPDOOR = ItemTypes.key(ResourceKey.sponge("iron_trapdoor"));

    public static final DefaultedRegistryReference<ItemType> ITEM_FRAME = ItemTypes.key(ResourceKey.sponge("item_frame"));

    public static final DefaultedRegistryReference<ItemType> JACK_O_LANTERN = ItemTypes.key(ResourceKey.sponge("jack_o_lantern"));

    public static final DefaultedRegistryReference<ItemType> JIGSAW = ItemTypes.key(ResourceKey.sponge("jigsaw"));

    public static final DefaultedRegistryReference<ItemType> JUKEBOX = ItemTypes.key(ResourceKey.sponge("jukebox"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_BOAT = ItemTypes.key(ResourceKey.sponge("jungle_boat"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_BUTTON = ItemTypes.key(ResourceKey.sponge("jungle_button"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_DOOR = ItemTypes.key(ResourceKey.sponge("jungle_door"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_FENCE = ItemTypes.key(ResourceKey.sponge("jungle_fence"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_FENCE_GATE = ItemTypes.key(ResourceKey.sponge("jungle_fence_gate"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_LEAVES = ItemTypes.key(ResourceKey.sponge("jungle_leaves"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_LOG = ItemTypes.key(ResourceKey.sponge("jungle_log"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_PLANKS = ItemTypes.key(ResourceKey.sponge("jungle_planks"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_PRESSURE_PLATE = ItemTypes.key(ResourceKey.sponge("jungle_pressure_plate"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_SAPLING = ItemTypes.key(ResourceKey.sponge("jungle_sapling"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_SIGN = ItemTypes.key(ResourceKey.sponge("jungle_sign"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_SLAB = ItemTypes.key(ResourceKey.sponge("jungle_slab"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_STAIRS = ItemTypes.key(ResourceKey.sponge("jungle_stairs"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_TRAPDOOR = ItemTypes.key(ResourceKey.sponge("jungle_trapdoor"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_WOOD = ItemTypes.key(ResourceKey.sponge("jungle_wood"));

    public static final DefaultedRegistryReference<ItemType> KELP = ItemTypes.key(ResourceKey.sponge("kelp"));

    public static final DefaultedRegistryReference<ItemType> KNOWLEDGE_BOOK = ItemTypes.key(ResourceKey.sponge("knowledge_book"));

    public static final DefaultedRegistryReference<ItemType> LADDER = ItemTypes.key(ResourceKey.sponge("ladder"));

    public static final DefaultedRegistryReference<ItemType> LANTERN = ItemTypes.key(ResourceKey.sponge("lantern"));

    public static final DefaultedRegistryReference<ItemType> LAPIS_BLOCK = ItemTypes.key(ResourceKey.sponge("lapis_block"));

    public static final DefaultedRegistryReference<ItemType> LAPIS_LAZULI = ItemTypes.key(ResourceKey.sponge("lapis_lazuli"));

    public static final DefaultedRegistryReference<ItemType> LAPIS_ORE = ItemTypes.key(ResourceKey.sponge("lapis_ore"));

    public static final DefaultedRegistryReference<ItemType> LARGE_FERN = ItemTypes.key(ResourceKey.sponge("large_fern"));

    public static final DefaultedRegistryReference<ItemType> LAVA_BUCKET = ItemTypes.key(ResourceKey.sponge("lava_bucket"));

    public static final DefaultedRegistryReference<ItemType> LEAD = ItemTypes.key(ResourceKey.sponge("lead"));

    public static final DefaultedRegistryReference<ItemType> LEATHER = ItemTypes.key(ResourceKey.sponge("leather"));

    public static final DefaultedRegistryReference<ItemType> LEATHER_BOOTS = ItemTypes.key(ResourceKey.sponge("leather_boots"));

    public static final DefaultedRegistryReference<ItemType> LEATHER_CHESTPLATE = ItemTypes.key(ResourceKey.sponge("leather_chestplate"));

    public static final DefaultedRegistryReference<ItemType> LEATHER_HELMET = ItemTypes.key(ResourceKey.sponge("leather_helmet"));

    public static final DefaultedRegistryReference<ItemType> LEATHER_HORSE_ARMOR = ItemTypes.key(ResourceKey.sponge("leather_horse_armor"));

    public static final DefaultedRegistryReference<ItemType> LEATHER_LEGGINGS = ItemTypes.key(ResourceKey.sponge("leather_leggings"));

    public static final DefaultedRegistryReference<ItemType> LECTERN = ItemTypes.key(ResourceKey.sponge("lectern"));

    public static final DefaultedRegistryReference<ItemType> LEVER = ItemTypes.key(ResourceKey.sponge("lever"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_BLUE_BANNER = ItemTypes.key(ResourceKey.sponge("light_blue_banner"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_BLUE_BED = ItemTypes.key(ResourceKey.sponge("light_blue_bed"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_BLUE_CARPET = ItemTypes.key(ResourceKey.sponge("light_blue_carpet"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_BLUE_CONCRETE = ItemTypes.key(ResourceKey.sponge("light_blue_concrete"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_BLUE_CONCRETE_POWDER = ItemTypes.key(ResourceKey.sponge("light_blue_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_BLUE_DYE = ItemTypes.key(ResourceKey.sponge("light_blue_dye"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_BLUE_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("light_blue_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_BLUE_SHULKER_BOX = ItemTypes.key(ResourceKey.sponge("light_blue_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_BLUE_STAINED_GLASS = ItemTypes.key(ResourceKey.sponge("light_blue_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_BLUE_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.sponge("light_blue_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_BLUE_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("light_blue_terracotta"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_BLUE_WOOL = ItemTypes.key(ResourceKey.sponge("light_blue_wool"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_GRAY_BANNER = ItemTypes.key(ResourceKey.sponge("light_gray_banner"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_GRAY_BED = ItemTypes.key(ResourceKey.sponge("light_gray_bed"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_GRAY_CARPET = ItemTypes.key(ResourceKey.sponge("light_gray_carpet"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_GRAY_CONCRETE = ItemTypes.key(ResourceKey.sponge("light_gray_concrete"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_GRAY_CONCRETE_POWDER = ItemTypes.key(ResourceKey.sponge("light_gray_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_GRAY_DYE = ItemTypes.key(ResourceKey.sponge("light_gray_dye"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_GRAY_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("light_gray_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_GRAY_SHULKER_BOX = ItemTypes.key(ResourceKey.sponge("light_gray_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_GRAY_STAINED_GLASS = ItemTypes.key(ResourceKey.sponge("light_gray_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_GRAY_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.sponge("light_gray_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_GRAY_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("light_gray_terracotta"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_GRAY_WOOL = ItemTypes.key(ResourceKey.sponge("light_gray_wool"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_WEIGHTED_PRESSURE_PLATE = ItemTypes.key(ResourceKey.sponge("light_weighted_pressure_plate"));

    public static final DefaultedRegistryReference<ItemType> LILAC = ItemTypes.key(ResourceKey.sponge("lilac"));

    public static final DefaultedRegistryReference<ItemType> LILY_OF_THE_VALLEY = ItemTypes.key(ResourceKey.sponge("lily_of_the_valley"));

    public static final DefaultedRegistryReference<ItemType> LILY_PAD = ItemTypes.key(ResourceKey.sponge("lily_pad"));

    public static final DefaultedRegistryReference<ItemType> LIME_BANNER = ItemTypes.key(ResourceKey.sponge("lime_banner"));

    public static final DefaultedRegistryReference<ItemType> LIME_BED = ItemTypes.key(ResourceKey.sponge("lime_bed"));

    public static final DefaultedRegistryReference<ItemType> LIME_CARPET = ItemTypes.key(ResourceKey.sponge("lime_carpet"));

    public static final DefaultedRegistryReference<ItemType> LIME_CONCRETE = ItemTypes.key(ResourceKey.sponge("lime_concrete"));

    public static final DefaultedRegistryReference<ItemType> LIME_CONCRETE_POWDER = ItemTypes.key(ResourceKey.sponge("lime_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> LIME_DYE = ItemTypes.key(ResourceKey.sponge("lime_dye"));

    public static final DefaultedRegistryReference<ItemType> LIME_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("lime_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> LIME_SHULKER_BOX = ItemTypes.key(ResourceKey.sponge("lime_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> LIME_STAINED_GLASS = ItemTypes.key(ResourceKey.sponge("lime_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> LIME_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.sponge("lime_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> LIME_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("lime_terracotta"));

    public static final DefaultedRegistryReference<ItemType> LIME_WOOL = ItemTypes.key(ResourceKey.sponge("lime_wool"));

    public static final DefaultedRegistryReference<ItemType> LINGERING_POTION = ItemTypes.key(ResourceKey.sponge("lingering_potion"));

    public static final DefaultedRegistryReference<ItemType> LLAMA_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("llama_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> LODESTONE = ItemTypes.key(ResourceKey.sponge("lodestone"));

    public static final DefaultedRegistryReference<ItemType> LOOM = ItemTypes.key(ResourceKey.sponge("loom"));

    public static final DefaultedRegistryReference<ItemType> MAGENTA_BANNER = ItemTypes.key(ResourceKey.sponge("magenta_banner"));

    public static final DefaultedRegistryReference<ItemType> MAGENTA_BED = ItemTypes.key(ResourceKey.sponge("magenta_bed"));

    public static final DefaultedRegistryReference<ItemType> MAGENTA_CARPET = ItemTypes.key(ResourceKey.sponge("magenta_carpet"));

    public static final DefaultedRegistryReference<ItemType> MAGENTA_CONCRETE = ItemTypes.key(ResourceKey.sponge("magenta_concrete"));

    public static final DefaultedRegistryReference<ItemType> MAGENTA_CONCRETE_POWDER = ItemTypes.key(ResourceKey.sponge("magenta_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> MAGENTA_DYE = ItemTypes.key(ResourceKey.sponge("magenta_dye"));

    public static final DefaultedRegistryReference<ItemType> MAGENTA_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("magenta_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> MAGENTA_SHULKER_BOX = ItemTypes.key(ResourceKey.sponge("magenta_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> MAGENTA_STAINED_GLASS = ItemTypes.key(ResourceKey.sponge("magenta_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> MAGENTA_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.sponge("magenta_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> MAGENTA_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("magenta_terracotta"));

    public static final DefaultedRegistryReference<ItemType> MAGENTA_WOOL = ItemTypes.key(ResourceKey.sponge("magenta_wool"));

    public static final DefaultedRegistryReference<ItemType> MAGMA_BLOCK = ItemTypes.key(ResourceKey.sponge("magma_block"));

    public static final DefaultedRegistryReference<ItemType> MAGMA_CREAM = ItemTypes.key(ResourceKey.sponge("magma_cream"));

    public static final DefaultedRegistryReference<ItemType> MAGMA_CUBE_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("magma_cube_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> MAP = ItemTypes.key(ResourceKey.sponge("map"));

    public static final DefaultedRegistryReference<ItemType> MELON = ItemTypes.key(ResourceKey.sponge("melon"));

    public static final DefaultedRegistryReference<ItemType> MELON_SEEDS = ItemTypes.key(ResourceKey.sponge("melon_seeds"));

    public static final DefaultedRegistryReference<ItemType> MELON_SLICE = ItemTypes.key(ResourceKey.sponge("melon_slice"));

    public static final DefaultedRegistryReference<ItemType> MILK_BUCKET = ItemTypes.key(ResourceKey.sponge("milk_bucket"));

    public static final DefaultedRegistryReference<ItemType> MINECART = ItemTypes.key(ResourceKey.sponge("minecart"));

    public static final DefaultedRegistryReference<ItemType> MOJANG_BANNER_PATTERN = ItemTypes.key(ResourceKey.sponge("mojang_banner_pattern"));

    public static final DefaultedRegistryReference<ItemType> MOOSHROOM_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("mooshroom_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> MOSSY_COBBLESTONE = ItemTypes.key(ResourceKey.sponge("mossy_cobblestone"));

    public static final DefaultedRegistryReference<ItemType> MOSSY_COBBLESTONE_SLAB = ItemTypes.key(ResourceKey.sponge("mossy_cobblestone_slab"));

    public static final DefaultedRegistryReference<ItemType> MOSSY_COBBLESTONE_STAIRS = ItemTypes.key(ResourceKey.sponge("mossy_cobblestone_stairs"));

    public static final DefaultedRegistryReference<ItemType> MOSSY_COBBLESTONE_WALL = ItemTypes.key(ResourceKey.sponge("mossy_cobblestone_wall"));

    public static final DefaultedRegistryReference<ItemType> MOSSY_STONE_BRICK_SLAB = ItemTypes.key(ResourceKey.sponge("mossy_stone_brick_slab"));

    public static final DefaultedRegistryReference<ItemType> MOSSY_STONE_BRICK_STAIRS = ItemTypes.key(ResourceKey.sponge("mossy_stone_brick_stairs"));

    public static final DefaultedRegistryReference<ItemType> MOSSY_STONE_BRICK_WALL = ItemTypes.key(ResourceKey.sponge("mossy_stone_brick_wall"));

    public static final DefaultedRegistryReference<ItemType> MOSSY_STONE_BRICKS = ItemTypes.key(ResourceKey.sponge("mossy_stone_bricks"));

    public static final DefaultedRegistryReference<ItemType> MULE_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("mule_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> MUSHROOM_STEM = ItemTypes.key(ResourceKey.sponge("mushroom_stem"));

    public static final DefaultedRegistryReference<ItemType> MUSHROOM_STEW = ItemTypes.key(ResourceKey.sponge("mushroom_stew"));

    public static final DefaultedRegistryReference<ItemType> MUSIC_DISC_11 = ItemTypes.key(ResourceKey.sponge("music_disc_11"));

    public static final DefaultedRegistryReference<ItemType> MUSIC_DISC_13 = ItemTypes.key(ResourceKey.sponge("music_disc_13"));

    public static final DefaultedRegistryReference<ItemType> MUSIC_DISC_BLOCKS = ItemTypes.key(ResourceKey.sponge("music_disc_blocks"));

    public static final DefaultedRegistryReference<ItemType> MUSIC_DISC_CAT = ItemTypes.key(ResourceKey.sponge("music_disc_cat"));

    public static final DefaultedRegistryReference<ItemType> MUSIC_DISC_CHIRP = ItemTypes.key(ResourceKey.sponge("music_disc_chirp"));

    public static final DefaultedRegistryReference<ItemType> MUSIC_DISC_FAR = ItemTypes.key(ResourceKey.sponge("music_disc_far"));

    public static final DefaultedRegistryReference<ItemType> MUSIC_DISC_MALL = ItemTypes.key(ResourceKey.sponge("music_disc_mall"));

    public static final DefaultedRegistryReference<ItemType> MUSIC_DISC_MELLOHI = ItemTypes.key(ResourceKey.sponge("music_disc_mellohi"));

    public static final DefaultedRegistryReference<ItemType> MUSIC_DISC_PIGSTEP = ItemTypes.key(ResourceKey.sponge("music_disc_pigstep"));

    public static final DefaultedRegistryReference<ItemType> MUSIC_DISC_STAL = ItemTypes.key(ResourceKey.sponge("music_disc_stal"));

    public static final DefaultedRegistryReference<ItemType> MUSIC_DISC_STRAD = ItemTypes.key(ResourceKey.sponge("music_disc_strad"));

    public static final DefaultedRegistryReference<ItemType> MUSIC_DISC_WAIT = ItemTypes.key(ResourceKey.sponge("music_disc_wait"));

    public static final DefaultedRegistryReference<ItemType> MUSIC_DISC_WARD = ItemTypes.key(ResourceKey.sponge("music_disc_ward"));

    public static final DefaultedRegistryReference<ItemType> MUTTON = ItemTypes.key(ResourceKey.sponge("mutton"));

    public static final DefaultedRegistryReference<ItemType> MYCELIUM = ItemTypes.key(ResourceKey.sponge("mycelium"));

    public static final DefaultedRegistryReference<ItemType> NAME_TAG = ItemTypes.key(ResourceKey.sponge("name_tag"));

    public static final DefaultedRegistryReference<ItemType> NAUTILUS_SHELL = ItemTypes.key(ResourceKey.sponge("nautilus_shell"));

    public static final DefaultedRegistryReference<ItemType> NETHER_BRICK = ItemTypes.key(ResourceKey.sponge("nether_brick"));

    public static final DefaultedRegistryReference<ItemType> NETHER_BRICK_FENCE = ItemTypes.key(ResourceKey.sponge("nether_brick_fence"));

    public static final DefaultedRegistryReference<ItemType> NETHER_BRICK_SLAB = ItemTypes.key(ResourceKey.sponge("nether_brick_slab"));

    public static final DefaultedRegistryReference<ItemType> NETHER_BRICK_STAIRS = ItemTypes.key(ResourceKey.sponge("nether_brick_stairs"));

    public static final DefaultedRegistryReference<ItemType> NETHER_BRICK_WALL = ItemTypes.key(ResourceKey.sponge("nether_brick_wall"));

    public static final DefaultedRegistryReference<ItemType> NETHER_BRICKS = ItemTypes.key(ResourceKey.sponge("nether_bricks"));

    public static final DefaultedRegistryReference<ItemType> NETHER_GOLD_ORE = ItemTypes.key(ResourceKey.sponge("nether_gold_ore"));

    public static final DefaultedRegistryReference<ItemType> NETHER_QUARTZ_ORE = ItemTypes.key(ResourceKey.sponge("nether_quartz_ore"));

    public static final DefaultedRegistryReference<ItemType> NETHER_SPROUTS = ItemTypes.key(ResourceKey.sponge("nether_sprouts"));

    public static final DefaultedRegistryReference<ItemType> NETHER_STAR = ItemTypes.key(ResourceKey.sponge("nether_star"));

    public static final DefaultedRegistryReference<ItemType> NETHER_WART = ItemTypes.key(ResourceKey.sponge("nether_wart"));

    public static final DefaultedRegistryReference<ItemType> NETHER_WART_BLOCK = ItemTypes.key(ResourceKey.sponge("nether_wart_block"));

    public static final DefaultedRegistryReference<ItemType> NETHERITE_AXE = ItemTypes.key(ResourceKey.sponge("netherite_axe"));

    public static final DefaultedRegistryReference<ItemType> NETHERITE_BLOCK = ItemTypes.key(ResourceKey.sponge("netherite_block"));

    public static final DefaultedRegistryReference<ItemType> NETHERITE_BOOTS = ItemTypes.key(ResourceKey.sponge("netherite_boots"));

    public static final DefaultedRegistryReference<ItemType> NETHERITE_CHESTPLATE = ItemTypes.key(ResourceKey.sponge("netherite_chestplate"));

    public static final DefaultedRegistryReference<ItemType> NETHERITE_HELMET = ItemTypes.key(ResourceKey.sponge("netherite_helmet"));

    public static final DefaultedRegistryReference<ItemType> NETHERITE_HOE = ItemTypes.key(ResourceKey.sponge("netherite_hoe"));

    public static final DefaultedRegistryReference<ItemType> NETHERITE_INGOT = ItemTypes.key(ResourceKey.sponge("netherite_ingot"));

    public static final DefaultedRegistryReference<ItemType> NETHERITE_LEGGINGS = ItemTypes.key(ResourceKey.sponge("netherite_leggings"));

    public static final DefaultedRegistryReference<ItemType> NETHERITE_PICKAXE = ItemTypes.key(ResourceKey.sponge("netherite_pickaxe"));

    public static final DefaultedRegistryReference<ItemType> NETHERITE_SCRAP = ItemTypes.key(ResourceKey.sponge("netherite_scrap"));

    public static final DefaultedRegistryReference<ItemType> NETHERITE_SHOVEL = ItemTypes.key(ResourceKey.sponge("netherite_shovel"));

    public static final DefaultedRegistryReference<ItemType> NETHERITE_SWORD = ItemTypes.key(ResourceKey.sponge("netherite_sword"));

    public static final DefaultedRegistryReference<ItemType> NETHERRACK = ItemTypes.key(ResourceKey.sponge("netherrack"));

    public static final DefaultedRegistryReference<ItemType> NOTE_BLOCK = ItemTypes.key(ResourceKey.sponge("note_block"));

    public static final DefaultedRegistryReference<ItemType> OAK_BOAT = ItemTypes.key(ResourceKey.sponge("oak_boat"));

    public static final DefaultedRegistryReference<ItemType> OAK_BUTTON = ItemTypes.key(ResourceKey.sponge("oak_button"));

    public static final DefaultedRegistryReference<ItemType> OAK_DOOR = ItemTypes.key(ResourceKey.sponge("oak_door"));

    public static final DefaultedRegistryReference<ItemType> OAK_FENCE = ItemTypes.key(ResourceKey.sponge("oak_fence"));

    public static final DefaultedRegistryReference<ItemType> OAK_FENCE_GATE = ItemTypes.key(ResourceKey.sponge("oak_fence_gate"));

    public static final DefaultedRegistryReference<ItemType> OAK_LEAVES = ItemTypes.key(ResourceKey.sponge("oak_leaves"));

    public static final DefaultedRegistryReference<ItemType> OAK_LOG = ItemTypes.key(ResourceKey.sponge("oak_log"));

    public static final DefaultedRegistryReference<ItemType> OAK_PLANKS = ItemTypes.key(ResourceKey.sponge("oak_planks"));

    public static final DefaultedRegistryReference<ItemType> OAK_PRESSURE_PLATE = ItemTypes.key(ResourceKey.sponge("oak_pressure_plate"));

    public static final DefaultedRegistryReference<ItemType> OAK_SAPLING = ItemTypes.key(ResourceKey.sponge("oak_sapling"));

    public static final DefaultedRegistryReference<ItemType> OAK_SIGN = ItemTypes.key(ResourceKey.sponge("oak_sign"));

    public static final DefaultedRegistryReference<ItemType> OAK_SLAB = ItemTypes.key(ResourceKey.sponge("oak_slab"));

    public static final DefaultedRegistryReference<ItemType> OAK_STAIRS = ItemTypes.key(ResourceKey.sponge("oak_stairs"));

    public static final DefaultedRegistryReference<ItemType> OAK_TRAPDOOR = ItemTypes.key(ResourceKey.sponge("oak_trapdoor"));

    public static final DefaultedRegistryReference<ItemType> OAK_WOOD = ItemTypes.key(ResourceKey.sponge("oak_wood"));

    public static final DefaultedRegistryReference<ItemType> OBSERVER = ItemTypes.key(ResourceKey.sponge("observer"));

    public static final DefaultedRegistryReference<ItemType> OBSIDIAN = ItemTypes.key(ResourceKey.sponge("obsidian"));

    public static final DefaultedRegistryReference<ItemType> OCELOT_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("ocelot_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_BANNER = ItemTypes.key(ResourceKey.sponge("orange_banner"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_BED = ItemTypes.key(ResourceKey.sponge("orange_bed"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_CARPET = ItemTypes.key(ResourceKey.sponge("orange_carpet"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_CONCRETE = ItemTypes.key(ResourceKey.sponge("orange_concrete"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_CONCRETE_POWDER = ItemTypes.key(ResourceKey.sponge("orange_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_DYE = ItemTypes.key(ResourceKey.sponge("orange_dye"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("orange_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_SHULKER_BOX = ItemTypes.key(ResourceKey.sponge("orange_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_STAINED_GLASS = ItemTypes.key(ResourceKey.sponge("orange_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.sponge("orange_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("orange_terracotta"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_TULIP = ItemTypes.key(ResourceKey.sponge("orange_tulip"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_WOOL = ItemTypes.key(ResourceKey.sponge("orange_wool"));

    public static final DefaultedRegistryReference<ItemType> OXEYE_DAISY = ItemTypes.key(ResourceKey.sponge("oxeye_daisy"));

    public static final DefaultedRegistryReference<ItemType> PACKED_ICE = ItemTypes.key(ResourceKey.sponge("packed_ice"));

    public static final DefaultedRegistryReference<ItemType> PAINTING = ItemTypes.key(ResourceKey.sponge("painting"));

    public static final DefaultedRegistryReference<ItemType> PANDA_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("panda_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> PAPER = ItemTypes.key(ResourceKey.sponge("paper"));

    public static final DefaultedRegistryReference<ItemType> PARROT_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("parrot_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> PEONY = ItemTypes.key(ResourceKey.sponge("peony"));

    public static final DefaultedRegistryReference<ItemType> PETRIFIED_OAK_SLAB = ItemTypes.key(ResourceKey.sponge("petrified_oak_slab"));

    public static final DefaultedRegistryReference<ItemType> PHANTOM_MEMBRANE = ItemTypes.key(ResourceKey.sponge("phantom_membrane"));

    public static final DefaultedRegistryReference<ItemType> PHANTOM_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("phantom_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> PIG_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("pig_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> PIGLIN_BANNER_PATTERN = ItemTypes.key(ResourceKey.sponge("piglin_banner_pattern"));

    public static final DefaultedRegistryReference<ItemType> PIGLIN_BRUTE_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("piglin_brute_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> PIGLIN_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("piglin_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> PILLAGER_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("pillager_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> PINK_BANNER = ItemTypes.key(ResourceKey.sponge("pink_banner"));

    public static final DefaultedRegistryReference<ItemType> PINK_BED = ItemTypes.key(ResourceKey.sponge("pink_bed"));

    public static final DefaultedRegistryReference<ItemType> PINK_CARPET = ItemTypes.key(ResourceKey.sponge("pink_carpet"));

    public static final DefaultedRegistryReference<ItemType> PINK_CONCRETE = ItemTypes.key(ResourceKey.sponge("pink_concrete"));

    public static final DefaultedRegistryReference<ItemType> PINK_CONCRETE_POWDER = ItemTypes.key(ResourceKey.sponge("pink_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> PINK_DYE = ItemTypes.key(ResourceKey.sponge("pink_dye"));

    public static final DefaultedRegistryReference<ItemType> PINK_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("pink_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> PINK_SHULKER_BOX = ItemTypes.key(ResourceKey.sponge("pink_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> PINK_STAINED_GLASS = ItemTypes.key(ResourceKey.sponge("pink_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> PINK_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.sponge("pink_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> PINK_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("pink_terracotta"));

    public static final DefaultedRegistryReference<ItemType> PINK_TULIP = ItemTypes.key(ResourceKey.sponge("pink_tulip"));

    public static final DefaultedRegistryReference<ItemType> PINK_WOOL = ItemTypes.key(ResourceKey.sponge("pink_wool"));

    public static final DefaultedRegistryReference<ItemType> PISTON = ItemTypes.key(ResourceKey.sponge("piston"));

    public static final DefaultedRegistryReference<ItemType> PLAYER_HEAD = ItemTypes.key(ResourceKey.sponge("player_head"));

    public static final DefaultedRegistryReference<ItemType> PODZOL = ItemTypes.key(ResourceKey.sponge("podzol"));

    public static final DefaultedRegistryReference<ItemType> POISONOUS_POTATO = ItemTypes.key(ResourceKey.sponge("poisonous_potato"));

    public static final DefaultedRegistryReference<ItemType> POLAR_BEAR_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("polar_bear_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_ANDESITE = ItemTypes.key(ResourceKey.sponge("polished_andesite"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_ANDESITE_SLAB = ItemTypes.key(ResourceKey.sponge("polished_andesite_slab"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_ANDESITE_STAIRS = ItemTypes.key(ResourceKey.sponge("polished_andesite_stairs"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_BASALT = ItemTypes.key(ResourceKey.sponge("polished_basalt"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_BLACKSTONE = ItemTypes.key(ResourceKey.sponge("polished_blackstone"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_BLACKSTONE_BRICK_SLAB = ItemTypes.key(ResourceKey.sponge("polished_blackstone_brick_slab"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_BLACKSTONE_BRICK_STAIRS = ItemTypes.key(ResourceKey.sponge("polished_blackstone_brick_stairs"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_BLACKSTONE_BRICK_WALL = ItemTypes.key(ResourceKey.sponge("polished_blackstone_brick_wall"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_BLACKSTONE_BRICKS = ItemTypes.key(ResourceKey.sponge("polished_blackstone_bricks"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_BLACKSTONE_BUTTON = ItemTypes.key(ResourceKey.sponge("polished_blackstone_button"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_BLACKSTONE_PRESSURE_PLATE = ItemTypes.key(ResourceKey.sponge("polished_blackstone_pressure_plate"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_BLACKSTONE_SLAB = ItemTypes.key(ResourceKey.sponge("polished_blackstone_slab"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_BLACKSTONE_STAIRS = ItemTypes.key(ResourceKey.sponge("polished_blackstone_stairs"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_BLACKSTONE_WALL = ItemTypes.key(ResourceKey.sponge("polished_blackstone_wall"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_DIORITE = ItemTypes.key(ResourceKey.sponge("polished_diorite"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_DIORITE_SLAB = ItemTypes.key(ResourceKey.sponge("polished_diorite_slab"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_DIORITE_STAIRS = ItemTypes.key(ResourceKey.sponge("polished_diorite_stairs"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_GRANITE = ItemTypes.key(ResourceKey.sponge("polished_granite"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_GRANITE_SLAB = ItemTypes.key(ResourceKey.sponge("polished_granite_slab"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_GRANITE_STAIRS = ItemTypes.key(ResourceKey.sponge("polished_granite_stairs"));

    public static final DefaultedRegistryReference<ItemType> POPPED_CHORUS_FRUIT = ItemTypes.key(ResourceKey.sponge("popped_chorus_fruit"));

    public static final DefaultedRegistryReference<ItemType> POPPY = ItemTypes.key(ResourceKey.sponge("poppy"));

    public static final DefaultedRegistryReference<ItemType> PORKCHOP = ItemTypes.key(ResourceKey.sponge("porkchop"));

    public static final DefaultedRegistryReference<ItemType> POTATO = ItemTypes.key(ResourceKey.sponge("potato"));

    public static final DefaultedRegistryReference<ItemType> POTION = ItemTypes.key(ResourceKey.sponge("potion"));

    public static final DefaultedRegistryReference<ItemType> POWERED_RAIL = ItemTypes.key(ResourceKey.sponge("powered_rail"));

    public static final DefaultedRegistryReference<ItemType> PRISMARINE = ItemTypes.key(ResourceKey.sponge("prismarine"));

    public static final DefaultedRegistryReference<ItemType> PRISMARINE_BRICK_SLAB = ItemTypes.key(ResourceKey.sponge("prismarine_brick_slab"));

    public static final DefaultedRegistryReference<ItemType> PRISMARINE_BRICK_STAIRS = ItemTypes.key(ResourceKey.sponge("prismarine_brick_stairs"));

    public static final DefaultedRegistryReference<ItemType> PRISMARINE_BRICKS = ItemTypes.key(ResourceKey.sponge("prismarine_bricks"));

    public static final DefaultedRegistryReference<ItemType> PRISMARINE_CRYSTALS = ItemTypes.key(ResourceKey.sponge("prismarine_crystals"));

    public static final DefaultedRegistryReference<ItemType> PRISMARINE_SHARD = ItemTypes.key(ResourceKey.sponge("prismarine_shard"));

    public static final DefaultedRegistryReference<ItemType> PRISMARINE_SLAB = ItemTypes.key(ResourceKey.sponge("prismarine_slab"));

    public static final DefaultedRegistryReference<ItemType> PRISMARINE_STAIRS = ItemTypes.key(ResourceKey.sponge("prismarine_stairs"));

    public static final DefaultedRegistryReference<ItemType> PRISMARINE_WALL = ItemTypes.key(ResourceKey.sponge("prismarine_wall"));

    public static final DefaultedRegistryReference<ItemType> PUFFERFISH = ItemTypes.key(ResourceKey.sponge("pufferfish"));

    public static final DefaultedRegistryReference<ItemType> PUFFERFISH_BUCKET = ItemTypes.key(ResourceKey.sponge("pufferfish_bucket"));

    public static final DefaultedRegistryReference<ItemType> PUFFERFISH_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("pufferfish_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> PUMPKIN = ItemTypes.key(ResourceKey.sponge("pumpkin"));

    public static final DefaultedRegistryReference<ItemType> PUMPKIN_PIE = ItemTypes.key(ResourceKey.sponge("pumpkin_pie"));

    public static final DefaultedRegistryReference<ItemType> PUMPKIN_SEEDS = ItemTypes.key(ResourceKey.sponge("pumpkin_seeds"));

    public static final DefaultedRegistryReference<ItemType> PURPLE_BANNER = ItemTypes.key(ResourceKey.sponge("purple_banner"));

    public static final DefaultedRegistryReference<ItemType> PURPLE_BED = ItemTypes.key(ResourceKey.sponge("purple_bed"));

    public static final DefaultedRegistryReference<ItemType> PURPLE_CARPET = ItemTypes.key(ResourceKey.sponge("purple_carpet"));

    public static final DefaultedRegistryReference<ItemType> PURPLE_CONCRETE = ItemTypes.key(ResourceKey.sponge("purple_concrete"));

    public static final DefaultedRegistryReference<ItemType> PURPLE_CONCRETE_POWDER = ItemTypes.key(ResourceKey.sponge("purple_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> PURPLE_DYE = ItemTypes.key(ResourceKey.sponge("purple_dye"));

    public static final DefaultedRegistryReference<ItemType> PURPLE_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("purple_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> PURPLE_SHULKER_BOX = ItemTypes.key(ResourceKey.sponge("purple_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> PURPLE_STAINED_GLASS = ItemTypes.key(ResourceKey.sponge("purple_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> PURPLE_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.sponge("purple_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> PURPLE_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("purple_terracotta"));

    public static final DefaultedRegistryReference<ItemType> PURPLE_WOOL = ItemTypes.key(ResourceKey.sponge("purple_wool"));

    public static final DefaultedRegistryReference<ItemType> PURPUR_BLOCK = ItemTypes.key(ResourceKey.sponge("purpur_block"));

    public static final DefaultedRegistryReference<ItemType> PURPUR_PILLAR = ItemTypes.key(ResourceKey.sponge("purpur_pillar"));

    public static final DefaultedRegistryReference<ItemType> PURPUR_SLAB = ItemTypes.key(ResourceKey.sponge("purpur_slab"));

    public static final DefaultedRegistryReference<ItemType> PURPUR_STAIRS = ItemTypes.key(ResourceKey.sponge("purpur_stairs"));

    public static final DefaultedRegistryReference<ItemType> QUARTZ = ItemTypes.key(ResourceKey.sponge("quartz"));

    public static final DefaultedRegistryReference<ItemType> QUARTZ_BLOCK = ItemTypes.key(ResourceKey.sponge("quartz_block"));

    public static final DefaultedRegistryReference<ItemType> QUARTZ_BRICKS = ItemTypes.key(ResourceKey.sponge("quartz_bricks"));

    public static final DefaultedRegistryReference<ItemType> QUARTZ_PILLAR = ItemTypes.key(ResourceKey.sponge("quartz_pillar"));

    public static final DefaultedRegistryReference<ItemType> QUARTZ_SLAB = ItemTypes.key(ResourceKey.sponge("quartz_slab"));

    public static final DefaultedRegistryReference<ItemType> QUARTZ_STAIRS = ItemTypes.key(ResourceKey.sponge("quartz_stairs"));

    public static final DefaultedRegistryReference<ItemType> RABBIT = ItemTypes.key(ResourceKey.sponge("rabbit"));

    public static final DefaultedRegistryReference<ItemType> RABBIT_FOOT = ItemTypes.key(ResourceKey.sponge("rabbit_foot"));

    public static final DefaultedRegistryReference<ItemType> RABBIT_HIDE = ItemTypes.key(ResourceKey.sponge("rabbit_hide"));

    public static final DefaultedRegistryReference<ItemType> RABBIT_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("rabbit_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> RABBIT_STEW = ItemTypes.key(ResourceKey.sponge("rabbit_stew"));

    public static final DefaultedRegistryReference<ItemType> RAIL = ItemTypes.key(ResourceKey.sponge("rail"));

    public static final DefaultedRegistryReference<ItemType> RAVAGER_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("ravager_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> RED_BANNER = ItemTypes.key(ResourceKey.sponge("red_banner"));

    public static final DefaultedRegistryReference<ItemType> RED_BED = ItemTypes.key(ResourceKey.sponge("red_bed"));

    public static final DefaultedRegistryReference<ItemType> RED_CARPET = ItemTypes.key(ResourceKey.sponge("red_carpet"));

    public static final DefaultedRegistryReference<ItemType> RED_CONCRETE = ItemTypes.key(ResourceKey.sponge("red_concrete"));

    public static final DefaultedRegistryReference<ItemType> RED_CONCRETE_POWDER = ItemTypes.key(ResourceKey.sponge("red_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> RED_DYE = ItemTypes.key(ResourceKey.sponge("red_dye"));

    public static final DefaultedRegistryReference<ItemType> RED_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("red_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> RED_MUSHROOM = ItemTypes.key(ResourceKey.sponge("red_mushroom"));

    public static final DefaultedRegistryReference<ItemType> RED_MUSHROOM_BLOCK = ItemTypes.key(ResourceKey.sponge("red_mushroom_block"));

    public static final DefaultedRegistryReference<ItemType> RED_NETHER_BRICK_SLAB = ItemTypes.key(ResourceKey.sponge("red_nether_brick_slab"));

    public static final DefaultedRegistryReference<ItemType> RED_NETHER_BRICK_STAIRS = ItemTypes.key(ResourceKey.sponge("red_nether_brick_stairs"));

    public static final DefaultedRegistryReference<ItemType> RED_NETHER_BRICK_WALL = ItemTypes.key(ResourceKey.sponge("red_nether_brick_wall"));

    public static final DefaultedRegistryReference<ItemType> RED_NETHER_BRICKS = ItemTypes.key(ResourceKey.sponge("red_nether_bricks"));

    public static final DefaultedRegistryReference<ItemType> RED_SAND = ItemTypes.key(ResourceKey.sponge("red_sand"));

    public static final DefaultedRegistryReference<ItemType> RED_SANDSTONE = ItemTypes.key(ResourceKey.sponge("red_sandstone"));

    public static final DefaultedRegistryReference<ItemType> RED_SANDSTONE_SLAB = ItemTypes.key(ResourceKey.sponge("red_sandstone_slab"));

    public static final DefaultedRegistryReference<ItemType> RED_SANDSTONE_STAIRS = ItemTypes.key(ResourceKey.sponge("red_sandstone_stairs"));

    public static final DefaultedRegistryReference<ItemType> RED_SANDSTONE_WALL = ItemTypes.key(ResourceKey.sponge("red_sandstone_wall"));

    public static final DefaultedRegistryReference<ItemType> RED_SHULKER_BOX = ItemTypes.key(ResourceKey.sponge("red_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> RED_STAINED_GLASS = ItemTypes.key(ResourceKey.sponge("red_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> RED_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.sponge("red_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> RED_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("red_terracotta"));

    public static final DefaultedRegistryReference<ItemType> RED_TULIP = ItemTypes.key(ResourceKey.sponge("red_tulip"));

    public static final DefaultedRegistryReference<ItemType> RED_WOOL = ItemTypes.key(ResourceKey.sponge("red_wool"));

    public static final DefaultedRegistryReference<ItemType> REDSTONE = ItemTypes.key(ResourceKey.sponge("redstone"));

    public static final DefaultedRegistryReference<ItemType> REDSTONE_BLOCK = ItemTypes.key(ResourceKey.sponge("redstone_block"));

    public static final DefaultedRegistryReference<ItemType> REDSTONE_LAMP = ItemTypes.key(ResourceKey.sponge("redstone_lamp"));

    public static final DefaultedRegistryReference<ItemType> REDSTONE_ORE = ItemTypes.key(ResourceKey.sponge("redstone_ore"));

    public static final DefaultedRegistryReference<ItemType> REDSTONE_TORCH = ItemTypes.key(ResourceKey.sponge("redstone_torch"));

    public static final DefaultedRegistryReference<ItemType> REPEATER = ItemTypes.key(ResourceKey.sponge("repeater"));

    public static final DefaultedRegistryReference<ItemType> REPEATING_COMMAND_BLOCK = ItemTypes.key(ResourceKey.sponge("repeating_command_block"));

    public static final DefaultedRegistryReference<ItemType> RESPAWN_ANCHOR = ItemTypes.key(ResourceKey.sponge("respawn_anchor"));

    public static final DefaultedRegistryReference<ItemType> ROSE_BUSH = ItemTypes.key(ResourceKey.sponge("rose_bush"));

    public static final DefaultedRegistryReference<ItemType> ROTTEN_FLESH = ItemTypes.key(ResourceKey.sponge("rotten_flesh"));

    public static final DefaultedRegistryReference<ItemType> SADDLE = ItemTypes.key(ResourceKey.sponge("saddle"));

    public static final DefaultedRegistryReference<ItemType> SALMON = ItemTypes.key(ResourceKey.sponge("salmon"));

    public static final DefaultedRegistryReference<ItemType> SALMON_BUCKET = ItemTypes.key(ResourceKey.sponge("salmon_bucket"));

    public static final DefaultedRegistryReference<ItemType> SALMON_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("salmon_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> SAND = ItemTypes.key(ResourceKey.sponge("sand"));

    public static final DefaultedRegistryReference<ItemType> SANDSTONE = ItemTypes.key(ResourceKey.sponge("sandstone"));

    public static final DefaultedRegistryReference<ItemType> SANDSTONE_SLAB = ItemTypes.key(ResourceKey.sponge("sandstone_slab"));

    public static final DefaultedRegistryReference<ItemType> SANDSTONE_STAIRS = ItemTypes.key(ResourceKey.sponge("sandstone_stairs"));

    public static final DefaultedRegistryReference<ItemType> SANDSTONE_WALL = ItemTypes.key(ResourceKey.sponge("sandstone_wall"));

    public static final DefaultedRegistryReference<ItemType> SCAFFOLDING = ItemTypes.key(ResourceKey.sponge("scaffolding"));

    public static final DefaultedRegistryReference<ItemType> SCUTE = ItemTypes.key(ResourceKey.sponge("scute"));

    public static final DefaultedRegistryReference<ItemType> SEA_LANTERN = ItemTypes.key(ResourceKey.sponge("sea_lantern"));

    public static final DefaultedRegistryReference<ItemType> SEA_PICKLE = ItemTypes.key(ResourceKey.sponge("sea_pickle"));

    public static final DefaultedRegistryReference<ItemType> SEAGRASS = ItemTypes.key(ResourceKey.sponge("seagrass"));

    public static final DefaultedRegistryReference<ItemType> SHEARS = ItemTypes.key(ResourceKey.sponge("shears"));

    public static final DefaultedRegistryReference<ItemType> SHEEP_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("sheep_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> SHIELD = ItemTypes.key(ResourceKey.sponge("shield"));

    public static final DefaultedRegistryReference<ItemType> SHROOMLIGHT = ItemTypes.key(ResourceKey.sponge("shroomlight"));

    public static final DefaultedRegistryReference<ItemType> SHULKER_BOX = ItemTypes.key(ResourceKey.sponge("shulker_box"));

    public static final DefaultedRegistryReference<ItemType> SHULKER_SHELL = ItemTypes.key(ResourceKey.sponge("shulker_shell"));

    public static final DefaultedRegistryReference<ItemType> SHULKER_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("shulker_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> SILVERFISH_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("silverfish_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> SKELETON_HORSE_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("skeleton_horse_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> SKELETON_SKULL = ItemTypes.key(ResourceKey.sponge("skeleton_skull"));

    public static final DefaultedRegistryReference<ItemType> SKELETON_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("skeleton_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> SKULL_BANNER_PATTERN = ItemTypes.key(ResourceKey.sponge("skull_banner_pattern"));

    public static final DefaultedRegistryReference<ItemType> SLIME_BALL = ItemTypes.key(ResourceKey.sponge("slime_ball"));

    public static final DefaultedRegistryReference<ItemType> SLIME_BLOCK = ItemTypes.key(ResourceKey.sponge("slime_block"));

    public static final DefaultedRegistryReference<ItemType> SLIME_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("slime_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> SMITHING_TABLE = ItemTypes.key(ResourceKey.sponge("smithing_table"));

    public static final DefaultedRegistryReference<ItemType> SMOKER = ItemTypes.key(ResourceKey.sponge("smoker"));

    public static final DefaultedRegistryReference<ItemType> SMOOTH_QUARTZ = ItemTypes.key(ResourceKey.sponge("smooth_quartz"));

    public static final DefaultedRegistryReference<ItemType> SMOOTH_QUARTZ_SLAB = ItemTypes.key(ResourceKey.sponge("smooth_quartz_slab"));

    public static final DefaultedRegistryReference<ItemType> SMOOTH_QUARTZ_STAIRS = ItemTypes.key(ResourceKey.sponge("smooth_quartz_stairs"));

    public static final DefaultedRegistryReference<ItemType> SMOOTH_RED_SANDSTONE = ItemTypes.key(ResourceKey.sponge("smooth_red_sandstone"));

    public static final DefaultedRegistryReference<ItemType> SMOOTH_RED_SANDSTONE_SLAB = ItemTypes.key(ResourceKey.sponge("smooth_red_sandstone_slab"));

    public static final DefaultedRegistryReference<ItemType> SMOOTH_RED_SANDSTONE_STAIRS = ItemTypes.key(ResourceKey.sponge("smooth_red_sandstone_stairs"));

    public static final DefaultedRegistryReference<ItemType> SMOOTH_SANDSTONE = ItemTypes.key(ResourceKey.sponge("smooth_sandstone"));

    public static final DefaultedRegistryReference<ItemType> SMOOTH_SANDSTONE_SLAB = ItemTypes.key(ResourceKey.sponge("smooth_sandstone_slab"));

    public static final DefaultedRegistryReference<ItemType> SMOOTH_SANDSTONE_STAIRS = ItemTypes.key(ResourceKey.sponge("smooth_sandstone_stairs"));

    public static final DefaultedRegistryReference<ItemType> SMOOTH_STONE = ItemTypes.key(ResourceKey.sponge("smooth_stone"));

    public static final DefaultedRegistryReference<ItemType> SMOOTH_STONE_SLAB = ItemTypes.key(ResourceKey.sponge("smooth_stone_slab"));

    public static final DefaultedRegistryReference<ItemType> SNOW = ItemTypes.key(ResourceKey.sponge("snow"));

    public static final DefaultedRegistryReference<ItemType> SNOW_BLOCK = ItemTypes.key(ResourceKey.sponge("snow_block"));

    public static final DefaultedRegistryReference<ItemType> SNOWBALL = ItemTypes.key(ResourceKey.sponge("snowball"));

    public static final DefaultedRegistryReference<ItemType> SOUL_CAMPFIRE = ItemTypes.key(ResourceKey.sponge("soul_campfire"));

    public static final DefaultedRegistryReference<ItemType> SOUL_LANTERN = ItemTypes.key(ResourceKey.sponge("soul_lantern"));

    public static final DefaultedRegistryReference<ItemType> SOUL_SAND = ItemTypes.key(ResourceKey.sponge("soul_sand"));

    public static final DefaultedRegistryReference<ItemType> SOUL_SOIL = ItemTypes.key(ResourceKey.sponge("soul_soil"));

    public static final DefaultedRegistryReference<ItemType> SOUL_TORCH = ItemTypes.key(ResourceKey.sponge("soul_torch"));

    public static final DefaultedRegistryReference<ItemType> SPAWNER = ItemTypes.key(ResourceKey.sponge("spawner"));

    public static final DefaultedRegistryReference<ItemType> SPECTRAL_ARROW = ItemTypes.key(ResourceKey.sponge("spectral_arrow"));

    public static final DefaultedRegistryReference<ItemType> SPIDER_EYE = ItemTypes.key(ResourceKey.sponge("spider_eye"));

    public static final DefaultedRegistryReference<ItemType> SPIDER_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("spider_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> SPLASH_POTION = ItemTypes.key(ResourceKey.sponge("splash_potion"));

    public static final DefaultedRegistryReference<ItemType> SPONGE = ItemTypes.key(ResourceKey.sponge("sponge"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_BOAT = ItemTypes.key(ResourceKey.sponge("spruce_boat"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_BUTTON = ItemTypes.key(ResourceKey.sponge("spruce_button"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_DOOR = ItemTypes.key(ResourceKey.sponge("spruce_door"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_FENCE = ItemTypes.key(ResourceKey.sponge("spruce_fence"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_FENCE_GATE = ItemTypes.key(ResourceKey.sponge("spruce_fence_gate"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_LEAVES = ItemTypes.key(ResourceKey.sponge("spruce_leaves"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_LOG = ItemTypes.key(ResourceKey.sponge("spruce_log"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_PLANKS = ItemTypes.key(ResourceKey.sponge("spruce_planks"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_PRESSURE_PLATE = ItemTypes.key(ResourceKey.sponge("spruce_pressure_plate"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_SAPLING = ItemTypes.key(ResourceKey.sponge("spruce_sapling"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_SIGN = ItemTypes.key(ResourceKey.sponge("spruce_sign"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_SLAB = ItemTypes.key(ResourceKey.sponge("spruce_slab"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_STAIRS = ItemTypes.key(ResourceKey.sponge("spruce_stairs"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_TRAPDOOR = ItemTypes.key(ResourceKey.sponge("spruce_trapdoor"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_WOOD = ItemTypes.key(ResourceKey.sponge("spruce_wood"));

    public static final DefaultedRegistryReference<ItemType> SQUID_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("squid_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> STICK = ItemTypes.key(ResourceKey.sponge("stick"));

    public static final DefaultedRegistryReference<ItemType> STICKY_PISTON = ItemTypes.key(ResourceKey.sponge("sticky_piston"));

    public static final DefaultedRegistryReference<ItemType> STONE = ItemTypes.key(ResourceKey.sponge("stone"));

    public static final DefaultedRegistryReference<ItemType> STONE_AXE = ItemTypes.key(ResourceKey.sponge("stone_axe"));

    public static final DefaultedRegistryReference<ItemType> STONE_BRICK_SLAB = ItemTypes.key(ResourceKey.sponge("stone_brick_slab"));

    public static final DefaultedRegistryReference<ItemType> STONE_BRICK_STAIRS = ItemTypes.key(ResourceKey.sponge("stone_brick_stairs"));

    public static final DefaultedRegistryReference<ItemType> STONE_BRICK_WALL = ItemTypes.key(ResourceKey.sponge("stone_brick_wall"));

    public static final DefaultedRegistryReference<ItemType> STONE_BRICKS = ItemTypes.key(ResourceKey.sponge("stone_bricks"));

    public static final DefaultedRegistryReference<ItemType> STONE_BUTTON = ItemTypes.key(ResourceKey.sponge("stone_button"));

    public static final DefaultedRegistryReference<ItemType> STONE_HOE = ItemTypes.key(ResourceKey.sponge("stone_hoe"));

    public static final DefaultedRegistryReference<ItemType> STONE_PICKAXE = ItemTypes.key(ResourceKey.sponge("stone_pickaxe"));

    public static final DefaultedRegistryReference<ItemType> STONE_PRESSURE_PLATE = ItemTypes.key(ResourceKey.sponge("stone_pressure_plate"));

    public static final DefaultedRegistryReference<ItemType> STONE_SHOVEL = ItemTypes.key(ResourceKey.sponge("stone_shovel"));

    public static final DefaultedRegistryReference<ItemType> STONE_SLAB = ItemTypes.key(ResourceKey.sponge("stone_slab"));

    public static final DefaultedRegistryReference<ItemType> STONE_STAIRS = ItemTypes.key(ResourceKey.sponge("stone_stairs"));

    public static final DefaultedRegistryReference<ItemType> STONE_SWORD = ItemTypes.key(ResourceKey.sponge("stone_sword"));

    public static final DefaultedRegistryReference<ItemType> STONECUTTER = ItemTypes.key(ResourceKey.sponge("stonecutter"));

    public static final DefaultedRegistryReference<ItemType> STRAY_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("stray_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> STRIDER_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("strider_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> STRING = ItemTypes.key(ResourceKey.sponge("string"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_ACACIA_LOG = ItemTypes.key(ResourceKey.sponge("stripped_acacia_log"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_ACACIA_WOOD = ItemTypes.key(ResourceKey.sponge("stripped_acacia_wood"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_BIRCH_LOG = ItemTypes.key(ResourceKey.sponge("stripped_birch_log"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_BIRCH_WOOD = ItemTypes.key(ResourceKey.sponge("stripped_birch_wood"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_CRIMSON_HYPHAE = ItemTypes.key(ResourceKey.sponge("stripped_crimson_hyphae"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_CRIMSON_STEM = ItemTypes.key(ResourceKey.sponge("stripped_crimson_stem"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_DARK_OAK_LOG = ItemTypes.key(ResourceKey.sponge("stripped_dark_oak_log"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_DARK_OAK_WOOD = ItemTypes.key(ResourceKey.sponge("stripped_dark_oak_wood"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_JUNGLE_LOG = ItemTypes.key(ResourceKey.sponge("stripped_jungle_log"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_JUNGLE_WOOD = ItemTypes.key(ResourceKey.sponge("stripped_jungle_wood"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_OAK_LOG = ItemTypes.key(ResourceKey.sponge("stripped_oak_log"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_OAK_WOOD = ItemTypes.key(ResourceKey.sponge("stripped_oak_wood"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_SPRUCE_LOG = ItemTypes.key(ResourceKey.sponge("stripped_spruce_log"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_SPRUCE_WOOD = ItemTypes.key(ResourceKey.sponge("stripped_spruce_wood"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_WARPED_HYPHAE = ItemTypes.key(ResourceKey.sponge("stripped_warped_hyphae"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_WARPED_STEM = ItemTypes.key(ResourceKey.sponge("stripped_warped_stem"));

    public static final DefaultedRegistryReference<ItemType> STRUCTURE_BLOCK = ItemTypes.key(ResourceKey.sponge("structure_block"));

    public static final DefaultedRegistryReference<ItemType> STRUCTURE_VOID = ItemTypes.key(ResourceKey.sponge("structure_void"));

    public static final DefaultedRegistryReference<ItemType> SUGAR = ItemTypes.key(ResourceKey.sponge("sugar"));

    public static final DefaultedRegistryReference<ItemType> SUGAR_CANE = ItemTypes.key(ResourceKey.sponge("sugar_cane"));

    public static final DefaultedRegistryReference<ItemType> SUNFLOWER = ItemTypes.key(ResourceKey.sponge("sunflower"));

    public static final DefaultedRegistryReference<ItemType> SUSPICIOUS_STEW = ItemTypes.key(ResourceKey.sponge("suspicious_stew"));

    public static final DefaultedRegistryReference<ItemType> SWEET_BERRIES = ItemTypes.key(ResourceKey.sponge("sweet_berries"));

    public static final DefaultedRegistryReference<ItemType> TALL_GRASS = ItemTypes.key(ResourceKey.sponge("tall_grass"));

    public static final DefaultedRegistryReference<ItemType> TARGET = ItemTypes.key(ResourceKey.sponge("target"));

    public static final DefaultedRegistryReference<ItemType> TERRACOTTA = ItemTypes.key(ResourceKey.sponge("terracotta"));

    public static final DefaultedRegistryReference<ItemType> TIPPED_ARROW = ItemTypes.key(ResourceKey.sponge("tipped_arrow"));

    public static final DefaultedRegistryReference<ItemType> TNT = ItemTypes.key(ResourceKey.sponge("tnt"));

    public static final DefaultedRegistryReference<ItemType> TNT_MINECART = ItemTypes.key(ResourceKey.sponge("tnt_minecart"));

    public static final DefaultedRegistryReference<ItemType> TORCH = ItemTypes.key(ResourceKey.sponge("torch"));

    public static final DefaultedRegistryReference<ItemType> TOTEM_OF_UNDYING = ItemTypes.key(ResourceKey.sponge("totem_of_undying"));

    public static final DefaultedRegistryReference<ItemType> TRADER_LLAMA_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("trader_llama_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> TRAPPED_CHEST = ItemTypes.key(ResourceKey.sponge("trapped_chest"));

    public static final DefaultedRegistryReference<ItemType> TRIDENT = ItemTypes.key(ResourceKey.sponge("trident"));

    public static final DefaultedRegistryReference<ItemType> TRIPWIRE_HOOK = ItemTypes.key(ResourceKey.sponge("tripwire_hook"));

    public static final DefaultedRegistryReference<ItemType> TROPICAL_FISH = ItemTypes.key(ResourceKey.sponge("tropical_fish"));

    public static final DefaultedRegistryReference<ItemType> TROPICAL_FISH_BUCKET = ItemTypes.key(ResourceKey.sponge("tropical_fish_bucket"));

    public static final DefaultedRegistryReference<ItemType> TROPICAL_FISH_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("tropical_fish_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> TUBE_CORAL = ItemTypes.key(ResourceKey.sponge("tube_coral"));

    public static final DefaultedRegistryReference<ItemType> TUBE_CORAL_BLOCK = ItemTypes.key(ResourceKey.sponge("tube_coral_block"));

    public static final DefaultedRegistryReference<ItemType> TUBE_CORAL_FAN = ItemTypes.key(ResourceKey.sponge("tube_coral_fan"));

    public static final DefaultedRegistryReference<ItemType> TURTLE_EGG = ItemTypes.key(ResourceKey.sponge("turtle_egg"));

    public static final DefaultedRegistryReference<ItemType> TURTLE_HELMET = ItemTypes.key(ResourceKey.sponge("turtle_helmet"));

    public static final DefaultedRegistryReference<ItemType> TURTLE_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("turtle_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> TWISTING_VINES = ItemTypes.key(ResourceKey.sponge("twisting_vines"));

    public static final DefaultedRegistryReference<ItemType> VEX_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("vex_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> VILLAGER_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("villager_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> VINDICATOR_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("vindicator_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> VINE = ItemTypes.key(ResourceKey.sponge("vine"));

    public static final DefaultedRegistryReference<ItemType> WANDERING_TRADER_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("wandering_trader_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> WARPED_BUTTON = ItemTypes.key(ResourceKey.sponge("warped_button"));

    public static final DefaultedRegistryReference<ItemType> WARPED_DOOR = ItemTypes.key(ResourceKey.sponge("warped_door"));

    public static final DefaultedRegistryReference<ItemType> WARPED_FENCE = ItemTypes.key(ResourceKey.sponge("warped_fence"));

    public static final DefaultedRegistryReference<ItemType> WARPED_FENCE_GATE = ItemTypes.key(ResourceKey.sponge("warped_fence_gate"));

    public static final DefaultedRegistryReference<ItemType> WARPED_FUNGUS = ItemTypes.key(ResourceKey.sponge("warped_fungus"));

    public static final DefaultedRegistryReference<ItemType> WARPED_FUNGUS_ON_A_STICK = ItemTypes.key(ResourceKey.sponge("warped_fungus_on_a_stick"));

    public static final DefaultedRegistryReference<ItemType> WARPED_HYPHAE = ItemTypes.key(ResourceKey.sponge("warped_hyphae"));

    public static final DefaultedRegistryReference<ItemType> WARPED_NYLIUM = ItemTypes.key(ResourceKey.sponge("warped_nylium"));

    public static final DefaultedRegistryReference<ItemType> WARPED_PLANKS = ItemTypes.key(ResourceKey.sponge("warped_planks"));

    public static final DefaultedRegistryReference<ItemType> WARPED_PRESSURE_PLATE = ItemTypes.key(ResourceKey.sponge("warped_pressure_plate"));

    public static final DefaultedRegistryReference<ItemType> WARPED_ROOTS = ItemTypes.key(ResourceKey.sponge("warped_roots"));

    public static final DefaultedRegistryReference<ItemType> WARPED_SIGN = ItemTypes.key(ResourceKey.sponge("warped_sign"));

    public static final DefaultedRegistryReference<ItemType> WARPED_SLAB = ItemTypes.key(ResourceKey.sponge("warped_slab"));

    public static final DefaultedRegistryReference<ItemType> WARPED_STAIRS = ItemTypes.key(ResourceKey.sponge("warped_stairs"));

    public static final DefaultedRegistryReference<ItemType> WARPED_STEM = ItemTypes.key(ResourceKey.sponge("warped_stem"));

    public static final DefaultedRegistryReference<ItemType> WARPED_TRAPDOOR = ItemTypes.key(ResourceKey.sponge("warped_trapdoor"));

    public static final DefaultedRegistryReference<ItemType> WARPED_WART_BLOCK = ItemTypes.key(ResourceKey.sponge("warped_wart_block"));

    public static final DefaultedRegistryReference<ItemType> WATER_BUCKET = ItemTypes.key(ResourceKey.sponge("water_bucket"));

    public static final DefaultedRegistryReference<ItemType> WEEPING_VINES = ItemTypes.key(ResourceKey.sponge("weeping_vines"));

    public static final DefaultedRegistryReference<ItemType> WET_SPONGE = ItemTypes.key(ResourceKey.sponge("wet_sponge"));

    public static final DefaultedRegistryReference<ItemType> WHEAT = ItemTypes.key(ResourceKey.sponge("wheat"));

    public static final DefaultedRegistryReference<ItemType> WHEAT_SEEDS = ItemTypes.key(ResourceKey.sponge("wheat_seeds"));

    public static final DefaultedRegistryReference<ItemType> WHITE_BANNER = ItemTypes.key(ResourceKey.sponge("white_banner"));

    public static final DefaultedRegistryReference<ItemType> WHITE_BED = ItemTypes.key(ResourceKey.sponge("white_bed"));

    public static final DefaultedRegistryReference<ItemType> WHITE_CARPET = ItemTypes.key(ResourceKey.sponge("white_carpet"));

    public static final DefaultedRegistryReference<ItemType> WHITE_CONCRETE = ItemTypes.key(ResourceKey.sponge("white_concrete"));

    public static final DefaultedRegistryReference<ItemType> WHITE_CONCRETE_POWDER = ItemTypes.key(ResourceKey.sponge("white_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> WHITE_DYE = ItemTypes.key(ResourceKey.sponge("white_dye"));

    public static final DefaultedRegistryReference<ItemType> WHITE_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("white_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> WHITE_SHULKER_BOX = ItemTypes.key(ResourceKey.sponge("white_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> WHITE_STAINED_GLASS = ItemTypes.key(ResourceKey.sponge("white_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> WHITE_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.sponge("white_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> WHITE_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("white_terracotta"));

    public static final DefaultedRegistryReference<ItemType> WHITE_TULIP = ItemTypes.key(ResourceKey.sponge("white_tulip"));

    public static final DefaultedRegistryReference<ItemType> WHITE_WOOL = ItemTypes.key(ResourceKey.sponge("white_wool"));

    public static final DefaultedRegistryReference<ItemType> WITCH_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("witch_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> WITHER_ROSE = ItemTypes.key(ResourceKey.sponge("wither_rose"));

    public static final DefaultedRegistryReference<ItemType> WITHER_SKELETON_SKULL = ItemTypes.key(ResourceKey.sponge("wither_skeleton_skull"));

    public static final DefaultedRegistryReference<ItemType> WITHER_SKELETON_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("wither_skeleton_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> WOLF_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("wolf_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> WOODEN_AXE = ItemTypes.key(ResourceKey.sponge("wooden_axe"));

    public static final DefaultedRegistryReference<ItemType> WOODEN_HOE = ItemTypes.key(ResourceKey.sponge("wooden_hoe"));

    public static final DefaultedRegistryReference<ItemType> WOODEN_PICKAXE = ItemTypes.key(ResourceKey.sponge("wooden_pickaxe"));

    public static final DefaultedRegistryReference<ItemType> WOODEN_SHOVEL = ItemTypes.key(ResourceKey.sponge("wooden_shovel"));

    public static final DefaultedRegistryReference<ItemType> WOODEN_SWORD = ItemTypes.key(ResourceKey.sponge("wooden_sword"));

    public static final DefaultedRegistryReference<ItemType> WRITABLE_BOOK = ItemTypes.key(ResourceKey.sponge("writable_book"));

    public static final DefaultedRegistryReference<ItemType> WRITTEN_BOOK = ItemTypes.key(ResourceKey.sponge("written_book"));

    public static final DefaultedRegistryReference<ItemType> YELLOW_BANNER = ItemTypes.key(ResourceKey.sponge("yellow_banner"));

    public static final DefaultedRegistryReference<ItemType> YELLOW_BED = ItemTypes.key(ResourceKey.sponge("yellow_bed"));

    public static final DefaultedRegistryReference<ItemType> YELLOW_CARPET = ItemTypes.key(ResourceKey.sponge("yellow_carpet"));

    public static final DefaultedRegistryReference<ItemType> YELLOW_CONCRETE = ItemTypes.key(ResourceKey.sponge("yellow_concrete"));

    public static final DefaultedRegistryReference<ItemType> YELLOW_CONCRETE_POWDER = ItemTypes.key(ResourceKey.sponge("yellow_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> YELLOW_DYE = ItemTypes.key(ResourceKey.sponge("yellow_dye"));

    public static final DefaultedRegistryReference<ItemType> YELLOW_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("yellow_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> YELLOW_SHULKER_BOX = ItemTypes.key(ResourceKey.sponge("yellow_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> YELLOW_STAINED_GLASS = ItemTypes.key(ResourceKey.sponge("yellow_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> YELLOW_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.sponge("yellow_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> YELLOW_TERRACOTTA = ItemTypes.key(ResourceKey.sponge("yellow_terracotta"));

    public static final DefaultedRegistryReference<ItemType> YELLOW_WOOL = ItemTypes.key(ResourceKey.sponge("yellow_wool"));

    public static final DefaultedRegistryReference<ItemType> ZOGLIN_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("zoglin_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> ZOMBIE_HEAD = ItemTypes.key(ResourceKey.sponge("zombie_head"));

    public static final DefaultedRegistryReference<ItemType> ZOMBIE_HORSE_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("zombie_horse_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> ZOMBIE_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("zombie_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> ZOMBIE_VILLAGER_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("zombie_villager_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> ZOMBIFIED_PIGLIN_SPAWN_EGG = ItemTypes.key(ResourceKey.sponge("zombified_piglin_spawn_egg"));

    // SORTFIELDS:OFF

    // @formatter:on

    private ItemTypes() {
    }

    private static DefaultedRegistryReference<ItemType> key(final ResourceKey location) {
        return RegistryKey.<ItemType>of(Registries.ITEM_TYPE.registry(), location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
