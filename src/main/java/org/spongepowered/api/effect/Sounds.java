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
package org.spongepowered.api.effect;

import com.google.common.base.Optional;

import java.util.List;

public final class Sounds {
    private Sounds() {
    }

    public static final Sound AMBIENCE_CAVE = null;
    public static final Sound AMBIENCE_RAIN = null;
    public static final Sound AMBIENCE_THUNDER = null;
    public static final Sound ANVIL_BREAK = null;
    public static final Sound ANVIL_LAND = null;
    public static final Sound ANVIL_USE = null;
    public static final Sound ARROW_HIT = null;
    public static final Sound BURP = null;
    public static final Sound CHEST_CLOSE = null;
    public static final Sound CHEST_OPEN = null;
    public static final Sound CLICK = null;
    public static final Sound DOOR_CLOSE = null;
    public static final Sound DOOR_OPEN = null;
    public static final Sound DRINK = null;
    public static final Sound EAT = null;
    public static final Sound EXPLODE = null;
    public static final Sound FALL_BIG = null;
    public static final Sound FALL_SMALL = null;
    public static final Sound FIRE = null;
    public static final Sound FIRE_IGNITE = null;
    public static final Sound FIZZ = null;
    public static final Sound FUSE = null;
    public static final Sound GLASS = null;
    public static final Sound HURT_FLESH = null;
    public static final Sound ITEM_BREAK = null;
    public static final Sound ITEM_PICKUP = null;
    public static final Sound LAVA = null;
    public static final Sound LAVA_POP = null;
    public static final Sound LEVEL_UP = null;
    public static final Sound MINECART_BASE = null;
    public static final Sound MINECART_INSIDE = null;
    public static final Sound NOTE_BASS = null;
    public static final Sound NOTE_PIANO = null;
    public static final Sound NOTE_BASS_DRUM = null;
    public static final Sound NOTE_STICKS = null;
    public static final Sound NOTE_BASS_GUITAR = null;
    public static final Sound NOTE_SNARE_DRUM = null;
    public static final Sound NOTE_PLING = null;
    public static final Sound ORB_PICKUP = null;
    public static final Sound PISTON_EXTEND = null;
    public static final Sound PISTON_RETRACT = null;
    public static final Sound PORTAL = null;
    public static final Sound PORTAL_TRAVEL = null;
    public static final Sound PORTAL_TRIGGER = null;
    public static final Sound SHOOT_ARROW = null;
    public static final Sound SPLASH = null;
    public static final Sound SPLASH2 = null;
    public static final Sound STEP_GRASS = null;
    public static final Sound STEP_GRAVEL = null;
    public static final Sound STEP_LADDER = null;
    public static final Sound STEP_SAND = null;
    public static final Sound STEP_SNOW = null;
    public static final Sound STEP_STONE = null;
    public static final Sound STEP_WOOD = null;
    public static final Sound STEP_WOOL = null;
    public static final Sound SWIM = null;
    public static final Sound WATER = null;
    public static final Sound WOOD_CLICK = null;
    public static final Sound BAT_DEATH = null;
    public static final Sound BAT_HURT = null;
    public static final Sound BAT_IDLE = null;
    public static final Sound BAT_LOOP = null;
    public static final Sound BAT_TAKEOFF = null;
    public static final Sound BLAZE_BREATH = null;
    public static final Sound BLAZE_DEATH = null;
    public static final Sound BLAZE_HIT = null;
    public static final Sound CAT_HISS = null;
    public static final Sound CAT_HIT = null;
    public static final Sound CAT_MEOW = null;
    public static final Sound CAT_PURR = null;
    public static final Sound CAT_PURREOW = null;
    public static final Sound CHICKEN_IDLE = null;
    public static final Sound CHICKEN_HURT = null;
    public static final Sound CHICKEN_EGG_POP = null;
    public static final Sound CHICKEN_WALK = null;
    public static final Sound COW_IDLE = null;
    public static final Sound COW_HURT = null;
    public static final Sound COW_WALK = null;
    public static final Sound CREEPER_HISS = null;
    public static final Sound CREEPER_DEATH = null;
    public static final Sound ENDERDRAGON_DEATH = null;
    public static final Sound ENDERDRAGON_GROWL = null;
    public static final Sound ENDERDRAGON_HIT = null;
    public static final Sound ENDERDRAGON_WINGS = null;
    public static final Sound ENDERMAN_DEATH = null;
    public static final Sound ENDERMAN_HIT = null;
    public static final Sound ENDERMAN_IDLE = null;
    public static final Sound ENDERMAN_TELEPORT = null;
    public static final Sound ENDERMAN_SCREAM = null;
    public static final Sound ENDERMAN_STARE = null;
    public static final Sound GHAST_SCREAM = null;
    public static final Sound GHAST_SCREAM2 = null;
    public static final Sound GHAST_CHARGE = null;
    public static final Sound GHAST_DEATH = null;
    public static final Sound GHAST_FIREBALL = null;
    public static final Sound GHAST_MOAN = null;
    public static final Sound GUARDIAN_IDLE = null;
    public static final Sound GUARDIAN_ELDER_IDLE = null;
    public static final Sound GUARDIAN_LAND_IDLE = null;
    public static final Sound GUARDIAN_HIT = null;
    public static final Sound GUARDIAN_ELDER_HIT = null;
    public static final Sound GUARDIAN_LAND_HIT = null;
    public static final Sound GUARDIAN_DEATH = null;
    public static final Sound GUARDIAN_ELDER_DEATH = null;
    public static final Sound GUARDIAN_LAND_DEATH = null;
    public static final Sound IRONGOLEM_DEATH = null;
    public static final Sound IRONGOLEM_HIT = null;
    public static final Sound IRONGOLEM_THROW = null;
    public static final Sound IRONGOLEM_WALK = null;
    public static final Sound MAGMACUBE_WALK = null;
    public static final Sound MAGMACUBE_WALK2 = null;
    public static final Sound MAGMACUBE_JUMP = null;
    public static final Sound PIG_IDLE = null;
    public static final Sound PIG_DEATH = null;
    public static final Sound PIG_WALK = null;
    public static final Sound RABBIT_IDLE = null;
    public static final Sound RABBIT_HURT = null;
    public static final Sound RABBIT_DEATH = null;
    public static final Sound SHEEP_IDLE = null;
    public static final Sound SHEEP_SHEAR = null;
    public static final Sound SHEEP_WALK = null;
    public static final Sound SILVERFISH_HIT = null;
    public static final Sound SILVERFISH_KILL = null;
    public static final Sound SILVERFISH_IDLE = null;
    public static final Sound SILVERFISH_WALK = null;
    public static final Sound SKELETON_IDLE = null;
    public static final Sound SKELETON_DEATH = null;
    public static final Sound SKELETON_HURT = null;
    public static final Sound SKELETON_WALK = null;
    public static final Sound SLIME_ATTACK = null;
    public static final Sound SLIME_WALK = null;
    public static final Sound SLIME_WALK2 = null;
    public static final Sound SPIDER_IDLE = null;
    public static final Sound SPIDER_DEATH = null;
    public static final Sound SPIDER_WALK = null;
    public static final Sound WITHER_DEATH = null;
    public static final Sound WITHER_HURT = null;
    public static final Sound WITHER_IDLE = null;
    public static final Sound WITHER_SHOOT = null;
    public static final Sound WITHER_SPAWN = null;
    public static final Sound WOLF_BARK = null;
    public static final Sound WOLF_DEATH = null;
    public static final Sound WOLF_GROWL = null;
    public static final Sound WOLF_HOWL = null;
    public static final Sound WOLF_HURT = null;
    public static final Sound WOLF_PANT = null;
    public static final Sound WOLF_SHAKE = null;
    public static final Sound WOLF_WALK = null;
    public static final Sound WOLF_WHINE = null;
    public static final Sound ZOMBIE_METAL = null;
    public static final Sound ZOMBIE_WOOD = null;
    public static final Sound ZOMBIE_WOODBREAK = null;
    public static final Sound ZOMBIE_IDLE = null;
    public static final Sound ZOMBIE_DEATH = null;
    public static final Sound ZOMBIE_HURT = null;
    public static final Sound ZOMBIE_INFECT = null;
    public static final Sound ZOMBIE_UNFECT = null;
    public static final Sound ZOMBIE_REMEDY = null;
    public static final Sound ZOMBIE_WALK = null;
    public static final Sound ZOMBIE_PIG_IDLE = null;
    public static final Sound ZOMBIE_PIG_ANGRY = null;
    public static final Sound ZOMBIE_PIG_DEATH = null;
    public static final Sound ZOMBIE_PIG_HURT = null;
    public static final Sound DIG_WOOL = null;
    public static final Sound DIG_GRASS = null;
    public static final Sound DIG_GRAVEL = null;
    public static final Sound DIG_SAND = null;
    public static final Sound DIG_SNOW = null;
    public static final Sound DIG_STONE = null;
    public static final Sound DIG_WOOD = null;
    public static final Sound FIREWORK_BLAST = null;
    public static final Sound FIREWORK_BLAST2 = null;
    public static final Sound FIREWORK_LARGE_BLAST = null;
    public static final Sound FIREWORK_LARGE_BLAST2 = null;
    public static final Sound FIREWORK_TWINKLE = null;
    public static final Sound FIREWORK_TWINKLE2 = null;
    public static final Sound FIREWORK_LAUNCH = null;
    public static final Sound SUCCESSFUL_HIT = null;
    public static final Sound HORSE_ANGRY = null;
    public static final Sound HORSE_ARMOR = null;
    public static final Sound HORSE_BREATHE = null;
    public static final Sound HORSE_DEATH = null;
    public static final Sound HORSE_GALLOP = null;
    public static final Sound HORSE_HIT = null;
    public static final Sound HORSE_IDLE = null;
    public static final Sound HORSE_JUMP = null;
    public static final Sound HORSE_LAND = null;
    public static final Sound HORSE_SADDLE = null;
    public static final Sound HORSE_SOFT = null;
    public static final Sound HORSE_WOOD = null;
    public static final Sound DONKEY_ANGRY = null;
    public static final Sound DONKEY_DEATH = null;
    public static final Sound DONKEY_HIT = null;
    public static final Sound DONKEY_IDLE = null;
    public static final Sound HORSE_SKELETON_DEATH = null;
    public static final Sound HORSE_SKELETON_HIT = null;
    public static final Sound HORSE_SKELETON_IDLE = null;
    public static final Sound HORSE_ZOMBIE_DEATH = null;
    public static final Sound HORSE_ZOMBIE_HIT = null;
    public static final Sound HORSE_ZOMBIE_IDLE = null;
    public static final Sound VILLAGER_DEATH = null;
    public static final Sound VILLAGER_HAGGLE = null;
    public static final Sound VILLAGER_HIT = null;
    public static final Sound VILLAGER_IDLE = null;
    public static final Sound VILLAGER_NO = null;
    public static final Sound VILLAGER_YES = null;

    public static Optional<Sound> getByName(String soundName) {
        return null;
    }

    public static List<Sound> getValues() {
        return null;
    }
    
}
