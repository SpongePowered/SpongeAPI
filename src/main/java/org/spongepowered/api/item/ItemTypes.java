/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

import org.spongepowered.api.item.inventory.ItemStackBuilder;
import org.spongepowered.api.item.merchant.TradeOfferBuilder;

/**
 * An enumeration of all possible {@link ItemType}s and {@link ItemBlock}s in vanilla minecraft.
 */
public class ItemTypes {

    private ItemTypes() {
    }

    public static final ItemBlock STONE = null;
    public static final ItemBlock GRASS = null;
    public static final ItemBlock DIRT = null;
    public static final ItemBlock COBBLESTONE = null;
    public static final ItemBlock PLANKS = null;
    public static final ItemBlock SAPLING = null;
    public static final ItemBlock BEDROCK = null;
    public static final ItemBlock SAND = null;
    public static final ItemBlock GRAVEL = null;
    public static final ItemBlock GOLD_ORE = null;
    public static final ItemBlock IRON_ORE = null;
    public static final ItemBlock COAL_ORE = null;
    public static final ItemBlock LOG = null;
    public static final ItemBlock LOG2 = null;
    public static final ItemBlock LEAVES = null;
    public static final ItemBlock LEAVES2 = null;
    public static final ItemBlock SPONGE = null;
    public static final ItemBlock GLASS = null;
    public static final ItemBlock LAPIS_ORE = null;
    public static final ItemBlock LAPIS_BLOCK = null;
    public static final ItemBlock DISPENSER = null;
    public static final ItemBlock SANDSTONE = null;
    public static final ItemBlock NOTEBLOCK = null;
    public static final ItemBlock GOLDEN_RAIL = null;
    public static final ItemBlock DETECTOR_RAIL = null;
    public static final ItemBlock STICKY_PISTON = null;
    public static final ItemBlock WEB = null;
    public static final ItemBlock TALLGRASS = null;
    public static final ItemBlock DEADBUSH = null;
    public static final ItemBlock PISTON = null;
    public static final ItemBlock WOOL = null;
    public static final ItemBlock YELLOW_FLOWER = null;
    public static final ItemBlock RED_FLOWER = null;
    public static final ItemBlock BROWN_MUSHROOM = null;
    public static final ItemBlock RED_MUSHROOM = null;
    public static final ItemBlock GOLD_BLOCK = null;
    public static final ItemBlock IRON_BLOCK = null;
    public static final ItemBlock STONE_SLAB = null;
    public static final ItemBlock BRICK_BLOCK = null;
    public static final ItemBlock TNT = null;
    public static final ItemBlock BOOKSHELF = null;
    public static final ItemBlock MOSSY_COBBLESTONE = null;
    public static final ItemBlock OBSIDIAN = null;
    public static final ItemBlock TORCH = null;
    public static final ItemBlock MOB_SPAWNER = null;
    public static final ItemBlock OAK_STAIRS = null;
    public static final ItemBlock CHEST = null;
    public static final ItemBlock DIAMOND_ORE = null;
    public static final ItemBlock DIAMOND_BLOCK = null;
    public static final ItemBlock CRAFTING_TABLE = null;
    public static final ItemBlock FARMLAND = null;
    public static final ItemBlock FURNACE = null;
    public static final ItemBlock LIT_FURNACE = null;
    public static final ItemBlock LADDER = null;
    public static final ItemBlock RAIL = null;
    public static final ItemBlock STONE_STAIRS = null;
    public static final ItemBlock LEVER = null;
    public static final ItemBlock STONE_PRESSURE_PLATE = null;
    public static final ItemBlock WOODEN_PRESSURE_PLATE = null;
    public static final ItemBlock REDSTONE_ORE = null;
    public static final ItemBlock REDSTONE_TORCH = null;
    public static final ItemBlock STONE_BUTTON = null;
    public static final ItemBlock SNOW_LAYER = null;
    public static final ItemBlock ICE = null;
    public static final ItemBlock SNOW = null;
    public static final ItemBlock CACTUS = null;
    public static final ItemBlock CLAY = null;
    public static final ItemBlock JUKEBOX = null;
    public static final ItemBlock OAK_FENCE = null;
    public static final ItemBlock SPRUCE_FENCE = null;
    public static final ItemBlock BIRCH_FENCE = null;
    public static final ItemBlock JUNGLE_FENCE = null;
    public static final ItemBlock DARK_OAK_FENCE = null;
    public static final ItemBlock ACACIA_FENCE = null;
    public static final ItemBlock PUMPKIN = null;
    public static final ItemBlock NETHERRACK = null;
    public static final ItemBlock SOUL_SAND = null;
    public static final ItemBlock GLOWSTONE = null;
    public static final ItemBlock LIT_PUMPKIN = null;
    public static final ItemBlock TRAPDOOR = null;
    public static final ItemBlock MONSTER_EGG = null;
    public static final ItemBlock STONEBRICK = null;
    public static final ItemBlock BROWN_MUSHROOM_BLOCK = null;
    public static final ItemBlock RED_MUSHROOM_BLOCK = null;
    public static final ItemBlock IRON_BARS = null;
    public static final ItemBlock GLASS_PANE = null;
    public static final ItemBlock MELON_BLOCK = null;
    public static final ItemBlock VINE = null;
    public static final ItemBlock OAK_FENCE_GATE = null;
    public static final ItemBlock SPRUCE_FENCE_GATE = null;
    public static final ItemBlock BIRCH_FENCE_GATE = null;
    public static final ItemBlock JUNGLE_FENCE_GATE = null;
    public static final ItemBlock DARK_OAK_FENCE_GATE = null;
    public static final ItemBlock ACACIA_FENCE_GATE = null;
    public static final ItemBlock BRICK_STAIRS = null;
    public static final ItemBlock STONE_BRICK_STAIRS = null;
    public static final ItemBlock MYCELIUM = null;
    public static final ItemBlock WATERLILY = null;
    public static final ItemBlock NETHER_BRICK = null;
    public static final ItemBlock NETHER_BRICK_FENCE = null;
    public static final ItemBlock NETHER_BRICK_STAIRS = null;
    public static final ItemBlock ENCHANTING_TABLE = null;
    public static final ItemBlock END_PORTAL_FRAME = null;
    public static final ItemBlock END_STONE = null;
    public static final ItemBlock DRAGON_EGG = null;
    public static final ItemBlock REDSTONE_LAMP = null;
    public static final ItemBlock WOODEN_SLAB = null;
    public static final ItemBlock SANDSTONE_STAIRS = null;
    public static final ItemBlock EMERALD_ORE = null;
    public static final ItemBlock ENDER_CHEST = null;
    public static final ItemBlock TRIPWIRE_HOOK = null;
    public static final ItemBlock EMERALD_BLOCK = null;
    public static final ItemBlock SPRUCE_STAIRS = null;
    public static final ItemBlock BIRCH_STAIRS = null;
    public static final ItemBlock JUNGLE_STAIRS = null;
    public static final ItemBlock COMMAND_BLOCK = null;
    public static final ItemBlock BEACON = null;
    public static final ItemBlock COBBLESTONE_WALL = null;
    public static final ItemBlock WOODEN_BUTTON = null;
    public static final ItemBlock ANVIL = null;
    public static final ItemBlock TRAPPED_CHEST = null;
    public static final ItemBlock LIGHT_WEIGHTED_PRESSURE_PLATE = null;
    public static final ItemBlock HEAVY_WEIGHTED_PRESSURE_PLATE = null;
    public static final ItemBlock DAYLIGHT_DETECTOR = null;
    public static final ItemBlock REDSTONE_BLOCK = null;
    public static final ItemBlock QUARTZ_ORE = null;
    public static final ItemBlock HOPPER = null;
    public static final ItemBlock QUARTZ_BLOCK = null;
    public static final ItemBlock QUARTZ_STAIRS = null;
    public static final ItemBlock ACTIVATOR_RAIL = null;
    public static final ItemBlock DROPPER = null;
    public static final ItemBlock STAINED_HARDENED_CLAY = null;
    public static final ItemBlock BARRIER = null;
    public static final ItemBlock IRON_TRAPDOOR = null;
    public static final ItemBlock HAY_BLOCK = null;
    public static final ItemBlock CARPET = null;
    public static final ItemBlock HARDENED_CLAY = null;
    public static final ItemBlock COAL_BLOCK = null;
    public static final ItemBlock PACKED_ICE = null;
    public static final ItemBlock ACACIA_STAIRS = null;
    public static final ItemBlock DARK_OAK_STAIRS = null;
    public static final ItemBlock SLIME_BLOCK = null;
    public static final ItemBlock DOUBLE_PLANT = null;
    public static final ItemBlock STAINED_GLASS = null;
    public static final ItemBlock STAINED_GLASS_PANE = null;
    public static final ItemBlock PRISMARINE = null;
    public static final ItemBlock SEA_LANTERN = null;
    public static final ItemBlock RED_SANDSTONE = null;
    public static final ItemBlock RED_SANDSTONE_STAIRS = null;
    public static final ItemBlock STONE_SLAB2 = null;

    public static final ItemType IRON_SHOVEL = null;
    public static final ItemType IRON_PICKAXE = null;
    public static final ItemType IRON_AXE = null;
    public static final ItemType FLINT_AND_STEEL = null;
    public static final ItemType APPLE = null;
    public static final ItemType BOW = null;
    public static final ItemType ARROW = null;
    public static final ItemType COAL = null;
    public static final ItemType DIAMOND = null;
    public static final ItemType IRON_INGOT = null;
    public static final ItemType GOLD_INGOT = null;
    public static final ItemType IRON_SWORD = null;
    public static final ItemType WOODEN_SWORD = null;
    public static final ItemType WOODEN_SHOVEL = null;
    public static final ItemType WOODEN_PICKAXE = null;
    public static final ItemType WOODEN_AXE = null;
    public static final ItemType STONE_SWORD = null;
    public static final ItemType STONE_SHOVEL = null;
    public static final ItemType STONE_PICKAXE = null;
    public static final ItemType STONE_AXE = null;
    public static final ItemType DIAMOND_SWORD = null;
    public static final ItemType DIAMOND_SHOVEL = null;
    public static final ItemType DIAMOND_PICKAXE = null;
    public static final ItemType DIAMOND_AXE = null;
    public static final ItemType STICK = null;
    public static final ItemType BOWL = null;
    public static final ItemType MUSHROOM_STEW = null;
    public static final ItemType GOLDEN_SWORD = null;
    public static final ItemType GOLDEN_SHOVEL = null;
    public static final ItemType GOLDEN_PICKAXE = null;
    public static final ItemType GOLDEN_AXE = null;
    public static final ItemType STRING = null;
    public static final ItemType FEATHER = null;
    public static final ItemType GUNPOWDER = null;
    public static final ItemType WOODEN_HOE = null;
    public static final ItemType STONE_HOE = null;
    public static final ItemType IRON_HOE = null;
    public static final ItemType DIAMOND_HOE = null;
    public static final ItemType GOLDEN_HOE = null;
    public static final ItemType WHEAT_SEEDS = null;
    public static final ItemType WHEAT = null;
    public static final ItemType BREAD = null;
    public static final ItemType LEATHER_HELMET = null;
    public static final ItemType LEATHER_CHESTPLATE = null;
    public static final ItemType LEATHER_LEGGINGS = null;
    public static final ItemType LEATHER_BOOTS = null;
    public static final ItemType CHAINMAIL_HELMET = null;
    public static final ItemType CHAINMAIL_CHESTPLATE = null;
    public static final ItemType CHAINMAIL_LEGGINGS = null;
    public static final ItemType CHAINMAIL_BOOTS = null;
    public static final ItemType IRON_HELMET = null;
    public static final ItemType IRON_CHESTPLATE = null;
    public static final ItemType IRON_LEGGINGS = null;
    public static final ItemType IRON_BOOTS = null;
    public static final ItemType DIAMOND_HELMET = null;
    public static final ItemType DIAMOND_CHESTPLATE = null;
    public static final ItemType DIAMOND_LEGGINGS = null;
    public static final ItemType DIAMOND_BOOTS = null;
    public static final ItemType GOLDEN_HELMET = null;
    public static final ItemType GOLDEN_CHESTPLATE = null;
    public static final ItemType GOLDEN_LEGGINGS = null;
    public static final ItemType GOLDEN_BOOTS = null;
    public static final ItemType FLINT = null;
    public static final ItemType PORKCHOP = null;
    public static final ItemType COOKED_PORKCHOP = null;
    public static final ItemType PAINTING = null;
    public static final ItemType GOLDEN_APPLE = null;
    public static final ItemType SIGN = null;
    public static final ItemType WOODEN_DOOR = null;
    public static final ItemType BUCKET = null;
    public static final ItemType WATER_BUCKET = null;
    public static final ItemType LAVA_BUCKET = null;
    public static final ItemType MINECART = null;
    public static final ItemType SADDLE = null;
    public static final ItemType IRON_DOOR = null;
    public static final ItemType REDSTONE = null;
    public static final ItemType SNOWBALL = null;
    public static final ItemType BOAT = null;
    public static final ItemType LEATHER = null;
    public static final ItemType MILK_BUCKET = null;
    public static final ItemType BRICK = null;
    public static final ItemType CLAY_BALL = null;
    public static final ItemType REEDS = null;
    public static final ItemType PAPER = null;
    public static final ItemType BOOK = null;
    public static final ItemType SLIME_BALL = null;
    public static final ItemType CHEST_MINECART = null;
    public static final ItemType FURNACE_MINECART = null;
    public static final ItemType EGG = null;
    public static final ItemType COMPASS = null;
    public static final ItemType FISHING_ROD = null;
    public static final ItemType CLOCK = null;
    public static final ItemType GLOWSTONE_DUST = null;
    public static final ItemType FISH = null;
    public static final ItemType COOKED_FISH = null;
    public static final ItemType DYE = null;
    public static final ItemType BONE = null;
    public static final ItemType SUGAR = null;
    public static final ItemType CAKE = null;
    public static final ItemType BED = null;
    public static final ItemType REPEATER = null;
    public static final ItemType COOKIE = null;
    public static final ItemType FILLED_MAP = null;
    public static final ItemType SHEARS = null;
    public static final ItemType MELON = null;
    public static final ItemType PUMPKIN_SEEDS = null;
    public static final ItemType MELON_SEEDS = null;
    public static final ItemType BEEF = null;
    public static final ItemType COOKED_BEEF = null;
    public static final ItemType CHICKEN = null;
    public static final ItemType COOKED_CHICKEN = null;
    public static final ItemType ROTTEN_FLESH = null;
    public static final ItemType ENDER_PEARL = null;
    public static final ItemType BLAZE_ROD = null;
    public static final ItemType GHAST_TEAR = null;
    public static final ItemType GOLD_NUGGET = null;
    public static final ItemType NETHER_WART = null;
    public static final ItemType POTION = null;
    public static final ItemType GLASS_BOTTLE = null;
    public static final ItemType SPIDER_EYE = null;
    public static final ItemType FERMENTED_SPIDER_EYE = null;
    public static final ItemType BLAZE_POWDER = null;
    public static final ItemType MAGMA_CREAM = null;
    public static final ItemType BREWING_STAND = null;
    public static final ItemType CAULDRON = null;
    public static final ItemType ENDER_EYE = null;
    public static final ItemType SPECKLED_MELON = null;
    public static final ItemType SPAWN_EGG = null;
    public static final ItemType EXPERIENCE_BOTTLE = null;
    public static final ItemType FIRE_CHARGE = null;
    public static final ItemType WRITABLE_BOOK = null;
    public static final ItemType WRITTEN_BOOK = null;
    public static final ItemType EMERALD = null;
    public static final ItemType ITEM_FRAME = null;
    public static final ItemType FLOWER_POT = null;
    public static final ItemType CARROT = null;
    public static final ItemType POTATO = null;
    public static final ItemType BAKED_POTATO = null;
    public static final ItemType POISONOUS_POTATO = null;
    public static final ItemType MAP = null;
    public static final ItemType GOLDEN_CARROT = null;
    public static final ItemType SKULL = null;
    public static final ItemType CARROT_ON_A_STICK = null;
    public static final ItemType NETHER_STAR = null;
    public static final ItemType PUMPKIN_PIE = null;
    public static final ItemType FIREWORKS = null;
    public static final ItemType FIREWORK_CHARGE = null;
    public static final ItemType ENCHANTED_BOOK = null;
    public static final ItemType COMPARATOR = null;
    public static final ItemType NETHERBRICK = null;
    public static final ItemType QUARTZ = null;
    public static final ItemType TNT_MINECART = null;
    public static final ItemType HOPPER_MINECART = null;
    public static final ItemType PRISMARINE_SHARD = null;
    public static final ItemType PRISMARINE_CRYSTALS = null;
    public static final ItemType RABBIT = null;
    public static final ItemType COOKED_RABBIT = null;
    public static final ItemType RABBIT_STEW = null;
    public static final ItemType RABBIT_FOOT = null;
    public static final ItemType RABBIT_HIDE = null;
    public static final ItemType ARMOR_STAND = null;
    public static final ItemType IRON_HORSE_ARMOR = null;
    public static final ItemType GOLDEN_HORSE_ARMOR = null;
    public static final ItemType DIAMOND_HORSE_ARMOR = null;
    public static final ItemType LEAD = null;
    public static final ItemType NAME_TAG = null;
    public static final ItemType COMMAND_BLOCK_MINECART = null;
    public static final ItemType MUTTON = null;
    public static final ItemType COOKED_MUTTON = null;
    public static final ItemType BANNER = null;
    public static final ItemType SPRUCE_DOOR = null;
    public static final ItemType BIRCH_DOOR = null;
    public static final ItemType JUNGLE_DOOR = null;
    public static final ItemType ACACIA_DOOR = null;
    public static final ItemType DARK_OAK_DOOR = null;
    public static final ItemType RECORD_13 = null;
    public static final ItemType RECORD_CAT = null;
    public static final ItemType RECORD_BLOCKS = null;
    public static final ItemType RECORD_CHIRP = null;
    public static final ItemType RECORD_FAR = null;
    public static final ItemType RECORD_MALL = null;
    public static final ItemType RECORD_MELLOHI = null;
    public static final ItemType RECORD_STAL = null;
    public static final ItemType RECORD_STRAD = null;
    public static final ItemType RECORD_WARD = null;
    public static final ItemType RECORD_11 = null;
    public static final ItemType RECORD_WAIT = null;

    public static ItemStackBuilder getItemBuilder() {
        return null;
    }

    public static TradeOfferBuilder getTradeOfferBuilder() {
        return null;
    }
}
