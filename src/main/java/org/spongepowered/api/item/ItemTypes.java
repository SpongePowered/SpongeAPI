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
import org.spongepowered.api.registry.RegistryTypes;
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

    public static final DefaultedRegistryReference<ItemType> ACACIA_BOAT = ItemTypes.key(ResourceKey.minecraft("acacia_boat"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_BUTTON = ItemTypes.key(ResourceKey.minecraft("acacia_button"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_DOOR = ItemTypes.key(ResourceKey.minecraft("acacia_door"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_FENCE = ItemTypes.key(ResourceKey.minecraft("acacia_fence"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_FENCE_GATE = ItemTypes.key(ResourceKey.minecraft("acacia_fence_gate"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_LEAVES = ItemTypes.key(ResourceKey.minecraft("acacia_leaves"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_LOG = ItemTypes.key(ResourceKey.minecraft("acacia_log"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_PLANKS = ItemTypes.key(ResourceKey.minecraft("acacia_planks"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_PRESSURE_PLATE = ItemTypes.key(ResourceKey.minecraft("acacia_pressure_plate"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_SAPLING = ItemTypes.key(ResourceKey.minecraft("acacia_sapling"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_SIGN = ItemTypes.key(ResourceKey.minecraft("acacia_sign"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_SLAB = ItemTypes.key(ResourceKey.minecraft("acacia_slab"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_STAIRS = ItemTypes.key(ResourceKey.minecraft("acacia_stairs"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_TRAPDOOR = ItemTypes.key(ResourceKey.minecraft("acacia_trapdoor"));

    public static final DefaultedRegistryReference<ItemType> ACACIA_WOOD = ItemTypes.key(ResourceKey.minecraft("acacia_wood"));

    public static final DefaultedRegistryReference<ItemType> ACTIVATOR_RAIL = ItemTypes.key(ResourceKey.minecraft("activator_rail"));

    public static final DefaultedRegistryReference<ItemType> AIR = ItemTypes.key(ResourceKey.minecraft("air"));

    public static final DefaultedRegistryReference<ItemType> ALLIUM = ItemTypes.key(ResourceKey.minecraft("allium"));

    public static final DefaultedRegistryReference<ItemType> AMETHYST_BLOCK = ItemTypes.key(ResourceKey.minecraft("amethyst_block"));

    public static final DefaultedRegistryReference<ItemType> AMETHYST_CLUSTER = ItemTypes.key(ResourceKey.minecraft("amethyst_cluster"));

    public static final DefaultedRegistryReference<ItemType> AMETHYST_SHARD = ItemTypes.key(ResourceKey.minecraft("amethyst_shard"));

    public static final DefaultedRegistryReference<ItemType> ANCIENT_DEBRIS = ItemTypes.key(ResourceKey.minecraft("ancient_debris"));

    public static final DefaultedRegistryReference<ItemType> ANDESITE = ItemTypes.key(ResourceKey.minecraft("andesite"));

    public static final DefaultedRegistryReference<ItemType> ANDESITE_SLAB = ItemTypes.key(ResourceKey.minecraft("andesite_slab"));

    public static final DefaultedRegistryReference<ItemType> ANDESITE_STAIRS = ItemTypes.key(ResourceKey.minecraft("andesite_stairs"));

    public static final DefaultedRegistryReference<ItemType> ANDESITE_WALL = ItemTypes.key(ResourceKey.minecraft("andesite_wall"));

    public static final DefaultedRegistryReference<ItemType> ANVIL = ItemTypes.key(ResourceKey.minecraft("anvil"));

    public static final DefaultedRegistryReference<ItemType> APPLE = ItemTypes.key(ResourceKey.minecraft("apple"));

    public static final DefaultedRegistryReference<ItemType> ARMOR_STAND = ItemTypes.key(ResourceKey.minecraft("armor_stand"));

    public static final DefaultedRegistryReference<ItemType> ARROW = ItemTypes.key(ResourceKey.minecraft("arrow"));

    public static final DefaultedRegistryReference<ItemType> AXOLOTL_BUCKET = ItemTypes.key(ResourceKey.minecraft("axolotl_bucket"));

    public static final DefaultedRegistryReference<ItemType> AXOLOTL_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("axolotl_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> AZURE_BLUET = ItemTypes.key(ResourceKey.minecraft("azure_bluet"));

    public static final DefaultedRegistryReference<ItemType> BAKED_POTATO = ItemTypes.key(ResourceKey.minecraft("baked_potato"));

    public static final DefaultedRegistryReference<ItemType> BAMBOO = ItemTypes.key(ResourceKey.minecraft("bamboo"));

    public static final DefaultedRegistryReference<ItemType> BARREL = ItemTypes.key(ResourceKey.minecraft("barrel"));

    public static final DefaultedRegistryReference<ItemType> BARRIER = ItemTypes.key(ResourceKey.minecraft("barrier"));

    public static final DefaultedRegistryReference<ItemType> BASALT = ItemTypes.key(ResourceKey.minecraft("basalt"));

    public static final DefaultedRegistryReference<ItemType> BAT_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("bat_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> BEACON = ItemTypes.key(ResourceKey.minecraft("beacon"));

    public static final DefaultedRegistryReference<ItemType> BEDROCK = ItemTypes.key(ResourceKey.minecraft("bedrock"));

    public static final DefaultedRegistryReference<ItemType> BEE_NEST = ItemTypes.key(ResourceKey.minecraft("bee_nest"));

    public static final DefaultedRegistryReference<ItemType> BEE_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("bee_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> BEEF = ItemTypes.key(ResourceKey.minecraft("beef"));

    public static final DefaultedRegistryReference<ItemType> BEEHIVE = ItemTypes.key(ResourceKey.minecraft("beehive"));

    public static final DefaultedRegistryReference<ItemType> BEETROOT = ItemTypes.key(ResourceKey.minecraft("beetroot"));

    public static final DefaultedRegistryReference<ItemType> BEETROOT_SEEDS = ItemTypes.key(ResourceKey.minecraft("beetroot_seeds"));

    public static final DefaultedRegistryReference<ItemType> BEETROOT_SOUP = ItemTypes.key(ResourceKey.minecraft("beetroot_soup"));

    public static final DefaultedRegistryReference<ItemType> BELL = ItemTypes.key(ResourceKey.minecraft("bell"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_BOAT = ItemTypes.key(ResourceKey.minecraft("birch_boat"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_BUTTON = ItemTypes.key(ResourceKey.minecraft("birch_button"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_DOOR = ItemTypes.key(ResourceKey.minecraft("birch_door"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_FENCE = ItemTypes.key(ResourceKey.minecraft("birch_fence"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_FENCE_GATE = ItemTypes.key(ResourceKey.minecraft("birch_fence_gate"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_LEAVES = ItemTypes.key(ResourceKey.minecraft("birch_leaves"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_LOG = ItemTypes.key(ResourceKey.minecraft("birch_log"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_PLANKS = ItemTypes.key(ResourceKey.minecraft("birch_planks"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_PRESSURE_PLATE = ItemTypes.key(ResourceKey.minecraft("birch_pressure_plate"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_SAPLING = ItemTypes.key(ResourceKey.minecraft("birch_sapling"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_SIGN = ItemTypes.key(ResourceKey.minecraft("birch_sign"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_SLAB = ItemTypes.key(ResourceKey.minecraft("birch_slab"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_STAIRS = ItemTypes.key(ResourceKey.minecraft("birch_stairs"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_TRAPDOOR = ItemTypes.key(ResourceKey.minecraft("birch_trapdoor"));

    public static final DefaultedRegistryReference<ItemType> BIRCH_WOOD = ItemTypes.key(ResourceKey.minecraft("birch_wood"));

    public static final DefaultedRegistryReference<ItemType> BLACK_BANNER = ItemTypes.key(ResourceKey.minecraft("black_banner"));

    public static final DefaultedRegistryReference<ItemType> BLACK_BED = ItemTypes.key(ResourceKey.minecraft("black_bed"));

    public static final DefaultedRegistryReference<ItemType> BLACK_CANDLE = ItemTypes.key(ResourceKey.minecraft("black_candle"));

    public static final DefaultedRegistryReference<ItemType> BLACK_CARPET = ItemTypes.key(ResourceKey.minecraft("black_carpet"));

    public static final DefaultedRegistryReference<ItemType> BLACK_CONCRETE = ItemTypes.key(ResourceKey.minecraft("black_concrete"));

    public static final DefaultedRegistryReference<ItemType> BLACK_CONCRETE_POWDER = ItemTypes.key(ResourceKey.minecraft("black_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> BLACK_DYE = ItemTypes.key(ResourceKey.minecraft("black_dye"));

    public static final DefaultedRegistryReference<ItemType> BLACK_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("black_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> BLACK_SHULKER_BOX = ItemTypes.key(ResourceKey.minecraft("black_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> BLACK_STAINED_GLASS = ItemTypes.key(ResourceKey.minecraft("black_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> BLACK_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.minecraft("black_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> BLACK_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("black_terracotta"));

    public static final DefaultedRegistryReference<ItemType> BLACK_WOOL = ItemTypes.key(ResourceKey.minecraft("black_wool"));

    public static final DefaultedRegistryReference<ItemType> BLACKSTONE = ItemTypes.key(ResourceKey.minecraft("blackstone"));

    public static final DefaultedRegistryReference<ItemType> BLACKSTONE_SLAB = ItemTypes.key(ResourceKey.minecraft("blackstone_slab"));

    public static final DefaultedRegistryReference<ItemType> BLACKSTONE_STAIRS = ItemTypes.key(ResourceKey.minecraft("blackstone_stairs"));

    public static final DefaultedRegistryReference<ItemType> BLACKSTONE_WALL = ItemTypes.key(ResourceKey.minecraft("blackstone_wall"));

    public static final DefaultedRegistryReference<ItemType> BLAST_FURNACE = ItemTypes.key(ResourceKey.minecraft("blast_furnace"));

    public static final DefaultedRegistryReference<ItemType> BLAZE_POWDER = ItemTypes.key(ResourceKey.minecraft("blaze_powder"));

    public static final DefaultedRegistryReference<ItemType> BLAZE_ROD = ItemTypes.key(ResourceKey.minecraft("blaze_rod"));

    public static final DefaultedRegistryReference<ItemType> BLAZE_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("blaze_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> BLUE_BANNER = ItemTypes.key(ResourceKey.minecraft("blue_banner"));

    public static final DefaultedRegistryReference<ItemType> BLUE_BED = ItemTypes.key(ResourceKey.minecraft("blue_bed"));

    public static final DefaultedRegistryReference<ItemType> BLUE_CANDLE = ItemTypes.key(ResourceKey.minecraft("blue_candle"));

    public static final DefaultedRegistryReference<ItemType> BLUE_CARPET = ItemTypes.key(ResourceKey.minecraft("blue_carpet"));

    public static final DefaultedRegistryReference<ItemType> BLUE_CONCRETE = ItemTypes.key(ResourceKey.minecraft("blue_concrete"));

    public static final DefaultedRegistryReference<ItemType> BLUE_CONCRETE_POWDER = ItemTypes.key(ResourceKey.minecraft("blue_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> BLUE_DYE = ItemTypes.key(ResourceKey.minecraft("blue_dye"));

    public static final DefaultedRegistryReference<ItemType> BLUE_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("blue_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> BLUE_ICE = ItemTypes.key(ResourceKey.minecraft("blue_ice"));

    public static final DefaultedRegistryReference<ItemType> BLUE_ORCHID = ItemTypes.key(ResourceKey.minecraft("blue_orchid"));

    public static final DefaultedRegistryReference<ItemType> BLUE_SHULKER_BOX = ItemTypes.key(ResourceKey.minecraft("blue_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> BLUE_STAINED_GLASS = ItemTypes.key(ResourceKey.minecraft("blue_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> BLUE_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.minecraft("blue_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> BLUE_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("blue_terracotta"));

    public static final DefaultedRegistryReference<ItemType> BLUE_WOOL = ItemTypes.key(ResourceKey.minecraft("blue_wool"));

    public static final DefaultedRegistryReference<ItemType> BONE = ItemTypes.key(ResourceKey.minecraft("bone"));

    public static final DefaultedRegistryReference<ItemType> BONE_BLOCK = ItemTypes.key(ResourceKey.minecraft("bone_block"));

    public static final DefaultedRegistryReference<ItemType> BONE_MEAL = ItemTypes.key(ResourceKey.minecraft("bone_meal"));

    public static final DefaultedRegistryReference<ItemType> BOOK = ItemTypes.key(ResourceKey.minecraft("book"));

    public static final DefaultedRegistryReference<ItemType> BOOKSHELF = ItemTypes.key(ResourceKey.minecraft("bookshelf"));

    public static final DefaultedRegistryReference<ItemType> BOW = ItemTypes.key(ResourceKey.minecraft("bow"));

    public static final DefaultedRegistryReference<ItemType> BOWL = ItemTypes.key(ResourceKey.minecraft("bowl"));

    public static final DefaultedRegistryReference<ItemType> BRAIN_CORAL = ItemTypes.key(ResourceKey.minecraft("brain_coral"));

    public static final DefaultedRegistryReference<ItemType> BRAIN_CORAL_BLOCK = ItemTypes.key(ResourceKey.minecraft("brain_coral_block"));

    public static final DefaultedRegistryReference<ItemType> BRAIN_CORAL_FAN = ItemTypes.key(ResourceKey.minecraft("brain_coral_fan"));

    public static final DefaultedRegistryReference<ItemType> BREAD = ItemTypes.key(ResourceKey.minecraft("bread"));

    public static final DefaultedRegistryReference<ItemType> BREWING_STAND = ItemTypes.key(ResourceKey.minecraft("brewing_stand"));

    public static final DefaultedRegistryReference<ItemType> BRICK = ItemTypes.key(ResourceKey.minecraft("brick"));

    public static final DefaultedRegistryReference<ItemType> BRICK_SLAB = ItemTypes.key(ResourceKey.minecraft("brick_slab"));

    public static final DefaultedRegistryReference<ItemType> BRICK_STAIRS = ItemTypes.key(ResourceKey.minecraft("brick_stairs"));

    public static final DefaultedRegistryReference<ItemType> BRICK_WALL = ItemTypes.key(ResourceKey.minecraft("brick_wall"));

    public static final DefaultedRegistryReference<ItemType> BRICKS = ItemTypes.key(ResourceKey.minecraft("bricks"));

    public static final DefaultedRegistryReference<ItemType> BROWN_BANNER = ItemTypes.key(ResourceKey.minecraft("brown_banner"));

    public static final DefaultedRegistryReference<ItemType> BROWN_BED = ItemTypes.key(ResourceKey.minecraft("brown_bed"));

    public static final DefaultedRegistryReference<ItemType> BROWN_CANDLE = ItemTypes.key(ResourceKey.minecraft("brown_candle"));

    public static final DefaultedRegistryReference<ItemType> BROWN_CARPET = ItemTypes.key(ResourceKey.minecraft("brown_carpet"));

    public static final DefaultedRegistryReference<ItemType> BROWN_CONCRETE = ItemTypes.key(ResourceKey.minecraft("brown_concrete"));

    public static final DefaultedRegistryReference<ItemType> BROWN_CONCRETE_POWDER = ItemTypes.key(ResourceKey.minecraft("brown_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> BROWN_DYE = ItemTypes.key(ResourceKey.minecraft("brown_dye"));

    public static final DefaultedRegistryReference<ItemType> BROWN_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("brown_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> BROWN_MUSHROOM = ItemTypes.key(ResourceKey.minecraft("brown_mushroom"));

    public static final DefaultedRegistryReference<ItemType> BROWN_MUSHROOM_BLOCK = ItemTypes.key(ResourceKey.minecraft("brown_mushroom_block"));

    public static final DefaultedRegistryReference<ItemType> BROWN_SHULKER_BOX = ItemTypes.key(ResourceKey.minecraft("brown_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> BROWN_STAINED_GLASS = ItemTypes.key(ResourceKey.minecraft("brown_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> BROWN_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.minecraft("brown_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> BROWN_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("brown_terracotta"));

    public static final DefaultedRegistryReference<ItemType> BROWN_WOOL = ItemTypes.key(ResourceKey.minecraft("brown_wool"));

    public static final DefaultedRegistryReference<ItemType> BUBBLE_CORAL = ItemTypes.key(ResourceKey.minecraft("bubble_coral"));

    public static final DefaultedRegistryReference<ItemType> BUBBLE_CORAL_BLOCK = ItemTypes.key(ResourceKey.minecraft("bubble_coral_block"));

    public static final DefaultedRegistryReference<ItemType> BUBBLE_CORAL_FAN = ItemTypes.key(ResourceKey.minecraft("bubble_coral_fan"));

    public static final DefaultedRegistryReference<ItemType> BUCKET = ItemTypes.key(ResourceKey.minecraft("bucket"));

    public static final DefaultedRegistryReference<ItemType> BUDDING_AMETHYST = ItemTypes.key(ResourceKey.minecraft("budding_amethyst"));

    public static final DefaultedRegistryReference<ItemType> BUNDLE = ItemTypes.key(ResourceKey.minecraft("bundle"));

    public static final DefaultedRegistryReference<ItemType> CACTUS = ItemTypes.key(ResourceKey.minecraft("cactus"));

    public static final DefaultedRegistryReference<ItemType> CAKE = ItemTypes.key(ResourceKey.minecraft("cake"));

    public static final DefaultedRegistryReference<ItemType> CALCITE = ItemTypes.key(ResourceKey.minecraft("calcite"));

    public static final DefaultedRegistryReference<ItemType> CAMPFIRE = ItemTypes.key(ResourceKey.minecraft("campfire"));

    public static final DefaultedRegistryReference<ItemType> CANDLE = ItemTypes.key(ResourceKey.minecraft("candle"));

    public static final DefaultedRegistryReference<ItemType> CARROT = ItemTypes.key(ResourceKey.minecraft("carrot"));

    public static final DefaultedRegistryReference<ItemType> CARROT_ON_A_STICK = ItemTypes.key(ResourceKey.minecraft("carrot_on_a_stick"));

    public static final DefaultedRegistryReference<ItemType> CARTOGRAPHY_TABLE = ItemTypes.key(ResourceKey.minecraft("cartography_table"));

    public static final DefaultedRegistryReference<ItemType> CARVED_PUMPKIN = ItemTypes.key(ResourceKey.minecraft("carved_pumpkin"));

    public static final DefaultedRegistryReference<ItemType> CAT_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("cat_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> CAULDRON = ItemTypes.key(ResourceKey.minecraft("cauldron"));

    public static final DefaultedRegistryReference<ItemType> CAVE_SPIDER_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("cave_spider_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> CHAIN = ItemTypes.key(ResourceKey.minecraft("chain"));

    public static final DefaultedRegistryReference<ItemType> CHAIN_COMMAND_BLOCK = ItemTypes.key(ResourceKey.minecraft("chain_command_block"));

    public static final DefaultedRegistryReference<ItemType> CHAINMAIL_BOOTS = ItemTypes.key(ResourceKey.minecraft("chainmail_boots"));

    public static final DefaultedRegistryReference<ItemType> CHAINMAIL_CHESTPLATE = ItemTypes.key(ResourceKey.minecraft("chainmail_chestplate"));

    public static final DefaultedRegistryReference<ItemType> CHAINMAIL_HELMET = ItemTypes.key(ResourceKey.minecraft("chainmail_helmet"));

    public static final DefaultedRegistryReference<ItemType> CHAINMAIL_LEGGINGS = ItemTypes.key(ResourceKey.minecraft("chainmail_leggings"));

    public static final DefaultedRegistryReference<ItemType> CHARCOAL = ItemTypes.key(ResourceKey.minecraft("charcoal"));

    public static final DefaultedRegistryReference<ItemType> CHEST = ItemTypes.key(ResourceKey.minecraft("chest"));

    public static final DefaultedRegistryReference<ItemType> CHEST_MINECART = ItemTypes.key(ResourceKey.minecraft("chest_minecart"));

    public static final DefaultedRegistryReference<ItemType> CHICKEN = ItemTypes.key(ResourceKey.minecraft("chicken"));

    public static final DefaultedRegistryReference<ItemType> CHICKEN_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("chicken_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> CHIPPED_ANVIL = ItemTypes.key(ResourceKey.minecraft("chipped_anvil"));

    public static final DefaultedRegistryReference<ItemType> CHISELED_NETHER_BRICKS = ItemTypes.key(ResourceKey.minecraft("chiseled_nether_bricks"));

    public static final DefaultedRegistryReference<ItemType> CHISELED_POLISHED_BLACKSTONE = ItemTypes.key(ResourceKey.minecraft("chiseled_polished_blackstone"));

    public static final DefaultedRegistryReference<ItemType> CHISELED_QUARTZ_BLOCK = ItemTypes.key(ResourceKey.minecraft("chiseled_quartz_block"));

    public static final DefaultedRegistryReference<ItemType> CHISELED_RED_SANDSTONE = ItemTypes.key(ResourceKey.minecraft("chiseled_red_sandstone"));

    public static final DefaultedRegistryReference<ItemType> CHISELED_SANDSTONE = ItemTypes.key(ResourceKey.minecraft("chiseled_sandstone"));

    public static final DefaultedRegistryReference<ItemType> CHISELED_STONE_BRICKS = ItemTypes.key(ResourceKey.minecraft("chiseled_stone_bricks"));

    public static final DefaultedRegistryReference<ItemType> CHORUS_FLOWER = ItemTypes.key(ResourceKey.minecraft("chorus_flower"));

    public static final DefaultedRegistryReference<ItemType> CHORUS_FRUIT = ItemTypes.key(ResourceKey.minecraft("chorus_fruit"));

    public static final DefaultedRegistryReference<ItemType> CHORUS_PLANT = ItemTypes.key(ResourceKey.minecraft("chorus_plant"));

    public static final DefaultedRegistryReference<ItemType> CLAY = ItemTypes.key(ResourceKey.minecraft("clay"));

    public static final DefaultedRegistryReference<ItemType> CLAY_BALL = ItemTypes.key(ResourceKey.minecraft("clay_ball"));

    public static final DefaultedRegistryReference<ItemType> CLOCK = ItemTypes.key(ResourceKey.minecraft("clock"));

    public static final DefaultedRegistryReference<ItemType> COAL = ItemTypes.key(ResourceKey.minecraft("coal"));

    public static final DefaultedRegistryReference<ItemType> COAL_BLOCK = ItemTypes.key(ResourceKey.minecraft("coal_block"));

    public static final DefaultedRegistryReference<ItemType> COAL_ORE = ItemTypes.key(ResourceKey.minecraft("coal_ore"));

    public static final DefaultedRegistryReference<ItemType> COARSE_DIRT = ItemTypes.key(ResourceKey.minecraft("coarse_dirt"));

    public static final DefaultedRegistryReference<ItemType> COBBLESTONE = ItemTypes.key(ResourceKey.minecraft("cobblestone"));

    public static final DefaultedRegistryReference<ItemType> COBBLESTONE_SLAB = ItemTypes.key(ResourceKey.minecraft("cobblestone_slab"));

    public static final DefaultedRegistryReference<ItemType> COBBLESTONE_STAIRS = ItemTypes.key(ResourceKey.minecraft("cobblestone_stairs"));

    public static final DefaultedRegistryReference<ItemType> COBBLESTONE_WALL = ItemTypes.key(ResourceKey.minecraft("cobblestone_wall"));

    public static final DefaultedRegistryReference<ItemType> COBWEB = ItemTypes.key(ResourceKey.minecraft("cobweb"));

    public static final DefaultedRegistryReference<ItemType> COCOA_BEANS = ItemTypes.key(ResourceKey.minecraft("cocoa_beans"));

    public static final DefaultedRegistryReference<ItemType> COD = ItemTypes.key(ResourceKey.minecraft("cod"));

    public static final DefaultedRegistryReference<ItemType> COD_BUCKET = ItemTypes.key(ResourceKey.minecraft("cod_bucket"));

    public static final DefaultedRegistryReference<ItemType> COD_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("cod_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> COMMAND_BLOCK = ItemTypes.key(ResourceKey.minecraft("command_block"));

    public static final DefaultedRegistryReference<ItemType> COMMAND_BLOCK_MINECART = ItemTypes.key(ResourceKey.minecraft("command_block_minecart"));

    public static final DefaultedRegistryReference<ItemType> COMPARATOR = ItemTypes.key(ResourceKey.minecraft("comparator"));

    public static final DefaultedRegistryReference<ItemType> COMPASS = ItemTypes.key(ResourceKey.minecraft("compass"));

    public static final DefaultedRegistryReference<ItemType> COMPOSTER = ItemTypes.key(ResourceKey.minecraft("composter"));

    public static final DefaultedRegistryReference<ItemType> CONDUIT = ItemTypes.key(ResourceKey.minecraft("conduit"));

    public static final DefaultedRegistryReference<ItemType> COOKED_BEEF = ItemTypes.key(ResourceKey.minecraft("cooked_beef"));

    public static final DefaultedRegistryReference<ItemType> COOKED_CHICKEN = ItemTypes.key(ResourceKey.minecraft("cooked_chicken"));

    public static final DefaultedRegistryReference<ItemType> COOKED_COD = ItemTypes.key(ResourceKey.minecraft("cooked_cod"));

    public static final DefaultedRegistryReference<ItemType> COOKED_MUTTON = ItemTypes.key(ResourceKey.minecraft("cooked_mutton"));

    public static final DefaultedRegistryReference<ItemType> COOKED_PORKCHOP = ItemTypes.key(ResourceKey.minecraft("cooked_porkchop"));

    public static final DefaultedRegistryReference<ItemType> COOKED_RABBIT = ItemTypes.key(ResourceKey.minecraft("cooked_rabbit"));

    public static final DefaultedRegistryReference<ItemType> COOKED_SALMON = ItemTypes.key(ResourceKey.minecraft("cooked_salmon"));

    public static final DefaultedRegistryReference<ItemType> COOKIE = ItemTypes.key(ResourceKey.minecraft("cookie"));

    public static final DefaultedRegistryReference<ItemType> COPPER_BLOCK = ItemTypes.key(ResourceKey.minecraft("copper_block"));

    public static final DefaultedRegistryReference<ItemType> COPPER_INGOT = ItemTypes.key(ResourceKey.minecraft("copper_ingot"));

    public static final DefaultedRegistryReference<ItemType> COPPER_ORE = ItemTypes.key(ResourceKey.minecraft("copper_ore"));

    public static final DefaultedRegistryReference<ItemType> CORNFLOWER = ItemTypes.key(ResourceKey.minecraft("cornflower"));

    public static final DefaultedRegistryReference<ItemType> COW_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("cow_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> CRACKED_NETHER_BRICKS = ItemTypes.key(ResourceKey.minecraft("cracked_nether_bricks"));

    public static final DefaultedRegistryReference<ItemType> CRACKED_POLISHED_BLACKSTONE_BRICKS = ItemTypes.key(ResourceKey.minecraft("cracked_polished_blackstone_bricks"));

    public static final DefaultedRegistryReference<ItemType> CRACKED_STONE_BRICKS = ItemTypes.key(ResourceKey.minecraft("cracked_stone_bricks"));

    public static final DefaultedRegistryReference<ItemType> CRAFTING_TABLE = ItemTypes.key(ResourceKey.minecraft("crafting_table"));

    public static final DefaultedRegistryReference<ItemType> CREEPER_BANNER_PATTERN = ItemTypes.key(ResourceKey.minecraft("creeper_banner_pattern"));

    public static final DefaultedRegistryReference<ItemType> CREEPER_HEAD = ItemTypes.key(ResourceKey.minecraft("creeper_head"));

    public static final DefaultedRegistryReference<ItemType> CREEPER_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("creeper_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_BUTTON = ItemTypes.key(ResourceKey.minecraft("crimson_button"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_DOOR = ItemTypes.key(ResourceKey.minecraft("crimson_door"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_FENCE = ItemTypes.key(ResourceKey.minecraft("crimson_fence"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_FENCE_GATE = ItemTypes.key(ResourceKey.minecraft("crimson_fence_gate"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_FUNGUS = ItemTypes.key(ResourceKey.minecraft("crimson_fungus"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_HYPHAE = ItemTypes.key(ResourceKey.minecraft("crimson_hyphae"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_NYLIUM = ItemTypes.key(ResourceKey.minecraft("crimson_nylium"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_PLANKS = ItemTypes.key(ResourceKey.minecraft("crimson_planks"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_PRESSURE_PLATE = ItemTypes.key(ResourceKey.minecraft("crimson_pressure_plate"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_ROOTS = ItemTypes.key(ResourceKey.minecraft("crimson_roots"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_SIGN = ItemTypes.key(ResourceKey.minecraft("crimson_sign"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_SLAB = ItemTypes.key(ResourceKey.minecraft("crimson_slab"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_STAIRS = ItemTypes.key(ResourceKey.minecraft("crimson_stairs"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_STEM = ItemTypes.key(ResourceKey.minecraft("crimson_stem"));

    public static final DefaultedRegistryReference<ItemType> CRIMSON_TRAPDOOR = ItemTypes.key(ResourceKey.minecraft("crimson_trapdoor"));

    public static final DefaultedRegistryReference<ItemType> CROSSBOW = ItemTypes.key(ResourceKey.minecraft("crossbow"));

    public static final DefaultedRegistryReference<ItemType> CRYING_OBSIDIAN = ItemTypes.key(ResourceKey.minecraft("crying_obsidian"));

    public static final DefaultedRegistryReference<ItemType> CUT_COPPER = ItemTypes.key(ResourceKey.minecraft("cut_copper"));

    public static final DefaultedRegistryReference<ItemType> CUT_COPPER_SLAB = ItemTypes.key(ResourceKey.minecraft("cut_copper_slab"));

    public static final DefaultedRegistryReference<ItemType> CUT_COPPER_STAIRS = ItemTypes.key(ResourceKey.minecraft("cut_copper_stairs"));

    public static final DefaultedRegistryReference<ItemType> CUT_RED_SANDSTONE = ItemTypes.key(ResourceKey.minecraft("cut_red_sandstone"));

    public static final DefaultedRegistryReference<ItemType> CUT_RED_SANDSTONE_SLAB = ItemTypes.key(ResourceKey.minecraft("cut_red_sandstone_slab"));

    public static final DefaultedRegistryReference<ItemType> CUT_SANDSTONE = ItemTypes.key(ResourceKey.minecraft("cut_sandstone"));

    public static final DefaultedRegistryReference<ItemType> CUT_SANDSTONE_SLAB = ItemTypes.key(ResourceKey.minecraft("cut_sandstone_slab"));

    public static final DefaultedRegistryReference<ItemType> CYAN_BANNER = ItemTypes.key(ResourceKey.minecraft("cyan_banner"));

    public static final DefaultedRegistryReference<ItemType> CYAN_BED = ItemTypes.key(ResourceKey.minecraft("cyan_bed"));

    public static final DefaultedRegistryReference<ItemType> CYAN_CANDLE = ItemTypes.key(ResourceKey.minecraft("cyan_candle"));

    public static final DefaultedRegistryReference<ItemType> CYAN_CARPET = ItemTypes.key(ResourceKey.minecraft("cyan_carpet"));

    public static final DefaultedRegistryReference<ItemType> CYAN_CONCRETE = ItemTypes.key(ResourceKey.minecraft("cyan_concrete"));

    public static final DefaultedRegistryReference<ItemType> CYAN_CONCRETE_POWDER = ItemTypes.key(ResourceKey.minecraft("cyan_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> CYAN_DYE = ItemTypes.key(ResourceKey.minecraft("cyan_dye"));

    public static final DefaultedRegistryReference<ItemType> CYAN_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("cyan_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> CYAN_SHULKER_BOX = ItemTypes.key(ResourceKey.minecraft("cyan_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> CYAN_STAINED_GLASS = ItemTypes.key(ResourceKey.minecraft("cyan_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> CYAN_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.minecraft("cyan_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> CYAN_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("cyan_terracotta"));

    public static final DefaultedRegistryReference<ItemType> CYAN_WOOL = ItemTypes.key(ResourceKey.minecraft("cyan_wool"));

    public static final DefaultedRegistryReference<ItemType> DAMAGED_ANVIL = ItemTypes.key(ResourceKey.minecraft("damaged_anvil"));

    public static final DefaultedRegistryReference<ItemType> DANDELION = ItemTypes.key(ResourceKey.minecraft("dandelion"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_BOAT = ItemTypes.key(ResourceKey.minecraft("dark_oak_boat"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_BUTTON = ItemTypes.key(ResourceKey.minecraft("dark_oak_button"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_DOOR = ItemTypes.key(ResourceKey.minecraft("dark_oak_door"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_FENCE = ItemTypes.key(ResourceKey.minecraft("dark_oak_fence"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_FENCE_GATE = ItemTypes.key(ResourceKey.minecraft("dark_oak_fence_gate"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_LEAVES = ItemTypes.key(ResourceKey.minecraft("dark_oak_leaves"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_LOG = ItemTypes.key(ResourceKey.minecraft("dark_oak_log"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_PLANKS = ItemTypes.key(ResourceKey.minecraft("dark_oak_planks"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_PRESSURE_PLATE = ItemTypes.key(ResourceKey.minecraft("dark_oak_pressure_plate"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_SAPLING = ItemTypes.key(ResourceKey.minecraft("dark_oak_sapling"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_SIGN = ItemTypes.key(ResourceKey.minecraft("dark_oak_sign"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_SLAB = ItemTypes.key(ResourceKey.minecraft("dark_oak_slab"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_STAIRS = ItemTypes.key(ResourceKey.minecraft("dark_oak_stairs"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_TRAPDOOR = ItemTypes.key(ResourceKey.minecraft("dark_oak_trapdoor"));

    public static final DefaultedRegistryReference<ItemType> DARK_OAK_WOOD = ItemTypes.key(ResourceKey.minecraft("dark_oak_wood"));

    public static final DefaultedRegistryReference<ItemType> DARK_PRISMARINE = ItemTypes.key(ResourceKey.minecraft("dark_prismarine"));

    public static final DefaultedRegistryReference<ItemType> DARK_PRISMARINE_SLAB = ItemTypes.key(ResourceKey.minecraft("dark_prismarine_slab"));

    public static final DefaultedRegistryReference<ItemType> DARK_PRISMARINE_STAIRS = ItemTypes.key(ResourceKey.minecraft("dark_prismarine_stairs"));

    public static final DefaultedRegistryReference<ItemType> DAYLIGHT_DETECTOR = ItemTypes.key(ResourceKey.minecraft("daylight_detector"));

    public static final DefaultedRegistryReference<ItemType> DEAD_BRAIN_CORAL = ItemTypes.key(ResourceKey.minecraft("dead_brain_coral"));

    public static final DefaultedRegistryReference<ItemType> DEAD_BRAIN_CORAL_BLOCK = ItemTypes.key(ResourceKey.minecraft("dead_brain_coral_block"));

    public static final DefaultedRegistryReference<ItemType> DEAD_BRAIN_CORAL_FAN = ItemTypes.key(ResourceKey.minecraft("dead_brain_coral_fan"));

    public static final DefaultedRegistryReference<ItemType> DEAD_BUBBLE_CORAL = ItemTypes.key(ResourceKey.minecraft("dead_bubble_coral"));

    public static final DefaultedRegistryReference<ItemType> DEAD_BUBBLE_CORAL_BLOCK = ItemTypes.key(ResourceKey.minecraft("dead_bubble_coral_block"));

    public static final DefaultedRegistryReference<ItemType> DEAD_BUBBLE_CORAL_FAN = ItemTypes.key(ResourceKey.minecraft("dead_bubble_coral_fan"));

    public static final DefaultedRegistryReference<ItemType> DEAD_BUSH = ItemTypes.key(ResourceKey.minecraft("dead_bush"));

    public static final DefaultedRegistryReference<ItemType> DEAD_FIRE_CORAL = ItemTypes.key(ResourceKey.minecraft("dead_fire_coral"));

    public static final DefaultedRegistryReference<ItemType> DEAD_FIRE_CORAL_BLOCK = ItemTypes.key(ResourceKey.minecraft("dead_fire_coral_block"));

    public static final DefaultedRegistryReference<ItemType> DEAD_FIRE_CORAL_FAN = ItemTypes.key(ResourceKey.minecraft("dead_fire_coral_fan"));

    public static final DefaultedRegistryReference<ItemType> DEAD_HORN_CORAL = ItemTypes.key(ResourceKey.minecraft("dead_horn_coral"));

    public static final DefaultedRegistryReference<ItemType> DEAD_HORN_CORAL_BLOCK = ItemTypes.key(ResourceKey.minecraft("dead_horn_coral_block"));

    public static final DefaultedRegistryReference<ItemType> DEAD_HORN_CORAL_FAN = ItemTypes.key(ResourceKey.minecraft("dead_horn_coral_fan"));

    public static final DefaultedRegistryReference<ItemType> DEAD_TUBE_CORAL = ItemTypes.key(ResourceKey.minecraft("dead_tube_coral"));

    public static final DefaultedRegistryReference<ItemType> DEAD_TUBE_CORAL_BLOCK = ItemTypes.key(ResourceKey.minecraft("dead_tube_coral_block"));

    public static final DefaultedRegistryReference<ItemType> DEAD_TUBE_CORAL_FAN = ItemTypes.key(ResourceKey.minecraft("dead_tube_coral_fan"));

    public static final DefaultedRegistryReference<ItemType> DEBUG_STICK = ItemTypes.key(ResourceKey.minecraft("debug_stick"));

    public static final DefaultedRegistryReference<ItemType> DETECTOR_RAIL = ItemTypes.key(ResourceKey.minecraft("detector_rail"));

    public static final DefaultedRegistryReference<ItemType> DIAMOND = ItemTypes.key(ResourceKey.minecraft("diamond"));

    public static final DefaultedRegistryReference<ItemType> DIAMOND_AXE = ItemTypes.key(ResourceKey.minecraft("diamond_axe"));

    public static final DefaultedRegistryReference<ItemType> DIAMOND_BLOCK = ItemTypes.key(ResourceKey.minecraft("diamond_block"));

    public static final DefaultedRegistryReference<ItemType> DIAMOND_BOOTS = ItemTypes.key(ResourceKey.minecraft("diamond_boots"));

    public static final DefaultedRegistryReference<ItemType> DIAMOND_CHESTPLATE = ItemTypes.key(ResourceKey.minecraft("diamond_chestplate"));

    public static final DefaultedRegistryReference<ItemType> DIAMOND_HELMET = ItemTypes.key(ResourceKey.minecraft("diamond_helmet"));

    public static final DefaultedRegistryReference<ItemType> DIAMOND_HOE = ItemTypes.key(ResourceKey.minecraft("diamond_hoe"));

    public static final DefaultedRegistryReference<ItemType> DIAMOND_HORSE_ARMOR = ItemTypes.key(ResourceKey.minecraft("diamond_horse_armor"));

    public static final DefaultedRegistryReference<ItemType> DIAMOND_LEGGINGS = ItemTypes.key(ResourceKey.minecraft("diamond_leggings"));

    public static final DefaultedRegistryReference<ItemType> DIAMOND_ORE = ItemTypes.key(ResourceKey.minecraft("diamond_ore"));

    public static final DefaultedRegistryReference<ItemType> DIAMOND_PICKAXE = ItemTypes.key(ResourceKey.minecraft("diamond_pickaxe"));

    public static final DefaultedRegistryReference<ItemType> DIAMOND_SHOVEL = ItemTypes.key(ResourceKey.minecraft("diamond_shovel"));

    public static final DefaultedRegistryReference<ItemType> DIAMOND_SWORD = ItemTypes.key(ResourceKey.minecraft("diamond_sword"));

    public static final DefaultedRegistryReference<ItemType> DIORITE = ItemTypes.key(ResourceKey.minecraft("diorite"));

    public static final DefaultedRegistryReference<ItemType> DIORITE_SLAB = ItemTypes.key(ResourceKey.minecraft("diorite_slab"));

    public static final DefaultedRegistryReference<ItemType> DIORITE_STAIRS = ItemTypes.key(ResourceKey.minecraft("diorite_stairs"));

    public static final DefaultedRegistryReference<ItemType> DIORITE_WALL = ItemTypes.key(ResourceKey.minecraft("diorite_wall"));

    public static final DefaultedRegistryReference<ItemType> DIRT = ItemTypes.key(ResourceKey.minecraft("dirt"));

    public static final DefaultedRegistryReference<ItemType> DIRT_PATH = ItemTypes.key(ResourceKey.minecraft("dirt_path"));

    public static final DefaultedRegistryReference<ItemType> DISPENSER = ItemTypes.key(ResourceKey.minecraft("dispenser"));

    public static final DefaultedRegistryReference<ItemType> DOLPHIN_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("dolphin_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> DONKEY_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("donkey_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> DRAGON_BREATH = ItemTypes.key(ResourceKey.minecraft("dragon_breath"));

    public static final DefaultedRegistryReference<ItemType> DRAGON_EGG = ItemTypes.key(ResourceKey.minecraft("dragon_egg"));

    public static final DefaultedRegistryReference<ItemType> DRAGON_HEAD = ItemTypes.key(ResourceKey.minecraft("dragon_head"));

    public static final DefaultedRegistryReference<ItemType> DRIED_KELP = ItemTypes.key(ResourceKey.minecraft("dried_kelp"));

    public static final DefaultedRegistryReference<ItemType> DRIED_KELP_BLOCK = ItemTypes.key(ResourceKey.minecraft("dried_kelp_block"));

    public static final DefaultedRegistryReference<ItemType> DRIPSTONE_BLOCK = ItemTypes.key(ResourceKey.minecraft("dripstone_block"));

    public static final DefaultedRegistryReference<ItemType> DROPPER = ItemTypes.key(ResourceKey.minecraft("dropper"));

    public static final DefaultedRegistryReference<ItemType> DROWNED_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("drowned_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> EGG = ItemTypes.key(ResourceKey.minecraft("egg"));

    public static final DefaultedRegistryReference<ItemType> ELDER_GUARDIAN_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("elder_guardian_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> ELYTRA = ItemTypes.key(ResourceKey.minecraft("elytra"));

    public static final DefaultedRegistryReference<ItemType> EMERALD = ItemTypes.key(ResourceKey.minecraft("emerald"));

    public static final DefaultedRegistryReference<ItemType> EMERALD_BLOCK = ItemTypes.key(ResourceKey.minecraft("emerald_block"));

    public static final DefaultedRegistryReference<ItemType> EMERALD_ORE = ItemTypes.key(ResourceKey.minecraft("emerald_ore"));

    public static final DefaultedRegistryReference<ItemType> ENCHANTED_BOOK = ItemTypes.key(ResourceKey.minecraft("enchanted_book"));

    public static final DefaultedRegistryReference<ItemType> ENCHANTED_GOLDEN_APPLE = ItemTypes.key(ResourceKey.minecraft("enchanted_golden_apple"));

    public static final DefaultedRegistryReference<ItemType> ENCHANTING_TABLE = ItemTypes.key(ResourceKey.minecraft("enchanting_table"));

    public static final DefaultedRegistryReference<ItemType> END_CRYSTAL = ItemTypes.key(ResourceKey.minecraft("end_crystal"));

    public static final DefaultedRegistryReference<ItemType> END_PORTAL_FRAME = ItemTypes.key(ResourceKey.minecraft("end_portal_frame"));

    public static final DefaultedRegistryReference<ItemType> END_ROD = ItemTypes.key(ResourceKey.minecraft("end_rod"));

    public static final DefaultedRegistryReference<ItemType> END_STONE = ItemTypes.key(ResourceKey.minecraft("end_stone"));

    public static final DefaultedRegistryReference<ItemType> END_STONE_BRICK_SLAB = ItemTypes.key(ResourceKey.minecraft("end_stone_brick_slab"));

    public static final DefaultedRegistryReference<ItemType> END_STONE_BRICK_STAIRS = ItemTypes.key(ResourceKey.minecraft("end_stone_brick_stairs"));

    public static final DefaultedRegistryReference<ItemType> END_STONE_BRICK_WALL = ItemTypes.key(ResourceKey.minecraft("end_stone_brick_wall"));

    public static final DefaultedRegistryReference<ItemType> END_STONE_BRICKS = ItemTypes.key(ResourceKey.minecraft("end_stone_bricks"));

    public static final DefaultedRegistryReference<ItemType> ENDER_CHEST = ItemTypes.key(ResourceKey.minecraft("ender_chest"));

    public static final DefaultedRegistryReference<ItemType> ENDER_EYE = ItemTypes.key(ResourceKey.minecraft("ender_eye"));

    public static final DefaultedRegistryReference<ItemType> ENDER_PEARL = ItemTypes.key(ResourceKey.minecraft("ender_pearl"));

    public static final DefaultedRegistryReference<ItemType> ENDERMAN_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("enderman_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> ENDERMITE_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("endermite_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> EVOKER_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("evoker_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> EXPERIENCE_BOTTLE = ItemTypes.key(ResourceKey.minecraft("experience_bottle"));

    public static final DefaultedRegistryReference<ItemType> FARMLAND = ItemTypes.key(ResourceKey.minecraft("farmland"));

    public static final DefaultedRegistryReference<ItemType> FEATHER = ItemTypes.key(ResourceKey.minecraft("feather"));

    public static final DefaultedRegistryReference<ItemType> FERMENTED_SPIDER_EYE = ItemTypes.key(ResourceKey.minecraft("fermented_spider_eye"));

    public static final DefaultedRegistryReference<ItemType> FERN = ItemTypes.key(ResourceKey.minecraft("fern"));

    public static final DefaultedRegistryReference<ItemType> FILLED_MAP = ItemTypes.key(ResourceKey.minecraft("filled_map"));

    public static final DefaultedRegistryReference<ItemType> FIRE_CHARGE = ItemTypes.key(ResourceKey.minecraft("fire_charge"));

    public static final DefaultedRegistryReference<ItemType> FIRE_CORAL = ItemTypes.key(ResourceKey.minecraft("fire_coral"));

    public static final DefaultedRegistryReference<ItemType> FIRE_CORAL_BLOCK = ItemTypes.key(ResourceKey.minecraft("fire_coral_block"));

    public static final DefaultedRegistryReference<ItemType> FIRE_CORAL_FAN = ItemTypes.key(ResourceKey.minecraft("fire_coral_fan"));

    public static final DefaultedRegistryReference<ItemType> FIREWORK_ROCKET = ItemTypes.key(ResourceKey.minecraft("firework_rocket"));

    public static final DefaultedRegistryReference<ItemType> FIREWORK_STAR = ItemTypes.key(ResourceKey.minecraft("firework_star"));

    public static final DefaultedRegistryReference<ItemType> FISHING_ROD = ItemTypes.key(ResourceKey.minecraft("fishing_rod"));

    public static final DefaultedRegistryReference<ItemType> FLETCHING_TABLE = ItemTypes.key(ResourceKey.minecraft("fletching_table"));

    public static final DefaultedRegistryReference<ItemType> FLINT = ItemTypes.key(ResourceKey.minecraft("flint"));

    public static final DefaultedRegistryReference<ItemType> FLINT_AND_STEEL = ItemTypes.key(ResourceKey.minecraft("flint_and_steel"));

    public static final DefaultedRegistryReference<ItemType> FLOWER_BANNER_PATTERN = ItemTypes.key(ResourceKey.minecraft("flower_banner_pattern"));

    public static final DefaultedRegistryReference<ItemType> FLOWER_POT = ItemTypes.key(ResourceKey.minecraft("flower_pot"));

    public static final DefaultedRegistryReference<ItemType> FOX_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("fox_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> FURNACE = ItemTypes.key(ResourceKey.minecraft("furnace"));

    public static final DefaultedRegistryReference<ItemType> FURNACE_MINECART = ItemTypes.key(ResourceKey.minecraft("furnace_minecart"));

    public static final DefaultedRegistryReference<ItemType> GHAST_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("ghast_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> GHAST_TEAR = ItemTypes.key(ResourceKey.minecraft("ghast_tear"));

    public static final DefaultedRegistryReference<ItemType> GILDED_BLACKSTONE = ItemTypes.key(ResourceKey.minecraft("gilded_blackstone"));

    public static final DefaultedRegistryReference<ItemType> GLASS = ItemTypes.key(ResourceKey.minecraft("glass"));

    public static final DefaultedRegistryReference<ItemType> GLASS_BOTTLE = ItemTypes.key(ResourceKey.minecraft("glass_bottle"));

    public static final DefaultedRegistryReference<ItemType> GLASS_PANE = ItemTypes.key(ResourceKey.minecraft("glass_pane"));

    public static final DefaultedRegistryReference<ItemType> GLISTERING_MELON_SLICE = ItemTypes.key(ResourceKey.minecraft("glistering_melon_slice"));

    public static final DefaultedRegistryReference<ItemType> GLOBE_BANNER_PATTERN = ItemTypes.key(ResourceKey.minecraft("globe_banner_pattern"));

    public static final DefaultedRegistryReference<ItemType> GLOW_INK_SAC = ItemTypes.key(ResourceKey.minecraft("glow_ink_sac"));

    public static final DefaultedRegistryReference<ItemType> GLOW_ITEM_FRAME = ItemTypes.key(ResourceKey.minecraft("glow_item_frame"));

    public static final DefaultedRegistryReference<ItemType> GLOW_LICHEN = ItemTypes.key(ResourceKey.minecraft("glow_lichen"));

    public static final DefaultedRegistryReference<ItemType> GLOW_SQUID_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("glow_squid_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> GLOWSTONE = ItemTypes.key(ResourceKey.minecraft("glowstone"));

    public static final DefaultedRegistryReference<ItemType> GLOWSTONE_DUST = ItemTypes.key(ResourceKey.minecraft("glowstone_dust"));

    public static final DefaultedRegistryReference<ItemType> GOLD_BLOCK = ItemTypes.key(ResourceKey.minecraft("gold_block"));

    public static final DefaultedRegistryReference<ItemType> GOLD_INGOT = ItemTypes.key(ResourceKey.minecraft("gold_ingot"));

    public static final DefaultedRegistryReference<ItemType> GOLD_NUGGET = ItemTypes.key(ResourceKey.minecraft("gold_nugget"));

    public static final DefaultedRegistryReference<ItemType> GOLD_ORE = ItemTypes.key(ResourceKey.minecraft("gold_ore"));

    public static final DefaultedRegistryReference<ItemType> GOLDEN_APPLE = ItemTypes.key(ResourceKey.minecraft("golden_apple"));

    public static final DefaultedRegistryReference<ItemType> GOLDEN_AXE = ItemTypes.key(ResourceKey.minecraft("golden_axe"));

    public static final DefaultedRegistryReference<ItemType> GOLDEN_BOOTS = ItemTypes.key(ResourceKey.minecraft("golden_boots"));

    public static final DefaultedRegistryReference<ItemType> GOLDEN_CARROT = ItemTypes.key(ResourceKey.minecraft("golden_carrot"));

    public static final DefaultedRegistryReference<ItemType> GOLDEN_CHESTPLATE = ItemTypes.key(ResourceKey.minecraft("golden_chestplate"));

    public static final DefaultedRegistryReference<ItemType> GOLDEN_HELMET = ItemTypes.key(ResourceKey.minecraft("golden_helmet"));

    public static final DefaultedRegistryReference<ItemType> GOLDEN_HOE = ItemTypes.key(ResourceKey.minecraft("golden_hoe"));

    public static final DefaultedRegistryReference<ItemType> GOLDEN_HORSE_ARMOR = ItemTypes.key(ResourceKey.minecraft("golden_horse_armor"));

    public static final DefaultedRegistryReference<ItemType> GOLDEN_LEGGINGS = ItemTypes.key(ResourceKey.minecraft("golden_leggings"));

    public static final DefaultedRegistryReference<ItemType> GOLDEN_PICKAXE = ItemTypes.key(ResourceKey.minecraft("golden_pickaxe"));

    public static final DefaultedRegistryReference<ItemType> GOLDEN_SHOVEL = ItemTypes.key(ResourceKey.minecraft("golden_shovel"));

    public static final DefaultedRegistryReference<ItemType> GOLDEN_SWORD = ItemTypes.key(ResourceKey.minecraft("golden_sword"));

    public static final DefaultedRegistryReference<ItemType> GRANITE = ItemTypes.key(ResourceKey.minecraft("granite"));

    public static final DefaultedRegistryReference<ItemType> GRANITE_SLAB = ItemTypes.key(ResourceKey.minecraft("granite_slab"));

    public static final DefaultedRegistryReference<ItemType> GRANITE_STAIRS = ItemTypes.key(ResourceKey.minecraft("granite_stairs"));

    public static final DefaultedRegistryReference<ItemType> GRANITE_WALL = ItemTypes.key(ResourceKey.minecraft("granite_wall"));

    public static final DefaultedRegistryReference<ItemType> GRASS = ItemTypes.key(ResourceKey.minecraft("grass"));

    public static final DefaultedRegistryReference<ItemType> GRASS_BLOCK = ItemTypes.key(ResourceKey.minecraft("grass_block"));

    public static final DefaultedRegistryReference<ItemType> GRAVEL = ItemTypes.key(ResourceKey.minecraft("gravel"));

    public static final DefaultedRegistryReference<ItemType> GRAY_BANNER = ItemTypes.key(ResourceKey.minecraft("gray_banner"));

    public static final DefaultedRegistryReference<ItemType> GRAY_BED = ItemTypes.key(ResourceKey.minecraft("gray_bed"));

    public static final DefaultedRegistryReference<ItemType> GRAY_CANDLE = ItemTypes.key(ResourceKey.minecraft("gray_candle"));

    public static final DefaultedRegistryReference<ItemType> GRAY_CARPET = ItemTypes.key(ResourceKey.minecraft("gray_carpet"));

    public static final DefaultedRegistryReference<ItemType> GRAY_CONCRETE = ItemTypes.key(ResourceKey.minecraft("gray_concrete"));

    public static final DefaultedRegistryReference<ItemType> GRAY_CONCRETE_POWDER = ItemTypes.key(ResourceKey.minecraft("gray_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> GRAY_DYE = ItemTypes.key(ResourceKey.minecraft("gray_dye"));

    public static final DefaultedRegistryReference<ItemType> GRAY_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("gray_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> GRAY_SHULKER_BOX = ItemTypes.key(ResourceKey.minecraft("gray_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> GRAY_STAINED_GLASS = ItemTypes.key(ResourceKey.minecraft("gray_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> GRAY_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.minecraft("gray_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> GRAY_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("gray_terracotta"));

    public static final DefaultedRegistryReference<ItemType> GRAY_WOOL = ItemTypes.key(ResourceKey.minecraft("gray_wool"));

    public static final DefaultedRegistryReference<ItemType> GREEN_BANNER = ItemTypes.key(ResourceKey.minecraft("green_banner"));

    public static final DefaultedRegistryReference<ItemType> GREEN_BED = ItemTypes.key(ResourceKey.minecraft("green_bed"));

    public static final DefaultedRegistryReference<ItemType> GREEN_CANDLE = ItemTypes.key(ResourceKey.minecraft("green_candle"));

    public static final DefaultedRegistryReference<ItemType> GREEN_CARPET = ItemTypes.key(ResourceKey.minecraft("green_carpet"));

    public static final DefaultedRegistryReference<ItemType> GREEN_CONCRETE = ItemTypes.key(ResourceKey.minecraft("green_concrete"));

    public static final DefaultedRegistryReference<ItemType> GREEN_CONCRETE_POWDER = ItemTypes.key(ResourceKey.minecraft("green_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> GREEN_DYE = ItemTypes.key(ResourceKey.minecraft("green_dye"));

    public static final DefaultedRegistryReference<ItemType> GREEN_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("green_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> GREEN_SHULKER_BOX = ItemTypes.key(ResourceKey.minecraft("green_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> GREEN_STAINED_GLASS = ItemTypes.key(ResourceKey.minecraft("green_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> GREEN_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.minecraft("green_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> GREEN_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("green_terracotta"));

    public static final DefaultedRegistryReference<ItemType> GREEN_WOOL = ItemTypes.key(ResourceKey.minecraft("green_wool"));

    public static final DefaultedRegistryReference<ItemType> GRINDSTONE = ItemTypes.key(ResourceKey.minecraft("grindstone"));

    public static final DefaultedRegistryReference<ItemType> GUARDIAN_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("guardian_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> GUNPOWDER = ItemTypes.key(ResourceKey.minecraft("gunpowder"));

    public static final DefaultedRegistryReference<ItemType> HAY_BLOCK = ItemTypes.key(ResourceKey.minecraft("hay_block"));

    public static final DefaultedRegistryReference<ItemType> HEART_OF_THE_SEA = ItemTypes.key(ResourceKey.minecraft("heart_of_the_sea"));

    public static final DefaultedRegistryReference<ItemType> HEAVY_WEIGHTED_PRESSURE_PLATE = ItemTypes.key(ResourceKey.minecraft("heavy_weighted_pressure_plate"));

    public static final DefaultedRegistryReference<ItemType> HOGLIN_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("hoglin_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> HONEY_BLOCK = ItemTypes.key(ResourceKey.minecraft("honey_block"));

    public static final DefaultedRegistryReference<ItemType> HONEY_BOTTLE = ItemTypes.key(ResourceKey.minecraft("honey_bottle"));

    public static final DefaultedRegistryReference<ItemType> HONEYCOMB = ItemTypes.key(ResourceKey.minecraft("honeycomb"));

    public static final DefaultedRegistryReference<ItemType> HONEYCOMB_BLOCK = ItemTypes.key(ResourceKey.minecraft("honeycomb_block"));

    public static final DefaultedRegistryReference<ItemType> HOPPER = ItemTypes.key(ResourceKey.minecraft("hopper"));

    public static final DefaultedRegistryReference<ItemType> HOPPER_MINECART = ItemTypes.key(ResourceKey.minecraft("hopper_minecart"));

    public static final DefaultedRegistryReference<ItemType> HORN_CORAL = ItemTypes.key(ResourceKey.minecraft("horn_coral"));

    public static final DefaultedRegistryReference<ItemType> HORN_CORAL_BLOCK = ItemTypes.key(ResourceKey.minecraft("horn_coral_block"));

    public static final DefaultedRegistryReference<ItemType> HORN_CORAL_FAN = ItemTypes.key(ResourceKey.minecraft("horn_coral_fan"));

    public static final DefaultedRegistryReference<ItemType> HORSE_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("horse_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> HUSK_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("husk_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> ICE = ItemTypes.key(ResourceKey.minecraft("ice"));

    public static final DefaultedRegistryReference<ItemType> INFESTED_CHISELED_STONE_BRICKS = ItemTypes.key(ResourceKey.minecraft("infested_chiseled_stone_bricks"));

    public static final DefaultedRegistryReference<ItemType> INFESTED_COBBLESTONE = ItemTypes.key(ResourceKey.minecraft("infested_cobblestone"));

    public static final DefaultedRegistryReference<ItemType> INFESTED_CRACKED_STONE_BRICKS = ItemTypes.key(ResourceKey.minecraft("infested_cracked_stone_bricks"));

    public static final DefaultedRegistryReference<ItemType> INFESTED_MOSSY_STONE_BRICKS = ItemTypes.key(ResourceKey.minecraft("infested_mossy_stone_bricks"));

    public static final DefaultedRegistryReference<ItemType> INFESTED_STONE = ItemTypes.key(ResourceKey.minecraft("infested_stone"));

    public static final DefaultedRegistryReference<ItemType> INFESTED_STONE_BRICKS = ItemTypes.key(ResourceKey.minecraft("infested_stone_bricks"));

    public static final DefaultedRegistryReference<ItemType> INK_SAC = ItemTypes.key(ResourceKey.minecraft("ink_sac"));

    public static final DefaultedRegistryReference<ItemType> IRON_AXE = ItemTypes.key(ResourceKey.minecraft("iron_axe"));

    public static final DefaultedRegistryReference<ItemType> IRON_BARS = ItemTypes.key(ResourceKey.minecraft("iron_bars"));

    public static final DefaultedRegistryReference<ItemType> IRON_BLOCK = ItemTypes.key(ResourceKey.minecraft("iron_block"));

    public static final DefaultedRegistryReference<ItemType> IRON_BOOTS = ItemTypes.key(ResourceKey.minecraft("iron_boots"));

    public static final DefaultedRegistryReference<ItemType> IRON_CHESTPLATE = ItemTypes.key(ResourceKey.minecraft("iron_chestplate"));

    public static final DefaultedRegistryReference<ItemType> IRON_DOOR = ItemTypes.key(ResourceKey.minecraft("iron_door"));

    public static final DefaultedRegistryReference<ItemType> IRON_HELMET = ItemTypes.key(ResourceKey.minecraft("iron_helmet"));

    public static final DefaultedRegistryReference<ItemType> IRON_HOE = ItemTypes.key(ResourceKey.minecraft("iron_hoe"));

    public static final DefaultedRegistryReference<ItemType> IRON_HORSE_ARMOR = ItemTypes.key(ResourceKey.minecraft("iron_horse_armor"));

    public static final DefaultedRegistryReference<ItemType> IRON_INGOT = ItemTypes.key(ResourceKey.minecraft("iron_ingot"));

    public static final DefaultedRegistryReference<ItemType> IRON_LEGGINGS = ItemTypes.key(ResourceKey.minecraft("iron_leggings"));

    public static final DefaultedRegistryReference<ItemType> IRON_NUGGET = ItemTypes.key(ResourceKey.minecraft("iron_nugget"));

    public static final DefaultedRegistryReference<ItemType> IRON_ORE = ItemTypes.key(ResourceKey.minecraft("iron_ore"));

    public static final DefaultedRegistryReference<ItemType> IRON_PICKAXE = ItemTypes.key(ResourceKey.minecraft("iron_pickaxe"));

    public static final DefaultedRegistryReference<ItemType> IRON_SHOVEL = ItemTypes.key(ResourceKey.minecraft("iron_shovel"));

    public static final DefaultedRegistryReference<ItemType> IRON_SWORD = ItemTypes.key(ResourceKey.minecraft("iron_sword"));

    public static final DefaultedRegistryReference<ItemType> IRON_TRAPDOOR = ItemTypes.key(ResourceKey.minecraft("iron_trapdoor"));

    public static final DefaultedRegistryReference<ItemType> ITEM_FRAME = ItemTypes.key(ResourceKey.minecraft("item_frame"));

    public static final DefaultedRegistryReference<ItemType> JACK_O_LANTERN = ItemTypes.key(ResourceKey.minecraft("jack_o_lantern"));

    public static final DefaultedRegistryReference<ItemType> JIGSAW = ItemTypes.key(ResourceKey.minecraft("jigsaw"));

    public static final DefaultedRegistryReference<ItemType> JUKEBOX = ItemTypes.key(ResourceKey.minecraft("jukebox"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_BOAT = ItemTypes.key(ResourceKey.minecraft("jungle_boat"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_BUTTON = ItemTypes.key(ResourceKey.minecraft("jungle_button"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_DOOR = ItemTypes.key(ResourceKey.minecraft("jungle_door"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_FENCE = ItemTypes.key(ResourceKey.minecraft("jungle_fence"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_FENCE_GATE = ItemTypes.key(ResourceKey.minecraft("jungle_fence_gate"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_LEAVES = ItemTypes.key(ResourceKey.minecraft("jungle_leaves"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_LOG = ItemTypes.key(ResourceKey.minecraft("jungle_log"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_PLANKS = ItemTypes.key(ResourceKey.minecraft("jungle_planks"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_PRESSURE_PLATE = ItemTypes.key(ResourceKey.minecraft("jungle_pressure_plate"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_SAPLING = ItemTypes.key(ResourceKey.minecraft("jungle_sapling"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_SIGN = ItemTypes.key(ResourceKey.minecraft("jungle_sign"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_SLAB = ItemTypes.key(ResourceKey.minecraft("jungle_slab"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_STAIRS = ItemTypes.key(ResourceKey.minecraft("jungle_stairs"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_TRAPDOOR = ItemTypes.key(ResourceKey.minecraft("jungle_trapdoor"));

    public static final DefaultedRegistryReference<ItemType> JUNGLE_WOOD = ItemTypes.key(ResourceKey.minecraft("jungle_wood"));

    public static final DefaultedRegistryReference<ItemType> KELP = ItemTypes.key(ResourceKey.minecraft("kelp"));

    public static final DefaultedRegistryReference<ItemType> KNOWLEDGE_BOOK = ItemTypes.key(ResourceKey.minecraft("knowledge_book"));

    public static final DefaultedRegistryReference<ItemType> LADDER = ItemTypes.key(ResourceKey.minecraft("ladder"));

    public static final DefaultedRegistryReference<ItemType> LANTERN = ItemTypes.key(ResourceKey.minecraft("lantern"));

    public static final DefaultedRegistryReference<ItemType> LAPIS_BLOCK = ItemTypes.key(ResourceKey.minecraft("lapis_block"));

    public static final DefaultedRegistryReference<ItemType> LAPIS_LAZULI = ItemTypes.key(ResourceKey.minecraft("lapis_lazuli"));

    public static final DefaultedRegistryReference<ItemType> LAPIS_ORE = ItemTypes.key(ResourceKey.minecraft("lapis_ore"));

    public static final DefaultedRegistryReference<ItemType> LARGE_AMETHYST_BUD = ItemTypes.key(ResourceKey.minecraft("large_amethyst_bud"));

    public static final DefaultedRegistryReference<ItemType> LARGE_FERN = ItemTypes.key(ResourceKey.minecraft("large_fern"));

    public static final DefaultedRegistryReference<ItemType> LAVA_BUCKET = ItemTypes.key(ResourceKey.minecraft("lava_bucket"));

    public static final DefaultedRegistryReference<ItemType> LEAD = ItemTypes.key(ResourceKey.minecraft("lead"));

    public static final DefaultedRegistryReference<ItemType> LEATHER = ItemTypes.key(ResourceKey.minecraft("leather"));

    public static final DefaultedRegistryReference<ItemType> LEATHER_BOOTS = ItemTypes.key(ResourceKey.minecraft("leather_boots"));

    public static final DefaultedRegistryReference<ItemType> LEATHER_CHESTPLATE = ItemTypes.key(ResourceKey.minecraft("leather_chestplate"));

    public static final DefaultedRegistryReference<ItemType> LEATHER_HELMET = ItemTypes.key(ResourceKey.minecraft("leather_helmet"));

    public static final DefaultedRegistryReference<ItemType> LEATHER_HORSE_ARMOR = ItemTypes.key(ResourceKey.minecraft("leather_horse_armor"));

    public static final DefaultedRegistryReference<ItemType> LEATHER_LEGGINGS = ItemTypes.key(ResourceKey.minecraft("leather_leggings"));

    public static final DefaultedRegistryReference<ItemType> LECTERN = ItemTypes.key(ResourceKey.minecraft("lectern"));

    public static final DefaultedRegistryReference<ItemType> LEVER = ItemTypes.key(ResourceKey.minecraft("lever"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_BLUE_BANNER = ItemTypes.key(ResourceKey.minecraft("light_blue_banner"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_BLUE_BED = ItemTypes.key(ResourceKey.minecraft("light_blue_bed"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_BLUE_CANDLE = ItemTypes.key(ResourceKey.minecraft("light_blue_candle"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_BLUE_CARPET = ItemTypes.key(ResourceKey.minecraft("light_blue_carpet"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_BLUE_CONCRETE = ItemTypes.key(ResourceKey.minecraft("light_blue_concrete"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_BLUE_CONCRETE_POWDER = ItemTypes.key(ResourceKey.minecraft("light_blue_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_BLUE_DYE = ItemTypes.key(ResourceKey.minecraft("light_blue_dye"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_BLUE_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("light_blue_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_BLUE_SHULKER_BOX = ItemTypes.key(ResourceKey.minecraft("light_blue_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_BLUE_STAINED_GLASS = ItemTypes.key(ResourceKey.minecraft("light_blue_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_BLUE_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.minecraft("light_blue_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_BLUE_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("light_blue_terracotta"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_BLUE_WOOL = ItemTypes.key(ResourceKey.minecraft("light_blue_wool"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_GRAY_BANNER = ItemTypes.key(ResourceKey.minecraft("light_gray_banner"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_GRAY_BED = ItemTypes.key(ResourceKey.minecraft("light_gray_bed"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_GRAY_CANDLE = ItemTypes.key(ResourceKey.minecraft("light_gray_candle"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_GRAY_CARPET = ItemTypes.key(ResourceKey.minecraft("light_gray_carpet"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_GRAY_CONCRETE = ItemTypes.key(ResourceKey.minecraft("light_gray_concrete"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_GRAY_CONCRETE_POWDER = ItemTypes.key(ResourceKey.minecraft("light_gray_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_GRAY_DYE = ItemTypes.key(ResourceKey.minecraft("light_gray_dye"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_GRAY_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("light_gray_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_GRAY_SHULKER_BOX = ItemTypes.key(ResourceKey.minecraft("light_gray_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_GRAY_STAINED_GLASS = ItemTypes.key(ResourceKey.minecraft("light_gray_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_GRAY_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.minecraft("light_gray_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_GRAY_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("light_gray_terracotta"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_GRAY_WOOL = ItemTypes.key(ResourceKey.minecraft("light_gray_wool"));

    public static final DefaultedRegistryReference<ItemType> LIGHT_WEIGHTED_PRESSURE_PLATE = ItemTypes.key(ResourceKey.minecraft("light_weighted_pressure_plate"));

    public static final DefaultedRegistryReference<ItemType> LIGHTLY_WEATHERED_COPPER_BLOCK = ItemTypes.key(ResourceKey.minecraft("lightly_weathered_copper_block"));

    public static final DefaultedRegistryReference<ItemType> LIGHTLY_WEATHERED_CUT_COPPER = ItemTypes.key(ResourceKey.minecraft("lightly_weathered_cut_copper"));

    public static final DefaultedRegistryReference<ItemType> LIGHTLY_WEATHERED_CUT_COPPER_SLAB = ItemTypes.key(ResourceKey.minecraft("lightly_weathered_cut_copper_slab"));

    public static final DefaultedRegistryReference<ItemType> LIGHTLY_WEATHERED_CUT_COPPER_STAIRS = ItemTypes.key(ResourceKey.minecraft("lightly_weathered_cut_copper_stairs"));

    public static final DefaultedRegistryReference<ItemType> LIGHTNING_ROD = ItemTypes.key(ResourceKey.minecraft("lightning_rod"));

    public static final DefaultedRegistryReference<ItemType> LILAC = ItemTypes.key(ResourceKey.minecraft("lilac"));

    public static final DefaultedRegistryReference<ItemType> LILY_OF_THE_VALLEY = ItemTypes.key(ResourceKey.minecraft("lily_of_the_valley"));

    public static final DefaultedRegistryReference<ItemType> LILY_PAD = ItemTypes.key(ResourceKey.minecraft("lily_pad"));

    public static final DefaultedRegistryReference<ItemType> LIME_BANNER = ItemTypes.key(ResourceKey.minecraft("lime_banner"));

    public static final DefaultedRegistryReference<ItemType> LIME_BED = ItemTypes.key(ResourceKey.minecraft("lime_bed"));

    public static final DefaultedRegistryReference<ItemType> LIME_CANDLE = ItemTypes.key(ResourceKey.minecraft("lime_candle"));

    public static final DefaultedRegistryReference<ItemType> LIME_CARPET = ItemTypes.key(ResourceKey.minecraft("lime_carpet"));

    public static final DefaultedRegistryReference<ItemType> LIME_CONCRETE = ItemTypes.key(ResourceKey.minecraft("lime_concrete"));

    public static final DefaultedRegistryReference<ItemType> LIME_CONCRETE_POWDER = ItemTypes.key(ResourceKey.minecraft("lime_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> LIME_DYE = ItemTypes.key(ResourceKey.minecraft("lime_dye"));

    public static final DefaultedRegistryReference<ItemType> LIME_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("lime_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> LIME_SHULKER_BOX = ItemTypes.key(ResourceKey.minecraft("lime_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> LIME_STAINED_GLASS = ItemTypes.key(ResourceKey.minecraft("lime_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> LIME_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.minecraft("lime_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> LIME_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("lime_terracotta"));

    public static final DefaultedRegistryReference<ItemType> LIME_WOOL = ItemTypes.key(ResourceKey.minecraft("lime_wool"));

    public static final DefaultedRegistryReference<ItemType> LINGERING_POTION = ItemTypes.key(ResourceKey.minecraft("lingering_potion"));

    public static final DefaultedRegistryReference<ItemType> LLAMA_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("llama_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> LODESTONE = ItemTypes.key(ResourceKey.minecraft("lodestone"));

    public static final DefaultedRegistryReference<ItemType> LOOM = ItemTypes.key(ResourceKey.minecraft("loom"));

    public static final DefaultedRegistryReference<ItemType> MAGENTA_BANNER = ItemTypes.key(ResourceKey.minecraft("magenta_banner"));

    public static final DefaultedRegistryReference<ItemType> MAGENTA_BED = ItemTypes.key(ResourceKey.minecraft("magenta_bed"));

    public static final DefaultedRegistryReference<ItemType> MAGENTA_CANDLE = ItemTypes.key(ResourceKey.minecraft("magenta_candle"));

    public static final DefaultedRegistryReference<ItemType> MAGENTA_CARPET = ItemTypes.key(ResourceKey.minecraft("magenta_carpet"));

    public static final DefaultedRegistryReference<ItemType> MAGENTA_CONCRETE = ItemTypes.key(ResourceKey.minecraft("magenta_concrete"));

    public static final DefaultedRegistryReference<ItemType> MAGENTA_CONCRETE_POWDER = ItemTypes.key(ResourceKey.minecraft("magenta_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> MAGENTA_DYE = ItemTypes.key(ResourceKey.minecraft("magenta_dye"));

    public static final DefaultedRegistryReference<ItemType> MAGENTA_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("magenta_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> MAGENTA_SHULKER_BOX = ItemTypes.key(ResourceKey.minecraft("magenta_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> MAGENTA_STAINED_GLASS = ItemTypes.key(ResourceKey.minecraft("magenta_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> MAGENTA_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.minecraft("magenta_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> MAGENTA_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("magenta_terracotta"));

    public static final DefaultedRegistryReference<ItemType> MAGENTA_WOOL = ItemTypes.key(ResourceKey.minecraft("magenta_wool"));

    public static final DefaultedRegistryReference<ItemType> MAGMA_BLOCK = ItemTypes.key(ResourceKey.minecraft("magma_block"));

    public static final DefaultedRegistryReference<ItemType> MAGMA_CREAM = ItemTypes.key(ResourceKey.minecraft("magma_cream"));

    public static final DefaultedRegistryReference<ItemType> MAGMA_CUBE_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("magma_cube_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> MAP = ItemTypes.key(ResourceKey.minecraft("map"));

    public static final DefaultedRegistryReference<ItemType> MEDIUM_AMETHYST_BUD = ItemTypes.key(ResourceKey.minecraft("medium_amethyst_bud"));

    public static final DefaultedRegistryReference<ItemType> MELON = ItemTypes.key(ResourceKey.minecraft("melon"));

    public static final DefaultedRegistryReference<ItemType> MELON_SEEDS = ItemTypes.key(ResourceKey.minecraft("melon_seeds"));

    public static final DefaultedRegistryReference<ItemType> MELON_SLICE = ItemTypes.key(ResourceKey.minecraft("melon_slice"));

    public static final DefaultedRegistryReference<ItemType> MILK_BUCKET = ItemTypes.key(ResourceKey.minecraft("milk_bucket"));

    public static final DefaultedRegistryReference<ItemType> MINECART = ItemTypes.key(ResourceKey.minecraft("minecart"));

    public static final DefaultedRegistryReference<ItemType> MOJANG_BANNER_PATTERN = ItemTypes.key(ResourceKey.minecraft("mojang_banner_pattern"));

    public static final DefaultedRegistryReference<ItemType> MOOSHROOM_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("mooshroom_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> MOSSY_COBBLESTONE = ItemTypes.key(ResourceKey.minecraft("mossy_cobblestone"));

    public static final DefaultedRegistryReference<ItemType> MOSSY_COBBLESTONE_SLAB = ItemTypes.key(ResourceKey.minecraft("mossy_cobblestone_slab"));

    public static final DefaultedRegistryReference<ItemType> MOSSY_COBBLESTONE_STAIRS = ItemTypes.key(ResourceKey.minecraft("mossy_cobblestone_stairs"));

    public static final DefaultedRegistryReference<ItemType> MOSSY_COBBLESTONE_WALL = ItemTypes.key(ResourceKey.minecraft("mossy_cobblestone_wall"));

    public static final DefaultedRegistryReference<ItemType> MOSSY_STONE_BRICK_SLAB = ItemTypes.key(ResourceKey.minecraft("mossy_stone_brick_slab"));

    public static final DefaultedRegistryReference<ItemType> MOSSY_STONE_BRICK_STAIRS = ItemTypes.key(ResourceKey.minecraft("mossy_stone_brick_stairs"));

    public static final DefaultedRegistryReference<ItemType> MOSSY_STONE_BRICK_WALL = ItemTypes.key(ResourceKey.minecraft("mossy_stone_brick_wall"));

    public static final DefaultedRegistryReference<ItemType> MOSSY_STONE_BRICKS = ItemTypes.key(ResourceKey.minecraft("mossy_stone_bricks"));

    public static final DefaultedRegistryReference<ItemType> MULE_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("mule_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> MUSHROOM_STEM = ItemTypes.key(ResourceKey.minecraft("mushroom_stem"));

    public static final DefaultedRegistryReference<ItemType> MUSHROOM_STEW = ItemTypes.key(ResourceKey.minecraft("mushroom_stew"));

    public static final DefaultedRegistryReference<ItemType> MUSIC_DISC_11 = ItemTypes.key(ResourceKey.minecraft("music_disc_11"));

    public static final DefaultedRegistryReference<ItemType> MUSIC_DISC_13 = ItemTypes.key(ResourceKey.minecraft("music_disc_13"));

    public static final DefaultedRegistryReference<ItemType> MUSIC_DISC_BLOCKS = ItemTypes.key(ResourceKey.minecraft("music_disc_blocks"));

    public static final DefaultedRegistryReference<ItemType> MUSIC_DISC_CAT = ItemTypes.key(ResourceKey.minecraft("music_disc_cat"));

    public static final DefaultedRegistryReference<ItemType> MUSIC_DISC_CHIRP = ItemTypes.key(ResourceKey.minecraft("music_disc_chirp"));

    public static final DefaultedRegistryReference<ItemType> MUSIC_DISC_FAR = ItemTypes.key(ResourceKey.minecraft("music_disc_far"));

    public static final DefaultedRegistryReference<ItemType> MUSIC_DISC_MALL = ItemTypes.key(ResourceKey.minecraft("music_disc_mall"));

    public static final DefaultedRegistryReference<ItemType> MUSIC_DISC_MELLOHI = ItemTypes.key(ResourceKey.minecraft("music_disc_mellohi"));

    public static final DefaultedRegistryReference<ItemType> MUSIC_DISC_PIGSTEP = ItemTypes.key(ResourceKey.minecraft("music_disc_pigstep"));

    public static final DefaultedRegistryReference<ItemType> MUSIC_DISC_STAL = ItemTypes.key(ResourceKey.minecraft("music_disc_stal"));

    public static final DefaultedRegistryReference<ItemType> MUSIC_DISC_STRAD = ItemTypes.key(ResourceKey.minecraft("music_disc_strad"));

    public static final DefaultedRegistryReference<ItemType> MUSIC_DISC_WAIT = ItemTypes.key(ResourceKey.minecraft("music_disc_wait"));

    public static final DefaultedRegistryReference<ItemType> MUSIC_DISC_WARD = ItemTypes.key(ResourceKey.minecraft("music_disc_ward"));

    public static final DefaultedRegistryReference<ItemType> MUTTON = ItemTypes.key(ResourceKey.minecraft("mutton"));

    public static final DefaultedRegistryReference<ItemType> MYCELIUM = ItemTypes.key(ResourceKey.minecraft("mycelium"));

    public static final DefaultedRegistryReference<ItemType> NAME_TAG = ItemTypes.key(ResourceKey.minecraft("name_tag"));

    public static final DefaultedRegistryReference<ItemType> NAUTILUS_SHELL = ItemTypes.key(ResourceKey.minecraft("nautilus_shell"));

    public static final DefaultedRegistryReference<ItemType> NETHER_BRICK = ItemTypes.key(ResourceKey.minecraft("nether_brick"));

    public static final DefaultedRegistryReference<ItemType> NETHER_BRICK_FENCE = ItemTypes.key(ResourceKey.minecraft("nether_brick_fence"));

    public static final DefaultedRegistryReference<ItemType> NETHER_BRICK_SLAB = ItemTypes.key(ResourceKey.minecraft("nether_brick_slab"));

    public static final DefaultedRegistryReference<ItemType> NETHER_BRICK_STAIRS = ItemTypes.key(ResourceKey.minecraft("nether_brick_stairs"));

    public static final DefaultedRegistryReference<ItemType> NETHER_BRICK_WALL = ItemTypes.key(ResourceKey.minecraft("nether_brick_wall"));

    public static final DefaultedRegistryReference<ItemType> NETHER_BRICKS = ItemTypes.key(ResourceKey.minecraft("nether_bricks"));

    public static final DefaultedRegistryReference<ItemType> NETHER_GOLD_ORE = ItemTypes.key(ResourceKey.minecraft("nether_gold_ore"));

    public static final DefaultedRegistryReference<ItemType> NETHER_QUARTZ_ORE = ItemTypes.key(ResourceKey.minecraft("nether_quartz_ore"));

    public static final DefaultedRegistryReference<ItemType> NETHER_SPROUTS = ItemTypes.key(ResourceKey.minecraft("nether_sprouts"));

    public static final DefaultedRegistryReference<ItemType> NETHER_STAR = ItemTypes.key(ResourceKey.minecraft("nether_star"));

    public static final DefaultedRegistryReference<ItemType> NETHER_WART = ItemTypes.key(ResourceKey.minecraft("nether_wart"));

    public static final DefaultedRegistryReference<ItemType> NETHER_WART_BLOCK = ItemTypes.key(ResourceKey.minecraft("nether_wart_block"));

    public static final DefaultedRegistryReference<ItemType> NETHERITE_AXE = ItemTypes.key(ResourceKey.minecraft("netherite_axe"));

    public static final DefaultedRegistryReference<ItemType> NETHERITE_BLOCK = ItemTypes.key(ResourceKey.minecraft("netherite_block"));

    public static final DefaultedRegistryReference<ItemType> NETHERITE_BOOTS = ItemTypes.key(ResourceKey.minecraft("netherite_boots"));

    public static final DefaultedRegistryReference<ItemType> NETHERITE_CHESTPLATE = ItemTypes.key(ResourceKey.minecraft("netherite_chestplate"));

    public static final DefaultedRegistryReference<ItemType> NETHERITE_HELMET = ItemTypes.key(ResourceKey.minecraft("netherite_helmet"));

    public static final DefaultedRegistryReference<ItemType> NETHERITE_HOE = ItemTypes.key(ResourceKey.minecraft("netherite_hoe"));

    public static final DefaultedRegistryReference<ItemType> NETHERITE_INGOT = ItemTypes.key(ResourceKey.minecraft("netherite_ingot"));

    public static final DefaultedRegistryReference<ItemType> NETHERITE_LEGGINGS = ItemTypes.key(ResourceKey.minecraft("netherite_leggings"));

    public static final DefaultedRegistryReference<ItemType> NETHERITE_PICKAXE = ItemTypes.key(ResourceKey.minecraft("netherite_pickaxe"));

    public static final DefaultedRegistryReference<ItemType> NETHERITE_SCRAP = ItemTypes.key(ResourceKey.minecraft("netherite_scrap"));

    public static final DefaultedRegistryReference<ItemType> NETHERITE_SHOVEL = ItemTypes.key(ResourceKey.minecraft("netherite_shovel"));

    public static final DefaultedRegistryReference<ItemType> NETHERITE_SWORD = ItemTypes.key(ResourceKey.minecraft("netherite_sword"));

    public static final DefaultedRegistryReference<ItemType> NETHERRACK = ItemTypes.key(ResourceKey.minecraft("netherrack"));

    public static final DefaultedRegistryReference<ItemType> NOTE_BLOCK = ItemTypes.key(ResourceKey.minecraft("note_block"));

    public static final DefaultedRegistryReference<ItemType> OAK_BOAT = ItemTypes.key(ResourceKey.minecraft("oak_boat"));

    public static final DefaultedRegistryReference<ItemType> OAK_BUTTON = ItemTypes.key(ResourceKey.minecraft("oak_button"));

    public static final DefaultedRegistryReference<ItemType> OAK_DOOR = ItemTypes.key(ResourceKey.minecraft("oak_door"));

    public static final DefaultedRegistryReference<ItemType> OAK_FENCE = ItemTypes.key(ResourceKey.minecraft("oak_fence"));

    public static final DefaultedRegistryReference<ItemType> OAK_FENCE_GATE = ItemTypes.key(ResourceKey.minecraft("oak_fence_gate"));

    public static final DefaultedRegistryReference<ItemType> OAK_LEAVES = ItemTypes.key(ResourceKey.minecraft("oak_leaves"));

    public static final DefaultedRegistryReference<ItemType> OAK_LOG = ItemTypes.key(ResourceKey.minecraft("oak_log"));

    public static final DefaultedRegistryReference<ItemType> OAK_PLANKS = ItemTypes.key(ResourceKey.minecraft("oak_planks"));

    public static final DefaultedRegistryReference<ItemType> OAK_PRESSURE_PLATE = ItemTypes.key(ResourceKey.minecraft("oak_pressure_plate"));

    public static final DefaultedRegistryReference<ItemType> OAK_SAPLING = ItemTypes.key(ResourceKey.minecraft("oak_sapling"));

    public static final DefaultedRegistryReference<ItemType> OAK_SIGN = ItemTypes.key(ResourceKey.minecraft("oak_sign"));

    public static final DefaultedRegistryReference<ItemType> OAK_SLAB = ItemTypes.key(ResourceKey.minecraft("oak_slab"));

    public static final DefaultedRegistryReference<ItemType> OAK_STAIRS = ItemTypes.key(ResourceKey.minecraft("oak_stairs"));

    public static final DefaultedRegistryReference<ItemType> OAK_TRAPDOOR = ItemTypes.key(ResourceKey.minecraft("oak_trapdoor"));

    public static final DefaultedRegistryReference<ItemType> OAK_WOOD = ItemTypes.key(ResourceKey.minecraft("oak_wood"));

    public static final DefaultedRegistryReference<ItemType> OBSERVER = ItemTypes.key(ResourceKey.minecraft("observer"));

    public static final DefaultedRegistryReference<ItemType> OBSIDIAN = ItemTypes.key(ResourceKey.minecraft("obsidian"));

    public static final DefaultedRegistryReference<ItemType> OCELOT_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("ocelot_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_BANNER = ItemTypes.key(ResourceKey.minecraft("orange_banner"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_BED = ItemTypes.key(ResourceKey.minecraft("orange_bed"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_CANDLE = ItemTypes.key(ResourceKey.minecraft("orange_candle"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_CARPET = ItemTypes.key(ResourceKey.minecraft("orange_carpet"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_CONCRETE = ItemTypes.key(ResourceKey.minecraft("orange_concrete"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_CONCRETE_POWDER = ItemTypes.key(ResourceKey.minecraft("orange_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_DYE = ItemTypes.key(ResourceKey.minecraft("orange_dye"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("orange_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_SHULKER_BOX = ItemTypes.key(ResourceKey.minecraft("orange_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_STAINED_GLASS = ItemTypes.key(ResourceKey.minecraft("orange_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.minecraft("orange_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("orange_terracotta"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_TULIP = ItemTypes.key(ResourceKey.minecraft("orange_tulip"));

    public static final DefaultedRegistryReference<ItemType> ORANGE_WOOL = ItemTypes.key(ResourceKey.minecraft("orange_wool"));

    public static final DefaultedRegistryReference<ItemType> OXEYE_DAISY = ItemTypes.key(ResourceKey.minecraft("oxeye_daisy"));

    public static final DefaultedRegistryReference<ItemType> PACKED_ICE = ItemTypes.key(ResourceKey.minecraft("packed_ice"));

    public static final DefaultedRegistryReference<ItemType> PAINTING = ItemTypes.key(ResourceKey.minecraft("painting"));

    public static final DefaultedRegistryReference<ItemType> PANDA_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("panda_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> PAPER = ItemTypes.key(ResourceKey.minecraft("paper"));

    public static final DefaultedRegistryReference<ItemType> PARROT_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("parrot_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> PEONY = ItemTypes.key(ResourceKey.minecraft("peony"));

    public static final DefaultedRegistryReference<ItemType> PETRIFIED_OAK_SLAB = ItemTypes.key(ResourceKey.minecraft("petrified_oak_slab"));

    public static final DefaultedRegistryReference<ItemType> PHANTOM_MEMBRANE = ItemTypes.key(ResourceKey.minecraft("phantom_membrane"));

    public static final DefaultedRegistryReference<ItemType> PHANTOM_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("phantom_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> PIG_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("pig_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> PIGLIN_BANNER_PATTERN = ItemTypes.key(ResourceKey.minecraft("piglin_banner_pattern"));

    public static final DefaultedRegistryReference<ItemType> PIGLIN_BRUTE_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("piglin_brute_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> PIGLIN_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("piglin_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> PILLAGER_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("pillager_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> PINK_BANNER = ItemTypes.key(ResourceKey.minecraft("pink_banner"));

    public static final DefaultedRegistryReference<ItemType> PINK_BED = ItemTypes.key(ResourceKey.minecraft("pink_bed"));

    public static final DefaultedRegistryReference<ItemType> PINK_CANDLE = ItemTypes.key(ResourceKey.minecraft("pink_candle"));

    public static final DefaultedRegistryReference<ItemType> PINK_CARPET = ItemTypes.key(ResourceKey.minecraft("pink_carpet"));

    public static final DefaultedRegistryReference<ItemType> PINK_CONCRETE = ItemTypes.key(ResourceKey.minecraft("pink_concrete"));

    public static final DefaultedRegistryReference<ItemType> PINK_CONCRETE_POWDER = ItemTypes.key(ResourceKey.minecraft("pink_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> PINK_DYE = ItemTypes.key(ResourceKey.minecraft("pink_dye"));

    public static final DefaultedRegistryReference<ItemType> PINK_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("pink_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> PINK_SHULKER_BOX = ItemTypes.key(ResourceKey.minecraft("pink_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> PINK_STAINED_GLASS = ItemTypes.key(ResourceKey.minecraft("pink_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> PINK_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.minecraft("pink_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> PINK_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("pink_terracotta"));

    public static final DefaultedRegistryReference<ItemType> PINK_TULIP = ItemTypes.key(ResourceKey.minecraft("pink_tulip"));

    public static final DefaultedRegistryReference<ItemType> PINK_WOOL = ItemTypes.key(ResourceKey.minecraft("pink_wool"));

    public static final DefaultedRegistryReference<ItemType> PISTON = ItemTypes.key(ResourceKey.minecraft("piston"));

    public static final DefaultedRegistryReference<ItemType> PLAYER_HEAD = ItemTypes.key(ResourceKey.minecraft("player_head"));

    public static final DefaultedRegistryReference<ItemType> PODZOL = ItemTypes.key(ResourceKey.minecraft("podzol"));

    public static final DefaultedRegistryReference<ItemType> POINTED_DRIPSTONE = ItemTypes.key(ResourceKey.minecraft("pointed_dripstone"));

    public static final DefaultedRegistryReference<ItemType> POISONOUS_POTATO = ItemTypes.key(ResourceKey.minecraft("poisonous_potato"));

    public static final DefaultedRegistryReference<ItemType> POLAR_BEAR_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("polar_bear_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_ANDESITE = ItemTypes.key(ResourceKey.minecraft("polished_andesite"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_ANDESITE_SLAB = ItemTypes.key(ResourceKey.minecraft("polished_andesite_slab"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_ANDESITE_STAIRS = ItemTypes.key(ResourceKey.minecraft("polished_andesite_stairs"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_BASALT = ItemTypes.key(ResourceKey.minecraft("polished_basalt"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_BLACKSTONE = ItemTypes.key(ResourceKey.minecraft("polished_blackstone"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_BLACKSTONE_BRICK_SLAB = ItemTypes.key(ResourceKey.minecraft("polished_blackstone_brick_slab"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_BLACKSTONE_BRICK_STAIRS = ItemTypes.key(ResourceKey.minecraft("polished_blackstone_brick_stairs"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_BLACKSTONE_BRICK_WALL = ItemTypes.key(ResourceKey.minecraft("polished_blackstone_brick_wall"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_BLACKSTONE_BRICKS = ItemTypes.key(ResourceKey.minecraft("polished_blackstone_bricks"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_BLACKSTONE_BUTTON = ItemTypes.key(ResourceKey.minecraft("polished_blackstone_button"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_BLACKSTONE_PRESSURE_PLATE = ItemTypes.key(ResourceKey.minecraft("polished_blackstone_pressure_plate"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_BLACKSTONE_SLAB = ItemTypes.key(ResourceKey.minecraft("polished_blackstone_slab"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_BLACKSTONE_STAIRS = ItemTypes.key(ResourceKey.minecraft("polished_blackstone_stairs"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_BLACKSTONE_WALL = ItemTypes.key(ResourceKey.minecraft("polished_blackstone_wall"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_DIORITE = ItemTypes.key(ResourceKey.minecraft("polished_diorite"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_DIORITE_SLAB = ItemTypes.key(ResourceKey.minecraft("polished_diorite_slab"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_DIORITE_STAIRS = ItemTypes.key(ResourceKey.minecraft("polished_diorite_stairs"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_GRANITE = ItemTypes.key(ResourceKey.minecraft("polished_granite"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_GRANITE_SLAB = ItemTypes.key(ResourceKey.minecraft("polished_granite_slab"));

    public static final DefaultedRegistryReference<ItemType> POLISHED_GRANITE_STAIRS = ItemTypes.key(ResourceKey.minecraft("polished_granite_stairs"));

    public static final DefaultedRegistryReference<ItemType> POPPED_CHORUS_FRUIT = ItemTypes.key(ResourceKey.minecraft("popped_chorus_fruit"));

    public static final DefaultedRegistryReference<ItemType> POPPY = ItemTypes.key(ResourceKey.minecraft("poppy"));

    public static final DefaultedRegistryReference<ItemType> PORKCHOP = ItemTypes.key(ResourceKey.minecraft("porkchop"));

    public static final DefaultedRegistryReference<ItemType> POTATO = ItemTypes.key(ResourceKey.minecraft("potato"));

    public static final DefaultedRegistryReference<ItemType> POTION = ItemTypes.key(ResourceKey.minecraft("potion"));

    public static final DefaultedRegistryReference<ItemType> POWDER_SNOW_BUCKET = ItemTypes.key(ResourceKey.minecraft("powder_snow_bucket"));

    public static final DefaultedRegistryReference<ItemType> POWERED_RAIL = ItemTypes.key(ResourceKey.minecraft("powered_rail"));

    public static final DefaultedRegistryReference<ItemType> PRISMARINE = ItemTypes.key(ResourceKey.minecraft("prismarine"));

    public static final DefaultedRegistryReference<ItemType> PRISMARINE_BRICK_SLAB = ItemTypes.key(ResourceKey.minecraft("prismarine_brick_slab"));

    public static final DefaultedRegistryReference<ItemType> PRISMARINE_BRICK_STAIRS = ItemTypes.key(ResourceKey.minecraft("prismarine_brick_stairs"));

    public static final DefaultedRegistryReference<ItemType> PRISMARINE_BRICKS = ItemTypes.key(ResourceKey.minecraft("prismarine_bricks"));

    public static final DefaultedRegistryReference<ItemType> PRISMARINE_CRYSTALS = ItemTypes.key(ResourceKey.minecraft("prismarine_crystals"));

    public static final DefaultedRegistryReference<ItemType> PRISMARINE_SHARD = ItemTypes.key(ResourceKey.minecraft("prismarine_shard"));

    public static final DefaultedRegistryReference<ItemType> PRISMARINE_SLAB = ItemTypes.key(ResourceKey.minecraft("prismarine_slab"));

    public static final DefaultedRegistryReference<ItemType> PRISMARINE_STAIRS = ItemTypes.key(ResourceKey.minecraft("prismarine_stairs"));

    public static final DefaultedRegistryReference<ItemType> PRISMARINE_WALL = ItemTypes.key(ResourceKey.minecraft("prismarine_wall"));

    public static final DefaultedRegistryReference<ItemType> PUFFERFISH = ItemTypes.key(ResourceKey.minecraft("pufferfish"));

    public static final DefaultedRegistryReference<ItemType> PUFFERFISH_BUCKET = ItemTypes.key(ResourceKey.minecraft("pufferfish_bucket"));

    public static final DefaultedRegistryReference<ItemType> PUFFERFISH_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("pufferfish_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> PUMPKIN = ItemTypes.key(ResourceKey.minecraft("pumpkin"));

    public static final DefaultedRegistryReference<ItemType> PUMPKIN_PIE = ItemTypes.key(ResourceKey.minecraft("pumpkin_pie"));

    public static final DefaultedRegistryReference<ItemType> PUMPKIN_SEEDS = ItemTypes.key(ResourceKey.minecraft("pumpkin_seeds"));

    public static final DefaultedRegistryReference<ItemType> PURPLE_BANNER = ItemTypes.key(ResourceKey.minecraft("purple_banner"));

    public static final DefaultedRegistryReference<ItemType> PURPLE_BED = ItemTypes.key(ResourceKey.minecraft("purple_bed"));

    public static final DefaultedRegistryReference<ItemType> PURPLE_CANDLE = ItemTypes.key(ResourceKey.minecraft("purple_candle"));

    public static final DefaultedRegistryReference<ItemType> PURPLE_CARPET = ItemTypes.key(ResourceKey.minecraft("purple_carpet"));

    public static final DefaultedRegistryReference<ItemType> PURPLE_CONCRETE = ItemTypes.key(ResourceKey.minecraft("purple_concrete"));

    public static final DefaultedRegistryReference<ItemType> PURPLE_CONCRETE_POWDER = ItemTypes.key(ResourceKey.minecraft("purple_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> PURPLE_DYE = ItemTypes.key(ResourceKey.minecraft("purple_dye"));

    public static final DefaultedRegistryReference<ItemType> PURPLE_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("purple_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> PURPLE_SHULKER_BOX = ItemTypes.key(ResourceKey.minecraft("purple_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> PURPLE_STAINED_GLASS = ItemTypes.key(ResourceKey.minecraft("purple_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> PURPLE_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.minecraft("purple_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> PURPLE_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("purple_terracotta"));

    public static final DefaultedRegistryReference<ItemType> PURPLE_WOOL = ItemTypes.key(ResourceKey.minecraft("purple_wool"));

    public static final DefaultedRegistryReference<ItemType> PURPUR_BLOCK = ItemTypes.key(ResourceKey.minecraft("purpur_block"));

    public static final DefaultedRegistryReference<ItemType> PURPUR_PILLAR = ItemTypes.key(ResourceKey.minecraft("purpur_pillar"));

    public static final DefaultedRegistryReference<ItemType> PURPUR_SLAB = ItemTypes.key(ResourceKey.minecraft("purpur_slab"));

    public static final DefaultedRegistryReference<ItemType> PURPUR_STAIRS = ItemTypes.key(ResourceKey.minecraft("purpur_stairs"));

    public static final DefaultedRegistryReference<ItemType> QUARTZ = ItemTypes.key(ResourceKey.minecraft("quartz"));

    public static final DefaultedRegistryReference<ItemType> QUARTZ_BLOCK = ItemTypes.key(ResourceKey.minecraft("quartz_block"));

    public static final DefaultedRegistryReference<ItemType> QUARTZ_BRICKS = ItemTypes.key(ResourceKey.minecraft("quartz_bricks"));

    public static final DefaultedRegistryReference<ItemType> QUARTZ_PILLAR = ItemTypes.key(ResourceKey.minecraft("quartz_pillar"));

    public static final DefaultedRegistryReference<ItemType> QUARTZ_SLAB = ItemTypes.key(ResourceKey.minecraft("quartz_slab"));

    public static final DefaultedRegistryReference<ItemType> QUARTZ_STAIRS = ItemTypes.key(ResourceKey.minecraft("quartz_stairs"));

    public static final DefaultedRegistryReference<ItemType> RABBIT = ItemTypes.key(ResourceKey.minecraft("rabbit"));

    public static final DefaultedRegistryReference<ItemType> RABBIT_FOOT = ItemTypes.key(ResourceKey.minecraft("rabbit_foot"));

    public static final DefaultedRegistryReference<ItemType> RABBIT_HIDE = ItemTypes.key(ResourceKey.minecraft("rabbit_hide"));

    public static final DefaultedRegistryReference<ItemType> RABBIT_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("rabbit_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> RABBIT_STEW = ItemTypes.key(ResourceKey.minecraft("rabbit_stew"));

    public static final DefaultedRegistryReference<ItemType> RAIL = ItemTypes.key(ResourceKey.minecraft("rail"));

    public static final DefaultedRegistryReference<ItemType> RAVAGER_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("ravager_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> RED_BANNER = ItemTypes.key(ResourceKey.minecraft("red_banner"));

    public static final DefaultedRegistryReference<ItemType> RED_BED = ItemTypes.key(ResourceKey.minecraft("red_bed"));

    public static final DefaultedRegistryReference<ItemType> RED_CANDLE = ItemTypes.key(ResourceKey.minecraft("red_candle"));

    public static final DefaultedRegistryReference<ItemType> RED_CARPET = ItemTypes.key(ResourceKey.minecraft("red_carpet"));

    public static final DefaultedRegistryReference<ItemType> RED_CONCRETE = ItemTypes.key(ResourceKey.minecraft("red_concrete"));

    public static final DefaultedRegistryReference<ItemType> RED_CONCRETE_POWDER = ItemTypes.key(ResourceKey.minecraft("red_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> RED_DYE = ItemTypes.key(ResourceKey.minecraft("red_dye"));

    public static final DefaultedRegistryReference<ItemType> RED_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("red_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> RED_MUSHROOM = ItemTypes.key(ResourceKey.minecraft("red_mushroom"));

    public static final DefaultedRegistryReference<ItemType> RED_MUSHROOM_BLOCK = ItemTypes.key(ResourceKey.minecraft("red_mushroom_block"));

    public static final DefaultedRegistryReference<ItemType> RED_NETHER_BRICK_SLAB = ItemTypes.key(ResourceKey.minecraft("red_nether_brick_slab"));

    public static final DefaultedRegistryReference<ItemType> RED_NETHER_BRICK_STAIRS = ItemTypes.key(ResourceKey.minecraft("red_nether_brick_stairs"));

    public static final DefaultedRegistryReference<ItemType> RED_NETHER_BRICK_WALL = ItemTypes.key(ResourceKey.minecraft("red_nether_brick_wall"));

    public static final DefaultedRegistryReference<ItemType> RED_NETHER_BRICKS = ItemTypes.key(ResourceKey.minecraft("red_nether_bricks"));

    public static final DefaultedRegistryReference<ItemType> RED_SAND = ItemTypes.key(ResourceKey.minecraft("red_sand"));

    public static final DefaultedRegistryReference<ItemType> RED_SANDSTONE = ItemTypes.key(ResourceKey.minecraft("red_sandstone"));

    public static final DefaultedRegistryReference<ItemType> RED_SANDSTONE_SLAB = ItemTypes.key(ResourceKey.minecraft("red_sandstone_slab"));

    public static final DefaultedRegistryReference<ItemType> RED_SANDSTONE_STAIRS = ItemTypes.key(ResourceKey.minecraft("red_sandstone_stairs"));

    public static final DefaultedRegistryReference<ItemType> RED_SANDSTONE_WALL = ItemTypes.key(ResourceKey.minecraft("red_sandstone_wall"));

    public static final DefaultedRegistryReference<ItemType> RED_SHULKER_BOX = ItemTypes.key(ResourceKey.minecraft("red_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> RED_STAINED_GLASS = ItemTypes.key(ResourceKey.minecraft("red_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> RED_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.minecraft("red_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> RED_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("red_terracotta"));

    public static final DefaultedRegistryReference<ItemType> RED_TULIP = ItemTypes.key(ResourceKey.minecraft("red_tulip"));

    public static final DefaultedRegistryReference<ItemType> RED_WOOL = ItemTypes.key(ResourceKey.minecraft("red_wool"));

    public static final DefaultedRegistryReference<ItemType> REDSTONE = ItemTypes.key(ResourceKey.minecraft("redstone"));

    public static final DefaultedRegistryReference<ItemType> REDSTONE_BLOCK = ItemTypes.key(ResourceKey.minecraft("redstone_block"));

    public static final DefaultedRegistryReference<ItemType> REDSTONE_LAMP = ItemTypes.key(ResourceKey.minecraft("redstone_lamp"));

    public static final DefaultedRegistryReference<ItemType> REDSTONE_ORE = ItemTypes.key(ResourceKey.minecraft("redstone_ore"));

    public static final DefaultedRegistryReference<ItemType> REDSTONE_TORCH = ItemTypes.key(ResourceKey.minecraft("redstone_torch"));

    public static final DefaultedRegistryReference<ItemType> REPEATER = ItemTypes.key(ResourceKey.minecraft("repeater"));

    public static final DefaultedRegistryReference<ItemType> REPEATING_COMMAND_BLOCK = ItemTypes.key(ResourceKey.minecraft("repeating_command_block"));

    public static final DefaultedRegistryReference<ItemType> RESPAWN_ANCHOR = ItemTypes.key(ResourceKey.minecraft("respawn_anchor"));

    public static final DefaultedRegistryReference<ItemType> ROSE_BUSH = ItemTypes.key(ResourceKey.minecraft("rose_bush"));

    public static final DefaultedRegistryReference<ItemType> ROTTEN_FLESH = ItemTypes.key(ResourceKey.minecraft("rotten_flesh"));

    public static final DefaultedRegistryReference<ItemType> SADDLE = ItemTypes.key(ResourceKey.minecraft("saddle"));

    public static final DefaultedRegistryReference<ItemType> SALMON = ItemTypes.key(ResourceKey.minecraft("salmon"));

    public static final DefaultedRegistryReference<ItemType> SALMON_BUCKET = ItemTypes.key(ResourceKey.minecraft("salmon_bucket"));

    public static final DefaultedRegistryReference<ItemType> SALMON_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("salmon_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> SAND = ItemTypes.key(ResourceKey.minecraft("sand"));

    public static final DefaultedRegistryReference<ItemType> SANDSTONE = ItemTypes.key(ResourceKey.minecraft("sandstone"));

    public static final DefaultedRegistryReference<ItemType> SANDSTONE_SLAB = ItemTypes.key(ResourceKey.minecraft("sandstone_slab"));

    public static final DefaultedRegistryReference<ItemType> SANDSTONE_STAIRS = ItemTypes.key(ResourceKey.minecraft("sandstone_stairs"));

    public static final DefaultedRegistryReference<ItemType> SANDSTONE_WALL = ItemTypes.key(ResourceKey.minecraft("sandstone_wall"));

    public static final DefaultedRegistryReference<ItemType> SCAFFOLDING = ItemTypes.key(ResourceKey.minecraft("scaffolding"));

    public static final DefaultedRegistryReference<ItemType> SCULK_SENSOR = ItemTypes.key(ResourceKey.minecraft("sculk_sensor"));

    public static final DefaultedRegistryReference<ItemType> SCUTE = ItemTypes.key(ResourceKey.minecraft("scute"));

    public static final DefaultedRegistryReference<ItemType> SEA_LANTERN = ItemTypes.key(ResourceKey.minecraft("sea_lantern"));

    public static final DefaultedRegistryReference<ItemType> SEA_PICKLE = ItemTypes.key(ResourceKey.minecraft("sea_pickle"));

    public static final DefaultedRegistryReference<ItemType> SEAGRASS = ItemTypes.key(ResourceKey.minecraft("seagrass"));

    public static final DefaultedRegistryReference<ItemType> SEMI_WEATHERED_COPPER_BLOCK = ItemTypes.key(ResourceKey.minecraft("semi_weathered_copper_block"));

    public static final DefaultedRegistryReference<ItemType> SEMI_WEATHERED_CUT_COPPER = ItemTypes.key(ResourceKey.minecraft("semi_weathered_cut_copper"));

    public static final DefaultedRegistryReference<ItemType> SEMI_WEATHERED_CUT_COPPER_SLAB = ItemTypes.key(ResourceKey.minecraft("semi_weathered_cut_copper_slab"));

    public static final DefaultedRegistryReference<ItemType> SEMI_WEATHERED_CUT_COPPER_STAIRS = ItemTypes.key(ResourceKey.minecraft("semi_weathered_cut_copper_stairs"));

    public static final DefaultedRegistryReference<ItemType> SHEARS = ItemTypes.key(ResourceKey.minecraft("shears"));

    public static final DefaultedRegistryReference<ItemType> SHEEP_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("sheep_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> SHIELD = ItemTypes.key(ResourceKey.minecraft("shield"));

    public static final DefaultedRegistryReference<ItemType> SHROOMLIGHT = ItemTypes.key(ResourceKey.minecraft("shroomlight"));

    public static final DefaultedRegistryReference<ItemType> SHULKER_BOX = ItemTypes.key(ResourceKey.minecraft("shulker_box"));

    public static final DefaultedRegistryReference<ItemType> SHULKER_SHELL = ItemTypes.key(ResourceKey.minecraft("shulker_shell"));

    public static final DefaultedRegistryReference<ItemType> SHULKER_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("shulker_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> SILVERFISH_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("silverfish_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> SKELETON_HORSE_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("skeleton_horse_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> SKELETON_SKULL = ItemTypes.key(ResourceKey.minecraft("skeleton_skull"));

    public static final DefaultedRegistryReference<ItemType> SKELETON_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("skeleton_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> SKULL_BANNER_PATTERN = ItemTypes.key(ResourceKey.minecraft("skull_banner_pattern"));

    public static final DefaultedRegistryReference<ItemType> SLIME_BALL = ItemTypes.key(ResourceKey.minecraft("slime_ball"));

    public static final DefaultedRegistryReference<ItemType> SLIME_BLOCK = ItemTypes.key(ResourceKey.minecraft("slime_block"));

    public static final DefaultedRegistryReference<ItemType> SLIME_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("slime_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> SMALL_AMETHYST_BUD = ItemTypes.key(ResourceKey.minecraft("small_amethyst_bud"));

    public static final DefaultedRegistryReference<ItemType> SMITHING_TABLE = ItemTypes.key(ResourceKey.minecraft("smithing_table"));

    public static final DefaultedRegistryReference<ItemType> SMOKER = ItemTypes.key(ResourceKey.minecraft("smoker"));

    public static final DefaultedRegistryReference<ItemType> SMOOTH_QUARTZ = ItemTypes.key(ResourceKey.minecraft("smooth_quartz"));

    public static final DefaultedRegistryReference<ItemType> SMOOTH_QUARTZ_SLAB = ItemTypes.key(ResourceKey.minecraft("smooth_quartz_slab"));

    public static final DefaultedRegistryReference<ItemType> SMOOTH_QUARTZ_STAIRS = ItemTypes.key(ResourceKey.minecraft("smooth_quartz_stairs"));

    public static final DefaultedRegistryReference<ItemType> SMOOTH_RED_SANDSTONE = ItemTypes.key(ResourceKey.minecraft("smooth_red_sandstone"));

    public static final DefaultedRegistryReference<ItemType> SMOOTH_RED_SANDSTONE_SLAB = ItemTypes.key(ResourceKey.minecraft("smooth_red_sandstone_slab"));

    public static final DefaultedRegistryReference<ItemType> SMOOTH_RED_SANDSTONE_STAIRS = ItemTypes.key(ResourceKey.minecraft("smooth_red_sandstone_stairs"));

    public static final DefaultedRegistryReference<ItemType> SMOOTH_SANDSTONE = ItemTypes.key(ResourceKey.minecraft("smooth_sandstone"));

    public static final DefaultedRegistryReference<ItemType> SMOOTH_SANDSTONE_SLAB = ItemTypes.key(ResourceKey.minecraft("smooth_sandstone_slab"));

    public static final DefaultedRegistryReference<ItemType> SMOOTH_SANDSTONE_STAIRS = ItemTypes.key(ResourceKey.minecraft("smooth_sandstone_stairs"));

    public static final DefaultedRegistryReference<ItemType> SMOOTH_STONE = ItemTypes.key(ResourceKey.minecraft("smooth_stone"));

    public static final DefaultedRegistryReference<ItemType> SMOOTH_STONE_SLAB = ItemTypes.key(ResourceKey.minecraft("smooth_stone_slab"));

    public static final DefaultedRegistryReference<ItemType> SNOW = ItemTypes.key(ResourceKey.minecraft("snow"));

    public static final DefaultedRegistryReference<ItemType> SNOW_BLOCK = ItemTypes.key(ResourceKey.minecraft("snow_block"));

    public static final DefaultedRegistryReference<ItemType> SNOWBALL = ItemTypes.key(ResourceKey.minecraft("snowball"));

    public static final DefaultedRegistryReference<ItemType> SOUL_CAMPFIRE = ItemTypes.key(ResourceKey.minecraft("soul_campfire"));

    public static final DefaultedRegistryReference<ItemType> SOUL_LANTERN = ItemTypes.key(ResourceKey.minecraft("soul_lantern"));

    public static final DefaultedRegistryReference<ItemType> SOUL_SAND = ItemTypes.key(ResourceKey.minecraft("soul_sand"));

    public static final DefaultedRegistryReference<ItemType> SOUL_SOIL = ItemTypes.key(ResourceKey.minecraft("soul_soil"));

    public static final DefaultedRegistryReference<ItemType> SOUL_TORCH = ItemTypes.key(ResourceKey.minecraft("soul_torch"));

    public static final DefaultedRegistryReference<ItemType> SPAWNER = ItemTypes.key(ResourceKey.minecraft("spawner"));

    public static final DefaultedRegistryReference<ItemType> SPECTRAL_ARROW = ItemTypes.key(ResourceKey.minecraft("spectral_arrow"));

    public static final DefaultedRegistryReference<ItemType> SPIDER_EYE = ItemTypes.key(ResourceKey.minecraft("spider_eye"));

    public static final DefaultedRegistryReference<ItemType> SPIDER_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("spider_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> SPLASH_POTION = ItemTypes.key(ResourceKey.minecraft("splash_potion"));

    public static final DefaultedRegistryReference<ItemType> SPONGE = ItemTypes.key(ResourceKey.minecraft("sponge"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_BOAT = ItemTypes.key(ResourceKey.minecraft("spruce_boat"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_BUTTON = ItemTypes.key(ResourceKey.minecraft("spruce_button"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_DOOR = ItemTypes.key(ResourceKey.minecraft("spruce_door"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_FENCE = ItemTypes.key(ResourceKey.minecraft("spruce_fence"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_FENCE_GATE = ItemTypes.key(ResourceKey.minecraft("spruce_fence_gate"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_LEAVES = ItemTypes.key(ResourceKey.minecraft("spruce_leaves"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_LOG = ItemTypes.key(ResourceKey.minecraft("spruce_log"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_PLANKS = ItemTypes.key(ResourceKey.minecraft("spruce_planks"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_PRESSURE_PLATE = ItemTypes.key(ResourceKey.minecraft("spruce_pressure_plate"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_SAPLING = ItemTypes.key(ResourceKey.minecraft("spruce_sapling"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_SIGN = ItemTypes.key(ResourceKey.minecraft("spruce_sign"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_SLAB = ItemTypes.key(ResourceKey.minecraft("spruce_slab"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_STAIRS = ItemTypes.key(ResourceKey.minecraft("spruce_stairs"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_TRAPDOOR = ItemTypes.key(ResourceKey.minecraft("spruce_trapdoor"));

    public static final DefaultedRegistryReference<ItemType> SPRUCE_WOOD = ItemTypes.key(ResourceKey.minecraft("spruce_wood"));

    public static final DefaultedRegistryReference<ItemType> SPYGLASS = ItemTypes.key(ResourceKey.minecraft("spyglass"));

    public static final DefaultedRegistryReference<ItemType> SQUID_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("squid_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> STICK = ItemTypes.key(ResourceKey.minecraft("stick"));

    public static final DefaultedRegistryReference<ItemType> STICKY_PISTON = ItemTypes.key(ResourceKey.minecraft("sticky_piston"));

    public static final DefaultedRegistryReference<ItemType> STONE = ItemTypes.key(ResourceKey.minecraft("stone"));

    public static final DefaultedRegistryReference<ItemType> STONE_AXE = ItemTypes.key(ResourceKey.minecraft("stone_axe"));

    public static final DefaultedRegistryReference<ItemType> STONE_BRICK_SLAB = ItemTypes.key(ResourceKey.minecraft("stone_brick_slab"));

    public static final DefaultedRegistryReference<ItemType> STONE_BRICK_STAIRS = ItemTypes.key(ResourceKey.minecraft("stone_brick_stairs"));

    public static final DefaultedRegistryReference<ItemType> STONE_BRICK_WALL = ItemTypes.key(ResourceKey.minecraft("stone_brick_wall"));

    public static final DefaultedRegistryReference<ItemType> STONE_BRICKS = ItemTypes.key(ResourceKey.minecraft("stone_bricks"));

    public static final DefaultedRegistryReference<ItemType> STONE_BUTTON = ItemTypes.key(ResourceKey.minecraft("stone_button"));

    public static final DefaultedRegistryReference<ItemType> STONE_HOE = ItemTypes.key(ResourceKey.minecraft("stone_hoe"));

    public static final DefaultedRegistryReference<ItemType> STONE_PICKAXE = ItemTypes.key(ResourceKey.minecraft("stone_pickaxe"));

    public static final DefaultedRegistryReference<ItemType> STONE_PRESSURE_PLATE = ItemTypes.key(ResourceKey.minecraft("stone_pressure_plate"));

    public static final DefaultedRegistryReference<ItemType> STONE_SHOVEL = ItemTypes.key(ResourceKey.minecraft("stone_shovel"));

    public static final DefaultedRegistryReference<ItemType> STONE_SLAB = ItemTypes.key(ResourceKey.minecraft("stone_slab"));

    public static final DefaultedRegistryReference<ItemType> STONE_STAIRS = ItemTypes.key(ResourceKey.minecraft("stone_stairs"));

    public static final DefaultedRegistryReference<ItemType> STONE_SWORD = ItemTypes.key(ResourceKey.minecraft("stone_sword"));

    public static final DefaultedRegistryReference<ItemType> STONECUTTER = ItemTypes.key(ResourceKey.minecraft("stonecutter"));

    public static final DefaultedRegistryReference<ItemType> STRAY_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("stray_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> STRIDER_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("strider_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> STRING = ItemTypes.key(ResourceKey.minecraft("string"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_ACACIA_LOG = ItemTypes.key(ResourceKey.minecraft("stripped_acacia_log"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_ACACIA_WOOD = ItemTypes.key(ResourceKey.minecraft("stripped_acacia_wood"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_BIRCH_LOG = ItemTypes.key(ResourceKey.minecraft("stripped_birch_log"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_BIRCH_WOOD = ItemTypes.key(ResourceKey.minecraft("stripped_birch_wood"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_CRIMSON_HYPHAE = ItemTypes.key(ResourceKey.minecraft("stripped_crimson_hyphae"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_CRIMSON_STEM = ItemTypes.key(ResourceKey.minecraft("stripped_crimson_stem"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_DARK_OAK_LOG = ItemTypes.key(ResourceKey.minecraft("stripped_dark_oak_log"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_DARK_OAK_WOOD = ItemTypes.key(ResourceKey.minecraft("stripped_dark_oak_wood"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_JUNGLE_LOG = ItemTypes.key(ResourceKey.minecraft("stripped_jungle_log"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_JUNGLE_WOOD = ItemTypes.key(ResourceKey.minecraft("stripped_jungle_wood"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_OAK_LOG = ItemTypes.key(ResourceKey.minecraft("stripped_oak_log"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_OAK_WOOD = ItemTypes.key(ResourceKey.minecraft("stripped_oak_wood"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_SPRUCE_LOG = ItemTypes.key(ResourceKey.minecraft("stripped_spruce_log"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_SPRUCE_WOOD = ItemTypes.key(ResourceKey.minecraft("stripped_spruce_wood"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_WARPED_HYPHAE = ItemTypes.key(ResourceKey.minecraft("stripped_warped_hyphae"));

    public static final DefaultedRegistryReference<ItemType> STRIPPED_WARPED_STEM = ItemTypes.key(ResourceKey.minecraft("stripped_warped_stem"));

    public static final DefaultedRegistryReference<ItemType> STRUCTURE_BLOCK = ItemTypes.key(ResourceKey.minecraft("structure_block"));

    public static final DefaultedRegistryReference<ItemType> STRUCTURE_VOID = ItemTypes.key(ResourceKey.minecraft("structure_void"));

    public static final DefaultedRegistryReference<ItemType> SUGAR = ItemTypes.key(ResourceKey.minecraft("sugar"));

    public static final DefaultedRegistryReference<ItemType> SUGAR_CANE = ItemTypes.key(ResourceKey.minecraft("sugar_cane"));

    public static final DefaultedRegistryReference<ItemType> SUNFLOWER = ItemTypes.key(ResourceKey.minecraft("sunflower"));

    public static final DefaultedRegistryReference<ItemType> SUSPICIOUS_STEW = ItemTypes.key(ResourceKey.minecraft("suspicious_stew"));

    public static final DefaultedRegistryReference<ItemType> SWEET_BERRIES = ItemTypes.key(ResourceKey.minecraft("sweet_berries"));

    public static final DefaultedRegistryReference<ItemType> TALL_GRASS = ItemTypes.key(ResourceKey.minecraft("tall_grass"));

    public static final DefaultedRegistryReference<ItemType> TARGET = ItemTypes.key(ResourceKey.minecraft("target"));

    public static final DefaultedRegistryReference<ItemType> TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("terracotta"));

    public static final DefaultedRegistryReference<ItemType> TINTED_GLASS = ItemTypes.key(ResourceKey.minecraft("tinted_glass"));

    public static final DefaultedRegistryReference<ItemType> TIPPED_ARROW = ItemTypes.key(ResourceKey.minecraft("tipped_arrow"));

    public static final DefaultedRegistryReference<ItemType> TNT = ItemTypes.key(ResourceKey.minecraft("tnt"));

    public static final DefaultedRegistryReference<ItemType> TNT_MINECART = ItemTypes.key(ResourceKey.minecraft("tnt_minecart"));

    public static final DefaultedRegistryReference<ItemType> TORCH = ItemTypes.key(ResourceKey.minecraft("torch"));

    public static final DefaultedRegistryReference<ItemType> TOTEM_OF_UNDYING = ItemTypes.key(ResourceKey.minecraft("totem_of_undying"));

    public static final DefaultedRegistryReference<ItemType> TRADER_LLAMA_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("trader_llama_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> TRAPPED_CHEST = ItemTypes.key(ResourceKey.minecraft("trapped_chest"));

    public static final DefaultedRegistryReference<ItemType> TRIDENT = ItemTypes.key(ResourceKey.minecraft("trident"));

    public static final DefaultedRegistryReference<ItemType> TRIPWIRE_HOOK = ItemTypes.key(ResourceKey.minecraft("tripwire_hook"));

    public static final DefaultedRegistryReference<ItemType> TROPICAL_FISH = ItemTypes.key(ResourceKey.minecraft("tropical_fish"));

    public static final DefaultedRegistryReference<ItemType> TROPICAL_FISH_BUCKET = ItemTypes.key(ResourceKey.minecraft("tropical_fish_bucket"));

    public static final DefaultedRegistryReference<ItemType> TROPICAL_FISH_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("tropical_fish_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> TUBE_CORAL = ItemTypes.key(ResourceKey.minecraft("tube_coral"));

    public static final DefaultedRegistryReference<ItemType> TUBE_CORAL_BLOCK = ItemTypes.key(ResourceKey.minecraft("tube_coral_block"));

    public static final DefaultedRegistryReference<ItemType> TUBE_CORAL_FAN = ItemTypes.key(ResourceKey.minecraft("tube_coral_fan"));

    public static final DefaultedRegistryReference<ItemType> TUFF = ItemTypes.key(ResourceKey.minecraft("tuff"));

    public static final DefaultedRegistryReference<ItemType> TURTLE_EGG = ItemTypes.key(ResourceKey.minecraft("turtle_egg"));

    public static final DefaultedRegistryReference<ItemType> TURTLE_HELMET = ItemTypes.key(ResourceKey.minecraft("turtle_helmet"));

    public static final DefaultedRegistryReference<ItemType> TURTLE_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("turtle_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> TWISTING_VINES = ItemTypes.key(ResourceKey.minecraft("twisting_vines"));

    public static final DefaultedRegistryReference<ItemType> VEX_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("vex_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> VILLAGER_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("villager_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> VINDICATOR_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("vindicator_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> VINE = ItemTypes.key(ResourceKey.minecraft("vine"));

    public static final DefaultedRegistryReference<ItemType> WANDERING_TRADER_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("wandering_trader_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> WARPED_BUTTON = ItemTypes.key(ResourceKey.minecraft("warped_button"));

    public static final DefaultedRegistryReference<ItemType> WARPED_DOOR = ItemTypes.key(ResourceKey.minecraft("warped_door"));

    public static final DefaultedRegistryReference<ItemType> WARPED_FENCE = ItemTypes.key(ResourceKey.minecraft("warped_fence"));

    public static final DefaultedRegistryReference<ItemType> WARPED_FENCE_GATE = ItemTypes.key(ResourceKey.minecraft("warped_fence_gate"));

    public static final DefaultedRegistryReference<ItemType> WARPED_FUNGUS = ItemTypes.key(ResourceKey.minecraft("warped_fungus"));

    public static final DefaultedRegistryReference<ItemType> WARPED_FUNGUS_ON_A_STICK = ItemTypes.key(ResourceKey.minecraft("warped_fungus_on_a_stick"));

    public static final DefaultedRegistryReference<ItemType> WARPED_HYPHAE = ItemTypes.key(ResourceKey.minecraft("warped_hyphae"));

    public static final DefaultedRegistryReference<ItemType> WARPED_NYLIUM = ItemTypes.key(ResourceKey.minecraft("warped_nylium"));

    public static final DefaultedRegistryReference<ItemType> WARPED_PLANKS = ItemTypes.key(ResourceKey.minecraft("warped_planks"));

    public static final DefaultedRegistryReference<ItemType> WARPED_PRESSURE_PLATE = ItemTypes.key(ResourceKey.minecraft("warped_pressure_plate"));

    public static final DefaultedRegistryReference<ItemType> WARPED_ROOTS = ItemTypes.key(ResourceKey.minecraft("warped_roots"));

    public static final DefaultedRegistryReference<ItemType> WARPED_SIGN = ItemTypes.key(ResourceKey.minecraft("warped_sign"));

    public static final DefaultedRegistryReference<ItemType> WARPED_SLAB = ItemTypes.key(ResourceKey.minecraft("warped_slab"));

    public static final DefaultedRegistryReference<ItemType> WARPED_STAIRS = ItemTypes.key(ResourceKey.minecraft("warped_stairs"));

    public static final DefaultedRegistryReference<ItemType> WARPED_STEM = ItemTypes.key(ResourceKey.minecraft("warped_stem"));

    public static final DefaultedRegistryReference<ItemType> WARPED_TRAPDOOR = ItemTypes.key(ResourceKey.minecraft("warped_trapdoor"));

    public static final DefaultedRegistryReference<ItemType> WARPED_WART_BLOCK = ItemTypes.key(ResourceKey.minecraft("warped_wart_block"));

    public static final DefaultedRegistryReference<ItemType> WATER_BUCKET = ItemTypes.key(ResourceKey.minecraft("water_bucket"));

    public static final DefaultedRegistryReference<ItemType> WAXED_COPPER = ItemTypes.key(ResourceKey.minecraft("waxed_copper"));

    public static final DefaultedRegistryReference<ItemType> WAXED_CUT_COPPER = ItemTypes.key(ResourceKey.minecraft("waxed_cut_copper"));

    public static final DefaultedRegistryReference<ItemType> WAXED_CUT_COPPER_SLAB = ItemTypes.key(ResourceKey.minecraft("waxed_cut_copper_slab"));

    public static final DefaultedRegistryReference<ItemType> WAXED_CUT_COPPER_STAIRS = ItemTypes.key(ResourceKey.minecraft("waxed_cut_copper_stairs"));

    public static final DefaultedRegistryReference<ItemType> WAXED_LIGHTLY_WEATHERED_COPPER = ItemTypes.key(ResourceKey.minecraft("waxed_lightly_weathered_copper"));

    public static final DefaultedRegistryReference<ItemType> WAXED_LIGHTLY_WEATHERED_CUT_COPPER = ItemTypes.key(ResourceKey.minecraft("waxed_lightly_weathered_cut_copper"));

    public static final DefaultedRegistryReference<ItemType> WAXED_LIGHTLY_WEATHERED_CUT_COPPER_SLAB = ItemTypes.key(ResourceKey.minecraft("waxed_lightly_weathered_cut_copper_slab"));

    public static final DefaultedRegistryReference<ItemType> WAXED_LIGHTLY_WEATHERED_CUT_COPPER_STAIRS = ItemTypes.key(ResourceKey.minecraft("waxed_lightly_weathered_cut_copper_stairs"));

    public static final DefaultedRegistryReference<ItemType> WAXED_SEMI_WEATHERED_COPPER = ItemTypes.key(ResourceKey.minecraft("waxed_semi_weathered_copper"));

    public static final DefaultedRegistryReference<ItemType> WAXED_SEMI_WEATHERED_CUT_COPPER = ItemTypes.key(ResourceKey.minecraft("waxed_semi_weathered_cut_copper"));

    public static final DefaultedRegistryReference<ItemType> WAXED_SEMI_WEATHERED_CUT_COPPER_SLAB = ItemTypes.key(ResourceKey.minecraft("waxed_semi_weathered_cut_copper_slab"));

    public static final DefaultedRegistryReference<ItemType> WAXED_SEMI_WEATHERED_CUT_COPPER_STAIRS = ItemTypes.key(ResourceKey.minecraft("waxed_semi_weathered_cut_copper_stairs"));

    public static final DefaultedRegistryReference<ItemType> WEATHERED_COPPER_BLOCK = ItemTypes.key(ResourceKey.minecraft("weathered_copper_block"));

    public static final DefaultedRegistryReference<ItemType> WEATHERED_CUT_COPPER = ItemTypes.key(ResourceKey.minecraft("weathered_cut_copper"));

    public static final DefaultedRegistryReference<ItemType> WEATHERED_CUT_COPPER_SLAB = ItemTypes.key(ResourceKey.minecraft("weathered_cut_copper_slab"));

    public static final DefaultedRegistryReference<ItemType> WEATHERED_CUT_COPPER_STAIRS = ItemTypes.key(ResourceKey.minecraft("weathered_cut_copper_stairs"));

    public static final DefaultedRegistryReference<ItemType> WEEPING_VINES = ItemTypes.key(ResourceKey.minecraft("weeping_vines"));

    public static final DefaultedRegistryReference<ItemType> WET_SPONGE = ItemTypes.key(ResourceKey.minecraft("wet_sponge"));

    public static final DefaultedRegistryReference<ItemType> WHEAT = ItemTypes.key(ResourceKey.minecraft("wheat"));

    public static final DefaultedRegistryReference<ItemType> WHEAT_SEEDS = ItemTypes.key(ResourceKey.minecraft("wheat_seeds"));

    public static final DefaultedRegistryReference<ItemType> WHITE_BANNER = ItemTypes.key(ResourceKey.minecraft("white_banner"));

    public static final DefaultedRegistryReference<ItemType> WHITE_BED = ItemTypes.key(ResourceKey.minecraft("white_bed"));

    public static final DefaultedRegistryReference<ItemType> WHITE_CANDLE = ItemTypes.key(ResourceKey.minecraft("white_candle"));

    public static final DefaultedRegistryReference<ItemType> WHITE_CARPET = ItemTypes.key(ResourceKey.minecraft("white_carpet"));

    public static final DefaultedRegistryReference<ItemType> WHITE_CONCRETE = ItemTypes.key(ResourceKey.minecraft("white_concrete"));

    public static final DefaultedRegistryReference<ItemType> WHITE_CONCRETE_POWDER = ItemTypes.key(ResourceKey.minecraft("white_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> WHITE_DYE = ItemTypes.key(ResourceKey.minecraft("white_dye"));

    public static final DefaultedRegistryReference<ItemType> WHITE_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("white_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> WHITE_SHULKER_BOX = ItemTypes.key(ResourceKey.minecraft("white_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> WHITE_STAINED_GLASS = ItemTypes.key(ResourceKey.minecraft("white_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> WHITE_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.minecraft("white_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> WHITE_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("white_terracotta"));

    public static final DefaultedRegistryReference<ItemType> WHITE_TULIP = ItemTypes.key(ResourceKey.minecraft("white_tulip"));

    public static final DefaultedRegistryReference<ItemType> WHITE_WOOL = ItemTypes.key(ResourceKey.minecraft("white_wool"));

    public static final DefaultedRegistryReference<ItemType> WITCH_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("witch_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> WITHER_ROSE = ItemTypes.key(ResourceKey.minecraft("wither_rose"));

    public static final DefaultedRegistryReference<ItemType> WITHER_SKELETON_SKULL = ItemTypes.key(ResourceKey.minecraft("wither_skeleton_skull"));

    public static final DefaultedRegistryReference<ItemType> WITHER_SKELETON_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("wither_skeleton_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> WOLF_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("wolf_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> WOODEN_AXE = ItemTypes.key(ResourceKey.minecraft("wooden_axe"));

    public static final DefaultedRegistryReference<ItemType> WOODEN_HOE = ItemTypes.key(ResourceKey.minecraft("wooden_hoe"));

    public static final DefaultedRegistryReference<ItemType> WOODEN_PICKAXE = ItemTypes.key(ResourceKey.minecraft("wooden_pickaxe"));

    public static final DefaultedRegistryReference<ItemType> WOODEN_SHOVEL = ItemTypes.key(ResourceKey.minecraft("wooden_shovel"));

    public static final DefaultedRegistryReference<ItemType> WOODEN_SWORD = ItemTypes.key(ResourceKey.minecraft("wooden_sword"));

    public static final DefaultedRegistryReference<ItemType> WRITABLE_BOOK = ItemTypes.key(ResourceKey.minecraft("writable_book"));

    public static final DefaultedRegistryReference<ItemType> WRITTEN_BOOK = ItemTypes.key(ResourceKey.minecraft("written_book"));

    public static final DefaultedRegistryReference<ItemType> YELLOW_BANNER = ItemTypes.key(ResourceKey.minecraft("yellow_banner"));

    public static final DefaultedRegistryReference<ItemType> YELLOW_BED = ItemTypes.key(ResourceKey.minecraft("yellow_bed"));

    public static final DefaultedRegistryReference<ItemType> YELLOW_CANDLE = ItemTypes.key(ResourceKey.minecraft("yellow_candle"));

    public static final DefaultedRegistryReference<ItemType> YELLOW_CARPET = ItemTypes.key(ResourceKey.minecraft("yellow_carpet"));

    public static final DefaultedRegistryReference<ItemType> YELLOW_CONCRETE = ItemTypes.key(ResourceKey.minecraft("yellow_concrete"));

    public static final DefaultedRegistryReference<ItemType> YELLOW_CONCRETE_POWDER = ItemTypes.key(ResourceKey.minecraft("yellow_concrete_powder"));

    public static final DefaultedRegistryReference<ItemType> YELLOW_DYE = ItemTypes.key(ResourceKey.minecraft("yellow_dye"));

    public static final DefaultedRegistryReference<ItemType> YELLOW_GLAZED_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("yellow_glazed_terracotta"));

    public static final DefaultedRegistryReference<ItemType> YELLOW_SHULKER_BOX = ItemTypes.key(ResourceKey.minecraft("yellow_shulker_box"));

    public static final DefaultedRegistryReference<ItemType> YELLOW_STAINED_GLASS = ItemTypes.key(ResourceKey.minecraft("yellow_stained_glass"));

    public static final DefaultedRegistryReference<ItemType> YELLOW_STAINED_GLASS_PANE = ItemTypes.key(ResourceKey.minecraft("yellow_stained_glass_pane"));

    public static final DefaultedRegistryReference<ItemType> YELLOW_TERRACOTTA = ItemTypes.key(ResourceKey.minecraft("yellow_terracotta"));

    public static final DefaultedRegistryReference<ItemType> YELLOW_WOOL = ItemTypes.key(ResourceKey.minecraft("yellow_wool"));

    public static final DefaultedRegistryReference<ItemType> ZOGLIN_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("zoglin_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> ZOMBIE_HEAD = ItemTypes.key(ResourceKey.minecraft("zombie_head"));

    public static final DefaultedRegistryReference<ItemType> ZOMBIE_HORSE_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("zombie_horse_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> ZOMBIE_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("zombie_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> ZOMBIE_VILLAGER_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("zombie_villager_spawn_egg"));

    public static final DefaultedRegistryReference<ItemType> ZOMBIFIED_PIGLIN_SPAWN_EGG = ItemTypes.key(ResourceKey.minecraft("zombified_piglin_spawn_egg"));

    // SORTFIELDS:OFF

    // @formatter:on

    private ItemTypes() {
    }

    private static DefaultedRegistryReference<ItemType> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.ITEM_TYPE, location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
