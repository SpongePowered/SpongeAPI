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

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of vanilla {@link SoundType}s.
 */
public final class SoundTypes {

    // SORTFIELDS:ON

    public static final SoundType AMBIENT_CAVE = null;

    public static final SoundType BLOCK_ANVIL_BREAK = null;

    public static final SoundType BLOCK_ANVIL_DESTROY = null;

    public static final SoundType BLOCK_ANVIL_FALL = null;

    public static final SoundType BLOCK_ANVIL_HIT = null;

    public static final SoundType BLOCK_ANVIL_LAND = null;

    public static final SoundType BLOCK_ANVIL_PLACE = null;

    public static final SoundType BLOCK_ANVIL_STEP = null;

    public static final SoundType BLOCK_ANVIL_USE = null;

    public static final SoundType BLOCK_BREWING_STAND_BREW = null;

    public static final SoundType BLOCK_CHEST_CLOSE = null;

    public static final SoundType BLOCK_CHEST_LOCKED = null;

    public static final SoundType BLOCK_CHEST_OPEN = null;

    public static final SoundType BLOCK_CHORUS_FLOWER_DEATH = null;

    public static final SoundType BLOCK_CHORUS_FLOWER_GROW = null;

    public static final SoundType BLOCK_CLOTH_BREAK = null;

    public static final SoundType BLOCK_CLOTH_FALL = null;

    public static final SoundType BLOCK_CLOTH_HIT = null;

    public static final SoundType BLOCK_CLOTH_PLACE = null;

    public static final SoundType BLOCK_CLOTH_STEP = null;

    public static final SoundType BLOCK_COMPARATOR_CLICK = null;

    public static final SoundType BLOCK_DISPENSER_DISPENSE = null;

    public static final SoundType BLOCK_DISPENSER_FAIL = null;

    public static final SoundType BLOCK_DISPENSER_LAUNCH = null;

    public static final SoundType BLOCK_ENDERCHEST_CLOSE = null;

    public static final SoundType BLOCK_ENDERCHEST_OPEN = null;

    public static final SoundType BLOCK_END_GATEWAY_SPAWN = null;

    public static final SoundType BLOCK_FENCE_GATE_CLOSE = null;

    public static final SoundType BLOCK_FENCE_GATE_OPEN = null;

    public static final SoundType BLOCK_FIRE_AMBIENT = null;

    public static final SoundType BLOCK_FIRE_EXTINGUISH = null;

    public static final SoundType BLOCK_FURNACE_FIRE_CRACKLE = null;

    public static final SoundType BLOCK_GLASS_BREAK = null;

    public static final SoundType BLOCK_GLASS_FALL = null;

    public static final SoundType BLOCK_GLASS_HIT = null;

    public static final SoundType BLOCK_GLASS_PLACE = null;

    public static final SoundType BLOCK_GLASS_STEP = null;

    public static final SoundType BLOCK_GRASS_BREAK = null;

    public static final SoundType BLOCK_GRASS_FALL = null;

    public static final SoundType BLOCK_GRASS_HIT = null;

    public static final SoundType BLOCK_GRASS_PLACE = null;

    public static final SoundType BLOCK_GRASS_STEP = null;

    public static final SoundType BLOCK_GRAVEL_BREAK = null;

    public static final SoundType BLOCK_GRAVEL_FALL = null;

    public static final SoundType BLOCK_GRAVEL_HIT = null;

    public static final SoundType BLOCK_GRAVEL_PLACE = null;

    public static final SoundType BLOCK_GRAVEL_STEP = null;

    public static final SoundType BLOCK_IRON_DOOR_CLOSE = null;

    public static final SoundType BLOCK_IRON_DOOR_OPEN = null;

    public static final SoundType BLOCK_IRON_TRAPDOOR_CLOSE = null;

    public static final SoundType BLOCK_IRON_TRAPDOOR_OPEN = null;

    public static final SoundType BLOCK_LADDER_BREAK = null;

    public static final SoundType BLOCK_LADDER_FALL = null;

    public static final SoundType BLOCK_LADDER_HIT = null;

    public static final SoundType BLOCK_LADDER_PLACE = null;

    public static final SoundType BLOCK_LADDER_STEP = null;

    public static final SoundType BLOCK_LAVA_AMBIENT = null;

    public static final SoundType BLOCK_LAVA_EXTINGUISH = null;

    public static final SoundType BLOCK_LAVA_POP = null;

    public static final SoundType BLOCK_LEVER_CLICK = null;

    public static final SoundType BLOCK_METAL_BREAK = null;

    public static final SoundType BLOCK_METAL_FALL = null;

    public static final SoundType BLOCK_METAL_HIT = null;

    public static final SoundType BLOCK_METAL_PLACE = null;

    public static final SoundType BLOCK_METAL_PRESSPLATE_CLICK_OFF = null;

    public static final SoundType BLOCK_METAL_PRESSPLATE_CLICK_ON = null;

    public static final SoundType BLOCK_METAL_STEP = null;

    public static final SoundType BLOCK_NOTE_BASEDRUM = null;

    public static final SoundType BLOCK_NOTE_BASS = null;

    public static final SoundType BLOCK_NOTE_HARP = null;

    public static final SoundType BLOCK_NOTE_HAT = null;

    public static final SoundType BLOCK_NOTE_PLING = null;

    public static final SoundType BLOCK_NOTE_SNARE = null;

    public static final SoundType BLOCK_PISTON_CONTRACT = null;

    public static final SoundType BLOCK_PISTON_EXTEND = null;

    public static final SoundType BLOCK_PORTAL_AMBIENT = null;

    public static final SoundType BLOCK_PORTAL_TRAVEL = null;

    public static final SoundType BLOCK_PORTAL_TRIGGER = null;

    public static final SoundType BLOCK_REDSTONE_TORCH_BURNOUT = null;

    public static final SoundType BLOCK_SAND_BREAK = null;

    public static final SoundType BLOCK_SAND_FALL = null;

    public static final SoundType BLOCK_SAND_HIT = null;

    public static final SoundType BLOCK_SAND_PLACE = null;

    public static final SoundType BLOCK_SAND_STEP = null;

    public static final SoundType BLOCK_SLIME_BREAK = null;

    public static final SoundType BLOCK_SLIME_FALL = null;

    public static final SoundType BLOCK_SLIME_HIT = null;

    public static final SoundType BLOCK_SLIME_PLACE = null;

    public static final SoundType BLOCK_SLIME_STEP = null;

    public static final SoundType BLOCK_SNOW_BREAK = null;

    public static final SoundType BLOCK_SNOW_FALL = null;

    public static final SoundType BLOCK_SNOW_HIT = null;

    public static final SoundType BLOCK_SNOW_PLACE = null;

    public static final SoundType BLOCK_SNOW_STEP = null;

    public static final SoundType BLOCK_STONE_BREAK = null;

    public static final SoundType BLOCK_STONE_BUTTON_CLICK_OFF = null;

    public static final SoundType BLOCK_STONE_BUTTON_CLICK_ON = null;

    public static final SoundType BLOCK_STONE_FALL = null;

    public static final SoundType BLOCK_STONE_HIT = null;

    public static final SoundType BLOCK_STONE_PLACE = null;

    public static final SoundType BLOCK_STONE_PRESSPLATE_CLICK_OFF = null;

    public static final SoundType BLOCK_STONE_PRESSPLATE_CLICK_ON = null;

    public static final SoundType BLOCK_STONE_STEP = null;

    public static final SoundType BLOCK_TRIPWIRE_ATTACH = null;

    public static final SoundType BLOCK_TRIPWIRE_CLICK_OFF = null;

    public static final SoundType BLOCK_TRIPWIRE_CLICK_ON = null;

    public static final SoundType BLOCK_TRIPWIRE_DETACH = null;

    public static final SoundType BLOCK_WATERLILY_PLACE = null;

    public static final SoundType BLOCK_WATER_AMBIENT = null;

    public static final SoundType BLOCK_WOODEN_DOOR_CLOSE = null;

    public static final SoundType BLOCK_WOODEN_DOOR_OPEN = null;

    public static final SoundType BLOCK_WOODEN_TRAPDOOR_CLOSE = null;

    public static final SoundType BLOCK_WOODEN_TRAPDOOR_OPEN = null;

    public static final SoundType BLOCK_WOOD_BREAK = null;

    public static final SoundType BLOCK_WOOD_BUTTON_CLICK_OFF = null;

    public static final SoundType BLOCK_WOOD_BUTTON_CLICK_ON = null;

    public static final SoundType BLOCK_WOOD_FALL = null;

    public static final SoundType BLOCK_WOOD_HIT = null;

    public static final SoundType BLOCK_WOOD_PLACE = null;

    public static final SoundType BLOCK_WOOD_PRESSPLATE_CLICK_OFF = null;

    public static final SoundType BLOCK_WOOD_PRESSPLATE_CLICK_ON = null;

    public static final SoundType BLOCK_WOOD_STEP = null;

    public static final SoundType ENCHANT_THORNS_HIT = null;

    public static final SoundType ENTITY_ARMORSTAND_BREAK = null;

    public static final SoundType ENTITY_ARMORSTAND_FALL = null;

    public static final SoundType ENTITY_ARMORSTAND_HIT = null;

    public static final SoundType ENTITY_ARMORSTAND_PLACE = null;

    public static final SoundType ENTITY_ARROW_HIT = null;

    public static final SoundType ENTITY_ARROW_HIT_PLAYER = null;

    public static final SoundType ENTITY_ARROW_SHOOT = null;

    public static final SoundType ENTITY_BAT_AMBIENT = null;

    public static final SoundType ENTITY_BAT_DEATH = null;

    public static final SoundType ENTITY_BAT_HURT = null;

    public static final SoundType ENTITY_BAT_LOOP = null;

    public static final SoundType ENTITY_BAT_TAKEOFF = null;

    public static final SoundType ENTITY_BLAZE_AMBIENT = null;

    public static final SoundType ENTITY_BLAZE_BURN = null;

    public static final SoundType ENTITY_BLAZE_DEATH = null;

    public static final SoundType ENTITY_BLAZE_HURT = null;

    public static final SoundType ENTITY_BLAZE_SHOOT = null;

    public static final SoundType ENTITY_BOBBER_SPLASH = null;

    public static final SoundType ENTITY_BOBBER_THROW = null;

    public static final SoundType ENTITY_CAT_AMBIENT = null;

    public static final SoundType ENTITY_CAT_DEATH = null;

    public static final SoundType ENTITY_CAT_HISS = null;

    public static final SoundType ENTITY_CAT_HURT = null;

    public static final SoundType ENTITY_CAT_PURR = null;

    public static final SoundType ENTITY_CAT_PURREOW = null;

    public static final SoundType ENTITY_CHICKEN_AMBIENT = null;

    public static final SoundType ENTITY_CHICKEN_DEATH = null;

    public static final SoundType ENTITY_CHICKEN_EGG = null;

    public static final SoundType ENTITY_CHICKEN_HURT = null;

    public static final SoundType ENTITY_CHICKEN_STEP = null;

    public static final SoundType ENTITY_COW_AMBIENT = null;

    public static final SoundType ENTITY_COW_DEATH = null;

    public static final SoundType ENTITY_COW_HURT = null;

    public static final SoundType ENTITY_COW_MILK = null;

    public static final SoundType ENTITY_COW_STEP = null;

    public static final SoundType ENTITY_CREEPER_DEATH = null;

    public static final SoundType ENTITY_CREEPER_HURT = null;

    public static final SoundType ENTITY_CREEPER_PRIMED = null;

    public static final SoundType ENTITY_DONKEY_AMBIENT = null;

    public static final SoundType ENTITY_DONKEY_ANGRY = null;

    public static final SoundType ENTITY_DONKEY_CHEST = null;

    public static final SoundType ENTITY_DONKEY_DEATH = null;

    public static final SoundType ENTITY_DONKEY_HURT = null;

    public static final SoundType ENTITY_EGG_THROW = null;

    public static final SoundType ENTITY_ELDERGUARDIAN_AMBIENTLAND = null;

    public static final SoundType ENTITY_ELDER_GUARDIAN_AMBIENT = null;

    public static final SoundType ENTITY_ELDER_GUARDIAN_CURSE = null;

    public static final SoundType ENTITY_ELDER_GUARDIAN_DEATH = null;

    public static final SoundType ENTITY_ELDER_GUARDIAN_DEATH_LAND = null;

    public static final SoundType ENTITY_ELDER_GUARDIAN_HURT = null;

    public static final SoundType ENTITY_ELDER_GUARDIAN_HURT_LAND = null;

    public static final SoundType ENTITY_ENDERDRAGON_AMBIENT = null;

    public static final SoundType ENTITY_ENDERDRAGON_DEATH = null;

    public static final SoundType ENTITY_ENDERDRAGON_FIREBALL_EPLD = null;

    public static final SoundType ENTITY_ENDERDRAGON_FLAP = null;

    public static final SoundType ENTITY_ENDERDRAGON_GROWL = null;

    public static final SoundType ENTITY_ENDERDRAGON_HURT = null;

    public static final SoundType ENTITY_ENDERDRAGON_SHOOT = null;

    public static final SoundType ENTITY_ENDEREYE_LAUNCH = null;

    public static final SoundType ENTITY_ENDERMEN_AMBIENT = null;

    public static final SoundType ENTITY_ENDERMEN_DEATH = null;

    public static final SoundType ENTITY_ENDERMEN_HURT = null;

    public static final SoundType ENTITY_ENDERMEN_SCREAM = null;

    public static final SoundType ENTITY_ENDERMEN_STARE = null;

    public static final SoundType ENTITY_ENDERMEN_TELEPORT = null;

    public static final SoundType ENTITY_ENDERMITE_AMBIENT = null;

    public static final SoundType ENTITY_ENDERMITE_DEATH = null;

    public static final SoundType ENTITY_ENDERMITE_HURT = null;

    public static final SoundType ENTITY_ENDERMITE_STEP = null;

    public static final SoundType ENTITY_ENDERPEARL_THROW = null;

    public static final SoundType ENTITY_EXPERIENCE_BOTTLE_THROW = null;

    public static final SoundType ENTITY_EXPERIENCE_ORB_PICKUP = null;

    public static final SoundType ENTITY_EXPERIENCE_ORB_TOUCH = null;

    public static final SoundType ENTITY_FIREWORK_BLAST = null;

    public static final SoundType ENTITY_FIREWORK_BLAST_FAR = null;

    public static final SoundType ENTITY_FIREWORK_LARGE_BLAST = null;

    public static final SoundType ENTITY_FIREWORK_LARGE_BLAST_FAR = null;

    public static final SoundType ENTITY_FIREWORK_LAUNCH = null;

    public static final SoundType ENTITY_FIREWORK_SHOOT = null;

    public static final SoundType ENTITY_FIREWORK_TWINKLE = null;

    public static final SoundType ENTITY_FIREWORK_TWINKLE_FAR = null;

    public static final SoundType ENTITY_GENERIC_BIG_FALL = null;

    public static final SoundType ENTITY_GENERIC_BURN = null;

    public static final SoundType ENTITY_GENERIC_DEATH = null;

    public static final SoundType ENTITY_GENERIC_DRINK = null;

    public static final SoundType ENTITY_GENERIC_EAT = null;

    public static final SoundType ENTITY_GENERIC_EXPLODE = null;

    public static final SoundType ENTITY_GENERIC_EXTINGUISH_FIRE = null;

    public static final SoundType ENTITY_GENERIC_HURT = null;

    public static final SoundType ENTITY_GENERIC_SMALL_FALL = null;

    public static final SoundType ENTITY_GENERIC_SPLASH = null;

    public static final SoundType ENTITY_GENERIC_SWIM = null;

    public static final SoundType ENTITY_GHAST_AMBIENT = null;

    public static final SoundType ENTITY_GHAST_DEATH = null;

    public static final SoundType ENTITY_GHAST_HURT = null;

    public static final SoundType ENTITY_GHAST_SCREAM = null;

    public static final SoundType ENTITY_GHAST_SHOOT = null;

    public static final SoundType ENTITY_GHAST_WARN = null;

    public static final SoundType ENTITY_GUARDIAN_AMBIENT = null;

    public static final SoundType ENTITY_GUARDIAN_AMBIENT_LAND = null;

    public static final SoundType ENTITY_GUARDIAN_ATTACK = null;

    public static final SoundType ENTITY_GUARDIAN_DEATH = null;

    public static final SoundType ENTITY_GUARDIAN_DEATH_LAND = null;

    public static final SoundType ENTITY_GUARDIAN_FLOP = null;

    public static final SoundType ENTITY_GUARDIAN_HURT = null;

    public static final SoundType ENTITY_GUARDIAN_HURT_LAND = null;

    public static final SoundType ENTITY_HORSE_AMBIENT = null;

    public static final SoundType ENTITY_HORSE_ANGRY = null;

    public static final SoundType ENTITY_HORSE_ARMOR = null;

    public static final SoundType ENTITY_HORSE_BREATHE = null;

    public static final SoundType ENTITY_HORSE_DEATH = null;

    public static final SoundType ENTITY_HORSE_EAT = null;

    public static final SoundType ENTITY_HORSE_GALLOP = null;

    public static final SoundType ENTITY_HORSE_HURT = null;

    public static final SoundType ENTITY_HORSE_JUMP = null;

    public static final SoundType ENTITY_HORSE_LAND = null;

    public static final SoundType ENTITY_HORSE_SADDLE = null;

    public static final SoundType ENTITY_HORSE_STEP = null;

    public static final SoundType ENTITY_HORSE_STEP_WOOD = null;

    public static final SoundType ENTITY_HOSTILE_BIG_FALL = null;

    public static final SoundType ENTITY_HOSTILE_DEATH = null;

    public static final SoundType ENTITY_HOSTILE_HURT = null;

    public static final SoundType ENTITY_HOSTILE_SMALL_FALL = null;

    public static final SoundType ENTITY_HOSTILE_SPLASH = null;

    public static final SoundType ENTITY_HOSTILE_SWIM = null;

    public static final SoundType ENTITY_IRONGOLEM_ATTACK = null;

    public static final SoundType ENTITY_IRONGOLEM_DEATH = null;

    public static final SoundType ENTITY_IRONGOLEM_HURT = null;

    public static final SoundType ENTITY_IRONGOLEM_STEP = null;

    public static final SoundType ENTITY_ITEMFRAME_ADD_ITEM = null;

    public static final SoundType ENTITY_ITEMFRAME_BREAK = null;

    public static final SoundType ENTITY_ITEMFRAME_PLACE = null;

    public static final SoundType ENTITY_ITEMFRAME_REMOVE_ITEM = null;

    public static final SoundType ENTITY_ITEMFRAME_ROTATE_ITEM = null;

    public static final SoundType ENTITY_ITEM_BREAK = null;

    public static final SoundType ENTITY_ITEM_PICKUP = null;

    public static final SoundType ENTITY_LEASHKNOT_BREAK = null;

    public static final SoundType ENTITY_LEASHKNOT_PLACE = null;

    public static final SoundType ENTITY_LIGHTNING_IMPACT = null;

    public static final SoundType ENTITY_LIGHTNING_THUNDER = null;

    public static final SoundType ENTITY_LINGERINGPOTION_THROW = null;

    public static final SoundType ENTITY_MAGMACUBE_DEATH = null;

    public static final SoundType ENTITY_MAGMACUBE_HURT = null;

    public static final SoundType ENTITY_MAGMACUBE_JUMP = null;

    public static final SoundType ENTITY_MAGMACUBE_SQUISH = null;

    public static final SoundType ENTITY_MINECART_INSIDE = null;

    public static final SoundType ENTITY_MINECART_RIDING = null;

    public static final SoundType ENTITY_MOOSHROOM_SHEAR = null;

    public static final SoundType ENTITY_MULE_AMBIENT = null;

    public static final SoundType ENTITY_MULE_DEATH = null;

    public static final SoundType ENTITY_MULE_HURT = null;

    public static final SoundType ENTITY_PAINTING_BREAK = null;

    public static final SoundType ENTITY_PAINTING_PLACE = null;

    public static final SoundType ENTITY_PIG_AMBIENT = null;

    public static final SoundType ENTITY_PIG_DEATH = null;

    public static final SoundType ENTITY_PIG_HURT = null;

    public static final SoundType ENTITY_PIG_SADDLE = null;

    public static final SoundType ENTITY_PIG_STEP = null;

    public static final SoundType ENTITY_PLAYER_ATTACK_CRIT = null;

    public static final SoundType ENTITY_PLAYER_ATTACK_KNOCKBACK = null;

    public static final SoundType ENTITY_PLAYER_ATTACK_NODAMAGE = null;

    public static final SoundType ENTITY_PLAYER_ATTACK_STRONG = null;

    public static final SoundType ENTITY_PLAYER_ATTACK_SWEEP = null;

    public static final SoundType ENTITY_PLAYER_ATTACK_WEAK = null;

    public static final SoundType ENTITY_PLAYER_BIG_FALL = null;

    public static final SoundType ENTITY_PLAYER_BREATH = null;

    public static final SoundType ENTITY_PLAYER_BURP = null;

    public static final SoundType ENTITY_PLAYER_DEATH = null;

    public static final SoundType ENTITY_PLAYER_HURT = null;

    public static final SoundType ENTITY_PLAYER_LEVELUP = null;

    public static final SoundType ENTITY_PLAYER_SMALL_FALL = null;

    public static final SoundType ENTITY_PLAYER_SPLASH = null;

    public static final SoundType ENTITY_PLAYER_SWIM = null;

    public static final SoundType ENTITY_RABBIT_AMBIENT = null;

    public static final SoundType ENTITY_RABBIT_ATTACK = null;

    public static final SoundType ENTITY_RABBIT_DEATH = null;

    public static final SoundType ENTITY_RABBIT_HURT = null;

    public static final SoundType ENTITY_RABBIT_JUMP = null;

    public static final SoundType ENTITY_SHEEP_AMBIENT = null;

    public static final SoundType ENTITY_SHEEP_DEATH = null;

    public static final SoundType ENTITY_SHEEP_HURT = null;

    public static final SoundType ENTITY_SHEEP_SHEAR = null;

    public static final SoundType ENTITY_SHEEP_STEP = null;

    public static final SoundType ENTITY_SHULKER_AMBIENT = null;

    public static final SoundType ENTITY_SHULKER_BULLET_HIT = null;

    public static final SoundType ENTITY_SHULKER_BULLET_HURT = null;

    public static final SoundType ENTITY_SHULKER_CLOSE = null;

    public static final SoundType ENTITY_SHULKER_DEATH = null;

    public static final SoundType ENTITY_SHULKER_HURT = null;

    public static final SoundType ENTITY_SHULKER_HURT_CLOSED = null;

    public static final SoundType ENTITY_SHULKER_OPEN = null;

    public static final SoundType ENTITY_SHULKER_SHOOT = null;

    public static final SoundType ENTITY_SHULKER_TELEPORT = null;

    public static final SoundType ENTITY_SILVERFISH_AMBIENT = null;

    public static final SoundType ENTITY_SILVERFISH_DEATH = null;

    public static final SoundType ENTITY_SILVERFISH_HURT = null;

    public static final SoundType ENTITY_SILVERFISH_STEP = null;

    public static final SoundType ENTITY_SKELETON_AMBIENT = null;

    public static final SoundType ENTITY_SKELETON_DEATH = null;

    public static final SoundType ENTITY_SKELETON_HORSE_AMBIENT = null;

    public static final SoundType ENTITY_SKELETON_HORSE_DEATH = null;

    public static final SoundType ENTITY_SKELETON_HORSE_HURT = null;

    public static final SoundType ENTITY_SKELETON_HURT = null;

    public static final SoundType ENTITY_SKELETON_SHOOT = null;

    public static final SoundType ENTITY_SKELETON_STEP = null;

    public static final SoundType ENTITY_SLIME_ATTACK = null;

    public static final SoundType ENTITY_SLIME_DEATH = null;

    public static final SoundType ENTITY_SLIME_HURT = null;

    public static final SoundType ENTITY_SLIME_JUMP = null;

    public static final SoundType ENTITY_SLIME_SQUISH = null;

    public static final SoundType ENTITY_SMALL_MAGMACUBE_DEATH = null;

    public static final SoundType ENTITY_SMALL_MAGMACUBE_HURT = null;

    public static final SoundType ENTITY_SMALL_MAGMACUBE_SQUISH = null;

    public static final SoundType ENTITY_SMALL_SLIME_DEATH = null;

    public static final SoundType ENTITY_SMALL_SLIME_HURT = null;

    public static final SoundType ENTITY_SMALL_SLIME_JUMP = null;

    public static final SoundType ENTITY_SMALL_SLIME_SQUISH = null;

    public static final SoundType ENTITY_SNOWBALL_THROW = null;

    public static final SoundType ENTITY_SNOWMAN_AMBIENT = null;

    public static final SoundType ENTITY_SNOWMAN_DEATH = null;

    public static final SoundType ENTITY_SNOWMAN_HURT = null;

    public static final SoundType ENTITY_SNOWMAN_SHOOT = null;

    public static final SoundType ENTITY_SPIDER_AMBIENT = null;

    public static final SoundType ENTITY_SPIDER_DEATH = null;

    public static final SoundType ENTITY_SPIDER_HURT = null;

    public static final SoundType ENTITY_SPIDER_STEP = null;

    public static final SoundType ENTITY_SPLASH_POTION_BREAK = null;

    public static final SoundType ENTITY_SPLASH_POTION_THROW = null;

    public static final SoundType ENTITY_SQUID_AMBIENT = null;

    public static final SoundType ENTITY_SQUID_DEATH = null;

    public static final SoundType ENTITY_SQUID_HURT = null;

    public static final SoundType ENTITY_TNT_PRIMED = null;

    public static final SoundType ENTITY_VILLAGER_AMBIENT = null;

    public static final SoundType ENTITY_VILLAGER_DEATH = null;

    public static final SoundType ENTITY_VILLAGER_HURT = null;

    public static final SoundType ENTITY_VILLAGER_NO = null;

    public static final SoundType ENTITY_VILLAGER_TRADING = null;

    public static final SoundType ENTITY_VILLAGER_YES = null;

    public static final SoundType ENTITY_WITCH_AMBIENT = null;

    public static final SoundType ENTITY_WITCH_DEATH = null;

    public static final SoundType ENTITY_WITCH_DRINK = null;

    public static final SoundType ENTITY_WITCH_HURT = null;

    public static final SoundType ENTITY_WITCH_THROW = null;

    public static final SoundType ENTITY_WITHER_AMBIENT = null;

    public static final SoundType ENTITY_WITHER_BREAK_BLOCK = null;

    public static final SoundType ENTITY_WITHER_DEATH = null;

    public static final SoundType ENTITY_WITHER_HURT = null;

    public static final SoundType ENTITY_WITHER_SHOOT = null;

    public static final SoundType ENTITY_WITHER_SPAWN = null;

    public static final SoundType ENTITY_WOLF_AMBIENT = null;

    public static final SoundType ENTITY_WOLF_DEATH = null;

    public static final SoundType ENTITY_WOLF_GROWL = null;

    public static final SoundType ENTITY_WOLF_HOWL = null;

    public static final SoundType ENTITY_WOLF_HURT = null;

    public static final SoundType ENTITY_WOLF_PANT = null;

    public static final SoundType ENTITY_WOLF_SHAKE = null;

    public static final SoundType ENTITY_WOLF_STEP = null;

    public static final SoundType ENTITY_WOLF_WHINE = null;

    public static final SoundType ENTITY_ZOMBIE_AMBIENT = null;

    public static final SoundType ENTITY_ZOMBIE_ATTACK_DOOR_WOOD = null;

    public static final SoundType ENTITY_ZOMBIE_ATTACK_IRON_DOOR = null;

    public static final SoundType ENTITY_ZOMBIE_BREAK_DOOR_WOOD = null;

    public static final SoundType ENTITY_ZOMBIE_DEATH = null;

    public static final SoundType ENTITY_ZOMBIE_HORSE_AMBIENT = null;

    public static final SoundType ENTITY_ZOMBIE_HORSE_DEATH = null;

    public static final SoundType ENTITY_ZOMBIE_HORSE_HURT = null;

    public static final SoundType ENTITY_ZOMBIE_HURT = null;

    public static final SoundType ENTITY_ZOMBIE_INFECT = null;

    public static final SoundType ENTITY_ZOMBIE_PIG_AMBIENT = null;

    public static final SoundType ENTITY_ZOMBIE_PIG_ANGRY = null;

    public static final SoundType ENTITY_ZOMBIE_PIG_DEATH = null;

    public static final SoundType ENTITY_ZOMBIE_PIG_HURT = null;

    public static final SoundType ENTITY_ZOMBIE_STEP = null;

    public static final SoundType ENTITY_ZOMBIE_VILLAGER_AMBIENT = null;

    public static final SoundType ENTITY_ZOMBIE_VILLAGER_CONVERTED = null;

    public static final SoundType ENTITY_ZOMBIE_VILLAGER_CURE = null;

    public static final SoundType ENTITY_ZOMBIE_VILLAGER_DEATH = null;

    public static final SoundType ENTITY_ZOMBIE_VILLAGER_HURT = null;

    public static final SoundType ENTITY_ZOMBIE_VILLAGER_STEP = null;

    public static final SoundType ITEM_ARMOR_EQUIP_CHAIN = null;

    public static final SoundType ITEM_ARMOR_EQUIP_DIAMOND = null;

    public static final SoundType ITEM_ARMOR_EQUIP_GENERIC = null;

    public static final SoundType ITEM_ARMOR_EQUIP_GOLD = null;

    public static final SoundType ITEM_ARMOR_EQUIP_IRON = null;

    public static final SoundType ITEM_ARMOR_EQUIP_LEATHER = null;

    public static final SoundType ITEM_BOTTLE_FILL = null;

    public static final SoundType ITEM_BOTTLE_FILL_DRAGONBREATH = null;

    public static final SoundType ITEM_BUCKET_EMPTY = null;

    public static final SoundType ITEM_BUCKET_EMPTY_LAVA = null;

    public static final SoundType ITEM_BUCKET_FILL = null;

    public static final SoundType ITEM_BUCKET_FILL_LAVA = null;

    public static final SoundType ITEM_CHORUS_FRUIT_TELEPORT = null;

    public static final SoundType ITEM_FIRECHARGE_USE = null;

    public static final SoundType ITEM_FLINTANDSTEEL_USE = null;

    public static final SoundType ITEM_HOE_TILL = null;

    public static final SoundType ITEM_SHIELD_BLOCK = null;

    public static final SoundType ITEM_SHIELD_BREAK = null;

    public static final SoundType ITEM_SHOVEL_FLATTEN = null;

    public static final SoundType MUSIC_CREATIVE = null;

    public static final SoundType MUSIC_CREDITS = null;

    public static final SoundType MUSIC_DRAGON = null;

    public static final SoundType MUSIC_END = null;

    public static final SoundType MUSIC_GAME = null;

    public static final SoundType MUSIC_MENU = null;

    public static final SoundType MUSIC_NETHER = null;

    public static final SoundType RECORD_11 = null;

    public static final SoundType RECORD_13 = null;

    public static final SoundType RECORD_BLOCKS = null;

    public static final SoundType RECORD_CAT = null;

    public static final SoundType RECORD_CHIRP = null;

    public static final SoundType RECORD_FAR = null;

    public static final SoundType RECORD_MALL = null;

    public static final SoundType RECORD_MELLOHI = null;

    public static final SoundType RECORD_STAL = null;

    public static final SoundType RECORD_STRAD = null;

    public static final SoundType RECORD_WAIT = null;

    public static final SoundType RECORD_WARD = null;

    public static final SoundType UI_BUTTON_CLICK = null;

    public static final SoundType WEATHER_RAIN = null;

    public static final SoundType WEATHER_RAIN_ABOVE = null;

    // SORTFIELDS:OFF

    private SoundTypes() {
    }

}
