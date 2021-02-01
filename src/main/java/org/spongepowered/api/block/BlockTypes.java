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
package org.spongepowered.api.block;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

/**
 * An enumeration of all possible {@link BlockType}s in vanilla minecraft.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class BlockTypes {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<BlockType> ACACIA_BUTTON = BlockTypes.key(ResourceKey.minecraft("acacia_button"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_DOOR = BlockTypes.key(ResourceKey.minecraft("acacia_door"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_FENCE = BlockTypes.key(ResourceKey.minecraft("acacia_fence"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_FENCE_GATE = BlockTypes.key(ResourceKey.minecraft("acacia_fence_gate"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_LEAVES = BlockTypes.key(ResourceKey.minecraft("acacia_leaves"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_LOG = BlockTypes.key(ResourceKey.minecraft("acacia_log"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_PLANKS = BlockTypes.key(ResourceKey.minecraft("acacia_planks"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_PRESSURE_PLATE = BlockTypes.key(ResourceKey.minecraft("acacia_pressure_plate"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_SAPLING = BlockTypes.key(ResourceKey.minecraft("acacia_sapling"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_SIGN = BlockTypes.key(ResourceKey.minecraft("acacia_sign"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_SLAB = BlockTypes.key(ResourceKey.minecraft("acacia_slab"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_STAIRS = BlockTypes.key(ResourceKey.minecraft("acacia_stairs"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_TRAPDOOR = BlockTypes.key(ResourceKey.minecraft("acacia_trapdoor"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_WALL_SIGN = BlockTypes.key(ResourceKey.minecraft("acacia_wall_sign"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_WOOD = BlockTypes.key(ResourceKey.minecraft("acacia_wood"));

    public static final DefaultedRegistryReference<BlockType> ACTIVATOR_RAIL = BlockTypes.key(ResourceKey.minecraft("activator_rail"));

    public static final DefaultedRegistryReference<BlockType> AIR = BlockTypes.key(ResourceKey.minecraft("air"));

    public static final DefaultedRegistryReference<BlockType> ALLIUM = BlockTypes.key(ResourceKey.minecraft("allium"));

    public static final DefaultedRegistryReference<BlockType> AMETHYST_BLOCK = BlockTypes.key(ResourceKey.minecraft("amethyst_block"));

    public static final DefaultedRegistryReference<BlockType> AMETHYST_CLUSTER = BlockTypes.key(ResourceKey.minecraft("amethyst_cluster"));

    public static final DefaultedRegistryReference<BlockType> ANCIENT_DEBRIS = BlockTypes.key(ResourceKey.minecraft("ancient_debris"));

    public static final DefaultedRegistryReference<BlockType> ANDESITE = BlockTypes.key(ResourceKey.minecraft("andesite"));

    public static final DefaultedRegistryReference<BlockType> ANDESITE_SLAB = BlockTypes.key(ResourceKey.minecraft("andesite_slab"));

    public static final DefaultedRegistryReference<BlockType> ANDESITE_STAIRS = BlockTypes.key(ResourceKey.minecraft("andesite_stairs"));

    public static final DefaultedRegistryReference<BlockType> ANDESITE_WALL = BlockTypes.key(ResourceKey.minecraft("andesite_wall"));

    public static final DefaultedRegistryReference<BlockType> ANVIL = BlockTypes.key(ResourceKey.minecraft("anvil"));

    public static final DefaultedRegistryReference<BlockType> ATTACHED_MELON_STEM = BlockTypes.key(ResourceKey.minecraft("attached_melon_stem"));

    public static final DefaultedRegistryReference<BlockType> ATTACHED_PUMPKIN_STEM = BlockTypes.key(ResourceKey.minecraft("attached_pumpkin_stem"));

    public static final DefaultedRegistryReference<BlockType> AZURE_BLUET = BlockTypes.key(ResourceKey.minecraft("azure_bluet"));

    public static final DefaultedRegistryReference<BlockType> BAMBOO = BlockTypes.key(ResourceKey.minecraft("bamboo"));

    public static final DefaultedRegistryReference<BlockType> BAMBOO_SAPLING = BlockTypes.key(ResourceKey.minecraft("bamboo_sapling"));

    public static final DefaultedRegistryReference<BlockType> BARREL = BlockTypes.key(ResourceKey.minecraft("barrel"));

    public static final DefaultedRegistryReference<BlockType> BARRIER = BlockTypes.key(ResourceKey.minecraft("barrier"));

    public static final DefaultedRegistryReference<BlockType> BASALT = BlockTypes.key(ResourceKey.minecraft("basalt"));

    public static final DefaultedRegistryReference<BlockType> BEACON = BlockTypes.key(ResourceKey.minecraft("beacon"));

    public static final DefaultedRegistryReference<BlockType> BEDROCK = BlockTypes.key(ResourceKey.minecraft("bedrock"));

    public static final DefaultedRegistryReference<BlockType> BEE_NEST = BlockTypes.key(ResourceKey.minecraft("bee_nest"));

    public static final DefaultedRegistryReference<BlockType> BEEHIVE = BlockTypes.key(ResourceKey.minecraft("beehive"));

    public static final DefaultedRegistryReference<BlockType> BEETROOTS = BlockTypes.key(ResourceKey.minecraft("beetroots"));

    public static final DefaultedRegistryReference<BlockType> BELL = BlockTypes.key(ResourceKey.minecraft("bell"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_BUTTON = BlockTypes.key(ResourceKey.minecraft("birch_button"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_DOOR = BlockTypes.key(ResourceKey.minecraft("birch_door"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_FENCE = BlockTypes.key(ResourceKey.minecraft("birch_fence"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_FENCE_GATE = BlockTypes.key(ResourceKey.minecraft("birch_fence_gate"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_LEAVES = BlockTypes.key(ResourceKey.minecraft("birch_leaves"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_LOG = BlockTypes.key(ResourceKey.minecraft("birch_log"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_PLANKS = BlockTypes.key(ResourceKey.minecraft("birch_planks"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_PRESSURE_PLATE = BlockTypes.key(ResourceKey.minecraft("birch_pressure_plate"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_SAPLING = BlockTypes.key(ResourceKey.minecraft("birch_sapling"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_SIGN = BlockTypes.key(ResourceKey.minecraft("birch_sign"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_SLAB = BlockTypes.key(ResourceKey.minecraft("birch_slab"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_STAIRS = BlockTypes.key(ResourceKey.minecraft("birch_stairs"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_TRAPDOOR = BlockTypes.key(ResourceKey.minecraft("birch_trapdoor"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_WALL_SIGN = BlockTypes.key(ResourceKey.minecraft("birch_wall_sign"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_WOOD = BlockTypes.key(ResourceKey.minecraft("birch_wood"));

    public static final DefaultedRegistryReference<BlockType> BLACK_BANNER = BlockTypes.key(ResourceKey.minecraft("black_banner"));

    public static final DefaultedRegistryReference<BlockType> BLACK_BED = BlockTypes.key(ResourceKey.minecraft("black_bed"));

    public static final DefaultedRegistryReference<BlockType> BLACK_CANDLE = BlockTypes.key(ResourceKey.minecraft("black_candle"));

    public static final DefaultedRegistryReference<BlockType> BLACK_CANDLE_CAKE = BlockTypes.key(ResourceKey.minecraft("black_candle_cake"));

    public static final DefaultedRegistryReference<BlockType> BLACK_CARPET = BlockTypes.key(ResourceKey.minecraft("black_carpet"));

    public static final DefaultedRegistryReference<BlockType> BLACK_CONCRETE = BlockTypes.key(ResourceKey.minecraft("black_concrete"));

    public static final DefaultedRegistryReference<BlockType> BLACK_CONCRETE_POWDER = BlockTypes.key(ResourceKey.minecraft("black_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> BLACK_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("black_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> BLACK_SHULKER_BOX = BlockTypes.key(ResourceKey.minecraft("black_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> BLACK_STAINED_GLASS = BlockTypes.key(ResourceKey.minecraft("black_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> BLACK_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.minecraft("black_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> BLACK_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("black_terracotta"));

    public static final DefaultedRegistryReference<BlockType> BLACK_WALL_BANNER = BlockTypes.key(ResourceKey.minecraft("black_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> BLACK_WOOL = BlockTypes.key(ResourceKey.minecraft("black_wool"));

    public static final DefaultedRegistryReference<BlockType> BLACKSTONE = BlockTypes.key(ResourceKey.minecraft("blackstone"));

    public static final DefaultedRegistryReference<BlockType> BLACKSTONE_SLAB = BlockTypes.key(ResourceKey.minecraft("blackstone_slab"));

    public static final DefaultedRegistryReference<BlockType> BLACKSTONE_STAIRS = BlockTypes.key(ResourceKey.minecraft("blackstone_stairs"));

    public static final DefaultedRegistryReference<BlockType> BLACKSTONE_WALL = BlockTypes.key(ResourceKey.minecraft("blackstone_wall"));

    public static final DefaultedRegistryReference<BlockType> BLAST_FURNACE = BlockTypes.key(ResourceKey.minecraft("blast_furnace"));

    public static final DefaultedRegistryReference<BlockType> BLUE_BANNER = BlockTypes.key(ResourceKey.minecraft("blue_banner"));

    public static final DefaultedRegistryReference<BlockType> BLUE_BED = BlockTypes.key(ResourceKey.minecraft("blue_bed"));

    public static final DefaultedRegistryReference<BlockType> BLUE_CANDLE = BlockTypes.key(ResourceKey.minecraft("blue_candle"));

    public static final DefaultedRegistryReference<BlockType> BLUE_CANDLE_CAKE = BlockTypes.key(ResourceKey.minecraft("blue_candle_cake"));

    public static final DefaultedRegistryReference<BlockType> BLUE_CARPET = BlockTypes.key(ResourceKey.minecraft("blue_carpet"));

    public static final DefaultedRegistryReference<BlockType> BLUE_CONCRETE = BlockTypes.key(ResourceKey.minecraft("blue_concrete"));

    public static final DefaultedRegistryReference<BlockType> BLUE_CONCRETE_POWDER = BlockTypes.key(ResourceKey.minecraft("blue_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> BLUE_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("blue_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> BLUE_ICE = BlockTypes.key(ResourceKey.minecraft("blue_ice"));

    public static final DefaultedRegistryReference<BlockType> BLUE_ORCHID = BlockTypes.key(ResourceKey.minecraft("blue_orchid"));

    public static final DefaultedRegistryReference<BlockType> BLUE_SHULKER_BOX = BlockTypes.key(ResourceKey.minecraft("blue_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> BLUE_STAINED_GLASS = BlockTypes.key(ResourceKey.minecraft("blue_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> BLUE_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.minecraft("blue_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> BLUE_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("blue_terracotta"));

    public static final DefaultedRegistryReference<BlockType> BLUE_WALL_BANNER = BlockTypes.key(ResourceKey.minecraft("blue_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> BLUE_WOOL = BlockTypes.key(ResourceKey.minecraft("blue_wool"));

    public static final DefaultedRegistryReference<BlockType> BONE_BLOCK = BlockTypes.key(ResourceKey.minecraft("bone_block"));

    public static final DefaultedRegistryReference<BlockType> BOOKSHELF = BlockTypes.key(ResourceKey.minecraft("bookshelf"));

    public static final DefaultedRegistryReference<BlockType> BRAIN_CORAL = BlockTypes.key(ResourceKey.minecraft("brain_coral"));

    public static final DefaultedRegistryReference<BlockType> BRAIN_CORAL_BLOCK = BlockTypes.key(ResourceKey.minecraft("brain_coral_block"));

    public static final DefaultedRegistryReference<BlockType> BRAIN_CORAL_FAN = BlockTypes.key(ResourceKey.minecraft("brain_coral_fan"));

    public static final DefaultedRegistryReference<BlockType> BRAIN_CORAL_WALL_FAN = BlockTypes.key(ResourceKey.minecraft("brain_coral_wall_fan"));

    public static final DefaultedRegistryReference<BlockType> BREWING_STAND = BlockTypes.key(ResourceKey.minecraft("brewing_stand"));

    public static final DefaultedRegistryReference<BlockType> BRICK_SLAB = BlockTypes.key(ResourceKey.minecraft("brick_slab"));

    public static final DefaultedRegistryReference<BlockType> BRICK_STAIRS = BlockTypes.key(ResourceKey.minecraft("brick_stairs"));

    public static final DefaultedRegistryReference<BlockType> BRICK_WALL = BlockTypes.key(ResourceKey.minecraft("brick_wall"));

    public static final DefaultedRegistryReference<BlockType> BRICKS = BlockTypes.key(ResourceKey.minecraft("bricks"));

    public static final DefaultedRegistryReference<BlockType> BROWN_BANNER = BlockTypes.key(ResourceKey.minecraft("brown_banner"));

    public static final DefaultedRegistryReference<BlockType> BROWN_BED = BlockTypes.key(ResourceKey.minecraft("brown_bed"));

    public static final DefaultedRegistryReference<BlockType> BROWN_CANDLE = BlockTypes.key(ResourceKey.minecraft("brown_candle"));

    public static final DefaultedRegistryReference<BlockType> BROWN_CANDLE_CAKE = BlockTypes.key(ResourceKey.minecraft("brown_candle_cake"));

    public static final DefaultedRegistryReference<BlockType> BROWN_CARPET = BlockTypes.key(ResourceKey.minecraft("brown_carpet"));

    public static final DefaultedRegistryReference<BlockType> BROWN_CONCRETE = BlockTypes.key(ResourceKey.minecraft("brown_concrete"));

    public static final DefaultedRegistryReference<BlockType> BROWN_CONCRETE_POWDER = BlockTypes.key(ResourceKey.minecraft("brown_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> BROWN_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("brown_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> BROWN_MUSHROOM = BlockTypes.key(ResourceKey.minecraft("brown_mushroom"));

    public static final DefaultedRegistryReference<BlockType> BROWN_MUSHROOM_BLOCK = BlockTypes.key(ResourceKey.minecraft("brown_mushroom_block"));

    public static final DefaultedRegistryReference<BlockType> BROWN_SHULKER_BOX = BlockTypes.key(ResourceKey.minecraft("brown_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> BROWN_STAINED_GLASS = BlockTypes.key(ResourceKey.minecraft("brown_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> BROWN_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.minecraft("brown_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> BROWN_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("brown_terracotta"));

    public static final DefaultedRegistryReference<BlockType> BROWN_WALL_BANNER = BlockTypes.key(ResourceKey.minecraft("brown_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> BROWN_WOOL = BlockTypes.key(ResourceKey.minecraft("brown_wool"));

    public static final DefaultedRegistryReference<BlockType> BUBBLE_COLUMN = BlockTypes.key(ResourceKey.minecraft("bubble_column"));

    public static final DefaultedRegistryReference<BlockType> BUBBLE_CORAL = BlockTypes.key(ResourceKey.minecraft("bubble_coral"));

    public static final DefaultedRegistryReference<BlockType> BUBBLE_CORAL_BLOCK = BlockTypes.key(ResourceKey.minecraft("bubble_coral_block"));

    public static final DefaultedRegistryReference<BlockType> BUBBLE_CORAL_FAN = BlockTypes.key(ResourceKey.minecraft("bubble_coral_fan"));

    public static final DefaultedRegistryReference<BlockType> BUBBLE_CORAL_WALL_FAN = BlockTypes.key(ResourceKey.minecraft("bubble_coral_wall_fan"));

    public static final DefaultedRegistryReference<BlockType> BUDDING_AMETHYST = BlockTypes.key(ResourceKey.minecraft("budding_amethyst"));

    public static final DefaultedRegistryReference<BlockType> CACTUS = BlockTypes.key(ResourceKey.minecraft("cactus"));

    public static final DefaultedRegistryReference<BlockType> CAKE = BlockTypes.key(ResourceKey.minecraft("cake"));

    public static final DefaultedRegistryReference<BlockType> CALCITE = BlockTypes.key(ResourceKey.minecraft("calcite"));

    public static final DefaultedRegistryReference<BlockType> CAMPFIRE = BlockTypes.key(ResourceKey.minecraft("campfire"));

    public static final DefaultedRegistryReference<BlockType> CANDLE = BlockTypes.key(ResourceKey.minecraft("candle"));

    public static final DefaultedRegistryReference<BlockType> CANDLE_CAKE = BlockTypes.key(ResourceKey.minecraft("candle_cake"));

    public static final DefaultedRegistryReference<BlockType> CARROTS = BlockTypes.key(ResourceKey.minecraft("carrots"));

    public static final DefaultedRegistryReference<BlockType> CARTOGRAPHY_TABLE = BlockTypes.key(ResourceKey.minecraft("cartography_table"));

    public static final DefaultedRegistryReference<BlockType> CARVED_PUMPKIN = BlockTypes.key(ResourceKey.minecraft("carved_pumpkin"));

    public static final DefaultedRegistryReference<BlockType> CAULDRON = BlockTypes.key(ResourceKey.minecraft("cauldron"));

    public static final DefaultedRegistryReference<BlockType> CAVE_AIR = BlockTypes.key(ResourceKey.minecraft("cave_air"));

    public static final DefaultedRegistryReference<BlockType> CHAIN = BlockTypes.key(ResourceKey.minecraft("chain"));

    public static final DefaultedRegistryReference<BlockType> CHAIN_COMMAND_BLOCK = BlockTypes.key(ResourceKey.minecraft("chain_command_block"));

    public static final DefaultedRegistryReference<BlockType> CHEST = BlockTypes.key(ResourceKey.minecraft("chest"));

    public static final DefaultedRegistryReference<BlockType> CHIPPED_ANVIL = BlockTypes.key(ResourceKey.minecraft("chipped_anvil"));

    public static final DefaultedRegistryReference<BlockType> CHISELED_NETHER_BRICKS = BlockTypes.key(ResourceKey.minecraft("chiseled_nether_bricks"));

    public static final DefaultedRegistryReference<BlockType> CHISELED_POLISHED_BLACKSTONE = BlockTypes.key(ResourceKey.minecraft("chiseled_polished_blackstone"));

    public static final DefaultedRegistryReference<BlockType> CHISELED_QUARTZ_BLOCK = BlockTypes.key(ResourceKey.minecraft("chiseled_quartz_block"));

    public static final DefaultedRegistryReference<BlockType> CHISELED_RED_SANDSTONE = BlockTypes.key(ResourceKey.minecraft("chiseled_red_sandstone"));

    public static final DefaultedRegistryReference<BlockType> CHISELED_SANDSTONE = BlockTypes.key(ResourceKey.minecraft("chiseled_sandstone"));

    public static final DefaultedRegistryReference<BlockType> CHISELED_STONE_BRICKS = BlockTypes.key(ResourceKey.minecraft("chiseled_stone_bricks"));

    public static final DefaultedRegistryReference<BlockType> CHORUS_FLOWER = BlockTypes.key(ResourceKey.minecraft("chorus_flower"));

    public static final DefaultedRegistryReference<BlockType> CHORUS_PLANT = BlockTypes.key(ResourceKey.minecraft("chorus_plant"));

    public static final DefaultedRegistryReference<BlockType> CLAY = BlockTypes.key(ResourceKey.minecraft("clay"));

    public static final DefaultedRegistryReference<BlockType> COAL_BLOCK = BlockTypes.key(ResourceKey.minecraft("coal_block"));

    public static final DefaultedRegistryReference<BlockType> COAL_ORE = BlockTypes.key(ResourceKey.minecraft("coal_ore"));

    public static final DefaultedRegistryReference<BlockType> COARSE_DIRT = BlockTypes.key(ResourceKey.minecraft("coarse_dirt"));

    public static final DefaultedRegistryReference<BlockType> COBBLESTONE = BlockTypes.key(ResourceKey.minecraft("cobblestone"));

    public static final DefaultedRegistryReference<BlockType> COBBLESTONE_SLAB = BlockTypes.key(ResourceKey.minecraft("cobblestone_slab"));

    public static final DefaultedRegistryReference<BlockType> COBBLESTONE_STAIRS = BlockTypes.key(ResourceKey.minecraft("cobblestone_stairs"));

    public static final DefaultedRegistryReference<BlockType> COBBLESTONE_WALL = BlockTypes.key(ResourceKey.minecraft("cobblestone_wall"));

    public static final DefaultedRegistryReference<BlockType> COBWEB = BlockTypes.key(ResourceKey.minecraft("cobweb"));

    public static final DefaultedRegistryReference<BlockType> COCOA = BlockTypes.key(ResourceKey.minecraft("cocoa"));

    public static final DefaultedRegistryReference<BlockType> COMMAND_BLOCK = BlockTypes.key(ResourceKey.minecraft("command_block"));

    public static final DefaultedRegistryReference<BlockType> COMPARATOR = BlockTypes.key(ResourceKey.minecraft("comparator"));

    public static final DefaultedRegistryReference<BlockType> COMPOSTER = BlockTypes.key(ResourceKey.minecraft("composter"));

    public static final DefaultedRegistryReference<BlockType> CONDUIT = BlockTypes.key(ResourceKey.minecraft("conduit"));

    public static final DefaultedRegistryReference<BlockType> COPPER_BLOCK = BlockTypes.key(ResourceKey.minecraft("copper_block"));

    public static final DefaultedRegistryReference<BlockType> COPPER_ORE = BlockTypes.key(ResourceKey.minecraft("copper_ore"));

    public static final DefaultedRegistryReference<BlockType> CORNFLOWER = BlockTypes.key(ResourceKey.minecraft("cornflower"));

    public static final DefaultedRegistryReference<BlockType> CRACKED_NETHER_BRICKS = BlockTypes.key(ResourceKey.minecraft("cracked_nether_bricks"));

    public static final DefaultedRegistryReference<BlockType> CRACKED_POLISHED_BLACKSTONE_BRICKS = BlockTypes.key(ResourceKey.minecraft("cracked_polished_blackstone_bricks"));

    public static final DefaultedRegistryReference<BlockType> CRACKED_STONE_BRICKS = BlockTypes.key(ResourceKey.minecraft("cracked_stone_bricks"));

    public static final DefaultedRegistryReference<BlockType> CRAFTING_TABLE = BlockTypes.key(ResourceKey.minecraft("crafting_table"));

    public static final DefaultedRegistryReference<BlockType> CREEPER_HEAD = BlockTypes.key(ResourceKey.minecraft("creeper_head"));

    public static final DefaultedRegistryReference<BlockType> CREEPER_WALL_HEAD = BlockTypes.key(ResourceKey.minecraft("creeper_wall_head"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_BUTTON = BlockTypes.key(ResourceKey.minecraft("crimson_button"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_DOOR = BlockTypes.key(ResourceKey.minecraft("crimson_door"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_FENCE = BlockTypes.key(ResourceKey.minecraft("crimson_fence"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_FENCE_GATE = BlockTypes.key(ResourceKey.minecraft("crimson_fence_gate"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_FUNGUS = BlockTypes.key(ResourceKey.minecraft("crimson_fungus"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_HYPHAE = BlockTypes.key(ResourceKey.minecraft("crimson_hyphae"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_NYLIUM = BlockTypes.key(ResourceKey.minecraft("crimson_nylium"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_PLANKS = BlockTypes.key(ResourceKey.minecraft("crimson_planks"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_PRESSURE_PLATE = BlockTypes.key(ResourceKey.minecraft("crimson_pressure_plate"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_ROOTS = BlockTypes.key(ResourceKey.minecraft("crimson_roots"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_SIGN = BlockTypes.key(ResourceKey.minecraft("crimson_sign"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_SLAB = BlockTypes.key(ResourceKey.minecraft("crimson_slab"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_STAIRS = BlockTypes.key(ResourceKey.minecraft("crimson_stairs"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_STEM = BlockTypes.key(ResourceKey.minecraft("crimson_stem"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_TRAPDOOR = BlockTypes.key(ResourceKey.minecraft("crimson_trapdoor"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_WALL_SIGN = BlockTypes.key(ResourceKey.minecraft("crimson_wall_sign"));

    public static final DefaultedRegistryReference<BlockType> CRYING_OBSIDIAN = BlockTypes.key(ResourceKey.minecraft("crying_obsidian"));

    public static final DefaultedRegistryReference<BlockType> CUT_COPPER = BlockTypes.key(ResourceKey.minecraft("cut_copper"));

    public static final DefaultedRegistryReference<BlockType> CUT_COPPER_SLAB = BlockTypes.key(ResourceKey.minecraft("cut_copper_slab"));

    public static final DefaultedRegistryReference<BlockType> CUT_COPPER_STAIRS = BlockTypes.key(ResourceKey.minecraft("cut_copper_stairs"));

    public static final DefaultedRegistryReference<BlockType> CUT_RED_SANDSTONE = BlockTypes.key(ResourceKey.minecraft("cut_red_sandstone"));

    public static final DefaultedRegistryReference<BlockType> CUT_RED_SANDSTONE_SLAB = BlockTypes.key(ResourceKey.minecraft("cut_red_sandstone_slab"));

    public static final DefaultedRegistryReference<BlockType> CUT_SANDSTONE = BlockTypes.key(ResourceKey.minecraft("cut_sandstone"));

    public static final DefaultedRegistryReference<BlockType> CUT_SANDSTONE_SLAB = BlockTypes.key(ResourceKey.minecraft("cut_sandstone_slab"));

    public static final DefaultedRegistryReference<BlockType> CYAN_BANNER = BlockTypes.key(ResourceKey.minecraft("cyan_banner"));

    public static final DefaultedRegistryReference<BlockType> CYAN_BED = BlockTypes.key(ResourceKey.minecraft("cyan_bed"));

    public static final DefaultedRegistryReference<BlockType> CYAN_CANDLE = BlockTypes.key(ResourceKey.minecraft("cyan_candle"));

    public static final DefaultedRegistryReference<BlockType> CYAN_CANDLE_CAKE = BlockTypes.key(ResourceKey.minecraft("cyan_candle_cake"));

    public static final DefaultedRegistryReference<BlockType> CYAN_CARPET = BlockTypes.key(ResourceKey.minecraft("cyan_carpet"));

    public static final DefaultedRegistryReference<BlockType> CYAN_CONCRETE = BlockTypes.key(ResourceKey.minecraft("cyan_concrete"));

    public static final DefaultedRegistryReference<BlockType> CYAN_CONCRETE_POWDER = BlockTypes.key(ResourceKey.minecraft("cyan_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> CYAN_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("cyan_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> CYAN_SHULKER_BOX = BlockTypes.key(ResourceKey.minecraft("cyan_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> CYAN_STAINED_GLASS = BlockTypes.key(ResourceKey.minecraft("cyan_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> CYAN_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.minecraft("cyan_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> CYAN_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("cyan_terracotta"));

    public static final DefaultedRegistryReference<BlockType> CYAN_WALL_BANNER = BlockTypes.key(ResourceKey.minecraft("cyan_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> CYAN_WOOL = BlockTypes.key(ResourceKey.minecraft("cyan_wool"));

    public static final DefaultedRegistryReference<BlockType> DAMAGED_ANVIL = BlockTypes.key(ResourceKey.minecraft("damaged_anvil"));

    public static final DefaultedRegistryReference<BlockType> DANDELION = BlockTypes.key(ResourceKey.minecraft("dandelion"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_BUTTON = BlockTypes.key(ResourceKey.minecraft("dark_oak_button"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_DOOR = BlockTypes.key(ResourceKey.minecraft("dark_oak_door"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_FENCE = BlockTypes.key(ResourceKey.minecraft("dark_oak_fence"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_FENCE_GATE = BlockTypes.key(ResourceKey.minecraft("dark_oak_fence_gate"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_LEAVES = BlockTypes.key(ResourceKey.minecraft("dark_oak_leaves"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_LOG = BlockTypes.key(ResourceKey.minecraft("dark_oak_log"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_PLANKS = BlockTypes.key(ResourceKey.minecraft("dark_oak_planks"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_PRESSURE_PLATE = BlockTypes.key(ResourceKey.minecraft("dark_oak_pressure_plate"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_SAPLING = BlockTypes.key(ResourceKey.minecraft("dark_oak_sapling"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_SIGN = BlockTypes.key(ResourceKey.minecraft("dark_oak_sign"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_SLAB = BlockTypes.key(ResourceKey.minecraft("dark_oak_slab"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_STAIRS = BlockTypes.key(ResourceKey.minecraft("dark_oak_stairs"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_TRAPDOOR = BlockTypes.key(ResourceKey.minecraft("dark_oak_trapdoor"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_WALL_SIGN = BlockTypes.key(ResourceKey.minecraft("dark_oak_wall_sign"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_WOOD = BlockTypes.key(ResourceKey.minecraft("dark_oak_wood"));

    public static final DefaultedRegistryReference<BlockType> DARK_PRISMARINE = BlockTypes.key(ResourceKey.minecraft("dark_prismarine"));

    public static final DefaultedRegistryReference<BlockType> DARK_PRISMARINE_SLAB = BlockTypes.key(ResourceKey.minecraft("dark_prismarine_slab"));

    public static final DefaultedRegistryReference<BlockType> DARK_PRISMARINE_STAIRS = BlockTypes.key(ResourceKey.minecraft("dark_prismarine_stairs"));

    public static final DefaultedRegistryReference<BlockType> DAYLIGHT_DETECTOR = BlockTypes.key(ResourceKey.minecraft("daylight_detector"));

    public static final DefaultedRegistryReference<BlockType> DEAD_BRAIN_CORAL = BlockTypes.key(ResourceKey.minecraft("dead_brain_coral"));

    public static final DefaultedRegistryReference<BlockType> DEAD_BRAIN_CORAL_BLOCK = BlockTypes.key(ResourceKey.minecraft("dead_brain_coral_block"));

    public static final DefaultedRegistryReference<BlockType> DEAD_BRAIN_CORAL_FAN = BlockTypes.key(ResourceKey.minecraft("dead_brain_coral_fan"));

    public static final DefaultedRegistryReference<BlockType> DEAD_BRAIN_CORAL_WALL_FAN = BlockTypes.key(ResourceKey.minecraft("dead_brain_coral_wall_fan"));

    public static final DefaultedRegistryReference<BlockType> DEAD_BUBBLE_CORAL = BlockTypes.key(ResourceKey.minecraft("dead_bubble_coral"));

    public static final DefaultedRegistryReference<BlockType> DEAD_BUBBLE_CORAL_BLOCK = BlockTypes.key(ResourceKey.minecraft("dead_bubble_coral_block"));

    public static final DefaultedRegistryReference<BlockType> DEAD_BUBBLE_CORAL_FAN = BlockTypes.key(ResourceKey.minecraft("dead_bubble_coral_fan"));

    public static final DefaultedRegistryReference<BlockType> DEAD_BUBBLE_CORAL_WALL_FAN = BlockTypes.key(ResourceKey.minecraft("dead_bubble_coral_wall_fan"));

    public static final DefaultedRegistryReference<BlockType> DEAD_BUSH = BlockTypes.key(ResourceKey.minecraft("dead_bush"));

    public static final DefaultedRegistryReference<BlockType> DEAD_FIRE_CORAL = BlockTypes.key(ResourceKey.minecraft("dead_fire_coral"));

    public static final DefaultedRegistryReference<BlockType> DEAD_FIRE_CORAL_BLOCK = BlockTypes.key(ResourceKey.minecraft("dead_fire_coral_block"));

    public static final DefaultedRegistryReference<BlockType> DEAD_FIRE_CORAL_FAN = BlockTypes.key(ResourceKey.minecraft("dead_fire_coral_fan"));

    public static final DefaultedRegistryReference<BlockType> DEAD_FIRE_CORAL_WALL_FAN = BlockTypes.key(ResourceKey.minecraft("dead_fire_coral_wall_fan"));

    public static final DefaultedRegistryReference<BlockType> DEAD_HORN_CORAL = BlockTypes.key(ResourceKey.minecraft("dead_horn_coral"));

    public static final DefaultedRegistryReference<BlockType> DEAD_HORN_CORAL_BLOCK = BlockTypes.key(ResourceKey.minecraft("dead_horn_coral_block"));

    public static final DefaultedRegistryReference<BlockType> DEAD_HORN_CORAL_FAN = BlockTypes.key(ResourceKey.minecraft("dead_horn_coral_fan"));

    public static final DefaultedRegistryReference<BlockType> DEAD_HORN_CORAL_WALL_FAN = BlockTypes.key(ResourceKey.minecraft("dead_horn_coral_wall_fan"));

    public static final DefaultedRegistryReference<BlockType> DEAD_TUBE_CORAL = BlockTypes.key(ResourceKey.minecraft("dead_tube_coral"));

    public static final DefaultedRegistryReference<BlockType> DEAD_TUBE_CORAL_BLOCK = BlockTypes.key(ResourceKey.minecraft("dead_tube_coral_block"));

    public static final DefaultedRegistryReference<BlockType> DEAD_TUBE_CORAL_FAN = BlockTypes.key(ResourceKey.minecraft("dead_tube_coral_fan"));

    public static final DefaultedRegistryReference<BlockType> DEAD_TUBE_CORAL_WALL_FAN = BlockTypes.key(ResourceKey.minecraft("dead_tube_coral_wall_fan"));

    public static final DefaultedRegistryReference<BlockType> DETECTOR_RAIL = BlockTypes.key(ResourceKey.minecraft("detector_rail"));

    public static final DefaultedRegistryReference<BlockType> DIAMOND_BLOCK = BlockTypes.key(ResourceKey.minecraft("diamond_block"));

    public static final DefaultedRegistryReference<BlockType> DIAMOND_ORE = BlockTypes.key(ResourceKey.minecraft("diamond_ore"));

    public static final DefaultedRegistryReference<BlockType> DIORITE = BlockTypes.key(ResourceKey.minecraft("diorite"));

    public static final DefaultedRegistryReference<BlockType> DIORITE_SLAB = BlockTypes.key(ResourceKey.minecraft("diorite_slab"));

    public static final DefaultedRegistryReference<BlockType> DIORITE_STAIRS = BlockTypes.key(ResourceKey.minecraft("diorite_stairs"));

    public static final DefaultedRegistryReference<BlockType> DIORITE_WALL = BlockTypes.key(ResourceKey.minecraft("diorite_wall"));

    public static final DefaultedRegistryReference<BlockType> DIRT = BlockTypes.key(ResourceKey.minecraft("dirt"));

    public static final DefaultedRegistryReference<BlockType> DIRT_PATH = BlockTypes.key(ResourceKey.minecraft("dirt_path"));

    public static final DefaultedRegistryReference<BlockType> DISPENSER = BlockTypes.key(ResourceKey.minecraft("dispenser"));

    public static final DefaultedRegistryReference<BlockType> DRAGON_EGG = BlockTypes.key(ResourceKey.minecraft("dragon_egg"));

    public static final DefaultedRegistryReference<BlockType> DRAGON_HEAD = BlockTypes.key(ResourceKey.minecraft("dragon_head"));

    public static final DefaultedRegistryReference<BlockType> DRAGON_WALL_HEAD = BlockTypes.key(ResourceKey.minecraft("dragon_wall_head"));

    public static final DefaultedRegistryReference<BlockType> DRIED_KELP_BLOCK = BlockTypes.key(ResourceKey.minecraft("dried_kelp_block"));

    public static final DefaultedRegistryReference<BlockType> DRIPSTONE_BLOCK = BlockTypes.key(ResourceKey.minecraft("dripstone_block"));

    public static final DefaultedRegistryReference<BlockType> DROPPER = BlockTypes.key(ResourceKey.minecraft("dropper"));

    public static final DefaultedRegistryReference<BlockType> EMERALD_BLOCK = BlockTypes.key(ResourceKey.minecraft("emerald_block"));

    public static final DefaultedRegistryReference<BlockType> EMERALD_ORE = BlockTypes.key(ResourceKey.minecraft("emerald_ore"));

    public static final DefaultedRegistryReference<BlockType> ENCHANTING_TABLE = BlockTypes.key(ResourceKey.minecraft("enchanting_table"));

    public static final DefaultedRegistryReference<BlockType> END_GATEWAY = BlockTypes.key(ResourceKey.minecraft("end_gateway"));

    public static final DefaultedRegistryReference<BlockType> END_PORTAL = BlockTypes.key(ResourceKey.minecraft("end_portal"));

    public static final DefaultedRegistryReference<BlockType> END_PORTAL_FRAME = BlockTypes.key(ResourceKey.minecraft("end_portal_frame"));

    public static final DefaultedRegistryReference<BlockType> END_ROD = BlockTypes.key(ResourceKey.minecraft("end_rod"));

    public static final DefaultedRegistryReference<BlockType> END_STONE = BlockTypes.key(ResourceKey.minecraft("end_stone"));

    public static final DefaultedRegistryReference<BlockType> END_STONE_BRICK_SLAB = BlockTypes.key(ResourceKey.minecraft("end_stone_brick_slab"));

    public static final DefaultedRegistryReference<BlockType> END_STONE_BRICK_STAIRS = BlockTypes.key(ResourceKey.minecraft("end_stone_brick_stairs"));

    public static final DefaultedRegistryReference<BlockType> END_STONE_BRICK_WALL = BlockTypes.key(ResourceKey.minecraft("end_stone_brick_wall"));

    public static final DefaultedRegistryReference<BlockType> END_STONE_BRICKS = BlockTypes.key(ResourceKey.minecraft("end_stone_bricks"));

    public static final DefaultedRegistryReference<BlockType> ENDER_CHEST = BlockTypes.key(ResourceKey.minecraft("ender_chest"));

    public static final DefaultedRegistryReference<BlockType> FARMLAND = BlockTypes.key(ResourceKey.minecraft("farmland"));

    public static final DefaultedRegistryReference<BlockType> FERN = BlockTypes.key(ResourceKey.minecraft("fern"));

    public static final DefaultedRegistryReference<BlockType> FIRE = BlockTypes.key(ResourceKey.minecraft("fire"));

    public static final DefaultedRegistryReference<BlockType> FIRE_CORAL = BlockTypes.key(ResourceKey.minecraft("fire_coral"));

    public static final DefaultedRegistryReference<BlockType> FIRE_CORAL_BLOCK = BlockTypes.key(ResourceKey.minecraft("fire_coral_block"));

    public static final DefaultedRegistryReference<BlockType> FIRE_CORAL_FAN = BlockTypes.key(ResourceKey.minecraft("fire_coral_fan"));

    public static final DefaultedRegistryReference<BlockType> FIRE_CORAL_WALL_FAN = BlockTypes.key(ResourceKey.minecraft("fire_coral_wall_fan"));

    public static final DefaultedRegistryReference<BlockType> FLETCHING_TABLE = BlockTypes.key(ResourceKey.minecraft("fletching_table"));

    public static final DefaultedRegistryReference<BlockType> FLOWER_POT = BlockTypes.key(ResourceKey.minecraft("flower_pot"));

    public static final DefaultedRegistryReference<BlockType> FROSTED_ICE = BlockTypes.key(ResourceKey.minecraft("frosted_ice"));

    public static final DefaultedRegistryReference<BlockType> FURNACE = BlockTypes.key(ResourceKey.minecraft("furnace"));

    public static final DefaultedRegistryReference<BlockType> GILDED_BLACKSTONE = BlockTypes.key(ResourceKey.minecraft("gilded_blackstone"));

    public static final DefaultedRegistryReference<BlockType> GLASS = BlockTypes.key(ResourceKey.minecraft("glass"));

    public static final DefaultedRegistryReference<BlockType> GLASS_PANE = BlockTypes.key(ResourceKey.minecraft("glass_pane"));

    public static final DefaultedRegistryReference<BlockType> GLOW_LICHEN = BlockTypes.key(ResourceKey.minecraft("glow_lichen"));

    public static final DefaultedRegistryReference<BlockType> GLOWSTONE = BlockTypes.key(ResourceKey.minecraft("glowstone"));

    public static final DefaultedRegistryReference<BlockType> GOLD_BLOCK = BlockTypes.key(ResourceKey.minecraft("gold_block"));

    public static final DefaultedRegistryReference<BlockType> GOLD_ORE = BlockTypes.key(ResourceKey.minecraft("gold_ore"));

    public static final DefaultedRegistryReference<BlockType> GRANITE = BlockTypes.key(ResourceKey.minecraft("granite"));

    public static final DefaultedRegistryReference<BlockType> GRANITE_SLAB = BlockTypes.key(ResourceKey.minecraft("granite_slab"));

    public static final DefaultedRegistryReference<BlockType> GRANITE_STAIRS = BlockTypes.key(ResourceKey.minecraft("granite_stairs"));

    public static final DefaultedRegistryReference<BlockType> GRANITE_WALL = BlockTypes.key(ResourceKey.minecraft("granite_wall"));

    public static final DefaultedRegistryReference<BlockType> GRASS = BlockTypes.key(ResourceKey.minecraft("grass"));

    public static final DefaultedRegistryReference<BlockType> GRASS_BLOCK = BlockTypes.key(ResourceKey.minecraft("grass_block"));

    public static final DefaultedRegistryReference<BlockType> GRAVEL = BlockTypes.key(ResourceKey.minecraft("gravel"));

    public static final DefaultedRegistryReference<BlockType> GRAY_BANNER = BlockTypes.key(ResourceKey.minecraft("gray_banner"));

    public static final DefaultedRegistryReference<BlockType> GRAY_BED = BlockTypes.key(ResourceKey.minecraft("gray_bed"));

    public static final DefaultedRegistryReference<BlockType> GRAY_CANDLE = BlockTypes.key(ResourceKey.minecraft("gray_candle"));

    public static final DefaultedRegistryReference<BlockType> GRAY_CANDLE_CAKE = BlockTypes.key(ResourceKey.minecraft("gray_candle_cake"));

    public static final DefaultedRegistryReference<BlockType> GRAY_CARPET = BlockTypes.key(ResourceKey.minecraft("gray_carpet"));

    public static final DefaultedRegistryReference<BlockType> GRAY_CONCRETE = BlockTypes.key(ResourceKey.minecraft("gray_concrete"));

    public static final DefaultedRegistryReference<BlockType> GRAY_CONCRETE_POWDER = BlockTypes.key(ResourceKey.minecraft("gray_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> GRAY_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("gray_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> GRAY_SHULKER_BOX = BlockTypes.key(ResourceKey.minecraft("gray_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> GRAY_STAINED_GLASS = BlockTypes.key(ResourceKey.minecraft("gray_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> GRAY_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.minecraft("gray_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> GRAY_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("gray_terracotta"));

    public static final DefaultedRegistryReference<BlockType> GRAY_WALL_BANNER = BlockTypes.key(ResourceKey.minecraft("gray_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> GRAY_WOOL = BlockTypes.key(ResourceKey.minecraft("gray_wool"));

    public static final DefaultedRegistryReference<BlockType> GREEN_BANNER = BlockTypes.key(ResourceKey.minecraft("green_banner"));

    public static final DefaultedRegistryReference<BlockType> GREEN_BED = BlockTypes.key(ResourceKey.minecraft("green_bed"));

    public static final DefaultedRegistryReference<BlockType> GREEN_CANDLE = BlockTypes.key(ResourceKey.minecraft("green_candle"));

    public static final DefaultedRegistryReference<BlockType> GREEN_CANDLE_CAKE = BlockTypes.key(ResourceKey.minecraft("green_candle_cake"));

    public static final DefaultedRegistryReference<BlockType> GREEN_CARPET = BlockTypes.key(ResourceKey.minecraft("green_carpet"));

    public static final DefaultedRegistryReference<BlockType> GREEN_CONCRETE = BlockTypes.key(ResourceKey.minecraft("green_concrete"));

    public static final DefaultedRegistryReference<BlockType> GREEN_CONCRETE_POWDER = BlockTypes.key(ResourceKey.minecraft("green_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> GREEN_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("green_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> GREEN_SHULKER_BOX = BlockTypes.key(ResourceKey.minecraft("green_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> GREEN_STAINED_GLASS = BlockTypes.key(ResourceKey.minecraft("green_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> GREEN_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.minecraft("green_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> GREEN_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("green_terracotta"));

    public static final DefaultedRegistryReference<BlockType> GREEN_WALL_BANNER = BlockTypes.key(ResourceKey.minecraft("green_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> GREEN_WOOL = BlockTypes.key(ResourceKey.minecraft("green_wool"));

    public static final DefaultedRegistryReference<BlockType> GRINDSTONE = BlockTypes.key(ResourceKey.minecraft("grindstone"));

    public static final DefaultedRegistryReference<BlockType> HAY_BLOCK = BlockTypes.key(ResourceKey.minecraft("hay_block"));

    public static final DefaultedRegistryReference<BlockType> HEAVY_WEIGHTED_PRESSURE_PLATE = BlockTypes.key(ResourceKey.minecraft("heavy_weighted_pressure_plate"));

    public static final DefaultedRegistryReference<BlockType> HONEY_BLOCK = BlockTypes.key(ResourceKey.minecraft("honey_block"));

    public static final DefaultedRegistryReference<BlockType> HONEYCOMB_BLOCK = BlockTypes.key(ResourceKey.minecraft("honeycomb_block"));

    public static final DefaultedRegistryReference<BlockType> HOPPER = BlockTypes.key(ResourceKey.minecraft("hopper"));

    public static final DefaultedRegistryReference<BlockType> HORN_CORAL = BlockTypes.key(ResourceKey.minecraft("horn_coral"));

    public static final DefaultedRegistryReference<BlockType> HORN_CORAL_BLOCK = BlockTypes.key(ResourceKey.minecraft("horn_coral_block"));

    public static final DefaultedRegistryReference<BlockType> HORN_CORAL_FAN = BlockTypes.key(ResourceKey.minecraft("horn_coral_fan"));

    public static final DefaultedRegistryReference<BlockType> HORN_CORAL_WALL_FAN = BlockTypes.key(ResourceKey.minecraft("horn_coral_wall_fan"));

    public static final DefaultedRegistryReference<BlockType> ICE = BlockTypes.key(ResourceKey.minecraft("ice"));

    public static final DefaultedRegistryReference<BlockType> INFESTED_CHISELED_STONE_BRICKS = BlockTypes.key(ResourceKey.minecraft("infested_chiseled_stone_bricks"));

    public static final DefaultedRegistryReference<BlockType> INFESTED_COBBLESTONE = BlockTypes.key(ResourceKey.minecraft("infested_cobblestone"));

    public static final DefaultedRegistryReference<BlockType> INFESTED_CRACKED_STONE_BRICKS = BlockTypes.key(ResourceKey.minecraft("infested_cracked_stone_bricks"));

    public static final DefaultedRegistryReference<BlockType> INFESTED_MOSSY_STONE_BRICKS = BlockTypes.key(ResourceKey.minecraft("infested_mossy_stone_bricks"));

    public static final DefaultedRegistryReference<BlockType> INFESTED_STONE = BlockTypes.key(ResourceKey.minecraft("infested_stone"));

    public static final DefaultedRegistryReference<BlockType> INFESTED_STONE_BRICKS = BlockTypes.key(ResourceKey.minecraft("infested_stone_bricks"));

    public static final DefaultedRegistryReference<BlockType> IRON_BARS = BlockTypes.key(ResourceKey.minecraft("iron_bars"));

    public static final DefaultedRegistryReference<BlockType> IRON_BLOCK = BlockTypes.key(ResourceKey.minecraft("iron_block"));

    public static final DefaultedRegistryReference<BlockType> IRON_DOOR = BlockTypes.key(ResourceKey.minecraft("iron_door"));

    public static final DefaultedRegistryReference<BlockType> IRON_ORE = BlockTypes.key(ResourceKey.minecraft("iron_ore"));

    public static final DefaultedRegistryReference<BlockType> IRON_TRAPDOOR = BlockTypes.key(ResourceKey.minecraft("iron_trapdoor"));

    public static final DefaultedRegistryReference<BlockType> JACK_O_LANTERN = BlockTypes.key(ResourceKey.minecraft("jack_o_lantern"));

    public static final DefaultedRegistryReference<BlockType> JIGSAW = BlockTypes.key(ResourceKey.minecraft("jigsaw"));

    public static final DefaultedRegistryReference<BlockType> JUKEBOX = BlockTypes.key(ResourceKey.minecraft("jukebox"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_BUTTON = BlockTypes.key(ResourceKey.minecraft("jungle_button"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_DOOR = BlockTypes.key(ResourceKey.minecraft("jungle_door"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_FENCE = BlockTypes.key(ResourceKey.minecraft("jungle_fence"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_FENCE_GATE = BlockTypes.key(ResourceKey.minecraft("jungle_fence_gate"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_LEAVES = BlockTypes.key(ResourceKey.minecraft("jungle_leaves"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_LOG = BlockTypes.key(ResourceKey.minecraft("jungle_log"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_PLANKS = BlockTypes.key(ResourceKey.minecraft("jungle_planks"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_PRESSURE_PLATE = BlockTypes.key(ResourceKey.minecraft("jungle_pressure_plate"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_SAPLING = BlockTypes.key(ResourceKey.minecraft("jungle_sapling"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_SIGN = BlockTypes.key(ResourceKey.minecraft("jungle_sign"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_SLAB = BlockTypes.key(ResourceKey.minecraft("jungle_slab"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_STAIRS = BlockTypes.key(ResourceKey.minecraft("jungle_stairs"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_TRAPDOOR = BlockTypes.key(ResourceKey.minecraft("jungle_trapdoor"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_WALL_SIGN = BlockTypes.key(ResourceKey.minecraft("jungle_wall_sign"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_WOOD = BlockTypes.key(ResourceKey.minecraft("jungle_wood"));

    public static final DefaultedRegistryReference<BlockType> KELP = BlockTypes.key(ResourceKey.minecraft("kelp"));

    public static final DefaultedRegistryReference<BlockType> KELP_PLANT = BlockTypes.key(ResourceKey.minecraft("kelp_plant"));

    public static final DefaultedRegistryReference<BlockType> LADDER = BlockTypes.key(ResourceKey.minecraft("ladder"));

    public static final DefaultedRegistryReference<BlockType> LANTERN = BlockTypes.key(ResourceKey.minecraft("lantern"));

    public static final DefaultedRegistryReference<BlockType> LAPIS_BLOCK = BlockTypes.key(ResourceKey.minecraft("lapis_block"));

    public static final DefaultedRegistryReference<BlockType> LAPIS_ORE = BlockTypes.key(ResourceKey.minecraft("lapis_ore"));

    public static final DefaultedRegistryReference<BlockType> LARGE_AMETHYST_BUD = BlockTypes.key(ResourceKey.minecraft("large_amethyst_bud"));

    public static final DefaultedRegistryReference<BlockType> LARGE_FERN = BlockTypes.key(ResourceKey.minecraft("large_fern"));

    public static final DefaultedRegistryReference<BlockType> LAVA = BlockTypes.key(ResourceKey.minecraft("lava"));

    public static final DefaultedRegistryReference<BlockType> LAVA_CAULDRON = BlockTypes.key(ResourceKey.minecraft("lava_cauldron"));

    public static final DefaultedRegistryReference<BlockType> LECTERN = BlockTypes.key(ResourceKey.minecraft("lectern"));

    public static final DefaultedRegistryReference<BlockType> LEVER = BlockTypes.key(ResourceKey.minecraft("lever"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_BLUE_BANNER = BlockTypes.key(ResourceKey.minecraft("light_blue_banner"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_BLUE_BED = BlockTypes.key(ResourceKey.minecraft("light_blue_bed"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_BLUE_CANDLE = BlockTypes.key(ResourceKey.minecraft("light_blue_candle"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_BLUE_CANDLE_CAKE = BlockTypes.key(ResourceKey.minecraft("light_blue_candle_cake"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_BLUE_CARPET = BlockTypes.key(ResourceKey.minecraft("light_blue_carpet"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_BLUE_CONCRETE = BlockTypes.key(ResourceKey.minecraft("light_blue_concrete"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_BLUE_CONCRETE_POWDER = BlockTypes.key(ResourceKey.minecraft("light_blue_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_BLUE_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("light_blue_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_BLUE_SHULKER_BOX = BlockTypes.key(ResourceKey.minecraft("light_blue_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_BLUE_STAINED_GLASS = BlockTypes.key(ResourceKey.minecraft("light_blue_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_BLUE_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.minecraft("light_blue_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_BLUE_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("light_blue_terracotta"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_BLUE_WALL_BANNER = BlockTypes.key(ResourceKey.minecraft("light_blue_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_BLUE_WOOL = BlockTypes.key(ResourceKey.minecraft("light_blue_wool"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_GRAY_BANNER = BlockTypes.key(ResourceKey.minecraft("light_gray_banner"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_GRAY_BED = BlockTypes.key(ResourceKey.minecraft("light_gray_bed"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_GRAY_CANDLE = BlockTypes.key(ResourceKey.minecraft("light_gray_candle"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_GRAY_CANDLE_CAKE = BlockTypes.key(ResourceKey.minecraft("light_gray_candle_cake"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_GRAY_CARPET = BlockTypes.key(ResourceKey.minecraft("light_gray_carpet"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_GRAY_CONCRETE = BlockTypes.key(ResourceKey.minecraft("light_gray_concrete"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_GRAY_CONCRETE_POWDER = BlockTypes.key(ResourceKey.minecraft("light_gray_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_GRAY_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("light_gray_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_GRAY_SHULKER_BOX = BlockTypes.key(ResourceKey.minecraft("light_gray_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_GRAY_STAINED_GLASS = BlockTypes.key(ResourceKey.minecraft("light_gray_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_GRAY_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.minecraft("light_gray_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_GRAY_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("light_gray_terracotta"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_GRAY_WALL_BANNER = BlockTypes.key(ResourceKey.minecraft("light_gray_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_GRAY_WOOL = BlockTypes.key(ResourceKey.minecraft("light_gray_wool"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_WEIGHTED_PRESSURE_PLATE = BlockTypes.key(ResourceKey.minecraft("light_weighted_pressure_plate"));

    public static final DefaultedRegistryReference<BlockType> LIGHTLY_WEATHERED_COPPER_BLOCK = BlockTypes.key(ResourceKey.minecraft("lightly_weathered_copper_block"));

    public static final DefaultedRegistryReference<BlockType> LIGHTLY_WEATHERED_CUT_COPPER = BlockTypes.key(ResourceKey.minecraft("lightly_weathered_cut_copper"));

    public static final DefaultedRegistryReference<BlockType> LIGHTLY_WEATHERED_CUT_COPPER_SLAB = BlockTypes.key(ResourceKey.minecraft("lightly_weathered_cut_copper_slab"));

    public static final DefaultedRegistryReference<BlockType> LIGHTLY_WEATHERED_CUT_COPPER_STAIRS = BlockTypes.key(ResourceKey.minecraft("lightly_weathered_cut_copper_stairs"));

    public static final DefaultedRegistryReference<BlockType> LIGHTNING_ROD = BlockTypes.key(ResourceKey.minecraft("lightning_rod"));

    public static final DefaultedRegistryReference<BlockType> LILAC = BlockTypes.key(ResourceKey.minecraft("lilac"));

    public static final DefaultedRegistryReference<BlockType> LILY_OF_THE_VALLEY = BlockTypes.key(ResourceKey.minecraft("lily_of_the_valley"));

    public static final DefaultedRegistryReference<BlockType> LILY_PAD = BlockTypes.key(ResourceKey.minecraft("lily_pad"));

    public static final DefaultedRegistryReference<BlockType> LIME_BANNER = BlockTypes.key(ResourceKey.minecraft("lime_banner"));

    public static final DefaultedRegistryReference<BlockType> LIME_BED = BlockTypes.key(ResourceKey.minecraft("lime_bed"));

    public static final DefaultedRegistryReference<BlockType> LIME_CANDLE = BlockTypes.key(ResourceKey.minecraft("lime_candle"));

    public static final DefaultedRegistryReference<BlockType> LIME_CANDLE_CAKE = BlockTypes.key(ResourceKey.minecraft("lime_candle_cake"));

    public static final DefaultedRegistryReference<BlockType> LIME_CARPET = BlockTypes.key(ResourceKey.minecraft("lime_carpet"));

    public static final DefaultedRegistryReference<BlockType> LIME_CONCRETE = BlockTypes.key(ResourceKey.minecraft("lime_concrete"));

    public static final DefaultedRegistryReference<BlockType> LIME_CONCRETE_POWDER = BlockTypes.key(ResourceKey.minecraft("lime_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> LIME_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("lime_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> LIME_SHULKER_BOX = BlockTypes.key(ResourceKey.minecraft("lime_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> LIME_STAINED_GLASS = BlockTypes.key(ResourceKey.minecraft("lime_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> LIME_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.minecraft("lime_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> LIME_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("lime_terracotta"));

    public static final DefaultedRegistryReference<BlockType> LIME_WALL_BANNER = BlockTypes.key(ResourceKey.minecraft("lime_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> LIME_WOOL = BlockTypes.key(ResourceKey.minecraft("lime_wool"));

    public static final DefaultedRegistryReference<BlockType> LODESTONE = BlockTypes.key(ResourceKey.minecraft("lodestone"));

    public static final DefaultedRegistryReference<BlockType> LOOM = BlockTypes.key(ResourceKey.minecraft("loom"));

    public static final DefaultedRegistryReference<BlockType> MAGENTA_BANNER = BlockTypes.key(ResourceKey.minecraft("magenta_banner"));

    public static final DefaultedRegistryReference<BlockType> MAGENTA_BED = BlockTypes.key(ResourceKey.minecraft("magenta_bed"));

    public static final DefaultedRegistryReference<BlockType> MAGENTA_CANDLE = BlockTypes.key(ResourceKey.minecraft("magenta_candle"));

    public static final DefaultedRegistryReference<BlockType> MAGENTA_CANDLE_CAKE = BlockTypes.key(ResourceKey.minecraft("magenta_candle_cake"));

    public static final DefaultedRegistryReference<BlockType> MAGENTA_CARPET = BlockTypes.key(ResourceKey.minecraft("magenta_carpet"));

    public static final DefaultedRegistryReference<BlockType> MAGENTA_CONCRETE = BlockTypes.key(ResourceKey.minecraft("magenta_concrete"));

    public static final DefaultedRegistryReference<BlockType> MAGENTA_CONCRETE_POWDER = BlockTypes.key(ResourceKey.minecraft("magenta_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> MAGENTA_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("magenta_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> MAGENTA_SHULKER_BOX = BlockTypes.key(ResourceKey.minecraft("magenta_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> MAGENTA_STAINED_GLASS = BlockTypes.key(ResourceKey.minecraft("magenta_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> MAGENTA_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.minecraft("magenta_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> MAGENTA_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("magenta_terracotta"));

    public static final DefaultedRegistryReference<BlockType> MAGENTA_WALL_BANNER = BlockTypes.key(ResourceKey.minecraft("magenta_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> MAGENTA_WOOL = BlockTypes.key(ResourceKey.minecraft("magenta_wool"));

    public static final DefaultedRegistryReference<BlockType> MAGMA_BLOCK = BlockTypes.key(ResourceKey.minecraft("magma_block"));

    public static final DefaultedRegistryReference<BlockType> MEDIUM_AMETHYST_BUD = BlockTypes.key(ResourceKey.minecraft("medium_amethyst_bud"));

    public static final DefaultedRegistryReference<BlockType> MELON = BlockTypes.key(ResourceKey.minecraft("melon"));

    public static final DefaultedRegistryReference<BlockType> MELON_STEM = BlockTypes.key(ResourceKey.minecraft("melon_stem"));

    public static final DefaultedRegistryReference<BlockType> MOSSY_COBBLESTONE = BlockTypes.key(ResourceKey.minecraft("mossy_cobblestone"));

    public static final DefaultedRegistryReference<BlockType> MOSSY_COBBLESTONE_SLAB = BlockTypes.key(ResourceKey.minecraft("mossy_cobblestone_slab"));

    public static final DefaultedRegistryReference<BlockType> MOSSY_COBBLESTONE_STAIRS = BlockTypes.key(ResourceKey.minecraft("mossy_cobblestone_stairs"));

    public static final DefaultedRegistryReference<BlockType> MOSSY_COBBLESTONE_WALL = BlockTypes.key(ResourceKey.minecraft("mossy_cobblestone_wall"));

    public static final DefaultedRegistryReference<BlockType> MOSSY_STONE_BRICK_SLAB = BlockTypes.key(ResourceKey.minecraft("mossy_stone_brick_slab"));

    public static final DefaultedRegistryReference<BlockType> MOSSY_STONE_BRICK_STAIRS = BlockTypes.key(ResourceKey.minecraft("mossy_stone_brick_stairs"));

    public static final DefaultedRegistryReference<BlockType> MOSSY_STONE_BRICK_WALL = BlockTypes.key(ResourceKey.minecraft("mossy_stone_brick_wall"));

    public static final DefaultedRegistryReference<BlockType> MOSSY_STONE_BRICKS = BlockTypes.key(ResourceKey.minecraft("mossy_stone_bricks"));

    public static final DefaultedRegistryReference<BlockType> MOVING_PISTON = BlockTypes.key(ResourceKey.minecraft("moving_piston"));

    public static final DefaultedRegistryReference<BlockType> MUSHROOM_STEM = BlockTypes.key(ResourceKey.minecraft("mushroom_stem"));

    public static final DefaultedRegistryReference<BlockType> MYCELIUM = BlockTypes.key(ResourceKey.minecraft("mycelium"));

    public static final DefaultedRegistryReference<BlockType> NETHER_BRICK_FENCE = BlockTypes.key(ResourceKey.minecraft("nether_brick_fence"));

    public static final DefaultedRegistryReference<BlockType> NETHER_BRICK_SLAB = BlockTypes.key(ResourceKey.minecraft("nether_brick_slab"));

    public static final DefaultedRegistryReference<BlockType> NETHER_BRICK_STAIRS = BlockTypes.key(ResourceKey.minecraft("nether_brick_stairs"));

    public static final DefaultedRegistryReference<BlockType> NETHER_BRICK_WALL = BlockTypes.key(ResourceKey.minecraft("nether_brick_wall"));

    public static final DefaultedRegistryReference<BlockType> NETHER_BRICKS = BlockTypes.key(ResourceKey.minecraft("nether_bricks"));

    public static final DefaultedRegistryReference<BlockType> NETHER_GOLD_ORE = BlockTypes.key(ResourceKey.minecraft("nether_gold_ore"));

    public static final DefaultedRegistryReference<BlockType> NETHER_PORTAL = BlockTypes.key(ResourceKey.minecraft("nether_portal"));

    public static final DefaultedRegistryReference<BlockType> NETHER_QUARTZ_ORE = BlockTypes.key(ResourceKey.minecraft("nether_quartz_ore"));

    public static final DefaultedRegistryReference<BlockType> NETHER_SPROUTS = BlockTypes.key(ResourceKey.minecraft("nether_sprouts"));

    public static final DefaultedRegistryReference<BlockType> NETHER_WART = BlockTypes.key(ResourceKey.minecraft("nether_wart"));

    public static final DefaultedRegistryReference<BlockType> NETHER_WART_BLOCK = BlockTypes.key(ResourceKey.minecraft("nether_wart_block"));

    public static final DefaultedRegistryReference<BlockType> NETHERITE_BLOCK = BlockTypes.key(ResourceKey.minecraft("netherite_block"));

    public static final DefaultedRegistryReference<BlockType> NETHERRACK = BlockTypes.key(ResourceKey.minecraft("netherrack"));

    public static final DefaultedRegistryReference<BlockType> NOTE_BLOCK = BlockTypes.key(ResourceKey.minecraft("note_block"));

    public static final DefaultedRegistryReference<BlockType> OAK_BUTTON = BlockTypes.key(ResourceKey.minecraft("oak_button"));

    public static final DefaultedRegistryReference<BlockType> OAK_DOOR = BlockTypes.key(ResourceKey.minecraft("oak_door"));

    public static final DefaultedRegistryReference<BlockType> OAK_FENCE = BlockTypes.key(ResourceKey.minecraft("oak_fence"));

    public static final DefaultedRegistryReference<BlockType> OAK_FENCE_GATE = BlockTypes.key(ResourceKey.minecraft("oak_fence_gate"));

    public static final DefaultedRegistryReference<BlockType> OAK_LEAVES = BlockTypes.key(ResourceKey.minecraft("oak_leaves"));

    public static final DefaultedRegistryReference<BlockType> OAK_LOG = BlockTypes.key(ResourceKey.minecraft("oak_log"));

    public static final DefaultedRegistryReference<BlockType> OAK_PLANKS = BlockTypes.key(ResourceKey.minecraft("oak_planks"));

    public static final DefaultedRegistryReference<BlockType> OAK_PRESSURE_PLATE = BlockTypes.key(ResourceKey.minecraft("oak_pressure_plate"));

    public static final DefaultedRegistryReference<BlockType> OAK_SAPLING = BlockTypes.key(ResourceKey.minecraft("oak_sapling"));

    public static final DefaultedRegistryReference<BlockType> OAK_SIGN = BlockTypes.key(ResourceKey.minecraft("oak_sign"));

    public static final DefaultedRegistryReference<BlockType> OAK_SLAB = BlockTypes.key(ResourceKey.minecraft("oak_slab"));

    public static final DefaultedRegistryReference<BlockType> OAK_STAIRS = BlockTypes.key(ResourceKey.minecraft("oak_stairs"));

    public static final DefaultedRegistryReference<BlockType> OAK_TRAPDOOR = BlockTypes.key(ResourceKey.minecraft("oak_trapdoor"));

    public static final DefaultedRegistryReference<BlockType> OAK_WALL_SIGN = BlockTypes.key(ResourceKey.minecraft("oak_wall_sign"));

    public static final DefaultedRegistryReference<BlockType> OAK_WOOD = BlockTypes.key(ResourceKey.minecraft("oak_wood"));

    public static final DefaultedRegistryReference<BlockType> OBSERVER = BlockTypes.key(ResourceKey.minecraft("observer"));

    public static final DefaultedRegistryReference<BlockType> OBSIDIAN = BlockTypes.key(ResourceKey.minecraft("obsidian"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_BANNER = BlockTypes.key(ResourceKey.minecraft("orange_banner"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_BED = BlockTypes.key(ResourceKey.minecraft("orange_bed"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_CANDLE = BlockTypes.key(ResourceKey.minecraft("orange_candle"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_CANDLE_CAKE = BlockTypes.key(ResourceKey.minecraft("orange_candle_cake"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_CARPET = BlockTypes.key(ResourceKey.minecraft("orange_carpet"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_CONCRETE = BlockTypes.key(ResourceKey.minecraft("orange_concrete"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_CONCRETE_POWDER = BlockTypes.key(ResourceKey.minecraft("orange_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("orange_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_SHULKER_BOX = BlockTypes.key(ResourceKey.minecraft("orange_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_STAINED_GLASS = BlockTypes.key(ResourceKey.minecraft("orange_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.minecraft("orange_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("orange_terracotta"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_TULIP = BlockTypes.key(ResourceKey.minecraft("orange_tulip"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_WALL_BANNER = BlockTypes.key(ResourceKey.minecraft("orange_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_WOOL = BlockTypes.key(ResourceKey.minecraft("orange_wool"));

    public static final DefaultedRegistryReference<BlockType> OXEYE_DAISY = BlockTypes.key(ResourceKey.minecraft("oxeye_daisy"));

    public static final DefaultedRegistryReference<BlockType> PACKED_ICE = BlockTypes.key(ResourceKey.minecraft("packed_ice"));

    public static final DefaultedRegistryReference<BlockType> PEONY = BlockTypes.key(ResourceKey.minecraft("peony"));

    public static final DefaultedRegistryReference<BlockType> PETRIFIED_OAK_SLAB = BlockTypes.key(ResourceKey.minecraft("petrified_oak_slab"));

    public static final DefaultedRegistryReference<BlockType> PINK_BANNER = BlockTypes.key(ResourceKey.minecraft("pink_banner"));

    public static final DefaultedRegistryReference<BlockType> PINK_BED = BlockTypes.key(ResourceKey.minecraft("pink_bed"));

    public static final DefaultedRegistryReference<BlockType> PINK_CANDLE = BlockTypes.key(ResourceKey.minecraft("pink_candle"));

    public static final DefaultedRegistryReference<BlockType> PINK_CANDLE_CAKE = BlockTypes.key(ResourceKey.minecraft("pink_candle_cake"));

    public static final DefaultedRegistryReference<BlockType> PINK_CARPET = BlockTypes.key(ResourceKey.minecraft("pink_carpet"));

    public static final DefaultedRegistryReference<BlockType> PINK_CONCRETE = BlockTypes.key(ResourceKey.minecraft("pink_concrete"));

    public static final DefaultedRegistryReference<BlockType> PINK_CONCRETE_POWDER = BlockTypes.key(ResourceKey.minecraft("pink_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> PINK_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("pink_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> PINK_SHULKER_BOX = BlockTypes.key(ResourceKey.minecraft("pink_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> PINK_STAINED_GLASS = BlockTypes.key(ResourceKey.minecraft("pink_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> PINK_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.minecraft("pink_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> PINK_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("pink_terracotta"));

    public static final DefaultedRegistryReference<BlockType> PINK_TULIP = BlockTypes.key(ResourceKey.minecraft("pink_tulip"));

    public static final DefaultedRegistryReference<BlockType> PINK_WALL_BANNER = BlockTypes.key(ResourceKey.minecraft("pink_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> PINK_WOOL = BlockTypes.key(ResourceKey.minecraft("pink_wool"));

    public static final DefaultedRegistryReference<BlockType> PISTON = BlockTypes.key(ResourceKey.minecraft("piston"));

    public static final DefaultedRegistryReference<BlockType> PISTON_HEAD = BlockTypes.key(ResourceKey.minecraft("piston_head"));

    public static final DefaultedRegistryReference<BlockType> PLAYER_HEAD = BlockTypes.key(ResourceKey.minecraft("player_head"));

    public static final DefaultedRegistryReference<BlockType> PLAYER_WALL_HEAD = BlockTypes.key(ResourceKey.minecraft("player_wall_head"));

    public static final DefaultedRegistryReference<BlockType> PODZOL = BlockTypes.key(ResourceKey.minecraft("podzol"));

    public static final DefaultedRegistryReference<BlockType> POINTED_DRIPSTONE = BlockTypes.key(ResourceKey.minecraft("pointed_dripstone"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_ANDESITE = BlockTypes.key(ResourceKey.minecraft("polished_andesite"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_ANDESITE_SLAB = BlockTypes.key(ResourceKey.minecraft("polished_andesite_slab"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_ANDESITE_STAIRS = BlockTypes.key(ResourceKey.minecraft("polished_andesite_stairs"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_BASALT = BlockTypes.key(ResourceKey.minecraft("polished_basalt"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_BLACKSTONE = BlockTypes.key(ResourceKey.minecraft("polished_blackstone"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_BLACKSTONE_BRICK_SLAB = BlockTypes.key(ResourceKey.minecraft("polished_blackstone_brick_slab"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_BLACKSTONE_BRICK_STAIRS = BlockTypes.key(ResourceKey.minecraft("polished_blackstone_brick_stairs"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_BLACKSTONE_BRICK_WALL = BlockTypes.key(ResourceKey.minecraft("polished_blackstone_brick_wall"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_BLACKSTONE_BRICKS = BlockTypes.key(ResourceKey.minecraft("polished_blackstone_bricks"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_BLACKSTONE_BUTTON = BlockTypes.key(ResourceKey.minecraft("polished_blackstone_button"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_BLACKSTONE_PRESSURE_PLATE = BlockTypes.key(ResourceKey.minecraft("polished_blackstone_pressure_plate"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_BLACKSTONE_SLAB = BlockTypes.key(ResourceKey.minecraft("polished_blackstone_slab"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_BLACKSTONE_STAIRS = BlockTypes.key(ResourceKey.minecraft("polished_blackstone_stairs"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_BLACKSTONE_WALL = BlockTypes.key(ResourceKey.minecraft("polished_blackstone_wall"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_DIORITE = BlockTypes.key(ResourceKey.minecraft("polished_diorite"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_DIORITE_SLAB = BlockTypes.key(ResourceKey.minecraft("polished_diorite_slab"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_DIORITE_STAIRS = BlockTypes.key(ResourceKey.minecraft("polished_diorite_stairs"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_GRANITE = BlockTypes.key(ResourceKey.minecraft("polished_granite"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_GRANITE_SLAB = BlockTypes.key(ResourceKey.minecraft("polished_granite_slab"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_GRANITE_STAIRS = BlockTypes.key(ResourceKey.minecraft("polished_granite_stairs"));

    public static final DefaultedRegistryReference<BlockType> POPPY = BlockTypes.key(ResourceKey.minecraft("poppy"));

    public static final DefaultedRegistryReference<BlockType> POTATOES = BlockTypes.key(ResourceKey.minecraft("potatoes"));

    public static final DefaultedRegistryReference<BlockType> POTTED_ACACIA_SAPLING = BlockTypes.key(ResourceKey.minecraft("potted_acacia_sapling"));

    public static final DefaultedRegistryReference<BlockType> POTTED_ALLIUM = BlockTypes.key(ResourceKey.minecraft("potted_allium"));

    public static final DefaultedRegistryReference<BlockType> POTTED_AZURE_BLUET = BlockTypes.key(ResourceKey.minecraft("potted_azure_bluet"));

    public static final DefaultedRegistryReference<BlockType> POTTED_BAMBOO = BlockTypes.key(ResourceKey.minecraft("potted_bamboo"));

    public static final DefaultedRegistryReference<BlockType> POTTED_BIRCH_SAPLING = BlockTypes.key(ResourceKey.minecraft("potted_birch_sapling"));

    public static final DefaultedRegistryReference<BlockType> POTTED_BLUE_ORCHID = BlockTypes.key(ResourceKey.minecraft("potted_blue_orchid"));

    public static final DefaultedRegistryReference<BlockType> POTTED_BROWN_MUSHROOM = BlockTypes.key(ResourceKey.minecraft("potted_brown_mushroom"));

    public static final DefaultedRegistryReference<BlockType> POTTED_CACTUS = BlockTypes.key(ResourceKey.minecraft("potted_cactus"));

    public static final DefaultedRegistryReference<BlockType> POTTED_CORNFLOWER = BlockTypes.key(ResourceKey.minecraft("potted_cornflower"));

    public static final DefaultedRegistryReference<BlockType> POTTED_CRIMSON_FUNGUS = BlockTypes.key(ResourceKey.minecraft("potted_crimson_fungus"));

    public static final DefaultedRegistryReference<BlockType> POTTED_CRIMSON_ROOTS = BlockTypes.key(ResourceKey.minecraft("potted_crimson_roots"));

    public static final DefaultedRegistryReference<BlockType> POTTED_DANDELION = BlockTypes.key(ResourceKey.minecraft("potted_dandelion"));

    public static final DefaultedRegistryReference<BlockType> POTTED_DARK_OAK_SAPLING = BlockTypes.key(ResourceKey.minecraft("potted_dark_oak_sapling"));

    public static final DefaultedRegistryReference<BlockType> POTTED_DEAD_BUSH = BlockTypes.key(ResourceKey.minecraft("potted_dead_bush"));

    public static final DefaultedRegistryReference<BlockType> POTTED_FERN = BlockTypes.key(ResourceKey.minecraft("potted_fern"));

    public static final DefaultedRegistryReference<BlockType> POTTED_JUNGLE_SAPLING = BlockTypes.key(ResourceKey.minecraft("potted_jungle_sapling"));

    public static final DefaultedRegistryReference<BlockType> POTTED_LILY_OF_THE_VALLEY = BlockTypes.key(ResourceKey.minecraft("potted_lily_of_the_valley"));

    public static final DefaultedRegistryReference<BlockType> POTTED_OAK_SAPLING = BlockTypes.key(ResourceKey.minecraft("potted_oak_sapling"));

    public static final DefaultedRegistryReference<BlockType> POTTED_ORANGE_TULIP = BlockTypes.key(ResourceKey.minecraft("potted_orange_tulip"));

    public static final DefaultedRegistryReference<BlockType> POTTED_OXEYE_DAISY = BlockTypes.key(ResourceKey.minecraft("potted_oxeye_daisy"));

    public static final DefaultedRegistryReference<BlockType> POTTED_PINK_TULIP = BlockTypes.key(ResourceKey.minecraft("potted_pink_tulip"));

    public static final DefaultedRegistryReference<BlockType> POTTED_POPPY = BlockTypes.key(ResourceKey.minecraft("potted_poppy"));

    public static final DefaultedRegistryReference<BlockType> POTTED_RED_MUSHROOM = BlockTypes.key(ResourceKey.minecraft("potted_red_mushroom"));

    public static final DefaultedRegistryReference<BlockType> POTTED_RED_TULIP = BlockTypes.key(ResourceKey.minecraft("potted_red_tulip"));

    public static final DefaultedRegistryReference<BlockType> POTTED_SPRUCE_SAPLING = BlockTypes.key(ResourceKey.minecraft("potted_spruce_sapling"));

    public static final DefaultedRegistryReference<BlockType> POTTED_WARPED_FUNGUS = BlockTypes.key(ResourceKey.minecraft("potted_warped_fungus"));

    public static final DefaultedRegistryReference<BlockType> POTTED_WARPED_ROOTS = BlockTypes.key(ResourceKey.minecraft("potted_warped_roots"));

    public static final DefaultedRegistryReference<BlockType> POTTED_WHITE_TULIP = BlockTypes.key(ResourceKey.minecraft("potted_white_tulip"));

    public static final DefaultedRegistryReference<BlockType> POTTED_WITHER_ROSE = BlockTypes.key(ResourceKey.minecraft("potted_wither_rose"));

    public static final DefaultedRegistryReference<BlockType> POWDER_SNOW = BlockTypes.key(ResourceKey.minecraft("powder_snow"));

    public static final DefaultedRegistryReference<BlockType> POWDER_SNOW_CAULDRON = BlockTypes.key(ResourceKey.minecraft("powder_snow_cauldron"));

    public static final DefaultedRegistryReference<BlockType> POWERED_RAIL = BlockTypes.key(ResourceKey.minecraft("powered_rail"));

    public static final DefaultedRegistryReference<BlockType> PRISMARINE = BlockTypes.key(ResourceKey.minecraft("prismarine"));

    public static final DefaultedRegistryReference<BlockType> PRISMARINE_BRICK_SLAB = BlockTypes.key(ResourceKey.minecraft("prismarine_brick_slab"));

    public static final DefaultedRegistryReference<BlockType> PRISMARINE_BRICK_STAIRS = BlockTypes.key(ResourceKey.minecraft("prismarine_brick_stairs"));

    public static final DefaultedRegistryReference<BlockType> PRISMARINE_BRICKS = BlockTypes.key(ResourceKey.minecraft("prismarine_bricks"));

    public static final DefaultedRegistryReference<BlockType> PRISMARINE_SLAB = BlockTypes.key(ResourceKey.minecraft("prismarine_slab"));

    public static final DefaultedRegistryReference<BlockType> PRISMARINE_STAIRS = BlockTypes.key(ResourceKey.minecraft("prismarine_stairs"));

    public static final DefaultedRegistryReference<BlockType> PRISMARINE_WALL = BlockTypes.key(ResourceKey.minecraft("prismarine_wall"));

    public static final DefaultedRegistryReference<BlockType> PUMPKIN = BlockTypes.key(ResourceKey.minecraft("pumpkin"));

    public static final DefaultedRegistryReference<BlockType> PUMPKIN_STEM = BlockTypes.key(ResourceKey.minecraft("pumpkin_stem"));

    public static final DefaultedRegistryReference<BlockType> PURPLE_BANNER = BlockTypes.key(ResourceKey.minecraft("purple_banner"));

    public static final DefaultedRegistryReference<BlockType> PURPLE_BED = BlockTypes.key(ResourceKey.minecraft("purple_bed"));

    public static final DefaultedRegistryReference<BlockType> PURPLE_CANDLE = BlockTypes.key(ResourceKey.minecraft("purple_candle"));

    public static final DefaultedRegistryReference<BlockType> PURPLE_CANDLE_CAKE = BlockTypes.key(ResourceKey.minecraft("purple_candle_cake"));

    public static final DefaultedRegistryReference<BlockType> PURPLE_CARPET = BlockTypes.key(ResourceKey.minecraft("purple_carpet"));

    public static final DefaultedRegistryReference<BlockType> PURPLE_CONCRETE = BlockTypes.key(ResourceKey.minecraft("purple_concrete"));

    public static final DefaultedRegistryReference<BlockType> PURPLE_CONCRETE_POWDER = BlockTypes.key(ResourceKey.minecraft("purple_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> PURPLE_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("purple_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> PURPLE_SHULKER_BOX = BlockTypes.key(ResourceKey.minecraft("purple_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> PURPLE_STAINED_GLASS = BlockTypes.key(ResourceKey.minecraft("purple_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> PURPLE_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.minecraft("purple_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> PURPLE_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("purple_terracotta"));

    public static final DefaultedRegistryReference<BlockType> PURPLE_WALL_BANNER = BlockTypes.key(ResourceKey.minecraft("purple_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> PURPLE_WOOL = BlockTypes.key(ResourceKey.minecraft("purple_wool"));

    public static final DefaultedRegistryReference<BlockType> PURPUR_BLOCK = BlockTypes.key(ResourceKey.minecraft("purpur_block"));

    public static final DefaultedRegistryReference<BlockType> PURPUR_PILLAR = BlockTypes.key(ResourceKey.minecraft("purpur_pillar"));

    public static final DefaultedRegistryReference<BlockType> PURPUR_SLAB = BlockTypes.key(ResourceKey.minecraft("purpur_slab"));

    public static final DefaultedRegistryReference<BlockType> PURPUR_STAIRS = BlockTypes.key(ResourceKey.minecraft("purpur_stairs"));

    public static final DefaultedRegistryReference<BlockType> QUARTZ_BLOCK = BlockTypes.key(ResourceKey.minecraft("quartz_block"));

    public static final DefaultedRegistryReference<BlockType> QUARTZ_BRICKS = BlockTypes.key(ResourceKey.minecraft("quartz_bricks"));

    public static final DefaultedRegistryReference<BlockType> QUARTZ_PILLAR = BlockTypes.key(ResourceKey.minecraft("quartz_pillar"));

    public static final DefaultedRegistryReference<BlockType> QUARTZ_SLAB = BlockTypes.key(ResourceKey.minecraft("quartz_slab"));

    public static final DefaultedRegistryReference<BlockType> QUARTZ_STAIRS = BlockTypes.key(ResourceKey.minecraft("quartz_stairs"));

    public static final DefaultedRegistryReference<BlockType> RAIL = BlockTypes.key(ResourceKey.minecraft("rail"));

    public static final DefaultedRegistryReference<BlockType> RED_BANNER = BlockTypes.key(ResourceKey.minecraft("red_banner"));

    public static final DefaultedRegistryReference<BlockType> RED_BED = BlockTypes.key(ResourceKey.minecraft("red_bed"));

    public static final DefaultedRegistryReference<BlockType> RED_CANDLE = BlockTypes.key(ResourceKey.minecraft("red_candle"));

    public static final DefaultedRegistryReference<BlockType> RED_CANDLE_CAKE = BlockTypes.key(ResourceKey.minecraft("red_candle_cake"));

    public static final DefaultedRegistryReference<BlockType> RED_CARPET = BlockTypes.key(ResourceKey.minecraft("red_carpet"));

    public static final DefaultedRegistryReference<BlockType> RED_CONCRETE = BlockTypes.key(ResourceKey.minecraft("red_concrete"));

    public static final DefaultedRegistryReference<BlockType> RED_CONCRETE_POWDER = BlockTypes.key(ResourceKey.minecraft("red_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> RED_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("red_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> RED_MUSHROOM = BlockTypes.key(ResourceKey.minecraft("red_mushroom"));

    public static final DefaultedRegistryReference<BlockType> RED_MUSHROOM_BLOCK = BlockTypes.key(ResourceKey.minecraft("red_mushroom_block"));

    public static final DefaultedRegistryReference<BlockType> RED_NETHER_BRICK_SLAB = BlockTypes.key(ResourceKey.minecraft("red_nether_brick_slab"));

    public static final DefaultedRegistryReference<BlockType> RED_NETHER_BRICK_STAIRS = BlockTypes.key(ResourceKey.minecraft("red_nether_brick_stairs"));

    public static final DefaultedRegistryReference<BlockType> RED_NETHER_BRICK_WALL = BlockTypes.key(ResourceKey.minecraft("red_nether_brick_wall"));

    public static final DefaultedRegistryReference<BlockType> RED_NETHER_BRICKS = BlockTypes.key(ResourceKey.minecraft("red_nether_bricks"));

    public static final DefaultedRegistryReference<BlockType> RED_SAND = BlockTypes.key(ResourceKey.minecraft("red_sand"));

    public static final DefaultedRegistryReference<BlockType> RED_SANDSTONE = BlockTypes.key(ResourceKey.minecraft("red_sandstone"));

    public static final DefaultedRegistryReference<BlockType> RED_SANDSTONE_SLAB = BlockTypes.key(ResourceKey.minecraft("red_sandstone_slab"));

    public static final DefaultedRegistryReference<BlockType> RED_SANDSTONE_STAIRS = BlockTypes.key(ResourceKey.minecraft("red_sandstone_stairs"));

    public static final DefaultedRegistryReference<BlockType> RED_SANDSTONE_WALL = BlockTypes.key(ResourceKey.minecraft("red_sandstone_wall"));

    public static final DefaultedRegistryReference<BlockType> RED_SHULKER_BOX = BlockTypes.key(ResourceKey.minecraft("red_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> RED_STAINED_GLASS = BlockTypes.key(ResourceKey.minecraft("red_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> RED_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.minecraft("red_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> RED_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("red_terracotta"));

    public static final DefaultedRegistryReference<BlockType> RED_TULIP = BlockTypes.key(ResourceKey.minecraft("red_tulip"));

    public static final DefaultedRegistryReference<BlockType> RED_WALL_BANNER = BlockTypes.key(ResourceKey.minecraft("red_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> RED_WOOL = BlockTypes.key(ResourceKey.minecraft("red_wool"));

    public static final DefaultedRegistryReference<BlockType> REDSTONE_BLOCK = BlockTypes.key(ResourceKey.minecraft("redstone_block"));

    public static final DefaultedRegistryReference<BlockType> REDSTONE_LAMP = BlockTypes.key(ResourceKey.minecraft("redstone_lamp"));

    public static final DefaultedRegistryReference<BlockType> REDSTONE_ORE = BlockTypes.key(ResourceKey.minecraft("redstone_ore"));

    public static final DefaultedRegistryReference<BlockType> REDSTONE_TORCH = BlockTypes.key(ResourceKey.minecraft("redstone_torch"));

    public static final DefaultedRegistryReference<BlockType> REDSTONE_WALL_TORCH = BlockTypes.key(ResourceKey.minecraft("redstone_wall_torch"));

    public static final DefaultedRegistryReference<BlockType> REDSTONE_WIRE = BlockTypes.key(ResourceKey.minecraft("redstone_wire"));

    public static final DefaultedRegistryReference<BlockType> REPEATER = BlockTypes.key(ResourceKey.minecraft("repeater"));

    public static final DefaultedRegistryReference<BlockType> REPEATING_COMMAND_BLOCK = BlockTypes.key(ResourceKey.minecraft("repeating_command_block"));

    public static final DefaultedRegistryReference<BlockType> RESPAWN_ANCHOR = BlockTypes.key(ResourceKey.minecraft("respawn_anchor"));

    public static final DefaultedRegistryReference<BlockType> ROSE_BUSH = BlockTypes.key(ResourceKey.minecraft("rose_bush"));

    public static final DefaultedRegistryReference<BlockType> SAND = BlockTypes.key(ResourceKey.minecraft("sand"));

    public static final DefaultedRegistryReference<BlockType> SANDSTONE = BlockTypes.key(ResourceKey.minecraft("sandstone"));

    public static final DefaultedRegistryReference<BlockType> SANDSTONE_SLAB = BlockTypes.key(ResourceKey.minecraft("sandstone_slab"));

    public static final DefaultedRegistryReference<BlockType> SANDSTONE_STAIRS = BlockTypes.key(ResourceKey.minecraft("sandstone_stairs"));

    public static final DefaultedRegistryReference<BlockType> SANDSTONE_WALL = BlockTypes.key(ResourceKey.minecraft("sandstone_wall"));

    public static final DefaultedRegistryReference<BlockType> SCAFFOLDING = BlockTypes.key(ResourceKey.minecraft("scaffolding"));

    public static final DefaultedRegistryReference<BlockType> SCULK_SENSOR = BlockTypes.key(ResourceKey.minecraft("sculk_sensor"));

    public static final DefaultedRegistryReference<BlockType> SEA_LANTERN = BlockTypes.key(ResourceKey.minecraft("sea_lantern"));

    public static final DefaultedRegistryReference<BlockType> SEA_PICKLE = BlockTypes.key(ResourceKey.minecraft("sea_pickle"));

    public static final DefaultedRegistryReference<BlockType> SEAGRASS = BlockTypes.key(ResourceKey.minecraft("seagrass"));

    public static final DefaultedRegistryReference<BlockType> SEMI_WEATHERED_COPPER_BLOCK = BlockTypes.key(ResourceKey.minecraft("semi_weathered_copper_block"));

    public static final DefaultedRegistryReference<BlockType> SEMI_WEATHERED_CUT_COPPER = BlockTypes.key(ResourceKey.minecraft("semi_weathered_cut_copper"));

    public static final DefaultedRegistryReference<BlockType> SEMI_WEATHERED_CUT_COPPER_SLAB = BlockTypes.key(ResourceKey.minecraft("semi_weathered_cut_copper_slab"));

    public static final DefaultedRegistryReference<BlockType> SEMI_WEATHERED_CUT_COPPER_STAIRS = BlockTypes.key(ResourceKey.minecraft("semi_weathered_cut_copper_stairs"));

    public static final DefaultedRegistryReference<BlockType> SHROOMLIGHT = BlockTypes.key(ResourceKey.minecraft("shroomlight"));

    public static final DefaultedRegistryReference<BlockType> SHULKER_BOX = BlockTypes.key(ResourceKey.minecraft("shulker_box"));

    public static final DefaultedRegistryReference<BlockType> SKELETON_SKULL = BlockTypes.key(ResourceKey.minecraft("skeleton_skull"));

    public static final DefaultedRegistryReference<BlockType> SKELETON_WALL_SKULL = BlockTypes.key(ResourceKey.minecraft("skeleton_wall_skull"));

    public static final DefaultedRegistryReference<BlockType> SLIME_BLOCK = BlockTypes.key(ResourceKey.minecraft("slime_block"));

    public static final DefaultedRegistryReference<BlockType> SMALL_AMETHYST_BUD = BlockTypes.key(ResourceKey.minecraft("small_amethyst_bud"));

    public static final DefaultedRegistryReference<BlockType> SMITHING_TABLE = BlockTypes.key(ResourceKey.minecraft("smithing_table"));

    public static final DefaultedRegistryReference<BlockType> SMOKER = BlockTypes.key(ResourceKey.minecraft("smoker"));

    public static final DefaultedRegistryReference<BlockType> SMOOTH_QUARTZ = BlockTypes.key(ResourceKey.minecraft("smooth_quartz"));

    public static final DefaultedRegistryReference<BlockType> SMOOTH_QUARTZ_SLAB = BlockTypes.key(ResourceKey.minecraft("smooth_quartz_slab"));

    public static final DefaultedRegistryReference<BlockType> SMOOTH_QUARTZ_STAIRS = BlockTypes.key(ResourceKey.minecraft("smooth_quartz_stairs"));

    public static final DefaultedRegistryReference<BlockType> SMOOTH_RED_SANDSTONE = BlockTypes.key(ResourceKey.minecraft("smooth_red_sandstone"));

    public static final DefaultedRegistryReference<BlockType> SMOOTH_RED_SANDSTONE_SLAB = BlockTypes.key(ResourceKey.minecraft("smooth_red_sandstone_slab"));

    public static final DefaultedRegistryReference<BlockType> SMOOTH_RED_SANDSTONE_STAIRS = BlockTypes.key(ResourceKey.minecraft("smooth_red_sandstone_stairs"));

    public static final DefaultedRegistryReference<BlockType> SMOOTH_SANDSTONE = BlockTypes.key(ResourceKey.minecraft("smooth_sandstone"));

    public static final DefaultedRegistryReference<BlockType> SMOOTH_SANDSTONE_SLAB = BlockTypes.key(ResourceKey.minecraft("smooth_sandstone_slab"));

    public static final DefaultedRegistryReference<BlockType> SMOOTH_SANDSTONE_STAIRS = BlockTypes.key(ResourceKey.minecraft("smooth_sandstone_stairs"));

    public static final DefaultedRegistryReference<BlockType> SMOOTH_STONE = BlockTypes.key(ResourceKey.minecraft("smooth_stone"));

    public static final DefaultedRegistryReference<BlockType> SMOOTH_STONE_SLAB = BlockTypes.key(ResourceKey.minecraft("smooth_stone_slab"));

    public static final DefaultedRegistryReference<BlockType> SNOW = BlockTypes.key(ResourceKey.minecraft("snow"));

    public static final DefaultedRegistryReference<BlockType> SNOW_BLOCK = BlockTypes.key(ResourceKey.minecraft("snow_block"));

    public static final DefaultedRegistryReference<BlockType> SOUL_CAMPFIRE = BlockTypes.key(ResourceKey.minecraft("soul_campfire"));

    public static final DefaultedRegistryReference<BlockType> SOUL_FIRE = BlockTypes.key(ResourceKey.minecraft("soul_fire"));

    public static final DefaultedRegistryReference<BlockType> SOUL_LANTERN = BlockTypes.key(ResourceKey.minecraft("soul_lantern"));

    public static final DefaultedRegistryReference<BlockType> SOUL_SAND = BlockTypes.key(ResourceKey.minecraft("soul_sand"));

    public static final DefaultedRegistryReference<BlockType> SOUL_SOIL = BlockTypes.key(ResourceKey.minecraft("soul_soil"));

    public static final DefaultedRegistryReference<BlockType> SOUL_TORCH = BlockTypes.key(ResourceKey.minecraft("soul_torch"));

    public static final DefaultedRegistryReference<BlockType> SOUL_WALL_TORCH = BlockTypes.key(ResourceKey.minecraft("soul_wall_torch"));

    public static final DefaultedRegistryReference<BlockType> SPAWNER = BlockTypes.key(ResourceKey.minecraft("spawner"));

    public static final DefaultedRegistryReference<BlockType> SPONGE = BlockTypes.key(ResourceKey.minecraft("sponge"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_BUTTON = BlockTypes.key(ResourceKey.minecraft("spruce_button"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_DOOR = BlockTypes.key(ResourceKey.minecraft("spruce_door"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_FENCE = BlockTypes.key(ResourceKey.minecraft("spruce_fence"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_FENCE_GATE = BlockTypes.key(ResourceKey.minecraft("spruce_fence_gate"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_LEAVES = BlockTypes.key(ResourceKey.minecraft("spruce_leaves"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_LOG = BlockTypes.key(ResourceKey.minecraft("spruce_log"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_PLANKS = BlockTypes.key(ResourceKey.minecraft("spruce_planks"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_PRESSURE_PLATE = BlockTypes.key(ResourceKey.minecraft("spruce_pressure_plate"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_SAPLING = BlockTypes.key(ResourceKey.minecraft("spruce_sapling"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_SIGN = BlockTypes.key(ResourceKey.minecraft("spruce_sign"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_SLAB = BlockTypes.key(ResourceKey.minecraft("spruce_slab"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_STAIRS = BlockTypes.key(ResourceKey.minecraft("spruce_stairs"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_TRAPDOOR = BlockTypes.key(ResourceKey.minecraft("spruce_trapdoor"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_WALL_SIGN = BlockTypes.key(ResourceKey.minecraft("spruce_wall_sign"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_WOOD = BlockTypes.key(ResourceKey.minecraft("spruce_wood"));

    public static final DefaultedRegistryReference<BlockType> STICKY_PISTON = BlockTypes.key(ResourceKey.minecraft("sticky_piston"));

    public static final DefaultedRegistryReference<BlockType> STONE = BlockTypes.key(ResourceKey.minecraft("stone"));

    public static final DefaultedRegistryReference<BlockType> STONE_BRICK_SLAB = BlockTypes.key(ResourceKey.minecraft("stone_brick_slab"));

    public static final DefaultedRegistryReference<BlockType> STONE_BRICK_STAIRS = BlockTypes.key(ResourceKey.minecraft("stone_brick_stairs"));

    public static final DefaultedRegistryReference<BlockType> STONE_BRICK_WALL = BlockTypes.key(ResourceKey.minecraft("stone_brick_wall"));

    public static final DefaultedRegistryReference<BlockType> STONE_BRICKS = BlockTypes.key(ResourceKey.minecraft("stone_bricks"));

    public static final DefaultedRegistryReference<BlockType> STONE_BUTTON = BlockTypes.key(ResourceKey.minecraft("stone_button"));

    public static final DefaultedRegistryReference<BlockType> STONE_PRESSURE_PLATE = BlockTypes.key(ResourceKey.minecraft("stone_pressure_plate"));

    public static final DefaultedRegistryReference<BlockType> STONE_SLAB = BlockTypes.key(ResourceKey.minecraft("stone_slab"));

    public static final DefaultedRegistryReference<BlockType> STONE_STAIRS = BlockTypes.key(ResourceKey.minecraft("stone_stairs"));

    public static final DefaultedRegistryReference<BlockType> STONECUTTER = BlockTypes.key(ResourceKey.minecraft("stonecutter"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_ACACIA_LOG = BlockTypes.key(ResourceKey.minecraft("stripped_acacia_log"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_ACACIA_WOOD = BlockTypes.key(ResourceKey.minecraft("stripped_acacia_wood"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_BIRCH_LOG = BlockTypes.key(ResourceKey.minecraft("stripped_birch_log"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_BIRCH_WOOD = BlockTypes.key(ResourceKey.minecraft("stripped_birch_wood"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_CRIMSON_HYPHAE = BlockTypes.key(ResourceKey.minecraft("stripped_crimson_hyphae"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_CRIMSON_STEM = BlockTypes.key(ResourceKey.minecraft("stripped_crimson_stem"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_DARK_OAK_LOG = BlockTypes.key(ResourceKey.minecraft("stripped_dark_oak_log"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_DARK_OAK_WOOD = BlockTypes.key(ResourceKey.minecraft("stripped_dark_oak_wood"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_JUNGLE_LOG = BlockTypes.key(ResourceKey.minecraft("stripped_jungle_log"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_JUNGLE_WOOD = BlockTypes.key(ResourceKey.minecraft("stripped_jungle_wood"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_OAK_LOG = BlockTypes.key(ResourceKey.minecraft("stripped_oak_log"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_OAK_WOOD = BlockTypes.key(ResourceKey.minecraft("stripped_oak_wood"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_SPRUCE_LOG = BlockTypes.key(ResourceKey.minecraft("stripped_spruce_log"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_SPRUCE_WOOD = BlockTypes.key(ResourceKey.minecraft("stripped_spruce_wood"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_WARPED_HYPHAE = BlockTypes.key(ResourceKey.minecraft("stripped_warped_hyphae"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_WARPED_STEM = BlockTypes.key(ResourceKey.minecraft("stripped_warped_stem"));

    public static final DefaultedRegistryReference<BlockType> STRUCTURE_BLOCK = BlockTypes.key(ResourceKey.minecraft("structure_block"));

    public static final DefaultedRegistryReference<BlockType> STRUCTURE_VOID = BlockTypes.key(ResourceKey.minecraft("structure_void"));

    public static final DefaultedRegistryReference<BlockType> SUGAR_CANE = BlockTypes.key(ResourceKey.minecraft("sugar_cane"));

    public static final DefaultedRegistryReference<BlockType> SUNFLOWER = BlockTypes.key(ResourceKey.minecraft("sunflower"));

    public static final DefaultedRegistryReference<BlockType> SWEET_BERRY_BUSH = BlockTypes.key(ResourceKey.minecraft("sweet_berry_bush"));

    public static final DefaultedRegistryReference<BlockType> TALL_GRASS = BlockTypes.key(ResourceKey.minecraft("tall_grass"));

    public static final DefaultedRegistryReference<BlockType> TALL_SEAGRASS = BlockTypes.key(ResourceKey.minecraft("tall_seagrass"));

    public static final DefaultedRegistryReference<BlockType> TARGET = BlockTypes.key(ResourceKey.minecraft("target"));

    public static final DefaultedRegistryReference<BlockType> TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("terracotta"));

    public static final DefaultedRegistryReference<BlockType> TINTED_GLASS = BlockTypes.key(ResourceKey.minecraft("tinted_glass"));

    public static final DefaultedRegistryReference<BlockType> TNT = BlockTypes.key(ResourceKey.minecraft("tnt"));

    public static final DefaultedRegistryReference<BlockType> TORCH = BlockTypes.key(ResourceKey.minecraft("torch"));

    public static final DefaultedRegistryReference<BlockType> TRAPPED_CHEST = BlockTypes.key(ResourceKey.minecraft("trapped_chest"));

    public static final DefaultedRegistryReference<BlockType> TRIPWIRE = BlockTypes.key(ResourceKey.minecraft("tripwire"));

    public static final DefaultedRegistryReference<BlockType> TRIPWIRE_HOOK = BlockTypes.key(ResourceKey.minecraft("tripwire_hook"));

    public static final DefaultedRegistryReference<BlockType> TUBE_CORAL = BlockTypes.key(ResourceKey.minecraft("tube_coral"));

    public static final DefaultedRegistryReference<BlockType> TUBE_CORAL_BLOCK = BlockTypes.key(ResourceKey.minecraft("tube_coral_block"));

    public static final DefaultedRegistryReference<BlockType> TUBE_CORAL_FAN = BlockTypes.key(ResourceKey.minecraft("tube_coral_fan"));

    public static final DefaultedRegistryReference<BlockType> TUBE_CORAL_WALL_FAN = BlockTypes.key(ResourceKey.minecraft("tube_coral_wall_fan"));

    public static final DefaultedRegistryReference<BlockType> TUFF = BlockTypes.key(ResourceKey.minecraft("tuff"));

    public static final DefaultedRegistryReference<BlockType> TURTLE_EGG = BlockTypes.key(ResourceKey.minecraft("turtle_egg"));

    public static final DefaultedRegistryReference<BlockType> TWISTING_VINES = BlockTypes.key(ResourceKey.minecraft("twisting_vines"));

    public static final DefaultedRegistryReference<BlockType> TWISTING_VINES_PLANT = BlockTypes.key(ResourceKey.minecraft("twisting_vines_plant"));

    public static final DefaultedRegistryReference<BlockType> VINE = BlockTypes.key(ResourceKey.minecraft("vine"));

    public static final DefaultedRegistryReference<BlockType> VOID_AIR = BlockTypes.key(ResourceKey.minecraft("void_air"));

    public static final DefaultedRegistryReference<BlockType> WALL_TORCH = BlockTypes.key(ResourceKey.minecraft("wall_torch"));

    public static final DefaultedRegistryReference<BlockType> WARPED_BUTTON = BlockTypes.key(ResourceKey.minecraft("warped_button"));

    public static final DefaultedRegistryReference<BlockType> WARPED_DOOR = BlockTypes.key(ResourceKey.minecraft("warped_door"));

    public static final DefaultedRegistryReference<BlockType> WARPED_FENCE = BlockTypes.key(ResourceKey.minecraft("warped_fence"));

    public static final DefaultedRegistryReference<BlockType> WARPED_FENCE_GATE = BlockTypes.key(ResourceKey.minecraft("warped_fence_gate"));

    public static final DefaultedRegistryReference<BlockType> WARPED_FUNGUS = BlockTypes.key(ResourceKey.minecraft("warped_fungus"));

    public static final DefaultedRegistryReference<BlockType> WARPED_HYPHAE = BlockTypes.key(ResourceKey.minecraft("warped_hyphae"));

    public static final DefaultedRegistryReference<BlockType> WARPED_NYLIUM = BlockTypes.key(ResourceKey.minecraft("warped_nylium"));

    public static final DefaultedRegistryReference<BlockType> WARPED_PLANKS = BlockTypes.key(ResourceKey.minecraft("warped_planks"));

    public static final DefaultedRegistryReference<BlockType> WARPED_PRESSURE_PLATE = BlockTypes.key(ResourceKey.minecraft("warped_pressure_plate"));

    public static final DefaultedRegistryReference<BlockType> WARPED_ROOTS = BlockTypes.key(ResourceKey.minecraft("warped_roots"));

    public static final DefaultedRegistryReference<BlockType> WARPED_SIGN = BlockTypes.key(ResourceKey.minecraft("warped_sign"));

    public static final DefaultedRegistryReference<BlockType> WARPED_SLAB = BlockTypes.key(ResourceKey.minecraft("warped_slab"));

    public static final DefaultedRegistryReference<BlockType> WARPED_STAIRS = BlockTypes.key(ResourceKey.minecraft("warped_stairs"));

    public static final DefaultedRegistryReference<BlockType> WARPED_STEM = BlockTypes.key(ResourceKey.minecraft("warped_stem"));

    public static final DefaultedRegistryReference<BlockType> WARPED_TRAPDOOR = BlockTypes.key(ResourceKey.minecraft("warped_trapdoor"));

    public static final DefaultedRegistryReference<BlockType> WARPED_WALL_SIGN = BlockTypes.key(ResourceKey.minecraft("warped_wall_sign"));

    public static final DefaultedRegistryReference<BlockType> WARPED_WART_BLOCK = BlockTypes.key(ResourceKey.minecraft("warped_wart_block"));

    public static final DefaultedRegistryReference<BlockType> WATER = BlockTypes.key(ResourceKey.minecraft("water"));

    public static final DefaultedRegistryReference<BlockType> WATER_CAULDRON = BlockTypes.key(ResourceKey.minecraft("water_cauldron"));

    public static final DefaultedRegistryReference<BlockType> WAXED_COPPER = BlockTypes.key(ResourceKey.minecraft("waxed_copper"));

    public static final DefaultedRegistryReference<BlockType> WAXED_CUT_COPPER = BlockTypes.key(ResourceKey.minecraft("waxed_cut_copper"));

    public static final DefaultedRegistryReference<BlockType> WAXED_CUT_COPPER_SLAB = BlockTypes.key(ResourceKey.minecraft("waxed_cut_copper_slab"));

    public static final DefaultedRegistryReference<BlockType> WAXED_CUT_COPPER_STAIRS = BlockTypes.key(ResourceKey.minecraft("waxed_cut_copper_stairs"));

    public static final DefaultedRegistryReference<BlockType> WAXED_LIGHTLY_WEATHERED_COPPER = BlockTypes.key(ResourceKey.minecraft("waxed_lightly_weathered_copper"));

    public static final DefaultedRegistryReference<BlockType> WAXED_LIGHTLY_WEATHERED_CUT_COPPER = BlockTypes.key(ResourceKey.minecraft("waxed_lightly_weathered_cut_copper"));

    public static final DefaultedRegistryReference<BlockType> WAXED_LIGHTLY_WEATHERED_CUT_COPPER_SLAB = BlockTypes.key(ResourceKey.minecraft("waxed_lightly_weathered_cut_copper_slab"));

    public static final DefaultedRegistryReference<BlockType> WAXED_LIGHTLY_WEATHERED_CUT_COPPER_STAIRS = BlockTypes.key(ResourceKey.minecraft("waxed_lightly_weathered_cut_copper_stairs"));

    public static final DefaultedRegistryReference<BlockType> WAXED_SEMI_WEATHERED_COPPER = BlockTypes.key(ResourceKey.minecraft("waxed_semi_weathered_copper"));

    public static final DefaultedRegistryReference<BlockType> WAXED_SEMI_WEATHERED_CUT_COPPER = BlockTypes.key(ResourceKey.minecraft("waxed_semi_weathered_cut_copper"));

    public static final DefaultedRegistryReference<BlockType> WAXED_SEMI_WEATHERED_CUT_COPPER_SLAB = BlockTypes.key(ResourceKey.minecraft("waxed_semi_weathered_cut_copper_slab"));

    public static final DefaultedRegistryReference<BlockType> WAXED_SEMI_WEATHERED_CUT_COPPER_STAIRS = BlockTypes.key(ResourceKey.minecraft("waxed_semi_weathered_cut_copper_stairs"));

    public static final DefaultedRegistryReference<BlockType> WEATHERED_COPPER_BLOCK = BlockTypes.key(ResourceKey.minecraft("weathered_copper_block"));

    public static final DefaultedRegistryReference<BlockType> WEATHERED_CUT_COPPER = BlockTypes.key(ResourceKey.minecraft("weathered_cut_copper"));

    public static final DefaultedRegistryReference<BlockType> WEATHERED_CUT_COPPER_SLAB = BlockTypes.key(ResourceKey.minecraft("weathered_cut_copper_slab"));

    public static final DefaultedRegistryReference<BlockType> WEATHERED_CUT_COPPER_STAIRS = BlockTypes.key(ResourceKey.minecraft("weathered_cut_copper_stairs"));

    public static final DefaultedRegistryReference<BlockType> WEEPING_VINES = BlockTypes.key(ResourceKey.minecraft("weeping_vines"));

    public static final DefaultedRegistryReference<BlockType> WEEPING_VINES_PLANT = BlockTypes.key(ResourceKey.minecraft("weeping_vines_plant"));

    public static final DefaultedRegistryReference<BlockType> WET_SPONGE = BlockTypes.key(ResourceKey.minecraft("wet_sponge"));

    public static final DefaultedRegistryReference<BlockType> WHEAT = BlockTypes.key(ResourceKey.minecraft("wheat"));

    public static final DefaultedRegistryReference<BlockType> WHITE_BANNER = BlockTypes.key(ResourceKey.minecraft("white_banner"));

    public static final DefaultedRegistryReference<BlockType> WHITE_BED = BlockTypes.key(ResourceKey.minecraft("white_bed"));

    public static final DefaultedRegistryReference<BlockType> WHITE_CANDLE = BlockTypes.key(ResourceKey.minecraft("white_candle"));

    public static final DefaultedRegistryReference<BlockType> WHITE_CANDLE_CAKE = BlockTypes.key(ResourceKey.minecraft("white_candle_cake"));

    public static final DefaultedRegistryReference<BlockType> WHITE_CARPET = BlockTypes.key(ResourceKey.minecraft("white_carpet"));

    public static final DefaultedRegistryReference<BlockType> WHITE_CONCRETE = BlockTypes.key(ResourceKey.minecraft("white_concrete"));

    public static final DefaultedRegistryReference<BlockType> WHITE_CONCRETE_POWDER = BlockTypes.key(ResourceKey.minecraft("white_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> WHITE_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("white_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> WHITE_SHULKER_BOX = BlockTypes.key(ResourceKey.minecraft("white_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> WHITE_STAINED_GLASS = BlockTypes.key(ResourceKey.minecraft("white_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> WHITE_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.minecraft("white_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> WHITE_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("white_terracotta"));

    public static final DefaultedRegistryReference<BlockType> WHITE_TULIP = BlockTypes.key(ResourceKey.minecraft("white_tulip"));

    public static final DefaultedRegistryReference<BlockType> WHITE_WALL_BANNER = BlockTypes.key(ResourceKey.minecraft("white_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> WHITE_WOOL = BlockTypes.key(ResourceKey.minecraft("white_wool"));

    public static final DefaultedRegistryReference<BlockType> WITHER_ROSE = BlockTypes.key(ResourceKey.minecraft("wither_rose"));

    public static final DefaultedRegistryReference<BlockType> WITHER_SKELETON_SKULL = BlockTypes.key(ResourceKey.minecraft("wither_skeleton_skull"));

    public static final DefaultedRegistryReference<BlockType> WITHER_SKELETON_WALL_SKULL = BlockTypes.key(ResourceKey.minecraft("wither_skeleton_wall_skull"));

    public static final DefaultedRegistryReference<BlockType> YELLOW_BANNER = BlockTypes.key(ResourceKey.minecraft("yellow_banner"));

    public static final DefaultedRegistryReference<BlockType> YELLOW_BED = BlockTypes.key(ResourceKey.minecraft("yellow_bed"));

    public static final DefaultedRegistryReference<BlockType> YELLOW_CANDLE = BlockTypes.key(ResourceKey.minecraft("yellow_candle"));

    public static final DefaultedRegistryReference<BlockType> YELLOW_CANDLE_CAKE = BlockTypes.key(ResourceKey.minecraft("yellow_candle_cake"));

    public static final DefaultedRegistryReference<BlockType> YELLOW_CARPET = BlockTypes.key(ResourceKey.minecraft("yellow_carpet"));

    public static final DefaultedRegistryReference<BlockType> YELLOW_CONCRETE = BlockTypes.key(ResourceKey.minecraft("yellow_concrete"));

    public static final DefaultedRegistryReference<BlockType> YELLOW_CONCRETE_POWDER = BlockTypes.key(ResourceKey.minecraft("yellow_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> YELLOW_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("yellow_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> YELLOW_SHULKER_BOX = BlockTypes.key(ResourceKey.minecraft("yellow_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> YELLOW_STAINED_GLASS = BlockTypes.key(ResourceKey.minecraft("yellow_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> YELLOW_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.minecraft("yellow_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> YELLOW_TERRACOTTA = BlockTypes.key(ResourceKey.minecraft("yellow_terracotta"));

    public static final DefaultedRegistryReference<BlockType> YELLOW_WALL_BANNER = BlockTypes.key(ResourceKey.minecraft("yellow_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> YELLOW_WOOL = BlockTypes.key(ResourceKey.minecraft("yellow_wool"));

    public static final DefaultedRegistryReference<BlockType> ZOMBIE_HEAD = BlockTypes.key(ResourceKey.minecraft("zombie_head"));

    public static final DefaultedRegistryReference<BlockType> ZOMBIE_WALL_HEAD = BlockTypes.key(ResourceKey.minecraft("zombie_wall_head"));

    // SORTFIELDS:OFF

    // @formatter:on

    private BlockTypes() {
    }

    private static DefaultedRegistryReference<BlockType> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.BLOCK_TYPE, location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
