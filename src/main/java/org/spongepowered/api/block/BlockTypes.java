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
import org.spongepowered.api.registry.Registries;
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

    public static final DefaultedRegistryReference<BlockType> ACACIA_BUTTON = BlockTypes.key(ResourceKey.sponge("acacia_button"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_DOOR = BlockTypes.key(ResourceKey.sponge("acacia_door"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_FENCE = BlockTypes.key(ResourceKey.sponge("acacia_fence"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_FENCE_GATE = BlockTypes.key(ResourceKey.sponge("acacia_fence_gate"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_LEAVES = BlockTypes.key(ResourceKey.sponge("acacia_leaves"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_LOG = BlockTypes.key(ResourceKey.sponge("acacia_log"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_PLANKS = BlockTypes.key(ResourceKey.sponge("acacia_planks"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_PRESSURE_PLATE = BlockTypes.key(ResourceKey.sponge("acacia_pressure_plate"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_SAPLING = BlockTypes.key(ResourceKey.sponge("acacia_sapling"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_SIGN = BlockTypes.key(ResourceKey.sponge("acacia_sign"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_SLAB = BlockTypes.key(ResourceKey.sponge("acacia_slab"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_STAIRS = BlockTypes.key(ResourceKey.sponge("acacia_stairs"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_TRAPDOOR = BlockTypes.key(ResourceKey.sponge("acacia_trapdoor"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_WALL_SIGN = BlockTypes.key(ResourceKey.sponge("acacia_wall_sign"));

    public static final DefaultedRegistryReference<BlockType> ACACIA_WOOD = BlockTypes.key(ResourceKey.sponge("acacia_wood"));

    public static final DefaultedRegistryReference<BlockType> ACTIVATOR_RAIL = BlockTypes.key(ResourceKey.sponge("activator_rail"));

    public static final DefaultedRegistryReference<BlockType> AIR = BlockTypes.key(ResourceKey.sponge("air"));

    public static final DefaultedRegistryReference<BlockType> ALLIUM = BlockTypes.key(ResourceKey.sponge("allium"));

    public static final DefaultedRegistryReference<BlockType> ANCIENT_DEBRIS = BlockTypes.key(ResourceKey.sponge("ancient_debris"));

    public static final DefaultedRegistryReference<BlockType> ANDESITE = BlockTypes.key(ResourceKey.sponge("andesite"));

    public static final DefaultedRegistryReference<BlockType> ANDESITE_SLAB = BlockTypes.key(ResourceKey.sponge("andesite_slab"));

    public static final DefaultedRegistryReference<BlockType> ANDESITE_STAIRS = BlockTypes.key(ResourceKey.sponge("andesite_stairs"));

    public static final DefaultedRegistryReference<BlockType> ANDESITE_WALL = BlockTypes.key(ResourceKey.sponge("andesite_wall"));

    public static final DefaultedRegistryReference<BlockType> ANVIL = BlockTypes.key(ResourceKey.sponge("anvil"));

    public static final DefaultedRegistryReference<BlockType> ATTACHED_MELON_STEM = BlockTypes.key(ResourceKey.sponge("attached_melon_stem"));

    public static final DefaultedRegistryReference<BlockType> ATTACHED_PUMPKIN_STEM = BlockTypes.key(ResourceKey.sponge("attached_pumpkin_stem"));

    public static final DefaultedRegistryReference<BlockType> AZURE_BLUET = BlockTypes.key(ResourceKey.sponge("azure_bluet"));

    public static final DefaultedRegistryReference<BlockType> BAMBOO = BlockTypes.key(ResourceKey.sponge("bamboo"));

    public static final DefaultedRegistryReference<BlockType> BAMBOO_SAPLING = BlockTypes.key(ResourceKey.sponge("bamboo_sapling"));

    public static final DefaultedRegistryReference<BlockType> BARREL = BlockTypes.key(ResourceKey.sponge("barrel"));

    public static final DefaultedRegistryReference<BlockType> BARRIER = BlockTypes.key(ResourceKey.sponge("barrier"));

    public static final DefaultedRegistryReference<BlockType> BASALT = BlockTypes.key(ResourceKey.sponge("basalt"));

    public static final DefaultedRegistryReference<BlockType> BEACON = BlockTypes.key(ResourceKey.sponge("beacon"));

    public static final DefaultedRegistryReference<BlockType> BEDROCK = BlockTypes.key(ResourceKey.sponge("bedrock"));

    public static final DefaultedRegistryReference<BlockType> BEE_NEST = BlockTypes.key(ResourceKey.sponge("bee_nest"));

    public static final DefaultedRegistryReference<BlockType> BEEHIVE = BlockTypes.key(ResourceKey.sponge("beehive"));

    public static final DefaultedRegistryReference<BlockType> BEETROOTS = BlockTypes.key(ResourceKey.sponge("beetroots"));

    public static final DefaultedRegistryReference<BlockType> BELL = BlockTypes.key(ResourceKey.sponge("bell"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_BUTTON = BlockTypes.key(ResourceKey.sponge("birch_button"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_DOOR = BlockTypes.key(ResourceKey.sponge("birch_door"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_FENCE = BlockTypes.key(ResourceKey.sponge("birch_fence"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_FENCE_GATE = BlockTypes.key(ResourceKey.sponge("birch_fence_gate"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_LEAVES = BlockTypes.key(ResourceKey.sponge("birch_leaves"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_LOG = BlockTypes.key(ResourceKey.sponge("birch_log"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_PLANKS = BlockTypes.key(ResourceKey.sponge("birch_planks"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_PRESSURE_PLATE = BlockTypes.key(ResourceKey.sponge("birch_pressure_plate"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_SAPLING = BlockTypes.key(ResourceKey.sponge("birch_sapling"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_SIGN = BlockTypes.key(ResourceKey.sponge("birch_sign"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_SLAB = BlockTypes.key(ResourceKey.sponge("birch_slab"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_STAIRS = BlockTypes.key(ResourceKey.sponge("birch_stairs"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_TRAPDOOR = BlockTypes.key(ResourceKey.sponge("birch_trapdoor"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_WALL_SIGN = BlockTypes.key(ResourceKey.sponge("birch_wall_sign"));

    public static final DefaultedRegistryReference<BlockType> BIRCH_WOOD = BlockTypes.key(ResourceKey.sponge("birch_wood"));

    public static final DefaultedRegistryReference<BlockType> BLACK_BANNER = BlockTypes.key(ResourceKey.sponge("black_banner"));

    public static final DefaultedRegistryReference<BlockType> BLACK_BED = BlockTypes.key(ResourceKey.sponge("black_bed"));

    public static final DefaultedRegistryReference<BlockType> BLACK_CARPET = BlockTypes.key(ResourceKey.sponge("black_carpet"));

    public static final DefaultedRegistryReference<BlockType> BLACK_CONCRETE = BlockTypes.key(ResourceKey.sponge("black_concrete"));

    public static final DefaultedRegistryReference<BlockType> BLACK_CONCRETE_POWDER = BlockTypes.key(ResourceKey.sponge("black_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> BLACK_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("black_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> BLACK_SHULKER_BOX = BlockTypes.key(ResourceKey.sponge("black_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> BLACK_STAINED_GLASS = BlockTypes.key(ResourceKey.sponge("black_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> BLACK_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.sponge("black_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> BLACK_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("black_terracotta"));

    public static final DefaultedRegistryReference<BlockType> BLACK_WALL_BANNER = BlockTypes.key(ResourceKey.sponge("black_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> BLACK_WOOL = BlockTypes.key(ResourceKey.sponge("black_wool"));

    public static final DefaultedRegistryReference<BlockType> BLACKSTONE = BlockTypes.key(ResourceKey.sponge("blackstone"));

    public static final DefaultedRegistryReference<BlockType> BLACKSTONE_SLAB = BlockTypes.key(ResourceKey.sponge("blackstone_slab"));

    public static final DefaultedRegistryReference<BlockType> BLACKSTONE_STAIRS = BlockTypes.key(ResourceKey.sponge("blackstone_stairs"));

    public static final DefaultedRegistryReference<BlockType> BLACKSTONE_WALL = BlockTypes.key(ResourceKey.sponge("blackstone_wall"));

    public static final DefaultedRegistryReference<BlockType> BLAST_FURNACE = BlockTypes.key(ResourceKey.sponge("blast_furnace"));

    public static final DefaultedRegistryReference<BlockType> BLUE_BANNER = BlockTypes.key(ResourceKey.sponge("blue_banner"));

    public static final DefaultedRegistryReference<BlockType> BLUE_BED = BlockTypes.key(ResourceKey.sponge("blue_bed"));

    public static final DefaultedRegistryReference<BlockType> BLUE_CARPET = BlockTypes.key(ResourceKey.sponge("blue_carpet"));

    public static final DefaultedRegistryReference<BlockType> BLUE_CONCRETE = BlockTypes.key(ResourceKey.sponge("blue_concrete"));

    public static final DefaultedRegistryReference<BlockType> BLUE_CONCRETE_POWDER = BlockTypes.key(ResourceKey.sponge("blue_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> BLUE_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("blue_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> BLUE_ICE = BlockTypes.key(ResourceKey.sponge("blue_ice"));

    public static final DefaultedRegistryReference<BlockType> BLUE_ORCHID = BlockTypes.key(ResourceKey.sponge("blue_orchid"));

    public static final DefaultedRegistryReference<BlockType> BLUE_SHULKER_BOX = BlockTypes.key(ResourceKey.sponge("blue_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> BLUE_STAINED_GLASS = BlockTypes.key(ResourceKey.sponge("blue_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> BLUE_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.sponge("blue_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> BLUE_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("blue_terracotta"));

    public static final DefaultedRegistryReference<BlockType> BLUE_WALL_BANNER = BlockTypes.key(ResourceKey.sponge("blue_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> BLUE_WOOL = BlockTypes.key(ResourceKey.sponge("blue_wool"));

    public static final DefaultedRegistryReference<BlockType> BONE_BLOCK = BlockTypes.key(ResourceKey.sponge("bone_block"));

    public static final DefaultedRegistryReference<BlockType> BOOKSHELF = BlockTypes.key(ResourceKey.sponge("bookshelf"));

    public static final DefaultedRegistryReference<BlockType> BRAIN_CORAL = BlockTypes.key(ResourceKey.sponge("brain_coral"));

    public static final DefaultedRegistryReference<BlockType> BRAIN_CORAL_BLOCK = BlockTypes.key(ResourceKey.sponge("brain_coral_block"));

    public static final DefaultedRegistryReference<BlockType> BRAIN_CORAL_FAN = BlockTypes.key(ResourceKey.sponge("brain_coral_fan"));

    public static final DefaultedRegistryReference<BlockType> BRAIN_CORAL_WALL_FAN = BlockTypes.key(ResourceKey.sponge("brain_coral_wall_fan"));

    public static final DefaultedRegistryReference<BlockType> BREWING_STAND = BlockTypes.key(ResourceKey.sponge("brewing_stand"));

    public static final DefaultedRegistryReference<BlockType> BRICK_SLAB = BlockTypes.key(ResourceKey.sponge("brick_slab"));

    public static final DefaultedRegistryReference<BlockType> BRICK_STAIRS = BlockTypes.key(ResourceKey.sponge("brick_stairs"));

    public static final DefaultedRegistryReference<BlockType> BRICK_WALL = BlockTypes.key(ResourceKey.sponge("brick_wall"));

    public static final DefaultedRegistryReference<BlockType> BRICKS = BlockTypes.key(ResourceKey.sponge("bricks"));

    public static final DefaultedRegistryReference<BlockType> BROWN_BANNER = BlockTypes.key(ResourceKey.sponge("brown_banner"));

    public static final DefaultedRegistryReference<BlockType> BROWN_BED = BlockTypes.key(ResourceKey.sponge("brown_bed"));

    public static final DefaultedRegistryReference<BlockType> BROWN_CARPET = BlockTypes.key(ResourceKey.sponge("brown_carpet"));

    public static final DefaultedRegistryReference<BlockType> BROWN_CONCRETE = BlockTypes.key(ResourceKey.sponge("brown_concrete"));

    public static final DefaultedRegistryReference<BlockType> BROWN_CONCRETE_POWDER = BlockTypes.key(ResourceKey.sponge("brown_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> BROWN_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("brown_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> BROWN_MUSHROOM = BlockTypes.key(ResourceKey.sponge("brown_mushroom"));

    public static final DefaultedRegistryReference<BlockType> BROWN_MUSHROOM_BLOCK = BlockTypes.key(ResourceKey.sponge("brown_mushroom_block"));

    public static final DefaultedRegistryReference<BlockType> BROWN_SHULKER_BOX = BlockTypes.key(ResourceKey.sponge("brown_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> BROWN_STAINED_GLASS = BlockTypes.key(ResourceKey.sponge("brown_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> BROWN_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.sponge("brown_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> BROWN_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("brown_terracotta"));

    public static final DefaultedRegistryReference<BlockType> BROWN_WALL_BANNER = BlockTypes.key(ResourceKey.sponge("brown_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> BROWN_WOOL = BlockTypes.key(ResourceKey.sponge("brown_wool"));

    public static final DefaultedRegistryReference<BlockType> BUBBLE_COLUMN = BlockTypes.key(ResourceKey.sponge("bubble_column"));

    public static final DefaultedRegistryReference<BlockType> BUBBLE_CORAL = BlockTypes.key(ResourceKey.sponge("bubble_coral"));

    public static final DefaultedRegistryReference<BlockType> BUBBLE_CORAL_BLOCK = BlockTypes.key(ResourceKey.sponge("bubble_coral_block"));

    public static final DefaultedRegistryReference<BlockType> BUBBLE_CORAL_FAN = BlockTypes.key(ResourceKey.sponge("bubble_coral_fan"));

    public static final DefaultedRegistryReference<BlockType> BUBBLE_CORAL_WALL_FAN = BlockTypes.key(ResourceKey.sponge("bubble_coral_wall_fan"));

    public static final DefaultedRegistryReference<BlockType> CACTUS = BlockTypes.key(ResourceKey.sponge("cactus"));

    public static final DefaultedRegistryReference<BlockType> CAKE = BlockTypes.key(ResourceKey.sponge("cake"));

    public static final DefaultedRegistryReference<BlockType> CAMPFIRE = BlockTypes.key(ResourceKey.sponge("campfire"));

    public static final DefaultedRegistryReference<BlockType> CARROTS = BlockTypes.key(ResourceKey.sponge("carrots"));

    public static final DefaultedRegistryReference<BlockType> CARTOGRAPHY_TABLE = BlockTypes.key(ResourceKey.sponge("cartography_table"));

    public static final DefaultedRegistryReference<BlockType> CARVED_PUMPKIN = BlockTypes.key(ResourceKey.sponge("carved_pumpkin"));

    public static final DefaultedRegistryReference<BlockType> CAULDRON = BlockTypes.key(ResourceKey.sponge("cauldron"));

    public static final DefaultedRegistryReference<BlockType> CAVE_AIR = BlockTypes.key(ResourceKey.sponge("cave_air"));

    public static final DefaultedRegistryReference<BlockType> CHAIN = BlockTypes.key(ResourceKey.sponge("chain"));

    public static final DefaultedRegistryReference<BlockType> CHAIN_COMMAND_BLOCK = BlockTypes.key(ResourceKey.sponge("chain_command_block"));

    public static final DefaultedRegistryReference<BlockType> CHEST = BlockTypes.key(ResourceKey.sponge("chest"));

    public static final DefaultedRegistryReference<BlockType> CHIPPED_ANVIL = BlockTypes.key(ResourceKey.sponge("chipped_anvil"));

    public static final DefaultedRegistryReference<BlockType> CHISELED_NETHER_BRICKS = BlockTypes.key(ResourceKey.sponge("chiseled_nether_bricks"));

    public static final DefaultedRegistryReference<BlockType> CHISELED_POLISHED_BLACKSTONE = BlockTypes.key(ResourceKey.sponge("chiseled_polished_blackstone"));

    public static final DefaultedRegistryReference<BlockType> CHISELED_QUARTZ_BLOCK = BlockTypes.key(ResourceKey.sponge("chiseled_quartz_block"));

    public static final DefaultedRegistryReference<BlockType> CHISELED_RED_SANDSTONE = BlockTypes.key(ResourceKey.sponge("chiseled_red_sandstone"));

    public static final DefaultedRegistryReference<BlockType> CHISELED_SANDSTONE = BlockTypes.key(ResourceKey.sponge("chiseled_sandstone"));

    public static final DefaultedRegistryReference<BlockType> CHISELED_STONE_BRICKS = BlockTypes.key(ResourceKey.sponge("chiseled_stone_bricks"));

    public static final DefaultedRegistryReference<BlockType> CHORUS_FLOWER = BlockTypes.key(ResourceKey.sponge("chorus_flower"));

    public static final DefaultedRegistryReference<BlockType> CHORUS_PLANT = BlockTypes.key(ResourceKey.sponge("chorus_plant"));

    public static final DefaultedRegistryReference<BlockType> CLAY = BlockTypes.key(ResourceKey.sponge("clay"));

    public static final DefaultedRegistryReference<BlockType> COAL_BLOCK = BlockTypes.key(ResourceKey.sponge("coal_block"));

    public static final DefaultedRegistryReference<BlockType> COAL_ORE = BlockTypes.key(ResourceKey.sponge("coal_ore"));

    public static final DefaultedRegistryReference<BlockType> COARSE_DIRT = BlockTypes.key(ResourceKey.sponge("coarse_dirt"));

    public static final DefaultedRegistryReference<BlockType> COBBLESTONE = BlockTypes.key(ResourceKey.sponge("cobblestone"));

    public static final DefaultedRegistryReference<BlockType> COBBLESTONE_SLAB = BlockTypes.key(ResourceKey.sponge("cobblestone_slab"));

    public static final DefaultedRegistryReference<BlockType> COBBLESTONE_STAIRS = BlockTypes.key(ResourceKey.sponge("cobblestone_stairs"));

    public static final DefaultedRegistryReference<BlockType> COBBLESTONE_WALL = BlockTypes.key(ResourceKey.sponge("cobblestone_wall"));

    public static final DefaultedRegistryReference<BlockType> COBWEB = BlockTypes.key(ResourceKey.sponge("cobweb"));

    public static final DefaultedRegistryReference<BlockType> COCOA = BlockTypes.key(ResourceKey.sponge("cocoa"));

    public static final DefaultedRegistryReference<BlockType> COMMAND_BLOCK = BlockTypes.key(ResourceKey.sponge("command_block"));

    public static final DefaultedRegistryReference<BlockType> COMPARATOR = BlockTypes.key(ResourceKey.sponge("comparator"));

    public static final DefaultedRegistryReference<BlockType> COMPOSTER = BlockTypes.key(ResourceKey.sponge("composter"));

    public static final DefaultedRegistryReference<BlockType> CONDUIT = BlockTypes.key(ResourceKey.sponge("conduit"));

    public static final DefaultedRegistryReference<BlockType> CORNFLOWER = BlockTypes.key(ResourceKey.sponge("cornflower"));

    public static final DefaultedRegistryReference<BlockType> CRACKED_NETHER_BRICKS = BlockTypes.key(ResourceKey.sponge("cracked_nether_bricks"));

    public static final DefaultedRegistryReference<BlockType> CRACKED_POLISHED_BLACKSTONE_BRICKS = BlockTypes.key(ResourceKey.sponge("cracked_polished_blackstone_bricks"));

    public static final DefaultedRegistryReference<BlockType> CRACKED_STONE_BRICKS = BlockTypes.key(ResourceKey.sponge("cracked_stone_bricks"));

    public static final DefaultedRegistryReference<BlockType> CRAFTING_TABLE = BlockTypes.key(ResourceKey.sponge("crafting_table"));

    public static final DefaultedRegistryReference<BlockType> CREEPER_HEAD = BlockTypes.key(ResourceKey.sponge("creeper_head"));

    public static final DefaultedRegistryReference<BlockType> CREEPER_WALL_HEAD = BlockTypes.key(ResourceKey.sponge("creeper_wall_head"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_BUTTON = BlockTypes.key(ResourceKey.sponge("crimson_button"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_DOOR = BlockTypes.key(ResourceKey.sponge("crimson_door"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_FENCE = BlockTypes.key(ResourceKey.sponge("crimson_fence"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_FENCE_GATE = BlockTypes.key(ResourceKey.sponge("crimson_fence_gate"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_FUNGUS = BlockTypes.key(ResourceKey.sponge("crimson_fungus"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_HYPHAE = BlockTypes.key(ResourceKey.sponge("crimson_hyphae"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_NYLIUM = BlockTypes.key(ResourceKey.sponge("crimson_nylium"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_PLANKS = BlockTypes.key(ResourceKey.sponge("crimson_planks"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_PRESSURE_PLATE = BlockTypes.key(ResourceKey.sponge("crimson_pressure_plate"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_ROOTS = BlockTypes.key(ResourceKey.sponge("crimson_roots"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_SIGN = BlockTypes.key(ResourceKey.sponge("crimson_sign"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_SLAB = BlockTypes.key(ResourceKey.sponge("crimson_slab"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_STAIRS = BlockTypes.key(ResourceKey.sponge("crimson_stairs"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_STEM = BlockTypes.key(ResourceKey.sponge("crimson_stem"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_TRAPDOOR = BlockTypes.key(ResourceKey.sponge("crimson_trapdoor"));

    public static final DefaultedRegistryReference<BlockType> CRIMSON_WALL_SIGN = BlockTypes.key(ResourceKey.sponge("crimson_wall_sign"));

    public static final DefaultedRegistryReference<BlockType> CRYING_OBSIDIAN = BlockTypes.key(ResourceKey.sponge("crying_obsidian"));

    public static final DefaultedRegistryReference<BlockType> CUT_RED_SANDSTONE = BlockTypes.key(ResourceKey.sponge("cut_red_sandstone"));

    public static final DefaultedRegistryReference<BlockType> CUT_RED_SANDSTONE_SLAB = BlockTypes.key(ResourceKey.sponge("cut_red_sandstone_slab"));

    public static final DefaultedRegistryReference<BlockType> CUT_SANDSTONE = BlockTypes.key(ResourceKey.sponge("cut_sandstone"));

    public static final DefaultedRegistryReference<BlockType> CUT_SANDSTONE_SLAB = BlockTypes.key(ResourceKey.sponge("cut_sandstone_slab"));

    public static final DefaultedRegistryReference<BlockType> CYAN_BANNER = BlockTypes.key(ResourceKey.sponge("cyan_banner"));

    public static final DefaultedRegistryReference<BlockType> CYAN_BED = BlockTypes.key(ResourceKey.sponge("cyan_bed"));

    public static final DefaultedRegistryReference<BlockType> CYAN_CARPET = BlockTypes.key(ResourceKey.sponge("cyan_carpet"));

    public static final DefaultedRegistryReference<BlockType> CYAN_CONCRETE = BlockTypes.key(ResourceKey.sponge("cyan_concrete"));

    public static final DefaultedRegistryReference<BlockType> CYAN_CONCRETE_POWDER = BlockTypes.key(ResourceKey.sponge("cyan_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> CYAN_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("cyan_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> CYAN_SHULKER_BOX = BlockTypes.key(ResourceKey.sponge("cyan_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> CYAN_STAINED_GLASS = BlockTypes.key(ResourceKey.sponge("cyan_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> CYAN_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.sponge("cyan_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> CYAN_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("cyan_terracotta"));

    public static final DefaultedRegistryReference<BlockType> CYAN_WALL_BANNER = BlockTypes.key(ResourceKey.sponge("cyan_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> CYAN_WOOL = BlockTypes.key(ResourceKey.sponge("cyan_wool"));

    public static final DefaultedRegistryReference<BlockType> DAMAGED_ANVIL = BlockTypes.key(ResourceKey.sponge("damaged_anvil"));

    public static final DefaultedRegistryReference<BlockType> DANDELION = BlockTypes.key(ResourceKey.sponge("dandelion"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_BUTTON = BlockTypes.key(ResourceKey.sponge("dark_oak_button"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_DOOR = BlockTypes.key(ResourceKey.sponge("dark_oak_door"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_FENCE = BlockTypes.key(ResourceKey.sponge("dark_oak_fence"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_FENCE_GATE = BlockTypes.key(ResourceKey.sponge("dark_oak_fence_gate"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_LEAVES = BlockTypes.key(ResourceKey.sponge("dark_oak_leaves"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_LOG = BlockTypes.key(ResourceKey.sponge("dark_oak_log"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_PLANKS = BlockTypes.key(ResourceKey.sponge("dark_oak_planks"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_PRESSURE_PLATE = BlockTypes.key(ResourceKey.sponge("dark_oak_pressure_plate"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_SAPLING = BlockTypes.key(ResourceKey.sponge("dark_oak_sapling"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_SIGN = BlockTypes.key(ResourceKey.sponge("dark_oak_sign"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_SLAB = BlockTypes.key(ResourceKey.sponge("dark_oak_slab"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_STAIRS = BlockTypes.key(ResourceKey.sponge("dark_oak_stairs"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_TRAPDOOR = BlockTypes.key(ResourceKey.sponge("dark_oak_trapdoor"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_WALL_SIGN = BlockTypes.key(ResourceKey.sponge("dark_oak_wall_sign"));

    public static final DefaultedRegistryReference<BlockType> DARK_OAK_WOOD = BlockTypes.key(ResourceKey.sponge("dark_oak_wood"));

    public static final DefaultedRegistryReference<BlockType> DARK_PRISMARINE = BlockTypes.key(ResourceKey.sponge("dark_prismarine"));

    public static final DefaultedRegistryReference<BlockType> DARK_PRISMARINE_SLAB = BlockTypes.key(ResourceKey.sponge("dark_prismarine_slab"));

    public static final DefaultedRegistryReference<BlockType> DARK_PRISMARINE_STAIRS = BlockTypes.key(ResourceKey.sponge("dark_prismarine_stairs"));

    public static final DefaultedRegistryReference<BlockType> DAYLIGHT_DETECTOR = BlockTypes.key(ResourceKey.sponge("daylight_detector"));

    public static final DefaultedRegistryReference<BlockType> DEAD_BRAIN_CORAL = BlockTypes.key(ResourceKey.sponge("dead_brain_coral"));

    public static final DefaultedRegistryReference<BlockType> DEAD_BRAIN_CORAL_BLOCK = BlockTypes.key(ResourceKey.sponge("dead_brain_coral_block"));

    public static final DefaultedRegistryReference<BlockType> DEAD_BRAIN_CORAL_FAN = BlockTypes.key(ResourceKey.sponge("dead_brain_coral_fan"));

    public static final DefaultedRegistryReference<BlockType> DEAD_BRAIN_CORAL_WALL_FAN = BlockTypes.key(ResourceKey.sponge("dead_brain_coral_wall_fan"));

    public static final DefaultedRegistryReference<BlockType> DEAD_BUBBLE_CORAL = BlockTypes.key(ResourceKey.sponge("dead_bubble_coral"));

    public static final DefaultedRegistryReference<BlockType> DEAD_BUBBLE_CORAL_BLOCK = BlockTypes.key(ResourceKey.sponge("dead_bubble_coral_block"));

    public static final DefaultedRegistryReference<BlockType> DEAD_BUBBLE_CORAL_FAN = BlockTypes.key(ResourceKey.sponge("dead_bubble_coral_fan"));

    public static final DefaultedRegistryReference<BlockType> DEAD_BUBBLE_CORAL_WALL_FAN = BlockTypes.key(ResourceKey.sponge("dead_bubble_coral_wall_fan"));

    public static final DefaultedRegistryReference<BlockType> DEAD_BUSH = BlockTypes.key(ResourceKey.sponge("dead_bush"));

    public static final DefaultedRegistryReference<BlockType> DEAD_FIRE_CORAL = BlockTypes.key(ResourceKey.sponge("dead_fire_coral"));

    public static final DefaultedRegistryReference<BlockType> DEAD_FIRE_CORAL_BLOCK = BlockTypes.key(ResourceKey.sponge("dead_fire_coral_block"));

    public static final DefaultedRegistryReference<BlockType> DEAD_FIRE_CORAL_FAN = BlockTypes.key(ResourceKey.sponge("dead_fire_coral_fan"));

    public static final DefaultedRegistryReference<BlockType> DEAD_FIRE_CORAL_WALL_FAN = BlockTypes.key(ResourceKey.sponge("dead_fire_coral_wall_fan"));

    public static final DefaultedRegistryReference<BlockType> DEAD_HORN_CORAL = BlockTypes.key(ResourceKey.sponge("dead_horn_coral"));

    public static final DefaultedRegistryReference<BlockType> DEAD_HORN_CORAL_BLOCK = BlockTypes.key(ResourceKey.sponge("dead_horn_coral_block"));

    public static final DefaultedRegistryReference<BlockType> DEAD_HORN_CORAL_FAN = BlockTypes.key(ResourceKey.sponge("dead_horn_coral_fan"));

    public static final DefaultedRegistryReference<BlockType> DEAD_HORN_CORAL_WALL_FAN = BlockTypes.key(ResourceKey.sponge("dead_horn_coral_wall_fan"));

    public static final DefaultedRegistryReference<BlockType> DEAD_TUBE_CORAL = BlockTypes.key(ResourceKey.sponge("dead_tube_coral"));

    public static final DefaultedRegistryReference<BlockType> DEAD_TUBE_CORAL_BLOCK = BlockTypes.key(ResourceKey.sponge("dead_tube_coral_block"));

    public static final DefaultedRegistryReference<BlockType> DEAD_TUBE_CORAL_FAN = BlockTypes.key(ResourceKey.sponge("dead_tube_coral_fan"));

    public static final DefaultedRegistryReference<BlockType> DEAD_TUBE_CORAL_WALL_FAN = BlockTypes.key(ResourceKey.sponge("dead_tube_coral_wall_fan"));

    public static final DefaultedRegistryReference<BlockType> DETECTOR_RAIL = BlockTypes.key(ResourceKey.sponge("detector_rail"));

    public static final DefaultedRegistryReference<BlockType> DIAMOND_BLOCK = BlockTypes.key(ResourceKey.sponge("diamond_block"));

    public static final DefaultedRegistryReference<BlockType> DIAMOND_ORE = BlockTypes.key(ResourceKey.sponge("diamond_ore"));

    public static final DefaultedRegistryReference<BlockType> DIORITE = BlockTypes.key(ResourceKey.sponge("diorite"));

    public static final DefaultedRegistryReference<BlockType> DIORITE_SLAB = BlockTypes.key(ResourceKey.sponge("diorite_slab"));

    public static final DefaultedRegistryReference<BlockType> DIORITE_STAIRS = BlockTypes.key(ResourceKey.sponge("diorite_stairs"));

    public static final DefaultedRegistryReference<BlockType> DIORITE_WALL = BlockTypes.key(ResourceKey.sponge("diorite_wall"));

    public static final DefaultedRegistryReference<BlockType> DIRT = BlockTypes.key(ResourceKey.sponge("dirt"));

    public static final DefaultedRegistryReference<BlockType> DISPENSER = BlockTypes.key(ResourceKey.sponge("dispenser"));

    public static final DefaultedRegistryReference<BlockType> DRAGON_EGG = BlockTypes.key(ResourceKey.sponge("dragon_egg"));

    public static final DefaultedRegistryReference<BlockType> DRAGON_HEAD = BlockTypes.key(ResourceKey.sponge("dragon_head"));

    public static final DefaultedRegistryReference<BlockType> DRAGON_WALL_HEAD = BlockTypes.key(ResourceKey.sponge("dragon_wall_head"));

    public static final DefaultedRegistryReference<BlockType> DRIED_KELP_BLOCK = BlockTypes.key(ResourceKey.sponge("dried_kelp_block"));

    public static final DefaultedRegistryReference<BlockType> DROPPER = BlockTypes.key(ResourceKey.sponge("dropper"));

    public static final DefaultedRegistryReference<BlockType> EMERALD_BLOCK = BlockTypes.key(ResourceKey.sponge("emerald_block"));

    public static final DefaultedRegistryReference<BlockType> EMERALD_ORE = BlockTypes.key(ResourceKey.sponge("emerald_ore"));

    public static final DefaultedRegistryReference<BlockType> ENCHANTING_TABLE = BlockTypes.key(ResourceKey.sponge("enchanting_table"));

    public static final DefaultedRegistryReference<BlockType> END_GATEWAY = BlockTypes.key(ResourceKey.sponge("end_gateway"));

    public static final DefaultedRegistryReference<BlockType> END_PORTAL = BlockTypes.key(ResourceKey.sponge("end_portal"));

    public static final DefaultedRegistryReference<BlockType> END_PORTAL_FRAME = BlockTypes.key(ResourceKey.sponge("end_portal_frame"));

    public static final DefaultedRegistryReference<BlockType> END_ROD = BlockTypes.key(ResourceKey.sponge("end_rod"));

    public static final DefaultedRegistryReference<BlockType> END_STONE = BlockTypes.key(ResourceKey.sponge("end_stone"));

    public static final DefaultedRegistryReference<BlockType> END_STONE_BRICK_SLAB = BlockTypes.key(ResourceKey.sponge("end_stone_brick_slab"));

    public static final DefaultedRegistryReference<BlockType> END_STONE_BRICK_STAIRS = BlockTypes.key(ResourceKey.sponge("end_stone_brick_stairs"));

    public static final DefaultedRegistryReference<BlockType> END_STONE_BRICK_WALL = BlockTypes.key(ResourceKey.sponge("end_stone_brick_wall"));

    public static final DefaultedRegistryReference<BlockType> END_STONE_BRICKS = BlockTypes.key(ResourceKey.sponge("end_stone_bricks"));

    public static final DefaultedRegistryReference<BlockType> ENDER_CHEST = BlockTypes.key(ResourceKey.sponge("ender_chest"));

    public static final DefaultedRegistryReference<BlockType> FARMLAND = BlockTypes.key(ResourceKey.sponge("farmland"));

    public static final DefaultedRegistryReference<BlockType> FERN = BlockTypes.key(ResourceKey.sponge("fern"));

    public static final DefaultedRegistryReference<BlockType> FIRE = BlockTypes.key(ResourceKey.sponge("fire"));

    public static final DefaultedRegistryReference<BlockType> FIRE_CORAL = BlockTypes.key(ResourceKey.sponge("fire_coral"));

    public static final DefaultedRegistryReference<BlockType> FIRE_CORAL_BLOCK = BlockTypes.key(ResourceKey.sponge("fire_coral_block"));

    public static final DefaultedRegistryReference<BlockType> FIRE_CORAL_FAN = BlockTypes.key(ResourceKey.sponge("fire_coral_fan"));

    public static final DefaultedRegistryReference<BlockType> FIRE_CORAL_WALL_FAN = BlockTypes.key(ResourceKey.sponge("fire_coral_wall_fan"));

    public static final DefaultedRegistryReference<BlockType> FLETCHING_TABLE = BlockTypes.key(ResourceKey.sponge("fletching_table"));

    public static final DefaultedRegistryReference<BlockType> FLOWER_POT = BlockTypes.key(ResourceKey.sponge("flower_pot"));

    public static final DefaultedRegistryReference<BlockType> FROSTED_ICE = BlockTypes.key(ResourceKey.sponge("frosted_ice"));

    public static final DefaultedRegistryReference<BlockType> FURNACE = BlockTypes.key(ResourceKey.sponge("furnace"));

    public static final DefaultedRegistryReference<BlockType> GILDED_BLACKSTONE = BlockTypes.key(ResourceKey.sponge("gilded_blackstone"));

    public static final DefaultedRegistryReference<BlockType> GLASS = BlockTypes.key(ResourceKey.sponge("glass"));

    public static final DefaultedRegistryReference<BlockType> GLASS_PANE = BlockTypes.key(ResourceKey.sponge("glass_pane"));

    public static final DefaultedRegistryReference<BlockType> GLOWSTONE = BlockTypes.key(ResourceKey.sponge("glowstone"));

    public static final DefaultedRegistryReference<BlockType> GOLD_BLOCK = BlockTypes.key(ResourceKey.sponge("gold_block"));

    public static final DefaultedRegistryReference<BlockType> GOLD_ORE = BlockTypes.key(ResourceKey.sponge("gold_ore"));

    public static final DefaultedRegistryReference<BlockType> GRANITE = BlockTypes.key(ResourceKey.sponge("granite"));

    public static final DefaultedRegistryReference<BlockType> GRANITE_SLAB = BlockTypes.key(ResourceKey.sponge("granite_slab"));

    public static final DefaultedRegistryReference<BlockType> GRANITE_STAIRS = BlockTypes.key(ResourceKey.sponge("granite_stairs"));

    public static final DefaultedRegistryReference<BlockType> GRANITE_WALL = BlockTypes.key(ResourceKey.sponge("granite_wall"));

    public static final DefaultedRegistryReference<BlockType> GRASS = BlockTypes.key(ResourceKey.sponge("grass"));

    public static final DefaultedRegistryReference<BlockType> GRASS_BLOCK = BlockTypes.key(ResourceKey.sponge("grass_block"));

    public static final DefaultedRegistryReference<BlockType> GRASS_PATH = BlockTypes.key(ResourceKey.sponge("grass_path"));

    public static final DefaultedRegistryReference<BlockType> GRAVEL = BlockTypes.key(ResourceKey.sponge("gravel"));

    public static final DefaultedRegistryReference<BlockType> GRAY_BANNER = BlockTypes.key(ResourceKey.sponge("gray_banner"));

    public static final DefaultedRegistryReference<BlockType> GRAY_BED = BlockTypes.key(ResourceKey.sponge("gray_bed"));

    public static final DefaultedRegistryReference<BlockType> GRAY_CARPET = BlockTypes.key(ResourceKey.sponge("gray_carpet"));

    public static final DefaultedRegistryReference<BlockType> GRAY_CONCRETE = BlockTypes.key(ResourceKey.sponge("gray_concrete"));

    public static final DefaultedRegistryReference<BlockType> GRAY_CONCRETE_POWDER = BlockTypes.key(ResourceKey.sponge("gray_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> GRAY_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("gray_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> GRAY_SHULKER_BOX = BlockTypes.key(ResourceKey.sponge("gray_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> GRAY_STAINED_GLASS = BlockTypes.key(ResourceKey.sponge("gray_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> GRAY_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.sponge("gray_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> GRAY_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("gray_terracotta"));

    public static final DefaultedRegistryReference<BlockType> GRAY_WALL_BANNER = BlockTypes.key(ResourceKey.sponge("gray_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> GRAY_WOOL = BlockTypes.key(ResourceKey.sponge("gray_wool"));

    public static final DefaultedRegistryReference<BlockType> GREEN_BANNER = BlockTypes.key(ResourceKey.sponge("green_banner"));

    public static final DefaultedRegistryReference<BlockType> GREEN_BED = BlockTypes.key(ResourceKey.sponge("green_bed"));

    public static final DefaultedRegistryReference<BlockType> GREEN_CARPET = BlockTypes.key(ResourceKey.sponge("green_carpet"));

    public static final DefaultedRegistryReference<BlockType> GREEN_CONCRETE = BlockTypes.key(ResourceKey.sponge("green_concrete"));

    public static final DefaultedRegistryReference<BlockType> GREEN_CONCRETE_POWDER = BlockTypes.key(ResourceKey.sponge("green_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> GREEN_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("green_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> GREEN_SHULKER_BOX = BlockTypes.key(ResourceKey.sponge("green_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> GREEN_STAINED_GLASS = BlockTypes.key(ResourceKey.sponge("green_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> GREEN_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.sponge("green_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> GREEN_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("green_terracotta"));

    public static final DefaultedRegistryReference<BlockType> GREEN_WALL_BANNER = BlockTypes.key(ResourceKey.sponge("green_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> GREEN_WOOL = BlockTypes.key(ResourceKey.sponge("green_wool"));

    public static final DefaultedRegistryReference<BlockType> GRINDSTONE = BlockTypes.key(ResourceKey.sponge("grindstone"));

    public static final DefaultedRegistryReference<BlockType> HAY_BLOCK = BlockTypes.key(ResourceKey.sponge("hay_block"));

    public static final DefaultedRegistryReference<BlockType> HEAVY_WEIGHTED_PRESSURE_PLATE = BlockTypes.key(ResourceKey.sponge("heavy_weighted_pressure_plate"));

    public static final DefaultedRegistryReference<BlockType> HONEY_BLOCK = BlockTypes.key(ResourceKey.sponge("honey_block"));

    public static final DefaultedRegistryReference<BlockType> HONEYCOMB_BLOCK = BlockTypes.key(ResourceKey.sponge("honeycomb_block"));

    public static final DefaultedRegistryReference<BlockType> HOPPER = BlockTypes.key(ResourceKey.sponge("hopper"));

    public static final DefaultedRegistryReference<BlockType> HORN_CORAL = BlockTypes.key(ResourceKey.sponge("horn_coral"));

    public static final DefaultedRegistryReference<BlockType> HORN_CORAL_BLOCK = BlockTypes.key(ResourceKey.sponge("horn_coral_block"));

    public static final DefaultedRegistryReference<BlockType> HORN_CORAL_FAN = BlockTypes.key(ResourceKey.sponge("horn_coral_fan"));

    public static final DefaultedRegistryReference<BlockType> HORN_CORAL_WALL_FAN = BlockTypes.key(ResourceKey.sponge("horn_coral_wall_fan"));

    public static final DefaultedRegistryReference<BlockType> ICE = BlockTypes.key(ResourceKey.sponge("ice"));

    public static final DefaultedRegistryReference<BlockType> INFESTED_CHISELED_STONE_BRICKS = BlockTypes.key(ResourceKey.sponge("infested_chiseled_stone_bricks"));

    public static final DefaultedRegistryReference<BlockType> INFESTED_COBBLESTONE = BlockTypes.key(ResourceKey.sponge("infested_cobblestone"));

    public static final DefaultedRegistryReference<BlockType> INFESTED_CRACKED_STONE_BRICKS = BlockTypes.key(ResourceKey.sponge("infested_cracked_stone_bricks"));

    public static final DefaultedRegistryReference<BlockType> INFESTED_MOSSY_STONE_BRICKS = BlockTypes.key(ResourceKey.sponge("infested_mossy_stone_bricks"));

    public static final DefaultedRegistryReference<BlockType> INFESTED_STONE = BlockTypes.key(ResourceKey.sponge("infested_stone"));

    public static final DefaultedRegistryReference<BlockType> INFESTED_STONE_BRICKS = BlockTypes.key(ResourceKey.sponge("infested_stone_bricks"));

    public static final DefaultedRegistryReference<BlockType> IRON_BARS = BlockTypes.key(ResourceKey.sponge("iron_bars"));

    public static final DefaultedRegistryReference<BlockType> IRON_BLOCK = BlockTypes.key(ResourceKey.sponge("iron_block"));

    public static final DefaultedRegistryReference<BlockType> IRON_DOOR = BlockTypes.key(ResourceKey.sponge("iron_door"));

    public static final DefaultedRegistryReference<BlockType> IRON_ORE = BlockTypes.key(ResourceKey.sponge("iron_ore"));

    public static final DefaultedRegistryReference<BlockType> IRON_TRAPDOOR = BlockTypes.key(ResourceKey.sponge("iron_trapdoor"));

    public static final DefaultedRegistryReference<BlockType> JACK_O_LANTERN = BlockTypes.key(ResourceKey.sponge("jack_o_lantern"));

    public static final DefaultedRegistryReference<BlockType> JIGSAW = BlockTypes.key(ResourceKey.sponge("jigsaw"));

    public static final DefaultedRegistryReference<BlockType> JUKEBOX = BlockTypes.key(ResourceKey.sponge("jukebox"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_BUTTON = BlockTypes.key(ResourceKey.sponge("jungle_button"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_DOOR = BlockTypes.key(ResourceKey.sponge("jungle_door"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_FENCE = BlockTypes.key(ResourceKey.sponge("jungle_fence"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_FENCE_GATE = BlockTypes.key(ResourceKey.sponge("jungle_fence_gate"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_LEAVES = BlockTypes.key(ResourceKey.sponge("jungle_leaves"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_LOG = BlockTypes.key(ResourceKey.sponge("jungle_log"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_PLANKS = BlockTypes.key(ResourceKey.sponge("jungle_planks"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_PRESSURE_PLATE = BlockTypes.key(ResourceKey.sponge("jungle_pressure_plate"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_SAPLING = BlockTypes.key(ResourceKey.sponge("jungle_sapling"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_SIGN = BlockTypes.key(ResourceKey.sponge("jungle_sign"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_SLAB = BlockTypes.key(ResourceKey.sponge("jungle_slab"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_STAIRS = BlockTypes.key(ResourceKey.sponge("jungle_stairs"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_TRAPDOOR = BlockTypes.key(ResourceKey.sponge("jungle_trapdoor"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_WALL_SIGN = BlockTypes.key(ResourceKey.sponge("jungle_wall_sign"));

    public static final DefaultedRegistryReference<BlockType> JUNGLE_WOOD = BlockTypes.key(ResourceKey.sponge("jungle_wood"));

    public static final DefaultedRegistryReference<BlockType> KELP = BlockTypes.key(ResourceKey.sponge("kelp"));

    public static final DefaultedRegistryReference<BlockType> KELP_PLANT = BlockTypes.key(ResourceKey.sponge("kelp_plant"));

    public static final DefaultedRegistryReference<BlockType> LADDER = BlockTypes.key(ResourceKey.sponge("ladder"));

    public static final DefaultedRegistryReference<BlockType> LANTERN = BlockTypes.key(ResourceKey.sponge("lantern"));

    public static final DefaultedRegistryReference<BlockType> LAPIS_BLOCK = BlockTypes.key(ResourceKey.sponge("lapis_block"));

    public static final DefaultedRegistryReference<BlockType> LAPIS_ORE = BlockTypes.key(ResourceKey.sponge("lapis_ore"));

    public static final DefaultedRegistryReference<BlockType> LARGE_FERN = BlockTypes.key(ResourceKey.sponge("large_fern"));

    public static final DefaultedRegistryReference<BlockType> LAVA = BlockTypes.key(ResourceKey.sponge("lava"));

    public static final DefaultedRegistryReference<BlockType> LECTERN = BlockTypes.key(ResourceKey.sponge("lectern"));

    public static final DefaultedRegistryReference<BlockType> LEVER = BlockTypes.key(ResourceKey.sponge("lever"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_BLUE_BANNER = BlockTypes.key(ResourceKey.sponge("light_blue_banner"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_BLUE_BED = BlockTypes.key(ResourceKey.sponge("light_blue_bed"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_BLUE_CARPET = BlockTypes.key(ResourceKey.sponge("light_blue_carpet"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_BLUE_CONCRETE = BlockTypes.key(ResourceKey.sponge("light_blue_concrete"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_BLUE_CONCRETE_POWDER = BlockTypes.key(ResourceKey.sponge("light_blue_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_BLUE_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("light_blue_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_BLUE_SHULKER_BOX = BlockTypes.key(ResourceKey.sponge("light_blue_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_BLUE_STAINED_GLASS = BlockTypes.key(ResourceKey.sponge("light_blue_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_BLUE_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.sponge("light_blue_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_BLUE_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("light_blue_terracotta"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_BLUE_WALL_BANNER = BlockTypes.key(ResourceKey.sponge("light_blue_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_BLUE_WOOL = BlockTypes.key(ResourceKey.sponge("light_blue_wool"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_GRAY_BANNER = BlockTypes.key(ResourceKey.sponge("light_gray_banner"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_GRAY_BED = BlockTypes.key(ResourceKey.sponge("light_gray_bed"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_GRAY_CARPET = BlockTypes.key(ResourceKey.sponge("light_gray_carpet"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_GRAY_CONCRETE = BlockTypes.key(ResourceKey.sponge("light_gray_concrete"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_GRAY_CONCRETE_POWDER = BlockTypes.key(ResourceKey.sponge("light_gray_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_GRAY_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("light_gray_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_GRAY_SHULKER_BOX = BlockTypes.key(ResourceKey.sponge("light_gray_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_GRAY_STAINED_GLASS = BlockTypes.key(ResourceKey.sponge("light_gray_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_GRAY_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.sponge("light_gray_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_GRAY_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("light_gray_terracotta"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_GRAY_WALL_BANNER = BlockTypes.key(ResourceKey.sponge("light_gray_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_GRAY_WOOL = BlockTypes.key(ResourceKey.sponge("light_gray_wool"));

    public static final DefaultedRegistryReference<BlockType> LIGHT_WEIGHTED_PRESSURE_PLATE = BlockTypes.key(ResourceKey.sponge("light_weighted_pressure_plate"));

    public static final DefaultedRegistryReference<BlockType> LILAC = BlockTypes.key(ResourceKey.sponge("lilac"));

    public static final DefaultedRegistryReference<BlockType> LILY_OF_THE_VALLEY = BlockTypes.key(ResourceKey.sponge("lily_of_the_valley"));

    public static final DefaultedRegistryReference<BlockType> LILY_PAD = BlockTypes.key(ResourceKey.sponge("lily_pad"));

    public static final DefaultedRegistryReference<BlockType> LIME_BANNER = BlockTypes.key(ResourceKey.sponge("lime_banner"));

    public static final DefaultedRegistryReference<BlockType> LIME_BED = BlockTypes.key(ResourceKey.sponge("lime_bed"));

    public static final DefaultedRegistryReference<BlockType> LIME_CARPET = BlockTypes.key(ResourceKey.sponge("lime_carpet"));

    public static final DefaultedRegistryReference<BlockType> LIME_CONCRETE = BlockTypes.key(ResourceKey.sponge("lime_concrete"));

    public static final DefaultedRegistryReference<BlockType> LIME_CONCRETE_POWDER = BlockTypes.key(ResourceKey.sponge("lime_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> LIME_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("lime_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> LIME_SHULKER_BOX = BlockTypes.key(ResourceKey.sponge("lime_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> LIME_STAINED_GLASS = BlockTypes.key(ResourceKey.sponge("lime_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> LIME_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.sponge("lime_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> LIME_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("lime_terracotta"));

    public static final DefaultedRegistryReference<BlockType> LIME_WALL_BANNER = BlockTypes.key(ResourceKey.sponge("lime_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> LIME_WOOL = BlockTypes.key(ResourceKey.sponge("lime_wool"));

    public static final DefaultedRegistryReference<BlockType> LODESTONE = BlockTypes.key(ResourceKey.sponge("lodestone"));

    public static final DefaultedRegistryReference<BlockType> LOOM = BlockTypes.key(ResourceKey.sponge("loom"));

    public static final DefaultedRegistryReference<BlockType> MAGENTA_BANNER = BlockTypes.key(ResourceKey.sponge("magenta_banner"));

    public static final DefaultedRegistryReference<BlockType> MAGENTA_BED = BlockTypes.key(ResourceKey.sponge("magenta_bed"));

    public static final DefaultedRegistryReference<BlockType> MAGENTA_CARPET = BlockTypes.key(ResourceKey.sponge("magenta_carpet"));

    public static final DefaultedRegistryReference<BlockType> MAGENTA_CONCRETE = BlockTypes.key(ResourceKey.sponge("magenta_concrete"));

    public static final DefaultedRegistryReference<BlockType> MAGENTA_CONCRETE_POWDER = BlockTypes.key(ResourceKey.sponge("magenta_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> MAGENTA_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("magenta_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> MAGENTA_SHULKER_BOX = BlockTypes.key(ResourceKey.sponge("magenta_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> MAGENTA_STAINED_GLASS = BlockTypes.key(ResourceKey.sponge("magenta_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> MAGENTA_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.sponge("magenta_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> MAGENTA_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("magenta_terracotta"));

    public static final DefaultedRegistryReference<BlockType> MAGENTA_WALL_BANNER = BlockTypes.key(ResourceKey.sponge("magenta_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> MAGENTA_WOOL = BlockTypes.key(ResourceKey.sponge("magenta_wool"));

    public static final DefaultedRegistryReference<BlockType> MAGMA_BLOCK = BlockTypes.key(ResourceKey.sponge("magma_block"));

    public static final DefaultedRegistryReference<BlockType> MELON = BlockTypes.key(ResourceKey.sponge("melon"));

    public static final DefaultedRegistryReference<BlockType> MELON_STEM = BlockTypes.key(ResourceKey.sponge("melon_stem"));

    public static final DefaultedRegistryReference<BlockType> MOSSY_COBBLESTONE = BlockTypes.key(ResourceKey.sponge("mossy_cobblestone"));

    public static final DefaultedRegistryReference<BlockType> MOSSY_COBBLESTONE_SLAB = BlockTypes.key(ResourceKey.sponge("mossy_cobblestone_slab"));

    public static final DefaultedRegistryReference<BlockType> MOSSY_COBBLESTONE_STAIRS = BlockTypes.key(ResourceKey.sponge("mossy_cobblestone_stairs"));

    public static final DefaultedRegistryReference<BlockType> MOSSY_COBBLESTONE_WALL = BlockTypes.key(ResourceKey.sponge("mossy_cobblestone_wall"));

    public static final DefaultedRegistryReference<BlockType> MOSSY_STONE_BRICK_SLAB = BlockTypes.key(ResourceKey.sponge("mossy_stone_brick_slab"));

    public static final DefaultedRegistryReference<BlockType> MOSSY_STONE_BRICK_STAIRS = BlockTypes.key(ResourceKey.sponge("mossy_stone_brick_stairs"));

    public static final DefaultedRegistryReference<BlockType> MOSSY_STONE_BRICK_WALL = BlockTypes.key(ResourceKey.sponge("mossy_stone_brick_wall"));

    public static final DefaultedRegistryReference<BlockType> MOSSY_STONE_BRICKS = BlockTypes.key(ResourceKey.sponge("mossy_stone_bricks"));

    public static final DefaultedRegistryReference<BlockType> MOVING_PISTON = BlockTypes.key(ResourceKey.sponge("moving_piston"));

    public static final DefaultedRegistryReference<BlockType> MUSHROOM_STEM = BlockTypes.key(ResourceKey.sponge("mushroom_stem"));

    public static final DefaultedRegistryReference<BlockType> MYCELIUM = BlockTypes.key(ResourceKey.sponge("mycelium"));

    public static final DefaultedRegistryReference<BlockType> NETHER_BRICK_FENCE = BlockTypes.key(ResourceKey.sponge("nether_brick_fence"));

    public static final DefaultedRegistryReference<BlockType> NETHER_BRICK_SLAB = BlockTypes.key(ResourceKey.sponge("nether_brick_slab"));

    public static final DefaultedRegistryReference<BlockType> NETHER_BRICK_STAIRS = BlockTypes.key(ResourceKey.sponge("nether_brick_stairs"));

    public static final DefaultedRegistryReference<BlockType> NETHER_BRICK_WALL = BlockTypes.key(ResourceKey.sponge("nether_brick_wall"));

    public static final DefaultedRegistryReference<BlockType> NETHER_BRICKS = BlockTypes.key(ResourceKey.sponge("nether_bricks"));

    public static final DefaultedRegistryReference<BlockType> NETHER_GOLD_ORE = BlockTypes.key(ResourceKey.sponge("nether_gold_ore"));

    public static final DefaultedRegistryReference<BlockType> NETHER_PORTAL = BlockTypes.key(ResourceKey.sponge("nether_portal"));

    public static final DefaultedRegistryReference<BlockType> NETHER_QUARTZ_ORE = BlockTypes.key(ResourceKey.sponge("nether_quartz_ore"));

    public static final DefaultedRegistryReference<BlockType> NETHER_SPROUTS = BlockTypes.key(ResourceKey.sponge("nether_sprouts"));

    public static final DefaultedRegistryReference<BlockType> NETHER_WART = BlockTypes.key(ResourceKey.sponge("nether_wart"));

    public static final DefaultedRegistryReference<BlockType> NETHER_WART_BLOCK = BlockTypes.key(ResourceKey.sponge("nether_wart_block"));

    public static final DefaultedRegistryReference<BlockType> NETHERITE_BLOCK = BlockTypes.key(ResourceKey.sponge("netherite_block"));

    public static final DefaultedRegistryReference<BlockType> NETHERRACK = BlockTypes.key(ResourceKey.sponge("netherrack"));

    public static final DefaultedRegistryReference<BlockType> NOTE_BLOCK = BlockTypes.key(ResourceKey.sponge("note_block"));

    public static final DefaultedRegistryReference<BlockType> OAK_BUTTON = BlockTypes.key(ResourceKey.sponge("oak_button"));

    public static final DefaultedRegistryReference<BlockType> OAK_DOOR = BlockTypes.key(ResourceKey.sponge("oak_door"));

    public static final DefaultedRegistryReference<BlockType> OAK_FENCE = BlockTypes.key(ResourceKey.sponge("oak_fence"));

    public static final DefaultedRegistryReference<BlockType> OAK_FENCE_GATE = BlockTypes.key(ResourceKey.sponge("oak_fence_gate"));

    public static final DefaultedRegistryReference<BlockType> OAK_LEAVES = BlockTypes.key(ResourceKey.sponge("oak_leaves"));

    public static final DefaultedRegistryReference<BlockType> OAK_LOG = BlockTypes.key(ResourceKey.sponge("oak_log"));

    public static final DefaultedRegistryReference<BlockType> OAK_PLANKS = BlockTypes.key(ResourceKey.sponge("oak_planks"));

    public static final DefaultedRegistryReference<BlockType> OAK_PRESSURE_PLATE = BlockTypes.key(ResourceKey.sponge("oak_pressure_plate"));

    public static final DefaultedRegistryReference<BlockType> OAK_SAPLING = BlockTypes.key(ResourceKey.sponge("oak_sapling"));

    public static final DefaultedRegistryReference<BlockType> OAK_SIGN = BlockTypes.key(ResourceKey.sponge("oak_sign"));

    public static final DefaultedRegistryReference<BlockType> OAK_SLAB = BlockTypes.key(ResourceKey.sponge("oak_slab"));

    public static final DefaultedRegistryReference<BlockType> OAK_STAIRS = BlockTypes.key(ResourceKey.sponge("oak_stairs"));

    public static final DefaultedRegistryReference<BlockType> OAK_TRAPDOOR = BlockTypes.key(ResourceKey.sponge("oak_trapdoor"));

    public static final DefaultedRegistryReference<BlockType> OAK_WALL_SIGN = BlockTypes.key(ResourceKey.sponge("oak_wall_sign"));

    public static final DefaultedRegistryReference<BlockType> OAK_WOOD = BlockTypes.key(ResourceKey.sponge("oak_wood"));

    public static final DefaultedRegistryReference<BlockType> OBSERVER = BlockTypes.key(ResourceKey.sponge("observer"));

    public static final DefaultedRegistryReference<BlockType> OBSIDIAN = BlockTypes.key(ResourceKey.sponge("obsidian"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_BANNER = BlockTypes.key(ResourceKey.sponge("orange_banner"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_BED = BlockTypes.key(ResourceKey.sponge("orange_bed"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_CARPET = BlockTypes.key(ResourceKey.sponge("orange_carpet"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_CONCRETE = BlockTypes.key(ResourceKey.sponge("orange_concrete"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_CONCRETE_POWDER = BlockTypes.key(ResourceKey.sponge("orange_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("orange_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_SHULKER_BOX = BlockTypes.key(ResourceKey.sponge("orange_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_STAINED_GLASS = BlockTypes.key(ResourceKey.sponge("orange_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.sponge("orange_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("orange_terracotta"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_TULIP = BlockTypes.key(ResourceKey.sponge("orange_tulip"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_WALL_BANNER = BlockTypes.key(ResourceKey.sponge("orange_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> ORANGE_WOOL = BlockTypes.key(ResourceKey.sponge("orange_wool"));

    public static final DefaultedRegistryReference<BlockType> OXEYE_DAISY = BlockTypes.key(ResourceKey.sponge("oxeye_daisy"));

    public static final DefaultedRegistryReference<BlockType> PACKED_ICE = BlockTypes.key(ResourceKey.sponge("packed_ice"));

    public static final DefaultedRegistryReference<BlockType> PEONY = BlockTypes.key(ResourceKey.sponge("peony"));

    public static final DefaultedRegistryReference<BlockType> PETRIFIED_OAK_SLAB = BlockTypes.key(ResourceKey.sponge("petrified_oak_slab"));

    public static final DefaultedRegistryReference<BlockType> PINK_BANNER = BlockTypes.key(ResourceKey.sponge("pink_banner"));

    public static final DefaultedRegistryReference<BlockType> PINK_BED = BlockTypes.key(ResourceKey.sponge("pink_bed"));

    public static final DefaultedRegistryReference<BlockType> PINK_CARPET = BlockTypes.key(ResourceKey.sponge("pink_carpet"));

    public static final DefaultedRegistryReference<BlockType> PINK_CONCRETE = BlockTypes.key(ResourceKey.sponge("pink_concrete"));

    public static final DefaultedRegistryReference<BlockType> PINK_CONCRETE_POWDER = BlockTypes.key(ResourceKey.sponge("pink_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> PINK_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("pink_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> PINK_SHULKER_BOX = BlockTypes.key(ResourceKey.sponge("pink_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> PINK_STAINED_GLASS = BlockTypes.key(ResourceKey.sponge("pink_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> PINK_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.sponge("pink_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> PINK_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("pink_terracotta"));

    public static final DefaultedRegistryReference<BlockType> PINK_TULIP = BlockTypes.key(ResourceKey.sponge("pink_tulip"));

    public static final DefaultedRegistryReference<BlockType> PINK_WALL_BANNER = BlockTypes.key(ResourceKey.sponge("pink_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> PINK_WOOL = BlockTypes.key(ResourceKey.sponge("pink_wool"));

    public static final DefaultedRegistryReference<BlockType> PISTON = BlockTypes.key(ResourceKey.sponge("piston"));

    public static final DefaultedRegistryReference<BlockType> PISTON_HEAD = BlockTypes.key(ResourceKey.sponge("piston_head"));

    public static final DefaultedRegistryReference<BlockType> PLAYER_HEAD = BlockTypes.key(ResourceKey.sponge("player_head"));

    public static final DefaultedRegistryReference<BlockType> PLAYER_WALL_HEAD = BlockTypes.key(ResourceKey.sponge("player_wall_head"));

    public static final DefaultedRegistryReference<BlockType> PODZOL = BlockTypes.key(ResourceKey.sponge("podzol"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_ANDESITE = BlockTypes.key(ResourceKey.sponge("polished_andesite"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_ANDESITE_SLAB = BlockTypes.key(ResourceKey.sponge("polished_andesite_slab"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_ANDESITE_STAIRS = BlockTypes.key(ResourceKey.sponge("polished_andesite_stairs"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_BASALT = BlockTypes.key(ResourceKey.sponge("polished_basalt"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_BLACKSTONE = BlockTypes.key(ResourceKey.sponge("polished_blackstone"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_BLACKSTONE_BRICK_SLAB = BlockTypes.key(ResourceKey.sponge("polished_blackstone_brick_slab"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_BLACKSTONE_BRICK_STAIRS = BlockTypes.key(ResourceKey.sponge("polished_blackstone_brick_stairs"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_BLACKSTONE_BRICK_WALL = BlockTypes.key(ResourceKey.sponge("polished_blackstone_brick_wall"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_BLACKSTONE_BRICKS = BlockTypes.key(ResourceKey.sponge("polished_blackstone_bricks"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_BLACKSTONE_BUTTON = BlockTypes.key(ResourceKey.sponge("polished_blackstone_button"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_BLACKSTONE_PRESSURE_PLATE = BlockTypes.key(ResourceKey.sponge("polished_blackstone_pressure_plate"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_BLACKSTONE_SLAB = BlockTypes.key(ResourceKey.sponge("polished_blackstone_slab"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_BLACKSTONE_STAIRS = BlockTypes.key(ResourceKey.sponge("polished_blackstone_stairs"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_BLACKSTONE_WALL = BlockTypes.key(ResourceKey.sponge("polished_blackstone_wall"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_DIORITE = BlockTypes.key(ResourceKey.sponge("polished_diorite"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_DIORITE_SLAB = BlockTypes.key(ResourceKey.sponge("polished_diorite_slab"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_DIORITE_STAIRS = BlockTypes.key(ResourceKey.sponge("polished_diorite_stairs"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_GRANITE = BlockTypes.key(ResourceKey.sponge("polished_granite"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_GRANITE_SLAB = BlockTypes.key(ResourceKey.sponge("polished_granite_slab"));

    public static final DefaultedRegistryReference<BlockType> POLISHED_GRANITE_STAIRS = BlockTypes.key(ResourceKey.sponge("polished_granite_stairs"));

    public static final DefaultedRegistryReference<BlockType> POPPY = BlockTypes.key(ResourceKey.sponge("poppy"));

    public static final DefaultedRegistryReference<BlockType> POTATOES = BlockTypes.key(ResourceKey.sponge("potatoes"));

    public static final DefaultedRegistryReference<BlockType> POTTED_ACACIA_SAPLING = BlockTypes.key(ResourceKey.sponge("potted_acacia_sapling"));

    public static final DefaultedRegistryReference<BlockType> POTTED_ALLIUM = BlockTypes.key(ResourceKey.sponge("potted_allium"));

    public static final DefaultedRegistryReference<BlockType> POTTED_AZURE_BLUET = BlockTypes.key(ResourceKey.sponge("potted_azure_bluet"));

    public static final DefaultedRegistryReference<BlockType> POTTED_BAMBOO = BlockTypes.key(ResourceKey.sponge("potted_bamboo"));

    public static final DefaultedRegistryReference<BlockType> POTTED_BIRCH_SAPLING = BlockTypes.key(ResourceKey.sponge("potted_birch_sapling"));

    public static final DefaultedRegistryReference<BlockType> POTTED_BLUE_ORCHID = BlockTypes.key(ResourceKey.sponge("potted_blue_orchid"));

    public static final DefaultedRegistryReference<BlockType> POTTED_BROWN_MUSHROOM = BlockTypes.key(ResourceKey.sponge("potted_brown_mushroom"));

    public static final DefaultedRegistryReference<BlockType> POTTED_CACTUS = BlockTypes.key(ResourceKey.sponge("potted_cactus"));

    public static final DefaultedRegistryReference<BlockType> POTTED_CORNFLOWER = BlockTypes.key(ResourceKey.sponge("potted_cornflower"));

    public static final DefaultedRegistryReference<BlockType> POTTED_CRIMSON_FUNGUS = BlockTypes.key(ResourceKey.sponge("potted_crimson_fungus"));

    public static final DefaultedRegistryReference<BlockType> POTTED_CRIMSON_ROOTS = BlockTypes.key(ResourceKey.sponge("potted_crimson_roots"));

    public static final DefaultedRegistryReference<BlockType> POTTED_DANDELION = BlockTypes.key(ResourceKey.sponge("potted_dandelion"));

    public static final DefaultedRegistryReference<BlockType> POTTED_DARK_OAK_SAPLING = BlockTypes.key(ResourceKey.sponge("potted_dark_oak_sapling"));

    public static final DefaultedRegistryReference<BlockType> POTTED_DEAD_BUSH = BlockTypes.key(ResourceKey.sponge("potted_dead_bush"));

    public static final DefaultedRegistryReference<BlockType> POTTED_FERN = BlockTypes.key(ResourceKey.sponge("potted_fern"));

    public static final DefaultedRegistryReference<BlockType> POTTED_JUNGLE_SAPLING = BlockTypes.key(ResourceKey.sponge("potted_jungle_sapling"));

    public static final DefaultedRegistryReference<BlockType> POTTED_LILY_OF_THE_VALLEY = BlockTypes.key(ResourceKey.sponge("potted_lily_of_the_valley"));

    public static final DefaultedRegistryReference<BlockType> POTTED_OAK_SAPLING = BlockTypes.key(ResourceKey.sponge("potted_oak_sapling"));

    public static final DefaultedRegistryReference<BlockType> POTTED_ORANGE_TULIP = BlockTypes.key(ResourceKey.sponge("potted_orange_tulip"));

    public static final DefaultedRegistryReference<BlockType> POTTED_OXEYE_DAISY = BlockTypes.key(ResourceKey.sponge("potted_oxeye_daisy"));

    public static final DefaultedRegistryReference<BlockType> POTTED_PINK_TULIP = BlockTypes.key(ResourceKey.sponge("potted_pink_tulip"));

    public static final DefaultedRegistryReference<BlockType> POTTED_POPPY = BlockTypes.key(ResourceKey.sponge("potted_poppy"));

    public static final DefaultedRegistryReference<BlockType> POTTED_RED_MUSHROOM = BlockTypes.key(ResourceKey.sponge("potted_red_mushroom"));

    public static final DefaultedRegistryReference<BlockType> POTTED_RED_TULIP = BlockTypes.key(ResourceKey.sponge("potted_red_tulip"));

    public static final DefaultedRegistryReference<BlockType> POTTED_SPRUCE_SAPLING = BlockTypes.key(ResourceKey.sponge("potted_spruce_sapling"));

    public static final DefaultedRegistryReference<BlockType> POTTED_WARPED_FUNGUS = BlockTypes.key(ResourceKey.sponge("potted_warped_fungus"));

    public static final DefaultedRegistryReference<BlockType> POTTED_WARPED_ROOTS = BlockTypes.key(ResourceKey.sponge("potted_warped_roots"));

    public static final DefaultedRegistryReference<BlockType> POTTED_WHITE_TULIP = BlockTypes.key(ResourceKey.sponge("potted_white_tulip"));

    public static final DefaultedRegistryReference<BlockType> POTTED_WITHER_ROSE = BlockTypes.key(ResourceKey.sponge("potted_wither_rose"));

    public static final DefaultedRegistryReference<BlockType> POWERED_RAIL = BlockTypes.key(ResourceKey.sponge("powered_rail"));

    public static final DefaultedRegistryReference<BlockType> PRISMARINE = BlockTypes.key(ResourceKey.sponge("prismarine"));

    public static final DefaultedRegistryReference<BlockType> PRISMARINE_BRICK_SLAB = BlockTypes.key(ResourceKey.sponge("prismarine_brick_slab"));

    public static final DefaultedRegistryReference<BlockType> PRISMARINE_BRICK_STAIRS = BlockTypes.key(ResourceKey.sponge("prismarine_brick_stairs"));

    public static final DefaultedRegistryReference<BlockType> PRISMARINE_BRICKS = BlockTypes.key(ResourceKey.sponge("prismarine_bricks"));

    public static final DefaultedRegistryReference<BlockType> PRISMARINE_SLAB = BlockTypes.key(ResourceKey.sponge("prismarine_slab"));

    public static final DefaultedRegistryReference<BlockType> PRISMARINE_STAIRS = BlockTypes.key(ResourceKey.sponge("prismarine_stairs"));

    public static final DefaultedRegistryReference<BlockType> PRISMARINE_WALL = BlockTypes.key(ResourceKey.sponge("prismarine_wall"));

    public static final DefaultedRegistryReference<BlockType> PUMPKIN = BlockTypes.key(ResourceKey.sponge("pumpkin"));

    public static final DefaultedRegistryReference<BlockType> PUMPKIN_STEM = BlockTypes.key(ResourceKey.sponge("pumpkin_stem"));

    public static final DefaultedRegistryReference<BlockType> PURPLE_BANNER = BlockTypes.key(ResourceKey.sponge("purple_banner"));

    public static final DefaultedRegistryReference<BlockType> PURPLE_BED = BlockTypes.key(ResourceKey.sponge("purple_bed"));

    public static final DefaultedRegistryReference<BlockType> PURPLE_CARPET = BlockTypes.key(ResourceKey.sponge("purple_carpet"));

    public static final DefaultedRegistryReference<BlockType> PURPLE_CONCRETE = BlockTypes.key(ResourceKey.sponge("purple_concrete"));

    public static final DefaultedRegistryReference<BlockType> PURPLE_CONCRETE_POWDER = BlockTypes.key(ResourceKey.sponge("purple_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> PURPLE_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("purple_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> PURPLE_SHULKER_BOX = BlockTypes.key(ResourceKey.sponge("purple_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> PURPLE_STAINED_GLASS = BlockTypes.key(ResourceKey.sponge("purple_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> PURPLE_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.sponge("purple_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> PURPLE_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("purple_terracotta"));

    public static final DefaultedRegistryReference<BlockType> PURPLE_WALL_BANNER = BlockTypes.key(ResourceKey.sponge("purple_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> PURPLE_WOOL = BlockTypes.key(ResourceKey.sponge("purple_wool"));

    public static final DefaultedRegistryReference<BlockType> PURPUR_BLOCK = BlockTypes.key(ResourceKey.sponge("purpur_block"));

    public static final DefaultedRegistryReference<BlockType> PURPUR_PILLAR = BlockTypes.key(ResourceKey.sponge("purpur_pillar"));

    public static final DefaultedRegistryReference<BlockType> PURPUR_SLAB = BlockTypes.key(ResourceKey.sponge("purpur_slab"));

    public static final DefaultedRegistryReference<BlockType> PURPUR_STAIRS = BlockTypes.key(ResourceKey.sponge("purpur_stairs"));

    public static final DefaultedRegistryReference<BlockType> QUARTZ_BLOCK = BlockTypes.key(ResourceKey.sponge("quartz_block"));

    public static final DefaultedRegistryReference<BlockType> QUARTZ_BRICKS = BlockTypes.key(ResourceKey.sponge("quartz_bricks"));

    public static final DefaultedRegistryReference<BlockType> QUARTZ_PILLAR = BlockTypes.key(ResourceKey.sponge("quartz_pillar"));

    public static final DefaultedRegistryReference<BlockType> QUARTZ_SLAB = BlockTypes.key(ResourceKey.sponge("quartz_slab"));

    public static final DefaultedRegistryReference<BlockType> QUARTZ_STAIRS = BlockTypes.key(ResourceKey.sponge("quartz_stairs"));

    public static final DefaultedRegistryReference<BlockType> RAIL = BlockTypes.key(ResourceKey.sponge("rail"));

    public static final DefaultedRegistryReference<BlockType> RED_BANNER = BlockTypes.key(ResourceKey.sponge("red_banner"));

    public static final DefaultedRegistryReference<BlockType> RED_BED = BlockTypes.key(ResourceKey.sponge("red_bed"));

    public static final DefaultedRegistryReference<BlockType> RED_CARPET = BlockTypes.key(ResourceKey.sponge("red_carpet"));

    public static final DefaultedRegistryReference<BlockType> RED_CONCRETE = BlockTypes.key(ResourceKey.sponge("red_concrete"));

    public static final DefaultedRegistryReference<BlockType> RED_CONCRETE_POWDER = BlockTypes.key(ResourceKey.sponge("red_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> RED_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("red_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> RED_MUSHROOM = BlockTypes.key(ResourceKey.sponge("red_mushroom"));

    public static final DefaultedRegistryReference<BlockType> RED_MUSHROOM_BLOCK = BlockTypes.key(ResourceKey.sponge("red_mushroom_block"));

    public static final DefaultedRegistryReference<BlockType> RED_NETHER_BRICK_SLAB = BlockTypes.key(ResourceKey.sponge("red_nether_brick_slab"));

    public static final DefaultedRegistryReference<BlockType> RED_NETHER_BRICK_STAIRS = BlockTypes.key(ResourceKey.sponge("red_nether_brick_stairs"));

    public static final DefaultedRegistryReference<BlockType> RED_NETHER_BRICK_WALL = BlockTypes.key(ResourceKey.sponge("red_nether_brick_wall"));

    public static final DefaultedRegistryReference<BlockType> RED_NETHER_BRICKS = BlockTypes.key(ResourceKey.sponge("red_nether_bricks"));

    public static final DefaultedRegistryReference<BlockType> RED_SAND = BlockTypes.key(ResourceKey.sponge("red_sand"));

    public static final DefaultedRegistryReference<BlockType> RED_SANDSTONE = BlockTypes.key(ResourceKey.sponge("red_sandstone"));

    public static final DefaultedRegistryReference<BlockType> RED_SANDSTONE_SLAB = BlockTypes.key(ResourceKey.sponge("red_sandstone_slab"));

    public static final DefaultedRegistryReference<BlockType> RED_SANDSTONE_STAIRS = BlockTypes.key(ResourceKey.sponge("red_sandstone_stairs"));

    public static final DefaultedRegistryReference<BlockType> RED_SANDSTONE_WALL = BlockTypes.key(ResourceKey.sponge("red_sandstone_wall"));

    public static final DefaultedRegistryReference<BlockType> RED_SHULKER_BOX = BlockTypes.key(ResourceKey.sponge("red_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> RED_STAINED_GLASS = BlockTypes.key(ResourceKey.sponge("red_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> RED_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.sponge("red_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> RED_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("red_terracotta"));

    public static final DefaultedRegistryReference<BlockType> RED_TULIP = BlockTypes.key(ResourceKey.sponge("red_tulip"));

    public static final DefaultedRegistryReference<BlockType> RED_WALL_BANNER = BlockTypes.key(ResourceKey.sponge("red_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> RED_WOOL = BlockTypes.key(ResourceKey.sponge("red_wool"));

    public static final DefaultedRegistryReference<BlockType> REDSTONE_BLOCK = BlockTypes.key(ResourceKey.sponge("redstone_block"));

    public static final DefaultedRegistryReference<BlockType> REDSTONE_LAMP = BlockTypes.key(ResourceKey.sponge("redstone_lamp"));

    public static final DefaultedRegistryReference<BlockType> REDSTONE_ORE = BlockTypes.key(ResourceKey.sponge("redstone_ore"));

    public static final DefaultedRegistryReference<BlockType> REDSTONE_TORCH = BlockTypes.key(ResourceKey.sponge("redstone_torch"));

    public static final DefaultedRegistryReference<BlockType> REDSTONE_WALL_TORCH = BlockTypes.key(ResourceKey.sponge("redstone_wall_torch"));

    public static final DefaultedRegistryReference<BlockType> REDSTONE_WIRE = BlockTypes.key(ResourceKey.sponge("redstone_wire"));

    public static final DefaultedRegistryReference<BlockType> REPEATER = BlockTypes.key(ResourceKey.sponge("repeater"));

    public static final DefaultedRegistryReference<BlockType> REPEATING_COMMAND_BLOCK = BlockTypes.key(ResourceKey.sponge("repeating_command_block"));

    public static final DefaultedRegistryReference<BlockType> RESPAWN_ANCHOR = BlockTypes.key(ResourceKey.sponge("respawn_anchor"));

    public static final DefaultedRegistryReference<BlockType> ROSE_BUSH = BlockTypes.key(ResourceKey.sponge("rose_bush"));

    public static final DefaultedRegistryReference<BlockType> SAND = BlockTypes.key(ResourceKey.sponge("sand"));

    public static final DefaultedRegistryReference<BlockType> SANDSTONE = BlockTypes.key(ResourceKey.sponge("sandstone"));

    public static final DefaultedRegistryReference<BlockType> SANDSTONE_SLAB = BlockTypes.key(ResourceKey.sponge("sandstone_slab"));

    public static final DefaultedRegistryReference<BlockType> SANDSTONE_STAIRS = BlockTypes.key(ResourceKey.sponge("sandstone_stairs"));

    public static final DefaultedRegistryReference<BlockType> SANDSTONE_WALL = BlockTypes.key(ResourceKey.sponge("sandstone_wall"));

    public static final DefaultedRegistryReference<BlockType> SCAFFOLDING = BlockTypes.key(ResourceKey.sponge("scaffolding"));

    public static final DefaultedRegistryReference<BlockType> SEA_LANTERN = BlockTypes.key(ResourceKey.sponge("sea_lantern"));

    public static final DefaultedRegistryReference<BlockType> SEA_PICKLE = BlockTypes.key(ResourceKey.sponge("sea_pickle"));

    public static final DefaultedRegistryReference<BlockType> SEAGRASS = BlockTypes.key(ResourceKey.sponge("seagrass"));

    public static final DefaultedRegistryReference<BlockType> SHROOMLIGHT = BlockTypes.key(ResourceKey.sponge("shroomlight"));

    public static final DefaultedRegistryReference<BlockType> SHULKER_BOX = BlockTypes.key(ResourceKey.sponge("shulker_box"));

    public static final DefaultedRegistryReference<BlockType> SKELETON_SKULL = BlockTypes.key(ResourceKey.sponge("skeleton_skull"));

    public static final DefaultedRegistryReference<BlockType> SKELETON_WALL_SKULL = BlockTypes.key(ResourceKey.sponge("skeleton_wall_skull"));

    public static final DefaultedRegistryReference<BlockType> SLIME_BLOCK = BlockTypes.key(ResourceKey.sponge("slime_block"));

    public static final DefaultedRegistryReference<BlockType> SMITHING_TABLE = BlockTypes.key(ResourceKey.sponge("smithing_table"));

    public static final DefaultedRegistryReference<BlockType> SMOKER = BlockTypes.key(ResourceKey.sponge("smoker"));

    public static final DefaultedRegistryReference<BlockType> SMOOTH_QUARTZ = BlockTypes.key(ResourceKey.sponge("smooth_quartz"));

    public static final DefaultedRegistryReference<BlockType> SMOOTH_QUARTZ_SLAB = BlockTypes.key(ResourceKey.sponge("smooth_quartz_slab"));

    public static final DefaultedRegistryReference<BlockType> SMOOTH_QUARTZ_STAIRS = BlockTypes.key(ResourceKey.sponge("smooth_quartz_stairs"));

    public static final DefaultedRegistryReference<BlockType> SMOOTH_RED_SANDSTONE = BlockTypes.key(ResourceKey.sponge("smooth_red_sandstone"));

    public static final DefaultedRegistryReference<BlockType> SMOOTH_RED_SANDSTONE_SLAB = BlockTypes.key(ResourceKey.sponge("smooth_red_sandstone_slab"));

    public static final DefaultedRegistryReference<BlockType> SMOOTH_RED_SANDSTONE_STAIRS = BlockTypes.key(ResourceKey.sponge("smooth_red_sandstone_stairs"));

    public static final DefaultedRegistryReference<BlockType> SMOOTH_SANDSTONE = BlockTypes.key(ResourceKey.sponge("smooth_sandstone"));

    public static final DefaultedRegistryReference<BlockType> SMOOTH_SANDSTONE_SLAB = BlockTypes.key(ResourceKey.sponge("smooth_sandstone_slab"));

    public static final DefaultedRegistryReference<BlockType> SMOOTH_SANDSTONE_STAIRS = BlockTypes.key(ResourceKey.sponge("smooth_sandstone_stairs"));

    public static final DefaultedRegistryReference<BlockType> SMOOTH_STONE = BlockTypes.key(ResourceKey.sponge("smooth_stone"));

    public static final DefaultedRegistryReference<BlockType> SMOOTH_STONE_SLAB = BlockTypes.key(ResourceKey.sponge("smooth_stone_slab"));

    public static final DefaultedRegistryReference<BlockType> SNOW = BlockTypes.key(ResourceKey.sponge("snow"));

    public static final DefaultedRegistryReference<BlockType> SNOW_BLOCK = BlockTypes.key(ResourceKey.sponge("snow_block"));

    public static final DefaultedRegistryReference<BlockType> SOUL_CAMPFIRE = BlockTypes.key(ResourceKey.sponge("soul_campfire"));

    public static final DefaultedRegistryReference<BlockType> SOUL_FIRE = BlockTypes.key(ResourceKey.sponge("soul_fire"));

    public static final DefaultedRegistryReference<BlockType> SOUL_LANTERN = BlockTypes.key(ResourceKey.sponge("soul_lantern"));

    public static final DefaultedRegistryReference<BlockType> SOUL_SAND = BlockTypes.key(ResourceKey.sponge("soul_sand"));

    public static final DefaultedRegistryReference<BlockType> SOUL_SOIL = BlockTypes.key(ResourceKey.sponge("soul_soil"));

    public static final DefaultedRegistryReference<BlockType> SOUL_TORCH = BlockTypes.key(ResourceKey.sponge("soul_torch"));

    public static final DefaultedRegistryReference<BlockType> SOUL_WALL_TORCH = BlockTypes.key(ResourceKey.sponge("soul_wall_torch"));

    public static final DefaultedRegistryReference<BlockType> SPAWNER = BlockTypes.key(ResourceKey.sponge("spawner"));

    public static final DefaultedRegistryReference<BlockType> SPONGE = BlockTypes.key(ResourceKey.sponge("sponge"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_BUTTON = BlockTypes.key(ResourceKey.sponge("spruce_button"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_DOOR = BlockTypes.key(ResourceKey.sponge("spruce_door"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_FENCE = BlockTypes.key(ResourceKey.sponge("spruce_fence"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_FENCE_GATE = BlockTypes.key(ResourceKey.sponge("spruce_fence_gate"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_LEAVES = BlockTypes.key(ResourceKey.sponge("spruce_leaves"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_LOG = BlockTypes.key(ResourceKey.sponge("spruce_log"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_PLANKS = BlockTypes.key(ResourceKey.sponge("spruce_planks"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_PRESSURE_PLATE = BlockTypes.key(ResourceKey.sponge("spruce_pressure_plate"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_SAPLING = BlockTypes.key(ResourceKey.sponge("spruce_sapling"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_SIGN = BlockTypes.key(ResourceKey.sponge("spruce_sign"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_SLAB = BlockTypes.key(ResourceKey.sponge("spruce_slab"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_STAIRS = BlockTypes.key(ResourceKey.sponge("spruce_stairs"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_TRAPDOOR = BlockTypes.key(ResourceKey.sponge("spruce_trapdoor"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_WALL_SIGN = BlockTypes.key(ResourceKey.sponge("spruce_wall_sign"));

    public static final DefaultedRegistryReference<BlockType> SPRUCE_WOOD = BlockTypes.key(ResourceKey.sponge("spruce_wood"));

    public static final DefaultedRegistryReference<BlockType> STICKY_PISTON = BlockTypes.key(ResourceKey.sponge("sticky_piston"));

    public static final DefaultedRegistryReference<BlockType> STONE = BlockTypes.key(ResourceKey.sponge("stone"));

    public static final DefaultedRegistryReference<BlockType> STONE_BRICK_SLAB = BlockTypes.key(ResourceKey.sponge("stone_brick_slab"));

    public static final DefaultedRegistryReference<BlockType> STONE_BRICK_STAIRS = BlockTypes.key(ResourceKey.sponge("stone_brick_stairs"));

    public static final DefaultedRegistryReference<BlockType> STONE_BRICK_WALL = BlockTypes.key(ResourceKey.sponge("stone_brick_wall"));

    public static final DefaultedRegistryReference<BlockType> STONE_BRICKS = BlockTypes.key(ResourceKey.sponge("stone_bricks"));

    public static final DefaultedRegistryReference<BlockType> STONE_BUTTON = BlockTypes.key(ResourceKey.sponge("stone_button"));

    public static final DefaultedRegistryReference<BlockType> STONE_PRESSURE_PLATE = BlockTypes.key(ResourceKey.sponge("stone_pressure_plate"));

    public static final DefaultedRegistryReference<BlockType> STONE_SLAB = BlockTypes.key(ResourceKey.sponge("stone_slab"));

    public static final DefaultedRegistryReference<BlockType> STONE_STAIRS = BlockTypes.key(ResourceKey.sponge("stone_stairs"));

    public static final DefaultedRegistryReference<BlockType> STONECUTTER = BlockTypes.key(ResourceKey.sponge("stonecutter"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_ACACIA_LOG = BlockTypes.key(ResourceKey.sponge("stripped_acacia_log"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_ACACIA_WOOD = BlockTypes.key(ResourceKey.sponge("stripped_acacia_wood"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_BIRCH_LOG = BlockTypes.key(ResourceKey.sponge("stripped_birch_log"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_BIRCH_WOOD = BlockTypes.key(ResourceKey.sponge("stripped_birch_wood"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_CRIMSON_HYPHAE = BlockTypes.key(ResourceKey.sponge("stripped_crimson_hyphae"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_CRIMSON_STEM = BlockTypes.key(ResourceKey.sponge("stripped_crimson_stem"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_DARK_OAK_LOG = BlockTypes.key(ResourceKey.sponge("stripped_dark_oak_log"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_DARK_OAK_WOOD = BlockTypes.key(ResourceKey.sponge("stripped_dark_oak_wood"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_JUNGLE_LOG = BlockTypes.key(ResourceKey.sponge("stripped_jungle_log"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_JUNGLE_WOOD = BlockTypes.key(ResourceKey.sponge("stripped_jungle_wood"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_OAK_LOG = BlockTypes.key(ResourceKey.sponge("stripped_oak_log"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_OAK_WOOD = BlockTypes.key(ResourceKey.sponge("stripped_oak_wood"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_SPRUCE_LOG = BlockTypes.key(ResourceKey.sponge("stripped_spruce_log"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_SPRUCE_WOOD = BlockTypes.key(ResourceKey.sponge("stripped_spruce_wood"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_WARPED_HYPHAE = BlockTypes.key(ResourceKey.sponge("stripped_warped_hyphae"));

    public static final DefaultedRegistryReference<BlockType> STRIPPED_WARPED_STEM = BlockTypes.key(ResourceKey.sponge("stripped_warped_stem"));

    public static final DefaultedRegistryReference<BlockType> STRUCTURE_BLOCK = BlockTypes.key(ResourceKey.sponge("structure_block"));

    public static final DefaultedRegistryReference<BlockType> STRUCTURE_VOID = BlockTypes.key(ResourceKey.sponge("structure_void"));

    public static final DefaultedRegistryReference<BlockType> SUGAR_CANE = BlockTypes.key(ResourceKey.sponge("sugar_cane"));

    public static final DefaultedRegistryReference<BlockType> SUNFLOWER = BlockTypes.key(ResourceKey.sponge("sunflower"));

    public static final DefaultedRegistryReference<BlockType> SWEET_BERRY_BUSH = BlockTypes.key(ResourceKey.sponge("sweet_berry_bush"));

    public static final DefaultedRegistryReference<BlockType> TALL_GRASS = BlockTypes.key(ResourceKey.sponge("tall_grass"));

    public static final DefaultedRegistryReference<BlockType> TALL_SEAGRASS = BlockTypes.key(ResourceKey.sponge("tall_seagrass"));

    public static final DefaultedRegistryReference<BlockType> TARGET = BlockTypes.key(ResourceKey.sponge("target"));

    public static final DefaultedRegistryReference<BlockType> TERRACOTTA = BlockTypes.key(ResourceKey.sponge("terracotta"));

    public static final DefaultedRegistryReference<BlockType> TNT = BlockTypes.key(ResourceKey.sponge("tnt"));

    public static final DefaultedRegistryReference<BlockType> TORCH = BlockTypes.key(ResourceKey.sponge("torch"));

    public static final DefaultedRegistryReference<BlockType> TRAPPED_CHEST = BlockTypes.key(ResourceKey.sponge("trapped_chest"));

    public static final DefaultedRegistryReference<BlockType> TRIPWIRE = BlockTypes.key(ResourceKey.sponge("tripwire"));

    public static final DefaultedRegistryReference<BlockType> TRIPWIRE_HOOK = BlockTypes.key(ResourceKey.sponge("tripwire_hook"));

    public static final DefaultedRegistryReference<BlockType> TUBE_CORAL = BlockTypes.key(ResourceKey.sponge("tube_coral"));

    public static final DefaultedRegistryReference<BlockType> TUBE_CORAL_BLOCK = BlockTypes.key(ResourceKey.sponge("tube_coral_block"));

    public static final DefaultedRegistryReference<BlockType> TUBE_CORAL_FAN = BlockTypes.key(ResourceKey.sponge("tube_coral_fan"));

    public static final DefaultedRegistryReference<BlockType> TUBE_CORAL_WALL_FAN = BlockTypes.key(ResourceKey.sponge("tube_coral_wall_fan"));

    public static final DefaultedRegistryReference<BlockType> TURTLE_EGG = BlockTypes.key(ResourceKey.sponge("turtle_egg"));

    public static final DefaultedRegistryReference<BlockType> TWISTING_VINES = BlockTypes.key(ResourceKey.sponge("twisting_vines"));

    public static final DefaultedRegistryReference<BlockType> TWISTING_VINES_PLANT = BlockTypes.key(ResourceKey.sponge("twisting_vines_plant"));

    public static final DefaultedRegistryReference<BlockType> VINE = BlockTypes.key(ResourceKey.sponge("vine"));

    public static final DefaultedRegistryReference<BlockType> VOID_AIR = BlockTypes.key(ResourceKey.sponge("void_air"));

    public static final DefaultedRegistryReference<BlockType> WALL_TORCH = BlockTypes.key(ResourceKey.sponge("wall_torch"));

    public static final DefaultedRegistryReference<BlockType> WARPED_BUTTON = BlockTypes.key(ResourceKey.sponge("warped_button"));

    public static final DefaultedRegistryReference<BlockType> WARPED_DOOR = BlockTypes.key(ResourceKey.sponge("warped_door"));

    public static final DefaultedRegistryReference<BlockType> WARPED_FENCE = BlockTypes.key(ResourceKey.sponge("warped_fence"));

    public static final DefaultedRegistryReference<BlockType> WARPED_FENCE_GATE = BlockTypes.key(ResourceKey.sponge("warped_fence_gate"));

    public static final DefaultedRegistryReference<BlockType> WARPED_FUNGUS = BlockTypes.key(ResourceKey.sponge("warped_fungus"));

    public static final DefaultedRegistryReference<BlockType> WARPED_HYPHAE = BlockTypes.key(ResourceKey.sponge("warped_hyphae"));

    public static final DefaultedRegistryReference<BlockType> WARPED_NYLIUM = BlockTypes.key(ResourceKey.sponge("warped_nylium"));

    public static final DefaultedRegistryReference<BlockType> WARPED_PLANKS = BlockTypes.key(ResourceKey.sponge("warped_planks"));

    public static final DefaultedRegistryReference<BlockType> WARPED_PRESSURE_PLATE = BlockTypes.key(ResourceKey.sponge("warped_pressure_plate"));

    public static final DefaultedRegistryReference<BlockType> WARPED_ROOTS = BlockTypes.key(ResourceKey.sponge("warped_roots"));

    public static final DefaultedRegistryReference<BlockType> WARPED_SIGN = BlockTypes.key(ResourceKey.sponge("warped_sign"));

    public static final DefaultedRegistryReference<BlockType> WARPED_SLAB = BlockTypes.key(ResourceKey.sponge("warped_slab"));

    public static final DefaultedRegistryReference<BlockType> WARPED_STAIRS = BlockTypes.key(ResourceKey.sponge("warped_stairs"));

    public static final DefaultedRegistryReference<BlockType> WARPED_STEM = BlockTypes.key(ResourceKey.sponge("warped_stem"));

    public static final DefaultedRegistryReference<BlockType> WARPED_TRAPDOOR = BlockTypes.key(ResourceKey.sponge("warped_trapdoor"));

    public static final DefaultedRegistryReference<BlockType> WARPED_WALL_SIGN = BlockTypes.key(ResourceKey.sponge("warped_wall_sign"));

    public static final DefaultedRegistryReference<BlockType> WARPED_WART_BLOCK = BlockTypes.key(ResourceKey.sponge("warped_wart_block"));

    public static final DefaultedRegistryReference<BlockType> WATER = BlockTypes.key(ResourceKey.sponge("water"));

    public static final DefaultedRegistryReference<BlockType> WEEPING_VINES = BlockTypes.key(ResourceKey.sponge("weeping_vines"));

    public static final DefaultedRegistryReference<BlockType> WEEPING_VINES_PLANT = BlockTypes.key(ResourceKey.sponge("weeping_vines_plant"));

    public static final DefaultedRegistryReference<BlockType> WET_SPONGE = BlockTypes.key(ResourceKey.sponge("wet_sponge"));

    public static final DefaultedRegistryReference<BlockType> WHEAT = BlockTypes.key(ResourceKey.sponge("wheat"));

    public static final DefaultedRegistryReference<BlockType> WHITE_BANNER = BlockTypes.key(ResourceKey.sponge("white_banner"));

    public static final DefaultedRegistryReference<BlockType> WHITE_BED = BlockTypes.key(ResourceKey.sponge("white_bed"));

    public static final DefaultedRegistryReference<BlockType> WHITE_CARPET = BlockTypes.key(ResourceKey.sponge("white_carpet"));

    public static final DefaultedRegistryReference<BlockType> WHITE_CONCRETE = BlockTypes.key(ResourceKey.sponge("white_concrete"));

    public static final DefaultedRegistryReference<BlockType> WHITE_CONCRETE_POWDER = BlockTypes.key(ResourceKey.sponge("white_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> WHITE_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("white_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> WHITE_SHULKER_BOX = BlockTypes.key(ResourceKey.sponge("white_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> WHITE_STAINED_GLASS = BlockTypes.key(ResourceKey.sponge("white_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> WHITE_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.sponge("white_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> WHITE_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("white_terracotta"));

    public static final DefaultedRegistryReference<BlockType> WHITE_TULIP = BlockTypes.key(ResourceKey.sponge("white_tulip"));

    public static final DefaultedRegistryReference<BlockType> WHITE_WALL_BANNER = BlockTypes.key(ResourceKey.sponge("white_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> WHITE_WOOL = BlockTypes.key(ResourceKey.sponge("white_wool"));

    public static final DefaultedRegistryReference<BlockType> WITHER_ROSE = BlockTypes.key(ResourceKey.sponge("wither_rose"));

    public static final DefaultedRegistryReference<BlockType> WITHER_SKELETON_SKULL = BlockTypes.key(ResourceKey.sponge("wither_skeleton_skull"));

    public static final DefaultedRegistryReference<BlockType> WITHER_SKELETON_WALL_SKULL = BlockTypes.key(ResourceKey.sponge("wither_skeleton_wall_skull"));

    public static final DefaultedRegistryReference<BlockType> YELLOW_BANNER = BlockTypes.key(ResourceKey.sponge("yellow_banner"));

    public static final DefaultedRegistryReference<BlockType> YELLOW_BED = BlockTypes.key(ResourceKey.sponge("yellow_bed"));

    public static final DefaultedRegistryReference<BlockType> YELLOW_CARPET = BlockTypes.key(ResourceKey.sponge("yellow_carpet"));

    public static final DefaultedRegistryReference<BlockType> YELLOW_CONCRETE = BlockTypes.key(ResourceKey.sponge("yellow_concrete"));

    public static final DefaultedRegistryReference<BlockType> YELLOW_CONCRETE_POWDER = BlockTypes.key(ResourceKey.sponge("yellow_concrete_powder"));

    public static final DefaultedRegistryReference<BlockType> YELLOW_GLAZED_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("yellow_glazed_terracotta"));

    public static final DefaultedRegistryReference<BlockType> YELLOW_SHULKER_BOX = BlockTypes.key(ResourceKey.sponge("yellow_shulker_box"));

    public static final DefaultedRegistryReference<BlockType> YELLOW_STAINED_GLASS = BlockTypes.key(ResourceKey.sponge("yellow_stained_glass"));

    public static final DefaultedRegistryReference<BlockType> YELLOW_STAINED_GLASS_PANE = BlockTypes.key(ResourceKey.sponge("yellow_stained_glass_pane"));

    public static final DefaultedRegistryReference<BlockType> YELLOW_TERRACOTTA = BlockTypes.key(ResourceKey.sponge("yellow_terracotta"));

    public static final DefaultedRegistryReference<BlockType> YELLOW_WALL_BANNER = BlockTypes.key(ResourceKey.sponge("yellow_wall_banner"));

    public static final DefaultedRegistryReference<BlockType> YELLOW_WOOL = BlockTypes.key(ResourceKey.sponge("yellow_wool"));

    public static final DefaultedRegistryReference<BlockType> ZOMBIE_HEAD = BlockTypes.key(ResourceKey.sponge("zombie_head"));

    public static final DefaultedRegistryReference<BlockType> ZOMBIE_WALL_HEAD = BlockTypes.key(ResourceKey.sponge("zombie_wall_head"));

    // SORTFIELDS:OFF

    // @formatter:on

    private BlockTypes() {
    }

    private static DefaultedRegistryReference<BlockType> key(final ResourceKey location) {
        return RegistryKey.<BlockType>of(Registries.BLOCK_TYPE.registry(), location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
